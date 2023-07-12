package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class mx extends AbstractC6375a {
    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr == null || objArr.length > 3 || objArr.length < 2) {
            return null;
        }
        Object obj = objArr[0];
        if (obj instanceof String) {
            String str = (String) obj;
            Object obj2 = objArr[1];
            if (obj2 instanceof String) {
                int f = uz.f((String) obj2);
                if (objArr.length == 3) {
                    Object obj3 = objArr[2];
                    if (obj3 instanceof String) {
                        int f2 = uz.f((String) obj3);
                        if (f2 < 0 || f + 1 > str.length()) {
                            return "";
                        }
                        int i = f >= 0 ? f : 0;
                        int i2 = f2 + i;
                        return i2 + (-1) < str.length() ? str.substring(i, i2) : i2 > str.length() ? str.substring(i) : null;
                    }
                    return null;
                } else if (f + 1 > str.length()) {
                    return "";
                } else {
                    return str.substring(f >= 0 ? f : 0);
                }
            }
            return null;
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return m80.SUBSTR_PREFIX;
    }
}
