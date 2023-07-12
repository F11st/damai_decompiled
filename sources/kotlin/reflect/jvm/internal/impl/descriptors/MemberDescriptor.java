package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;
import tb.f70;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface MemberDescriptor extends DeclarationDescriptorNonRoot, DeclarationDescriptorWithVisibility {
    @NotNull
    Modality getModality();

    @NotNull
    f70 getVisibility();

    boolean isActual();

    boolean isExpect();

    boolean isExternal();
}
