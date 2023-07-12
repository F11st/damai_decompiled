package in.srain.cube.views.ptr;

import tb.rx1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
class a implements PtrUIHandler {
    private PtrUIHandler a;
    private a b;

    private a() {
    }

    public static void a(a aVar, PtrUIHandler ptrUIHandler) {
        if (ptrUIHandler == null || aVar == null) {
            return;
        }
        if (aVar.a == null) {
            aVar.a = ptrUIHandler;
            return;
        }
        while (!aVar.b(ptrUIHandler)) {
            a aVar2 = aVar.b;
            if (aVar2 == null) {
                a aVar3 = new a();
                aVar3.a = ptrUIHandler;
                aVar.b = aVar3;
                return;
            }
            aVar = aVar2;
        }
    }

    private boolean b(PtrUIHandler ptrUIHandler) {
        PtrUIHandler ptrUIHandler2 = this.a;
        return ptrUIHandler2 != null && ptrUIHandler2 == ptrUIHandler;
    }

    public static a c() {
        return new a();
    }

    private PtrUIHandler d() {
        return this.a;
    }

    public static a f(a aVar, PtrUIHandler ptrUIHandler) {
        if (aVar == null || ptrUIHandler == null || aVar.a == null) {
            return aVar;
        }
        a aVar2 = aVar;
        a aVar3 = null;
        do {
            if (!aVar.b(ptrUIHandler)) {
                aVar3 = aVar;
                aVar = aVar.b;
                continue;
            } else if (aVar3 == null) {
                aVar2 = aVar.b;
                aVar.b = null;
                aVar = aVar2;
                continue;
            } else {
                aVar3.b = aVar.b;
                aVar.b = null;
                aVar = aVar3.b;
                continue;
            }
        } while (aVar != null);
        return aVar2 == null ? new a() : aVar2;
    }

    public boolean e() {
        return this.a != null;
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, rx1 rx1Var) {
        a aVar = this;
        do {
            PtrUIHandler d = aVar.d();
            if (d != null) {
                d.onUIPositionChange(ptrFrameLayout, z, b, rx1Var);
            }
            aVar = aVar.b;
        } while (aVar != null);
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
        a aVar = this;
        do {
            PtrUIHandler d = aVar.d();
            if (d != null) {
                d.onUIRefreshBegin(ptrFrameLayout);
            }
            aVar = aVar.b;
        } while (aVar != null);
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
        a aVar = this;
        do {
            PtrUIHandler d = aVar.d();
            if (d != null) {
                d.onUIRefreshComplete(ptrFrameLayout);
            }
            aVar = aVar.b;
        } while (aVar != null);
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
        if (e()) {
            a aVar = this;
            do {
                PtrUIHandler d = aVar.d();
                if (d != null) {
                    d.onUIRefreshPrepare(ptrFrameLayout);
                }
                aVar = aVar.b;
            } while (aVar != null);
        }
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIReset(PtrFrameLayout ptrFrameLayout) {
        a aVar = this;
        do {
            PtrUIHandler d = aVar.d();
            if (d != null) {
                d.onUIReset(ptrFrameLayout);
            }
            aVar = aVar.b;
        } while (aVar != null);
    }
}
