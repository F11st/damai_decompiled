package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class lx extends com.taobao.android.dinamicx.expression.parser.a {
    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null && objArr.length == 1) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                return ((String) obj).toLowerCase();
            }
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "lowercase";
    }
}
