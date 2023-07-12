package tb;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ge2 {
    private final String a;
    private final String b;
    private final int c;
    private final boolean d;
    private String e = "remote";
    private String f;
    private List<pe2> g;

    public ge2(String str, String str2, int i, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = z;
    }

    public String a() {
        return this.a;
    }

    public List<pe2> b() {
        return this.g;
    }

    public boolean c() {
        return this.d;
    }

    public String d() {
        return this.f;
    }

    public String e() {
        return this.e;
    }

    public int f() {
        return this.c;
    }

    public void g(String str) {
        this.f = str;
    }

    public void h(String str) {
        this.e = str;
    }

    public void i(List<pe2> list) {
        this.g = list;
    }

    public String j() {
        return this.b;
    }
}
