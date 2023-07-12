package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.mine.bean.MyFeedBackDetail;
import cn.damai.mine.contract.MyFeedBackDetailContract;
import cn.damai.mine.net.MyFeedBackDetailRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MyFeedBackDetailPresenter extends MyFeedBackDetailContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.MyFeedBackDetailContract.Presenter
    public void getFeedBackList(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1332273472")) {
            ipChange.ipc$dispatch("1332273472", new Object[]{this, str});
            return;
        }
        MyFeedBackDetailRequest myFeedBackDetailRequest = new MyFeedBackDetailRequest();
        myFeedBackDetailRequest.feedbackId = str;
        myFeedBackDetailRequest.request(new DMMtopResultRequestListener<MyFeedBackDetail>(MyFeedBackDetail.class) { // from class: cn.damai.mine.presenter.MyFeedBackDetailPresenter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1145294049")) {
                    ipChange2.ipc$dispatch("-1145294049", new Object[]{this, str2, str3});
                } else {
                    ((MyFeedBackDetailContract.View) MyFeedBackDetailPresenter.this.mView).onNetError(str2, str3, "mtop.damai.wireless.user.feedback.replayDetail");
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onSuccess(MyFeedBackDetail myFeedBackDetail) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-749787389")) {
                    ipChange2.ipc$dispatch("-749787389", new Object[]{this, myFeedBackDetail});
                    return;
                }
                ((MyFeedBackDetailContract.View) MyFeedBackDetailPresenter.this.mView).onNetSuccess();
                ((MyFeedBackDetailContract.View) MyFeedBackDetailPresenter.this.mView).returnFeedBack(myFeedBackDetail);
            }
        });
    }
}
