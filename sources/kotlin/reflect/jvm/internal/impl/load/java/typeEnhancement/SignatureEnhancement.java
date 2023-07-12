package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.huawei.hms.opendevice.c;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ContextKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a81;
import tb.b41;
import tb.c51;
import tb.c70;
import tb.ck0;
import tb.fm1;
import tb.fn;
import tb.fr2;
import tb.gu2;
import tb.hp0;
import tb.k50;
import tb.ni1;
import tb.o51;
import tb.p61;
import tb.qc2;
import tb.r51;
import tb.r81;
import tb.rq2;
import tb.s51;
import tb.t51;
import tb.t81;
import tb.xe0;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class SignatureEnhancement {
    @NotNull
    private final AnnotationTypeQualifierResolver a;
    @NotNull
    private final JavaTypeEnhancementState b;
    @NotNull
    private final r51 c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class a {
        @NotNull
        private final z71 a;
        private final boolean b;
        private final boolean c;

        public a(@NotNull z71 z71Var, boolean z, boolean z2) {
            b41.i(z71Var, "type");
            this.a = z71Var;
            this.b = z;
            this.c = z2;
        }

        public final boolean a() {
            return this.c;
        }

        @NotNull
        public final z71 b() {
            return this.a;
        }

        public final boolean c() {
            return this.b;
        }
    }

    public SignatureEnhancement(@NotNull AnnotationTypeQualifierResolver annotationTypeQualifierResolver, @NotNull JavaTypeEnhancementState javaTypeEnhancementState, @NotNull r51 r51Var) {
        b41.i(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        b41.i(javaTypeEnhancementState, "javaTypeEnhancementState");
        b41.i(r51Var, "typeEnhancement");
        this.a = annotationTypeQualifierResolver;
        this.b = javaTypeEnhancementState;
        this.c = r51Var;
    }

    private final fm1 c(hp0 hp0Var, AnnotationDescriptor annotationDescriptor, boolean z) {
        ReportLevel invoke = this.b.c().invoke(hp0Var);
        if (invoke.isIgnore()) {
            return null;
        }
        boolean z2 = invoke.isWarning() || z;
        if (p61.l().contains(hp0Var)) {
            return new fm1(NullabilityQualifier.NULLABLE, z2);
        }
        if (p61.k().contains(hp0Var)) {
            return new fm1(NullabilityQualifier.NOT_NULL, z2);
        }
        if (b41.d(hp0Var, p61.g())) {
            return new fm1(NullabilityQualifier.NULLABLE, z2);
        }
        if (b41.d(hp0Var, p61.h())) {
            return new fm1(NullabilityQualifier.FORCE_FLEXIBILITY, z2);
        }
        if (b41.d(hp0Var, p61.f())) {
            return j(annotationDescriptor, z2);
        }
        if (b41.d(hp0Var, p61.d())) {
            return new fm1(NullabilityQualifier.NULLABLE, z2);
        }
        if (b41.d(hp0Var, p61.c())) {
            return new fm1(NullabilityQualifier.NOT_NULL, z2);
        }
        if (b41.d(hp0Var, p61.a())) {
            return new fm1(NullabilityQualifier.NOT_NULL, z2);
        }
        if (b41.d(hp0Var, p61.b())) {
            return new fm1(NullabilityQualifier.NULLABLE, z2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> D d(D r19, tb.r81 r20) {
        /*
            Method dump skipped, instructions count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.d(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, tb.r81):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor");
    }

    private final fm1 i(AnnotationDescriptor annotationDescriptor, boolean z, boolean z2) {
        hp0 fqName = annotationDescriptor.getFqName();
        if (fqName == null) {
            return null;
        }
        fm1 c = c(fqName, annotationDescriptor, (annotationDescriptor instanceof LazyJavaAnnotationDescriptor) && (((LazyJavaAnnotationDescriptor) annotationDescriptor).h() || z2) && !z);
        if (c == null) {
            return null;
        }
        return (!c.d() && (annotationDescriptor instanceof PossiblyExternalAnnotationDescriptor) && ((PossiblyExternalAnnotationDescriptor) annotationDescriptor).isIdeExternalAnnotation()) ? fm1.b(c, null, true, 1, null) : c;
    }

    private final fm1 j(AnnotationDescriptor annotationDescriptor, boolean z) {
        fn<?> b = DescriptorUtilsKt.b(annotationDescriptor);
        xe0 xe0Var = b instanceof xe0 ? (xe0) b : null;
        if (xe0Var == null) {
            return new fm1(NullabilityQualifier.NOT_NULL, z);
        }
        String b2 = xe0Var.c().b();
        switch (b2.hashCode()) {
            case 73135176:
                if (!b2.equals("MAYBE")) {
                    return null;
                }
                break;
            case 74175084:
                if (!b2.equals("NEVER")) {
                    return null;
                }
                break;
            case 433141802:
                if (b2.equals("UNKNOWN")) {
                    return new fm1(NullabilityQualifier.FORCE_FLEXIBILITY, z);
                }
                return null;
            case 1933739535:
                if (b2.equals("ALWAYS")) {
                    return new fm1(NullabilityQualifier.NOT_NULL, z);
                }
                return null;
            default:
                return null;
        }
        return new fm1(NullabilityQualifier.NULLABLE, z);
    }

    private final <D extends CallableMemberDescriptor> Annotations k(D d, r81 r81Var) {
        int q;
        List<? extends AnnotationDescriptor> k0;
        ClassifierDescriptor a2 = c70.a(d);
        if (a2 == null) {
            return d.getAnnotations();
        }
        LazyJavaClassDescriptor lazyJavaClassDescriptor = a2 instanceof LazyJavaClassDescriptor ? (LazyJavaClassDescriptor) a2 : null;
        List<JavaAnnotation> k = lazyJavaClassDescriptor != null ? lazyJavaClassDescriptor.k() : null;
        if (k == null || k.isEmpty()) {
            return d.getAnnotations();
        }
        q = n.q(k, 10);
        ArrayList arrayList = new ArrayList(q);
        for (JavaAnnotation javaAnnotation : k) {
            arrayList.add(new LazyJavaAnnotationDescriptor(r81Var, javaAnnotation, true));
        }
        Annotations.a aVar = Annotations.Companion;
        k0 = CollectionsKt___CollectionsKt.k0(d.getAnnotations(), arrayList);
        return aVar.a(k0);
    }

    private final SignatureParts l(CallableMemberDescriptor callableMemberDescriptor, Annotated annotated, boolean z, r81 r81Var, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, Function1<? super CallableMemberDescriptor, ? extends z71> function1) {
        int q;
        z71 invoke = function1.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        b41.h(overriddenDescriptors, "this.overriddenDescriptors");
        q = n.q(overriddenDescriptors, 10);
        ArrayList arrayList = new ArrayList(q);
        for (CallableMemberDescriptor callableMemberDescriptor2 : overriddenDescriptors) {
            b41.h(callableMemberDescriptor2, AdvanceSetting.NETWORK_TYPE);
            arrayList.add(function1.invoke(callableMemberDescriptor2));
        }
        return new SignatureParts(annotated, invoke, arrayList, z, ContextKt.h(r81Var, function1.invoke(callableMemberDescriptor).getAnnotations()), annotationQualifierApplicabilityType, false, false, 192, null);
    }

    private final SignatureParts m(CallableMemberDescriptor callableMemberDescriptor, ValueParameterDescriptor valueParameterDescriptor, r81 r81Var, Function1<? super CallableMemberDescriptor, ? extends z71> function1) {
        r81 h;
        return l(callableMemberDescriptor, valueParameterDescriptor, false, (valueParameterDescriptor == null || (h = ContextKt.h(r81Var, valueParameterDescriptor.getAnnotations())) == null) ? r81Var : h, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <D extends CallableMemberDescriptor> Collection<D> e(@NotNull r81 r81Var, @NotNull Collection<? extends D> collection) {
        int q;
        b41.i(r81Var, c.a);
        b41.i(collection, "platformSignatures");
        q = n.q(collection, 10);
        ArrayList arrayList = new ArrayList(q);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(d((CallableMemberDescriptor) it.next(), r81Var));
        }
        return arrayList;
    }

    @NotNull
    public final z71 f(@NotNull z71 z71Var, @NotNull r81 r81Var) {
        List g;
        b41.i(z71Var, "type");
        b41.i(r81Var, WPKFactory.INIT_KEY_CONTEXT);
        g = m.g();
        return SignatureParts.h(new SignatureParts(null, z71Var, g, false, r81Var, AnnotationQualifierApplicabilityType.TYPE_USE, false, true, 64, null), null, 1, null).b();
    }

    @NotNull
    public final List<z71> g(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull List<? extends z71> list, @NotNull r81 r81Var) {
        int q;
        List g;
        Iterator it;
        b41.i(typeParameterDescriptor, "typeParameter");
        b41.i(list, "bounds");
        b41.i(r81Var, WPKFactory.INIT_KEY_CONTEXT);
        q = n.q(list, 10);
        ArrayList arrayList = new ArrayList(q);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            z71 z71Var = (z71) it2.next();
            if (TypeUtilsKt.b(z71Var, new Function1<gu2, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceTypeParameterBounds$1$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull gu2 gu2Var) {
                    b41.i(gu2Var, AdvanceSetting.NETWORK_TYPE);
                    return Boolean.valueOf(gu2Var instanceof RawType);
                }
            })) {
                it = it2;
            } else {
                g = m.g();
                it = it2;
                z71Var = SignatureParts.h(new SignatureParts(typeParameterDescriptor, z71Var, g, false, r81Var, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, true, false, 128, null), null, 1, null).b();
            }
            arrayList.add(z71Var);
            it2 = it;
        }
        return arrayList;
    }

    @Nullable
    public final fm1 h(@NotNull AnnotationDescriptor annotationDescriptor, boolean z, boolean z2) {
        fm1 i;
        b41.i(annotationDescriptor, "annotationDescriptor");
        fm1 i2 = i(annotationDescriptor, z, z2);
        if (i2 == null) {
            AnnotationDescriptor m = this.a.m(annotationDescriptor);
            if (m == null) {
                return null;
            }
            ReportLevel j = this.a.j(annotationDescriptor);
            if (j.isIgnore() || (i = i(m, z, z2)) == null) {
                return null;
            }
            return fm1.b(i, null, j.isWarning(), 1, null);
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public final class SignatureParts {
        @Nullable
        private final Annotated a;
        @NotNull
        private final z71 b;
        @NotNull
        private final Collection<z71> c;
        private final boolean d;
        @NotNull
        private final r81 e;
        @NotNull
        private final AnnotationQualifierApplicabilityType f;
        private final boolean g;
        private final boolean h;

        /* JADX WARN: Multi-variable type inference failed */
        public SignatureParts(@Nullable SignatureEnhancement signatureEnhancement, @NotNull Annotated annotated, @NotNull z71 z71Var, Collection<? extends z71> collection, @NotNull boolean z, @NotNull r81 r81Var, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2, boolean z3) {
            b41.i(signatureEnhancement, "this$0");
            b41.i(z71Var, "fromOverride");
            b41.i(collection, "fromOverridden");
            b41.i(r81Var, "containerContext");
            b41.i(annotationQualifierApplicabilityType, "containerApplicabilityType");
            SignatureEnhancement.this = signatureEnhancement;
            this.a = annotated;
            this.b = z71Var;
            this.c = collection;
            this.d = z;
            this.e = r81Var;
            this.f = annotationQualifierApplicabilityType;
            this.g = z2;
            this.h = z3;
        }

        private final fm1 b(TypeParameterDescriptor typeParameterDescriptor) {
            boolean z;
            boolean b;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            if (typeParameterDescriptor instanceof t81) {
                t81 t81Var = (t81) typeParameterDescriptor;
                List<z71> upperBounds = t81Var.getUpperBounds();
                b41.h(upperBounds, "upperBounds");
                boolean z6 = false;
                boolean z7 = true;
                if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                    for (z71 z71Var : upperBounds) {
                        if (!a81.a(z71Var)) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (!z) {
                    List<z71> upperBounds2 = t81Var.getUpperBounds();
                    b41.h(upperBounds2, "upperBounds");
                    if (!(upperBounds2 instanceof Collection) || !upperBounds2.isEmpty()) {
                        for (z71 z71Var2 : upperBounds2) {
                            b = qc2.b(z71Var2);
                            if (!b) {
                                z2 = false;
                                break;
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                        List<z71> upperBounds3 = t81Var.getUpperBounds();
                        b41.h(upperBounds3, "upperBounds");
                        if (!(upperBounds3 instanceof Collection) || !upperBounds3.isEmpty()) {
                            for (z71 z71Var3 : upperBounds3) {
                                if (!(z71Var3 instanceof ck0) || a81.b(((ck0) z71Var3).getEnhancement())) {
                                    z3 = false;
                                    continue;
                                } else {
                                    z3 = true;
                                    continue;
                                }
                                if (z3) {
                                    z4 = true;
                                    break;
                                }
                            }
                        }
                        z4 = false;
                        if (z4) {
                            return new fm1(NullabilityQualifier.NOT_NULL, true);
                        }
                        List<z71> upperBounds4 = t81Var.getUpperBounds();
                        b41.h(upperBounds4, "upperBounds");
                        if (!(upperBounds4 instanceof Collection) || !upperBounds4.isEmpty()) {
                            Iterator<T> it = upperBounds4.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                z71 z71Var4 = (z71) it.next();
                                if ((z71Var4 instanceof ck0) && a81.b(((ck0) z71Var4).getEnhancement())) {
                                    z5 = true;
                                    continue;
                                } else {
                                    z5 = false;
                                    continue;
                                }
                                if (z5) {
                                    z6 = true;
                                    break;
                                }
                            }
                        }
                        if (z6) {
                            return new fm1(NullabilityQualifier.NULLABLE, true);
                        }
                        return null;
                    }
                    List<z71> upperBounds5 = t81Var.getUpperBounds();
                    b41.h(upperBounds5, "upperBounds");
                    if (!(upperBounds5 instanceof Collection) || !upperBounds5.isEmpty()) {
                        for (z71 z71Var5 : upperBounds5) {
                            b41.h(z71Var5, AdvanceSetting.NETWORK_TYPE);
                            if (!a81.b(z71Var5)) {
                                break;
                            }
                        }
                    }
                    z7 = false;
                    return new fm1(z7 ? NullabilityQualifier.NOT_NULL : NullabilityQualifier.NULLABLE, false, 2, null);
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final kotlin.jvm.functions.Function1<java.lang.Integer, tb.s51> c() {
            /*
                r17 = this;
                r7 = r17
                java.util.Collection<tb.z71> r0 = r7.c
                java.util.ArrayList r8 = new java.util.ArrayList
                r1 = 10
                int r1 = kotlin.collections.k.q(r0, r1)
                r8.<init>(r1)
                java.util.Iterator r0 = r0.iterator()
            L13:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L27
                java.lang.Object r1 = r0.next()
                tb.z71 r1 = (tb.z71) r1
                java.util.List r1 = r7.q(r1)
                r8.add(r1)
                goto L13
            L27:
                tb.z71 r0 = r7.b
                java.util.List r9 = r7.q(r0)
                boolean r0 = r7.d
                r11 = 1
                if (r0 == 0) goto L60
                java.util.Collection<tb.z71> r0 = r7.c
                boolean r1 = r0 instanceof java.util.Collection
                if (r1 == 0) goto L40
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L40
            L3e:
                r0 = 0
                goto L5c
            L40:
                java.util.Iterator r0 = r0.iterator()
            L44:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L3e
                java.lang.Object r1 = r0.next()
                tb.z71 r1 = (tb.z71) r1
                kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker r2 = kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.DEFAULT
                tb.z71 r3 = r7.b
                boolean r1 = r2.equalTypes(r1, r3)
                r1 = r1 ^ r11
                if (r1 == 0) goto L44
                r0 = 1
            L5c:
                if (r0 == 0) goto L60
                r12 = 1
                goto L61
            L60:
                r12 = 0
            L61:
                if (r12 == 0) goto L65
                r13 = 1
                goto L6a
            L65:
                int r0 = r9.size()
                r13 = r0
            L6a:
                tb.s51[] r14 = new tb.s51[r13]
                r15 = 0
            L6d:
                if (r15 >= r13) goto Lc0
                if (r15 != 0) goto L73
                r4 = 1
                goto L74
            L73:
                r4 = 0
            L74:
                java.lang.Object r0 = r9.get(r15)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.b r0 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.b) r0
                tb.z71 r1 = r0.a()
                tb.c51 r3 = r0.b()
                kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r5 = r0.c()
                boolean r6 = r0.d()
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r0 = r8.iterator()
            L93:
                boolean r16 = r0.hasNext()
                if (r16 == 0) goto Lb5
                java.lang.Object r16 = r0.next()
                r10 = r16
                java.util.List r10 = (java.util.List) r10
                java.lang.Object r10 = kotlin.collections.k.S(r10, r15)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.b r10 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.b) r10
                if (r10 != 0) goto Lab
                r10 = 0
                goto Laf
            Lab:
                tb.z71 r10 = r10.e()
            Laf:
                if (r10 == 0) goto L93
                r2.add(r10)
                goto L93
            Lb5:
                r0 = r17
                tb.s51 r0 = r0.e(r1, r2, r3, r4, r5, r6)
                r14[r15] = r0
                int r15 = r15 + 1
                goto L6d
            Lc0:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1 r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1
                r0.<init>()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.c():kotlin.jvm.functions.Function1");
        }

        private final fm1 d(fm1 fm1Var, c51 c51Var, TypeParameterDescriptor typeParameterDescriptor) {
            fm1 f;
            if (fm1Var == null) {
                fm1Var = (c51Var == null || (f = c51Var.f()) == null) ? null : new fm1(f.c(), f.d());
            }
            fm1 b = typeParameterDescriptor != null ? b(typeParameterDescriptor) : null;
            if (b == null) {
                return fm1Var;
            }
            if (c51Var == null && fm1Var == null && b.c() == NullabilityQualifier.NULLABLE) {
                return new fm1(NullabilityQualifier.FORCE_FLEXIBILITY, b.d());
            }
            return fm1Var == null ? b : o(b, fm1Var);
        }

        /* JADX WARN: Removed duplicated region for block: B:76:0x012e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final tb.s51 e(tb.z71 r10, java.util.Collection<? extends tb.z71> r11, tb.c51 r12, boolean r13, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r14, boolean r15) {
            /*
                Method dump skipped, instructions count: 308
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.e(tb.z71, java.util.Collection, tb.c51, boolean, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, boolean):tb.s51");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean g(gu2 gu2Var) {
            ClassifierDescriptor declarationDescriptor = gu2Var.c().getDeclarationDescriptor();
            if (declarationDescriptor == null) {
                return false;
            }
            ni1 name = declarationDescriptor.getName();
            o51 o51Var = o51.INSTANCE;
            return b41.d(name, o51Var.i().g()) && b41.d(DescriptorUtilsKt.e(declarationDescriptor), o51Var.i());
        }

        public static /* synthetic */ a h(SignatureParts signatureParts, rq2 rq2Var, int i, Object obj) {
            if ((i & 1) != 0) {
                rq2Var = null;
            }
            return signatureParts.f(rq2Var);
        }

        private final fm1 i(Annotations annotations, boolean z, boolean z2) {
            SignatureEnhancement signatureEnhancement = SignatureEnhancement.this;
            Iterator<AnnotationDescriptor> it = annotations.iterator();
            while (it.hasNext()) {
                fm1 h = signatureEnhancement.h(it.next(), z, z2);
                if (h != null) {
                    return h;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final tb.s51 j(tb.z71 r12) {
            /*
                r11 = this;
                boolean r0 = tb.dk0.b(r12)
                if (r0 == 0) goto L18
                tb.ak0 r0 = tb.dk0.a(r12)
                kotlin.Pair r1 = new kotlin.Pair
                tb.fd2 r2 = r0.k()
                tb.fd2 r0 = r0.l()
                r1.<init>(r2, r0)
                goto L1d
            L18:
                kotlin.Pair r1 = new kotlin.Pair
                r1.<init>(r12, r12)
            L1d:
                java.lang.Object r0 = r1.component1()
                tb.z71 r0 = (tb.z71) r0
                java.lang.Object r1 = r1.component2()
                tb.z71 r1 = (tb.z71) r1
                tb.p51 r2 = tb.p51.INSTANCE
                tb.s51 r10 = new tb.s51
                boolean r3 = r0.d()
                r4 = 0
                if (r3 == 0) goto L38
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            L36:
                r5 = r3
                goto L42
            L38:
                boolean r3 = r1.d()
                if (r3 != 0) goto L41
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                goto L36
            L41:
                r5 = r4
            L42:
                boolean r0 = r2.f(r0)
                if (r0 == 0) goto L4b
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY
                goto L55
            L4b:
                boolean r0 = r2.d(r1)
                if (r0 == 0) goto L54
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE
                goto L55
            L54:
                r0 = r4
            L55:
                tb.gu2 r12 = r12.f()
                boolean r6 = r12 instanceof tb.ll1
                r7 = 0
                r8 = 8
                r9 = 0
                r3 = r10
                r4 = r5
                r5 = r0
                r3.<init>(r4, r5, r6, r7, r8, r9)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.j(tb.z71):tb.s51");
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x00c2, code lost:
            if (((r13.d() || !kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.o(r11)) && (r13.c() || !r15)) != false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00f4, code lost:
            if (r1.c() == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00f7, code lost:
            r12 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x0106, code lost:
            if ((r13 != null && r13.e()) != false) goto L66;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final tb.s51 k(tb.z71 r11, boolean r12, tb.c51 r13, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r14, boolean r15) {
            /*
                Method dump skipped, instructions count: 325
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.k(tb.z71, boolean, tb.c51, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, boolean):tb.s51");
        }

        private static final <T> T l(List<hp0> list, Annotations annotations, T t) {
            boolean z;
            boolean z2 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (hp0 hp0Var : list) {
                    if (annotations.findAnnotation(hp0Var) != null) {
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
            }
            z2 = false;
            if (z2) {
                return t;
            }
            return null;
        }

        private static final <T> T m(T t, T t2) {
            if (t == null || t2 == null || b41.d(t, t2)) {
                return t == null ? t2 : t;
            }
            return null;
        }

        private final boolean n() {
            Annotated annotated = this.a;
            if (!(annotated instanceof ValueParameterDescriptor)) {
                annotated = null;
            }
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) annotated;
            return (valueParameterDescriptor != null ? valueParameterDescriptor.getVarargElementType() : null) != null;
        }

        private final fm1 o(fm1 fm1Var, fm1 fm1Var2) {
            NullabilityQualifier c = fm1Var.c();
            NullabilityQualifier nullabilityQualifier = NullabilityQualifier.FORCE_FLEXIBILITY;
            if (c == nullabilityQualifier) {
                return fm1Var2;
            }
            if (fm1Var2.c() == nullabilityQualifier) {
                return fm1Var;
            }
            NullabilityQualifier c2 = fm1Var.c();
            NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.NULLABLE;
            if (c2 == nullabilityQualifier2) {
                return fm1Var2;
            }
            if (fm1Var2.c() == nullabilityQualifier2) {
                return fm1Var;
            }
            if (fm1Var.c() == fm1Var2.c()) {
                fm1Var.c();
                NullabilityQualifier nullabilityQualifier3 = NullabilityQualifier.NOT_NULL;
            }
            return new fm1(NullabilityQualifier.NOT_NULL, false, 2, null);
        }

        private final Pair<fm1, Boolean> p(z71 z71Var) {
            ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
            TypeParameterDescriptor typeParameterDescriptor = declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null;
            fm1 b = typeParameterDescriptor == null ? null : b(typeParameterDescriptor);
            if (b == null) {
                return new Pair<>(null, Boolean.FALSE);
            }
            NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
            return new Pair<>(new fm1(nullabilityQualifier, b.d()), Boolean.valueOf(b.c() == nullabilityQualifier));
        }

        private final List<b> q(z71 z71Var) {
            ArrayList arrayList = new ArrayList(1);
            r(this, arrayList, z71Var, this.e, null);
            return arrayList;
        }

        private static final void r(SignatureParts signatureParts, ArrayList<b> arrayList, z71 z71Var, r81 r81Var, TypeParameterDescriptor typeParameterDescriptor) {
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
            c51 a;
            List<Pair> H0;
            r81 h = ContextKt.h(r81Var, z71Var.getAnnotations());
            t51 b = h.b();
            if (b == null) {
                a = null;
            } else {
                if (signatureParts.g) {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
                } else {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_USE;
                }
                a = b.a(annotationQualifierApplicabilityType);
            }
            arrayList.add(new b(z71Var, a, typeParameterDescriptor, false));
            if (signatureParts.h && (z71Var instanceof RawType)) {
                return;
            }
            List<TypeProjection> b2 = z71Var.b();
            List<TypeParameterDescriptor> parameters = z71Var.c().getParameters();
            b41.h(parameters, "type.constructor.parameters");
            H0 = CollectionsKt___CollectionsKt.H0(b2, parameters);
            for (Pair pair : H0) {
                TypeProjection typeProjection = (TypeProjection) pair.component1();
                TypeParameterDescriptor typeParameterDescriptor2 = (TypeParameterDescriptor) pair.component2();
                if (typeProjection.isStarProjection()) {
                    z71 type = typeProjection.getType();
                    b41.h(type, "arg.type");
                    arrayList.add(new b(type, a, typeParameterDescriptor2, true));
                } else {
                    z71 type2 = typeProjection.getType();
                    b41.h(type2, "arg.type");
                    r(signatureParts, arrayList, type2, h, typeParameterDescriptor2);
                }
            }
        }

        @NotNull
        public final a f(@Nullable final rq2 rq2Var) {
            boolean c;
            final Function1<Integer, s51> c2 = c();
            Function1<Integer, s51> function1 = rq2Var == null ? null : new Function1<Integer, s51>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ s51 invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @NotNull
                public final s51 invoke(int i) {
                    s51 s51Var = rq2.this.a().get(Integer.valueOf(i));
                    return s51Var == null ? c2.invoke(Integer.valueOf(i)) : s51Var;
                }
            };
            if (this.h) {
                c = fr2.e(this.b, SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1.INSTANCE, new Function1<z71, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$SignatureParts$enhance$containsFunctionN$2
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(z71 z71Var) {
                        return Boolean.valueOf(z71Var instanceof RawType);
                    }
                });
            } else {
                c = fr2.c(this.b, SignatureEnhancement$SignatureParts$enhance$containsFunctionN$3.INSTANCE);
            }
            r51 r51Var = SignatureEnhancement.this.c;
            z71 z71Var = this.b;
            if (function1 != null) {
                c2 = function1;
            }
            z71 b = r51Var.b(z71Var, c2, this.h);
            a aVar = b != null ? new a(b, true, c) : null;
            return aVar == null ? new a(this.b, false, c) : aVar;
        }

        public /* synthetic */ SignatureParts(Annotated annotated, z71 z71Var, Collection collection, boolean z, r81 r81Var, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z2, boolean z3, int i, k50 k50Var) {
            this(SignatureEnhancement.this, annotated, z71Var, collection, z, r81Var, annotationQualifierApplicabilityType, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? false : z3);
        }
    }
}
