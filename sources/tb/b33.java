package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b33 {
    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(null, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b() {
        return "file".equals(a("ro.crypto.type"));
    }
}
