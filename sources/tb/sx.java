package tb;

import android.content.Context;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class sx extends AbstractC6375a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_TOCOMPUTEPX = 3196568048963202419L;

    private int a(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1634283037")) {
            return ((Integer) ipChange.ipc$dispatch("1634283037", new Object[]{this, context, str})).intValue();
        }
        try {
        } catch (Exception e) {
            cb1.b("DXDataParserToComputePX", e.getMessage());
        }
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.endsWith("ap")) {
            return z00.b(context, Integer.parseInt(str.replace("ap", "")));
        }
        if (str.endsWith(d90.DIMEN_SUFFIX_NP)) {
            return z00.c(context, Integer.parseInt(str.replace(d90.DIMEN_SUFFIX_NP, "")));
        }
        return 0;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1618858828")) {
            return ipChange.ipc$dispatch("-1618858828", new Object[]{this, objArr, dXRuntimeContext});
        }
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[0];
        if (obj instanceof String) {
            String str = (String) obj;
            if (!TextUtils.isEmpty(str) && str.contains("-")) {
                String[] split = str.split("-");
                if (tq.a(split) < 2) {
                    return "0np";
                }
                int a = a(dXRuntimeContext.getContext(), split[0]);
                int a2 = a(dXRuntimeContext.getContext(), split[1]);
                return t60.e(dXRuntimeContext.getContext(), a - a2) + d90.DIMEN_SUFFIX_NP;
            }
            return "0np";
        }
        return "0np";
    }
}
