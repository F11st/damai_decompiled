package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ie0 extends jp1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ie0(@NotNull ModuleDescriptor moduleDescriptor, @NotNull hp0 hp0Var) {
        super(moduleDescriptor, hp0Var);
        b41.i(moduleDescriptor, "module");
        b41.i(hp0Var, "fqName");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor
    @NotNull
    /* renamed from: d */
    public MemberScope.C8499b getMemberScope() {
        return MemberScope.C8499b.INSTANCE;
    }
}
