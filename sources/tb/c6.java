package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class c6 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(ClassDescriptor classDescriptor) {
        return b6.b().contains(DescriptorUtilsKt.i(classDescriptor)) || classDescriptor.getAnnotations().hasAnnotation(b6.f());
    }
}
