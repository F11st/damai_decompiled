package cn.damai.ticklet.bean;

import cn.damai.common.db.db.annotation.Column;
import cn.damai.common.db.db.annotation.Table;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
@Table(name = "perform")
/* loaded from: classes16.dex */
public class PerformTable implements Serializable, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String COUPON_PERFORM_TYPE = "1";
    private static final String NFT_PERFORM_TYPE = "2";
    public static final String PERFORM_SUPPORT_BIND_FACE = "1";
    public static final String PERFORM_SUPPORT_ONE = "1";
    private static final long serialVersionUID = 1;
    private AnnouncementVO announcement;
    @Column(name = "color")
    public String color;
    @Column(name = "createTime")
    public long createTime;
    public TicketAlipayCardBean ecertTipsInfo;
    @Column(name = "ecertTipsInfodb")
    public String ecertTipsInfodb;
    @Column(name = "endTime")
    public long endTime;
    private int esouvenirEnable;
    @Column(name = "expireTime")
    public long expireTime;
    private PerformExtAttr extAttr;
    public String historyPerformFlag;
    @Column(isId = true, name = "id")
    public int id;
    @Column(name = "isCertPerform")
    public String isCertPerform;
    @Column(name = "isLive")
    public String isLive;
    @Column(name = "isLongtermProject")
    public String isLongtermProject;
    @Column(name = "isMoreEnter")
    public String isMoreEnter;
    public String isTimeChanged;
    @Column(name = "liveH5Url")
    public String liveH5Url;
    private String liveTicketBgUrl;
    @Column(name = "liveType")
    public String liveType;
    @Column(name = "localExtAttr")
    private String localExtAttr;
    @Column(name = "localUserProjectVO")
    public String localUserProjectVO;
    @Column(name = "localUserVenueVO")
    public String localUserVenueVO;
    @Column(name = "memberLevel")
    private String memberLevel;
    private String performDetailTitle;
    @Column(name = TicketDetailExtFragment.PERFORM_ID)
    public String performId;
    public ArrayList<PerformOpModule> performOpList;
    @Column(name = "performOpListLocal")
    public String performOpListLocal;
    @Column(name = "performStatus")
    public String performStatus;
    @Column(name = "performType")
    public String performType;
    @Column(name = TicketDetailExtFragment.PRODUCT_SYSTEM_ID)
    public String productSystemId;
    @Column(name = "showTimeRangeDetail")
    public String showTimeRangeDetail;
    private String startTime;
    @Column(name = "startTimeByLong")
    public long startTimeByLong;
    private String tenantId;
    @Column(name = "ticketQuantity")
    public int ticketQuantity;
    public String timeChangedReason;
    public String timeShow;
    @Column(name = "timeTitle")
    public String timeTitle;
    private int transferState;
    private String transferWarn;
    private int transferringNum;
    @Column(name = "userCode")
    public String userCode;
    private UserProjectBean userProjectVO;
    private List<UserTicketTable> userTicketVOList;
    private UserVenueBean userVenueVO;
    private TransferBackBean withdrawVO;
    public int timeShowIcon = -1;
    public int sepType = 0;

    public Object clone() throws CloneNotSupportedException {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "321867322") ? ipChange.ipc$dispatch("321867322", new Object[]{this}) : super.clone();
    }

    public AnnouncementVO getAnnouncement() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1561450970") ? (AnnouncementVO) ipChange.ipc$dispatch("1561450970", new Object[]{this}) : this.announcement;
    }

    public String getColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1294884360") ? (String) ipChange.ipc$dispatch("-1294884360", new Object[]{this}) : this.color;
    }

    public long getCreateTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-474616790") ? ((Long) ipChange.ipc$dispatch("-474616790", new Object[]{this})).longValue() : this.createTime;
    }

    public TicketAlipayCardBean getEcertTipsInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1638952224") ? (TicketAlipayCardBean) ipChange.ipc$dispatch("-1638952224", new Object[]{this}) : this.ecertTipsInfo;
    }

    public String getEcertTipsInfodb() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-156148478") ? (String) ipChange.ipc$dispatch("-156148478", new Object[]{this}) : this.ecertTipsInfodb;
    }

    public long getEndTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "866545943") ? ((Long) ipChange.ipc$dispatch("866545943", new Object[]{this})).longValue() : this.endTime;
    }

    public int getEsouvenirEnable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-988191257") ? ((Integer) ipChange.ipc$dispatch("-988191257", new Object[]{this})).intValue() : this.esouvenirEnable;
    }

    public long getExpireTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-830721369") ? ((Long) ipChange.ipc$dispatch("-830721369", new Object[]{this})).longValue() : this.expireTime;
    }

    public PerformExtAttr getExtAttr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-229721112") ? (PerformExtAttr) ipChange.ipc$dispatch("-229721112", new Object[]{this}) : this.extAttr;
    }

    public String getHistoryPerformFlag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1247884410") ? (String) ipChange.ipc$dispatch("1247884410", new Object[]{this}) : this.historyPerformFlag;
    }

    public int getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-287887945") ? ((Integer) ipChange.ipc$dispatch("-287887945", new Object[]{this})).intValue() : this.id;
    }

    public String getIsCertPerform() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1277981096") ? (String) ipChange.ipc$dispatch("1277981096", new Object[]{this}) : this.isCertPerform;
    }

    public String getIsLive() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "101449975") ? (String) ipChange.ipc$dispatch("101449975", new Object[]{this}) : this.isLive;
    }

    public String getIsLongtermProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "853109788") ? (String) ipChange.ipc$dispatch("853109788", new Object[]{this}) : this.isLongtermProject;
    }

    public String getIsMoreEnter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "677385870") ? (String) ipChange.ipc$dispatch("677385870", new Object[]{this}) : this.isMoreEnter;
    }

    public String getIsTimeChanged() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1695750962") ? (String) ipChange.ipc$dispatch("1695750962", new Object[]{this}) : this.isTimeChanged;
    }

    public String getItemId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1659968689")) {
            return (String) ipChange.ipc$dispatch("-1659968689", new Object[]{this});
        }
        UserProjectBean userProjectBean = this.userProjectVO;
        return userProjectBean != null ? userProjectBean.itemId : "";
    }

    public String getLiveH5Url() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1576236565") ? (String) ipChange.ipc$dispatch("-1576236565", new Object[]{this}) : this.liveH5Url;
    }

    public String getLiveTicketBgUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "744527687") ? (String) ipChange.ipc$dispatch("744527687", new Object[]{this}) : this.liveTicketBgUrl;
    }

    public String getLiveType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1665221767") ? (String) ipChange.ipc$dispatch("1665221767", new Object[]{this}) : this.liveType;
    }

    public String getLocalExtAttr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-655693176") ? (String) ipChange.ipc$dispatch("-655693176", new Object[]{this}) : this.localExtAttr;
    }

    public String getLocalUserProjectVO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2047071773") ? (String) ipChange.ipc$dispatch("2047071773", new Object[]{this}) : this.localUserProjectVO;
    }

    public String getLocalUserVenueVO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1536336115") ? (String) ipChange.ipc$dispatch("1536336115", new Object[]{this}) : this.localUserVenueVO;
    }

    public String getLocaleName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-109130938")) {
            return (String) ipChange.ipc$dispatch("-109130938", new Object[]{this});
        }
        UserVenueBean userVenueBean = this.userVenueVO;
        return userVenueBean != null ? userVenueBean.localeName : "";
    }

    public String getMemberLevel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1695683937") ? (String) ipChange.ipc$dispatch("-1695683937", new Object[]{this}) : this.memberLevel;
    }

    public String getPerformDetailTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1547036967") ? (String) ipChange.ipc$dispatch("1547036967", new Object[]{this}) : this.performDetailTitle;
    }

    public String getPerformId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-724851855") ? (String) ipChange.ipc$dispatch("-724851855", new Object[]{this}) : this.performId;
    }

    public ArrayList<PerformOpModule> getPerformOpList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1733250203") ? (ArrayList) ipChange.ipc$dispatch("-1733250203", new Object[]{this}) : this.performOpList;
    }

    public String getPerformOpListLocal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "290398380") ? (String) ipChange.ipc$dispatch("290398380", new Object[]{this}) : this.performOpListLocal;
    }

    public String getPerformStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1884973240") ? (String) ipChange.ipc$dispatch("-1884973240", new Object[]{this}) : this.performStatus;
    }

    public String getPerformType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1156254032") ? (String) ipChange.ipc$dispatch("1156254032", new Object[]{this}) : this.performType;
    }

    public String getProductSystemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "600970446") ? (String) ipChange.ipc$dispatch("600970446", new Object[]{this}) : this.productSystemId;
    }

    public String getProjectId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2076447447")) {
            return (String) ipChange.ipc$dispatch("-2076447447", new Object[]{this});
        }
        UserProjectBean userProjectBean = this.userProjectVO;
        return userProjectBean != null ? userProjectBean.projectId : "";
    }

    public String getProjectImage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-258270461")) {
            return (String) ipChange.ipc$dispatch("-258270461", new Object[]{this});
        }
        UserProjectBean userProjectBean = this.userProjectVO;
        return userProjectBean != null ? userProjectBean.projectImageUrl : "";
    }

    public String getProjectName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1764679129")) {
            return (String) ipChange.ipc$dispatch("1764679129", new Object[]{this});
        }
        UserProjectBean userProjectBean = this.userProjectVO;
        return userProjectBean != null ? userProjectBean.projectName : "";
    }

    public String getShowTimeRangeDetail() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1006321849") ? (String) ipChange.ipc$dispatch("1006321849", new Object[]{this}) : this.showTimeRangeDetail;
    }

    public long getStartTimeByLong() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "376106109") ? ((Long) ipChange.ipc$dispatch("376106109", new Object[]{this})).longValue() : this.startTimeByLong;
    }

    public String getTenantId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2133954598") ? (String) ipChange.ipc$dispatch("2133954598", new Object[]{this}) : this.tenantId;
    }

    public int getTicketQuantity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1818960229") ? ((Integer) ipChange.ipc$dispatch("-1818960229", new Object[]{this})).intValue() : this.ticketQuantity;
    }

    public String getTimeChangedReason() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "984706016") ? (String) ipChange.ipc$dispatch("984706016", new Object[]{this}) : this.timeChangedReason;
    }

    public String getTimeTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-940101344") ? (String) ipChange.ipc$dispatch("-940101344", new Object[]{this}) : this.timeTitle;
    }

    public String getTransferBackDesc() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "67349732")) {
            return (String) ipChange.ipc$dispatch("67349732", new Object[]{this});
        }
        TransferBackBean transferBackBean = this.withdrawVO;
        return transferBackBean != null ? transferBackBean.withdrawDesc : "";
    }

    public String getTransferBackUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1875851698")) {
            return (String) ipChange.ipc$dispatch("1875851698", new Object[]{this});
        }
        TransferBackBean transferBackBean = this.withdrawVO;
        return transferBackBean != null ? transferBackBean.withdrawUrl : "";
    }

    public int getTransferState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1844573880") ? ((Integer) ipChange.ipc$dispatch("1844573880", new Object[]{this})).intValue() : this.transferState;
    }

    public String getTransferWarn() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "629782738") ? (String) ipChange.ipc$dispatch("629782738", new Object[]{this}) : this.transferWarn;
    }

    public int getTransferringNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1662871955") ? ((Integer) ipChange.ipc$dispatch("1662871955", new Object[]{this})).intValue() : this.transferringNum;
    }

    public UserProjectBean getUserProjectVO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1235929526") ? (UserProjectBean) ipChange.ipc$dispatch("-1235929526", new Object[]{this}) : this.userProjectVO;
    }

    public List<UserTicketTable> getUserTicketVOList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1319172586") ? (List) ipChange.ipc$dispatch("-1319172586", new Object[]{this}) : this.userTicketVOList;
    }

    public UserVenueBean getUserVenueVO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-870829986") ? (UserVenueBean) ipChange.ipc$dispatch("-870829986", new Object[]{this}) : this.userVenueVO;
    }

    public String getVenueDetailAddress() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "882051061")) {
            return (String) ipChange.ipc$dispatch("882051061", new Object[]{this});
        }
        UserVenueBean userVenueBean = this.userVenueVO;
        return userVenueBean != null ? userVenueBean.detailLocation : "";
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-434403921")) {
            return (String) ipChange.ipc$dispatch("-434403921", new Object[]{this});
        }
        UserVenueBean userVenueBean = this.userVenueVO;
        return userVenueBean != null ? userVenueBean.venueName : "";
    }

    public TransferBackBean getWithdrawVO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "967784148") ? (TransferBackBean) ipChange.ipc$dispatch("967784148", new Object[]{this}) : this.withdrawVO;
    }

    public boolean isCouponPerform() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-249595512") ? ((Boolean) ipChange.ipc$dispatch("-249595512", new Object[]{this})).booleanValue() : "1".equals(this.performType);
    }

    public boolean isHistoryTicket() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2117421309") ? ((Boolean) ipChange.ipc$dispatch("-2117421309", new Object[]{this})).booleanValue() : "1".equals(getHistoryPerformFlag());
    }

    public boolean isLivePerform() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-324068018") ? ((Boolean) ipChange.ipc$dispatch("-324068018", new Object[]{this})).booleanValue() : "1".equals(this.isLive);
    }

    public boolean isMaiLive() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-95437886") ? ((Boolean) ipChange.ipc$dispatch("-95437886", new Object[]{this})).booleanValue() : "1".equals(getLiveType());
    }

    public boolean isNftPerform() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "304421706") ? ((Boolean) ipChange.ipc$dispatch("304421706", new Object[]{this})).booleanValue() : "2".equals(this.performType);
    }

    public void setAnnouncement(AnnouncementVO announcementVO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2041108136")) {
            ipChange.ipc$dispatch("2041108136", new Object[]{this, announcementVO});
        } else {
            this.announcement = announcementVO;
        }
    }

    public void setColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004658046")) {
            ipChange.ipc$dispatch("1004658046", new Object[]{this, str});
        } else {
            this.color = str;
        }
    }

    public void setCreateTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1526626650")) {
            ipChange.ipc$dispatch("1526626650", new Object[]{this, Long.valueOf(j)});
        } else {
            this.createTime = j;
        }
    }

    public void setEcertTipsInfo(TicketAlipayCardBean ticketAlipayCardBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "846177806")) {
            ipChange.ipc$dispatch("846177806", new Object[]{this, ticketAlipayCardBean});
        } else {
            this.ecertTipsInfo = ticketAlipayCardBean;
        }
    }

    public void setEcertTipsInfodb(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-263822156")) {
            ipChange.ipc$dispatch("-263822156", new Object[]{this, str});
        } else {
            this.ecertTipsInfodb = str;
        }
    }

    public void setEndTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678584971")) {
            ipChange.ipc$dispatch("-678584971", new Object[]{this, Long.valueOf(j)});
        } else {
            this.endTime = j;
        }
    }

    public void setEsouvenirEnable(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "744000259")) {
            ipChange.ipc$dispatch("744000259", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.esouvenirEnable = i;
        }
    }

    public void setExpireTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-922680707")) {
            ipChange.ipc$dispatch("-922680707", new Object[]{this, Long.valueOf(j)});
        } else {
            this.expireTime = j;
        }
    }

    public void setExtAttr(PerformExtAttr performExtAttr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1165184496")) {
            ipChange.ipc$dispatch("1165184496", new Object[]{this, performExtAttr});
        } else {
            this.extAttr = performExtAttr;
        }
    }

    public void setHistoryPerformFlag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12295516")) {
            ipChange.ipc$dispatch("-12295516", new Object[]{this, str});
        } else {
            this.historyPerformFlag = str;
        }
    }

    public void setId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-549178933")) {
            ipChange.ipc$dispatch("-549178933", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.id = i;
        }
    }

    public void setIsCertPerform(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-905955378")) {
            ipChange.ipc$dispatch("-905955378", new Object[]{this, str});
        } else {
            this.isCertPerform = str;
        }
    }

    public void setIsLive(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1749857223")) {
            ipChange.ipc$dispatch("1749857223", new Object[]{this, str});
        } else {
            this.isLive = str;
        }
    }

    public void setIsLongtermProject(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1687594458")) {
            ipChange.ipc$dispatch("1687594458", new Object[]{this, str});
        } else {
            this.isLongtermProject = str;
        }
    }

    public void setIsMoreEnter(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1519141544")) {
            ipChange.ipc$dispatch("1519141544", new Object[]{this, str});
        } else {
            this.isMoreEnter = str;
        }
    }

    public void setIsTimeChanged(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-839991420")) {
            ipChange.ipc$dispatch("-839991420", new Object[]{this, str});
        } else {
            this.isTimeChanged = str;
        }
    }

    public void setLiveH5Url(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "711069163")) {
            ipChange.ipc$dispatch("711069163", new Object[]{this, str});
        } else {
            this.liveH5Url = str;
        }
    }

    public void setLiveTicketBgUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1887335183")) {
            ipChange.ipc$dispatch("1887335183", new Object[]{this, str});
        } else {
            this.liveTicketBgUrl = str;
        }
    }

    public void setLiveType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "199939383")) {
            ipChange.ipc$dispatch("199939383", new Object[]{this, str});
        } else {
            this.liveType = str;
        }
    }

    public void setLocalExtAttr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1546229078")) {
            ipChange.ipc$dispatch("1546229078", new Object[]{this, str});
        } else {
            this.localExtAttr = str;
        }
    }

    public void setLocalUserProjectVO(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1007291039")) {
            ipChange.ipc$dispatch("-1007291039", new Object[]{this, str});
        } else {
            this.localUserProjectVO = str;
        }
    }

    public void setLocalUserVenueVO(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-790015413")) {
            ipChange.ipc$dispatch("-790015413", new Object[]{this, str});
        } else {
            this.localUserVenueVO = str;
        }
    }

    public void setMemberLevel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "968421559")) {
            ipChange.ipc$dispatch("968421559", new Object[]{this, str});
        } else {
            this.memberLevel = str;
        }
    }

    public void setPerformDetailTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "671499159")) {
            ipChange.ipc$dispatch("671499159", new Object[]{this, str});
        } else {
            this.performDetailTitle = str;
        }
    }

    public void setPerformId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1334191397")) {
            ipChange.ipc$dispatch("1334191397", new Object[]{this, str});
        } else {
            this.performId = str;
        }
    }

    public void setPerformOpList(ArrayList<PerformOpModule> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1142422029")) {
            ipChange.ipc$dispatch("-1142422029", new Object[]{this, arrayList});
        } else {
            this.performOpList = arrayList;
        }
    }

    public void setPerformOpListLocal(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "370408626")) {
            ipChange.ipc$dispatch("370408626", new Object[]{this, str});
        } else {
            this.performOpListLocal = str;
        }
    }

    public void setPerformStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-173291986")) {
            ipChange.ipc$dispatch("-173291986", new Object[]{this, str});
        } else {
            this.performStatus = str;
        }
    }

    public void setPerformType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815814618")) {
            ipChange.ipc$dispatch("-815814618", new Object[]{this, str});
        } else {
            this.performType = str;
        }
    }

    public void setProductSystemId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1732028008")) {
            ipChange.ipc$dispatch("1732028008", new Object[]{this, str});
        } else {
            this.productSystemId = str;
        }
    }

    public void setProjectImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "981431355")) {
            ipChange.ipc$dispatch("981431355", new Object[]{this, str});
            return;
        }
        UserProjectBean userProjectBean = this.userProjectVO;
        if (userProjectBean != null) {
            userProjectBean.projectImageUrl = str;
        }
    }

    public void setShowTimeRangeDetail(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1489071651")) {
            ipChange.ipc$dispatch("-1489071651", new Object[]{this, str});
        } else {
            this.showTimeRangeDetail = str;
        }
    }

    public void setStartTimeByLong(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "87546575")) {
            ipChange.ipc$dispatch("87546575", new Object[]{this, Long.valueOf(j)});
        } else {
            this.startTimeByLong = j;
        }
    }

    public void setTenantId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1845755256")) {
            ipChange.ipc$dispatch("1845755256", new Object[]{this, str});
        } else {
            this.tenantId = str;
        }
    }

    public void setTicketQuantity(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1983048551")) {
            ipChange.ipc$dispatch("1983048551", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.ticketQuantity = i;
        }
    }

    public void setTimeChangedReason(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1472110230")) {
            ipChange.ipc$dispatch("1472110230", new Object[]{this, str});
        } else {
            this.timeChangedReason = str;
        }
    }

    public void setTimeTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1043575466")) {
            ipChange.ipc$dispatch("-1043575466", new Object[]{this, str});
        } else {
            this.timeTitle = str;
        }
    }

    public void setTransferState(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736321874")) {
            ipChange.ipc$dispatch("736321874", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.transferState = i;
        }
    }

    public void setTransferWarn(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1553690548")) {
            ipChange.ipc$dispatch("-1553690548", new Object[]{this, str});
        } else {
            this.transferWarn = str;
        }
    }

    public void setTransferringNum(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322581207")) {
            ipChange.ipc$dispatch("1322581207", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.transferringNum = i;
        }
    }

    public void setUserCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "401826405")) {
            ipChange.ipc$dispatch("401826405", new Object[]{this, str});
        } else {
            this.userCode = str;
        }
    }

    public void setUserProjectVO(UserProjectBean userProjectBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "184470854")) {
            ipChange.ipc$dispatch("184470854", new Object[]{this, userProjectBean});
        } else {
            this.userProjectVO = userProjectBean;
        }
    }

    public void setUserTicketVOList(List<UserTicketTable> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-451204490")) {
            ipChange.ipc$dispatch("-451204490", new Object[]{this, list});
        } else {
            this.userTicketVOList = list;
        }
    }

    public void setUserVenueVO(UserVenueBean userVenueBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "670784390")) {
            ipChange.ipc$dispatch("670784390", new Object[]{this, userVenueBean});
        } else {
            this.userVenueVO = userVenueBean;
        }
    }

    public void setWithdrawVO(TransferBackBean transferBackBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-482837654")) {
            ipChange.ipc$dispatch("-482837654", new Object[]{this, transferBackBean});
        } else {
            this.withdrawVO = transferBackBean;
        }
    }
}
