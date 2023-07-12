package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import tb.oz;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yu extends et {
    @Override // tb.et
    public Object a(Object[] objArr, DXRuntimeContext dXRuntimeContext, oz.a aVar, int i) {
        if (!uz.d(objArr[i])) {
            aVar.a = true;
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return m80.AND_PREFIX;
    }
}
