package tb;

import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ki2 {
    public String[] a;

    public ki2(String[] strArr) {
        this.a = strArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ki2.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.a, ((ki2) obj).a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public String toString() {
        return "SubKey{podNames=" + Arrays.toString(this.a) + '}';
    }
}
