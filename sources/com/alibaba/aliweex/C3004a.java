package com.alibaba.aliweex;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.aliweex.adapter.IAliPayModuleAdapter;
import com.alibaba.aliweex.adapter.IConfigGeneratorAdapter;
import com.alibaba.aliweex.adapter.IEventModuleAdapter;
import com.alibaba.aliweex.adapter.IFestivalModuleAdapter;
import com.alibaba.aliweex.adapter.IGodEyeStageAdapter;
import com.alibaba.aliweex.adapter.INavigationBarModuleAdapter;
import com.alibaba.aliweex.adapter.IPageInfoModuleAdapter;
import com.alibaba.aliweex.adapter.IShareModuleAdapter;
import com.alibaba.aliweex.adapter.IUserModuleAdapter;
import com.taobao.weex.C6948a;
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alibaba.aliweex.a */
/* loaded from: classes15.dex */
public class C3004a {
    private static C3004a c;
    @NonNull
    private Application a;
    private C3005a b;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.a$a */
    /* loaded from: classes15.dex */
    public static class C3005a {
        IShareModuleAdapter a;
        IUserModuleAdapter b;
        IEventModuleAdapter c;
        IPageInfoModuleAdapter d;
        IAliPayModuleAdapter e;
        IConfigGeneratorAdapter f;
        INavigationBarModuleAdapter g;
        IConfigAdapter h;
        IFestivalModuleAdapter i;
        IWXImgLoaderAdapter j;
        IWXHttpAdapter k;
        List<String> l;
        IGodEyeStageAdapter m;
        C6948a n;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.aliweex.a$a$a */
        /* loaded from: classes15.dex */
        public static class C3006a {
            IShareModuleAdapter a;
            IUserModuleAdapter b;
            IEventModuleAdapter c;
            IPageInfoModuleAdapter d;
            IConfigGeneratorAdapter e;
            IAliPayModuleAdapter f;
            IConfigAdapter g;
            IFestivalModuleAdapter h;
            IWXImgLoaderAdapter i;
            IWXHttpAdapter j;
            List<String> k = new LinkedList();
            C6948a l;
            IGodEyeStageAdapter m;

            public C3005a a() {
                C3005a c3005a = new C3005a();
                c3005a.a = this.a;
                c3005a.b = this.b;
                c3005a.c = this.c;
                c3005a.d = this.d;
                c3005a.e = this.f;
                c3005a.f = this.e;
                c3005a.h = this.g;
                c3005a.i = this.h;
                c3005a.j = this.i;
                c3005a.k = this.j;
                c3005a.n = this.l;
                c3005a.l = this.k;
                c3005a.m = this.m;
                return c3005a;
            }
        }

        IAliPayModuleAdapter a() {
            return this.e;
        }

        IConfigAdapter b() {
            return this.h;
        }

        IConfigGeneratorAdapter c() {
            return this.f;
        }

        IEventModuleAdapter d() {
            return this.c;
        }

        IFestivalModuleAdapter e() {
            return this.i;
        }

        IWXHttpAdapter f() {
            return this.k;
        }

        IWXImgLoaderAdapter g() {
            return this.j;
        }

        C6948a h() {
            return this.n;
        }

        @NonNull
        Iterable<String> i() {
            if (this.l == null) {
                this.l = new LinkedList();
            }
            return this.l;
        }

        INavigationBarModuleAdapter j() {
            return this.g;
        }

        IPageInfoModuleAdapter k() {
            return this.d;
        }

        IShareModuleAdapter l() {
            return this.a;
        }

        IUserModuleAdapter m() {
            return this.b;
        }
    }

    public static C3004a l() {
        if (c == null) {
            synchronized (C3004a.class) {
                if (c == null) {
                    c = new C3004a();
                }
            }
        }
        return c;
    }

    public IAliPayModuleAdapter a() {
        C3005a c3005a = this.b;
        if (c3005a != null) {
            return c3005a.a();
        }
        return null;
    }

    public Application b() {
        return this.a;
    }

    public IConfigAdapter c() {
        C3005a c3005a = this.b;
        if (c3005a != null) {
            return c3005a.b();
        }
        return null;
    }

    public IConfigGeneratorAdapter d() {
        C3005a c3005a = this.b;
        if (c3005a != null) {
            return c3005a.c();
        }
        return null;
    }

    public Context e() {
        return this.a.getApplicationContext();
    }

    public IEventModuleAdapter f() {
        C3005a c3005a = this.b;
        if (c3005a != null) {
            return c3005a.d();
        }
        return null;
    }

    public IFestivalModuleAdapter g() {
        C3005a c3005a = this.b;
        if (c3005a != null) {
            return c3005a.e();
        }
        return null;
    }

    public IGodEyeStageAdapter h() {
        C3005a c3005a = this.b;
        if (c3005a != null) {
            return c3005a.m;
        }
        return null;
    }

    public IWXHttpAdapter i() {
        C3005a c3005a = this.b;
        if (c3005a != null) {
            return c3005a.f();
        }
        return null;
    }

    public IWXImgLoaderAdapter j() {
        C3005a c3005a = this.b;
        if (c3005a != null) {
            return c3005a.g();
        }
        return null;
    }

    public C6948a k() {
        C3005a c3005a = this.b;
        if (c3005a != null) {
            return c3005a.h();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Iterable<String> m() {
        C3005a c3005a = this.b;
        if (c3005a != null) {
            return c3005a.i();
        }
        return null;
    }

    public INavigationBarModuleAdapter n() {
        C3005a c3005a = this.b;
        if (c3005a != null) {
            return c3005a.j();
        }
        return null;
    }

    public IPageInfoModuleAdapter o() {
        C3005a c3005a = this.b;
        if (c3005a != null) {
            return c3005a.k();
        }
        return null;
    }

    public IShareModuleAdapter p() {
        C3005a c3005a = this.b;
        if (c3005a != null) {
            return c3005a.l();
        }
        return null;
    }

    public IUserModuleAdapter q() {
        C3005a c3005a = this.b;
        if (c3005a != null) {
            return c3005a.m();
        }
        return null;
    }

    public void r(Application application, C3005a c3005a) {
        this.a = application;
        this.b = c3005a;
    }

    public void s(String str, Map<String, Object> map) {
        IGodEyeStageAdapter iGodEyeStageAdapter;
        C3005a c3005a = this.b;
        if (c3005a == null || (iGodEyeStageAdapter = c3005a.m) == null) {
            return;
        }
        iGodEyeStageAdapter.onStage(str, map);
    }
}
