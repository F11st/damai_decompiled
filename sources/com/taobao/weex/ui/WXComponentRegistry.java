package com.taobao.weex.ui;

import android.text.TextUtils;
import com.taobao.weex.C6967b;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXException;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.cache.RegisterCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXComponentRegistry {
    private static Map<String, IFComponentHolder> sTypeComponentMap = new ConcurrentHashMap();
    private static ArrayList<Map<String, Object>> sComponentInfos = new ArrayList<>();

    public static IFComponentHolder getComponent(String str) {
        return sTypeComponentMap.get(str);
    }

    public static synchronized boolean registerComponent(Map<String, RegisterCache.ComponentCache> map) {
        synchronized (WXComponentRegistry.class) {
            if (map.isEmpty()) {
                return true;
            }
            final Iterator<Map.Entry<String, RegisterCache.ComponentCache>> it = map.entrySet().iterator();
            WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.ui.WXComponentRegistry.1
                @Override // java.lang.Runnable
                public void run() {
                    ArrayList arrayList = new ArrayList();
                    while (it.hasNext()) {
                        try {
                            RegisterCache.ComponentCache componentCache = (RegisterCache.ComponentCache) ((Map.Entry) it.next()).getValue();
                            Map map2 = componentCache.componentInfo;
                            if (map2 == null) {
                                map2 = new HashMap();
                            }
                            map2.put("type", componentCache.type);
                            map2.put("methods", componentCache.holder.getMethods());
                            WXComponentRegistry.registerNativeComponent(componentCache.type, componentCache.holder);
                            WXComponentRegistry.sComponentInfos.add(map2);
                            arrayList.add(map2);
                        } catch (WXException e) {
                            e.printStackTrace();
                        }
                    }
                    WXSDKManager.v().P(arrayList);
                }
            });
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean registerJSComponent(Map<String, Object> map) throws WXException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        WXSDKManager.v().P(arrayList);
        return true;
    }

    static boolean registerNativeComponent(String str, IFComponentHolder iFComponentHolder) throws WXException {
        try {
            iFComponentHolder.loadIfNonLazy();
            sTypeComponentMap.put(str, iFComponentHolder);
            return true;
        } catch (ArrayStoreException e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void reload() {
        WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.ui.WXComponentRegistry.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Iterator it = WXComponentRegistry.sComponentInfos.iterator();
                    while (it.hasNext()) {
                        WXComponentRegistry.registerJSComponent((Map) it.next());
                    }
                } catch (WXException e) {
                    WXLogUtils.e("", e);
                }
            }
        });
    }

    public static synchronized boolean registerComponent(final String str, final IFComponentHolder iFComponentHolder, final Map<String, Object> map) throws WXException {
        synchronized (WXComponentRegistry.class) {
            if (iFComponentHolder != null) {
                if (!TextUtils.isEmpty(str)) {
                    C6967b.b().g(str, iFComponentHolder, map);
                    if (RegisterCache.getInstance().cacheComponent(str, iFComponentHolder, map)) {
                        return true;
                    }
                    WXBridgeManager.getInstance().post(new Runnable() { // from class: com.taobao.weex.ui.WXComponentRegistry.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                Map map2 = map;
                                if (map2 == null) {
                                    map2 = new HashMap();
                                }
                                map2.put("type", str);
                                map2.put("methods", iFComponentHolder.getMethods());
                                WXComponentRegistry.registerNativeComponent(str, iFComponentHolder);
                                WXComponentRegistry.registerJSComponent(map2);
                                WXComponentRegistry.sComponentInfos.add(map2);
                            } catch (WXException e) {
                                WXLogUtils.e("register component error:", e);
                            }
                        }
                    });
                    return true;
                }
            }
            return false;
        }
    }
}
