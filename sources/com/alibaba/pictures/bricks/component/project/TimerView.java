package com.alibaba.pictures.bricks.component.project;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer;
import com.alibaba.pictures.bricks.component.project.bean.DaojishiListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TimerView extends LinearLayout implements WeakRefCountDownTimer.OnTickListener, DaojishiListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long DAY = 86400000;
    private static final long HOUR = 3600000;
    private static final long MINUTE = 60000;
    protected long days;
    protected long hour;
    protected Context mContext;
    protected long mDiffTime;
    protected View mPartentView;
    protected TextView mPerformTime;
    protected String mSaleTime;
    protected TextView mTimeDay;
    protected TextView mTimeDayLabel;
    protected TextView mTimeHour;
    protected TextView mTimeHourLabel;
    protected TextView mTimeMin;
    protected TextView mTimeMinLabel;
    protected TextView mTimeSec;
    protected TextView mTimerIcon;
    protected LinearLayout mTimerLayout;
    protected long mUpTime;
    boolean mVisibleGoneAfterTimeout;
    protected long min;
    protected long sec;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.component.project.TimerView$a */
    /* loaded from: classes7.dex */
    public static class C3490a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;

        public C3490a(String str, String str2, String str3, String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }
    }

    public TimerView(Context context) {
        this(context, null);
    }

    public static String getConcatText(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1682857300")) {
            return (String) ipChange.ipc$dispatch("1682857300", new Object[]{Long.valueOf(j)});
        }
        if (j < 10) {
            return "0" + j;
        }
        return "" + j;
    }

    @NonNull
    public static C3490a getDateResult(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "800211614")) {
            return (C3490a) ipChange.ipc$dispatch("800211614", new Object[]{Long.valueOf(j)});
        }
        long j2 = j / 86400000;
        long j3 = j % 86400000;
        long j4 = j3 / 3600000;
        long j5 = j3 % 3600000;
        return new C3490a(getConcatText(j2), getConcatText(j4), getConcatText(j5 / 60000), getConcatText((j5 % 60000) / 1000));
    }

    public LinearLayout getTimerLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1118091673") ? (LinearLayout) ipChange.ipc$dispatch("1118091673", new Object[]{this}) : this.mTimerLayout;
    }

    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-624573434")) {
            ipChange.ipc$dispatch("-624573434", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.bricks_layout_search_timer, this);
        this.mPartentView = inflate;
        this.mTimerLayout = (LinearLayout) inflate.findViewById(R$id.ll_timer);
        this.mTimerIcon = (TextView) this.mPartentView.findViewById(R$id.tv_perform_time_icon);
        this.mPerformTime = (TextView) this.mPartentView.findViewById(R$id.tv_perform_time);
        this.mTimeDay = (TextView) this.mPartentView.findViewById(R$id.tv_timer_day);
        this.mTimeDayLabel = (TextView) this.mPartentView.findViewById(R$id.tv_timer_day_mark);
        this.mTimeHour = (TextView) this.mPartentView.findViewById(R$id.tv_timer_hour);
        this.mTimeHourLabel = (TextView) this.mPartentView.findViewById(R$id.tv_timer_hour_label);
        this.mTimeMin = (TextView) this.mPartentView.findViewById(R$id.tv_timer_min);
        this.mTimeMinLabel = (TextView) this.mPartentView.findViewById(R$id.tv_timer_min_label);
        this.mTimeSec = (TextView) this.mPartentView.findViewById(R$id.tv_timer_sec);
    }

    public void loadTimeData(String str, long j, long j2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1294268808")) {
            ipChange.ipc$dispatch("1294268808", new Object[]{this, str, Long.valueOf(j), Long.valueOf(j2)});
            return;
        }
        this.mSaleTime = str;
        this.mUpTime = j;
        this.mDiffTime = j2;
        if (this.mPerformTime != null) {
            if (!TextUtils.isEmpty(str)) {
                TextView textView = this.mPerformTime;
                textView.setText(str + "开抢");
            } else {
                this.mPerformTime.setText("");
            }
        }
        long elapsedRealtime = ((j - j2) - SystemClock.elapsedRealtime()) / 1000;
        if (elapsedRealtime <= 0) {
            this.mTimeDay.setText("00");
            this.mTimeHour.setText("00");
            this.mTimeMin.setText("00");
            this.mTimeSec.setText("00");
            return;
        }
        long j3 = elapsedRealtime / 86400;
        this.days = j3;
        if (j3 >= 0) {
            Long.signum(j3);
            elapsedRealtime -= 86400 * j3;
        }
        long j4 = elapsedRealtime / 3600;
        this.hour = j4;
        long j5 = elapsedRealtime - (j4 * 3600);
        long j6 = j5 / 60;
        this.min = j6;
        this.sec = j5 - (j6 * 60);
        if (j3 < 10) {
            TextView textView2 = this.mTimeDay;
            textView2.setText("0" + this.days);
        } else {
            TextView textView3 = this.mTimeDay;
            textView3.setText("" + this.days);
        }
        if (this.hour < 10) {
            TextView textView4 = this.mTimeHour;
            textView4.setText("0" + this.hour);
        } else {
            TextView textView5 = this.mTimeHour;
            textView5.setText("" + this.hour);
        }
        if (this.min < 10) {
            TextView textView6 = this.mTimeMin;
            textView6.setText("0" + this.min);
        } else {
            TextView textView7 = this.mTimeMin;
            textView7.setText("" + this.min);
        }
        if (this.sec < 10) {
            TextView textView8 = this.mTimeSec;
            textView8.setText("0" + this.sec);
            return;
        }
        TextView textView9 = this.mTimeSec;
        textView9.setText("" + this.sec);
    }

    public void markBricksStyle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1664545923")) {
            ipChange.ipc$dispatch("-1664545923", new Object[]{this});
            return;
        }
        this.mTimerIcon.setVisibility(0);
        this.mTimerLayout.setBackgroundResource(R$drawable.bricks_timer_red_bg);
        int color = getResources().getColor(R$color.bricks_color_primary_red);
        this.mPerformTime.setTextColor(color);
        this.mTimeDay.setTextColor(color);
        this.mTimeDayLabel.setTextColor(color);
        this.mTimeHour.setTextColor(color);
        this.mTimeHourLabel.setTextColor(color);
        this.mTimeMin.setTextColor(color);
        this.mTimeMinLabel.setTextColor(color);
        this.mTimeSec.setTextColor(color);
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1838293143")) {
            ipChange.ipc$dispatch("-1838293143", new Object[]{this});
        } else if (this.mVisibleGoneAfterTimeout) {
            setVisibility(8);
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.WeakRefCountDownTimer.OnTickListener
    public void onTick(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1025851077")) {
            ipChange.ipc$dispatch("1025851077", new Object[]{this, Long.valueOf(j)});
            return;
        }
        C3490a dateResult = getDateResult(j);
        this.mTimeDay.setText(dateResult.a);
        this.mTimeHour.setText(dateResult.b);
        this.mTimeMin.setText(dateResult.c);
        this.mTimeSec.setText(dateResult.d);
    }

    public void setPerformTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-363909127")) {
            ipChange.ipc$dispatch("-363909127", new Object[]{this, str});
        } else {
            setPerformTime(str, "开抢");
        }
    }

    public void setTimeUp() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "218348069")) {
            ipChange.ipc$dispatch("218348069", new Object[]{this});
            return;
        }
        this.mTimeDay.setText("00");
        this.mTimeHour.setText("00");
        this.mTimeMin.setText("00");
        this.mTimeSec.setText("00");
    }

    public void setVisibleGoneAfterTimeout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1941436921")) {
            ipChange.ipc$dispatch("-1941436921", new Object[]{this});
        } else {
            this.mVisibleGoneAfterTimeout = true;
        }
    }

    @Override // com.alibaba.pictures.bricks.component.project.bean.DaojishiListener
    public void updateView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "111080621")) {
            ipChange.ipc$dispatch("111080621", new Object[]{this});
        } else {
            loadTimeData(this.mSaleTime, this.mUpTime, this.mDiffTime);
        }
    }

    public TimerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setPerformTime(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778363779")) {
            ipChange.ipc$dispatch("1778363779", new Object[]{this, str, str2});
        } else if (this.mPerformTime == null) {
        } else {
            if (!TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str2)) {
                    str = str + str2;
                }
                this.mPerformTime.setText(str);
                return;
            }
            this.mPerformTime.setText("");
        }
    }

    public TimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVisibleGoneAfterTimeout = false;
        this.mContext = context;
        initView();
    }
}
