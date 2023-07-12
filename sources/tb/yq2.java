package tb;

import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public abstract class yq2 implements TypeProjection {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TypeProjection) {
            TypeProjection typeProjection = (TypeProjection) obj;
            return isStarProjection() == typeProjection.isStarProjection() && getProjectionKind() == typeProjection.getProjectionKind() && getType().equals(typeProjection.getType());
        }
        return false;
    }

    public int hashCode() {
        int hashCode = getProjectionKind().hashCode();
        if (fr2.w(getType())) {
            return (hashCode * 31) + 19;
        }
        return (hashCode * 31) + (isStarProjection() ? 17 : getType().hashCode());
    }

    public String toString() {
        if (isStarProjection()) {
            return jn1.MUL;
        }
        if (getProjectionKind() == Variance.INVARIANT) {
            return getType().toString();
        }
        return getProjectionKind() + " " + getType();
    }
}
