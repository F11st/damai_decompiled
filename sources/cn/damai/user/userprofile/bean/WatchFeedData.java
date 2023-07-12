package cn.damai.user.userprofile.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class WatchFeedData extends CommentFeedData {
    private static transient /* synthetic */ IpChange $ipChange;
    public String contentId;
    public boolean feature;
    public List<GradeDo> grades;
    public List<String> imgs;
    public String title;
    public VideoInfo videoInfo;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    static class GradeDo implements Serializable {
        public int value;
        public String valueDesc;

        GradeDo() {
        }
    }

    public int getValue() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-591177089")) {
            return ((Integer) ipChange.ipc$dispatch("-591177089", new Object[]{this})).intValue();
        }
        List<GradeDo> list = this.grades;
        if (list == null || list.size() <= 0 || this.grades.get(0) == null) {
            return 0;
        }
        return this.grades.get(0).value;
    }

    public String getValueDesc() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-473782459")) {
            return (String) ipChange.ipc$dispatch("-473782459", new Object[]{this});
        }
        List<GradeDo> list = this.grades;
        return (list == null || list.size() <= 0 || this.grades.get(0) == null) ? "" : this.grades.get(0).valueDesc;
    }
}
