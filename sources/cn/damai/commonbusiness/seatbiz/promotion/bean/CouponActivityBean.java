package cn.damai.commonbusiness.seatbiz.promotion.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CouponActivityBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAOMAI_VIP_ENABLE_USED = "0";
    public static final String TAOMAI_VIP_HAS_CHANGE = "1";
    public static final String TAOMAI_VIP_INTEGRAL_LITTLE = "4";
    public static final String TAOMAI_VIP_LEVEL_LOW = "3";
    public static final String TAOMAI_VIP_NOAUTH_ISVIP = "31";
    public static final String TAOMAI_VIP_NOAUTH_NOTVIP = "32";
    private static final long serialVersionUID = 2748259609122281777L;
    private String applicable;
    private String authorizeProfitText;
    private String couponActSpreadId;
    private String desc;
    private String discountDesc;
    private String effectiveEndTime;
    private String effectiveStartTime;
    private String exchange4Dm;
    private String gainType;
    private String gainWholly;
    private String id;
    private boolean isMaxVipLastOne;
    private boolean isNeedAuthorizeProfit;
    private int mActivityType;
    private String name;
    private String profitAsac;
    private int profitCurrentPoint;
    private String profitDrawButtonText;
    private String profitDrawStatus;
    private String profitId;
    private String profitPoint;
    private Integer profitPointDiscount;
    private String profitPoolId;
    private String profitPoolSpreadId;
    private Integer reductionProfitPoint;
    private String status;
    private List<CouponSubActBean> subCouponActExs;
    private String unapplicableCause;

    public String getAuthorizeProfitText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1174171065") ? (String) ipChange.ipc$dispatch("1174171065", new Object[]{this}) : this.authorizeProfitText;
    }

    public String getCouponActSpreadId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2060302087") ? (String) ipChange.ipc$dispatch("-2060302087", new Object[]{this}) : this.couponActSpreadId;
    }

    public String getDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1702610376") ? (String) ipChange.ipc$dispatch("1702610376", new Object[]{this}) : this.desc;
    }

    public String getDiscountDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2139504681") ? (String) ipChange.ipc$dispatch("2139504681", new Object[]{this}) : this.discountDesc;
    }

    public String getEffectiveEndTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "204315608") ? (String) ipChange.ipc$dispatch("204315608", new Object[]{this}) : this.effectiveEndTime;
    }

    public String getEffectiveStartTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1534629151") ? (String) ipChange.ipc$dispatch("1534629151", new Object[]{this}) : this.effectiveStartTime;
    }

    public String getExchange4Dm() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "792419897") ? (String) ipChange.ipc$dispatch("792419897", new Object[]{this}) : this.exchange4Dm;
    }

    public String getGainType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1251265392") ? (String) ipChange.ipc$dispatch("-1251265392", new Object[]{this}) : this.gainType;
    }

    public String getGainWholly() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1118512495") ? (String) ipChange.ipc$dispatch("-1118512495", new Object[]{this}) : this.gainWholly;
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "697251410") ? (String) ipChange.ipc$dispatch("697251410", new Object[]{this}) : this.id;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "114589890") ? (String) ipChange.ipc$dispatch("114589890", new Object[]{this}) : this.name;
    }

    public String getProfitAsac() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1848798993") ? (String) ipChange.ipc$dispatch("-1848798993", new Object[]{this}) : this.profitAsac;
    }

    public int getProfitCurrentPoint() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1653662431") ? ((Integer) ipChange.ipc$dispatch("-1653662431", new Object[]{this})).intValue() : this.profitCurrentPoint;
    }

    public String getProfitDrawButtonText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1717892990") ? (String) ipChange.ipc$dispatch("1717892990", new Object[]{this}) : this.profitDrawButtonText;
    }

    public String getProfitDrawStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1415320177") ? (String) ipChange.ipc$dispatch("1415320177", new Object[]{this}) : this.profitDrawStatus;
    }

    public String getProfitId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1829997386") ? (String) ipChange.ipc$dispatch("-1829997386", new Object[]{this}) : this.profitId;
    }

    public String getProfitPoint() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1291203573") ? (String) ipChange.ipc$dispatch("-1291203573", new Object[]{this}) : this.profitPoint;
    }

    public Integer getProfitPointDiscount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-157453733") ? (Integer) ipChange.ipc$dispatch("-157453733", new Object[]{this}) : this.profitPointDiscount;
    }

    public String getProfitPoolId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1025813518") ? (String) ipChange.ipc$dispatch("-1025813518", new Object[]{this}) : this.profitPoolId;
    }

    public String getProfitPoolSpreadId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2049281979") ? (String) ipChange.ipc$dispatch("-2049281979", new Object[]{this}) : this.profitPoolSpreadId;
    }

    public Integer getReductionProfitPoint() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1575653719") ? (Integer) ipChange.ipc$dispatch("1575653719", new Object[]{this}) : this.reductionProfitPoint;
    }

    public String getStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-525151831") ? (String) ipChange.ipc$dispatch("-525151831", new Object[]{this}) : this.status;
    }

    public List<CouponSubActBean> getSubCouponActExs() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1357804262") ? (List) ipChange.ipc$dispatch("-1357804262", new Object[]{this}) : this.subCouponActExs;
    }

    public String getUnapplicableCause() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1491730640") ? (String) ipChange.ipc$dispatch("-1491730640", new Object[]{this}) : this.unapplicableCause;
    }

    public String isApplicable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1960454402") ? (String) ipChange.ipc$dispatch("-1960454402", new Object[]{this}) : this.applicable;
    }

    public boolean isMaxVipEnable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1178332567") ? ((Boolean) ipChange.ipc$dispatch("-1178332567", new Object[]{this})).booleanValue() : "0".equals(getProfitDrawStatus());
    }

    public boolean isMaxVipHasChange() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1875398628") ? ((Boolean) ipChange.ipc$dispatch("-1875398628", new Object[]{this})).booleanValue() : "1".equals(getProfitDrawStatus());
    }

    public boolean isMaxVipIntegralLittle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-20265782") ? ((Boolean) ipChange.ipc$dispatch("-20265782", new Object[]{this})).booleanValue() : "4".equals(getProfitDrawStatus());
    }

    public boolean isMaxVipLastOne() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2053766294") ? ((Boolean) ipChange.ipc$dispatch("2053766294", new Object[]{this})).booleanValue() : this.isMaxVipLastOne;
    }

    public boolean isMaxVipLevelLow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "257409756") ? ((Boolean) ipChange.ipc$dispatch("257409756", new Object[]{this})).booleanValue() : "3".equals(getProfitDrawStatus());
    }

    public boolean isNeedAuthorizeProfit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1938262806") ? ((Boolean) ipChange.ipc$dispatch("1938262806", new Object[]{this})).booleanValue() : this.isNeedAuthorizeProfit;
    }

    public boolean isNoauthIsVip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1411096285") ? ((Boolean) ipChange.ipc$dispatch("-1411096285", new Object[]{this})).booleanValue() : "31".equals(getProfitDrawStatus());
    }

    public boolean isNoauthNotVip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "684074354") ? ((Boolean) ipChange.ipc$dispatch("684074354", new Object[]{this})).booleanValue() : "32".equals(getProfitDrawStatus());
    }

    public boolean isTaoMaxVip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "65168210") ? ((Boolean) ipChange.ipc$dispatch("65168210", new Object[]{this})).booleanValue() : this.mActivityType == 1;
    }

    public void setActivityType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1471125105")) {
            ipChange.ipc$dispatch("-1471125105", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mActivityType = i;
        }
    }

    public void setApplicable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1526140984")) {
            ipChange.ipc$dispatch("-1526140984", new Object[]{this, str});
        } else {
            this.applicable = str;
        }
    }

    public void setAuthorizeProfitText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-580713251")) {
            ipChange.ipc$dispatch("-580713251", new Object[]{this, str});
        } else {
            this.authorizeProfitText = str;
        }
    }

    public void setCouponActSpreadId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1566139549")) {
            ipChange.ipc$dispatch("1566139549", new Object[]{this, str});
        } else {
            this.couponActSpreadId = str;
        }
    }

    public void setDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "948557334")) {
            ipChange.ipc$dispatch("948557334", new Object[]{this, str});
        } else {
            this.desc = str;
        }
    }

    public void setDiscountDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1996950571")) {
            ipChange.ipc$dispatch("-1996950571", new Object[]{this, str});
        } else {
            this.discountDesc = str;
        }
    }

    public void setEffectiveEndTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "867021830")) {
            ipChange.ipc$dispatch("867021830", new Object[]{this, str});
        } else {
            this.effectiveEndTime = str;
        }
    }

    public void setEffectiveStartTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "286856863")) {
            ipChange.ipc$dispatch("286856863", new Object[]{this, str});
        } else {
            this.effectiveStartTime = str;
        }
    }

    public void setExchange4Dm(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "790229085")) {
            ipChange.ipc$dispatch("790229085", new Object[]{this, str});
        } else {
            this.exchange4Dm = str;
        }
    }

    public void setGainType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-16849330")) {
            ipChange.ipc$dispatch("-16849330", new Object[]{this, str});
        } else {
            this.gainType = str;
        }
    }

    public void setGainWholly(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1870934893")) {
            ipChange.ipc$dispatch("1870934893", new Object[]{this, str});
        } else {
            this.gainWholly = str;
        }
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1018690612")) {
            ipChange.ipc$dispatch("-1018690612", new Object[]{this, str});
        } else {
            this.id = str;
        }
    }

    public void setMaxVipLastOne(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "654026270")) {
            ipChange.ipc$dispatch("654026270", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isMaxVipLastOne = z;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1035437476")) {
            ipChange.ipc$dispatch("-1035437476", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public void setNeedAuthorizeProfit(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1046330722")) {
            ipChange.ipc$dispatch("-1046330722", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isNeedAuthorizeProfit = z;
        }
    }

    public void setProfitAsac(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706889935")) {
            ipChange.ipc$dispatch("706889935", new Object[]{this, str});
        } else {
            this.profitAsac = str;
        }
    }

    public void setProfitCurrentPoint(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1119393697")) {
            ipChange.ipc$dispatch("1119393697", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.profitCurrentPoint = i;
        }
    }

    public void setProfitDrawButtonText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "772764448")) {
            ipChange.ipc$dispatch("772764448", new Object[]{this, str});
        } else {
            this.profitDrawButtonText = str;
        }
    }

    public void setProfitDrawStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-246542195")) {
            ipChange.ipc$dispatch("-246542195", new Object[]{this, str});
        } else {
            this.profitDrawStatus = str;
        }
    }

    public void setProfitId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-777671960")) {
            ipChange.ipc$dispatch("-777671960", new Object[]{this, str});
        } else {
            this.profitId = str;
        }
    }

    public void setProfitPoint(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "622410955")) {
            ipChange.ipc$dispatch("622410955", new Object[]{this, str});
        } else {
            this.profitPoint = str;
        }
    }

    public void setProfitPointDiscount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-765368637")) {
            ipChange.ipc$dispatch("-765368637", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.profitPointDiscount = Integer.valueOf(i);
        }
    }

    public void setProfitPoolId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1337566932")) {
            ipChange.ipc$dispatch("-1337566932", new Object[]{this, str});
        } else {
            this.profitPoolId = str;
        }
    }

    public void setProfitPoolSpreadId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "854761529")) {
            ipChange.ipc$dispatch("854761529", new Object[]{this, str});
        } else {
            this.profitPoolSpreadId = str;
        }
    }

    public void setReductionProfitPoint(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913578463")) {
            ipChange.ipc$dispatch("1913578463", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.reductionProfitPoint = Integer.valueOf(i);
        }
    }

    public void setStatus(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-494929579")) {
            ipChange.ipc$dispatch("-494929579", new Object[]{this, str});
        } else {
            this.status = str;
        }
    }

    public void setSubCouponActExs(List<CouponSubActBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-105376118")) {
            ipChange.ipc$dispatch("-105376118", new Object[]{this, list});
        } else {
            this.subCouponActExs = list;
        }
    }

    public void setUnapplicableCause(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2011985222")) {
            ipChange.ipc$dispatch("2011985222", new Object[]{this, str});
        } else {
            this.unapplicableCause = str;
        }
    }
}
