package com.ali.user.mobile.register.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class OceanRegisterParam implements Parcelable {
    public static final Parcelable.Creator<OceanRegisterParam> CREATOR = new Parcelable.Creator<OceanRegisterParam>() { // from class: com.ali.user.mobile.register.model.OceanRegisterParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OceanRegisterParam createFromParcel(Parcel parcel) {
            return new OceanRegisterParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OceanRegisterParam[] newArray(int i) {
            return new OceanRegisterParam[i];
        }
    };
    public String checkCode;
    public String codeLength;
    public String companyName;
    public String countryCode;
    public String email;
    public Map<String, String> externParams;
    public String firstName;
    public boolean haveCompany;
    public String lastName;
    public String locale;
    public String loginSourcePage;
    public String loginSourceSpm;
    public String loginSourceType;
    public String mobileAreaCode;
    public String mobileNum;
    public String ncSessionId;
    public String ncSignature;
    public String ncToken;
    public String nick;
    public String password;
    public String sendType;
    public String sessionId;
    public String thirdType;
    public String thirdUserId;
    public String traceId;

    public OceanRegisterParam() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public OceanRegisterParam toInfo() {
        OceanRegisterParam oceanRegisterParam = new OceanRegisterParam();
        oceanRegisterParam.nick = this.nick;
        oceanRegisterParam.locale = this.locale;
        oceanRegisterParam.checkCode = this.checkCode;
        oceanRegisterParam.countryCode = this.countryCode;
        oceanRegisterParam.mobileAreaCode = this.mobileAreaCode;
        oceanRegisterParam.mobileNum = this.mobileNum;
        oceanRegisterParam.email = this.email;
        oceanRegisterParam.password = this.password;
        oceanRegisterParam.firstName = this.firstName;
        oceanRegisterParam.lastName = this.lastName;
        oceanRegisterParam.companyName = this.companyName;
        oceanRegisterParam.thirdUserId = this.thirdUserId;
        oceanRegisterParam.thirdType = this.thirdType;
        oceanRegisterParam.sessionId = this.sessionId;
        oceanRegisterParam.ncSessionId = this.ncSessionId;
        oceanRegisterParam.ncToken = this.ncToken;
        oceanRegisterParam.ncSignature = this.ncSignature;
        oceanRegisterParam.sendType = this.sendType;
        return oceanRegisterParam;
    }

    public OceanRegisterParam toSendOverSeaSMS() {
        OceanRegisterParam oceanRegisterParam = new OceanRegisterParam();
        oceanRegisterParam.sessionId = this.sessionId;
        oceanRegisterParam.checkCode = this.checkCode;
        oceanRegisterParam.mobileAreaCode = this.mobileAreaCode;
        oceanRegisterParam.mobileNum = this.mobileNum;
        oceanRegisterParam.countryCode = this.countryCode;
        return oceanRegisterParam;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.checkCode);
        parcel.writeString(this.countryCode);
        parcel.writeString(this.mobileAreaCode);
        parcel.writeString(this.mobileNum);
        parcel.writeString(this.email);
        parcel.writeString(this.password);
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.companyName);
        parcel.writeString(this.thirdUserId);
        parcel.writeString(this.thirdType);
        parcel.writeString(this.sessionId);
        parcel.writeString(this.ncSessionId);
        parcel.writeString(this.ncToken);
        parcel.writeString(this.ncSignature);
        parcel.writeString(this.sendType);
        parcel.writeInt(this.haveCompany ? 1 : 0);
    }

    protected OceanRegisterParam(Parcel parcel) {
        this.checkCode = parcel.readString();
        this.countryCode = parcel.readString();
        this.mobileAreaCode = parcel.readString();
        this.mobileNum = parcel.readString();
        this.email = parcel.readString();
        this.password = parcel.readString();
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
        this.companyName = parcel.readString();
        this.thirdUserId = parcel.readString();
        this.thirdType = parcel.readString();
        this.sessionId = parcel.readString();
        this.ncSessionId = parcel.readString();
        this.ncToken = parcel.readString();
        this.ncSignature = parcel.readString();
        this.sendType = parcel.readString();
        this.haveCompany = parcel.readInt() == 1;
    }
}
