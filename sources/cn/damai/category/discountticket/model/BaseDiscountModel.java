package cn.damai.category.discountticket.model;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import cn.damai.category.discountticket.bean.CouponActivityBean;
import cn.damai.category.discountticket.bean.CouponApplyBean;
import cn.damai.category.discountticket.bean.HeaderCouponBean;
import cn.damai.category.discountticket.bean.HeaderData;
import cn.damai.category.discountticket.bean.biz.ApplyResult;
import cn.damai.category.discountticket.contract.DiscountTicketContract;
import cn.damai.category.discountticket.request.CouponApplyRequest;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.a;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.seatbiz.utils.RequestHolder;
import cn.damai.commonbusiness.share.generateimage.GenerateImageUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.List;
import mtopsdk.mtop.util.ErrorConstant;
import tb.j11;
import tb.m62;
import tb.mu0;
import tb.o90;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class BaseDiscountModel implements DiscountTicketContract.DtModel {
    private static transient /* synthetic */ IpChange $ipChange;
    private RequestHolder mRequestHolder = new RequestHolder();

    public void addBusiness(MtopBusiness mtopBusiness) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-382772115")) {
            ipChange.ipc$dispatch("-382772115", new Object[]{this, mtopBusiness});
        } else {
            this.mRequestHolder.a(mtopBusiness);
        }
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void applyCoupon(HeaderCouponBean headerCouponBean, final CouponActivityBean couponActivityBean, final OnApplyCouponListener onApplyCouponListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-148132764")) {
            ipChange.ipc$dispatch("-148132764", new Object[]{this, headerCouponBean, couponActivityBean, onApplyCouponListener});
        } else {
            addBusiness(new CouponApplyRequest(couponActivityBean.couponActSpreadId).request(new DMMtopRequestListener<CouponApplyBean>(CouponApplyBean.class) { // from class: cn.damai.category.discountticket.model.BaseDiscountModel.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "94453504")) {
                        ipChange2.ipc$dispatch("94453504", new Object[]{this, str, str2});
                    } else if (TextUtils.equals(ErrorConstant.ERRCODE_ANDROID_SYS_LOGIN_CANCEL, str)) {
                    } else {
                        if (TextUtils.equals(CouponActivityBean.COUPON_ALREADY_GOT, str)) {
                            ApplyResult applySuccessResult = CouponApplyBean.getApplySuccessResult(str2);
                            couponActivityBean.updateCouponAfterApply(applySuccessResult);
                            onApplyCouponListener.onApplyResultFinish(applySuccessResult.toastMsg);
                            return;
                        }
                        onApplyCouponListener.onApplyFail(str, str2);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(CouponApplyBean couponApplyBean) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2027628513")) {
                        ipChange2.ipc$dispatch("-2027628513", new Object[]{this, couponApplyBean});
                    } else if (couponApplyBean != null) {
                        ApplyResult computeApplyResult = couponApplyBean.computeApplyResult();
                        if (computeApplyResult != null) {
                            couponActivityBean.updateCouponAfterApply(computeApplyResult);
                            onApplyCouponListener.onApplyResultFinish(computeApplyResult.toastMsg);
                            return;
                        }
                        onFail("", "领取失败");
                    } else {
                        onFail("", "领取失败");
                    }
                }
            }));
        }
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-718599050")) {
            ipChange.ipc$dispatch("-718599050", new Object[]{this});
        } else {
            this.mRequestHolder.c();
        }
    }

    @Override // cn.damai.category.discountticket.contract.DiscountTicketContract.DtModel
    public void share(final OnShareListener onShareListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1281787426")) {
            ipChange.ipc$dispatch("-1281787426", new Object[]{this, onShareListener});
            return;
        }
        final HeaderData headerData = getHeaderData();
        if (headerData == null || !headerData.isSupportShare()) {
            return;
        }
        onShareListener.showLoading(true);
        final String str = headerData.sharePic;
        Application a = mu0.a();
        a.b().f(str, m62.a(a, 111.0f), m62.a(a, 148.0f)).n(new DMImageCreator.DMImageSuccListener() { // from class: cn.damai.category.discountticket.model.BaseDiscountModel.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
            public void onSuccess(DMImageCreator.e eVar) {
                Bitmap bitmap;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-495626785")) {
                    ipChange2.ipc$dispatch("-495626785", new Object[]{this, eVar});
                    return;
                }
                onShareListener.showLoading(false);
                if (eVar == null || (bitmap = eVar.b) == null) {
                    return;
                }
                try {
                    String d = j11.d(str, bitmap, mu0.a());
                    HeaderData headerData2 = headerData;
                    String str2 = headerData2.title;
                    String str3 = headerData2.subtitle;
                    String str4 = headerData2.sharePic;
                    String str5 = headerData2.h5Url;
                    Bundle bundle = new Bundle();
                    bundle.putString("title", str2);
                    bundle.putString("projectName", str2);
                    bundle.putString("message", str3);
                    if (!TextUtils.isEmpty(str4)) {
                        bundle.putString("imageurl", str4);
                        bundle.putString("projectImage", str4);
                    }
                    if (!TextUtils.isEmpty(d)) {
                        bundle.putString("sinaSharePath", d);
                    }
                    if (!TextUtils.isEmpty(str5)) {
                        bundle.putString("producturl", str5);
                    }
                    bundle.putBoolean("showGenerateImage", true);
                    bundle.putString("shareType", "chat_h5");
                    bundle.putString("shareImageStyle", GenerateImageUtil.STYLE_GENERATE_DISCOUNT_TICKET);
                    onShareListener.onShare(bundle);
                } catch (Exception unused) {
                    onShareListener.toast("分享失败");
                }
            }
        }).e(new DMImageCreator.DMImageFailListener() { // from class: cn.damai.category.discountticket.model.BaseDiscountModel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
            public void onFail(DMImageCreator.d dVar) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1289952310")) {
                    ipChange2.ipc$dispatch("-1289952310", new Object[]{this, dVar});
                    return;
                }
                onShareListener.showLoading(false);
                onShareListener.toast("分享失败");
            }
        }).f();
    }

    public void addBusiness(List<MtopBusiness> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "375535872")) {
            ipChange.ipc$dispatch("375535872", new Object[]{this, list});
        } else if (!o90.b(list)) {
            for (MtopBusiness mtopBusiness : list) {
                addBusiness(mtopBusiness);
            }
        }
    }
}
