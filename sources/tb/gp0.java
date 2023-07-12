package tb;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractC5205t;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public abstract class gp0<K, V> extends AbstractC5205t implements Map.Entry<K, V> {
    protected abstract Map.Entry<K, V> a();

    public boolean equals(@NullableDecl Object obj) {
        return a().equals(obj);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return a().getKey();
    }

    public V getValue() {
        return a().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return a().hashCode();
    }

    public V setValue(V v) {
        return a().setValue(v);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean standardEquals(@NullableDecl Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return nm1.a(getKey(), entry.getKey()) && nm1.a(getValue(), entry.getValue());
        }
        return false;
    }
}
