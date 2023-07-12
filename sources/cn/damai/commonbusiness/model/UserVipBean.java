package cn.damai.commonbusiness.model;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class UserVipBean {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean isVip;
    private String vipLevel;
    private String vipLevelIcon;

    public UserVipBean() {
    }

    public int getVipLevelInt() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-579169103")) {
            return ((Integer) ipChange.ipc$dispatch("-579169103", new Object[]{this})).intValue();
        }
        if (TextUtils.isEmpty(this.vipLevel)) {
            return 0;
        }
        try {
            return wh2.l(this.vipLevel, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public UserVipBean(UserData userData) {
        if (userData != null && userData.getUserBaseInfo() != null) {
            UserBaseInfoBean userBaseInfo = userData.getUserBaseInfo();
            this.isVip = userBaseInfo.isVip();
            this.vipLevel = userBaseInfo.getVipLevel();
            this.vipLevelIcon = userBaseInfo.getVipLevelIcon();
            return;
        }
        this.isVip = false;
        this.vipLevel = "0";
        this.vipLevelIcon = null;
    }

    public UserVipBean(boolean z, String str, String str2) {
        this.isVip = z;
        this.vipLevel = str;
        this.vipLevelIcon = str2;
    }
}
