package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class gw extends cz {
    @Override // tb.cz
    protected Object a(DXRuntimeContext dXRuntimeContext) {
        DinamicXEngine e;
        com.taobao.android.dinamicx.eventchain.b o;
        h j;
        com.taobao.android.dinamicx.d engineContext = dXRuntimeContext.getEngineContext();
        if (engineContext == null || (e = engineContext.e()) == null || (o = e.o()) == null || (j = o.j()) == null) {
            return null;
        }
        return j.d();
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "getEngineStorage";
    }
}
