package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class zv extends com.taobao.android.dinamicx.expression.parser.a {
    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr == null || objArr.length != 2) {
            return null;
        }
        Object obj = objArr[0];
        Object obj2 = objArr[1];
        if (obj == null && obj2 == null) {
            return Boolean.TRUE;
        }
        if (obj != null && obj2 != null) {
            if (obj.getClass().equals(obj2.getClass())) {
                return Boolean.valueOf(obj.equals(obj2));
            }
            if ((obj instanceof Number) && (obj2 instanceof Number)) {
                return Boolean.valueOf(uz.a((Number) obj, (Number) obj2));
            }
            return Boolean.valueOf(obj.equals(obj2));
        }
        return Boolean.FALSE;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "equal";
    }
}
