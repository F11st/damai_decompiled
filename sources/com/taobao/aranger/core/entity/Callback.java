package com.taobao.aranger.core.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.aranger.core.wrapper.MethodWrapper;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.utils.C6699b;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Callback implements Parcelable {
    public static final Parcelable.Creator<Callback> CREATOR = new Parcelable.Creator<Callback>() { // from class: com.taobao.aranger.core.entity.Callback.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Callback createFromParcel(Parcel parcel) {
            Callback obtain = Callback.obtain();
            obtain.readFromParcel(parcel);
            return obtain;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Callback[] newArray(int i) {
            return new Callback[i];
        }
    };
    private boolean isOneWay;
    private boolean isVoid;
    private long mDataSize;
    private String mKey;
    private MethodWrapper mMethodWrapper;
    private ParameterWrapper[] mParameterWrappers;

    private Callback() {
    }

    public static Callback obtain() {
        return new Callback();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readFromParcel(Parcel parcel) {
        this.mKey = parcel.readString();
        this.mMethodWrapper = MethodWrapper.CREATOR.createFromParcel(parcel);
        this.mParameterWrappers = (ParameterWrapper[]) C6699b.e(getClass().getClassLoader(), parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getDataSize() {
        return this.mDataSize;
    }

    public String getKey() {
        return this.mKey;
    }

    public MethodWrapper getMethodWrapper() {
        return this.mMethodWrapper;
    }

    public ParameterWrapper[] getParameterWrappers() {
        return this.mParameterWrappers;
    }

    public boolean isOneWay() {
        return this.isOneWay;
    }

    public boolean isVoid() {
        return this.isVoid;
    }

    public Callback setKey(String str) {
        this.mKey = str;
        return this;
    }

    public Callback setMethodWrapper(MethodWrapper methodWrapper) {
        this.mMethodWrapper = methodWrapper;
        return this;
    }

    public Callback setOneWay(boolean z) {
        this.isOneWay = z;
        return this;
    }

    public Callback setParameterWrappers(ParameterWrapper[] parameterWrapperArr) {
        this.mParameterWrappers = parameterWrapperArr;
        return this;
    }

    public Callback setVoid(boolean z) {
        this.isVoid = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mKey);
        this.mMethodWrapper.writeToParcel(parcel, i);
        this.mDataSize = C6699b.g(parcel, this.mParameterWrappers, i, true);
    }
}
