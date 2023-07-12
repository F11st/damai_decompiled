package tb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class rw extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DX_PARSER_KV = 798575;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        JSONObject jSONObject = new JSONObject();
        if (objArr != null && objArr.length != 0 && objArr.length % 2 == 0) {
            for (int i = 0; i < objArr.length; i += 2) {
                if (objArr[i] != null) {
                    String obj = objArr[i].toString();
                    if (!TextUtils.isEmpty(obj)) {
                        jSONObject.put(obj, objArr[i + 1]);
                    }
                }
            }
            return jSONObject;
        }
        nz.g("DXDataParserKv", "args 键值对数量不符合规范");
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "kv";
    }
}
