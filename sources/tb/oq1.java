package tb;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes5.dex */
public class oq1 {
    public static int a(String str) {
        if (yh2.g(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return 0;
    }
}
