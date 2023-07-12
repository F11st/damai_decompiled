package android.taobao.windvane.jsbridge;

import android.taobao.windvane.monitor.WVJSBrdigeMonitorInterface;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVPluginManager {
    public static final String KEY_METHOD = "method";
    public static final String KEY_NAME = "name";
    private static final String SEPARATOR = "::";
    private static final String TAG = "WVPluginManager";
    private static boolean skipMonitor;
    private static final Map<String, WVApiPlugin> objPlugins = new ConcurrentHashMap();
    private static final Map<String, WVPluginInfo> plugins = new ConcurrentHashMap();
    private static final Map<IWVWebView, Map<String, WVPluginInfo>> localPlugins = new ConcurrentHashMap();
    private static final Map<String, String> aliasPlugins = new ConcurrentHashMap();
    private static IJsBridgeService jsBridgeService = null;

    /* JADX WARN: Code restructure failed: missing block: B:31:0x006e, code lost:
        if (android.text.TextUtils.isEmpty(r3) != false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.taobao.windvane.jsbridge.WVApiPlugin createPlugin(java.lang.String r5, android.content.Context r6, android.taobao.windvane.webview.IWVWebView r7) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.taobao.windvane.jsbridge.WVPluginManager.createPlugin(java.lang.String, android.content.Context, android.taobao.windvane.webview.IWVWebView):android.taobao.windvane.jsbridge.WVApiPlugin");
    }

    public static Map<String, String> getOriginalPlugin(String str, String str2) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Map<String, String> map = aliasPlugins;
            String str3 = map.get(str + SEPARATOR + str2);
            if (TextUtils.isEmpty(str3) || (indexOf = str3.indexOf(SEPARATOR)) <= 0) {
                return null;
            }
            String substring = str3.substring(0, indexOf);
            String substring2 = str3.substring(indexOf + 2);
            HashMap hashMap = new HashMap();
            hashMap.put("name", substring);
            hashMap.put("method", substring2);
            return hashMap;
        }
        TaoLog.w(TAG, "getOriginalPlugin failed, alias is empty.");
        return null;
    }

    public static WVPluginInfo getPluginInfo(String str) {
        Map<String, WVPluginInfo> map = plugins;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public static void registerAlias(String str, String str2, String str3, String str4) {
        if (plugins.containsKey(str3) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return;
            }
            aliasPlugins.put(str + SEPARATOR + str2, str3 + SEPARATOR + str4);
            return;
        }
        TaoLog.w(TAG, "registerAlias quit, this is no original plugin or alias is invalid.");
    }

    public static void registerLocalPlugin(IWVWebView iWVWebView, String str, Class<? extends WVApiPlugin> cls) {
        if (iWVWebView != null) {
            Map<IWVWebView, Map<String, WVPluginInfo>> map = localPlugins;
            Map<String, WVPluginInfo> map2 = map.get(iWVWebView);
            if (map2 == null) {
                map2 = new ConcurrentHashMap<>();
                map.put(iWVWebView, map2);
            }
            registerPlugin(str, cls, true, map2);
            TaoLog.i(TAG, "注册到局部API，使用范围=[" + iWVWebView.getClass().getSimpleName() + "],API=[" + str + SEPARATOR + cls.getSimpleName() + jn1.ARRAY_END_STR);
            return;
        }
        registerPlugin(str, cls);
    }

    public static void registerPlugin(String str, Class<? extends WVApiPlugin> cls) {
        registerPlugin(str, cls, true);
    }

    public static void registerPluginwithParam(String str, Class<? extends WVApiPlugin> cls, Object... objArr) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return;
        }
        WVPluginInfo wVPluginInfo = new WVPluginInfo(cls.getName(), cls.getClassLoader());
        if (objArr != null) {
            wVPluginInfo.setParamObj(objArr);
        }
        plugins.put(str, wVPluginInfo);
        if (WVMonitorService.getJsBridgeMonitor() != null) {
            WVJSBrdigeMonitorInterface jsBridgeMonitor = WVMonitorService.getJsBridgeMonitor();
            jsBridgeMonitor.onJsBridgeReturn("HY_REGISTERPLUGIN", "", "HY_REGISTERPLUGIN", str + SEPARATOR + cls.getName(), "");
        }
    }

    public static void registerWVJsBridgeService(IJsBridgeService iJsBridgeService) {
        jsBridgeService = iJsBridgeService;
    }

    public static void skipMnoitor(boolean z) {
        skipMonitor = z;
    }

    public static void unregisterAlias(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Map<String, String> map = aliasPlugins;
            map.remove(str + SEPARATOR + str2);
            return;
        }
        TaoLog.w(TAG, "unregisterAlias quit, alias is invalid.");
    }

    public static void unregisterLocalPlugins(IWVWebView iWVWebView) {
        Map<IWVWebView, Map<String, WVPluginInfo>> map = localPlugins;
        if (map.get(iWVWebView) == null) {
            return;
        }
        map.remove(iWVWebView);
    }

    public static void unregisterPlugin(String str) {
        Map<String, WVPluginInfo> map = plugins;
        if (map.containsKey(str)) {
            map.remove(str);
            return;
        }
        Map<String, WVApiPlugin> map2 = objPlugins;
        if (map2.containsKey(str)) {
            map2.remove(str);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class WVPluginInfo {
        private ClassLoader classLoader;
        private String className;
        private Object paramObj;

        WVPluginInfo(String str) {
            this.className = str;
        }

        public ClassLoader getClassLoader() {
            return this.classLoader;
        }

        public String getClassName() {
            return this.className;
        }

        public Object getParamObj() {
            return this.paramObj;
        }

        public void setClassLoader(ClassLoader classLoader) {
            this.classLoader = classLoader;
        }

        public void setClassName(String str) {
            this.className = str;
        }

        public void setParamObj(Object obj) {
            this.paramObj = obj;
        }

        WVPluginInfo(String str, ClassLoader classLoader) {
            this.className = str;
            this.classLoader = classLoader;
        }
    }

    public static String getPluginInfo() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, WVPluginInfo> entry : plugins.entrySet()) {
            sb.append(entry.getKey());
            sb.append("-");
            sb.append(entry.getValue().className);
            sb.append(",");
        }
        return sb.toString();
    }

    private static void registerPlugin(String str, Class<? extends WVApiPlugin> cls, boolean z, Map<String, WVPluginInfo> map) {
        if (TextUtils.isEmpty(str) || cls == null) {
            return;
        }
        map.put(str, new WVPluginInfo(cls.getName(), z ? cls.getClassLoader() : null));
        if (skipMonitor || WVMonitorService.getJsBridgeMonitor() == null) {
            return;
        }
        WVJSBrdigeMonitorInterface jsBridgeMonitor = WVMonitorService.getJsBridgeMonitor();
        jsBridgeMonitor.onJsBridgeReturn("HY_REGISTERPLUGIN", TAG, "HY_REGISTERPLUGIN", str + SEPARATOR + cls.getName(), "");
    }

    public static void registerPlugin(String str, Class<? extends WVApiPlugin> cls, boolean z) {
        registerPlugin(str, cls, z, plugins);
    }

    @Deprecated
    public static void registerPlugin(String str, String str2) {
        registerPlugin(str, str2, (ClassLoader) null);
    }

    public static void registerPlugin(String str, Object obj) {
        try {
            if (obj instanceof WVApiPlugin) {
                objPlugins.put(str, (WVApiPlugin) obj);
            }
        } catch (Throwable th) {
            if (TaoLog.getLogStatus()) {
                TaoLog.e(TAG, "registerPlugin by Object error : " + th.getMessage());
            }
        }
    }

    @Deprecated
    public static void registerPlugin(String str, String str2, ClassLoader classLoader) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        plugins.put(str, new WVPluginInfo(str2, classLoader));
        if (WVMonitorService.getJsBridgeMonitor() != null) {
            WVJSBrdigeMonitorInterface jsBridgeMonitor = WVMonitorService.getJsBridgeMonitor();
            jsBridgeMonitor.onJsBridgeReturn("HY_REGISTERPLUGIN", "", "HY_REGISTERPLUGIN", str + SEPARATOR + str2, "");
        }
    }

    public static void registerPlugin(String str, String str2, ClassLoader classLoader, Object... objArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        WVPluginInfo wVPluginInfo = new WVPluginInfo(str2, classLoader);
        wVPluginInfo.setParamObj(objArr);
        plugins.put(str, wVPluginInfo);
        if (WVMonitorService.getJsBridgeMonitor() != null) {
            WVJSBrdigeMonitorInterface jsBridgeMonitor = WVMonitorService.getJsBridgeMonitor();
            jsBridgeMonitor.onJsBridgeReturn("HY_REGISTERPLUGIN", "", "HY_REGISTERPLUGIN", str + SEPARATOR + str2, "");
        }
    }
}
