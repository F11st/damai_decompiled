package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DriveRoutePlanResult extends RoutePlanResult {
    public static final Parcelable.Creator<DriveRoutePlanResult> CREATOR = new Parcelable.Creator<DriveRoutePlanResult>() { // from class: com.amap.api.services.route.DriveRoutePlanResult.1
        private static DriveRoutePlanResult a(Parcel parcel) {
            return new DriveRoutePlanResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRoutePlanResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRoutePlanResult[] newArray(int i) {
            return a(i);
        }

        private static DriveRoutePlanResult[] a(int i) {
            return new DriveRoutePlanResult[i];
        }
    };
    private List<DrivePlanPath> a;
    private List<TimeInfo> b;
    private RouteSearch.DrivePlanQuery c;

    public DriveRoutePlanResult(Parcel parcel) {
        super(parcel);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.a = parcel.createTypedArrayList(DrivePlanPath.CREATOR);
        this.b = parcel.createTypedArrayList(TimeInfo.CREATOR);
        this.c = (RouteSearch.DrivePlanQuery) parcel.readParcelable(RouteSearch.DrivePlanQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivePlanPath> getPaths() {
        return this.a;
    }

    public List<TimeInfo> getTimeInfos() {
        return this.b;
    }

    public void setDrivePlanQuery(RouteSearch.DrivePlanQuery drivePlanQuery) {
        this.c = drivePlanQuery;
        RouteSearch.FromAndTo fromAndTo = drivePlanQuery.getFromAndTo();
        if (fromAndTo != null) {
            setStartPos(fromAndTo.getFrom());
            setTargetPos(fromAndTo.getTo());
        }
    }

    public void setPaths(List<DrivePlanPath> list) {
        this.a = list;
    }

    public void setTimeInfos(List<TimeInfo> list) {
        this.b = list;
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
        parcel.writeTypedList(this.b);
        parcel.writeParcelable(this.c, i);
    }

    public DriveRoutePlanResult() {
        this.a = new ArrayList();
        this.b = new ArrayList();
    }
}
