package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class tv extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DX_PARSER_DATAPARSERNOTFOUND = 1583580654108865350L;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null) {
            boolean z = true;
            if (objArr.length == 1) {
                if (!(objArr[0] instanceof String)) {
                    return Boolean.TRUE;
                }
                try {
                    if (dXRuntimeContext.getParserMap().get(Long.parseLong((String) objArr[0])) != null) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                } catch (Exception unused) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.TRUE;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "dataParserNotFound";
    }
}
