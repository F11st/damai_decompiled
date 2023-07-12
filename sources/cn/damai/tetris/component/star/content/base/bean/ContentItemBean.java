package cn.damai.tetris.component.star.content.base.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ContentItemBean {
    private static transient /* synthetic */ IpChange $ipChange;
    private String card;
    private String content;
    private String contentId;
    private String coverImage;
    private List<String> images;
    private PraiseInfo praiseInfo;
    private String releaseTime;
    private String sourceId;
    private String title;
    private ContentVideoBean video;

    public String getCard() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1493124390") ? (String) ipChange.ipc$dispatch("1493124390", new Object[]{this}) : this.card;
    }

    public String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-376928359") ? (String) ipChange.ipc$dispatch("-376928359", new Object[]{this}) : this.content;
    }

    public String getContentId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1461425708") ? (String) ipChange.ipc$dispatch("-1461425708", new Object[]{this}) : this.contentId;
    }

    public String getCoverImage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1514105926") ? (String) ipChange.ipc$dispatch("-1514105926", new Object[]{this}) : this.coverImage;
    }

    public List<String> getImages() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-295701771") ? (List) ipChange.ipc$dispatch("-295701771", new Object[]{this}) : this.images;
    }

    public PraiseInfo getPraiseInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1193247712") ? (PraiseInfo) ipChange.ipc$dispatch("-1193247712", new Object[]{this}) : this.praiseInfo;
    }

    public String getReleaseTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1751951508") ? (String) ipChange.ipc$dispatch("1751951508", new Object[]{this}) : this.releaseTime;
    }

    public String getSourceId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2039643092") ? (String) ipChange.ipc$dispatch("-2039643092", new Object[]{this}) : this.sourceId;
    }

    public String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1664040648") ? (String) ipChange.ipc$dispatch("-1664040648", new Object[]{this}) : this.title;
    }

    public ContentVideoBean getVideo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1198117251") ? (ContentVideoBean) ipChange.ipc$dispatch("-1198117251", new Object[]{this}) : this.video;
    }

    public void setCard(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1250540936")) {
            ipChange.ipc$dispatch("-1250540936", new Object[]{this, str});
        } else {
            this.card = str;
        }
    }

    public void setContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-416130819")) {
            ipChange.ipc$dispatch("-416130819", new Object[]{this, str});
        } else {
            this.content = str;
        }
    }

    public void setContentId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-24761566")) {
            ipChange.ipc$dispatch("-24761566", new Object[]{this, str});
        } else {
            this.contentId = str;
        }
    }

    public void setCoverImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1802526876")) {
            ipChange.ipc$dispatch("-1802526876", new Object[]{this, str});
        } else {
            this.coverImage = str;
        }
    }

    public void setImages(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "35969655")) {
            ipChange.ipc$dispatch("35969655", new Object[]{this, list});
        } else {
            this.images = list;
        }
    }

    public void setPraiseInfo(PraiseInfo praiseInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1334577276")) {
            ipChange.ipc$dispatch("1334577276", new Object[]{this, praiseInfo});
        } else {
            this.praiseInfo = praiseInfo;
        }
    }

    public void setReleaseTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "470937954")) {
            ipChange.ipc$dispatch("470937954", new Object[]{this, str});
        } else {
            this.releaseTime = str;
        }
    }

    public void setSourceId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1313245746")) {
            ipChange.ipc$dispatch("1313245746", new Object[]{this, str});
        } else {
            this.sourceId = str;
        }
    }

    public void setTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1849252290")) {
            ipChange.ipc$dispatch("-1849252290", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }

    public void setVideo(ContentVideoBean contentVideoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1645915305")) {
            ipChange.ipc$dispatch("-1645915305", new Object[]{this, contentVideoBean});
        } else {
            this.video = contentVideoBean;
        }
    }
}
