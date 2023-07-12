package kotlin.reflect;

import kotlin.jvm.functions.Function3;
import kotlin.reflect.KMutableProperty;
import org.jetbrains.annotations.NotNull;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface KMutableProperty2<D, E, V> extends KProperty2<D, E, V>, KMutableProperty<V> {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface Setter<D, E, V> extends KMutableProperty.Setter<V>, Function3<D, E, V, wt2> {
    }

    @Override // kotlin.reflect.KMutableProperty
    @NotNull
    Setter<D, E, V> getSetter();

    void set(D d, E e, V v);
}
