package com.youku.live.messagechannel.channel;

import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MCChannelInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    @NonNull
    public long appId;
    @NonNull
    public String channelId;
    @NonNull
    public long serverTime;
    @NonNull
    public CDNInfo CDNInfo = new CDNInfo();
    @NonNull
    public PMInfo PMInfo = new PMInfo();
    @NonNull
    public MASSInfo MASSInfo = new MASSInfo();

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "464641860")) {
            return (String) ipChange.ipc$dispatch("464641860", new Object[]{this});
        }
        return "MCChannelInfo{appId=" + this.appId + ", channelId='" + this.channelId + "', serverTime=" + this.serverTime + ", CDNInfo=" + this.CDNInfo.toString() + ", PMInfo=" + this.PMInfo.toString() + ", MASSInfo=" + this.MASSInfo.toString() + '}';
    }
}
