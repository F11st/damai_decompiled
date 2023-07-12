package com.taobao.update.instantpatch.model;

import com.alibaba.fastjson.JSONObject;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class InstantUpdateInfo implements Serializable {
    public String baseVersion;
    public boolean beta;
    public String httpsUrl;
    public String md5;
    public String patchUrl;
    public String patchVersion;
    public String priority;
    public boolean rollback;
    public String size;
    public String type;

    public static InstantUpdateInfo create(JSONObject jSONObject) {
        InstantUpdateInfo instantUpdateInfo = new InstantUpdateInfo();
        if (jSONObject == null) {
            return instantUpdateInfo;
        }
        if (jSONObject.containsKey("rollback")) {
            instantUpdateInfo.rollback = true;
            return instantUpdateInfo;
        }
        instantUpdateInfo.beta = jSONObject.containsKey("beta") ? Boolean.valueOf(jSONObject.getString("beta")).booleanValue() : false;
        if (jSONObject.containsKey("httpsUrl")) {
            instantUpdateInfo.patchUrl = jSONObject.getString("httpsUrl");
            instantUpdateInfo.httpsUrl = jSONObject.getString("httpsUrl");
        } else if (jSONObject.containsKey("patchUrl")) {
            instantUpdateInfo.patchUrl = jSONObject.getString("patchUrl");
            instantUpdateInfo.httpsUrl = "";
        } else {
            instantUpdateInfo.patchUrl = "";
            instantUpdateInfo.httpsUrl = "";
        }
        instantUpdateInfo.size = jSONObject.containsKey("size") ? jSONObject.getString("size") : "";
        instantUpdateInfo.priority = jSONObject.containsKey("priority") ? jSONObject.getString("priority") : "0";
        instantUpdateInfo.baseVersion = jSONObject.containsKey(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION) ? jSONObject.getString(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION) : "";
        instantUpdateInfo.type = jSONObject.containsKey("type") ? jSONObject.getString("type") : "";
        instantUpdateInfo.patchVersion = jSONObject.containsKey("patchVersion") ? jSONObject.getString("patchVersion") : "";
        instantUpdateInfo.md5 = jSONObject.containsKey("md5") ? jSONObject.getString("md5") : "";
        return instantUpdateInfo;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InstantUpdateInfo instantUpdateInfo = (InstantUpdateInfo) obj;
        if (this.patchUrl.equals(instantUpdateInfo.patchUrl) && this.size.equals(instantUpdateInfo.size) && this.priority.equals(instantUpdateInfo.priority) && this.baseVersion.equals(instantUpdateInfo.baseVersion) && this.httpsUrl.equals(instantUpdateInfo.httpsUrl) && this.type.equals(instantUpdateInfo.type) && this.patchVersion.equals(instantUpdateInfo.patchVersion)) {
            return this.md5.equals(instantUpdateInfo.md5);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.patchUrl.hashCode() * 31) + this.size.hashCode()) * 31) + this.priority.hashCode()) * 31) + this.baseVersion.hashCode()) * 31) + this.httpsUrl.hashCode()) * 31) + this.type.hashCode()) * 31) + this.patchVersion.hashCode()) * 31) + this.md5.hashCode();
    }
}
