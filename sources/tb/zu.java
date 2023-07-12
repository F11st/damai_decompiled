package tb;

import com.alibaba.fastjson.JSONArray;
import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class zu extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DX_PARSER_ARRAY_CONCAT = 6742876832553239298L;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        JSONArray jSONArray = new JSONArray();
        if (objArr == null) {
            return jSONArray;
        }
        for (Object obj : objArr) {
            if (obj instanceof JSONArray) {
                jSONArray.addAll((JSONArray) obj);
            } else if (obj != null) {
                jSONArray.add(obj);
            }
        }
        return jSONArray;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "array_concat";
    }
}
