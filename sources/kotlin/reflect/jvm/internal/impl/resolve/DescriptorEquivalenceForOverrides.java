package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.collections.C8212k;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.b81;
import tb.d70;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class DescriptorEquivalenceForOverrides {
    @NotNull
    public static final DescriptorEquivalenceForOverrides INSTANCE = new DescriptorEquivalenceForOverrides();

    private DescriptorEquivalenceForOverrides() {
    }

    public static /* synthetic */ boolean b(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2, boolean z, boolean z2, boolean z3, b81 b81Var, int i, Object obj) {
        return descriptorEquivalenceForOverrides.a(callableDescriptor, callableDescriptor2, z, (i & 8) != 0 ? true : z2, (i & 16) != 0 ? false : z3, b81Var);
    }

    private final boolean c(ClassDescriptor classDescriptor, ClassDescriptor classDescriptor2) {
        return b41.d(classDescriptor.getTypeConstructor(), classDescriptor2.getTypeConstructor());
    }

    public static /* synthetic */ boolean e(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        return descriptorEquivalenceForOverrides.d(declarationDescriptor, declarationDescriptor2, z, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean h(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final Boolean invoke(@Nullable DeclarationDescriptor declarationDescriptor, @Nullable DeclarationDescriptor declarationDescriptor2) {
                    return Boolean.FALSE;
                }
            };
        }
        return descriptorEquivalenceForOverrides.g(typeParameterDescriptor, typeParameterDescriptor2, z, function2);
    }

    private final boolean i(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2, boolean z) {
        DeclarationDescriptor containingDeclaration = declarationDescriptor.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration2 = declarationDescriptor2.getContainingDeclaration();
        if (!(containingDeclaration instanceof CallableMemberDescriptor) && !(containingDeclaration2 instanceof CallableMemberDescriptor)) {
            return e(this, containingDeclaration, containingDeclaration2, z, false, 8, null);
        }
        return function2.invoke(containingDeclaration, containingDeclaration2).booleanValue();
    }

    private final SourceElement j(CallableDescriptor callableDescriptor) {
        while (callableDescriptor instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) callableDescriptor;
            if (callableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
            b41.h(overriddenDescriptors, "overriddenDescriptors");
            callableDescriptor = (CallableMemberDescriptor) C8212k.r0(overriddenDescriptors);
            if (callableDescriptor == null) {
                return null;
            }
        }
        return callableDescriptor.getSource();
    }

    public final boolean a(@NotNull final CallableDescriptor callableDescriptor, @NotNull final CallableDescriptor callableDescriptor2, final boolean z, boolean z2, boolean z3, @NotNull b81 b81Var) {
        b41.i(callableDescriptor, "a");
        b41.i(callableDescriptor2, "b");
        b41.i(b81Var, "kotlinTypeRefiner");
        if (b41.d(callableDescriptor, callableDescriptor2)) {
            return true;
        }
        if (b41.d(callableDescriptor.getName(), callableDescriptor2.getName())) {
            if (z2 && (callableDescriptor instanceof MemberDescriptor) && (callableDescriptor2 instanceof MemberDescriptor) && ((MemberDescriptor) callableDescriptor).isExpect() != ((MemberDescriptor) callableDescriptor2).isExpect()) {
                return false;
            }
            if ((!b41.d(callableDescriptor.getContainingDeclaration(), callableDescriptor2.getContainingDeclaration()) || (z && b41.d(j(callableDescriptor), j(callableDescriptor2)))) && !d70.E(callableDescriptor) && !d70.E(callableDescriptor2) && i(callableDescriptor, callableDescriptor2, new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1
                @Override // kotlin.jvm.functions.Function2
                @NotNull
                public final Boolean invoke(@Nullable DeclarationDescriptor declarationDescriptor, @Nullable DeclarationDescriptor declarationDescriptor2) {
                    return Boolean.FALSE;
                }
            }, z)) {
                OverridingUtil i = OverridingUtil.i(b81Var, new KotlinTypeChecker.TypeConstructorEquality() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1
                    @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
                    public final boolean equals(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2) {
                        b41.i(typeConstructor, "c1");
                        b41.i(typeConstructor2, "c2");
                        if (b41.d(typeConstructor, typeConstructor2)) {
                            return true;
                        }
                        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
                        ClassifierDescriptor declarationDescriptor2 = typeConstructor2.getDeclarationDescriptor();
                        if ((declarationDescriptor instanceof TypeParameterDescriptor) && (declarationDescriptor2 instanceof TypeParameterDescriptor)) {
                            boolean z4 = z;
                            final CallableDescriptor callableDescriptor3 = callableDescriptor;
                            final CallableDescriptor callableDescriptor4 = callableDescriptor2;
                            return DescriptorEquivalenceForOverrides.INSTANCE.g((TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, z4, new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                @NotNull
                                public final Boolean invoke(@Nullable DeclarationDescriptor declarationDescriptor3, @Nullable DeclarationDescriptor declarationDescriptor4) {
                                    return Boolean.valueOf(b41.d(declarationDescriptor3, CallableDescriptor.this) && b41.d(declarationDescriptor4, callableDescriptor4));
                                }
                            });
                        }
                        return false;
                    }
                });
                b41.h(i, "a: CallableDescriptor,\n …= a && y == b }\n        }");
                OverridingUtil.OverrideCompatibilityInfo.Result c = i.F(callableDescriptor, callableDescriptor2, null, !z3).c();
                OverridingUtil.OverrideCompatibilityInfo.Result result = OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
                return c == result && i.F(callableDescriptor2, callableDescriptor, null, z3 ^ true).c() == result;
            }
            return false;
        }
        return false;
    }

    public final boolean d(@Nullable DeclarationDescriptor declarationDescriptor, @Nullable DeclarationDescriptor declarationDescriptor2, boolean z, boolean z2) {
        if ((declarationDescriptor instanceof ClassDescriptor) && (declarationDescriptor2 instanceof ClassDescriptor)) {
            return c((ClassDescriptor) declarationDescriptor, (ClassDescriptor) declarationDescriptor2);
        }
        if ((declarationDescriptor instanceof TypeParameterDescriptor) && (declarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return h(this, (TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, z, null, 8, null);
        }
        if ((declarationDescriptor instanceof CallableDescriptor) && (declarationDescriptor2 instanceof CallableDescriptor)) {
            return b(this, (CallableDescriptor) declarationDescriptor, (CallableDescriptor) declarationDescriptor2, z, z2, false, b81.C8955a.INSTANCE, 16, null);
        }
        return ((declarationDescriptor instanceof PackageFragmentDescriptor) && (declarationDescriptor2 instanceof PackageFragmentDescriptor)) ? b41.d(((PackageFragmentDescriptor) declarationDescriptor).getFqName(), ((PackageFragmentDescriptor) declarationDescriptor2).getFqName()) : b41.d(declarationDescriptor, declarationDescriptor2);
    }

    @JvmOverloads
    public final boolean f(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeParameterDescriptor typeParameterDescriptor2, boolean z) {
        b41.i(typeParameterDescriptor, "a");
        b41.i(typeParameterDescriptor2, "b");
        return h(this, typeParameterDescriptor, typeParameterDescriptor2, z, null, 8, null);
    }

    @JvmOverloads
    public final boolean g(@NotNull TypeParameterDescriptor typeParameterDescriptor, @NotNull TypeParameterDescriptor typeParameterDescriptor2, boolean z, @NotNull Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> function2) {
        b41.i(typeParameterDescriptor, "a");
        b41.i(typeParameterDescriptor2, "b");
        b41.i(function2, "equivalentCallables");
        if (b41.d(typeParameterDescriptor, typeParameterDescriptor2)) {
            return true;
        }
        return !b41.d(typeParameterDescriptor.getContainingDeclaration(), typeParameterDescriptor2.getContainingDeclaration()) && i(typeParameterDescriptor, typeParameterDescriptor2, function2, z) && typeParameterDescriptor.getIndex() == typeParameterDescriptor2.getIndex();
    }
}
