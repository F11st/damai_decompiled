package cn.damai.user.userhome.bean;

import android.text.TextUtils;
import cn.damai.commonbusiness.yymember.bean.PerformFilmVipDO;
import cn.damai.uikit.view.avatar.AvatarConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import tb.k23;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class UserInfoBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean artistVip;
    public String birthday;
    public String havanaIdStr;
    public String headBgImg;
    public String imgUrl;
    public PerformFilmVipDO performFilmVipDO;
    public String region;
    public int sex;
    public String userIntro;
    public String userNick;
    public String userNickStatus;
    public int userTypeCode;
    public String userTypeIcon;
    public boolean vip;
    public String vipLevel;
    public String vipLevelIcon;

    public static AvatarConfig createConfig(UserInfoBean userInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-205169912")) {
            return (AvatarConfig) ipChange.ipc$dispatch("-205169912", new Object[]{userInfoBean});
        }
        if (userInfoBean == null) {
            return AvatarConfig.defaultConfig();
        }
        if (userInfoBean.userTypeCode == 2) {
            return AvatarConfig.vTagConfig();
        }
        if (userInfoBean.isPerformFilmVip()) {
            String memberFlag = userInfoBean.getMemberFlag();
            if (TextUtils.equals("1", memberFlag)) {
                return AvatarConfig.normalDiamondConfig();
            }
            if (TextUtils.equals("10", memberFlag)) {
                return AvatarConfig.blackDiamondConfig();
            }
            return AvatarConfig.defaultConfig();
        }
        return AvatarConfig.defaultConfig();
    }

    public String getHavanaIdStr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1680416376") ? (String) ipChange.ipc$dispatch("-1680416376", new Object[]{this}) : this.havanaIdStr;
    }

    public String getImgUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-749243975") ? (String) ipChange.ipc$dispatch("-749243975", new Object[]{this}) : this.imgUrl;
    }

    public String getMemberFlag() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1643502029")) {
            return (String) ipChange.ipc$dispatch("-1643502029", new Object[]{this});
        }
        PerformFilmVipDO performFilmVipDO = this.performFilmVipDO;
        if (performFilmVipDO != null) {
            return performFilmVipDO.memberFlag;
        }
        return k23.h();
    }

    public PerformFilmVipDO getPerformFilmVipDO() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-185656193") ? (PerformFilmVipDO) ipChange.ipc$dispatch("-185656193", new Object[]{this}) : this.performFilmVipDO;
    }

    public String getUserNick() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1525619877") ? (String) ipChange.ipc$dispatch("-1525619877", new Object[]{this}) : this.userNick;
    }

    public String getUserNickStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1718580845") ? (String) ipChange.ipc$dispatch("1718580845", new Object[]{this}) : this.userNickStatus;
    }

    public String getVipLevel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1345286260") ? (String) ipChange.ipc$dispatch("1345286260", new Object[]{this}) : this.vipLevel;
    }

    public String getVipLevelIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1586274803") ? (String) ipChange.ipc$dispatch("-1586274803", new Object[]{this}) : this.vipLevelIcon;
    }

    public boolean isPerformFilmVip() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-214159005")) {
            return ((Boolean) ipChange.ipc$dispatch("-214159005", new Object[]{this})).booleanValue();
        }
        PerformFilmVipDO performFilmVipDO = this.performFilmVipDO;
        return performFilmVipDO != null && k23.d(performFilmVipDO.memberFlag);
    }

    public boolean isVip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1252201786") ? ((Boolean) ipChange.ipc$dispatch("1252201786", new Object[]{this})).booleanValue() : this.vip;
    }

    public void setImgUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1148148549")) {
            ipChange.ipc$dispatch("1148148549", new Object[]{this, str});
        } else {
            this.imgUrl = str;
        }
    }
}
