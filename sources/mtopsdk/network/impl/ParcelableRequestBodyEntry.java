package mtopsdk.network.impl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.request.BodyEntry;
import java.io.IOException;
import java.io.OutputStream;
import mtopsdk.network.domain.ParcelableRequestBodyImpl;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ParcelableRequestBodyEntry implements BodyEntry {
    public static final Parcelable.Creator<ParcelableRequestBodyEntry> CREATOR = new Parcelable.Creator<ParcelableRequestBodyEntry>() { // from class: mtopsdk.network.impl.ParcelableRequestBodyEntry.1
        @Override // android.os.Parcelable.Creator
        public ParcelableRequestBodyEntry createFromParcel(Parcel parcel) {
            return new ParcelableRequestBodyEntry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ParcelableRequestBodyEntry[] newArray(int i) {
            return new ParcelableRequestBodyEntry[i];
        }
    };
    ParcelableRequestBodyImpl requestBody;

    public ParcelableRequestBodyEntry(ParcelableRequestBodyImpl parcelableRequestBodyImpl) {
        this.requestBody = parcelableRequestBodyImpl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // anet.channel.request.BodyEntry
    public String getContentType() {
        return this.requestBody.contentType();
    }

    @Override // anet.channel.request.BodyEntry
    public int writeTo(OutputStream outputStream) throws IOException {
        this.requestBody.writeTo(outputStream);
        return (int) this.requestBody.contentLength();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.requestBody, i);
    }

    protected ParcelableRequestBodyEntry(Parcel parcel) {
        this.requestBody = (ParcelableRequestBodyImpl) parcel.readParcelable(ParcelableRequestBodyImpl.class.getClassLoader());
    }
}
