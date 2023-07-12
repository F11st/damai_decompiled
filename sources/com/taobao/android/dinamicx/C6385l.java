package com.taobao.android.dinamicx;

import android.content.Context;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.ry;
import tb.z00;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.l */
/* loaded from: classes12.dex */
public class C6385l {
    private void a(Context context, DXWidgetNode dXWidgetNode, long j, Object obj) {
        dXWidgetNode.setIntAttribute(j, z00.j(context, String.valueOf(obj), dXWidgetNode.getDefaultValueForIntAttr(j)));
    }

    /* JADX WARN: Removed duplicated region for block: B:197:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x052c A[LOOP:1: B:209:0x0526->B:211:0x052c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a9 A[Catch: Exception -> 0x00fb, TryCatch #5 {Exception -> 0x00fb, blocks: (B:45:0x00a5, B:47:0x00a9, B:49:0x00b3, B:51:0x00bd, B:53:0x00cd, B:56:0x00eb, B:57:0x00f3), top: B:225:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f3 A[Catch: Exception -> 0x00fb, TRY_LEAVE, TryCatch #5 {Exception -> 0x00fb, blocks: (B:45:0x00a5, B:47:0x00a9, B:49:0x00b3, B:51:0x00bd, B:53:0x00cd, B:56:0x00eb, B:57:0x00f3), top: B:225:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0199  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0105 -> B:224:0x0116). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(com.taobao.android.dinamicx.widget.DXWidgetNode r23, com.taobao.android.dinamicx.DXRuntimeContext r24) {
        /*
            Method dump skipped, instructions count: 1351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.C6385l.c(com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.DXRuntimeContext):void");
    }

    private void d(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setDoubleAttribute(j, dXWidgetNode.getDefaultValueForDoubleAttr(j));
    }

    private void e(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setIntAttribute(j, dXWidgetNode.getDefaultValueForIntAttr(j));
    }

    private void f(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setListAttribute(j, dXWidgetNode.getDefaultValueForListAttr(j));
    }

    private void g(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setLongAttribute(j, dXWidgetNode.getDefaultValueForLongAttr(j));
    }

    private void h(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setMapAttribute(j, dXWidgetNode.getDefaultValueForMapAttr(j));
    }

    @Deprecated
    public DXWidgetNode b(DXWidgetNode dXWidgetNode, DXRuntimeContext dXRuntimeContext) {
        try {
            c(dXWidgetNode, dXRuntimeContext);
            return dXWidgetNode;
        } catch (Exception e) {
            ry.b(e);
            dXRuntimeContext.getDxError().c.add(new C6368e.C6369a("Pipeline", "Pipeline_Stage_Load_Binary", C6368e.DXERROR_PIPELINE_PARSE_WT_EXCEPTION, ry.a(e)));
            return null;
        }
    }
}
