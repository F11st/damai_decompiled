package tb;

import kotlin.SinceKotlin;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@SinceKotlin(version = "1.4")
/* loaded from: classes3.dex */
public final class xq2 implements KTypeParameter {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: Taobao */
        /* renamed from: tb.xq2$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public /* synthetic */ class C0465a {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[KVariance.values().length];
                iArr[KVariance.INVARIANT.ordinal()] = 1;
                iArr[KVariance.IN.ordinal()] = 2;
                iArr[KVariance.OUT.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }

        @NotNull
        public final String a(@NotNull KTypeParameter kTypeParameter) {
            b41.i(kTypeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i = C0465a.$EnumSwitchMapping$0[kTypeParameter.getVariance().ordinal()];
            if (i == 2) {
                sb.append("in ");
            } else if (i == 3) {
                sb.append("out ");
            }
            sb.append(kTypeParameter.getName());
            String sb2 = sb.toString();
            b41.h(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }
}
