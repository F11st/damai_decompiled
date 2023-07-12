package cn.damai.tetris.component.star.content.base.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ContentVideoBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public String contentVideoCoverUrl;
    public String contentVideoUrl;
    private String exclusive;
    private String picUrl;
    private String vid;
    private long videoTime;
    private String videoUrl;

    public String getExclusive() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1702175982") ? (String) ipChange.ipc$dispatch("-1702175982", new Object[]{this}) : this.exclusive;
    }

    public String getPicUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1219188679")) {
            return (String) ipChange.ipc$dispatch("1219188679", new Object[]{this});
        }
        if (!TextUtils.isEmpty(this.contentVideoCoverUrl)) {
            return this.contentVideoCoverUrl;
        }
        return this.picUrl;
    }

    public String getVid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "825778117") ? (String) ipChange.ipc$dispatch("825778117", new Object[]{this}) : this.vid;
    }

    public long getVideoTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1532707912") ? ((Long) ipChange.ipc$dispatch("-1532707912", new Object[]{this})).longValue() : this.videoTime;
    }

    public String getVideoUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "101798902")) {
            return (String) ipChange.ipc$dispatch("101798902", new Object[]{this});
        }
        if (!TextUtils.isEmpty(this.contentVideoUrl)) {
            return this.contentVideoUrl;
        }
        return this.videoUrl;
    }

    public void setExclusive(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1101914532")) {
            ipChange.ipc$dispatch("1101914532", new Object[]{this, str});
        } else {
            this.exclusive = str;
        }
    }

    public void setPicUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2040018679")) {
            ipChange.ipc$dispatch("2040018679", new Object[]{this, str});
        } else {
            this.picUrl = str;
        }
    }

    public void setVid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1247865937")) {
            ipChange.ipc$dispatch("1247865937", new Object[]{this, str});
        } else {
            this.vid = str;
        }
    }

    public void setVideoTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2100717068")) {
            ipChange.ipc$dispatch("-2100717068", new Object[]{this, Long.valueOf(j)});
        } else {
            this.videoTime = j;
        }
    }

    public void setVideoUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1021529176")) {
            ipChange.ipc$dispatch("-1021529176", new Object[]{this, str});
        } else {
            this.videoUrl = str;
        }
    }
}
