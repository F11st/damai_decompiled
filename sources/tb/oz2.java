package tb;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;
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
    public b a = null;
    public b b = null;
    public b c = null;
    public b d = null;
    public b e = null;
    public b f = null;
    public b g = null;
    public b h = null;
    public b i = null;
    public b j = null;
    public b k = null;
    public b l = null;
    public b m = null;
    public b n = null;
    private SharedPreferences q = null;
    private List<b> r = new ArrayList();

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class a implements IConfigModuleListener {
        a() {
        }

        @Override // com.alibaba.aliweex.adapter.IConfigModuleListener
        public void onConfigUpdate(String str, Map<String, String> map) {
            IConfigAdapter c = com.alibaba.aliweex.a.l().c();
            if (c == null) {
                return;
            }
            for (b bVar : oz2.this.r) {
                if (bVar.a.equals(str)) {
                    oz2.this.g(c, bVar);
                }
            }
            if ("android_weex_ext_config".equals(str)) {
                oz2.this.d();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class b {
        public String a;
        public String b;
        public String c;
        public String d = null;

        b(String str, String str2, String str3) {
            this.b = str;
            this.c = str2;
            this.a = str3;
        }
    }

    private oz2() {
        this.o = null;
        this.p = null;
        l();
        IConfigGeneratorAdapter d = com.alibaba.aliweex.a.l().d();
        if (d != null) {
            this.o = d.generateConfigInstance("");
            this.p = new a();
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
        Application b2 = com.alibaba.aliweex.a.l().b();
        if (b2 != null) {
            this.q = b2.getSharedPreferences("weex_init_config", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(IConfigAdapter iConfigAdapter, b bVar) {
        p(bVar.b, iConfigAdapter.getConfig(bVar.a, bVar.b, bVar.c));
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
        b bVar = new b(key_enableAutoScan, e ? "false" : "true", "android_weex_ext_config");
        this.a = bVar;
        this.r.add(bVar);
        b bVar2 = new b(key_enableRegisterCache, e ? "true" : "false", "android_weex_ext_config");
        this.b = bVar2;
        this.r.add(bVar2);
        b bVar3 = new b(key_enableBackUpThread, e ? "true" : "false", "android_weex_ext_config");
        this.d = bVar3;
        this.r.add(bVar3);
        b bVar4 = new b(key_enableBackUpThreadCache, "true", "android_weex_ext_config");
        this.e = bVar4;
        this.r.add(bVar4);
        b bVar5 = new b(key_enable_so_loader, "true", "android_weex_ext_config");
        this.c = bVar5;
        this.r.add(bVar5);
        b bVar6 = new b(key_initLeftSize, "50", "android_weex_ext_config");
        this.f = bVar6;
        this.r.add(bVar6);
        b bVar7 = new b(key_enable_lazy_init, "true", "android_weex_ext_config");
        this.g = bVar7;
        this.r.add(bVar7);
        b bVar8 = new b(key_enable_init_async, "true", "android_weex_ext_config");
        this.h = bVar8;
        this.r.add(bVar8);
        b bVar9 = new b(key_back_to_home_when_exception, "false", "android_weex_ext_config");
        this.n = bVar9;
        this.r.add(bVar9);
        b bVar10 = new b("use_runtime_api", "0", WXAPM_CONFIG_GROUP);
        this.i = bVar10;
        this.r.add(bVar10);
        b bVar11 = new b("enableAlarmSignal", "true", WXAPM_CONFIG_GROUP);
        this.j = bVar11;
        this.r.add(bVar11);
        b bVar12 = new b("loadRaxPkg", "true", WXAPM_CONFIG_GROUP);
        this.k = bVar12;
        this.r.add(bVar12);
        b bVar13 = new b("release_map", "true", WXAPM_CONFIG_GROUP);
        this.l = bVar13;
        this.r.add(bVar13);
        b bVar14 = new b(key_enable_mtop_usecache, "false", "android_weex_ext_config");
        this.m = bVar14;
        this.r.add(bVar14);
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

    public synchronized String h(b bVar) {
        if (bVar == null) {
            return null;
        }
        if (bVar.d == null) {
            bVar.d = o(bVar.a, bVar.b, bVar.c);
        }
        return bVar.d;
    }

    public synchronized String i(b bVar) {
        if (bVar == null) {
            return null;
        }
        return f(bVar.b, bVar.c);
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
        IConfigAdapter c = com.alibaba.aliweex.a.l().c();
        return c == null ? f : c.getConfig(str, str2, f);
    }
}
