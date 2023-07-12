package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class f70 {
    @Nullable
    public final Integer a(@NotNull f70 f70Var) {
        b41.i(f70Var, "visibility");
        return b().a(f70Var.b());
    }

    @NotNull
    public abstract uy2 b();

    @NotNull
    public abstract String c();

    public final boolean d() {
        return b().c();
    }

    public abstract boolean e(@Nullable ReceiverValue receiverValue, @NotNull DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, @NotNull DeclarationDescriptor declarationDescriptor);

    @NotNull
    public abstract f70 f();

    @NotNull
    public final String toString() {
        return b().toString();
    }
}
