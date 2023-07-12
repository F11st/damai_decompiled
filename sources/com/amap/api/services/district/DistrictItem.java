package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() { // from class: com.amap.api.services.district.DistrictItem.1
        private static DistrictItem a(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistrictItem[] newArray(int i) {
            return a(i);
        }

        private static DistrictItem[] a(int i) {
            return new DistrictItem[i];
        }
    };
    private String a;
    private String b;
    private String c;
    private LatLonPoint d;
    private String e;
    private List<DistrictItem> f;
    private String[] g;

    public DistrictItem() {
        this.f = new ArrayList();
        this.g = new String[0];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String[] districtBoundary() {
        return this.g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DistrictItem.class == obj.getClass()) {
            DistrictItem districtItem = (DistrictItem) obj;
            String str = this.b;
            if (str == null) {
                if (districtItem.b != null) {
                    return false;
                }
            } else if (!str.equals(districtItem.b)) {
                return false;
            }
            LatLonPoint latLonPoint = this.d;
            if (latLonPoint == null) {
                if (districtItem.d != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(districtItem.d)) {
                return false;
            }
            String str2 = this.a;
            if (str2 == null) {
                if (districtItem.a != null) {
                    return false;
                }
            } else if (!str2.equals(districtItem.a)) {
                return false;
            }
            if (Arrays.equals(this.g, districtItem.g)) {
                List<DistrictItem> list = this.f;
                if (list == null) {
                    if (districtItem.f != null) {
                        return false;
                    }
                } else if (!list.equals(districtItem.f)) {
                    return false;
                }
                String str3 = this.e;
                if (str3 == null) {
                    if (districtItem.e != null) {
                        return false;
                    }
                } else if (!str3.equals(districtItem.e)) {
                    return false;
                }
                String str4 = this.c;
                if (str4 == null) {
                    if (districtItem.c != null) {
                        return false;
                    }
                } else if (!str4.equals(districtItem.c)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final String getAdcode() {
        return this.b;
    }

    public final LatLonPoint getCenter() {
        return this.d;
    }

    public final String getCitycode() {
        return this.a;
    }

    public final String getLevel() {
        return this.e;
    }

    public final String getName() {
        return this.c;
    }

    public final List<DistrictItem> getSubDistrict() {
        return this.f;
    }

    public final int hashCode() {
        String str = this.b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.d;
        int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
        String str2 = this.a;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Arrays.hashCode(this.g)) * 31;
        List<DistrictItem> list = this.f;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.e;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.c;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setAdcode(String str) {
        this.b = str;
    }

    public final void setCenter(LatLonPoint latLonPoint) {
        this.d = latLonPoint;
    }

    public final void setCitycode(String str) {
        this.a = str;
    }

    public final void setDistrictBoundary(String[] strArr) {
        this.g = strArr;
    }

    public final void setLevel(String str) {
        this.e = str;
    }

    public final void setName(String str) {
        this.c = str;
    }

    public final void setSubDistrict(ArrayList<DistrictItem> arrayList) {
        this.f = arrayList;
    }

    public final String toString() {
        return "DistrictItem [mCitycode=" + this.a + ", mAdcode=" + this.b + ", mName=" + this.c + ", mCenter=" + this.d + ", mLevel=" + this.e + ", mDistricts=" + this.f + jn1.ARRAY_END_STR;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.e);
        parcel.writeTypedList(this.f);
        parcel.writeInt(this.g.length);
        parcel.writeStringArray(this.g);
    }

    public DistrictItem(String str, String str2, String str3, LatLonPoint latLonPoint, String str4) {
        this.f = new ArrayList();
        this.g = new String[0];
        this.c = str;
        this.a = str2;
        this.b = str3;
        this.d = latLonPoint;
        this.e = str4;
    }

    public DistrictItem(Parcel parcel) {
        this.f = new ArrayList();
        this.g = new String[0];
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.e = parcel.readString();
        this.f = parcel.createTypedArrayList(CREATOR);
        String[] strArr = new String[parcel.readInt()];
        this.g = strArr;
        parcel.readStringArray(strArr);
    }
}
