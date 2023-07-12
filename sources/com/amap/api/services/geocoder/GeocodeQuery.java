package com.amap.api.services.geocoder;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class GeocodeQuery {
    private String a;
    private String b;
    private String c;

    public GeocodeQuery(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
            String str = this.b;
            if (str == null) {
                if (geocodeQuery.b != null) {
                    return false;
                }
            } else if (!str.equals(geocodeQuery.b)) {
                return false;
            }
            String str2 = this.a;
            if (str2 == null) {
                if (geocodeQuery.a != null) {
                    return false;
                }
            } else if (!str2.equals(geocodeQuery.a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public String getCity() {
        return this.b;
    }

    public String getCountry() {
        return this.c;
    }

    public String getLocationName() {
        return this.a;
    }

    public int hashCode() {
        String str = this.b;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.a;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public void setCity(String str) {
        this.b = str;
    }

    public void setCountry(String str) {
        this.c = str;
    }

    public void setLocationName(String str) {
        this.a = str;
    }
}
