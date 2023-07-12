package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.core.aidl.b */
/* loaded from: classes10.dex */
public class C5546b implements Parcelable {
    public static final Parcelable.Creator<C5546b> CREATOR = new C5547a();
    public String a;
    public Bundle b;
    private int c;
    private Bundle d;

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.core.aidl.b$a */
    /* loaded from: classes10.dex */
    static class C5547a implements Parcelable.Creator<C5546b> {
        C5547a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public C5546b createFromParcel(Parcel parcel) {
            return new C5546b(parcel, (C5547a) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public C5546b[] newArray(int i) {
            return new C5546b[i];
        }
    }

    /* synthetic */ C5546b(Parcel parcel, C5547a c5547a) {
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

    private C5546b(Parcel parcel) {
        this.b = null;
        this.c = 1;
        this.d = null;
        a(parcel);
    }

    public C5546b a(Bundle bundle) {
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

    public C5546b() {
        this.b = null;
        this.c = 1;
        this.d = null;
    }

    public C5546b(String str, int i) {
        this.b = null;
        this.c = 1;
        this.d = null;
        this.a = str;
        this.c = i;
    }
}
