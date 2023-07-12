package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class RailwayStationItem implements Parcelable {
    public static final Parcelable.Creator<RailwayStationItem> CREATOR = new Parcelable.Creator<RailwayStationItem>() { // from class: com.amap.api.services.route.RailwayStationItem.1
        private static RailwayStationItem a(Parcel parcel) {
            return new RailwayStationItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwayStationItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RailwayStationItem[] newArray(int i) {
            return a(i);
        }

        private static RailwayStationItem[] a(int i) {
            return new RailwayStationItem[i];
        }
    };
    private String a;
    private String b;
    private LatLonPoint c;
    private String d;
    private String e;
    private boolean f;
    private boolean g;
    private float h;

    public RailwayStationItem() {
        this.f = false;
        this.g = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdcode() {
        return this.d;
    }

    public String getID() {
        return this.a;
    }

    public LatLonPoint getLocation() {
        return this.c;
    }

    public String getName() {
        return this.b;
    }

    public String getTime() {
        return this.e;
    }

    public float getWait() {
        return this.h;
    }

    public boolean isEnd() {
        return this.g;
    }

    public boolean isStart() {
        return this.f;
    }

    public void setAdcode(String str) {
        this.d = str;
    }

    public void setID(String str) {
        this.a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public void setName(String str) {
        this.b = str;
    }

    public void setTime(String str) {
        this.e = str;
    }

    public void setWait(float f) {
        this.h = f;
    }

    public void setisEnd(boolean z) {
        this.g = z;
    }

    public void setisStart(boolean z) {
        this.f = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeBooleanArray(new boolean[]{this.f, this.g});
        parcel.writeFloat(this.h);
    }

    protected RailwayStationItem(Parcel parcel) {
        this.f = false;
        this.g = false;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.d = parcel.readString();
        this.e = parcel.readString();
        boolean[] zArr = new boolean[2];
        parcel.readBooleanArray(zArr);
        this.f = zArr[0];
        this.g = zArr[1];
        this.h = parcel.readFloat();
    }
}
