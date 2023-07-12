package cn.damai.user.star.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class Videos implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public int index;
    public String picUrl;
    public String title;
    public String type;
    public String vid;

    public String getPicUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-508985879") ? (String) ipChange.ipc$dispatch("-508985879", new Object[]{this}) : this.picUrl;
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-452139030") ? (String) ipChange.ipc$dispatch("-452139030", new Object[]{this}) : this.title;
    }

    public String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1719196510") ? (String) ipChange.ipc$dispatch("1719196510", new Object[]{this}) : this.type;
    }

    public String getVid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1389280483") ? (String) ipChange.ipc$dispatch("1389280483", new Object[]{this}) : this.vid;
    }

    public void setPicUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "6214933")) {
            ipChange.ipc$dispatch("6214933", new Object[]{this, str});
        } else {
            this.picUrl = str;
        }
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1359959500")) {
            ipChange.ipc$dispatch("1359959500", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }

    public void setType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1462727488")) {
            ipChange.ipc$dispatch("1462727488", new Object[]{this, str});
        } else {
            this.type = str;
        }
    }

    public void setVid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1536570099")) {
            ipChange.ipc$dispatch("1536570099", new Object[]{this, str});
        } else {
            this.vid = str;
        }
    }
}
