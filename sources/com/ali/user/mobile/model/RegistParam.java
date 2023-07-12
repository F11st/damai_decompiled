package com.ali.user.mobile.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class RegistParam implements Parcelable {
    public String regFrom;
    public String registAccount;
    public int registSite;
    public String registerSiteString;
    public String source = "";
    public String token;
    public boolean userSiteHere;
    public static final Pattern REG_EMAIL = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    public static final Parcelable.Creator<RegistParam> CREATOR = new Parcelable.Creator<RegistParam>() { // from class: com.ali.user.mobile.model.RegistParam.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RegistParam createFromParcel(Parcel parcel) {
            return new RegistParam(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RegistParam[] newArray(int i) {
            return new RegistParam[i];
        }
    };

    public RegistParam() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.registAccount);
        parcel.writeString(this.token);
        parcel.writeInt(this.registSite);
        parcel.writeString(this.regFrom);
        parcel.writeInt(this.userSiteHere ? 1 : 0);
        parcel.writeString(this.registerSiteString);
    }

    public RegistParam(Parcel parcel) {
        this.registAccount = parcel.readString();
        this.token = parcel.readString();
        this.registSite = parcel.readInt();
        this.regFrom = parcel.readString();
        this.userSiteHere = parcel.readInt() == 1;
        this.registerSiteString = parcel.readString();
    }
}
