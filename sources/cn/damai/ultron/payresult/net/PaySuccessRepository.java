package cn.damai.ultron.payresult.net;

import androidx.annotation.Nullable;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.commonbusiness.banner.bean.PayAdvertBean;
import cn.damai.commonbusiness.banner.request.PaySuccessBannerRequest;
import cn.damai.ultron.payresult.bean.DmPaySuccessBean;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.bean.RecommendListMo;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.request.RecommendRequest;
import com.alibaba.pictures.dolores.business.FailAction;
import com.alibaba.pictures.dolores.business.SuccessAction;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.dc0;
import tb.rb0;
import tb.y20;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class PaySuccessRepository extends y20 {
    private static transient /* synthetic */ IpChange $ipChange;

    public void queryBanner(String str, String str2, DMMtopRequestListener<PayAdvertBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "394760842")) {
            ipChange.ipc$dispatch("394760842", new Object[]{this, str, str2, dMMtopRequestListener});
            return;
        }
        PaySuccessBannerRequest paySuccessBannerRequest = new PaySuccessBannerRequest();
        paySuccessBannerRequest.projectId = str;
        paySuccessBannerRequest.orderId = str2;
        paySuccessBannerRequest.request(dMMtopRequestListener);
    }

    public void queryPaySuccessInfo(String str, DMMtopRequestListener<DmPaySuccessBean> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1628968207")) {
            ipChange.ipc$dispatch("-1628968207", new Object[]{this, str, dMMtopRequestListener});
            return;
        }
        PaySuccessRequest paySuccessRequest = new PaySuccessRequest();
        paySuccessRequest.orderId = str;
        paySuccessRequest.request(dMMtopRequestListener);
    }

    public void queryRecommendList(final DMMtopRequestListener<RecommendListMo> dMMtopRequestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-494660166")) {
            ipChange.ipc$dispatch("-494660166", new Object[]{this, dMMtopRequestListener});
            return;
        }
        RecommendRequest recommendRequest = new RecommendRequest();
        recommendRequest.setCityId(z20.c());
        rb0.h(recommendRequest).a().doOnSuccess(new SuccessAction<RecommendListMo>() { // from class: cn.damai.ultron.payresult.net.PaySuccessRepository.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.alibaba.pictures.dolores.business.SuccessAction
            public void onSuccess(RecommendListMo recommendListMo) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1357346340")) {
                    ipChange2.ipc$dispatch("-1357346340", new Object[]{this, recommendListMo});
                    return;
                }
                DMMtopRequestListener dMMtopRequestListener2 = dMMtopRequestListener;
                if (dMMtopRequestListener2 != null) {
                    dMMtopRequestListener2.onSuccess(recommendListMo);
                }
            }
        }).doOnFail(new FailAction<RecommendListMo>() { // from class: cn.damai.ultron.payresult.net.PaySuccessRepository.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.alibaba.pictures.dolores.business.FailAction
            public void onFail(@Nullable dc0<RecommendListMo> dc0Var) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "528819776")) {
                    ipChange2.ipc$dispatch("528819776", new Object[]{this, dc0Var});
                    return;
                }
                DMMtopRequestListener dMMtopRequestListener2 = dMMtopRequestListener;
                if (dMMtopRequestListener2 != null) {
                    dMMtopRequestListener2.onFail(dc0Var == null ? "error" : dc0Var.e(), dc0Var != null ? dc0Var.f() : "error");
                }
            }
        });
    }
}
