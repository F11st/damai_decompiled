package com.android.dingtalk.share.ddsharemodule;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.android.dingtalk.share.ddsharemodule.message.BaseReq;
import com.android.dingtalk.share.ddsharemodule.message.DDMessage;
import com.android.dingtalk.share.ddsharemodule.message.DDMessageAct;
import com.android.dingtalk.share.ddsharemodule.message.SendAuth;
import com.android.dingtalk.share.ddsharemodule.message.SendMessageToDD;
import com.android.dingtalk.share.ddsharemodule.plugin.DDVersionCheck;
import com.android.dingtalk.share.ddsharemodule.plugin.SignatureCheck;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DDShareApiV2 implements IDDShareApi {
    private static final String TAG = "DDShareApiV2";
    private String mAppId;
    private Context mContext;
    private boolean mNeedSignatureCheck;

    public DDShareApiV2(Context context, String str, boolean z) {
        this.mContext = context;
        this.mAppId = str;
        this.mNeedSignatureCheck = z;
    }

    private boolean innerIsDDAppInstalled(Context context, String str) {
        try {
            if (context.getPackageManager().getPackageInfo(str, 64) != null) {
                return checkSumConsistent(context, str);
            }
            return false;
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            return false;
        }
    }

    protected boolean checkSumConsistent(Context context, String str) {
        if (!this.mNeedSignatureCheck) {
            Log.d(TAG, "ignore dd app signature validation");
            return true;
        }
        boolean equals = TextUtils.equals(SignatureCheck.getMD5Signature(context, str), ShareConstant.DD_APP_SIGNATURE);
        Log.e(TAG, "checkSumConsistent: result = " + equals + ",packageName = " + str);
        return equals;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public int getDDSupportAPI() {
        return getDDSupportAPI(this.mContext);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean handleIntent(Intent intent, IDDAPIEventHandler iDDAPIEventHandler) {
        String stringExtra = intent.getStringExtra(ShareConstant.EXTRA_MESSAGE_APP_PACKAGE_NAME);
        if (stringExtra != null && stringExtra.length() != 0 && iDDAPIEventHandler != null) {
            int intExtra = intent.getIntExtra(ShareConstant.EXTRA_COMMAND_TYPE, 0);
            if (intExtra == 1) {
                iDDAPIEventHandler.onResp(new SendMessageToDD.Resp(intent.getExtras()));
                return true;
            } else if (intExtra == 2) {
                iDDAPIEventHandler.onResp(new SendMessageToDD.Resp(intent.getExtras()));
                return true;
            } else if (intExtra == 3) {
                iDDAPIEventHandler.onReq(new SendMessageToDD.Req(intent.getExtras()));
                return true;
            } else if (intExtra == 4) {
                iDDAPIEventHandler.onReq(new SendMessageToDD.Req(intent.getExtras()));
                return true;
            } else if (intExtra != 100) {
                return false;
            } else {
                SendAuth.Resp resp = new SendAuth.Resp();
                resp.fromBundle(intent.getExtras());
                iDDAPIEventHandler.onResp(resp);
                return true;
            }
        }
        Log.e("TAG", "invalid argument");
        return false;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean isDDAppInstalled() {
        return isDDAppInstalled(this.mContext);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean isDDSupportAPI() {
        return isDDSupportAPI(this.mContext);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean isDDSupportDingAPI() {
        return isDDSupportDingAPI(this.mContext);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean isDDSupportDingAPI(Context context) {
        return false;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean openDDApp() {
        return openDDApp(this.mContext);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean registerApp(String str) {
        return registerApp(this.mContext, str);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean sendReq(BaseReq baseReq) {
        return sendReq(this.mContext, baseReq);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean sendReqToDing(BaseReq baseReq) {
        return sendReqToDing(this.mContext, baseReq);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public void unregisterApp() {
        unregisterApp(this.mContext);
    }

    private boolean sendReq(Context context, BaseReq baseReq) {
        if (!isDDSupportAPI(context)) {
            Log.e(TAG, "sendReq failed for dd not supported baseRequest");
            return false;
        } else if (baseReq.getSupportVersion() > getDDSupportAPI(context)) {
            Log.e(TAG, "sendReq failed for dd not supported baseRequest,minSupportVersion:" + baseReq.getSupportVersion() + ",dingtalkSupportSdkVersion:" + getDDSupportAPI(context));
            return false;
        } else if (!checkSumConsistent(context, ShareConstant.DD_APP_PACKAGE) && !checkSumConsistent(context, ShareConstant.ALI_DD_APP_PACKAGE)) {
            Log.e(TAG, "sendReq failed for dd app signature check failed");
            return false;
        } else if (!baseReq.checkArgs()) {
            Log.e(TAG, "sendReq checkArgs fail");
            return false;
        } else {
            Log.e(TAG, "sendReq: ");
            Bundle bundle = new Bundle();
            baseReq.attachContext(context);
            baseReq.toBundle(bundle);
            if (baseReq.getType() == 100) {
                Log.e(TAG, "sendReq: dd auth");
                return DDMessageAct.sendDDAuth(context, this.mAppId, bundle);
            }
            Log.e(TAG, "sendReq: dd friend");
            return DDMessageAct.sendDDFriend(context, this.mAppId, bundle);
        }
    }

    private boolean sendReqToDing(Context context, BaseReq baseReq) {
        if (!isDDSupportDingAPI(context)) {
            Log.e(TAG, "sendReq failed for dd not supported ding");
            return false;
        } else if (!checkSumConsistent(context, ShareConstant.DD_APP_PACKAGE) && !checkSumConsistent(context, ShareConstant.ALI_DD_APP_PACKAGE)) {
            Log.e(TAG, "sendReq failed for dd app signature check failed");
            return false;
        } else if (!baseReq.checkArgs()) {
            Log.e(TAG, "sendReq checkArgs fail");
            return false;
        } else {
            Bundle bundle = new Bundle();
            baseReq.toBundle(bundle);
            return DDMessageAct.sendDing(context, this.mAppId, bundle);
        }
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public int getDDSupportAPI(Context context) {
        if (!isDDAppInstalled(context)) {
            Log.e(TAG, "open dd app failed, not installed or signature check failed");
            return 0;
        }
        int sdkVersionFromMetaData = DDVersionCheck.getSdkVersionFromMetaData(context, 0);
        Log.e(TAG, "getDDSupportAPI: result = " + sdkVersionFromMetaData);
        return sdkVersionFromMetaData;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean isDDAppInstalled(Context context) {
        return innerIsDDAppInstalled(context, ShareConstant.DD_APP_PACKAGE) || innerIsDDAppInstalled(context, ShareConstant.ALI_DD_APP_PACKAGE);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean isDDSupportAPI(Context context) {
        return getDDSupportAPI(context) >= 20151201;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean openDDApp(Context context) {
        if (!isDDAppInstalled(context)) {
            Log.e(TAG, "open dd app failed, not installed or signature check failed");
            return false;
        }
        try {
            Log.e(TAG, "openDDApp: ");
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(ShareConstant.DD_APP_PACKAGE));
            return true;
        } catch (Exception e) {
            Log.e(TAG, "start dd Main Activity fail, exception = " + e.getMessage());
            return false;
        }
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public boolean registerApp(Context context, String str) {
        if (!checkSumConsistent(context, ShareConstant.DD_APP_PACKAGE) && !checkSumConsistent(context, ShareConstant.ALI_DD_APP_PACKAGE)) {
            Log.e(TAG, "register app failed for alipay app signature check failed");
            return false;
        }
        if (str != null) {
            this.mAppId = str;
        }
        if (context != null) {
            Log.d(TAG, "register app " + context.getPackageName());
            String str2 = ShareConstant.PERMISSION_ACTION_HANDLE_APP_REGISTER;
            DDMessage.send(context, ShareConstant.DD_APP_PACKAGE, str2, ShareConstant.ACTION_APP_REGISTER + str);
            return true;
        }
        Log.e(TAG, "register app context null");
        return false;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.IDDShareApi
    public void unregisterApp(Context context) {
        if (!checkSumConsistent(context, ShareConstant.DD_APP_PACKAGE) && !checkSumConsistent(context, ShareConstant.ALI_DD_APP_PACKAGE)) {
            Log.e(TAG, "unregister app failed for dd app signature check failed");
            return;
        }
        String str = this.mAppId;
        if (str != null && str.length() != 0 && context != null) {
            Log.d(TAG, "unregister app " + context.getPackageName());
            String str2 = ShareConstant.PERMISSION_ACTION_HANDLE_APP_UNREGISTER;
            DDMessage.send(context, ShareConstant.DD_APP_PACKAGE, str2, ShareConstant.ACTION_APP_UNREGISTER + this.mAppId);
            return;
        }
        Log.e(TAG, "unregisterApp fail, appId is empty or context null");
    }
}
