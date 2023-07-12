package cn.damai.homepage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.common.bean.MemberAuthDetail;
import cn.damai.commonbusiness.coupondialog.net.CouponListResponse;
import cn.damai.commonbusiness.yymember.bean.GuideInfo;
import cn.damai.commonbusiness.yymember.bean.MemberFinishedInfo;
import cn.damai.commonbusiness.yymember.bean.MemberGuideInfo;
import cn.damai.commonbusiness.yymember.bean.WrapFirstGuideBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.m61;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class MainAlertEntity implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ALERT_TYPE_AD = "2";
    public static final String ALERT_TYPE_EVALUATE = "3";
    public static final String ALERT_TYPE_FIRST_MEMBER_GUIDE = "4";
    public static final String ALERT_TYPE_MEMBER_BIND_GUIDE = "5";
    public static final String ALERT_TYPE_RED_PACKET = "1";
    public static final String ALERT_TYPE_TO_MEMBER = "6";
    public static final String ALERT_TYPE_TO_PROCOTOL = "7";
    public static final String PICK_HID_TYPE_CALLBACK = "NEED_CALL_BACK_HID";
    public static final String PICK_TYPE_CALLBACK = "NEED_CALL_BACK";
    public CouponListResponse.ContentList content;
    public String id;
    public MainAlertModel item;
    public String memberFinishedInfo;
    public String memberGuideInfo;
    public String type;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class MainAlertContentListItem implements Serializable {
        public static final String ABOVE_AGREEMENT = "0";
        public static final String AGREEMENT = "1";
        public static final String UNDER_AGREEMENT = "2";
        public String content;
        public String contentType;
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static class MainAlertModel implements Serializable {
        public Long circleId;
        public List<MainAlertContentListItem> contentList;
        public String id;
        public String imageUrl;
        public long nextAlert;
        public String pkType;
        public String pkid;
        public String protocolColor;
        public String protocolLink;
        public String protocolName;
        public String schema;
        public String scm;
        public String titleColor;
    }

    private boolean textEquals(String str, String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1708964855") ? ((Boolean) ipChange.ipc$dispatch("-1708964855", new Object[]{this, str, str2})).booleanValue() : TextUtils.equals(str, str2);
    }

    @NonNull
    public MemberGuideInfo getMemberDailyBindGuideInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1512067619")) {
            return (MemberGuideInfo) ipChange.ipc$dispatch("-1512067619", new Object[]{this});
        }
        if (TextUtils.isEmpty(this.memberGuideInfo)) {
            return new MemberGuideInfo();
        }
        return (MemberGuideInfo) m61.a(this.memberGuideInfo, MemberGuideInfo.class);
    }

    @NonNull
    public MemberFinishedInfo getMemberFinishedInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "646370843")) {
            return (MemberFinishedInfo) ipChange.ipc$dispatch("646370843", new Object[]{this});
        }
        if (TextUtils.isEmpty(this.memberFinishedInfo)) {
            return new MemberFinishedInfo();
        }
        return (MemberFinishedInfo) m61.a(this.memberFinishedInfo, MemberFinishedInfo.class);
    }

    @NonNull
    public WrapFirstGuideBean getWrapFirstGuideBean() {
        MemberAuthDetail memberAuthDetail;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "113650075")) {
            return (WrapFirstGuideBean) ipChange.ipc$dispatch("113650075", new Object[]{this});
        }
        String str = null;
        MemberGuideInfo memberDailyBindGuideInfo = getMemberDailyBindGuideInfo();
        String str2 = memberDailyBindGuideInfo.tipType;
        GuideInfo guideInfo = memberDailyBindGuideInfo.info;
        if (guideInfo != null && (memberAuthDetail = guideInfo.detail) != null) {
            str = memberAuthDetail.rightImgUrl;
        }
        return new WrapFirstGuideBean(str2, str);
    }

    public boolean isDailyMemberGuide() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1688449902") ? ((Boolean) ipChange.ipc$dispatch("1688449902", new Object[]{this})).booleanValue() : textEquals("5", this.type);
    }

    public boolean isFirstMemberGuide() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1681150917") ? ((Boolean) ipChange.ipc$dispatch("1681150917", new Object[]{this})).booleanValue() : textEquals("4", this.type);
    }

    public boolean isMemberFinishGuide() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1512570988") ? ((Boolean) ipChange.ipc$dispatch("1512570988", new Object[]{this})).booleanValue() : textEquals("6", this.type);
    }

    public boolean isType4Member() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-726030457") ? ((Boolean) ipChange.ipc$dispatch("-726030457", new Object[]{this})).booleanValue() : isFirstMemberGuide() || isDailyMemberGuide() || isMemberFinishGuide();
    }
}
