package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import cn.damai.commonbusiness.notice.bean.NoticeListBean;
import cn.damai.commonbusiness.rank.RankInfo;
import cn.damai.trade.newtradeorder.ui.projectdetail.common.bean.VenueBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectStaticDataBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -3251974394106774030L;
    public String alipayDetailUrl;
    public ProjectNotice announcementMsg;
    public NoticeListBean announcementVO;
    public HashMap<String, String> ext;
    public List<String> faqs;
    public ProjectStaticItemBaseBean itemBase;
    public ProjectStaticExtendInfoBean itemExtendInfo;
    public NoticeMatter noticeMatter;
    public RankInfo rankListVO;
    public ProjectRatingBean rating;
    public RealNameBean realName;
    public SharingBar sharingBar;
    public List<ProjectStaticTicketNoteBean> ticketNotes;
    public ProjectTicketGuideBean ticketPurchasesGuidePage;
    public List<ProjectStaticTipBean> tips;
    public List<ProjectTour> tourProjects;
    public String track;
    public VenueBean venue;

    public String getExt(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-748044637")) {
            return (String) ipChange.ipc$dispatch("-748044637", new Object[]{this, str});
        }
        HashMap<String, String> hashMap = this.ext;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public List<String> getFaqs() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-127356434") ? (List) ipChange.ipc$dispatch("-127356434", new Object[]{this}) : this.faqs;
    }

    public ProjectStaticItemBaseBean getItemBase() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "44005008") ? (ProjectStaticItemBaseBean) ipChange.ipc$dispatch("44005008", new Object[]{this}) : this.itemBase;
    }

    public ProjectStaticExtendInfoBean getItemExtendInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1448788093") ? (ProjectStaticExtendInfoBean) ipChange.ipc$dispatch("-1448788093", new Object[]{this}) : this.itemExtendInfo;
    }

    public NoticeMatter getNoticeMatter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1284200643") ? (NoticeMatter) ipChange.ipc$dispatch("-1284200643", new Object[]{this}) : this.noticeMatter;
    }

    public RankInfo getRankListVO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "126715216") ? (RankInfo) ipChange.ipc$dispatch("126715216", new Object[]{this}) : this.rankListVO;
    }

    public String getShareIconPicUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1965342057")) {
            return (String) ipChange.ipc$dispatch("1965342057", new Object[]{this});
        }
        SharingBar sharingBar = this.sharingBar;
        if (sharingBar != null) {
            return sharingBar.sharingIcon;
        }
        return null;
    }

    public String getTheater_status() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2010291190") ? (String) ipChange.ipc$dispatch("-2010291190", new Object[]{this}) : getExt("pro_theater_status");
    }

    public List<ProjectStaticTicketNoteBean> getTicketNotes() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "52759624") ? (List) ipChange.ipc$dispatch("52759624", new Object[]{this}) : this.ticketNotes;
    }

    public List<ProjectStaticTipBean> getTips() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-790709175") ? (List) ipChange.ipc$dispatch("-790709175", new Object[]{this}) : this.tips;
    }

    public VenueBean getVenue() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "378018567") ? (VenueBean) ipChange.ipc$dispatch("378018567", new Object[]{this}) : this.venue;
    }

    public void setTips(List<ProjectStaticTipBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004718243")) {
            ipChange.ipc$dispatch("1004718243", new Object[]{this, list});
        } else {
            this.tips = list;
        }
    }
}
