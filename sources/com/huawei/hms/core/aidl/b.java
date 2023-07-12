package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    public String a;
    public Bundle b;
    private int c;
    private Bundle d;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a implements Parcelable.Creator<b> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public b createFromParcel(Parcel parcel) {
            return new b(parcel, (a) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    /* synthetic */ b(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static ClassLoader a(Class cls) {
        return cls.getClassLoader();
    }

    public int b() {
        return this.d == null ? 0 : 1;
    }

    public int c() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeString(this.a);
        parcel.writeBundle(this.b);
        parcel.writeBundle(this.d);
    }

    private b(Parcel parcel) {
        this.b = null;
        this.c = 1;
        this.d = null;
        a(parcel);
    }

    public b a(Bundle bundle) {
        this.d = bundle;
        return this;
    }

    public Bundle a() {
        return this.d;
    }

    private void a(Parcel parcel) {
        this.c = parcel.readInt();
        this.a = parcel.readString();
        this.b = parcel.readBundle(a(Bundle.class));
        this.d = parcel.readBundle(a(Bundle.class));
    }

    public b() {
        this.b = null;
        this.c = 1;
        this.d = null;
    }

    public b(String str, int i) {
        this.b = null;
        this.c = 1;
        this.d = null;
        this.a = str;
        this.c = i;
    }
}
