package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;
import com.taobao.android.dinamicx.widget.C6493f;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class mz extends AbstractC6375a {
    public static final long DX_PARSER_LISTDATA = 4399723831998020670L;

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext.getWidgetNode() instanceof C6493f) {
            return ((C6493f) dXRuntimeContext.getWidgetNode()).getListData();
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return Constants.Name.Recycler.LIST_DATA;
    }
}
