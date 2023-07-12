package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AppIconSetting implements Parcelable {
    public static final String APP_ICON_SETTING = "is";
    public static final Parcelable.Creator<AppIconSetting> CREATOR = new Parcelable.Creator<AppIconSetting>() { // from class: com.meizu.cloud.pushsdk.notification.model.AppIconSetting.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppIconSetting createFromParcel(Parcel parcel) {
            return new AppIconSetting(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppIconSetting[] newArray(int i) {
            return new AppIconSetting[i];
        }
    };
    public static final String DEFAULT_LARGE_ICON = "di";
    public static final String LARGE_ICON_URL = "li";
    public static final String TAG = "app_icon_setting";
    private boolean defaultLargeIcon;
    private String largeIconUrl;

    public AppIconSetting() {
        this.defaultLargeIcon = true;
    }

    public AppIconSetting(Parcel parcel) {
        this.defaultLargeIcon = true;
        this.defaultLargeIcon = parcel.readByte() != 0;
        this.largeIconUrl = parcel.readString();
    }

    public static AppIconSetting parse(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                DebugLogger.e(TAG, "parse json string error " + e.getMessage());
            }
            return parse(jSONObject);
        }
        jSONObject = null;
        return parse(jSONObject);
    }

    public static AppIconSetting parse(JSONObject jSONObject) {
        String str;
        AppIconSetting appIconSetting = new AppIconSetting();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull(DEFAULT_LARGE_ICON)) {
                    appIconSetting.setDefaultLargeIcon(jSONObject.getInt(DEFAULT_LARGE_ICON) != 0);
                }
                if (!jSONObject.isNull(LARGE_ICON_URL)) {
                    appIconSetting.setLargeIconUrl(jSONObject.getString(LARGE_ICON_URL));
                }
            } catch (JSONException e) {
                str = "parse json obj error " + e.getMessage();
            }
            return appIconSetting;
        }
        str = "no such tag app_icon_setting";
        DebugLogger.e(TAG, str);
        return appIconSetting;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getLargeIconUrl() {
        return this.largeIconUrl;
    }

    public boolean isDefaultLargeIcon() {
        return this.defaultLargeIcon;
    }

    public void setDefaultLargeIcon(boolean z) {
        this.defaultLargeIcon = z;
    }

    public void setLargeIconUrl(String str) {
        this.largeIconUrl = str;
    }

    public String toString() {
        return "AppIconSetting{defaultLargeIcon=" + this.defaultLargeIcon + ", largeIconUrl='" + this.largeIconUrl + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.defaultLargeIcon ? (byte) 1 : (byte) 0);
        parcel.writeString(this.largeIconUrl);
    }
}
