package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
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
        return AndroidInstantRuntime.support(ipChange, "1176951607") ? (String) ipChange.ipc$dispatch("1176951607", new Object[]{this}) : this.content;
    }

    public String getHeadImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1812257919") ? (String) ipChange.ipc$dispatch("-1812257919", new Object[]{this}) : this.headImg;
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1093622803") ? (String) ipChange.ipc$dispatch("1093622803", new Object[]{this}) : this.id;
    }

    public int getIsFeature() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-381743511") ? ((Integer) ipChange.ipc$dispatch("-381743511", new Object[]{this})).intValue() : this.isFeature;
    }

    public String getNickname() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1783227866") ? (String) ipChange.ipc$dispatch("-1783227866", new Object[]{this}) : this.nickname;
    }

    public String getPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-644425912") ? (String) ipChange.ipc$dispatch("-644425912", new Object[]{this}) : this.pic;
    }

    public VideoInfo getVideoInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1440229694") ? (VideoInfo) ipChange.ipc$dispatch("1440229694", new Object[]{this}) : this.videoInfo;
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "509507871")) {
            ipChange.ipc$dispatch("509507871", new Object[]{this, str});
        } else {
            this.content = str;
        }
    }

    public void setHeadImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1961674219")) {
            ipChange.ipc$dispatch("-1961674219", new Object[]{this, str});
        } else {
            this.headImg = str;
        }
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1616079317")) {
            ipChange.ipc$dispatch("-1616079317", new Object[]{this, str});
        } else {
            this.id = str;
        }
    }

    public void setIsFeature(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-780559935")) {
            ipChange.ipc$dispatch("-780559935", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.isFeature = i;
        }
    }

    public void setNickname(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "672183160")) {
            ipChange.ipc$dispatch("672183160", new Object[]{this, str});
        } else {
            this.nickname = str;
        }
    }

    public void setPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1378786002")) {
            ipChange.ipc$dispatch("-1378786002", new Object[]{this, str});
        } else {
            this.pic = str;
        }
    }

    public void setVideoInfo(VideoInfo videoInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1052773254")) {
            ipChange.ipc$dispatch("1052773254", new Object[]{this, videoInfo});
        } else {
            this.videoInfo = videoInfo;
        }
    }
}
