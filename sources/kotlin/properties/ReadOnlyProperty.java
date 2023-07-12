package kotlin.properties;

import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ReadOnlyProperty<T, V> {
    V getValue(T t, @NotNull KProperty<?> kProperty);
}
