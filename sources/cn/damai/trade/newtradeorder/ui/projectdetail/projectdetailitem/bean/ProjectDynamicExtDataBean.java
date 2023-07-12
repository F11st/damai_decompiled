package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import cn.damai.comment.bean.HotDiscussBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectDynamicExtDataBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -3374581284322019926L;
    public List<ProjectDynamicArtistBean> artists;
    public List<String> artistsRichText;
    public List<BrandAndArtists> brandArtists;
    public List<Brand> brands;
    public List<InFieldCommentsBean> inFieldComments;
    public ProjectDynamicIpCardBean ipCard;
    public ProjectMemberPrompt memberPrompt;
    public String sharingBtnBubbleText;
    public boolean subFlag;
    public HotDiscussBean topicHotComment;
    public ProjectWantSeeBean wantVO;

    public List<ProjectDynamicArtistBean> getArtists() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-106422005") ? (List) ipChange.ipc$dispatch("-106422005", new Object[]{this}) : this.artists;
    }

    public List<String> getArtistsRichText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1440755692") ? (List) ipChange.ipc$dispatch("-1440755692", new Object[]{this}) : this.artistsRichText;
    }

    public List<Brand> getBrands() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1308825489") ? (List) ipChange.ipc$dispatch("1308825489", new Object[]{this}) : this.brands;
    }

    public ProjectDynamicIpCardBean getIpCard() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "38257591") ? (ProjectDynamicIpCardBean) ipChange.ipc$dispatch("38257591", new Object[]{this}) : this.ipCard;
    }

    public String getSharingBtnBubbleText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1606084681") ? (String) ipChange.ipc$dispatch("-1606084681", new Object[]{this}) : this.sharingBtnBubbleText;
    }

    public boolean isSubFlag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-251056262") ? ((Boolean) ipChange.ipc$dispatch("-251056262", new Object[]{this})).booleanValue() : this.subFlag;
    }

    public void setSubFlag(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-14482484")) {
            ipChange.ipc$dispatch("-14482484", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.subFlag = z;
        }
    }
}
