package tb;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.List;
import kotlin.collections.C8214m;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class jf0 extends fd2 {
    @NotNull
    private final TypeConstructor b;
    @NotNull
    private final MemberScope c;
    @NotNull
    private final List<TypeProjection> d;
    private final boolean e;
    @NotNull
    private final String f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public jf0(@NotNull TypeConstructor typeConstructor, @NotNull MemberScope memberScope) {
        this(typeConstructor, memberScope, null, false, null, 28, null);
        b41.i(typeConstructor, "constructor");
        b41.i(memberScope, "memberScope");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public jf0(@NotNull TypeConstructor typeConstructor, @NotNull MemberScope memberScope, @NotNull List<? extends TypeProjection> list, boolean z) {
        this(typeConstructor, memberScope, list, z, null, 16, null);
        b41.i(typeConstructor, "constructor");
        b41.i(memberScope, "memberScope");
        b41.i(list, "arguments");
    }

    public /* synthetic */ jf0(TypeConstructor typeConstructor, MemberScope memberScope, List list, boolean z, String str, int i, k50 k50Var) {
        this(typeConstructor, memberScope, (i & 4) != 0 ? C8214m.g() : list, (i & 8) != 0 ? false : z, (i & 16) != 0 ? "???" : str);
    }

    @Override // tb.z71
    @NotNull
    public List<TypeProjection> b() {
        return this.d;
    }

    @Override // tb.z71
    @NotNull
    public TypeConstructor c() {
        return this.b;
    }

    @Override // tb.z71
    public boolean d() {
        return this.e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated
    @NotNull
    public Annotations getAnnotations() {
        return Annotations.Companion.b();
    }

    @Override // tb.z71
    @NotNull
    public MemberScope getMemberScope() {
        return this.c;
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: j */
    public fd2 g(boolean z) {
        return new jf0(c(), getMemberScope(), b(), z, null, 16, null);
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: k */
    public fd2 i(@NotNull Annotations annotations) {
        b41.i(annotations, "newAnnotations");
        return this;
    }

    @NotNull
    public String l() {
        return this.f;
    }

    @Override // tb.gu2
    @NotNull
    /* renamed from: m */
    public jf0 h(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return this;
    }

    @Override // tb.fd2
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(c());
        sb.append(b().isEmpty() ? "" : CollectionsKt___CollectionsKt.Y(b(), AVFSCacheConstants.COMMA_SEP, jn1.L, jn1.G, -1, "...", null));
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public jf0(@NotNull TypeConstructor typeConstructor, @NotNull MemberScope memberScope, @NotNull List<? extends TypeProjection> list, boolean z, @NotNull String str) {
        b41.i(typeConstructor, "constructor");
        b41.i(memberScope, "memberScope");
        b41.i(list, "arguments");
        b41.i(str, "presentableName");
        this.b = typeConstructor;
        this.c = memberScope;
        this.d = list;
        this.e = z;
        this.f = str;
    }
}
