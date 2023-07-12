package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.notification.model.a */
/* loaded from: classes10.dex */
public class C6087a implements Parcelable {
    public static final Parcelable.Creator<C6087a> CREATOR = new Parcelable.Creator<C6087a>() { // from class: com.meizu.cloud.pushsdk.notification.model.a.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public C6087a createFromParcel(Parcel parcel) {
            return new C6087a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public C6087a[] newArray(int i) {
            return new C6087a[i];
        }
    };
    private int a;
    private String b;

    public C6087a() {
        this.a = 0;
    }

    protected C6087a(Parcel parcel) {
        this.a = 0;
        this.a = parcel.readInt();
        this.b = parcel.readString();
    }

    public static C6087a a(MessageV3 messageV3) {
        C6087a c;
        try {
            c = !TextUtils.isEmpty(messageV3.getNotificationMessage()) ? a(new JSONObject(messageV3.getNotificationMessage()).getJSONObject("data").getJSONObject("extra").getJSONObject("no")) : null;
        } catch (Exception e) {
            DebugLogger.e("NotifyOption", "parse flyme NotifyOption setting error " + e.getMessage() + " so get from notificationMessage");
            c = c(messageV3.getNotificationMessage());
        }
        DebugLogger.i("NotifyOption", "current notify option is " + c);
        return c;
    }

    public static C6087a a(JSONObject jSONObject) {
        String str;
        C6087a c6087a = new C6087a();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("ni")) {
                    c6087a.a(jSONObject.getInt("ni"));
                }
                if (!jSONObject.isNull("nk")) {
                    c6087a.a(jSONObject.getString("nk"));
                }
            } catch (JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
            return c6087a;
        }
        str = "no such tag NotifyOption";
        DebugLogger.e("NotifyOption", str);
        return c6087a;
    }

    public static int b(MessageV3 messageV3) {
        C6087a a = a(messageV3);
        if (a != null) {
            return a.a();
        }
        return 0;
    }

    public static C6087a b(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                DebugLogger.e("NotifyOption", "parse json string error " + e.getMessage());
            }
            return a(jSONObject);
        }
        jSONObject = null;
        return a(jSONObject);
    }

    private static C6087a c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return b(new JSONObject(str).getString("no"));
        } catch (JSONException e) {
            DebugLogger.e("NotifyOption", "parse notificationMessage error " + e.getMessage());
            return null;
        }
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotifyOption{notifyId=" + this.a + ", notifyKey='" + this.b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
    }
}
