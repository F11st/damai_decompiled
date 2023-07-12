package cn.damai.user.userprofile.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class FeedMergeDataDO implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final long serialVersionUID = -8100634300173587499L;
    public List<ArticleFeedData> articleData;
    public String bizTime;
    public String bizType;
    public List<CommentFeedData> commentData;
    public int commentNum;
    public List<DynamicFeedData> dynamicData;
    public boolean enableComment;
    public boolean enableForward;
    public boolean enablePraise;
    public List<FollowFeedData> followData;
    public int fowardNum;
    public Long gmtCreate;
    public boolean hasPraised;
    public int praiseNum;
    public String title;
    public List<WatchFeedData> watchData;
    public String year;

    public Integer getSubType() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "93777826")) {
            return (Integer) ipChange.ipc$dispatch("93777826", new Object[]{this});
        }
        String[] split = this.bizType.split("\\.");
        if (split.length == 2) {
            return Integer.valueOf(Integer.parseInt(split[1]));
        }
        return null;
    }
}
