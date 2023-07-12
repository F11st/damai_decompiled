package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface TypeMappingConfiguration<T> {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        @Nullable
        public static <T> String a(@NotNull TypeMappingConfiguration<? extends T> typeMappingConfiguration, @NotNull ClassDescriptor classDescriptor) {
            b41.i(typeMappingConfiguration, "this");
            b41.i(classDescriptor, "classDescriptor");
            return null;
        }

        @Nullable
        public static <T> z71 b(@NotNull TypeMappingConfiguration<? extends T> typeMappingConfiguration, @NotNull z71 z71Var) {
            b41.i(typeMappingConfiguration, "this");
            b41.i(z71Var, "kotlinType");
            return null;
        }

        public static <T> boolean c(@NotNull TypeMappingConfiguration<? extends T> typeMappingConfiguration) {
            b41.i(typeMappingConfiguration, "this");
            return true;
        }
    }

    @NotNull
    z71 commonSupertype(@NotNull Collection<z71> collection);

    @Nullable
    String getPredefinedFullInternalNameForClass(@NotNull ClassDescriptor classDescriptor);

    @Nullable
    String getPredefinedInternalNameForClass(@NotNull ClassDescriptor classDescriptor);

    @Nullable
    T getPredefinedTypeForClass(@NotNull ClassDescriptor classDescriptor);

    @Nullable
    z71 preprocessType(@NotNull z71 z71Var);

    void processErrorType(@NotNull z71 z71Var, @NotNull ClassDescriptor classDescriptor);

    boolean releaseCoroutines();
}
