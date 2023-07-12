package cn.damai.commonbusiness.seatbiz.promotion.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CouponListDataBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 7446864797550687934L;
    private String authorizeProfitText;
    private List<CouponActivityBean> couponActivities;
    private boolean needAuthorizeProfit;
    private List<CouponActivityBean> performProfitActivities;
    private UserProfitInfoBean userProfitInfo;

    public String getAuthorizeProfitText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "878038144") ? (String) ipChange.ipc$dispatch("878038144", new Object[]{this}) : this.authorizeProfitText;
    }

    public List<CouponActivityBean> getCouponActivities() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1488912874") ? (List) ipChange.ipc$dispatch("1488912874", new Object[]{this}) : this.couponActivities;
    }

    public List<CouponActivityBean> getPerformProfitActivities() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "771489567") ? (List) ipChange.ipc$dispatch("771489567", new Object[]{this}) : this.performProfitActivities;
    }

    public UserProfitInfoBean getUserProfitInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1049108978") ? (UserProfitInfoBean) ipChange.ipc$dispatch("-1049108978", new Object[]{this}) : this.userProfitInfo;
    }

    public boolean isNeedAuthorizeProfit() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2051547747") ? ((Boolean) ipChange.ipc$dispatch("-2051547747", new Object[]{this})).booleanValue() : this.needAuthorizeProfit;
    }

    public void setAuthorizeProfitText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1170899210")) {
            ipChange.ipc$dispatch("-1170899210", new Object[]{this, str});
        } else {
            this.authorizeProfitText = str;
        }
    }

    public void setCouponActivities(List<CouponActivityBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "700098850")) {
            ipChange.ipc$dispatch("700098850", new Object[]{this, list});
        } else {
            this.couponActivities = list;
        }
    }

    public void setNeedAuthorizeProfit(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "151523173")) {
            ipChange.ipc$dispatch("151523173", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.needAuthorizeProfit = z;
        }
    }

    public void setPerformProfitActivities(List<CouponActivityBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1413015259")) {
            ipChange.ipc$dispatch("-1413015259", new Object[]{this, list});
        } else {
            this.performProfitActivities = list;
        }
    }

    public void setUserProfitInfo(UserProfitInfoBean userProfitInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891180004")) {
            ipChange.ipc$dispatch("891180004", new Object[]{this, userProfitInfoBean});
        } else {
            this.userProfitInfo = userProfitInfoBean;
        }
    }
}
