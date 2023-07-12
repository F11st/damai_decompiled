package tb;

import com.taobao.weex.bridge.WXBridgeManager;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ld0 extends ak0 implements DynamicTypeMarker {
    @NotNull
    private final Annotations d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ld0(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.builtins.AbstractC8271b r3, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations r4) {
        /*
            r2 = this;
            java.lang.String r0 = "builtIns"
            tb.b41.i(r3, r0)
            java.lang.String r0 = "annotations"
            tb.b41.i(r4, r0)
            tb.fd2 r0 = r3.H()
            java.lang.String r1 = "builtIns.nothingType"
            tb.b41.h(r0, r1)
            tb.fd2 r3 = r3.I()
            java.lang.String r1 = "builtIns.nullableAnyType"
            tb.b41.h(r3, r1)
            r2.<init>(r0, r3)
            r2.d = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.ld0.<init>(kotlin.reflect.jvm.internal.impl.builtins.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations):void");
    }

    @Override // tb.ak0, tb.z71
    public boolean d() {
        return false;
    }

    @Override // tb.ak0, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.d;
    }

    @Override // tb.ak0
    @NotNull
    public fd2 j() {
        return l();
    }

    @Override // tb.ak0
    @NotNull
    public String m(@NotNull DescriptorRenderer descriptorRenderer, @NotNull DescriptorRendererOptions descriptorRendererOptions) {
        b41.i(descriptorRenderer, "renderer");
        b41.i(descriptorRendererOptions, WXBridgeManager.OPTIONS);
        return lu2.DYNAMIC;
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: n */
    public ld0 g(boolean z) {
        return this;
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: o */
    public ld0 h(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return this;
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: p */
    public ld0 i(@NotNull Annotations annotations) {
        b41.i(annotations, "newAnnotations");
        return new ld0(TypeUtilsKt.h(j()), annotations);
    }
}
