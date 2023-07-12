package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class d6 extends fn<AnnotationDescriptor> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d6(@NotNull AnnotationDescriptor annotationDescriptor) {
        super(annotationDescriptor);
        b41.i(annotationDescriptor, "value");
    }

    @Override // tb.fn
    @NotNull
    public z71 a(@NotNull ModuleDescriptor moduleDescriptor) {
        b41.i(moduleDescriptor, "module");
        return b().getType();
    }
}
