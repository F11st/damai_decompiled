package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class mv extends com.taobao.android.dinamicx.expression.parser.a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_DMRANDOMEQUAL = 8723552886362424055L;

    private String a(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1112964091")) {
            return (String) ipChange.ipc$dispatch("-1112964091", new Object[]{this, obj});
        }
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Integer) && !(obj instanceof BigInteger) && !(obj instanceof Long) && !(obj instanceof BigDecimal) && !(obj instanceof Boolean)) {
            if (obj instanceof String) {
                return (String) obj;
            }
            return null;
        }
        return String.valueOf(obj);
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "63761656")) {
            return ipChange.ipc$dispatch("63761656", new Object[]{this, objArr, dXRuntimeContext});
        }
        if (objArr != null && objArr.length >= 2) {
            String a = a(objArr[0]);
            if (a == null) {
                return Boolean.FALSE;
            }
            for (int i = 1; i < objArr.length; i++) {
                String a2 = a(objArr[i]);
                if (a2 != null && a.equals(a2)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }
}
