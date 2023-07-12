package com.taobao.weex.bridge;

import android.content.Intent;
import android.text.TextUtils;
import android.view.Menu;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONArray;
import com.taobao.orange.OConstant;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.IWXUserTrackAdapter;
import com.taobao.weex.b;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.TypeModuleFactory;
import com.taobao.weex.common.WXErrorCode;
import com.taobao.weex.common.WXException;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.config.ConfigModuleFactory;
import com.taobao.weex.ui.module.WXDomModule;
import com.taobao.weex.ui.module.WXTimerModule;
import com.taobao.weex.utils.WXExceptionUtils;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.cache.RegisterCache;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXModuleManager {
    private static volatile ConcurrentMap<String, ModuleFactoryImpl> sModuleFactoryMap = new ConcurrentHashMap();
    private static Map<String, WXModule> sGlobalModuleMap = new HashMap();
    private static Map<String, WXDomModule> sDomModuleMap = new HashMap();
    private static Map<String, Map<String, WXModule>> sInstanceModuleMap = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object callModuleMethod(String str, String str2, String str3, JSONArray jSONArray) {
        ModuleFactoryImpl moduleFactoryImpl = sModuleFactoryMap.get(str2);
        if (moduleFactoryImpl == null) {
            WXLogUtils.e("[WXModuleManager] module factoryImpl not found.");
            return null;
        }
        ModuleFactory moduleFactory = moduleFactoryImpl.mFactory;
        if (moduleFactory == null) {
            WXLogUtils.e("[WXModuleManager] module factory not found.");
            return null;
        }
        WXModule findModule = findModule(str, str2, moduleFactory);
        if (findModule == null) {
            return null;
        }
        WXSDKInstance y = WXSDKManager.v().y(str);
        findModule.mWXSDKInstance = y;
        Invoker methodInvoker = moduleFactory.getMethodInvoker(str3);
        if (methodInvoker == null) {
            StringBuilder sb = new StringBuilder("CallNativeModule Failed For ");
            sb.append(str2);
            sb.append(":");
            sb.append(str3);
            sb.append("'s invoker is null");
            try {
                if (moduleFactory instanceof TypeModuleFactory) {
                    TypeModuleFactory typeModuleFactory = (TypeModuleFactory) moduleFactory;
                    if (!typeModuleFactory.hasRebuild() && typeModuleFactory.hasMethodInClass(str3)) {
                        sb.append(" but has ");
                        sb.append(str3);
                        sb.append(" and rebuilding...");
                        typeModuleFactory.reBuildMethodMap();
                    } else {
                        sb.append(" do not has ");
                        sb.append(str3);
                    }
                    methodInvoker = moduleFactory.getMethodInvoker(str3);
                    sb.append(" And Class Name is ");
                    sb.append(typeModuleFactory.className());
                    if (methodInvoker == null) {
                        sb.append(" and rebuild Method Map Failed");
                    } else {
                        sb.append(" and rebuild Method Map Succeed, Continue Call Native Module");
                    }
                }
            } catch (Throwable th) {
                sb.append(" Throw Exception ");
                sb.append(th.getMessage());
            }
            WXLogUtils.e(sb.toString());
            WXExceptionUtils.commitCriticalExceptionRT(str, WXErrorCode.WX_RENDER_ERR_CALL_NATIVE_MODULE, "callModuleMethod", sb.toString(), null);
        }
        if (methodInvoker == null) {
            return null;
        }
        try {
            try {
                if (y != null) {
                    IWXUserTrackAdapter t = WXSDKManager.v().t();
                    if (t != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("errCode", OConstant.CODE_POINT_EXP_BIND_SERVICE);
                        hashMap.put("arg", str2 + "." + str3);
                        hashMap.put("errMsg", y.getBundleUrl());
                        t.commit(y.getContext(), null, IWXUserTrackAdapter.INVOKE_MODULE, null, hashMap);
                    }
                    Object dispatchCallModuleMethod = dispatchCallModuleMethod(y, findModule, jSONArray, methodInvoker);
                    if ((findModule instanceof WXDomModule) || (findModule instanceof WXTimerModule)) {
                        findModule.mWXSDKInstance = null;
                    }
                    return dispatchCallModuleMethod;
                }
                WXLogUtils.e("callModuleMethod >>> instance is null");
                if ((findModule instanceof WXDomModule) || (findModule instanceof WXTimerModule)) {
                    findModule.mWXSDKInstance = null;
                }
                return null;
            } catch (Exception e) {
                WXLogUtils.e("callModuleMethod >>> invoke module:" + str2 + ", method:" + str3 + " failed. ", e);
                if ((findModule instanceof WXDomModule) || (findModule instanceof WXTimerModule)) {
                    findModule.mWXSDKInstance = null;
                }
                return null;
            }
        } catch (Throwable th2) {
            if ((findModule instanceof WXDomModule) || (findModule instanceof WXTimerModule)) {
                findModule.mWXSDKInstance = null;
            }
            throw th2;
        }
    }

    public static void createDomModule(WXSDKInstance wXSDKInstance) {
        if (wXSDKInstance != null) {
            sDomModuleMap.put(wXSDKInstance.getInstanceId(), new WXDomModule(wXSDKInstance));
        }
    }

    public static void destoryDomModule(String str) {
        sDomModuleMap.remove(str);
    }

    public static void destroyInstanceModules(String str) {
        sDomModuleMap.remove(str);
        Map<String, WXModule> remove = sInstanceModuleMap.remove(str);
        if (remove == null || remove.size() < 1) {
            return;
        }
        for (Map.Entry<String, WXModule> entry : remove.entrySet()) {
            WXModule value = entry.getValue();
            if (value instanceof Destroyable) {
                ((Destroyable) value).destroy();
            }
        }
    }

    private static Object dispatchCallModuleMethod(@NonNull WXSDKInstance wXSDKInstance, @NonNull WXModule wXModule, @NonNull JSONArray jSONArray, @NonNull Invoker invoker) throws Exception {
        if (!wXSDKInstance.isPreRenderMode()) {
            return wXSDKInstance.getNativeInvokeHelper().invoke(wXModule, invoker, jSONArray);
        }
        if (invoker.isRunOnUIThread()) {
            return null;
        }
        return wXSDKInstance.getNativeInvokeHelper().invoke(wXModule, invoker, jSONArray);
    }

    private static WXModule findModule(String str, String str2, ModuleFactory moduleFactory) {
        WXModule buildInstance;
        WXModule wXModule = sGlobalModuleMap.get(str2);
        if (wXModule == null) {
            Map<String, WXModule> map = sInstanceModuleMap.get(str);
            if (map == null) {
                map = new ConcurrentHashMap<>();
                sInstanceModuleMap.put(str, map);
            }
            WXModule wXModule2 = map.get(str2);
            if (wXModule2 == null) {
                try {
                    if (moduleFactory instanceof ConfigModuleFactory) {
                        buildInstance = ((ConfigModuleFactory) moduleFactory).buildInstance(WXSDKManager.v().y(str));
                    } else {
                        buildInstance = moduleFactory.buildInstance();
                    }
                    buildInstance.setModuleName(str2);
                    map.put(str2, buildInstance);
                    return buildInstance;
                } catch (Exception e) {
                    WXLogUtils.e(str2 + " module build instace failed.", e);
                    return null;
                }
            }
            return wXModule2;
        }
        return wXModule;
    }

    public static WXDomModule getDomModule(String str) {
        return sDomModuleMap.get(str);
    }

    public static boolean hasModule(String str) {
        return sGlobalModuleMap.containsKey(str) || sModuleFactoryMap.containsKey(str);
    }

    public static boolean onActivityBack(String str) {
        Map<String, WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    return wXModule.onActivityBack();
                }
                WXLogUtils.w("onActivityCreate can not find the " + str2 + " module");
            }
            return false;
        }
        return false;
    }

    public static void onActivityCreate(String str) {
        Map<String, WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onActivityCreate();
                } else {
                    WXLogUtils.w("onActivityCreate can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void onActivityDestroy(String str) {
        Map<String, WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onActivityDestroy();
                } else {
                    WXLogUtils.w("onActivityDestroy can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void onActivityPause(String str) {
        Map<String, WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onActivityPause();
                } else {
                    WXLogUtils.w("onActivityPause can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void onActivityResult(String str, int i, int i2, Intent intent) {
        Map<String, WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onActivityResult(i, i2, intent);
                } else {
                    WXLogUtils.w("onActivityResult can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void onActivityResume(String str) {
        Map<String, WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onActivityResume();
                } else {
                    WXLogUtils.w("onActivityResume can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void onActivityStart(String str) {
        Map<String, WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onActivityStart();
                } else {
                    WXLogUtils.w("onActivityStart can not find the " + str2 + " module");
                }
            }
        }
    }

    public static void onActivityStop(String str) {
        Map<String, WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onActivityStop();
                } else {
                    WXLogUtils.w("onActivityStop can not find the " + str2 + " module");
                }
            }
        }
    }

    public static boolean onCreateOptionsMenu(String str, Menu menu) {
        Map<String, WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onCreateOptionsMenu(menu);
                } else {
                    WXLogUtils.w("onActivityResult can not find the " + str2 + " module");
                }
            }
            return false;
        }
        return false;
    }

    public static void onRequestPermissionsResult(String str, int i, String[] strArr, int[] iArr) {
        Map<String, WXModule> map = sInstanceModuleMap.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                WXModule wXModule = map.get(str2);
                if (wXModule != null) {
                    wXModule.onRequestPermissionsResult(i, strArr, iArr);
                } else {
                    WXLogUtils.w("onActivityResult can not find the " + str2 + " module");
                }
            }
        }
    }

    static boolean registerJSModule(String str, ModuleFactory moduleFactory) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, moduleFactory.getMethods());
        WXSDKManager.v().R(hashMap);
        return true;
    }

    public static boolean registerModule(Map<String, RegisterCache.ModuleCache> map) {
        if (map.isEmpty()) {
            return true;
        }
        final Iterator<Map.Entry<String, RegisterCache.ModuleCache>> it = map.entrySet().iterator();
        WXBridgeManager.getInstance().postWithName(new Runnable() { // from class: com.taobao.weex.bridge.WXModuleManager.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap hashMap = new HashMap();
                while (it.hasNext()) {
                    RegisterCache.ModuleCache moduleCache = (RegisterCache.ModuleCache) ((Map.Entry) it.next()).getValue();
                    String str = moduleCache.name;
                    if (!TextUtils.equals(str, WXDomModule.WXDOM)) {
                        if (WXModuleManager.sModuleFactoryMap != null && WXModuleManager.sModuleFactoryMap.containsKey(str)) {
                            WXLogUtils.w("WXComponentRegistry Duplicate the Module name: " + str);
                        }
                        ModuleFactory moduleFactory = moduleCache.factory;
                        try {
                            WXModuleManager.registerNativeModule(str, moduleFactory);
                        } catch (WXException e) {
                            WXLogUtils.e("registerNativeModule" + e);
                        }
                        if (moduleCache.global) {
                            try {
                                WXModule buildInstance = moduleFactory.buildInstance();
                                buildInstance.setModuleName(str);
                                WXModuleManager.sGlobalModuleMap.put(str, buildInstance);
                            } catch (Exception e2) {
                                WXLogUtils.e(str + " class must have a default constructor without params. ", e2);
                            }
                        }
                        try {
                            WXModuleManager.sModuleFactoryMap.put(str, new ModuleFactoryImpl(moduleFactory));
                        } catch (Throwable unused) {
                        }
                        hashMap.put(str, moduleFactory.getMethods());
                    } else {
                        WXLogUtils.e("Cannot registered module with name 'dom'.");
                    }
                }
                WXSDKManager.v().R(hashMap);
            }
        }, null, "registerModule From Cache");
        return true;
    }

    static boolean registerNativeModule(String str, ModuleFactory moduleFactory) throws WXException {
        if (moduleFactory == null) {
            return false;
        }
        try {
            if (sModuleFactoryMap.containsKey(str)) {
                return true;
            }
            sModuleFactoryMap.put(str, new ModuleFactoryImpl(moduleFactory));
            return true;
        } catch (ArrayStoreException e) {
            e.printStackTrace();
            WXLogUtils.e("[WXModuleManager] registerNativeModule Error moduleName:" + str + " Error:" + e.toString());
            return true;
        }
    }

    public static void registerWhenCreateInstance() {
        if (sModuleFactoryMap == null || sModuleFactoryMap.size() <= 0) {
            return;
        }
        for (Map.Entry<String, ModuleFactoryImpl> entry : sModuleFactoryMap.entrySet()) {
            try {
                if (!entry.getValue().hasRigster) {
                    registerJSModule(entry.getKey(), entry.getValue().mFactory);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void reload() {
        if (sModuleFactoryMap == null || sModuleFactoryMap.size() <= 0) {
            return;
        }
        for (Map.Entry<String, ModuleFactoryImpl> entry : sModuleFactoryMap.entrySet()) {
            try {
                registerJSModule(entry.getKey(), entry.getValue().mFactory);
            } catch (Throwable unused) {
            }
        }
    }

    public static void resetAllModuleState() {
        if (sModuleFactoryMap == null || sModuleFactoryMap.size() <= 0) {
            return;
        }
        for (Map.Entry<String, ModuleFactoryImpl> entry : sModuleFactoryMap.entrySet()) {
            entry.getValue().hasRigster = false;
        }
    }

    public static void resetModuleState(String str, boolean z) {
        if (sModuleFactoryMap == null || sModuleFactoryMap.size() <= 0) {
            return;
        }
        for (Map.Entry<String, ModuleFactoryImpl> entry : sModuleFactoryMap.entrySet()) {
            try {
                if (entry.getKey() != null && entry.getKey().equals(str)) {
                    entry.getValue().hasRigster = z;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean registerModule(final String str, final ModuleFactory moduleFactory, final boolean z) throws WXException {
        if (str == null || moduleFactory == null) {
            return false;
        }
        if (TextUtils.equals(str, WXDomModule.WXDOM)) {
            WXLogUtils.e("Cannot registered module with name 'dom'.");
            return false;
        }
        b.b().h(str, moduleFactory, z);
        if (RegisterCache.getInstance().cacheModule(str, moduleFactory, z)) {
            return true;
        }
        WXBridgeManager.getInstance().postWithName(new Runnable() { // from class: com.taobao.weex.bridge.WXModuleManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (WXModuleManager.sModuleFactoryMap != null && WXModuleManager.sModuleFactoryMap.containsKey(str)) {
                    WXLogUtils.w("WXComponentRegistry Duplicate the Module name: " + str);
                }
                try {
                    WXModuleManager.registerNativeModule(str, moduleFactory);
                } catch (WXException e) {
                    WXLogUtils.e("registerNativeModule" + e);
                }
                if (z) {
                    try {
                        WXModule buildInstance = moduleFactory.buildInstance();
                        buildInstance.setModuleName(str);
                        WXModuleManager.sGlobalModuleMap.put(str, buildInstance);
                    } catch (Exception e2) {
                        WXLogUtils.e(str + " class must have a default constructor without params. ", e2);
                    }
                }
                WXModuleManager.registerJSModule(str, moduleFactory);
                try {
                    WXModuleManager.sModuleFactoryMap.put(str, new ModuleFactoryImpl(moduleFactory));
                } catch (Throwable unused) {
                }
            }
        }, null, "registerModule");
        return true;
    }
}
