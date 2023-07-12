package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fd2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface TypeAliasDescriptor extends ClassifierDescriptorWithTypeParameters {
    @Nullable
    ClassDescriptor getClassDescriptor();

    @NotNull
    fd2 getExpandedType();

    @NotNull
    fd2 getUnderlyingType();
}
