package tb;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.core.internal.view.SupportMenu;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class p40 {
    public static void a(SpannableStringBuilder spannableStringBuilder, String str, String str2, Object obj, Object obj2) {
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str).append(jn1.CONDITION_IF_MIDDLE);
        if (obj == null) {
            obj = new ForegroundColorSpan(-3355444);
        }
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        int length2 = spannableStringBuilder.length();
        if (str2 == null) {
            str2 = "Null";
        }
        spannableStringBuilder.append((CharSequence) str2).append('\n');
        int i = str2 == null ? SupportMenu.CATEGORY_MASK : -7829368;
        if (obj2 == null) {
            obj2 = new ForegroundColorSpan(i);
        }
        spannableStringBuilder.setSpan(obj2, length2, spannableStringBuilder.length(), 33);
    }
}
