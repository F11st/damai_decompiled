package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cx extends com.taobao.android.dinamicx.expression.parser.a {
    public static final Object DEFAULT_VALUE = null;
    public static final long DX_PARSER_NOTEQUAL = 4995563293267863121L;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null) {
            try {
                if (objArr.length == 2) {
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    if (obj == null && obj2 == null) {
                        return Boolean.FALSE;
                    }
                    if (obj != null && obj2 != null) {
                        if (obj.getClass().equals(obj2.getClass())) {
                            return Boolean.valueOf(obj.equals(obj2) ? false : true);
                        } else if ((obj instanceof Number) && (obj2 instanceof Number)) {
                            return Boolean.valueOf(uz.a((Number) obj, (Number) obj2) ? false : true);
                        } else {
                            return Boolean.valueOf(obj.equals(obj2) ? false : true);
                        }
                    }
                    return Boolean.TRUE;
                }
            } catch (Throwable unused) {
                return DEFAULT_VALUE;
            }
        }
        return DEFAULT_VALUE;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "notEqual";
    }
}
