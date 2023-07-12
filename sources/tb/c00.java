package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;
import com.taobao.android.dinamicx.widget.C6493f;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.StringTokenizer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class c00 extends AbstractC6375a {
    public static final long DX_PARSER_PARENTSUBDATA = -1943779674642760869L;

    private Object a(DXRuntimeContext dXRuntimeContext) {
        DXWidgetNode widgetNode;
        DXWidgetNode parentWidget;
        if (dXRuntimeContext == null || (widgetNode = dXRuntimeContext.getWidgetNode()) == null || (parentWidget = widgetNode.getParentWidget()) == null) {
            return null;
        }
        C6493f c6493f = (C6493f) parentWidget;
        if (c6493f.isHandleListData()) {
            return c6493f.getDXRuntimeContext().getSubData();
        }
        return a(c6493f.getDXRuntimeContext());
    }

    private Object b(DXRuntimeContext dXRuntimeContext, Object obj, String str) {
        if (obj == null || str == null) {
            return null;
        }
        return cy.a(dXRuntimeContext, obj, str);
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        Object a = a(dXRuntimeContext);
        if (a == null) {
            return null;
        }
        if (objArr != null && objArr.length != 0) {
            if (objArr.length > 1) {
                return null;
            }
            Object obj = objArr[0];
            if (!(obj instanceof String)) {
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer((String) obj, " .[]", false);
            while (stringTokenizer.hasMoreTokens()) {
                a = b(dXRuntimeContext, a, stringTokenizer.nextToken());
            }
        }
        return a;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "parentSubdata";
    }
}
