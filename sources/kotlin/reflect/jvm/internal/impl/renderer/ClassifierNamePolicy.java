package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.C8221s;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.d70;
import tb.ip0;
import tb.ni1;
import tb.q12;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ClassifierNamePolicy {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy$a */
    /* loaded from: classes3.dex */
    public static final class C8471a implements ClassifierNamePolicy {
        @NotNull
        public static final C8471a INSTANCE = new C8471a();

        private C8471a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer) {
            b41.i(classifierDescriptor, "classifier");
            b41.i(descriptorRenderer, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                ni1 name = ((TypeParameterDescriptor) classifierDescriptor).getName();
                b41.h(name, "classifier.name");
                return descriptorRenderer.f(name, false);
            }
            ip0 m = d70.m(classifierDescriptor);
            b41.h(m, "getFqName(classifier)");
            return descriptorRenderer.e(m);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy$b */
    /* loaded from: classes3.dex */
    public static final class C8472b implements ClassifierNamePolicy {
        @NotNull
        public static final C8472b INSTANCE = new C8472b();

        private C8472b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer) {
            boolean z;
            List D;
            b41.i(classifierDescriptor, "classifier");
            b41.i(descriptorRenderer, "renderer");
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                ni1 name = ((TypeParameterDescriptor) classifierDescriptor).getName();
                b41.h(name, "classifier.name");
                return descriptorRenderer.f(name, false);
            }
            ArrayList arrayList = new ArrayList();
            ClassifierDescriptor classifierDescriptor2 = classifierDescriptor;
            do {
                arrayList.add(classifierDescriptor2.getName());
                DeclarationDescriptor containingDeclaration = classifierDescriptor2.getContainingDeclaration();
                z = containingDeclaration instanceof ClassDescriptor;
                classifierDescriptor2 = containingDeclaration;
            } while (z);
            D = C8221s.D(arrayList);
            return q12.c(D);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy$c */
    /* loaded from: classes3.dex */
    public static final class C8473c implements ClassifierNamePolicy {
        @NotNull
        public static final C8473c INSTANCE = new C8473c();

        private C8473c() {
        }

        private final String a(ClassifierDescriptor classifierDescriptor) {
            ni1 name = classifierDescriptor.getName();
            b41.h(name, "descriptor.name");
            String b = q12.b(name);
            if (classifierDescriptor instanceof TypeParameterDescriptor) {
                return b;
            }
            DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
            b41.h(containingDeclaration, "descriptor.containingDeclaration");
            String b2 = b(containingDeclaration);
            if (b2 == null || b41.d(b2, "")) {
                return b;
            }
            return ((Object) b2) + '.' + b;
        }

        private final String b(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor instanceof ClassDescriptor) {
                return a((ClassifierDescriptor) declarationDescriptor);
            }
            if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                ip0 j = ((PackageFragmentDescriptor) declarationDescriptor).getFqName().j();
                b41.h(j, "descriptor.fqName.toUnsafe()");
                return q12.a(j);
            }
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.renderer.ClassifierNamePolicy
        @NotNull
        public String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer) {
            b41.i(classifierDescriptor, "classifier");
            b41.i(descriptorRenderer, "renderer");
            return a(classifierDescriptor);
        }
    }

    @NotNull
    String renderClassifier(@NotNull ClassifierDescriptor classifierDescriptor, @NotNull DescriptorRenderer descriptorRenderer);
}
