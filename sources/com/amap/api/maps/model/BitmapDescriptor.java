package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.eq;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();
    int a;
    int b;
    Bitmap c;
    private String mId;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitmapDescriptor(Bitmap bitmap, String str) {
        this.a = 0;
        this.b = 0;
        if (bitmap != null) {
            try {
                this.a = bitmap.getWidth();
                this.b = bitmap.getHeight();
                if (bitmap.getConfig() == null) {
                    this.c = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                } else {
                    this.c = bitmap.copy(bitmap.getConfig(), true);
                }
            } catch (Throwable th) {
                eq.a(th);
                return;
            }
        }
        this.mId = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        BitmapDescriptor bitmapDescriptor;
        Bitmap bitmap;
        Bitmap bitmap2 = this.c;
        if (bitmap2 == null || bitmap2.isRecycled() || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (BitmapDescriptor.class == obj.getClass() && (bitmap = (bitmapDescriptor = (BitmapDescriptor) obj).c) != null && !bitmap.isRecycled() && this.a == bitmapDescriptor.getWidth() && this.b == bitmapDescriptor.getHeight()) {
            try {
                return this.c.sameAs(bitmapDescriptor.c);
            } catch (Throwable th) {
                eq.a(th);
            }
        }
        return false;
    }

    public Bitmap getBitmap() {
        return this.c;
    }

    public int getHeight() {
        return this.b;
    }

    public String getId() {
        return this.mId;
    }

    public int getWidth() {
        return this.a;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void recycle() {
        try {
            Bitmap bitmap = this.c;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            eq.b(this.c);
            this.c = null;
        } catch (Throwable th) {
            eq.a(th);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeParcelable(this.c, i);
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
    }

    /* renamed from: clone */
    public BitmapDescriptor m219clone() {
        try {
            Bitmap bitmap = this.c;
            return new BitmapDescriptor(bitmap.copy(bitmap.getConfig(), true), this.a, this.b, this.mId);
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
            return null;
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2, String str) {
        this.a = 0;
        this.b = 0;
        this.a = i;
        this.b = i2;
        this.c = bitmap;
        this.mId = str;
    }
}
