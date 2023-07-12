package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qf2 {
    private final String a;
    private final long b;

    public qf2(String str, long j) {
        this.a = str;
        this.b = j;
    }

    public String a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || qf2.class != obj.getClass()) {
            return false;
        }
        qf2 qf2Var = (qf2) obj;
        String str = this.a;
        return str != null && str.equals(qf2Var.a);
    }

    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return this.a;
    }
}
