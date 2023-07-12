package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.api.entity.core.CoreNaming;
import com.huawei.hms.utils.Util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ForegroundIntentBuilder {
    private Activity activity;
    private String foregroundBody;
    private RequestHeader foregroundHeader;
    private ForegroundInnerHeader innerHeader;
    private String innerPkgName;

    public ForegroundIntentBuilder(Activity activity) throws IllegalArgumentException {
        if (activity != null) {
            this.activity = activity;
            RequestHeader requestHeader = new RequestHeader();
            this.foregroundHeader = requestHeader;
            requestHeader.setPkgName(activity.getPackageName());
            this.foregroundHeader.setSdkVersion(60400302);
            this.foregroundBody = "";
            ForegroundInnerHeader foregroundInnerHeader = new ForegroundInnerHeader();
            this.innerHeader = foregroundInnerHeader;
            foregroundInnerHeader.setApkVersion(30000000);
            return;
        }
        throw new IllegalArgumentException("listener must not be null.");
    }

    public static void registerResponseCallback(String str, BusResponseCallback busResponseCallback) {
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
    }

    public static void unregisterResponseCallback(String str) {
        ForegroundBusResponseMgr.getInstance().unRegisterObserver(str);
    }

    public Intent build() {
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(this.activity, ForegroundBusDelegate.class.getName());
        if (this.foregroundHeader.getAppID() == null) {
            RequestHeader requestHeader = this.foregroundHeader;
            requestHeader.setAppID(Util.getAppId(this.activity) + "|");
        } else {
            RequestHeader requestHeader2 = this.foregroundHeader;
            requestHeader2.setAppID(Util.getAppId(this.activity) + "|" + this.foregroundHeader.getAppID());
        }
        if (TextUtils.isEmpty(this.foregroundHeader.getTransactionId())) {
            RequestHeader requestHeader3 = this.foregroundHeader;
            requestHeader3.setTransactionId(TransactionIdCreater.getId(requestHeader3.getAppID(), CoreNaming.HUBREQUEST));
        }
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_HEADER, this.foregroundHeader.toJson());
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_BODY, this.foregroundBody);
        intentStartBridgeActivity.putExtra(ForegroundBusDelegate.HMS_FOREGROUND_REQ_INNER, this.innerHeader.toJson());
        if (!TextUtils.isEmpty(this.innerPkgName)) {
            intentStartBridgeActivity.putExtra(ForegroundBusDelegate.INNER_PKG_NAME, this.innerPkgName);
        }
        return intentStartBridgeActivity;
    }

    public ForegroundIntentBuilder setAction(String str) {
        this.foregroundHeader.setApiName(str);
        return this;
    }

    public ForegroundIntentBuilder setApiLevel(int i) {
        this.foregroundHeader.setApiLevel(i);
        return this;
    }

    public ForegroundIntentBuilder setInnerHms() {
        this.innerPkgName = this.activity.getPackageName();
        return this;
    }

    public ForegroundIntentBuilder setKitSdkVersion(int i) {
        this.foregroundHeader.setKitSdkVersion(i);
        return this;
    }

    public ForegroundIntentBuilder setMinApkVersion(int i) {
        this.innerHeader.setApkVersion(i);
        return this;
    }

    public ForegroundIntentBuilder setRequestBody(String str) {
        this.foregroundBody = str;
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str, BusResponseCallback busResponseCallback) {
        this.innerHeader.setResponseCallbackKey(str);
        ForegroundBusResponseMgr.getInstance().registerObserver(str, busResponseCallback);
        return this;
    }

    public ForegroundIntentBuilder setServiceName(String str) {
        this.foregroundHeader.setSrvName(str);
        return this;
    }

    public ForegroundIntentBuilder setSubAppId(String str) {
        this.foregroundHeader.setAppID(str);
        return this;
    }

    public ForegroundIntentBuilder setTransactionId(String str) {
        this.foregroundHeader.setTransactionId(str);
        return this;
    }

    public ForegroundIntentBuilder setResponseCallback(String str) {
        this.innerHeader.setResponseCallbackKey(str);
        return this;
    }
}
