package com.alibaba.pictures.bricks.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class VoteActionRes implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String msg;
    public boolean voteResult;
    public VoteInfoBean voteVO;

    public boolean isShouldShowToast() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-563661049") ? ((Boolean) ipChange.ipc$dispatch("-563661049", new Object[]{this})).booleanValue() : (this.voteResult || TextUtils.isEmpty(this.msg)) ? false : true;
    }

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1824889886") ? ((Boolean) ipChange.ipc$dispatch("-1824889886", new Object[]{this})).booleanValue() : this.voteVO != null;
    }
}
