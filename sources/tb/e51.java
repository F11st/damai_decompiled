package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class e51 {
    public static final boolean a(@NotNull PropertyDescriptor propertyDescriptor) {
        b41.i(propertyDescriptor, "<this>");
        return propertyDescriptor.getGetter() == null;
    }
}
