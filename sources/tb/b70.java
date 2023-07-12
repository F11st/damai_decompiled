package tb;

import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class b70 {
    private static /* synthetic */ void a(int i) {
        String str = i != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 4 ? 3 : 2];
        switch (i) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String format = String.format(str, objArr);
        if (i == 4) {
            throw new IllegalStateException(format);
        }
    }

    @NotNull
    public static TypeSubstitutor b(@NotNull List<TypeParameterDescriptor> list, @NotNull br2 br2Var, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull List<TypeParameterDescriptor> list2) {
        if (list == null) {
            a(0);
        }
        if (br2Var == null) {
            a(1);
        }
        if (declarationDescriptor == null) {
            a(2);
        }
        if (list2 == null) {
            a(3);
        }
        TypeSubstitutor c = c(list, br2Var, declarationDescriptor, list2, null);
        if (c != null) {
            return c;
        }
        throw new AssertionError("Substitution failed");
    }

    @Nullable
    public static TypeSubstitutor c(@NotNull List<TypeParameterDescriptor> list, @NotNull br2 br2Var, @NotNull DeclarationDescriptor declarationDescriptor, @NotNull List<TypeParameterDescriptor> list2, @Nullable boolean[] zArr) {
        if (list == null) {
            a(5);
        }
        if (br2Var == null) {
            a(6);
        }
        if (declarationDescriptor == null) {
            a(7);
        }
        if (list2 == null) {
            a(8);
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i = 0;
        for (TypeParameterDescriptor typeParameterDescriptor : list) {
            wq2 k = wq2.k(declarationDescriptor, typeParameterDescriptor.getAnnotations(), typeParameterDescriptor.isReified(), typeParameterDescriptor.getVariance(), typeParameterDescriptor.getName(), i, SourceElement.NO_SOURCE, typeParameterDescriptor.getStorageManager());
            hashMap.put(typeParameterDescriptor.getTypeConstructor(), new zq2(k.getDefaultType()));
            hashMap2.put(typeParameterDescriptor, k);
            list2.add(k);
            i++;
        }
        oq2 j = oq2.j(hashMap);
        TypeSubstitutor h = TypeSubstitutor.h(br2Var, j);
        TypeSubstitutor h2 = TypeSubstitutor.h(br2Var.h(), j);
        for (TypeParameterDescriptor typeParameterDescriptor2 : list) {
            wq2 wq2Var = (wq2) hashMap2.get(typeParameterDescriptor2);
            for (z71 z71Var : typeParameterDescriptor2.getUpperBounds()) {
                ClassifierDescriptor declarationDescriptor2 = z71Var.c().getDeclarationDescriptor();
                z71 q = (((declarationDescriptor2 instanceof TypeParameterDescriptor) && TypeUtilsKt.j((TypeParameterDescriptor) declarationDescriptor2)) ? h : h2).q(z71Var, Variance.OUT_VARIANCE);
                if (q == null) {
                    return null;
                }
                if (q != z71Var && zArr != null) {
                    zArr[0] = true;
                }
                wq2Var.g(q);
            }
            wq2Var.o();
        }
        return h;
    }
}
