package tb;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class yv0<K, V> {
    private final HashMap<K, ArrayList<V>> a = new HashMap<>();

    public ArrayList<V> a(K k) {
        return this.a.get(k);
    }

    public HashMap<K, ArrayList<V>> b() {
        return this.a;
    }

    public void c(K k, V v) {
        ArrayList<V> a = a(k);
        if (a == null) {
            a = new ArrayList<>();
        }
        a.add(v);
        this.a.put(k, a);
    }
}
