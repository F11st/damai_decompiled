package com.amap.api.services.busline;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class BusLineQuery implements Cloneable {
    private String a;
    private String b;
    private SearchType e;
    private int c = 20;
    private int d = 1;
    private String f = "base";

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public BusLineQuery(String str, SearchType searchType, String str2) {
        this.a = str;
        this.e = searchType;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BusLineQuery busLineQuery = (BusLineQuery) obj;
            if (this.e != busLineQuery.e) {
                return false;
            }
            String str = this.b;
            if (str == null) {
                if (busLineQuery.b != null) {
                    return false;
                }
            } else if (!str.equals(busLineQuery.b)) {
                return false;
            }
            if (this.d == busLineQuery.d && this.c == busLineQuery.c) {
                String str2 = this.a;
                if (str2 == null) {
                    if (busLineQuery.a != null) {
                        return false;
                    }
                } else if (!str2.equals(busLineQuery.a)) {
                    return false;
                }
                String str3 = this.f;
                if (str3 == null) {
                    if (busLineQuery.f != null) {
                        return false;
                    }
                } else if (!str3.equals(busLineQuery.f)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public SearchType getCategory() {
        return this.e;
    }

    public String getCity() {
        return this.b;
    }

    public String getExtensions() {
        return this.f;
    }

    public int getPageNumber() {
        return this.d;
    }

    public int getPageSize() {
        return this.c;
    }

    public String getQueryString() {
        return this.a;
    }

    public int hashCode() {
        SearchType searchType = this.e;
        int hashCode = ((searchType == null ? 0 : searchType.hashCode()) + 31) * 31;
        String str = this.b;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.d) * 31) + this.c) * 31;
        String str2 = this.a;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public void setCategory(SearchType searchType) {
        this.e = searchType;
    }

    public void setCity(String str) {
        this.b = str;
    }

    public void setExtensions(String str) {
        this.f = str;
    }

    public void setPageNumber(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.d = i;
    }

    public void setPageSize(int i) {
        this.c = i;
    }

    public void setQueryString(String str) {
        this.a = str;
    }

    public boolean weakEquals(BusLineQuery busLineQuery) {
        if (this == busLineQuery) {
            return true;
        }
        if (busLineQuery == null) {
            return false;
        }
        if (this.a == null) {
            if (busLineQuery.getQueryString() != null) {
                return false;
            }
        } else if (!busLineQuery.getQueryString().equals(this.a)) {
            return false;
        }
        if (this.b == null) {
            if (busLineQuery.getCity() != null) {
                return false;
            }
        } else if (!busLineQuery.getCity().equals(this.b)) {
            return false;
        }
        return this.c == busLineQuery.getPageSize() && busLineQuery.getCategory().compareTo(this.e) == 0;
    }

    /* renamed from: clone */
    public BusLineQuery m221clone() {
        BusLineQuery busLineQuery = new BusLineQuery(this.a, this.e, this.b);
        busLineQuery.setPageNumber(this.d);
        busLineQuery.setPageSize(this.c);
        busLineQuery.setExtensions(this.f);
        return busLineQuery;
    }
}
