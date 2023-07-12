package com.huawei.hms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes10.dex */
public class Feature extends AbstractSafeParcelable {
    public static final int ARGS_NAME = 1;
    public static final int ARGS_SVC_VER = 2;
    public static final int ARGS_VER = 3;
    public static final Parcelable.Creator<Feature> CREATOR = new FeatureCreator();
    private static final int SVC_VER = -1;
    private final long apiVersion;
    private final String name;
    @Deprecated
    private final int serviceVersion;

    public Feature(String str, long j) {
        this(str, -1, j);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            return this.name.equals(feature.getName()) && getVersion() == feature.getVersion();
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public long getVersion() {
        long j = this.apiVersion;
        return -1 == j ? this.serviceVersion : j;
    }

    public int hashCode() {
        return Objects.hashCode(getName(), Long.valueOf(getVersion()));
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", getName()).add("version", Long.valueOf(getVersion())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, this.serviceVersion);
        SafeParcelWriter.writeLong(parcel, 3, getVersion());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public Feature(String str, int i, long j) {
        this.name = str;
        this.serviceVersion = i;
        this.apiVersion = j;
    }
}
