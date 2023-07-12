package tb;

import com.alibaba.fastjson.JSONArray;
import com.taobao.android.dinamicx.DXRuntimeContext;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class px extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DX_PARSER_SUB_ARRAY = -6848818898485245999L;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        int i;
        List<Object> subList;
        if (objArr != null && objArr.length == 3) {
            try {
                if (objArr[0] instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) objArr[0];
                    try {
                        int parseInt = Integer.parseInt(objArr[1].toString());
                        int parseInt2 = Integer.parseInt(objArr[2].toString());
                        int size = jSONArray.size();
                        if (size > 0 && parseInt <= size && parseInt >= 0 && (i = parseInt2 + parseInt) <= jSONArray.size() && (subList = jSONArray.subList(parseInt, i)) != null) {
                            JSONArray jSONArray2 = new JSONArray();
                            jSONArray2.addAll(subList);
                            return jSONArray2;
                        }
                    } catch (NumberFormatException unused) {
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                ry.b(e);
            }
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "sub_array";
    }
}
