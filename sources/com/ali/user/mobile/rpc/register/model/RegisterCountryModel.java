package com.ali.user.mobile.rpc.register.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class RegisterCountryModel implements Parcelable {
    public static final Parcelable.Creator<RegisterCountryModel> CREATOR = new Parcelable.Creator<RegisterCountryModel>() { // from class: com.ali.user.mobile.rpc.register.model.RegisterCountryModel.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RegisterCountryModel createFromParcel(Parcel parcel) {
            return new RegisterCountryModel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RegisterCountryModel[] newArray(int i) {
            return new RegisterCountryModel[i];
        }
    };
    public String areaCode;
    public String checkPattern;
    public String countryCode;
    public String countryFlagBaseUrl;
    public String countryName;
    public String sortLetters;

    public RegisterCountryModel() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.areaCode);
        parcel.writeString(this.countryName);
        parcel.writeString(this.countryCode);
        parcel.writeString(this.checkPattern);
        parcel.writeString(this.sortLetters);
        parcel.writeString(this.countryFlagBaseUrl);
    }

    protected RegisterCountryModel(Parcel parcel) {
        this.areaCode = parcel.readString();
        this.countryName = parcel.readString();
        this.countryCode = parcel.readString();
        this.checkPattern = parcel.readString();
        this.sortLetters = parcel.readString();
        this.countryFlagBaseUrl = parcel.readString();
    }
}
