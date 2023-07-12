package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ck2 extends com.taobao.android.dinamicx.expression.parser.a {
    public static final String PARSER_TAG = "tdcolor";

    private Object a(Object[] objArr, DXRuntimeContext dXRuntimeContext) throws Exception {
        String a = rq1.a(objArr, 2, new Class[]{null, String.class});
        if (TextUtils.isEmpty(a)) {
            Object obj = objArr[0];
            String str = (String) objArr[1];
            if (obj != null) {
                String obj2 = obj.toString();
                if (rk.e(obj2, 0) == 0) {
                    return str;
                }
                if (obj2.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX)) {
                    return obj2;
                }
                return obj2 + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX;
            }
            return str;
        }
        throw new RuntimeException(a);
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        try {
            return a(objArr, dXRuntimeContext);
        } catch (Exception e) {
            vt2.b(PARSER_TAG, String.valueOf(objArr), e.toString(), String.valueOf(dXRuntimeContext));
            return null;
        }
    }
}
