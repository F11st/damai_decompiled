package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
import kotlin.collections.w;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.b90;
import tb.c02;
import tb.d42;
import tb.e70;
import tb.f70;
import tb.g42;
import tb.jn1;
import tb.k50;
import tb.ni1;
import tb.r10;
import tb.vp;
import tb.wt2;
import tb.x02;
import tb.yg1;
import tb.zv2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class KDeclarationContainerImpl implements ClassBasedDeclarationContainer {
    @NotNull
    public static final a Companion = new a(null);
    private static final Class<?> a = k50.class;
    @NotNull
    private static final Regex b = new Regex("<v#(\\d+)>");

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public abstract class Data {
        static final /* synthetic */ KProperty[] c = {a12.i(new PropertyReference1Impl(a12.b(Data.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        @NotNull
        private final x02.a a = x02.d(new Function0<d42>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$Data$moduleData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final d42 invoke() {
                return yg1.a(KDeclarationContainerImpl.this.getJClass());
            }
        });

        public Data() {
        }

        @NotNull
        public final d42 a() {
            return (d42) this.a.b(this, c[0]);
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "member", "", "accept", "<init>", "(Ljava/lang/String;I)V", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    protected enum MemberBelonginess {
        DECLARED,
        INHERITED;

        public final boolean accept(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
            b41.i(callableMemberDescriptor, "member");
            CallableMemberDescriptor.Kind kind = callableMemberDescriptor.getKind();
            b41.h(kind, "member.kind");
            return kind.isReal() == (this == DECLARED);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        @NotNull
        public final Regex a() {
            return KDeclarationContainerImpl.b;
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static final class b<T> implements Comparator {
        public static final b INSTANCE = new b();

        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public final int compare(f70 f70Var, f70 f70Var2) {
            Integer d = e70.d(f70Var, f70Var2);
            if (d != null) {
                return d.intValue();
            }
            return 0;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class c extends vp {
        c(KDeclarationContainerImpl kDeclarationContainerImpl, KDeclarationContainerImpl kDeclarationContainerImpl2) {
            super(kDeclarationContainerImpl2);
        }

        @Override // tb.v40, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
        @NotNull
        /* renamed from: e */
        public KCallableImpl<?> visitConstructorDescriptor(@NotNull ConstructorDescriptor constructorDescriptor, @NotNull wt2 wt2Var) {
            b41.i(constructorDescriptor, "descriptor");
            b41.i(wt2Var, "data");
            throw new IllegalStateException("No constructors should appear here: " + constructorDescriptor);
        }
    }

    private final void b(List<Class<?>> list, String str, boolean z) {
        List<Class<?>> o = o(str);
        list.addAll(o);
        int size = ((o.size() + 32) - 1) / 32;
        for (int i = 0; i < size; i++) {
            Class<?> cls = Integer.TYPE;
            b41.h(cls, "Integer.TYPE");
            list.add(cls);
        }
        Class cls2 = z ? a : Object.class;
        b41.h(cls2, "if (isConstructor) DEFAU…RKER else Any::class.java");
        list.add(cls2);
    }

    private final List<Class<?>> o(String str) {
        boolean J;
        int Y;
        int i;
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        while (str.charAt(i2) != ')') {
            int i3 = i2;
            while (str.charAt(i3) == '[') {
                i3++;
            }
            char charAt = str.charAt(i3);
            J = StringsKt__StringsKt.J("VZCBSIFJD", charAt, false, 2, null);
            if (J) {
                i = i3 + 1;
            } else if (charAt == 'L') {
                Y = StringsKt__StringsKt.Y(str, b90.TokenSEM, i2, false, 4, null);
                i = Y + 1;
            } else {
                throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
            }
            arrayList.add(r(str, i2, i));
            i2 = i;
        }
        return arrayList;
    }

    private final Class<?> p(String str) {
        int Y;
        Y = StringsKt__StringsKt.Y(str, ')', 0, false, 6, null);
        return r(str, Y + 1, str.length());
    }

    private final Method q(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z) {
        Class<?>[] interfaces;
        Method q;
        if (z) {
            clsArr[0] = cls;
        }
        Method t = t(cls, str, clsArr, cls2);
        if (t != null) {
            return t;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || (q = q(superclass, str, clsArr, cls2, z)) == null) {
            for (Class<?> cls3 : cls.getInterfaces()) {
                b41.h(cls3, "superInterface");
                Method q2 = q(cls3, str, clsArr, cls2, z);
                if (q2 != null) {
                    return q2;
                }
                if (z) {
                    Class<?> a2 = c02.a(ReflectClassUtilKt.f(cls3), cls3.getName() + "$DefaultImpls");
                    if (a2 != null) {
                        clsArr[0] = cls3;
                        Method t2 = t(a2, str, clsArr, cls2);
                        if (t2 != null) {
                            return t2;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return null;
        }
        return q;
    }

    private final Class<?> r(String str, int i, int i2) {
        String y;
        char charAt = str.charAt(i);
        if (charAt != 'F') {
            if (charAt == 'L') {
                ClassLoader f = ReflectClassUtilKt.f(getJClass());
                String substring = str.substring(i + 1, i2 - 1);
                b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                y = o.y(substring, r10.DIR, '.', false, 4, null);
                Class<?> loadClass = f.loadClass(y);
                b41.h(loadClass, "jClass.safeClassLoader.l…d - 1).replace('/', '.'))");
                return loadClass;
            } else if (charAt != 'S') {
                if (charAt == 'V') {
                    Class<?> cls = Void.TYPE;
                    b41.h(cls, "Void.TYPE");
                    return cls;
                } else if (charAt != 'I') {
                    if (charAt != 'J') {
                        if (charAt != 'Z') {
                            if (charAt != '[') {
                                switch (charAt) {
                                    case 'B':
                                        return Byte.TYPE;
                                    case 'C':
                                        return Character.TYPE;
                                    case 'D':
                                        return Double.TYPE;
                                    default:
                                        throw new KotlinReflectionInternalError("Unknown type prefix in the method signature: " + str);
                                }
                            }
                            return zv2.f(r(str, i + 1, i2));
                        }
                        return Boolean.TYPE;
                    }
                    return Long.TYPE;
                } else {
                    return Integer.TYPE;
                }
            } else {
                return Short.TYPE;
            }
        }
        return Float.TYPE;
    }

    private final Constructor<?> s(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array != null) {
                Class[] clsArr = (Class[]) array;
                return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[LOOP:0: B:7:0x0029->B:18:0x005a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.reflect.Method t(java.lang.Class<?> r7, java.lang.String r8, java.lang.Class<?>[] r9, java.lang.Class<?> r10) {
        /*
            r6 = this;
            r0 = 0
            int r1 = r9.length     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r9, r1)     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.Class[] r1 = (java.lang.Class[]) r1     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.reflect.Method r1 = r7.getDeclaredMethod(r8, r1)     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.String r2 = "result"
            tb.b41.h(r1, r2)     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.Class r2 = r1.getReturnType()     // Catch: java.lang.NoSuchMethodException -> L5d
            boolean r2 = tb.b41.d(r2, r10)     // Catch: java.lang.NoSuchMethodException -> L5d
            if (r2 == 0) goto L1d
            r0 = r1
            goto L5d
        L1d:
            java.lang.reflect.Method[] r7 = r7.getDeclaredMethods()     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.String r1 = "declaredMethods"
            tb.b41.h(r7, r1)     // Catch: java.lang.NoSuchMethodException -> L5d
            int r1 = r7.length     // Catch: java.lang.NoSuchMethodException -> L5d
            r2 = 0
            r3 = 0
        L29:
            if (r3 >= r1) goto L5d
            r4 = r7[r3]     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.String r5 = "method"
            tb.b41.h(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L5d
            java.lang.String r5 = r4.getName()     // Catch: java.lang.NoSuchMethodException -> L5d
            boolean r5 = tb.b41.d(r5, r8)     // Catch: java.lang.NoSuchMethodException -> L5d
            if (r5 == 0) goto L55
            java.lang.Class r5 = r4.getReturnType()     // Catch: java.lang.NoSuchMethodException -> L5d
            boolean r5 = tb.b41.d(r5, r10)     // Catch: java.lang.NoSuchMethodException -> L5d
            if (r5 == 0) goto L55
            java.lang.Class[] r5 = r4.getParameterTypes()     // Catch: java.lang.NoSuchMethodException -> L5d
            tb.b41.f(r5)     // Catch: java.lang.NoSuchMethodException -> L5d
            boolean r5 = java.util.Arrays.equals(r5, r9)     // Catch: java.lang.NoSuchMethodException -> L5d
            if (r5 == 0) goto L55
            r5 = 1
            goto L56
        L55:
            r5 = 0
        L56:
            if (r5 == 0) goto L5a
            r0 = r4
            goto L5d
        L5a:
            int r3 = r3 + 1
            goto L29
        L5d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.t(java.lang.Class, java.lang.String, java.lang.Class[], java.lang.Class):java.lang.reflect.Method");
    }

    @Nullable
    public final Constructor<?> c(@NotNull String str) {
        b41.i(str, SocialConstants.PARAM_APP_DESC);
        return s(getJClass(), o(str));
    }

    @Nullable
    public final Constructor<?> d(@NotNull String str) {
        b41.i(str, SocialConstants.PARAM_APP_DESC);
        Class<?> jClass = getJClass();
        ArrayList arrayList = new ArrayList();
        b(arrayList, str, true);
        wt2 wt2Var = wt2.INSTANCE;
        return s(jClass, arrayList);
    }

    @Nullable
    public final Method e(@NotNull String str, @NotNull String str2, boolean z) {
        b41.i(str, "name");
        b41.i(str2, SocialConstants.PARAM_APP_DESC);
        if (b41.d(str, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(getJClass());
        }
        b(arrayList, str2, false);
        Class<?> m = m();
        String str3 = str + "$default";
        Object[] array = arrayList.toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return q(m, str3, (Class[]) array, p(str2), z);
    }

    @NotNull
    public final FunctionDescriptor f(@NotNull String str, @NotNull String str2) {
        Collection<FunctionDescriptor> j;
        String Z;
        b41.i(str, "name");
        b41.i(str2, SocialOperation.GAME_SIGNATURE);
        if (b41.d(str, "<init>")) {
            j = CollectionsKt___CollectionsKt.A0(i());
        } else {
            ni1 f = ni1.f(str);
            b41.h(f, "Name.identifier(name)");
            j = j(f);
        }
        Collection<FunctionDescriptor> collection = j;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (b41.d(g42.INSTANCE.g((FunctionDescriptor) obj).a(), str2)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() != 1) {
            Z = CollectionsKt___CollectionsKt.Z(collection, StringUtils.LF, null, null, 0, null, new Function1<FunctionDescriptor, CharSequence>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull FunctionDescriptor functionDescriptor) {
                    b41.i(functionDescriptor, "descriptor");
                    return DescriptorRenderer.DEBUG_TEXT.a(functionDescriptor) + " | " + g42.INSTANCE.g(functionDescriptor).a();
                }
            }, 30, null);
            StringBuilder sb = new StringBuilder();
            sb.append("Function '");
            sb.append(str);
            sb.append("' (JVM signature: ");
            sb.append(str2);
            sb.append(") not resolved in ");
            sb.append(this);
            sb.append(jn1.CONDITION_IF_MIDDLE);
            sb.append(Z.length() == 0 ? " no members found" : '\n' + Z);
            throw new KotlinReflectionInternalError(sb.toString());
        }
        return (FunctionDescriptor) k.q0(arrayList);
    }

    @Nullable
    public final Method g(@NotNull String str, @NotNull String str2) {
        Method q;
        b41.i(str, "name");
        b41.i(str2, SocialConstants.PARAM_APP_DESC);
        if (b41.d(str, "<init>")) {
            return null;
        }
        Object[] array = o(str2).toArray(new Class[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Class<?>[] clsArr = (Class[]) array;
        Class<?> p = p(str2);
        Method q2 = q(m(), str, clsArr, p, false);
        if (q2 != null) {
            return q2;
        }
        if (!m().isInterface() || (q = q(Object.class, str, clsArr, p, false)) == null) {
            return null;
        }
        return q;
    }

    @NotNull
    public final PropertyDescriptor h(@NotNull String str, @NotNull String str2) {
        SortedMap h;
        String Z;
        b41.i(str, "name");
        b41.i(str2, SocialOperation.GAME_SIGNATURE);
        MatchResult matchEntire = b.matchEntire(str2);
        if (matchEntire != null) {
            String str3 = matchEntire.getDestructured().a().getGroupValues().get(1);
            PropertyDescriptor k = k(Integer.parseInt(str3));
            if (k != null) {
                return k;
            }
            throw new KotlinReflectionInternalError("Local property #" + str3 + " not found in " + getJClass());
        }
        ni1 f = ni1.f(str);
        b41.h(f, "Name.identifier(name)");
        Collection<PropertyDescriptor> n = n(f);
        ArrayList arrayList = new ArrayList();
        for (Object obj : n) {
            if (b41.d(g42.INSTANCE.f((PropertyDescriptor) obj).a(), str2)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            if (arrayList.size() != 1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj2 : arrayList) {
                    f70 visibility = ((PropertyDescriptor) obj2).getVisibility();
                    Object obj3 = linkedHashMap.get(visibility);
                    if (obj3 == null) {
                        obj3 = new ArrayList();
                        linkedHashMap.put(visibility, obj3);
                    }
                    ((List) obj3).add(obj2);
                }
                h = w.h(linkedHashMap, b.INSTANCE);
                Collection values = h.values();
                b41.h(values, "properties\n             …                }).values");
                List list = (List) k.a0(values);
                if (list.size() == 1) {
                    b41.h(list, "mostVisibleProperties");
                    return (PropertyDescriptor) k.P(list);
                }
                ni1 f2 = ni1.f(str);
                b41.h(f2, "Name.identifier(name)");
                Z = CollectionsKt___CollectionsKt.Z(n(f2), StringUtils.LF, null, null, 0, null, new Function1<PropertyDescriptor, CharSequence>() { // from class: kotlin.reflect.jvm.internal.KDeclarationContainerImpl$findPropertyDescriptor$allMembers$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final CharSequence invoke(@NotNull PropertyDescriptor propertyDescriptor) {
                        b41.i(propertyDescriptor, "descriptor");
                        return DescriptorRenderer.DEBUG_TEXT.a(propertyDescriptor) + " | " + g42.INSTANCE.f(propertyDescriptor).a();
                    }
                }, 30, null);
                StringBuilder sb = new StringBuilder();
                sb.append("Property '");
                sb.append(str);
                sb.append("' (JVM signature: ");
                sb.append(str2);
                sb.append(") not resolved in ");
                sb.append(this);
                sb.append(jn1.CONDITION_IF_MIDDLE);
                sb.append(Z.length() == 0 ? " no members found" : '\n' + Z);
                throw new KotlinReflectionInternalError(sb.toString());
            }
            return (PropertyDescriptor) k.q0(arrayList);
        }
        throw new KotlinReflectionInternalError("Property '" + str + "' (JVM signature: " + str2 + ") not resolved in " + this);
    }

    @NotNull
    public abstract Collection<ConstructorDescriptor> i();

    @NotNull
    public abstract Collection<FunctionDescriptor> j(@NotNull ni1 ni1Var);

    @Nullable
    public abstract PropertyDescriptor k(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x001e A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Collection<kotlin.reflect.jvm.internal.KCallableImpl<?>> l(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            tb.b41.i(r8, r0)
            java.lang.String r0 = "belonginess"
            tb.b41.i(r9, r0)
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl$c r0 = new kotlin.reflect.jvm.internal.KDeclarationContainerImpl$c
            r0.<init>(r7, r7)
            r1 = 0
            r2 = 3
            java.util.Collection r8 = kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.a.a(r8, r1, r1, r2, r1)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r8 = r8.iterator()
        L1e:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L55
            java.lang.Object r3 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor) r3
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r4 == 0) goto L4e
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4
            tb.f70 r5 = r4.getVisibility()
            tb.f70 r6 = tb.e70.INVISIBLE_FAKE
            boolean r5 = tb.b41.d(r5, r6)
            r5 = r5 ^ 1
            if (r5 == 0) goto L4e
            boolean r4 = r9.accept(r4)
            if (r4 == 0) goto L4e
            tb.wt2 r4 = tb.wt2.INSTANCE
            java.lang.Object r3 = r3.accept(r0, r4)
            kotlin.reflect.jvm.internal.KCallableImpl r3 = (kotlin.reflect.jvm.internal.KCallableImpl) r3
            goto L4f
        L4e:
            r3 = r1
        L4f:
            if (r3 == 0) goto L1e
            r2.add(r3)
            goto L1e
        L55:
            java.util.List r8 = kotlin.collections.k.A0(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.l(kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess):java.util.Collection");
    }

    @NotNull
    protected Class<?> m() {
        Class<?> g = ReflectClassUtilKt.g(getJClass());
        return g != null ? g : getJClass();
    }

    @NotNull
    public abstract Collection<PropertyDescriptor> n(@NotNull ni1 ni1Var);
}
