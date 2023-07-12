package cn.damai.tetris.component.ip.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class IpTags implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private int like;
    private int tagCount;
    private String tagId;
    private String tagName;

    public int getLike() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "455768119") ? ((Integer) ipChange.ipc$dispatch("455768119", new Object[]{this})).intValue() : this.like;
    }

    public int getTagCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "736057977") ? ((Integer) ipChange.ipc$dispatch("736057977", new Object[]{this})).intValue() : this.tagCount;
    }

    public String getTagId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2102264294") ? (String) ipChange.ipc$dispatch("2102264294", new Object[]{this}) : this.tagId;
    }

    public String getTagName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1712240470") ? (String) ipChange.ipc$dispatch("1712240470", new Object[]{this}) : this.tagName;
    }

    public void setLike(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1155359819")) {
            ipChange.ipc$dispatch("1155359819", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.like = i;
        }
    }

    public void setTagCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2041224119")) {
            ipChange.ipc$dispatch("-2041224119", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.tagCount = i;
        }
    }

    public void setTagId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1057916080")) {
            ipChange.ipc$dispatch("-1057916080", new Object[]{this, str});
        } else {
            this.tagId = str;
        }
    }

    public void setTagName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-76406560")) {
            ipChange.ipc$dispatch("-76406560", new Object[]{this, str});
        } else {
            this.tagName = str;
        }
    }
}
