package cn.damai.mine.presenter;

import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.mine.bean.MyFeedBackList;
import cn.damai.mine.contract.MyFeedBackListContract;
import cn.damai.mine.net.MyFeedBackListRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MyFeedBackListPresenter extends MyFeedBackListContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.mine.contract.MyFeedBackListContract.Presenter
    public void getFeedBackList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1335568835")) {
            ipChange.ipc$dispatch("1335568835", new Object[]{this});
        } else {
            new MyFeedBackListRequest().request(new DMMtopResultRequestListener<MyFeedBackList>(MyFeedBackList.class) { // from class: cn.damai.mine.presenter.MyFeedBackListPresenter.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1483620722")) {
                        ipChange2.ipc$dispatch("1483620722", new Object[]{this, str, str2});
                    } else {
                        ((MyFeedBackListContract.View) MyFeedBackListPresenter.this.mView).onNetError(str, str2, "mtop.damai.wireless.user.feedback.replayList");
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
                public void onSuccess(MyFeedBackList myFeedBackList) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "392097833")) {
                        ipChange2.ipc$dispatch("392097833", new Object[]{this, myFeedBackList});
                        return;
                    }
                    ((MyFeedBackListContract.View) MyFeedBackListPresenter.this.mView).onNetSuccess();
                    ((MyFeedBackListContract.View) MyFeedBackListPresenter.this.mView).returnFeedBackList(myFeedBackList);
                }
            });
        }
    }
}
