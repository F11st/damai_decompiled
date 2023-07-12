package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fw extends cz {
    @Override // tb.cz
    protected Object a(DXRuntimeContext dXRuntimeContext) {
        q a;
        my eventChainExpressionSourceContext = dXRuntimeContext.getEventChainExpressionSourceContext();
        if (eventChainExpressionSourceContext == null || (a = eventChainExpressionSourceContext.a()) == null) {
            return null;
        }
        return a.b();
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "getChainStorage";
    }
}
