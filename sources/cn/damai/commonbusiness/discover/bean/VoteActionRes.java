package cn.damai.commonbusiness.discover.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class VoteActionRes implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String msg;
    public boolean voteResult;
    public VoteInfoBean voteVO;

    public boolean isShouldShowToast() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1573347834") ? ((Boolean) ipChange.ipc$dispatch("-1573347834", new Object[]{this})).booleanValue() : (this.voteResult || TextUtils.isEmpty(this.msg)) ? false : true;
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "305245601") ? ((Boolean) ipChange.ipc$dispatch("305245601", new Object[]{this})).booleanValue() : this.voteVO != null;
    }
}
