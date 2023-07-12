package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ni2 implements IDXFunction {
    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public az call(DXRuntimeContext dXRuntimeContext, az azVar, int i, az[] azVarArr, ez ezVar) throws DXExprFunctionError {
        az azVar2;
        if (i != 0) {
            if (azVar != null && azVar.D() && azVar.p() != null) {
                if (azVarArr != null && azVarArr.length == i) {
                    az azVar3 = azVarArr[0];
                    if (azVar3 != null && azVar3.x()) {
                        String p = azVar.p();
                        long m = azVar3.m();
                        long length = p.length();
                        if (i == 2 && (azVar2 = azVarArr[1]) != null && azVar2.x()) {
                            length = azVar2.m();
                        }
                        if (length <= m) {
                            m = length;
                            length = m;
                        }
                        if (m < 0) {
                            m = 0;
                        }
                        if (m >= p.length()) {
                            return az.N("");
                        }
                        if (length > p.length()) {
                            return az.N(p.substring((int) m));
                        }
                        return az.N(p.substring((int) m, (int) length));
                    }
                    throw new DXExprFunctionError("start index is not int");
                }
                throw new DXExprFunctionError("args == null || args.length != argc");
            }
            throw new DXExprFunctionError("self is not string");
        }
        throw new DXExprFunctionError("argc == 0");
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "substring";
    }
}
