package cn.damai.issue.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class ToEvaListResponse implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public String commentGiftIcon;
    public String commentGiftLink;
    public String hasMore;
    public String pagingKey;
    public List<EvaluateInfo> performCardInfoList;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class EvaluateInfo implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 1;
        public long beginTime;
        public CommentInfo commentInfo;
        public String isDisplayComment;
        public String itemType;
        public String localeName;
        public String localeStoreName;
        public String performId;
        public String projectId;
        public String projectImage;
        public String projectName;
        public String storeId;
        public String ticketNum;
        public String timeTitle;
        public String venueName;

        public long getBeginTime() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-150315733") ? ((Long) ipChange.ipc$dispatch("-150315733", new Object[]{this})).longValue() : this.beginTime;
        }

        public CommentInfo getCommentInfo() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-197352101") ? (CommentInfo) ipChange.ipc$dispatch("-197352101", new Object[]{this}) : this.commentInfo;
        }

        public String getIsDisplayComment() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "683957226") ? (String) ipChange.ipc$dispatch("683957226", new Object[]{this}) : this.isDisplayComment;
        }

        public String getLocaleName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1627753448") ? (String) ipChange.ipc$dispatch("1627753448", new Object[]{this}) : this.localeName;
        }

        public String getPerformId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "855197327") ? (String) ipChange.ipc$dispatch("855197327", new Object[]{this}) : this.performId;
        }

        public String getProjectId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-496398265") ? (String) ipChange.ipc$dispatch("-496398265", new Object[]{this}) : this.projectId;
        }

        public String getProjectImage() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1854653659") ? (String) ipChange.ipc$dispatch("-1854653659", new Object[]{this}) : this.projectImage;
        }

        public String getProjectName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-226479753") ? (String) ipChange.ipc$dispatch("-226479753", new Object[]{this}) : this.projectName;
        }

        public String getTicketNum() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1418273779") ? (String) ipChange.ipc$dispatch("-1418273779", new Object[]{this}) : this.ticketNum;
        }

        public String getTimeTitle() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "639947838") ? (String) ipChange.ipc$dispatch("639947838", new Object[]{this}) : this.timeTitle;
        }

        public String getVenueName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1145645261") ? (String) ipChange.ipc$dispatch("1145645261", new Object[]{this}) : this.venueName;
        }

        public boolean isScriptmurderShop() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-465051927") ? ((Boolean) ipChange.ipc$dispatch("-465051927", new Object[]{this})).booleanValue() : "1".equals(this.itemType);
        }

        public void setLocaleName(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1105833206")) {
                ipChange.ipc$dispatch("1105833206", new Object[]{this, str});
            } else {
                this.localeName = str;
            }
        }

        public void setProjectId(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-173681905")) {
                ipChange.ipc$dispatch("-173681905", new Object[]{this, str});
            } else {
                this.projectId = str;
            }
        }

        public void setTicketNum(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1312948233")) {
                ipChange.ipc$dispatch("1312948233", new Object[]{this, str});
            } else {
                this.ticketNum = str;
            }
        }
    }

    public String getHasMore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "129746419") ? (String) ipChange.ipc$dispatch("129746419", new Object[]{this}) : this.hasMore;
    }

    public String getPagingKey() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1281722409") ? (String) ipChange.ipc$dispatch("-1281722409", new Object[]{this}) : this.pagingKey;
    }

    public List<EvaluateInfo> getPerformCardInfoList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1257687576") ? (List) ipChange.ipc$dispatch("-1257687576", new Object[]{this}) : this.performCardInfoList;
    }

    public void setHasMore(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889081885")) {
            ipChange.ipc$dispatch("-1889081885", new Object[]{this, str});
        } else {
            this.hasMore = str;
        }
    }

    public void setPagingKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251073407")) {
            ipChange.ipc$dispatch("1251073407", new Object[]{this, str});
        } else {
            this.pagingKey = str;
        }
    }

    public void setPerformCardInfoList(List<EvaluateInfo> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1582932348")) {
            ipChange.ipc$dispatch("1582932348", new Object[]{this, list});
        } else {
            this.performCardInfoList = list;
        }
    }
}
