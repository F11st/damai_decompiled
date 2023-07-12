package tb;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.DXRuntimeContext;
import java.util.StringTokenizer;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cz extends com.taobao.android.dinamicx.expression.parser.a {
    private Object c(DXRuntimeContext dXRuntimeContext, Object obj, String str) {
        if (obj == null || str == null) {
            return null;
        }
        return cy.a(dXRuntimeContext, obj, str);
    }

    protected Object a(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null) {
            return null;
        }
        return dXRuntimeContext.getData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object b(@NonNull String str, Object obj, DXRuntimeContext dXRuntimeContext) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, " .[]", false);
        while (stringTokenizer.hasMoreTokens()) {
            obj = c(dXRuntimeContext, obj, stringTokenizer.nextToken());
        }
        return obj;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        Object a = a(dXRuntimeContext);
        if (objArr == null || objArr.length == 0) {
            return a;
        }
        if (objArr.length > 1) {
            return null;
        }
        Object obj = objArr[0];
        if (obj instanceof String) {
            return b((String) obj, a, dXRuntimeContext);
        }
        return null;
    }
}
