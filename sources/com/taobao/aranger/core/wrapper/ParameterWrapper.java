package com.taobao.aranger.core.wrapper;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.taobao.aranger.utils.TypeUtils;
import com.taobao.aranger.utils.b;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.z01;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ParameterWrapper extends BaseWrapper implements Parcelable {
    private IBinder mClientServiceBinder;
    private Object mData;
    private int mFlowFlag = 0;
    private String mTimeStamp;
    private static final String TAG = ParameterWrapper.class.getSimpleName();
    public static final Parcelable.Creator<ParameterWrapper> CREATOR = new Parcelable.Creator<ParameterWrapper>() { // from class: com.taobao.aranger.core.wrapper.ParameterWrapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParameterWrapper createFromParcel(Parcel parcel) {
            ParameterWrapper obtain = ParameterWrapper.obtain();
            obtain.readFromParcel(parcel);
            return obtain;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParameterWrapper[] newArray(int i) {
            return new ParameterWrapper[i];
        }
    };

    private ParameterWrapper() {
    }

    public static ParameterWrapper obtain() {
        return new ParameterWrapper();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IBinder getClientServiceBinder() {
        return this.mClientServiceBinder;
    }

    public Object getData() {
        return this.mData;
    }

    public int getFlowFlag() {
        return this.mFlowFlag;
    }

    public String getTimeStamp() {
        return this.mTimeStamp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.taobao.aranger.core.wrapper.BaseWrapper
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.mFlowFlag = parcel.readByte();
        if ((parcel.readByte() | 0) == 0) {
            this.mTimeStamp = parcel.readString();
        }
        if ((parcel.readByte() | 0) == 0) {
            this.mClientServiceBinder = parcel.readStrongBinder();
        }
        this.mData = b.e(getClass().getClassLoader(), parcel);
    }

    public ParameterWrapper setClientServiceBinder(IBinder iBinder) {
        this.mClientServiceBinder = iBinder;
        return this;
    }

    public ParameterWrapper setData(Object obj) {
        this.mData = obj;
        if (obj == null) {
            return this;
        }
        Class<?> cls = obj.getClass();
        if (this.mFlowFlag == 1) {
            if (cls.isArray()) {
                this.mData = Array.newInstance(cls.getComponentType(), TypeUtils.getObjectArraySize(cls.getName(), this.mData));
            } else if (List.class.isAssignableFrom(cls)) {
                this.mData = new ArrayList();
            } else if (Map.class.isAssignableFrom(cls)) {
                this.mData = new HashMap();
            } else {
                try {
                    this.mData = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception e) {
                    z01.c(TAG, "[setData][newInstance]", e, new Object[0]);
                }
            }
        }
        return this;
    }

    public ParameterWrapper setFlowFlag(int i) {
        this.mFlowFlag = i;
        return this;
    }

    public ParameterWrapper setParameterName(String str) {
        setName(str);
        return this;
    }

    public ParameterWrapper setTimeStamp(String str) {
        this.mTimeStamp = str;
        return this;
    }

    @Override // com.taobao.aranger.core.wrapper.BaseWrapper, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeByte((byte) this.mFlowFlag);
        if (this.mTimeStamp != null) {
            parcel.writeByte((byte) 0);
            parcel.writeString(this.mTimeStamp);
        } else {
            parcel.writeByte((byte) 1);
        }
        if (this.mClientServiceBinder != null) {
            parcel.writeByte((byte) 0);
            parcel.writeStrongBinder(this.mClientServiceBinder);
        } else {
            parcel.writeByte((byte) 1);
        }
        b.g(parcel, this.mData, i, false);
    }
}
