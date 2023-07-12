package kotlin.reflect;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.KMutableProperty;
import org.jetbrains.annotations.NotNull;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface KMutableProperty1<T, V> extends KProperty1<T, V>, KMutableProperty<V> {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface Setter<T, V> extends KMutableProperty.Setter<V>, Function2<T, V, wt2> {
    }

    @Override // kotlin.reflect.KMutableProperty
    @NotNull
    Setter<T, V> getSetter();

    void set(T t, V v);
}
