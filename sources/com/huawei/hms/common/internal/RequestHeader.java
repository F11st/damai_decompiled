package com.huawei.hms.common.internal;

import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.tencent.connect.common.Constants;
import mtopsdk.common.util.SymbolExpUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class RequestHeader implements IMessageEntity {
    private static final String TAG = "RequestHeader";
    @Packed
    private int apiLevel;
    @Packed
    private String api_name;
    @Packed
    private int kitSdkVersion;
    private Parcelable parcelable;
    @Packed
    private String pkg_name;
    @Packed
    private String session_id;
    @Packed
    private String srv_name;
    @Packed
    private String transaction_id;
    @Packed
    private String app_id = "";
    @Packed
    private String version = "4.0";
    @Packed
    private int sdk_version = 60400302;

    public boolean fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.version = JsonUtil.getStringValue(jSONObject, "version");
            this.srv_name = JsonUtil.getStringValue(jSONObject, "srv_name");
            this.api_name = JsonUtil.getStringValue(jSONObject, "api_name");
            this.app_id = JsonUtil.getStringValue(jSONObject, "app_id");
            this.pkg_name = JsonUtil.getStringValue(jSONObject, Constants.PARAM_PKG_NAME);
            this.sdk_version = JsonUtil.getIntValue(jSONObject, "sdk_version");
            this.kitSdkVersion = JsonUtil.getIntValue(jSONObject, "kitSdkVersion");
            this.apiLevel = JsonUtil.getIntValue(jSONObject, "apiLevel");
            this.session_id = JsonUtil.getStringValue(jSONObject, "session_id");
            this.transaction_id = JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.TRANSACTION_ID);
            return true;
        } catch (JSONException e) {
            HMSLog.e(TAG, "fromJson failed: " + e.getMessage());
            return false;
        }
    }

    public String getActualAppID() {
        if (TextUtils.isEmpty(this.app_id)) {
            return "";
        }
        String[] split = this.app_id.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
        if (split.length == 0) {
            return "";
        }
        if (split.length == 1) {
            return split[0];
        }
        return split[1];
    }

    public int getApiLevel() {
        return this.apiLevel;
    }

    public String getApiName() {
        return this.api_name;
    }

    public String getAppID() {
        return this.app_id;
    }

    public int getKitSdkVersion() {
        return this.kitSdkVersion;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public String getPkgName() {
        return this.pkg_name;
    }

    public int getSdkVersion() {
        return this.sdk_version;
    }

    public String getSessionId() {
        return this.session_id;
    }

    public String getSrvName() {
        return this.srv_name;
    }

    public String getTransactionId() {
        return this.transaction_id;
    }

    public String getVersion() {
        return this.version;
    }

    public void setApiLevel(int i) {
        this.apiLevel = i;
    }

    public void setApiName(String str) {
        this.api_name = str;
    }

    public void setAppID(String str) {
        this.app_id = str;
    }

    public void setKitSdkVersion(int i) {
        this.kitSdkVersion = i;
    }

    public void setParcelable(Parcelable parcelable) {
        this.parcelable = parcelable;
    }

    public void setPkgName(String str) {
        this.pkg_name = str;
    }

    public void setSdkVersion(int i) {
        this.sdk_version = i;
    }

    public void setSessionId(String str) {
        this.session_id = str;
    }

    public void setSrvName(String str) {
        this.srv_name = str;
    }

    public void setTransactionId(String str) {
        this.transaction_id = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.version);
            jSONObject.put("srv_name", this.srv_name);
            jSONObject.put("api_name", this.api_name);
            jSONObject.put("app_id", this.app_id);
            jSONObject.put(Constants.PARAM_PKG_NAME, this.pkg_name);
            jSONObject.put("sdk_version", this.sdk_version);
            jSONObject.put("kitSdkVersion", this.kitSdkVersion);
            jSONObject.put("apiLevel", this.apiLevel);
            if (!TextUtils.isEmpty(this.session_id)) {
                jSONObject.put("session_id", this.session_id);
            }
            jSONObject.put(CommonCode.MapKey.TRANSACTION_ID, this.transaction_id);
        } catch (JSONException e) {
            HMSLog.e(TAG, "toJson failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "api_name:" + this.api_name + ", app_id:" + this.app_id + ", pkg_name:" + this.pkg_name + ", sdk_version:" + this.sdk_version + ", session_id:*, transaction_id:" + this.transaction_id + ", kitSdkVersion:" + this.kitSdkVersion + ", apiLevel:" + this.apiLevel;
    }
}
