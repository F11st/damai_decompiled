package cn.damai.uikit.calendar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.appcompat.widget.AppCompatTextView;
import cn.damai.uikit.calendar.format.WeekDayFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;
import tb.qf;

/* compiled from: Taobao */
@Experimental
@SuppressLint({"ViewConstructor"})
/* loaded from: classes8.dex */
public class WeekDayView extends AppCompatTextView {
    private static transient /* synthetic */ IpChange $ipChange;
    private int dayOfWeek;
    private WeekDayFormatter formatter;

    public WeekDayView(Context context, int i) {
        super(context);
        this.formatter = WeekDayFormatter.DEFAULT;
        setGravity(17);
        if (Build.VERSION.SDK_INT >= 17) {
            setTextAlignment(4);
        }
        setDayOfWeek(i);
    }

    public void setDayOfWeek(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "265993255")) {
            ipChange.ipc$dispatch("265993255", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.dayOfWeek = i;
        setText(this.formatter.format(i));
    }

    public void setWeekDayFormatter(WeekDayFormatter weekDayFormatter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686931531")) {
            ipChange.ipc$dispatch("686931531", new Object[]{this, weekDayFormatter});
            return;
        }
        if (weekDayFormatter == null) {
            weekDayFormatter = WeekDayFormatter.DEFAULT;
        }
        this.formatter = weekDayFormatter;
        setDayOfWeek(this.dayOfWeek);
    }

    public void setDayOfWeek(Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "164290349")) {
            ipChange.ipc$dispatch("164290349", new Object[]{this, calendar});
        } else {
            setDayOfWeek(qf.c(calendar));
        }
    }
}
