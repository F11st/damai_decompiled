package com.taobao.android.dinamicx.eventchain;

import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.taobao.android.dinamicx.monitor.RuntimeProfilingInfoCollector;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import tb.az;
import tb.hy;
import tb.my;
import tb.nz;
import tb.oy;
import tb.ry;
import tb.uf0;
import tb.wt;
import tb.y00;
import tb.z10;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXEventChainEventHandler extends com.taobao.android.dinamicx.a {
    public static final long DX_EVENT_EVENTCHAIN = -812009131795779670L;
    private static final AtomicInteger b = new AtomicInteger(0);
    DXEventChainCallback a;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface DXEventChainCallback {
        void eventChainCallBack(oy oyVar);
    }

    private static void e(String str, a aVar, String str2, hy hyVar) {
        if (DinamicXEngine.x()) {
            int incrementAndGet = b.incrementAndGet();
            DXTemplateItem dXTemplateItem = null;
            if (aVar != null) {
                aVar.v();
                DXRuntimeContext l = aVar.l();
                if (l != null) {
                    dXTemplateItem = l.getDxTemplateItem();
                }
            }
            uf0 uf0Var = new uf0(incrementAndGet, str, dXTemplateItem, str2, hyVar);
            if (aVar != null) {
                aVar.B(uf0Var);
            }
            RuntimeProfilingInfoCollector.c().e(uf0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(hy hyVar, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        DXWidgetNode queryRootWidgetNode;
        Map<String, az> a;
        if (objArr != null && objArr.length != 0 && !TextUtils.isEmpty(objArr[0].toString())) {
            if (dXRuntimeContext != null && dXRuntimeContext.getEngineContext() != null && dXRuntimeContext.getEngineContext().e() != null && dXRuntimeContext.getEngineContext().e().o() != null) {
                a aVar = null;
                try {
                    z10 d = d(hyVar, objArr, dXRuntimeContext);
                    d.e(dXRuntimeContext.getContext());
                    d.g(dXRuntimeContext.getNativeView());
                    String obj = objArr[0].toString();
                    Object obj2 = objArr.length > 1 ? objArr[1] : null;
                    DXTraceUtil.a(2, "DX-EventChain-Start", " : ", obj);
                    b o = dXRuntimeContext.getEngineContext().e().o();
                    a aVar2 = new a();
                    try {
                        aVar2.I(dXRuntimeContext.getNativeView());
                        aVar2.A(dXRuntimeContext);
                        aVar2.w(d);
                        aVar2.z(o);
                        if (wt.M0() && objArr.length == 3) {
                            Object obj3 = objArr[2];
                            if (obj3 instanceof DXWidgetNode) {
                                aVar2.C(((DXWidgetNode) obj3).getDxEventChains());
                                aVar2.G(true);
                            }
                        } else if (wt.M0() && dXRuntimeContext.getWidgetNode() == null && (queryRootWidgetNode = dXRuntimeContext.getWidgetNode().queryRootWidgetNode()) != null) {
                            aVar2.C(queryRootWidgetNode.getDxEventChains());
                        }
                        d.d(o.j());
                        d.i(dXRuntimeContext.getRootView());
                        d.j(dXRuntimeContext.getWidgetNode());
                        o.k(aVar2);
                        JSONObject jSONObject = new JSONObject();
                        if (hyVar != null && (a = hyVar.a()) != null) {
                            for (Map.Entry<String, az> entry : a.entrySet()) {
                                jSONObject.put(entry.getKey(), entry.getValue().s());
                            }
                        }
                        my myVar = new my();
                        myVar.f(d);
                        myVar.h(obj2);
                        myVar.i(jSONObject);
                        myVar.g(hyVar);
                        dXRuntimeContext.setEventChainExpressionSourceContext(myVar);
                        aVar2.E(myVar);
                        if (DinamicXEngine.x()) {
                            e(obj, aVar2, dXRuntimeContext.getWidgetNode() != null ? dXRuntimeContext.getWidgetNode().getClass().getName() : null, hyVar);
                        }
                        aVar2.D(obj);
                        c(obj, aVar2);
                        oy f = o.f("$(main)", obj, aVar2);
                        DXEventChainCallback dXEventChainCallback = this.a;
                        if (dXEventChainCallback != null) {
                            dXEventChainCallback.eventChainCallBack(f);
                        }
                        b(obj, f, aVar2);
                        DXTraceUtil.d(2);
                    } catch (Throwable th) {
                        th = th;
                        aVar = aVar2;
                        e.a aVar3 = new e.a("DX_EventChain", "DX_EventChain_Crash", e.EVENTCHAIN_EXECUTE_CRASH);
                        aVar3.e = ry.a(th);
                        dXRuntimeContext.getDxError().c.add(aVar3);
                        if (DinamicXEngine.x()) {
                            b.d(aVar != null ? aVar.s() : -1, oy.a(-1, th.getMessage()), aVar);
                        }
                        ry.b(th);
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                nz.g("DXEventChainEventHandler", "dx evnetchain handle error : Missing the necessary parameters(eventChainManage)");
            }
        } else {
            nz.g("DXEventChainEventHandler", "dx evnetchain handle error : Missing the necessary parameters（args）");
        }
    }

    protected void b(String str, oy oyVar, a aVar) {
    }

    protected void c(String str, a aVar) {
    }

    protected z10 d(hy hyVar, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        return new z10();
    }

    @Override // com.taobao.android.dinamicx.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "dxEventHandler";
    }

    @Override // com.taobao.android.dinamicx.IDXEventHandler
    public void handleEvent(final hy hyVar, final Object[] objArr, final DXRuntimeContext dXRuntimeContext) {
        if (wt.U()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                f(hyVar, objArr, dXRuntimeContext);
                return;
            } else {
                y00.m(new Runnable() { // from class: com.taobao.android.dinamicx.eventchain.DXEventChainEventHandler.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DXEventChainEventHandler.this.f(hyVar, objArr, dXRuntimeContext);
                    }
                });
                return;
            }
        }
        f(hyVar, objArr, dXRuntimeContext);
    }
}
