package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.storage.CacheWithNullableValues;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class u52 implements SamConversionResolver {
    @NotNull
    private final Iterable<Object> a;
    @NotNull
    private final CacheWithNullableValues<ClassDescriptor, fd2> b;

    public u52(@NotNull StorageManager storageManager, @NotNull Iterable<? extends Object> iterable) {
        b41.i(storageManager, "storageManager");
        b41.i(iterable, "samWithReceiverResolvers");
        this.a = iterable;
        this.b = storageManager.createCacheWithNullableValues();
    }
}
