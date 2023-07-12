package tb;

import androidx.annotation.RestrictTo;
import java.util.List;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes9.dex */
public class cp0 {
    private final List<lb2> a;
    private final char b;
    private final double c;
    private final String d;
    private final String e;

    public cp0(List<lb2> list, char c, double d, double d2, String str, String str2) {
        this.a = list;
        this.b = c;
        this.c = d2;
        this.d = str;
        this.e = str2;
    }

    public static int c(char c, String str, String str2) {
        return ((((0 + c) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<lb2> a() {
        return this.a;
    }

    public double b() {
        return this.c;
    }

    public int hashCode() {
        return c(this.b, this.e, this.d);
    }
}
