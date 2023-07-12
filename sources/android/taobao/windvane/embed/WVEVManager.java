package android.taobao.windvane.embed;

import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import com.uc.webview.export.extension.EmbedViewConfig;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVEVManager {
    private static final String TAG = "WVEVManager";
    private static final Map<String, WVEmbedViewInfo> embedViews = new ConcurrentHashMap();

    public static BaseEmbedView createEV(String str, String str2, IWVWebView iWVWebView, EmbedViewConfig embedViewConfig) {
        Class<?> loadClass;
        WVEmbedViewInfo ev = getEv(str2);
        if (ev == null) {
            TaoLog.e(TAG, "no register view with type:[" + str2 + jn1.ARRAY_END_STR);
            return null;
        }
        try {
            ClassLoader classLoader = ev.getClassLoader();
            if (classLoader == null) {
                loadClass = Class.forName(ev.getClassName());
            } else {
                loadClass = classLoader.loadClass(ev.getClassName());
            }
            if (loadClass != null && BaseEmbedView.class.isAssignableFrom(loadClass)) {
                BaseEmbedView baseEmbedView = (BaseEmbedView) loadClass.newInstance();
                if (baseEmbedView.init(str, str2, iWVWebView, embedViewConfig)) {
                    return baseEmbedView;
                }
                TaoLog.e(TAG, "type check error, required type:[" + baseEmbedView.getViewType() + "], real type:[" + str2 + jn1.ARRAY_END_STR);
            } else {
                TaoLog.e(TAG, "no class found");
            }
        } catch (Exception e) {
            TaoLog.e(TAG, "create embed view error, type:" + str2 + " | msg:" + e.getMessage());
        }
        return null;
    }

    public static ArrayList<String> getEmbedViewNames() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : embedViews.keySet()) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public static WVEmbedViewInfo getEv(String str) {
        return embedViews.get(str);
    }

    public static void registerEmbedView(String str, Class<? extends BaseEmbedView> cls, boolean z) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return;
        }
        WVEmbedViewInfo wVEmbedViewInfo = new WVEmbedViewInfo(cls.getName(), z ? cls.getClassLoader() : null);
        Map<String, WVEmbedViewInfo> map = embedViews;
        if (map.containsKey(str)) {
            TaoLog.e(TAG, "new view:[" + cls.getSimpleName() + "] will overlap the old view [" + map.get(str).getClassName() + jn1.ARRAY_END_STR);
        }
        map.put(str, wVEmbedViewInfo);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class WVEmbedViewInfo {
        private ClassLoader classLoader;
        private String className;

        WVEmbedViewInfo(String str) {
            this.className = str;
        }

        public ClassLoader getClassLoader() {
            return this.classLoader;
        }

        public String getClassName() {
            return this.className;
        }

        public void setClassLoader(ClassLoader classLoader) {
            this.classLoader = classLoader;
        }

        public void setClassName(String str) {
            this.className = str;
        }

        WVEmbedViewInfo(String str, ClassLoader classLoader) {
            this.className = str;
            this.classLoader = classLoader;
        }
    }
}
