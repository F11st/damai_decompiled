package com.ali.user.mobile.login.ui;

import com.ali.user.mobile.login.presenter.LoginFlowReturnData;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.rpc.RpcResponse;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public interface RecommendLoginView extends BaseLoginView {
    void onFlowLimitLocked(String str);

    void onGetAccessTokenFail();

    void onGuideH5(LoginParam loginParam, RpcResponse<LoginFlowReturnData> rpcResponse);

    void onNeedAlert(LoginParam loginParam, RpcResponse<LoginFlowReturnData> rpcResponse);

    void onNeedVerifyMobileForReg(String str, String str2);

    void onRecommendBioLogin(String str, List<String> list, LoginParam loginParam);

    void onRecommendFaceLogin(String str, List<String> list, LoginParam loginParam);

    void onRecommendPwdLogin(String str, List<String> list, LoginParam loginParam);

    void onRecommendSimLogin(String str, List<String> list, LoginParam loginParam);

    void onRecommendSmsLogin(String str, List<String> list, LoginParam loginParam);

    void updateAccountInfo(LoginFlowReturnData loginFlowReturnData);
}
