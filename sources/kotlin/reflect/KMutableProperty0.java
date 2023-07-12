package kotlin.reflect;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KMutableProperty;
import org.jetbrains.annotations.NotNull;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface KMutableProperty0<V> extends KProperty0<V>, KMutableProperty<V> {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface Setter<V> extends KMutableProperty.Setter<V>, Function1<V, wt2> {
    }

    @Override // kotlin.reflect.KMutableProperty
    @NotNull
    Setter<V> getSetter();

    void set(V v);
}
