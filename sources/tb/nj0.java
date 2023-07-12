package tb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class nj0 implements Annotations {
    @NotNull
    private final Annotations a;
    private final boolean b;
    @NotNull
    private final Function1<hp0, Boolean> c;

    /* JADX WARN: Multi-variable type inference failed */
    public nj0(@NotNull Annotations annotations, boolean z, @NotNull Function1<? super hp0, Boolean> function1) {
        b41.i(annotations, "delegate");
        b41.i(function1, "fqNameFilter");
        this.a = annotations;
        this.b = z;
        this.c = function1;
    }

    private final boolean a(AnnotationDescriptor annotationDescriptor) {
        hp0 fqName = annotationDescriptor.getFqName();
        return fqName != null && this.c.invoke(fqName).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        if (this.c.invoke(hp0Var).booleanValue()) {
            return this.a.findAnnotation(hp0Var);
        }
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        if (this.c.invoke(hp0Var).booleanValue()) {
            return this.a.hasAnnotation(hp0Var);
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        boolean z;
        Annotations<AnnotationDescriptor> annotations = this.a;
        if (!(annotations instanceof Collection) || !((Collection) annotations).isEmpty()) {
            for (AnnotationDescriptor annotationDescriptor : annotations) {
                if (a(annotationDescriptor)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return this.b ? !z : z;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        Annotations annotations = this.a;
        ArrayList arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : annotations) {
            if (a(annotationDescriptor)) {
                arrayList.add(annotationDescriptor);
            }
        }
        return arrayList.iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public nj0(@NotNull Annotations annotations, @NotNull Function1<? super hp0, Boolean> function1) {
        this(annotations, false, function1);
        b41.i(annotations, "delegate");
        b41.i(function1, "fqNameFilter");
    }
}
