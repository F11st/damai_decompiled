package tb;

import com.taobao.weex.bridge.WXBridgeManager;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class bk0 extends ak0 implements CustomTypeVariable {
    @NotNull
    public static final C8967a Companion = new C8967a(null);
    @JvmField
    public static boolean e;
    private boolean d;

    /* compiled from: Taobao */
    /* renamed from: tb.bk0$a */
    /* loaded from: classes3.dex */
    public static final class C8967a {
        private C8967a() {
        }

        public /* synthetic */ C8967a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bk0(@NotNull fd2 fd2Var, @NotNull fd2 fd2Var2) {
        super(fd2Var, fd2Var2);
        b41.i(fd2Var, "lowerBound");
        b41.i(fd2Var2, "upperBound");
    }

    private final void o() {
        if (!e || this.d) {
            return;
        }
        this.d = true;
        dk0.b(k());
        dk0.b(l());
        b41.d(k(), l());
        KotlinTypeChecker.DEFAULT.isSubtypeOf(k(), l());
    }

    @Override // tb.gu2
    @NotNull
    public gu2 g(boolean z) {
        return KotlinTypeFactory.d(k().j(z), l().j(z));
    }

    @Override // tb.gu2
    @NotNull
    public gu2 i(@NotNull Annotations annotations) {
        b41.i(annotations, "newAnnotations");
        return KotlinTypeFactory.d(k().k(annotations), l().k(annotations));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    public boolean isTypeVariable() {
        return (k().c().getDeclarationDescriptor() instanceof TypeParameterDescriptor) && b41.d(k().c(), l().c());
    }

    @Override // tb.ak0
    @NotNull
    public fd2 j() {
        o();
        return k();
    }

    @Override // tb.ak0
    @NotNull
    public String m(@NotNull DescriptorRenderer descriptorRenderer, @NotNull DescriptorRendererOptions descriptorRendererOptions) {
        b41.i(descriptorRenderer, "renderer");
        b41.i(descriptorRendererOptions, WXBridgeManager.OPTIONS);
        if (descriptorRendererOptions.getDebugMode()) {
            return '(' + descriptorRenderer.g(k()) + ".." + descriptorRenderer.g(l()) + ')';
        }
        return descriptorRenderer.d(descriptorRenderer.g(k()), descriptorRenderer.g(l()), TypeUtilsKt.h(this));
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: n */
    public ak0 h(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return new bk0((fd2) b81Var.g(k()), (fd2) b81Var.g(l()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.CustomTypeVariable
    @NotNull
    public z71 substitutionResult(@NotNull z71 z71Var) {
        gu2 d;
        b41.i(z71Var, "replacement");
        gu2 f = z71Var.f();
        if (f instanceof ak0) {
            d = f;
        } else if (!(f instanceof fd2)) {
            throw new NoWhenBranchMatchedException();
        } else {
            fd2 fd2Var = (fd2) f;
            d = KotlinTypeFactory.d(fd2Var, fd2Var.j(true));
        }
        return gr2.b(d, f);
    }

    @Override // tb.ak0
    @NotNull
    public String toString() {
        return '(' + k() + ".." + l() + ')';
    }
}
