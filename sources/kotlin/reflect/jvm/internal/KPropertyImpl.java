package kotlin.reflect.jvm.internal;

import com.tencent.open.SocialOperation;
import java.lang.reflect.Field;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.a71;
import tb.b41;
import tb.b71;
import tb.g42;
import tb.g70;
import tb.k50;
import tb.n21;
import tb.w61;
import tb.wt2;
import tb.x02;
import tb.x60;
import tb.zv2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class KPropertyImpl<V> extends KCallableImpl<V> implements KProperty<V> {
    @NotNull
    public static final C8262b Companion = new C8262b(null);
    @NotNull
    private static final Object k = new Object();
    private final x02.C9895b<Field> e;
    private final x02.C9894a<PropertyDescriptor> f;
    @NotNull
    private final KDeclarationContainerImpl g;
    @NotNull
    private final String h;
    @NotNull
    private final String i;
    private final Object j;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static abstract class Getter<V> extends AbstractC8261a<V, V> implements KProperty.Getter<V> {
        static final /* synthetic */ KProperty[] g = {a12.i(new PropertyReference1Impl(a12.b(Getter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), a12.i(new PropertyReference1Impl(a12.b(Getter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        @NotNull
        private final x02.C9894a e = x02.d(new Function0<PropertyGetterDescriptor>() { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Getter$descriptor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PropertyGetterDescriptor invoke() {
                PropertyGetterDescriptor getter = KPropertyImpl.Getter.this.m().i().getGetter();
                return getter != null ? getter : x60.b(KPropertyImpl.Getter.this.m().i(), Annotations.Companion.b());
            }
        });
        @NotNull
        private final x02.C9895b f = x02.b(new Function0<Caller<?>>() { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Getter$caller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Caller<?> invoke() {
                return KPropertyImplKt.a(KPropertyImpl.Getter.this, true);
            }
        });

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Getter) && b41.d(m(), ((Getter) obj).m());
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public Caller<?> f() {
            return (Caller) this.f.b(this, g[1]);
        }

        @Override // kotlin.reflect.KCallable
        @NotNull
        public String getName() {
            return "<get-" + m().getName() + '>';
        }

        public int hashCode() {
            return m().hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.AbstractC8261a
        @NotNull
        /* renamed from: n */
        public PropertyGetterDescriptor l() {
            return (PropertyGetterDescriptor) this.e.b(this, g[0]);
        }

        @NotNull
        public String toString() {
            return "getter of " + m();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static abstract class Setter<V> extends AbstractC8261a<V, wt2> implements KMutableProperty.Setter<V> {
        static final /* synthetic */ KProperty[] g = {a12.i(new PropertyReference1Impl(a12.b(Setter.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), a12.i(new PropertyReference1Impl(a12.b(Setter.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        @NotNull
        private final x02.C9894a e = x02.d(new Function0<PropertySetterDescriptor>() { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Setter$descriptor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PropertySetterDescriptor invoke() {
                PropertySetterDescriptor setter = KPropertyImpl.Setter.this.m().i().getSetter();
                if (setter != null) {
                    return setter;
                }
                PropertyDescriptor i = KPropertyImpl.Setter.this.m().i();
                Annotations.C8302a c8302a = Annotations.Companion;
                return x60.c(i, c8302a.b(), c8302a.b());
            }
        });
        @NotNull
        private final x02.C9895b f = x02.b(new Function0<Caller<?>>() { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$Setter$caller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Caller<?> invoke() {
                return KPropertyImplKt.a(KPropertyImpl.Setter.this, false);
            }
        });

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof Setter) && b41.d(m(), ((Setter) obj).m());
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public Caller<?> f() {
            return (Caller) this.f.b(this, g[1]);
        }

        @Override // kotlin.reflect.KCallable
        @NotNull
        public String getName() {
            return "<set-" + m().getName() + '>';
        }

        public int hashCode() {
            return m().hashCode();
        }

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.AbstractC8261a
        @NotNull
        /* renamed from: n */
        public PropertySetterDescriptor l() {
            return (PropertySetterDescriptor) this.e.b(this, g[0]);
        }

        @NotNull
        public String toString() {
            return "setter of " + m();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.KPropertyImpl$a */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC8261a<PropertyType, ReturnType> extends KCallableImpl<ReturnType> implements KFunction<ReturnType>, KProperty.Accessor<PropertyType> {
        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @NotNull
        public KDeclarationContainerImpl g() {
            return m().g();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        @Nullable
        public Caller<?> h() {
            return null;
        }

        @Override // kotlin.reflect.KFunction
        public boolean isExternal() {
            return l().isExternal();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInfix() {
            return l().isInfix();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isInline() {
            return l().isInline();
        }

        @Override // kotlin.reflect.KFunction
        public boolean isOperator() {
            return l().isOperator();
        }

        @Override // kotlin.reflect.KCallable
        public boolean isSuspend() {
            return l().isSuspend();
        }

        @Override // kotlin.reflect.jvm.internal.KCallableImpl
        public boolean k() {
            return m().k();
        }

        @NotNull
        public abstract PropertyAccessorDescriptor l();

        @NotNull
        public abstract KPropertyImpl<PropertyType> m();
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.KPropertyImpl$b */
    /* loaded from: classes3.dex */
    public static final class C8262b {
        private C8262b() {
        }

        public /* synthetic */ C8262b(k50 k50Var) {
            this();
        }
    }

    private KPropertyImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, PropertyDescriptor propertyDescriptor, Object obj) {
        this.g = kDeclarationContainerImpl;
        this.h = str;
        this.i = str2;
        this.j = obj;
        x02.C9895b<Field> b = x02.b(new Function0<Field>() { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$_javaField$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Field invoke() {
                Class<?> enclosingClass;
                a71 f = g42.INSTANCE.f(KPropertyImpl.this.i());
                if (f instanceof a71.C8900c) {
                    a71.C8900c c8900c = (a71.C8900c) f;
                    PropertyDescriptor b2 = c8900c.b();
                    w61.C9845a d = b71.d(b71.INSTANCE, c8900c.e(), c8900c.d(), c8900c.g(), false, 8, null);
                    if (d != null) {
                        if (!g70.e(b2) && !b71.f(c8900c.e())) {
                            DeclarationDescriptor containingDeclaration = b2.getContainingDeclaration();
                            enclosingClass = containingDeclaration instanceof ClassDescriptor ? zv2.p((ClassDescriptor) containingDeclaration) : KPropertyImpl.this.g().getJClass();
                        } else {
                            enclosingClass = KPropertyImpl.this.g().getJClass().getEnclosingClass();
                        }
                        if (enclosingClass != null) {
                            try {
                                return enclosingClass.getDeclaredField(d.c());
                            } catch (NoSuchFieldException unused) {
                                return null;
                            }
                        }
                        return null;
                    }
                    return null;
                } else if (f instanceof a71.C8898a) {
                    return ((a71.C8898a) f).b();
                } else {
                    if ((f instanceof a71.C8899b) || (f instanceof a71.C8901d)) {
                        return null;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }
        });
        b41.h(b, "ReflectProperties.lazy {…y -> null\n        }\n    }");
        this.e = b;
        x02.C9894a<PropertyDescriptor> c = x02.c(propertyDescriptor, new Function0<PropertyDescriptor>() { // from class: kotlin.reflect.jvm.internal.KPropertyImpl$_descriptor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final PropertyDescriptor invoke() {
                return KPropertyImpl.this.g().h(KPropertyImpl.this.getName(), KPropertyImpl.this.r());
            }
        });
        b41.h(c, "ReflectProperties.lazySo…or(name, signature)\n    }");
        this.f = c;
    }

    public boolean equals(@Nullable Object obj) {
        KPropertyImpl<?> d = zv2.d(obj);
        return d != null && b41.d(g(), d.g()) && b41.d(getName(), d.getName()) && b41.d(this.i, d.i) && b41.d(this.j, d.j);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public Caller<?> f() {
        return p().f();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public KDeclarationContainerImpl g() {
        return this.g;
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public String getName() {
        return this.h;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @Nullable
    public Caller<?> h() {
        return p().h();
    }

    public int hashCode() {
        return (((g().hashCode() * 31) + getName().hashCode()) * 31) + this.i.hashCode();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return i().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return i().isLateInit();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean k() {
        return !b41.d(this.j, CallableReference.NO_RECEIVER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Field l() {
        if (i().isDelegated()) {
            return q();
        }
        return null;
    }

    @Nullable
    public final Object m() {
        return n21.a(this.j, i());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
        return r2.get(r3);
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object n(@org.jetbrains.annotations.Nullable java.lang.reflect.Field r2, @org.jetbrains.annotations.Nullable java.lang.Object r3) {
        /*
            r1 = this;
            java.lang.Object r0 = kotlin.reflect.jvm.internal.KPropertyImpl.k     // Catch: java.lang.IllegalAccessException -> L39
            if (r3 != r0) goto L30
            kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r0 = r1.i()     // Catch: java.lang.IllegalAccessException -> L39
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r0 = r0.getExtensionReceiverParameter()     // Catch: java.lang.IllegalAccessException -> L39
            if (r0 == 0) goto Lf
            goto L30
        Lf:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.IllegalAccessException -> L39
            r3.<init>()     // Catch: java.lang.IllegalAccessException -> L39
            r0 = 39
            r3.append(r0)     // Catch: java.lang.IllegalAccessException -> L39
            r3.append(r1)     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.String r0 = "' is not an extension property and thus getExtensionDelegate() "
            r3.append(r0)     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.String r0 = "is not going to work, use getDelegate() instead"
            r3.append(r0)     // Catch: java.lang.IllegalAccessException -> L39
            java.lang.String r3 = r3.toString()     // Catch: java.lang.IllegalAccessException -> L39
            r2.<init>(r3)     // Catch: java.lang.IllegalAccessException -> L39
            throw r2     // Catch: java.lang.IllegalAccessException -> L39
        L30:
            if (r2 == 0) goto L37
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.IllegalAccessException -> L39
            goto L38
        L37:
            r2 = 0
        L38:
            return r2
        L39:
            r2 = move-exception
            kotlin.reflect.full.IllegalPropertyDelegateAccessException r3 = new kotlin.reflect.full.IllegalPropertyDelegateAccessException
            r3.<init>(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPropertyImpl.n(java.lang.reflect.Field, java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    /* renamed from: o */
    public PropertyDescriptor i() {
        PropertyDescriptor invoke = this.f.invoke();
        b41.h(invoke, "_descriptor()");
        return invoke;
    }

    @NotNull
    public abstract Getter<V> p();

    @Nullable
    public final Field q() {
        return this.e.invoke();
    }

    @NotNull
    public final String r() {
        return this.i;
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.g(i());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj);
        b41.i(kDeclarationContainerImpl, "container");
        b41.i(str, "name");
        b41.i(str2, SocialOperation.GAME_SIGNATURE);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KPropertyImpl(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.KDeclarationContainerImpl r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor r9) {
        /*
            r7 = this;
            java.lang.String r0 = "container"
            tb.b41.i(r8, r0)
            java.lang.String r0 = "descriptor"
            tb.b41.i(r9, r0)
            tb.ni1 r0 = r9.getName()
            java.lang.String r3 = r0.b()
            java.lang.String r0 = "descriptor.name.asString()"
            tb.b41.h(r3, r0)
            tb.g42 r0 = tb.g42.INSTANCE
            tb.a71 r0 = r0.f(r9)
            java.lang.String r4 = r0.a()
            java.lang.Object r6 = kotlin.jvm.internal.CallableReference.NO_RECEIVER
            r1 = r7
            r2 = r8
            r5 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPropertyImpl.<init>(kotlin.reflect.jvm.internal.KDeclarationContainerImpl, kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor):void");
    }
}
