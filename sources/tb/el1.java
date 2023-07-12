package tb;

import cn.damai.common.app.ShareperfenceConstants;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class el1 extends gp1 {
    @Override // tb.gp1
    public void b(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
        b41.i(callableMemberDescriptor, ShareperfenceConstants.FIRST);
        b41.i(callableMemberDescriptor2, "second");
        e(callableMemberDescriptor, callableMemberDescriptor2);
    }

    @Override // tb.gp1
    public void c(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
        b41.i(callableMemberDescriptor, "fromSuper");
        b41.i(callableMemberDescriptor2, "fromCurrent");
        e(callableMemberDescriptor, callableMemberDescriptor2);
    }

    protected abstract void e(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2);
}
