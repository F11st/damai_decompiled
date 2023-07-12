package cn.damai.commonbusiness.yymember.bean;

import android.text.TextUtils;
import cn.damai.common.bean.MemberAuthDetail;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MemberGuideInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String authorize = "authorize";
    public static final String bind = "bind";
    public static final String notBind = "notBind";
    public GuideInfo info;
    public String tipType;

    public static MemberGuideInfo mockDaily() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-407343787")) {
            return (MemberGuideInfo) ipChange.ipc$dispatch("-407343787", new Object[0]);
        }
        MemberGuideInfo memberGuideInfo = new MemberGuideInfo();
        memberGuideInfo.tipType = "daily";
        GuideInfo guideInfo = new GuideInfo();
        memberGuideInfo.info = guideInfo;
        guideInfo.title = "影演会员数据打通授权A";
        guideInfo.memberStatus = notBind;
        guideInfo.detail = MemberAuthDetail.mock();
        return memberGuideInfo;
    }

    public static MemberGuideInfo mockFirst() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-832856930")) {
            return (MemberGuideInfo) ipChange.ipc$dispatch("-832856930", new Object[0]);
        }
        MemberGuideInfo memberGuideInfo = new MemberGuideInfo();
        memberGuideInfo.tipType = "new";
        GuideInfo guideInfo = new GuideInfo();
        memberGuideInfo.info = guideInfo;
        guideInfo.title = "影演会员数据打通授权A";
        guideInfo.memberStatus = notBind;
        MemberAuthDetail mock = MemberAuthDetail.mock();
        guideInfo.detail = mock;
        mock.rightImgUrl = "https://img2.baidu.com/it/u=189214096,2501165656&fm=26&fmt=auto&gp=0.jpg";
        return memberGuideInfo;
    }

    public String getDailyBindMemberStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "365675122")) {
            return (String) ipChange.ipc$dispatch("365675122", new Object[]{this});
        }
        GuideInfo guideInfo = this.info;
        if (guideInfo != null) {
            return guideInfo.memberStatus;
        }
        return null;
    }

    public boolean isStatusJustAuthor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-174029717") ? ((Boolean) ipChange.ipc$dispatch("-174029717", new Object[]{this})).booleanValue() : TextUtils.equals(authorize, getDailyBindMemberStatus());
    }

    public boolean isStatusJustBind() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1914576825") ? ((Boolean) ipChange.ipc$dispatch("1914576825", new Object[]{this})).booleanValue() : TextUtils.equals("bind", getDailyBindMemberStatus());
    }

    public boolean isStatusNotBind() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-79444352") ? ((Boolean) ipChange.ipc$dispatch("-79444352", new Object[]{this})).booleanValue() : TextUtils.equals(notBind, getDailyBindMemberStatus());
    }

    public boolean isValid4DailyBind() {
        GuideInfo guideInfo;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2097033856") ? ((Boolean) ipChange.ipc$dispatch("-2097033856", new Object[]{this})).booleanValue() : (TextUtils.isEmpty(this.tipType) || (guideInfo = this.info) == null || guideInfo.detail == null) ? false : true;
    }
}
