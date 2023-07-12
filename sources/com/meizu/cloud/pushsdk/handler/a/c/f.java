package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.taobao.tao.log.TLogConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.f.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f[] newArray(int i) {
            return new f[i];
        }
    };
    private String a;
    private String b;
    private boolean c;
    private String d;
    private String e;

    public f() {
        this.c = false;
    }

    protected f(Parcel parcel) {
        this.c = false;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readByte() != 0;
        this.d = parcel.readString();
        this.e = parcel.readString();
    }

    public static f a(JSONObject jSONObject) {
        String str;
        f fVar = new f();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(TLogConstant.PERSIST_TASK_ID)) {
                    fVar.a(jSONObject.getString(TLogConstant.PERSIST_TASK_ID));
                }
                if (!jSONObject.isNull("time")) {
                    fVar.b(jSONObject.getString("time"));
                }
                if (!jSONObject.isNull("pushExtra")) {
                    fVar.a(jSONObject.getInt("pushExtra") == 0);
                }
            } catch (JSONException e) {
                str = " parse statics message error " + e.getMessage();
            }
            return fVar;
        }
        str = "no control statics can parse ";
        DebugLogger.e("statics", str);
        return fVar;
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
