package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class jv extends AbstractC6375a {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long DX_PARSER_DXDATAPARSERDMMERGE = 5758674975472925463L;

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1788900545")) {
            return ipChange.ipc$dispatch("-1788900545", new Object[]{this, objArr, dXRuntimeContext});
        }
        if (objArr == null || objArr.length < 2) {
            return null;
        }
        String str = (String) objArr[0];
        String str2 = (String) objArr[1];
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str + str2;
    }
}
