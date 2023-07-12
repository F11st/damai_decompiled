package cn.damai.commonbusiness.search.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class RepertoireBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public String artsDesc;
    public String backgroundPic;
    public long childRepertoireType;
    public String childRepertoireTypeName;
    public String focusComment;
    public int followStatus;
    public String repertoireId;
    public String repertoireName;
    public String repertoirePic;
    public storyPicsBean storyPics;
    public String summary;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static class storyPicsBean implements Serializable {
        public List<String> pics;
    }

    public boolean isFollowState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-849033061") ? ((Boolean) ipChange.ipc$dispatch("-849033061", new Object[]{this})).booleanValue() : this.followStatus != 0;
    }
}
