package tb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.collections.C8214m;
import kotlin.collections.C8215n;
import kotlin.collections.C8225w;
import kotlin.collections.C8226x;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class kj implements KClass<Object>, ClassBasedDeclarationContainer {
    @NotNull
    public static final C9364a Companion = new C9364a(null);
    @NotNull
    private static final Map<Class<? extends Function<?>>, Integer> b;
    @NotNull
    private static final HashMap<String, String> c;
    @NotNull
    private static final HashMap<String, String> d;
    @NotNull
    private static final HashMap<String, String> e;
    @NotNull
    private static final Map<String, String> f;
    @NotNull
    private final Class<?> a;

    /* compiled from: Taobao */
    /* renamed from: tb.kj$a */
    /* loaded from: classes3.dex */
    public static final class C9364a {
        private C9364a() {
        }

        public /* synthetic */ C9364a(k50 k50Var) {
            this();
        }

        @Nullable
        public final String a(@NotNull Class<?> cls) {
            String str;
            b41.i(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str3 = (String) kj.e.get(cls.getName());
                return str3 == null ? cls.getCanonicalName() : str3;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (str = (String) kj.e.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 == null ? "kotlin.Array" : str2;
        }

        @Nullable
        public final String b(@NotNull Class<?> cls) {
            String str;
            Method enclosingMethod;
            Constructor<?> enclosingConstructor;
            String D0;
            String E0;
            String E02;
            b41.i(cls, "jClass");
            String str2 = null;
            if (!cls.isAnonymousClass()) {
                if (cls.isLocalClass()) {
                    String simpleName = cls.getSimpleName();
                    if (cls.getEnclosingMethod() != null) {
                        b41.h(simpleName, "name");
                        E02 = StringsKt__StringsKt.E0(simpleName, enclosingMethod.getName() + '$', null, 2, null);
                        if (E02 != null) {
                            return E02;
                        }
                    }
                    if (cls.getEnclosingConstructor() == null) {
                        b41.h(simpleName, "name");
                        D0 = StringsKt__StringsKt.D0(simpleName, '$', null, 2, null);
                        return D0;
                    }
                    b41.h(simpleName, "name");
                    E0 = StringsKt__StringsKt.E0(simpleName, enclosingConstructor.getName() + '$', null, 2, null);
                    return E0;
                } else if (!cls.isArray()) {
                    String str3 = (String) kj.f.get(cls.getName());
                    return str3 == null ? cls.getSimpleName() : str3;
                } else {
                    Class<?> componentType = cls.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) kj.f.get(componentType.getName())) != null) {
                        str2 = str + "Array";
                    }
                    if (str2 == null) {
                        return "Array";
                    }
                }
            }
            return str2;
        }

        public final boolean c(@Nullable Object obj, @NotNull Class<?> cls) {
            b41.i(cls, "jClass");
            Map map = kj.b;
            b41.g(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                return tq2.k(obj, num.intValue());
            }
            if (cls.isPrimitive()) {
                cls = s61.c(s61.e(cls));
            }
            return cls.isInstance(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List j;
        int q;
        Map<Class<? extends Function<?>>, Integer> r;
        int e2;
        String G0;
        String G02;
        int i = 0;
        j = C8214m.j(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        q = C8215n.q(j, 10);
        ArrayList arrayList = new ArrayList(q);
        for (Object obj : j) {
            int i2 = i + 1;
            if (i < 0) {
                C8214m.p();
            }
            arrayList.add(hq2.a((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        r = C8226x.r(arrayList);
        b = r;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        c = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        d = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        b41.h(values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            b41.h(str, "kotlinName");
            G02 = StringsKt__StringsKt.G0(str, '.', null, 2, null);
            sb.append(G02);
            sb.append("CompanionObject");
            Pair a = hq2.a(sb.toString(), str + ".Companion");
            hashMap3.put(a.getFirst(), a.getSecond());
        }
        for (Map.Entry<Class<? extends Function<?>>, Integer> entry : b.entrySet()) {
            int intValue = entry.getValue().intValue();
            hashMap3.put(entry.getKey().getName(), "kotlin.Function" + intValue);
        }
        e = hashMap3;
        e2 = C8225w.e(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(e2);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            G0 = StringsKt__StringsKt.G0((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, G0);
        }
        f = linkedHashMap;
    }

    public kj(@NotNull Class<?> cls) {
        b41.i(cls, "jClass");
        this.a = cls;
    }

    private final Void d() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof kj) && b41.d(s61.c(this), s61.c((KClass) obj));
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KFunction<Object>> getConstructors() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.internal.ClassBasedDeclarationContainer
    @NotNull
    public Class<?> getJClass() {
        return this.a;
    }

    @Override // kotlin.reflect.KClass, kotlin.reflect.KDeclarationContainer
    @NotNull
    public Collection<KCallable<?>> getMembers() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public Collection<KClass<?>> getNestedClasses() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public Object getObjectInstance() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getQualifiedName() {
        return Companion.a(getJClass());
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KClass<? extends Object>> getSealedSubclasses() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public String getSimpleName() {
        return Companion.b(getJClass());
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KType> getSupertypes() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @Nullable
    public KVisibility getVisibility() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return s61.c(this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    @SinceKotlin(version = "1.1")
    public boolean isInstance(@Nullable Object obj) {
        return Companion.c(obj, getJClass());
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        d();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        d();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
