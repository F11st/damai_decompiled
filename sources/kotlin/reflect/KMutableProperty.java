package kotlin.reflect;

import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface KMutableProperty<V> extends KProperty<V> {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface Setter<V> extends KProperty.Accessor<V>, KFunction<wt2> {
    }

    @NotNull
    Setter<V> getSetter();
}
