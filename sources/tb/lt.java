package tb;

import android.text.TextUtils;
import android.view.View;
import com.alibaba.android.bindingx.plugin.android.NativeViewFinder;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class lt implements NativeViewFinder {
    private DXWidgetNode a(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof DXRootView) {
            return ((DXRootView) view).getFlattenWidgetNode();
        }
        Object tag = view.getTag(DXWidgetNode.TAG_WIDGET_NODE);
        if (tag instanceof DXWidgetNode) {
            return (DXWidgetNode) tag;
        }
        return null;
    }

    @Override // com.alibaba.android.bindingx.plugin.android.NativeViewFinder
    public View findViewBy(View view, String str) {
        if (view != null && !TextUtils.isEmpty(str)) {
            DXWidgetNode a = a(view);
            if (a != null && a.getReferenceNode() != null) {
                DXWidgetNode referenceNode = a.getReferenceNode();
                if (referenceNode != view.getTag(g00.b)) {
                    if (DinamicXEngine.x()) {
                        nz.o("未找到" + str + "对应的view  原因为： expandWidget != view.getTag(DXPublicConstant.TAG_ANIMATION_EXPANDED_WIDGET_ON_VIEW)");
                    }
                    return null;
                } else if (ot.a(referenceNode)) {
                    if (DinamicXEngine.x()) {
                        nz.o("未找到" + str + "对应的view  原因为： 当前rootview已经被复用");
                    }
                    return null;
                } else {
                    String u = kt.u(str);
                    if ("this".equalsIgnoreCase(u)) {
                        if (referenceNode.getReferenceNode() != null && referenceNode.getReferenceNode().getWRView() != null) {
                            return referenceNode.getReferenceNode().getWRView().get();
                        }
                        if (DinamicXEngine.x()) {
                            nz.o("未找到" + str + "对应的view  原因为： 对应的节点上面的view已经不存在");
                        }
                        return null;
                    }
                    DXWidgetNode queryWTByUserId = !wt.P0(referenceNode.getDXRuntimeContext()) ? referenceNode.queryWTByUserId(u) : null;
                    if (queryWTByUserId == null || queryWTByUserId.getReferenceNode() == null) {
                        queryWTByUserId = referenceNode.queryWidgetNodeByUserId(u);
                    }
                    if (queryWTByUserId != null && queryWTByUserId.getReferenceNode() != null && queryWTByUserId.getReferenceNode().getWRView() != null) {
                        return queryWTByUserId.getReferenceNode().getWRView().get();
                    }
                    if (DinamicXEngine.x()) {
                        nz.o("未找到" + str + "对应的view  原因为： 找不到对应的节点，或者对应节点的view不存，请检查模版bindingX.json是否书写正确");
                    }
                    return null;
                }
            }
            if (DinamicXEngine.x()) {
                nz.o("未找到" + str + "对应的view  原因为： 拍平节点是空或者其对应的展开节点是空flattenWidget == null || flattenWidget.getReferenceNode() == null");
            }
            return null;
        }
        if (DinamicXEngine.x()) {
            nz.o("未找到" + str + "对应的view  原因为：  view == null || TextUtils.isEmpty(ref)");
        }
        return null;
    }
}
