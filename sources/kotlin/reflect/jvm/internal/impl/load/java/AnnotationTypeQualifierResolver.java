package kotlin.reflect.jvm.internal.impl.load.java;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.C8220r;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationTargetMapper;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.b6;
import tb.c51;
import tb.c6;
import tb.fm1;
import tb.fn;
import tb.hp0;
import tb.ni1;
import tb.o61;
import tb.xe0;
import tb.y7;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class AnnotationTypeQualifierResolver {
    @NotNull
    private final JavaTypeEnhancementState a;
    @NotNull
    private final MemoizedFunctionToNullable<ClassDescriptor, AnnotationDescriptor> b;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$a */
    /* loaded from: classes3.dex */
    public static final class C8326a {
        @NotNull
        private final AnnotationDescriptor a;
        private final int b;

        public C8326a(@NotNull AnnotationDescriptor annotationDescriptor, int i) {
            b41.i(annotationDescriptor, "typeQualifier");
            this.a = annotationDescriptor;
            this.b = i;
        }

        private final boolean c(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
            return ((1 << annotationQualifierApplicabilityType.ordinal()) & this.b) != 0;
        }

        private final boolean d(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
            if (c(annotationQualifierApplicabilityType)) {
                return true;
            }
            return c(AnnotationQualifierApplicabilityType.TYPE_USE) && annotationQualifierApplicabilityType != AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
        }

        @NotNull
        public final AnnotationDescriptor a() {
            return this.a;
        }

        @NotNull
        public final List<AnnotationQualifierApplicabilityType> b() {
            AnnotationQualifierApplicabilityType[] values = AnnotationQualifierApplicabilityType.values();
            ArrayList arrayList = new ArrayList();
            for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : values) {
                if (d(annotationQualifierApplicabilityType)) {
                    arrayList.add(annotationQualifierApplicabilityType);
                }
            }
            return arrayList;
        }
    }

    public AnnotationTypeQualifierResolver(@NotNull StorageManager storageManager, @NotNull JavaTypeEnhancementState javaTypeEnhancementState) {
        b41.i(storageManager, "storageManager");
        b41.i(javaTypeEnhancementState, "javaTypeEnhancementState");
        this.a = javaTypeEnhancementState;
        this.b = storageManager.createMemoizedFunctionWithNullableValues(new AnnotationTypeQualifierResolver$resolvedNicknames$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnnotationDescriptor c(ClassDescriptor classDescriptor) {
        if (classDescriptor.getAnnotations().hasAnnotation(b6.g())) {
            for (AnnotationDescriptor annotationDescriptor : classDescriptor.getAnnotations()) {
                AnnotationDescriptor m = m(annotationDescriptor);
                if (m != null) {
                    return m;
                }
            }
            return null;
        }
        return null;
    }

    private final List<AnnotationQualifierApplicabilityType> d(fn<?> fnVar, Function2<? super xe0, ? super AnnotationQualifierApplicabilityType, Boolean> function2) {
        List<AnnotationQualifierApplicabilityType> g;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
        List<AnnotationQualifierApplicabilityType> k;
        if (fnVar instanceof y7) {
            ArrayList arrayList = new ArrayList();
            for (fn<?> fnVar2 : ((y7) fnVar).b()) {
                C8220r.v(arrayList, d(fnVar2, function2));
            }
            return arrayList;
        } else if (!(fnVar instanceof xe0)) {
            g = C8214m.g();
            return g;
        } else {
            AnnotationQualifierApplicabilityType[] values = AnnotationQualifierApplicabilityType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    annotationQualifierApplicabilityType = null;
                    break;
                }
                annotationQualifierApplicabilityType = values[i];
                if (function2.invoke(fnVar, annotationQualifierApplicabilityType).booleanValue()) {
                    break;
                }
                i++;
            }
            k = C8214m.k(annotationQualifierApplicabilityType);
            return k;
        }
    }

    private final List<AnnotationQualifierApplicabilityType> e(fn<?> fnVar) {
        return d(fnVar, new Function2<xe0, AnnotationQualifierApplicabilityType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$mapJavaConstantToQualifierApplicabilityTypes$1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Boolean invoke(@NotNull xe0 xe0Var, @NotNull AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
                b41.i(xe0Var, "$this$mapConstantToQualifierApplicabilityTypes");
                b41.i(annotationQualifierApplicabilityType, AdvanceSetting.NETWORK_TYPE);
                return Boolean.valueOf(b41.d(xe0Var.c().d(), annotationQualifierApplicabilityType.getJavaTarget()));
            }
        });
    }

    private final List<AnnotationQualifierApplicabilityType> f(fn<?> fnVar) {
        return d(fnVar, new Function2<xe0, AnnotationQualifierApplicabilityType, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver$mapKotlinConstantToQualifierApplicabilityTypes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Boolean invoke(@NotNull xe0 xe0Var, @NotNull AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
                List p;
                b41.i(xe0Var, "$this$mapConstantToQualifierApplicabilityTypes");
                b41.i(annotationQualifierApplicabilityType, AdvanceSetting.NETWORK_TYPE);
                p = AnnotationTypeQualifierResolver.this.p(annotationQualifierApplicabilityType.getJavaTarget());
                return Boolean.valueOf(p.contains(xe0Var.c().d()));
            }
        });
    }

    private final ReportLevel g(ClassDescriptor classDescriptor) {
        AnnotationDescriptor findAnnotation = classDescriptor.getAnnotations().findAnnotation(b6.d());
        fn<?> b = findAnnotation == null ? null : DescriptorUtilsKt.b(findAnnotation);
        xe0 xe0Var = b instanceof xe0 ? (xe0) b : null;
        if (xe0Var == null) {
            return null;
        }
        ReportLevel b2 = this.a.d().b();
        if (b2 == null) {
            String b3 = xe0Var.c().b();
            int hashCode = b3.hashCode();
            if (hashCode == -2137067054) {
                if (b3.equals("IGNORE")) {
                    return ReportLevel.IGNORE;
                }
                return null;
            } else if (hashCode == -1838656823) {
                if (b3.equals("STRICT")) {
                    return ReportLevel.STRICT;
                }
                return null;
            } else if (hashCode == 2656902 && b3.equals("WARN")) {
                return ReportLevel.WARN;
            } else {
                return null;
            }
        }
        return b2;
    }

    private final ReportLevel i(AnnotationDescriptor annotationDescriptor) {
        hp0 fqName = annotationDescriptor.getFqName();
        if (fqName != null && b6.c().containsKey(fqName)) {
            return this.a.c().invoke(fqName);
        }
        return j(annotationDescriptor);
    }

    private final AnnotationDescriptor o(ClassDescriptor classDescriptor) {
        if (classDescriptor.getKind() != ClassKind.ANNOTATION_CLASS) {
            return null;
        }
        return this.b.invoke(classDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> p(String str) {
        int q;
        Set<KotlinTarget> b = JavaAnnotationTargetMapper.INSTANCE.b(str);
        q = C8215n.q(b, 10);
        ArrayList arrayList = new ArrayList(q);
        for (KotlinTarget kotlinTarget : b) {
            arrayList.add(kotlinTarget.name());
        }
        return arrayList;
    }

    @Nullable
    public final C8326a h(@NotNull AnnotationDescriptor annotationDescriptor) {
        b41.i(annotationDescriptor, "annotationDescriptor");
        ClassDescriptor f = DescriptorUtilsKt.f(annotationDescriptor);
        if (f == null) {
            return null;
        }
        Annotations annotations = f.getAnnotations();
        hp0 hp0Var = o61.TARGET_ANNOTATION;
        b41.h(hp0Var, "TARGET_ANNOTATION");
        AnnotationDescriptor findAnnotation = annotations.findAnnotation(hp0Var);
        if (findAnnotation == null) {
            return null;
        }
        Map<ni1, fn<?>> allValueArguments = findAnnotation.getAllValueArguments();
        ArrayList<AnnotationQualifierApplicabilityType> arrayList = new ArrayList();
        for (Map.Entry<ni1, fn<?>> entry : allValueArguments.entrySet()) {
            C8220r.v(arrayList, f(entry.getValue()));
        }
        int i = 0;
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : arrayList) {
            i |= 1 << annotationQualifierApplicabilityType.ordinal();
        }
        return new C8326a(annotationDescriptor, i);
    }

    @NotNull
    public final ReportLevel j(@NotNull AnnotationDescriptor annotationDescriptor) {
        b41.i(annotationDescriptor, "annotationDescriptor");
        ReportLevel k = k(annotationDescriptor);
        return k == null ? this.a.d().a() : k;
    }

    @Nullable
    public final ReportLevel k(@NotNull AnnotationDescriptor annotationDescriptor) {
        b41.i(annotationDescriptor, "annotationDescriptor");
        ReportLevel reportLevel = this.a.d().c().get(annotationDescriptor.getFqName());
        if (reportLevel == null) {
            ClassDescriptor f = DescriptorUtilsKt.f(annotationDescriptor);
            if (f == null) {
                return null;
            }
            return g(f);
        }
        return reportLevel;
    }

    @Nullable
    public final c51 l(@NotNull AnnotationDescriptor annotationDescriptor) {
        c51 c51Var;
        b41.i(annotationDescriptor, "annotationDescriptor");
        if (this.a.b() || (c51Var = b6.a().get(annotationDescriptor.getFqName())) == null) {
            return null;
        }
        ReportLevel i = i(annotationDescriptor);
        if (!(i != ReportLevel.IGNORE)) {
            i = null;
        }
        if (i == null) {
            return null;
        }
        return c51.b(c51Var, fm1.b(c51Var.f(), null, i.isWarning(), 1, null), null, false, false, 14, null);
    }

    @Nullable
    public final AnnotationDescriptor m(@NotNull AnnotationDescriptor annotationDescriptor) {
        ClassDescriptor f;
        boolean b;
        b41.i(annotationDescriptor, "annotationDescriptor");
        if (this.a.d().d() || (f = DescriptorUtilsKt.f(annotationDescriptor)) == null) {
            return null;
        }
        b = c6.b(f);
        return b ? annotationDescriptor : o(f);
    }

    @Nullable
    public final C8326a n(@NotNull AnnotationDescriptor annotationDescriptor) {
        AnnotationDescriptor annotationDescriptor2;
        boolean z;
        List<AnnotationQualifierApplicabilityType> g;
        b41.i(annotationDescriptor, "annotationDescriptor");
        if (this.a.d().d()) {
            return null;
        }
        ClassDescriptor f = DescriptorUtilsKt.f(annotationDescriptor);
        if (f == null || !f.getAnnotations().hasAnnotation(b6.e())) {
            f = null;
        }
        if (f == null) {
            return null;
        }
        ClassDescriptor f2 = DescriptorUtilsKt.f(annotationDescriptor);
        b41.f(f2);
        AnnotationDescriptor findAnnotation = f2.getAnnotations().findAnnotation(b6.e());
        b41.f(findAnnotation);
        Map<ni1, fn<?>> allValueArguments = findAnnotation.getAllValueArguments();
        ArrayList<AnnotationQualifierApplicabilityType> arrayList = new ArrayList();
        for (Map.Entry<ni1, fn<?>> entry : allValueArguments.entrySet()) {
            fn<?> value = entry.getValue();
            if (b41.d(entry.getKey(), o61.DEFAULT_ANNOTATION_MEMBER_NAME)) {
                g = e(value);
            } else {
                g = C8214m.g();
            }
            C8220r.v(arrayList, g);
        }
        int i = 0;
        for (AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType : arrayList) {
            i |= 1 << annotationQualifierApplicabilityType.ordinal();
        }
        Iterator<AnnotationDescriptor> it = f.getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                annotationDescriptor2 = null;
                break;
            }
            annotationDescriptor2 = it.next();
            if (m(annotationDescriptor2) != null) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        AnnotationDescriptor annotationDescriptor3 = annotationDescriptor2;
        if (annotationDescriptor3 == null) {
            return null;
        }
        return new C8326a(annotationDescriptor3, i);
    }
}
