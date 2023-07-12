package com.amap.api.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.CameraPosition;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class AMapOptionsCreator implements Parcelable.Creator<AMapOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public AMapOptions createFromParcel(Parcel parcel) {
        AMapOptions aMapOptions = new AMapOptions();
        aMapOptions.mapType(parcel.readInt());
        aMapOptions.camera((CameraPosition) parcel.readParcelable(CameraPosition.class.getClassLoader()));
        boolean[] createBooleanArray = parcel.createBooleanArray();
        if (createBooleanArray != null && createBooleanArray.length >= 6) {
            aMapOptions.rotateGesturesEnabled(createBooleanArray[0]);
            aMapOptions.scrollGesturesEnabled(createBooleanArray[1]);
            aMapOptions.tiltGesturesEnabled(createBooleanArray[2]);
            aMapOptions.zoomGesturesEnabled(createBooleanArray[3]);
            aMapOptions.zoomControlsEnabled(createBooleanArray[4]);
            aMapOptions.zOrderOnTop(createBooleanArray[5]);
            aMapOptions.compassEnabled(createBooleanArray[6]);
            aMapOptions.scaleControlsEnabled(createBooleanArray[7]);
        }
        return aMapOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public AMapOptions[] newArray(int i) {
        return new AMapOptions[i];
    }
}
