package tb;

import cn.damai.common.app.ShareperfenceConstants;
import com.youku.live.dago.liveplayback.ApiConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class f51 {
    @NotNull
    public static final f70 PACKAGE_VISIBILITY;
    @NotNull
    public static final f70 PROTECTED_AND_PACKAGE;
    @NotNull
    public static final f70 PROTECTED_STATIC_VISIBILITY;
    @NotNull
    private static final Map<uy2, f70> a;

    /* compiled from: Taobao */
    /* renamed from: tb.f51$a */
    /* loaded from: classes3.dex */
    static class C9127a extends m60 {
        C9127a(uy2 uy2Var) {
            super(uy2Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
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
            return f51.d(declarationDescriptorWithVisibility, declarationDescriptor);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.f51$b */
    /* loaded from: classes3.dex */
    static class C9128b extends m60 {
        C9128b(uy2 uy2Var) {
            super(uy2Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
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
            return f51.e(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.f51$c */
    /* loaded from: classes3.dex */
    static class C9129c extends m60 {
        C9129c(uy2 uy2Var) {
            super(uy2Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = ApiConstants.EventParams.WHAT;
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
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
            return f51.e(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
        }
    }

    static {
        C9127a c9127a = new C9127a(w51.INSTANCE);
        PACKAGE_VISIBILITY = c9127a;
        C9128b c9128b = new C9128b(y51.INSTANCE);
        PROTECTED_STATIC_VISIBILITY = c9128b;
        C9129c c9129c = new C9129c(x51.INSTANCE);
        PROTECTED_AND_PACKAGE = c9129c;
        a = new HashMap();
        f(c9127a);
        f(c9128b);
        f(c9129c);
    }

    private static /* synthetic */ void a(int i) {
        String str = (i == 5 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 5 || i == 6) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "from";
                break;
            case 2:
                objArr[0] = ShareperfenceConstants.FIRST;
                break;
            case 3:
                objArr[0] = "second";
                break;
            case 4:
                objArr[0] = "visibility";
                break;
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
                break;
            default:
                objArr[0] = ApiConstants.EventParams.WHAT;
                break;
        }
        if (i == 5 || i == 6) {
            objArr[1] = "toDescriptorVisibility";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        }
        if (i == 2 || i == 3) {
            objArr[2] = "areInSamePackage";
        } else if (i == 4) {
            objArr[2] = "toDescriptorVisibility";
        } else if (i != 5 && i != 6) {
            objArr[2] = "isVisibleForProtectedAndPackage";
        }
        String format = String.format(str, objArr);
        if (i != 5 && i != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(@NotNull DeclarationDescriptor declarationDescriptor, @NotNull DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            a(2);
        }
        if (declarationDescriptor2 == null) {
            a(3);
        }
        PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) d70.r(declarationDescriptor, PackageFragmentDescriptor.class, false);
        PackageFragmentDescriptor packageFragmentDescriptor2 = (PackageFragmentDescriptor) d70.r(declarationDescriptor2, PackageFragmentDescriptor.class, false);
        return (packageFragmentDescriptor2 == null || packageFragmentDescriptor == null || !packageFragmentDescriptor.getFqName().equals(packageFragmentDescriptor2.getFqName())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            a(0);
        }
        if (declarationDescriptor == null) {
            a(1);
        }
        if (d(d70.M(declarationDescriptorWithVisibility), declarationDescriptor)) {
            return true;
        }
        return e70.PROTECTED.e(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor);
    }

    private static void f(f70 f70Var) {
        a.put(f70Var.b(), f70Var);
    }

    @NotNull
    public static f70 g(@NotNull uy2 uy2Var) {
        if (uy2Var == null) {
            a(4);
        }
        f70 f70Var = a.get(uy2Var);
        if (f70Var == null) {
            f70 j = e70.j(uy2Var);
            if (j == null) {
                a(5);
            }
            return j;
        }
        return f70Var;
    }
}
