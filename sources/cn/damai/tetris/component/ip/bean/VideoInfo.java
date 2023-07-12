package cn.damai.tetris.component.ip.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class VideoInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String coverUrl;
    private String height;
    private String sourceLabel;
    private String url;
    public int videoTime;
    private String width;

    public String getCoverUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2107207418") ? (String) ipChange.ipc$dispatch("-2107207418", new Object[]{this}) : this.coverUrl;
    }

    public String getHeight() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "170356533") ? (String) ipChange.ipc$dispatch("170356533", new Object[]{this}) : this.height;
    }

    public String getSourceLabel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-60324095") ? (String) ipChange.ipc$dispatch("-60324095", new Object[]{this}) : this.sourceLabel;
    }

    public String getUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1456108247") ? (String) ipChange.ipc$dispatch("1456108247", new Object[]{this}) : this.url;
    }

    public String getWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1928885870") ? (String) ipChange.ipc$dispatch("1928885870", new Object[]{this}) : this.width;
    }

    public void setCoverUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-781248360")) {
            ipChange.ipc$dispatch("-781248360", new Object[]{this, str});
        } else {
            this.coverUrl = str;
        }
    }

    public void setHeight(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-409006775")) {
            ipChange.ipc$dispatch("-409006775", new Object[]{this, str});
        } else {
            this.height = str;
        }
    }

    public void setSourceLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "124969109")) {
            ipChange.ipc$dispatch("124969109", new Object[]{this, str});
        } else {
            this.sourceLabel = str;
        }
    }

    public void setUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-686736513")) {
            ipChange.ipc$dispatch("-686736513", new Object[]{this, str});
        } else {
            this.url = str;
        }
    }

    public void setWidth(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2137679928")) {
            ipChange.ipc$dispatch("-2137679928", new Object[]{this, str});
        } else {
            this.width = str;
        }
    }
}
