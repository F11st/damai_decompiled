package tb;

import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class dr2 {

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.INVARIANT.ordinal()] = 1;
            iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static final TypeVariance a(@NotNull Variance variance) {
        b41.i(variance, "<this>");
        int i = a.$EnumSwitchMapping$0[variance.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return TypeVariance.OUT;
                }
                throw new NoWhenBranchMatchedException();
            }
            return TypeVariance.IN;
        }
        return TypeVariance.INV;
    }
}
