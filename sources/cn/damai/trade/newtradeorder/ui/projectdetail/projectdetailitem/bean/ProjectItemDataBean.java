package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionContentsBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean.SkuPerformBase;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectItemDataBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String atmosphericPicUrl;
    private String bannerPicUrl;
    private String bannerRedirectUrl;
    private int buyBtnStatus;
    private String buyBtnStatusAfterCountDown;
    private String buyBtnText;
    private String buyBtnTextAfterCountDown;
    private String buyBtnTip;
    private String buyBtnTipAfterCountDown;
    private long countDown;
    private String dashPrice;
    public EarlyBirdVO earlyBirdVO;
    public boolean hasEarlyBird;
    public boolean hasWedHalfPrice;
    private String isSoldOutAndNoUnpaid;
    private String itemCouponIds;
    private List<String> itemCouponTag;
    private String itemPromotionIds;
    private List<String> itemPromotionTag;
    private MarketingStallBean marketingStall;
    private String needRealNameCertified;
    private long notifyCustomerTimeBeforeSellStart;
    private List<SkuPerformBase> performBases;
    private String priceRange;
    private String privilegeActivityIds;
    private String privilegeDesc;
    private String privilegeId;
    private String privilegeName;
    public cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PromotionBean promotionDetail;
    public List<PromotionItemBean> promotionList;
    public String promotionRemark;
    private List<PromotionContentsBean> promotions;
    private int purchaseLimitation;
    private String realNameCertifiedTip;
    private long sellStartTime;
    private String sellStartTimeStr;
    private StatusNotice statusNotice;
    private List<String> taomaiMemberTag;
    private String unpaidNotice;
    public WedHalfPriceVO wedHalfPriceVO;

    public String getAtmosphericPicUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1721004009") ? (String) ipChange.ipc$dispatch("1721004009", new Object[]{this}) : this.atmosphericPicUrl;
    }

    public String getBannerPicUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "367284832") ? (String) ipChange.ipc$dispatch("367284832", new Object[]{this}) : this.bannerPicUrl;
    }

    public String getBannerRedirectUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1225068206") ? (String) ipChange.ipc$dispatch("1225068206", new Object[]{this}) : this.bannerRedirectUrl;
    }

    public int getBuyBtnStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-524407012") ? ((Integer) ipChange.ipc$dispatch("-524407012", new Object[]{this})).intValue() : this.buyBtnStatus;
    }

    public String getBuyBtnStatusAfterCountDown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1230308108") ? (String) ipChange.ipc$dispatch("1230308108", new Object[]{this}) : this.buyBtnStatusAfterCountDown;
    }

    public String getBuyBtnText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "923112658") ? (String) ipChange.ipc$dispatch("923112658", new Object[]{this}) : this.buyBtnText;
    }

    public String getBuyBtnTextAfterCountDown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "875378695") ? (String) ipChange.ipc$dispatch("875378695", new Object[]{this}) : this.buyBtnTextAfterCountDown;
    }

    public String getBuyBtnTip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-272454324") ? (String) ipChange.ipc$dispatch("-272454324", new Object[]{this}) : this.buyBtnTip;
    }

    public String getBuyBtnTipAfterCountDown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1028590847") ? (String) ipChange.ipc$dispatch("-1028590847", new Object[]{this}) : this.buyBtnTipAfterCountDown;
    }

    public long getCountDown() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-432935236") ? ((Long) ipChange.ipc$dispatch("-432935236", new Object[]{this})).longValue() : this.countDown;
    }

    public String getDashPrice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "503439966") ? (String) ipChange.ipc$dispatch("503439966", new Object[]{this}) : this.dashPrice;
    }

    public String getIsSoldOutAndNoUnpaid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1490045980") ? (String) ipChange.ipc$dispatch("1490045980", new Object[]{this}) : this.isSoldOutAndNoUnpaid;
    }

    public String getItemCouponIds() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1268501094") ? (String) ipChange.ipc$dispatch("1268501094", new Object[]{this}) : this.itemCouponIds;
    }

    public List<String> getItemCouponTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-495004177") ? (List) ipChange.ipc$dispatch("-495004177", new Object[]{this}) : this.itemCouponTag;
    }

    public String getItemPromotionIds() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1479286057") ? (String) ipChange.ipc$dispatch("-1479286057", new Object[]{this}) : this.itemPromotionIds;
    }

    public List<String> getItemPromotionTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-837527904") ? (List) ipChange.ipc$dispatch("-837527904", new Object[]{this}) : this.itemPromotionTag;
    }

    public MarketingStallBean getMarketingStall() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-214788826") ? (MarketingStallBean) ipChange.ipc$dispatch("-214788826", new Object[]{this}) : this.marketingStall;
    }

    public String getNeedRealNameCertified() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "129617071") ? (String) ipChange.ipc$dispatch("129617071", new Object[]{this}) : this.needRealNameCertified;
    }

    public long getNotifyCustomerTimeBeforeSellStart() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1641911920") ? ((Long) ipChange.ipc$dispatch("1641911920", new Object[]{this})).longValue() : this.notifyCustomerTimeBeforeSellStart;
    }

    public List<SkuPerformBase> getPerformBases() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2106022679") ? (List) ipChange.ipc$dispatch("2106022679", new Object[]{this}) : this.performBases;
    }

    public String getPriceRange() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1172344707") ? (String) ipChange.ipc$dispatch("1172344707", new Object[]{this}) : this.priceRange;
    }

    public String getPrivilegeActivityIds() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-584570681") ? (String) ipChange.ipc$dispatch("-584570681", new Object[]{this}) : this.privilegeActivityIds;
    }

    public String getPrivilegeDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1662606569") ? (String) ipChange.ipc$dispatch("1662606569", new Object[]{this}) : this.privilegeDesc;
    }

    public String getPrivilegeId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1506139725") ? (String) ipChange.ipc$dispatch("-1506139725", new Object[]{this}) : this.privilegeId;
    }

    public String getPrivilegeName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "74586083") ? (String) ipChange.ipc$dispatch("74586083", new Object[]{this}) : this.privilegeName;
    }

    public String getPromotionRemark() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1585209482") ? (String) ipChange.ipc$dispatch("1585209482", new Object[]{this}) : this.promotionRemark;
    }

    public List<PromotionContentsBean> getPromotions() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1945218470") ? (List) ipChange.ipc$dispatch("1945218470", new Object[]{this}) : this.promotions;
    }

    public int getPurchaseLimitation() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1429526217") ? ((Integer) ipChange.ipc$dispatch("1429526217", new Object[]{this})).intValue() : this.purchaseLimitation;
    }

    public String getRealNameCertifiedTip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1441176748") ? (String) ipChange.ipc$dispatch("1441176748", new Object[]{this}) : this.realNameCertifiedTip;
    }

    public long getSellStartTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-194397072") ? ((Long) ipChange.ipc$dispatch("-194397072", new Object[]{this})).longValue() : this.sellStartTime;
    }

    public String getSellStartTimeStr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-933823261") ? (String) ipChange.ipc$dispatch("-933823261", new Object[]{this}) : this.sellStartTimeStr;
    }

    public StatusNotice getStatusNotice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1076734998") ? (StatusNotice) ipChange.ipc$dispatch("1076734998", new Object[]{this}) : this.statusNotice;
    }

    public List<String> getTaomaiMemberTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1714686363") ? (List) ipChange.ipc$dispatch("1714686363", new Object[]{this}) : this.taomaiMemberTag;
    }

    public String getUnpaidNotice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "768615084") ? (String) ipChange.ipc$dispatch("768615084", new Object[]{this}) : this.unpaidNotice;
    }

    public String isNeedRealNameCertified() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1154392887") ? (String) ipChange.ipc$dispatch("1154392887", new Object[]{this}) : this.needRealNameCertified;
    }

    public void setAtmosphericPicUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1472455763")) {
            ipChange.ipc$dispatch("-1472455763", new Object[]{this, str});
        } else {
            this.atmosphericPicUrl = str;
        }
    }

    public void setBannerPicUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1101191042")) {
            ipChange.ipc$dispatch("-1101191042", new Object[]{this, str});
        } else {
            this.bannerPicUrl = str;
        }
    }

    public void setBannerRedirectUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "333403528")) {
            ipChange.ipc$dispatch("333403528", new Object[]{this, str});
        } else {
            this.bannerRedirectUrl = str;
        }
    }

    public void setBuyBtnStatus(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-620446202")) {
            ipChange.ipc$dispatch("-620446202", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.buyBtnStatus = i;
        }
    }

    public void setBuyBtnStatusAfterCountDown(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-637554094")) {
            ipChange.ipc$dispatch("-637554094", new Object[]{this, str});
        } else {
            this.buyBtnStatusAfterCountDown = str;
        }
    }

    public void setBuyBtnText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "736805196")) {
            ipChange.ipc$dispatch("736805196", new Object[]{this, str});
        } else {
            this.buyBtnText = str;
        }
    }

    public void setBuyBtnTextAfterCountDown(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1413879369")) {
            ipChange.ipc$dispatch("-1413879369", new Object[]{this, str});
        } else {
            this.buyBtnTextAfterCountDown = str;
        }
    }

    public void setBuyBtnTip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1821354326")) {
            ipChange.ipc$dispatch("-1821354326", new Object[]{this, str});
        } else {
            this.buyBtnTip = str;
        }
    }

    public void setBuyBtnTipAfterCountDown(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1175993707")) {
            ipChange.ipc$dispatch("-1175993707", new Object[]{this, str});
        } else {
            this.buyBtnTipAfterCountDown = str;
        }
    }

    public void setCountDown(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1927464816")) {
            ipChange.ipc$dispatch("1927464816", new Object[]{this, Long.valueOf(j)});
        } else {
            this.countDown = j;
        }
    }

    public void setDashPrice(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "756532184")) {
            ipChange.ipc$dispatch("756532184", new Object[]{this, str});
        } else {
            this.dashPrice = str;
        }
    }

    public void setIsSoldOutAndNoUnpaid(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1995525566")) {
            ipChange.ipc$dispatch("-1995525566", new Object[]{this, str});
        } else {
            this.isSoldOutAndNoUnpaid = str;
        }
    }

    public void setItemCouponIds(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1199835440")) {
            ipChange.ipc$dispatch("-1199835440", new Object[]{this, str});
        } else {
            this.itemCouponIds = str;
        }
    }

    public void setItemCouponTag(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "440335189")) {
            ipChange.ipc$dispatch("440335189", new Object[]{this, list});
        } else {
            this.itemCouponTag = list;
        }
    }

    public void setItemPromotionIds(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "214977767")) {
            ipChange.ipc$dispatch("214977767", new Object[]{this, str});
        } else {
            this.itemPromotionIds = str;
        }
    }

    public void setItemPromotionTag(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1594878764")) {
            ipChange.ipc$dispatch("1594878764", new Object[]{this, list});
        } else {
            this.itemPromotionTag = list;
        }
    }

    public void setMarketingStall(MarketingStallBean marketingStallBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006236276")) {
            ipChange.ipc$dispatch("2006236276", new Object[]{this, marketingStallBean});
        } else {
            this.marketingStall = marketingStallBean;
        }
    }

    public void setNeedRealNameCertified(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-741772889")) {
            ipChange.ipc$dispatch("-741772889", new Object[]{this, str});
        } else {
            this.needRealNameCertified = str;
        }
    }

    public void setNotifyCustomerTimeBeforeSellStart(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-281216452")) {
            ipChange.ipc$dispatch("-281216452", new Object[]{this, Long.valueOf(j)});
        } else {
            this.notifyCustomerTimeBeforeSellStart = j;
        }
    }

    public void setPerformBases(List<SkuPerformBase> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-342143083")) {
            ipChange.ipc$dispatch("-342143083", new Object[]{this, list});
        } else {
            this.performBases = list;
        }
    }

    public void setPriceRange(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-126935877")) {
            ipChange.ipc$dispatch("-126935877", new Object[]{this, str});
        } else {
            this.priceRange = str;
        }
    }

    public void setPrivilegeActivityIds(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1884132617")) {
            ipChange.ipc$dispatch("-1884132617", new Object[]{this, str});
        } else {
            this.privilegeActivityIds = str;
        }
    }

    public void setPrivilegeDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1867467603")) {
            ipChange.ipc$dispatch("-1867467603", new Object[]{this, str});
        } else {
            this.privilegeDesc = str;
        }
    }

    public void setPrivilegeId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1745642461")) {
            ipChange.ipc$dispatch("-1745642461", new Object[]{this, str});
        } else {
            this.privilegeId = str;
        }
    }

    public void setPrivilegeName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443504883")) {
            ipChange.ipc$dispatch("443504883", new Object[]{this, str});
        } else {
            this.privilegeName = str;
        }
    }

    public void setPromotionRemark(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2116300244")) {
            ipChange.ipc$dispatch("-2116300244", new Object[]{this, str});
        } else {
            this.promotionRemark = str;
        }
    }

    public void setPromotions(List<PromotionContentsBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1195449318")) {
            ipChange.ipc$dispatch("1195449318", new Object[]{this, list});
        } else {
            this.promotions = list;
        }
    }

    public void setPurchaseLimitation(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2086006023")) {
            ipChange.ipc$dispatch("-2086006023", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.purchaseLimitation = i;
        }
    }

    public void setRealNameCertifiedTip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "784495538")) {
            ipChange.ipc$dispatch("784495538", new Object[]{this, str});
        } else {
            this.realNameCertifiedTip = str;
        }
    }

    public void setSellStartTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1952732732")) {
            ipChange.ipc$dispatch("1952732732", new Object[]{this, Long.valueOf(j)});
        } else {
            this.sellStartTime = j;
        }
    }

    public void setSellStartTimeStr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-55544741")) {
            ipChange.ipc$dispatch("-55544741", new Object[]{this, str});
        } else {
            this.sellStartTimeStr = str;
        }
    }

    public void setStatusNotice(StatusNotice statusNotice) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1567885252")) {
            ipChange.ipc$dispatch("1567885252", new Object[]{this, statusNotice});
        } else {
            this.statusNotice = statusNotice;
        }
    }

    public void setTaomaiMemberTag(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652552745")) {
            ipChange.ipc$dispatch("652552745", new Object[]{this, list});
        } else {
            this.taomaiMemberTag = list;
        }
    }

    public void setUnpaidNotice(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1544855118")) {
            ipChange.ipc$dispatch("-1544855118", new Object[]{this, str});
        } else {
            this.unpaidNotice = str;
        }
    }

    public boolean showWantSeeGuideTips() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1509944057")) {
            return ((Boolean) ipChange.ipc$dispatch("1509944057", new Object[]{this})).booleanValue();
        }
        int i = this.buyBtnStatus;
        return i == 90 || i == 91 || i == 106;
    }

    public boolean showWantSeeTips() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1970621331")) {
            return ((Boolean) ipChange.ipc$dispatch("-1970621331", new Object[]{this})).booleanValue();
        }
        int i = this.buyBtnStatus;
        return i == 92 || i == 99 || i == 100 || i == 204 || i == 206 || i == 216 || i == 217 || i == 230 || i == 231 || i == 303;
    }
}
