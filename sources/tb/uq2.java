package tb;

import java.util.Collection;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class uq2 implements TypeMappingConfiguration<c71> {
    @NotNull
    public static final uq2 INSTANCE = new uq2();

    private uq2() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    @Nullable
    /* renamed from: a */
    public c71 getPredefinedTypeForClass(@NotNull ClassDescriptor classDescriptor) {
        b41.i(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    @NotNull
    public z71 commonSupertype(@NotNull Collection<? extends z71> collection) {
        String Z;
        b41.i(collection, "types");
        Z = CollectionsKt___CollectionsKt.Z(collection, null, null, null, 0, null, null, 63, null);
        throw new AssertionError(b41.r("There should be no intersection type in existing descriptors, but found: ", Z));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    @Nullable
    public String getPredefinedFullInternalNameForClass(@NotNull ClassDescriptor classDescriptor) {
        return TypeMappingConfiguration.a.a(this, classDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    @Nullable
    public String getPredefinedInternalNameForClass(@NotNull ClassDescriptor classDescriptor) {
        b41.i(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    @Nullable
    public z71 preprocessType(@NotNull z71 z71Var) {
        return TypeMappingConfiguration.a.b(this, z71Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public void processErrorType(@NotNull z71 z71Var, @NotNull ClassDescriptor classDescriptor) {
        b41.i(z71Var, "kotlinType");
        b41.i(classDescriptor, "descriptor");
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration
    public boolean releaseCoroutines() {
        return TypeMappingConfiguration.a.c(this);
    }
}
