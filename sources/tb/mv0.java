package tb;

import android.content.Context;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
class mv0 {
    private static final String a = ".UTSystemConfig" + File.separator + "Global";

    public static nr1 a(Context context) {
        if (context != null) {
            return new nr1(context, a, "Alvin3", false, true);
        }
        return null;
    }

    public static nr1 b(Context context) {
        if (context != null) {
            return new nr1(context, a, "UTCommon", false, true);
        }
        return null;
    }
}
