package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class kv extends AbstractC6375a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_DMNUMBERFORMAT = -2092015216107125647L;

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        Object obj;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "110196461")) {
            return ipChange.ipc$dispatch("110196461", new Object[]{this, objArr, dXRuntimeContext});
        }
        if (objArr == null || objArr.length == 0 || (obj = objArr[0]) == null || !(obj instanceof String)) {
            return "";
        }
        String str = (String) obj;
        if (wh2.j(str)) {
            return "";
        }
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        return i <= 0 ? "" : i < 10000 ? str : i % 10000 > 0 ? String.format("%s万", Double.valueOf(Math.floor(((i * 1.0d) / 10000.0d) * 10.0d) / 10.0d)) : String.format("%s万", Integer.valueOf(i / 10000));
    }
}
