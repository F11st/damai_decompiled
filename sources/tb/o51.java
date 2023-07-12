package tb;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class o51 {
    @NotNull
    public static final o51 INSTANCE;
    @NotNull
    private static final String a;
    @NotNull
    private static final String b;
    @NotNull
    private static final String c;
    @NotNull
    private static final String d;
    @NotNull
    private static final hj e;
    @NotNull
    private static final hp0 f;
    @NotNull
    private static final hj g;
    @NotNull
    private static final HashMap<ip0, hj> h;
    @NotNull
    private static final HashMap<ip0, hj> i;
    @NotNull
    private static final HashMap<ip0, hp0> j;
    @NotNull
    private static final HashMap<ip0, hp0> k;
    @NotNull
    private static final List<a> l;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        @NotNull
        private final hj a;
        @NotNull
        private final hj b;
        @NotNull
        private final hj c;

        public a(@NotNull hj hjVar, @NotNull hj hjVar2, @NotNull hj hjVar3) {
            b41.i(hjVar, "javaClass");
            b41.i(hjVar2, "kotlinReadOnly");
            b41.i(hjVar3, "kotlinMutable");
            this.a = hjVar;
            this.b = hjVar2;
            this.c = hjVar3;
        }

        @NotNull
        public final hj a() {
            return this.a;
        }

        @NotNull
        public final hj b() {
            return this.b;
        }

        @NotNull
        public final hj c() {
            return this.c;
        }

        @NotNull
        public final hj d() {
            return this.a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return b41.d(this.a, aVar.a) && b41.d(this.b, aVar.b) && b41.d(this.c, aVar.c);
            }
            return false;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        @NotNull
        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.a + ", kotlinReadOnly=" + this.b + ", kotlinMutable=" + this.c + ')';
        }
    }

    static {
        List<a> j2;
        o51 o51Var = new o51();
        INSTANCE = o51Var;
        StringBuilder sb = new StringBuilder();
        FunctionClassKind functionClassKind = FunctionClassKind.Function;
        sb.append(functionClassKind.getPackageFqName().toString());
        sb.append('.');
        sb.append(functionClassKind.getClassNamePrefix());
        a = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        FunctionClassKind functionClassKind2 = FunctionClassKind.KFunction;
        sb2.append(functionClassKind2.getPackageFqName().toString());
        sb2.append('.');
        sb2.append(functionClassKind2.getClassNamePrefix());
        b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        FunctionClassKind functionClassKind3 = FunctionClassKind.SuspendFunction;
        sb3.append(functionClassKind3.getPackageFqName().toString());
        sb3.append('.');
        sb3.append(functionClassKind3.getClassNamePrefix());
        c = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        FunctionClassKind functionClassKind4 = FunctionClassKind.KSuspendFunction;
        sb4.append(functionClassKind4.getPackageFqName().toString());
        sb4.append('.');
        sb4.append(functionClassKind4.getClassNamePrefix());
        d = sb4.toString();
        hj m = hj.m(new hp0("kotlin.jvm.functions.FunctionN"));
        b41.h(m, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        e = m;
        hp0 b2 = m.b();
        b41.h(b2, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        f = b2;
        hj m2 = hj.m(new hp0("kotlin.reflect.KFunction"));
        b41.h(m2, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        g = m2;
        b41.h(hj.m(new hp0("kotlin.reflect.KClass")), "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        o51Var.h(Class.class);
        h = new HashMap<>();
        i = new HashMap<>();
        j = new HashMap<>();
        k = new HashMap<>();
        hj m3 = hj.m(c.a.iterable);
        b41.h(m3, "topLevel(FqNames.iterable)");
        hp0 hp0Var = c.a.mutableIterable;
        hp0 h2 = m3.h();
        hp0 h3 = m3.h();
        b41.h(h3, "kotlinReadOnly.packageFqName");
        hp0 g2 = kotlin.reflect.jvm.internal.impl.name.a.g(hp0Var, h3);
        int i2 = 0;
        hj hjVar = new hj(h2, g2, false);
        hj m4 = hj.m(c.a.iterator);
        b41.h(m4, "topLevel(FqNames.iterator)");
        hp0 hp0Var2 = c.a.mutableIterator;
        hp0 h4 = m4.h();
        hp0 h5 = m4.h();
        b41.h(h5, "kotlinReadOnly.packageFqName");
        hj hjVar2 = new hj(h4, kotlin.reflect.jvm.internal.impl.name.a.g(hp0Var2, h5), false);
        hj m5 = hj.m(c.a.collection);
        b41.h(m5, "topLevel(FqNames.collection)");
        hp0 hp0Var3 = c.a.mutableCollection;
        hp0 h6 = m5.h();
        hp0 h7 = m5.h();
        b41.h(h7, "kotlinReadOnly.packageFqName");
        hj hjVar3 = new hj(h6, kotlin.reflect.jvm.internal.impl.name.a.g(hp0Var3, h7), false);
        hj m6 = hj.m(c.a.list);
        b41.h(m6, "topLevel(FqNames.list)");
        hp0 hp0Var4 = c.a.mutableList;
        hp0 h8 = m6.h();
        hp0 h9 = m6.h();
        b41.h(h9, "kotlinReadOnly.packageFqName");
        hj hjVar4 = new hj(h8, kotlin.reflect.jvm.internal.impl.name.a.g(hp0Var4, h9), false);
        hj m7 = hj.m(c.a.set);
        b41.h(m7, "topLevel(FqNames.set)");
        hp0 hp0Var5 = c.a.mutableSet;
        hp0 h10 = m7.h();
        hp0 h11 = m7.h();
        b41.h(h11, "kotlinReadOnly.packageFqName");
        hj hjVar5 = new hj(h10, kotlin.reflect.jvm.internal.impl.name.a.g(hp0Var5, h11), false);
        hj m8 = hj.m(c.a.listIterator);
        b41.h(m8, "topLevel(FqNames.listIterator)");
        hp0 hp0Var6 = c.a.mutableListIterator;
        hp0 h12 = m8.h();
        hp0 h13 = m8.h();
        b41.h(h13, "kotlinReadOnly.packageFqName");
        hj hjVar6 = new hj(h12, kotlin.reflect.jvm.internal.impl.name.a.g(hp0Var6, h13), false);
        hp0 hp0Var7 = c.a.map;
        hj m9 = hj.m(hp0Var7);
        b41.h(m9, "topLevel(FqNames.map)");
        hp0 hp0Var8 = c.a.mutableMap;
        hp0 h14 = m9.h();
        hp0 h15 = m9.h();
        b41.h(h15, "kotlinReadOnly.packageFqName");
        hj hjVar7 = new hj(h14, kotlin.reflect.jvm.internal.impl.name.a.g(hp0Var8, h15), false);
        hj d2 = hj.m(hp0Var7).d(c.a.mapEntry.g());
        b41.h(d2, "topLevel(FqNames.map).cr…mes.mapEntry.shortName())");
        hp0 hp0Var9 = c.a.mutableMapEntry;
        hp0 h16 = d2.h();
        hp0 h17 = d2.h();
        b41.h(h17, "kotlinReadOnly.packageFqName");
        j2 = kotlin.collections.m.j(new a(o51Var.h(Iterable.class), m3, hjVar), new a(o51Var.h(Iterator.class), m4, hjVar2), new a(o51Var.h(Collection.class), m5, hjVar3), new a(o51Var.h(List.class), m6, hjVar4), new a(o51Var.h(Set.class), m7, hjVar5), new a(o51Var.h(ListIterator.class), m8, hjVar6), new a(o51Var.h(Map.class), m9, hjVar7), new a(o51Var.h(Map.Entry.class), d2, new hj(h16, kotlin.reflect.jvm.internal.impl.name.a.g(hp0Var9, h17), false)));
        l = j2;
        o51Var.g(Object.class, c.a.any);
        o51Var.g(String.class, c.a.string);
        o51Var.g(CharSequence.class, c.a.charSequence);
        o51Var.f(Throwable.class, c.a.throwable);
        o51Var.g(Cloneable.class, c.a.cloneable);
        o51Var.g(Number.class, c.a.number);
        o51Var.f(Comparable.class, c.a.comparable);
        o51Var.g(Enum.class, c.a._enum);
        o51Var.f(Annotation.class, c.a.annotation);
        for (a aVar : j2) {
            INSTANCE.e(aVar);
        }
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i3 = 0;
        while (i3 < length) {
            JvmPrimitiveType jvmPrimitiveType = values[i3];
            i3++;
            o51 o51Var2 = INSTANCE;
            hj m10 = hj.m(jvmPrimitiveType.getWrapperFqName());
            b41.h(m10, "topLevel(jvmType.wrapperFqName)");
            PrimitiveType primitiveType = jvmPrimitiveType.getPrimitiveType();
            b41.h(primitiveType, "jvmType.primitiveType");
            hj m11 = hj.m(kotlin.reflect.jvm.internal.impl.builtins.c.c(primitiveType));
            b41.h(m11, "topLevel(StandardNames.g…e(jvmType.primitiveType))");
            o51Var2.b(m10, m11);
        }
        for (hj hjVar8 : ql.INSTANCE.a()) {
            o51 o51Var3 = INSTANCE;
            hj m12 = hj.m(new hp0("kotlin.jvm.internal." + hjVar8.j().b() + "CompanionObject"));
            b41.h(m12, "topLevel(FqName(\"kotlin.…g() + \"CompanionObject\"))");
            hj d3 = hjVar8.d(af2.DEFAULT_NAME_FOR_COMPANION_OBJECT);
            b41.h(d3, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
            o51Var3.b(m12, d3);
        }
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            o51 o51Var4 = INSTANCE;
            hj m13 = hj.m(new hp0(b41.r("kotlin.jvm.functions.Function", Integer.valueOf(i4))));
            b41.h(m13, "topLevel(FqName(\"kotlin.…m.functions.Function$i\"))");
            o51Var4.b(m13, kotlin.reflect.jvm.internal.impl.builtins.c.a(i4));
            o51Var4.d(new hp0(b41.r(b, Integer.valueOf(i4))), g);
            if (i5 >= 23) {
                break;
            }
            i4 = i5;
        }
        while (true) {
            int i6 = i2 + 1;
            FunctionClassKind functionClassKind5 = FunctionClassKind.KSuspendFunction;
            o51 o51Var5 = INSTANCE;
            o51Var5.d(new hp0(b41.r(functionClassKind5.getPackageFqName().toString() + '.' + functionClassKind5.getClassNamePrefix(), Integer.valueOf(i2))), g);
            if (i6 >= 22) {
                hp0 l2 = c.a.nothing.l();
                b41.h(l2, "nothing.toSafe()");
                o51Var5.d(l2, o51Var5.h(Void.class));
                return;
            }
            i2 = i6;
        }
    }

    private o51() {
    }

    private final void b(hj hjVar, hj hjVar2) {
        c(hjVar, hjVar2);
        hp0 b2 = hjVar2.b();
        b41.h(b2, "kotlinClassId.asSingleFqName()");
        d(b2, hjVar);
    }

    private final void c(hj hjVar, hj hjVar2) {
        HashMap<ip0, hj> hashMap = h;
        ip0 j2 = hjVar.b().j();
        b41.h(j2, "javaClassId.asSingleFqName().toUnsafe()");
        hashMap.put(j2, hjVar2);
    }

    private final void d(hp0 hp0Var, hj hjVar) {
        HashMap<ip0, hj> hashMap = i;
        ip0 j2 = hp0Var.j();
        b41.h(j2, "kotlinFqNameUnsafe.toUnsafe()");
        hashMap.put(j2, hjVar);
    }

    private final void e(a aVar) {
        hj a2 = aVar.a();
        hj b2 = aVar.b();
        hj c2 = aVar.c();
        b(a2, b2);
        hp0 b3 = c2.b();
        b41.h(b3, "mutableClassId.asSingleFqName()");
        d(b3, a2);
        hp0 b4 = b2.b();
        b41.h(b4, "readOnlyClassId.asSingleFqName()");
        hp0 b5 = c2.b();
        b41.h(b5, "mutableClassId.asSingleFqName()");
        HashMap<ip0, hp0> hashMap = j;
        ip0 j2 = c2.b().j();
        b41.h(j2, "mutableClassId.asSingleFqName().toUnsafe()");
        hashMap.put(j2, b4);
        HashMap<ip0, hp0> hashMap2 = k;
        ip0 j3 = b4.j();
        b41.h(j3, "readOnlyFqName.toUnsafe()");
        hashMap2.put(j3, b5);
    }

    private final void f(Class<?> cls, hp0 hp0Var) {
        hj h2 = h(cls);
        hj m = hj.m(hp0Var);
        b41.h(m, "topLevel(kotlinFqName)");
        b(h2, m);
    }

    private final void g(Class<?> cls, ip0 ip0Var) {
        hp0 l2 = ip0Var.l();
        b41.h(l2, "kotlinFqName.toSafe()");
        f(cls, l2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final hj h(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            hj m = hj.m(new hp0(cls.getCanonicalName()));
            b41.h(m, "topLevel(FqName(clazz.canonicalName))");
            return m;
        }
        hj d2 = h(declaringClass).d(ni1.f(cls.getSimpleName()));
        b41.h(d2, "classId(outer).createNes…tifier(clazz.simpleName))");
        return d2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
        r5 = kotlin.text.n.i(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean k(tb.ip0 r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r5 = r5.b()
            java.lang.String r0 = "kotlinFqName.asString()"
            tb.b41.h(r5, r0)
            java.lang.String r0 = ""
            java.lang.String r5 = kotlin.text.g.C0(r5, r6, r0)
            int r6 = r5.length()
            r0 = 1
            r1 = 0
            if (r6 <= 0) goto L19
            r6 = 1
            goto L1a
        L19:
            r6 = 0
        L1a:
            if (r6 == 0) goto L37
            r6 = 48
            r2 = 2
            r3 = 0
            boolean r6 = kotlin.text.g.y0(r5, r6, r1, r2, r3)
            if (r6 != 0) goto L37
            java.lang.Integer r5 = kotlin.text.g.i(r5)
            if (r5 == 0) goto L35
            int r5 = r5.intValue()
            r6 = 23
            if (r5 < r6) goto L35
            goto L36
        L35:
            r0 = 0
        L36:
            return r0
        L37:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.o51.k(tb.ip0, java.lang.String):boolean");
    }

    @NotNull
    public final hp0 i() {
        return f;
    }

    @NotNull
    public final List<a> j() {
        return l;
    }

    public final boolean l(@Nullable ip0 ip0Var) {
        HashMap<ip0, hp0> hashMap = j;
        Objects.requireNonNull(hashMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return hashMap.containsKey(ip0Var);
    }

    public final boolean m(@Nullable ip0 ip0Var) {
        HashMap<ip0, hp0> hashMap = k;
        Objects.requireNonNull(hashMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return hashMap.containsKey(ip0Var);
    }

    @Nullable
    public final hj n(@NotNull hp0 hp0Var) {
        b41.i(hp0Var, "fqName");
        return h.get(hp0Var.j());
    }

    @Nullable
    public final hj o(@NotNull ip0 ip0Var) {
        b41.i(ip0Var, "kotlinFqName");
        if (!k(ip0Var, a) && !k(ip0Var, c)) {
            if (!k(ip0Var, b) && !k(ip0Var, d)) {
                return i.get(ip0Var);
            }
            return g;
        }
        return e;
    }

    @Nullable
    public final hp0 p(@Nullable ip0 ip0Var) {
        return j.get(ip0Var);
    }

    @Nullable
    public final hp0 q(@Nullable ip0 ip0Var) {
        return k.get(ip0Var);
    }
}
