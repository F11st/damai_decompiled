package cn.damai.commonbusiness.artist;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ArtistFollowResultBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String artistId;
    private int followStatus;
    public String targetType;

    public ArtistFollowResultBean() {
    }

    public String getArtistId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "864812175") ? (String) ipChange.ipc$dispatch("864812175", new Object[]{this}) : this.artistId;
    }

    public int getFollowStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-539868861") ? ((Integer) ipChange.ipc$dispatch("-539868861", new Object[]{this})).intValue() : this.followStatus;
    }

    public void setArtistId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1157045807")) {
            ipChange.ipc$dispatch("1157045807", new Object[]{this, str});
        } else {
            this.artistId = str;
        }
    }

    public void setFollowStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1099763521")) {
            ipChange.ipc$dispatch("-1099763521", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.followStatus = i;
        }
    }

    public ArtistFollowResultBean(String str, int i) {
        this.artistId = str;
        this.followStatus = i;
    }
}
