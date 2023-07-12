package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class kx extends com.taobao.android.dinamicx.expression.parser.a {
    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr == null || objArr.length < 2) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            if (obj instanceof String) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return m80.CONCAT_PREFIX;
    }
}
