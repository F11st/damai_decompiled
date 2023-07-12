package tb;

import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class om1<V> implements ReadWriteProperty<Object, V> {
    private V a;

    public om1(V v) {
        this.a = v;
    }

    protected void a(@NotNull KProperty<?> kProperty, V v, V v2) {
        b41.i(kProperty, "property");
    }

    protected boolean b(@NotNull KProperty<?> kProperty, V v, V v2) {
        b41.i(kProperty, "property");
        return true;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public V getValue(@Nullable Object obj, @NotNull KProperty<?> kProperty) {
        b41.i(kProperty, "property");
        return this.a;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(@Nullable Object obj, @NotNull KProperty<?> kProperty, V v) {
        b41.i(kProperty, "property");
        V v2 = this.a;
        if (b(kProperty, v2, v)) {
            this.a = v;
            a(kProperty, v2, v);
        }
    }
}
