package tb;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class hd1 {
    private static String d = "\r";
    private final String a;
    public final float b;
    public final float c;

    public hd1(String str, float f, float f2) {
        this.a = str;
        this.c = f2;
        this.b = f;
    }

    public boolean a(String str) {
        if (this.a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.a.endsWith(d)) {
            String str2 = this.a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
