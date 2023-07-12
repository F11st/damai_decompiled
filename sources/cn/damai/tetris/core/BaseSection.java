package cn.damai.tetris.core;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BaseSection extends BaseNode {
    private static transient /* synthetic */ IpChange $ipChange;
    String componentId;
    String sectionId;

    public static BaseSection obj2Section(String str, JSONObject jSONObject, TrackInfo trackInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-922751071")) {
            return (BaseSection) ipChange.ipc$dispatch("-922751071", new Object[]{str, jSONObject, trackInfo});
        }
        BaseSection baseSection = new BaseSection();
        baseSection.setComponentId(str);
        baseSection.setItem(jSONObject);
        baseSection.setTrackInfo(trackInfo);
        return baseSection;
    }

    public String getComponentId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "309867470") ? (String) ipChange.ipc$dispatch("309867470", new Object[]{this}) : this.componentId;
    }

    public String getSectionId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-899416458") ? (String) ipChange.ipc$dispatch("-899416458", new Object[]{this}) : this.sectionId;
    }

    public void setComponentId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1283994264")) {
            ipChange.ipc$dispatch("-1283994264", new Object[]{this, str});
        } else {
            this.componentId = str;
        }
    }

    public void setSectionId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "217656000")) {
            ipChange.ipc$dispatch("217656000", new Object[]{this, str});
        } else {
            this.sectionId = str;
        }
    }
}
