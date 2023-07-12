package com.alibaba.pictures.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistVideoInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String contentId;
    public String picUrl;
    public String videoTagUrl;
    public String videoTitle;
    public String videoUrl;

    public boolean isValid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "777309539") ? ((Boolean) ipChange.ipc$dispatch("777309539", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.videoUrl) && TextUtils.isEmpty(this.contentId)) ? false : true;
    }
}
