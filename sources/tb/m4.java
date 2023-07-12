package tb;

import android.app.ActivityManager;
import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class m4 {
    public float a = 0.0f;
    public int b;

    public void a(Context context) {
        if (this.a == 0.0f && context != null) {
            float f = 2.0f;
            try {
                String glEsVersion = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().getGlEsVersion();
                if (glEsVersion != null) {
                    f = Float.parseFloat(glEsVersion);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.a = f;
            this.b = b(f);
        }
    }

    @Deprecated
    public int b(float f) {
        double d = f;
        int i = (d > 4.0d ? 1 : (d == 4.0d ? 0 : -1));
        if (i > 0) {
            return 10;
        }
        if (i >= 0) {
            return 9;
        }
        if (d >= 3.2d) {
            return 8;
        }
        if (d >= 3.1d) {
            return 7;
        }
        if (d >= 3.0d) {
            return 6;
        }
        return d >= 2.0d ? 3 : 8;
    }
}
