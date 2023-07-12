package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprFunctionError;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunctionObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class tp0 implements IDXFunction {
    private String a;
    private IDXFunctionObject b;

    public tp0(IDXFunctionObject iDXFunctionObject, String str) {
        this.a = str;
        this.b = iDXFunctionObject;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public az call(DXRuntimeContext dXRuntimeContext, az azVar, int i, az[] azVarArr, ez ezVar) throws DXExprFunctionError {
        return this.b.call(dXRuntimeContext, azVar, i, azVarArr, this.a, ezVar);
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return this.a;
    }
}
