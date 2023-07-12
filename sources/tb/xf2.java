package tb;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.collections.C8212k;
import kotlin.collections.C8215n;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class xf2 {

    /* compiled from: Taobao */
    /* renamed from: tb.xf2$a */
    /* loaded from: classes3.dex */
    public static final class C9929a extends oq2 {
        final /* synthetic */ List<TypeConstructor> a;

        /* JADX WARN: Multi-variable type inference failed */
        C9929a(List<? extends TypeConstructor> list) {
            this.a = list;
        }

        @Override // tb.oq2
        @Nullable
        public TypeProjection k(@NotNull TypeConstructor typeConstructor) {
            b41.i(typeConstructor, "key");
            if (this.a.contains(typeConstructor)) {
                ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                return fr2.t((TypeParameterDescriptor) declarationDescriptor);
            }
            return null;
        }
    }

    private static final z71 a(List<? extends TypeConstructor> list, List<? extends z71> list2, AbstractC8271b abstractC8271b) {
        z71 q = TypeSubstitutor.g(new C9929a(list)).q((z71) C8212k.P(list2), Variance.OUT_VARIANCE);
        if (q == null) {
            q = abstractC8271b.y();
        }
        b41.h(q, "typeParameters: List<Typ… ?: builtIns.defaultBound");
        return q;
    }

    @NotNull
    public static final z71 b(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        int q;
        int q2;
        b41.i(typeParameterDescriptor, "<this>");
        DeclarationDescriptor containingDeclaration = typeParameterDescriptor.getContainingDeclaration();
        b41.h(containingDeclaration, "this.containingDeclaration");
        if (containingDeclaration instanceof ClassifierDescriptorWithTypeParameters) {
            List<TypeParameterDescriptor> parameters = ((ClassifierDescriptorWithTypeParameters) containingDeclaration).getTypeConstructor().getParameters();
            b41.h(parameters, "descriptor.typeConstructor.parameters");
            q2 = C8215n.q(parameters, 10);
            ArrayList arrayList = new ArrayList(q2);
            for (TypeParameterDescriptor typeParameterDescriptor2 : parameters) {
                TypeConstructor typeConstructor = typeParameterDescriptor2.getTypeConstructor();
                b41.h(typeConstructor, "it.typeConstructor");
                arrayList.add(typeConstructor);
            }
            List<z71> upperBounds = typeParameterDescriptor.getUpperBounds();
            b41.h(upperBounds, "upperBounds");
            return a(arrayList, upperBounds, DescriptorUtilsKt.g(typeParameterDescriptor));
        } else if (containingDeclaration instanceof FunctionDescriptor) {
            List<TypeParameterDescriptor> typeParameters = ((FunctionDescriptor) containingDeclaration).getTypeParameters();
            b41.h(typeParameters, "descriptor.typeParameters");
            q = C8215n.q(typeParameters, 10);
            ArrayList arrayList2 = new ArrayList(q);
            for (TypeParameterDescriptor typeParameterDescriptor3 : typeParameters) {
                TypeConstructor typeConstructor2 = typeParameterDescriptor3.getTypeConstructor();
                b41.h(typeConstructor2, "it.typeConstructor");
                arrayList2.add(typeConstructor2);
            }
            List<z71> upperBounds2 = typeParameterDescriptor.getUpperBounds();
            b41.h(upperBounds2, "upperBounds");
            return a(arrayList2, upperBounds2, DescriptorUtilsKt.g(typeParameterDescriptor));
        } else {
            throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
        }
    }
}
