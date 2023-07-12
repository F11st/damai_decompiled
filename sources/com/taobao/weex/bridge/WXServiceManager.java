package com.taobao.weex.bridge;

import android.text.TextUtils;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.common.WXJSService;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXServiceManager {
    private static volatile ConcurrentHashMap<String, WXJSService> sInstanceJSServiceMap = new ConcurrentHashMap<>();

    public static void execAllCacheJsService() {
        for (String str : sInstanceJSServiceMap.keySet()) {
            WXJSService wXJSService = sInstanceJSServiceMap.get(str);
            registerService(wXJSService.getName(), wXJSService.getScript(), wXJSService.getOptions());
        }
    }

    public static WXJSService getService(String str) {
        if (sInstanceJSServiceMap != null) {
            return sInstanceJSServiceMap.get(str);
        }
        return null;
    }

    public static boolean registerService(String str, String str2, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        String str3 = "serviceName: \"" + str + "\"";
        for (String str4 : map.keySet()) {
            Object obj = map.get(str4);
            str3 = obj instanceof String ? str3 + ", '" + str4 + "': '" + obj + "'" : str3 + ", '" + str4 + "': " + obj;
        }
        String format = String.format(";(function(service, options){ ;%s; })({ %s }, { %s });", str2, "register: global.registerService, unregister: global.unregisterService", str3);
        WXJSService wXJSService = new WXJSService();
        wXJSService.setName(str);
        wXJSService.setScript(str2);
        wXJSService.setOptions(map);
        sInstanceJSServiceMap.put(str, wXJSService);
        WXBridgeManager.getInstance().execJSService(format);
        return true;
    }

    public static void reload() {
        if (sInstanceJSServiceMap == null || sInstanceJSServiceMap.size() <= 0) {
            return;
        }
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.bridge.WXServiceManager.1
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : WXServiceManager.sInstanceJSServiceMap.entrySet()) {
                    WXJSService wXJSService = (WXJSService) entry.getValue();
                    WXServiceManager.registerService(wXJSService.getName(), wXJSService.getScript(), wXJSService.getOptions());
                }
            }
        });
    }

    public static boolean unRegisterService(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (WXEnvironment.isApkDebugable()) {
            sInstanceJSServiceMap.remove(str);
        }
        WXBridgeManager.getInstance().execJSService(String.format("global.unregisterService( \"%s\" );", str));
        return true;
    }
}
