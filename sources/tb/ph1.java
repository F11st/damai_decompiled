package tb;

import android.text.SpannableStringBuilder;
import cn.damai.uikit.calendar.CalendarDay;
import cn.damai.uikit.calendar.format.TitleFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ph1 implements TitleFormatter {
    private static transient /* synthetic */ IpChange $ipChange;
    private final CharSequence[] a;

    public ph1(CharSequence[] charSequenceArr) {
        if (charSequenceArr != null) {
            if (charSequenceArr.length >= 12) {
                this.a = charSequenceArr;
                return;
            }
            throw new IllegalArgumentException("Label array is too short");
        }
        throw new IllegalArgumentException("Label array cannot be null");
    }

    @Override // cn.damai.uikit.calendar.format.TitleFormatter
    public CharSequence format(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1140196690") ? (CharSequence) ipChange.ipc$dispatch("-1140196690", new Object[]{this, calendarDay}) : new SpannableStringBuilder().append(this.a[calendarDay.getMonth()]).append((CharSequence) " ").append((CharSequence) String.valueOf(calendarDay.getYear()));
    }
}
