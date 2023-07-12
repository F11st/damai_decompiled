package com.huawei.hms.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ForegroundBusDelegate implements IBridgeActivityDelegate {
    private static final String EXTRA_DELEGATE_NAME = "intent.extra.hms.core.DELEGATE_NAME";
    private static final String EXTRA_DELEGATE_VALUE = "com.huawei.hms.core.activity.ForegroundBus";
    public static final String HMS_FOREGROUND_REQ_BODY = "HMS_FOREGROUND_REQ_BODY";
    public static final String HMS_FOREGROUND_REQ_HEADER = "HMS_FOREGROUND_REQ_HEADER";
    public static final String HMS_FOREGROUND_REQ_INNER = "HMS_FOREGROUND_REQ_INNER";
    public static final String HMS_FOREGROUND_RESP_HEADER = "HMS_FOREGROUND_RESP_HEADER";
    public static final String INNER_PKG_NAME = "INNER_PACKAGE_NAME";
    private static final int REQUEST_CODE_BUS = 431057;
    private static final String TAG = "ForegroundBusDelegate";
    private static final String UI_JUMP_ACTIVITY_NAME = "com.huawei.hms.core.activity.UiJumpActivity";
    private String foregroundBody;
    private RequestHeader foregroundHeader;
    private ForegroundInnerHeader innerHeader = new ForegroundInnerHeader();
    private boolean isUseInnerHms;
    private WeakReference<Activity> mThisWeakRef;
    private ResponseHeader responseHeader;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public class MyAvailableCallBack implements AvailableAdapter.AvailableCallBack {
        private MyAvailableCallBack() {
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int i) {
            if (i == 0) {
                ForegroundBusDelegate.this.startApkHubActivity();
                return;
            }
            HMSLog.i(ForegroundBusDelegate.TAG, "version check failed");
            ForegroundBusDelegate.this.errorReturn(0, "apk version is invalid");
        }
    }

    private void biReportRequestEntryForegroundBus() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
        mapFromForegroundRequestHeader.put("direction", "req");
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
        if (getActivity() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, mapFromForegroundRequestHeader);
        }
    }

    private void biReportRequestEntryStartCore() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
        mapFromForegroundRequestHeader.put("direction", "req");
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
        if (getActivity() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, mapFromForegroundRequestHeader);
        }
    }

    private void biReportRequestReturnForegroundBus() {
        if (this.foregroundHeader != null) {
            Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
            mapFromForegroundRequestHeader.put("direction", HiAnalyticsConstant.Direction.RESPONSE);
            mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
            ResponseHeader responseHeader = this.responseHeader;
            if (responseHeader != null) {
                mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(responseHeader.getStatusCode()));
                mapFromForegroundRequestHeader.put("result", String.valueOf(this.responseHeader.getErrorCode()));
            }
            if (getActivity() != null) {
                HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, mapFromForegroundRequestHeader);
            }
        }
    }

    private void biReportRequestReturnStartCore() {
        Map<String, String> mapFromForegroundRequestHeader = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.foregroundHeader);
        mapFromForegroundRequestHeader.put("direction", HiAnalyticsConstant.Direction.RESPONSE);
        mapFromForegroundRequestHeader.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.foregroundHeader.getKitSdkVersion())));
        ResponseHeader responseHeader = this.responseHeader;
        if (responseHeader != null) {
            mapFromForegroundRequestHeader.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(responseHeader.getStatusCode()));
            mapFromForegroundRequestHeader.put("result", String.valueOf(this.responseHeader.getErrorCode()));
        }
        if (getActivity() != null) {
            HiAnalyticsUtil.getInstance().onNewEvent(getActivity().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, mapFromForegroundRequestHeader);
        }
    }

    private void checkMinVersion() {
        if (getActivity() == null) {
            HMSLog.e(TAG, "checkMinVersion failed, activity must not be null.");
        } else if (this.isUseInnerHms) {
            startApkHubActivity();
        } else if (!Util.isAvailableLibExist(getActivity().getApplicationContext())) {
            if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(getActivity().getApplicationContext(), this.innerHeader.getApkVersion()) != 0) {
                HMSLog.e(TAG, "checkMinVersion failed, and no available lib exists.");
            } else {
                startApkHubActivity();
            }
        } else {
            MyAvailableCallBack myAvailableCallBack = new MyAvailableCallBack();
            AvailableAdapter availableAdapter = new AvailableAdapter(this.innerHeader.getApkVersion());
            int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(getActivity());
            if (isHuaweiMobileServicesAvailable == 0) {
                myAvailableCallBack.onComplete(isHuaweiMobileServicesAvailable);
            } else if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
                resolution(getActivity(), availableAdapter, myAvailableCallBack);
            } else {
                myAvailableCallBack.onComplete(isHuaweiMobileServicesAvailable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errorReturn(int i, String str) {
        HMSLog.e(TAG, str);
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        BusResponseCallback responseCallback = getResponseCallback(this.innerHeader.getResponseCallbackKey());
        if (responseCallback != null) {
            BusResponseResult innerError = responseCallback.innerError(this.mThisWeakRef.get(), i, str);
            if (innerError == null) {
                activity.setResult(0);
            } else {
                activity.setResult(innerError.getCode(), innerError.getIntent());
            }
        } else {
            activity.setResult(0);
        }
        finishBridgeActivity();
    }

    private void finishBridgeActivity() {
        Activity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }

    private Activity getActivity() {
        WeakReference<Activity> weakReference = this.mThisWeakRef;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private BusResponseCallback getResponseCallback(String str) {
        return ForegroundBusResponseMgr.getInstance().get(str);
    }

    private static void resolution(Activity activity, AvailableAdapter availableAdapter, AvailableAdapter.AvailableCallBack availableCallBack) {
        if (activity == null) {
            HMSLog.i(TAG, "null activity, could not start resolution intent");
        }
        availableAdapter.startResolution(activity, availableCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startApkHubActivity() {
        String hMSPackageNameForMultiService;
        HMSLog.i(TAG, "startApkHubActivity");
        Activity activity = getActivity();
        if (activity == null) {
            HMSLog.e(TAG, "startApkHubActivity but activity is null");
            return;
        }
        if (this.isUseInnerHms) {
            hMSPackageNameForMultiService = activity.getPackageName();
        } else {
            hMSPackageNameForMultiService = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageNameForMultiService();
        }
        Intent intent = new Intent(this.innerHeader.getAction());
        intent.putExtra(HMS_FOREGROUND_REQ_BODY, this.foregroundBody);
        try {
            intent.setPackage(hMSPackageNameForMultiService);
        } catch (IllegalArgumentException unused) {
            HMSLog.e(TAG, "IllegalArgumentException when startApkHubActivity intent.setPackage");
        }
        intent.putExtra(BridgeActivity.EXTRA_IS_FULLSCREEN, UIUtil.isActivityFullscreen(activity));
        intent.setClassName(hMSPackageNameForMultiService, UI_JUMP_ACTIVITY_NAME);
        intent.putExtra(HMS_FOREGROUND_REQ_HEADER, this.foregroundHeader.toJson());
        intent.putExtra(EXTRA_DELEGATE_NAME, EXTRA_DELEGATE_VALUE);
        try {
            biReportRequestEntryStartCore();
            activity.startActivityForResult(intent, REQUEST_CODE_BUS);
        } catch (ActivityNotFoundException e) {
            HMSLog.e(TAG, "Launch sign in Intent failed. hms is probably being updated：", e);
            errorReturn(0, "launch bus intent failed");
        }
    }

    private void succeedReturn(int i, Intent intent) {
        HMSLog.i(TAG, "succeedReturn");
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.setResult(i, intent);
        finishBridgeActivity();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return REQUEST_CODE_BUS;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        this.mThisWeakRef = new WeakReference<>(activity);
        Intent intent = activity.getIntent();
        String stringExtra = intent.getStringExtra(HMS_FOREGROUND_REQ_HEADER);
        RequestHeader requestHeader = new RequestHeader();
        this.foregroundHeader = requestHeader;
        if (!requestHeader.fromJson(stringExtra)) {
            errorReturn(0, "header is invalid");
            return;
        }
        this.foregroundBody = intent.getStringExtra(HMS_FOREGROUND_REQ_BODY);
        ForegroundInnerHeader foregroundInnerHeader = this.innerHeader;
        if (foregroundInnerHeader == null) {
            errorReturn(0, "inner header is invalid");
            return;
        }
        foregroundInnerHeader.fromJson(intent.getStringExtra(HMS_FOREGROUND_REQ_INNER));
        if (TextUtils.isEmpty(this.foregroundHeader.getApiName())) {
            errorReturn(0, "action is invalid");
            return;
        }
        biReportRequestEntryForegroundBus();
        if (!TextUtils.isEmpty(intent.getStringExtra(INNER_PKG_NAME))) {
            HMSLog.i(TAG, "isUseInnerHms: true");
            this.isUseInnerHms = true;
        }
        checkMinVersion();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        biReportRequestReturnForegroundBus();
        this.mThisWeakRef = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i == REQUEST_CODE_BUS) {
            if (intent != null && intent.hasExtra(HMS_FOREGROUND_RESP_HEADER)) {
                String stringExtra = intent.getStringExtra(HMS_FOREGROUND_RESP_HEADER);
                ResponseHeader responseHeader = new ResponseHeader();
                this.responseHeader = responseHeader;
                JsonUtil.jsonToEntity(stringExtra, responseHeader);
            }
            biReportRequestReturnStartCore();
            BusResponseCallback responseCallback = getResponseCallback(this.innerHeader.getResponseCallbackKey());
            if (responseCallback == null) {
                succeedReturn(i2, intent);
                return true;
            }
            BusResponseResult succeedReturn = responseCallback.succeedReturn(this.mThisWeakRef.get(), i2, intent);
            if (succeedReturn == null) {
                succeedReturn(i2, intent);
                return true;
            }
            succeedReturn(succeedReturn.getCode(), succeedReturn.getIntent());
            return true;
        }
        return false;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
    }
}
