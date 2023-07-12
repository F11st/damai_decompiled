package com.alibaba.pictures.bricks.component.home;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class FollowStateBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String status;
    public String success;

    public boolean isFollowed() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2076883093") ? ((Boolean) ipChange.ipc$dispatch("2076883093", new Object[]{this})).booleanValue() : TextUtils.equals("1", this.status) || TextUtils.equals("2", this.status);
    }
}
