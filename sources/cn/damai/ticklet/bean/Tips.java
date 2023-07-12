package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class Tips implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public String link;
    public String linkText;
    public String text;

    public String getLink() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-651267258") ? (String) ipChange.ipc$dispatch("-651267258", new Object[]{this}) : this.link;
    }

    public String getLinkText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "695094931") ? (String) ipChange.ipc$dispatch("695094931", new Object[]{this}) : this.linkText;
    }

    public String getText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1125019897") ? (String) ipChange.ipc$dispatch("1125019897", new Object[]{this}) : this.text;
    }

    public void setLink(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "992794712")) {
            ipChange.ipc$dispatch("992794712", new Object[]{this, str});
        } else {
            this.link = str;
        }
    }

    public void setLinkText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "190778539")) {
            ipChange.ipc$dispatch("190778539", new Object[]{this, str});
        } else {
            this.linkText = str;
        }
    }

    public void setText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "223121669")) {
            ipChange.ipc$dispatch("223121669", new Object[]{this, str});
        } else {
            this.text = str;
        }
    }
}
