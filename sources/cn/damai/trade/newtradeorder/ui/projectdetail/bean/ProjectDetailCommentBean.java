package cn.damai.trade.newtradeorder.ui.projectdetail.bean;

import cn.damai.comment.bean.CommentsItemBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectDetailCommentBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 3739113332570390732L;
    private ProjectDetailCommentConfigureBean config;
    private String hotTotal;
    private List<CommentsItemBean> moduleComments;
    private String total;
    private List<CommentsItemBean> userComments;

    public ProjectDetailCommentConfigureBean getConfig() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "418258216") ? (ProjectDetailCommentConfigureBean) ipChange.ipc$dispatch("418258216", new Object[]{this}) : this.config;
    }

    public String getHotTotal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "526511695") ? (String) ipChange.ipc$dispatch("526511695", new Object[]{this}) : this.hotTotal;
    }

    public List<CommentsItemBean> getModuleComments() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "822840127") ? (List) ipChange.ipc$dispatch("822840127", new Object[]{this}) : this.moduleComments;
    }

    public String getTotal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "184338210") ? (String) ipChange.ipc$dispatch("184338210", new Object[]{this}) : this.total;
    }

    public List<CommentsItemBean> getUserComments() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "241993502") ? (List) ipChange.ipc$dispatch("241993502", new Object[]{this}) : this.userComments;
    }

    public void setConfig(ProjectDetailCommentConfigureBean projectDetailCommentConfigureBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1955399570")) {
            ipChange.ipc$dispatch("1955399570", new Object[]{this, projectDetailCommentConfigureBean});
        } else {
            this.config = projectDetailCommentConfigureBean;
        }
    }

    public void setHotTotal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-740334481")) {
            ipChange.ipc$dispatch("-740334481", new Object[]{this, str});
        } else {
            this.hotTotal = str;
        }
    }

    public void setModuleComments(List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1041667949")) {
            ipChange.ipc$dispatch("1041667949", new Object[]{this, list});
        } else {
            this.moduleComments = list;
        }
    }

    public void setTotal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-384082540")) {
            ipChange.ipc$dispatch("-384082540", new Object[]{this, str});
        } else {
            this.total = str;
        }
    }

    public void setUserComments(List<CommentsItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2002494574")) {
            ipChange.ipc$dispatch("2002494574", new Object[]{this, list});
        } else {
            this.userComments = list;
        }
    }
}
