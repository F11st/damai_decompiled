package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.hp0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class CompositeAnnotations implements Annotations {
    @NotNull
    private final List<Annotations> a;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositeAnnotations(@NotNull List<? extends Annotations> list) {
        b41.i(list, "delegates");
        this.a = list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull final hp0 hp0Var) {
        Sequence I;
        Sequence w;
        b41.i(hp0Var, "fqName");
        I = CollectionsKt___CollectionsKt.I(this.a);
        w = SequencesKt___SequencesKt.w(I, new Function1<Annotations, AnnotationDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations$findAnnotation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final AnnotationDescriptor invoke(@NotNull Annotations annotations) {
                b41.i(annotations, AdvanceSetting.NETWORK_TYPE);
                return annotations.findAnnotation(hp0.this);
            }
        });
        return (AnnotationDescriptor) d.s(w);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull hp0 hp0Var) {
        Sequence<Annotations> I;
        b41.i(hp0Var, "fqName");
        I = CollectionsKt___CollectionsKt.I(this.a);
        for (Annotations annotations : I) {
            if (annotations.hasAnnotation(hp0Var)) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        List<Annotations> list = this.a;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (Annotations annotations : list) {
            if (!annotations.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        Sequence I;
        I = CollectionsKt___CollectionsKt.I(this.a);
        return SequencesKt___SequencesKt.t(I, new Function1<Annotations, Sequence<? extends AnnotationDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations$iterator$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Sequence<AnnotationDescriptor> invoke(@NotNull Annotations annotations) {
                Sequence<AnnotationDescriptor> I2;
                b41.i(annotations, AdvanceSetting.NETWORK_TYPE);
                I2 = CollectionsKt___CollectionsKt.I(annotations);
                return I2;
            }
        }).iterator();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CompositeAnnotations(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations... r2) {
        /*
            r1 = this;
            java.lang.String r0 = "delegates"
            tb.b41.i(r2, r0)
            java.util.List r2 = kotlin.collections.e.X(r2)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations.<init>(kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations[]):void");
    }
}
