package cn.damai.mine.bean;

import cn.damai.user.userhome.bean.MinepublishCheckBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class VipCardInfoWrap {
    private static transient /* synthetic */ IpChange $ipChange;
    private UserCenterDynamicMenu dynamicMenu;
    private String myHeadAreaBgImg;
    private MinepublishCheckBean publishCheckInfo;

    public UserCenterDynamicMenu getDynamicMenu() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1970881105") ? (UserCenterDynamicMenu) ipChange.ipc$dispatch("1970881105", new Object[]{this}) : this.dynamicMenu;
    }

    public String getMyHeadAreaBgImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1969424435") ? (String) ipChange.ipc$dispatch("1969424435", new Object[]{this}) : this.myHeadAreaBgImg;
    }

    public MinepublishCheckBean getPublishCheckInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "610784725") ? (MinepublishCheckBean) ipChange.ipc$dispatch("610784725", new Object[]{this}) : this.publishCheckInfo;
    }

    public void setDynamicMenu(UserCenterDynamicMenu userCenterDynamicMenu) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2134442223")) {
            ipChange.ipc$dispatch("2134442223", new Object[]{this, userCenterDynamicMenu});
        } else {
            this.dynamicMenu = userCenterDynamicMenu;
        }
    }

    public void setMyHeadAreaBgImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1204428707")) {
            ipChange.ipc$dispatch("1204428707", new Object[]{this, str});
        } else {
            this.myHeadAreaBgImg = str;
        }
    }

    public void setPublishCheckInfo(MinepublishCheckBean minepublishCheckBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2040800331")) {
            ipChange.ipc$dispatch("-2040800331", new Object[]{this, minepublishCheckBean});
        } else {
            this.publishCheckInfo = minepublishCheckBean;
        }
    }
}
