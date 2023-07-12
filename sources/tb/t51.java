package tb;

import java.util.EnumMap;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class t51 {
    @NotNull
    private final EnumMap<AnnotationQualifierApplicabilityType, c51> a;

    public t51(@NotNull EnumMap<AnnotationQualifierApplicabilityType, c51> enumMap) {
        b41.i(enumMap, "defaultQualifiers");
        this.a = enumMap;
    }

    @Nullable
    public final c51 a(@Nullable AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return this.a.get(annotationQualifierApplicabilityType);
    }

    @NotNull
    public final EnumMap<AnnotationQualifierApplicabilityType, c51> b() {
        return this.a;
    }
}
