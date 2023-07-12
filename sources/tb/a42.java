package tb;

import android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a42 {
    private static String a;

    static {
        a = Build.getCPU_ABI();
        if (Build.VERSION.SDK_INT >= 21) {
            if (qp.getCurrentRuntimeCpuArchValue(eu0.d().b()) == 8) {
                String[] strArr = android.os.Build.SUPPORTED_64_BIT_ABIS;
                if (strArr.length > 0) {
                    a = strArr[0];
                    return;
                }
            }
            String[] strArr2 = android.os.Build.SUPPORTED_32_BIT_ABIS;
            if (strArr2.length > 0) {
                a = strArr2[0];
            }
        }
    }

    public static String a() {
        return a;
    }
}
