package com.taobao.android.dinamicx.expression.expr_v2;

import com.taobao.android.dinamicx.DXRuntimeContext;
import tb.az;
import tb.ez;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDXFunction {
    az call(DXRuntimeContext dXRuntimeContext, az azVar, int i, az[] azVarArr, ez ezVar) throws DXExprFunctionError;

    String getDxFunctionName();
}
