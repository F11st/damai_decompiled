package com.alibaba.security.biometrics.camera.size;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.SparseArrayCompat;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AspectRatio implements Parcelable, Comparable<AspectRatio> {
    public final int b;
    public final int c;
    public static final AspectRatio a = new AspectRatio(4, 3);
    private static final SparseArrayCompat<SparseArrayCompat<AspectRatio>> d = new SparseArrayCompat<>(16);
    public static final Parcelable.Creator<AspectRatio> CREATOR = new Parcelable.Creator<AspectRatio>() { // from class: com.alibaba.security.biometrics.camera.size.AspectRatio.1
        private static AspectRatio a(Parcel parcel) {
            return AspectRatio.a(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AspectRatio createFromParcel(Parcel parcel) {
            return AspectRatio.a(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AspectRatio[] newArray(int i) {
            return new AspectRatio[i];
        }

        private static AspectRatio[] a(int i) {
            return new AspectRatio[i];
        }
    };

    private AspectRatio(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    public static AspectRatio a(int i, int i2) {
        int b = b(i, i2);
        int i3 = i / b;
        int i4 = i2 / b;
        SparseArrayCompat<SparseArrayCompat<AspectRatio>> sparseArrayCompat = d;
        SparseArrayCompat<AspectRatio> sparseArrayCompat2 = sparseArrayCompat.get(i3);
        if (sparseArrayCompat2 == null) {
            AspectRatio aspectRatio = new AspectRatio(i3, i4);
            SparseArrayCompat<AspectRatio> sparseArrayCompat3 = new SparseArrayCompat<>();
            sparseArrayCompat3.put(i4, aspectRatio);
            sparseArrayCompat.put(i3, sparseArrayCompat3);
            return aspectRatio;
        }
        AspectRatio aspectRatio2 = sparseArrayCompat2.get(i4);
        if (aspectRatio2 == null) {
            AspectRatio aspectRatio3 = new AspectRatio(i3, i4);
            sparseArrayCompat2.put(i4, aspectRatio3);
            return aspectRatio3;
        }
        return aspectRatio2;
    }

    private int b() {
        return this.c;
    }

    private float c() {
        return this.b / this.c;
    }

    private AspectRatio d() {
        return a(this.c, this.b);
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(AspectRatio aspectRatio) {
        AspectRatio aspectRatio2 = aspectRatio;
        if (equals(aspectRatio2)) {
            return 0;
        }
        return c() - aspectRatio2.c() > 0.0f ? 1 : -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof AspectRatio) {
            AspectRatio aspectRatio = (AspectRatio) obj;
            if (this.b == aspectRatio.b && this.c == aspectRatio.c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.c;
        int i2 = this.b;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public String toString() {
        return this.b + ":" + this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }

    public static int b(int i, int i2) {
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i == 0) {
                return i4;
            }
            i2 = i4 % i;
        }
    }

    private static AspectRatio a(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            try {
                return a(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Malformed aspect ratio: ".concat(str), e);
            }
        }
        throw new IllegalArgumentException("Malformed aspect ratio: ".concat(str));
    }

    private int a() {
        return this.b;
    }

    private int a(AspectRatio aspectRatio) {
        if (equals(aspectRatio)) {
            return 0;
        }
        return c() - aspectRatio.c() > 0.0f ? 1 : -1;
    }

    private boolean a(a aVar) {
        int b = b(aVar.a, aVar.b);
        return this.b == aVar.a / b && this.c == aVar.b / b;
    }
}
