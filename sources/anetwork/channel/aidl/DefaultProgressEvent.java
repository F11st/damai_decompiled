package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anetwork.channel.NetworkEvent$ProgressEvent;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DefaultProgressEvent implements Parcelable, NetworkEvent$ProgressEvent {
    public static final Parcelable.Creator<DefaultProgressEvent> CREATOR = new Parcelable.Creator<DefaultProgressEvent>() { // from class: anetwork.channel.aidl.DefaultProgressEvent.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultProgressEvent createFromParcel(Parcel parcel) {
            return DefaultProgressEvent.readFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultProgressEvent[] newArray(int i) {
            return new DefaultProgressEvent[i];
        }
    };
    private static final String TAG = "anet.DefaultProgressEvent";
    Object context;
    int index;
    byte[] out;
    int size;
    int total;

    public DefaultProgressEvent() {
    }

    public static DefaultProgressEvent readFromParcel(Parcel parcel) {
        DefaultProgressEvent defaultProgressEvent = new DefaultProgressEvent();
        try {
            defaultProgressEvent.index = parcel.readInt();
            defaultProgressEvent.size = parcel.readInt();
            defaultProgressEvent.total = parcel.readInt();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                parcel.readByteArray(bArr);
                defaultProgressEvent.out = bArr;
            }
        } catch (Exception unused) {
        }
        return defaultProgressEvent;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // anetwork.channel.NetworkEvent$ProgressEvent
    public byte[] getBytedata() {
        return this.out;
    }

    public Object getContext() {
        return this.context;
    }

    @Override // anetwork.channel.NetworkEvent$ProgressEvent
    public String getDesc() {
        return "";
    }

    @Override // anetwork.channel.NetworkEvent$ProgressEvent
    public int getIndex() {
        return this.index;
    }

    @Override // anetwork.channel.NetworkEvent$ProgressEvent
    public int getSize() {
        return this.size;
    }

    @Override // anetwork.channel.NetworkEvent$ProgressEvent
    public int getTotal() {
        return this.total;
    }

    public void setContext(Object obj) {
        this.context = obj;
    }

    public String toString() {
        return "DefaultProgressEvent [index=" + this.index + ", size=" + this.size + ", total=" + this.total + jn1.ARRAY_END_STR;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.index);
        parcel.writeInt(this.size);
        parcel.writeInt(this.total);
        byte[] bArr = this.out;
        parcel.writeInt(bArr != null ? bArr.length : 0);
        parcel.writeByteArray(this.out);
    }

    public DefaultProgressEvent(int i, int i2, int i3, byte[] bArr) {
        this.index = i;
        this.size = i2;
        this.total = i3;
        this.out = bArr;
    }
}
