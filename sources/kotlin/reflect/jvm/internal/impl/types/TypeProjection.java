package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import org.jetbrains.annotations.NotNull;
import tb.b81;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface TypeProjection extends TypeArgumentMarker {
    @NotNull
    Variance getProjectionKind();

    @NotNull
    z71 getType();

    boolean isStarProjection();

    @NotNull
    TypeProjection refine(@NotNull b81 b81Var);
}
