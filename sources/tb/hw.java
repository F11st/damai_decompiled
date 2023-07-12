package tb;

import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hw extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DX_PARSER_GETRECYCLERSTATEDATASOURCE = 5890925234203956351L;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        DXRootView rootView;
        DXWidgetNode expandWidgetNode;
        if (objArr == null || objArr.length < 1 || dXRuntimeContext == null) {
            return null;
        }
        Object obj = objArr[0];
        if (!(obj instanceof String) || (rootView = dXRuntimeContext.getRootView()) == null || (expandWidgetNode = rootView.getExpandWidgetNode()) == null) {
            return null;
        }
        DXWidgetNode queryWidgetNodeByUserId = expandWidgetNode.queryWidgetNodeByUserId((String) obj);
        if (queryWidgetNodeByUserId instanceof DXRecyclerLayout) {
            return ((DXRecyclerLayout) queryWidgetNodeByUserId).getDataSource();
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "getRecyclerStateDataSource";
    }
}
