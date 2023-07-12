package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.appmonitor.pool.Reusable;
import com.alibaba.appmonitor.pool.a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class MeasureValueSet implements IMerge<MeasureValueSet>, Reusable, Parcelable {
    public static final Parcelable.Creator<MeasureValueSet> CREATOR = new Parcelable.Creator<MeasureValueSet>() { // from class: com.alibaba.mtl.appmonitor.model.MeasureValueSet.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MeasureValueSet createFromParcel(Parcel parcel) {
            return MeasureValueSet.readFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MeasureValueSet[] newArray(int i) {
            return new MeasureValueSet[i];
        }
    };
    private Map<String, MeasureValue> map = new LinkedHashMap();

    public static MeasureValueSet create() {
        return (MeasureValueSet) a.a().poll(MeasureValueSet.class, new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static MeasureValueSet fromStringMap(Map<String, String> map) {
        MeasureValueSet measureValueSet = (MeasureValueSet) a.a().poll(MeasureValueSet.class, new Object[0]);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Double d = toDouble(entry.getValue());
                if (d != null) {
                    measureValueSet.map.put(entry.getKey(), a.a().poll(MeasureValue.class, d));
                }
            }
        }
        return measureValueSet;
    }

    private Measure getMeasure(List<Measure> list, String str) {
        for (Measure measure : list) {
            if (str.equalsIgnoreCase(measure.getName())) {
                return measure;
            }
        }
        return null;
    }

    static MeasureValueSet readFromParcel(Parcel parcel) {
        try {
            MeasureValueSet create = create();
            try {
                create.map = parcel.readHashMap(DimensionValueSet.class.getClassLoader());
                return create;
            } catch (Throwable unused) {
                return create;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static Double toDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void clean() {
        for (MeasureValue measureValue : this.map.values()) {
            a.a().offer(measureValue);
        }
        this.map.clear();
    }

    public boolean containValue(String str) {
        return this.map.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.alibaba.appmonitor.pool.Reusable
    public void fill(Object... objArr) {
        if (this.map == null) {
            this.map = new LinkedHashMap();
        }
    }

    public Map<String, MeasureValue> getMap() {
        return this.map;
    }

    public MeasureValue getValue(String str) {
        return this.map.get(str);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public void setBuckets(List<Measure> list) {
        if (list == null) {
            return;
        }
        for (String str : this.map.keySet()) {
            this.map.get(str).setBuckets(getMeasure(list, str));
        }
    }

    public void setMap(Map<String, MeasureValue> map) {
        this.map = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MeasureValueSet setValue(String str, double d) {
        this.map.put(str, a.a().poll(MeasureValue.class, Double.valueOf(d)));
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.map);
    }

    @Deprecated
    public static MeasureValueSet create(int i) {
        return (MeasureValueSet) a.a().poll(MeasureValueSet.class, new Object[0]);
    }

    @Override // com.alibaba.mtl.appmonitor.model.IMerge
    public void merge(MeasureValueSet measureValueSet) {
        for (String str : this.map.keySet()) {
            this.map.get(str).merge(measureValueSet.getValue(str));
        }
    }

    public void setValue(String str, MeasureValue measureValue) {
        this.map.put(str, measureValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static MeasureValueSet create(Map<String, Double> map) {
        MeasureValueSet measureValueSet = (MeasureValueSet) a.a().poll(MeasureValueSet.class, new Object[0]);
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    Double d = map.get(str);
                    if (d != null) {
                        measureValueSet.map.put(str, a.a().poll(MeasureValue.class, d));
                    }
                }
            } catch (Exception unused) {
            }
        }
        return measureValueSet;
    }
}
