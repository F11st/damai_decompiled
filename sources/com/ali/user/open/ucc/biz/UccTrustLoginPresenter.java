package com.ali.user.open.ucc.biz;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.callback.CallbackManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.ResultCode;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.util.DialogHelper;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.ucc.R;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccServiceImpl;
import com.ali.user.open.ucc.UccServiceProviderFactory;
import com.ali.user.open.ucc.context.UccContext;
import com.ali.user.open.ucc.data.DataRepository;
import com.ali.user.open.ucc.model.UccParams;
import com.ali.user.open.ucc.remote.broadcast.UccBroadcastHelper;
import com.ali.user.open.ucc.remote.broadcast.UccResultAction;
import com.ali.user.open.ucc.util.UTHitConstants;
import com.ali.user.open.ucc.util.UTHitUtils;
import com.ali.user.open.ucc.util.UccConstants;
import com.ali.user.open.ucc.util.Utils;
import com.ali.user.open.ucc.webview.UccWebViewActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.sns4android.jsbridge.SNSJsbridge;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccTrustLoginPresenter {
    private static volatile UccTrustLoginPresenter instance;

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(Context context) {
        if (context == null || !(context instanceof UccWebViewActivity)) {
            return;
        }
        ((Activity) context).finish();
        CallbackManager.unregisterCallback(UccConstants.UCC_H5_CALLBACK_TYPE);
    }

    public static UccTrustLoginPresenter getInstance() {
        if (instance == null) {
            synchronized (UccTrustLoginPresenter.class) {
                if (instance == null) {
                    instance = new UccTrustLoginPresenter();
                }
            }
        }
        return instance;
    }

    public static void loginByIVToken(final Activity activity, final UccParams uccParams, Map<String, String> map, final String str, String str2, String str3, final UccCallback uccCallback) {
        int havanaSite = Site.getHavanaSite(uccParams.bindSite);
        final boolean isCookieOnly = UccOauthLoginPresenter.isCookieOnly(map);
        DataRepository.loginByIVToken(havanaSite, str, str2, str3, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.ucc.biz.UccTrustLoginPresenter.3
            private void rpcResultHit(String str4) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", "" + str4);
                hashMap.put("token", str);
                UTHitUtils.send(UTHitConstants.PageUccLogin, "UccLogin_TokenLoginResult", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str4, RpcResponse rpcResponse) {
                T t;
                rpcResultHit(str4 + "");
                if (TextUtils.equals("H5", rpcResponse.actionType) && (t = rpcResponse.returnValue) != 0) {
                    JSONObject parseObject = JSON.parseObject((String) t);
                    if (parseObject != null && activity != null) {
                        String string = parseObject.getString(ParamsConstants.Key.PARAM_H5URL);
                        Bundle bundle = new Bundle();
                        bundle.putString("url", string);
                        bundle.putString("token", parseObject.getString("token"));
                        bundle.putString("scene", parseObject.getString("scene"));
                        bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                        bundle.putString("needSession", "1");
                        UccH5Presenter.openUrl(activity, bundle, UccCallback.this);
                        return;
                    }
                    Activity activity2 = activity;
                    if (activity2 != null && (activity2 instanceof UccWebViewActivity)) {
                        activity2.finish();
                    }
                    UccCallback.this.onFail(uccParams.bindSite, rpcResponse.code, rpcResponse.message);
                    return;
                }
                Activity activity3 = activity;
                if (activity3 != null && (activity3 instanceof UccWebViewActivity)) {
                    activity3.finish();
                }
                UccCallback.this.onFail(uccParams.bindSite, rpcResponse.code, rpcResponse.message);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                if (rpcResponse == null || rpcResponse.returnValue == 0) {
                    UccCallback uccCallback2 = UccCallback.this;
                    String str4 = uccParams.bindSite;
                    ResultCode resultCode = ResultCode.SYSTEM_EXCEPTION;
                    uccCallback2.onFail(str4, resultCode.code, resultCode.message);
                }
                int i = rpcResponse.code;
                if (i == 3000) {
                    rpcResultHit("3000");
                    Activity activity2 = activity;
                    if (activity2 != null && (activity2 instanceof UccWebViewActivity)) {
                        activity2.finish();
                    }
                    String str5 = (String) rpcResponse.returnValue;
                    UccServiceProviderFactory.getInstance().getUccServiceProvider(uccParams.bindSite).refreshWhenLogin(uccParams.bindSite, str5, isCookieOnly);
                    HashMap hashMap = new HashMap();
                    hashMap.put(UccConstants.PARAM_LOGIN_DATA, str5);
                    UccCallback.this.onSuccess(uccParams.bindSite, hashMap);
                    return;
                }
                UccCallback.this.onFail(uccParams.bindSite, i, rpcResponse.message);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str4, RpcResponse rpcResponse) {
                rpcResultHit(str4 + "");
                UccCallback.this.onFail(uccParams.bindSite, rpcResponse.code, rpcResponse.message);
                Activity activity2 = activity;
                if (activity2 == null || !(activity2 instanceof UccWebViewActivity)) {
                    return;
                }
                activity2.finish();
            }
        });
    }

    public void doTrustLogin(final Activity activity, final UccParams uccParams, final String str, final Map<String, String> map, final UccCallback uccCallback) {
        UccContext.startTrustLoginTime = System.currentTimeMillis();
        DataRepository.trustLogin(uccParams, map, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.ucc.biz.UccTrustLoginPresenter.1
            private void rpcResultHit(String str2, String str3, String str4) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str2);
                hashMap.put("actionType", str3);
                hashMap.put("h5Type", str4);
                UTHitUtils.send(UTHitConstants.PageUccLogin, "UccLogin_Result", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str2, RpcResponse rpcResponse) {
                T t;
                String str3;
                Map map2 = map;
                boolean z = false;
                boolean z2 = map2 == null || !TextUtils.equals((CharSequence) map2.get(ParamsConstants.Key.PARAM_NEED_UI), "0");
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1005);
                String str4 = "";
                if (z2 && TextUtils.equals("NEED_BIND", rpcResponse.actionType)) {
                    rpcResultHit(buidErrorCode + "", rpcResponse.actionType, "");
                    String str5 = (String) rpcResponse.returnValue;
                    Map map3 = map;
                    if (map3 != null && "0".equals(map3.get(ParamsConstants.Key.PARAM_NEED_BIND))) {
                        z = true;
                    }
                    if ((Site.ICBU.equals(str) && Site.DING.equals(AliMemberSDK.getMasterSite())) || z) {
                        UccCallback uccCallback2 = uccCallback;
                        if (uccCallback2 != null) {
                            uccCallback2.onFail(str, rpcResponse.code, rpcResponse.message);
                            return;
                        }
                        return;
                    }
                    JSONObject parseObject = JSON.parseObject(str5);
                    if (parseObject != null) {
                        str4 = parseObject.getString(ParamsConstants.Key.PARAM_H5URL);
                        str3 = parseObject.getString("h5Type");
                    } else {
                        str3 = "";
                    }
                    Map<String, String> map4 = map;
                    if (map4 == null) {
                        map4 = new HashMap<>();
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        map4.put(UccConstants.PARAM_BIND_URL, str4);
                    }
                    map4.put("needSession", "1");
                    map4.put(ParamsConstants.Key.PARAM_NEED_LOCAL_COOKIE_ONLY, UccOauthLoginPresenter.isCookieOnly(map) ? "1" : "0");
                    map4.put(ParamsConstants.Key.PARAM_NEED_TOAST, "0");
                    map4.put("h5Type", str3);
                    UccServiceImpl.getInstance().bind(activity, uccParams.userToken, str, map4, uccCallback);
                } else if (z2 && TextUtils.equals("H5", rpcResponse.actionType) && (t = rpcResponse.returnValue) != 0) {
                    JSONObject parseObject2 = JSON.parseObject((String) t);
                    if (parseObject2 != null) {
                        String string = parseObject2.getString(ParamsConstants.Key.PARAM_H5URL);
                        String string2 = parseObject2.getString("token");
                        String string3 = parseObject2.getString("scene");
                        String string4 = parseObject2.getString("h5Type");
                        Bundle bundle = new Bundle();
                        bundle.putString("url", string);
                        bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                        bundle.putString("needSession", "1");
                        bundle.putString("token", string2);
                        bundle.putString("scene", string3);
                        bundle.putString("params", Utils.convertMapToJsonStr(map));
                        UccH5Presenter.openUrl(activity, bundle, uccCallback);
                        rpcResultHit(buidErrorCode + "", rpcResponse.actionType, string4);
                        return;
                    }
                    rpcResultHit(buidErrorCode + "", rpcResponse.actionType, "");
                    UccCallback uccCallback3 = uccCallback;
                    if (uccCallback3 != null) {
                        uccCallback3.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                    }
                } else {
                    rpcResultHit(buidErrorCode + "", rpcResponse == null ? "" : rpcResponse.actionType, "");
                    UccCallback uccCallback4 = uccCallback;
                    if (uccCallback4 != null) {
                        uccCallback4.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
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
                            uccCallback2.onFail(str, rpcResponse.code, Utils.buidErrorMessage(rpcResponse, "免登response为空"));
                            return;
                        }
                        return;
                    }
                    UccBizContants.mBusyControlMap.put(str, Long.valueOf(System.currentTimeMillis()));
                    boolean isCookieOnly = UccOauthLoginPresenter.isCookieOnly(map);
                    String str2 = (String) rpcResponse.returnValue;
                    String string = JSON.parseObject(str2).getString("authorizationResponse");
                    if (!TextUtils.isEmpty(string)) {
                        UccServiceProviderFactory.getInstance().getUccServiceProvider(str).refreshWhenLogin(str, string, isCookieOnly);
                    } else {
                        UccServiceProviderFactory.getInstance().getUccServiceProvider(str).refreshWhenLogin(str, str2, isCookieOnly);
                    }
                    Intent intent = new Intent();
                    intent.setAction(UccResultAction.NOTIFY_UCC_LOGIN_SUCCESS.name());
                    intent.setPackage(KernelContext.getApplicationContext().getPackageName());
                    Map map2 = map;
                    intent.putExtra("process", map2 != null ? (String) map2.get("process") : "");
                    intent.putExtra("site", str);
                    UccBroadcastHelper.sendBroadcast(intent);
                    if (uccCallback != null) {
                        HashMap hashMap = new HashMap();
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(UccConstants.PARAM_LOGIN_DATA, string);
                        } else {
                            hashMap.put(UccConstants.PARAM_LOGIN_DATA, str2);
                        }
                        uccCallback.onSuccess(str, hashMap);
                    }
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str2, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1005);
                rpcResultHit(buidErrorCode + "", rpcResponse == null ? "" : rpcResponse.actionType, "");
                Integer num = UccBizContants.mTrustLoginErrorTime.get(str);
                if (num == null) {
                    num = 0;
                }
                UccBizContants.mTrustLoginErrorTime.put(str, Integer.valueOf(num.intValue() + 1));
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                }
            }
        });
    }

    public void tokenLogin(Activity activity, UccParams uccParams, String str, String str2, String str3, Map<String, String> map, UccCallback uccCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("token", str2);
        UTHitUtils.send(UTHitConstants.PageUccLogin, "UccLogin_TokenLogin", uccParams, hashMap);
        loginByIVToken(activity, uccParams, map, str2, str, str3, uccCallback);
    }

    public void upgradeLogin(final Activity activity, UccParams uccParams, final String str, String str2, String str3, final String str4, final Map<String, String> map, final UccCallback uccCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str4);
        hashMap.put("scene", str2);
        hashMap.put("requestToken", str3);
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccLogin_UpgradeAccount", uccParams, hashMap);
        DataRepository.upgrade(uccParams, str2, str3, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.ucc.biz.UccTrustLoginPresenter.2
            private void rpcResultHit(String str5, String str6, String str7) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("code", str5);
                hashMap2.put("actionType", str6);
                hashMap2.put("h5Type", str7);
                UTHitUtils.send(UTHitConstants.PageUccBind, "UccLogin_UpgradeAccountResult", null, hashMap2);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str5, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1500);
                rpcResultHit(buidErrorCode + "", "", "");
                if (!TextUtils.equals(str4, "h5")) {
                    UccTrustLoginPresenter.this.finishActivity(activity);
                    UccCallback uccCallback2 = uccCallback;
                    if (uccCallback2 != null) {
                        uccCallback2.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, "OauthLogin接口错误"));
                        return;
                    }
                    return;
                }
                String str6 = rpcResponse != null ? rpcResponse.message : "";
                DialogHelper dialogHelper = DialogHelper.getInstance();
                Activity activity2 = activity;
                dialogHelper.alert(activity2, "", str6, activity2.getString(R.string.member_sdk_iknow), new DialogInterface.OnClickListener() { // from class: com.ali.user.open.ucc.biz.UccTrustLoginPresenter.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, "", null);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSuccess(RpcResponse rpcResponse) {
                T t;
                if (rpcResponse != null) {
                    rpcResultHit(rpcResponse.code + "", rpcResponse.actionType, "");
                    if (rpcResponse.code != 3000 && !TextUtils.equals("SUCCESS", rpcResponse.actionType)) {
                        if (TextUtils.equals("H5", rpcResponse.actionType) && (t = rpcResponse.returnValue) != 0) {
                            JSONObject parseObject = JSON.parseObject((String) t);
                            if (parseObject == null) {
                                UccTrustLoginPresenter.this.finishActivity(activity);
                                UccCallback uccCallback2 = uccCallback;
                                if (uccCallback2 != null) {
                                    uccCallback2.onFail(str, 1500, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                                    return;
                                }
                                return;
                            }
                            String string = parseObject.getString(ParamsConstants.Key.PARAM_H5URL);
                            Bundle bundle = new Bundle();
                            bundle.putString("url", string);
                            bundle.putString("token", parseObject.getString("token"));
                            bundle.putString("scene", parseObject.getString("scene"));
                            bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(new UccParams()));
                            bundle.putString("needSession", "1");
                            UccH5Presenter.openUrl(activity, bundle, uccCallback);
                            Activity activity2 = activity;
                            if (activity2 == null || (activity2 instanceof UccWebViewActivity)) {
                                return;
                            }
                            activity2.finish();
                            return;
                        }
                        rpcResultHit(rpcResponse.code + "", "", "");
                        UccCallback uccCallback3 = uccCallback;
                        if (uccCallback3 != null) {
                            uccCallback3.onFail(str, rpcResponse.code, Utils.buidErrorMessage(rpcResponse, "免登response为空"));
                            return;
                        }
                        return;
                    }
                    UccBizContants.mBusyControlMap.put(str, Long.valueOf(System.currentTimeMillis()));
                    String str5 = (String) rpcResponse.returnValue;
                    boolean z = true;
                    Map map2 = map;
                    if (map2 != null && TextUtils.equals((CharSequence) map2.get(ParamsConstants.Key.PARAM_NEED_LOCAL_SESSION), "0")) {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(str5) && z) {
                        UccServiceProviderFactory.getInstance().getUccServiceProvider(str).refreshWhenLogin(str, str5, UccOauthLoginPresenter.isCookieOnly(map));
                    }
                    UccTrustLoginPresenter.this.finishActivity(activity);
                    if (uccCallback != null) {
                        Map<String, String> buildSessionInfo = UccBindPresenter.buildSessionInfo(str, str5);
                        String string2 = JSON.parseObject(str5).getString("authorizationResponse");
                        if (TextUtils.isEmpty(string2)) {
                            buildSessionInfo.put(UccConstants.PARAM_LOGIN_DATA, str5);
                        } else {
                            buildSessionInfo.put(UccConstants.PARAM_LOGIN_DATA, string2);
                        }
                        uccCallback.onSuccess(str, buildSessionInfo);
                    }
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str5, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1500);
                rpcResultHit(buidErrorCode + "", "", "");
            }
        });
    }

    public void userGrowLogin(final Activity activity, final UccParams uccParams, @Site.SiteName final String str, final Map<String, String> map, final UccCallback uccCallback) {
        DataRepository.userGrowLogin(uccParams.requestToken, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.ucc.biz.UccTrustLoginPresenter.4
            private void rpcResultHit(String str2, String str3, String str4) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", str2);
                hashMap.put("actionType", str3);
                hashMap.put("h5Type", str4);
                UTHitUtils.send(UTHitConstants.PageUccLogin, "UccLogin_Result", uccParams, hashMap);
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onError(String str2, RpcResponse rpcResponse) {
                T t;
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1005);
                if (TextUtils.equals("H5", rpcResponse.actionType) && (t = rpcResponse.returnValue) != 0) {
                    String str3 = (String) t;
                    JSONObject parseObject = JSON.parseObject(str3);
                    if (parseObject != null) {
                        String string = parseObject.getString(ParamsConstants.Key.PARAM_H5URL);
                        if (!TextUtils.isEmpty(string)) {
                            String string2 = parseObject.getString("token");
                            String string3 = parseObject.getString("scene");
                            String string4 = parseObject.getString("h5Type");
                            Bundle bundle = new Bundle();
                            bundle.putString("url", string);
                            bundle.putString(UccConstants.PARAM_UCC_PARAMS, JSON.toJSONString(uccParams));
                            bundle.putString("needSession", "1");
                            bundle.putString("token", string2);
                            bundle.putString("scene", string3);
                            bundle.putString("params", Utils.convertMapToJsonStr(map));
                            UccH5Presenter.openUrl(activity, bundle, uccCallback);
                            rpcResultHit(buidErrorCode + "", rpcResponse.actionType, string4);
                            return;
                        } else if (!TextUtils.isEmpty(parseObject.getString("returnUrl"))) {
                            UccCallback uccCallback2 = uccCallback;
                            if (uccCallback2 != null) {
                                uccCallback2.onFail(str, 3000, str3);
                                return;
                            }
                            return;
                        } else {
                            UccCallback uccCallback3 = uccCallback;
                            if (uccCallback3 != null) {
                                uccCallback3.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                                return;
                            }
                            return;
                        }
                    }
                    rpcResultHit(buidErrorCode + "", rpcResponse.actionType, "");
                    UccCallback uccCallback4 = uccCallback;
                    if (uccCallback4 != null) {
                        uccCallback4.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                        return;
                    }
                    return;
                }
                rpcResultHit(buidErrorCode + "", rpcResponse.actionType, "");
                UccCallback uccCallback5 = uccCallback;
                if (uccCallback5 != null) {
                    uccCallback5.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
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
                            uccCallback2.onFail(str, rpcResponse.code, Utils.buidErrorMessage(rpcResponse, "免登response为空"));
                            return;
                        }
                        return;
                    }
                    UccBizContants.mBusyControlMap.put(str, Long.valueOf(System.currentTimeMillis()));
                    boolean isCookieOnly = UccOauthLoginPresenter.isCookieOnly(map);
                    String str2 = (String) rpcResponse.returnValue;
                    JSONObject parseObject = JSON.parseObject(str2);
                    String string = parseObject.getString("authorizationResponse");
                    if (!TextUtils.isEmpty(string)) {
                        UccServiceProviderFactory.getInstance().getUccServiceProvider(str).refreshWhenLogin(str, string, isCookieOnly);
                    } else {
                        UccServiceProviderFactory.getInstance().getUccServiceProvider(str).refreshWhenLogin(str, str2, isCookieOnly);
                    }
                    if (uccCallback != null) {
                        HashMap hashMap = new HashMap();
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(UccConstants.PARAM_LOGIN_DATA, string);
                        } else {
                            hashMap.put(UccConstants.PARAM_LOGIN_DATA, str2);
                        }
                        hashMap.put("callbackUrl", parseObject.getString("callbackUrl"));
                        uccCallback.onSuccess(str, hashMap);
                    }
                }
            }

            @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
            public void onSystemError(String str2, RpcResponse rpcResponse) {
                int buidErrorCode = Utils.buidErrorCode(rpcResponse, 1005);
                rpcResultHit(buidErrorCode + "", rpcResponse == null ? "" : rpcResponse.actionType, "");
                Integer num = UccBizContants.mTrustLoginErrorTime.get(str);
                if (num == null) {
                    num = 0;
                }
                UccBizContants.mTrustLoginErrorTime.put(str, Integer.valueOf(num.intValue() + 1));
                UccCallback uccCallback2 = uccCallback;
                if (uccCallback2 != null) {
                    uccCallback2.onFail(str, buidErrorCode, Utils.buidErrorMessage(rpcResponse, SNSJsbridge.TAOBAO_ERROR_MESSAGE));
                }
            }
        });
    }
}
