package com.taobao.weex.utils.cache;

import com.taobao.weex.bridge.ModuleFactory;
import com.taobao.weex.bridge.WXModuleManager;
import com.taobao.weex.ui.IFComponentHolder;
import com.taobao.weex.ui.WXComponentRegistry;
import com.taobao.weex.ui.config.AutoScanConfigRegister;
import com.taobao.weex.utils.WXLogUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RegisterCache {
    private static Map<String, ModuleCache> e = new ConcurrentHashMap();
    private static Map<String, ComponentCache> f = new ConcurrentHashMap();
    private static RegisterCache g;
    private boolean a = false;
    private boolean b = true;
    private volatile boolean c = false;
    private volatile int d = Integer.MAX_VALUE;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class ComponentCache {
        public final Map<String, Object> componentInfo;
        public final IFComponentHolder holder;
        public final String type;

        ComponentCache(RegisterCache registerCache, String str, IFComponentHolder iFComponentHolder, Map<String, Object> map) {
            this.type = str;
            this.componentInfo = map;
            this.holder = iFComponentHolder;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class ModuleCache {
        public final ModuleFactory factory;
        public final boolean global;
        public final String name;

        ModuleCache(RegisterCache registerCache, String str, ModuleFactory moduleFactory, boolean z) {
            this.name = str;
            this.factory = moduleFactory;
            this.global = z;
        }
    }

    private RegisterCache() {
    }

    private void a() {
        if (f.isEmpty()) {
            return;
        }
        WXComponentRegistry.registerComponent(f);
    }

    private void b() {
        if (e.isEmpty()) {
            return;
        }
        WXModuleManager.registerModule(e);
    }

    private boolean c() {
        return d() && !this.c && e() < 1;
    }

    private boolean d() {
        return this.a;
    }

    private int e() {
        int i = this.d;
        this.d = i - 1;
        return i;
    }

    public static RegisterCache getInstance() {
        if (g == null) {
            synchronized (RegisterCache.class) {
                if (g == null) {
                    g = new RegisterCache();
                }
            }
        }
        return g;
    }

    public boolean cacheComponent(String str, IFComponentHolder iFComponentHolder, Map<String, Object> map) {
        if (c()) {
            try {
                f.put(str, new ComponentCache(this, str, iFComponentHolder, map));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public boolean cacheModule(String str, ModuleFactory moduleFactory, boolean z) {
        if (c()) {
            try {
                e.put(str, new ModuleCache(this, str, moduleFactory, z));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public boolean enableAutoScan() {
        return this.b;
    }

    public boolean idle(boolean z) {
        if (this.c) {
            return true;
        }
        String str = z ? "idle from create instance" : "idle from external";
        WXLogUtils.e(str + " cache size is " + (e.size() + f.size()));
        this.c = true;
        a();
        b();
        return true;
    }

    public void setDoNotCacheSize(int i) {
        this.d = i;
    }

    public void setEnable(boolean z) {
        this.a = z;
    }

    public void setEnableAutoScan(boolean z) {
        if (this.b != z) {
            if (z) {
                AutoScanConfigRegister.doScanConfig();
            }
            this.b = z;
        }
    }
}
