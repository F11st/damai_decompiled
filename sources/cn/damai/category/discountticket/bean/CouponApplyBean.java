package cn.damai.category.discountticket.bean;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.damai.category.discountticket.bean.biz.ApplyResult;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CouponApplyBean {
    private static transient /* synthetic */ IpChange $ipChange;
    public List<CouponApplyFail> failedCoupons;
    public boolean nextApplicable;
    public List<CouponApplySuccess> successCoupons;

    public static ApplyResult getApplySuccessResult(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "368518559")) {
            return (ApplyResult) ipChange.ipc$dispatch("368518559", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            str = "您已领劵，不能再领了";
        }
        return new ApplyResult(false, CouponActivityBean.COUPON_ALREADY_GOT, str);
    }

    @Nullable
    public ApplyResult computeApplyResult() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1358620605")) {
            return (ApplyResult) ipChange.ipc$dispatch("-1358620605", new Object[]{this});
        }
        if (this.nextApplicable) {
            return new ApplyResult(true, null, "领取成功！快去使用吧");
        }
        if (wh2.e(this.successCoupons) > 0) {
            return new ApplyResult(false, CouponActivityBean.COUPON_ALREADY_GOT, "领取成功！快去使用吧");
        }
        if (wh2.e(this.failedCoupons) > 0) {
            CouponApplyFail couponApplyFail = this.failedCoupons.get(0);
            return new ApplyResult(false, couponApplyFail.errorCode, couponApplyFail.errorMsg);
        }
        return null;
    }
}
