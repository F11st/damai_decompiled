package com.taobao.android.dinamicx;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import tb.dt;
import tb.e00;
import tb.g00;
import tb.ry;
import tb.wt;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.i */
/* loaded from: classes12.dex */
public class C6382i {
    public static final int PIPELINE = 0;
    public static final int SIMPLE_PIPELINE = 1;
    protected dt a = new e00();

    private View a(DXWidgetNode dXWidgetNode) {
        WeakReference<View> wRView;
        if (dXWidgetNode == null || (wRView = dXWidgetNode.getWRView()) == null) {
            return null;
        }
        return wRView.get();
    }

    private void b(DXRuntimeContext dXRuntimeContext, DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2, View view, int i) {
        long nanoTime = System.nanoTime();
        DXTraceUtil.b(i == 0 ? "DX-Pipeline-RenderDetail(不含子节点)" : i == 1 ? "DX-SimplePipeline-RenderDetail(不含子节点" : "");
        if (dXRuntimeContext != null && dXRuntimeContext.isRefreshPart()) {
            if (dXWidgetNode.getStatInPrivateFlags(256)) {
                dXWidgetNode.setRealViewLayoutParam(view);
                dXWidgetNode.bindEvent(dXRuntimeContext.getContext());
                dXWidgetNode.setNeedRender(dXRuntimeContext.getContext());
                dXWidgetNode.unsetStatFlag(256);
                if (dXWidgetNode.getReferenceNode() != null) {
                    dXWidgetNode.getReferenceNode().unsetStatFlag(256);
                }
            }
        } else {
            dXWidgetNode.setRealViewLayoutParam(view);
            dXWidgetNode.bindEvent(dXRuntimeContext.getContext());
            dXWidgetNode.setNeedRender(dXRuntimeContext.getContext());
            if (DinamicXEngine.x()) {
                dXRuntimeContext.renderViewInfo += "render： " + dXWidgetNode.getClass().getSimpleName() + " time :" + (((float) (System.nanoTime() - nanoTime)) / 1000000.0f);
                dXRuntimeContext.countTime += ((float) (System.nanoTime() - nanoTime)) / 1000000.0f;
            }
        }
        DXTraceUtil.c();
        List<DXWidgetNode> children = dXWidgetNode.getChildren();
        if (children != null) {
            for (int i2 = 0; i2 < dXWidgetNode.getChildrenCount(); i2++) {
                c(dXRuntimeContext, children.get(i2), dXWidgetNode2, view, i2, i);
            }
        }
    }

    private void c(DXRuntimeContext dXRuntimeContext, DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2, View view, int i, int i2) {
        long nanoTime;
        String str;
        try {
            nanoTime = System.nanoTime();
            str = "";
            if (DXTraceUtil.e() && dXWidgetNode != null) {
                DXTraceUtil.b(i2 == 0 ? "DX-Pipeline-RenderFlatten" : i2 == 1 ? "DX-SimplePipeline-RenderFlatten" : "", "-", dXWidgetNode.getClass().getSimpleName());
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            View a = a(dXWidgetNode);
            if (a != null) {
                if (view == null) {
                    a.setTag(g00.a, dXWidgetNode2);
                }
                a.setTag(DXWidgetNode.TAG_WIDGET_NODE, dXWidgetNode);
                if (DinamicXEngine.x()) {
                    dXRuntimeContext.reuseCount++;
                    dXRuntimeContext.reuseCountTime += ((float) (System.nanoTime() - nanoTime)) / 1000000.0f;
                    dXRuntimeContext.createViewInfo += " reuse : " + a.getClass().getSimpleName() + " time : " + (((float) (System.nanoTime() - nanoTime)) / 1000000.0f);
                }
                b(dXRuntimeContext, dXWidgetNode, dXWidgetNode2, a, i2);
            } else {
                if (i2 == 0) {
                    str = "DX-Pipeline-CreateView";
                } else if (i2 == 1) {
                    str = "DX-SimplePipeline-CreateView";
                }
                DXTraceUtil.b(str, "-", dXWidgetNode.getClass().getSimpleName());
                View createView = dXWidgetNode.createView(dXRuntimeContext.getContext());
                DXTraceUtil.c();
                if (createView == null && wt.j0(dXWidgetNode)) {
                    return;
                }
                if (view == null) {
                    createView.setTag(g00.a, dXWidgetNode2);
                }
                if (DinamicXEngine.x()) {
                    dXRuntimeContext.createCount++;
                    dXRuntimeContext.reCountTime += ((float) (System.nanoTime() - nanoTime)) / 1000000.0f;
                    dXRuntimeContext.createViewInfo += " create : " + createView.getClass().getSimpleName() + " time : " + (((float) (System.nanoTime() - nanoTime)) / 1000000.0f);
                }
                b(dXRuntimeContext, dXWidgetNode, dXWidgetNode2, createView, i2);
                if (view != null && (view instanceof ViewGroup)) {
                    if (wt.l0()) {
                        if (i <= ((ViewGroup) view).getChildCount()) {
                            ((ViewGroup) view).addView(createView, i);
                        } else {
                            ((ViewGroup) view).addView(createView);
                            DXAppMonitor.q(dXRuntimeContext.getBizType(), dXRuntimeContext.getDxTemplateItem(), "Render", "RENDER_ERROR", C6368e.DX_ADD_VIEW_ERROR, "renderManager addView error");
                        }
                    } else {
                        ((ViewGroup) view).addView(createView, i);
                    }
                }
            }
            DXTraceUtil.c();
        } catch (Throwable th2) {
            th = th2;
            if (dXRuntimeContext != null && dXRuntimeContext.getDxError() != null && dXRuntimeContext.getDxError().c != null) {
                C6368e.C6369a c6369a = new C6368e.C6369a("Render", "Render_Fltten_Crash", C6368e.DXERROR_RENDER_FLATTEN);
                c6369a.e = ry.a(th);
                dXRuntimeContext.getDxError().c.add(c6369a);
            }
            ry.b(th);
            DXTraceUtil.c();
        }
    }

    private void e(DXRuntimeContext dXRuntimeContext, String str, long j, Map<String, String> map) {
        try {
            DXAppMonitor.s(3, dXRuntimeContext.config.a, "Pipeline_Detail_Render_Detail", str, dXRuntimeContext.getDxTemplateItem(), map, j, true);
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public View d(DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2, View view, DXRuntimeContext dXRuntimeContext, int i) {
        String str = null;
        if (dXWidgetNode == null || dXWidgetNode2 == null || view == null) {
            return null;
        }
        try {
            int i2 = DXWidgetNode.TAG_WIDGET_NODE;
            DXWidgetNode dXWidgetNode3 = (DXWidgetNode) view.getTag(i2);
            long nanoTime = System.nanoTime();
            if (i == 0) {
                str = "DX-Pipeline-RenderWt-diff";
            } else if (i == 1) {
                str = "DX-SimplePipeline-RenderWt-diff";
            }
            DXTraceUtil.b(str);
            try {
                this.a.a(dXWidgetNode2, dXWidgetNode3);
                long nanoTime2 = System.nanoTime() - nanoTime;
                e(dXRuntimeContext, "Detail_RenderWidget_Diff", nanoTime2, DXAppMonitor.g((float) nanoTime2));
                DXTraceUtil.c();
                dXWidgetNode2.setWRView(new WeakReference<>(view));
                long nanoTime3 = System.nanoTime();
                c(dXRuntimeContext, dXWidgetNode2, dXWidgetNode, null, 0, i);
                if (dXWidgetNode2.getAccessibility() == 3) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        view.setImportantForAccessibility(1);
                    }
                } else if (Build.VERSION.SDK_INT >= 16) {
                    view.setImportantForAccessibility(2);
                }
                view.setTag(i2, dXWidgetNode2);
                if (dXWidgetNode3 != null && dXWidgetNode3.getParentWidget() != null) {
                    dXWidgetNode3.getParentWidget().replaceChild(dXWidgetNode2, dXWidgetNode3);
                }
                long nanoTime4 = System.nanoTime() - nanoTime3;
                e(dXRuntimeContext, "Detail_RenderWidget_Recursion_Render_WT", nanoTime4, DXAppMonitor.g((float) nanoTime4));
                if (DinamicXEngine.x()) {
                    dXRuntimeContext.getDxPerformInfo().h = dXRuntimeContext.createViewInfo;
                    dXRuntimeContext.getDxPerformInfo().i = dXRuntimeContext.renderViewInfo;
                    dXRuntimeContext.getDxPerformInfo().l = dXRuntimeContext.reuseCount;
                    dXRuntimeContext.getDxPerformInfo().k = dXRuntimeContext.createCount;
                }
            } catch (Exception e) {
                e = e;
                ry.b(e);
                if (dXRuntimeContext != null && dXRuntimeContext.getDxError() != null && dXRuntimeContext.getDxError().c != null) {
                    C6368e.C6369a c6369a = new C6368e.C6369a("Pipeline_Detail", "Pipeline_Detail_Render_Detail", 90001);
                    c6369a.e = "DXLayoutManager#renderWidget " + ry.a(e);
                    dXRuntimeContext.getDxError().c.add(c6369a);
                }
                return view;
            }
        } catch (Exception e2) {
            e = e2;
        }
        return view;
    }
}
