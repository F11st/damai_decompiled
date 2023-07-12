package tb;

import com.alibaba.fastjson.JSONArray;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class nv extends AbstractC6375a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_DMSUBARRAY = -3678511738734981180L;

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-586932410")) {
            return ipChange.ipc$dispatch("-586932410", new Object[]{this, objArr, dXRuntimeContext});
        }
        int a = tq.a(objArr);
        if (a <= 0) {
            return null;
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a <= 2) {
            if (a > 0) {
                return objArr[0];
            }
            return null;
        }
        Object obj = objArr[0];
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int b = t41.b(jSONArray);
            Object obj2 = objArr[1];
            int l = obj2 instanceof String ? wh2.l((String) obj2, 0) : 0;
            Object obj3 = objArr[2];
            if (obj3 instanceof String) {
                i = wh2.l((String) obj3, b);
                int i2 = b - 1;
                if (i > i2) {
                    i = i2;
                }
            } else {
                i = b;
            }
            if (l < 0 || l >= b || i <= l) {
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            while (l <= i) {
                jSONArray2.add(jSONArray.getJSONObject(l));
                l++;
            }
            return jSONArray2;
        }
        return null;
    }
}
