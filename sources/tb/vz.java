package tb;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vz extends hy {
    public vz(long j) {
        super(j);
    }

    public void f(String str, String str2) {
        Map<String, az> a = a();
        if (a == null) {
            a = new HashMap<>();
            d(a);
        }
        a.put(str, az.N(str2));
    }
}
