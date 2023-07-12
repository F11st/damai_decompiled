package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.n31;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b\u001a\r\u0010\u0004\u001a\u00020\u0003*\u00020\u0001H\u0087\b\u001a%\u0010\n\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0086\n\u001a\u001d\u0010\n\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0086\n¨\u0006\r"}, d2 = {"", "Landroid/text/Spannable;", "toSpannable", "Ltb/wt2;", "clearSpans", "", "start", "end", "", "span", "set", "Ltb/n31;", "range", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SpannableStringKt {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(@NotNull Spannable spannable) {
        b41.i(spannable, "<this>");
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        b41.h(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(@NotNull Spannable spannable, int i, int i2, @NotNull Object obj) {
        b41.i(spannable, "<this>");
        b41.i(obj, "span");
        spannable.setSpan(obj, i, i2, 17);
    }

    @NotNull
    public static final Spannable toSpannable(@NotNull CharSequence charSequence) {
        b41.i(charSequence, "<this>");
        SpannableString valueOf = SpannableString.valueOf(charSequence);
        b41.h(valueOf, "valueOf(this)");
        return valueOf;
    }

    public static final void set(@NotNull Spannable spannable, @NotNull n31 n31Var, @NotNull Object obj) {
        b41.i(spannable, "<this>");
        b41.i(n31Var, "range");
        b41.i(obj, "span");
        spannable.setSpan(obj, n31Var.getStart().intValue(), n31Var.getEndInclusive().intValue(), 17);
    }
}
