package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class jy extends cz {
    public static final long DX_PARSER_EVENTCHAINDATA = 1597069669224900237L;

    @Override // tb.cz
    protected Object a(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null || dXRuntimeContext.getEventChainExpressionSourceContext() == null) {
            return null;
        }
        return dXRuntimeContext.getEventChainExpressionSourceContext().c();
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "eventChainData";
    }
}
