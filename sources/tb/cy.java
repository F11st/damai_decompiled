package tb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.model.DXJSONObjectForVM;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cy {
    public static Object a(DXRuntimeContext dXRuntimeContext, Object obj, String str) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (obj instanceof DXJSONObjectForVM) {
            return a(dXRuntimeContext, ((DXJSONObjectForVM) obj).getData(), str);
        }
        if (obj instanceof JSONObject) {
            return ((JSONObject) obj).get(str);
        }
        if (obj instanceof JSONArray) {
            try {
                return ((JSONArray) obj).get(Integer.parseInt(str));
            } catch (Exception unused) {
                nz.s("DXExpressionParser list index is not number");
                return null;
            }
        }
        if (dXRuntimeContext != null && dXRuntimeContext.supportDataProxy()) {
            dXRuntimeContext.getDataProxy();
            throw null;
        }
        return null;
    }

    public static boolean b(DXRuntimeContext dXRuntimeContext, Object obj) {
        return dXRuntimeContext != null && dXRuntimeContext.supportDataProxy() && !(obj instanceof JSONArray) && (obj instanceof List);
    }
}
