package tb;

import android.content.pm.PackageManager;
import android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class rv extends com.taobao.android.dinamicx.expression.parser.a {
    public static final long DX_PARSER_DX_ENV = 9060459234603530L;

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[0];
            if (!(obj instanceof String)) {
                return null;
            }
            String lowerCase = ((String) obj).toLowerCase();
            if (lowerCase.equals("platform")) {
                return "1";
            }
            if (lowerCase.equals("platformdetail")) {
                return "-1";
            }
            if (lowerCase.equals("platformmodel")) {
                return Build.getMODEL();
            }
            if (lowerCase.equals("osversion")) {
                return Build.VERSION.INCREMENTAL;
            }
            if (lowerCase.equals("appversion")) {
                if (dXRuntimeContext == null || dXRuntimeContext.getContext() == null) {
                    return null;
                }
                try {
                    return dXRuntimeContext.getContext().getPackageManager().getPackageInfo(dXRuntimeContext.getContext().getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                    return null;
                }
            } else if (lowerCase.equals("sdkversion")) {
                return "3.9.10.3";
            } else {
                if (lowerCase.equals("systemtime")) {
                    return String.valueOf(System.currentTimeMillis());
                }
            }
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "dx_env";
    }
}
