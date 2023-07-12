package com.youku.usercenter.passport.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PassportConfig implements Parcelable {
    public static final Parcelable.Creator<PassportConfig> CREATOR = new Parcelable.Creator<PassportConfig>() { // from class: com.youku.usercenter.passport.remote.PassportConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PassportConfig createFromParcel(Parcel parcel) {
            return new PassportConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PassportConfig[] newArray(int i) {
            return new PassportConfig[i];
        }
    };
    public static final String PASSPORT_THEME_TUDOU = "tudou";
    public static final String PASSPORT_THEME_YOUKU = "youku";
    public String mAlipayAppId;
    public boolean mAlipayLoginSupport;
    public String mAlipayPid;
    public String mAlipaySignType;
    public String mAppId;
    public String mAppSecret;
    public boolean mDebug;
    public Domain mDomain;
    public String mGuid;
    public String mMMAppId;
    public boolean mMMLoginSupport;
    public String mPid;
    public String mQQAppId;
    public boolean mQQLoginSupport;
    public boolean mTaobaoLoginSupport;
    public String mTheme;
    private Bundle mThemeBundle;
    public boolean mUseMtop;
    public boolean mUseOrange;
    public String mWeiboAppId;
    public boolean mWeiboLoginSupport;
    public String mWeiboRedirectUrl;
    public int orientation;

    public PassportConfig() {
        this.mQQLoginSupport = true;
        this.mMMLoginSupport = true;
        this.mWeiboLoginSupport = true;
        this.mTaobaoLoginSupport = true;
        this.mAlipayLoginSupport = true;
        this.mDebug = false;
        this.mUseMtop = true;
        this.mUseOrange = true;
        this.mDomain = Domain.DOMAIN_ONLINE;
        this.orientation = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ThemeBundle getThemeBundle() {
        Bundle bundle = this.mThemeBundle;
        if (bundle != null) {
            return new ThemeBundle(bundle);
        }
        return null;
    }

    public void setThemeBundle(ThemeBundle themeBundle) {
        if (themeBundle != null) {
            this.mThemeBundle = themeBundle.getBundle();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        String str = this.mAppId;
        if (str == null) {
            str = "";
        }
        parcel.writeString(str);
        String str2 = this.mAppSecret;
        if (str2 == null) {
            str2 = "";
        }
        parcel.writeString(str2);
        parcel.writeByte(this.mQQLoginSupport ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mMMLoginSupport ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mWeiboLoginSupport ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mTaobaoLoginSupport ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mAlipayLoginSupport ? (byte) 1 : (byte) 0);
        String str3 = this.mQQAppId;
        if (str3 == null) {
            str3 = "";
        }
        parcel.writeString(str3);
        String str4 = this.mMMAppId;
        if (str4 == null) {
            str4 = "";
        }
        parcel.writeString(str4);
        String str5 = this.mWeiboAppId;
        if (str5 == null) {
            str5 = "";
        }
        parcel.writeString(str5);
        String str6 = this.mAlipayAppId;
        if (str6 == null) {
            str6 = "";
        }
        parcel.writeString(str6);
        String str7 = this.mAlipayPid;
        if (str7 == null) {
            str7 = "";
        }
        parcel.writeString(str7);
        String str8 = this.mAlipaySignType;
        if (str8 == null) {
            str8 = "";
        }
        parcel.writeString(str8);
        String str9 = this.mWeiboRedirectUrl;
        if (str9 == null) {
            str9 = "";
        }
        parcel.writeString(str9);
        String str10 = this.mGuid;
        if (str10 == null) {
            str10 = "";
        }
        parcel.writeString(str10);
        String str11 = this.mPid;
        if (str11 == null) {
            str11 = "";
        }
        parcel.writeString(str11);
        parcel.writeByte(this.mDebug ? (byte) 1 : (byte) 0);
        String str12 = this.mTheme;
        parcel.writeString(str12 != null ? str12 : "");
        parcel.writeByte(this.mUseMtop ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.mUseOrange ? (byte) 1 : (byte) 0);
        parcel.writeBundle(this.mThemeBundle);
        parcel.writeString(this.mDomain.name());
        parcel.writeInt(this.orientation);
    }

    protected PassportConfig(Parcel parcel) {
        this.mQQLoginSupport = true;
        this.mMMLoginSupport = true;
        this.mWeiboLoginSupport = true;
        this.mTaobaoLoginSupport = true;
        this.mAlipayLoginSupport = true;
        this.mDebug = false;
        this.mUseMtop = true;
        this.mUseOrange = true;
        this.mDomain = Domain.DOMAIN_ONLINE;
        this.orientation = 1;
        this.mAppId = parcel.readString();
        this.mAppSecret = parcel.readString();
        this.mQQLoginSupport = parcel.readByte() != 0;
        this.mMMLoginSupport = parcel.readByte() != 0;
        this.mWeiboLoginSupport = parcel.readByte() != 0;
        this.mTaobaoLoginSupport = parcel.readByte() != 0;
        this.mAlipayLoginSupport = parcel.readByte() != 0;
        this.mQQAppId = parcel.readString();
        this.mMMAppId = parcel.readString();
        this.mWeiboAppId = parcel.readString();
        this.mAlipayAppId = parcel.readString();
        this.mAlipayPid = parcel.readString();
        this.mAlipaySignType = parcel.readString();
        this.mWeiboRedirectUrl = parcel.readString();
        this.mGuid = parcel.readString();
        this.mPid = parcel.readString();
        this.mDebug = parcel.readByte() != 0;
        this.mTheme = parcel.readString();
        this.mUseMtop = parcel.readByte() != 0;
        this.mUseOrange = parcel.readByte() != 0;
        this.mThemeBundle = parcel.readBundle(getClass().getClassLoader());
        this.mDomain = Domain.valueOf(parcel.readString());
        this.orientation = parcel.readInt();
    }
}
