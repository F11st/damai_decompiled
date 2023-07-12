package tb;

import com.alibaba.fastjson.JSONArray;
import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bw extends com.taobao.android.dinamicx.expression.parser.a {
    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null && objArr.length == 2) {
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            dXRuntimeContext.getDataProxy();
            if ((obj instanceof JSONArray) && ((JSONArray) obj).contains(obj2)) {
                return obj2;
            }
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "array_find";
    }
}
