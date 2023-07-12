package com.ali.user.open.ucc.data;

import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.MemberCallback;
import com.ali.user.open.core.model.RpcRequest;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.service.RpcService;
import com.ali.user.open.ucc.UccDataProvider;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DefaultDataProvider implements UccDataProvider {
    @Override // com.ali.user.open.ucc.UccDataProvider
    public void getUserToken(String str, final MemberCallback<String> memberCallback) {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.target = "mtop.alibaba.ucc.taobao.apply.usertoken";
        rpcRequest.version = "1.0";
        rpcRequest.NEED_ECODE = true;
        rpcRequest.NEED_SESSION = true;
        ((RpcService) AliMemberSDK.getService(RpcService.class)).remoteBusiness(rpcRequest, UserTokenModel.class, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.ucc.data.DefaultDataProvider.1
            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str2, RpcResponse rpcResponse) {
                MemberCallback memberCallback2 = memberCallback;
                if (memberCallback2 != null) {
                    memberCallback2.onFailure(1004, rpcResponse == null ? "" : rpcResponse.message);
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                T t = rpcResponse.returnValue;
                UserTokenModel userTokenModel = (UserTokenModel) t;
                if (t != 0) {
                    String str2 = userTokenModel.userToken;
                    MemberCallback memberCallback2 = memberCallback;
                    if (memberCallback2 != null) {
                        memberCallback2.onSuccess(str2);
                        return;
                    }
                    return;
                }
                MemberCallback memberCallback3 = memberCallback;
                if (memberCallback3 != null) {
                    memberCallback3.onFailure(1004, rpcResponse.message);
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str2, RpcResponse rpcResponse) {
                MemberCallback memberCallback2 = memberCallback;
                if (memberCallback2 != null) {
                    memberCallback2.onFailure(1004, rpcResponse == null ? "" : rpcResponse.message);
                }
            }
        });
    }
}
