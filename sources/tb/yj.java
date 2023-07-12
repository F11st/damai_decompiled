package tb;

import java.io.Closeable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yj {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }
}
