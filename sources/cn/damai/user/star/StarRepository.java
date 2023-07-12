package cn.damai.user.star;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.user.star.bean.StarIndexRequest;
import cn.damai.user.star.bean.StarIndexResponse;
import cn.damai.user.star.bean.StarInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class StarRepository {
    private static transient /* synthetic */ IpChange $ipChange;

    public StarRepository(Context context) {
    }

    public MutableLiveData<StarIndexResponse> a(StarIndexRequest starIndexRequest) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "118735448")) {
            return (MutableLiveData) ipChange.ipc$dispatch("118735448", new Object[]{this, starIndexRequest});
        }
        final MutableLiveData<StarIndexResponse> mutableLiveData = new MutableLiveData<>();
        starIndexRequest.request(new DMMtopRequestListener<StarInfo>(StarInfo.class) { // from class: cn.damai.user.star.StarRepository.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1410914801")) {
                    ipChange2.ipc$dispatch("1410914801", new Object[]{this, str, str2});
                    return;
                }
                StarIndexResponse starIndexResponse = new StarIndexResponse();
                starIndexResponse.errorCode = str;
                starIndexResponse.errorMsg = str2;
                mutableLiveData.setValue(starIndexResponse);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(StarInfo starInfo) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-375793776")) {
                    ipChange2.ipc$dispatch("-375793776", new Object[]{this, starInfo});
                    return;
                }
                StarIndexResponse starIndexResponse = new StarIndexResponse();
                starIndexResponse.data = starInfo;
                mutableLiveData.setValue(starIndexResponse);
            }
        });
        return mutableLiveData;
    }
}
