package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DrivePath extends Path {
    public static final Parcelable.Creator<DrivePath> CREATOR = new Parcelable.Creator<DrivePath>() { // from class: com.amap.api.services.route.DrivePath.1
        private static DrivePath a(Parcel parcel) {
            return new DrivePath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePath[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private float b;
    private float c;
    private int d;
    private List<DriveStep> e;
    private int f;

    public DrivePath(Parcel parcel) {
        super(parcel);
        this.e = new ArrayList();
        this.a = parcel.readString();
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.e = parcel.createTypedArrayList(DriveStep.CREATOR);
        this.d = parcel.readInt();
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRestriction() {
        return this.f;
    }

    public List<DriveStep> getSteps() {
        return this.e;
    }

    public String getStrategy() {
        return this.a;
    }

    public float getTollDistance() {
        return this.c;
    }

    public float getTolls() {
        return this.b;
    }

    public int getTotalTrafficlights() {
        return this.d;
    }

    public void setRestriction(int i) {
        this.f = i;
    }

    public void setSteps(List<DriveStep> list) {
        this.e = list;
    }

    public void setStrategy(String str) {
        this.a = str;
    }

    public void setTollDistance(float f) {
        this.c = f;
    }

    public void setTolls(float f) {
        this.b = f;
    }

    public void setTotalTrafficlights(int i) {
        this.d = i;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeTypedList(this.e);
        parcel.writeInt(this.d);
    }

    public DrivePath() {
        this.e = new ArrayList();
    }
}
