package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushinternal.DebugLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.handler.a.c.a */
/* loaded from: classes10.dex */
public class C6040a implements Parcelable {
    public static final Parcelable.Creator<C6040a> CREATOR = new Parcelable.Creator<C6040a>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.a.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public C6040a createFromParcel(Parcel parcel) {
            return new C6040a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public C6040a[] newArray(int i) {
            return new C6040a[i];
        }
    };
    private int a;
    private int b;
    private int c;

    public C6040a() {
    }

    protected C6040a(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
    }

    public static C6040a a(JSONObject jSONObject) {
        String str;
        C6040a c6040a = new C6040a();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("pushType")) {
                    c6040a.a(jSONObject.getInt("pushType"));
                }
                if (!jSONObject.isNull("cached")) {
                    c6040a.b(jSONObject.getInt("cached"));
                }
                if (!jSONObject.isNull("cacheNum")) {
                    c6040a.c(jSONObject.getInt("cacheNum"));
                }
            } catch (JSONException e) {
                str = " parse control message error " + e.getMessage();
            }
            return c6040a;
        }
        str = "no control message can parse ";
        DebugLogger.e("ctl", str);
        return c6040a;
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void b(int i) {
        this.b = i;
    }

    public void c(int i) {
        this.c = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "Control{pushType=" + this.a + ", cached=" + this.b + ", cacheNum=" + this.c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
    }
}
