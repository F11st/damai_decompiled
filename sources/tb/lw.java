package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import tb.oz;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class lw extends et {
    @Override // tb.et
    public Object a(Object[] objArr, DXRuntimeContext dXRuntimeContext, oz.a aVar, int i) {
        if (i == 0) {
            aVar.a = !uz.d(objArr[0]);
            return null;
        }
        aVar.a = true;
        if (i == 1) {
            return objArr[1];
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return m80.MATCH_PREFIX;
    }
}
