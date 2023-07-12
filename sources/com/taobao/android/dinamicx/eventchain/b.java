package com.taobao.android.dinamicx.eventchain;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.d;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.monitor.RuntimeProfilingInfoCollector;
import com.taobao.weex.ui.component.AbstractEditComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import tb.h;
import tb.jn1;
import tb.ky;
import tb.lu2;
import tb.m80;
import tb.my;
import tb.oy;
import tb.q;
import tb.q0;
import tb.s00;
import tb.s20;
import tb.vf0;
import tb.wf0;
import tb.wt;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b extends com.taobao.android.dinamicx.b {
    private h d;
    private WeakHashMap<com.taobao.android.dinamicx.eventchain.a, Integer> e;
    private List<WeakReference<com.taobao.android.dinamicx.eventchain.a>> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a implements DXEventChainCallback {
        final /* synthetic */ com.taobao.android.dinamicx.eventchain.a a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        a(com.taobao.android.dinamicx.eventchain.a aVar, int i, String str) {
            this.a = aVar;
            this.b = i;
            this.c = str;
        }

        @Override // com.taobao.android.dinamicx.eventchain.DXEventChainCallback
        public void callback(c cVar, oy oyVar) {
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
                    com.taobao.android.dinamicx.eventchain.a aVar = this.a;
                    int i = this.b;
                    aVar.H(new wf0(i, "callback_" + cVar.a(), oyVar));
                }
                b.this.f(cVar.b(), this.c, this.a);
            }
        }
    }

    public b(@NonNull d dVar) {
        super(dVar);
        h a2 = dVar.b().a();
        if (a2 == null) {
            q0 q0Var = new q0(a(), "DX");
            h hVar = new h();
            this.d = hVar;
            hVar.h(q0Var);
        } else {
            this.d = a2;
            this.d.h(new q0(a(), "DX"));
        }
        this.e = new WeakHashMap<>();
        this.f = new ArrayList();
    }

    public static void d(int i, oy oyVar, com.taobao.android.dinamicx.eventchain.a aVar) {
        e(i(i, null, aVar), null, oyVar, aVar);
    }

    public static void e(vf0 vf0Var, DXAtomicEventNode dXAtomicEventNode, oy oyVar, com.taobao.android.dinamicx.eventchain.a aVar) {
        if (vf0Var != null) {
            vf0Var.i(oyVar);
            if (dXAtomicEventNode != null) {
                vf0Var.h(dXAtomicEventNode.p());
                vf0Var.g(dXAtomicEventNode.o());
                vf0Var.a(dXAtomicEventNode.m());
            }
        }
        RuntimeProfilingInfoCollector.c().d(aVar != null ? aVar.m() : null, vf0Var);
    }

    private oy g(String str, String str2, com.taobao.android.dinamicx.eventchain.a aVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && aVar != null) {
            int f = aVar.f();
            DXAtomicEventNode i = aVar.i(str, str2);
            if (i == null) {
                if (DinamicXEngine.x()) {
                    d(f, oy.b(ky.EVENT_CHAIN_ERROR_EXECUTE_ATOMIC_EVENT_NODE_IS_NULL), aVar);
                }
                return oy.b(ky.EVENT_CHAIN_ERROR_EXECUTE_ATOMIC_EVENT_NODE_IS_NULL);
            }
            vf0 i2 = DinamicXEngine.x() ? i(f, i, aVar) : null;
            oy j = i.j(aVar, new a(aVar, f, str));
            if (DinamicXEngine.x()) {
                e(i2, i, j, aVar);
            }
            if (j.g() == 2) {
                s00.b("event chain interrupt");
                return j;
            }
            DXRuntimeContext l = aVar.l();
            if (l == null) {
                s00.b("callback dxRuntimeContext recycled");
                return j;
            }
            my eventChainExpressionSourceContext = l.getEventChainExpressionSourceContext();
            if (eventChainExpressionSourceContext != null) {
                eventChainExpressionSourceContext.j(j.f());
                if (aVar.p() != null) {
                    eventChainExpressionSourceContext.h(aVar.p().c());
                    eventChainExpressionSourceContext.i(aVar.p().d());
                }
            }
            if (DinamicXEngine.x()) {
                aVar.H(new wf0(f, AbstractEditComponent.ReturnTypes.NEXT, j));
            }
            return !TextUtils.isEmpty(i.o()) ? f(i.o(), str, aVar) : j;
        }
        if (DinamicXEngine.x()) {
            d(aVar != null ? aVar.s() + 1 : -1, oy.b(ky.EVENT_CHAIN_ERROR_EXECUTE_ATOMIC_EVENT_CONTEXT_IS_NULL), aVar);
        }
        return oy.b(ky.EVENT_CHAIN_ERROR_EXECUTE_ATOMIC_EVENT_CONTEXT_IS_NULL);
    }

    private oy h(String str, com.taobao.android.dinamicx.eventchain.a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            aVar.D(str);
            return g(str, lu2.MAIN, aVar);
        }
        return oy.b(ky.EVENT_CHAIN_ERROR_EXECUTE_EVENTCHIAN_CONTEXT_IS_NULL);
    }

    public static vf0 i(int i, DXAtomicEventNode dXAtomicEventNode, com.taobao.android.dinamicx.eventchain.a aVar) {
        vf0 vf0Var;
        if (dXAtomicEventNode == null) {
            vf0Var = new vf0(i, "unknown", -1L, null);
        } else {
            vf0Var = new vf0(i, dXAtomicEventNode.n(), dXAtomicEventNode.q().longValue(), null);
        }
        if (aVar != null) {
            vf0Var.f(aVar.r());
            q e = aVar.e();
            if (e != null) {
                vf0Var.b(e.b());
                h a2 = e.a();
                if (a2 != null) {
                    vf0Var.c(a2.d());
                }
            }
            my p = aVar.p();
            if (p != null) {
                vf0Var.e(p.e());
                vf0Var.d(p.c());
            }
            DXRuntimeContext l = aVar.l();
            if (l != null) {
                vf0Var.j(l.getData());
                vf0Var.k(l.getSubData());
            }
        }
        return vf0Var;
    }

    public void c() {
        String str;
        com.taobao.android.dinamicx.eventchain.a aVar;
        try {
            if (wt.L0()) {
                if (this.f == null) {
                    return;
                }
                str = " List : size" + this.f.size();
                Iterator<WeakReference<com.taobao.android.dinamicx.eventchain.a>> it = this.f.iterator();
                if (it == null) {
                    return;
                }
                while (it.hasNext()) {
                    WeakReference<com.taobao.android.dinamicx.eventchain.a> next = it.next();
                    if (next != null && (aVar = next.get()) != null) {
                        aVar.b();
                    }
                }
            } else if (this.e == null) {
                return;
            } else {
                str = " map : size" + this.e.size();
                for (Map.Entry<com.taobao.android.dinamicx.eventchain.a, Integer> entry : this.e.entrySet()) {
                    if (entry != null && entry.getKey() != null) {
                        entry.getKey().b();
                    }
                }
            }
            DXAppMonitor.q(a(), null, "DX_EventChain", "DX_EventChain_Error", e.EVENTCHAIN_CONTEXT_SIZE, str);
        } catch (Throwable th) {
            s00.d("DXEventChainException", "", "cancel event chain error : " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public oy f(String str, String str2, com.taobao.android.dinamicx.eventchain.a aVar) {
        Object b;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && aVar != null) {
            aVar.K();
            if (str.startsWith("$(") && str.endsWith(jn1.BRACKET_END_STR)) {
                return g(str2, str.substring(2, str.length() - 1), aVar);
            }
            if (str.startsWith("$$(") && str.endsWith(jn1.BRACKET_END_STR)) {
                return h(str.substring(3, str.length() - 1), aVar);
            }
            if (str.startsWith(m80.DINAMIC_PREFIX_AT) && str.endsWith("}") && (b = aVar.n().b(str).b(null, aVar.l())) != null) {
                return f(b.toString(), str2, aVar);
            }
            return null;
        }
        return oy.b(ky.EVENT_CHAIN_ERROR_EXECUTE_CONTEXT_IS_NULL);
    }

    public h j() {
        return this.d;
    }

    public void k(com.taobao.android.dinamicx.eventchain.a aVar) {
        if (wt.L0()) {
            this.f.add(new WeakReference<>(aVar));
            s20.a(this.f);
            return;
        }
        this.e.put(aVar, Integer.valueOf(aVar.hashCode()));
    }

    public void l() {
        this.d.g();
    }
}
