package cn.damai.ticklet.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.ColorUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.in2;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TicketDeatilResult implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    private int[] bgGradientColors;
    private float[] bgGradientPostions;
    private EmptyDataVO emptyDataVO;
    public int hasMore;
    public Boolean isLocalData = Boolean.FALSE;
    public long loadTime = 0;
    private int mainColor;
    public ArrayList<TickletDetailModuleBean> modules;
    private int pageBgColor;
    public String pagingKey;
    public Long serverTimestamp;
    private PerformTable userPerformVO;

    public AnnouncementVO getAnnouncement() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1841199277") ? (AnnouncementVO) ipChange.ipc$dispatch("1841199277", new Object[]{this}) : this.userPerformVO.getAnnouncement();
    }

    public Long getBeginTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-814422483") ? (Long) ipChange.ipc$dispatch("-814422483", new Object[]{this}) : Long.valueOf(this.userPerformVO.getStartTimeByLong());
    }

    public int[] getBgGradientColors() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "434718269") ? (int[]) ipChange.ipc$dispatch("434718269", new Object[]{this}) : this.bgGradientColors;
    }

    public float[] getBgGradientPostions() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1022967253") ? (float[]) ipChange.ipc$dispatch("1022967253", new Object[]{this}) : this.bgGradientPostions;
    }

    public String getChangeDateReason() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1560897930") ? (String) ipChange.ipc$dispatch("-1560897930", new Object[]{this}) : this.userPerformVO.getTimeChangedReason();
    }

    public String getChangeDateState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1743290005") ? (String) ipChange.ipc$dispatch("1743290005", new Object[]{this}) : this.userPerformVO.getIsTimeChanged();
    }

    public int getColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "273524462") ? ((Integer) ipChange.ipc$dispatch("273524462", new Object[]{this})).intValue() : this.mainColor;
    }

    public TicketAlipayCardBean getEcertTipsInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1282224301") ? (TicketAlipayCardBean) ipChange.ipc$dispatch("1282224301", new Object[]{this}) : this.userPerformVO.ecertTipsInfo;
    }

    public EmptyDataVO getEmptyDataVO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1830040318") ? (EmptyDataVO) ipChange.ipc$dispatch("-1830040318", new Object[]{this}) : this.emptyDataVO;
    }

    public int getEsouvenirEnable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1054910842") ? ((Integer) ipChange.ipc$dispatch("1054910842", new Object[]{this})).intValue() : this.userPerformVO.getEsouvenirEnable();
    }

    public int getHasMore() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1395379326") ? ((Integer) ipChange.ipc$dispatch("-1395379326", new Object[]{this})).intValue() : this.hasMore;
    }

    public String getIsCertPerform() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-547801675") ? (String) ipChange.ipc$dispatch("-547801675", new Object[]{this}) : this.userPerformVO.getIsCertPerform();
    }

    public String getItemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1815012322") ? (String) ipChange.ipc$dispatch("1815012322", new Object[]{this}) : this.userPerformVO.getItemId();
    }

    public String getLiveH5Url() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-13673352") ? (String) ipChange.ipc$dispatch("-13673352", new Object[]{this}) : this.userPerformVO.getLiveH5Url();
    }

    public String getLiveTicketBgUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1486058476") ? (String) ipChange.ipc$dispatch("-1486058476", new Object[]{this}) : this.userPerformVO.getLiveTicketBgUrl();
    }

    public String getLiveType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-362582950") ? (String) ipChange.ipc$dispatch("-362582950", new Object[]{this}) : this.userPerformVO.getLiveType();
    }

    public long getLoadTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-493026483") ? ((Long) ipChange.ipc$dispatch("-493026483", new Object[]{this})).longValue() : this.loadTime;
    }

    public String getLocaleName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1085688409") ? (String) ipChange.ipc$dispatch("1085688409", new Object[]{this}) : this.userPerformVO.getLocaleName();
    }

    public String getLongtermProject() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1095167757") ? (String) ipChange.ipc$dispatch("-1095167757", new Object[]{this}) : this.userPerformVO.getIsLongtermProject();
    }

    public void getMainColorFun() {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "185464183")) {
            ipChange.ipc$dispatch("185464183", new Object[]{this});
            return;
        }
        if (getPerformExtAttr() == null || wh2.e(getPerformExtAttr().bgColor) <= 0 || TextUtils.isEmpty(getPerformExtAttr().bgColor.get(0))) {
            str = in2.DETAIL_PAGE_DEFAULT_COLOR;
            str2 = "#965BBD";
        } else {
            str2 = getPerformExtAttr().bgColor.get(0);
            str = getPerformExtAttr().bgColor.get(getPerformExtAttr().bgColor.size() - 1);
        }
        this.mainColor = ColorUtil.parseColorSafely(str2, "#965BBD");
        this.pageBgColor = ColorUtil.parseColorSafely(str, in2.DETAIL_PAGE_DEFAULT_COLOR);
    }

    public String getMemberLevel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "983977452")) {
            return (String) ipChange.ipc$dispatch("983977452", new Object[]{this});
        }
        if (getUserPerformVO() == null) {
            return null;
        }
        return getUserPerformVO().getMemberLevel();
    }

    public String getMoreType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "733318083") ? (String) ipChange.ipc$dispatch("733318083", new Object[]{this}) : this.userPerformVO.getIsMoreEnter();
    }

    public int getPageBgColor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1519427710") ? ((Integer) ipChange.ipc$dispatch("-1519427710", new Object[]{this})).intValue() : this.pageBgColor;
    }

    public String getPagingKey() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1978705067") ? (String) ipChange.ipc$dispatch("-1978705067", new Object[]{this}) : this.pagingKey;
    }

    public String getPerformDetailTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1888658746") ? (String) ipChange.ipc$dispatch("1888658746", new Object[]{this}) : this.userPerformVO.getPerformDetailTitle();
    }

    public PerformExtAttr getPerformExtAttr() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "874653574")) {
            return (PerformExtAttr) ipChange.ipc$dispatch("874653574", new Object[]{this});
        }
        if (getUserPerformVO() == null || getUserPerformVO().getExtAttr() == null) {
            return null;
        }
        return getUserPerformVO().getExtAttr();
    }

    public String getPerformId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "837711358") ? (String) ipChange.ipc$dispatch("837711358", new Object[]{this}) : this.userPerformVO.getPerformId();
    }

    public PerformNftExtAttr getPerformNftExtAttr() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "616701300")) {
            return (PerformNftExtAttr) ipChange.ipc$dispatch("616701300", new Object[]{this});
        }
        if (getUserPerformVO() == null || getUserPerformVO().getExtAttr() == null) {
            return null;
        }
        return getUserPerformVO().getExtAttr().nftAttr;
    }

    public String getPerformStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "584211285") ? (String) ipChange.ipc$dispatch("584211285", new Object[]{this}) : this.userPerformVO.getPerformStatus();
    }

    public String getProjectId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-513884234") ? (String) ipChange.ipc$dispatch("-513884234", new Object[]{this}) : this.userPerformVO.getProjectId();
    }

    public String getProjectImage() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1206853974") ? (String) ipChange.ipc$dispatch("1206853974", new Object[]{this}) : this.userPerformVO.getProjectImage();
    }

    public String getProjectName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "149373222") ? (String) ipChange.ipc$dispatch("149373222", new Object[]{this}) : this.userPerformVO.getProjectName();
    }

    public Long getServerTimestamp() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1886242218") ? (Long) ipChange.ipc$dispatch("1886242218", new Object[]{this}) : this.serverTimestamp;
    }

    public String getShowTimeRangeDetail() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1288304890") ? (String) ipChange.ipc$dispatch("-1288304890", new Object[]{this}) : this.userPerformVO.getShowTimeRangeDetail();
    }

    public List<UserTicketTable> getTicketInfoList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "153656467") ? (List) ipChange.ipc$dispatch("153656467", new Object[]{this}) : this.userPerformVO.getUserTicketVOList();
    }

    public int getTicketNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "530146711") ? ((Integer) ipChange.ipc$dispatch("530146711", new Object[]{this})).intValue() : this.userPerformVO.getTicketQuantity();
    }

    public String getTimeTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "622461869") ? (String) ipChange.ipc$dispatch("622461869", new Object[]{this}) : this.userPerformVO.getTimeTitle();
    }

    public String getTransferBackDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-361344585") ? (String) ipChange.ipc$dispatch("-361344585", new Object[]{this}) : this.userPerformVO.getTransferBackDesc();
    }

    public String getTransferBackUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-354734465") ? (String) ipChange.ipc$dispatch("-354734465", new Object[]{this}) : this.userPerformVO.getTransferBackUrl();
    }

    public String getTransferWarn() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2094907173") ? (String) ipChange.ipc$dispatch("2094907173", new Object[]{this}) : this.userPerformVO.getTransferWarn();
    }

    public int getTransferringNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-588993242") ? ((Integer) ipChange.ipc$dispatch("-588993242", new Object[]{this})).intValue() : this.userPerformVO.getTransferringNum();
    }

    public PerformTable getUserPerformVO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-858889418") ? (PerformTable) ipChange.ipc$dispatch("-858889418", new Object[]{this}) : this.userPerformVO;
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1128159292") ? (String) ipChange.ipc$dispatch("1128159292", new Object[]{this}) : this.userPerformVO.getVenueName();
    }

    public boolean isLivePerform() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1394955813") ? ((Boolean) ipChange.ipc$dispatch("-1394955813", new Object[]{this})).booleanValue() : "1".equals(this.userPerformVO.getIsLive());
    }

    public boolean isNftPerform() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1254143715")) {
            return ((Boolean) ipChange.ipc$dispatch("-1254143715", new Object[]{this})).booleanValue();
        }
        PerformTable performTable = this.userPerformVO;
        if (performTable == null) {
            return false;
        }
        return performTable.isNftPerform();
    }

    public void setBgGradientColors(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-211245239")) {
            ipChange.ipc$dispatch("-211245239", new Object[]{this, iArr});
        } else {
            this.bgGradientColors = iArr;
        }
    }

    public void setBgGradientPostions(float[] fArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2020920011")) {
            ipChange.ipc$dispatch("2020920011", new Object[]{this, fArr});
        } else {
            this.bgGradientPostions = fArr;
        }
    }

    public void setColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "184671761")) {
            ipChange.ipc$dispatch("184671761", new Object[]{this, str});
            return;
        }
        PerformTable performTable = this.userPerformVO;
        if (performTable != null) {
            performTable.setColor(str);
        }
    }

    public void setEmptyDataVO(EmptyDataVO emptyDataVO) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1113869718")) {
            ipChange.ipc$dispatch("-1113869718", new Object[]{this, emptyDataVO});
        } else {
            this.emptyDataVO = emptyDataVO;
        }
    }

    public void setHasMore(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2078792504")) {
            ipChange.ipc$dispatch("-2078792504", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.hasMore = i;
        }
    }

    public void setLoadTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1488135785")) {
            ipChange.ipc$dispatch("-1488135785", new Object[]{this, Long.valueOf(j)});
        } else {
            this.loadTime = j;
        }
    }

    public void setPagingKey(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1119447489")) {
            ipChange.ipc$dispatch("1119447489", new Object[]{this, str});
        } else {
            this.pagingKey = str;
        }
    }

    public void setProjectImage(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-844351416")) {
            ipChange.ipc$dispatch("-844351416", new Object[]{this, str});
        } else {
            this.userPerformVO.setProjectImage(str);
        }
    }

    public void setServerTimestamp(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2062542934")) {
            ipChange.ipc$dispatch("2062542934", new Object[]{this, l});
        } else {
            this.serverTimestamp = l;
        }
    }

    public void setUserPerformVO(PerformTable performTable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1709896426")) {
            ipChange.ipc$dispatch("1709896426", new Object[]{this, performTable});
        } else {
            this.userPerformVO = performTable;
        }
    }
}
