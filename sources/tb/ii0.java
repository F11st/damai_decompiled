package tb;

import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ii0 extends y5 implements FieldDescriptor {
    @NotNull
    private final PropertyDescriptor b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ii0(@NotNull Annotations annotations, @NotNull PropertyDescriptor propertyDescriptor) {
        super(annotations);
        b41.i(annotations, "annotations");
        b41.i(propertyDescriptor, "correspondingProperty");
        this.b = propertyDescriptor;
    }
}
