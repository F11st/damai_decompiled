package tb;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.collections.C8202e;
import kotlin.reflect.jvm.internal.calls.BoundCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class yf<M extends Member> implements Caller<M> {
    @NotNull
    public static final C9962d Companion = new C9962d(null);
    @NotNull
    private final List<Type> a;
    @NotNull
    private final M b;
    @NotNull
    private final Type c;
    @Nullable
    private final Class<?> d;

    /* compiled from: Taobao */
    /* renamed from: tb.yf$a */
    /* loaded from: classes3.dex */
    public static final class C9959a extends yf<Constructor<?>> implements BoundCaller {
        private final Object e;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public C9959a(@org.jetbrains.annotations.NotNull java.lang.reflect.Constructor<?> r8, @org.jetbrains.annotations.Nullable java.lang.Object r9) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                tb.b41.i(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                tb.b41.h(r3, r0)
                java.lang.reflect.Type[] r0 = r8.getGenericParameterTypes()
                java.lang.String r1 = "constructor.genericParameterTypes"
                tb.b41.h(r0, r1)
                int r1 = r0.length
                r2 = 2
                if (r1 > r2) goto L1f
                r0 = 0
                java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r0]
                goto L2b
            L1f:
                int r1 = r0.length
                r2 = 1
                int r1 = r1 - r2
                java.lang.Object[] r0 = kotlin.collections.C8202e.h(r0, r2, r1)
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
                java.util.Objects.requireNonNull(r0, r1)
            L2b:
                r5 = r0
                java.lang.reflect.Type[] r5 = (java.lang.reflect.Type[]) r5
                r6 = 0
                r4 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                r7.e = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.yf.C9959a.<init>(java.lang.reflect.Constructor, java.lang.Object):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            b41.i(objArr, "args");
            a(objArr);
            if2 if2Var = new if2(3);
            if2Var.a(this.e);
            if2Var.b(objArr);
            if2Var.a(null);
            return getMember().newInstance(if2Var.d(new Object[if2Var.c()]));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.yf$b */
    /* loaded from: classes3.dex */
    public static final class C9960b extends yf<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public C9960b(@org.jetbrains.annotations.NotNull java.lang.reflect.Constructor<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                tb.b41.i(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                tb.b41.h(r3, r0)
                java.lang.reflect.Type[] r0 = r8.getGenericParameterTypes()
                java.lang.String r1 = "constructor.genericParameterTypes"
                tb.b41.h(r0, r1)
                int r1 = r0.length
                r2 = 0
                r4 = 1
                if (r1 > r4) goto L1f
                java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r2]
                goto L2a
            L1f:
                int r1 = r0.length
                int r1 = r1 - r4
                java.lang.Object[] r0 = kotlin.collections.C8202e.h(r0, r2, r1)
                java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
                java.util.Objects.requireNonNull(r0, r1)
            L2a:
                r5 = r0
                java.lang.reflect.Type[] r5 = (java.lang.reflect.Type[]) r5
                r6 = 0
                r4 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.yf.C9960b.<init>(java.lang.reflect.Constructor):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            b41.i(objArr, "args");
            a(objArr);
            if2 if2Var = new if2(2);
            if2Var.b(objArr);
            if2Var.a(null);
            return getMember().newInstance(if2Var.d(new Object[if2Var.c()]));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.yf$c */
    /* loaded from: classes3.dex */
    public static final class C9961c extends yf<Constructor<?>> implements BoundCaller {
        private final Object e;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public C9961c(@org.jetbrains.annotations.NotNull java.lang.reflect.Constructor<?> r8, @org.jetbrains.annotations.Nullable java.lang.Object r9) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                tb.b41.i(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                tb.b41.h(r3, r0)
                java.lang.reflect.Type[] r5 = r8.getGenericParameterTypes()
                java.lang.String r0 = "constructor.genericParameterTypes"
                tb.b41.h(r5, r0)
                r4 = 0
                r6 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                r7.e = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.yf.C9961c.<init>(java.lang.reflect.Constructor, java.lang.Object):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            b41.i(objArr, "args");
            a(objArr);
            if2 if2Var = new if2(2);
            if2Var.a(this.e);
            if2Var.b(objArr);
            return getMember().newInstance(if2Var.d(new Object[if2Var.c()]));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.yf$d */
    /* loaded from: classes3.dex */
    public static final class C9962d {
        private C9962d() {
        }

        public /* synthetic */ C9962d(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.yf$e */
    /* loaded from: classes3.dex */
    public static final class C9963e extends yf<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public C9963e(@org.jetbrains.annotations.NotNull java.lang.reflect.Constructor<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                tb.b41.i(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                tb.b41.h(r3, r0)
                java.lang.Class r0 = r8.getDeclaringClass()
                java.lang.String r1 = "klass"
                tb.b41.h(r0, r1)
                java.lang.Class r1 = r0.getDeclaringClass()
                if (r1 == 0) goto L29
                int r0 = r0.getModifiers()
                boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
                if (r0 != 0) goto L29
                r4 = r1
                goto L2b
            L29:
                r0 = 0
                r4 = r0
            L2b:
                java.lang.reflect.Type[] r5 = r8.getGenericParameterTypes()
                java.lang.String r0 = "constructor.genericParameterTypes"
                tb.b41.h(r5, r0)
                r6 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.yf.C9963e.<init>(java.lang.reflect.Constructor):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            b41.i(objArr, "args");
            a(objArr);
            return getMember().newInstance(Arrays.copyOf(objArr, objArr.length));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.yf$f */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC9964f extends yf<Field> {

        /* compiled from: Taobao */
        /* renamed from: tb.yf$f$a */
        /* loaded from: classes3.dex */
        public static final class C9965a extends AbstractC9964f implements BoundCaller {
            private final Object e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9965a(@NotNull Field field, @Nullable Object obj) {
                super(field, false, null);
                b41.i(field, "field");
                this.e = obj;
            }

            @Override // tb.yf.AbstractC9964f, kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                b41.i(objArr, "args");
                a(objArr);
                return getMember().get(this.e);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.yf$f$b */
        /* loaded from: classes3.dex */
        public static final class C9966b extends AbstractC9964f implements BoundCaller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9966b(@NotNull Field field) {
                super(field, false, null);
                b41.i(field, "field");
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.yf$f$c */
        /* loaded from: classes3.dex */
        public static final class C9967c extends AbstractC9964f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9967c(@NotNull Field field) {
                super(field, true, null);
                b41.i(field, "field");
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.yf$f$d */
        /* loaded from: classes3.dex */
        public static final class C9968d extends AbstractC9964f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9968d(@NotNull Field field) {
                super(field, true, null);
                b41.i(field, "field");
            }

            @Override // tb.yf
            public void a(@NotNull Object[] objArr) {
                b41.i(objArr, "args");
                super.a(objArr);
                b(C8202e.v(objArr));
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.yf$f$e */
        /* loaded from: classes3.dex */
        public static final class C9969e extends AbstractC9964f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9969e(@NotNull Field field) {
                super(field, false, null);
                b41.i(field, "field");
            }
        }

        public /* synthetic */ AbstractC9964f(Field field, boolean z, k50 k50Var) {
            this(field, z);
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            b41.i(objArr, "args");
            a(objArr);
            return getMember().get(c() != null ? C8202e.u(objArr) : null);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private AbstractC9964f(java.lang.reflect.Field r7, boolean r8) {
            /*
                r6 = this;
                java.lang.reflect.Type r2 = r7.getGenericType()
                java.lang.String r0 = "field.genericType"
                tb.b41.h(r2, r0)
                if (r8 == 0) goto L10
                java.lang.Class r8 = r7.getDeclaringClass()
                goto L11
            L10:
                r8 = 0
            L11:
                r3 = r8
                r8 = 0
                java.lang.reflect.Type[] r4 = new java.lang.reflect.Type[r8]
                r5 = 0
                r0 = r6
                r1 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.yf.AbstractC9964f.<init>(java.lang.reflect.Field, boolean):void");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.yf$g */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC9970g extends yf<Field> {
        private final boolean e;

        /* compiled from: Taobao */
        /* renamed from: tb.yf$g$a */
        /* loaded from: classes3.dex */
        public static final class C9971a extends AbstractC9970g implements BoundCaller {
            private final Object f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9971a(@NotNull Field field, boolean z, @Nullable Object obj) {
                super(field, z, false, null);
                b41.i(field, "field");
                this.f = obj;
            }

            @Override // tb.yf.AbstractC9970g, kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                b41.i(objArr, "args");
                a(objArr);
                getMember().set(this.f, C8202e.u(objArr));
                return wt2.INSTANCE;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.yf$g$b */
        /* loaded from: classes3.dex */
        public static final class C9972b extends AbstractC9970g implements BoundCaller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9972b(@NotNull Field field, boolean z) {
                super(field, z, false, null);
                b41.i(field, "field");
            }

            @Override // tb.yf.AbstractC9970g, kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                b41.i(objArr, "args");
                a(objArr);
                getMember().set(null, C8202e.G(objArr));
                return wt2.INSTANCE;
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.yf$g$c */
        /* loaded from: classes3.dex */
        public static final class C9973c extends AbstractC9970g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9973c(@NotNull Field field, boolean z) {
                super(field, z, true, null);
                b41.i(field, "field");
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.yf$g$d */
        /* loaded from: classes3.dex */
        public static final class C9974d extends AbstractC9970g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9974d(@NotNull Field field, boolean z) {
                super(field, z, true, null);
                b41.i(field, "field");
            }

            @Override // tb.yf.AbstractC9970g, tb.yf
            public void a(@NotNull Object[] objArr) {
                b41.i(objArr, "args");
                super.a(objArr);
                b(C8202e.v(objArr));
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.yf$g$e */
        /* loaded from: classes3.dex */
        public static final class C9975e extends AbstractC9970g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9975e(@NotNull Field field, boolean z) {
                super(field, z, false, null);
                b41.i(field, "field");
            }
        }

        public /* synthetic */ AbstractC9970g(Field field, boolean z, boolean z2, k50 k50Var) {
            this(field, z, z2);
        }

        @Override // tb.yf
        public void a(@NotNull Object[] objArr) {
            b41.i(objArr, "args");
            super.a(objArr);
            if (this.e && C8202e.G(objArr) == null) {
                throw new IllegalArgumentException("null is not allowed as a value for this property.");
            }
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] objArr) {
            b41.i(objArr, "args");
            a(objArr);
            getMember().set(c() != null ? C8202e.u(objArr) : null, C8202e.G(objArr));
            return wt2.INSTANCE;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private AbstractC9970g(java.lang.reflect.Field r7, boolean r8, boolean r9) {
            /*
                r6 = this;
                java.lang.Class r2 = java.lang.Void.TYPE
                java.lang.String r0 = "Void.TYPE"
                tb.b41.h(r2, r0)
                if (r9 == 0) goto Le
                java.lang.Class r9 = r7.getDeclaringClass()
                goto Lf
            Le:
                r9 = 0
            Lf:
                r3 = r9
                r9 = 1
                java.lang.reflect.Type[] r4 = new java.lang.reflect.Type[r9]
                r9 = 0
                java.lang.reflect.Type r0 = r7.getGenericType()
                java.lang.String r1 = "field.genericType"
                tb.b41.h(r0, r1)
                r4[r9] = r0
                r5 = 0
                r0 = r6
                r1 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                r6.e = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.yf.AbstractC9970g.<init>(java.lang.reflect.Field, boolean, boolean):void");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.yf$h */
    /* loaded from: classes3.dex */
    public static abstract class AbstractC9976h extends yf<Method> {
        private final boolean e;

        /* compiled from: Taobao */
        /* renamed from: tb.yf$h$a */
        /* loaded from: classes3.dex */
        public static final class C9977a extends AbstractC9976h implements BoundCaller {
            private final Object f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9977a(@NotNull Method method, @Nullable Object obj) {
                super(method, false, null, 4, null);
                b41.i(method, "method");
                this.f = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                b41.i(objArr, "args");
                a(objArr);
                return d(this.f, objArr);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.yf$h$b */
        /* loaded from: classes3.dex */
        public static final class C9978b extends AbstractC9976h implements BoundCaller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9978b(@NotNull Method method) {
                super(method, false, null, 4, null);
                b41.i(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                b41.i(objArr, "args");
                a(objArr);
                return d(null, objArr);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.yf$h$c */
        /* loaded from: classes3.dex */
        public static final class C9979c extends AbstractC9976h implements BoundCaller {
            private final Object f;

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public C9979c(@org.jetbrains.annotations.NotNull java.lang.reflect.Method r5, @org.jetbrains.annotations.Nullable java.lang.Object r6) {
                /*
                    r4 = this;
                    java.lang.String r0 = "method"
                    tb.b41.i(r5, r0)
                    java.lang.reflect.Type[] r0 = r5.getGenericParameterTypes()
                    java.lang.String r1 = "method.genericParameterTypes"
                    tb.b41.h(r0, r1)
                    int r1 = r0.length
                    r2 = 1
                    r3 = 0
                    if (r1 > r2) goto L16
                    java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r3]
                    goto L20
                L16:
                    int r1 = r0.length
                    java.lang.Object[] r0 = kotlin.collections.C8202e.h(r0, r2, r1)
                    java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T>"
                    java.util.Objects.requireNonNull(r0, r1)
                L20:
                    java.lang.reflect.Type[] r0 = (java.lang.reflect.Type[]) r0
                    r1 = 0
                    r4.<init>(r5, r3, r0, r1)
                    r4.f = r6
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: tb.yf.AbstractC9976h.C9979c.<init>(java.lang.reflect.Method, java.lang.Object):void");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                b41.i(objArr, "args");
                a(objArr);
                if2 if2Var = new if2(2);
                if2Var.a(this.f);
                if2Var.b(objArr);
                return d(null, if2Var.d(new Object[if2Var.c()]));
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.yf$h$d */
        /* loaded from: classes3.dex */
        public static final class C9980d extends AbstractC9976h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9980d(@NotNull Method method) {
                super(method, false, null, 6, null);
                b41.i(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                Object[] h;
                b41.i(objArr, "args");
                a(objArr);
                Object obj = objArr[0];
                if (objArr.length <= 1) {
                    h = new Object[0];
                } else {
                    h = C8202e.h(objArr, 1, objArr.length);
                    Objects.requireNonNull(h, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                return d(obj, h);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.yf$h$e */
        /* loaded from: classes3.dex */
        public static final class C9981e extends AbstractC9976h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9981e(@NotNull Method method) {
                super(method, true, null, 4, null);
                b41.i(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                Object[] h;
                b41.i(objArr, "args");
                a(objArr);
                b(C8202e.v(objArr));
                if (objArr.length <= 1) {
                    h = new Object[0];
                } else {
                    h = C8202e.h(objArr, 1, objArr.length);
                    Objects.requireNonNull(h, "null cannot be cast to non-null type kotlin.Array<T>");
                }
                return d(null, h);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: tb.yf$h$f */
        /* loaded from: classes3.dex */
        public static final class C9982f extends AbstractC9976h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9982f(@NotNull Method method) {
                super(method, false, null, 6, null);
                b41.i(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] objArr) {
                b41.i(objArr, "args");
                a(objArr);
                return d(null, objArr);
            }
        }

        public /* synthetic */ AbstractC9976h(Method method, boolean z, Type[] typeArr, k50 k50Var) {
            this(method, z, typeArr);
        }

        @Nullable
        protected final Object d(@Nullable Object obj, @NotNull Object[] objArr) {
            b41.i(objArr, "args");
            return this.e ? wt2.INSTANCE : getMember().invoke(obj, Arrays.copyOf(objArr, objArr.length));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ AbstractC9976h(java.lang.reflect.Method r1, boolean r2, java.lang.reflect.Type[] r3, int r4, tb.k50 r5) {
            /*
                r0 = this;
                r5 = r4 & 2
                if (r5 == 0) goto Le
                int r2 = r1.getModifiers()
                boolean r2 = java.lang.reflect.Modifier.isStatic(r2)
                r2 = r2 ^ 1
            Le:
                r4 = r4 & 4
                if (r4 == 0) goto L1b
                java.lang.reflect.Type[] r3 = r1.getGenericParameterTypes()
                java.lang.String r4 = "method.genericParameterTypes"
                tb.b41.h(r3, r4)
            L1b:
                r0.<init>(r1, r2, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.yf.AbstractC9976h.<init>(java.lang.reflect.Method, boolean, java.lang.reflect.Type[], int, tb.k50):void");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private AbstractC9976h(java.lang.reflect.Method r7, boolean r8, java.lang.reflect.Type[] r9) {
            /*
                r6 = this;
                java.lang.reflect.Type r2 = r7.getGenericReturnType()
                java.lang.String r0 = "method.genericReturnType"
                tb.b41.h(r2, r0)
                if (r8 == 0) goto L10
                java.lang.Class r8 = r7.getDeclaringClass()
                goto L11
            L10:
                r8 = 0
            L11:
                r3 = r8
                r5 = 0
                r0 = r6
                r1 = r7
                r4 = r9
                r0.<init>(r1, r2, r3, r4, r5)
                java.lang.reflect.Type r7 = r6.getReturnType()
                java.lang.Class r8 = java.lang.Void.TYPE
                boolean r7 = tb.b41.d(r7, r8)
                r6.e = r7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.yf.AbstractC9976h.<init>(java.lang.reflect.Method, boolean, java.lang.reflect.Type[]):void");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0027, code lost:
        if (r1 != null) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private yf(M r1, java.lang.reflect.Type r2, java.lang.Class<?> r3, java.lang.reflect.Type[] r4) {
        /*
            r0 = this;
            r0.<init>()
            r0.b = r1
            r0.c = r2
            r0.d = r3
            if (r3 == 0) goto L2a
            tb.if2 r1 = new tb.if2
            r2 = 2
            r1.<init>(r2)
            r1.a(r3)
            r1.b(r4)
            int r2 = r1.c()
            java.lang.reflect.Type[] r2 = new java.lang.reflect.Type[r2]
            java.lang.Object[] r1 = r1.d(r2)
            java.lang.reflect.Type[] r1 = (java.lang.reflect.Type[]) r1
            java.util.List r1 = kotlin.collections.C8212k.j(r1)
            if (r1 == 0) goto L2a
            goto L2e
        L2a:
            java.util.List r1 = kotlin.collections.C8202e.X(r4)
        L2e:
            r0.a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.yf.<init>(java.lang.reflect.Member, java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type[]):void");
    }

    public void a(@NotNull Object[] objArr) {
        b41.i(objArr, "args");
        Caller.C8265a.a(this, objArr);
    }

    protected final void b(@Nullable Object obj) {
        if (obj == null || !this.b.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    @Nullable
    public final Class<?> c() {
        return this.d;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public final M getMember() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public List<Type> getParameterTypes() {
        return this.a;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public final Type getReturnType() {
        return this.c;
    }

    public /* synthetic */ yf(Member member, Type type, Class cls, Type[] typeArr, k50 k50Var) {
        this(member, type, cls, typeArr);
    }
}
