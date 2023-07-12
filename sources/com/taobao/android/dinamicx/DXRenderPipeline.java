package com.taobao.android.dinamicx;

import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRenderOptions;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.model.DXLongSparseArray;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.notification.DXNotificationCenter;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode;
import com.taobao.android.dinamicx.widget.event.IDXControlEventListener;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import tb.au;
import tb.bu;
import tb.f00;
import tb.jn1;
import tb.kt;
import tb.nz;
import tb.ry;
import tb.s00;
import tb.s10;
import tb.t00;
import tb.wt;
import tb.y00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXRenderPipeline extends DXRenderPipelineBase implements IDXControlEventListener {
    public static final String DATA_PARSE_TIME = "dataParseTime";
    public static final String FLATTEN_TIME = "flattenTime";
    public static final String LAYOUT_TIME = "layoutTime";
    public static final String LOAD_BINARY_TIME = "loadBinaryTime";
    public static final String MEASURE_TIME = "measureTime";
    public static final String RENDER_TIME = "renderTime";
    DXNotificationCenter f;
    l g;
    g h;
    i i;
    DXTemplateManager j;
    WeakReference<bu> k;
    WeakReference<h> l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DXRenderPipeline(d dVar, DXTemplateManager dXTemplateManager) {
        super(dVar);
        this.g = new l();
        this.h = new g();
        this.i = new i();
        DinamicXEngine e = dVar.e();
        if (e == null) {
            return;
        }
        this.f = e.l;
        this.j = dXTemplateManager;
        this.k = new WeakReference<>(e.k);
        this.l = new WeakReference<>(e.m);
        o();
    }

    private boolean f(DXRenderOptions dXRenderOptions) {
        return dXRenderOptions.e() == 1 && dXRenderOptions.i();
    }

    private void g(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext != null) {
            try {
                if (dXRuntimeContext.getOpenTracerSpan() != null) {
                    dXRuntimeContext.getOpenTracerSpan().dataParseStart(Long.valueOf(System.currentTimeMillis()));
                }
            } catch (Throwable th) {
                ry.b(th);
            }
        }
    }

    private void h(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null) {
            return;
        }
        try {
            DXTemplateItem dxTemplateItem = dXRuntimeContext.getDxTemplateItem();
            DXEngineConfig dXEngineConfig = this.a;
            if (dXEngineConfig == null || dXEngineConfig.e || k() == null || dxTemplateItem == null) {
                return;
            }
            k().e(dxTemplateItem);
            n(dXRuntimeContext, 1000);
        } catch (Exception e) {
            if (DinamicXEngine.x()) {
                e.printStackTrace();
            }
        }
    }

    private boolean l(e eVar) {
        List<e.a> list;
        if (wt.x0(this.b) && eVar != null && (list = eVar.c) != null && !list.isEmpty()) {
            for (e.a aVar : eVar.c) {
                if (aVar.d == 80001) {
                    return true;
                }
            }
        }
        return false;
    }

    private String m(DXLongSparseArray<IDXBuilderWidgetNode> dXLongSparseArray) {
        if (dXLongSparseArray == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < dXLongSparseArray.size(); i++) {
            jSONObject.put(String.valueOf(dXLongSparseArray.keyAt(i)), (Object) dXLongSparseArray.valueAt(i).getClass().getName());
        }
        return jSONObject.toJSONString();
    }

    private void n(DXRuntimeContext dXRuntimeContext, int i) {
        if (this.f == null || dXRuntimeContext == null) {
            return;
        }
        s10 s10Var = new s10();
        s10Var.a = dXRuntimeContext.dxTemplateItem;
        s10Var.d = dXRuntimeContext.getDxUserContext();
        s10Var.b = dXRuntimeContext.getData();
        s10Var.c = i;
        this.f.f(s10Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(au auVar) {
        DXWidgetNode dXWidgetNode;
        DXRuntimeContext dXRuntimeContext;
        DXRootView rootView;
        if (auVar == null || !(auVar instanceof f00)) {
            return;
        }
        f00 f00Var = (f00) auVar;
        Object obj = auVar.a;
        if ((obj instanceof DXWidgetNode) && (dXWidgetNode = (DXWidgetNode) obj) != null && (dXRuntimeContext = dXWidgetNode.getDXRuntimeContext()) != null && dXRuntimeContext.renderType == 0 && (rootView = dXRuntimeContext.getRootView()) != null && dXRuntimeContext.dxTemplateItem.equals(rootView.dxTemplateItem) && dXRuntimeContext.getData() == rootView.data) {
            DXRuntimeContext cloneWithWidgetNode = dXWidgetNode.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode);
            cloneWithWidgetNode.refreshType = f00Var.e;
            DXRenderOptions k = new DXRenderOptions.b().o(true).l(f00Var.d).u(dXRuntimeContext.getRootWidthSpec()).m(dXRuntimeContext.getRootHeightSpec()).s(8).k();
            if (cloneWithWidgetNode.isRefreshPart()) {
                dXWidgetNode.updateRefreshType(1);
            }
            r(dXWidgetNode, rootView.getFlattenWidgetNode(), rootView, cloneWithWidgetNode, k);
        }
    }

    private void s(DXRootView dXRootView) {
        try {
            kt bindingXManager = dXRootView.getBindingXManager();
            if (bindingXManager != null) {
                bindingXManager.t(dXRootView);
            }
        } catch (Exception e) {
            ry.b(e);
            e eVar = new e(a());
            eVar.c.add(new e.a("Pipeline", "Pipeline_Stage_Reset_Bindingx", e.RESET_ANIMATION_CRASH, ry.a(e)));
            DXAppMonitor.n(eVar);
        }
    }

    private void t(DXRuntimeContext dXRuntimeContext, String str, long j) {
        if (dXRuntimeContext != null) {
            try {
                if (dXRuntimeContext.getOpenTracerSpan() != null) {
                    dXRuntimeContext.getOpenTracerSpan().setTag(str, Float.valueOf(((float) (System.nanoTime() - j)) / 1000000.0f));
                }
            } catch (Throwable th) {
                ry.b(th);
            }
        }
    }

    private void u(e eVar, String str, int i, String str2, Map<String, String> map, boolean z) {
        if (eVar == null || eVar.c == null) {
            return;
        }
        e.a aVar = new e.a("Pipeline", str, i);
        aVar.e = str2;
        aVar.f = map;
        eVar.c.add(aVar);
        if (z) {
            DXAppMonitor.n(eVar);
        }
    }

    private void w(DXRuntimeContext dXRuntimeContext, DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2, DXWidgetNode dXWidgetNode3) {
        if (dXRuntimeContext != null && l(dXRuntimeContext.getDxError())) {
            String name = Thread.currentThread().getName();
            if (dXWidgetNode != null) {
                String treeInfo = dXWidgetNode.toTreeInfo();
                s00.b(jn1.L + this.b + "|" + name + "> originTree: " + treeInfo);
                if (DinamicXEngine.x()) {
                    nz.i("ReportMeasureFlattenError", "originTree: " + treeInfo);
                }
            }
            if (dXWidgetNode2 != null) {
                String treeInfo2 = dXWidgetNode2.toTreeInfo();
                s00.b(jn1.L + this.b + "|" + name + "> deepCloneOriginTree: " + treeInfo2);
                if (DinamicXEngine.x()) {
                    nz.i("ReportMeasureFlattenError", "deepCloneOriginTree: " + treeInfo2);
                }
            }
            if (dXWidgetNode3 != null) {
                String treeInfo3 = dXWidgetNode3.toTreeInfo();
                s00.b(jn1.L + this.b + "|" + name + "> parsedTree: " + treeInfo3);
                if (DinamicXEngine.x()) {
                    nz.i("ReportMeasureFlattenError", "parsedTree: " + treeInfo3);
                }
            }
            String m = m(dXRuntimeContext.widgetNodeMap);
            if (TextUtils.isEmpty(m)) {
                return;
            }
            s00.b(jn1.L + this.b + "|" + name + "> widgetNodeMapInfo: " + m);
            if (DinamicXEngine.x()) {
                nz.i("ReportMeasureFlattenError", "widgetNodeMapInfo: " + m);
            }
        }
    }

    private void x(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext != null) {
            try {
                if (dXRuntimeContext.getOpenTracerSpan() != null) {
                    dXRuntimeContext.getOpenTracerSpan().viewRenderEnd(Long.valueOf(System.currentTimeMillis()));
                }
            } catch (Throwable th) {
                ry.b(th);
            }
        }
    }

    private void y(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext != null) {
            try {
                if (dXRuntimeContext.getOpenTracerSpan() != null) {
                    dXRuntimeContext.getOpenTracerSpan().viewRenderStart(Long.valueOf(System.currentTimeMillis()));
                }
            } catch (Throwable th) {
                ry.b(th);
            }
        }
    }

    public bu i() {
        return this.k.get();
    }

    public h j() {
        return this.l.get();
    }

    public DXTemplateManager k() {
        return this.j;
    }

    void o() {
        bu i = i();
        if (i != null) {
            i.c(this, f00.DX_EVENT_PIPELINE_SCHEDULE);
        }
    }

    public t00<DXRootView> q(DXRootView dXRootView, DXRuntimeContext dXRuntimeContext, int i, DXRenderOptions dXRenderOptions) {
        if (dXRootView == null) {
            return null;
        }
        s00.b("开始渲染 tpl: " + dXRuntimeContext.getTemplateId() + " renderType: " + dXRenderOptions.e() + " isControlEvent: " + dXRenderOptions.j());
        s(dXRootView);
        dXRootView.data = dXRuntimeContext.getData();
        dXRootView.setPosition(i);
        dXRootView.parentWidthSpec = dXRenderOptions.h();
        dXRootView.parentHeightSpec = dXRenderOptions.b();
        dXRootView.dxTemplateItem = dXRuntimeContext.getDxTemplateItem();
        View r = r(null, dXRootView.getFlattenWidgetNode(), dXRootView, dXRuntimeContext, dXRenderOptions);
        t00<DXRootView> t00Var = new t00<>();
        if (r != null && (r instanceof DXRootView)) {
            t00Var.f((DXRootView) r);
        }
        t00Var.d(dXRuntimeContext.getDxError());
        return t00Var;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:(8:(3:237|238|(21:240|241|242|243|196|197|199|200|201|202|203|(2:221|222)|205|206|207|208|(1:212)|213|214|215|53))|207|208|(2:210|212)|213|214|215|53)|196|197|199|200|201|202|203|(0)|205|206) */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x084b, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x084c, code lost:
        r2 = r48;
        r3 = r4;
        r13 = r7;
        r5 = r3;
        r10 = r1;
        r14 = r49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x085d, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x085e, code lost:
        r2 = r48;
        r3 = r4;
        r13 = r7;
        r5 = r3;
        r10 = r1;
        r4 = r53;
        r15 = r56;
        r14 = r49;
        r12 = r2;
        r7 = r54;
     */
    /* JADX WARN: Removed duplicated region for block: B:255:0x094c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0963 A[Catch: all -> 0x0976, TryCatch #7 {all -> 0x0976, blocks: (B:257:0x0950, B:261:0x095c, B:263:0x0963, B:265:0x0969, B:268:0x0971), top: B:375:0x0950 }] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x098c  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0a3a  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0a9a  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0b42  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x07ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:417:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View r(com.taobao.android.dinamicx.widget.DXWidgetNode r66, com.taobao.android.dinamicx.widget.DXWidgetNode r67, android.view.View r68, com.taobao.android.dinamicx.DXRuntimeContext r69, com.taobao.android.dinamicx.DXRenderOptions r70) {
        /*
            Method dump skipped, instructions count: 3114
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.DXRenderPipeline.r(com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, android.view.View, com.taobao.android.dinamicx.DXRuntimeContext, com.taobao.android.dinamicx.DXRenderOptions):android.view.View");
    }

    @Override // com.taobao.android.dinamicx.widget.event.IDXControlEventListener
    public void receivedControlEvent(final au auVar) {
        if ((auVar instanceof f00 ? ((f00) auVar).f : false) && Thread.currentThread() == Looper.getMainLooper().getThread()) {
            p(auVar);
            return;
        }
        y00.d();
        y00.m(new Runnable() { // from class: com.taobao.android.dinamicx.DXRenderPipeline.1
            @Override // java.lang.Runnable
            public void run() {
                DXRenderPipeline.this.p(auVar);
            }
        });
    }

    protected void v(DXRuntimeContext dXRuntimeContext, String str, long j, Map<String, String> map) {
        try {
            if (map != null) {
                map.putAll(DXAppMonitor.g((float) j));
            } else {
                map = DXAppMonitor.g((float) j);
            }
            DXAppMonitor.s(1, dXRuntimeContext.bizType, "Pipeline", str, dXRuntimeContext.getDxTemplateItem(), map, j, true);
        } catch (Exception e) {
            if (DinamicXEngine.x()) {
                e.printStackTrace();
            }
        }
    }
}
