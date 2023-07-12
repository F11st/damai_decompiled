package cn.damai.issue.net;

import cn.damai.commonbusiness.share.generateimage.DMShareMessage;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class EvaluteSuccessRenderResponse implements Serializable {
    private static final long serialVersionUID = 1;
    public EvaSuccessActivityInfo activityInfo;
    public CommentSuccessInfo commentInfo;
    public CommentProjectDO projectDO;
    public DMShareMessage.YYMemberIntegrate vipScore;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class CommentProjectDO implements Serializable {
        private static final long serialVersionUID = 1;
        public String cityName;
        public String itemScore;
        public String projectId;
        public String projectName;
        public String projectPoster;
        public String showTime;
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class CommentSuccessInfo implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 1;
        public String userCommentTotal;

        public String getUserCommentTotal() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1521189620") ? (String) ipChange.ipc$dispatch("1521189620", new Object[]{this}) : this.userCommentTotal;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class EvaSuccessActivityInfo implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 1;
        public String activityDes;
        public String activityName;
        public String activityUrl;
        public String banner;
        public String popBanner;

        public String getActivityDes() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1411160119") ? (String) ipChange.ipc$dispatch("1411160119", new Object[]{this}) : this.activityDes;
        }

        public String getActivityName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "498205884") ? (String) ipChange.ipc$dispatch("498205884", new Object[]{this}) : this.activityName;
        }

        public String getActivityUrl() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1107064556") ? (String) ipChange.ipc$dispatch("-1107064556", new Object[]{this}) : this.activityUrl;
        }

        public String getBanner() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1670895122") ? (String) ipChange.ipc$dispatch("-1670895122", new Object[]{this}) : this.banner;
        }

        public String getPopBanner() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "34340817") ? (String) ipChange.ipc$dispatch("34340817", new Object[]{this}) : this.popBanner;
        }
    }
}
