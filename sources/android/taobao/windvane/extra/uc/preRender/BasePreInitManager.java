package android.taobao.windvane.extra.uc.preRender;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.taobao.windvane.extra.core.WVCore;
import android.taobao.windvane.extra.uc.preRender.PreRenderWebView;
import android.taobao.windvane.util.TaoLog;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tscheduleprotocol.ScheduleProtocolCallback;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import com.youku.live.livesdk.wkit.component.Constants;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class BasePreInitManager<WebView extends PreRenderWebView> {
    public static final String ATTACH_EVENT = "WV.Event.Preload.Attach";
    public static final String INJECT_JS = "injectJs";
    private static final String KEY_EXTRA_FULL_URL = "fullUrl";
    public static final String ONLOAD_EVENT = "WV.Event.Preload.OnLoad";
    public static final String PRE_RENDER_URL_ADDITION = "&_wv_preload=true";
    public static final String PRE_RENDER_URL_ADDITION_JUDGE = "_wv_preload=true";
    public static final String PRE_RENDER_URL_ADDITION_KEY = "_wv_preload";
    public static final String PRE_RENDER_URL_ADDITION_VALUE = "true";
    public static final String TAG = "BasePreInitManager";
    public static final String TIMEOUT = "timeout";
    Class<WebView> WebViewClass;
    private WebView preWeb;
    private Map<String, WebView> preRenderWebViews = new HashMap();
    private Map<String, WebView> preInitWebViews = new HashMap();
    private Map<String, ScheduleProtocolCallback> callbacks = new HashMap();

    public BasePreInitManager() {
        try {
            this.WebViewClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.v(TAG, "WebViewClass " + this.WebViewClass);
    }

    private WebView clearCacheInQueue(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.preRenderWebViews.remove(str);
    }

    private String getRealKey(String str) {
        return (URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str)) ? removeHash(str) : str;
    }

    private boolean isSameQuery(Uri uri, Uri uri2) {
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames == null || queryParameterNames.isEmpty()) {
            return true;
        }
        Set<String> queryParameterNames2 = uri2.getQueryParameterNames();
        if (queryParameterNames2 != null && !queryParameterNames2.isEmpty()) {
            for (String str : queryParameterNames) {
                String queryParameter = uri.getQueryParameter(str);
                String queryParameter2 = uri2.getQueryParameter(str);
                if (!TextUtils.equals(queryParameter, queryParameter2)) {
                    try {
                        JSONObject parseObject = JSON.parseObject(queryParameter);
                        JSONObject parseObject2 = JSON.parseObject(queryParameter2);
                        if (parseObject2 != null && parseObject != null) {
                            for (String str2 : parseObject.keySet()) {
                                if (!TextUtils.equals(parseObject.getString(str2), parseObject2.getString(str2))) {
                                    TaoLog.i(TAG, "query value is not equal, require=[" + queryParameter + "],real=[" + queryParameter2 + jn1.ARRAY_END_STR);
                                    return false;
                                }
                            }
                            continue;
                        }
                    } catch (Throwable unused) {
                        TaoLog.i(TAG, "query value is not equal, require=[" + queryParameter + "],real=[" + queryParameter2 + jn1.ARRAY_END_STR);
                        return false;
                    }
                }
            }
            return true;
        }
        TaoLog.i(TAG, "real url miss query");
        return false;
    }

    private boolean isSameUrl(Uri uri, Uri uri2) {
        String host = uri.getHost();
        String host2 = uri2.getHost();
        if (!TextUtils.equals(host, host2)) {
            TaoLog.i(TAG, "host equal=[false],require=[" + host + "],real=[" + host2 + jn1.ARRAY_END_STR);
            return false;
        }
        String path = uri.getPath();
        String path2 = uri2.getPath();
        if (TextUtils.equals(path, path2)) {
            return true;
        }
        TaoLog.i(TAG, "path equal=[false],require=[" + path + "],real=[" + path2 + jn1.ARRAY_END_STR);
        return false;
    }

    private String removeHash(String str) {
        return str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean addPreInitWeb(String str, Context context, ScheduleProtocolCallback scheduleProtocolCallback) {
        if (WVCore.getInstance().isUCSupport()) {
            String realKey = getRealKey(str);
            if (this.preInitWebViews.containsKey(realKey)) {
                return false;
            }
            this.preInitWebViews.put(realKey, (PreRenderWebView) getNewObject((Class<WebView>) this.WebViewClass, new MutableContextWrapper(context)));
            if (scheduleProtocolCallback != null) {
                this.callbacks.put(realKey, scheduleProtocolCallback);
            }
            TaoLog.i(TAG, "add pre init webview success. key=[" + realKey + jn1.ARRAY_END_STR);
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void addPreRenderWeb(String str, Context context) {
        PreRenderWebView preRenderWebView = (PreRenderWebView) getNewObject((Class<WebView>) this.WebViewClass, new MutableContextWrapper(context));
        preRenderWebView.preRenderInit(str);
        preRenderWebView.isPreLoad = true;
        preRenderWebView.loadUrl(str.concat(PRE_RENDER_URL_ADDITION));
        this.preRenderWebViews.put(getRealKey(str), preRenderWebView);
        TaoLog.i(TAG, "add pre render webview success. key=[" + getRealKey(str) + "], url = [" + str.concat(PRE_RENDER_URL_ADDITION) + jn1.ARRAY_END_STR);
    }

    public void clear() {
        this.preWeb = null;
    }

    public boolean clearAll() {
        for (WebView webview : this.preRenderWebViews.values()) {
            if (webview != null) {
                webview.destroy();
            }
        }
        for (WebView webview2 : this.preInitWebViews.values()) {
            if (webview2 != null) {
                webview2.destroy();
            }
        }
        this.preRenderWebViews.clear();
        this.preInitWebViews.clear();
        this.callbacks.clear();
        return true;
    }

    public boolean clearByKey(String str) {
        String realKey = getRealKey(str);
        WebView remove = this.preRenderWebViews.remove(realKey);
        if (remove != null) {
            remove.destroy();
        }
        WebView remove2 = this.preInitWebViews.remove(realKey);
        if (remove2 != null) {
            remove2.destroy();
        }
        this.callbacks.remove(realKey);
        return true;
    }

    <T> T getNewObject(Class<T> cls, Context context) {
        try {
            return cls.getConstructor(Context.class).newInstance(context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public WebView getPreRender(String str, Context context) {
        return getPreRender(str, context, null);
    }

    public WebView getPreWeb() {
        return this.preWeb;
    }

    public void setPreWeb(WebView webview) {
        this.preWeb = webview;
    }

    public void triggerRender(String str, String str2, @Nullable Context context) {
        triggerRender(str, str2, context, null);
    }

    public WebView getPreRender(String str, Context context, @Nullable Map<String, String> map) {
        String str2;
        String str3;
        String str4;
        ScheduleProtocolCallback remove;
        ScheduleProtocolCallback.ScheduleProtocolCallbackType scheduleProtocolCallbackType;
        String str5;
        WebView webview = null;
        if (str == null || str.isEmpty()) {
            return null;
        }
        TaoLog.i(TAG, "getPreRender for url: " + str);
        String realKey = getRealKey(str);
        boolean z = false;
        WebView webview2 = this.preRenderWebViews.get(realKey);
        if (webview2 == null) {
            Uri parse = Uri.parse(realKey);
            Iterator<Map.Entry<String, WebView>> it = this.preRenderWebViews.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = "";
                    break;
                }
                str2 = it.next().getKey();
                Uri parse2 = Uri.parse(str2);
                if (isSameUrl(parse2, parse)) {
                    if (isSameQuery(parse2, parse)) {
                        webview2 = this.preRenderWebViews.get(str2);
                    }
                }
            }
        } else {
            str2 = realKey;
        }
        if (webview2 != null) {
            if (!webview2.isPreRenderSuccess()) {
                TaoLog.i(TAG, "PreRender is not Success");
                clearCacheInQueue(str2);
                webview2.destroy();
                str5 = "H5.preRenderDidNotReportSuccess";
            } else if (webview2.getExpireTime() < System.currentTimeMillis()) {
                TaoLog.i(TAG, "PreRender is expire");
                z = true;
                clearCacheInQueue(str2);
                webview2.destroy();
                str5 = "PreRender.webViewExpired";
            } else {
                String str6 = map != null ? map.get(KEY_EXTRA_FULL_URL) : null;
                if (TextUtils.isEmpty(str6)) {
                    str6 = str;
                }
                webview2.setRealUrl(str6);
                TaoLog.i(TAG, "hit pre render,key = [" + str2 + "],url=[" + str + "],realUrl=[" + str6 + jn1.ARRAY_END_STR);
                str3 = "PreRender.success";
            }
            str3 = str5;
            webview2 = null;
        } else {
            str3 = "PreRender.urlNotEqual";
        }
        if (webview2 == null) {
            webview2 = this.preInitWebViews.remove(realKey);
            if (webview2 == null) {
                Uri parse3 = Uri.parse(realKey);
                Iterator<Map.Entry<String, WebView>> it2 = this.preInitWebViews.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        str4 = str2;
                        break;
                    }
                    str4 = it2.next().getKey();
                    Uri parse4 = Uri.parse(str4);
                    if (isSameUrl(parse4, parse3)) {
                        if (isSameQuery(parse4, parse3) && (webview2 = this.preInitWebViews.remove(str4)) != null) {
                            webview2.preRenderInit(str);
                            webview2.loadUrl(str);
                        }
                    }
                }
            } else {
                str4 = str;
            }
            if (webview2 != null) {
                TaoLog.i(TAG, "hit pre webview,key = [" + str4 + "],url=[" + str + jn1.ARRAY_END_STR);
            }
        } else {
            str4 = str2;
        }
        if (webview2 != null) {
            webview2.setOuterContext(context);
        }
        if (webview2 == null) {
            remove = this.callbacks.get(str4);
        } else {
            remove = this.callbacks.remove(str4);
        }
        if (remove != null) {
            if (webview2 != null) {
                if (remove.validateTargetUrl(str, map)) {
                    clearCacheInQueue(str2);
                    scheduleProtocolCallbackType = ScheduleProtocolCallback.ScheduleProtocolCallbackType.TYPE_HIT;
                } else {
                    scheduleProtocolCallbackType = ScheduleProtocolCallback.ScheduleProtocolCallbackType.TYPE_OUT_OF_SERVICE;
                    HashMap hashMap = new HashMap(2);
                    hashMap.put("url", str);
                    hashMap.put("reason", str3);
                    remove.onPreload(scheduleProtocolCallbackType, hashMap);
                    return webview;
                }
            } else {
                scheduleProtocolCallbackType = z ? ScheduleProtocolCallback.ScheduleProtocolCallbackType.TYPE_EXPIRE : ScheduleProtocolCallback.ScheduleProtocolCallbackType.TYPE_MISS;
            }
            webview = webview2;
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("url", str);
            hashMap2.put("reason", str3);
            remove.onPreload(scheduleProtocolCallbackType, hashMap2);
            return webview;
        }
        clearCacheInQueue(str2);
        return webview2;
    }

    public boolean triggerRender(String str, String str2, @Nullable Context context, ScheduleProtocolCallback scheduleProtocolCallback) {
        return triggerRender(str, str2, context, scheduleProtocolCallback, null);
    }

    public boolean triggerRender(String str, String str2, @Nullable Context context, ScheduleProtocolCallback scheduleProtocolCallback, Map<String, String> map) {
        if (str2 == null || str2.isEmpty()) {
            return false;
        }
        TaoLog.i(TAG, "triggerRender() called with: key = [" + str + "], url = [" + str2 + "], ctx = [" + context + "], scheduleProtocolCallback = [" + scheduleProtocolCallback + "], args = [" + map + jn1.ARRAY_END_STR);
        if (WVCore.getInstance().isUCSupport()) {
            String realKey = getRealKey(str2);
            if (this.preRenderWebViews.containsKey(realKey)) {
                return false;
            }
            for (WebView webview : this.preRenderWebViews.values()) {
                if (webview != null) {
                    webview.destroy();
                }
            }
            this.preRenderWebViews.clear();
            WebView remove = this.preInitWebViews.remove(getRealKey(str));
            if (remove == null && context != null) {
                remove = (WebView) getNewObject((Class<WebView>) this.WebViewClass, new MutableContextWrapper(context));
                remove.preRenderInit(str2);
                TaoLog.i(TAG, "obtain pre init webview failed by key=[" + str + "], init it");
            } else {
                TaoLog.i(TAG, "obtain pre init webview success by key=[" + str + jn1.ARRAY_END_STR);
            }
            if (remove == null) {
                TaoLog.e(TAG, "triger render failed, for no inited webview");
                return false;
            }
            remove.isPreLoad = true;
            if (remove.getUCExtension() != null) {
                remove.getUCExtension().setIsPreRender(true);
            }
            if (map != null && map.containsKey(INJECT_JS)) {
                String str3 = map.get(INJECT_JS);
                if (!TextUtils.isEmpty(str3)) {
                    remove.injectJsEarly(str3);
                }
            }
            long j = AbsPerformance.LONG_NIL;
            if (map != null && map.containsKey("timeout")) {
                String str4 = map.get("timeout");
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        int parseInt = Integer.parseInt(str4);
                        j = System.currentTimeMillis() + parseInt;
                        TaoLog.i(TAG, "time=" + parseInt);
                    } catch (Exception unused) {
                    }
                }
            }
            remove.setExpireTime(j);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            View view = remove.getView();
            view.setTop(0);
            view.setBottom(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
            view.setLeft(0);
            view.setRight(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics));
            view.measure(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
            remove.injectJsEarly("javascript:window._wv_preload=true");
            remove.loadUrl(str2.concat(PRE_RENDER_URL_ADDITION));
            this.preRenderWebViews.put(realKey, remove);
            if (scheduleProtocolCallback != null) {
                this.callbacks.put(realKey, scheduleProtocolCallback);
            }
            TaoLog.i(TAG, "trigger render success. key=[" + realKey + "],url = [" + str2.concat(PRE_RENDER_URL_ADDITION) + jn1.ARRAY_END_STR);
            return true;
        }
        return false;
    }
}
