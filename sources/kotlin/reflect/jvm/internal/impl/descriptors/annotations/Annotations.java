package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.k;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.e6;
import tb.hp0;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface Annotations extends Iterable<AnnotationDescriptor>, KMappedMarker {
    @NotNull
    public static final a Companion = a.a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        static final /* synthetic */ a a = new a();
        @NotNull
        private static final Annotations b = new C0414a();

        /* compiled from: Taobao */
        /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0414a implements Annotations {
            C0414a() {
            }

            @Nullable
            public Void a(@NotNull hp0 hp0Var) {
                b41.i(hp0Var, "fqName");
                return null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            public /* bridge */ /* synthetic */ AnnotationDescriptor findAnnotation(hp0 hp0Var) {
                return (AnnotationDescriptor) a(hp0Var);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            public boolean hasAnnotation(@NotNull hp0 hp0Var) {
                return b.b(this, hp0Var);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            @NotNull
            public Iterator<AnnotationDescriptor> iterator() {
                return k.g().iterator();
            }

            @NotNull
            public String toString() {
                return "EMPTY";
            }
        }

        private a() {
        }

        @NotNull
        public final Annotations a(@NotNull List<? extends AnnotationDescriptor> list) {
            b41.i(list, "annotations");
            return list.isEmpty() ? b : new e6(list);
        }

        @NotNull
        public final Annotations b() {
            return b;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class b {
        @Nullable
        public static AnnotationDescriptor a(@NotNull Annotations annotations, @NotNull hp0 hp0Var) {
            AnnotationDescriptor annotationDescriptor;
            b41.i(annotations, "this");
            b41.i(hp0Var, "fqName");
            Iterator<AnnotationDescriptor> it = annotations.iterator();
            while (true) {
                if (!it.hasNext()) {
                    annotationDescriptor = null;
                    break;
                }
                annotationDescriptor = it.next();
                if (b41.d(annotationDescriptor.getFqName(), hp0Var)) {
                    break;
                }
            }
            return annotationDescriptor;
        }

        public static boolean b(@NotNull Annotations annotations, @NotNull hp0 hp0Var) {
            b41.i(annotations, "this");
            b41.i(hp0Var, "fqName");
            return annotations.findAnnotation(hp0Var) != null;
        }
    }

    @Nullable
    AnnotationDescriptor findAnnotation(@NotNull hp0 hp0Var);

    boolean hasAnnotation(@NotNull hp0 hp0Var);

    boolean isEmpty();
}
