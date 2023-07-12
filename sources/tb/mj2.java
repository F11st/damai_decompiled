package tb;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class mj2 {
    public static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, str);
        } catch (Exception unused) {
            return "";
        }
    }
}
