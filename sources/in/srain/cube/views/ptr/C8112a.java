package in.srain.cube.views.ptr;

import tb.rx1;

/* compiled from: Taobao */
/* renamed from: in.srain.cube.views.ptr.a */
/* loaded from: classes3.dex */
class C8112a implements PtrUIHandler {
    private PtrUIHandler a;
    private C8112a b;

    private C8112a() {
    }

    public static void a(C8112a c8112a, PtrUIHandler ptrUIHandler) {
        if (ptrUIHandler == null || c8112a == null) {
            return;
        }
        if (c8112a.a == null) {
            c8112a.a = ptrUIHandler;
            return;
        }
        while (!c8112a.b(ptrUIHandler)) {
            C8112a c8112a2 = c8112a.b;
            if (c8112a2 == null) {
                C8112a c8112a3 = new C8112a();
                c8112a3.a = ptrUIHandler;
                c8112a.b = c8112a3;
                return;
            }
            c8112a = c8112a2;
        }
    }

    private boolean b(PtrUIHandler ptrUIHandler) {
        PtrUIHandler ptrUIHandler2 = this.a;
        return ptrUIHandler2 != null && ptrUIHandler2 == ptrUIHandler;
    }

    public static C8112a c() {
        return new C8112a();
    }

    private PtrUIHandler d() {
        return this.a;
    }

    public static C8112a f(C8112a c8112a, PtrUIHandler ptrUIHandler) {
        if (c8112a == null || ptrUIHandler == null || c8112a.a == null) {
            return c8112a;
        }
        C8112a c8112a2 = c8112a;
        C8112a c8112a3 = null;
        do {
            if (!c8112a.b(ptrUIHandler)) {
                c8112a3 = c8112a;
                c8112a = c8112a.b;
                continue;
            } else if (c8112a3 == null) {
                c8112a2 = c8112a.b;
                c8112a.b = null;
                c8112a = c8112a2;
                continue;
            } else {
                c8112a3.b = c8112a.b;
                c8112a.b = null;
                c8112a = c8112a3.b;
                continue;
            }
        } while (c8112a != null);
        return c8112a2 == null ? new C8112a() : c8112a2;
    }

    public boolean e() {
        return this.a != null;
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, rx1 rx1Var) {
        C8112a c8112a = this;
        do {
            PtrUIHandler d = c8112a.d();
            if (d != null) {
                d.onUIPositionChange(ptrFrameLayout, z, b, rx1Var);
            }
            c8112a = c8112a.b;
        } while (c8112a != null);
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
        C8112a c8112a = this;
        do {
            PtrUIHandler d = c8112a.d();
            if (d != null) {
                d.onUIRefreshBegin(ptrFrameLayout);
            }
            c8112a = c8112a.b;
        } while (c8112a != null);
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
        C8112a c8112a = this;
        do {
            PtrUIHandler d = c8112a.d();
            if (d != null) {
                d.onUIRefreshComplete(ptrFrameLayout);
            }
            c8112a = c8112a.b;
        } while (c8112a != null);
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
        if (e()) {
            C8112a c8112a = this;
            do {
                PtrUIHandler d = c8112a.d();
                if (d != null) {
                    d.onUIRefreshPrepare(ptrFrameLayout);
                }
                c8112a = c8112a.b;
            } while (c8112a != null);
        }
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIReset(PtrFrameLayout ptrFrameLayout) {
        C8112a c8112a = this;
        do {
            PtrUIHandler d = c8112a.d();
            if (d != null) {
                d.onUIReset(ptrFrameLayout);
            }
            c8112a = c8112a.b;
        } while (c8112a != null);
    }
}
