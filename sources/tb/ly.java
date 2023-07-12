package tb;

import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ly extends cz {
    public static final long DX_PARSER_EVENTCHAINEVENTDATA = 5680234302234270868L;

    @Override // tb.cz
    protected Object a(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null || dXRuntimeContext.getEventChainExpressionSourceContext() == null) {
            return null;
        }
        return dXRuntimeContext.getEventChainExpressionSourceContext().d();
    }

    protected JSONObject d(@NonNull hy hyVar) {
        return x41.f(hyVar, true, hy.class);
    }

    @Override // tb.cz, com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        Object evalWithArgs = super.evalWithArgs(objArr, dXRuntimeContext);
        if (evalWithArgs != null) {
            return evalWithArgs;
        }
        if (!wt.e0() || dXRuntimeContext == null || dXRuntimeContext.getEventChainExpressionSourceContext() == null) {
            return null;
        }
        hy b = dXRuntimeContext.getEventChainExpressionSourceContext().b();
        if (objArr != null && objArr.length != 0 && (objArr[0] instanceof String) && b != null) {
            return b((String) objArr[0], d(b), dXRuntimeContext);
        }
        return new JSONObject();
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "eventChainEventData";
    }
}
