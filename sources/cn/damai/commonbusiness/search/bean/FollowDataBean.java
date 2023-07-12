package cn.damai.commonbusiness.search.bean;

import cn.damai.tetris.component.rank.bean.RankItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class FollowDataBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int FOLLOW_STATUS_SUCCESS = 1;
    private int status;
    public RankItemBean tempRank = null;

    public int getStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-404490508") ? ((Integer) ipChange.ipc$dispatch("-404490508", new Object[]{this})).intValue() : this.status;
    }

    public void setStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1119857198")) {
            ipChange.ipc$dispatch("1119857198", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.status = i;
        }
    }
}
