package tb;

import com.alibaba.fastjson.JSONArray;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class w7 implements IDXFunction {
    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public az call(DXRuntimeContext dXRuntimeContext, az azVar, int i, az[] azVarArr, ez ezVar) throws DXExprFunctionError {
        az azVar2;
        if (i != 0) {
            if (azVar != null && azVar.t() && azVar.h() != null) {
                if (azVarArr != null && azVarArr.length == i) {
                    az azVar3 = azVarArr[0];
                    if (azVar3 != null && azVar3.x()) {
                        JSONArray h = azVar.h();
                        long m = azVar3.m();
                        if (m < h.size() && m >= 0) {
                            long size = h.size();
                            if (i == 2 && (azVar2 = azVarArr[1]) != null && azVar2.x()) {
                                size = azVar2.m();
                            }
                            if (size <= m) {
                                return az.E(new JSONArray());
                            }
                            if (size > h.size()) {
                                return az.E(new JSONArray(h.subList((int) m, h.size())));
                            }
                            return az.E(new JSONArray(h.subList((int) m, (int) size)));
                        }
                        return az.E(new JSONArray());
                    }
                    throw new DXExprFunctionError("start index is not int");
                }
                throw new DXExprFunctionError("args == null || args.length != argc");
            }
            throw new DXExprFunctionError("self is not array");
        }
        throw new DXExprFunctionError("argc == 0");
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "slice";
    }
}
