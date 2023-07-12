package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TickletExtraInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public int actionTvColor;
    public long beginTime;
    public int esouvenirEnable;
    public PerformNftExtAttr extAttr;
    public String faceOpenState;
    public String forceShowNotFace;
    public String itemProjectId;
    public String liveH5Url;
    public String liveTicketBgUrl;
    public String liveType;
    public String memberLevel;
    public String moreType;
    public String projectId;
    public String projectImage;
    public String projectName;
    public String transferWarn;
    public int transferringNum;

    public boolean isTMNormalMember() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1085621576") ? ((Boolean) ipChange.ipc$dispatch("1085621576", new Object[]{this})).booleanValue() : "1".equals(this.memberLevel);
    }

    public boolean isTMVipMember() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1507299634") ? ((Boolean) ipChange.ipc$dispatch("1507299634", new Object[]{this})).booleanValue() : "10".equals(this.memberLevel);
    }
}
