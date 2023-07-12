package com.taobao.android.dinamicx;

import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;
import tb.az;
import tb.ez;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.a */
/* loaded from: classes11.dex */
public abstract class AbstractC6362a implements IDXEventHandler, IDXFunction {
    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public az call(DXRuntimeContext dXRuntimeContext, az azVar, int i, az[] azVarArr, ez ezVar) throws DXExprFunctionError {
        if (i >= 0) {
            Object[] objArr = new Object[i];
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = az.P(azVarArr[i2]);
            }
            if (ezVar.a() != null && ezVar.a().c()) {
                prepareBindEventWithArgs(objArr, dXRuntimeContext);
            } else {
                handleEvent(ezVar.a(), objArr, dXRuntimeContext);
            }
            return az.d(null);
        }
        if (ezVar.a() != null && ezVar.a().c()) {
            prepareBindEventWithArgs(null, dXRuntimeContext);
        } else {
            handleEvent(ezVar.a(), null, dXRuntimeContext);
        }
        return az.L();
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return null;
    }

    @Override // com.taobao.android.dinamicx.IDXEventHandler
    public void prepareBindEventWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
    }
}
