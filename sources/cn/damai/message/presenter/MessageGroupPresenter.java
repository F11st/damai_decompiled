package cn.damai.message.presenter;

import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.message.bean.MessageGroupResponse;
import cn.damai.message.contract.MessageGroupContract;
import cn.damai.message.request.MessageGroupRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.common.Constants;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MessageGroupPresenter extends MessageGroupContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.message.contract.MessageGroupContract.Presenter
    public void getMessageGroupList(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "893126786")) {
            ipChange.ipc$dispatch("893126786", new Object[]{this, map});
            return;
        }
        MessageGroupRequest messageGroupRequest = new MessageGroupRequest();
        if (map.containsKey(ShareperfenceConstants.OLD_LOGIN_KEY)) {
            messageGroupRequest.loginkey = map.get(ShareperfenceConstants.OLD_LOGIN_KEY);
        }
        if (map.containsKey(Constants.KEY_OS_TYPE)) {
            messageGroupRequest.osType = map.get(Constants.KEY_OS_TYPE);
        }
        messageGroupRequest.request(new DMMtopRequestListener<MessageGroupResponse>(MessageGroupResponse.class) { // from class: cn.damai.message.presenter.MessageGroupPresenter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "92137215")) {
                    ipChange2.ipc$dispatch("92137215", new Object[]{this, str, str2});
                } else {
                    ((MessageGroupContract.View) MessageGroupPresenter.this.mView).returnMessageGroupListFailure(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(MessageGroupResponse messageGroupResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-383079080")) {
                    ipChange2.ipc$dispatch("-383079080", new Object[]{this, messageGroupResponse});
                } else {
                    ((MessageGroupContract.View) MessageGroupPresenter.this.mView).returnMessageGroupListSuccess(messageGroupResponse);
                }
            }
        });
    }
}
