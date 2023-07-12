package com.youku.passport.family;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class RelationList implements Parcelable {
    public static final Parcelable.Creator<RelationList> CREATOR = new Parcelable.Creator<RelationList>() { // from class: com.youku.passport.family.RelationList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RelationList createFromParcel(Parcel parcel) {
            return new RelationList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RelationList[] newArray(int i) {
            return new RelationList[i];
        }
    };
    public String faqAuth;
    public String faqBind;
    @JSONField(alternateNames = {"nickname"}, name = "nickName")
    public String nickname;
    @JSONField(name = "partnerRelationList")
    public ArrayList<Relation> relations;
    public boolean showAuthPage;
    @JSONField(name = "notAuthPartnerRelationList")
    public ArrayList<Relation> unauthorizedRelations;
    @JSONField(name = "notBindPartnerRelationList")
    public ArrayList<Relation> unboundRelations;

    public RelationList() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isEmpty() {
        ArrayList<Relation> arrayList;
        ArrayList<Relation> arrayList2;
        ArrayList<Relation> arrayList3 = this.relations;
        return (arrayList3 == null || arrayList3.size() <= 0) && ((arrayList = this.unboundRelations) == null || arrayList.size() <= 0) && ((arrayList2 = this.unauthorizedRelations) == null || arrayList2.size() <= 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nickname);
        parcel.writeTypedList(this.relations);
        parcel.writeTypedList(this.unboundRelations);
        parcel.writeTypedList(this.unauthorizedRelations);
        parcel.writeInt(this.showAuthPage ? 1 : 0);
        parcel.writeString(this.faqBind);
        parcel.writeString(this.faqAuth);
    }

    protected RelationList(Parcel parcel) {
        this.nickname = parcel.readString();
        Parcelable.Creator<Relation> creator = Relation.CREATOR;
        this.relations = parcel.createTypedArrayList(creator);
        this.unboundRelations = parcel.createTypedArrayList(creator);
        this.unauthorizedRelations = parcel.createTypedArrayList(creator);
        this.showAuthPage = parcel.readInt() == 1;
        this.faqBind = parcel.readString();
        this.faqAuth = parcel.readString();
    }
}
