package com.alibaba.pictures.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistHeadBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public ArtistInfo artistInfo;
    public String followStatus;
    public ArtistVideoInfo videoInfo;

    public boolean isUnFollow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "106520802") ? ((Boolean) ipChange.ipc$dispatch("106520802", new Object[]{this})).booleanValue() : TextUtils.isEmpty(this.followStatus) || "0".equalsIgnoreCase(this.followStatus);
    }

    public void setFollowed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1166423654")) {
            ipChange.ipc$dispatch("1166423654", new Object[]{this});
        } else {
            this.followStatus = "1";
        }
    }
}
