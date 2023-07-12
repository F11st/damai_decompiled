package cn.damai.commonbusiness.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class SimpleTimerView extends TimerView {
    private static transient /* synthetic */ IpChange $ipChange;

    public SimpleTimerView(Context context) {
        super(context);
    }

    @Override // com.alibaba.pictures.bricks.component.project.TimerView
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "921755706")) {
            ipChange.ipc$dispatch("921755706", new Object[]{this});
            return;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.layout_search_timer_simple, this);
        this.mPartentView = inflate;
        this.mTimerLayout = (LinearLayout) inflate.findViewById(R$id.ll_timer);
        this.mTimeDay = (TextView) this.mPartentView.findViewById(R$id.tv_timer_day);
        this.mTimeDayLabel = (TextView) this.mPartentView.findViewById(R$id.tv_timer_day_mark);
        this.mTimeHour = (TextView) this.mPartentView.findViewById(R$id.tv_timer_hour);
        this.mTimeHourLabel = (TextView) this.mPartentView.findViewById(R$id.tv_timer_hour_label);
        this.mTimeMin = (TextView) this.mPartentView.findViewById(R$id.tv_timer_min);
        this.mTimeMinLabel = (TextView) this.mPartentView.findViewById(R$id.tv_timer_min_label);
        this.mTimeSec = (TextView) this.mPartentView.findViewById(R$id.tv_timer_sec);
    }

    public SimpleTimerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SimpleTimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
