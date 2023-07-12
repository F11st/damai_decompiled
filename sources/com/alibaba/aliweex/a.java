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
import com.taobao.weex.adapter.IWXHttpAdapter;
import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class a {
    private static a c;
    @NonNull
    private Application a;
    private C0122a b;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.aliweex.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0122a {
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
        com.taobao.weex.a n;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.aliweex.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public static class C0123a {
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
            com.taobao.weex.a l;
            IGodEyeStageAdapter m;

            public C0122a a() {
                C0122a c0122a = new C0122a();
                c0122a.a = this.a;
                c0122a.b = this.b;
                c0122a.c = this.c;
                c0122a.d = this.d;
                c0122a.e = this.f;
                c0122a.f = this.e;
                c0122a.h = this.g;
                c0122a.i = this.h;
                c0122a.j = this.i;
                c0122a.k = this.j;
                c0122a.n = this.l;
                c0122a.l = this.k;
                c0122a.m = this.m;
                return c0122a;
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

        com.taobao.weex.a h() {
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

    public static a l() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public IAliPayModuleAdapter a() {
        C0122a c0122a = this.b;
        if (c0122a != null) {
            return c0122a.a();
        }
        return null;
    }

    public Application b() {
        return this.a;
    }

    public IConfigAdapter c() {
        C0122a c0122a = this.b;
        if (c0122a != null) {
            return c0122a.b();
        }
        return null;
    }

    public IConfigGeneratorAdapter d() {
        C0122a c0122a = this.b;
        if (c0122a != null) {
            return c0122a.c();
        }
        return null;
    }

    public Context e() {
        return this.a.getApplicationContext();
    }

    public IEventModuleAdapter f() {
        C0122a c0122a = this.b;
        if (c0122a != null) {
            return c0122a.d();
        }
        return null;
    }

    public IFestivalModuleAdapter g() {
        C0122a c0122a = this.b;
        if (c0122a != null) {
            return c0122a.e();
        }
        return null;
    }

    public IGodEyeStageAdapter h() {
        C0122a c0122a = this.b;
        if (c0122a != null) {
            return c0122a.m;
        }
        return null;
    }

    public IWXHttpAdapter i() {
        C0122a c0122a = this.b;
        if (c0122a != null) {
            return c0122a.f();
        }
        return null;
    }

    public IWXImgLoaderAdapter j() {
        C0122a c0122a = this.b;
        if (c0122a != null) {
            return c0122a.g();
        }
        return null;
    }

    public com.taobao.weex.a k() {
        C0122a c0122a = this.b;
        if (c0122a != null) {
            return c0122a.h();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Iterable<String> m() {
        C0122a c0122a = this.b;
        if (c0122a != null) {
            return c0122a.i();
        }
        return null;
    }

    public INavigationBarModuleAdapter n() {
        C0122a c0122a = this.b;
        if (c0122a != null) {
            return c0122a.j();
        }
        return null;
    }

    public IPageInfoModuleAdapter o() {
        C0122a c0122a = this.b;
        if (c0122a != null) {
            return c0122a.k();
        }
        return null;
    }

    public IShareModuleAdapter p() {
        C0122a c0122a = this.b;
        if (c0122a != null) {
            return c0122a.l();
        }
        return null;
    }

    public IUserModuleAdapter q() {
        C0122a c0122a = this.b;
        if (c0122a != null) {
            return c0122a.m();
        }
        return null;
    }

    public void r(Application application, C0122a c0122a) {
        this.a = application;
        this.b = c0122a;
    }

    public void s(String str, Map<String, Object> map) {
        IGodEyeStageAdapter iGodEyeStageAdapter;
        C0122a c0122a = this.b;
        if (c0122a == null || (iGodEyeStageAdapter = c0122a.m) == null) {
            return;
        }
        iGodEyeStageAdapter.onStage(str, map);
    }
}
