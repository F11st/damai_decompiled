package cn.damai.category.ranksquare.repository;

import androidx.lifecycle.MutableLiveData;
import cn.damai.category.ranksquare.bean.RankSquareBean;
import cn.damai.category.ranksquare.bean.RankSquareMoreBean;
import cn.damai.category.ranksquare.bean.RankSquareResponse;
import cn.damai.category.ranksquare.request.RankSquareMoreRequest;
import cn.damai.category.ranksquare.request.RankSquareRequest;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RankSquareRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    public MutableLiveData<RankSquareResponse> a(RankSquareMoreRequest rankSquareMoreRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "233569498")) {
            return (MutableLiveData) ipChange.ipc$dispatch("233569498", new Object[]{this, rankSquareMoreRequest});
        }
        final MutableLiveData<RankSquareResponse> mutableLiveData = new MutableLiveData<>();
        DMMtopRequestListener<RankSquareMoreBean> dMMtopRequestListener = new DMMtopRequestListener<RankSquareMoreBean>(RankSquareMoreBean.class) { // from class: cn.damai.category.ranksquare.repository.RankSquareRepository.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "523914434")) {
                    ipChange2.ipc$dispatch("523914434", new Object[]{this, str, str2});
                    return;
                }
                RankSquareResponse rankSquareResponse = new RankSquareResponse(false);
                rankSquareResponse.errorCode = str;
                rankSquareResponse.errorMsg = str2;
                mutableLiveData.setValue(rankSquareResponse);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(RankSquareMoreBean rankSquareMoreBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "765244077")) {
                    ipChange2.ipc$dispatch("765244077", new Object[]{this, rankSquareMoreBean});
                    return;
                }
                RankSquareResponse rankSquareResponse = new RankSquareResponse(true);
                rankSquareResponse.mRankSquareMoreBean = rankSquareMoreBean;
                mutableLiveData.setValue(rankSquareResponse);
            }
        };
        if (rankSquareMoreRequest != null) {
            rankSquareMoreRequest.request(dMMtopRequestListener);
        }
        return mutableLiveData;
    }

    public MutableLiveData<RankSquareResponse> b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1356026416")) {
            return (MutableLiveData) ipChange.ipc$dispatch("-1356026416", new Object[]{this});
        }
        final MutableLiveData<RankSquareResponse> mutableLiveData = new MutableLiveData<>();
        new RankSquareRequest().request(new DMMtopRequestListener<RankSquareBean>(RankSquareBean.class) { // from class: cn.damai.category.ranksquare.repository.RankSquareRepository.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "531673793")) {
                    ipChange2.ipc$dispatch("531673793", new Object[]{this, str, str2});
                    return;
                }
                RankSquareResponse rankSquareResponse = new RankSquareResponse(false);
                rankSquareResponse.errorCode = str;
                rankSquareResponse.errorMsg = str2;
                mutableLiveData.setValue(rankSquareResponse);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(RankSquareBean rankSquareBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "149564579")) {
                    ipChange2.ipc$dispatch("149564579", new Object[]{this, rankSquareBean});
                    return;
                }
                RankSquareResponse rankSquareResponse = new RankSquareResponse(true);
                rankSquareResponse.mRankSquareBean = rankSquareBean;
                mutableLiveData.setValue(rankSquareResponse);
            }
        });
        return mutableLiveData;
    }
}
