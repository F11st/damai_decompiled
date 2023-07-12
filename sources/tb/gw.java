package tb;

import com.taobao.android.dinamicx.C6367d;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.eventchain.C6372b;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class gw extends cz {
    @Override // tb.cz
    protected Object a(DXRuntimeContext dXRuntimeContext) {
        DinamicXEngine e;
        C6372b o;
        C9192h j;
        C6367d engineContext = dXRuntimeContext.getEngineContext();
        if (engineContext == null || (e = engineContext.e()) == null || (o = e.o()) == null || (j = o.j()) == null) {
            return null;
        }
        return j.d();
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "getEngineStorage";
    }
}
