package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class DistrictResult implements Parcelable {
    public Parcelable.Creator<DistrictResult> CREATOR;
    private DistrictSearchQuery a;
    private ArrayList<DistrictItem> b;
    private int c;
    private AMapException d;

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel) {
                return new DistrictResult(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i) {
                return a(i);
            }

            private static DistrictResult[] a(int i) {
                return new DistrictResult[i];
            }
        };
        this.a = districtSearchQuery;
        this.b = arrayList;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DistrictResult.class == obj.getClass()) {
            DistrictResult districtResult = (DistrictResult) obj;
            DistrictSearchQuery districtSearchQuery = this.a;
            if (districtSearchQuery == null) {
                if (districtResult.a != null) {
                    return false;
                }
            } else if (!districtSearchQuery.equals(districtResult.a)) {
                return false;
            }
            ArrayList<DistrictItem> arrayList = this.b;
            if (arrayList == null) {
                if (districtResult.b != null) {
                    return false;
                }
            } else if (!arrayList.equals(districtResult.b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final AMapException getAMapException() {
        return this.d;
    }

    public final ArrayList<DistrictItem> getDistrict() {
        return this.b;
    }

    public final int getPageCount() {
        return this.c;
    }

    public final DistrictSearchQuery getQuery() {
        return this.a;
    }

    public final int hashCode() {
        DistrictSearchQuery districtSearchQuery = this.a;
        int hashCode = ((districtSearchQuery == null ? 0 : districtSearchQuery.hashCode()) + 31) * 31;
        ArrayList<DistrictItem> arrayList = this.b;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setAMapException(AMapException aMapException) {
        this.d = aMapException;
    }

    public final void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.b = arrayList;
    }

    public final void setPageCount(int i) {
        this.c = i;
    }

    public final void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.a = districtSearchQuery;
    }

    public final String toString() {
        return "DistrictResult [mDisQuery=" + this.a + ", mDistricts=" + this.b + jn1.ARRAY_END_STR;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeTypedList(this.b);
    }

    public DistrictResult() {
        this.b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel) {
                return new DistrictResult(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i) {
                return a(i);
            }

            private static DistrictResult[] a(int i) {
                return new DistrictResult[i];
            }
        };
    }

    protected DistrictResult(Parcel parcel) {
        this.b = new ArrayList<>();
        this.CREATOR = new Parcelable.Creator<DistrictResult>() { // from class: com.amap.api.services.district.DistrictResult.1
            private static DistrictResult a(Parcel parcel2) {
                return new DistrictResult(parcel2);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult createFromParcel(Parcel parcel2) {
                return a(parcel2);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DistrictResult[] newArray(int i) {
                return a(i);
            }

            private static DistrictResult[] a(int i) {
                return new DistrictResult[i];
            }
        };
        this.a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }
}
