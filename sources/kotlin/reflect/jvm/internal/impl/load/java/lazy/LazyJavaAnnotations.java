package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import com.huawei.hms.opendevice.c;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hp0;
import tb.k50;
import tb.r81;
import tb.z41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class LazyJavaAnnotations implements Annotations {
    @NotNull
    private final r81 a;
    @NotNull
    private final JavaAnnotationOwner b;
    private final boolean c;
    @NotNull
    private final MemoizedFunctionToNullable<JavaAnnotation, AnnotationDescriptor> d;

    public LazyJavaAnnotations(@NotNull r81 r81Var, @NotNull JavaAnnotationOwner javaAnnotationOwner, boolean z) {
        b41.i(r81Var, c.a);
        b41.i(javaAnnotationOwner, "annotationOwner");
        this.a = r81Var;
        this.b = javaAnnotationOwner;
        this.c = z;
        this.d = r81Var.a().u().createMemoizedFunctionWithNullableValues(new Function1<JavaAnnotation, AnnotationDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations$annotationDescriptors$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final AnnotationDescriptor invoke(@NotNull JavaAnnotation javaAnnotation) {
                r81 r81Var2;
                boolean z2;
                b41.i(javaAnnotation, "annotation");
                z41 z41Var = z41.INSTANCE;
                r81Var2 = LazyJavaAnnotations.this.a;
                z2 = LazyJavaAnnotations.this.c;
                return z41Var.e(javaAnnotation, r81Var2, z2);
            }
        });
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        JavaAnnotation findAnnotation = this.b.findAnnotation(hp0Var);
        AnnotationDescriptor invoke = findAnnotation == null ? null : this.d.invoke(findAnnotation);
        return invoke == null ? z41.INSTANCE.a(hp0Var, this.b, this.a) : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull hp0 hp0Var) {
        return Annotations.b.b(this, hp0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return this.b.getAnnotations().isEmpty() && !this.b.isDeprecatedInJavaDoc();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        Sequence I;
        Sequence v;
        Sequence y;
        Sequence q;
        I = CollectionsKt___CollectionsKt.I(this.b.getAnnotations());
        v = SequencesKt___SequencesKt.v(I, this.d);
        y = SequencesKt___SequencesKt.y(v, z41.INSTANCE.a(c.a.deprecated, this.b, this.a));
        q = SequencesKt___SequencesKt.q(y);
        return q.iterator();
    }

    public /* synthetic */ LazyJavaAnnotations(r81 r81Var, JavaAnnotationOwner javaAnnotationOwner, boolean z, int i, k50 k50Var) {
        this(r81Var, javaAnnotationOwner, (i & 4) != 0 ? false : z);
    }
}
