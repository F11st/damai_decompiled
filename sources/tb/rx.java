package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class rx extends AbstractC6375a {
    public static final long DX_PARSER_TOBINDINGXUNIT = 6677129169796262308L;

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        int c;
        if (objArr != null) {
            try {
                if (objArr.length == 1) {
                    Object obj = objArr[0];
                    if (obj instanceof Number) {
                        return Integer.valueOf(z00.b(DinamicXEngine.i(), ((Number) obj).floatValue()));
                    }
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (str.endsWith("ap")) {
                            c = z00.b(DinamicXEngine.i(), Float.parseFloat(str.substring(0, str.length() - 2)));
                        } else if (str.endsWith(d90.DIMEN_SUFFIX_NP)) {
                            c = z00.c(DinamicXEngine.i(), Float.parseFloat(str.substring(0, str.length() - 2)));
                        } else {
                            return Integer.valueOf(z00.b(DinamicXEngine.i(), Float.valueOf(str).floatValue()));
                        }
                        return Integer.valueOf(c);
                    }
                    return 0;
                }
            } catch (Throwable unused) {
                return 0;
            }
        }
        return 0;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "toBindingXUnit";
    }
}
