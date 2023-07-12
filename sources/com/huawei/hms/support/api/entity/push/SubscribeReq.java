package com.huawei.hms.support.api.entity.push;

import android.content.Context;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.push.s;
import com.huawei.hms.utils.Util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SubscribeReq implements IMessageEntity {
    @Packed
    public String appId;
    @Packed
    public boolean isFastApp = false;
    @Packed
    public String operation;
    @Packed
    public String packageName;
    @Packed
    public String projectId;
    @Packed
    public String subjectId;
    @Packed
    public String token;
    @Packed
    public String topic;

    public SubscribeReq() {
    }

    public String getAppId() {
        return this.appId;
    }

    public String getOperation() {
        return this.operation;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public String getToken() {
        return this.token;
    }

    public String getTopic() {
        return this.topic;
    }

    public boolean isFastApp() {
        return this.isFastApp;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setFastApp(boolean z) {
        this.isFastApp = z;
    }

    public void setOperation(String str) {
        this.operation = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setProjectId(String str) {
        this.projectId = str;
    }

    public void setSubjectId(String str) {
        this.subjectId = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setTopic(String str) {
        this.topic = str;
    }

    public String toString() {
        return "SubscribeReq{packageName='" + this.packageName + "', operation='" + this.operation + "'}";
    }

    public SubscribeReq(Context context, String str, String str2) {
        this.packageName = context.getPackageName();
        this.operation = str;
        this.topic = str2;
        this.appId = Util.getAppId(context);
        this.projectId = s.c(context);
    }
}
