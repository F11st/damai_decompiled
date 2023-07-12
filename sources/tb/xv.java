package tb;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class xv extends ly {
    public static final long DX_PARSER_DXEVENTPROP = -3357931786827536758L;

    public Object e(hy hyVar, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        JSONObject f;
        Object evalWithArgs = super.evalWithArgs(objArr, dXRuntimeContext);
        if (evalWithArgs != null) {
            return evalWithArgs;
        }
        if (objArr != null && objArr.length != 0 && (objArr[0] instanceof String) && hyVar != null) {
            if (hyVar.a() != null && !hyVar.a().isEmpty()) {
                f = new JSONObject();
                for (Map.Entry<String, az> entry : hyVar.a().entrySet()) {
                    f.put(entry.getKey(), (Object) entry.getValue());
                }
            } else {
                f = x41.f(hyVar, true, hy.class);
            }
            return b((String) objArr[0], f, dXRuntimeContext);
        }
        return new JSONObject();
    }
}
