package tb;

import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class b51 implements ClassDataFinder {
    @NotNull
    private final KotlinClassFinder a;
    @NotNull
    private final DeserializedDescriptorResolver b;

    public b51(@NotNull KotlinClassFinder kotlinClassFinder, @NotNull DeserializedDescriptorResolver deserializedDescriptorResolver) {
        b41.i(kotlinClassFinder, "kotlinClassFinder");
        b41.i(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        this.a = kotlinClassFinder;
        this.b = deserializedDescriptorResolver;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    @Nullable
    public ej findClassData(@NotNull hj hjVar) {
        b41.i(hjVar, "classId");
        KotlinJvmBinaryClass b = w71.b(this.a, hjVar);
        if (b == null) {
            return null;
        }
        b41.d(b.getClassId(), hjVar);
        return this.b.j(b);
    }
}
