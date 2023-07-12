package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ov extends com.taobao.android.dinamicx.expression.parser.a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_DMTOWEBP = -7411709743744784406L;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "863633860")) {
            return ipChange.ipc$dispatch("863633860", new Object[]{this, objArr, dXRuntimeContext});
        }
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[0];
        if (obj == null || !((obj instanceof String) || (obj instanceof CharSequence))) {
            return obj;
        }
        String str = (String) obj;
        if (wh2.j(str)) {
            return obj;
        }
        if (cn.damai.common.image.b.e()) {
            if (tq.a(objArr) >= 2) {
                String str2 = (String) objArr[1];
                if (!wh2.j(str2) && str2.contains(Constants.Name.X) && str2.split(Constants.Name.X).length == 2) {
                    try {
                        String[] split = str2.split(Constants.Name.X);
                        return String.format("%s%s%sx%s", str, "?optParams=", Integer.valueOf(t60.a(dXRuntimeContext.getContext(), Integer.parseInt(split[0]))), Integer.valueOf(t60.a(dXRuntimeContext.getContext(), Integer.parseInt(split[1]))));
                    } catch (Exception e) {
                        cb1.b("DXDataParserDMToWebp", e.getMessage());
                        return str;
                    }
                }
                return str;
            }
            return String.format("%s%s%s", str, "?optParams=", "-1x-1");
        }
        return str;
    }
}
