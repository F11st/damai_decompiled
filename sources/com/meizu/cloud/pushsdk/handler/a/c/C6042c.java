package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushsdk.handler.MessageV3;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.c.c */
/* loaded from: classes10.dex */
public class C6042c implements Parcelable {
    public static final Parcelable.Creator<C6042c> CREATOR = new Parcelable.Creator<C6042c>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.c.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public C6042c createFromParcel(Parcel parcel) {
            return new C6042c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public C6042c[] newArray(int i) {
            return new C6042c[i];
        }
    };
    private MessageV3 a;
    private String b;
    private int c;
    private int d;

    protected C6042c(Parcel parcel) {
        this.a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }

    public C6042c(MessageV3 messageV3) {
        this.a = messageV3;
    }

    public MessageV3 a() {
        return this.a;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public int b() {
        return this.c;
    }

    public void b(int i) {
        this.d = i;
    }

    public int c() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.a + ", notificationPkg='" + this.b + "', notificationId='" + this.c + "', state='" + this.d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }
}
