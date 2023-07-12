package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class j33 {
    public final String a;
    public final int b;
    public final String c;
    public final int d;
    public final boolean e;

    public j33(String str, int i, String str2, int i2, boolean z) {
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = i2;
        this.e = z;
    }

    public abstract com.uploader.implement.b.e a(com.uploader.implement.c cVar);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j33) {
            j33 j33Var = (j33) obj;
            if (this.b == j33Var.b && this.d == j33Var.d && this.e == j33Var.e) {
                String str = this.a;
                if (str == null ? j33Var.a == null : str.equals(j33Var.a)) {
                    String str2 = this.c;
                    String str3 = j33Var.c;
                    if (str2 != null) {
                        if (str2.equals(str3)) {
                            return true;
                        }
                    } else if (str3 == null) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        return "ConnectionTarget{address='" + this.a + "', port=" + this.b + ", proxyIp='" + this.c + "', proxyPort=" + this.d + ", isLongLived=" + this.e + '}';
    }
}
