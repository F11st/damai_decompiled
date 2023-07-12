package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class lq1 implements IDXFunction {
    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public az call(DXRuntimeContext dXRuntimeContext, az azVar, int i, az[] azVarArr, ez ezVar) throws DXExprFunctionError {
        String valueOf;
        if (i != 0) {
            if (azVarArr != null && azVarArr.length == i) {
                az azVar2 = azVarArr[0];
                if (azVar2 != null && (azVar2.D() || azVar2.A())) {
                    if (azVar2.D()) {
                        valueOf = azVar2.p();
                    } else {
                        valueOf = String.valueOf(azVar2.b());
                    }
                    return az.H(Double.parseDouble(valueOf));
                }
                throw new DXExprFunctionError("args[0] not string or number");
            }
            throw new DXExprFunctionError("args == null || args.length != argc");
        }
        throw new DXExprFunctionError("argc == 0");
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "parseFloat";
    }
}
