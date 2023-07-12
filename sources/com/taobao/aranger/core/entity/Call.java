package com.taobao.aranger.core.entity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.aranger.core.wrapper.MethodWrapper;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.core.wrapper.ServiceWrapper;
import com.taobao.aranger.utils.b;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Call implements Parcelable {
    public static final Parcelable.Creator<Call> CREATOR = new Parcelable.Creator<Call>() { // from class: com.taobao.aranger.core.entity.Call.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Call createFromParcel(Parcel parcel) {
            Call obtain = Call.obtain();
            obtain.readFromParcel(parcel);
            return obtain;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Call[] newArray(int i) {
            return new Call[i];
        }
    };
    private boolean isOneWay;
    private boolean isSameApp;
    private boolean isVoid;
    private String mCallingPackage;
    private long mDataSize;
    private MethodWrapper mMethodWrapper;
    private ParameterWrapper[] mParameterWrappers;
    private Uri mRemoteProviderUri;
    private ServiceWrapper mServiceWrapper;

    private Call() {
    }

    public static Call obtain() {
        return new Call();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readFromParcel(Parcel parcel) {
        this.mServiceWrapper = ServiceWrapper.CREATOR.createFromParcel(parcel);
        this.mMethodWrapper = MethodWrapper.CREATOR.createFromParcel(parcel);
        this.mParameterWrappers = (ParameterWrapper[]) b.e(getClass().getClassLoader(), parcel);
        if (parcel.readInt() == 1) {
            this.mCallingPackage = parcel.readString();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCallingPackage() {
        return this.mCallingPackage;
    }

    public long getDataSize() {
        return this.mDataSize;
    }

    public MethodWrapper getMethodWrapper() {
        return this.mMethodWrapper;
    }

    public ParameterWrapper[] getParameterWrappers() {
        return this.mParameterWrappers;
    }

    public Uri getRemoteProviderUri() {
        return this.mRemoteProviderUri;
    }

    public ServiceWrapper getServiceWrapper() {
        return this.mServiceWrapper;
    }

    public boolean isOneWay() {
        return this.isOneWay;
    }

    public boolean isSameApp() {
        return this.isSameApp;
    }

    public boolean isVoid() {
        return this.isVoid;
    }

    public Call setCallingPackage(String str) {
        this.mCallingPackage = str;
        return this;
    }

    public Call setIsSameApp(boolean z) {
        this.isSameApp = z;
        return this;
    }

    public Call setMethodWrapper(MethodWrapper methodWrapper) {
        this.mMethodWrapper = methodWrapper;
        return this;
    }

    public Call setOneWay(boolean z) {
        this.isOneWay = z;
        return this;
    }

    public Call setParameterWrappers(ParameterWrapper[] parameterWrapperArr) {
        this.mParameterWrappers = parameterWrapperArr;
        return this;
    }

    public Call setRemoteProviderUri(Uri uri) {
        this.mRemoteProviderUri = uri;
        return this;
    }

    public Call setServiceWrapper(ServiceWrapper serviceWrapper) {
        this.mServiceWrapper = serviceWrapper;
        return this;
    }

    public Call setVoid(boolean z) {
        this.isVoid = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        this.mServiceWrapper.writeToParcel(parcel, i);
        this.mMethodWrapper.writeToParcel(parcel, i);
        this.mDataSize = b.g(parcel, this.mParameterWrappers, i, true);
        if (this.isSameApp) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeString(this.mCallingPackage);
    }
}
