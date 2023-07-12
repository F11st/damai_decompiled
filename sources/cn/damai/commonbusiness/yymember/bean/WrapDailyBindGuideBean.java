package cn.damai.commonbusiness.yymember.bean;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WrapDailyBindGuideBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public GuideInfo mGuideInfo;
    public String tipType;

    public WrapDailyBindGuideBean() {
    }

    public boolean isValid() {
        GuideInfo guideInfo;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1353139660") ? ((Boolean) ipChange.ipc$dispatch("-1353139660", new Object[]{this})).booleanValue() : (!TextUtils.isEmpty(this.tipType) || (guideInfo = this.mGuideInfo) == null || guideInfo.detail == null) ? false : true;
    }

    public WrapDailyBindGuideBean(String str, GuideInfo guideInfo) {
        this.tipType = str;
        this.mGuideInfo = guideInfo;
    }
}
