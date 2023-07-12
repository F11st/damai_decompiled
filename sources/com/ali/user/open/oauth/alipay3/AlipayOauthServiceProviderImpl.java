package com.ali.user.open.oauth.alipay3;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.task.AbsAsyncTask;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.trace.TLogAdapter;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl;
import com.alipay.android.phone.inside.api.model.accountopenauth.AOAuthModel;
import com.alipay.android.phone.inside.api.model.accountopenauth.MCAccountStatusEnum;
import com.alipay.android.phone.inside.api.model.accountopenauth.McAccountStatusChangeModel;
import com.alipay.android.phone.inside.api.result.OperationResult;
import com.alipay.android.phone.inside.service.InsideOperationService;
import com.alipay.sdk.app.AuthTask;
import com.alipay.sdk.auth.OpenAuthTask;
import com.alipay.sdk.m.u.C4316l;
import com.amap.api.services.core.AMapException;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.security.util.SignConstants;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AlipayOauthServiceProviderImpl extends BaseOauthServiceProviderImpl {
    public static final String TAG = "Login.AlipayOauthServiceProviderImpl";
    private boolean mLoginAfterOauth = true;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    class InsideAuthTask extends AbsAsyncTask<Void, Void, Void> {
        private String mSign;
        private OauthCallback memberCallback;

        public InsideAuthTask(String str, OauthCallback oauthCallback) {
            this.memberCallback = oauthCallback;
            this.mSign = str;
        }

        @Override // com.ali.user.open.core.task.AbsAsyncTask
        protected void doFinally() {
        }

        @Override // com.ali.user.open.core.task.AbsAsyncTask
        protected void doWhenException(Throwable th) {
            th.printStackTrace();
            failCallback();
        }

        void failCallback() {
            ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.oauth.alipay3.AlipayOauthServiceProviderImpl.InsideAuthTask.3
                @Override // java.lang.Runnable
                public void run() {
                    InsideAuthTask.this.memberCallback.onFail("alipay", 202, AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.ali.user.open.core.task.AbsAsyncTask
        public Void asyncExecute(Void... voidArr) {
            AOAuthModel aOAuthModel = new AOAuthModel();
            aOAuthModel.setAuthUrl(this.mSign);
            try {
                final OperationResult startAction = InsideOperationService.getInstance().startAction(KernelContext.getApplicationContext(), aOAuthModel);
                if (startAction != null && startAction.getResult() != null && startAction.getCodeValue() != null) {
                    if ("account_open_auth_9000".equals(startAction.getCodeValue()) && !TextUtils.isEmpty(startAction.getResult())) {
                        JSONObject jSONObject = new JSONObject(startAction.getResult());
                        final HashMap hashMap = new HashMap();
                        hashMap.put(SignConstants.MIDDLE_PARAM_AUTHCODE, jSONObject.optString("auth_code"));
                        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.oauth.alipay3.AlipayOauthServiceProviderImpl.InsideAuthTask.1
                            @Override // java.lang.Runnable
                            public void run() {
                                InsideAuthTask.this.memberCallback.onSuccess("alipay", hashMap);
                            }
                        });
                        return null;
                    } else if (startAction.getCodeValue() != null) {
                        SDKLogger.e(AlipayOauthServiceProviderImpl.TAG, "alipay inside auth: " + startAction.getCodeValue());
                        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postUITask(new Runnable() { // from class: com.ali.user.open.oauth.alipay3.AlipayOauthServiceProviderImpl.InsideAuthTask.2
                            @Override // java.lang.Runnable
                            public void run() {
                                InsideAuthTask.this.memberCallback.onFail("alipay", 202, startAction.getCodeValue());
                            }
                        });
                        return null;
                    }
                }
            } catch (InsideOperationService.RunInMainThreadException e) {
                SDKLogger.e(AlipayOauthServiceProviderImpl.TAG, "alipay inside auth exception");
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            failCallback();
            return null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    class InsideUnAuthTask extends AbsAsyncTask<Void, Void, Void> {
        private Context mContext;

        public InsideUnAuthTask(Context context) {
            this.mContext = context;
        }

        @Override // com.ali.user.open.core.task.AbsAsyncTask
        protected void doFinally() {
        }

        @Override // com.ali.user.open.core.task.AbsAsyncTask
        protected void doWhenException(Throwable th) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.ali.user.open.core.task.AbsAsyncTask
        public Void asyncExecute(Void... voidArr) {
            try {
                McAccountStatusChangeModel mcAccountStatusChangeModel = new McAccountStatusChangeModel();
                mcAccountStatusChangeModel.setMcAccountStatus(MCAccountStatusEnum.MC_LOGOUT);
                OperationResult startAction = InsideOperationService.getInstance().startAction(this.mContext, mcAccountStatusChangeModel);
                if (startAction != null) {
                    SDKLogger.e(AlipayOauthServiceProviderImpl.TAG, "code = " + startAction.getCodeValue());
                    return null;
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
    }

    private void authTask(final Activity activity, final String str, AppCredential appCredential, Map<String, String> map, final OauthCallback oauthCallback) {
        try {
            Class.forName("com.alipay.sdk.auth.OpenAuthTask");
            HashMap hashMap = new HashMap();
            if (map != null && !TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_ALIPAY_URL))) {
                hashMap.put("url", map.get(ParamsConstants.Key.PARAM_ALIPAY_URL));
            } else if (map != null && "1".equals(map.get(ParamsConstants.Key.PARAM_ALIPAY_QUICK_LOGIN))) {
                hashMap.put("url", "https://render.alipay.com/p/yuyan/180020010001205638/fast-login.html?auth_type=PURE_OAUTH_SDK&third_party=TAO_BAO&app_id=" + appCredential.appKey + "&scope=login_getPayInfo&auth_token_type=once&state=init");
            } else {
                hashMap.put("url", "https://authweb.alipay.com/auth?auth_type=PURE_OAUTH_SDK&app_id=" + appCredential.appKey + "&scope=auth_user&auth_token_type=once&state=init");
            }
            TLogAdapter.e(TAG, "in authTask,URL=" + ((String) hashMap.get("url")));
            OpenAuthTask openAuthTask = new OpenAuthTask(activity);
            String packageName = activity.getPackageName();
            openAuthTask.execute(packageName + "__alipaysdkauth__", OpenAuthTask.BizType.AccountAuth, hashMap, new OpenAuthTask.Callback() { // from class: com.ali.user.open.oauth.alipay3.AlipayOauthServiceProviderImpl.2
                public void onResult(int i, String str2, Bundle bundle) {
                    TLogAdapter.e(AlipayOauthServiceProviderImpl.TAG, "in onResult");
                    HashMap hashMap2 = new HashMap();
                    if (i == 9000) {
                        if (!TextUtils.isEmpty(bundle.getString("auth_code"))) {
                            hashMap2.put(SignConstants.MIDDLE_PARAM_AUTHCODE, bundle.getString("auth_code"));
                            oauthCallback.onSuccess(str, hashMap2);
                            return;
                        } else if (!TextUtils.equals(bundle.getString("authStatus"), LoginConstant.FETCH_IV_FAIL_CANCEL) && !TextUtils.equals(bundle.getString("authStatus"), "USER_BACK")) {
                            oauthCallback.onFail(str, 202, "");
                            return;
                        } else {
                            oauthCallback.onFail(str, 204, "");
                            return;
                        }
                    }
                    hashMap2.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
                    hashMap2.put("code", "202");
                    oauthCallback.onFail(str, 202, "");
                }
            }, true);
            TLogAdapter.e(TAG, "after task.execute");
        } catch (Throwable th) {
            th.printStackTrace();
            SignRequest signRequest = new SignRequest();
            signRequest.app_id = appCredential.appKey;
            signRequest.pid = appCredential.pid;
            signRequest.sign_type = appCredential.signType;
            signRequest.target_id = appCredential.targetId;
            signRequest.scope = appCredential.scope;
            AlipayRpcPresenter.getAlipaySign(new GetSignCallback() { // from class: com.ali.user.open.oauth.alipay3.AlipayOauthServiceProviderImpl.3
                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str2) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("code", i + "");
                    ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_AlipayOauth", "Page_AlipayOauth_signResult", hashMap2);
                    oauthCallback.onFail(str, i, str2);
                }

                @Override // com.ali.user.open.oauth.alipay3.GetSignCallback
                public void onGetSignSuccessed(final String str2) {
                    ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postTask(new Runnable() { // from class: com.ali.user.open.oauth.alipay3.AlipayOauthServiceProviderImpl.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            String str3;
                            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_AlipayOauth", "Page_AlipayOauth_signResult", new HashMap());
                            SDKLogger.d(AlipayOauthServiceProviderImpl.TAG, "sign=" + str2);
                            Map<String, String> authV2 = new AuthTask(activity).authV2(str2, true);
                            if (authV2 != null) {
                                SDKLogger.d(AlipayOauthServiceProviderImpl.TAG, "result=" + authV2.toString());
                                String str4 = authV2.get("result");
                                if (!TextUtils.isEmpty(str4)) {
                                    HashMap hashMap2 = new HashMap();
                                    String[] split = str4.split("&");
                                    if (split != null) {
                                        int length = split.length;
                                        char c = 0;
                                        str3 = "";
                                        int i = 0;
                                        while (i < length) {
                                            String[] split2 = split[i].split("=");
                                            if (split2 != null && split2.length == 2) {
                                                if ("auth_code".equals(split2[c])) {
                                                    str3 = split2[1];
                                                    hashMap2.put(SignConstants.MIDDLE_PARAM_AUTHCODE, str3);
                                                } else if ("alipay_open_id".equals(split2[c])) {
                                                    hashMap2.put("openId", split2[1]);
                                                } else if (UTDataCollectorNodeColumn.USER_ID.equals(split2[0])) {
                                                    hashMap2.put("userId", split2[1]);
                                                }
                                            }
                                            i++;
                                            c = 0;
                                        }
                                    } else {
                                        str3 = "";
                                    }
                                    HashMap hashMap3 = new HashMap();
                                    if (!TextUtils.isEmpty(str3)) {
                                        hashMap3.put(UTConstant.Args.UT_PROPERTY_SUCCESS, "T");
                                        hashMap3.put(SignConstants.MIDDLE_PARAM_AUTHCODE, hashMap2.get(SignConstants.MIDDLE_PARAM_AUTHCODE));
                                        hashMap3.put("openId", hashMap2.get("openId"));
                                        hashMap3.put("userId", hashMap2.get("userId"));
                                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                        oauthCallback.onSuccess(str, hashMap2);
                                    } else {
                                        hashMap3.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
                                        hashMap3.put("code", "202");
                                        AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                        oauthCallback.onFail(str, 202, "");
                                    }
                                    ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_AlipayOauth", "Page_AlipayOauth_Result", hashMap3);
                                    return;
                                }
                                AnonymousClass3 anonymousClass33 = AnonymousClass3.this;
                                oauthCallback.onFail(str, 201, authV2.get(C4316l.b));
                            }
                        }
                    });
                }
            }, signRequest);
        }
    }

    public void authInsideTask(Activity activity, Map<String, String> map, final OauthCallback oauthCallback) {
        AlipayRpcPresenter.getAlipayInsideSign(map, new GetSignCallback() { // from class: com.ali.user.open.oauth.alipay3.AlipayOauthServiceProviderImpl.1
            @Override // com.ali.user.open.core.callback.FailureCallback
            public void onFailure(int i, String str) {
                SDKLogger.e(AlipayOauthServiceProviderImpl.TAG, "inside genAlipaySign error:" + i + ",msg=" + str);
                oauthCallback.onFail("alipay", i, str);
            }

            @Override // com.ali.user.open.oauth.alipay3.GetSignCallback
            public void onGetSignSuccessed(String str) {
                new InsideAuthTask(str, oauthCallback).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        });
    }

    @Override // com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl, com.ali.user.open.oauth.OauthServiceProvider
    public boolean isAppAuthSurpport(Context context) {
        try {
            Class.forName("com.alipay.sdk.auth.OpenAuthTask");
            if (context instanceof Activity) {
                return new OpenAuthTask((Activity) context).isAliPaySupportOpenAuth();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (context == null) {
            context = KernelContext.getApplicationContext();
        }
        try {
            context.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public boolean isLoginUrl(String str) {
        return false;
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void logout(Context context, String str) {
        SDKLogger.e(TAG, "logout alipay inside");
        new InsideUnAuthTask(context).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void oauth(Activity activity, String str, AppCredential appCredential, Map<String, String> map, OauthCallback oauthCallback) {
        this.mLoginAfterOauth = true;
        ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_AlipayOauth", "Page_AlipayOauth_Invoke", new HashMap());
        if (map != null && "1".equals(map.get(ParamsConstants.Key.PARAM_INSIDE_ALIPAY))) {
            authInsideTask(activity, map, oauthCallback);
        } else if (activity == null) {
            oauthCallback.onFail(str, 102, "param is null");
        } else if (appCredential != null && !TextUtils.isEmpty(appCredential.appKey)) {
            authTask(activity, str, appCredential, map, oauthCallback);
        } else {
            oauthCallback.onFail(str, 101, "app credential is null");
        }
    }
}
