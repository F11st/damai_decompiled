package tb;

import com.taobao.android.dinamicx.DXGlobalCenter;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.IDXHardwareInterface;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class wv extends AbstractC6375a {
    public static final long DX_PARSER_DXDEVICELEVEL = 3863236816138429745L;
    public static final String PARAM_LEVEL_HIGH = "high";
    public static final String PARAM_LEVEL_LOW = "low";
    public static final String PARAM_LEVEL_MEDIUM = "medium";
    public static final String PARAM_LEVEL_UNKNOWN = "unknown";

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null && objArr.length != 0) {
            IDXHardwareInterface c = DXGlobalCenter.c();
            if (c == null) {
                return Boolean.FALSE;
            }
            Object obj = objArr[0];
            if (!(obj instanceof String)) {
                return Boolean.FALSE;
            }
            String lowerCase = ((String) obj).toLowerCase();
            try {
                int deviceLevel = c.getDeviceLevel();
                if ("low".equals(lowerCase)) {
                    return Boolean.valueOf(deviceLevel == 2);
                } else if (PARAM_LEVEL_MEDIUM.equals(lowerCase)) {
                    return Boolean.valueOf(deviceLevel == 1);
                } else if ("high".equals(lowerCase)) {
                    return Boolean.valueOf(deviceLevel == 0);
                } else if ("unknown".equals(lowerCase)) {
                    return Boolean.valueOf(deviceLevel == -1);
                } else {
                    return Boolean.FALSE;
                }
            } catch (Throwable unused) {
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }
}
