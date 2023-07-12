package cn.damai.tetris.core;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BaseLayer extends BaseNode {
    private static transient /* synthetic */ IpChange $ipChange;
    String layerId;
    List<BaseSection> sections;

    public BaseSection getFirstSection() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12627097")) {
            return (BaseSection) ipChange.ipc$dispatch("-12627097", new Object[]{this});
        }
        List<BaseSection> list = this.sections;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.sections.get(0);
    }

    public String getLayerId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "291063862") ? (String) ipChange.ipc$dispatch("291063862", new Object[]{this}) : this.layerId;
    }

    public List<BaseSection> getSections() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2085316321") ? (List) ipChange.ipc$dispatch("2085316321", new Object[]{this}) : this.sections;
    }

    public List<BaseSection> getSubNodes() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "936456772")) {
            return (List) ipChange.ipc$dispatch("936456772", new Object[]{this});
        }
        return null;
    }

    public void setLayerId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1183208448")) {
            ipChange.ipc$dispatch("-1183208448", new Object[]{this, str});
        } else {
            this.layerId = str;
        }
    }

    public void setSections(List<BaseSection> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-269248757")) {
            ipChange.ipc$dispatch("-269248757", new Object[]{this, list});
        } else {
            this.sections = list;
        }
    }
}
