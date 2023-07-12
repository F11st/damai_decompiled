package kotlin.ranges;

import java.lang.Comparable;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface ClosedRange<T extends Comparable<? super T>> {

    /* compiled from: Taobao */
    /* renamed from: kotlin.ranges.ClosedRange$a */
    /* loaded from: classes3.dex */
    public static final class C8240a {
        public static <T extends Comparable<? super T>> boolean a(@NotNull ClosedRange<T> closedRange, @NotNull T t) {
            b41.i(t, "value");
            return t.compareTo(closedRange.getStart()) >= 0 && t.compareTo(closedRange.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(@NotNull ClosedRange<T> closedRange) {
            return closedRange.getStart().compareTo(closedRange.getEndInclusive()) > 0;
        }
    }

    boolean contains(@NotNull T t);

    @NotNull
    T getEndInclusive();

    @NotNull
    T getStart();

    boolean isEmpty();
}
