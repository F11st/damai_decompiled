package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class kz extends cz {
    @Override // tb.cz
    protected Object a(DXRuntimeContext dXRuntimeContext) {
        my eventChainExpressionSourceContext = dXRuntimeContext.getEventChainExpressionSourceContext();
        if (eventChainExpressionSourceContext == null) {
            return null;
        }
        return eventChainExpressionSourceContext.e();
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "lastdata";
    }
}
