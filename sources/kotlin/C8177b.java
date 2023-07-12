package kotlin;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: kotlin.b */
/* loaded from: classes3.dex */
public class C8177b {

    /* compiled from: Taobao */
    /* renamed from: kotlin.b$a */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C8178a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LazyThreadSafetyMode.values().length];
            iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
            iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
            iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public static <T> Lazy<T> a(@NotNull LazyThreadSafetyMode lazyThreadSafetyMode, @NotNull Function0<? extends T> function0) {
        b41.i(lazyThreadSafetyMode, "mode");
        b41.i(function0, "initializer");
        int i = C8178a.$EnumSwitchMapping$0[lazyThreadSafetyMode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return new UnsafeLazyImpl(function0);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new SafePublicationLazyImpl(function0);
        }
        return new SynchronizedLazyImpl(function0, null, 2, null);
    }

    @NotNull
    public static <T> Lazy<T> b(@NotNull Function0<? extends T> function0) {
        b41.i(function0, "initializer");
        return new SynchronizedLazyImpl(function0, null, 2, null);
    }
}
