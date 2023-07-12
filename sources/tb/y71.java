package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class y71 implements DeserializedContainerSource {
    @NotNull
    private final KotlinJvmBinaryClass a;

    public y71(@NotNull KotlinJvmBinaryClass kotlinJvmBinaryClass, @Nullable g21<x61> g21Var, boolean z, @NotNull DeserializedContainerAbiStability deserializedContainerAbiStability) {
        b41.i(kotlinJvmBinaryClass, "binaryClass");
        b41.i(deserializedContainerAbiStability, "abiStability");
        this.a = kotlinJvmBinaryClass;
    }

    @NotNull
    public final KotlinJvmBinaryClass a() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.SourceElement
    @NotNull
    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        b41.h(sourceFile, "NO_SOURCE_FILE");
        return sourceFile;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource
    @NotNull
    public String getPresentableString() {
        return "Class '" + this.a.getClassId().b().b() + '\'';
    }

    @NotNull
    public String toString() {
        return ((Object) y71.class.getSimpleName()) + ": " + this.a;
    }
}
