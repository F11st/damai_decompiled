package com.amap.api.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.taobao.windvane.connect.HttpRequest;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class TileOverlayOptions implements Parcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private String diskCacheDir;
    private boolean diskCacheEnabled;
    private long diskCacheSize;
    private TileProvider mTileProvider;
    private final int mVersionCode;
    private boolean mVisible;
    private float mZIndex;
    private int memCacheSize;
    private boolean memoryCacheEnabled;

    public TileOverlayOptions() {
        this.mVisible = true;
        this.memCacheSize = HttpRequest.DEFAULT_MAX_LENGTH;
        this.diskCacheSize = 20971520L;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions diskCacheDir(String str) {
        this.diskCacheDir = str;
        return this;
    }

    public TileOverlayOptions diskCacheEnabled(boolean z) {
        this.diskCacheEnabled = z;
        return this;
    }

    public TileOverlayOptions diskCacheSize(int i) {
        this.diskCacheSize = i * 1024;
        return this;
    }

    public String getDiskCacheDir() {
        return this.diskCacheDir;
    }

    public boolean getDiskCacheEnabled() {
        return this.diskCacheEnabled;
    }

    public long getDiskCacheSize() {
        return this.diskCacheSize;
    }

    public int getMemCacheSize() {
        return this.memCacheSize;
    }

    public boolean getMemoryCacheEnabled() {
        return this.memoryCacheEnabled;
    }

    public TileProvider getTileProvider() {
        return this.mTileProvider;
    }

    public float getZIndex() {
        return this.mZIndex;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public TileOverlayOptions memCacheSize(int i) {
        this.memCacheSize = i;
        return this;
    }

    public TileOverlayOptions memoryCacheEnabled(boolean z) {
        this.memoryCacheEnabled = z;
        return this;
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.mTileProvider = tileProvider;
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.mVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeValue(this.mTileProvider);
        parcel.writeByte(this.mVisible ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.mZIndex);
        parcel.writeInt(this.memCacheSize);
        parcel.writeLong(this.diskCacheSize);
        parcel.writeString(this.diskCacheDir);
        parcel.writeByte(this.memoryCacheEnabled ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.diskCacheEnabled ? (byte) 1 : (byte) 0);
    }

    public TileOverlayOptions zIndex(float f) {
        this.mZIndex = f;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TileOverlayOptions(int i, IBinder iBinder, boolean z, float f) {
        this.mVisible = true;
        this.memCacheSize = HttpRequest.DEFAULT_MAX_LENGTH;
        this.diskCacheSize = 20971520L;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = i;
        this.mVisible = z;
        this.mZIndex = f;
    }
}
