package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.b81;
import tb.xf2;
import tb.yq2;
import tb.z71;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class StarProjectionImpl extends yq2 {
    @NotNull
    private final TypeParameterDescriptor a;
    @NotNull
    private final Lazy b;

    public StarProjectionImpl(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        Lazy a;
        b41.i(typeParameterDescriptor, "typeParameter");
        this.a = typeParameterDescriptor;
        a = kotlin.b.a(LazyThreadSafetyMode.PUBLICATION, new Function0<z71>() { // from class: kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl$_type$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final z71 invoke() {
                TypeParameterDescriptor typeParameterDescriptor2;
                typeParameterDescriptor2 = StarProjectionImpl.this.a;
                return xf2.b(typeParameterDescriptor2);
            }
        });
        this.b = a;
    }

    private final z71 b() {
        return (z71) this.b.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public z71 getType() {
        return b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public TypeProjection refine(@NotNull b81 b81Var) {
        b41.i(b81Var, "kotlinTypeRefiner");
        return this;
    }
}
