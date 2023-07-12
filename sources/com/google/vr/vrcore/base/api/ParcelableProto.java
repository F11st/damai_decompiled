package com.google.vr.vrcore.base.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ParcelableProto<T extends MessageNano> implements Parcelable {
    private static final String TAG = ParcelableProto.class.getSimpleName();
    private byte[] data = null;

    public ParcelableProto() {
    }

    public void clear() {
        this.data = null;
    }

    public void copyFrom(ParcelableProto<T> parcelableProto) {
        byte[] bArr = parcelableProto.data;
        if (bArr == null) {
            this.data = null;
        } else {
            this.data = Arrays.copyOf(bArr, bArr.length);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ParcelableProto) {
            return Arrays.equals(((ParcelableProto) obj).data, this.data);
        }
        return false;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getSizeBytes() {
        byte[] bArr = this.data;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    public boolean isEmpty() {
        byte[] bArr = this.data;
        return bArr == null || bArr.length == 0;
    }

    public T parseToProto(Class<T> cls) {
        try {
            T newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (isEmpty()) {
                return newInstance;
            }
            try {
                return (T) MessageNano.mergeFrom(newInstance, this.data);
            } catch (InvalidProtocolBufferNanoException e) {
                String str = TAG;
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(valueOf.length() + 29);
                sb.append("Failed to parse data buffer: ");
                sb.append(valueOf);
                Log.e(str, sb.toString());
                return null;
            }
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            String str2 = TAG;
            String valueOf2 = String.valueOf(e2);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 38);
            sb2.append("Failed to invoke nullary constructor: ");
            sb2.append(valueOf2);
            Log.e(str2, sb2.toString());
            return null;
        }
    }

    public void readFromParcel(Parcel parcel) {
        if (shouldSerializeDataLength()) {
            parcel.readInt();
        }
        this.data = parcel.createByteArray();
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setFromProto(T t) {
        int serializedSize = t != null ? t.getSerializedSize() : 0;
        if (serializedSize == 0) {
            clear();
            return;
        }
        byte[] bArr = this.data;
        if (bArr != null && serializedSize == bArr.length) {
            MessageNano.toByteArray(t, bArr, 0, bArr.length);
        } else {
            this.data = MessageNano.toByteArray(t);
        }
    }

    protected boolean shouldSerializeDataLength() {
        return false;
    }

    protected boolean shouldSerializeEmptyInsteadOfNullBuffer() {
        return false;
    }

    public String toString() {
        int sizeBytes = getSizeBytes();
        StringBuilder sb = new StringBuilder(34);
        sb.append("ParcelableProto[");
        sb.append(sizeBytes);
        sb.append(" bytes]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (shouldSerializeDataLength()) {
            byte[] bArr = this.data;
            parcel.writeInt(bArr == null ? 0 : bArr.length);
        }
        if (this.data == null && shouldSerializeEmptyInsteadOfNullBuffer()) {
            parcel.writeByteArray(new byte[0]);
        } else {
            parcel.writeByteArray(this.data);
        }
    }

    public ParcelableProto(byte[] bArr) {
        setData(bArr);
    }

    public ParcelableProto(T t) {
        setFromProto(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ParcelableProto(Parcel parcel) {
        readFromParcel(parcel);
    }
}
