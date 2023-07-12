package com.taobao.android.dinamicx;

import android.view.View;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.ry;
import tb.z00;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class g {
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
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.g.a(com.taobao.android.dinamicx.widget.DXWidgetNode, int, int, int, int, com.taobao.android.dinamicx.widget.DXWidgetNode, boolean, boolean, boolean, int, float):void");
    }

    private boolean e(int i) {
        return View.MeasureSpec.getMode(i) == 0 && View.MeasureSpec.getSize(i) == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.taobao.android.dinamicx.widget.d b(DXWidgetNode dXWidgetNode, DXRuntimeContext dXRuntimeContext, boolean z) {
        com.taobao.android.dinamicx.widget.d dVar = null;
        if (dXWidgetNode == null) {
            return null;
        }
        try {
            com.taobao.android.dinamicx.widget.d dVar2 = new com.taobao.android.dinamicx.widget.d();
            try {
                dVar2.setFlatten(true);
                dVar2.setReferenceNode(dVar2);
                dVar2.setDXRuntimeContext(dXRuntimeContext.cloneWithWidgetNode(dVar2));
                if (dXWidgetNode.getVisibility() != 0) {
                    dVar2.setMeasuredDimension(0, 0);
                    return dVar2;
                }
                dVar2.setLayoutWidth(dXWidgetNode.getLayoutWidth());
                dVar2.setLayoutHeight(dXWidgetNode.getLayoutHeight());
                dVar2.setMeasuredDimension(dXWidgetNode.getMeasuredWidthAndState(), dXWidgetNode.getMeasuredHeightAndState());
                dVar2.setStatFlag(256);
                a(dXWidgetNode, 0, 0, dXWidgetNode.getMeasuredWidth(), dXWidgetNode.getMeasuredHeight(), dVar2, false, false, z, 1, 1.0f);
                return dVar2;
            } catch (Exception e) {
                e = e;
                dVar = dVar2;
                if (DinamicXEngine.x()) {
                    e.printStackTrace();
                }
                if (dXRuntimeContext != null && dXRuntimeContext.getDxError() != null && dXRuntimeContext.getDxError().c != null) {
                    e.a aVar = new e.a("Pipeline_Detail", "Pipeline_Detail_PerformFlatten", 80004);
                    aVar.e = "DXLayoutManager#performFlatten " + ry.a(e);
                    dXRuntimeContext.getDxError().c.add(aVar);
                }
                return dVar;
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
            e.a aVar = new e.a("Pipeline_Detail", "Pipeline_Detail_PerformLayout", 80003);
            aVar.e = "DXLayoutManager#performLayout " + ry.a(e);
            dXRuntimeContext.getDxError().c.add(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(DXWidgetNode dXWidgetNode, int i, int i2, DXRuntimeContext dXRuntimeContext) {
        if (dXWidgetNode != null) {
            try {
                if (dXWidgetNode instanceof com.taobao.android.dinamicx.widget.f) {
                    if (e(i)) {
                        i = z00.f();
                    }
                    if (e(i2)) {
                        i2 = z00.e();
                    }
                    int childMeasureSpec = com.taobao.android.dinamicx.widget.f.getChildMeasureSpec(i, 0, dXWidgetNode.getLayoutWidth());
                    int childMeasureSpec2 = com.taobao.android.dinamicx.widget.f.getChildMeasureSpec(i2, 0, dXWidgetNode.getLayoutHeight());
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
                e.a aVar = new e.a("Pipeline_Detail", "Pipeline_Detail_PerformMeasure", 80002);
                aVar.e = "DXLayoutManager#performMeasure" + ry.a(e);
                dXRuntimeContext.getDxError().c.add(aVar);
                return;
            }
        }
        e.a aVar2 = new e.a("Pipeline_Detail", "Pipeline_Detail_PerformMeasure", 80001);
        aVar2.e = "DXLayoutManager#performMeasure widgetNode == null || !(widgetNode instanceof DXLayout)";
        dXRuntimeContext.getDxError().c.add(aVar2);
    }
}
