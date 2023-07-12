package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class TruckRouteRestult implements Parcelable {
    public static final Parcelable.Creator<TruckRouteRestult> CREATOR = new Parcelable.Creator<TruckRouteRestult>() { // from class: com.amap.api.services.route.TruckRouteRestult.1
        private static TruckRouteRestult a(Parcel parcel) {
            return new TruckRouteRestult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckRouteRestult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckRouteRestult[] newArray(int i) {
            return a(i);
        }

        private static TruckRouteRestult[] a(int i) {
            return new TruckRouteRestult[i];
        }
    };
    private RouteSearch.TruckRouteQuery a;
    private List<TruckPath> b;
    private LatLonPoint c;
    private LatLonPoint d;

    public TruckRouteRestult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TruckPath> getPaths() {
        return this.b;
    }

    public LatLonPoint getStartPos() {
        return this.c;
    }

    public LatLonPoint getTargetPos() {
        return this.d;
    }

    public RouteSearch.TruckRouteQuery getTruckQuery() {
        return this.a;
    }

    public void setPaths(List<TruckPath> list) {
        this.b = list;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.c = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.d = latLonPoint;
    }

    public void setTruckQuery(RouteSearch.TruckRouteQuery truckRouteQuery) {
        this.a = truckRouteQuery;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
    }

    protected TruckRouteRestult(Parcel parcel) {
        this.b = parcel.createTypedArrayList(TruckPath.CREATOR);
        this.c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }
}
