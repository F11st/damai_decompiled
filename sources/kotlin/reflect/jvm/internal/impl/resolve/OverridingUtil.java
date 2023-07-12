package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.C8212k;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractC8316a;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.a81;
import tb.ax1;
import tb.b81;
import tb.bx1;
import tb.d70;
import tb.dk0;
import tb.e70;
import tb.f70;
import tb.gp1;
import tb.hk1;
import tb.hp1;
import tb.mj;
import tb.ni1;
import tb.vy2;
import tb.wt2;
import tb.yd2;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class OverridingUtil {
    public static final OverridingUtil DEFAULT;
    private static final List<ExternalOverridabilityCondition> c;
    private static final KotlinTypeChecker.TypeConstructorEquality d;
    private final b81 a;
    private final KotlinTypeChecker.TypeConstructorEquality b;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class OverrideCompatibilityInfo {
        private static final OverrideCompatibilityInfo b = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");
        private final Result a;

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public OverrideCompatibilityInfo(@NotNull Result result, @NotNull String str) {
            if (result == null) {
                a(3);
            }
            if (str == null) {
                a(4);
            }
            this.a = result;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void a(int r10) {
            /*
                r0 = 4
                r1 = 3
                r2 = 2
                r3 = 1
                if (r10 == r3) goto Lf
                if (r10 == r2) goto Lf
                if (r10 == r1) goto Lf
                if (r10 == r0) goto Lf
                java.lang.String r4 = "@NotNull method %s.%s must not return null"
                goto L11
            Lf:
                java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            L11:
                if (r10 == r3) goto L1b
                if (r10 == r2) goto L1b
                if (r10 == r1) goto L1b
                if (r10 == r0) goto L1b
                r5 = 2
                goto L1c
            L1b:
                r5 = 3
            L1c:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "success"
                java.lang.String r7 = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo"
                r8 = 0
                if (r10 == r3) goto L31
                if (r10 == r2) goto L31
                if (r10 == r1) goto L2e
                if (r10 == r0) goto L31
                r5[r8] = r7
                goto L35
            L2e:
                r5[r8] = r6
                goto L35
            L31:
                java.lang.String r9 = "debugMessage"
                r5[r8] = r9
            L35:
                switch(r10) {
                    case 1: goto L45;
                    case 2: goto L45;
                    case 3: goto L45;
                    case 4: goto L45;
                    case 5: goto L40;
                    case 6: goto L3b;
                    default: goto L38;
                }
            L38:
                r5[r3] = r6
                goto L47
            L3b:
                java.lang.String r6 = "getDebugMessage"
                r5[r3] = r6
                goto L47
            L40:
                java.lang.String r6 = "getResult"
                r5[r3] = r6
                goto L47
            L45:
                r5[r3] = r7
            L47:
                if (r10 == r3) goto L5a
                if (r10 == r2) goto L55
                if (r10 == r1) goto L50
                if (r10 == r0) goto L50
                goto L5e
            L50:
                java.lang.String r6 = "<init>"
                r5[r2] = r6
                goto L5e
            L55:
                java.lang.String r6 = "conflict"
                r5[r2] = r6
                goto L5e
            L5a:
                java.lang.String r6 = "incompatible"
                r5[r2] = r6
            L5e:
                java.lang.String r4 = java.lang.String.format(r4, r5)
                if (r10 == r3) goto L70
                if (r10 == r2) goto L70
                if (r10 == r1) goto L70
                if (r10 == r0) goto L70
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r4)
                goto L75
            L70:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r4)
            L75:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.a(int):void");
        }

        @NotNull
        public static OverrideCompatibilityInfo b(@NotNull String str) {
            if (str == null) {
                a(2);
            }
            return new OverrideCompatibilityInfo(Result.CONFLICT, str);
        }

        @NotNull
        public static OverrideCompatibilityInfo d(@NotNull String str) {
            if (str == null) {
                a(1);
            }
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, str);
        }

        @NotNull
        public static OverrideCompatibilityInfo e() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = b;
            if (overrideCompatibilityInfo == null) {
                a(0);
            }
            return overrideCompatibilityInfo;
        }

        @NotNull
        public Result c() {
            Result result = this.a;
            if (result == null) {
                a(5);
            }
            return result;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$a */
    /* loaded from: classes3.dex */
    static class C8483a implements KotlinTypeChecker.TypeConstructorEquality {
        C8483a() {
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "a";
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality
        public boolean equals(@NotNull TypeConstructor typeConstructor, @NotNull TypeConstructor typeConstructor2) {
            if (typeConstructor == null) {
                a(0);
            }
            if (typeConstructor2 == null) {
                a(1);
            }
            return typeConstructor.equals(typeConstructor2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [D] */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$b */
    /* loaded from: classes3.dex */
    public static class C8484b<D> implements Function2<D, D, Pair<CallableDescriptor, CallableDescriptor>> {
        C8484b() {
        }

        /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/Pair<Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;>; */
        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a */
        public Pair invoke(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
            return new Pair(callableDescriptor, callableDescriptor2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$c */
    /* loaded from: classes3.dex */
    public static class C8485c implements Function1<CallableMemberDescriptor, Boolean> {
        final /* synthetic */ DeclarationDescriptor a;

        C8485c(DeclarationDescriptor declarationDescriptor) {
            this.a = declarationDescriptor;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(callableMemberDescriptor.getContainingDeclaration() == this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$d */
    /* loaded from: classes3.dex */
    public static class C8486d implements Function1<CallableMemberDescriptor, CallableDescriptor> {
        C8486d() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public CallableMemberDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$e */
    /* loaded from: classes3.dex */
    public static class C8487e implements Function1<CallableMemberDescriptor, Boolean> {
        final /* synthetic */ ClassDescriptor a;

        C8487e(ClassDescriptor classDescriptor) {
            this.a = classDescriptor;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(!e70.g(callableMemberDescriptor.getVisibility()) && e70.h(callableMemberDescriptor, this.a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$f */
    /* loaded from: classes3.dex */
    public static class C8488f implements Function1<CallableMemberDescriptor, CallableDescriptor> {
        C8488f() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public CallableDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$g */
    /* loaded from: classes3.dex */
    public static class C8489g implements Function1<CallableMemberDescriptor, wt2> {
        final /* synthetic */ gp1 a;
        final /* synthetic */ CallableMemberDescriptor b;

        C8489g(gp1 gp1Var, CallableMemberDescriptor callableMemberDescriptor) {
            this.a = gp1Var;
            this.b = callableMemberDescriptor;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a */
        public wt2 invoke(CallableMemberDescriptor callableMemberDescriptor) {
            this.a.b(this.b, callableMemberDescriptor);
            return wt2.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil$h */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C8490h {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[Modality.values().length];
            c = iArr;
            try {
                iArr[Modality.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[Modality.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[Modality.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[Modality.ABSTRACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[OverrideCompatibilityInfo.Result.values().length];
            b = iArr2;
            try {
                iArr2[OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[OverrideCompatibilityInfo.Result.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[OverrideCompatibilityInfo.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[ExternalOverridabilityCondition.Result.values().length];
            a = iArr3;
            try {
                iArr3[ExternalOverridabilityCondition.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ExternalOverridabilityCondition.Result.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ExternalOverridabilityCondition.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ExternalOverridabilityCondition.Result.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    static {
        List<ExternalOverridabilityCondition> A0;
        A0 = CollectionsKt___CollectionsKt.A0(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
        c = A0;
        C8483a c8483a = new C8483a();
        d = c8483a;
        DEFAULT = new OverridingUtil(c8483a, b81.C8955a.INSTANCE);
    }

    private OverridingUtil(@NotNull KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality, @NotNull b81 b81Var) {
        if (typeConstructorEquality == null) {
            a(4);
        }
        if (b81Var == null) {
            a(5);
        }
        this.b = typeConstructorEquality;
        this.a = b81Var;
    }

    @NotNull
    public static Set<CallableMemberDescriptor> A(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(13);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f(callableMemberDescriptor, linkedHashSet);
        return linkedHashSet;
    }

    private static boolean B(@Nullable PropertyAccessorDescriptor propertyAccessorDescriptor, @Nullable PropertyAccessorDescriptor propertyAccessorDescriptor2) {
        if (propertyAccessorDescriptor == null || propertyAccessorDescriptor2 == null) {
            return true;
        }
        return I(propertyAccessorDescriptor, propertyAccessorDescriptor2);
    }

    public static boolean C(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2) {
        if (callableDescriptor == null) {
            a(67);
        }
        if (callableDescriptor2 == null) {
            a(68);
        }
        z71 returnType = callableDescriptor.getReturnType();
        z71 returnType2 = callableDescriptor2.getReturnType();
        if (I(callableDescriptor, callableDescriptor2)) {
            Pair<hk1, mj> l = DEFAULT.l(callableDescriptor.getTypeParameters(), callableDescriptor2.getTypeParameters());
            if (callableDescriptor instanceof FunctionDescriptor) {
                return H(callableDescriptor, returnType, callableDescriptor2, returnType2, l);
            }
            if (callableDescriptor instanceof PropertyDescriptor) {
                PropertyDescriptor propertyDescriptor = (PropertyDescriptor) callableDescriptor;
                PropertyDescriptor propertyDescriptor2 = (PropertyDescriptor) callableDescriptor2;
                if (B(propertyDescriptor.getSetter(), propertyDescriptor2.getSetter())) {
                    if (propertyDescriptor.isVar() && propertyDescriptor2.isVar()) {
                        return l.getFirst().a(l.getSecond(), returnType.f(), returnType2.f());
                    }
                    return (propertyDescriptor.isVar() || !propertyDescriptor2.isVar()) && H(callableDescriptor, returnType, callableDescriptor2, returnType2, l);
                }
                return false;
            }
            throw new IllegalArgumentException("Unexpected callable: " + callableDescriptor.getClass());
        }
        return false;
    }

    private static boolean D(@NotNull CallableDescriptor callableDescriptor, @NotNull Collection<CallableDescriptor> collection) {
        if (callableDescriptor == null) {
            a(71);
        }
        if (collection == null) {
            a(72);
        }
        for (CallableDescriptor callableDescriptor2 : collection) {
            if (!C(callableDescriptor, callableDescriptor2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean H(@NotNull CallableDescriptor callableDescriptor, @NotNull z71 z71Var, @NotNull CallableDescriptor callableDescriptor2, @NotNull z71 z71Var2, @NotNull Pair<hk1, mj> pair) {
        if (callableDescriptor == null) {
            a(73);
        }
        if (z71Var == null) {
            a(74);
        }
        if (callableDescriptor2 == null) {
            a(75);
        }
        if (z71Var2 == null) {
            a(76);
        }
        if (pair == null) {
            a(77);
        }
        return pair.getFirst().c(pair.getSecond(), z71Var.f(), z71Var2.f());
    }

    private static boolean I(@NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2) {
        if (declarationDescriptorWithVisibility == null) {
            a(69);
        }
        if (declarationDescriptorWithVisibility2 == null) {
            a(70);
        }
        Integer d2 = e70.d(declarationDescriptorWithVisibility.getVisibility(), declarationDescriptorWithVisibility2.getVisibility());
        return d2 == null || d2.intValue() >= 0;
    }

    public static boolean J(@NotNull MemberDescriptor memberDescriptor, @NotNull MemberDescriptor memberDescriptor2) {
        if (memberDescriptor == null) {
            a(57);
        }
        if (memberDescriptor2 == null) {
            a(58);
        }
        return !e70.g(memberDescriptor2.getVisibility()) && e70.h(memberDescriptor2, memberDescriptor);
    }

    public static <D extends CallableDescriptor> boolean K(@NotNull D d2, @NotNull D d3, boolean z, boolean z2) {
        if (d2 == null) {
            a(11);
        }
        if (d3 == null) {
            a(12);
        }
        if (d2.equals(d3) || !DescriptorEquivalenceForOverrides.INSTANCE.d(d2.getOriginal(), d3.getOriginal(), z, z2)) {
            CallableDescriptor original = d3.getOriginal();
            for (CallableDescriptor callableDescriptor : d70.d(d2)) {
                if (DescriptorEquivalenceForOverrides.INSTANCE.d(original, callableDescriptor, z, z2)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static void L(@NotNull CallableMemberDescriptor callableMemberDescriptor, @Nullable Function1<CallableMemberDescriptor, wt2> function1) {
        f70 f70Var;
        if (callableMemberDescriptor == null) {
            a(107);
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.getOverriddenDescriptors()) {
            if (callableMemberDescriptor2.getVisibility() == e70.INHERITED) {
                L(callableMemberDescriptor2, function1);
            }
        }
        if (callableMemberDescriptor.getVisibility() != e70.INHERITED) {
            return;
        }
        f70 h = h(callableMemberDescriptor);
        if (h == null) {
            if (function1 != null) {
                function1.invoke(callableMemberDescriptor);
            }
            f70Var = e70.PUBLIC;
        } else {
            f70Var = h;
        }
        if (callableMemberDescriptor instanceof bx1) {
            ((bx1) callableMemberDescriptor).u(f70Var);
            for (PropertyAccessorDescriptor propertyAccessorDescriptor : ((PropertyDescriptor) callableMemberDescriptor).getAccessors()) {
                L(propertyAccessorDescriptor, h == null ? null : function1);
            }
        } else if (callableMemberDescriptor instanceof AbstractC8316a) {
            ((AbstractC8316a) callableMemberDescriptor).D(f70Var);
        } else {
            ax1 ax1Var = (ax1) callableMemberDescriptor;
            ax1Var.i(f70Var);
            if (f70Var != ax1Var.getCorrespondingProperty().getVisibility()) {
                ax1Var.g(false);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <H> H M(@NotNull Collection<H> collection, @NotNull Function1<H, CallableDescriptor> function1) {
        List e0;
        if (collection == null) {
            a(78);
        }
        if (function1 == 0) {
            a(79);
        }
        if (collection.size() == 1) {
            H h = (H) C8212k.O(collection);
            if (h == null) {
                a(80);
            }
            return h;
        }
        ArrayList arrayList = new ArrayList(2);
        e0 = CollectionsKt___CollectionsKt.e0(collection, function1);
        H h2 = (H) C8212k.O(collection);
        CallableDescriptor callableDescriptor = (CallableDescriptor) function1.invoke(h2);
        for (H h3 : collection) {
            CallableDescriptor callableDescriptor2 = (CallableDescriptor) function1.invoke(h3);
            if (D(callableDescriptor2, e0)) {
                arrayList.add(h3);
            }
            if (C(callableDescriptor2, callableDescriptor) && !C(callableDescriptor, callableDescriptor2)) {
                h2 = h3;
            }
        }
        if (arrayList.isEmpty()) {
            if (h2 == null) {
                a(81);
            }
            return h2;
        } else if (arrayList.size() == 1) {
            H h4 = (H) C8212k.O(arrayList);
            if (h4 == null) {
                a(82);
            }
            return h4;
        } else {
            H h5 = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!dk0.b(((CallableDescriptor) function1.invoke(next)).getReturnType())) {
                    h5 = next;
                    break;
                }
            }
            if (h5 != null) {
                return h5;
            }
            H h6 = (H) C8212k.O(arrayList);
            if (h6 == null) {
                a(84);
            }
            return h6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x024f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0163 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r24) {
        /*
            Method dump skipped, instructions count: 1316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.a(int):void");
    }

    private static boolean b(@NotNull Collection<CallableMemberDescriptor> collection) {
        boolean H;
        if (collection == null) {
            a(63);
        }
        if (collection.size() < 2) {
            return true;
        }
        H = CollectionsKt___CollectionsKt.H(collection, new C8485c(collection.iterator().next().getContainingDeclaration()));
        return H;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r5, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r6, @org.jetbrains.annotations.NotNull kotlin.Pair<tb.hk1, tb.mj> r7) {
        /*
            r4 = this;
            if (r5 != 0) goto L7
            r0 = 49
            a(r0)
        L7:
            if (r6 != 0) goto Le
            r0 = 50
            a(r0)
        Le:
            if (r7 != 0) goto L15
            r0 = 51
            a(r0)
        L15:
            java.util.List r5 = r5.getUpperBounds()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List r6 = r6.getUpperBounds()
            r0.<init>(r6)
            int r6 = r5.size()
            int r1 = r0.size()
            r2 = 0
            if (r6 == r1) goto L2e
            return r2
        L2e:
            java.util.Iterator r5 = r5.iterator()
        L32:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L59
            java.lang.Object r6 = r5.next()
            tb.z71 r6 = (tb.z71) r6
            java.util.ListIterator r1 = r0.listIterator()
        L42:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r1.next()
            tb.z71 r3 = (tb.z71) r3
            boolean r3 = r4.d(r6, r3, r7)
            if (r3 == 0) goto L42
            r1.remove()
            goto L32
        L58:
            return r2
        L59:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.c(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor, kotlin.Pair):boolean");
    }

    private boolean d(@NotNull z71 z71Var, @NotNull z71 z71Var2, @NotNull Pair<hk1, mj> pair) {
        if (z71Var == null) {
            a(46);
        }
        if (z71Var2 == null) {
            a(47);
        }
        if (pair == null) {
            a(48);
        }
        if (a81.a(z71Var) && a81.a(z71Var2)) {
            return true;
        }
        return pair.getFirst().a(pair.getSecond(), z71Var.f(), z71Var2.f());
    }

    @Nullable
    private static OverrideCompatibilityInfo e(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        if ((callableDescriptor.getExtensionReceiverParameter() == null) != (callableDescriptor2.getExtensionReceiverParameter() == null)) {
            return OverrideCompatibilityInfo.d("Receiver presence mismatch");
        }
        if (callableDescriptor.getValueParameters().size() != callableDescriptor2.getValueParameters().size()) {
            return OverrideCompatibilityInfo.d("Value parameter number mismatch");
        }
        return null;
    }

    private static void f(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            a(15);
        }
        if (set == null) {
            a(16);
        }
        if (callableMemberDescriptor.getKind().isReal()) {
            set.add(callableMemberDescriptor);
        } else if (!callableMemberDescriptor.getOverriddenDescriptors().isEmpty()) {
            for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.getOverriddenDescriptors()) {
                f(callableMemberDescriptor2, set);
            }
        } else {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
    }

    private static List<z71> g(CallableDescriptor callableDescriptor) {
        ReceiverParameterDescriptor extensionReceiverParameter = callableDescriptor.getExtensionReceiverParameter();
        ArrayList arrayList = new ArrayList();
        if (extensionReceiverParameter != null) {
            arrayList.add(extensionReceiverParameter.getType());
        }
        for (ValueParameterDescriptor valueParameterDescriptor : callableDescriptor.getValueParameters()) {
            arrayList.add(valueParameterDescriptor.getType());
        }
        return arrayList;
    }

    @Nullable
    private static f70 h(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(108);
        }
        Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.getOverriddenDescriptors();
        f70 v = v(overriddenDescriptors);
        if (v == null) {
            return null;
        }
        if (callableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            for (CallableMemberDescriptor callableMemberDescriptor2 : overriddenDescriptors) {
                if (callableMemberDescriptor2.getModality() != Modality.ABSTRACT && !callableMemberDescriptor2.getVisibility().equals(v)) {
                    return null;
                }
            }
            return v;
        }
        return v.f();
    }

    @NotNull
    public static OverridingUtil i(@NotNull b81 b81Var, @NotNull KotlinTypeChecker.TypeConstructorEquality typeConstructorEquality) {
        if (b81Var == null) {
            a(2);
        }
        if (typeConstructorEquality == null) {
            a(3);
        }
        return new OverridingUtil(typeConstructorEquality, b81Var);
    }

    private static void j(@NotNull Collection<CallableMemberDescriptor> collection, @NotNull ClassDescriptor classDescriptor, @NotNull gp1 gp1Var) {
        if (collection == null) {
            a(85);
        }
        if (classDescriptor == null) {
            a(86);
        }
        if (gp1Var == null) {
            a(87);
        }
        Collection<CallableMemberDescriptor> u = u(classDescriptor, collection);
        boolean isEmpty = u.isEmpty();
        if (!isEmpty) {
            collection = u;
        }
        CallableMemberDescriptor copy = ((CallableMemberDescriptor) M(collection, new C8486d())).copy(classDescriptor, o(collection, classDescriptor), isEmpty ? e70.INVISIBLE_FAKE : e70.INHERITED, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        gp1Var.d(copy, collection);
        gp1Var.a(copy);
    }

    private static void k(@NotNull ClassDescriptor classDescriptor, @NotNull Collection<CallableMemberDescriptor> collection, @NotNull gp1 gp1Var) {
        if (classDescriptor == null) {
            a(64);
        }
        if (collection == null) {
            a(65);
        }
        if (gp1Var == null) {
            a(66);
        }
        if (b(collection)) {
            for (CallableMemberDescriptor callableMemberDescriptor : collection) {
                j(Collections.singleton(callableMemberDescriptor), classDescriptor, gp1Var);
            }
            return;
        }
        LinkedList linkedList = new LinkedList(collection);
        while (!linkedList.isEmpty()) {
            j(r(vy2.a(linkedList), linkedList, gp1Var), classDescriptor, gp1Var);
        }
    }

    @NotNull
    private Pair<hk1, mj> l(@NotNull List<TypeParameterDescriptor> list, @NotNull List<TypeParameterDescriptor> list2) {
        if (list == null) {
            a(40);
        }
        if (list2 == null) {
            a(41);
        }
        return new Pair<>(new hk1(this.a, KotlinTypePreparator.C8547a.INSTANCE), m(list, list2));
    }

    @NotNull
    private mj m(@NotNull List<TypeParameterDescriptor> list, @NotNull List<TypeParameterDescriptor> list2) {
        if (list == null) {
            a(42);
        }
        if (list2 == null) {
            a(43);
        }
        if (list.isEmpty()) {
            mj mjVar = (mj) new hp1(null, this.b, this.a).b(true, true);
            if (mjVar == null) {
                a(44);
            }
            return mjVar;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            hashMap.put(list.get(i).getTypeConstructor(), list2.get(i).getTypeConstructor());
        }
        mj mjVar2 = (mj) new hp1(hashMap, this.b, this.a).b(true, true);
        if (mjVar2 == null) {
            a(45);
        }
        return mjVar2;
    }

    @NotNull
    public static OverridingUtil n(@NotNull b81 b81Var) {
        if (b81Var == null) {
            a(1);
        }
        return new OverridingUtil(d, b81Var);
    }

    @NotNull
    private static Modality o(@NotNull Collection<CallableMemberDescriptor> collection, @NotNull ClassDescriptor classDescriptor) {
        if (collection == null) {
            a(88);
        }
        if (classDescriptor == null) {
            a(89);
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            int i = C8490h.c[callableMemberDescriptor.getModality().ordinal()];
            if (i == 1) {
                Modality modality = Modality.FINAL;
                if (modality == null) {
                    a(90);
                }
                return modality;
            } else if (i == 2) {
                throw new IllegalStateException("Member cannot have SEALED modality: " + callableMemberDescriptor);
            } else if (i == 3) {
                z2 = true;
            } else if (i == 4) {
                z3 = true;
            }
        }
        if (classDescriptor.isExpect() && classDescriptor.getModality() != Modality.ABSTRACT && classDescriptor.getModality() != Modality.SEALED) {
            z = true;
        }
        if (z2 && !z3) {
            Modality modality2 = Modality.OPEN;
            if (modality2 == null) {
                a(91);
            }
            return modality2;
        } else if (!z2 && z3) {
            Modality modality3 = z ? classDescriptor.getModality() : Modality.ABSTRACT;
            if (modality3 == null) {
                a(92);
            }
            return modality3;
        } else {
            HashSet hashSet = new HashSet();
            for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
                hashSet.addAll(A(callableMemberDescriptor2));
            }
            return z(s(hashSet), z, classDescriptor.getModality());
        }
    }

    private Collection<CallableMemberDescriptor> p(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Collection<? extends CallableMemberDescriptor> collection, @NotNull ClassDescriptor classDescriptor, @NotNull gp1 gp1Var) {
        if (callableMemberDescriptor == null) {
            a(59);
        }
        if (collection == null) {
            a(60);
        }
        if (classDescriptor == null) {
            a(61);
        }
        if (gp1Var == null) {
            a(62);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        yd2 a = yd2.a();
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            OverrideCompatibilityInfo.Result c2 = E(callableMemberDescriptor2, callableMemberDescriptor, classDescriptor).c();
            boolean J = J(callableMemberDescriptor, callableMemberDescriptor2);
            int i = C8490h.b[c2.ordinal()];
            if (i == 1) {
                if (J) {
                    a.add(callableMemberDescriptor2);
                }
                arrayList.add(callableMemberDescriptor2);
            } else if (i == 2) {
                if (J) {
                    gp1Var.c(callableMemberDescriptor2, callableMemberDescriptor);
                }
                arrayList.add(callableMemberDescriptor2);
            }
        }
        gp1Var.d(callableMemberDescriptor, a);
        return arrayList;
    }

    @NotNull
    public static <H> Collection<H> q(@NotNull H h, @NotNull Collection<H> collection, @NotNull Function1<H, CallableDescriptor> function1, @NotNull Function1<H, wt2> function12) {
        if (h == null) {
            a(99);
        }
        if (collection == null) {
            a(100);
        }
        if (function1 == null) {
            a(101);
        }
        if (function12 == null) {
            a(102);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h);
        CallableDescriptor invoke = function1.invoke(h);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            CallableDescriptor invoke2 = function1.invoke(next);
            if (h == next) {
                it.remove();
            } else {
                OverrideCompatibilityInfo.Result y = y(invoke, invoke2);
                if (y == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (y == OverrideCompatibilityInfo.Result.CONFLICT) {
                    function12.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    @NotNull
    private static Collection<CallableMemberDescriptor> r(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Queue<CallableMemberDescriptor> queue, @NotNull gp1 gp1Var) {
        if (callableMemberDescriptor == null) {
            a(104);
        }
        if (queue == null) {
            a(105);
        }
        if (gp1Var == null) {
            a(106);
        }
        return q(callableMemberDescriptor, queue, new C8488f(), new C8489g(gp1Var, callableMemberDescriptor));
    }

    @NotNull
    public static <D extends CallableDescriptor> Set<D> s(@NotNull Set<D> set) {
        if (set == null) {
            a(6);
        }
        return t(set, !set.isEmpty() && DescriptorUtilsKt.q(DescriptorUtilsKt.l(set.iterator().next())), null, new C8484b());
    }

    @NotNull
    public static <D> Set<D> t(@NotNull Set<D> set, boolean z, @Nullable Function0<?> function0, @NotNull Function2<? super D, ? super D, Pair<CallableDescriptor, CallableDescriptor>> function2) {
        if (set == null) {
            a(7);
        }
        if (function2 == null) {
            a(8);
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (function0 != null) {
                function0.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (it.hasNext()) {
                    Pair<CallableDescriptor, CallableDescriptor> invoke = function2.invoke(obj, (Object) it.next());
                    CallableDescriptor component1 = invoke.component1();
                    CallableDescriptor component2 = invoke.component2();
                    if (K(component1, component2, z, true)) {
                        it.remove();
                    } else if (K(component2, component1, z, true)) {
                        break;
                    }
                } else {
                    linkedHashSet.add(obj);
                    break;
                }
            }
        }
        return linkedHashSet;
    }

    @NotNull
    private static Collection<CallableMemberDescriptor> u(@NotNull ClassDescriptor classDescriptor, @NotNull Collection<CallableMemberDescriptor> collection) {
        List N;
        if (classDescriptor == null) {
            a(96);
        }
        if (collection == null) {
            a(97);
        }
        N = CollectionsKt___CollectionsKt.N(collection, new C8487e(classDescriptor));
        if (N == null) {
            a(98);
        }
        return N;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static tb.f70 v(@org.jetbrains.annotations.NotNull java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> r5) {
        /*
            if (r5 != 0) goto L7
            r0 = 109(0x6d, float:1.53E-43)
            a(r0)
        L7:
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L10
            tb.f70 r5 = tb.e70.DEFAULT_VISIBILITY
            return r5
        L10:
            java.util.Iterator r0 = r5.iterator()
            r1 = 0
        L15:
            r2 = r1
        L16:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L38
            java.lang.Object r3 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r3
            tb.f70 r3 = r3.getVisibility()
            if (r2 != 0) goto L2a
        L28:
            r2 = r3
            goto L16
        L2a:
            java.lang.Integer r4 = tb.e70.d(r3, r2)
            if (r4 != 0) goto L31
            goto L15
        L31:
            int r4 = r4.intValue()
            if (r4 <= 0) goto L16
            goto L28
        L38:
            if (r2 != 0) goto L3b
            return r1
        L3b:
            java.util.Iterator r5 = r5.iterator()
        L3f:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L5c
            java.lang.Object r0 = r5.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0
            tb.f70 r0 = r0.getVisibility()
            java.lang.Integer r0 = tb.e70.d(r2, r0)
            if (r0 == 0) goto L5b
            int r0 = r0.intValue()
            if (r0 >= 0) goto L3f
        L5b:
            return r1
        L5c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.v(java.util.Collection):tb.f70");
    }

    @Nullable
    public static OverrideCompatibilityInfo x(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2) {
        boolean z;
        if (callableDescriptor == null) {
            a(38);
        }
        if (callableDescriptor2 == null) {
            a(39);
        }
        boolean z2 = callableDescriptor instanceof FunctionDescriptor;
        if ((!z2 || (callableDescriptor2 instanceof FunctionDescriptor)) && (!((z = callableDescriptor instanceof PropertyDescriptor)) || (callableDescriptor2 instanceof PropertyDescriptor))) {
            if (!z2 && !z) {
                throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + callableDescriptor);
            } else if (!callableDescriptor.getName().equals(callableDescriptor2.getName())) {
                return OverrideCompatibilityInfo.d("Name mismatch");
            } else {
                OverrideCompatibilityInfo e = e(callableDescriptor, callableDescriptor2);
                if (e != null) {
                    return e;
                }
                return null;
            }
        }
        return OverrideCompatibilityInfo.d("Member kind mismatch");
    }

    @Nullable
    public static OverrideCompatibilityInfo.Result y(CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        OverridingUtil overridingUtil = DEFAULT;
        OverrideCompatibilityInfo.Result c2 = overridingUtil.E(callableDescriptor2, callableDescriptor, null).c();
        OverrideCompatibilityInfo.Result c3 = overridingUtil.E(callableDescriptor, callableDescriptor2, null).c();
        OverrideCompatibilityInfo.Result result = OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (c2 == result && c3 == result) {
            return result;
        }
        OverrideCompatibilityInfo.Result result2 = OverrideCompatibilityInfo.Result.CONFLICT;
        return (c2 == result2 || c3 == result2) ? result2 : OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    }

    @NotNull
    private static Modality z(@NotNull Collection<CallableMemberDescriptor> collection, boolean z, @NotNull Modality modality) {
        if (collection == null) {
            a(93);
        }
        if (modality == null) {
            a(94);
        }
        Modality modality2 = Modality.ABSTRACT;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            Modality modality3 = (z && callableMemberDescriptor.getModality() == Modality.ABSTRACT) ? modality : callableMemberDescriptor.getModality();
            if (modality3.compareTo(modality2) < 0) {
                modality2 = modality3;
            }
        }
        if (modality2 == null) {
            a(95);
        }
        return modality2;
    }

    @NotNull
    public OverrideCompatibilityInfo E(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, @Nullable ClassDescriptor classDescriptor) {
        if (callableDescriptor == null) {
            a(17);
        }
        if (callableDescriptor2 == null) {
            a(18);
        }
        OverrideCompatibilityInfo F = F(callableDescriptor, callableDescriptor2, classDescriptor, false);
        if (F == null) {
            a(19);
        }
        return F;
    }

    @NotNull
    public OverrideCompatibilityInfo F(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, @Nullable ClassDescriptor classDescriptor, boolean z) {
        if (callableDescriptor == null) {
            a(20);
        }
        if (callableDescriptor2 == null) {
            a(21);
        }
        OverrideCompatibilityInfo G = G(callableDescriptor, callableDescriptor2, z);
        boolean z2 = G.c() == OverrideCompatibilityInfo.Result.OVERRIDABLE;
        for (ExternalOverridabilityCondition externalOverridabilityCondition : c) {
            if (externalOverridabilityCondition.getContract() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY && (!z2 || externalOverridabilityCondition.getContract() != ExternalOverridabilityCondition.Contract.SUCCESS_ONLY)) {
                int i = C8490h.a[externalOverridabilityCondition.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal()];
                if (i == 1) {
                    z2 = true;
                } else if (i == 2) {
                    OverrideCompatibilityInfo b = OverrideCompatibilityInfo.b("External condition failed");
                    if (b == null) {
                        a(22);
                    }
                    return b;
                } else if (i == 3) {
                    OverrideCompatibilityInfo d2 = OverrideCompatibilityInfo.d("External condition");
                    if (d2 == null) {
                        a(23);
                    }
                    return d2;
                }
            }
        }
        if (z2) {
            for (ExternalOverridabilityCondition externalOverridabilityCondition2 : c) {
                if (externalOverridabilityCondition2.getContract() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) {
                    int i2 = C8490h.a[externalOverridabilityCondition2.isOverridable(callableDescriptor, callableDescriptor2, classDescriptor).ordinal()];
                    if (i2 == 1) {
                        throw new IllegalStateException("Contract violation in " + externalOverridabilityCondition2.getClass().getName() + " condition. It's not supposed to end with success");
                    } else if (i2 == 2) {
                        OverrideCompatibilityInfo b2 = OverrideCompatibilityInfo.b("External condition failed");
                        if (b2 == null) {
                            a(25);
                        }
                        return b2;
                    } else if (i2 == 3) {
                        OverrideCompatibilityInfo d3 = OverrideCompatibilityInfo.d("External condition");
                        if (d3 == null) {
                            a(26);
                        }
                        return d3;
                    }
                }
            }
            OverrideCompatibilityInfo e = OverrideCompatibilityInfo.e();
            if (e == null) {
                a(27);
            }
            return e;
        }
        return G;
    }

    @NotNull
    public OverrideCompatibilityInfo G(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2, boolean z) {
        if (callableDescriptor == null) {
            a(28);
        }
        if (callableDescriptor2 == null) {
            a(29);
        }
        OverrideCompatibilityInfo x = x(callableDescriptor, callableDescriptor2);
        if (x != null) {
            return x;
        }
        List<z71> g = g(callableDescriptor);
        List<z71> g2 = g(callableDescriptor2);
        List<TypeParameterDescriptor> typeParameters = callableDescriptor.getTypeParameters();
        List<TypeParameterDescriptor> typeParameters2 = callableDescriptor2.getTypeParameters();
        int i = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i < g.size()) {
                if (!KotlinTypeChecker.DEFAULT.equalTypes(g.get(i), g2.get(i))) {
                    OverrideCompatibilityInfo d2 = OverrideCompatibilityInfo.d("Type parameter number mismatch");
                    if (d2 == null) {
                        a(31);
                    }
                    return d2;
                }
                i++;
            }
            OverrideCompatibilityInfo b = OverrideCompatibilityInfo.b("Type parameter number mismatch");
            if (b == null) {
                a(32);
            }
            return b;
        }
        Pair<hk1, mj> l = l(typeParameters, typeParameters2);
        for (int i2 = 0; i2 < typeParameters.size(); i2++) {
            if (!c(typeParameters.get(i2), typeParameters2.get(i2), l)) {
                OverrideCompatibilityInfo d3 = OverrideCompatibilityInfo.d("Type parameter bounds mismatch");
                if (d3 == null) {
                    a(33);
                }
                return d3;
            }
        }
        for (int i3 = 0; i3 < g.size(); i3++) {
            if (!d(g.get(i3), g2.get(i3), l)) {
                OverrideCompatibilityInfo d4 = OverrideCompatibilityInfo.d("Value parameter type mismatch");
                if (d4 == null) {
                    a(34);
                }
                return d4;
            }
        }
        if ((callableDescriptor instanceof FunctionDescriptor) && (callableDescriptor2 instanceof FunctionDescriptor) && ((FunctionDescriptor) callableDescriptor).isSuspend() != ((FunctionDescriptor) callableDescriptor2).isSuspend()) {
            OverrideCompatibilityInfo b2 = OverrideCompatibilityInfo.b("Incompatible suspendability");
            if (b2 == null) {
                a(35);
            }
            return b2;
        }
        if (z) {
            z71 returnType = callableDescriptor.getReturnType();
            z71 returnType2 = callableDescriptor2.getReturnType();
            if (returnType != null && returnType2 != null) {
                if (a81.a(returnType2) && a81.a(returnType)) {
                    i = 1;
                }
                if (i == 0 && !l.getFirst().c(l.getSecond(), returnType2.f(), returnType.f())) {
                    OverrideCompatibilityInfo b3 = OverrideCompatibilityInfo.b("Return type mismatch");
                    if (b3 == null) {
                        a(36);
                    }
                    return b3;
                }
            }
        }
        OverrideCompatibilityInfo e = OverrideCompatibilityInfo.e();
        if (e == null) {
            a(37);
        }
        return e;
    }

    public void w(@NotNull ni1 ni1Var, @NotNull Collection<? extends CallableMemberDescriptor> collection, @NotNull Collection<? extends CallableMemberDescriptor> collection2, @NotNull ClassDescriptor classDescriptor, @NotNull gp1 gp1Var) {
        if (ni1Var == null) {
            a(52);
        }
        if (collection == null) {
            a(53);
        }
        if (collection2 == null) {
            a(54);
        }
        if (classDescriptor == null) {
            a(55);
        }
        if (gp1Var == null) {
            a(56);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        for (CallableMemberDescriptor callableMemberDescriptor : collection2) {
            linkedHashSet.removeAll(p(callableMemberDescriptor, collection, classDescriptor, gp1Var));
        }
        k(classDescriptor, linkedHashSet, gp1Var);
    }
}
