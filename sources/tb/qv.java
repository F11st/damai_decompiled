package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class qv extends com.taobao.android.dinamicx.expression.parser.a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_DMTRANSFERSTRING = -7774666226496243107L;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-923802775")) {
            return ipChange.ipc$dispatch("-923802775", new Object[]{this, objArr, dXRuntimeContext});
        }
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[0];
        if (obj instanceof String) {
            return obj;
        }
        if ((obj instanceof Integer) || (obj instanceof BigInteger) || (obj instanceof Long) || (obj instanceof BigDecimal) || (obj instanceof Boolean)) {
            return String.valueOf(obj);
        }
        return null;
    }
}
