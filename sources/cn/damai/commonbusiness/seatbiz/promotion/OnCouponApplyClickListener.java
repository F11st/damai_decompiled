package cn.damai.commonbusiness.seatbiz.promotion;

import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponActivityBean;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface OnCouponApplyClickListener {
    void onClick(CouponActivityBean couponActivityBean, int i, String str, String str2, String str3);

    void onIntegralConvertClick(int i, String str, String str2, String str3);

    void refreshCouponRequest();
}
