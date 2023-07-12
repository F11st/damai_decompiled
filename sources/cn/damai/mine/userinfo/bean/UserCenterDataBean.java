package cn.damai.mine.userinfo.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.model.RealNameAuthStatusBean;
import cn.damai.mine.bean.UserCenterDynamicMenu;
import cn.damai.user.userhome.bean.UserHomeDataBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class UserCenterDataBean extends UserHomeDataBean {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<UserBanner> banner;
    private RealNameAuthStatusBean certificateInfo;
    private UserCenterDynamicMenu dynamicMenu;
    private LogisticsInfo logistics;
    private UserPerformFileVip performFilmVip;
    private UserGuideBean userGuide;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class LogisticsInfo implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String orderDetailUrl;
        public String orderId;
        public String performImageUrl;
        public String status;
        public List<TransitStepInfo> transitStepInfos;
        public String waybillId;
        public String waybillName;

        public String getOrderDetailUrl() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-422727278") ? (String) ipChange.ipc$dispatch("-422727278", new Object[]{this}) : this.orderDetailUrl;
        }

        public String getPerformImageUrl() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1430170455") ? (String) ipChange.ipc$dispatch("-1430170455", new Object[]{this}) : this.performImageUrl;
        }

        public String getStatus() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1244781524") ? (String) ipChange.ipc$dispatch("1244781524", new Object[]{this}) : this.status;
        }

        public List<TransitStepInfo> getTransitStepInfos() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "417540687") ? (List) ipChange.ipc$dispatch("417540687", new Object[]{this}) : this.transitStepInfos;
        }

        public String getWaybillId() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1217536005") ? (String) ipChange.ipc$dispatch("1217536005", new Object[]{this}) : this.waybillId;
        }

        public String getWaybillName() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1891879349") ? (String) ipChange.ipc$dispatch("1891879349", new Object[]{this}) : this.waybillName;
        }

        public void setStatus(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1461570422")) {
                ipChange.ipc$dispatch("-1461570422", new Object[]{this, str});
            } else {
                this.status = str;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class TransitStepInfo implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        public String action;
        public String statusDesc;
        public String statusTime;

        public String getStatusDesc() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1970507185") ? (String) ipChange.ipc$dispatch("1970507185", new Object[]{this}) : this.statusDesc;
        }

        public String getStatusTime() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1348627437") ? (String) ipChange.ipc$dispatch("1348627437", new Object[]{this}) : this.statusTime;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class UserGuideBean implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange = null;
        private static final long serialVersionUID = 1;
        public String bindAuthorization;
        public String content;
        public boolean memberThreshold;

        public boolean isUnbind() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1409416346") ? ((Boolean) ipChange.ipc$dispatch("1409416346", new Object[]{this})).booleanValue() : "0".equals(this.bindAuthorization);
        }

        public boolean isbindNotAuth() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "722277796") ? ((Boolean) ipChange.ipc$dispatch("722277796", new Object[]{this})).booleanValue() : "1".equals(this.bindAuthorization);
        }
    }

    public List<UserBanner> getBanner() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1883450280") ? (List) ipChange.ipc$dispatch("-1883450280", new Object[]{this}) : this.banner;
    }

    public RealNameAuthStatusBean getCertificateInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1174735417") ? (RealNameAuthStatusBean) ipChange.ipc$dispatch("1174735417", new Object[]{this}) : this.certificateInfo;
    }

    public UserCenterDynamicMenu getDynamicMenu() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "869328404") ? (UserCenterDynamicMenu) ipChange.ipc$dispatch("869328404", new Object[]{this}) : this.dynamicMenu;
    }

    public LogisticsInfo getLogistics() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "171041704") ? (LogisticsInfo) ipChange.ipc$dispatch("171041704", new Object[]{this}) : this.logistics;
    }

    public UserPerformFileVip getPerformFilmVip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-807392499") ? (UserPerformFileVip) ipChange.ipc$dispatch("-807392499", new Object[]{this}) : this.performFilmVip;
    }

    public UserGuideBean getUserGuide() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "607379366") ? (UserGuideBean) ipChange.ipc$dispatch("607379366", new Object[]{this}) : this.userGuide;
    }

    public int getVipLevel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "800139367")) {
            return ((Integer) ipChange.ipc$dispatch("800139367", new Object[]{this})).intValue();
        }
        if (getUserInfo() == null || TextUtils.isEmpty(getUserInfo().vipLevel)) {
            return 0;
        }
        return wh2.l(getUserInfo().vipLevel, 0);
    }

    public String getVipLevelIcon() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1589138501")) {
            return (String) ipChange.ipc$dispatch("1589138501", new Object[]{this});
        }
        if (getUserInfo() != null) {
            return getUserInfo().vipLevelIcon;
        }
        return null;
    }

    public void setBanner(List<UserBanner> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1939593868")) {
            ipChange.ipc$dispatch("-1939593868", new Object[]{this, list});
        } else {
            this.banner = list;
        }
    }

    public void setCertificateInfo(RealNameAuthStatusBean realNameAuthStatusBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1339799363")) {
            ipChange.ipc$dispatch("1339799363", new Object[]{this, realNameAuthStatusBean});
        } else {
            this.certificateInfo = realNameAuthStatusBean;
        }
    }

    public void setDynamicMenu(UserCenterDynamicMenu userCenterDynamicMenu) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1948920436")) {
            ipChange.ipc$dispatch("-1948920436", new Object[]{this, userCenterDynamicMenu});
        } else {
            this.dynamicMenu = userCenterDynamicMenu;
        }
    }

    public void setLogistics(LogisticsInfo logisticsInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923698902")) {
            ipChange.ipc$dispatch("923698902", new Object[]{this, logisticsInfo});
        } else {
            this.logistics = logisticsInfo;
        }
    }

    public void setPerformFilmVip(UserPerformFileVip userPerformFileVip) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1407095057")) {
            ipChange.ipc$dispatch("1407095057", new Object[]{this, userPerformFileVip});
        } else {
            this.performFilmVip = userPerformFileVip;
        }
    }

    public void setUserGuide(UserGuideBean userGuideBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "199491288")) {
            ipChange.ipc$dispatch("199491288", new Object[]{this, userGuideBean});
        } else {
            this.userGuide = userGuideBean;
        }
    }
}
