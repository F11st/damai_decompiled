package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class mq1 implements IDXFunction {
    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public az call(DXRuntimeContext dXRuntimeContext, az azVar, int i, az[] azVarArr, ez ezVar) throws DXExprFunctionError {
        String valueOf;
        if (i != 0) {
            if (azVarArr != null && azVarArr.length == i) {
                az azVar2 = azVarArr[0];
                if (azVar2 != null && (azVar2.D() || azVar2.A())) {
                    int i2 = 10;
                    if (azVar2.D()) {
                        valueOf = azVar2.p();
                        if (valueOf.startsWith("0x") || valueOf.startsWith("0X")) {
                            i2 = 16;
                        }
                    } else {
                        valueOf = String.valueOf((long) Math.floor(azVar2.b()));
                    }
                    if (i == 2) {
                        az azVar3 = azVarArr[1];
                        if (azVar3 != null && azVar3.x()) {
                            i2 = (int) azVar3.m();
                        } else {
                            throw new DXExprFunctionError("args[1] not int");
                        }
                    }
                    return az.J(Long.parseLong(valueOf, i2));
                }
                throw new DXExprFunctionError("args[0] not string or number");
            }
            throw new DXExprFunctionError("args == null || args.length != argc");
        }
        throw new DXExprFunctionError("argc == 0");
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "parseInt";
    }
}
