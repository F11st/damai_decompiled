package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.C4832d;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractC5196n;
import com.google.common.collect.AbstractC5207v;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.reflect.AbstractC5278b;
import com.google.common.reflect.Types;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.jn1;
import tb.lu1;
import tb.yt2;

/* compiled from: Taobao */
@Beta
/* loaded from: classes10.dex */
public abstract class TypeToken<T> extends AbstractC5281c<T> implements Serializable {
    private static final long serialVersionUID = 3637540370352322684L;
    @MonotonicNonNullDecl
    private transient C5283e covariantTypeResolver;
    @MonotonicNonNullDecl
    private transient C5283e invariantTypeResolver;
    private final Type runtimeType;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        @MonotonicNonNullDecl
        private transient ImmutableSet<TypeToken<? super T>> classes;

        private ClassSet() {
            super();
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) AbstractC5262f.b.a().c(TypeToken.this.getRawTypes()));
        }

        /* synthetic */ ClassSet(TypeToken typeToken, C5257a c5257a) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.AbstractC5207v, com.google.common.collect.AbstractC5200o, com.google.common.collect.AbstractC5205t
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.classes;
            if (immutableSet == null) {
                ImmutableSet<TypeToken<? super T>> f = AbstractC5196n.d(AbstractC5262f.a.a().d(TypeToken.this)).c(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).f();
                this.classes = f;
                return f;
            }
            return immutableSet;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type type) {
            super(type, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum TypeFilter implements Predicate<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD { // from class: com.google.common.reflect.TypeToken.TypeFilter.1
            @Override // com.google.common.base.Predicate
            public boolean apply(TypeToken<?> typeToken) {
                return ((((TypeToken) typeToken).runtimeType instanceof TypeVariable) || (((TypeToken) typeToken).runtimeType instanceof WildcardType)) ? false : true;
            }
        },
        INTERFACE_ONLY { // from class: com.google.common.reflect.TypeToken.TypeFilter.2
            @Override // com.google.common.base.Predicate
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        };

        /* synthetic */ TypeFilter(C5257a c5257a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.reflect.TypeToken$a */
    /* loaded from: classes10.dex */
    public class C5257a extends AbstractC5278b.C5280b<T> {
        C5257a(Method method) {
            super(method);
        }

        @Override // com.google.common.reflect.C5277a
        public TypeToken<T> a() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.C5277a
        public String toString() {
            return a() + "." + super.toString();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.reflect.TypeToken$b */
    /* loaded from: classes10.dex */
    class C5258b extends AbstractC5278b.C5279a<T> {
        C5258b(Constructor constructor) {
            super(constructor);
        }

        @Override // com.google.common.reflect.C5277a
        public TypeToken<T> a() {
            return TypeToken.this;
        }

        @Override // com.google.common.reflect.AbstractC5278b.C5279a
        Type[] b() {
            return TypeToken.this.getInvariantTypeResolver().l(super.b());
        }

        @Override // com.google.common.reflect.C5277a
        public String toString() {
            return a() + jn1.BRACKET_START_STR + C4832d.g(AVFSCacheConstants.COMMA_SEP).e(b()) + jn1.BRACKET_END_STR;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.reflect.TypeToken$c */
    /* loaded from: classes10.dex */
    class C5259c extends AbstractC5291f {
        C5259c() {
        }

        @Override // com.google.common.reflect.AbstractC5291f
        void c(GenericArrayType genericArrayType) {
            a(genericArrayType.getGenericComponentType());
        }

        @Override // com.google.common.reflect.AbstractC5291f
        void d(ParameterizedType parameterizedType) {
            a(parameterizedType.getActualTypeArguments());
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.AbstractC5291f
        void e(TypeVariable<?> typeVariable) {
            throw new IllegalArgumentException(TypeToken.this.runtimeType + "contains a type variable and is not safe for the operation");
        }

        @Override // com.google.common.reflect.AbstractC5291f
        void f(WildcardType wildcardType) {
            a(wildcardType.getLowerBounds());
            a(wildcardType.getUpperBounds());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.reflect.TypeToken$d */
    /* loaded from: classes10.dex */
    public class C5260d extends AbstractC5291f {
        final /* synthetic */ ImmutableSet.C4989a b;

        C5260d(TypeToken typeToken, ImmutableSet.C4989a c4989a) {
            this.b = c4989a;
        }

        @Override // com.google.common.reflect.AbstractC5291f
        void b(Class<?> cls) {
            this.b.a(cls);
        }

        @Override // com.google.common.reflect.AbstractC5291f
        void c(GenericArrayType genericArrayType) {
            this.b.a(Types.i(TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
        }

        @Override // com.google.common.reflect.AbstractC5291f
        void d(ParameterizedType parameterizedType) {
            this.b.a((Class) parameterizedType.getRawType());
        }

        @Override // com.google.common.reflect.AbstractC5291f
        void e(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.AbstractC5291f
        void f(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.reflect.TypeToken$e */
    /* loaded from: classes10.dex */
    public static class C5261e {
        private final Type[] a;
        private final boolean b;

        C5261e(Type[] typeArr, boolean z) {
            this.a = typeArr;
            this.b = z;
        }

        boolean a(Type type) {
            for (Type type2 : this.a) {
                boolean isSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                boolean z = this.b;
                if (isSubtypeOf == z) {
                    return z;
                }
            }
            return !this.b;
        }

        boolean b(Type type) {
            TypeToken<?> of = TypeToken.of(type);
            for (Type type2 : this.a) {
                boolean isSubtypeOf = of.isSubtypeOf(type2);
                boolean z = this.b;
                if (isSubtypeOf == z) {
                    return z;
                }
            }
            return !this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.reflect.TypeToken$f */
    /* loaded from: classes10.dex */
    public static abstract class AbstractC5262f<K> {
        static final AbstractC5262f<TypeToken<?>> a = new C5263a();
        static final AbstractC5262f<Class<?>> b = new C5264b();

        /* compiled from: Taobao */
        /* renamed from: com.google.common.reflect.TypeToken$f$a */
        /* loaded from: classes10.dex */
        static class C5263a extends AbstractC5262f<TypeToken<?>> {
            C5263a() {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.AbstractC5262f
            /* renamed from: i */
            public Iterable<? extends TypeToken<?>> e(TypeToken<?> typeToken) {
                return typeToken.getGenericInterfaces();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.AbstractC5262f
            /* renamed from: j */
            public Class<?> f(TypeToken<?> typeToken) {
                return typeToken.getRawType();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.AbstractC5262f
            @NullableDecl
            /* renamed from: k */
            public TypeToken<?> g(TypeToken<?> typeToken) {
                return typeToken.getGenericSuperclass();
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.google.common.reflect.TypeToken$f$b */
        /* loaded from: classes10.dex */
        static class C5264b extends AbstractC5262f<Class<?>> {
            C5264b() {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.AbstractC5262f
            /* renamed from: i */
            public Iterable<? extends Class<?>> e(Class<?> cls) {
                return Arrays.asList(cls.getInterfaces());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.AbstractC5262f
            /* renamed from: j */
            public Class<?> f(Class<?> cls) {
                return cls;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.TypeToken.AbstractC5262f
            @NullableDecl
            /* renamed from: k */
            public Class<?> g(Class<?> cls) {
                return cls.getSuperclass();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.reflect.TypeToken$f$c */
        /* loaded from: classes10.dex */
        public class C5265c extends C5267e<K> {
            C5265c(AbstractC5262f abstractC5262f, AbstractC5262f abstractC5262f2) {
                super(abstractC5262f2);
            }

            @Override // com.google.common.reflect.TypeToken.AbstractC5262f
            ImmutableList<K> c(Iterable<? extends K> iterable) {
                ImmutableList.C4971a builder = ImmutableList.builder();
                for (K k : iterable) {
                    if (!f(k).isInterface()) {
                        builder.a(k);
                    }
                }
                return super.c(builder.j());
            }

            @Override // com.google.common.reflect.TypeToken.AbstractC5262f
            Iterable<? extends K> e(K k) {
                return ImmutableSet.of();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.google.common.reflect.TypeToken$f$d */
        /* loaded from: classes10.dex */
        public static class C5266d extends Ordering<K> {
            final /* synthetic */ Comparator a;
            final /* synthetic */ Map b;

            C5266d(Comparator comparator, Map map) {
                this.a = comparator;
                this.b = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Ordering, java.util.Comparator
            public int compare(K k, K k2) {
                return this.a.compare(this.b.get(k), this.b.get(k2));
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.google.common.reflect.TypeToken$f$e */
        /* loaded from: classes10.dex */
        private static class C5267e<K> extends AbstractC5262f<K> {
            private final AbstractC5262f<K> c;

            C5267e(AbstractC5262f<K> abstractC5262f) {
                super(null);
                this.c = abstractC5262f;
            }

            @Override // com.google.common.reflect.TypeToken.AbstractC5262f
            Class<?> f(K k) {
                return this.c.f(k);
            }

            @Override // com.google.common.reflect.TypeToken.AbstractC5262f
            K g(K k) {
                return this.c.g(k);
            }
        }

        private AbstractC5262f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        private int b(K k, Map<? super K, Integer> map) {
            Integer num = map.get(k);
            if (num != null) {
                return num.intValue();
            }
            boolean isInterface = f(k).isInterface();
            int i = isInterface;
            for (K k2 : e(k)) {
                i = Math.max(i, b(k2, map));
            }
            K g = g(k);
            int i2 = i;
            if (g != null) {
                i2 = Math.max(i, b(g, map));
            }
            int i3 = i2 + 1;
            map.put(k, Integer.valueOf(i3));
            return i3;
        }

        private static <K, V> ImmutableList<K> h(Map<K, V> map, Comparator<? super V> comparator) {
            return (ImmutableList<K>) new C5266d(comparator, map).immutableSortedCopy(map.keySet());
        }

        final AbstractC5262f<K> a() {
            return new C5265c(this, this);
        }

        ImmutableList<K> c(Iterable<? extends K> iterable) {
            HashMap p = Maps.p();
            for (K k : iterable) {
                b(k, p);
            }
            return h(p, Ordering.natural().reverse());
        }

        final ImmutableList<K> d(K k) {
            return c(ImmutableList.of(k));
        }

        abstract Iterable<? extends K> e(K k);

        abstract Class<?> f(K k);

        @NullableDecl
        abstract K g(K k);

        /* synthetic */ AbstractC5262f(C5257a c5257a) {
            this();
        }
    }

    /* synthetic */ TypeToken(Type type, C5257a c5257a) {
        this(type);
    }

    private static C5261e any(Type[] typeArr) {
        return new C5261e(typeArr, true);
    }

    @NullableDecl
    private TypeToken<? super T> boundAsSuperclass(Type type) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] typeArr) {
        ImmutableList.C4971a builder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.getRawType().isInterface()) {
                builder.a(of);
            }
        }
        return builder.j();
    }

    private static Type canonicalizeTypeArg(TypeVariable<?> typeVariable, Type type) {
        if (type instanceof WildcardType) {
            return canonicalizeWildcardType(typeVariable, (WildcardType) type);
        }
        return canonicalizeWildcardsInType(type);
    }

    private static WildcardType canonicalizeWildcardType(TypeVariable<?> typeVariable, WildcardType wildcardType) {
        Type[] upperBounds;
        Type[] bounds = typeVariable.getBounds();
        ArrayList arrayList = new ArrayList();
        for (Type type : wildcardType.getUpperBounds()) {
            if (!any(bounds).a(type)) {
                arrayList.add(canonicalizeWildcardsInType(type));
            }
        }
        return new Types.WildcardTypeImpl(wildcardType.getLowerBounds(), (Type[]) arrayList.toArray(new Type[0]));
    }

    private static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType parameterizedType) {
        Class cls = (Class) parameterizedType.getRawType();
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            actualTypeArguments[i] = canonicalizeTypeArg(typeParameters[i], actualTypeArguments[i]);
        }
        return Types.n(parameterizedType.getOwnerType(), cls, actualTypeArguments);
    }

    private static Type canonicalizeWildcardsInType(Type type) {
        if (type instanceof ParameterizedType) {
            return canonicalizeWildcardsInParameterizedType((ParameterizedType) type);
        }
        return type instanceof GenericArrayType ? Types.k(canonicalizeWildcardsInType(((GenericArrayType) type).getGenericComponentType())) : type;
    }

    private static C5261e every(Type[] typeArr) {
        return new C5261e(typeArr, false);
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> cls) {
        return (TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(cls.getComponentType()).runtimeType));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> getArraySupertype(Class<? super T> cls) {
        return (TypeToken<? super T>) of(newArrayClassOrGenericArrayType(((TypeToken) du1.s(getComponentType(), "%s isn't a super type of %s", cls, this)).getSupertype(cls.getComponentType()).runtimeType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C5283e getCovariantTypeResolver() {
        C5283e c5283e = this.covariantTypeResolver;
        if (c5283e == null) {
            C5283e d = C5283e.d(this.runtimeType);
            this.covariantTypeResolver = d;
            return d;
        }
        return c5283e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C5283e getInvariantTypeResolver() {
        C5283e c5283e = this.invariantTypeResolver;
        if (c5283e == null) {
            C5283e f = C5283e.f(this.runtimeType);
            this.invariantTypeResolver = f;
            return f;
        }
        return c5283e;
    }

    @NullableDecl
    private Type getOwnerTypeIfPresent() {
        Type type = this.runtimeType;
        if (type instanceof ParameterizedType) {
            return ((ParameterizedType) type).getOwnerType();
        }
        if (type instanceof Class) {
            return ((Class) type).getEnclosingClass();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> getRawTypes() {
        ImmutableSet.C4989a builder = ImmutableSet.builder();
        new C5260d(this, builder).a(this.runtimeType);
        return builder.l();
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> of = of(type);
            if (of.isSubtypeOf(cls)) {
                return (TypeToken<? super T>) of.getSupertype(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    private boolean is(Type type, TypeVariable<?> typeVariable) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (type instanceof WildcardType) {
            WildcardType canonicalizeWildcardType = canonicalizeWildcardType(typeVariable, (WildcardType) type);
            return every(canonicalizeWildcardType.getUpperBounds()).b(this.runtimeType) && every(canonicalizeWildcardType.getLowerBounds()).a(this.runtimeType);
        }
        return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(type));
    }

    private boolean isOwnedBySubtypeOf(Type type) {
        Iterator<TypeToken<? super T>> it = getTypes().iterator();
        while (it.hasNext()) {
            Type ownerTypeIfPresent = it.next().getOwnerTypeIfPresent();
            if (ownerTypeIfPresent != null && of(ownerTypeIfPresent).isSubtypeOf(type)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubtypeOfArrayType(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                return of((Class) cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
            }
            return false;
        } else if (type instanceof GenericArrayType) {
            return of(((GenericArrayType) type).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType parameterizedType) {
        Class<? super Object> rawType = of(parameterizedType).getRawType();
        if (someRawTypeIsSubclassOf(rawType)) {
            TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (int i = 0; i < typeParameters.length; i++) {
                if (!of(getCovariantTypeResolver().j(typeParameters[i])).is(actualTypeArguments[i], typeParameters[i])) {
                    return false;
                }
            }
            return Modifier.isStatic(((Class) parameterizedType.getRawType()).getModifiers()) || parameterizedType.getOwnerType() == null || isOwnedBySubtypeOf(parameterizedType.getOwnerType());
        }
        return false;
    }

    private boolean isSupertypeOfArray(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return cls.isAssignableFrom(Object[].class);
            }
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        } else if (type instanceof GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean isWrapper() {
        return lu1.b().contains(this.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type type) {
        return Types.JavaVersion.JAVA7.newArrayType(type);
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    private TypeToken<?> resolveSupertype(Type type) {
        TypeToken<?> of = of(getCovariantTypeResolver().j(type));
        of.covariantTypeResolver = this.covariantTypeResolver;
        of.invariantTypeResolver = this.invariantTypeResolver;
        return of;
    }

    private Type resolveTypeArgsForSubclass(Class<?> cls) {
        if (!(this.runtimeType instanceof Class) || (cls.getTypeParameters().length != 0 && getRawType().getTypeParameters().length == 0)) {
            TypeToken genericType = toGenericType(cls);
            return new C5283e().n(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).j(genericType.runtimeType);
        }
        return cls;
    }

    private boolean someRawTypeIsSubclassOf(Class<?> cls) {
        yt2<Class<? super T>> it = getRawTypes().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(Types.k(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
        if (typeParameters.length <= 0 && (type == null || type == cls.getEnclosingClass())) {
            return of((Class) cls);
        }
        return (TypeToken<? extends T>) of(Types.n(type, cls, typeParameters));
    }

    public final AbstractC5278b<T, T> constructor(Constructor<?> constructor) {
        du1.l(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new C5258b(constructor);
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    @NullableDecl
    public final TypeToken<?> getComponentType() {
        Type j = Types.j(this.runtimeType);
        if (j == null) {
            return null;
        }
        return of(j);
    }

    final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.C4971a builder = ImmutableList.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            builder.a(resolveSupertype(type2));
        }
        return builder.j();
    }

    @NullableDecl
    final TypeToken<? super T> getGenericSuperclass() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundAsSuperclass(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return boundAsSuperclass(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (TypeToken<? super T>) resolveSupertype(genericSuperclass);
    }

    public final Class<? super T> getRawType() {
        return getRawTypes().iterator().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        du1.k(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return getSubtypeFromLowerBounds(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(cls);
        }
        du1.l(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        TypeToken<? extends T> typeToken = (TypeToken<? extends T>) of(resolveTypeArgsForSubclass(cls));
        du1.l(typeToken.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", typeToken, this);
        return typeToken;
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        du1.l(someRawTypeIsSubclassOf(cls), "%s is not a super class of %s", cls, this);
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return getSupertypeFromUpperBounds(cls, ((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return getSupertypeFromUpperBounds(cls, ((WildcardType) type).getUpperBounds());
        }
        if (cls.isArray()) {
            return getArraySupertype(cls);
        }
        return (TypeToken<? super T>) resolveSupertype(toGenericType(cls).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        Type type = this.runtimeType;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    public final AbstractC5278b<T, Object> method(Method method) {
        du1.l(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new C5257a(method);
    }

    @CanIgnoreReturnValue
    final TypeToken<T> rejectTypeVariables() {
        new C5259c().a(this.runtimeType);
        return this;
    }

    public final TypeToken<?> resolveType(Type type) {
        du1.p(type);
        return of(getInvariantTypeResolver().j(type));
    }

    public String toString() {
        return Types.t(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        return isWrapper() ? of(lu1.c((Class) this.runtimeType)) : this;
    }

    public final <X> TypeToken<T> where(AbstractC5282d<X> abstractC5282d, TypeToken<X> typeToken) {
        new C5283e();
        throw null;
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? of(lu1.d((Class) this.runtimeType)) : this;
    }

    protected Object writeReplace() {
        return of(new C5283e().j(this.runtimeType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private final transient TypeToken<T>.TypeSet allTypes;
        @MonotonicNonNullDecl
        private transient ImmutableSet<TypeToken<? super T>> interfaces;

        /* compiled from: Taobao */
        /* renamed from: com.google.common.reflect.TypeToken$InterfaceSet$a */
        /* loaded from: classes10.dex */
        class C5256a implements Predicate<Class<?>> {
            C5256a(InterfaceSet interfaceSet) {
            }

            @Override // com.google.common.base.Predicate
            /* renamed from: a */
            public boolean apply(Class<?> cls) {
                return cls.isInterface();
            }
        }

        InterfaceSet(TypeToken<T>.TypeSet typeSet) {
            super();
            this.allTypes = typeSet;
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return AbstractC5196n.d(AbstractC5262f.b.c(TypeToken.this.getRawTypes())).c(new C5256a(this)).f();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.AbstractC5207v, com.google.common.collect.AbstractC5200o, com.google.common.collect.AbstractC5205t
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.interfaces;
            if (immutableSet == null) {
                ImmutableSet<TypeToken<? super T>> f = AbstractC5196n.d(this.allTypes).c(TypeFilter.INTERFACE_ONLY).f();
                this.interfaces = f;
                return f;
            }
            return immutableSet;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class TypeSet extends AbstractC5207v<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        @MonotonicNonNullDecl
        private transient ImmutableSet<TypeToken<? super T>> types;

        TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(TypeToken.this, null);
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) AbstractC5262f.b.c(TypeToken.this.getRawTypes()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractC5207v, com.google.common.collect.AbstractC5200o, com.google.common.collect.AbstractC5205t
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
            if (immutableSet == null) {
                ImmutableSet<TypeToken<? super T>> f = AbstractC5196n.d(AbstractC5262f.a.d(TypeToken.this)).c(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).f();
                this.types = f;
                return f;
            }
            return immutableSet;
        }
    }

    protected TypeToken() {
        Type capture = capture();
        this.runtimeType = capture;
        du1.A(!(capture instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", capture);
    }

    public static TypeToken<?> of(Type type) {
        return new SimpleTypeToken(type);
    }

    public final boolean isSubtypeOf(Type type) {
        du1.p(type);
        if (type instanceof WildcardType) {
            return any(((WildcardType) type).getLowerBounds()).b(this.runtimeType);
        }
        Type type2 = this.runtimeType;
        if (type2 instanceof WildcardType) {
            return any(((WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof TypeVariable) {
            return type2.equals(type) || any(((TypeVariable) this.runtimeType).getBounds()).a(type);
        } else if (type2 instanceof GenericArrayType) {
            return of(type).isSupertypeOfArray((GenericArrayType) this.runtimeType);
        } else {
            if (type instanceof Class) {
                return someRawTypeIsSubclassOf((Class) type);
            }
            if (type instanceof ParameterizedType) {
                return isSubtypeOfParameterizedType((ParameterizedType) type);
            }
            if (type instanceof GenericArrayType) {
                return isSubtypeOfArrayType((GenericArrayType) type);
            }
            return false;
        }
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public final <X> TypeToken<T> where(AbstractC5282d<X> abstractC5282d, Class<X> cls) {
        return where(abstractC5282d, of((Class) cls));
    }

    protected TypeToken(Class<?> cls) {
        Type capture = super.capture();
        if (capture instanceof Class) {
            this.runtimeType = capture;
        } else {
            this.runtimeType = C5283e.d(cls).j(capture);
        }
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) du1.p(type);
    }
}
