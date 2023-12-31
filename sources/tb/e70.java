package tb;

import com.youku.live.dago.liveplayback.ApiConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ty2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class e70 {
    public static final ReceiverValue ALWAYS_SUITABLE_RECEIVER;
    public static final f70 DEFAULT_VISIBILITY;
    @Deprecated
    public static final ReceiverValue FALSE_IF_PROTECTED;
    @NotNull
    public static final f70 INHERITED;
    @NotNull
    public static final f70 INTERNAL;
    @NotNull
    public static final f70 INVISIBLE_FAKE;
    public static final Set<f70> INVISIBLE_FROM_OTHER_MODULES;
    @NotNull
    public static final f70 LOCAL;
    @NotNull
    public static final f70 PRIVATE;
    @NotNull
    public static final f70 PRIVATE_TO_THIS;
    @NotNull
    public static final f70 PROTECTED;
    @NotNull
    public static final f70 PUBLIC;
    @NotNull
    public static final f70 UNKNOWN;
    private static final Map<f70, Integer> a;
    private static final ReceiverValue b;
    @NotNull
    private static final ModuleVisibilityHelper c;
    @NotNull
    private static final Map<uy2, f70> d;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class a implements ReceiverValue {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
        @NotNull
        public z71 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class b implements ReceiverValue {
        b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
        @NotNull
        public z71 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class c implements ReceiverValue {
        c() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
        @NotNull
        public z71 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class d extends m60 {
        d(uy2 uy2Var) {
            super(uy2Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else if (i != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i == 1 || i == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(@NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                g(0);
            }
            return d70.j(declarationDescriptor) != SourceFile.NO_SOURCE_FILE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility] */
        /* JADX WARN: Type inference failed for: r5v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
        /* JADX WARN: Type inference failed for: r5v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
        /* JADX WARN: Type inference failed for: r5v4, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
        @Override // tb.f70
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == 0) {
                g(1);
            }
            if (declarationDescriptor == null) {
                g(2);
            }
            if (d70.J(declarationDescriptorWithVisibility) && h(declarationDescriptor)) {
                return e70.f(declarationDescriptorWithVisibility, declarationDescriptor);
            }
            if (declarationDescriptorWithVisibility instanceof ConstructorDescriptor) {
                ClassifierDescriptorWithTypeParameters containingDeclaration = ((ConstructorDescriptor) declarationDescriptorWithVisibility).getContainingDeclaration();
                if (d70.G(containingDeclaration) && d70.J(containingDeclaration) && (declarationDescriptor instanceof ConstructorDescriptor) && d70.J(declarationDescriptor.getContainingDeclaration()) && e70.f(declarationDescriptorWithVisibility, declarationDescriptor)) {
                    return true;
                }
            }
            while (declarationDescriptorWithVisibility != 0) {
                declarationDescriptorWithVisibility = declarationDescriptorWithVisibility.getContainingDeclaration();
                if (declarationDescriptorWithVisibility instanceof ClassDescriptor) {
                    if (!d70.x(declarationDescriptorWithVisibility)) {
                        break;
                    }
                }
                if (declarationDescriptorWithVisibility instanceof PackageFragmentDescriptor) {
                    break;
                }
            }
            if (declarationDescriptorWithVisibility == 0) {
                return false;
            }
            while (declarationDescriptor != null) {
                if (declarationDescriptorWithVisibility == declarationDescriptor) {
                    return true;
                }
                if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                    return (declarationDescriptorWithVisibility instanceof PackageFragmentDescriptor) && declarationDescriptorWithVisibility.getFqName().equals(((PackageFragmentDescriptor) declarationDescriptor).getFqName()) && d70.b(declarationDescriptor, declarationDescriptorWithVisibility);
                }
                declarationDescriptor = declarationDescriptor.getContainingDeclaration();
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class e extends m60 {
        e(uy2 uy2Var) {
            super(uy2Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // tb.f70
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            DeclarationDescriptor q;
            if (declarationDescriptorWithVisibility == null) {
                g(0);
            }
            if (declarationDescriptor == null) {
                g(1);
            }
            if (e70.PRIVATE.e(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor)) {
                if (receiverValue == e70.ALWAYS_SUITABLE_RECEIVER) {
                    return true;
                }
                if (receiverValue != e70.b && (q = d70.q(declarationDescriptorWithVisibility, ClassDescriptor.class)) != null && (receiverValue instanceof ThisClassReceiver)) {
                    return ((ThisClassReceiver) receiverValue).getClassDescriptor().getOriginal().equals(q.getOriginal());
                }
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class f extends m60 {
        f(uy2 uy2Var) {
            super(uy2Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "from";
            } else if (i == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i != 3) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i == 2 || i == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean h(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull ClassDescriptor classDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                g(2);
            }
            if (classDescriptor == null) {
                g(3);
            }
            if (receiverValue == e70.FALSE_IF_PROTECTED) {
                return false;
            }
            if (!(declarationDescriptorWithVisibility instanceof CallableMemberDescriptor) || (declarationDescriptorWithVisibility instanceof ConstructorDescriptor) || receiverValue == e70.ALWAYS_SUITABLE_RECEIVER) {
                return true;
            }
            if (receiverValue == e70.b || receiverValue == null) {
                return false;
            }
            z71 thisType = receiverValue instanceof SuperCallReceiverValue ? ((SuperCallReceiverValue) receiverValue).getThisType() : receiverValue.getType();
            return d70.I(thisType, classDescriptor) || md0.a(thisType);
        }

        @Override // tb.f70
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            ClassDescriptor classDescriptor;
            if (declarationDescriptorWithVisibility == null) {
                g(0);
            }
            if (declarationDescriptor == null) {
                g(1);
            }
            ClassDescriptor classDescriptor2 = (ClassDescriptor) d70.q(declarationDescriptorWithVisibility, ClassDescriptor.class);
            ClassDescriptor classDescriptor3 = (ClassDescriptor) d70.r(declarationDescriptor, ClassDescriptor.class, false);
            if (classDescriptor3 == null) {
                return false;
            }
            if (classDescriptor2 == null || !d70.x(classDescriptor2) || (classDescriptor = (ClassDescriptor) d70.q(classDescriptor2, ClassDescriptor.class)) == null || !d70.H(classDescriptor3, classDescriptor)) {
                DeclarationDescriptorWithVisibility M = d70.M(declarationDescriptorWithVisibility);
                ClassDescriptor classDescriptor4 = (ClassDescriptor) d70.q(M, ClassDescriptor.class);
                if (classDescriptor4 == null) {
                    return false;
                }
                if (d70.H(classDescriptor3, classDescriptor4) && h(receiverValue, M, classDescriptor3)) {
                    return true;
                }
                return e(receiverValue, declarationDescriptorWithVisibility, classDescriptor3.getContainingDeclaration());
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class g extends m60 {
        g(uy2 uy2Var) {
            super(uy2Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // tb.f70
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                g(0);
            }
            if (declarationDescriptor == null) {
                g(1);
            }
            if (d70.g(declarationDescriptor).shouldSeeInternalsOf(d70.g(declarationDescriptorWithVisibility))) {
                return e70.c.isInFriendModule(declarationDescriptorWithVisibility, declarationDescriptor);
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class h extends m60 {
        h(uy2 uy2Var) {
            super(uy2Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // tb.f70
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                g(0);
            }
            if (declarationDescriptor == null) {
                g(1);
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class i extends m60 {
        i(uy2 uy2Var) {
            super(uy2Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // tb.f70
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                g(0);
            }
            if (declarationDescriptor == null) {
                g(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class j extends m60 {
        j(uy2 uy2Var) {
            super(uy2Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // tb.f70
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                g(0);
            }
            if (declarationDescriptor == null) {
                g(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class k extends m60 {
        k(uy2 uy2Var) {
            super(uy2Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // tb.f70
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                g(0);
            }
            if (declarationDescriptor == null) {
                g(1);
            }
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class l extends m60 {
        l(uy2 uy2Var) {
            super(uy2Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // tb.f70
        public boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                g(0);
            }
            if (declarationDescriptor == null) {
                g(1);
            }
            return false;
        }
    }

    static {
        Set g2;
        d dVar = new d(ty2.e.INSTANCE);
        PRIVATE = dVar;
        e eVar = new e(ty2.f.INSTANCE);
        PRIVATE_TO_THIS = eVar;
        f fVar = new f(ty2.g.INSTANCE);
        PROTECTED = fVar;
        g gVar = new g(ty2.b.INSTANCE);
        INTERNAL = gVar;
        h hVar = new h(ty2.h.INSTANCE);
        PUBLIC = hVar;
        i iVar = new i(ty2.d.INSTANCE);
        LOCAL = iVar;
        j jVar = new j(ty2.a.INSTANCE);
        INHERITED = jVar;
        k kVar = new k(ty2.c.INSTANCE);
        INVISIBLE_FAKE = kVar;
        l lVar = new l(ty2.i.INSTANCE);
        UNKNOWN = lVar;
        g2 = kotlin.collections.e0.g(dVar, eVar, gVar, iVar);
        INVISIBLE_FROM_OTHER_MODULES = Collections.unmodifiableSet(g2);
        HashMap e2 = kk.e(4);
        e2.put(eVar, 0);
        e2.put(dVar, 0);
        e2.put(gVar, 1);
        e2.put(fVar, 1);
        e2.put(hVar, 2);
        a = Collections.unmodifiableMap(e2);
        DEFAULT_VISIBILITY = hVar;
        b = new a();
        ALWAYS_SUITABLE_RECEIVER = new b();
        FALSE_IF_PROTECTED = new c();
        Iterator it = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        c = it.hasNext() ? (ModuleVisibilityHelper) it.next() : ModuleVisibilityHelper.a.INSTANCE;
        d = new HashMap();
        i(dVar);
        i(eVar);
        i(fVar);
        i(gVar);
        i(hVar);
        i(iVar);
        i(jVar);
        i(kVar);
        i(lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r8) {
        /*
            r0 = 16
            if (r8 == r0) goto L7
            java.lang.String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L9
        L7:
            java.lang.String r1 = "@NotNull method %s.%s must not return null"
        L9:
            r2 = 3
            r3 = 2
            if (r8 == r0) goto Lf
            r4 = 3
            goto L10
        Lf:
            r4 = 2
        L10:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities"
            r6 = 1
            r7 = 0
            if (r8 == r6) goto L3a
            if (r8 == r2) goto L3a
            r2 = 5
            if (r8 == r2) goto L3a
            r2 = 7
            if (r8 == r2) goto L3a
            switch(r8) {
                case 9: goto L3a;
                case 10: goto L35;
                case 11: goto L30;
                case 12: goto L35;
                case 13: goto L30;
                case 14: goto L2b;
                case 15: goto L2b;
                case 16: goto L28;
                default: goto L23;
            }
        L23:
            java.lang.String r2 = "what"
            r4[r7] = r2
            goto L3e
        L28:
            r4[r7] = r5
            goto L3e
        L2b:
            java.lang.String r2 = "visibility"
            r4[r7] = r2
            goto L3e
        L30:
            java.lang.String r2 = "second"
            r4[r7] = r2
            goto L3e
        L35:
            java.lang.String r2 = "first"
            r4[r7] = r2
            goto L3e
        L3a:
            java.lang.String r2 = "from"
            r4[r7] = r2
        L3e:
            java.lang.String r2 = "toDescriptorVisibility"
            if (r8 == r0) goto L45
            r4[r6] = r5
            goto L47
        L45:
            r4[r6] = r2
        L47:
            switch(r8) {
                case 2: goto L70;
                case 3: goto L70;
                case 4: goto L6b;
                case 5: goto L6b;
                case 6: goto L66;
                case 7: goto L66;
                case 8: goto L61;
                case 9: goto L61;
                case 10: goto L5c;
                case 11: goto L5c;
                case 12: goto L57;
                case 13: goto L57;
                case 14: goto L52;
                case 15: goto L4f;
                case 16: goto L74;
                default: goto L4a;
            }
        L4a:
            java.lang.String r2 = "isVisible"
            r4[r3] = r2
            goto L74
        L4f:
            r4[r3] = r2
            goto L74
        L52:
            java.lang.String r2 = "isPrivate"
            r4[r3] = r2
            goto L74
        L57:
            java.lang.String r2 = "compare"
            r4[r3] = r2
            goto L74
        L5c:
            java.lang.String r2 = "compareLocal"
            r4[r3] = r2
            goto L74
        L61:
            java.lang.String r2 = "findInvisibleMember"
            r4[r3] = r2
            goto L74
        L66:
            java.lang.String r2 = "inSameFile"
            r4[r3] = r2
            goto L74
        L6b:
            java.lang.String r2 = "isVisibleWithAnyReceiver"
            r4[r3] = r2
            goto L74
        L70:
            java.lang.String r2 = "isVisibleIgnoringReceiver"
            r4[r3] = r2
        L74:
            java.lang.String r1 = java.lang.String.format(r1, r4)
            if (r8 == r0) goto L80
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r1)
            goto L85
        L80:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
        L85:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.e70.a(int):void");
    }

    @Nullable
    public static Integer d(@NotNull f70 f70Var, @NotNull f70 f70Var2) {
        if (f70Var == null) {
            a(12);
        }
        if (f70Var2 == null) {
            a(13);
        }
        Integer a2 = f70Var.a(f70Var2);
        if (a2 != null) {
            return a2;
        }
        Integer a3 = f70Var2.a(f70Var);
        if (a3 != null) {
            return Integer.valueOf(-a3.intValue());
        }
        return null;
    }

    @Nullable
    public static DeclarationDescriptorWithVisibility e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptorWithVisibility e2;
        if (declarationDescriptorWithVisibility == null) {
            a(8);
        }
        if (declarationDescriptor == null) {
            a(9);
        }
        for (DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) declarationDescriptorWithVisibility.getOriginal(); declarationDescriptorWithVisibility2 != null && declarationDescriptorWithVisibility2.getVisibility() != LOCAL; declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) d70.q(declarationDescriptorWithVisibility2, DeclarationDescriptorWithVisibility.class)) {
            if (!declarationDescriptorWithVisibility2.getVisibility().e(receiverValue, declarationDescriptorWithVisibility2, declarationDescriptor)) {
                return declarationDescriptorWithVisibility2;
            }
        }
        if (!(declarationDescriptorWithVisibility instanceof TypeAliasConstructorDescriptor) || (e2 = e(receiverValue, ((TypeAliasConstructorDescriptor) declarationDescriptorWithVisibility).getUnderlyingConstructorDescriptor(), declarationDescriptor)) == null) {
            return null;
        }
        return e2;
    }

    public static boolean f(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            a(6);
        }
        if (declarationDescriptor2 == null) {
            a(7);
        }
        SourceFile j2 = d70.j(declarationDescriptor2);
        if (j2 != SourceFile.NO_SOURCE_FILE) {
            return j2.equals(d70.j(declarationDescriptor));
        }
        return false;
    }

    public static boolean g(@NotNull f70 f70Var) {
        if (f70Var == null) {
            a(14);
        }
        return f70Var == PRIVATE || f70Var == PRIVATE_TO_THIS;
    }

    public static boolean h(@NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            a(2);
        }
        if (declarationDescriptor == null) {
            a(3);
        }
        return e(ALWAYS_SUITABLE_RECEIVER, declarationDescriptorWithVisibility, declarationDescriptor) == null;
    }

    private static void i(f70 f70Var) {
        d.put(f70Var.b(), f70Var);
    }

    @NotNull
    public static f70 j(@NotNull uy2 uy2Var) {
        if (uy2Var == null) {
            a(15);
        }
        f70 f70Var = d.get(uy2Var);
        if (f70Var != null) {
            return f70Var;
        }
        throw new IllegalArgumentException("Inapplicable visibility: " + uy2Var);
    }
}
