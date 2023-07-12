package com.youku.gaiax.provider.module.js;

import android.app.Activity;
import android.util.DisplayMetrics;
import androidx.annotation.Keep;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alient.oneservice.appconfig.AppConfigProviderProxy;
import com.alient.oneservice.nav.Action;
import com.alient.oneservice.nav.NavProviderProxy;
import com.alient.oneservice.userinfo.LoginProviderProxy;
import com.alient.oneservice.userinfo.MemberProviderProxy;
import com.alient.oneservice.userinfo.YYLoginListener;
import com.alient.oneservice.ut.TrackInfo;
import com.alient.oneservice.ut.UserTrackProviderProxy;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.weex.bridge.WXBridgeManager;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import com.youku.gaiax.api.proxy.IProxyPrefs;
import com.youku.gaiax.impl.GaiaXProxy;
import com.youku.gaiax.impl.utils.GaiaXUiExecutor;
import com.youku.gaiax.impl.utils.GaiaXWorkerExecutor;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import com.youku.gaiax.js.api.IGaiaXCallback;
import com.youku.gaiax.js.api.IGaiaXPromise;
import com.youku.gaiax.js.api.annotation.GaiaXAsyncMethod;
import com.youku.gaiax.js.api.annotation.GaiaXPromiseMethod;
import com.youku.gaiax.js.api.annotation.GaiaXSyncMethod;
import com.youku.gaiax.js.support.JSDataConvert;
import com.youku.gaiax.js.utils.Log;
import com.youku.gaiax.provider.module.js.GaiaXBuildInProviderModule;
import com.youku.gaiax.provider.module.net.JSMtopRequest;
import com.youku.gaiax.provider.module.proxy.PictureGaiaXProviderProxy;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.middlewareservice.provider.info.DeviceInfoProviderProxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import mtopsdk.mtop.domain.MtopResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hi;
import tb.k50;
import tb.wt2;

/* compiled from: Taobao */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b)\u0010*J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\u000f\u001a\u00020\bH\u0007JB\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0007J\"\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0010H\u0007J\b\u0010\u001e\u001a\u00020\u001dH\u0007J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J \u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00102\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010%\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0016\u0010(\u001a\u00020\u00108V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/youku/gaiax/provider/module/js/GaiaXBuildInProviderModule;", "Lcom/youku/gaiax/js/api/GaiaXBaseModule;", "Landroid/util/DisplayMetrics;", "getDisplayMetrics", "Lcom/youku/gaiax/js/api/IGaiaXPromise;", "promise", "Ltb/wt2;", "getUserInfo", "Lcom/alibaba/fastjson/JSONObject;", "data", "Lcom/youku/gaiax/js/api/IGaiaXCallback;", WXBridgeManager.METHOD_CALLBACK, LoginConstants.SHOW_TOAST, "showDialog", "showAlert", "getSystemInfo", "", "eventId", "pageName", "arg1", "arg2", UTDataCollectorNodeColumn.ARG3, "arg", "remoteLog", "url", "https", "mtop", "openAction", "openUrl", "", "checkSession", "login", "key", "removeStorage", "", "value", "setStorage", "getStorage", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "Companion", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXBuildInProviderModule extends GaiaXBaseModule {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final String GAIAX_JS_STORAGE = "GAIAX_JS_STORAGE";

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/gaiax/provider/module/js/GaiaXBuildInProviderModule$Companion;", "", "", GaiaXBuildInProviderModule.GAIAX_JS_STORAGE, "Ljava/lang/String;", "<init>", "()V", "GaiaX-Provider-DM"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    private final DisplayMetrics getDisplayMetrics() {
        return AppInfoProviderProxy.getAppContext().getResources().getDisplayMetrics();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0056 -> B:18:0x0071). Please submit an issue!!! */
    /* renamed from: mtop$lambda-7  reason: not valid java name */
    public static final void m1263mtop$lambda7(String str, JSONObject jSONObject, IGaiaXPromise iGaiaXPromise) {
        b41.i(str, "$url");
        b41.i(jSONObject, "$data");
        b41.i(iGaiaXPromise, "$promise");
        MtopResponse syncRequest = new JSMtopRequest(str, jSONObject).call().syncRequest();
        if (syncRequest != null) {
            byte[] bytedata = syncRequest.getBytedata();
            if (bytedata != null) {
                JSONObject parseObject = JSON.parseObject(new String(bytedata, hi.UTF_8));
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    log.d(b41.r("mtop() called with: ", parseObject));
                }
                try {
                    if (syncRequest.isApiSuccess()) {
                        iGaiaXPromise.resolve().invoke(parseObject);
                    } else {
                        iGaiaXPromise.reject().invoke(parseObject);
                    }
                } catch (Exception unused) {
                    iGaiaXPromise.reject().invoke(parseObject);
                }
                return;
            }
            iGaiaXPromise.reject().invoke("bytedata is empty");
            return;
        }
        iGaiaXPromise.reject().invoke("");
    }

    @GaiaXSyncMethod
    public final boolean checkSession() {
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("checkSession() called with");
        }
        return LoginProviderProxy.checkSessionValid();
    }

    @Override // com.youku.gaiax.js.api.IGaiaXModule
    @NotNull
    public String getName() {
        return "BuildIn";
    }

    @GaiaXPromiseMethod
    public final void getStorage(@NotNull String str, @NotNull IGaiaXPromise iGaiaXPromise) {
        b41.i(str, "key");
        b41.i(iGaiaXPromise, "promise");
        GaiaXProxy.Companion companion = GaiaXProxy.Companion;
        IProxyPrefs prefs = companion.getInstance().getPrefs();
        boolean z = false;
        if (prefs != null && prefs.contains(GAIAX_JS_STORAGE, str)) {
            z = true;
        }
        if (z) {
            try {
                IProxyPrefs prefs2 = companion.getInstance().getPrefs();
                String string = prefs2 == null ? null : prefs2.getString(GAIAX_JS_STORAGE, str);
                JSONObject parseObject = JSON.parseObject(string);
                Object obj = parseObject.get("data");
                String string2 = parseObject.getString("type");
                JSDataConvert jSDataConvert = JSDataConvert.INSTANCE;
                b41.h(string2, "type");
                Object dataValueByType = jSDataConvert.getDataValueByType(string2, obj);
                Log log = Log.INSTANCE;
                if (log.isLog()) {
                    log.d("getStorage() called with: key = " + str + ", targetStr = " + ((Object) string) + ", value = " + dataValueByType);
                }
                iGaiaXPromise.resolve().invoke(dataValueByType);
                return;
            } catch (Exception e) {
                iGaiaXPromise.reject().invoke(e.getMessage());
                return;
            }
        }
        iGaiaXPromise.resolve().invoke(new Object());
    }

    @GaiaXSyncMethod
    @NotNull
    public final JSONObject getSystemInfo() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put((JSONObject) "brand", Build.getBRAND().toString());
        jSONObject.put((JSONObject) "model", Build.getMODEL().toString());
        if (AppConfigProviderProxy.topActivity() != null) {
            DisplayMetrics displayMetrics = getDisplayMetrics();
            jSONObject.put((JSONObject) "pixelRatio", (String) (displayMetrics == null ? null : Float.valueOf(displayMetrics.density)));
            jSONObject.put((JSONObject) "screenWidth", (String) Integer.valueOf(DeviceInfoProviderProxy.getWindowWidth()));
            jSONObject.put((JSONObject) "screenHeight", (String) Integer.valueOf(DeviceInfoProviderProxy.getWindowHeight()));
            jSONObject.put((JSONObject) "statusBarHeight", (String) Integer.valueOf(DeviceInfoProviderProxy.getStatusBarHeight()));
        }
        jSONObject.put((JSONObject) "jsEngine", "0");
        jSONObject.put((JSONObject) "platform", "android");
        jSONObject.put((JSONObject) "appVersion", (String) Integer.valueOf(AppInfoProviderProxy.getVersionCode()));
        jSONObject.put((JSONObject) "theme", "light");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(b41.r("getSystemInfo() called: info = ", jSONObject));
        }
        return jSONObject;
    }

    @GaiaXPromiseMethod
    public final void getUserInfo(@NotNull IGaiaXPromise iGaiaXPromise) {
        wt2 wt2Var;
        b41.i(iGaiaXPromise, "promise");
        JSONObject currentUserInfo = MemberProviderProxy.getCurrentUserInfo();
        if (currentUserInfo == null) {
            wt2Var = null;
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "nickname", (String) currentUserInfo.get("nickname"));
            jSONObject.put((JSONObject) "avatarUrl", (String) currentUserInfo.get("avatarUrl"));
            iGaiaXPromise.resolve().invoke(jSONObject);
            wt2Var = wt2.INSTANCE;
        }
        if (wt2Var == null) {
            IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.reject(), null, 1, null);
        }
    }

    @GaiaXPromiseMethod
    public final void https(@NotNull String str, @Nullable JSONObject jSONObject, @NotNull IGaiaXPromise iGaiaXPromise) {
        b41.i(str, "url");
        b41.i(iGaiaXPromise, "promise");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("https() called with: url = " + str + ", promise = " + iGaiaXPromise);
        }
        IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.reject(), null, 1, null);
    }

    @GaiaXPromiseMethod
    public final void login(@NotNull final IGaiaXPromise iGaiaXPromise) {
        b41.i(iGaiaXPromise, "promise");
        if (LoginProviderProxy.checkSessionValid()) {
            IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.resolve(), null, 1, null);
            return;
        }
        Activity activity = AppConfigProviderProxy.topActivity();
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(b41.r("login() called with: context = ", activity));
        }
        if (activity == null) {
            IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.reject(), null, 1, null);
        } else {
            LoginProviderProxy.notifyLogin(activity, new YYLoginListener() { // from class: com.youku.gaiax.provider.module.js.GaiaXBuildInProviderModule$login$1
                @Override // com.alient.oneservice.userinfo.YYLoginListener
                public void onLoginCancel() {
                    IGaiaXCallback.DefaultImpls.invoke$default(IGaiaXPromise.this.reject(), null, 1, null);
                }

                @Override // com.alient.oneservice.userinfo.YYLoginListener
                public void onLoginFail() {
                    IGaiaXCallback.DefaultImpls.invoke$default(IGaiaXPromise.this.reject(), null, 1, null);
                }

                @Override // com.alient.oneservice.userinfo.YYLoginListener
                public void onLoginSuccess() {
                    IGaiaXCallback.DefaultImpls.invoke$default(IGaiaXPromise.this.resolve(), null, 1, null);
                }

                @Override // com.alient.oneservice.userinfo.YYLoginListener
                public void onLogout() {
                }
            });
        }
    }

    @GaiaXPromiseMethod
    public final void mtop(@NotNull final String str, @NotNull final JSONObject jSONObject, @NotNull final IGaiaXPromise iGaiaXPromise) {
        b41.i(str, "url");
        b41.i(jSONObject, "data");
        b41.i(iGaiaXPromise, "promise");
        GaiaXWorkerExecutor.INSTANCE.action(new Runnable() { // from class: tb.at0
            @Override // java.lang.Runnable
            public final void run() {
                GaiaXBuildInProviderModule.m1263mtop$lambda7(str, jSONObject, iGaiaXPromise);
            }
        });
    }

    @GaiaXSyncMethod
    public final void openAction(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "data");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(b41.r("openAction() called with: data = ", jSONObject));
        }
        try {
            Action action = new Action();
            action.setActionType(1);
            action.setActionUrl(jSONObject.getString("jumpUrl"));
            action.setTrackInfo((TrackInfo) jSONObject.getObject("trackInfo", TrackInfo.class));
            TrackInfo trackInfo = action.getTrackInfo();
            if (trackInfo != null) {
                UserTrackProviderProxy.click(trackInfo, true);
            }
            NavProviderProxy.getProxy().toUri(AppInfoProviderProxy.getAppContext(), action);
        } catch (Exception unused) {
        }
    }

    @GaiaXSyncMethod
    public final void openUrl(@NotNull String str) {
        b41.i(str, "url");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(b41.r("openUrl() called with: url = ", str));
        }
        try {
            Action action = new Action();
            action.setActionType(1);
            action.setActionUrl(str);
            NavProviderProxy.getProxy().toUri(AppInfoProviderProxy.getAppContext(), action);
        } catch (Exception unused) {
        }
    }

    @GaiaXSyncMethod
    public final void remoteLog(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable JSONObject jSONObject) {
        b41.i(str, "eventId");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("remoteLog() called with: eventId = " + str + ", pageName = " + ((Object) str2) + ", arg1 = " + ((Object) str3) + ", arg2 = " + ((Object) str4) + ", arg = " + jSONObject);
        }
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setSpma(PictureGaiaXProviderProxy.Companion.utA());
        trackInfo.setSpmb(str2 == null ? "GaiaXJSPageName" : str2);
        trackInfo.setSpmc(str3 == null ? "" : str3);
        trackInfo.setSpmd(str4 == null ? "" : str4);
        trackInfo.setClickEventName(str5 != null ? str5 : "");
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject != null) {
            for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                String key = entry.getKey();
                b41.h(key, "it.key");
                hashMap.put(key, entry.getValue().toString());
            }
        }
        wt2 wt2Var = wt2.INSTANCE;
        trackInfo.setArgs(hashMap);
        int hashCode = str.hashCode();
        if (hashCode != 1537215) {
            if (hashCode != 1538176) {
                if (hashCode == 47007217 && str.equals("19999")) {
                    UserTrackProviderProxy.reportCustom(trackInfo.getArgs(), trackInfo.getSpmb(), trackInfo.getSpmc());
                    return;
                }
            } else if (str.equals("2101")) {
                UserTrackProviderProxy.click(trackInfo, false);
                return;
            }
        } else if (str.equals("2001")) {
            UserTrackProviderProxy.click(trackInfo, true);
            return;
        }
        UserTrackProviderProxy.reportOriginalCustomEvent(str, str2, str3, str4, str5, trackInfo.getArgs());
    }

    @GaiaXPromiseMethod
    public final void removeStorage(@NotNull String str, @NotNull IGaiaXPromise iGaiaXPromise) {
        b41.i(str, "key");
        b41.i(iGaiaXPromise, "promise");
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d(b41.r("removeStorage() called with: key = ", str));
        }
        GaiaXProxy.Companion companion = GaiaXProxy.Companion;
        IProxyPrefs prefs = companion.getInstance().getPrefs();
        boolean z = false;
        if (prefs != null && prefs.contains(GAIAX_JS_STORAGE, str)) {
            z = true;
        }
        if (z) {
            try {
                IProxyPrefs prefs2 = companion.getInstance().getPrefs();
                if (prefs2 != null) {
                    prefs2.removeKey(GAIAX_JS_STORAGE, str);
                }
                IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.resolve(), null, 1, null);
                return;
            } catch (Exception e) {
                iGaiaXPromise.reject().invoke(e.getMessage());
                return;
            }
        }
        IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.resolve(), null, 1, null);
    }

    @GaiaXPromiseMethod
    public final void setStorage(@NotNull String str, @NotNull Object obj, @NotNull IGaiaXPromise iGaiaXPromise) {
        b41.i(str, "key");
        b41.i(obj, "value");
        b41.i(iGaiaXPromise, "promise");
        try {
            String dataTypeByValue = JSDataConvert.INSTANCE.getDataTypeByValue(obj);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put((JSONObject) "type", dataTypeByValue);
            jSONObject.put((JSONObject) "data", (String) obj);
            Log log = Log.INSTANCE;
            if (log.isLog()) {
                log.d("setStorage() called with: key = " + str + ", type = " + dataTypeByValue + ", target = " + obj);
            }
            IProxyPrefs prefs = GaiaXProxy.Companion.getInstance().getPrefs();
            if (prefs != null) {
                String jSONString = jSONObject.toJSONString();
                b41.h(jSONString, "target.toJSONString()");
                prefs.putString(GAIAX_JS_STORAGE, str, jSONString);
            }
            IGaiaXCallback.DefaultImpls.invoke$default(iGaiaXPromise.resolve(), null, 1, null);
        } catch (Exception e) {
            iGaiaXPromise.reject().invoke(e.getMessage());
        }
    }

    @GaiaXAsyncMethod
    public final void showAlert(@NotNull JSONObject jSONObject, @NotNull IGaiaXCallback iGaiaXCallback) {
        b41.i(jSONObject, "data");
        b41.i(iGaiaXCallback, WXBridgeManager.METHOD_CALLBACK);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("showAlert() called with: data = " + jSONObject + ", callback = " + iGaiaXCallback);
        }
        try {
            String string = jSONObject.getString("title");
            String str = "";
            if (string == null) {
                string = "";
            }
            String string2 = jSONObject.getString("message");
            if (string2 != null) {
                str = string2;
            }
            GaiaXUiExecutor.INSTANCE.action(new GaiaXBuildInProviderModule$showAlert$1(string, str, iGaiaXCallback));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GaiaXAsyncMethod
    public final void showDialog(@NotNull JSONObject jSONObject, @NotNull IGaiaXCallback iGaiaXCallback) {
        b41.i(jSONObject, "data");
        b41.i(iGaiaXCallback, WXBridgeManager.METHOD_CALLBACK);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("showDialog() called with: data = " + jSONObject + ", callback = " + iGaiaXCallback);
        }
        try {
            String string = jSONObject.getString("title");
            String str = string == null ? "" : string;
            String string2 = jSONObject.getString("content");
            String str2 = string2 == null ? "" : string2;
            String string3 = jSONObject.getString("cancelText");
            if (string3 == null) {
                string3 = "取消";
            }
            String str3 = string3;
            String string4 = jSONObject.getString("confirmText");
            if (string4 == null) {
                string4 = PurchaseConstants.CONFIRM;
            }
            GaiaXUiExecutor.INSTANCE.action(new GaiaXBuildInProviderModule$showDialog$1(str, str2, str3, string4, iGaiaXCallback));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GaiaXAsyncMethod
    public final void showToast(@NotNull JSONObject jSONObject, @NotNull IGaiaXCallback iGaiaXCallback) {
        b41.i(jSONObject, "data");
        b41.i(iGaiaXCallback, WXBridgeManager.METHOD_CALLBACK);
        Log log = Log.INSTANCE;
        if (log.isLog()) {
            log.d("showToast() called with: data = " + jSONObject + ", callback = " + iGaiaXCallback);
        }
        try {
            final String string = jSONObject.getString("title");
            if (string == null) {
                string = "";
            }
            Integer integer = jSONObject.getInteger("duration");
            final int i = (integer == null ? 3 : integer.intValue()) >= 3 ? 1 : 0;
            GaiaXUiExecutor.INSTANCE.action(new Function0<wt2>() { // from class: com.youku.gaiax.provider.module.js.GaiaXBuildInProviderModule$showToast$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ wt2 invoke() {
                    invoke2();
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Activity activity = AppConfigProviderProxy.topActivity();
                    if (activity == null) {
                        return;
                    }
                    AppConfigProviderProxy.showToast(activity, string, i);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
