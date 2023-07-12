package anet.channel;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import tb.xa2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class b {
    Map<String, Integer> a = new HashMap();
    Map<String, xa2> b = new ConcurrentHashMap();

    public int a(String str) {
        Integer num;
        synchronized (this.a) {
            num = this.a.get(str);
        }
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xa2 b(String str) {
        return this.b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<xa2> c() {
        return this.b.values();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.a) {
                this.a.put(str, Integer.valueOf(i));
            }
            return;
        }
        throw new IllegalArgumentException("host cannot be null or empty");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(xa2 xa2Var) {
        Objects.requireNonNull(xa2Var, "info is null");
        if (!TextUtils.isEmpty(xa2Var.a)) {
            this.b.put(xa2Var.a, xa2Var);
            return;
        }
        throw new IllegalArgumentException("host cannot be null or empty");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public xa2 f(String str) {
        return this.b.remove(str);
    }
}
