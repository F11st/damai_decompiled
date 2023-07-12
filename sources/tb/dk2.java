package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class dk2 extends AbstractC6375a {
    public static final String PARSER_TAG = "tdPlatform";

    private Object a(Object[] objArr, DXRuntimeContext dXRuntimeContext) throws Exception {
        String a = qq1.a(objArr, 1, new Class[]{String.class});
        if (TextUtils.isEmpty(a)) {
            if ("Android".equalsIgnoreCase(((String) objArr[0]).trim())) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        throw new RuntimeException(a);
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        try {
            return a(objArr, dXRuntimeContext);
        } catch (Exception unused) {
            return null;
        }
    }
}
