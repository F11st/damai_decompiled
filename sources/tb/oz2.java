package tb;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.aliweex.C3004a;
import com.alibaba.aliweex.IConfigAdapter;
import com.alibaba.aliweex.adapter.IConfigGeneratorAdapter;
import com.alibaba.aliweex.adapter.IConfigModuleAdapter;
import com.alibaba.aliweex.adapter.IConfigModuleListener;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.cache.RegisterCache;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class oz2 {
    public static final String INIT_CONFIG_GROUP = "android_weex_ext_config";
    public static final String WXAPM_CONFIG_GROUP = "wxapm";
    public static final String key_back_to_home_when_exception = "backToHomeWhenException";
    public static final String key_enableAutoScan = "enableAutoScan";
    public static final String key_enableBackUpThread = "enableBackUpThread";
    public static final String key_enableBackUpThreadCache = "enableBackUpThreadCache";
    public static final String key_enableRegisterCache = "enableRegisterCache";
    public static final String key_enable_init_async = "enableInitAsync";
    public static final String key_enable_lazy_init = "enableLazyInit";
    public static final String key_enable_mtop_usecache = "enableMtopCache";
    public static final String key_enable_so_loader = "enableInitSoLoader";
    public static final String key_initLeftSize = "initLeftSize";
    private static volatile oz2 s;
    private IConfigModuleAdapter o;
    private IConfigModuleListener p;
    public C9538b a = null;
    public C9538b b = null;
    public C9538b c = null;
    public C9538b d = null;
    public C9538b e = null;
    public C9538b f = null;
    public C9538b g = null;
    public C9538b h = null;
    public C9538b i = null;
    public C9538b j = null;
    public C9538b k = null;
    public C9538b l = null;
    public C9538b m = null;
    public C9538b n = null;
    private SharedPreferences q = null;
    private List<C9538b> r = new ArrayList();

    /* compiled from: Taobao */
    /* renamed from: tb.oz2$a */
    /* loaded from: classes5.dex */
    class C9537a implements IConfigModuleListener {
        C9537a() {
        }

        @Override // com.alibaba.aliweex.adapter.IConfigModuleListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            IConfigAdapter c = C3004a.l().c();
            if (c == null) {
                return;
            }
            for (C9538b c9538b : oz2.this.r) {
                if (c9538b.a.equals(str)) {
                    oz2.this.g(c, c9538b);
                }
            }
            if ("android_weex_ext_config".equals(str)) {
                oz2.this.d();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.oz2$b */
    /* loaded from: classes5.dex */
    public static class C9538b {
        public String a;
        public String b;
        public String c;
        public String d = null;

        C9538b(String str, String str2, String str3) {
            this.b = str;
            this.c = str2;
            this.a = str3;
        }
    }

    private oz2() {
        this.o = null;
        this.p = null;
        l();
        IConfigGeneratorAdapter d = C3004a.l().d();
        if (d != null) {
            this.o = d.generateConfigInstance("");
            this.p = new C9537a();
            n(new String[]{"android_weex_ext_config", WXAPM_CONFIG_GROUP});
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        RegisterCache.getInstance().setEnableAutoScan("true".equals(f(key_enableAutoScan, "false")));
    }

    private synchronized void e() {
        if (this.q != null) {
            return;
        }
        Application b = C3004a.l().b();
        if (b != null) {
            this.q = b.getSharedPreferences("weex_init_config", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(IConfigAdapter iConfigAdapter, C9538b c9538b) {
        p(c9538b.b, iConfigAdapter.getConfig(c9538b.a, c9538b.b, c9538b.c));
    }

    public static oz2 j() {
        if (s == null) {
            synchronized (oz2.class) {
                if (s == null) {
                    s = new oz2();
                }
            }
        }
        return s;
    }

    private void l() {
        boolean e = zz2.e();
        WXLogUtils.e("aliweex initInitConfig:" + e);
        C9538b c9538b = new C9538b(key_enableAutoScan, e ? "false" : "true", "android_weex_ext_config");
        this.a = c9538b;
        this.r.add(c9538b);
        C9538b c9538b2 = new C9538b(key_enableRegisterCache, e ? "true" : "false", "android_weex_ext_config");
        this.b = c9538b2;
        this.r.add(c9538b2);
        C9538b c9538b3 = new C9538b(key_enableBackUpThread, e ? "true" : "false", "android_weex_ext_config");
        this.d = c9538b3;
        this.r.add(c9538b3);
        C9538b c9538b4 = new C9538b(key_enableBackUpThreadCache, "true", "android_weex_ext_config");
        this.e = c9538b4;
        this.r.add(c9538b4);
        C9538b c9538b5 = new C9538b(key_enable_so_loader, "true", "android_weex_ext_config");
        this.c = c9538b5;
        this.r.add(c9538b5);
        C9538b c9538b6 = new C9538b(key_initLeftSize, "50", "android_weex_ext_config");
        this.f = c9538b6;
        this.r.add(c9538b6);
        C9538b c9538b7 = new C9538b(key_enable_lazy_init, "true", "android_weex_ext_config");
        this.g = c9538b7;
        this.r.add(c9538b7);
        C9538b c9538b8 = new C9538b(key_enable_init_async, "true", "android_weex_ext_config");
        this.h = c9538b8;
        this.r.add(c9538b8);
        C9538b c9538b9 = new C9538b(key_back_to_home_when_exception, "false", "android_weex_ext_config");
        this.n = c9538b9;
        this.r.add(c9538b9);
        C9538b c9538b10 = new C9538b("use_runtime_api", "0", WXAPM_CONFIG_GROUP);
        this.i = c9538b10;
        this.r.add(c9538b10);
        C9538b c9538b11 = new C9538b("enableAlarmSignal", "true", WXAPM_CONFIG_GROUP);
        this.j = c9538b11;
        this.r.add(c9538b11);
        C9538b c9538b12 = new C9538b("loadRaxPkg", "true", WXAPM_CONFIG_GROUP);
        this.k = c9538b12;
        this.r.add(c9538b12);
        C9538b c9538b13 = new C9538b("release_map", "true", WXAPM_CONFIG_GROUP);
        this.l = c9538b13;
        this.r.add(c9538b13);
        C9538b c9538b14 = new C9538b(key_enable_mtop_usecache, "false", "android_weex_ext_config");
        this.m = c9538b14;
        this.r.add(c9538b14);
    }

    private synchronized void p(String str, String str2) {
        e();
        if (this.q != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            WXLogUtils.e("save Init Config : " + str + ":" + str2);
            SharedPreferences.Editor edit = this.q.edit();
            edit.putString(str, str2);
            edit.commit();
        }
    }

    public synchronized String f(String str, String str2) {
        e();
        SharedPreferences sharedPreferences = this.q;
        if (sharedPreferences != null && str != null) {
            str2 = sharedPreferences.getString(str, str2);
        }
        return str2;
    }

    public synchronized String h(C9538b c9538b) {
        if (c9538b == null) {
            return null;
        }
        if (c9538b.d == null) {
            c9538b.d = o(c9538b.a, c9538b.b, c9538b.c);
        }
        return c9538b.d;
    }

    public synchronized String i(C9538b c9538b) {
        if (c9538b == null) {
            return null;
        }
        return f(c9538b.b, c9538b.c);
    }

    public void k() {
        int i;
        if (m()) {
            String i2 = i(this.a);
            WXLogUtils.e("updateGlobalConfig enableAutoScan " + i2);
            RegisterCache.getInstance().setEnableAutoScan("true".equals(i2));
            String i3 = i(this.b);
            WXLogUtils.e("updateGlobalConfig enableRegisterCache " + i3);
            RegisterCache.getInstance().setEnable("true".equals(i3));
            String f = f(key_initLeftSize, "50");
            WXLogUtils.e("updateGlobalConfig initLeftSize " + f);
            try {
                i = Integer.parseInt(f);
            } catch (Exception unused) {
                i = 50;
            }
            RegisterCache.getInstance().setDoNotCacheSize(i);
        }
    }

    public boolean m() {
        if (this.q == null) {
            e();
        }
        return this.o != null;
    }

    void n(String[] strArr) {
        IConfigModuleAdapter iConfigModuleAdapter = this.o;
        if (iConfigModuleAdapter != null) {
            iConfigModuleAdapter.registerListener(strArr, this.p);
        }
    }

    public String o(String str, String str2, String str3) {
        String f = f(str2, str3);
        IConfigAdapter c = C3004a.l().c();
        return c == null ? f : c.getConfig(str, str2, f);
    }
}
