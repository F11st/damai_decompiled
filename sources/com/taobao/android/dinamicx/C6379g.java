package com.taobao.android.dinamicx;

import android.view.View;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.widget.C6489d;
import com.taobao.android.dinamicx.widget.C6493f;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.ry;
import tb.z00;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.g */
/* loaded from: classes12.dex */
public class C6379g {
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.taobao.android.dinamicx.widget.DXWidgetNode r26, int r27, int r28, int r29, int r30, com.taobao.android.dinamicx.widget.DXWidgetNode r31, boolean r32, boolean r33, boolean r34, int r35, float r36) {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.C6379g.a(com.taobao.android.dinamicx.widget.DXWidgetNode, int, int, int, int, com.taobao.android.dinamicx.widget.DXWidgetNode, boolean, boolean, boolean, int, float):void");
    }

    private boolean e(int i) {
        return View.MeasureSpec.getMode(i) == 0 && View.MeasureSpec.getSize(i) == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C6489d b(DXWidgetNode dXWidgetNode, DXRuntimeContext dXRuntimeContext, boolean z) {
        C6489d c6489d = null;
        if (dXWidgetNode == null) {
            return null;
        }
        try {
            C6489d c6489d2 = new C6489d();
            try {
                c6489d2.setFlatten(true);
                c6489d2.setReferenceNode(c6489d2);
                c6489d2.setDXRuntimeContext(dXRuntimeContext.cloneWithWidgetNode(c6489d2));
                if (dXWidgetNode.getVisibility() != 0) {
                    c6489d2.setMeasuredDimension(0, 0);
                    return c6489d2;
                }
                c6489d2.setLayoutWidth(dXWidgetNode.getLayoutWidth());
                c6489d2.setLayoutHeight(dXWidgetNode.getLayoutHeight());
                c6489d2.setMeasuredDimension(dXWidgetNode.getMeasuredWidthAndState(), dXWidgetNode.getMeasuredHeightAndState());
                c6489d2.setStatFlag(256);
                a(dXWidgetNode, 0, 0, dXWidgetNode.getMeasuredWidth(), dXWidgetNode.getMeasuredHeight(), c6489d2, false, false, z, 1, 1.0f);
                return c6489d2;
            } catch (Exception e) {
                e = e;
                c6489d = c6489d2;
                if (DinamicXEngine.x()) {
                    e.printStackTrace();
                }
                if (dXRuntimeContext != null && dXRuntimeContext.getDxError() != null && dXRuntimeContext.getDxError().c != null) {
                    C6368e.C6369a c6369a = new C6368e.C6369a("Pipeline_Detail", "Pipeline_Detail_PerformFlatten", 80004);
                    c6369a.e = "DXLayoutManager#performFlatten " + ry.a(e);
                    dXRuntimeContext.getDxError().c.add(c6369a);
                }
                return c6489d;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(DXWidgetNode dXWidgetNode, DXRuntimeContext dXRuntimeContext) {
        if (dXWidgetNode == null) {
            return;
        }
        try {
            if (dXWidgetNode.getVisibility() == 0) {
                dXWidgetNode.layout(0, 0, dXWidgetNode.getMeasuredWidth(), dXWidgetNode.getMeasuredHeight());
            }
        } catch (Exception e) {
            if (DinamicXEngine.x()) {
                e.printStackTrace();
            }
            if (dXRuntimeContext == null || dXRuntimeContext.getDxError() == null || dXRuntimeContext.getDxError().c == null) {
                return;
            }
            C6368e.C6369a c6369a = new C6368e.C6369a("Pipeline_Detail", "Pipeline_Detail_PerformLayout", 80003);
            c6369a.e = "DXLayoutManager#performLayout " + ry.a(e);
            dXRuntimeContext.getDxError().c.add(c6369a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(DXWidgetNode dXWidgetNode, int i, int i2, DXRuntimeContext dXRuntimeContext) {
        if (dXWidgetNode != null) {
            try {
                if (dXWidgetNode instanceof C6493f) {
                    if (e(i)) {
                        i = z00.f();
                    }
                    if (e(i2)) {
                        i2 = z00.e();
                    }
                    int childMeasureSpec = C6493f.getChildMeasureSpec(i, 0, dXWidgetNode.getLayoutWidth());
                    int childMeasureSpec2 = C6493f.getChildMeasureSpec(i2, 0, dXWidgetNode.getLayoutHeight());
                    if (dXWidgetNode.getVisibility() == 0) {
                        dXWidgetNode.measure(childMeasureSpec, childMeasureSpec2);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                if (DinamicXEngine.x()) {
                    e.printStackTrace();
                }
                if (dXRuntimeContext == null || dXRuntimeContext.getDxError() == null || dXRuntimeContext.getDxError().c == null) {
                    return;
                }
                C6368e.C6369a c6369a = new C6368e.C6369a("Pipeline_Detail", "Pipeline_Detail_PerformMeasure", 80002);
                c6369a.e = "DXLayoutManager#performMeasure" + ry.a(e);
                dXRuntimeContext.getDxError().c.add(c6369a);
                return;
            }
        }
        C6368e.C6369a c6369a2 = new C6368e.C6369a("Pipeline_Detail", "Pipeline_Detail_PerformMeasure", 80001);
        c6369a2.e = "DXLayoutManager#performMeasure widgetNode == null || !(widgetNode instanceof DXLayout)";
        dXRuntimeContext.getDxError().c.add(c6369a2);
    }
}
