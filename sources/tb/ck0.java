package tb;

import com.taobao.weex.bridge.WXBridgeManager;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ck0 extends ak0 implements TypeWithEnhancement {
    @NotNull
    private final ak0 d;
    @NotNull
    private final z71 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck0(@NotNull ak0 ak0Var, @NotNull z71 z71Var) {
        super(ak0Var.k(), ak0Var.l());
        b41.i(ak0Var, "origin");
        b41.i(z71Var, "enhancement");
        this.d = ak0Var;
        this.e = z71Var;
    }

    @Override // tb.gu2
    @NotNull
    public gu2 g(boolean z) {
        return gr2.e(getOrigin().g(z), getEnhancement().f().g(z));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    @NotNull
    public z71 getEnhancement() {
        return this.e;
    }

    @Override // tb.gu2
    @NotNull
    public gu2 i(@NotNull Annotations annotations) {
        b41.i(annotations, "newAnnotations");
        return gr2.e(getOrigin().i(annotations), getEnhancement());
    }

    @Override // tb.ak0
    @NotNull
    public fd2 j() {
        return getOrigin().j();
    }

    @Override // tb.ak0
    @NotNull
    public String m(@NotNull DescriptorRenderer descriptorRenderer, @NotNull DescriptorRendererOptions descriptorRendererOptions) {
        b41.i(descriptorRenderer, "renderer");
        b41.i(descriptorRendererOptions, WXBridgeManager.OPTIONS);
        if (descriptorRendererOptions.getEnhancedTypes()) {
            return descriptorRenderer.g(getEnhancement());
        }
        return getOrigin().m(descriptorRenderer, descriptorRendererOptions);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancement
    @NotNull
    /* renamed from: n */
    public ak0 getOrigin() {
        return this.d;
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: o */
    public ck0 h(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return new ck0((ak0) b81Var.g(getOrigin()), b81Var.g(getEnhancement()));
    }
}
