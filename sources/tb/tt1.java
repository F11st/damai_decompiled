package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class tt1 {
    @NotNull
    private final ClassifierDescriptorWithTypeParameters a;
    @NotNull
    private final List<TypeProjection> b;
    @Nullable
    private final tt1 c;

    /* JADX WARN: Multi-variable type inference failed */
    public tt1(@NotNull ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, @NotNull List<? extends TypeProjection> list, @Nullable tt1 tt1Var) {
        b41.i(classifierDescriptorWithTypeParameters, "classifierDescriptor");
        b41.i(list, "arguments");
        this.a = classifierDescriptorWithTypeParameters;
        this.b = list;
        this.c = tt1Var;
    }

    @NotNull
    public final List<TypeProjection> a() {
        return this.b;
    }

    @NotNull
    public final ClassifierDescriptorWithTypeParameters b() {
        return this.a;
    }

    @Nullable
    public final tt1 c() {
        return this.c;
    }
}
