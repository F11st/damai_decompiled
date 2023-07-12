package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vx extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DX_PARSER_TOSTR = 19624365692481L;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        long longValue;
        if (objArr != null) {
            try {
                if (objArr.length != 0 && objArr.length <= 2) {
                    Object obj = objArr[0];
                    if (obj instanceof String) {
                        return obj;
                    }
                    if (objArr.length != 1 && !(obj instanceof Integer) && !(obj instanceof Long)) {
                        if (obj instanceof Number) {
                            Object obj2 = objArr[1];
                            if (obj2 instanceof Number) {
                                longValue = ((Number) obj2).longValue();
                            } else {
                                longValue = Double.valueOf(obj2.toString()).longValue();
                            }
                            if (longValue >= 0) {
                                double doubleValue = ((Number) obj).doubleValue();
                                return String.format("%." + longValue + "f", Double.valueOf(doubleValue));
                            }
                            return obj.toString();
                        }
                        return "";
                    }
                    return obj.toString();
                }
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "toStr";
    }
}
