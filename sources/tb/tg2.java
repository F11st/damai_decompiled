package tb;

import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class tg2 {
    @NotNull
    public static final <T> T a(@NotNull NotNullLazyValue<? extends T> notNullLazyValue, @Nullable Object obj, @NotNull KProperty<?> kProperty) {
        b41.i(notNullLazyValue, "<this>");
        b41.i(kProperty, "p");
        return notNullLazyValue.invoke();
    }

    @Nullable
    public static final <T> T b(@NotNull NullableLazyValue<? extends T> nullableLazyValue, @Nullable Object obj, @NotNull KProperty<?> kProperty) {
        b41.i(nullableLazyValue, "<this>");
        b41.i(kProperty, "p");
        return nullableLazyValue.invoke();
    }
}
