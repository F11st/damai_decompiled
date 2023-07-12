package com.huawei.hms.common.internal;

import android.app.Activity;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ClientSettings {
    private List<String> apiName;
    private String appId;
    private String clientClassName;
    private String clientPackageName;
    private WeakReference<Activity> cpActivity;
    private boolean hasActivity;
    private String innerHmsPkg;
    private boolean isUseInnerHms;
    private String mCpID;
    private List<Scope> scopes;
    private SubAppInfo subAppId;

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2) {
        this.clientPackageName = str;
        this.clientClassName = str2;
        this.scopes = list;
        this.appId = str3;
        this.apiName = list2;
    }

    public List<String> getApiName() {
        return this.apiName;
    }

    public String getAppID() {
        return this.appId;
    }

    public String getClientClassName() {
        return this.clientClassName;
    }

    public String getClientPackageName() {
        return this.clientPackageName;
    }

    public Activity getCpActivity() {
        WeakReference<Activity> weakReference = this.cpActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getCpID() {
        return this.mCpID;
    }

    public String getInnerHmsPkg() {
        return this.innerHmsPkg;
    }

    public List<Scope> getScopes() {
        return this.scopes;
    }

    public SubAppInfo getSubAppID() {
        return this.subAppId;
    }

    public boolean isHasActivity() {
        return this.hasActivity;
    }

    public boolean isUseInnerHms() {
        return this.isUseInnerHms;
    }

    public void setApiName(List<String> list) {
        this.apiName = list;
    }

    public void setAppID(String str) {
        this.appId = str;
    }

    public void setClientClassName(String str) {
        this.clientClassName = str;
    }

    public void setClientPackageName(String str) {
        this.clientPackageName = str;
    }

    public void setCpActivity(Activity activity) {
        this.cpActivity = new WeakReference<>(activity);
        this.hasActivity = true;
    }

    public void setCpID(String str) {
        this.mCpID = str;
    }

    public void setInnerHmsPkg(String str) {
        this.innerHmsPkg = str;
    }

    public void setScopes(List<Scope> list) {
        this.scopes = list;
    }

    public void setSubAppId(SubAppInfo subAppInfo) {
        this.subAppId = subAppInfo;
    }

    public void setUseInnerHms(boolean z) {
        this.isUseInnerHms = z;
    }

    public ClientSettings(String str, String str2, List<Scope> list, String str3, List<String> list2, SubAppInfo subAppInfo) {
        this(str, str2, list, str3, list2);
        setSubAppId(subAppInfo);
    }
}
