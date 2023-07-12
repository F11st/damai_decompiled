package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ix extends AbstractC6375a {
    public static final long DX_PARSER_RECYCLERDATAINDEX = -1158194156417975076L;

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null || dXRuntimeContext.getWidgetNode() == null) {
            return -1;
        }
        DXWidgetNode widgetNode = dXRuntimeContext.getWidgetNode();
        DXWidgetNode dXWidgetNode = widgetNode;
        while (dXWidgetNode.getParentWidget() != null) {
            dXWidgetNode = dXWidgetNode.getParentWidget();
            if (dXWidgetNode instanceof DXRecyclerLayout) {
                return Integer.valueOf(((DXRecyclerLayout) dXWidgetNode).getDataIndex(widgetNode));
            }
        }
        return -1;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "recyclerDataIndex";
    }
}
