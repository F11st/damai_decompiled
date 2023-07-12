package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.c.b */
/* loaded from: classes10.dex */
public class C6041b implements Parcelable {
    public static final Parcelable.Creator<C6041b> CREATOR = new Parcelable.Creator<C6041b>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public C6041b createFromParcel(Parcel parcel) {
            return new C6041b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public C6041b[] newArray(int i) {
            return new C6041b[i];
        }
    };
    private String a;
    private C6040a b;
    private C6047f c;

    public C6041b() {
    }

    protected C6041b(Parcel parcel) {
        this.a = parcel.readString();
        this.b = (C6040a) parcel.readParcelable(C6040a.class.getClassLoader());
        this.c = (C6047f) parcel.readParcelable(C6047f.class.getClassLoader());
    }

    public C6041b(String str, String str2, String str3) {
        this.a = str;
        if (TextUtils.isEmpty(str)) {
            this.b = new C6040a();
            this.c = new C6047f();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = C6040a.a(jSONObject.getJSONObject("ctl"));
            C6047f a = C6047f.a(jSONObject.getJSONObject("statics"));
            this.c = a;
            a.c(str2);
            this.c.d(str3);
        } catch (JSONException e) {
            this.b = new C6040a();
            this.c = new C6047f();
            DebugLogger.e("ControlMessage", "parse control message error " + e.getMessage());
        }
    }

    public static C6041b a(String str) {
        C6041b c6041b = new C6041b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            c6041b.a(C6040a.a(jSONObject.getJSONObject("ctl")));
            c6041b.a(C6047f.a(jSONObject.getJSONObject("statics")));
        } catch (Exception e) {
            DebugLogger.e("ControlMessage", "parse control message error " + e.getMessage());
            c6041b.a(new C6047f());
            c6041b.a(new C6040a());
        }
        return c6041b;
    }

    public C6040a a() {
        return this.b;
    }

    public void a(C6040a c6040a) {
        this.b = c6040a;
    }

    public void a(C6047f c6047f) {
        this.c = c6047f;
    }

    public C6047f b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ControlMessage{controlMessage='" + this.a + "', control=" + this.b + ", statics=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeParcelable(this.c, i);
    }
}
