package tb;

import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXWidgetNode;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hx extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DX_DATA_PARSER_RECYCLER_CURRENT_POSITION = -4732527849534416472L;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        DXWidgetNode expandWidgetNode;
        int i = -1;
        if (objArr != null && objArr.length >= 2 && dXRuntimeContext != null) {
            Object obj = objArr[1];
            if (obj instanceof String) {
                String str = (String) obj;
                DXRootView rootView = dXRuntimeContext.getRootView();
                if (rootView != null && (expandWidgetNode = rootView.getExpandWidgetNode()) != null) {
                    DXWidgetNode queryWidgetNodeByUserId = expandWidgetNode.queryWidgetNodeByUserId(str);
                    if (queryWidgetNodeByUserId instanceof DXRecyclerLayout) {
                        i = ((DXRecyclerLayout) queryWidgetNodeByUserId).getScrollPosition();
                    }
                }
            }
            return Integer.valueOf(i);
        }
        return -1;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "recyclerCurrentPosition";
    }
}
