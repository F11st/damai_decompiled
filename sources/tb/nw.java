package tb;

import com.alibaba.fastjson.JSONArray;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class nw extends mw {
    @Override // tb.mw
    protected int a(JSONArray jSONArray, Object obj) {
        int size = jSONArray.size();
        for (int i = 0; i < size; i++) {
            if (jSONArray.get(i).equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override // tb.mw, com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "index_of_value";
    }
}
