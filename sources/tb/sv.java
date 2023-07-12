package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class sv extends AbstractC6375a {
    public static final long DX_PARSER_DXVERSION_GREATERTHANOREQUALTO = 87712825513562832L;

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null && objArr.length == 1) {
            if (!(objArr[0] instanceof String)) {
                return Boolean.FALSE;
            }
            String[] split = "3.9.10.3".split("\\.");
            String[] split2 = ((String) objArr[0]).split("\\.");
            if (split.length == 4 && split2.length == 4) {
                for (int i = 0; i < 4; i++) {
                    String str = split[i];
                    String str2 = split2[i];
                    if (i == 3) {
                        try {
                            if (str.contains("-")) {
                                str = str.split("-")[0];
                            }
                            if (str2.contains("-")) {
                                str2 = str2.split("-")[0];
                            }
                        } catch (Exception unused) {
                            return Boolean.FALSE;
                        }
                    }
                    int parseInt = Integer.parseInt(str);
                    int parseInt2 = Integer.parseInt(str2);
                    if (parseInt2 > parseInt) {
                        return Boolean.TRUE;
                    }
                    if (parseInt2 < parseInt) {
                        return Boolean.FALSE;
                    }
                    if (i == 3) {
                        return Boolean.TRUE;
                    }
                }
            }
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "DXVersion_GreaterThanOrEqualTo";
    }
}
