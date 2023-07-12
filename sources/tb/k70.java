package tb;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class k70 implements Annotations {
    static final /* synthetic */ KProperty<Object>[] b = {a12.i(new PropertyReference1Impl(a12.b(k70.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    @NotNull
    private final NotNullLazyValue a;

    public k70(@NotNull StorageManager storageManager, @NotNull Function0<? extends List<? extends AnnotationDescriptor>> function0) {
        b41.i(storageManager, "storageManager");
        b41.i(function0, "compute");
        this.a = storageManager.createLazyValue(function0);
    }

    private final List<AnnotationDescriptor> a() {
        return (List) tg2.a(this.a, this, b[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    @Nullable
    public AnnotationDescriptor findAnnotation(@NotNull hp0 hp0Var) {
        return Annotations.C8304b.a(this, hp0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean hasAnnotation(@NotNull hp0 hp0Var) {
        return Annotations.C8304b.b(this, hp0Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations
    public boolean isEmpty() {
        return a().isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<AnnotationDescriptor> iterator() {
        return a().iterator();
    }
}
