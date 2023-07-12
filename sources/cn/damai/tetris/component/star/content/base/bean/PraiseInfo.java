package cn.damai.tetris.component.star.content.base.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class PraiseInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean hasPraised;
    private int praiseCount;

    public boolean getHasPraised() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "349795516") ? ((Boolean) ipChange.ipc$dispatch("349795516", new Object[]{this})).booleanValue() : this.hasPraised;
    }

    public int getPraiseCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1910423228") ? ((Integer) ipChange.ipc$dispatch("-1910423228", new Object[]{this})).intValue() : this.praiseCount;
    }

    public void setHasPraised(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1313619240")) {
            ipChange.ipc$dispatch("1313619240", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.hasPraised = z;
        }
    }

    public void setPraiseCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1826485574")) {
            ipChange.ipc$dispatch("1826485574", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.praiseCount = i;
        }
    }
}
