package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunctionObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class nd1 implements IDXFunctionObject {
    private az a(az[] azVarArr) throws DXExprFunctionError {
        az azVar = azVarArr[0];
        if (azVar != null && azVar.A()) {
            if (azVar.x()) {
                return az.J(Math.abs(azVar.m()));
            }
            return az.H(Math.abs(azVar.k()));
        }
        throw new DXExprFunctionError("args[0] not number");
    }

    private az b(az[] azVarArr) throws DXExprFunctionError {
        az azVar = azVarArr[0];
        if (azVar != null && azVar.A()) {
            return az.J((int) Math.ceil(azVar.b()));
        }
        throw new DXExprFunctionError("args[0] not number");
    }

    private az c(az[] azVarArr) throws DXExprFunctionError {
        az azVar = azVarArr[0];
        if (azVar != null && azVar.A()) {
            return az.H(Math.exp(azVar.b()));
        }
        throw new DXExprFunctionError("args[0] not number");
    }

    private az d(az[] azVarArr) throws DXExprFunctionError {
        az azVar = azVarArr[0];
        if (azVar != null && azVar.A()) {
            return az.J((int) Math.floor(azVar.b()));
        }
        throw new DXExprFunctionError("args[0] not number");
    }

    private az e(int i, az[] azVarArr) throws DXExprFunctionError {
        az azVar = null;
        for (int i2 = 0; i2 < i; i2++) {
            az azVar2 = azVarArr[i2];
            if (azVar2 != null && azVar2.A()) {
                if (azVar == null || azVar.b() < azVar2.b()) {
                    azVar = azVar2;
                }
            } else {
                throw new DXExprFunctionError("args[" + i2 + "] not number");
            }
        }
        return azVar;
    }

    private az f(int i, az[] azVarArr) throws DXExprFunctionError {
        az azVar = null;
        for (int i2 = 0; i2 < i; i2++) {
            az azVar2 = azVarArr[i2];
            if (azVar2 != null && azVar2.A()) {
                if (azVar == null || azVar.b() > azVar2.b()) {
                    azVar = azVar2;
                }
            } else {
                throw new DXExprFunctionError("args[" + i2 + "] not number");
            }
        }
        return azVar;
    }

    private az g(az[] azVarArr) throws DXExprFunctionError {
        az azVar = azVarArr[0];
        if (azVar != null && azVar.A()) {
            return az.J(Math.round(azVar.b()));
        }
        throw new DXExprFunctionError("args[0] not number");
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunctionObject
    public az call(DXRuntimeContext dXRuntimeContext, az azVar, int i, az[] azVarArr, String str, ez ezVar) throws DXExprFunctionError {
        if (i != 0) {
            if (azVarArr != null && azVarArr.length == i) {
                if (!TextUtils.isEmpty(str)) {
                    str.hashCode();
                    char c = 65535;
                    switch (str.hashCode()) {
                        case 96370:
                            if (str.equals("abs")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 100893:
                            if (str.equals("exp")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 107876:
                            if (str.equals("max")) {
                                c = 2;
                                break;
                            }
                            break;
                        case 108114:
                            if (str.equals("min")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 3049733:
                            if (str.equals("ceil")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 97526796:
                            if (str.equals("floor")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 108704142:
                            if (str.equals("round")) {
                                c = 6;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            return a(azVarArr);
                        case 1:
                            return c(azVarArr);
                        case 2:
                            return e(i, azVarArr);
                        case 3:
                            return f(i, azVarArr);
                        case 4:
                            return b(azVarArr);
                        case 5:
                            return d(azVarArr);
                        case 6:
                            return g(azVarArr);
                        default:
                            throw new DXExprFunctionError("can not find function on Math:" + str);
                    }
                }
                throw new DXExprFunctionError("function is null");
            }
            throw new DXExprFunctionError("args == null || args.length != argc");
        }
        throw new DXExprFunctionError("argc == 0");
    }
}
