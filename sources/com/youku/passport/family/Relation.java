package com.youku.passport.family;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.youku.usercenter.passport.remote.UserInfo;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class Relation implements Parcelable {
    public static final Parcelable.Creator<Relation> CREATOR = new Parcelable.Creator<Relation>() { // from class: com.youku.passport.family.Relation.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Relation createFromParcel(Parcel parcel) {
            return new Relation(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Relation[] newArray(int i) {
            return new Relation[i];
        }
    };
    @JSONField(name = "relationUserRoleName")
    public String relationRoleName;
    public String relationType;
    @JSONField(name = "relationUserId")
    public String relationUid;
    public UserInfo relationUserInfo;
    public String roleGenSource;
    @JSONField(name = "userRoleName")
    public String roleName;
    public String tlSite;
    @JSONField(name = "userId")
    public String uid;

    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public @interface RelationType {
        public static final String OBJECT = "object";
        public static final String SUBJECT = "subject";
    }

    public Relation() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.tlSite);
        parcel.writeString(this.uid);
        parcel.writeString(this.relationUid);
        parcel.writeString(this.relationType);
        parcel.writeString(this.relationRoleName);
        parcel.writeString(this.roleGenSource);
        parcel.writeParcelable(this.relationUserInfo, i);
    }

    protected Relation(Parcel parcel) {
        this.tlSite = parcel.readString();
        this.uid = parcel.readString();
        this.relationUid = parcel.readString();
        this.relationType = parcel.readString();
        this.relationRoleName = parcel.readString();
        this.roleGenSource = parcel.readString();
        this.relationUserInfo = (UserInfo) parcel.readParcelable(UserInfo.class.getClassLoader());
    }
}
