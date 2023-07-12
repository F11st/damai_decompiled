package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class ak0 extends gu2 implements FlexibleTypeMarker {
    @NotNull
    private final fd2 b;
    @NotNull
    private final fd2 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak0(@NotNull fd2 fd2Var, @NotNull fd2 fd2Var2) {
        super(null);
        b41.i(fd2Var, "lowerBound");
        b41.i(fd2Var2, "upperBound");
        this.b = fd2Var;
        this.c = fd2Var2;
    }

    @Override // tb.z71
    @NotNull
    public List<TypeProjection> b() {
        return j().b();
    }

    @Override // tb.z71
    @NotNull
    public TypeConstructor c() {
        return j().c();
    }

    @Override // tb.z71
    public boolean d() {
        return j().d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return j().getAnnotations();
    }

    @Override // tb.z71
    @NotNull
    public MemberScope getMemberScope() {
        return j().getMemberScope();
    }

    @NotNull
    public abstract fd2 j();

    @NotNull
    public final fd2 k() {
        return this.b;
    }

    @NotNull
    public final fd2 l() {
        return this.c;
    }

    @NotNull
    public abstract String m(@NotNull DescriptorRenderer descriptorRenderer, @NotNull DescriptorRendererOptions descriptorRendererOptions);

    @NotNull
    public String toString() {
        return DescriptorRenderer.DEBUG_TEXT.g(this);
    }
}
