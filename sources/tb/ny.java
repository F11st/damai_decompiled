package tb;

import android.util.Log;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.eventchain.DXAtomicEventNode;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ny {
    private k10 b;
    private C9487a c;
    private py a = null;
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;

    /* compiled from: Taobao */
    /* renamed from: tb.ny$a */
    /* loaded from: classes11.dex */
    class C9487a {
        private Map<String, wy> a;
        private Stack<wy> b = new Stack<>();
        private k10 c;

        public C9487a(ny nyVar, k10 k10Var) {
            this.c = k10Var;
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x0136, code lost:
            r16.a.put(r9, r11);
            r6 = r6 + 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean b(int r17, tb.C9787ut r18, com.taobao.android.dinamicx.DXRuntimeContext r19) {
            /*
                Method dump skipped, instructions count: 349
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.ny.C9487a.b(int, tb.ut, com.taobao.android.dinamicx.DXRuntimeContext):boolean");
        }
    }

    public ny() {
        k10 k10Var = new k10();
        this.b = k10Var;
        this.c = new C9487a(this, k10Var);
    }

    private DXAtomicEventNode b(int i, String str, C9787ut c9787ut, DXRuntimeContext dXRuntimeContext) {
        try {
            short h = c9787ut.h();
            String str2 = new String(c9787ut.a(), c9787ut.c(), (int) h);
            c9787ut.j(h);
            DXAtomicEventNode dXAtomicEventNode = new DXAtomicEventNode(str2, Long.valueOf(c9787ut.g()));
            short h2 = c9787ut.h();
            if (h2 != 0) {
                dXAtomicEventNode.w(new String(c9787ut.a(), c9787ut.c(), (int) h2));
                c9787ut.j(h2);
            }
            short h3 = c9787ut.h();
            if (h3 != 0) {
                dXAtomicEventNode.u(new String(c9787ut.a(), c9787ut.c(), (int) h3));
                c9787ut.j(h3);
            }
            int f = c9787ut.f();
            if (f != 0) {
                dXAtomicEventNode.v(new String(c9787ut.a(), c9787ut.c(), f));
                c9787ut.j(f);
            }
            return dXAtomicEventNode;
        } catch (Exception e) {
            if (DinamicXEngine.x()) {
                e.printStackTrace();
            }
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_LOADER_ATOMICEVENT, ry.a(e)));
            return null;
        }
    }

    private iy c(int i, C9787ut c9787ut, DXRuntimeContext dXRuntimeContext) {
        try {
            short h = c9787ut.h();
            String str = new String(c9787ut.a(), c9787ut.c(), (int) h);
            c9787ut.j(h);
            short h2 = c9787ut.h();
            iy iyVar = new iy(str, h2);
            for (int i2 = 0; i2 < h2; i2++) {
                c9787ut.d();
                DXAtomicEventNode b = b(c9787ut.h(), str, c9787ut, dXRuntimeContext);
                if (b == null) {
                    List<C6368e.C6369a> list = dXRuntimeContext.getDxError().c;
                    list.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_LOADER_ATOMICEVENT, "eventChainName" + str));
                    return null;
                }
                iyVar.a(b.n(), b);
                c9787ut.d();
            }
            return iyVar;
        } catch (Exception e) {
            if (DinamicXEngine.x()) {
                e.printStackTrace();
            }
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_LOADER_EVENTCHIAN, ry.a(e)));
            return null;
        }
    }

    public py a(C9787ut c9787ut, DXRuntimeContext dXRuntimeContext) {
        iy c;
        long nanoTime = System.nanoTime();
        if (this.e == 0 || c9787ut == null || !c9787ut.i(this.d)) {
            return null;
        }
        byte d = c9787ut.d();
        if (d < 0) {
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_LOADER_COUNT_ERROR));
            return null;
        }
        this.a = new py();
        for (int i = 0; i < d; i++) {
            if (c9787ut.d() != 0 || (c = c(c9787ut.f(), c9787ut, dXRuntimeContext)) == null) {
                return null;
            }
            this.a.e(c.d(), c);
            if (c9787ut.d() != 1) {
                return null;
            }
        }
        this.a.d(this.c.a);
        Log.e("TIME:", "eventchain_createEventChain** " + (System.nanoTime() - nanoTime));
        return this.a;
    }

    public boolean d(C9787ut c9787ut, DXRuntimeContext dXRuntimeContext) {
        long nanoTime = System.nanoTime();
        if (c9787ut == null || !c9787ut.i(this.d)) {
            return false;
        }
        if (!c9787ut.j(this.e)) {
            Log.e("EventChainLoader_TMTEST", "event chain seekBy error:" + this.e);
            return false;
        }
        c9787ut.c();
        if (c9787ut.c() == this.f) {
            if (!this.b.a(this.g, c9787ut, dXRuntimeContext)) {
                s00.b("event chain string loadFromBuffer error!");
            }
        } else {
            List<C6368e.C6369a> list = dXRuntimeContext.getDxError().c;
            list.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_STRING_LOADER_POSITION_ERROR, "event chain string pos error:" + this.f + "  read pos:" + c9787ut.c()));
        }
        if (c9787ut.c() == this.h) {
            if (!this.c.b(this.i, c9787ut, dXRuntimeContext)) {
                s00.b("event chain expr loadFromBuffer error!");
            }
        } else {
            List<C6368e.C6369a> list2 = dXRuntimeContext.getDxError().c;
            list2.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Event_Chain_Binary", C6368e.DXERROR_PIPELINE_BINARY_FILE_EVENT_CHAIN_EXPR_LOADER_POSITION_ERROR, "event chain expr pos error:" + this.h + "  read pos:" + c9787ut.c()));
        }
        Log.e("TIME:", "eventchain_loadFromBuffer** " + (System.nanoTime() - nanoTime));
        return true;
    }

    public void e(int i) {
        this.e = i;
    }

    public void f(int i) {
        this.d = i;
    }

    public void g(int i) {
        this.i = i;
    }

    public void h(int i) {
        this.h = i;
    }

    public void i(int i) {
        this.g = i;
    }

    public void j(int i) {
        this.f = i;
    }
}
