package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushinternal.DebugLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.c.h */
/* loaded from: classes10.dex */
public class C6049h implements Parcelable {
    public static final Parcelable.Creator<C6049h> CREATOR = new Parcelable.Creator<C6049h>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.h.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public C6049h createFromParcel(Parcel parcel) {
            return new C6049h(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public C6049h[] newArray(int i) {
            return new C6049h[i];
        }
    };
    private C6041b a;
    private String b;
    private int c;

    protected C6049h(Parcel parcel) {
        this.a = (C6041b) parcel.readParcelable(C6041b.class.getClassLoader());
        this.b = parcel.readString();
        this.c = parcel.readInt();
    }

    public C6049h(String str, String str2, String str3, String str4, String str5) {
        this.b = str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(RemoteMessageConst.Notification.NOTIFY_ID)) {
                this.c = jSONObject.getInt(RemoteMessageConst.Notification.NOTIFY_ID);
            }
        } catch (JSONException e) {
            DebugLogger.e("WithDrawMessage", "parse WithDrawMessage error " + e.getMessage());
        }
        this.a = new C6041b(str3, str4, str5);
    }

    public C6041b a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WithDrawMessage{controlMessage=" + this.a + ", revokePackageName='" + this.b + "', notifyId=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
    }
}
