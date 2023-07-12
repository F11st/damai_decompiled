package tb;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.C8214m;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class te0 implements Annotations {
    @NotNull
    private final hp0 a;

    public te0(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqNameToMatch");
        this.a = hp0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    @Nullable
    /* renamed from: a */
    public se0 findAnnotation(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        if (b41.d(hp0Var, this.a)) {
            return se0.INSTANCE;
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull hp0 hp0Var) {
        return Annotations.C8304b.b(this, hp0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        List g;
        g = C8214m.g();
        return g.iterator();
    }
}
