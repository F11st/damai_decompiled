package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.fd2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class a extends b {
    @NotNull
    private final Annotations c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull fd2 fd2Var, @NotNull Annotations annotations) {
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
    public a n(@NotNull fd2 fd2Var) {
        b41.i(fd2Var, "delegate");
        return new a(fd2Var, getAnnotations());
    }
}
