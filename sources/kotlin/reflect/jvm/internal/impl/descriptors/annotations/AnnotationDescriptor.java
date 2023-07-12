package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fn;
import tb.hp0;
import tb.kf0;
import tb.ni1;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface AnnotationDescriptor {

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor$a */
    /* loaded from: classes3.dex */
    public static final class C8301a {
        @Nullable
        public static hp0 a(@NotNull AnnotationDescriptor annotationDescriptor) {
            b41.i(annotationDescriptor, "this");
            ClassDescriptor f = DescriptorUtilsKt.f(annotationDescriptor);
            if (f == null) {
                return null;
            }
            if (kf0.r(f)) {
                f = null;
            }
            if (f == null) {
                return null;
            }
            return DescriptorUtilsKt.e(f);
        }
    }

    @NotNull
    Map<ni1, fn<?>> getAllValueArguments();

    @Nullable
    hp0 getFqName();

    @NotNull
    SourceElement getSource();

    @NotNull
    z71 getType();
}
