package com.taobao.android.dinamicx.expression.parser;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;
import tb.az;
import tb.ez;
import tb.xv;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class a implements IDXFunction, IDXDataParser {
    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public az call(DXRuntimeContext dXRuntimeContext, az azVar, int i, az[] azVarArr, ez ezVar) throws DXExprFunctionError {
        Object evalWithArgs;
        Object evalWithArgs2;
        if (i >= 0) {
            Object[] objArr = new Object[i];
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = az.P(azVarArr[i2]);
            }
            if (this instanceof xv) {
                evalWithArgs2 = ((xv) this).e(ezVar.a(), objArr, dXRuntimeContext);
            } else {
                evalWithArgs2 = evalWithArgs(objArr, dXRuntimeContext);
            }
            return az.d(evalWithArgs2);
        }
        if (this instanceof xv) {
            evalWithArgs = ((xv) this).e(ezVar.a(), null, dXRuntimeContext);
        } else {
            evalWithArgs = evalWithArgs(null, dXRuntimeContext);
        }
        return az.d(evalWithArgs);
    }

    @Override // com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return null;
    }
}
