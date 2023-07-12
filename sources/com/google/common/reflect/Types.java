package com.google.common.reflect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.C4832d;
import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.C5152a0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.b12;
import tb.du1;
import tb.nm1;
import tb.yt2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class Types {
    private static final Function<Type, String> a = new C5272a();
    private static final C4832d b = C4832d.g(AVFSCacheConstants.COMMA_SEP).i("null");

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS { // from class: com.google.common.reflect.Types.ClassOwnership.1
            @Override // com.google.common.reflect.Types.ClassOwnership
            @NullableDecl
            Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER { // from class: com.google.common.reflect.Types.ClassOwnership.2
            @Override // com.google.common.reflect.Types.ClassOwnership
            @NullableDecl
            Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };
        
        static final ClassOwnership JVM_BEHAVIOR = detectJvmBehavior();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.reflect.Types$ClassOwnership$a */
        /* loaded from: classes10.dex */
        public class C5268a<T> {
            C5268a() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.reflect.Types$ClassOwnership$b */
        /* loaded from: classes10.dex */
        public static class C5269b extends C5268a<String> {
            C5269b() {
            }
        }

        private static ClassOwnership detectJvmBehavior() {
            ClassOwnership[] values;
            new C5269b();
            ParameterizedType parameterizedType = (ParameterizedType) C5269b.class.getGenericSuperclass();
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.getOwnerType(C5268a.class) == parameterizedType.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }

        @NullableDecl
        abstract Class<?> getOwnerType(Class<?> cls);

        /* synthetic */ ClassOwnership(C5272a c5272a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        GenericArrayTypeImpl(Type type) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(type);
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return nm1.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Types.t(this.componentType) + "[]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum JavaVersion {
        JAVA6 { // from class: com.google.common.reflect.Types.JavaVersion.1
            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                du1.p(type);
                if (type instanceof Class) {
                    Class cls = (Class) type;
                    return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
                }
                return type;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public GenericArrayType newArrayType(Type type) {
                return new GenericArrayTypeImpl(type);
            }
        },
        JAVA7 { // from class: com.google.common.reflect.Types.JavaVersion.2
            @Override // com.google.common.reflect.Types.JavaVersion
            Type newArrayType(Type type) {
                if (type instanceof Class) {
                    return Types.i((Class) type);
                }
                return new GenericArrayTypeImpl(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                return (Type) du1.p(type);
            }
        },
        JAVA8 { // from class: com.google.common.reflect.Types.JavaVersion.3
            @Override // com.google.common.reflect.Types.JavaVersion
            Type newArrayType(Type type) {
                return JavaVersion.JAVA7.newArrayType(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2);
                }
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                return JavaVersion.JAVA7.usedInGenericType(type);
            }
        },
        JAVA9 { // from class: com.google.common.reflect.Types.JavaVersion.4
            @Override // com.google.common.reflect.Types.JavaVersion
            boolean jdkTypeDuplicatesOwnerName() {
                return false;
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type newArrayType(Type type) {
                return JavaVersion.JAVA8.newArrayType(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            String typeName(Type type) {
                return JavaVersion.JAVA8.typeName(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                return JavaVersion.JAVA8.usedInGenericType(type);
            }
        };
        
        static final JavaVersion CURRENT;

        /* compiled from: Taobao */
        /* renamed from: com.google.common.reflect.Types$JavaVersion$a */
        /* loaded from: classes10.dex */
        static class C5270a extends AbstractC5281c<Map.Entry<String, int[][]>> {
            C5270a() {
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.google.common.reflect.Types$JavaVersion$b */
        /* loaded from: classes10.dex */
        static class C5271b extends AbstractC5281c<int[]> {
            C5271b() {
            }
        }

        static {
            JavaVersion javaVersion = JAVA6;
            JavaVersion javaVersion2 = JAVA7;
            JavaVersion javaVersion3 = JAVA8;
            JavaVersion javaVersion4 = JAVA9;
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                if (new C5270a().capture().toString().contains("java.util.Map.java.util.Map")) {
                    CURRENT = javaVersion3;
                } else {
                    CURRENT = javaVersion4;
                }
            } else if (new C5271b().capture() instanceof Class) {
                CURRENT = javaVersion2;
            } else {
                CURRENT = javaVersion;
            }
        }

        boolean jdkTypeDuplicatesOwnerName() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Type newArrayType(Type type);

        String typeName(Type type) {
            return Types.t(type);
        }

        final ImmutableList<Type> usedInGenericType(Type[] typeArr) {
            ImmutableList.C4971a builder = ImmutableList.builder();
            for (Type type : typeArr) {
                builder.a(usedInGenericType(type));
            }
            return builder.j();
        }

        abstract Type usedInGenericType(Type type);

        /* synthetic */ JavaVersion(C5272a c5272a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;
        @NullableDecl
        private final Type ownerType;
        private final Class<?> rawType;

        ParameterizedTypeImpl(@NullableDecl Type type, Class<?> cls, Type[] typeArr) {
            du1.p(cls);
            du1.d(typeArr.length == cls.getTypeParameters().length);
            Types.g(typeArr, "type parameter");
            this.ownerType = type;
            this.rawType = cls;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(typeArr);
        }

        public boolean equals(Object obj) {
            if (obj instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) obj;
                return getRawType().equals(parameterizedType.getRawType()) && nm1.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
            }
            return false;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return Types.s(this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            Type type = this.ownerType;
            return ((type == null ? 0 : type.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.ownerType != null) {
                JavaVersion javaVersion = JavaVersion.CURRENT;
                if (javaVersion.jdkTypeDuplicatesOwnerName()) {
                    sb.append(javaVersion.typeName(this.ownerType));
                    sb.append('.');
                }
            }
            sb.append(this.rawType.getName());
            sb.append('<');
            sb.append(Types.b.c(C5152a0.n(this.argumentsList, Types.a)));
            sb.append('>');
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class WildcardTypeImpl implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        /* JADX INFO: Access modifiers changed from: package-private */
        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.g(typeArr, "lower bound for wildcard");
            Types.g(typeArr2, "upper bound for wildcard");
            JavaVersion javaVersion = JavaVersion.CURRENT;
            this.lowerBounds = javaVersion.usedInGenericType(typeArr);
            this.upperBounds = javaVersion.usedInGenericType(typeArr2);
        }

        public boolean equals(Object obj) {
            if (obj instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) obj;
                return this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()));
            }
            return false;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return Types.s(this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return Types.s(this.upperBounds);
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("?");
            yt2<Type> it = this.lowerBounds.iterator();
            while (it.hasNext()) {
                sb.append(" super ");
                sb.append(JavaVersion.CURRENT.typeName(it.next()));
            }
            for (Type type : Types.h(this.upperBounds)) {
                sb.append(" extends ");
                sb.append(JavaVersion.CURRENT.typeName(type));
            }
            return sb.toString();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.reflect.Types$a */
    /* loaded from: classes10.dex */
    static class C5272a implements Function<Type, String> {
        C5272a() {
        }

        @Override // com.google.common.base.Function
        /* renamed from: a */
        public String apply(Type type) {
            return JavaVersion.CURRENT.typeName(type);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.reflect.Types$b */
    /* loaded from: classes10.dex */
    public static class C5273b extends AbstractC5291f {
        final /* synthetic */ AtomicReference b;

        C5273b(AtomicReference atomicReference) {
            this.b = atomicReference;
        }

        @Override // com.google.common.reflect.AbstractC5291f
        void b(Class<?> cls) {
            this.b.set(cls.getComponentType());
        }

        @Override // com.google.common.reflect.AbstractC5291f
        void c(GenericArrayType genericArrayType) {
            this.b.set(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.common.reflect.AbstractC5291f
        void e(TypeVariable<?> typeVariable) {
            this.b.set(Types.q(typeVariable.getBounds()));
        }

        @Override // com.google.common.reflect.AbstractC5291f
        void f(WildcardType wildcardType) {
            this.b.set(Types.q(wildcardType.getUpperBounds()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.reflect.Types$c */
    /* loaded from: classes10.dex */
    public static final class C5274c<X> {
        static final boolean a = !C5274c.class.getTypeParameters()[0].equals(Types.l(C5274c.class, "X", new Type[0]));

        C5274c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.reflect.Types$d */
    /* loaded from: classes10.dex */
    public static final class C5275d<D extends GenericDeclaration> {
        private final D a;
        private final String b;
        private final ImmutableList<Type> c;

        C5275d(D d, String str, Type[] typeArr) {
            Types.g(typeArr, "bound for type variable");
            this.a = (D) du1.p(d);
            this.b = (String) du1.p(str);
            this.c = ImmutableList.copyOf(typeArr);
        }

        public D a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (C5274c.a) {
                if (obj != null && Proxy.isProxyClass(obj.getClass()) && (Proxy.getInvocationHandler(obj) instanceof C5276e)) {
                    C5275d c5275d = ((C5276e) Proxy.getInvocationHandler(obj)).a;
                    return this.b.equals(c5275d.b()) && this.a.equals(c5275d.a()) && this.c.equals(c5275d.c);
                }
                return false;
            } else if (obj instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.b.equals(typeVariable.getName()) && this.a.equals(typeVariable.getGenericDeclaration());
            } else {
                return false;
            }
        }

        public int hashCode() {
            return this.a.hashCode() ^ this.b.hashCode();
        }

        public String toString() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.reflect.Types$e */
    /* loaded from: classes10.dex */
    public static final class C5276e implements InvocationHandler {
        private static final ImmutableMap<String, Method> b;
        private final C5275d<?> a;

        static {
            Method[] methods;
            ImmutableMap.C4977b builder = ImmutableMap.builder();
            for (Method method : C5275d.class.getMethods()) {
                if (method.getDeclaringClass().equals(C5275d.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    builder.c(method.getName(), method);
                }
            }
            b = builder.a();
        }

        C5276e(C5275d<?> c5275d) {
            this.a = c5275d;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = b.get(name);
            if (method2 != null) {
                try {
                    return method2.invoke(this.a, objArr);
                } catch (InvocationTargetException e) {
                    throw e.getCause();
                }
            }
            throw new UnsupportedOperationException(name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Type[] typeArr, String str) {
        Class cls;
        for (Type type : typeArr) {
            if (type instanceof Class) {
                du1.l(!cls.isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterable<Type> h(Iterable<Type> iterable) {
        return C5152a0.d(iterable, Predicates.g(Predicates.d(Object.class)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> i(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NullableDecl
    public static Type j(Type type) {
        du1.p(type);
        AtomicReference atomicReference = new AtomicReference();
        new C5273b(atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Type k(Type type) {
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            du1.e(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
            if (lowerBounds.length == 1) {
                return r(k(lowerBounds[0]));
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            du1.e(upperBounds.length == 1, "Wildcard should have only one upper bound.");
            return p(k(upperBounds[0]));
        }
        return JavaVersion.CURRENT.newArrayType(type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <D extends GenericDeclaration> TypeVariable<D> l(D d, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return o(d, str, typeArr);
    }

    static ParameterizedType m(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ParameterizedType n(@NullableDecl Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return m(cls, typeArr);
        }
        du1.p(typeArr);
        du1.k(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    private static <D extends GenericDeclaration> TypeVariable<D> o(D d, String str, Type[] typeArr) {
        return (TypeVariable) b12.a(TypeVariable.class, new C5276e(new C5275d(d, str, typeArr)));
    }

    @VisibleForTesting
    static WildcardType p(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NullableDecl
    public static Type q(Type[] typeArr) {
        for (Type type : typeArr) {
            Type j = j(type);
            if (j != null) {
                if (j instanceof Class) {
                    Class cls = (Class) j;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return p(j);
            }
        }
        return null;
    }

    @VisibleForTesting
    static WildcardType r(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Type[] s(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String t(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
