package com.taobao.android.dinamicx;

import java.lang.ref.WeakReference;
import tb.uy;
import tb.v01;
import tb.vy;
import tb.wt;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.d */
/* loaded from: classes12.dex */
public class C6367d {
    protected DXEngineConfig a;
    private WeakReference<vy> b;
    private WeakReference<uy> c;
    private WeakReference<DinamicXEngine> d;
    private boolean e;
    private boolean f;
    private v01 g;
    private boolean h;
    private int i;

    public C6367d(DXEngineConfig dXEngineConfig) {
        this.e = false;
        this.f = false;
        this.h = false;
        this.i = 500;
        this.a = dXEngineConfig;
        if (wt.c0(dXEngineConfig.a)) {
            this.e = true;
        }
        if (wt.b0(dXEngineConfig.b())) {
            this.f = true;
        }
        if (wt.Q0(dXEngineConfig.b())) {
            this.h = wt.O0();
            this.i = wt.X();
        }
    }

    public long a() {
        DXRemoteTimeInterface m;
        if (e() == null || (m = e().m()) == null) {
            return -1L;
        }
        return m.fetchRemoteTimeSync();
    }

    public DXEngineConfig b() {
        return this.a;
    }

    public uy c() {
        WeakReference<uy> weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public vy d() {
        WeakReference<vy> weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public DinamicXEngine e() {
        WeakReference<DinamicXEngine> weakReference = this.d;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public v01 f() {
        return this.g;
    }

    public int g() {
        return this.i;
    }

    public boolean h() {
        return this.e;
    }

    public boolean i() {
        return this.f;
    }

    public boolean j() {
        return this.h;
    }

    public void k(DXRootView dXRootView, Object obj) {
        if (e() != null) {
            e().E(dXRootView, obj);
        }
    }

    public void l(uy uyVar) {
        this.c = new WeakReference<>(uyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(vy vyVar) {
        this.b = new WeakReference<>(vyVar);
    }

    public void n(DinamicXEngine dinamicXEngine) {
        this.d = new WeakReference<>(dinamicXEngine);
    }
}
