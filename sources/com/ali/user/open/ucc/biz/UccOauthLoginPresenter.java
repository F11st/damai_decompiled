package com.ali.user.open.ucc.biz;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccServiceProviderFactory;
import com.ali.user.open.ucc.data.DataRepository;
import com.ali.user.open.ucc.model.UccParams;
import com.ali.user.open.ucc.util.UTHitConstants;
import com.ali.user.open.ucc.util.UTHitUtils;
import com.ali.user.open.ucc.util.UccConstants;
import com.ali.user.open.ucc.util.Utils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.sns4android.jsbridge.SNSJsbridge;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccOauthLoginPresenter {
    private static volatile UccOauthLoginPresenter instance;

    public static UccOauthLoginPresenter getInstance() {
        if (instance == null) {
            synchronized (UccOauthLoginPresenter.class) {
                if (instance == null) {
                    instance = new UccOauthLoginPresenter();
                }
            }
        }
        return instance;
    }

    public static boolean isCookieOnly(Map<String, String> map) {
        return map != null && "1".equals(map.get(ParamsConstants.Key.PARAM_NEED_LOCAL_COOKIE_ONLY));
    }

    public void doUccOAuthLogin(final Activity activity, final UccParams uccParams, final Map<String, String> map, final UccCallback uccCallback) {
        DataRepository.uccOAuthLogin(uccParams, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.ucc.biz.UccOauthLoginPresenter.1
            private void rpcResultHit(String str, String str2, String str3) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put("actionType", str2);
                hashMap.put("h5Type", str3);
                UTHitUtils.send(UTHitConstants.PageUccOAuthLogin, "UccOAuthLogin_Result", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str, RpcResponse rpcResponse) {
                T t;
                String str2;
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1005);
                String str3 = "";
                if (TextUtils.equals("NEED_BIND", rpcResponse.actionType)) {
                    rpcResultHit(buidErrorCode + "", rpcResponse.actionType, "");
                    JSONObject parseObject = JSON.parseObject((String) rpcResponse.returnValue);
                    if (parseObject != null) {
                        str3 = parseObject.getString("returnUrl");
                        str2 = parseObject.getString("h5Type");
                    } else {
                        str2 = "";
                    }
                    Map map2 = map;
                    if (map2 == null) {
                        map2 = new HashMap();
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        map2.put(UccConstants.PARAM_BIND_URL, str3);
                    }
                    map2.put("needSession", "1");
                    map2.put(ParamsConstants.Key.PARAM_NEED_TOAST, "0");
                    map2.put("h5Type", str2);
                    UccH5Presenter.showH5BindPage(activity, uccParams, map2, false, uccCallback);
                } else if (TextUtils.equals("H5", rpcResponse.actionType) && (t = rpcResponse.returnValue) != 0) {
                    JSONObject parseObject2 = JSON.parseObject((String) t);
                    if (parseObject2 != null) {
                        JSONObject parseObject3 = JSON.parseObject(parseObject2.getString("authorizationResponse"));
                        if (parseObject3 != null) {
                            String string = parseObject3.getString(ParamsConstants.Key.PARAM_H5URL);
                            String string2 = parseObject3.getString("token");
                            String string3 = parseObject3.getString("scene");
                            Bundle bundle = new Bundle();
                            bundle.putString("url", string);
                            bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                            bundle.putString("needSession", "1");
                            bundle.putString("token", string2);
                            bundle.putString("scene", string3);
                            bundle.putString("params", Utils.convertMapToJsonStr(map));
                            UccH5Presenter.openUrl(activity, bundle, uccCallback);
                        } else {
                            UccCallback uccCallback2 = uccCallback;
                            if (uccCallback2 != null) {
                                uccCallback2.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                            }
                        }
                        rpcResultHit(buidErrorCode + "", rpcResponse.actionType, "");
                        return;
                    }
                    rpcResultHit(buidErrorCode + "", rpcResponse.actionType, "");
                    UccCallback uccCallback3 = uccCallback;
                    if (uccCallback3 != null) {
                        uccCallback3.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                    }
                } else {
                    rpcResultHit(buidErrorCode + "", rpcResponse.actionType, "");
                    UccCallback uccCallback4 = uccCallback;
                    if (uccCallback4 != null) {
                        uccCallback4.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                    }
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                if (rpcResponse != null) {
                    rpcResultHit(rpcResponse.code + "", rpcResponse.actionType, "");
                    if (rpcResponse.code != 3000 && !TextUtils.equals("SUCCESS", rpcResponse.actionType)) {
                        rpcResultHit(rpcResponse.code + "", "", "");
                        UccCallback uccCallback2 = uccCallback;
                        if (uccCallback2 != null) {
                            uccCallback2.onFail(uccParams.bindSite, rpcResponse.code, Utils.buidErrorMessage(rpcResponse, "免登response为空"));
                            return;
                        }
                        return;
                    }
                    UccBizContants.mBusyControlMap.put(uccParams.bindSite, Long.valueOf(System.currentTimeMillis()));
                    String str = (String) rpcResponse.returnValue;
                    UccServiceProviderFactory.getInstance().getUccServiceProvider(uccParams.bindSite).refreshWhenLogin(uccParams.bindSite, str, UccOauthLoginPresenter.isCookieOnly(map));
                    if (uccCallback != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(UccConstants.PARAM_LOGIN_DATA, JSON.parseObject(str).getString("authorizationResponse"));
                        uccCallback.onSuccess(uccParams.bindSite, hashMap);
                    }
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1005);
                rpcResultHit(buidErrorCode + "", rpcResponse == null ? "" : rpcResponse.actionType, "");
                Integer num = UccBizContants.mTrustLoginErrorTime.get(uccParams.bindSite);
                if (num == null) {
                    num = 0;
                }
                UccBizContants.mTrustLoginErrorTime.put(uccParams.bindSite, Integer.valueOf(num.intValue() + 1));
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(uccParams.bindSite, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                }
            }
        });
    }
}
