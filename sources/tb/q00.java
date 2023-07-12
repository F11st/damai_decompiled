package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class q00 {
    public static boolean a(@NonNull DXWidgetNode dXWidgetNode, DXRuntimeContext dXRuntimeContext) {
        if (dXWidgetNode.getDataParsersExprNode() == null || dXWidgetNode.getDataParsersExprNode().get(DXTemplateWidgetNode.DXTEMPLATE_IF) == null) {
            return true;
        }
        Object obj = null;
        try {
            obj = dXWidgetNode.getDataParsersExprNode().get(DXTemplateWidgetNode.DXTEMPLATE_IF).b(null, dXRuntimeContext);
        } catch (Exception unused) {
        }
        if (obj instanceof String) {
            return "true".equalsIgnoreCase((String) obj);
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static DXTemplateWidgetNode b(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode != null) {
            while (dXWidgetNode.getParentWidget() != null) {
                DXWidgetNode parentWidget = dXWidgetNode.getParentWidget();
                if ((dXWidgetNode instanceof DXTemplateWidgetNode) && (parentWidget instanceof DXRecyclerLayout)) {
                    return (DXTemplateWidgetNode) dXWidgetNode;
                }
                dXWidgetNode = parentWidget;
            }
            return null;
        }
        return null;
    }

    public static void c(DXTemplateWidgetNode dXTemplateWidgetNode) {
        if (!TextUtils.isEmpty(dXTemplateWidgetNode.getSlotId())) {
            dXTemplateWidgetNode.processContainsSlotIdTemplate();
        } else if (dXTemplateWidgetNode.getDataParsersExprNode() == null) {
        } else {
            if (dXTemplateWidgetNode.getDataParsersExprNode().get(DXTemplateWidgetNode.DXTEMPLATE_NAME) != null) {
                try {
                    Object b = dXTemplateWidgetNode.getDataParsersExprNode().get(DXTemplateWidgetNode.DXTEMPLATE_NAME).b(null, dXTemplateWidgetNode.getDXRuntimeContext());
                    if (b instanceof String) {
                        dXTemplateWidgetNode.setStringAttribute(DXTemplateWidgetNode.DXTEMPLATE_NAME, String.valueOf(b));
                    }
                } catch (Exception unused) {
                }
            }
            if (dXTemplateWidgetNode.getDataParsersExprNode().get(DXTemplateWidgetNode.DXTEMPLATE_VERSION) != null) {
                try {
                    Object b2 = dXTemplateWidgetNode.getDataParsersExprNode().get(DXTemplateWidgetNode.DXTEMPLATE_VERSION).b(null, dXTemplateWidgetNode.getDXRuntimeContext());
                    if (b2 != null) {
                        dXTemplateWidgetNode.setStringAttribute(DXTemplateWidgetNode.DXTEMPLATE_VERSION, String.valueOf(b2));
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }
}
