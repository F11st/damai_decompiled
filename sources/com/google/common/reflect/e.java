package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.nm1;

/* compiled from: Taobao */
@Beta
/* loaded from: classes10.dex */
public final class e {
    private final c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a extends f {
        final /* synthetic */ Map b;
        final /* synthetic */ Type c;

        a(Map map, Type type) {
            this.b = map;
            this.c = type;
        }

        @Override // com.google.common.reflect.f
        void b(Class<?> cls) {
            if (this.c instanceof WildcardType) {
                return;
            }
            throw new IllegalArgumentException("No type mapping from " + cls + " to " + this.c);
        }

        @Override // com.google.common.reflect.f
        void c(GenericArrayType genericArrayType) {
            Type type = this.c;
            if (type instanceof WildcardType) {
                return;
            }
            Type j = Types.j(type);
            du1.k(j != null, "%s is not an array type.", this.c);
            e.g(this.b, genericArrayType.getGenericComponentType(), j);
        }

        @Override // com.google.common.reflect.f
        void d(ParameterizedType parameterizedType) {
            Type type = this.c;
            if (type instanceof WildcardType) {
                return;
            }
            ParameterizedType parameterizedType2 = (ParameterizedType) e.e(ParameterizedType.class, type);
            if (parameterizedType.getOwnerType() != null && parameterizedType2.getOwnerType() != null) {
                e.g(this.b, parameterizedType.getOwnerType(), parameterizedType2.getOwnerType());
            }
            du1.l(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.c);
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
            du1.l(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
            for (int i = 0; i < actualTypeArguments.length; i++) {
                e.g(this.b, actualTypeArguments[i], actualTypeArguments2[i]);
            }
        }

        @Override // com.google.common.reflect.f
        void e(TypeVariable<?> typeVariable) {
            this.b.put(new d(typeVariable), this.c);
        }

        @Override // com.google.common.reflect.f
        void f(WildcardType wildcardType) {
            Type type = this.c;
            if (type instanceof WildcardType) {
                WildcardType wildcardType2 = (WildcardType) type;
                Type[] upperBounds = wildcardType.getUpperBounds();
                Type[] upperBounds2 = wildcardType2.getUpperBounds();
                Type[] lowerBounds = wildcardType.getLowerBounds();
                Type[] lowerBounds2 = wildcardType2.getLowerBounds();
                du1.l(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.c);
                for (int i = 0; i < upperBounds.length; i++) {
                    e.g(this.b, upperBounds[i], upperBounds2[i]);
                }
                for (int i2 = 0; i2 < lowerBounds.length; i2++) {
                    e.g(this.b, lowerBounds[i2], lowerBounds2[i2]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class b extends f {
        private final Map<d, Type> b = Maps.p();

        private b() {
        }

        static ImmutableMap<d, Type> g(Type type) {
            du1.p(type);
            b bVar = new b();
            bVar.a(type);
            return ImmutableMap.copyOf((Map) bVar.b);
        }

        private void h(d dVar, Type type) {
            if (this.b.containsKey(dVar)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (dVar.a(type2)) {
                    while (type != null) {
                        type = this.b.remove(d.c(type));
                    }
                    return;
                }
                type2 = this.b.get(d.c(type2));
            }
            this.b.put(dVar, type);
        }

        @Override // com.google.common.reflect.f
        void b(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.f
        void d(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            du1.w(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                h(new d(typeParameters[i]), actualTypeArguments[i]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.f
        void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.f
        void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class d {
        private final TypeVariable<?> a;

        d(TypeVariable<?> typeVariable) {
            this.a = (TypeVariable) du1.p(typeVariable);
        }

        private boolean b(TypeVariable<?> typeVariable) {
            return this.a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.a.getName().equals(typeVariable.getName());
        }

        static d c(Type type) {
            if (type instanceof TypeVariable) {
                return new d((TypeVariable) type);
            }
            return null;
        }

        boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return b((TypeVariable) type);
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return b(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return nm1.b(this.a.getGenericDeclaration(), this.a.getName());
        }

        public String toString() {
            return this.a.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.reflect.e$e  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0241e {
        static final C0241e b = new C0241e();
        private final AtomicInteger a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.reflect.e$e$a */
        /* loaded from: classes10.dex */
        public class a extends C0241e {
            final /* synthetic */ TypeVariable c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(C0241e c0241e, AtomicInteger atomicInteger, TypeVariable typeVariable) {
                super(atomicInteger, null);
                this.c = typeVariable;
            }

            @Override // com.google.common.reflect.e.C0241e
            TypeVariable<?> b(Type[] typeArr) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(typeArr));
                linkedHashSet.addAll(Arrays.asList(this.c.getBounds()));
                if (linkedHashSet.size() > 1) {
                    linkedHashSet.remove(Object.class);
                }
                return super.b((Type[]) linkedHashSet.toArray(new Type[0]));
            }
        }

        /* synthetic */ C0241e(AtomicInteger atomicInteger, a aVar) {
            this(atomicInteger);
        }

        private Type c(@NullableDecl Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        private C0241e d(TypeVariable<?> typeVariable) {
            return new a(this, this.a, typeVariable);
        }

        private C0241e e() {
            return new C0241e(this.a);
        }

        final Type a(Type type) {
            du1.p(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.k(e().a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Class cls = (Class) parameterizedType.getRawType();
                TypeVariable<?>[] typeParameters = cls.getTypeParameters();
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                for (int i = 0; i < actualTypeArguments.length; i++) {
                    actualTypeArguments[i] = d(typeParameters[i]).a(actualTypeArguments[i]);
                }
                return Types.n(e().c(parameterizedType.getOwnerType()), cls, actualTypeArguments);
            } else if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return wildcardType.getLowerBounds().length == 0 ? b(wildcardType.getUpperBounds()) : type;
            } else {
                throw new AssertionError("must have been one of the known types");
            }
        }

        TypeVariable<?> b(Type[] typeArr) {
            return Types.l(C0241e.class, "capture#" + this.a.incrementAndGet() + "-of ? extends " + com.google.common.base.d.f('&').e(typeArr), typeArr);
        }

        private C0241e() {
            this(new AtomicInteger());
        }

        private C0241e(AtomicInteger atomicInteger) {
            this.a = atomicInteger;
        }
    }

    /* synthetic */ e(c cVar, a aVar) {
        this(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e d(Type type) {
        return new e().o(b.g(type));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T e(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e f(Type type) {
        return new e().o(b.g(C0241e.b.a(type)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Map<d, Type> map, Type type, Type type2) {
        if (type.equals(type2)) {
            return;
        }
        new a(map, type2).a(type);
    }

    private Type h(GenericArrayType genericArrayType) {
        return Types.k(j(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType i(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return Types.n(ownerType == null ? null : j(ownerType), (Class) j(parameterizedType.getRawType()), k(parameterizedType.getActualTypeArguments()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Type[] k(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = j(typeArr[i]);
        }
        return typeArr2;
    }

    private WildcardType m(WildcardType wildcardType) {
        return new Types.WildcardTypeImpl(k(wildcardType.getLowerBounds()), k(wildcardType.getUpperBounds()));
    }

    public Type j(Type type) {
        du1.p(type);
        if (type instanceof TypeVariable) {
            return this.a.a((TypeVariable) type);
        }
        if (type instanceof ParameterizedType) {
            return i((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return h((GenericArrayType) type);
        }
        return type instanceof WildcardType ? m((WildcardType) type) : type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Type[] l(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = j(typeArr[i]);
        }
        return typeArr;
    }

    public e n(Type type, Type type2) {
        HashMap p = Maps.p();
        g(p, (Type) du1.p(type), (Type) du1.p(type2));
        return o(p);
    }

    e o(Map<d, ? extends Type> map) {
        return new e(this.a.c(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class c {
        private final ImmutableMap<d, Type> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes10.dex */
        public class a extends c {
            final /* synthetic */ TypeVariable b;
            final /* synthetic */ c c;

            a(c cVar, TypeVariable typeVariable, c cVar2) {
                this.b = typeVariable;
                this.c = cVar2;
            }

            @Override // com.google.common.reflect.e.c
            public Type b(TypeVariable<?> typeVariable, c cVar) {
                return typeVariable.getGenericDeclaration().equals(this.b.getGenericDeclaration()) ? typeVariable : this.c.b(typeVariable, cVar);
            }
        }

        c() {
            this.a = ImmutableMap.of();
        }

        final Type a(TypeVariable<?> typeVariable) {
            return b(typeVariable, new a(this, typeVariable, this));
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.reflect.GenericDeclaration] */
        Type b(TypeVariable<?> typeVariable, c cVar) {
            Type type = this.a.get(new d(typeVariable));
            if (type == null) {
                Type[] bounds = typeVariable.getBounds();
                if (bounds.length == 0) {
                    return typeVariable;
                }
                Type[] k = new e(cVar, null).k(bounds);
                return (Types.c.a && Arrays.equals(bounds, k)) ? typeVariable : Types.l(typeVariable.getGenericDeclaration(), typeVariable.getName(), k);
            }
            return new e(cVar, null).j(type);
        }

        final c c(Map<d, ? extends Type> map) {
            ImmutableMap.b builder = ImmutableMap.builder();
            builder.f(this.a);
            for (Map.Entry<d, ? extends Type> entry : map.entrySet()) {
                d key = entry.getKey();
                Type value = entry.getValue();
                du1.k(!key.a(value), "Type variable %s bound to itself", key);
                builder.c(key, value);
            }
            return new c(builder.a());
        }

        private c(ImmutableMap<d, Type> immutableMap) {
            this.a = immutableMap;
        }
    }

    public e() {
        this.a = new c();
    }

    private e(c cVar) {
        this.a = cVar;
    }
}
