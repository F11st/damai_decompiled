package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import tb.oz;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class dx extends et {
    @Override // tb.et
    public Object a(Object[] objArr, DXRuntimeContext dXRuntimeContext, oz.a aVar, int i) {
        if (uz.d(objArr[i])) {
            aVar.a = true;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return m80.OR_PREFIX;
    }
}
