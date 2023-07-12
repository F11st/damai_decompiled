package cn.damai.tetris.component.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ActorBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String artistId;
    private String damaiId;
    private String description;
    private String headPic;
    private String name;
    private String subtype;

    public String getArtistId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "282345800") ? (String) ipChange.ipc$dispatch("282345800", new Object[]{this}) : this.artistId;
    }

    public String getDescription() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1004154924") ? (String) ipChange.ipc$dispatch("1004154924", new Object[]{this}) : this.description;
    }

    public String getHeadPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-181243078") ? (String) ipChange.ipc$dispatch("-181243078", new Object[]{this}) : this.headPic;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-16064495") ? (String) ipChange.ipc$dispatch("-16064495", new Object[]{this}) : this.name;
    }

    public String getSubtype() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1985489194") ? (String) ipChange.ipc$dispatch("1985489194", new Object[]{this}) : this.subtype;
    }

    public void setArtistId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "280457366")) {
            ipChange.ipc$dispatch("280457366", new Object[]{this, str});
        } else {
            this.artistId = str;
        }
    }

    public void setDescription(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1235919670")) {
            ipChange.ipc$dispatch("-1235919670", new Object[]{this, str});
        } else {
            this.description = str;
        }
    }

    public void setHeadPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1355145596")) {
            ipChange.ipc$dispatch("1355145596", new Object[]{this, str});
        } else {
            this.headPic = str;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-790756115")) {
            ipChange.ipc$dispatch("-790756115", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public void setSubtype(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-195630708")) {
            ipChange.ipc$dispatch("-195630708", new Object[]{this, str});
        } else {
            this.subtype = str;
        }
    }
}
