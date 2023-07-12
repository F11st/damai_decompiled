package kotlin.reflect.jvm.internal;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tencent.open.SocialOperation;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.FunctionWithAllInvokes;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a12;
import tb.b41;
import tb.g42;
import tb.k50;
import tb.n21;
import tb.o21;
import tb.x02;
import tb.yf;
import tb.zf;
import tb.zv2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class KFunctionImpl extends KCallableImpl<Object> implements FunctionBase<Object>, KFunction<Object>, FunctionWithAllInvokes {
    static final /* synthetic */ KProperty[] k = {a12.i(new PropertyReference1Impl(a12.b(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), a12.i(new PropertyReference1Impl(a12.b(KFunctionImpl.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), a12.i(new PropertyReference1Impl(a12.b(KFunctionImpl.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    @NotNull
    private final x02.a e;
    @NotNull
    private final x02.b f;
    @Nullable
    private final x02.b g;
    @NotNull
    private final KDeclarationContainerImpl h;
    private final String i;
    private final Object j;

    /* synthetic */ KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, FunctionDescriptor functionDescriptor, Object obj, int i, k50 k50Var) {
        this(kDeclarationContainerImpl, str, str2, functionDescriptor, (i & 16) != 0 ? CallableReference.NO_RECEIVER : obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final yf<Constructor<?>> q(Constructor<?> constructor, FunctionDescriptor functionDescriptor) {
        if (o21.f(functionDescriptor)) {
            if (k()) {
                return new yf.a(constructor, u());
            }
            return new yf.b(constructor);
        } else if (k()) {
            return new yf.c(constructor, u());
        } else {
            return new yf.e(constructor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final yf.h r(Method method) {
        return k() ? new yf.h.a(method, u()) : new yf.h.d(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final yf.h s(Method method) {
        return k() ? new yf.h.b(method) : new yf.h.e(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final yf.h t(Method method) {
        return k() ? new yf.h.c(method, u()) : new yf.h.f(method);
    }

    private final Object u() {
        return n21.a(this.j, i());
    }

    public boolean equals(@Nullable Object obj) {
        KFunctionImpl c = zv2.c(obj);
        return c != null && b41.d(g(), c.g()) && b41.d(getName(), c.getName()) && b41.d(this.i, c.i) && b41.d(this.j, c.j);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public Caller<?> f() {
        return (Caller) this.f.b(this, k[1]);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    public KDeclarationContainerImpl g() {
        return this.h;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return zf.a(f());
    }

    @Override // kotlin.reflect.KCallable
    @NotNull
    public String getName() {
        String b = i().getName().b();
        b41.h(b, "descriptor.name.asString()");
        return b;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @Nullable
    public Caller<?> h() {
        return (Caller) this.g.b(this, k[2]);
    }

    public int hashCode() {
        return (((g().hashCode() * 31) + getName().hashCode()) * 31) + this.i.hashCode();
    }

    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public Object invoke() {
        return FunctionWithAllInvokes.a.a(this);
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return i().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return i().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return i().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return i().isOperator();
    }

    @Override // kotlin.reflect.KCallable
    public boolean isSuspend() {
        return i().isSuspend();
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean k() {
        return !b41.d(this.j, CallableReference.NO_RECEIVER);
    }

    @NotNull
    public String toString() {
        return ReflectionObjectRenderer.INSTANCE.d(i());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @NotNull
    /* renamed from: v */
    public FunctionDescriptor i() {
        return (FunctionDescriptor) this.e.b(this, k[0]);
    }

    private KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, final String str, String str2, FunctionDescriptor functionDescriptor, Object obj) {
        this.h = kDeclarationContainerImpl;
        this.i = str2;
        this.j = obj;
        this.e = x02.c(functionDescriptor, new Function0<FunctionDescriptor>() { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$descriptor$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final FunctionDescriptor invoke() {
                String str3;
                KDeclarationContainerImpl g = KFunctionImpl.this.g();
                String str4 = str;
                str3 = KFunctionImpl.this.i;
                return g.f(str4, str3);
            }
        });
        this.f = x02.b(new Function0<Caller<? extends Member>>() { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$caller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Caller<? extends Member> invoke() {
                int q;
                Object b;
                Caller r;
                int q2;
                JvmFunctionSignature g = g42.INSTANCE.g(KFunctionImpl.this.i());
                if (g instanceof JvmFunctionSignature.b) {
                    if (KFunctionImpl.this.j()) {
                        Class<?> jClass = KFunctionImpl.this.g().getJClass();
                        List<KParameter> parameters = KFunctionImpl.this.getParameters();
                        q2 = n.q(parameters, 10);
                        ArrayList arrayList = new ArrayList(q2);
                        for (KParameter kParameter : parameters) {
                            String name = kParameter.getName();
                            b41.f(name);
                            arrayList.add(name);
                        }
                        return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
                    }
                    b = KFunctionImpl.this.g().c(((JvmFunctionSignature.b) g).b());
                } else if (g instanceof JvmFunctionSignature.c) {
                    JvmFunctionSignature.c cVar = (JvmFunctionSignature.c) g;
                    b = KFunctionImpl.this.g().g(cVar.c(), cVar.b());
                } else if (g instanceof JvmFunctionSignature.a) {
                    b = ((JvmFunctionSignature.a) g).b();
                } else if (!(g instanceof JvmFunctionSignature.JavaConstructor)) {
                    if (g instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                        List<Method> b2 = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) g).b();
                        Class<?> jClass2 = KFunctionImpl.this.g().getJClass();
                        q = n.q(b2, 10);
                        ArrayList arrayList2 = new ArrayList(q);
                        for (Method method : b2) {
                            b41.h(method, AdvanceSetting.NETWORK_TYPE);
                            arrayList2.add(method.getName());
                        }
                        return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, b2);
                    }
                    throw new NoWhenBranchMatchedException();
                } else {
                    b = ((JvmFunctionSignature.JavaConstructor) g).b();
                }
                if (b instanceof Constructor) {
                    KFunctionImpl kFunctionImpl = KFunctionImpl.this;
                    r = kFunctionImpl.q((Constructor) b, kFunctionImpl.i());
                } else if (b instanceof Method) {
                    Method method2 = (Method) b;
                    r = !Modifier.isStatic(method2.getModifiers()) ? KFunctionImpl.this.r(method2) : KFunctionImpl.this.i().getAnnotations().findAnnotation(zv2.j()) != null ? KFunctionImpl.this.s(method2) : KFunctionImpl.this.t(method2);
                } else {
                    throw new KotlinReflectionInternalError("Could not compute caller for function: " + KFunctionImpl.this.i() + " (member = " + b + ')');
                }
                return n21.c(r, KFunctionImpl.this.i(), false, 2, null);
            }
        });
        this.g = x02.b(new Function0<Caller<? extends Member>>() { // from class: kotlin.reflect.jvm.internal.KFunctionImpl$defaultCaller$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.reflect.Member, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Caller<? extends Member> invoke() {
                GenericDeclaration genericDeclaration;
                int q;
                int q2;
                Caller caller;
                ?? member;
                JvmFunctionSignature g = g42.INSTANCE.g(KFunctionImpl.this.i());
                if (g instanceof JvmFunctionSignature.c) {
                    KDeclarationContainerImpl g2 = KFunctionImpl.this.g();
                    JvmFunctionSignature.c cVar = (JvmFunctionSignature.c) g;
                    String c = cVar.c();
                    String b = cVar.b();
                    b41.f(KFunctionImpl.this.f().getMember());
                    genericDeclaration = g2.e(c, b, !Modifier.isStatic(member.getModifiers()));
                } else if (g instanceof JvmFunctionSignature.b) {
                    if (KFunctionImpl.this.j()) {
                        Class<?> jClass = KFunctionImpl.this.g().getJClass();
                        List<KParameter> parameters = KFunctionImpl.this.getParameters();
                        q2 = n.q(parameters, 10);
                        ArrayList arrayList = new ArrayList(q2);
                        for (KParameter kParameter : parameters) {
                            String name = kParameter.getName();
                            b41.f(name);
                            arrayList.add(name);
                        }
                        return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
                    }
                    genericDeclaration = KFunctionImpl.this.g().d(((JvmFunctionSignature.b) g).b());
                } else if (g instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
                    List<Method> b2 = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) g).b();
                    Class<?> jClass2 = KFunctionImpl.this.g().getJClass();
                    q = n.q(b2, 10);
                    ArrayList arrayList2 = new ArrayList(q);
                    for (Method method : b2) {
                        b41.h(method, AdvanceSetting.NETWORK_TYPE);
                        arrayList2.add(method.getName());
                    }
                    return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, b2);
                } else {
                    genericDeclaration = null;
                }
                if (genericDeclaration instanceof Constructor) {
                    KFunctionImpl kFunctionImpl = KFunctionImpl.this;
                    caller = kFunctionImpl.q((Constructor) genericDeclaration, kFunctionImpl.i());
                } else if (genericDeclaration instanceof Method) {
                    if (KFunctionImpl.this.i().getAnnotations().findAnnotation(zv2.j()) != null) {
                        DeclarationDescriptor containingDeclaration = KFunctionImpl.this.i().getContainingDeclaration();
                        Objects.requireNonNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                        if (!((ClassDescriptor) containingDeclaration).isCompanionObject()) {
                            caller = KFunctionImpl.this.s((Method) genericDeclaration);
                        }
                    }
                    caller = KFunctionImpl.this.t((Method) genericDeclaration);
                } else {
                    caller = null;
                }
                if (caller != null) {
                    return n21.b(caller, KFunctionImpl.this.i(), true);
                }
                return null;
            }
        });
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public Object invoke(@Nullable Object obj) {
        return FunctionWithAllInvokes.a.b(this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2) {
        return FunctionWithAllInvokes.a.c(this, obj, obj2);
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        return FunctionWithAllInvokes.a.d(this, obj, obj2, obj3);
    }

    @Override // kotlin.jvm.functions.Function4
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4) {
        return FunctionWithAllInvokes.a.e(this, obj, obj2, obj3, obj4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KFunctionImpl(@NotNull KDeclarationContainerImpl kDeclarationContainerImpl, @NotNull String str, @NotNull String str2, @Nullable Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj);
        b41.i(kDeclarationContainerImpl, "container");
        b41.i(str, "name");
        b41.i(str2, SocialOperation.GAME_SIGNATURE);
    }

    @Override // kotlin.jvm.functions.Function5
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5) {
        return FunctionWithAllInvokes.a.f(this, obj, obj2, obj3, obj4, obj5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KFunctionImpl(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.KDeclarationContainerImpl r10, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r11) {
        /*
            r9 = this;
            java.lang.String r0 = "container"
            tb.b41.i(r10, r0)
            java.lang.String r0 = "descriptor"
            tb.b41.i(r11, r0)
            tb.ni1 r0 = r11.getName()
            java.lang.String r3 = r0.b()
            java.lang.String r0 = "descriptor.name.asString()"
            tb.b41.h(r3, r0)
            tb.g42 r0 = tb.g42.INSTANCE
            kotlin.reflect.jvm.internal.JvmFunctionSignature r0 = r0.g(r11)
            java.lang.String r4 = r0.a()
            r6 = 0
            r7 = 16
            r8 = 0
            r1 = r9
            r2 = r10
            r5 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KFunctionImpl.<init>(kotlin.reflect.jvm.internal.KDeclarationContainerImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor):void");
    }

    @Override // kotlin.jvm.functions.Function6
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6) {
        return FunctionWithAllInvokes.a.g(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // kotlin.jvm.functions.Function7
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7) {
        return FunctionWithAllInvokes.a.h(this, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // kotlin.jvm.functions.Function8
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8) {
        return FunctionWithAllInvokes.a.i(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // kotlin.jvm.functions.Function9
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9) {
        return FunctionWithAllInvokes.a.j(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // kotlin.jvm.functions.Function10
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10) {
        return FunctionWithAllInvokes.a.k(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // kotlin.jvm.functions.Function11
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11) {
        return FunctionWithAllInvokes.a.l(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // kotlin.jvm.functions.Function12
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12) {
        return FunctionWithAllInvokes.a.m(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // kotlin.jvm.functions.Function13
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13) {
        return FunctionWithAllInvokes.a.n(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // kotlin.jvm.functions.Function14
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14) {
        return FunctionWithAllInvokes.a.o(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // kotlin.jvm.functions.Function15
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15) {
        return FunctionWithAllInvokes.a.p(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // kotlin.jvm.functions.Function16
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16) {
        return FunctionWithAllInvokes.a.q(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // kotlin.jvm.functions.Function17
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17) {
        return FunctionWithAllInvokes.a.r(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // kotlin.jvm.functions.Function18
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18) {
        return FunctionWithAllInvokes.a.s(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // kotlin.jvm.functions.Function19
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19) {
        return FunctionWithAllInvokes.a.t(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // kotlin.jvm.functions.Function20
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20) {
        return FunctionWithAllInvokes.a.u(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // kotlin.jvm.functions.Function21
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20, @Nullable Object obj21) {
        return FunctionWithAllInvokes.a.v(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Override // kotlin.jvm.functions.Function22
    @Nullable
    public Object invoke(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @Nullable Object obj4, @Nullable Object obj5, @Nullable Object obj6, @Nullable Object obj7, @Nullable Object obj8, @Nullable Object obj9, @Nullable Object obj10, @Nullable Object obj11, @Nullable Object obj12, @Nullable Object obj13, @Nullable Object obj14, @Nullable Object obj15, @Nullable Object obj16, @Nullable Object obj17, @Nullable Object obj18, @Nullable Object obj19, @Nullable Object obj20, @Nullable Object obj21, @Nullable Object obj22) {
        return FunctionWithAllInvokes.a.w(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
