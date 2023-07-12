package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class m10 extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DX_PARSER_SUBDATAINDEX = -7608311581340923672L;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null) {
            return -1;
        }
        return Integer.valueOf(dXRuntimeContext.getSubdataIndex());
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "subdataIndex";
    }
}
