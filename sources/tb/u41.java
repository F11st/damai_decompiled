package tb;

import com.alibaba.fastjson.JSON;
import com.taobao.analysis.StageType;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunctionObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class u41 implements IDXFunctionObject {
    private az b(az azVar) throws DXExprFunctionError {
        if (azVar != null && azVar.B() && azVar.o() != null) {
            return az.N(azVar.o().toJSONString());
        }
        throw new DXExprFunctionError("args[0] not object");
    }

    public az a(az azVar) throws DXExprFunctionError {
        if (azVar != null && azVar.D()) {
            return az.M(JSON.parseObject(azVar.p()));
        }
        throw new DXExprFunctionError("args[0] not string");
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunctionObject
    public az call(DXRuntimeContext dXRuntimeContext, az azVar, int i, az[] azVarArr, String str, ez ezVar) throws DXExprFunctionError {
        if (i != 0) {
            if (azVarArr != null && azVarArr.length == i) {
                az azVar2 = azVarArr[0];
                str.hashCode();
                if (str.equals("stringify")) {
                    return b(azVar2);
                }
                if (str.equals(StageType.PARSE)) {
                    return a(azVar2);
                }
                throw new DXExprFunctionError("can not find function on JSON:" + str);
            }
            throw new DXExprFunctionError("args == null || args.length != argc");
        }
        throw new DXExprFunctionError("argc == 0");
    }
}
