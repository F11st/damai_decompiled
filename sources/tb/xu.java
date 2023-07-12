package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;
import com.taobao.downloader.adpater.Monitor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class xu extends AbstractC6375a {
    public static final long DX_PARSER_ADD = 516206988;

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        return sz.a(objArr, 1);
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return Monitor.POINT_ADD;
    }
}
