package com.taobao.android.dinamicx.eventchain;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.C6365b;
import com.taobao.android.dinamicx.C6367d;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.monitor.RuntimeProfilingInfoCollector;
import com.taobao.weex.ui.component.AbstractEditComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import tb.C9192h;
import tb.C9586q;
import tb.C9587q0;
import tb.jn1;
import tb.ky;
import tb.lu2;
import tb.m80;
import tb.my;
import tb.oy;
import tb.s00;
import tb.s20;
import tb.vf0;
import tb.wf0;
import tb.wt;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.eventchain.b */
/* loaded from: classes11.dex */
public class C6372b extends C6365b {
    private C9192h d;
    private WeakHashMap<C6371a, Integer> e;
    private List<WeakReference<C6371a>> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.eventchain.b$a */
    /* loaded from: classes11.dex */
    public class C6373a implements DXEventChainCallback {
        final /* synthetic */ C6371a a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        C6373a(C6371a c6371a, int i, String str) {
            this.a = c6371a;
            this.b = i;
            this.c = str;
        }

        @Override // com.taobao.android.dinamicx.eventchain.DXEventChainCallback
        public void callback(C6374c c6374c, oy oyVar) {
            if (oyVar.g() == 2) {
                s00.b("event chain interrupt");
            } else if (this.a.l() == null) {
                s00.b("callback dxRuntimeContext recycled");
            } else {
                my p = this.a.p();
                if (p != null) {
                    p.j(oyVar.f());
                    if (this.a.p() != null) {
                        p.h(this.a.p().c());
                        p.i(this.a.p().d());
                    }
                }
                if (DinamicXEngine.x()) {
                    C6371a c6371a = this.a;
                    int i = this.b;
                    c6371a.H(new wf0(i, "callback_" + c6374c.a(), oyVar));
                }
                C6372b.this.f(c6374c.b(), this.c, this.a);
            }
        }
    }

    public C6372b(@NonNull C6367d c6367d) {
        super(c6367d);
        C9192h a = c6367d.b().a();
        if (a == null) {
            C9587q0 c9587q0 = new C9587q0(a(), "DX");
            C9192h c9192h = new C9192h();
            this.d = c9192h;
            c9192h.h(c9587q0);
        } else {
            this.d = a;
            this.d.h(new C9587q0(a(), "DX"));
        }
        this.e = new WeakHashMap<>();
        this.f = new ArrayList();
    }

    public static void d(int i, oy oyVar, C6371a c6371a) {
        e(i(i, null, c6371a), null, oyVar, c6371a);
    }

    public static void e(vf0 vf0Var, DXAtomicEventNode dXAtomicEventNode, oy oyVar, C6371a c6371a) {
        if (vf0Var != null) {
            vf0Var.i(oyVar);
            if (dXAtomicEventNode != null) {
                vf0Var.h(dXAtomicEventNode.p());
                vf0Var.g(dXAtomicEventNode.o());
                vf0Var.a(dXAtomicEventNode.m());
            }
        }
        RuntimeProfilingInfoCollector.c().d(c6371a != null ? c6371a.m() : null, vf0Var);
    }

    private oy g(String str, String str2, C6371a c6371a) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && c6371a != null) {
            int f = c6371a.f();
            DXAtomicEventNode i = c6371a.i(str, str2);
            if (i == null) {
                if (DinamicXEngine.x()) {
                    d(f, oy.b(ky.EVENT_CHAIN_ERROR_EXECUTE_ATOMIC_EVENT_NODE_IS_NULL), c6371a);
                }
                return oy.b(ky.EVENT_CHAIN_ERROR_EXECUTE_ATOMIC_EVENT_NODE_IS_NULL);
            }
            vf0 i2 = DinamicXEngine.x() ? i(f, i, c6371a) : null;
            oy j = i.j(c6371a, new C6373a(c6371a, f, str));
            if (DinamicXEngine.x()) {
                e(i2, i, j, c6371a);
            }
            if (j.g() == 2) {
                s00.b("event chain interrupt");
                return j;
            }
            DXRuntimeContext l = c6371a.l();
            if (l == null) {
                s00.b("callback dxRuntimeContext recycled");
                return j;
            }
            my eventChainExpressionSourceContext = l.getEventChainExpressionSourceContext();
            if (eventChainExpressionSourceContext != null) {
                eventChainExpressionSourceContext.j(j.f());
                if (c6371a.p() != null) {
                    eventChainExpressionSourceContext.h(c6371a.p().c());
                    eventChainExpressionSourceContext.i(c6371a.p().d());
                }
            }
            if (DinamicXEngine.x()) {
                c6371a.H(new wf0(f, AbstractEditComponent.ReturnTypes.NEXT, j));
            }
            return !TextUtils.isEmpty(i.o()) ? f(i.o(), str, c6371a) : j;
        }
        if (DinamicXEngine.x()) {
            d(c6371a != null ? c6371a.s() + 1 : -1, oy.b(ky.EVENT_CHAIN_ERROR_EXECUTE_ATOMIC_EVENT_CONTEXT_IS_NULL), c6371a);
        }
        return oy.b(ky.EVENT_CHAIN_ERROR_EXECUTE_ATOMIC_EVENT_CONTEXT_IS_NULL);
    }

    private oy h(String str, C6371a c6371a) {
        if (!TextUtils.isEmpty(str) && c6371a != null) {
            c6371a.D(str);
            return g(str, lu2.MAIN, c6371a);
        }
        return oy.b(ky.EVENT_CHAIN_ERROR_EXECUTE_EVENTCHIAN_CONTEXT_IS_NULL);
    }

    public static vf0 i(int i, DXAtomicEventNode dXAtomicEventNode, C6371a c6371a) {
        vf0 vf0Var;
        if (dXAtomicEventNode == null) {
            vf0Var = new vf0(i, "unknown", -1L, null);
        } else {
            vf0Var = new vf0(i, dXAtomicEventNode.n(), dXAtomicEventNode.q().longValue(), null);
        }
        if (c6371a != null) {
            vf0Var.f(c6371a.r());
            C9586q e = c6371a.e();
            if (e != null) {
                vf0Var.b(e.b());
                C9192h a = e.a();
                if (a != null) {
                    vf0Var.c(a.d());
                }
            }
            my p = c6371a.p();
            if (p != null) {
                vf0Var.e(p.e());
                vf0Var.d(p.c());
            }
            DXRuntimeContext l = c6371a.l();
            if (l != null) {
                vf0Var.j(l.getData());
                vf0Var.k(l.getSubData());
            }
        }
        return vf0Var;
    }

    public void c() {
        String str;
        C6371a c6371a;
        try {
            if (wt.L0()) {
                if (this.f == null) {
                    return;
                }
                str = " List : size" + this.f.size();
                Iterator<WeakReference<C6371a>> it = this.f.iterator();
                if (it == null) {
                    return;
                }
                while (it.hasNext()) {
                    WeakReference<C6371a> next = it.next();
                    if (next != null && (c6371a = next.get()) != null) {
                        c6371a.b();
                    }
                }
            } else if (this.e == null) {
                return;
            } else {
                str = " map : size" + this.e.size();
                for (Map.Entry<C6371a, Integer> entry : this.e.entrySet()) {
                    if (entry != null && entry.getKey() != null) {
                        entry.getKey().b();
                    }
                }
            }
            DXAppMonitor.q(a(), null, "DX_EventChain", "DX_EventChain_Error", C6368e.EVENTCHAIN_CONTEXT_SIZE, str);
        } catch (Throwable th) {
            s00.d("DXEventChainException", "", "cancel event chain error : " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public oy f(String str, String str2, C6371a c6371a) {
        Object b;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && c6371a != null) {
            c6371a.K();
            if (str.startsWith("$(") && str.endsWith(jn1.BRACKET_END_STR)) {
                return g(str2, str.substring(2, str.length() - 1), c6371a);
            }
            if (str.startsWith("$$(") && str.endsWith(jn1.BRACKET_END_STR)) {
                return h(str.substring(3, str.length() - 1), c6371a);
            }
            if (str.startsWith(m80.DINAMIC_PREFIX_AT) && str.endsWith("}") && (b = c6371a.n().b(str).b(null, c6371a.l())) != null) {
                return f(b.toString(), str2, c6371a);
            }
            return null;
        }
        return oy.b(ky.EVENT_CHAIN_ERROR_EXECUTE_CONTEXT_IS_NULL);
    }

    public C9192h j() {
        return this.d;
    }

    public void k(C6371a c6371a) {
        if (wt.L0()) {
            this.f.add(new WeakReference<>(c6371a));
            s20.a(this.f);
            return;
        }
        this.e.put(c6371a, Integer.valueOf(c6371a.hashCode()));
    }

    public void l() {
        this.d.g();
    }
}
