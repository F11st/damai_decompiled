package com.taobao.aranger.core.wrapper;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.aranger.constant.Constants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MethodWrapper extends BaseWrapper implements Parcelable {
    public static final Parcelable.Creator<MethodWrapper> CREATOR = new Parcelable.Creator<MethodWrapper>() { // from class: com.taobao.aranger.core.wrapper.MethodWrapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MethodWrapper createFromParcel(Parcel parcel) {
            MethodWrapper obtain = MethodWrapper.obtain();
            obtain.readFromParcel(parcel);
            return obtain;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MethodWrapper[] newArray(int i) {
            return new MethodWrapper[i];
        }
    };
    private String mReturnType;

    private MethodWrapper() {
    }

    public static MethodWrapper obtain() {
        return new MethodWrapper();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getReturnType() {
        return this.mReturnType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.taobao.aranger.core.wrapper.BaseWrapper
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        if ((parcel.readByte() | 0) == 0) {
            this.mReturnType = parcel.readString();
        }
    }

    public MethodWrapper setMethodName(String str) {
        setName(str);
        return this;
    }

    public MethodWrapper setReturnType(String str) {
        this.mReturnType = str;
        return this;
    }

    @Override // com.taobao.aranger.core.wrapper.BaseWrapper, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        String str = this.mReturnType;
        if (str != null && !Constants.VOID.equals(str)) {
            parcel.writeByte((byte) 0);
            parcel.writeString(this.mReturnType);
            return;
        }
        parcel.writeByte((byte) 1);
    }
}
