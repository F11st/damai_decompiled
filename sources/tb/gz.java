package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.IDXNodePropProvider;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class gz extends AbstractC6375a {
    public static final long DX_PARSER_GETWIDGETPROPERTYVALUE = 1720632590440773916L;

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        DXWidgetNode widgetNode;
        Object nodePropByKey;
        if (objArr == null || objArr.length < 2 || objArr[1] == null) {
            return null;
        }
        Object obj = objArr[0];
        String str = (!(obj instanceof String) || TextUtils.isEmpty((CharSequence) obj)) ? "" : (String) obj;
        Object obj2 = objArr[1];
        String str2 = obj2 instanceof String ? (String) obj2 : "";
        Object obj3 = objArr.length >= 3 ? objArr[2] : null;
        if (TextUtils.isEmpty(str2) || (widgetNode = dXRuntimeContext.getWidgetNode()) == null) {
            return obj3;
        }
        DXWidgetNode queryWidgetNodeByUserId = (TextUtils.isEmpty(str) || str.equals(widgetNode.getUserId())) ? widgetNode : widgetNode.queryWidgetNodeByUserId(str);
        if ("root".equals(str) && queryWidgetNodeByUserId == null) {
            queryWidgetNodeByUserId = widgetNode.queryRootWidgetNode();
        }
        return ((queryWidgetNodeByUserId instanceof IDXNodePropProvider) && (nodePropByKey = ((IDXNodePropProvider) queryWidgetNodeByUserId).getNodePropByKey(str2)) != null) ? nodePropByKey : obj3;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "getWidgetPropertyValue";
    }
}
