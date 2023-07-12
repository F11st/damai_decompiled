package tb;

import kotlin.jvm.functions.Function3;
import kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactory;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class w60 {
    @NotNull
    public static final String a(@NotNull ClassDescriptor classDescriptor, @NotNull TypeMappingConfiguration<?> typeMappingConfiguration) {
        String y;
        b41.i(classDescriptor, "klass");
        b41.i(typeMappingConfiguration, "typeMappingConfiguration");
        String predefinedFullInternalNameForClass = typeMappingConfiguration.getPredefinedFullInternalNameForClass(classDescriptor);
        if (predefinedFullInternalNameForClass == null) {
            DeclarationDescriptor containingDeclaration = classDescriptor.getContainingDeclaration();
            b41.h(containingDeclaration, "klass.containingDeclaration");
            String d = af2.c(classDescriptor.getName()).d();
            b41.h(d, "safeIdentifier(klass.name).identifier");
            if (containingDeclaration instanceof PackageFragmentDescriptor) {
                hp0 fqName = ((PackageFragmentDescriptor) containingDeclaration).getFqName();
                if (fqName.d()) {
                    return d;
                }
                StringBuilder sb = new StringBuilder();
                String b = fqName.b();
                b41.h(b, "fqName.asString()");
                y = C8604o.y(b, '.', r10.DIR, false, 4, null);
                sb.append(y);
                sb.append(r10.DIR);
                sb.append(d);
                return sb.toString();
            }
            ClassDescriptor classDescriptor2 = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
            if (classDescriptor2 != null) {
                String predefinedInternalNameForClass = typeMappingConfiguration.getPredefinedInternalNameForClass(classDescriptor2);
                if (predefinedInternalNameForClass == null) {
                    predefinedInternalNameForClass = a(classDescriptor2, typeMappingConfiguration);
                }
                return predefinedInternalNameForClass + '$' + d;
            }
            throw new IllegalArgumentException("Unexpected container: " + containingDeclaration + " for " + classDescriptor);
        }
        return predefinedFullInternalNameForClass;
    }

    public static /* synthetic */ String b(ClassDescriptor classDescriptor, TypeMappingConfiguration typeMappingConfiguration, int i, Object obj) {
        if ((i & 2) != 0) {
            typeMappingConfiguration = uq2.INSTANCE;
        }
        return a(classDescriptor, typeMappingConfiguration);
    }

    public static final boolean c(@NotNull CallableDescriptor callableDescriptor) {
        b41.i(callableDescriptor, "descriptor");
        if (callableDescriptor instanceof ConstructorDescriptor) {
            return true;
        }
        z71 returnType = callableDescriptor.getReturnType();
        b41.f(returnType);
        if (AbstractC8271b.A0(returnType)) {
            z71 returnType2 = callableDescriptor.getReturnType();
            b41.f(returnType2);
            if (!fr2.m(returnType2) && !(callableDescriptor instanceof PropertyGetterDescriptor)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [T, java.lang.Object] */
    @NotNull
    public static final <T> T d(@NotNull z71 z71Var, @NotNull JvmTypeFactory<T> jvmTypeFactory, @NotNull vq2 vq2Var, @NotNull TypeMappingConfiguration<? extends T> typeMappingConfiguration, @Nullable u61<T> u61Var, @NotNull Function3<? super z71, ? super T, ? super vq2, wt2> function3) {
        Object obj;
        z71 z71Var2;
        Object d;
        b41.i(z71Var, "kotlinType");
        b41.i(jvmTypeFactory, "factory");
        b41.i(vq2Var, "mode");
        b41.i(typeMappingConfiguration, "typeMappingConfiguration");
        b41.i(function3, "writeGenericType");
        z71 preprocessType = typeMappingConfiguration.preprocessType(z71Var);
        if (preprocessType == null) {
            if (up0.o(z71Var)) {
                return (T) d(fj2.b(z71Var, typeMappingConfiguration.releaseCoroutines()), jvmTypeFactory, vq2Var, typeMappingConfiguration, u61Var, function3);
            }
            xc2 xc2Var = xc2.INSTANCE;
            Object b = ar2.b(xc2Var, z71Var, jvmTypeFactory, vq2Var);
            if (b == null) {
                TypeConstructor c = z71Var.c();
                if (c instanceof IntersectionTypeConstructor) {
                    IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) c;
                    z71 c2 = intersectionTypeConstructor.c();
                    if (c2 == null) {
                        c2 = typeMappingConfiguration.commonSupertype(intersectionTypeConstructor.getSupertypes());
                    }
                    return (T) d(TypeUtilsKt.t(c2), jvmTypeFactory, vq2Var, typeMappingConfiguration, u61Var, function3);
                }
                ClassifierDescriptor declarationDescriptor = c.getDeclarationDescriptor();
                if (declarationDescriptor != null) {
                    if (kf0.r(declarationDescriptor)) {
                        T t = (T) jvmTypeFactory.createObjectType("error/NonExistentClass");
                        typeMappingConfiguration.processErrorType(z71Var, (ClassDescriptor) declarationDescriptor);
                        return t;
                    }
                    boolean z = declarationDescriptor instanceof ClassDescriptor;
                    if (z && AbstractC8271b.c0(z71Var)) {
                        if (z71Var.b().size() == 1) {
                            TypeProjection typeProjection = z71Var.b().get(0);
                            z71 type = typeProjection.getType();
                            b41.h(type, "memberProjection.type");
                            if (typeProjection.getProjectionKind() == Variance.IN_VARIANCE) {
                                d = jvmTypeFactory.createObjectType("java/lang/Object");
                            } else {
                                Variance projectionKind = typeProjection.getProjectionKind();
                                b41.h(projectionKind, "memberProjection.projectionKind");
                                d = d(type, jvmTypeFactory, vq2Var.f(projectionKind, true), typeMappingConfiguration, u61Var, function3);
                            }
                            return (T) jvmTypeFactory.createFromString(b41.r(jn1.ARRAY_START_STR, jvmTypeFactory.toString(d)));
                        }
                        throw new UnsupportedOperationException("arrays must have one type argument");
                    } else if (z) {
                        if (q21.b(declarationDescriptor) && !vq2Var.c() && (z71Var2 = (z71) tg0.a(xc2Var, z71Var)) != null) {
                            return (T) d(z71Var2, jvmTypeFactory, vq2Var.g(), typeMappingConfiguration, u61Var, function3);
                        }
                        if (vq2Var.e() && AbstractC8271b.j0((ClassDescriptor) declarationDescriptor)) {
                            obj = (Object) jvmTypeFactory.getJavaLangClassType();
                        } else {
                            ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
                            ClassDescriptor original = classDescriptor.getOriginal();
                            b41.h(original, "descriptor.original");
                            T predefinedTypeForClass = typeMappingConfiguration.getPredefinedTypeForClass(original);
                            if (predefinedTypeForClass == null) {
                                if (classDescriptor.getKind() == ClassKind.ENUM_ENTRY) {
                                    classDescriptor = (ClassDescriptor) classDescriptor.getContainingDeclaration();
                                }
                                ClassDescriptor original2 = classDescriptor.getOriginal();
                                b41.h(original2, "enumClassIfEnumEntry.original");
                                obj = (Object) jvmTypeFactory.createObjectType(a(original2, typeMappingConfiguration));
                            } else {
                                obj = (Object) predefinedTypeForClass;
                            }
                        }
                        function3.invoke(z71Var, obj, vq2Var);
                        return (T) obj;
                    } else if (declarationDescriptor instanceof TypeParameterDescriptor) {
                        return (T) d(TypeUtilsKt.i((TypeParameterDescriptor) declarationDescriptor), jvmTypeFactory, vq2Var, typeMappingConfiguration, null, FunctionsKt.b());
                    } else {
                        if ((declarationDescriptor instanceof TypeAliasDescriptor) && vq2Var.b()) {
                            return (T) d(((TypeAliasDescriptor) declarationDescriptor).getExpandedType(), jvmTypeFactory, vq2Var, typeMappingConfiguration, u61Var, function3);
                        }
                        throw new UnsupportedOperationException(b41.r("Unknown type ", z71Var));
                    }
                }
                throw new UnsupportedOperationException(b41.r("no descriptor for type constructor of ", z71Var));
            }
            ?? r9 = (Object) ar2.a(jvmTypeFactory, b, vq2Var.d());
            function3.invoke(z71Var, r9, vq2Var);
            return r9;
        }
        return (T) d(preprocessType, jvmTypeFactory, vq2Var, typeMappingConfiguration, u61Var, function3);
    }

    public static /* synthetic */ Object e(z71 z71Var, JvmTypeFactory jvmTypeFactory, vq2 vq2Var, TypeMappingConfiguration typeMappingConfiguration, u61 u61Var, Function3 function3, int i, Object obj) {
        if ((i & 32) != 0) {
            function3 = FunctionsKt.b();
        }
        return d(z71Var, jvmTypeFactory, vq2Var, typeMappingConfiguration, u61Var, function3);
    }
}
