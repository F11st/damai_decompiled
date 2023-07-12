package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.road.Road;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class RegeocodeAddress implements Parcelable {
    public static final Parcelable.Creator<RegeocodeAddress> CREATOR = new Parcelable.Creator<RegeocodeAddress>() { // from class: com.amap.api.services.geocoder.RegeocodeAddress.1
        private static RegeocodeAddress a(Parcel parcel) {
            return new RegeocodeAddress(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RegeocodeAddress createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RegeocodeAddress[] newArray(int i) {
            return null;
        }
    };
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private StreetNumber h;
    private String i;
    private String j;
    private String k;
    private List<RegeocodeRoad> l;
    private List<Crossroad> m;
    private List<PoiItem> n;
    private List<BusinessArea> o;
    private List<AoiItem> p;
    private String q;
    private String r;

    /* synthetic */ RegeocodeAddress(Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getAdCode() {
        return this.j;
    }

    public final List<AoiItem> getAois() {
        return this.p;
    }

    public final String getBuilding() {
        return this.g;
    }

    public final List<BusinessArea> getBusinessAreas() {
        return this.o;
    }

    public final String getCity() {
        return this.c;
    }

    public final String getCityCode() {
        return this.i;
    }

    public final String getCountry() {
        return this.q;
    }

    public final String getCountryCode() {
        return this.r;
    }

    public final List<Crossroad> getCrossroads() {
        return this.m;
    }

    public final String getDistrict() {
        return this.d;
    }

    public final String getFormatAddress() {
        return this.a;
    }

    public final String getNeighborhood() {
        return this.f;
    }

    public final List<PoiItem> getPois() {
        return this.n;
    }

    public final String getProvince() {
        return this.b;
    }

    public final List<RegeocodeRoad> getRoads() {
        return this.l;
    }

    public final StreetNumber getStreetNumber() {
        return this.h;
    }

    public final String getTowncode() {
        return this.k;
    }

    public final String getTownship() {
        return this.e;
    }

    public final void setAdCode(String str) {
        this.j = str;
    }

    public final void setAois(List<AoiItem> list) {
        this.p = list;
    }

    public final void setBuilding(String str) {
        this.g = str;
    }

    public final void setBusinessAreas(List<BusinessArea> list) {
        this.o = list;
    }

    public final void setCity(String str) {
        this.c = str;
    }

    public final void setCityCode(String str) {
        this.i = str;
    }

    public final void setCountry(String str) {
        this.q = str;
    }

    public final void setCountryCode(String str) {
        this.r = str;
    }

    public final void setCrossroads(List<Crossroad> list) {
        this.m = list;
    }

    public final void setDistrict(String str) {
        this.d = str;
    }

    public final void setFormatAddress(String str) {
        this.a = str;
    }

    public final void setNeighborhood(String str) {
        this.f = str;
    }

    public final void setPois(List<PoiItem> list) {
        this.n = list;
    }

    public final void setProvince(String str) {
        this.b = str;
    }

    public final void setRoads(List<RegeocodeRoad> list) {
        this.l = list;
    }

    public final void setStreetNumber(StreetNumber streetNumber) {
        this.h = streetNumber;
    }

    public final void setTowncode(String str) {
        this.k = str;
    }

    public final void setTownship(String str) {
        this.e = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeValue(this.h);
        parcel.writeList(this.l);
        parcel.writeList(this.m);
        parcel.writeList(this.n);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeList(this.o);
        parcel.writeList(this.p);
        parcel.writeString(this.k);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
    }

    public RegeocodeAddress() {
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
    }

    private RegeocodeAddress(Parcel parcel) {
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = (StreetNumber) parcel.readValue(StreetNumber.class.getClassLoader());
        this.l = parcel.readArrayList(Road.class.getClassLoader());
        this.m = parcel.readArrayList(Crossroad.class.getClassLoader());
        this.n = parcel.readArrayList(PoiItem.class.getClassLoader());
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.o = parcel.readArrayList(BusinessArea.class.getClassLoader());
        this.p = parcel.readArrayList(AoiItem.class.getClassLoader());
        this.k = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
    }
}
