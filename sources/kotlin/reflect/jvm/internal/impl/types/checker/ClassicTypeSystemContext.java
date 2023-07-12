package kotlin.reflect.jvm.internal.impl.types.checker;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.tencent.open.SocialConstants;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.b;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.a41;
import tb.a81;
import tb.ak0;
import tb.ak1;
import tb.b41;
import tb.ci2;
import tb.dr2;
import tb.fd2;
import tb.fr2;
import tb.gd2;
import tb.gu2;
import tb.hp0;
import tb.ip0;
import tb.j60;
import tb.kg;
import tb.l2;
import tb.ld0;
import tb.mj;
import tb.oj;
import tb.q21;
import tb.tg1;
import tb.z71;
import tb.zj1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ClassicTypeSystemContext extends TypeSystemCommonBackendContext, TypeSystemInferenceExtensionContext {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        @NotNull
        public static TypeVariance A(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeParameterMarker typeParameterMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeParameterMarker, SocialConstants.PARAM_RECEIVER);
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                Variance variance = ((TypeParameterDescriptor) typeParameterMarker).getVariance();
                b41.h(variance, "this.variance");
                return dr2.a(variance);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeParameterMarker.getClass())).toString());
        }

        public static boolean B(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker, @NotNull hp0 hp0Var) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            b41.i(hp0Var, "fqName");
            if (kotlinTypeMarker instanceof z71) {
                return ((z71) kotlinTypeMarker).getAnnotations().hasAnnotation(hp0Var);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean C(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemInferenceExtensionContext.a.d(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean D(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeParameterMarker typeParameterMarker, @Nullable TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeParameterMarker, SocialConstants.PARAM_RECEIVER);
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                if (typeConstructorMarker == null ? true : typeConstructorMarker instanceof TypeConstructor) {
                    return TypeUtilsKt.l((TypeParameterDescriptor) typeParameterMarker, (TypeConstructor) typeConstructorMarker, null, 4, null);
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeParameterMarker.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeParameterMarker.getClass())).toString());
        }

        public static boolean E(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, "a");
            b41.i(simpleTypeMarker2, "b");
            if (simpleTypeMarker instanceof fd2) {
                if (simpleTypeMarker2 instanceof fd2) {
                    return ((fd2) simpleTypeMarker).b() == ((fd2) simpleTypeMarker2).b();
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker2 + AVFSCacheConstants.COMMA_SEP + a12.b(simpleTypeMarker2.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(simpleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker F(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull List<? extends KotlinTypeMarker> list) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(list, "types");
            return a41.a(list);
        }

        public static boolean G(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                return b.u0((TypeConstructor) typeConstructorMarker, c.a.any);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean H(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemInferenceExtensionContext.a.e(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean I(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemInferenceExtensionContext.a.f(classicTypeSystemContext, simpleTypeMarker);
        }

        public static boolean J(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor() instanceof ClassDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean K(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
                return (classDescriptor == null || !tg1.a(classDescriptor) || classDescriptor.getKind() == ClassKind.ENUM_ENTRY || classDescriptor.getKind() == ClassKind.ANNOTATION_CLASS) ? false : true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean L(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemInferenceExtensionContext.a.g(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean M(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).isDenotable();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean N(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemInferenceExtensionContext.a.h(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean O(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof z71) {
                return a81.a((z71) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean P(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
                return classDescriptor != null && q21.b(classDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean Q(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemInferenceExtensionContext.a.i(classicTypeSystemContext, simpleTypeMarker);
        }

        public static boolean R(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                return typeConstructorMarker instanceof IntegerLiteralTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean S(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                return typeConstructorMarker instanceof IntersectionTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean T(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemInferenceExtensionContext.a.j(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean U(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof fd2) {
                return ((fd2) simpleTypeMarker).d();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(simpleTypeMarker.getClass())).toString());
        }

        public static boolean V(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemInferenceExtensionContext.a.k(classicTypeSystemContext, kotlinTypeMarker);
        }

        public static boolean W(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                return b.u0((TypeConstructor) typeConstructorMarker, c.a.nothing);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean X(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof z71) {
                return fr2.m((z71) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean Y(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker capturedTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(capturedTypeMarker, SocialConstants.PARAM_RECEIVER);
            return capturedTypeMarker instanceof kg;
        }

        public static boolean Z(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof z71) {
                return b.q0((z71) simpleTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(simpleTypeMarker.getClass())).toString());
        }

        public static boolean a(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker, @NotNull TypeConstructorMarker typeConstructorMarker2) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, "c1");
            b41.i(typeConstructorMarker2, "c2");
            if (typeConstructorMarker instanceof TypeConstructor) {
                if (typeConstructorMarker2 instanceof TypeConstructor) {
                    return b41.d(typeConstructorMarker, typeConstructorMarker2);
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker2 + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker2.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        public static boolean a0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker capturedTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(capturedTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (capturedTypeMarker instanceof zj1) {
                return ((zj1) capturedTypeMarker).o();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(capturedTypeMarker.getClass())).toString());
        }

        public static int b(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof z71) {
                return ((z71) kotlinTypeMarker).b().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean b0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof fd2) {
                if (!a81.a((z71) simpleTypeMarker)) {
                    fd2 fd2Var = (fd2) simpleTypeMarker;
                    if (!(fd2Var.c().getDeclarationDescriptor() instanceof TypeAliasDescriptor) && (fd2Var.c().getDeclarationDescriptor() != null || (simpleTypeMarker instanceof kg) || (simpleTypeMarker instanceof zj1) || (simpleTypeMarker instanceof j60) || (fd2Var.c() instanceof IntegerLiteralTypeConstructor) || c0(classicTypeSystemContext, simpleTypeMarker))) {
                        return true;
                    }
                }
                return false;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(simpleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static TypeArgumentListMarker c(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof fd2) {
                return (TypeArgumentListMarker) simpleTypeMarker;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(simpleTypeMarker.getClass())).toString());
        }

        private static boolean c0(ClassicTypeSystemContext classicTypeSystemContext, SimpleTypeMarker simpleTypeMarker) {
            return (simpleTypeMarker instanceof gd2) && classicTypeSystemContext.isSingleClassifierType(((gd2) simpleTypeMarker).getOrigin());
        }

        @Nullable
        public static CapturedTypeMarker d(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof fd2) {
                if (simpleTypeMarker instanceof gd2) {
                    return classicTypeSystemContext.asCapturedType(((gd2) simpleTypeMarker).getOrigin());
                }
                if (simpleTypeMarker instanceof zj1) {
                    return (zj1) simpleTypeMarker;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(simpleTypeMarker.getClass())).toString());
        }

        public static boolean d0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker typeArgumentMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeArgumentMarker, SocialConstants.PARAM_RECEIVER);
            if (typeArgumentMarker instanceof TypeProjection) {
                return ((TypeProjection) typeArgumentMarker).isStarProjection();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeArgumentMarker.getClass())).toString());
        }

        @Nullable
        public static DefinitelyNotNullTypeMarker e(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof fd2) {
                if (simpleTypeMarker instanceof j60) {
                    return (j60) simpleTypeMarker;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(simpleTypeMarker.getClass())).toString());
        }

        public static boolean e0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof fd2) {
                if (!(simpleTypeMarker instanceof l2)) {
                    if (!((simpleTypeMarker instanceof j60) && (((j60) simpleTypeMarker).o() instanceof l2))) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(simpleTypeMarker.getClass())).toString());
        }

        @Nullable
        public static DynamicTypeMarker f(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker flexibleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(flexibleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (flexibleTypeMarker instanceof ak0) {
                if (flexibleTypeMarker instanceof ld0) {
                    return (ld0) flexibleTypeMarker;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(flexibleTypeMarker.getClass())).toString());
        }

        public static boolean f0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof fd2) {
                if (!(simpleTypeMarker instanceof ci2)) {
                    if (!((simpleTypeMarker instanceof j60) && (((j60) simpleTypeMarker).o() instanceof ci2))) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(simpleTypeMarker.getClass())).toString());
        }

        @Nullable
        public static FlexibleTypeMarker g(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof z71) {
                gu2 f = ((z71) kotlinTypeMarker).f();
                if (f instanceof ak0) {
                    return (ak0) f;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(kotlinTypeMarker.getClass())).toString());
        }

        public static boolean g0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                return declarationDescriptor != null && b.z0(declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        @Nullable
        public static SimpleTypeMarker h(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof z71) {
                gu2 f = ((z71) kotlinTypeMarker).f();
                if (f instanceof fd2) {
                    return (fd2) f;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker h0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker flexibleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(flexibleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (flexibleTypeMarker instanceof ak0) {
                return ((ak0) flexibleTypeMarker).k();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(flexibleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static TypeArgumentMarker i(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof z71) {
                return TypeUtilsKt.a((z71) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker i0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemInferenceExtensionContext.a.l(classicTypeSystemContext, kotlinTypeMarker);
        }

        @Nullable
        public static SimpleTypeMarker j(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull CaptureStatus captureStatus) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, "type");
            b41.i(captureStatus, "status");
            if (simpleTypeMarker instanceof fd2) {
                return ak1.b((fd2) simpleTypeMarker, captureStatus);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(simpleTypeMarker.getClass())).toString());
        }

        @Nullable
        public static KotlinTypeMarker j0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker capturedTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(capturedTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (capturedTypeMarker instanceof zj1) {
                return ((zj1) capturedTypeMarker).n();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(capturedTypeMarker.getClass())).toString());
        }

        @NotNull
        public static CaptureStatus k(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker capturedTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(capturedTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (capturedTypeMarker instanceof zj1) {
                return ((zj1) capturedTypeMarker).l();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(capturedTypeMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker k0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            gu2 b;
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof gu2) {
                b = oj.b((gu2) kotlinTypeMarker);
                return b;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker l(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, "lowerBound");
            b41.i(simpleTypeMarker2, "upperBound");
            if (simpleTypeMarker instanceof fd2) {
                if (simpleTypeMarker2 instanceof fd2) {
                    return KotlinTypeFactory.d((fd2) simpleTypeMarker, (fd2) simpleTypeMarker2);
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + AVFSCacheConstants.COMMA_SEP + a12.b(classicTypeSystemContext.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + classicTypeSystemContext + AVFSCacheConstants.COMMA_SEP + a12.b(classicTypeSystemContext.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker l0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemCommonBackendContext.a.a(classicTypeSystemContext, kotlinTypeMarker);
        }

        @Nullable
        public static List<SimpleTypeMarker> m(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            b41.i(typeConstructorMarker, "constructor");
            return TypeSystemInferenceExtensionContext.a.a(classicTypeSystemContext, simpleTypeMarker, typeConstructorMarker);
        }

        @NotNull
        public static AbstractTypeCheckerContext m0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, boolean z, boolean z2) {
            b41.i(classicTypeSystemContext, "this");
            return new mj(z, z2, false, null, null, classicTypeSystemContext, 28, null);
        }

        @NotNull
        public static TypeArgumentMarker n(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentListMarker typeArgumentListMarker, int i) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeArgumentListMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemInferenceExtensionContext.a.b(classicTypeSystemContext, typeArgumentListMarker, i);
        }

        @NotNull
        public static SimpleTypeMarker n0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull DefinitelyNotNullTypeMarker definitelyNotNullTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(definitelyNotNullTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (definitelyNotNullTypeMarker instanceof j60) {
                return ((j60) definitelyNotNullTypeMarker).o();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + definitelyNotNullTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(definitelyNotNullTypeMarker.getClass())).toString());
        }

        @NotNull
        public static TypeArgumentMarker o(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker, int i) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof z71) {
                return ((z71) kotlinTypeMarker).b().get(i);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(kotlinTypeMarker.getClass())).toString());
        }

        public static int o0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                return ((TypeConstructor) typeConstructorMarker).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        @Nullable
        public static TypeArgumentMarker p(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, int i) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemInferenceExtensionContext.a.c(classicTypeSystemContext, simpleTypeMarker, i);
        }

        @NotNull
        public static Collection<KotlinTypeMarker> p0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            TypeConstructorMarker typeConstructor = classicTypeSystemContext.typeConstructor(simpleTypeMarker);
            if (typeConstructor instanceof IntegerLiteralTypeConstructor) {
                return ((IntegerLiteralTypeConstructor) typeConstructor).e();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(simpleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static ip0 q(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return DescriptorUtilsKt.j((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static TypeArgumentMarker q0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeConstructorMarker capturedTypeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(capturedTypeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (capturedTypeConstructorMarker instanceof NewCapturedTypeConstructor) {
                return ((NewCapturedTypeConstructor) capturedTypeConstructorMarker).getProjection();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(capturedTypeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static TypeParameterMarker r(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker, int i) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                TypeParameterDescriptor typeParameterDescriptor = ((TypeConstructor) typeConstructorMarker).getParameters().get(i);
                b41.h(typeParameterDescriptor, "this.parameters[index]");
                return typeParameterDescriptor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        public static int r0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentListMarker typeArgumentListMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeArgumentListMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemInferenceExtensionContext.a.m(classicTypeSystemContext, typeArgumentListMarker);
        }

        @Nullable
        public static PrimitiveType s(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return b.P((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static Collection<KotlinTypeMarker> s0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                Collection<z71> supertypes = ((TypeConstructor) typeConstructorMarker).getSupertypes();
                b41.h(supertypes, "this.supertypes");
                return supertypes;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        @Nullable
        public static PrimitiveType t(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return b.S((ClassDescriptor) declarationDescriptor);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static CapturedTypeConstructorMarker t0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull CapturedTypeMarker capturedTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(capturedTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (capturedTypeMarker instanceof zj1) {
                return ((zj1) capturedTypeMarker).c();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + capturedTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(capturedTypeMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker u(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeParameterMarker typeParameterMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeParameterMarker, SocialConstants.PARAM_RECEIVER);
            if (typeParameterMarker instanceof TypeParameterDescriptor) {
                return TypeUtilsKt.i((TypeParameterDescriptor) typeParameterMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeParameterMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeParameterMarker.getClass())).toString());
        }

        @NotNull
        public static TypeConstructorMarker u0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemInferenceExtensionContext.a.n(classicTypeSystemContext, kotlinTypeMarker);
        }

        @Nullable
        public static KotlinTypeMarker v(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof z71) {
                return q21.e((z71) kotlinTypeMarker);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + kotlinTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(kotlinTypeMarker.getClass())).toString());
        }

        @NotNull
        public static TypeConstructorMarker v0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof fd2) {
                return ((fd2) simpleTypeMarker).c();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(simpleTypeMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker w(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker typeArgumentMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeArgumentMarker, SocialConstants.PARAM_RECEIVER);
            if (typeArgumentMarker instanceof TypeProjection) {
                return ((TypeProjection) typeArgumentMarker).getType().f();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeArgumentMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker w0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull FlexibleTypeMarker flexibleTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(flexibleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (flexibleTypeMarker instanceof ak0) {
                return ((ak0) flexibleTypeMarker).l();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + flexibleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(flexibleTypeMarker.getClass())).toString());
        }

        @Nullable
        public static TypeParameterMarker x(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeVariableTypeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeVariableTypeConstructorMarker instanceof NewTypeVariableConstructor) {
                return ((NewTypeVariableConstructor) typeVariableTypeConstructorMarker).getOriginalTypeParameter();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeVariableTypeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeVariableTypeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker x0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            return TypeSystemInferenceExtensionContext.a.o(classicTypeSystemContext, kotlinTypeMarker);
        }

        @Nullable
        public static TypeParameterMarker y(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeConstructorMarker typeConstructorMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeConstructorMarker, SocialConstants.PARAM_RECEIVER);
            if (typeConstructorMarker instanceof TypeConstructor) {
                ClassifierDescriptor declarationDescriptor = ((TypeConstructor) typeConstructorMarker).getDeclarationDescriptor();
                if (declarationDescriptor instanceof TypeParameterDescriptor) {
                    return (TypeParameterDescriptor) declarationDescriptor;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeConstructorMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeConstructorMarker.getClass())).toString());
        }

        @NotNull
        public static KotlinTypeMarker y0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull KotlinTypeMarker kotlinTypeMarker, boolean z) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(kotlinTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (kotlinTypeMarker instanceof SimpleTypeMarker) {
                return classicTypeSystemContext.withNullability((SimpleTypeMarker) kotlinTypeMarker, z);
            }
            if (kotlinTypeMarker instanceof FlexibleTypeMarker) {
                FlexibleTypeMarker flexibleTypeMarker = (FlexibleTypeMarker) kotlinTypeMarker;
                return classicTypeSystemContext.createFlexibleType(classicTypeSystemContext.withNullability(classicTypeSystemContext.lowerBound(flexibleTypeMarker), z), classicTypeSystemContext.withNullability(classicTypeSystemContext.upperBound(flexibleTypeMarker), z));
            }
            throw new IllegalStateException("sealed".toString());
        }

        @NotNull
        public static TypeVariance z(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull TypeArgumentMarker typeArgumentMarker) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(typeArgumentMarker, SocialConstants.PARAM_RECEIVER);
            if (typeArgumentMarker instanceof TypeProjection) {
                Variance projectionKind = ((TypeProjection) typeArgumentMarker).getProjectionKind();
                b41.h(projectionKind, "this.projectionKind");
                return dr2.a(projectionKind);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + typeArgumentMarker + AVFSCacheConstants.COMMA_SEP + a12.b(typeArgumentMarker.getClass())).toString());
        }

        @NotNull
        public static SimpleTypeMarker z0(@NotNull ClassicTypeSystemContext classicTypeSystemContext, @NotNull SimpleTypeMarker simpleTypeMarker, boolean z) {
            b41.i(classicTypeSystemContext, "this");
            b41.i(simpleTypeMarker, SocialConstants.PARAM_RECEIVER);
            if (simpleTypeMarker instanceof fd2) {
                return ((fd2) simpleTypeMarker).j(z);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + simpleTypeMarker + AVFSCacheConstants.COMMA_SEP + a12.b(simpleTypeMarker.getClass())).toString());
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @Nullable
    CapturedTypeMarker asCapturedType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @Nullable
    SimpleTypeMarker asSimpleType(@NotNull KotlinTypeMarker kotlinTypeMarker);

    @NotNull
    KotlinTypeMarker createFlexibleType(@NotNull SimpleTypeMarker simpleTypeMarker, @NotNull SimpleTypeMarker simpleTypeMarker2);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    boolean isSingleClassifierType(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    SimpleTypeMarker lowerBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    TypeConstructorMarker typeConstructor(@NotNull SimpleTypeMarker simpleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    SimpleTypeMarker upperBound(@NotNull FlexibleTypeMarker flexibleTypeMarker);

    @Override // kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext
    @NotNull
    SimpleTypeMarker withNullability(@NotNull SimpleTypeMarker simpleTypeMarker, boolean z);
}
