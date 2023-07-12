package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fv extends AbstractC6375a {
    public static final long DX_PARSER_CONTAINSSTR = 2778723849224680611L;

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null && objArr.length >= 2) {
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            if ((obj instanceof String) && (obj2 instanceof String)) {
                return Boolean.valueOf(((String) objArr[0]).contains((String) objArr[1]));
            }
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "containsStr";
    }
}
