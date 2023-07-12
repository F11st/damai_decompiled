package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.analytics.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class DimensionSet implements Parcelable {
    public static final Parcelable.Creator<DimensionSet> CREATOR = new Parcelable.Creator<DimensionSet>() { // from class: com.alibaba.mtl.appmonitor.model.DimensionSet.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DimensionSet createFromParcel(Parcel parcel) {
            return DimensionSet.readFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DimensionSet[] newArray(int i) {
            return new DimensionSet[i];
        }
    };
    private static final int INIT_SIZE = 3;
    private static final String TAG = "DimensionSet";
    private List<Dimension> dimensions = new ArrayList(3);

    private DimensionSet() {
    }

    public static DimensionSet create() {
        return new DimensionSet();
    }

    static DimensionSet readFromParcel(Parcel parcel) {
        DimensionSet create = create();
        try {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(DimensionSet.class.getClassLoader());
            if (readParcelableArray != null) {
                if (create.dimensions == null) {
                    create.dimensions = new ArrayList();
                }
                for (int i = 0; i < readParcelableArray.length; i++) {
                    if (readParcelableArray[i] == null || !(readParcelableArray[i] instanceof Dimension)) {
                        Logger.f(TAG, "parcelables[i]:", readParcelableArray[i]);
                    } else {
                        create.dimensions.add((Dimension) readParcelableArray[i]);
                    }
                }
            }
        } catch (Throwable th) {
            Logger.v(TAG, "[readFromParcel]", th);
        }
        return create;
    }

    public DimensionSet addDimension(Dimension dimension) {
        if (this.dimensions.contains(dimension)) {
            return this;
        }
        this.dimensions.add(dimension);
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Dimension getDimension(String str) {
        for (Dimension dimension : this.dimensions) {
            if (dimension.getName().equals(str)) {
                return dimension;
            }
        }
        return null;
    }

    public List<Dimension> getDimensions() {
        return this.dimensions;
    }

    public void setConstantValue(DimensionValueSet dimensionValueSet) {
        List<Dimension> list = this.dimensions;
        if (list == null || dimensionValueSet == null) {
            return;
        }
        for (Dimension dimension : list) {
            if (dimension.getConstantValue() != null && dimensionValueSet.getValue(dimension.getName()) == null) {
                dimensionValueSet.setValue(dimension.getName(), dimension.getConstantValue());
            }
        }
    }

    public boolean valid(DimensionValueSet dimensionValueSet) {
        List<Dimension> list = this.dimensions;
        if (list != null) {
            if (dimensionValueSet != null) {
                for (Dimension dimension : list) {
                    if (!dimensionValueSet.containValue(dimension.getName())) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        List<Dimension> list = this.dimensions;
        if (list != null) {
            try {
                Object[] array = list.toArray();
                Dimension[] dimensionArr = null;
                if (array != null) {
                    dimensionArr = new Dimension[array.length];
                    for (int i2 = 0; i2 < array.length; i2++) {
                        dimensionArr[i2] = (Dimension) array[i2];
                    }
                }
                parcel.writeParcelableArray(dimensionArr, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static DimensionSet create(Collection<String> collection) {
        DimensionSet dimensionSet = new DimensionSet();
        if (collection != null) {
            for (String str : collection) {
                dimensionSet.addDimension(new Dimension(str));
            }
        }
        return dimensionSet;
    }

    public DimensionSet addDimension(String str) {
        return addDimension(new Dimension(str));
    }

    public static DimensionSet create(String[] strArr) {
        DimensionSet dimensionSet = new DimensionSet();
        if (strArr != null) {
            for (String str : strArr) {
                dimensionSet.addDimension(new Dimension(str));
            }
        }
        return dimensionSet;
    }

    public DimensionSet addDimension(String str, String str2) {
        return addDimension(new Dimension(str, str2));
    }
}
