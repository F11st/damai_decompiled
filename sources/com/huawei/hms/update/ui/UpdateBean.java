package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class UpdateBean implements Serializable {
    public boolean a;
    public String b;
    public ArrayList c;
    public boolean d = true;

    public static <T> T a(T t) {
        return t;
    }

    public String getClientAppName() {
        return (String) a(this.b);
    }

    public boolean getResolutionInstallHMS() {
        return this.a;
    }

    public ArrayList getTypeList() {
        return (ArrayList) a(this.c);
    }

    public boolean isNeedConfirm() {
        return ((Boolean) a(Boolean.valueOf(this.d))).booleanValue();
    }

    public void setClientAppId(String str) {
    }

    public void setClientAppName(String str) {
        this.b = str;
    }

    public void setClientPackageName(String str) {
    }

    public void setClientVersionCode(int i) {
    }

    public void setHmsOrApkUpgrade(boolean z) {
    }

    public void setNeedConfirm(boolean z) {
        this.d = z;
    }

    public void setResolutionInstallHMS(boolean z) {
        this.a = z;
    }

    public void setTypeList(ArrayList arrayList) {
        this.c = arrayList;
    }
}
