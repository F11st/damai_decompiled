package tb;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class bu2 extends jf0 {
    @NotNull
    private final String g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu2(@NotNull String str, @NotNull TypeConstructor typeConstructor, @NotNull MemberScope memberScope, @NotNull List<? extends TypeProjection> list, boolean z) {
        super(typeConstructor, memberScope, list, z, null, 16, null);
        b41.i(str, "presentableName");
        b41.i(typeConstructor, "constructor");
        b41.i(memberScope, "memberScope");
        b41.i(list, "arguments");
        this.g = str;
    }

    @Override // tb.jf0, tb.gu2
    @NotNull
    /* renamed from: j */
    public fd2 g(boolean z) {
        return new bu2(l(), c(), getMemberScope(), b(), z);
    }

    @Override // tb.jf0
    @NotNull
    public String l() {
        return this.g;
    }

    @Override // tb.jf0
    @NotNull
    /* renamed from: n */
    public bu2 m(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return this;
    }
}
