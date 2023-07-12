package tb;

import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.collections.AbstractC8186b;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@SinceKotlin(version = "1.4")
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
/* loaded from: classes3.dex */
public final class m7<E> extends AbstractC8186b<E> {
    @NotNull
    public static final C9432a Companion = new C9432a(null);
    @NotNull
    private static final Object[] a = new Object[0];

    /* compiled from: Taobao */
    /* renamed from: tb.m7$a */
    /* loaded from: classes3.dex */
    public static final class C9432a {
        private C9432a() {
        }

        public /* synthetic */ C9432a(k50 k50Var) {
            this();
        }

        public final int a(int i, int i2) {
            int i3 = i + (i >> 1);
            if (i3 - i2 < 0) {
                i3 = i2;
            }
            return i3 - 2147483639 > 0 ? i2 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i3;
        }
    }
}
