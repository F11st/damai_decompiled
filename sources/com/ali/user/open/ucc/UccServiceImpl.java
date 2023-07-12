package com.ali.user.open.ucc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view.PromotionTagView;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.MemberCallback;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.model.RpcRequestCallbackWithCode;
import com.ali.user.open.core.model.RpcResponse;
import com.ali.user.open.core.model.SerializableMap;
import com.ali.user.open.core.service.MemberExecutorService;
import com.ali.user.open.core.service.OneKeyLoginService;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.core.util.ReflectionUtils;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.OauthPlatformConfig;
import com.ali.user.open.oauth.OauthService;
import com.ali.user.open.service.SessionService;
import com.ali.user.open.session.Session;
import com.ali.user.open.ucc.biz.UccBindPresenter;
import com.ali.user.open.ucc.biz.UccBizContants;
import com.ali.user.open.ucc.biz.UccH5Presenter;
import com.ali.user.open.ucc.biz.UccOauthLoginPresenter;
import com.ali.user.open.ucc.biz.UccTrustLoginPresenter;
import com.ali.user.open.ucc.biz.UccUnbindPresenter;
import com.ali.user.open.ucc.data.DataRepository;
import com.ali.user.open.ucc.model.UccParams;
import com.ali.user.open.ucc.remote.broadcast.UccBroadcastHelper;
import com.ali.user.open.ucc.remote.broadcast.UccResultAction;
import com.ali.user.open.ucc.ui.UccActivity;
import com.ali.user.open.ucc.util.UTHitConstants;
import com.ali.user.open.ucc.util.UTHitUtils;
import com.ali.user.open.ucc.util.UccCallbackManager;
import com.ali.user.open.ucc.util.UccConstants;
import com.ali.user.open.ucc.util.UccStatus;
import com.ali.user.open.ucc.util.Utils;
import com.taobao.orange.OrangeConfig;
import com.youku.android.utils.OPRUtils;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.security.util.SignConstants;
import org.android.agoo.message.MessageService;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UccServiceImpl implements UccService {
    public static final String TAG = "UccServiceImpl";
    private static volatile UccServiceImpl sInstance;
    private long mLastLaunchUccActivityTime;
    private UccDataProvider mUccDataProvider;
    private Map<String, UccDataProvider> mUccDataProviderContainer = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.ali.user.open.ucc.UccServiceImpl$13  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass13 implements OauthCallback {
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ String val$bizcode;
        final /* synthetic */ String val$realm;
        final /* synthetic */ UccCallback val$uccCallback;

        AnonymousClass13(String str, String str2, UccCallback uccCallback, Activity activity) {
            this.val$bizcode = str;
            this.val$realm = str2;
            this.val$uccCallback = uccCallback;
            this.val$activity = activity;
        }

        @Override // com.ali.user.open.oauth.OauthCallback
        public void onFail(String str, int i, String str2) {
            UccCallback uccCallback = this.val$uccCallback;
            if (uccCallback != null) {
                uccCallback.onFail(str, i, str2);
            }
        }

        @Override // com.ali.user.open.oauth.OauthCallback
        public void onSuccess(String str, Map map) {
            DataRepository.bindAlipay((String) map.get(SignConstants.MIDDLE_PARAM_AUTHCODE), this.val$bizcode, this.val$realm, new RpcRequestCallbackWithCode() { // from class: com.ali.user.open.ucc.UccServiceImpl.13.1
                @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                public void onError(String str2, RpcResponse rpcResponse) {
                    T t;
                    if (rpcResponse != null && (t = rpcResponse.returnValue) != 0) {
                        Bundle bundle = new Bundle();
                        bundle.putString("url", (String) t);
                        UccH5Presenter.openUrl(AnonymousClass13.this.val$activity, bundle, new UccCallback() { // from class: com.ali.user.open.ucc.UccServiceImpl.13.1.1
                            @Override // com.ali.user.open.ucc.UccCallback
                            public void onFail(String str3, int i, String str4) {
                                UccCallback uccCallback = AnonymousClass13.this.val$uccCallback;
                                if (uccCallback != null) {
                                    uccCallback.onFail(str3, i, str4);
                                }
                            }

                            @Override // com.ali.user.open.ucc.UccCallback
                            public void onSuccess(String str3, Map map2) {
                                UccCallback uccCallback = AnonymousClass13.this.val$uccCallback;
                                if (uccCallback != null) {
                                    uccCallback.onSuccess(str3, map2);
                                }
                            }
                        });
                        return;
                    }
                    UccCallback uccCallback = AnonymousClass13.this.val$uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onFail("alipay", rpcResponse == null ? -1 : rpcResponse.code, "");
                    }
                }

                @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                public void onSuccess(RpcResponse rpcResponse) {
                    UccCallback uccCallback = AnonymousClass13.this.val$uccCallback;
                    if (uccCallback != null) {
                        uccCallback.onSuccess("alipay", null);
                    }
                }

                @Override // com.ali.user.open.core.model.RpcRequestCallbackWithCode
                public void onSystemError(String str2, RpcResponse rpcResponse) {
                    onError(str2, rpcResponse);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doBind(Activity activity, UccParams uccParams, String str, Map<String, String> map, UccCallback uccCallback) {
        UccBizContants.mBusyControlMap.put(str, 0L);
        AppCredential oauthConfigByPlatform = OauthPlatformConfig.getOauthConfigByPlatform(str);
        if (map == null) {
            map = new HashMap<>(6);
        }
        UccServiceProviderFactory.getInstance().getUccServiceProvider(str).bind(activity, uccParams, oauthConfigByPlatform, map, uccCallback);
    }

    public static UccServiceImpl getInstance() {
        if (sInstance == null) {
            synchronized (UccServiceImpl.class) {
                if (sInstance == null) {
                    sInstance = new UccServiceImpl();
                }
            }
        }
        return sInstance;
    }

    private long getLoginLimitInterval(String str) {
        try {
            OrangeConfig orangeConfig = OrangeConfig.getInstance();
            return Long.parseLong(orangeConfig.getConfig("login4android", str + "LoginInterval", "-1"));
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private long getLoginLimitIntervalForActivity(String str) {
        try {
            OrangeConfig orangeConfig = OrangeConfig.getInstance();
            return Long.parseLong(orangeConfig.getConfig("login4android", str + "LoginIntervalForActivity", MessageService.MSG_DB_COMPLETE));
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private long getLoginTimeout(String str) {
        try {
            OrangeConfig orangeConfig = OrangeConfig.getInstance();
            return Long.parseLong(orangeConfig.getConfig("login4android", str + "LoginTimeout", "30000"));
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private UccDataProvider getUccDataProviderInstance(Map<String, String> map, String str) {
        UccDataProvider uccDataProvider = (map == null || TextUtils.isEmpty(map.get("site"))) ? null : this.mUccDataProviderContainer.get(map.get("site"));
        if (uccDataProvider != null || this.mUccDataProvider != null) {
            return uccDataProvider == null ? this.mUccDataProvider : uccDataProvider;
        }
        UccDataProvider makeUpUccDataProvider = makeUpUccDataProvider();
        this.mUccDataProvider = makeUpUccDataProvider;
        if (makeUpUccDataProvider == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bindSite", str);
            hashMap.put("code", OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_LOW);
            UTHitUtils.send(UTHitConstants.PageUccUnBind, "Ucc_UserTokenNIL", null, hashMap);
            return makeUpUccDataProvider;
        }
        return makeUpUccDataProvider;
    }

    private UccDataProvider makeUpUccDataProvider() {
        String uccDataProviderClass = ConfigManager.getInstance().getUccDataProviderClass();
        if (TextUtils.isEmpty(uccDataProviderClass)) {
            return null;
        }
        try {
            UTHitUtils.send(UTHitConstants.PageUccLogin, "ucc_recreate_dataprovider", null, null);
            return (UccDataProvider) ReflectionUtils.newInstance(uccDataProviderClass, (String[]) null, (Object[]) null);
        } catch (Throwable unused) {
            UTHitUtils.send(UTHitConstants.PageUccLogin, "ucc_recreate_dataprovider_fail", null, null);
            return null;
        }
    }

    private synchronized boolean uccActivityLimit(String str) {
        if (System.currentTimeMillis() - this.mLastLaunchUccActivityTime >= getLoginLimitIntervalForActivity(str) && (!UccActivity.isUccActivityExist || System.currentTimeMillis() - this.mLastLaunchUccActivityTime >= 2000)) {
            this.mLastLaunchUccActivityTime = System.currentTimeMillis();
            return false;
        }
        return true;
    }

    @Override // com.ali.user.open.ucc.UccService
    public void applyToken(String str, Map<String, String> map, UccCallback uccCallback) {
        UccParams uccParams = new UccParams();
        uccParams.bindSite = str;
        UccServiceProviderFactory.getInstance().getUccServiceProvider(str).applyToken(uccParams, map, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccService
    public void bind(Activity activity, String str, String str2, UccCallback uccCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("needSession", "0");
        bind(activity, str, str2, hashMap, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccService
    public void bindAlipay(String str, String str2, Map<String, String> map, UccCallback uccCallback) {
        UccActivity.mUccCallback = uccCallback;
        Intent intent = new Intent();
        intent.putExtra(UccConstants.PARAM_FUNC_TYPE, 3);
        intent.putExtra("bizCode", str);
        intent.putExtra(UccConstants.PARAM_REALM, str2);
        intent.setClass(KernelContext.getApplicationContext(), UccActivity.class);
        intent.setFlags(268435456);
        KernelContext.getApplicationContext().startActivity(intent);
    }

    @Override // com.ali.user.open.ucc.UccService
    public void bindWithIBB(Activity activity, String str, String str2, Map<String, String> map, UccCallback uccCallback) {
        UccParams uccParams = new UccParams();
        uccParams.traceId = Utils.generateTraceId("bindWithIbb");
        uccParams.bindSite = str;
        uccParams.site = AliMemberSDK.getMasterSite();
        HashMap hashMap = new HashMap();
        if (map != null) {
            uccParams.miniAppId = map.get("miniAppId");
            hashMap.put("scene", map.get("scene"));
            hashMap.put("needSession", TextUtils.equals(map.get("needSession"), "1") ? "T" : UTConstant.Args.UT_SUCCESS_F);
        }
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBindWithIbb_Invoke", uccParams, hashMap);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(ParamsConstants.Key.PARAM_NEED_LOCAL_SESSION, "0");
        map.put("scene", ParamsConstants.UrlConstant.NEW_YOUKU_UPGRADE);
        map.put("needSession", "1");
        map.put(ParamsConstants.Key.PARAM_ONLY_AUTHCODE, "1");
        map.put(ParamsConstants.Key.PARAM_IS_BIND, "1");
        UccServiceProviderFactory.getInstance().getUccServiceProvider(str).bindWithIBB(activity, uccParams, str2, map, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccService
    public void cleanUp() {
        UccServiceProviderFactory.getInstance().cleanUp();
    }

    public void doBindAlipay(Activity activity, String str, String str2, Map<String, String> map, UccCallback uccCallback) {
        ((OauthService) AliMemberSDK.getService(OauthService.class)).oauth(activity, "alipay", new AnonymousClass13(str, str2, uccCallback, activity));
    }

    @Override // com.ali.user.open.ucc.UccService
    public void doChangeBind(Activity activity, UccParams uccParams, int i, String str, String str2, Map<String, String> map, UccCallback uccCallback) {
        if (uccCallback == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            uccCallback.onFail(uccParams.bindSite, 1002, "参数错误");
        } else {
            UccBindPresenter.getInstance().doChangeBind(activity, uccParams, i, str, str2, map, uccCallback);
        }
    }

    @Override // com.ali.user.open.ucc.UccService
    public void fetchUrl(final Context context, final String str, final Map<String, String> map, final UccCallback uccCallback) {
        if (uccCallback == null) {
            return;
        }
        final UccParams uccParams = new UccParams();
        uccParams.site = AliMemberSDK.getMasterSite();
        uccParams.bindSite = str;
        if (TextUtils.isEmpty(str)) {
            UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccGrantAuth_InvalidParams", uccParams, null);
            uccCallback.onFail(str, 1900, "参数错误");
        } else if (map != null && map.get("activityId") != null) {
            if (map.get("scene") == null) {
                UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccGrantAuth_InvalidParams", uccParams, null);
                uccCallback.onFail(str, 1900, "参数错误,scene必传");
            } else if (TextUtils.equals("1", map.get(ParamsConstants.Key.PARAM_NO_LOGIN))) {
                uccParams.activityId = map.get("activityId");
                if (AliMemberSDK.getService(OneKeyLoginService.class) != null) {
                    ((OneKeyLoginService) AliMemberSDK.getService(OneKeyLoginService.class)).getLoginMaskPhone(new MemberCallback<String>() { // from class: com.ali.user.open.ucc.UccServiceImpl.14
                        @Override // com.ali.user.open.core.callback.FailureCallback
                        public void onFailure(int i, String str2) {
                            UccH5Presenter.leadNoLoginNewUserH5Page(context, uccParams, map, uccCallback);
                        }

                        @Override // com.ali.user.open.core.callback.MemberCallback
                        public void onSuccess(String str2) {
                            UccParams uccParams2 = uccParams;
                            uccParams2.maskMobile = str2;
                            UccH5Presenter.leadNoLoginNewUserH5Page(context, uccParams2, map, uccCallback);
                        }
                    });
                } else {
                    UccH5Presenter.leadNoLoginNewUserH5Page(context, uccParams, map, uccCallback);
                }
            } else {
                UccDataProvider uccDataProviderInstance = getUccDataProviderInstance(map, str);
                if (uccDataProviderInstance == null) {
                    uccCallback.onFail(str, 1003, "data provider为空");
                } else {
                    uccDataProviderInstance.getUserToken(str, new MemberCallback<String>() { // from class: com.ali.user.open.ucc.UccServiceImpl.15
                        @Override // com.ali.user.open.core.callback.FailureCallback
                        public void onFailure(int i, String str2) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("bindSite", str);
                            UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccGrantAuth_UserTokenNIL", null, hashMap);
                            UccCallback uccCallback2 = uccCallback;
                            String str3 = str;
                            if (TextUtils.isEmpty(str2)) {
                                str2 = "userToken为空";
                            }
                            uccCallback2.onFail(str3, 1004, str2);
                        }

                        @Override // com.ali.user.open.core.callback.MemberCallback
                        public void onSuccess(String str2) {
                            UccParams uccParams2 = uccParams;
                            uccParams2.userToken = str2;
                            uccParams2.activityId = (String) map.get("activityId");
                            UccH5Presenter.leadNewUserH5Page(context, uccParams, map, uccCallback);
                        }
                    });
                }
            }
        } else {
            UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccGrantAuth_InvalidParams", uccParams, null);
            uccCallback.onFail(str, 1900, "参数错误,activityId必传");
        }
    }

    @Override // com.ali.user.open.ucc.UccService
    public Session getSession(String str) {
        return ((SessionService) AliMemberSDK.getService(SessionService.class)).getSession(str);
    }

    @Override // com.ali.user.open.ucc.UccService
    public UccDataProvider getUccDataProvider() {
        return this.mUccDataProvider;
    }

    @Override // com.ali.user.open.ucc.UccService
    public boolean isLoginUrl(String str, String str2) {
        Integer num = UccBizContants.mTrustLoginErrorTime.get(str);
        if (num == null || num.intValue() <= 3) {
            return ((OauthService) AliMemberSDK.getService(OauthService.class)).isLoginUrl(str, str2);
        }
        return false;
    }

    public void launchAppWithAuthCode(Context context, String str, String str2, UccCallback uccCallback) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("tbopen://m.taobao.com/tbopen/index.html?action=ali.open.nav&module=h5&source=" + str + "&visa=5d429034ad046701&appkey=" + ((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey() + "&loginToken=" + str2));
        intent.addFlags(268435456);
        intent.addFlags(ConfigReporter.BIT_GETTER_IMP);
        try {
            context.startActivity(intent);
            uccCallback.onSuccess("taobao", new HashMap());
        } catch (Throwable th) {
            th.printStackTrace();
            uccCallback.onFail("taobao", 1605, "launch taobao error");
        }
    }

    @Override // com.ali.user.open.ucc.UccService
    public void launchTaobao(final Context context, final String str, final UccCallback uccCallback) {
        if (TextUtils.isEmpty(str)) {
            uccCallback.onFail("taobao", 1603, "invalid source");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("source", str);
        applyToken("taobao", hashMap, new UccCallback() { // from class: com.ali.user.open.ucc.UccServiceImpl.11
            @Override // com.ali.user.open.ucc.UccCallback
            public void onFail(String str2, int i, String str3) {
                uccCallback.onFail("taobao", i, str3);
            }

            @Override // com.ali.user.open.ucc.UccCallback
            public void onSuccess(String str2, Map map) {
                if (map != null && !TextUtils.isEmpty((String) map.get("token"))) {
                    UccServiceImpl.this.launchAppWithAuthCode(context, str, (String) map.get("token"), uccCallback);
                } else {
                    uccCallback.onFail("taobao", 1604, "empty token");
                }
            }
        });
    }

    @Override // com.ali.user.open.ucc.UccService
    public void logout(Context context, final String str) {
        UccParams uccParams = new UccParams();
        uccParams.traceId = Utils.generateTraceId("logout");
        uccParams.bindSite = str;
        if (TextUtils.isEmpty(str)) {
            UTHitUtils.send(UTHitConstants.PageUccLogout, "UccLogout_InvalidParams", uccParams, null);
            return;
        }
        UTHitUtils.send(UTHitConstants.PageUccLogout, "UccLogout_Invoke", uccParams, null);
        ((OauthService) AliMemberSDK.getService(OauthService.class)).logout(context, str);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ali.user.open.ucc.UccServiceImpl.8
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent();
                intent.setAction(UccResultAction.NOTIFY_UCC_LOGOUT.name());
                intent.setPackage(KernelContext.getApplicationContext().getPackageName());
                intent.putExtra("site", str);
                UccBroadcastHelper.sendBroadcast(intent);
            }
        }, 500L);
    }

    @Override // com.ali.user.open.ucc.UccService
    public void logoutAll(final Context context) {
        ((MemberExecutorService) AliMemberSDK.getService(MemberExecutorService.class)).postTask(new Runnable() { // from class: com.ali.user.open.ucc.UccServiceImpl.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final List<String> logoutAll = ((OauthService) AliMemberSDK.getService(OauthService.class)).logoutAll(context);
                    if (logoutAll == null || logoutAll.size() <= 0) {
                        return;
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ali.user.open.ucc.UccServiceImpl.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Intent intent = new Intent();
                            intent.setAction(UccResultAction.NOTIFY_UCC_LOGOUT.name());
                            intent.setPackage(KernelContext.getApplicationContext().getPackageName());
                            String str = "";
                            for (int i = 0; i < logoutAll.size(); i++) {
                                str = str + ((String) logoutAll.get(i));
                                if (i != logoutAll.size() - 1) {
                                    str = str + ";";
                                }
                            }
                            intent.putExtra("site", str);
                            UccBroadcastHelper.sendBroadcast(intent);
                        }
                    }, 500L);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.ali.user.open.ucc.UccService
    public void noActionBind(String str, Map<String, String> map, UccCallback uccCallback) {
        if (uccCallback == null) {
            return;
        }
        if (map != null && map.get("userToken") != null) {
            UccParams uccParams = new UccParams();
            uccParams.traceId = Utils.generateTraceId("noActionBind");
            uccParams.bindSite = str;
            uccParams.bindSiteUserId = map.get("bindSiteUserId");
            uccParams.site = AliMemberSDK.getMasterSite();
            uccParams.bindSiteNeedTransfer = "1".equals(map.get("bindSiteNeedTransfer"));
            uccParams.createBindSiteSession = "1".equals(map.get("needSession"));
            uccParams.userToken = map.get("userToken");
            uccParams.userTokenType = map.get("userTokenType");
            uccParams.bindUserToken = map.get("bindUserToken");
            uccParams.bindUserTokenType = map.get("bindUserTokenType");
            UccBindPresenter.getInstance().noActionBind(uccParams, uccCallback);
            return;
        }
        uccCallback.onFail(str, 1002, "参数错误");
    }

    @Override // com.ali.user.open.ucc.UccService
    public void noActionBindWithChangeBind(Activity activity, String str, Map<String, String> map, UccCallback uccCallback) {
        if (uccCallback == null || activity == null) {
            return;
        }
        if (map != null && map.get("userToken") != null) {
            UccParams uccParams = new UccParams();
            uccParams.traceId = Utils.generateTraceId("noActionBind");
            uccParams.bindSite = str;
            uccParams.bindSiteUserId = map.get("bindSiteUserId");
            uccParams.site = AliMemberSDK.getMasterSite();
            uccParams.bindSiteNeedTransfer = "1".equals(map.get("bindSiteNeedTransfer"));
            uccParams.userToken = map.get("userToken");
            uccParams.userTokenType = map.get("userTokenType");
            uccParams.bindUserToken = map.get("bindUserToken");
            uccParams.bindUserTokenType = map.get("bindUserTokenType");
            uccParams.createBindSiteSession = "1".equals(map.get("needSession"));
            UccBindPresenter.getInstance().noActionBindWithChangeBind(activity, uccParams, map, uccCallback);
            return;
        }
        uccCallback.onFail(str, 1002, "参数错误");
    }

    @Override // com.ali.user.open.ucc.UccService
    public void queryBind(String str, String str2, String str3, boolean z, Map<String, String> map, UccCallback uccCallback) {
        UccParams uccParams = new UccParams();
        uccParams.traceId = Utils.generateTraceId("queryBind");
        uccParams.bindSite = str;
        uccParams.bindSiteNeedTransfer = z;
        UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccUnbind_Invoke", uccParams, null);
        if (uccCallback == null) {
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            uccParams.userToken = str2;
            uccParams.site = AliMemberSDK.getMasterSite();
            uccParams.bindSite = str;
            uccParams.userToken = str2;
            uccParams.userTokenType = str3;
            UccBindPresenter.getInstance().queryBind(uccParams, map, uccCallback);
            return;
        }
        UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccUnbind_InvalidParams", uccParams, null);
        uccCallback.onFail(str, 1009, "参数错误");
    }

    public void realTrustLogin(String str, Map<String, String> map, UccCallback uccCallback) {
        UccActivity.mUccCallback = uccCallback;
        Intent intent = new Intent();
        intent.putExtra(UccConstants.PARAM_FUNC_TYPE, 1);
        intent.putExtra("targetSite", str);
        if (map != null) {
            Bundle bundle = new Bundle();
            SerializableMap serializableMap = new SerializableMap();
            serializableMap.setMap(map);
            bundle.putSerializable("params", serializableMap);
            intent.putExtras(bundle);
        }
        intent.setClass(KernelContext.getApplicationContext(), UccActivity.class);
        intent.setFlags(268435456);
        KernelContext.getApplicationContext().startActivity(intent);
    }

    @Override // com.ali.user.open.ucc.UccService
    public void setUccDataProvider(UccDataProvider uccDataProvider) {
        this.mUccDataProvider = uccDataProvider;
    }

    @Override // com.ali.user.open.ucc.UccService
    public void trustLogin(Activity activity, String str, UccCallback uccCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("needSession", "1");
        trustLogin(activity, str, hashMap, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccService
    public void uccOAuthLogin(final Activity activity, final String str, Map<String, String> map, final UccCallback uccCallback) {
        final UccParams uccParams = new UccParams();
        uccParams.traceId = Utils.generateTraceId("login");
        uccParams.bindSite = str;
        UTHitUtils.send(UTHitConstants.PageUccOAuthLogin, "UccOAuthLogin_Invoke", uccParams, null);
        if (uccCallback == null) {
            return;
        }
        if (activity != null && !TextUtils.isEmpty(str)) {
            ((OauthService) AliMemberSDK.getService(OauthService.class)).oauth(activity, str, new OauthCallback() { // from class: com.ali.user.open.ucc.UccServiceImpl.7
                @Override // com.ali.user.open.oauth.OauthCallback
                public void onFail(String str2, int i, String str3) {
                    UccCallback uccCallback2 = uccCallback;
                    if (uccCallback2 != null) {
                        uccCallback2.onFail(str, i, str3);
                    }
                }

                @Override // com.ali.user.open.oauth.OauthCallback
                public void onSuccess(String str2, Map map2) {
                    uccParams.site = str;
                    String str3 = "";
                    if (map2 != null && map2.get("site") != null) {
                        str3 = (String) map2.get("site");
                    }
                    if (map2 != null && !TextUtils.isEmpty(str3)) {
                        uccParams.bindSite = str3;
                    } else {
                        uccParams.bindSite = AliMemberSDK.getMasterSite();
                    }
                    uccParams.bindUserToken = (String) map2.get(SignConstants.MIDDLE_PARAM_AUTHCODE);
                    uccParams.bindUserTokenType = "oauthcode";
                    UccOauthLoginPresenter.getInstance().doUccOAuthLogin(activity, uccParams, map2, uccCallback);
                }
            });
            return;
        }
        UTHitUtils.send(UTHitConstants.PageUccOAuthLogin, "UccOAuthLogin_InvalidParams", uccParams, null);
        uccCallback.onFail(str, 1002, "参数错误");
    }

    @Override // com.ali.user.open.ucc.UccService
    public void unbind(String str, UccCallback uccCallback) {
        unbind(str, null, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccService
    public void updateGrantAuthorization(String str, String str2, String str3, String str4, boolean z, UccCallback uccCallback) {
        UccParams uccParams = new UccParams();
        uccParams.traceId = Utils.generateTraceId("grantAuth");
        uccParams.bindSite = str;
        UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccGrantAuth_Invoke", uccParams, null);
        if (uccCallback == null) {
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            uccParams.site = AliMemberSDK.getMasterSite();
            uccParams.bindSite = str;
            uccParams.bindSiteUserId = str2;
            uccParams.userToken = str3;
            uccParams.userTokenType = str4;
            uccParams.bindSiteNeedTransfer = z;
            UccBindPresenter.getInstance().updateGrantAuthorization(uccParams, null, uccCallback);
            return;
        }
        UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccGrantAuth_InvalidParams", uccParams, null);
        uccCallback.onFail(str, 1009, "参数错误");
    }

    @Override // com.ali.user.open.ucc.UccService
    public void setUccDataProvider(String str, UccDataProvider uccDataProvider) {
        this.mUccDataProviderContainer.put(str, uccDataProvider);
    }

    @Override // com.ali.user.open.ucc.UccService
    public void unbind(final String str, Map<String, String> map, final UccCallback uccCallback) {
        UccBizContants.mBusyControlMap.put(str, 0L);
        final UccParams uccParams = new UccParams();
        uccParams.traceId = Utils.generateTraceId("unbind");
        uccParams.bindSite = str;
        UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccUnbind_Invoke", uccParams, null);
        if (uccCallback == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccUnbind_InvalidParams", uccParams, null);
            uccCallback.onFail(str, 1009, "参数错误");
            return;
        }
        UccDataProvider uccDataProviderInstance = getUccDataProviderInstance(map, str);
        if (uccDataProviderInstance == null) {
            uccCallback.onFail(str, 1003, "data provider为空");
        } else {
            uccDataProviderInstance.getUserToken(str, new MemberCallback<String>() { // from class: com.ali.user.open.ucc.UccServiceImpl.4
                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("bindSite", str);
                    UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccUnBind_UserTokenNIL", null, hashMap);
                    UccCallback uccCallback2 = uccCallback;
                    String str3 = str;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "userToken为空";
                    }
                    uccCallback2.onFail(str3, 1004, str2);
                }

                @Override // com.ali.user.open.core.callback.MemberCallback
                public void onSuccess(String str2) {
                    UccParams uccParams2 = uccParams;
                    uccParams2.userToken = str2;
                    uccParams2.site = AliMemberSDK.getMasterSite();
                    UccParams uccParams3 = uccParams;
                    uccParams3.bindSite = str;
                    uccParams3.userToken = str2;
                    UccUnbindPresenter.getInstance().doUnbind(uccParams, str, uccCallback);
                }
            });
        }
    }

    @Override // com.ali.user.open.ucc.UccService
    public void bind(Activity activity, @NonNull String str, String str2, Map<String, String> map, UccCallback uccCallback) {
        UccParams uccParams = new UccParams();
        uccParams.traceId = Utils.generateTraceId("bind");
        uccParams.bindSite = str2;
        uccParams.userToken = str;
        HashMap hashMap = new HashMap();
        if (map != null) {
            uccParams.miniAppId = map.get("miniAppId");
            hashMap.put("scene", map.get("scene"));
            hashMap.put("needSession", TextUtils.equals(map.get("needSession"), "1") ? "T" : UTConstant.Args.UT_SUCCESS_F);
            uccParams.sdkVersion = map.get("sdkVersion");
        }
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_Invoke", uccParams, hashMap);
        doBind(activity, uccParams, str2, map, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccService
    public void trustLogin(Activity activity, final String str, Map<String, String> map, UccCallback uccCallback) {
        if (System.currentTimeMillis() - UccStatus.getLastLoginTime(str) > getLoginTimeout(str)) {
            UccStatus.resetLoginFlag(str);
        }
        UccCallbackManager.registerUccCallback(str, uccCallback);
        realTrustLogin(activity, str, map, new UccCallback() { // from class: com.ali.user.open.ucc.UccServiceImpl.5
            @Override // com.ali.user.open.ucc.UccCallback
            public void onFail(String str2, int i, String str3) {
                UccStatus.resetLoginFlag(str);
                if (UccCallbackManager.getUccCallbackWithSite(str) != null) {
                    for (UccCallback uccCallback2 : UccCallbackManager.getUccCallbackWithSite(str)) {
                        if (uccCallback2 != null) {
                            uccCallback2.onFail(str, i, str3);
                        }
                    }
                    UccCallbackManager.unregisterUccCallback(str);
                }
            }

            @Override // com.ali.user.open.ucc.UccCallback
            public void onSuccess(String str2, Map map2) {
                UccStatus.resetLoginFlag(str);
                if (UccCallbackManager.getUccCallbackWithSite(str) != null) {
                    for (UccCallback uccCallback2 : UccCallbackManager.getUccCallbackWithSite(str)) {
                        if (uccCallback2 != null) {
                            uccCallback2.onSuccess(str, map2);
                        }
                    }
                    UccCallbackManager.unregisterUccCallback(str);
                }
            }
        });
    }

    @Override // com.ali.user.open.ucc.UccService
    public void trustLogin(String str, Map<String, String> map, UccCallback uccCallback) {
        SDKLogger.d("UccServiceImpl", "trustLogin goUccActivity");
        UccActivity.mUccCallback = uccCallback;
        if (map != null && TextUtils.equals(map.get(ParamsConstants.Key.PARAM_NEED_UI), "0")) {
            trustLogin(null, str, map, uccCallback);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(UccConstants.PARAM_FUNC_TYPE, 1);
        intent.putExtra("targetSite", str);
        if (map != null) {
            Bundle bundle = new Bundle();
            SerializableMap serializableMap = new SerializableMap();
            serializableMap.setMap(map);
            bundle.putSerializable("params", serializableMap);
            intent.putExtras(bundle);
        }
        intent.setClass(KernelContext.getApplicationContext(), UccActivity.class);
        intent.setFlags(268435456);
        KernelContext.getApplicationContext().startActivity(intent);
    }

    public void realTrustLogin(final Activity activity, final String str, final Map<String, String> map, final UccCallback uccCallback) {
        SDKLogger.e("UccServiceImpl", "trustlogin");
        final UccParams uccParams = new UccParams();
        uccParams.traceId = Utils.generateTraceId("login");
        uccParams.bindSite = str;
        HashMap hashMap = new HashMap();
        if (map != null) {
            uccParams.miniAppId = map.get("miniAppId");
            hashMap.put("scene", map.get("scene"));
            uccParams.sdkVersion = map.get("sdkVersion");
        }
        long loginLimitInterval = getLoginLimitInterval(str);
        if (loginLimitInterval == -1) {
            loginLimitInterval = 500;
        }
        Long l = UccBizContants.mBusyControlMap.get(str);
        if (l == null) {
            l = 0L;
        }
        if (System.currentTimeMillis() - l.longValue() < loginLimitInterval) {
            UTHitUtils.send(UTHitConstants.PageUccLogin, "UccLogin_Busy", uccParams, hashMap);
            if (uccCallback != null) {
                uccCallback.onFail(str, UccResultCode.BIND_BUSY_CONTROL, "");
                return;
            }
            return;
        }
        UTHitUtils.send(UTHitConstants.PageUccLogin, "UccLogin_Invoke", uccParams, hashMap);
        if (uccCallback == null) {
            return;
        }
        boolean z = true;
        if (map != null && TextUtils.equals(map.get(ParamsConstants.Key.PARAM_NEED_UI), "0")) {
            z = false;
        }
        if ((activity == null && z) || TextUtils.isEmpty(str)) {
            UTHitUtils.send(UTHitConstants.PageUccLogin, "UccLogin_InvalidParams", uccParams, null);
            uccCallback.onFail(str, 1002, "参数错误");
            return;
        }
        UccDataProvider uccDataProviderInstance = getUccDataProviderInstance(map, str);
        if (uccDataProviderInstance == null) {
            uccCallback.onFail(str, 1003, "data provider为空");
        } else {
            uccDataProviderInstance.getUserToken(str, new MemberCallback<String>() { // from class: com.ali.user.open.ucc.UccServiceImpl.6
                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str2) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("bindSite", str);
                    hashMap2.put("code", PromotionTagView.HALF_PRICE);
                    UTHitUtils.send(UTHitConstants.PageUccLogin, "UccLogin_UserTokenNIL", null, hashMap2);
                    uccCallback.onFail(str, 1004, str2);
                }

                @Override // com.ali.user.open.core.callback.MemberCallback
                public void onSuccess(String str2) {
                    SDKLogger.e("UccServiceImpl", "trustlogin get usertoken success");
                    uccParams.userToken = str2;
                    Map map2 = map;
                    if (map2 != null && !TextUtils.isEmpty((CharSequence) map2.get("site"))) {
                        uccParams.site = (String) map.get("site");
                    } else {
                        uccParams.site = AliMemberSDK.getMasterSite();
                    }
                    UccParams uccParams2 = uccParams;
                    uccParams2.bindSite = str;
                    uccParams2.userToken = str2;
                    Map map3 = map;
                    if (map3 != null && !TextUtils.isEmpty((CharSequence) map3.get("scene"))) {
                        uccParams.scene = (String) map.get("scene");
                    }
                    Map map4 = map;
                    if (map4 != null && TextUtils.equals((CharSequence) map4.get("silentLogin"), "true")) {
                        map.put(ParamsConstants.Key.PARAM_NEED_UI, "0");
                    }
                    UccTrustLoginPresenter.getInstance().doTrustLogin(activity, uccParams, str, map, uccCallback);
                }
            });
        }
    }

    @Override // com.ali.user.open.ucc.UccService
    public void bind(@NonNull String str, String str2, Map<String, String> map, UccCallback uccCallback) {
        SDKLogger.d("UccServiceImpl", "bind goUccActivity");
        if (uccActivityLimit(str2)) {
            if (uccCallback != null) {
                uccCallback.onFail(str2, UccResultCode.BIND_BUSY_CONTROL, "频繁调用");
                return;
            }
            return;
        }
        UccActivity.mUccCallback = uccCallback;
        Intent intent = new Intent();
        intent.putExtra(UccConstants.PARAM_FUNC_TYPE, 2);
        intent.putExtra("targetSite", str2);
        intent.putExtra("userToken", str);
        if (map != null) {
            Bundle bundle = new Bundle();
            SerializableMap serializableMap = new SerializableMap();
            serializableMap.setMap(map);
            bundle.putSerializable("params", serializableMap);
            intent.putExtras(bundle);
        }
        intent.setClass(KernelContext.getApplicationContext(), UccActivity.class);
        intent.setFlags(268435456);
        KernelContext.getApplicationContext().startActivity(intent);
    }

    @Override // com.ali.user.open.ucc.UccService
    public void queryBind(final String str, final Map<String, String> map, final UccCallback uccCallback) {
        final UccParams uccParams = new UccParams();
        uccParams.traceId = Utils.generateTraceId("unbind");
        uccParams.bindSite = str;
        uccParams.bindSiteNeedTransfer = false;
        UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccUnbind_Invoke", uccParams, null);
        if (uccCallback == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccUnbind_InvalidParams", uccParams, null);
            uccCallback.onFail(str, 1009, "参数错误");
            return;
        }
        UccDataProvider uccDataProviderInstance = getUccDataProviderInstance(map, str);
        if (uccDataProviderInstance == null) {
            uccCallback.onFail(str, 1003, "data provider为空");
        } else {
            uccDataProviderInstance.getUserToken(str, new MemberCallback<String>() { // from class: com.ali.user.open.ucc.UccServiceImpl.10
                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("bindSite", str);
                    UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccUnBind_UserTokenNIL", null, hashMap);
                    UccCallback uccCallback2 = uccCallback;
                    String str3 = str;
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "userToken为空";
                    }
                    uccCallback2.onFail(str3, 1004, str2);
                }

                @Override // com.ali.user.open.core.callback.MemberCallback
                public void onSuccess(String str2) {
                    UccParams uccParams2 = uccParams;
                    uccParams2.userToken = str2;
                    uccParams2.site = AliMemberSDK.getMasterSite();
                    UccParams uccParams3 = uccParams;
                    uccParams3.bindSite = str;
                    uccParams3.userToken = str2;
                    UccBindPresenter.getInstance().queryBind(uccParams, map, uccCallback);
                }
            });
        }
    }

    @Override // com.ali.user.open.ucc.UccService
    public void updateGrantAuthorization(String str, String str2, String str3, String str4, UccCallback uccCallback) {
        updateGrantAuthorization(str, str2, str3, str4, false, uccCallback);
    }

    @Override // com.ali.user.open.ucc.UccService
    public void updateGrantAuthorization(final String str, final String str2, Map<String, String> map, final UccCallback uccCallback) {
        final UccParams uccParams = new UccParams();
        uccParams.traceId = Utils.generateTraceId("grantAuth");
        uccParams.bindSite = str;
        uccParams.bindSiteUserId = str2;
        UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccGrantAuth_Invoke", uccParams, null);
        if (uccCallback == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccGrantAuth_InvalidParams", uccParams, null);
            uccCallback.onFail(str, 1009, "参数错误");
            return;
        }
        UccDataProvider uccDataProviderInstance = getUccDataProviderInstance(map, str);
        if (uccDataProviderInstance == null) {
            uccCallback.onFail(str, 1003, "data provider为空");
        } else {
            uccDataProviderInstance.getUserToken(str, new MemberCallback<String>() { // from class: com.ali.user.open.ucc.UccServiceImpl.12
                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str3) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("bindSite", str);
                    UTHitUtils.send(UTHitConstants.PageUccUnBind, "UccGrantAuth_UserTokenNIL", null, hashMap);
                    UccCallback uccCallback2 = uccCallback;
                    String str4 = str;
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "userToken为空";
                    }
                    uccCallback2.onFail(str4, 1004, str3);
                }

                @Override // com.ali.user.open.core.callback.MemberCallback
                public void onSuccess(String str3) {
                    UccParams uccParams2 = uccParams;
                    uccParams2.userToken = str3;
                    uccParams2.site = AliMemberSDK.getMasterSite();
                    UccParams uccParams3 = uccParams;
                    uccParams3.bindSite = str;
                    uccParams3.bindSiteUserId = str2;
                    uccParams3.bindSiteNeedTransfer = false;
                    UccBindPresenter.getInstance().updateGrantAuthorization(uccParams, null, uccCallback);
                }
            });
        }
    }

    @Override // com.ali.user.open.ucc.UccService
    public void bind(final Activity activity, final String str, final UccCallback uccCallback) {
        final UccParams uccParams = new UccParams();
        uccParams.traceId = Utils.generateTraceId("bind");
        uccParams.bindSite = str;
        HashMap hashMap = new HashMap();
        hashMap.put("needSession", UTConstant.Args.UT_SUCCESS_F);
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_Invoke", uccParams, hashMap);
        UccDataProvider uccDataProviderInstance = getUccDataProviderInstance(new HashMap(), str);
        if (uccDataProviderInstance == null) {
            uccCallback.onFail(str, 1003, "data provider为空");
        } else {
            uccDataProviderInstance.getUserToken(str, new MemberCallback<String>() { // from class: com.ali.user.open.ucc.UccServiceImpl.1
                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str2) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("bindSite", str);
                    hashMap2.put("code", PromotionTagView.HALF_PRICE);
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_UserTokenNIL", null, hashMap2);
                    UccCallback uccCallback2 = uccCallback;
                    if (uccCallback2 != null) {
                        String str3 = str;
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "userToken为空";
                        }
                        uccCallback2.onFail(str3, 1004, str2);
                    }
                }

                @Override // com.ali.user.open.core.callback.MemberCallback
                public void onSuccess(String str2) {
                    UccParams uccParams2 = uccParams;
                    uccParams2.userToken = str2;
                    UccServiceImpl.this.doBind(activity, uccParams2, str, null, uccCallback);
                }
            });
        }
    }

    @Override // com.ali.user.open.ucc.UccService
    public void bind(final Activity activity, final String str, final Map<String, String> map, final UccCallback uccCallback) {
        final UccParams uccParams = new UccParams();
        uccParams.traceId = Utils.generateTraceId("bind");
        uccParams.bindSite = str;
        if (map != null && !TextUtils.isEmpty(map.get("scene"))) {
            uccParams.scene = map.get("scene");
        }
        HashMap hashMap = new HashMap();
        if (map != null) {
            uccParams.miniAppId = map.get("miniAppId");
            hashMap.put("scene", map.get("scene"));
            hashMap.put("needSession", TextUtils.equals(map.get("needSession"), "1") ? "T" : UTConstant.Args.UT_SUCCESS_F);
            uccParams.sdkVersion = map.get("sdkVersion");
        }
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_Invoke", uccParams, hashMap);
        UccDataProvider uccDataProviderInstance = getUccDataProviderInstance(map, str);
        if (uccDataProviderInstance == null) {
            uccCallback.onFail(str, 1003, "data provider为空");
        } else {
            uccDataProviderInstance.getUserToken(str, new MemberCallback<String>() { // from class: com.ali.user.open.ucc.UccServiceImpl.2
                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str2) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("bindSite", str);
                    hashMap2.put("code", PromotionTagView.HALF_PRICE);
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_UserTokenNIL", null, hashMap2);
                    UccCallback uccCallback2 = uccCallback;
                    if (uccCallback2 != null) {
                        String str3 = str;
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "userToken为空";
                        }
                        uccCallback2.onFail(str3, 1004, str2);
                    }
                }

                @Override // com.ali.user.open.core.callback.MemberCallback
                public void onSuccess(String str2) {
                    UccParams uccParams2 = uccParams;
                    uccParams2.userToken = str2;
                    UccServiceImpl.this.doBind(activity, uccParams2, str, map, uccCallback);
                }
            });
        }
    }

    @Override // com.ali.user.open.ucc.UccService
    public void bind(final String str, final Map<String, String> map, final UccCallback uccCallback) {
        UccDataProvider uccDataProviderInstance = getUccDataProviderInstance(map, str);
        if (uccDataProviderInstance == null) {
            uccCallback.onFail(str, 1003, "data provider为空");
        } else {
            uccDataProviderInstance.getUserToken(str, new MemberCallback<String>() { // from class: com.ali.user.open.ucc.UccServiceImpl.3
                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str2) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("bindSite", str);
                    hashMap.put("code", PromotionTagView.HALF_PRICE);
                    UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_UserTokenNIL", null, hashMap);
                    UccCallback uccCallback2 = uccCallback;
                    if (uccCallback2 != null) {
                        String str3 = str;
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "userToken为空";
                        }
                        uccCallback2.onFail(str3, 1004, str2);
                    }
                }

                @Override // com.ali.user.open.core.callback.MemberCallback
                public void onSuccess(String str2) {
                    UccServiceImpl.this.bind(str2, str, map, uccCallback);
                }
            });
        }
    }
}
