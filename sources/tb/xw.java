package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class xw extends AbstractC6375a {
    public static final long DX_PARSER_MERGEOBJ = 4689616238216008755L;

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        JSONObject jSONObject = new JSONObject();
        if (objArr != null && objArr.length != 0) {
            for (Object obj : objArr) {
                if (obj instanceof JSONObject) {
                    jSONObject.putAll((JSONObject) obj);
                }
            }
            return jSONObject;
        }
        nz.g("DXDataParserMergeObj", "operationList 键值对数量不符合规范");
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "mergeObj";
    }
}
