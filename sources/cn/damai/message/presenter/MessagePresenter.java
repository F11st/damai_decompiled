package cn.damai.message.presenter;

import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.message.bean.MessageList;
import cn.damai.message.contract.MessageContract;
import cn.damai.message.request.MessageDeleteRequest;
import cn.damai.message.request.MessageListRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import mtopsdk.mtop.domain.MtopResponse;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MessagePresenter extends MessageContract.Presenter {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // cn.damai.message.contract.MessageContract.Presenter
    public void deleteMessage(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1876651777")) {
            ipChange.ipc$dispatch("-1876651777", new Object[]{this, map});
            return;
        }
        MessageDeleteRequest messageDeleteRequest = new MessageDeleteRequest();
        if (map.containsKey(ShareperfenceConstants.OLD_LOGIN_KEY)) {
            messageDeleteRequest.loginkey = map.get(ShareperfenceConstants.OLD_LOGIN_KEY);
        }
        if (map.containsKey("messageId")) {
            messageDeleteRequest.messageId = map.get("messageId");
        }
        messageDeleteRequest.request(new DMMtopRequestListener<MtopResponse>(MtopResponse.class) { // from class: cn.damai.message.presenter.MessagePresenter.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-572371443")) {
                    ipChange2.ipc$dispatch("-572371443", new Object[]{this, str, str2});
                } else {
                    ((MessageContract.View) MessagePresenter.this.mView).deleteMessageFailure(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(MtopResponse mtopResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1152591051")) {
                    ipChange2.ipc$dispatch("-1152591051", new Object[]{this, mtopResponse});
                } else {
                    ((MessageContract.View) MessagePresenter.this.mView).deleteMessageSuccess();
                }
            }
        });
    }

    @Override // cn.damai.message.contract.MessageContract.Presenter
    public void getMessageItemList(Map<String, String> map, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1660054357")) {
            ipChange.ipc$dispatch("1660054357", new Object[]{this, map, Boolean.valueOf(z)});
            return;
        }
        MessageListRequest messageListRequest = new MessageListRequest();
        messageListRequest.isRefresh = z;
        if (map.containsKey(ShareperfenceConstants.OLD_LOGIN_KEY)) {
            messageListRequest.loginkey = map.get(ShareperfenceConstants.OLD_LOGIN_KEY);
        }
        if (map.containsKey("groupId")) {
            messageListRequest.groupId = map.get("groupId");
        }
        if (map.containsKey("messageId")) {
            messageListRequest.messageId = map.get("messageId");
        }
        if (map.containsKey("size")) {
            messageListRequest.size = map.get("size");
        }
        if (map.containsKey("pageIndex")) {
            messageListRequest.pageIndex = map.get("pageIndex");
        }
        messageListRequest.request(new DMMtopRequestListener<MessageList>(MessageList.class) { // from class: cn.damai.message.presenter.MessagePresenter.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-564612084")) {
                    ipChange2.ipc$dispatch("-564612084", new Object[]{this, str, str2});
                } else {
                    ((MessageContract.View) MessagePresenter.this.mView).returnMessageItemListFailures(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(MessageList messageList) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "118222535")) {
                    ipChange2.ipc$dispatch("118222535", new Object[]{this, messageList});
                } else {
                    ((MessageContract.View) MessagePresenter.this.mView).returnMessageItemListSuccess(messageList);
                }
            }
        });
    }
}
