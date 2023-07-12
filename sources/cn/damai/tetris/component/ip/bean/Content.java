package cn.damai.tetris.component.ip.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class Content implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String content;
    private String headImg;
    private long id;
    private int isFeature;
    private String nickname;
    private String pic;
    private VideoInfo videoInfo;

    public String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-603697231") ? (String) ipChange.ipc$dispatch("-603697231", new Object[]{this}) : this.content;
    }

    public String getHeadImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "702060539") ? (String) ipChange.ipc$dispatch("702060539", new Object[]{this}) : this.headImg;
    }

    public long getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-696097765") ? ((Long) ipChange.ipc$dispatch("-696097765", new Object[]{this})).longValue() : this.id;
    }

    public int getIsFeature() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1396340015") ? ((Integer) ipChange.ipc$dispatch("1396340015", new Object[]{this})).intValue() : this.isFeature;
    }

    public String getNickname() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1148766996") ? (String) ipChange.ipc$dispatch("-1148766996", new Object[]{this}) : this.nickname;
    }

    public String getPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1341810494") ? (String) ipChange.ipc$dispatch("-1341810494", new Object[]{this}) : this.pic;
    }

    public VideoInfo getVideoInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1313760565") ? (VideoInfo) ipChange.ipc$dispatch("-1313760565", new Object[]{this}) : this.videoInfo;
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1143968741")) {
            ipChange.ipc$dispatch("1143968741", new Object[]{this, str});
        } else {
            this.content = str;
        }
    }

    public void setHeadImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1327213349")) {
            ipChange.ipc$dispatch("-1327213349", new Object[]{this, str});
        } else {
            this.headImg = str;
        }
    }

    public void setId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-318780535")) {
            ipChange.ipc$dispatch("-318780535", new Object[]{this, Long.valueOf(j)});
        } else {
            this.id = j;
        }
    }

    public void setIsFeature(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1494545477")) {
            ipChange.ipc$dispatch("-1494545477", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.isFeature = i;
        }
    }

    public void setNickname(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1134366350")) {
            ipChange.ipc$dispatch("-1134366350", new Object[]{this, str});
        } else {
            this.nickname = str;
        }
    }

    public void setPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1522871564")) {
            ipChange.ipc$dispatch("-1522871564", new Object[]{this, str});
        } else {
            this.pic = str;
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1265031921")) {
            ipChange.ipc$dispatch("1265031921", new Object[]{this, videoInfo});
        } else {
            this.videoInfo = videoInfo;
        }
    }
}
