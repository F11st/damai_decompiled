package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class dv extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DEFAULT_VALUE = 0;
    public static final long DX_PARSER_CEIL = 33272317873L;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null) {
            try {
                if (objArr.length == 1) {
                    Object obj = objArr[0];
                    if (obj instanceof Number) {
                        return new Double(Math.ceil(((Number) obj).doubleValue()));
                    }
                    if (obj instanceof String) {
                        return new Double(Math.ceil(Double.parseDouble((String) obj)));
                    }
                    return 0L;
                }
            } catch (Throwable unused) {
                return 0L;
            }
        }
        return 0L;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "ceil";
    }
}
