package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class e21 implements ImplicitReceiver, ThisClassReceiver {
    @NotNull
    private final ClassDescriptor a;
    @NotNull
    private final ClassDescriptor b;

    public e21(@NotNull ClassDescriptor classDescriptor, @Nullable e21 e21Var) {
        b41.i(classDescriptor, "classDescriptor");
        this.a = classDescriptor;
        this.b = classDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
    @NotNull
    /* renamed from: a */
    public fd2 getType() {
        fd2 defaultType = this.a.getDefaultType();
        b41.h(defaultType, "classDescriptor.defaultType");
        return defaultType;
    }

    public boolean equals(@Nullable Object obj) {
        ClassDescriptor classDescriptor = this.a;
        e21 e21Var = obj instanceof e21 ? (e21) obj : null;
        return b41.d(classDescriptor, e21Var != null ? e21Var.a : null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver
    @NotNull
    public final ClassDescriptor getClassDescriptor() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @NotNull
    public String toString() {
        return "Class{" + getType() + '}';
    }
}
