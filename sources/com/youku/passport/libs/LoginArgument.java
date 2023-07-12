package com.youku.passport.libs;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class LoginArgument implements Parcelable {
    public static final Parcelable.Creator<LoginArgument> CREATOR = new Parcelable.Creator<LoginArgument>() { // from class: com.youku.passport.libs.LoginArgument.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginArgument createFromParcel(Parcel parcel) {
            return new LoginArgument(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginArgument[] newArray(int i) {
            return new LoginArgument[i];
        }
    };
    public static final String DATA_TOKEN_FAMILY_INVITE = "family_invite";
    public static final String DATA_TOKEN_TRUST_DEVICE = "trust_device";
    public static final String EXT_DATA_TOKEN_TYPE = "dataTokenBizType";
    public static final String EXT_INVITER_DISPLAY_NAME = "inviterDisplayName";
    public static final String EXT_INVITER_MASK_EMAIL = "inviterMaskEmail";
    public static final String EXT_INVITER_MASK_MOBILE = "inviterMaskMobile";
    public static final String EXT_INVITER_MASK_NICKNAME = "inviterMaskNickname";
    public static final String EXT_TLSITE_NICKNAME = "tlsiteNickname";
    public static final String EXT_TL_SITE = "tlsite";
    public String authCode;
    public String displayName;
    public HashMap<String, Object> extInfo;
    public boolean isLoginMobile;
    public String loginMobile;
    public String loginPassport;
    public String loginRegion;
    public String loginType;
    public String maskEmail;
    public String maskMobile;
    public String maskNickname;
    public String nickname;
    public String portrait;
    public LoginStyle style;
    public String ytid;

    public LoginArgument() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.ytid);
        parcel.writeString(this.nickname);
        parcel.writeString(this.loginType);
        parcel.writeString(this.maskMobile);
        parcel.writeString(this.maskEmail);
        parcel.writeString(this.maskNickname);
        parcel.writeString(this.loginMobile);
        parcel.writeString(this.loginRegion);
        parcel.writeString(this.authCode);
        parcel.writeString(this.loginPassport);
        parcel.writeString(this.portrait);
        parcel.writeParcelable(this.style, i);
        parcel.writeString(this.displayName);
        parcel.writeByte(this.isLoginMobile ? (byte) 1 : (byte) 0);
        parcel.writeSerializable(this.extInfo);
    }

    protected LoginArgument(Parcel parcel) {
        this.ytid = parcel.readString();
        this.nickname = parcel.readString();
        this.loginType = parcel.readString();
        this.maskMobile = parcel.readString();
        this.maskEmail = parcel.readString();
        this.maskNickname = parcel.readString();
        this.loginMobile = parcel.readString();
        this.loginRegion = parcel.readString();
        this.authCode = parcel.readString();
        this.loginPassport = parcel.readString();
        this.portrait = parcel.readString();
        this.style = (LoginStyle) parcel.readParcelable(LoginStyle.class.getClassLoader());
        this.displayName = parcel.readString();
        this.isLoginMobile = parcel.readByte() != 0;
        this.extInfo = (HashMap) parcel.readSerializable();
    }
}
