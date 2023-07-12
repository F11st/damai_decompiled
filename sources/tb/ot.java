package tb;

import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ot {
    public static boolean a(DXWidgetNode dXWidgetNode) {
        DXWidgetNode b = b(dXWidgetNode);
        DXRootView rootView = (dXWidgetNode == null || dXWidgetNode.getDXRuntimeContext() == null) ? null : dXWidgetNode.getDXRuntimeContext().getRootView();
        return rootView == null || rootView.getExpandWidgetNode() != b;
    }

    public static DXWidgetNode b(DXWidgetNode dXWidgetNode) {
        return dXWidgetNode.getParentWidget() == null ? dXWidgetNode : b(dXWidgetNode.getParentWidget());
    }
}
