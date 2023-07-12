package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.DXGlobalCenter;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.config.IDXConfigInterface;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ex extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DX_DATA_PARSER_ORANGE = 2060908603279329344L;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        IDXConfigInterface b;
        if (objArr == null || objArr.length < 2 || !(objArr[0] instanceof String) || !(objArr[1] instanceof String) || (b = DXGlobalCenter.b()) == null) {
            return null;
        }
        String str = (String) objArr[0];
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = (String) objArr[1];
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        Object obj = objArr.length >= 3 ? objArr[2] : null;
        return b.getConfig(str, str2, obj != null ? obj.toString() : null);
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "dxOrange";
    }
}
