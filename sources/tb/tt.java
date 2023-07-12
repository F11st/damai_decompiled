package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class tt {
    public static DXWidgetNode a(DXRuntimeContext dXRuntimeContext, DXWidgetNode dXWidgetNode) {
        DXWidgetNode dXWidgetNode2;
        if (dXWidgetNode == null || (dXWidgetNode2 = (DXWidgetNode) b(dXRuntimeContext, dXWidgetNode, true)) == null) {
            return null;
        }
        if (dXWidgetNode.getChildren() != null) {
            dXWidgetNode2.removeAllChild();
            for (int i = 0; i < dXWidgetNode.getChildren().size(); i++) {
                dXWidgetNode2.addChild(a(dXRuntimeContext, dXWidgetNode.getChildren().get(i)), false);
            }
        }
        return dXWidgetNode2;
    }

    public static Object b(DXRuntimeContext dXRuntimeContext, DXWidgetNode dXWidgetNode, boolean z) {
        DXWidgetNode build;
        if (dXWidgetNode == null || (build = dXWidgetNode.build(null)) == null) {
            return null;
        }
        if (dXWidgetNode.getDXRuntimeContext() != null) {
            build.setDXRuntimeContext(dXWidgetNode.getDXRuntimeContext().cloneWithWidgetNode(build));
        } else if (dXRuntimeContext != null) {
            build.setDXRuntimeContext(dXRuntimeContext.cloneWithWidgetNode(build));
        }
        build.onClone(dXWidgetNode, z);
        return build;
    }
}
