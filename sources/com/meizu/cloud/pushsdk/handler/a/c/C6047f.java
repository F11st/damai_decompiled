package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.taobao.tao.log.TLogConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.c.f */
/* loaded from: classes10.dex */
public class C6047f implements Parcelable {
    public static final Parcelable.Creator<C6047f> CREATOR = new Parcelable.Creator<C6047f>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.f.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public C6047f createFromParcel(Parcel parcel) {
            return new C6047f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public C6047f[] newArray(int i) {
            return new C6047f[i];
        }
    };
    private String a;
    private String b;
    private boolean c;
    private String d;
    private String e;

    public C6047f() {
        this.c = false;
    }

    protected C6047f(Parcel parcel) {
        this.c = false;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readByte() != 0;
        this.d = parcel.readString();
        this.e = parcel.readString();
    }

    public static C6047f a(JSONObject jSONObject) {
        String str;
        C6047f c6047f = new C6047f();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(TLogConstant.PERSIST_TASK_ID)) {
                    c6047f.a(jSONObject.getString(TLogConstant.PERSIST_TASK_ID));
                }
                if (!jSONObject.isNull("time")) {
                    c6047f.b(jSONObject.getString("time"));
                }
                if (!jSONObject.isNull("pushExtra")) {
                    c6047f.a(jSONObject.getInt("pushExtra") == 0);
                }
            } catch (JSONException e) {
                str = " parse statics message error " + e.getMessage();
            }
            return c6047f;
        }
        str = "no control statics can parse ";
        DebugLogger.e("statics", str);
        return c6047f;
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public boolean c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public void d(String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.e;
    }

    public String toString() {
        return "Statics{taskId='" + this.a + "', time='" + this.b + "', pushExtra=" + this.c + ", deviceId='" + this.d + "', seqId='" + this.e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
    }
}
