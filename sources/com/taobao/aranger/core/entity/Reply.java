package com.taobao.aranger.core.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.utils.b;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Reply implements Parcelable {
    public static final Parcelable.Creator<Reply> CREATOR = new Parcelable.Creator<Reply>() { // from class: com.taobao.aranger.core.entity.Reply.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Reply createFromParcel(Parcel parcel) {
            Reply obtain = Reply.obtain();
            obtain.readFromParcel(parcel);
            return obtain;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Reply[] newArray(int i) {
            return new Reply[i];
        }
    };
    private int mErrorCode;
    private String mErrorMessage;
    private ParameterWrapper[] mFlowParameterWrappers;
    private long mInvokeTime;
    private Object mResult;

    private Reply() {
    }

    public static Reply obtain() {
        return new Reply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readFromParcel(Parcel parcel) {
        this.mErrorCode = parcel.readByte();
        if ((parcel.readByte() | 0) == 0) {
            this.mErrorMessage = parcel.readString();
        }
        if ((parcel.readByte() | 0) == 0) {
            this.mFlowParameterWrappers = (ParameterWrapper[]) b.e(getClass().getClassLoader(), parcel);
        }
        this.mInvokeTime = parcel.readInt();
        this.mResult = b.e(getClass().getClassLoader(), parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public String getErrorMessage() {
        return this.mErrorMessage;
    }

    public ParameterWrapper[] getFlowParameterWrappers() {
        return this.mFlowParameterWrappers;
    }

    public long getInvokeTime() {
        return this.mInvokeTime;
    }

    public Object getResult() {
        return this.mResult;
    }

    public boolean isError() {
        return this.mErrorCode != 0;
    }

    public Reply setErrorCode(int i) {
        this.mErrorCode = i;
        return this;
    }

    public Reply setErrorMessage(String str) {
        this.mErrorMessage = str;
        return this;
    }

    public Reply setFlowParameterWrappers(ParameterWrapper[] parameterWrapperArr) {
        this.mFlowParameterWrappers = parameterWrapperArr;
        return this;
    }

    public Reply setInvokeTime(long j) {
        this.mInvokeTime = j;
        return this;
    }

    public Reply setResult(Object obj) {
        this.mResult = obj;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) this.mErrorCode);
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            parcel.writeByte((byte) 0);
            parcel.writeString(this.mErrorMessage);
        } else {
            parcel.writeByte((byte) 1);
        }
        if (this.mFlowParameterWrappers != null) {
            parcel.writeByte((byte) 0);
            b.g(parcel, this.mFlowParameterWrappers, i, true);
        } else {
            parcel.writeByte((byte) 1);
        }
        parcel.writeInt((int) this.mInvokeTime);
        b.g(parcel, this.mResult, i, true);
    }
}
