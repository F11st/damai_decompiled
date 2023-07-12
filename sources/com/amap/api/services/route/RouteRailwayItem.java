package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class RouteRailwayItem extends Railway {
    public static final Parcelable.Creator<RouteRailwayItem> CREATOR = new Parcelable.Creator<RouteRailwayItem>() { // from class: com.amap.api.services.route.RouteRailwayItem.1
        private static RouteRailwayItem a(Parcel parcel) {
            return new RouteRailwayItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteRailwayItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteRailwayItem[] newArray(int i) {
            return a(i);
        }

        private static RouteRailwayItem[] a(int i) {
            return new RouteRailwayItem[i];
        }
    };
    private String a;
    private String b;
    private float c;
    private String d;
    private RailwayStationItem e;
    private RailwayStationItem f;
    private List<RailwayStationItem> g;
    private List<Railway> h;
    private List<RailwaySpace> i;

    public RouteRailwayItem() {
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Railway> getAlters() {
        return this.h;
    }

    public RailwayStationItem getArrivalstop() {
        return this.f;
    }

    public RailwayStationItem getDeparturestop() {
        return this.e;
    }

    public float getDistance() {
        return this.c;
    }

    public List<RailwaySpace> getSpaces() {
        return this.i;
    }

    public String getTime() {
        return this.a;
    }

    public String getTrip() {
        return this.b;
    }

    public String getType() {
        return this.d;
    }

    public List<RailwayStationItem> getViastops() {
        return this.g;
    }

    public void setAlters(List<Railway> list) {
        this.h = list;
    }

    public void setArrivalstop(RailwayStationItem railwayStationItem) {
        this.f = railwayStationItem;
    }

    public void setDeparturestop(RailwayStationItem railwayStationItem) {
        this.e = railwayStationItem;
    }

    public void setDistance(float f) {
        this.c = f;
    }

    public void setSpaces(List<RailwaySpace> list) {
        this.i = list;
    }

    public void setTime(String str) {
        this.a = str;
    }

    public void setTrip(String str) {
        this.b = str;
    }

    public void setType(String str) {
        this.d = str;
    }

    public void setViastops(List<RailwayStationItem> list) {
        this.g = list;
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeFloat(this.c);
        parcel.writeString(this.d);
        parcel.writeParcelable(this.e, i);
        parcel.writeParcelable(this.f, i);
        parcel.writeTypedList(this.g);
        parcel.writeTypedList(this.h);
        parcel.writeTypedList(this.i);
    }

    protected RouteRailwayItem(Parcel parcel) {
        super(parcel);
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readFloat();
        this.d = parcel.readString();
        this.e = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.g = parcel.createTypedArrayList(RailwayStationItem.CREATOR);
        this.h = parcel.createTypedArrayList(Railway.CREATOR);
        this.i = parcel.createTypedArrayList(RailwaySpace.CREATOR);
    }
}
