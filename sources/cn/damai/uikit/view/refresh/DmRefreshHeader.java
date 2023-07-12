package cn.damai.uikit.view.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import cn.damai.uikit.irecycler.widget.PullToRefreshHeaderView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DmRefreshHeader extends FrameLayout implements RefreshHeader {
    private static transient /* synthetic */ IpChange $ipChange;
    PullToRefreshHeaderView headerView;

    public DmRefreshHeader(Context context) {
        this(context, null);
    }

    @Override // cn.damai.uikit.view.refresh.RefreshHeader
    public void complete() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680853779")) {
            ipChange.ipc$dispatch("-680853779", new Object[]{this});
        } else {
            this.headerView.onComplete();
        }
    }

    @Override // cn.damai.uikit.view.refresh.RefreshHeader
    public void onPositionChange(float f, float f2, float f3, boolean z, State state) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1542344412")) {
            ipChange.ipc$dispatch("-1542344412", new Object[]{this, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z), state});
        } else if (f < f3 && f2 >= f3) {
            if (z) {
                State state2 = State.PULL;
            }
        } else if (f <= f3 || f2 > f3 || !z || state != State.PULL) {
        } else {
            this.headerView.onMove(false, false, 10000);
        }
    }

    @Override // cn.damai.uikit.view.refresh.RefreshHeader
    public void pull() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-273144095")) {
            ipChange.ipc$dispatch("-273144095", new Object[]{this});
        }
    }

    @Override // cn.damai.uikit.view.refresh.RefreshHeader
    public void refreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1545985535")) {
            ipChange.ipc$dispatch("1545985535", new Object[]{this});
            return;
        }
        this.headerView.onMove(false, false, 10000);
        this.headerView.onRefresh();
    }

    @Override // cn.damai.uikit.view.refresh.RefreshHeader
    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1805834731")) {
            ipChange.ipc$dispatch("-1805834731", new Object[]{this});
        } else {
            this.headerView.onReset();
        }
    }

    public DmRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.headerView = PullToRefreshHeaderView.getInstance(context);
        addView(this.headerView, new LinearLayout.LayoutParams(-1, q60.a(context, 70.0f)));
    }
}
