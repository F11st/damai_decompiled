package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.appmonitor.pool.Reusable;
import com.alibaba.appmonitor.pool.a;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class DimensionValueSet implements Parcelable, Reusable {
    public static final Parcelable.Creator<DimensionValueSet> CREATOR = new Parcelable.Creator<DimensionValueSet>() { // from class: com.alibaba.mtl.appmonitor.model.DimensionValueSet.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DimensionValueSet createFromParcel(Parcel parcel) {
            return DimensionValueSet.readFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DimensionValueSet[] newArray(int i) {
            return new DimensionValueSet[i];
        }
    };
    protected Map<String, String> map;

    @Deprecated
    public DimensionValueSet() {
        if (this.map == null) {
            this.map = new LinkedHashMap();
        }
    }

    public static DimensionValueSet create() {
        return (DimensionValueSet) a.a().poll(DimensionValueSet.class, new Object[0]);
    }

    public static DimensionValueSet fromStringMap(Map<String, String> map) {
        DimensionValueSet dimensionValueSet = (DimensionValueSet) a.a().poll(DimensionValueSet.class, new Object[0]);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            dimensionValueSet.map.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : "null");
        }
        return dimensionValueSet;
    }

    static DimensionValueSet readFromParcel(Parcel parcel) {
        DimensionValueSet dimensionValueSet;
        try {
            dimensionValueSet = create();
        } catch (Throwable th) {
            th = th;
            dimensionValueSet = null;
        }
        try {
            dimensionValueSet.map = parcel.readHashMap(DimensionValueSet.class.getClassLoader());
        } catch (Throwable th2) {
            th = th2;
            th.printStackTrace();
            return dimensionValueSet;
        }
        return dimensionValueSet;
    }

    public DimensionValueSet addValues(DimensionValueSet dimensionValueSet) {
        Map<String, String> map;
        if (dimensionValueSet != null && (map = dimensionValueSet.getMap()) != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.map.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : "null");
            }
        }
        return this;
    }

    public void clean() {
        this.map.clear();
    }

    public boolean containValue(String str) {
        return this.map.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DimensionValueSet dimensionValueSet = (DimensionValueSet) obj;
            Map<String, String> map = this.map;
            if (map == null) {
                if (dimensionValueSet.map != null) {
                    return false;
                }
            } else if (!map.equals(dimensionValueSet.map)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void fill(Object... objArr) {
        if (this.map == null) {
            this.map = new LinkedHashMap();
        }
    }

    public Map<String, String> getMap() {
        return this.map;
    }

    public String getValue(String str) {
        return this.map.get(str);
    }

    public int hashCode() {
        Map<String, String> map = this.map;
        return 31 + (map == null ? 0 : map.hashCode());
    }

    public void setMap(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.map.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : "null");
        }
    }

    public DimensionValueSet setValue(String str, String str2) {
        Map<String, String> map = this.map;
        if (str2 == null) {
            str2 = "null";
        }
        map.put(str, str2);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.map);
    }

    @Deprecated
    public static DimensionValueSet create(int i) {
        return (DimensionValueSet) a.a().poll(DimensionValueSet.class, new Object[0]);
    }
}
