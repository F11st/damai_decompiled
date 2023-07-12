package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface StorageManager {
    <T> T compute(@NotNull Function0<? extends T> function0);

    @NotNull
    <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues();

    @NotNull
    <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues();

    @NotNull
    <T> NotNullLazyValue<T> createLazyValue(@NotNull Function0<? extends T> function0);

    @NotNull
    <T> NotNullLazyValue<T> createLazyValueWithPostCompute(@NotNull Function0<? extends T> function0, @Nullable Function1<? super Boolean, ? extends T> function1, @NotNull Function1<? super T, wt2> function12);

    @NotNull
    <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> function1);

    @NotNull
    <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> function1);

    @NotNull
    <T> NullableLazyValue<T> createNullableLazyValue(@NotNull Function0<? extends T> function0);

    @NotNull
    <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(@NotNull Function0<? extends T> function0, @NotNull T t);
}
