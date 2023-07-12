package tb;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.C8226x;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.PropertyReference;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.f42;
import tb.g71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class zv2 {
    @NotNull
    private static final hp0 a = new hp0("kotlin.jvm.JvmStatic");

    /* JADX WARN: Incorrect type for immutable var: ssa=boolean[], code=short[], for r7v3, types: [boolean[]] */
    /* JADX WARN: Incorrect type for immutable var: ssa=byte[], code=short[], for r7v5, types: [byte[]] */
    /* JADX WARN: Incorrect type for immutable var: ssa=char[], code=short[], for r7v4, types: [char[]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [double[]] */
    /* JADX WARN: Type inference failed for: r7v19, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r7v20, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r7v21, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r7v7, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v8, types: [float[]] */
    /* JADX WARN: Type inference failed for: r7v9, types: [long[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.Object a(tb.y7 r6, java.lang.ClassLoader r7) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.zv2.a(tb.y7, java.lang.ClassLoader):java.lang.Object");
    }

    @Nullable
    public static final KCallableImpl<?> b(@Nullable Object obj) {
        KCallableImpl<?> kCallableImpl = (KCallableImpl) (!(obj instanceof KCallableImpl) ? null : obj);
        if (kCallableImpl == null) {
            kCallableImpl = c(obj);
        }
        return kCallableImpl != null ? kCallableImpl : d(obj);
    }

    @Nullable
    public static final KFunctionImpl c(@Nullable Object obj) {
        KFunctionImpl kFunctionImpl = (KFunctionImpl) (!(obj instanceof KFunctionImpl) ? null : obj);
        if (kFunctionImpl != null) {
            return kFunctionImpl;
        }
        if (!(obj instanceof FunctionReference)) {
            obj = null;
        }
        FunctionReference functionReference = (FunctionReference) obj;
        KCallable compute = functionReference != null ? functionReference.compute() : null;
        return compute instanceof KFunctionImpl ? compute : null;
    }

    @Nullable
    public static final KPropertyImpl<?> d(@Nullable Object obj) {
        KPropertyImpl<?> kPropertyImpl = (KPropertyImpl) (!(obj instanceof KPropertyImpl) ? null : obj);
        if (kPropertyImpl != null) {
            return kPropertyImpl;
        }
        if (!(obj instanceof PropertyReference)) {
            obj = null;
        }
        PropertyReference propertyReference = (PropertyReference) obj;
        KCallable compute = propertyReference != null ? propertyReference.compute() : null;
        return compute instanceof KPropertyImpl ? compute : null;
    }

    @NotNull
    public static final List<Annotation> e(@NotNull Annotated annotated) {
        b41.i(annotated, "$this$computeAnnotations");
        Annotations annotations = annotated.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (AnnotationDescriptor annotationDescriptor : annotations) {
            SourceElement source = annotationDescriptor.getSource();
            Annotation annotation = null;
            if (source instanceof tz1) {
                annotation = ((tz1) source).a();
            } else if (source instanceof f42.C9125a) {
                g02 javaElement = ((f42.C9125a) source).getJavaElement();
                if (!(javaElement instanceof vz1)) {
                    javaElement = null;
                }
                vz1 vz1Var = (vz1) javaElement;
                if (vz1Var != null) {
                    annotation = vz1Var.a();
                }
            } else {
                annotation = o(annotationDescriptor);
            }
            if (annotation != null) {
                arrayList.add(annotation);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final Class<?> f(@NotNull Class<?> cls) {
        b41.i(cls, "$this$createArrayType");
        return Array.newInstance(cls, 0).getClass();
    }

    @Nullable
    public static final Object g(@NotNull Type type) {
        b41.i(type, "type");
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            if (b41.d(type, Boolean.TYPE)) {
                return Boolean.FALSE;
            }
            if (b41.d(type, Character.TYPE)) {
                return Character.valueOf((char) 0);
            }
            if (b41.d(type, Byte.TYPE)) {
                return Byte.valueOf((byte) 0);
            }
            if (b41.d(type, Short.TYPE)) {
                return Short.valueOf((short) 0);
            }
            if (b41.d(type, Integer.TYPE)) {
                return 0;
            }
            if (b41.d(type, Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (b41.d(type, Long.TYPE)) {
                return 0L;
            }
            if (b41.d(type, Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            if (b41.d(type, Void.TYPE)) {
                throw new IllegalStateException("Parameter with void type is illegal");
            }
            throw new UnsupportedOperationException("Unknown primitive: " + type);
        }
        return null;
    }

    @Nullable
    public static final <M extends MessageLite, D extends CallableDescriptor> D h(@NotNull Class<?> cls, @NotNull M m, @NotNull NameResolver nameResolver, @NotNull er2 er2Var, @NotNull AbstractC9135fc abstractC9135fc, @NotNull Function2<? super MemberDeserializer, ? super M, ? extends D> function2) {
        List<ProtoBuf$TypeParameter> typeParameterList;
        b41.i(cls, "moduleAnchor");
        b41.i(m, "proto");
        b41.i(nameResolver, "nameResolver");
        b41.i(er2Var, "typeTable");
        b41.i(abstractC9135fc, "metadataVersion");
        b41.i(function2, "createDescriptor");
        d42 a2 = yg1.a(cls);
        if (m instanceof ProtoBuf$Function) {
            typeParameterList = ((ProtoBuf$Function) m).getTypeParameterList();
        } else if (!(m instanceof ProtoBuf$Property)) {
            throw new IllegalStateException(("Unsupported message: " + m).toString());
        } else {
            typeParameterList = ((ProtoBuf$Property) m).getTypeParameterList();
        }
        List<ProtoBuf$TypeParameter> list = typeParameterList;
        h70 a3 = a2.a();
        ModuleDescriptor b = a2.b();
        ix2 b2 = ix2.Companion.b();
        b41.h(list, "typeParameters");
        return function2.invoke(new MemberDeserializer(new j70(a3, nameResolver, b, er2Var, b2, abstractC9135fc, null, null, list)), m);
    }

    @Nullable
    public static final ReceiverParameterDescriptor i(@NotNull CallableDescriptor callableDescriptor) {
        b41.i(callableDescriptor, "$this$instanceReceiverParameter");
        if (callableDescriptor.getDispatchReceiverParameter() != null) {
            DeclarationDescriptor containingDeclaration = callableDescriptor.getContainingDeclaration();
            Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            return ((ClassDescriptor) containingDeclaration).getThisAsReceiverParameter();
        }
        return null;
    }

    @NotNull
    public static final hp0 j() {
        return a;
    }

    public static final boolean k(@NotNull KType kType) {
        z71 c;
        b41.i(kType, "$this$isInlineClassType");
        if (!(kType instanceof KTypeImpl)) {
            kType = null;
        }
        KTypeImpl kTypeImpl = (KTypeImpl) kType;
        return (kTypeImpl == null || (c = kTypeImpl.c()) == null || !q21.c(c)) ? false : true;
    }

    private static final Class<?> l(ClassLoader classLoader, String str, String str2, int i) {
        String y;
        String v;
        if (b41.d(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('.');
        y = C8604o.y(str2, '.', '$', false, 4, null);
        sb.append(y);
        String sb2 = sb.toString();
        if (i > 0) {
            StringBuilder sb3 = new StringBuilder();
            v = C8604o.v(jn1.ARRAY_START_STR, i);
            sb3.append(v);
            sb3.append(qb1.LEVEL_L);
            sb3.append(sb2);
            sb3.append(b90.TokenSEM);
            sb2 = sb3.toString();
        }
        return c02.a(classLoader, sb2);
    }

    private static final Class<?> m(ClassLoader classLoader, hj hjVar, int i) {
        o51 o51Var = o51.INSTANCE;
        ip0 j = hjVar.b().j();
        b41.h(j, "kotlinClassId.asSingleFqName().toUnsafe()");
        hj o = o51Var.o(j);
        if (o != null) {
            hjVar = o;
        }
        String b = hjVar.h().b();
        b41.h(b, "javaClassId.packageFqName.asString()");
        String b2 = hjVar.i().b();
        b41.h(b2, "javaClassId.relativeClassName.asString()");
        return l(classLoader, b, b2, i);
    }

    static /* synthetic */ Class n(ClassLoader classLoader, hj hjVar, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m(classLoader, hjVar, i);
    }

    private static final Annotation o(AnnotationDescriptor annotationDescriptor) {
        Map r;
        ClassDescriptor f = DescriptorUtilsKt.f(annotationDescriptor);
        Class<?> p = f != null ? p(f) : null;
        if (!(p instanceof Class)) {
            p = null;
        }
        if (p != null) {
            Set<Map.Entry<ni1, fn<?>>> entrySet = annotationDescriptor.getAllValueArguments().entrySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = entrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                ni1 ni1Var = (ni1) entry.getKey();
                ClassLoader classLoader = p.getClassLoader();
                b41.h(classLoader, "annotationClass.classLoader");
                Object r2 = r((fn) entry.getValue(), classLoader);
                Pair a2 = r2 != null ? hq2.a(ni1Var.b(), r2) : null;
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            r = C8226x.r(arrayList);
            return (Annotation) AnnotationConstructorCallerKt.d(p, r, null, 4, null);
        }
        return null;
    }

    @Nullable
    public static final Class<?> p(@NotNull ClassDescriptor classDescriptor) {
        b41.i(classDescriptor, "$this$toJavaClass");
        SourceElement source = classDescriptor.getSource();
        b41.h(source, "source");
        if (source instanceof y71) {
            KotlinJvmBinaryClass a2 = ((y71) source).a();
            Objects.requireNonNull(a2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((t02) a2).a();
        } else if (source instanceof f42.C9125a) {
            g02 javaElement = ((f42.C9125a) source).getJavaElement();
            Objects.requireNonNull(javaElement, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((ReflectJavaClass) javaElement).getElement();
        } else {
            hj h = DescriptorUtilsKt.h(classDescriptor);
            if (h != null) {
                return m(ReflectClassUtilKt.f(classDescriptor.getClass()), h, 0);
            }
            return null;
        }
    }

    @Nullable
    public static final KVisibility q(@NotNull f70 f70Var) {
        b41.i(f70Var, "$this$toKVisibility");
        if (b41.d(f70Var, e70.PUBLIC)) {
            return KVisibility.PUBLIC;
        }
        if (b41.d(f70Var, e70.PROTECTED)) {
            return KVisibility.PROTECTED;
        }
        if (b41.d(f70Var, e70.INTERNAL)) {
            return KVisibility.INTERNAL;
        }
        if (b41.d(f70Var, e70.PRIVATE) || b41.d(f70Var, e70.PRIVATE_TO_THIS)) {
            return KVisibility.PRIVATE;
        }
        return null;
    }

    private static final Object r(fn<?> fnVar, ClassLoader classLoader) {
        if (fnVar instanceof d6) {
            return o(((d6) fnVar).b());
        }
        if (fnVar instanceof y7) {
            return a((y7) fnVar, classLoader);
        }
        if (fnVar instanceof xe0) {
            Pair<? extends hj, ? extends ni1> b = ((xe0) fnVar).b();
            ni1 component2 = b.component2();
            Class n = n(classLoader, b.component1(), 0, 4, null);
            if (n != null) {
                return vv2.a(n, component2.b());
            }
            return null;
        } else if (fnVar instanceof g71) {
            g71.AbstractC9159b b2 = ((g71) fnVar).b();
            if (b2 instanceof g71.AbstractC9159b.C9161b) {
                g71.AbstractC9159b.C9161b c9161b = (g71.AbstractC9159b.C9161b) b2;
                return m(classLoader, c9161b.b(), c9161b.a());
            } else if (b2 instanceof g71.AbstractC9159b.C9160a) {
                ClassifierDescriptor declarationDescriptor = ((g71.AbstractC9159b.C9160a) b2).a().c().getDeclarationDescriptor();
                if (!(declarationDescriptor instanceof ClassDescriptor)) {
                    declarationDescriptor = null;
                }
                ClassDescriptor classDescriptor = (ClassDescriptor) declarationDescriptor;
                if (classDescriptor != null) {
                    return p(classDescriptor);
                }
                return null;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else if ((fnVar instanceof lf0) || (fnVar instanceof dm1)) {
            return null;
        } else {
            return fnVar.b();
        }
    }
}
