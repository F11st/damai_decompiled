package tb;

import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class e6 implements Annotations {
    @NotNull
    private final List<AnnotationDescriptor> a;

    /* JADX WARN: Multi-variable type inference failed */
    public e6(@NotNull List<? extends AnnotationDescriptor> list) {
        b41.i(list, "annotations");
        this.a = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull hp0 hp0Var) {
        return Annotations.C8304b.a(this, hp0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull hp0 hp0Var) {
        return Annotations.C8304b.b(this, hp0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return this.a.iterator();
    }

    @NotNull
    public String toString() {
        return this.a.toString();
    }
}
