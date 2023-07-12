package com.taobao.login4android.video;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import android.taobao.windvane.runtimepermission.PermissionProposer;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.helper.DialogHelper;
import com.ali.user.mobile.log.TLogAdapter;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.CommonCallback;
import com.ali.user.mobile.security.SecurityGuardManagerWraper;
import com.ali.user.mobile.service.FingerprintService;
import com.ali.user.mobile.service.NavigatorService;
import com.ali.user.mobile.service.ServiceFactory;
import com.ali.user.mobile.utils.NetworkUtil;
import com.ali.user.mobile.verify.VerifyApi;
import com.ali.user.mobile.verify.model.VerifyParam;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.login4android.broadcast.LoginAction;
import com.taobao.login4android.broadcast.LoginBroadcastHelper;
import com.taobao.login4android.constants.LoginEnvType;
import com.taobao.login4android.login.LoginController;
import com.taobao.login4android.sdk.R;
import com.taobao.login4android.session.constants.SessionConstants;
import com.taobao.login4android.video.UploadTask;
import com.taobao.weex.devtools.debug.WXDebugConstants;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class VerifyJsbridge extends WVApiPlugin {
    private BroadcastReceiver mLoginReceiver;
    private WVCallBackContext mCallback = null;
    private String TAG = "loginsdk.JSBridgeService";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.video.VerifyJsbridge$a */
    /* loaded from: classes11.dex */
    public class C6740a implements UploadTask.ResultCallback {
        final /* synthetic */ WVResult a;
        final /* synthetic */ WVCallBackContext b;
        final /* synthetic */ long c;

        C6740a(WVResult wVResult, WVCallBackContext wVCallBackContext, long j) {
            this.a = wVResult;
            this.b = wVCallBackContext;
            this.c = j;
        }

        @Override // com.taobao.login4android.video.UploadTask.ResultCallback
        public void onFail(String str) {
            String str2 = VerifyJsbridge.this.TAG;
            TLogAdapter.e(str2, "msg=" + str);
            VerifyJsbridge.this.errorCallback(this.b, UTConstant.Args.UT_VERIFY_STOPRECORD, RecordErrorCode.E_UPLOAD_FAIL);
        }

        @Override // com.taobao.login4android.video.UploadTask.ResultCallback
        public void onSuccess(String str) {
            this.a.setResult(WVResult.SUCCESS);
            this.a.addData("voiceUrl", str);
            this.a.addData(WXDebugConstants.ENV_DEVICE_MODEL, Build.getMODEL());
            this.b.success(this.a);
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = VerifyJsbridge.this.TAG;
            TLogAdapter.e(str2, "upload time=" + (currentTimeMillis - this.c));
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.video.VerifyJsbridge$b */
    /* loaded from: classes11.dex */
    static /* synthetic */ class C6741b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LoginAction.values().length];
            a = iArr;
            try {
                iArr[LoginAction.NOTIFY_IV_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LoginAction.NOTIFY_IV_FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.video.VerifyJsbridge$c */
    /* loaded from: classes11.dex */
    public class C6742c implements CommonCallback {
        final /* synthetic */ WVResult a;
        final /* synthetic */ String b;
        final /* synthetic */ WVCallBackContext c;

        C6742c(VerifyJsbridge verifyJsbridge, WVResult wVResult, String str, WVCallBackContext wVCallBackContext) {
            this.a = wVResult;
            this.b = str;
            this.c = wVCallBackContext;
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onFail(int i, String str) {
            this.a.addData("code", Integer.valueOf(i));
            WVCallBackContext wVCallBackContext = this.c;
            if (wVCallBackContext != null) {
                wVCallBackContext.error(this.a);
            }
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onSuccess() {
            this.a.addData("biometricKey", this.b);
            WVCallBackContext wVCallBackContext = this.c;
            if (wVCallBackContext != null) {
                wVCallBackContext.success(this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.video.VerifyJsbridge$d */
    /* loaded from: classes11.dex */
    public class C6743d implements CommonCallback {
        final /* synthetic */ VerifyParam a;
        final /* synthetic */ WVCallBackContext b;

        /* compiled from: Taobao */
        /* renamed from: com.taobao.login4android.video.VerifyJsbridge$d$a */
        /* loaded from: classes11.dex */
        class DialogInterface$OnClickListenerC6744a implements DialogInterface.OnClickListener {
            final /* synthetic */ Activity a;

            DialogInterface$OnClickListenerC6744a(Activity activity) {
                this.a = activity;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C6743d c6743d = C6743d.this;
                VerifyJsbridge.this.errorCallback(c6743d.b, "openBiometricGoSetting", 4002);
                NetworkUtil.goSettings(this.a);
            }
        }

        /* compiled from: Taobao */
        /* renamed from: com.taobao.login4android.video.VerifyJsbridge$d$b */
        /* loaded from: classes11.dex */
        class DialogInterface$OnClickListenerC6745b implements DialogInterface.OnClickListener {
            DialogInterface$OnClickListenerC6745b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C6743d c6743d = C6743d.this;
                VerifyJsbridge.this.errorCallback(c6743d.b, "openBiometricCancelSetting", 4002);
            }
        }

        C6743d(VerifyParam verifyParam, WVCallBackContext wVCallBackContext) {
            this.a = verifyParam;
            this.b = wVCallBackContext;
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onFail(int i, String str) {
            String str2 = this.a.requestScene;
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.OPEN_BIO_F, str2, str2, null);
            if (i == 4004) {
                if (((WVApiPlugin) VerifyJsbridge.this).mContext instanceof Activity) {
                    Activity activity = (Activity) ((WVApiPlugin) VerifyJsbridge.this).mContext;
                    new DialogHelper(activity).alert("", activity.getString(R.string.aliuser_finger_not_roll), activity.getString(R.string.aliuser_finger_go_set), new DialogInterface$OnClickListenerC6744a(activity), activity.getString(R.string.aliuser_cancel), new DialogInterface$OnClickListenerC6745b());
                    return;
                }
                return;
            }
            VerifyJsbridge.this.errorCallback(this.b, "openBiometric", i);
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onSuccess() {
            String str = this.a.requestScene;
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.OPEN_BIO_S, str, str, null);
            VerifyJsbridge.this.successCallback(this.b, "openBiometric");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.video.VerifyJsbridge$e */
    /* loaded from: classes11.dex */
    public class C6746e implements CommonCallback {
        final /* synthetic */ VerifyParam a;
        final /* synthetic */ WVCallBackContext b;

        C6746e(VerifyParam verifyParam, WVCallBackContext wVCallBackContext) {
            this.a = verifyParam;
            this.b = wVCallBackContext;
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onFail(int i, String str) {
            String str2 = this.a.requestScene;
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.CLOSE_BIO_F, str2, str2, null);
            VerifyJsbridge.this.errorCallback(this.b, "closeBiometric", i);
        }

        @Override // com.ali.user.mobile.model.CommonCallback
        public void onSuccess() {
            String str = this.a.requestScene;
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.CLOSE_BIO_S, str, str, null);
            VerifyJsbridge.this.successCallback(this.b, "closeBiometric");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.login4android.video.VerifyJsbridge$f */
    /* loaded from: classes11.dex */
    public class CountDownTimerC6747f extends CountDownTimer {
        final /* synthetic */ int a;
        final /* synthetic */ WVCallBackContext b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        CountDownTimerC6747f(long j, long j2, int i, WVCallBackContext wVCallBackContext) {
            super(j, j2);
            this.a = i;
            this.b = wVCallBackContext;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            AudioRecordFunc.getInstance().stopRecordAndFile();
            if (AudioRecordFunc.getInstance().getMaxVolume() < this.a) {
                VerifyJsbridge.this.successCallback(this.b, UTConstant.Args.UT_VERIFY_CHECKNOISE);
            } else {
                VerifyJsbridge.this.errorCallback(this.b, UTConstant.Args.UT_VERIFY_CHECKNOISE, 13010);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    private synchronized void applyIVToken(String str, final WVCallBackContext wVCallBackContext) {
        this.mCallback = wVCallBackContext;
        try {
            String string = new JSONObject(str).getString("actionType");
            IWVWebView iWVWebView = this.mWebView;
            if (iWVWebView != null) {
                try {
                    String host = Uri.parse(iWVWebView.getUrl()).getHost();
                    if (DataProviderFactory.getDataProvider().getEnvType() == LoginEnvType.ONLINE.getSdkEnvType() && !host.endsWith(".taobao.com") && !host.endsWith(".tmall.com")) {
                        ivErrorCallback(wVCallBackContext, -3, "invalid host");
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (this.mLoginReceiver == null) {
                this.mLoginReceiver = new BroadcastReceiver() { // from class: com.taobao.login4android.video.VerifyJsbridge.4
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        if (intent == null) {
                            return;
                        }
                        int i = C6741b.a[LoginAction.valueOf(intent.getAction()).ordinal()];
                        if (i != 1) {
                            if (i != 2) {
                                return;
                            }
                            VerifyJsbridge.this.ivErrorCallback(wVCallBackContext, intent.getIntExtra("errorCode", 1100), intent.getStringExtra("message"));
                            return;
                        }
                        String stringExtra = intent.getStringExtra("token");
                        if (TextUtils.isEmpty(stringExtra)) {
                            VerifyJsbridge.this.ivErrorCallback(wVCallBackContext, -2, "empty token");
                            return;
                        }
                        WVResult wVResult = new WVResult();
                        wVResult.setResult(WVResult.SUCCESS);
                        wVResult.addData("token", stringExtra);
                        if (VerifyJsbridge.this.mCallback != null) {
                            VerifyJsbridge.this.mCallback.success(wVResult);
                        }
                    }
                };
                LoginBroadcastHelper.registerLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
            }
            LoginController.getInstance().navToIVByScene(DataProviderFactory.getApplicationContext(), string, DataProviderFactory.getDataProvider().getSite());
        } catch (Exception unused) {
            ivErrorCallback(wVCallBackContext, -1, "error param");
        }
    }

    private synchronized void biometricIV(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        String optString = new JSONObject(str).optString(SessionConstants.BIOMETRIC);
        if (ServiceFactory.getService(FingerprintService.class) != null) {
            String fingerValue = SecurityGuardManagerWraper.getFingerValue(optString);
            if (!TextUtils.isEmpty(fingerValue)) {
                ((NavigatorService) ServiceFactory.getService(NavigatorService.class)).fingerIV(this.mContext, new C6742c(this, wVResult, fingerValue, wVCallBackContext));
                return;
            }
            wVResult.addData("code", Integer.valueOf((int) VerifyApi.FINGER_VERIFY_NO_BIO_KEY));
        }
        if (wVCallBackContext != null) {
            wVCallBackContext.error(wVResult);
        }
    }

    public static VerifyParam buildVerifyParam(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString(SessionConstants.BIOMETRIC);
        String string = jSONObject.getString("requestScene");
        String string2 = jSONObject.getString("biometricType");
        String optString2 = jSONObject.optString("token");
        VerifyParam verifyParam = new VerifyParam();
        verifyParam.biometricId = optString;
        verifyParam.requestScene = string;
        verifyParam.biometricType = string2;
        verifyParam.loginToken = optString2;
        return verifyParam;
    }

    private synchronized void checkBiometricStatus(String str, WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        String optString = new JSONObject(str).optString(SessionConstants.BIOMETRIC);
        if (ServiceFactory.getService(FingerprintService.class) != null) {
            if (!TextUtils.isEmpty(SecurityGuardManagerWraper.getFingerValue(optString))) {
                if (wVCallBackContext != null) {
                    wVResult.addData("supportBiometricType", "fingerprint");
                    wVCallBackContext.success(wVResult);
                }
                return;
            }
            wVResult.addData("code", Integer.valueOf((int) VerifyApi.FINGER_VERIFY_NO_BIO_KEY));
        }
        if (wVCallBackContext != null) {
            wVCallBackContext.error(wVResult);
        }
    }

    private synchronized void checkNoise(final String str, final WVCallBackContext wVCallBackContext) {
        try {
            PermissionProposer.buildPermissionTask(wVCallBackContext.getWebview().getContext(), new String[]{"android.permission.RECORD_AUDIO"}).setTaskOnPermissionGranted(new Runnable() { // from class: com.taobao.login4android.video.VerifyJsbridge.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        VerifyJsbridge.this.testRecordNoise(wVCallBackContext, jSONObject.getInt("checkSeconds"), jSONObject.getInt("maxVolume"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                        VerifyJsbridge.this.errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_CHECKNOISE, RecordErrorCode.E_UNKOWN);
                    }
                }
            }).setTaskOnPermissionDenied(new Runnable() { // from class: com.taobao.login4android.video.VerifyJsbridge.5
                @Override // java.lang.Runnable
                public void run() {
                    VerifyJsbridge.this.errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_CHECKNOISE, RecordErrorCode.E_NO_PERMISSION);
                }
            }).execute();
        } catch (Exception e) {
            e.printStackTrace();
            errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_CHECKNOISE, RecordErrorCode.E_UNKOWN);
        }
    }

    private synchronized void closeBiometric(String str, WVCallBackContext wVCallBackContext) {
        try {
            VerifyParam buildVerifyParam = buildVerifyParam(str);
            String str2 = buildVerifyParam.requestScene;
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.CLOSE_BIO_C, str2, str2, null);
            VerifyApi.closeBiometric(buildVerifyParam, new C6746e(buildVerifyParam, wVCallBackContext));
        } catch (JSONException e) {
            e.printStackTrace();
            errorCallback(wVCallBackContext, "closeBiometric", 4010);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errorCallback(WVCallBackContext wVCallBackContext, String str, int i) {
        WVResult wVResult = new WVResult();
        wVResult.setResult("HY_FAILED");
        wVResult.addData("code", Integer.valueOf(i));
        wVResult.addData(WXDebugConstants.ENV_DEVICE_MODEL, Build.getMODEL());
        wVCallBackContext.error(wVResult);
        Properties properties = new Properties();
        properties.put(UTConstant.Args.UT_PROPERTY_SUCCESS, UTConstant.Args.UT_SUCCESS_F);
        properties.put("code", Integer.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UserTrackAdapter.sendUT(str, properties);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ivErrorCallback(WVCallBackContext wVCallBackContext, int i, String str) {
        WVResult wVResult = new WVResult();
        wVResult.setResult("HY_FAILED");
        wVResult.addData("code", Integer.valueOf(i));
        wVResult.addData("message", str);
        wVCallBackContext.error(wVResult);
    }

    private synchronized void openBiometric(String str, WVCallBackContext wVCallBackContext) {
        try {
            VerifyParam buildVerifyParam = buildVerifyParam(str);
            String str2 = buildVerifyParam.requestScene;
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.OPEN_BIO_C, str2, str2, null);
            VerifyApi.openBiometric(this.mContext, buildVerifyParam, new C6743d(buildVerifyParam, wVCallBackContext));
        } catch (Exception e) {
            e.printStackTrace();
            UserTrackAdapter.sendUT(UTConstant.PageName.UT_PAGE_EXTEND, UTConstant.CustomEvent.OPEN_BIO_S);
            errorCallback(wVCallBackContext, "openBiometric", 4003);
        }
    }

    private synchronized void startRecord(final String str, final WVCallBackContext wVCallBackContext) {
        try {
            PermissionProposer.buildPermissionTask(wVCallBackContext.getWebview().getContext(), new String[]{"android.permission.RECORD_AUDIO"}).setTaskOnPermissionGranted(new Runnable() { // from class: com.taobao.login4android.video.VerifyJsbridge.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int i = jSONObject.getInt("maxSeconds");
                        int i2 = jSONObject.getInt("minSeconds");
                        AudioRecordFunc audioRecordFunc = AudioRecordFunc.getInstance();
                        audioRecordFunc.setMaxRecordSeconds(i);
                        audioRecordFunc.setmMinRecordSeconds(i2);
                        audioRecordFunc.startRecordAndFile();
                        VerifyJsbridge.this.successCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STARTRECORD);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        VerifyJsbridge.this.errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STARTRECORD, RecordErrorCode.E_UNKOWN);
                    }
                }
            }).setTaskOnPermissionDenied(new Runnable() { // from class: com.taobao.login4android.video.VerifyJsbridge.8
                @Override // java.lang.Runnable
                public void run() {
                    VerifyJsbridge.this.errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STARTRECORD, RecordErrorCode.E_NO_PERMISSION);
                }
            }).execute();
        } catch (Exception unused) {
            errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STARTRECORD, RecordErrorCode.E_UNKOWN);
        }
    }

    private synchronized void stopRecord(String str, WVCallBackContext wVCallBackContext) {
        long currentTimeMillis;
        AudioRecordFunc audioRecordFunc;
        try {
            currentTimeMillis = System.currentTimeMillis();
            audioRecordFunc = AudioRecordFunc.getInstance();
        } catch (Throwable th) {
            th.printStackTrace();
            errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STOPRECORD, RecordErrorCode.E_UNKOWN);
        }
        if (audioRecordFunc.isClosedForLimit()) {
            errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STOPRECORD, RecordErrorCode.E_15_SECONDS_LIMMIT);
            AudioRecordFunc.getInstance().stopRecordAndFile();
            return;
        }
        audioRecordFunc.stopRecordAndFile();
        long recordTime = audioRecordFunc.getRecordTime();
        if (recordTime > audioRecordFunc.getMaxRecordSeconds()) {
            errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STOPRECORD, RecordErrorCode.E_15_SECONDS_LIMMIT);
        } else if (recordTime < audioRecordFunc.getMinRecordSeconds()) {
            errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STOPRECORD, RecordErrorCode.E_1_SECONDS_LIMIT);
        } else {
            String audioName = audioRecordFunc.getAudioName();
            if (audioName != null) {
                UploadTask.getInstance().setResultCallback(new C6740a(new WVResult(), wVCallBackContext, currentTimeMillis));
                UploadTask.getInstance().uploadAsync(DataProviderFactory.getApplicationContext(), audioName, "a/b");
            } else {
                errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_STOPRECORD, RecordErrorCode.E_UNKOWN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void successCallback(WVCallBackContext wVCallBackContext, String str) {
        WVResult wVResult = new WVResult();
        wVResult.setResult(WVResult.SUCCESS);
        wVResult.addData(WXDebugConstants.ENV_DEVICE_MODEL, Build.getMODEL());
        wVCallBackContext.success(wVResult);
        Properties properties = new Properties();
        properties.put(UTConstant.Args.UT_PROPERTY_SUCCESS, "T");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UserTrackAdapter.sendUT(str, properties);
    }

    private synchronized void supportBiometricType(WVCallBackContext wVCallBackContext) {
        WVResult wVResult = new WVResult();
        wVResult.setResult(WVResult.SUCCESS);
        if (ServiceFactory.getService(FingerprintService.class) != null && ((FingerprintService) ServiceFactory.getService(FingerprintService.class)).isFingerprintSetable()) {
            wVResult.addData("supportBiometricType", "fingerprint");
        } else {
            wVResult.addData("supportBiometricType", "");
        }
        if (wVCallBackContext != null) {
            wVCallBackContext.success(wVResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void testRecordNoise(WVCallBackContext wVCallBackContext, int i, int i2) {
        int startRecordAndCheckNoise = AudioRecordFunc.getInstance().startRecordAndCheckNoise();
        if (1000 != startRecordAndCheckNoise && 1002 != startRecordAndCheckNoise) {
            errorCallback(wVCallBackContext, UTConstant.Args.UT_VERIFY_CHECKNOISE, startRecordAndCheckNoise);
        } else {
            new CountDownTimerC6747f(i * 1000, 500L, i2, wVCallBackContext).start();
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (!TextUtils.isEmpty(str)) {
            UserTrackAdapter.sendUT(str);
        }
        if ("supportBiometricType".equals(str)) {
            supportBiometricType(wVCallBackContext);
            return true;
        } else if ("openBiometric".equals(str)) {
            openBiometric(str2, wVCallBackContext);
            return true;
        } else if ("closeBiometric".equals(str)) {
            closeBiometric(str2, wVCallBackContext);
            return true;
        } else if ("checkBiometricStatus".equals(str)) {
            checkBiometricStatus(str2, wVCallBackContext);
            return true;
        } else if ("biometricIV".equals(str)) {
            biometricIV(str2, wVCallBackContext);
            return true;
        } else if ("checkNoise".equals(str)) {
            checkNoise(str2, wVCallBackContext);
            return true;
        } else if ("startRecord".equals(str)) {
            startRecord(str2, wVCallBackContext);
            return true;
        } else if ("stopRecord".equals(str)) {
            stopRecord(str2, wVCallBackContext);
            return true;
        } else if ("aluApplyIVToken".equals(str)) {
            applyIVToken(str2, wVCallBackContext);
            return true;
        } else if ("checkEnv".equals(str)) {
            if (wVCallBackContext != null) {
                wVCallBackContext.success();
                return true;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin, com.uc.webview.export.extension.IEmbedViewContainer.OnStateChangedListener
    public void onDestroy() {
        if (this.mLoginReceiver != null) {
            LoginBroadcastHelper.unregisterLoginReceiver(DataProviderFactory.getApplicationContext(), this.mLoginReceiver);
            this.mLoginReceiver = null;
        }
        this.mCallback = null;
        super.onDestroy();
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public void onPause() {
        super.onPause();
        try {
            AudioRecordFunc.getInstance().stopRecordAndFile();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
