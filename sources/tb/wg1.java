package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class wg1 implements ClassDescriptor {
    @NotNull
    public static final C9867a Companion = new C9867a(null);

    /* compiled from: Taobao */
    /* renamed from: tb.wg1$a */
    /* loaded from: classes3.dex */
    public static final class C9867a {
        private C9867a() {
        }

        public /* synthetic */ C9867a(k50 k50Var) {
            this();
        }

        @NotNull
        public final MemberScope a(@NotNull ClassDescriptor classDescriptor, @NotNull br2 br2Var, @NotNull b81 b81Var) {
            b41.i(classDescriptor, "<this>");
            b41.i(br2Var, "typeSubstitution");
            b41.i(b81Var, "kotlinTypeRefiner");
            wg1 wg1Var = classDescriptor instanceof wg1 ? (wg1) classDescriptor : null;
            if (wg1Var == null) {
                MemberScope memberScope = classDescriptor.getMemberScope(br2Var);
                b41.h(memberScope, "this.getMemberScope(\n   …ubstitution\n            )");
                return memberScope;
            }
            return wg1Var.a(br2Var, b81Var);
        }

        @NotNull
        public final MemberScope b(@NotNull ClassDescriptor classDescriptor, @NotNull b81 b81Var) {
            b41.i(classDescriptor, "<this>");
            b41.i(b81Var, "kotlinTypeRefiner");
            wg1 wg1Var = classDescriptor instanceof wg1 ? (wg1) classDescriptor : null;
            if (wg1Var == null) {
                MemberScope unsubstitutedMemberScope = classDescriptor.getUnsubstitutedMemberScope();
                b41.h(unsubstitutedMemberScope, "this.unsubstitutedMemberScope");
                return unsubstitutedMemberScope;
            }
            return wg1Var.b(b81Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract MemberScope a(@NotNull br2 br2Var, @NotNull b81 b81Var);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract MemberScope b(@NotNull b81 b81Var);
}
