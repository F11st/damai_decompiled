package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.fd2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.reflect.jvm.internal.impl.types.a */
/* loaded from: classes3.dex */
public final class C8543a extends AbstractC8544b {
    @NotNull
    private final Annotations c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8543a(@NotNull fd2 fd2Var, @NotNull Annotations annotations) {
        super(fd2Var);
        b41.i(fd2Var, "delegate");
        b41.i(annotations, "annotations");
        this.c = annotations;
    }

    @Override // tb.p60, kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return this.c;
    }

    @Override // tb.p60
    @NotNull
    /* renamed from: p */
    public C8543a n(@NotNull fd2 fd2Var) {
        b41.i(fd2Var, "delegate");
        return new C8543a(fd2Var, getAnnotations());
    }
}
