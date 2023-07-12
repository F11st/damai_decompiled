package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import tb.oz;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class xx extends et {
    @Override // tb.et
    public Object a(Object[] objArr, DXRuntimeContext dXRuntimeContext, oz.a aVar, int i) {
        if (dXRuntimeContext != null && dXRuntimeContext.isOpenNewFastReturnLogic() && i == 0) {
            if (uz.d(objArr[0])) {
                return null;
            }
            aVar.a = false;
            aVar.b = 1;
        }
        if (i < 1) {
            return null;
        }
        if (i == 1) {
            if (uz.d(objArr[0])) {
                aVar.a = true;
                return objArr[1];
            }
            return null;
        }
        aVar.a = true;
        if (i == 2) {
            return objArr[2];
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return m80.TRIPLE_PREFIX;
    }
}
