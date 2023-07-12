package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ee2 {
    private final String a;
    private final String b;
    private final String c;
    private final transient int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ee2(String str, String str2, String str3, int i) {
        this.b = str;
        this.c = str2;
        this.a = str3;
        this.d = i;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.c;
    }

    public String toString() {
        return this.c + jn1.BRACKET_START_STR + this.d + jn1.BRACKET_END_STR;
    }
}
