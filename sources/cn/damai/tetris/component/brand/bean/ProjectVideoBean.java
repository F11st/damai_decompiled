package cn.damai.tetris.component.brand.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectVideoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String backgroundPic;
    private ProjectDO projectDO;
    private VideoDO videoDO;

    public String getBackgroundPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1448622381") ? (String) ipChange.ipc$dispatch("1448622381", new Object[]{this}) : this.backgroundPic;
    }

    public ProjectDO getProjectDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "579763328") ? (ProjectDO) ipChange.ipc$dispatch("579763328", new Object[]{this}) : this.projectDO;
    }

    public VideoDO getVideoDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1228539008") ? (VideoDO) ipChange.ipc$dispatch("1228539008", new Object[]{this}) : this.videoDO;
    }

    public void setBackgroundPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "88957161")) {
            ipChange.ipc$dispatch("88957161", new Object[]{this, str});
        } else {
            this.backgroundPic = str;
        }
    }

    public void setProjectDO(ProjectDO projectDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2083741076")) {
            ipChange.ipc$dispatch("-2083741076", new Object[]{this, projectDO});
        } else {
            this.projectDO = projectDO;
        }
    }

    public void setVideoDO(VideoDO videoDO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "146233640")) {
            ipChange.ipc$dispatch("146233640", new Object[]{this, videoDO});
        } else {
            this.videoDO = videoDO;
        }
    }
}
