package cn.damai.tetris.component.ip.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class VideoAlbum implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CONTENT_TAG_ARTICAL = 1;
    public static final int CONTENT_TAG_VIDEO = 2;
    public BaseUserDO baseUserDO;
    private String content;
    public ContentInfo contentInfo;
    public int contentTag;
    private String headImg;
    private String id;
    public ArrayList<String> imgList;
    public String ipvuv;
    private int isFeature;
    private String nickname;
    private String pic;
    public String publishTime;
    public String publishTimeStr;
    private VideoInfo videoInfo;

    public String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1469364682") ? (String) ipChange.ipc$dispatch("-1469364682", new Object[]{this}) : this.content;
    }

    public String getHeadImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-163606912") ? (String) ipChange.ipc$dispatch("-163606912", new Object[]{this}) : this.headImg;
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2063977908") ? (String) ipChange.ipc$dispatch("2063977908", new Object[]{this}) : this.id;
    }

    public int getIsFeature() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1163401910") ? ((Integer) ipChange.ipc$dispatch("-1163401910", new Object[]{this})).intValue() : this.isFeature;
    }

    public String getNickname() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2080313095") ? (String) ipChange.ipc$dispatch("2080313095", new Object[]{this}) : this.nickname;
    }

    public String getPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-628188729") ? (String) ipChange.ipc$dispatch("-628188729", new Object[]{this}) : this.pic;
    }

    public VideoInfo getVideoInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "229346918") ? (VideoInfo) ipChange.ipc$dispatch("229346918", new Object[]{this}) : this.videoInfo;
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "78081536")) {
            ipChange.ipc$dispatch("78081536", new Object[]{this, str});
        } else {
            this.content = str;
        }
    }

    public void setHeadImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1901866742")) {
            ipChange.ipc$dispatch("1901866742", new Object[]{this, str});
        } else {
            this.headImg = str;
        }
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599842134")) {
            ipChange.ipc$dispatch("-1599842134", new Object[]{this, str});
        } else {
            this.id = str;
        }
    }

    public void setIsFeature(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "757833472")) {
            ipChange.ipc$dispatch("757833472", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.isFeature = i;
        }
    }

    public void setNickname(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "182868663")) {
            ipChange.ipc$dispatch("182868663", new Object[]{this, str});
        } else {
            this.nickname = str;
        }
    }

    public void setPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-875433329")) {
            ipChange.ipc$dispatch("-875433329", new Object[]{this, str});
        } else {
            this.pic = str;
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1856723638")) {
            ipChange.ipc$dispatch("1856723638", new Object[]{this, videoInfo});
        } else {
            this.videoInfo = videoInfo;
        }
    }
}
