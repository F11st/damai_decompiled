package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class v13 extends z71 {
    public v13() {
        super(null);
    }

    @Override // tb.z71
    @NotNull
    public List<TypeProjection> b() {
        return g().b();
    }

    @Override // tb.z71
    @NotNull
    public TypeConstructor c() {
        return g().c();
    }

    @Override // tb.z71
    public boolean d() {
        return g().d();
    }

    @Override // tb.z71
    @NotNull
    public final gu2 f() {
        z71 g = g();
        while (g instanceof v13) {
            g = ((v13) g).g();
        }
        return (gu2) g;
    }

    @NotNull
    protected abstract z71 g();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return g().getAnnotations();
    }

    @Override // tb.z71
    @NotNull
    public MemberScope getMemberScope() {
        return g().getMemberScope();
    }

    public boolean h() {
        return true;
    }

    @NotNull
    public String toString() {
        return h() ? g().toString() : "<Not computed yet>";
    }
}
