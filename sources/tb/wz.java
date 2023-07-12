package tb;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class wz extends hy {
    protected Map<String, String> d;

    public wz(long j) {
        super(j);
        this.d = null;
    }

    public void f(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.d == null) {
            this.d = new HashMap();
        }
        this.d.put(str, str2);
        Map<String, az> a = a();
        if (a == null) {
            a = new HashMap<>();
            d(a);
        }
        a.put(str, az.N(str2));
    }
}
