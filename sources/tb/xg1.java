package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class xg1 {
    @NotNull
    public static final MemberScope a(@NotNull ClassDescriptor classDescriptor, @NotNull br2 br2Var, @NotNull b81 b81Var) {
        b41.i(classDescriptor, "<this>");
        b41.i(br2Var, "typeSubstitution");
        b41.i(b81Var, "kotlinTypeRefiner");
        return wg1.Companion.a(classDescriptor, br2Var, b81Var);
    }

    @NotNull
    public static final MemberScope b(@NotNull ClassDescriptor classDescriptor, @NotNull b81 b81Var) {
        b41.i(classDescriptor, "<this>");
        b41.i(b81Var, "kotlinTypeRefiner");
        return wg1.Companion.b(classDescriptor, b81Var);
    }
}
