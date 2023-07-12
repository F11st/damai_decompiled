package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class n70 extends jp1 {
    @NotNull
    private final StorageManager g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n70(@NotNull hp0 hp0Var, @NotNull StorageManager storageManager, @NotNull ModuleDescriptor moduleDescriptor) {
        super(moduleDescriptor, hp0Var);
        b41.i(hp0Var, "fqName");
        b41.i(storageManager, "storageManager");
        b41.i(moduleDescriptor, "module");
        this.g = storageManager;
    }

    @NotNull
    public abstract ClassDataFinder d();

    public boolean e(@NotNull ni1 ni1Var) {
        b41.i(ni1Var, "name");
        MemberScope memberScope = getMemberScope();
        return (memberScope instanceof DeserializedMemberScope) && ((DeserializedMemberScope) memberScope).k().contains(ni1Var);
    }

    public abstract void f(@NotNull h70 h70Var);
}
