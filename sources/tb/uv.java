package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.weex.ui.component.WXBasicComponentType;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class uv extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DX_PARSER_DIV = 518002038;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        return sz.a(objArr, 4);
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return WXBasicComponentType.DIV;
    }
}
