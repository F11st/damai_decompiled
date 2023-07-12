package com.taobao.aranger.core.wrapper;

import android.os.Parcel;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class BaseWrapper {
    private String mName;

    public String getName() {
        return this.mName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void readFromParcel(Parcel parcel) {
        this.mName = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setName(String str) {
        this.mName = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mName);
    }
}
