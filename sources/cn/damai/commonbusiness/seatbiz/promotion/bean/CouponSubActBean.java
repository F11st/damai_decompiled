package cn.damai.commonbusiness.seatbiz.promotion.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CouponSubActBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SUB_BIZ_TYPE_MEMBER_COUPON_ORDER_BOGO = "MEMBER_COUPON_ORDER_BOGO";
    public static final String SUB_BIZ_TYPE_MEMBER_COUPON_ORDER_REDUCE = "MEMBER_COUPON_ORDER_REDUCE";
    public static final String SUB_BIZ_TYPE_MEMBER_COUPON_ORDER_REDUCE_TO = "MEMBER_COUPON_ORDER_REDUCE_TO";
    private static final long serialVersionUID = 6500649418656554120L;
    private String appAsacCode;
    private String applicable;
    private String decreaseMoneyNum;
    private String decreaseMoneyTag;
    private String desc;
    private String effectiveEndTime;
    private String effectiveStartTime;
    private String effectiveTimeText;
    private String id;
    private String name;
    private String overAmountText;
    public String subBizType;
    private String tag;
    private String unapplicableCause;

    public String getAppAsacCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1374821374") ? (String) ipChange.ipc$dispatch("1374821374", new Object[]{this}) : this.appAsacCode;
    }

    public String getDecreaseMoneyNum() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1620341314") ? (String) ipChange.ipc$dispatch("-1620341314", new Object[]{this}) : this.decreaseMoneyNum;
    }

    public String getDecreaseMoneyTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1903374382") ? (String) ipChange.ipc$dispatch("-1903374382", new Object[]{this}) : this.decreaseMoneyTag;
    }

    public String getDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "670861547") ? (String) ipChange.ipc$dispatch("670861547", new Object[]{this}) : this.desc;
    }

    public String getEffectiveEndTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2022425211") ? (String) ipChange.ipc$dispatch("2022425211", new Object[]{this}) : this.effectiveEndTime;
    }

    public String getEffectiveStartTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "686268162") ? (String) ipChange.ipc$dispatch("686268162", new Object[]{this}) : this.effectiveStartTime;
    }

    public String getEffectiveTimeText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1883623171") ? (String) ipChange.ipc$dispatch("-1883623171", new Object[]{this}) : this.effectiveTimeText;
    }

    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-90413515") ? (String) ipChange.ipc$dispatch("-90413515", new Object[]{this}) : this.id;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-917158939") ? (String) ipChange.ipc$dispatch("-917158939", new Object[]{this}) : this.name;
    }

    public String getOverAmountText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "217951539") ? (String) ipChange.ipc$dispatch("217951539", new Object[]{this}) : this.overAmountText;
    }

    public String getTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1959229302") ? (String) ipChange.ipc$dispatch("1959229302", new Object[]{this}) : this.tag;
    }

    public String getUnapplicableCause() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-964907795") ? (String) ipChange.ipc$dispatch("-964907795", new Object[]{this}) : this.unapplicableCause;
    }

    public String isApplicable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1432392123") ? (String) ipChange.ipc$dispatch("1432392123", new Object[]{this}) : this.applicable;
    }

    public void setAppAsacCode(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1664805688")) {
            ipChange.ipc$dispatch("1664805688", new Object[]{this, str});
        } else {
            this.appAsacCode = str;
        }
    }

    public void setApplicable(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-880808123")) {
            ipChange.ipc$dispatch("-880808123", new Object[]{this, str});
        } else {
            this.applicable = str;
        }
    }

    public void setDecreaseMoneyNum(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "137232096")) {
            ipChange.ipc$dispatch("137232096", new Object[]{this, str});
        } else {
            this.decreaseMoneyNum = str;
        }
    }

    public void setDecreaseMoneyTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-46858420")) {
            ipChange.ipc$dispatch("-46858420", new Object[]{this, str});
        } else {
            this.decreaseMoneyTag = str;
        }
    }

    public void setDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970885293")) {
            ipChange.ipc$dispatch("-970885293", new Object[]{this, str});
        } else {
            this.desc = str;
        }
    }

    public void setEffectiveEndTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1393844675")) {
            ipChange.ipc$dispatch("1393844675", new Object[]{this, str});
        } else {
            this.effectiveEndTime = str;
        }
    }

    public void setEffectiveStartTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-242530020")) {
            ipChange.ipc$dispatch("-242530020", new Object[]{this, str});
        } else {
            this.effectiveStartTime = str;
        }
    }

    public void setEffectiveTimeText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1546748647")) {
            ipChange.ipc$dispatch("-1546748647", new Object[]{this, str});
        } else {
            this.effectiveTimeText = str;
        }
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "333500489")) {
            ipChange.ipc$dispatch("333500489", new Object[]{this, str});
        } else {
            this.id = str;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1340087193")) {
            ipChange.ipc$dispatch("1340087193", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public void setOverAmountText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-950543605")) {
            ipChange.ipc$dispatch("-950543605", new Object[]{this, str});
        } else {
            this.overAmountText = str;
        }
    }

    public void setTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025114304")) {
            ipChange.ipc$dispatch("2025114304", new Object[]{this, str});
        } else {
            this.tag = str;
        }
    }

    public void setUnapplicableCause(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1163624233")) {
            ipChange.ipc$dispatch("1163624233", new Object[]{this, str});
        } else {
            this.unapplicableCause = str;
        }
    }
}
