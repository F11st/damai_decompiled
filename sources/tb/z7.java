package tb;

import cn.damai.uikit.calendar.format.WeekDayFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class z7 implements WeekDayFormatter {
    private static transient /* synthetic */ IpChange $ipChange;
    private final CharSequence[] a;

    public z7(CharSequence[] charSequenceArr) {
        if (charSequenceArr != null) {
            if (charSequenceArr.length == 7) {
                this.a = charSequenceArr;
                return;
            }
            throw new IllegalArgumentException("Array must contain exactly 7 elements");
        }
        throw new IllegalArgumentException("Cannot be null");
    }

    @Override // cn.damai.uikit.calendar.format.WeekDayFormatter
    public CharSequence format(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-841881823") ? (CharSequence) ipChange.ipc$dispatch("-841881823", new Object[]{this, Integer.valueOf(i)}) : this.a[i - 1];
    }
}
