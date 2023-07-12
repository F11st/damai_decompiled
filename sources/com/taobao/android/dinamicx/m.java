package com.taobao.android.dinamicx;

import android.content.Context;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.ry;
import tb.z00;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class m {
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092 A[Catch: Exception -> 0x00de, TryCatch #0 {Exception -> 0x00de, blocks: (B:32:0x008e, B:34:0x0092, B:36:0x009c, B:38:0x00a6, B:40:0x00b6, B:41:0x00ce, B:42:0x00d6), top: B:56:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d6 A[Catch: Exception -> 0x00de, TRY_LEAVE, TryCatch #0 {Exception -> 0x00de, blocks: (B:32:0x008e, B:34:0x0092, B:36:0x009c, B:38:0x00a6, B:40:0x00b6, B:41:0x00ce, B:42:0x00d6), top: B:56:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0107 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00e8 -> B:55:0x00fd). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.taobao.android.dinamicx.widget.DXWidgetNode r13) {
        /*
            java.lang.String r0 = "Pipeline_Stage_Load_Binary"
            java.lang.String r1 = "Pipeline"
            boolean r2 = tb.wt.h0()
            r3 = 5802348655878590802(0x5086155c409bd152, double:8.182680092428053E79)
            r5 = 1
            r6 = 2
            if (r2 == 0) goto L28
            int r2 = r13.getVisibility()
            if (r2 != r6) goto L2f
            androidx.collection.LongSparseArray r2 = r13.getDataParsersExprNode()
            if (r2 == 0) goto L2f
            androidx.collection.LongSparseArray r2 = r13.getDataParsersExprNode()
            java.lang.Object r2 = r2.get(r3)
            if (r2 != 0) goto L2f
            return r5
        L28:
            int r2 = r13.getVisibility()
            if (r2 != r6) goto L2f
            return r5
        L2f:
            androidx.collection.LongSparseArray r2 = r13.getDataParsersExprNode()
            r7 = 0
            if (r2 != 0) goto L37
            return r7
        L37:
            r2 = 2048(0x800, float:2.87E-42)
            boolean r8 = r13.getStatInPrivateFlags(r2)
            if (r8 != 0) goto L100
            androidx.collection.LongSparseArray r8 = r13.getDataParsersExprNode()
            java.lang.Object r8 = r8.get(r3)
            if (r8 == 0) goto Lfd
            androidx.collection.LongSparseArray r8 = r13.getDataParsersExprNode()
            java.lang.Object r8 = r8.get(r3)
            tb.wy r8 = (tb.wy) r8
            r9 = 0
            com.taobao.android.dinamicx.DXRuntimeContext r10 = r13.getDXRuntimeContext()     // Catch: java.lang.Exception -> L6e
            com.taobao.android.dinamicx.IExprRecorderProtocol r11 = tb.xy.a()     // Catch: java.lang.Exception -> L6e
            r11.doBeforeExecuteASTWithEventAndContext(r8, r9, r10)     // Catch: java.lang.Exception -> L6e
            java.lang.Object r11 = r8.b(r9, r10)     // Catch: java.lang.Exception -> L6e
            com.taobao.android.dinamicx.IExprRecorderProtocol r12 = tb.xy.a()     // Catch: java.lang.Exception -> L6b
            r12.doAfterExecuteASTWithEventAndContext(r8, r9, r10)     // Catch: java.lang.Exception -> L6b
            goto L8e
        L6b:
            r8 = move-exception
            r9 = r11
            goto L6f
        L6e:
            r8 = move-exception
        L6f:
            boolean r10 = com.taobao.android.dinamicx.DinamicXEngine.x()
            if (r10 == 0) goto L78
            r8.printStackTrace()
        L78:
            com.taobao.android.dinamicx.DXRuntimeContext r8 = r13.getDXRuntimeContext()
            com.taobao.android.dinamicx.e r8 = r8.getDxError()
            java.util.List<com.taobao.android.dinamicx.e$a> r8 = r8.c
            com.taobao.android.dinamicx.e$a r10 = new com.taobao.android.dinamicx.e$a
            r11 = 71002(0x1155a, float:9.9495E-41)
            r10.<init>(r1, r0, r11)
            r8.add(r10)
            r11 = r9
        L8e:
            boolean r8 = r11 instanceof java.lang.String     // Catch: java.lang.Exception -> Lde
            if (r8 == 0) goto Ld6
            java.lang.String r8 = java.lang.String.valueOf(r11)     // Catch: java.lang.Exception -> Lde
            com.taobao.android.dinamicx.model.DXLongSparseArray r9 = r13.getEnumMap()     // Catch: java.lang.Exception -> Lde
            if (r9 == 0) goto Lce
            com.taobao.android.dinamicx.model.DXLongSparseArray r9 = r13.getEnumMap()     // Catch: java.lang.Exception -> Lde
            java.lang.Object r9 = r9.get(r3)     // Catch: java.lang.Exception -> Lde
            if (r9 == 0) goto Lce
            com.taobao.android.dinamicx.model.DXLongSparseArray r9 = r13.getEnumMap()     // Catch: java.lang.Exception -> Lde
            java.lang.Object r9 = r9.get(r3)     // Catch: java.lang.Exception -> Lde
            java.util.Map r9 = (java.util.Map) r9     // Catch: java.lang.Exception -> Lde
            java.lang.Object r9 = r9.get(r8)     // Catch: java.lang.Exception -> Lde
            if (r9 == 0) goto Lce
            com.taobao.android.dinamicx.model.DXLongSparseArray r9 = r13.getEnumMap()     // Catch: java.lang.Exception -> Lde
            java.lang.Object r9 = r9.get(r3)     // Catch: java.lang.Exception -> Lde
            java.util.Map r9 = (java.util.Map) r9     // Catch: java.lang.Exception -> Lde
            java.lang.Object r8 = r9.get(r8)     // Catch: java.lang.Exception -> Lde
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch: java.lang.Exception -> Lde
            int r8 = r8.intValue()     // Catch: java.lang.Exception -> Lde
            r13.setIntAttribute(r3, r8)     // Catch: java.lang.Exception -> Lde
            goto Lfd
        Lce:
            int r8 = r13.getDefaultValueForIntAttr(r3)     // Catch: java.lang.Exception -> Lde
            r13.setIntAttribute(r3, r8)     // Catch: java.lang.Exception -> Lde
            goto Lfd
        Ld6:
            int r8 = r13.getDefaultValueForIntAttr(r3)     // Catch: java.lang.Exception -> Lde
            r13.setIntAttribute(r3, r8)     // Catch: java.lang.Exception -> Lde
            goto Lfd
        Lde:
            r3 = move-exception
            boolean r4 = com.taobao.android.dinamicx.DinamicXEngine.x()
            if (r4 == 0) goto Le8
            r3.printStackTrace()
        Le8:
            com.taobao.android.dinamicx.DXRuntimeContext r3 = r13.getDXRuntimeContext()
            com.taobao.android.dinamicx.e r3 = r3.getDxError()
            java.util.List<com.taobao.android.dinamicx.e$a> r3 = r3.c
            com.taobao.android.dinamicx.e$a r4 = new com.taobao.android.dinamicx.e$a
            r8 = 71003(0x1155b, float:9.9496E-41)
            r4.<init>(r1, r0, r8)
            r3.add(r4)
        Lfd:
            r13.setStatFlag(r2)
        L100:
            int r13 = r13.getVisibility()
            if (r13 != r6) goto L107
            goto L108
        L107:
            r5 = 0
        L108:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.m.a(com.taobao.android.dinamicx.widget.DXWidgetNode):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(com.taobao.android.dinamicx.widget.DXWidgetNode r18) {
        /*
            Method dump skipped, instructions count: 872
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.m.b(com.taobao.android.dinamicx.widget.DXWidgetNode):void");
    }

    private void c(DXWidgetNode dXWidgetNode) {
        if (!dXWidgetNode.getStatInPrivateFlags(2) || dXWidgetNode.getStatInPrivateFlags(1)) {
            b(dXWidgetNode);
            dXWidgetNode.setStatFlag(2);
        }
    }

    private void e(Context context, DXWidgetNode dXWidgetNode, long j, Object obj) {
        dXWidgetNode.setIntAttribute(j, z00.j(context, String.valueOf(obj), dXWidgetNode.getDefaultValueForIntAttr(j)));
    }

    private boolean g(DXWidgetNode dXWidgetNode) {
        if (a(dXWidgetNode)) {
            return false;
        }
        if (dXWidgetNode.getStatInPrivateFlags(1024)) {
            if (dXWidgetNode.getLayoutWidth() == 0 || dXWidgetNode.getLayoutHeight() == 0) {
                b(dXWidgetNode);
                dXWidgetNode.setStatFlag(2);
            }
            if (dXWidgetNode.getLayoutWidth() != -2 && dXWidgetNode.getLayoutHeight() != -2) {
                return false;
            }
        }
        c(dXWidgetNode);
        if (dXWidgetNode instanceof DXTemplateWidgetNode) {
            ((DXTemplateWidgetNode) dXWidgetNode).onProcessRemoteTemplate(1);
        }
        if (!dXWidgetNode.getStatInPrivateFlags(4096)) {
            dXWidgetNode.setStatFlag(4096);
            if (dXWidgetNode.getChildrenCount() > 0) {
                dXWidgetNode.onBeforeBindChildData();
            }
        }
        return true;
    }

    private void i(DXWidgetNode dXWidgetNode) {
        dXWidgetNode.beginParser(true);
        dXWidgetNode.unsetStatFlag(1024);
        if (g(dXWidgetNode)) {
            int direction = dXWidgetNode.getDirection();
            for (int i = 0; i < dXWidgetNode.getChildrenCount(); i++) {
                DXWidgetNode childAt = dXWidgetNode.getChildAt(i);
                childAt.getDXRuntimeContext().setParentDirectionSpec(direction);
                i(childAt);
            }
            o(dXWidgetNode);
            dXWidgetNode.endParser(true);
        }
    }

    private void j(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setDoubleAttribute(j, dXWidgetNode.getDefaultValueForDoubleAttr(j));
    }

    private void k(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setIntAttribute(j, dXWidgetNode.getDefaultValueForIntAttr(j));
    }

    private void l(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setListAttribute(j, dXWidgetNode.getDefaultValueForListAttr(j));
    }

    private void m(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setLongAttribute(j, dXWidgetNode.getDefaultValueForLongAttr(j));
    }

    private void n(DXWidgetNode dXWidgetNode, long j) {
        dXWidgetNode.setMapAttribute(j, dXWidgetNode.getDefaultValueForMapAttr(j));
    }

    private void o(DXWidgetNode dXWidgetNode) {
        dXWidgetNode.unsetStatFlag(1);
        dXWidgetNode.setStatFlag(32768);
        dXWidgetNode.setStatFlag(4);
    }

    public void d(DXWidgetNode dXWidgetNode) {
        dXWidgetNode.setStatFlag(1024);
        if (g(dXWidgetNode)) {
            int direction = dXWidgetNode.getDirection();
            for (int i = 0; i < dXWidgetNode.getChildrenCount(); i++) {
                DXWidgetNode childAt = dXWidgetNode.getChildAt(i);
                childAt.getDXRuntimeContext().setParentDirectionSpec(direction);
                d(childAt);
            }
        }
    }

    public DXWidgetNode f(DXWidgetNode dXWidgetNode) {
        try {
            i(dXWidgetNode);
            return dXWidgetNode;
        } catch (Exception e) {
            ry.b(e);
            if (dXWidgetNode == null || dXWidgetNode.getDXRuntimeContext() == null) {
                return null;
            }
            dXWidgetNode.getDXRuntimeContext().getDxError().c.add(new e.a("Pipeline", "Pipeline_Stage_Load_Binary", e.DXERROR_WIDGETNODE_PARSE_WT_EXCEPTION));
            return null;
        }
    }

    public void h(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode == null || a(dXWidgetNode)) {
            return;
        }
        c(dXWidgetNode);
        if (z) {
            o(dXWidgetNode);
        }
    }
}
