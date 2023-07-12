package kotlin.reflect.jvm.internal.impl.descriptors;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.d70;
import tb.kf0;
import tb.tt1;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class TypeParameterUtilsKt {
    @Nullable
    public static final tt1 a(@NotNull z71 z71Var) {
        b41.i(z71Var, "<this>");
        ClassifierDescriptor declarationDescriptor = z71Var.c().getDeclarationDescriptor();
        return b(z71Var, declarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) declarationDescriptor : null, 0);
    }

    private static final tt1 b(z71 z71Var, ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, int i) {
        if (classifierDescriptorWithTypeParameters == null || kf0.r(classifierDescriptorWithTypeParameters)) {
            return null;
        }
        int size = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters().size() + i;
        if (!classifierDescriptorWithTypeParameters.isInner()) {
            if (size != z71Var.b().size()) {
                d70.E(classifierDescriptorWithTypeParameters);
            }
            return new tt1(classifierDescriptorWithTypeParameters, z71Var.b().subList(i, z71Var.b().size()), null);
        }
        List<TypeProjection> subList = z71Var.b().subList(i, size);
        DeclarationDescriptor containingDeclaration = classifierDescriptorWithTypeParameters.getContainingDeclaration();
        return new tt1(classifierDescriptorWithTypeParameters, subList, b(z71Var, containingDeclaration instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) containingDeclaration : null, size));
    }

    private static final C8300a c(TypeParameterDescriptor typeParameterDescriptor, DeclarationDescriptor declarationDescriptor, int i) {
        return new C8300a(typeParameterDescriptor, declarationDescriptor, i);
    }

    @NotNull
    public static final List<TypeParameterDescriptor> d(@NotNull ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters) {
        Sequence z;
        Sequence o;
        Sequence t;
        List B;
        List<TypeParameterDescriptor> list;
        DeclarationDescriptor declarationDescriptor;
        List<TypeParameterDescriptor> m0;
        int q;
        List<TypeParameterDescriptor> m02;
        TypeConstructor typeConstructor;
        b41.i(classifierDescriptorWithTypeParameters, "<this>");
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
        b41.h(declaredTypeParameters, "declaredTypeParameters");
        if (classifierDescriptorWithTypeParameters.isInner() || (classifierDescriptorWithTypeParameters.getContainingDeclaration() instanceof CallableDescriptor)) {
            z = SequencesKt___SequencesKt.z(DescriptorUtilsKt.m(classifierDescriptorWithTypeParameters), new Function1<DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull DeclarationDescriptor declarationDescriptor2) {
                    b41.i(declarationDescriptor2, AdvanceSetting.NETWORK_TYPE);
                    return Boolean.valueOf(declarationDescriptor2 instanceof CallableDescriptor);
                }
            });
            o = SequencesKt___SequencesKt.o(z, new Function1<DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull DeclarationDescriptor declarationDescriptor2) {
                    b41.i(declarationDescriptor2, AdvanceSetting.NETWORK_TYPE);
                    return Boolean.valueOf(!(declarationDescriptor2 instanceof ConstructorDescriptor));
                }
            });
            t = SequencesKt___SequencesKt.t(o, new Function1<DeclarationDescriptor, Sequence<? extends TypeParameterDescriptor>>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt$computeConstructorTypeParameters$parametersFromContainingFunctions$3
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Sequence<TypeParameterDescriptor> invoke(@NotNull DeclarationDescriptor declarationDescriptor2) {
                    Sequence<TypeParameterDescriptor> I;
                    b41.i(declarationDescriptor2, AdvanceSetting.NETWORK_TYPE);
                    List<TypeParameterDescriptor> typeParameters = ((CallableDescriptor) declarationDescriptor2).getTypeParameters();
                    b41.h(typeParameters, "it as CallableDescriptor).typeParameters");
                    I = CollectionsKt___CollectionsKt.I(typeParameters);
                    return I;
                }
            });
            B = SequencesKt___SequencesKt.B(t);
            Iterator<DeclarationDescriptor> it = DescriptorUtilsKt.m(classifierDescriptorWithTypeParameters).iterator();
            while (true) {
                list = null;
                if (!it.hasNext()) {
                    declarationDescriptor = null;
                    break;
                }
                declarationDescriptor = it.next();
                if (declarationDescriptor instanceof ClassDescriptor) {
                    break;
                }
            }
            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
            if (classDescriptor != null && (typeConstructor = classDescriptor.getTypeConstructor()) != null) {
                list = typeConstructor.getParameters();
            }
            if (list == null) {
                list = C8214m.g();
            }
            if (B.isEmpty() && list.isEmpty()) {
                List<TypeParameterDescriptor> declaredTypeParameters2 = classifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
                b41.h(declaredTypeParameters2, "declaredTypeParameters");
                return declaredTypeParameters2;
            }
            m0 = CollectionsKt___CollectionsKt.m0(B, list);
            q = C8215n.q(m0, 10);
            ArrayList arrayList = new ArrayList(q);
            for (TypeParameterDescriptor typeParameterDescriptor : m0) {
                b41.h(typeParameterDescriptor, AdvanceSetting.NETWORK_TYPE);
                arrayList.add(c(typeParameterDescriptor, classifierDescriptorWithTypeParameters, declaredTypeParameters.size()));
            }
            m02 = CollectionsKt___CollectionsKt.m0(declaredTypeParameters, arrayList);
            return m02;
        }
        return declaredTypeParameters;
    }
}
