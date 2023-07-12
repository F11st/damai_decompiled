package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class l41 {
    public String a;
    public long b;
    public String c;
    public String d;

    public l41() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l41) {
            l41 l41Var = (l41) obj;
            String str = this.a;
            if (str == null ? l41Var.a == null : str.equals(l41Var.a)) {
                String str2 = this.d;
                String str3 = l41Var.d;
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

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.d;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Item{url='" + this.a + "', size=" + this.b + ", md5='" + this.c + "', name='" + this.d + "'}";
    }

    public l41(String str) {
        this.a = str;
    }
}
