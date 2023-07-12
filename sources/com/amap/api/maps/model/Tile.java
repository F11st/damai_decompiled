package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.ae.gmap.maploader.Pools;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class Tile implements Parcelable {
    public static final b CREATOR = new b();
    private static final Pools.SynchronizedPool<Tile> M_POOL = new Pools.SynchronizedPool<>(18);
    public final byte[] data;
    public final int height;
    private final int mVersionCode;
    public final int width;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tile(int i, int i2, int i3, byte[] bArr) {
        this.mVersionCode = i;
        this.width = i2;
        this.height = i3;
        this.data = bArr;
    }

    public static Tile obtain(int i, int i2, byte[] bArr) {
        Tile acquire = M_POOL.acquire();
        return acquire != null ? acquire : new Tile(i, i2, bArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeByteArray(this.data);
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }
}
