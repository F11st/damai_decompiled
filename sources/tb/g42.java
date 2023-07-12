package tb;

import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.builtins.C8277c;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedCallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.a71;
import tb.w61;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class g42 {
    @NotNull
    public static final g42 INSTANCE = new g42();
    private static final hj a;

    static {
        hj m = hj.m(new hp0("java.lang.Void"));
        b41.h(m, "ClassId.topLevel(FqName(\"java.lang.Void\"))");
        a = m;
    }

    private g42() {
    }

    private final PrimitiveType a(Class<?> cls) {
        if (cls.isPrimitive()) {
            JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.get(cls.getSimpleName());
            b41.h(jvmPrimitiveType, "JvmPrimitiveType.get(simpleName)");
            return jvmPrimitiveType.getPrimitiveType();
        }
        return null;
    }

    private final boolean b(FunctionDescriptor functionDescriptor) {
        if (x60.m(functionDescriptor) || x60.n(functionDescriptor)) {
            return true;
        }
        return b41.d(functionDescriptor.getName(), tj.Companion.a()) && functionDescriptor.getValueParameters().isEmpty();
    }

    private final JvmFunctionSignature.C8250c d(FunctionDescriptor functionDescriptor) {
        return new JvmFunctionSignature.C8250c(new w61.C9846b(e(functionDescriptor), mf1.c(functionDescriptor, false, false, 1, null)));
    }

    private final String e(CallableMemberDescriptor callableMemberDescriptor) {
        String b = SpecialBuiltinMembers.b(callableMemberDescriptor);
        if (b != null) {
            return b;
        }
        if (callableMemberDescriptor instanceof PropertyGetterDescriptor) {
            String b2 = DescriptorUtilsKt.o(callableMemberDescriptor).getName().b();
            b41.h(b2, "descriptor.propertyIfAccessor.name.asString()");
            return n61.a(b2);
        } else if (callableMemberDescriptor instanceof PropertySetterDescriptor) {
            String b3 = DescriptorUtilsKt.o(callableMemberDescriptor).getName().b();
            b41.h(b3, "descriptor.propertyIfAccessor.name.asString()");
            return n61.d(b3);
        } else {
            String b4 = callableMemberDescriptor.getName().b();
            b41.h(b4, "descriptor.name.asString()");
            return b4;
        }
    }

    @NotNull
    public final hj c(@NotNull Class<?> cls) {
        b41.i(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            b41.h(componentType, "klass.componentType");
            PrimitiveType a2 = a(componentType);
            if (a2 != null) {
                return new hj(C8277c.BUILT_INS_PACKAGE_FQ_NAME, a2.getArrayTypeName());
            }
            hj m = hj.m(C8277c.C8278a.array.l());
            b41.h(m, "ClassId.topLevel(Standar…s.FqNames.array.toSafe())");
            return m;
        } else if (b41.d(cls, Void.TYPE)) {
            return a;
        } else {
            PrimitiveType a3 = a(cls);
            if (a3 != null) {
                return new hj(C8277c.BUILT_INS_PACKAGE_FQ_NAME, a3.getTypeName());
            }
            hj a4 = ReflectClassUtilKt.a(cls);
            if (!a4.k()) {
                o51 o51Var = o51.INSTANCE;
                hp0 b = a4.b();
                b41.h(b, "classId.asSingleFqName()");
                hj n = o51Var.n(b);
                if (n != null) {
                    return n;
                }
            }
            return a4;
        }
    }

    @NotNull
    public final a71 f(@NotNull PropertyDescriptor propertyDescriptor) {
        b41.i(propertyDescriptor, "possiblyOverriddenProperty");
        CallableMemberDescriptor L = d70.L(propertyDescriptor);
        b41.h(L, "DescriptorUtils.unwrapFa…ssiblyOverriddenProperty)");
        PropertyDescriptor original = ((PropertyDescriptor) L).getOriginal();
        b41.h(original, "DescriptorUtils.unwrapFa…rriddenProperty).original");
        if (original instanceof p70) {
            p70 p70Var = (p70) original;
            ProtoBuf$Property proto = p70Var.getProto();
            GeneratedMessageLite.C8441c<ProtoBuf$Property, JvmProtoBuf.JvmPropertySignature> c8441c = JvmProtoBuf.propertySignature;
            b41.h(c8441c, "JvmProtoBuf.propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) fx1.a(proto, c8441c);
            if (jvmPropertySignature != null) {
                return new a71.C8900c(original, proto, jvmPropertySignature, p70Var.getNameResolver(), p70Var.getTypeTable());
            }
        } else if (original instanceof m51) {
            SourceElement source = ((m51) original).getSource();
            if (!(source instanceof JavaSourceElement)) {
                source = null;
            }
            JavaSourceElement javaSourceElement = (JavaSourceElement) source;
            JavaElement javaElement = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            if (javaElement instanceof i02) {
                return new a71.C8898a(((i02) javaElement).d());
            }
            if (javaElement instanceof l02) {
                Method d = ((l02) javaElement).d();
                PropertySetterDescriptor setter = original.getSetter();
                SourceElement source2 = setter != null ? setter.getSource() : null;
                if (!(source2 instanceof JavaSourceElement)) {
                    source2 = null;
                }
                JavaSourceElement javaSourceElement2 = (JavaSourceElement) source2;
                JavaElement javaElement2 = javaSourceElement2 != null ? javaSourceElement2.getJavaElement() : null;
                if (!(javaElement2 instanceof l02)) {
                    javaElement2 = null;
                }
                l02 l02Var = (l02) javaElement2;
                return new a71.C8899b(d, l02Var != null ? l02Var.d() : null);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + original + " (source = " + javaElement + ')');
        }
        PropertyGetterDescriptor getter = original.getGetter();
        b41.f(getter);
        JvmFunctionSignature.C8250c d2 = d(getter);
        PropertySetterDescriptor setter2 = original.getSetter();
        return new a71.C8901d(d2, setter2 != null ? d(setter2) : null);
    }

    @NotNull
    public final JvmFunctionSignature g(@NotNull FunctionDescriptor functionDescriptor) {
        Method d;
        w61.C9846b b;
        w61.C9846b e;
        b41.i(functionDescriptor, "possiblySubstitutedFunction");
        CallableMemberDescriptor L = d70.L(functionDescriptor);
        b41.h(L, "DescriptorUtils.unwrapFa…siblySubstitutedFunction)");
        FunctionDescriptor original = ((FunctionDescriptor) L).getOriginal();
        b41.h(original, "DescriptorUtils.unwrapFa…titutedFunction).original");
        if (original instanceof DeserializedCallableMemberDescriptor) {
            DeserializedCallableMemberDescriptor deserializedCallableMemberDescriptor = (DeserializedCallableMemberDescriptor) original;
            MessageLite proto = deserializedCallableMemberDescriptor.getProto();
            if ((proto instanceof ProtoBuf$Function) && (e = b71.INSTANCE.e((ProtoBuf$Function) proto, deserializedCallableMemberDescriptor.getNameResolver(), deserializedCallableMemberDescriptor.getTypeTable())) != null) {
                return new JvmFunctionSignature.C8250c(e);
            }
            if ((proto instanceof ProtoBuf$Constructor) && (b = b71.INSTANCE.b((ProtoBuf$Constructor) proto, deserializedCallableMemberDescriptor.getNameResolver(), deserializedCallableMemberDescriptor.getTypeTable())) != null) {
                DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
                b41.h(containingDeclaration, "possiblySubstitutedFunction.containingDeclaration");
                if (q21.b(containingDeclaration)) {
                    return new JvmFunctionSignature.C8250c(b);
                }
                return new JvmFunctionSignature.C8249b(b);
            }
            return d(original);
        }
        if (original instanceof JavaMethodDescriptor) {
            SourceElement source = ((JavaMethodDescriptor) original).getSource();
            if (!(source instanceof JavaSourceElement)) {
                source = null;
            }
            JavaSourceElement javaSourceElement = (JavaSourceElement) source;
            JavaElement javaElement = javaSourceElement != null ? javaSourceElement.getJavaElement() : null;
            l02 l02Var = (l02) (javaElement instanceof l02 ? javaElement : null);
            if (l02Var != null && (d = l02Var.d()) != null) {
                return new JvmFunctionSignature.C8248a(d);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + original);
        } else if (original instanceof a51) {
            SourceElement source2 = ((a51) original).getSource();
            if (!(source2 instanceof JavaSourceElement)) {
                source2 = null;
            }
            JavaSourceElement javaSourceElement2 = (JavaSourceElement) source2;
            JavaElement javaElement2 = javaSourceElement2 != null ? javaSourceElement2.getJavaElement() : null;
            if (javaElement2 instanceof f02) {
                return new JvmFunctionSignature.JavaConstructor(((f02) javaElement2).d());
            }
            if (javaElement2 instanceof ReflectJavaClass) {
                ReflectJavaClass reflectJavaClass = (ReflectJavaClass) javaElement2;
                if (reflectJavaClass.isAnnotationType()) {
                    return new JvmFunctionSignature.FakeJavaAnnotationConstructor(reflectJavaClass.getElement());
                }
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + original + " (" + javaElement2 + ')');
        } else if (b(original)) {
            return d(original);
        } else {
            throw new KotlinReflectionInternalError("Unknown origin of " + original + " (" + original.getClass() + ')');
        }
    }
}
