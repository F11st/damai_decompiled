package kotlin.reflect.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.C8215n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.j71;
import tb.s61;
import tb.t02;
import tb.vp;
import tb.wt2;
import tb.x02;
import tb.xq2;
import tb.z61;
import tb.z71;
import tb.zv2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class KTypeParameterImpl implements KTypeParameter, KClassifierImpl {
    static final /* synthetic */ KProperty[] d = {a12.i(new PropertyReference1Impl(a12.b(KTypeParameterImpl.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    @NotNull
    private final x02.C9894a a;
    private final KTypeParameterOwnerImpl b;
    @NotNull
    private final TypeParameterDescriptor c;

    public KTypeParameterImpl(@Nullable KTypeParameterOwnerImpl kTypeParameterOwnerImpl, @NotNull TypeParameterDescriptor typeParameterDescriptor) {
        KClassImpl<?> kClassImpl;
        Object accept;
        b41.i(typeParameterDescriptor, "descriptor");
        this.c = typeParameterDescriptor;
        this.a = x02.d(new Function0<List<? extends KTypeImpl>>() { // from class: kotlin.reflect.jvm.internal.KTypeParameterImpl$upperBounds$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KTypeImpl> invoke() {
                int q;
                List<z71> upperBounds = KTypeParameterImpl.this.getDescriptor().getUpperBounds();
                b41.h(upperBounds, "descriptor.upperBounds");
                q = C8215n.q(upperBounds, 10);
                ArrayList arrayList = new ArrayList(q);
                for (z71 z71Var : upperBounds) {
                    arrayList.add(new KTypeImpl(z71Var, null, 2, null));
                }
                return arrayList;
            }
        });
        if (kTypeParameterOwnerImpl == null) {
            DeclarationDescriptor containingDeclaration = getDescriptor().getContainingDeclaration();
            b41.h(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof ClassDescriptor) {
                accept = c((ClassDescriptor) containingDeclaration);
            } else if (containingDeclaration instanceof CallableMemberDescriptor) {
                DeclarationDescriptor containingDeclaration2 = ((CallableMemberDescriptor) containingDeclaration).getContainingDeclaration();
                b41.h(containingDeclaration2, "declaration.containingDeclaration");
                if (containingDeclaration2 instanceof ClassDescriptor) {
                    kClassImpl = c((ClassDescriptor) containingDeclaration2);
                } else {
                    DeserializedMemberDescriptor deserializedMemberDescriptor = (DeserializedMemberDescriptor) (!(containingDeclaration instanceof DeserializedMemberDescriptor) ? null : containingDeclaration);
                    if (deserializedMemberDescriptor != null) {
                        KClass e = s61.e(a(deserializedMemberDescriptor));
                        Objects.requireNonNull(e, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
                        kClassImpl = (KClassImpl) e;
                    } else {
                        throw new KotlinReflectionInternalError("Non-class callable descriptor must be deserialized: " + containingDeclaration);
                    }
                }
                accept = containingDeclaration.accept(new vp(kClassImpl), wt2.INSTANCE);
            } else {
                throw new KotlinReflectionInternalError("Unknown type parameter container: " + containingDeclaration);
            }
            b41.h(accept, "when (val declaration = … $declaration\")\n        }");
            kTypeParameterOwnerImpl = (KTypeParameterOwnerImpl) accept;
        }
        this.b = kTypeParameterOwnerImpl;
    }

    private final Class<?> a(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        Class<?> a;
        DeserializedContainerSource containerSource = deserializedMemberDescriptor.getContainerSource();
        if (!(containerSource instanceof z61)) {
            containerSource = null;
        }
        z61 z61Var = (z61) containerSource;
        KotlinJvmBinaryClass c = z61Var != null ? z61Var.c() : null;
        t02 t02Var = c instanceof t02 ? c : null;
        if (t02Var == null || (a = t02Var.a()) == null) {
            throw new KotlinReflectionInternalError("Container of deserialized member is not resolved: " + deserializedMemberDescriptor);
        }
        return a;
    }

    private final KClassImpl<?> c(ClassDescriptor classDescriptor) {
        Class<?> p = zv2.p(classDescriptor);
        KClassImpl<?> kClassImpl = (KClassImpl) (p != null ? s61.e(p) : null);
        if (kClassImpl != null) {
            return kClassImpl;
        }
        throw new KotlinReflectionInternalError("Type parameter container is not resolved: " + classDescriptor.getContainingDeclaration());
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    @NotNull
    /* renamed from: b */
    public TypeParameterDescriptor getDescriptor() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof KTypeParameterImpl) {
            KTypeParameterImpl kTypeParameterImpl = (KTypeParameterImpl) obj;
            if (b41.d(this.b, kTypeParameterImpl.b) && b41.d(getName(), kTypeParameterImpl.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public String getName() {
        String b = getDescriptor().getName().b();
        b41.h(b, "descriptor.name.asString()");
        return b;
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public List<KType> getUpperBounds() {
        return (List) this.a.b(this, d[0]);
    }

    @Override // kotlin.reflect.KTypeParameter
    @NotNull
    public KVariance getVariance() {
        int i = j71.$EnumSwitchMapping$0[getDescriptor().getVariance().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return KVariance.OUT;
                }
                throw new NoWhenBranchMatchedException();
            }
            return KVariance.IN;
        }
        return KVariance.INVARIANT;
    }

    public int hashCode() {
        return (this.b.hashCode() * 31) + getName().hashCode();
    }

    @Override // kotlin.reflect.KTypeParameter
    public boolean isReified() {
        return getDescriptor().isReified();
    }

    @NotNull
    public String toString() {
        return xq2.Companion.a(this);
    }
}
