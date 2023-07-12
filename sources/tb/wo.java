package tb;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class wo {
    public String a;
    public double b;
    public String c;
    public String d;

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("[module:");
        sb.append(this.c);
        sb.append(" modulePoint:");
        sb.append(this.d);
        sb.append(" arg:");
        sb.append(this.a);
        sb.append(" value:");
        sb.append(this.b);
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }
}
