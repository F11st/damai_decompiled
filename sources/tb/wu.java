package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class wu extends AbstractC6375a {
    public static final long DX_PARSER_ABS = 516202497;

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null) {
            try {
                if (objArr.length == 1) {
                    Object obj = objArr[0];
                    if (!(obj instanceof Long) && !(obj instanceof Integer)) {
                        if (uz.c(obj)) {
                            return Double.valueOf(Math.abs(((Number) obj).doubleValue()));
                        }
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (uz.b(str)) {
                                return Double.valueOf(Math.abs(Double.valueOf(str).doubleValue()));
                            }
                            return Long.valueOf(Math.abs(Long.valueOf(str).longValue()));
                        }
                        return 0L;
                    }
                    return Long.valueOf(Math.abs(((Number) obj).longValue()));
                }
            } catch (Throwable th) {
                ry.b(th);
                return 0L;
            }
        }
        return 0L;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "abs";
    }
}
