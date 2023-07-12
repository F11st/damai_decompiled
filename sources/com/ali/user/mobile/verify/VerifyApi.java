package com.ali.user.mobile.verify;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.callback.RpcRequestCallback;
import com.ali.user.mobile.eventbus.Event;
import com.ali.user.mobile.eventbus.EventBus;
import com.ali.user.mobile.eventbus.EventBusEnum;
import com.ali.user.mobile.eventbus.EventListener;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.model.FingerInfo;
import com.ali.user.mobile.model.UrlParam;
import com.ali.user.mobile.rpc.RpcResponse;
import com.ali.user.mobile.rpc.safe.AES;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.FingerprintService;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.verify.impl.VerifyServiceImpl;
import com.ali.user.mobile.verify.model.OpenBiometricData;
import com.ali.user.mobile.verify.model.VerifyParam;
import com.taobao.login4android.config.LoginSwitch;
import com.taobao.login4android.session.SessionManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class VerifyApi {
    public static final int CLOSE_FINGER_ERROR = 4010;
    public static final int CLOSE_FINGER_ILLEGAL = 4010;
    public static final int FINGER_VERIFY_INVALID_PARAM = 4020;
    public static final int FINGER_VERIFY_NO_BIO_KEY = 4021;
    public static final int OPEN_FINGER_CANCEL = 4002;
    public static final int OPEN_FINGER_ERROR = 4001;
    public static final int OPEN_FINGER_ILLEGAL = 4003;
    public static final int OPEN_FINGER_UNROLL = 4004;
    private static String TAG = "login.verify";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.ali.user.mobile.verify.VerifyApi$4  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static class AnonymousClass4 implements RpcRequestCallback<OpenBiometricData> {
        final /* synthetic */ CommonCallback val$callback;
        final /* synthetic */ Context val$context;
        final /* synthetic */ VerifyParam val$param;

        AnonymousClass4(Context context, CommonCallback commonCallback, VerifyParam verifyParam) {
            this.val$context = context;
            this.val$callback = commonCallback;
            this.val$param = verifyParam;
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onError(final RpcResponse<OpenBiometricData> rpcResponse) {
            OpenBiometricData openBiometricData;
            if (rpcResponse != null && (openBiometricData = rpcResponse.returnValue) != null && !TextUtils.isEmpty(openBiometricData.h5Url) && "H5".equals(rpcResponse.actionType)) {
                EventBus.getDefault().registerEventListener(EventBusEnum.EventName.ACTION_H5, new EventListener() { // from class: com.ali.user.mobile.verify.VerifyApi.4.1
                    @Override // com.ali.user.mobile.eventbus.EventListener
                    public void onEvent(Event event) {
                        Map<String, Object> map;
                        EventBus.getDefault().unregisterEventListener(EventBusEnum.EventName.ACTION_H5, this);
                        if (event != null && (map = event.params) != null) {
                            String str = (String) map.get("token");
                            String str2 = (String) event.params.get("result");
                            if (!TextUtils.isEmpty(str) && TextUtils.equals(str2, "success")) {
                                VerifyParam verifyParam = new VerifyParam();
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                VerifyParam verifyParam2 = anonymousClass4.val$param;
                                verifyParam.biometricId = verifyParam2.biometricId;
                                verifyParam.requestScene = verifyParam2.requestScene;
                                verifyParam.ivToken = str;
                                verifyParam.loginToken = verifyParam2.loginToken;
                                VerifyApi.setAfterLogin(anonymousClass4.val$context, verifyParam, anonymousClass4.val$callback);
                                return;
                            } else if (TextUtils.equals(str2, "cancel")) {
                                AnonymousClass4.this.val$callback.onFail(4002, "取消指纹开启");
                                return;
                            } else {
                                AnonymousClass4.this.onSystemError(rpcResponse);
                                return;
                            }
                        }
                        AnonymousClass4.this.onSystemError(rpcResponse);
                    }
                });
                UrlParam urlParam = new UrlParam();
                urlParam.url = rpcResponse.returnValue.h5Url;
                ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).navToWebViewPage(EventBusEnum.EventName.ACTION_H5, urlParam);
                return;
            }
            onSystemError(rpcResponse);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSuccess(RpcResponse<OpenBiometricData> rpcResponse) {
            VerifyApi.afterOpenRpcSuccess(this.val$context, this.val$callback, rpcResponse);
        }

        @Override // com.ali.user.mobile.callback.RpcRequestCallback
        public void onSystemError(RpcResponse<OpenBiometricData> rpcResponse) {
            this.val$callback.onFail(4001, "指纹开启失败");
        }
    }

    protected static void afterOpenRpcSuccess(Context context, final CommonCallback commonCallback, final RpcResponse<OpenBiometricData> rpcResponse) {
        OpenBiometricData openBiometricData;
        if (rpcResponse != null && (openBiometricData = rpcResponse.returnValue) != null && !TextUtils.isEmpty(openBiometricData.biometricKey) && !TextUtils.isEmpty(rpcResponse.returnValue.biometricId)) {
            if (ServiceFactory.getService(FingerprintService.class) != null) {
                ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).fingerSet(context, new CommonCallback() { // from class: com.ali.user.mobile.verify.VerifyApi.5
                    @Override // com.ali.user.mobile.model.CommonCallback
                    public void onFail(int i, String str) {
                        commonCallback.onFail(i, str);
                    }

                    @Override // com.ali.user.mobile.model.CommonCallback
                    public void onSuccess() {
                        VerifyApi.handleResponse(RpcResponse.this);
                        commonCallback.onSuccess();
                    }
                });
                return;
            } else {
                commonCallback.onFail(4001, "未引入指纹模块");
                return;
            }
        }
        commonCallback.onFail(4001, "指纹开启失败");
    }

    protected static void callOpenRpc(Context context, VerifyParam verifyParam, CommonCallback commonCallback) {
        try {
            VerifyServiceImpl.getInstance().openFinger(verifyParam, new AnonymousClass4(context, commonCallback, verifyParam));
        } catch (Throwable th) {
            th.printStackTrace();
            commonCallback.onFail(4001, "指纹开启失败");
        }
    }

    public static void closeBiometric(final VerifyParam verifyParam, final CommonCallback commonCallback) {
        if (commonCallback == null) {
            return;
        }
        if (verifyParam == null) {
            commonCallback.onFail(4010, "参数非法");
            return;
        }
        try {
            if (TextUtils.isEmpty(verifyParam.biometricId)) {
                verifyParam.biometricId = SessionManager.getInstance(DataProviderFactory.getApplicationContext()).getBiometricId();
            }
            VerifyServiceImpl.getInstance().closeFinger(verifyParam, new RpcRequestCallback<Void>() { // from class: com.ali.user.mobile.verify.VerifyApi.6
                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onError(RpcResponse<Void> rpcResponse) {
                    onSystemError(rpcResponse);
                }

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onSuccess(RpcResponse<Void> rpcResponse) {
                    if (VerifyParam.this.list != null) {
                        SecurityGuardManagerWraper.removeAllFinger();
                    } else {
                        FingerInfo fingerInfo = new FingerInfo();
                        fingerInfo.key = VerifyParam.this.biometricId;
                        SecurityGuardManagerWraper.removeFinger(fingerInfo);
                    }
                    commonCallback.onSuccess();
                }

                @Override // com.ali.user.mobile.callback.RpcRequestCallback
                public void onSystemError(RpcResponse<Void> rpcResponse) {
                    commonCallback.onFail(4010, "指纹关闭失败");
                }
            });
        } catch (Throwable unused) {
            commonCallback.onFail(4010, "指纹关闭失败");
        }
    }

    protected static void handleResponse(RpcResponse<OpenBiometricData> rpcResponse) {
        FingerInfo fingerInfo = new FingerInfo();
        OpenBiometricData openBiometricData = rpcResponse.returnValue;
        fingerInfo.key = openBiometricData.biometricId;
        fingerInfo.value = openBiometricData.biometricKey;
        fingerInfo.loginTime = openBiometricData.biometricOpenTime == 0 ? System.currentTimeMillis() : openBiometricData.biometricOpenTime;
        saveFingerInBackground(fingerInfo, rpcResponse.returnValue.biometricIdList);
    }

    public static void invalidAll() {
        UserTrackAdapter.sendUT("FingerInvalidAll");
        BackgroundExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.verify.VerifyApi.7
            @Override // java.lang.Runnable
            public void run() {
                List<FingerInfo> fingerList = SecurityGuardManagerWraper.getFingerList();
                if (fingerList == null || fingerList.size() == 0) {
                    return;
                }
                VerifyParam verifyParam = new VerifyParam();
                verifyParam.list = fingerList;
                verifyParam.requestScene = "biometric_changed";
                VerifyApi.closeBiometric(verifyParam, new CommonCallback() { // from class: com.ali.user.mobile.verify.VerifyApi.7.1
                    @Override // com.ali.user.mobile.model.CommonCallback
                    public void onFail(int i, String str) {
                        TLogAdapter.e(VerifyApi.TAG, "close biometric failed");
                        SecurityGuardManagerWraper.removeAllFinger();
                    }

                    @Override // com.ali.user.mobile.model.CommonCallback
                    public void onSuccess() {
                        TLogAdapter.e(VerifyApi.TAG, "close biometric success");
                    }
                });
            }
        });
    }

    public static void openBiometric(final Context context, final VerifyParam verifyParam, final CommonCallback commonCallback) {
        if (commonCallback == null) {
            return;
        }
        if (verifyParam != null) {
            try {
                if (!TextUtils.isEmpty(verifyParam.requestScene)) {
                    if (ServiceFactory.getService(FingerprintService.class) == null) {
                        commonCallback.onFail(4001, "未接入指纹SDK");
                        return;
                    } else if (!((FingerprintService) ServiceFactory.getService(FingerprintService.class)).isFingerprintSetable()) {
                        commonCallback.onFail(4001, "指纹硬件不支持");
                        return;
                    } else if (!"account_center".equals(verifyParam.requestScene) && !((FingerprintService) ServiceFactory.getService(FingerprintService.class)).isFingerprintAvailable()) {
                        commonCallback.onFail(4004, "指纹未录入");
                        return;
                    } else {
                        UserTrackAdapter.sendUT("setFingerCheck");
                        new AES().checkValid(new CommonCallback() { // from class: com.ali.user.mobile.verify.VerifyApi.1
                            @Override // com.ali.user.mobile.model.CommonCallback
                            public void onFail(int i, String str) {
                                UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "setFingerCheck_fail", String.valueOf(i), null);
                                if ("login_success".equals(VerifyParam.this.requestScene)) {
                                    VerifyApi.setAfterLogin(context, VerifyParam.this, commonCallback);
                                } else {
                                    VerifyApi.callOpenRpc(context, VerifyParam.this, commonCallback);
                                }
                            }

                            @Override // com.ali.user.mobile.model.CommonCallback
                            public void onSuccess() {
                                UserTrackAdapter.sendUT("setFingerCheck_success");
                                if ("login_success".equals(VerifyParam.this.requestScene)) {
                                    VerifyApi.setAfterLogin(context, VerifyParam.this, commonCallback);
                                } else {
                                    VerifyApi.callOpenRpc(context, VerifyParam.this, commonCallback);
                                }
                            }
                        });
                        return;
                    }
                }
            } catch (Throwable th) {
                try {
                    UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, "setFingerCheck_fail", th.getMessage(), null);
                } catch (Throwable unused) {
                }
                commonCallback.onFail(4001, "指纹开启失败");
                th.printStackTrace();
                return;
            }
        }
        commonCallback.onFail(4003, "参数不合法");
    }

    public static void saveFingerInBackground(final FingerInfo fingerInfo, final ArrayList<String> arrayList) {
        if (LoginSwitch.getSwitch("degradeFingerBackground", "true")) {
            SecurityGuardManagerWraper.saveFinger(fingerInfo, arrayList);
            try {
                if (TextUtils.isEmpty(SecurityGuardManagerWraper.getFingerValue(fingerInfo.key))) {
                    UserTrackAdapter.sendUT("LostFingerToken");
                    return;
                }
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        BackgroundExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.verify.VerifyApi.3
            @Override // java.lang.Runnable
            public void run() {
                SecurityGuardManagerWraper.saveFinger(FingerInfo.this, arrayList);
                try {
                    if (TextUtils.isEmpty(SecurityGuardManagerWraper.getFingerValue(FingerInfo.this.key))) {
                        UserTrackAdapter.sendUT("LostFingerToken");
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    protected static void setAfterLogin(Context context, final VerifyParam verifyParam, final CommonCallback commonCallback) {
        if (ServiceFactory.getService(FingerprintService.class) != null) {
            ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).fingerSet(context, new CommonCallback() { // from class: com.ali.user.mobile.verify.VerifyApi.2
                @Override // com.ali.user.mobile.model.CommonCallback
                public void onFail(int i, String str) {
                    commonCallback.onFail(i, str);
                }

                @Override // com.ali.user.mobile.model.CommonCallback
                public void onSuccess() {
                    VerifyServiceImpl.getInstance().openFinger(VerifyParam.this, new RpcRequestCallback<OpenBiometricData>() { // from class: com.ali.user.mobile.verify.VerifyApi.2.1
                        @Override // com.ali.user.mobile.callback.RpcRequestCallback
                        public void onError(RpcResponse<OpenBiometricData> rpcResponse) {
                            commonCallback.onFail(4001, "指纹开启失败");
                        }

                        @Override // com.ali.user.mobile.callback.RpcRequestCallback
                        public void onSuccess(RpcResponse<OpenBiometricData> rpcResponse) {
                            VerifyApi.handleResponse(rpcResponse);
                            commonCallback.onSuccess();
                        }

                        @Override // com.ali.user.mobile.callback.RpcRequestCallback
                        public void onSystemError(RpcResponse<OpenBiometricData> rpcResponse) {
                            commonCallback.onFail(4001, "指纹开启失败");
                        }
                    });
                }
            });
        } else {
            commonCallback.onFail(4001, "未引入指纹模块");
        }
    }
}
