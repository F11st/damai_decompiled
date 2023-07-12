package com.google.vr.vrcore.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.vr.sdk.proto.nano.Session;
import com.google.vr.vrcore.base.api.ParcelableProto;
import java.util.Arrays;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class HeadTrackingState extends ParcelableProto<Session.TrackerState> {
    public static final Parcelable.Creator<HeadTrackingState> CREATOR = new a();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    class a implements Parcelable.Creator<HeadTrackingState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public HeadTrackingState createFromParcel(Parcel parcel) {
            return new HeadTrackingState(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public HeadTrackingState[] newArray(int i) {
            return new HeadTrackingState[i];
        }
    }

    /* synthetic */ HeadTrackingState(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.google.vr.vrcore.base.api.ParcelableProto
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof HeadTrackingState) {
            return Arrays.equals(((HeadTrackingState) obj).getData(), getData());
        }
        return false;
    }

    @Override // com.google.vr.vrcore.base.api.ParcelableProto
    protected final boolean shouldSerializeDataLength() {
        return true;
    }

    @Override // com.google.vr.vrcore.base.api.ParcelableProto
    protected boolean shouldSerializeEmptyInsteadOfNullBuffer() {
        return true;
    }

    @Override // com.google.vr.vrcore.base.api.ParcelableProto
    public String toString() {
        int sizeBytes = getSizeBytes();
        StringBuilder sb = new StringBuilder(36);
        sb.append("HeadTrackingState[");
        sb.append(sizeBytes);
        sb.append(" bytes]");
        return sb.toString();
    }

    public HeadTrackingState() {
    }

    public HeadTrackingState(byte[] bArr) {
        super(bArr);
    }

    private HeadTrackingState(Parcel parcel) {
        super(parcel);
    }
}
