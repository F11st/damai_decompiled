package kotlin.properties;

import kotlin.SinceKotlin;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@SinceKotlin(version = "1.4")
/* loaded from: classes3.dex */
public interface PropertyDelegateProvider<T, D> {
    D provideDelegate(T t, @NotNull KProperty<?> kProperty);
}
