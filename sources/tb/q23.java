package tb;

import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class q23 extends j30 {
    public Set<String> b;

    public void a(String str) {
        if (str != null) {
            if (this.b == null) {
                this.b = new HashSet();
            }
            if (this.b.contains(str)) {
                return;
            }
            this.b.add(str);
        }
    }
}
