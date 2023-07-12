package tb;

import com.taobao.android.dinamicx.DXDarkModeCenter;
import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ow extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DX_PARSER_ISDARKMODE = 8991544260901901805L;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        return Boolean.valueOf(DXDarkModeCenter.d() && DXDarkModeCenter.c());
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "isDarkMode";
    }
}
