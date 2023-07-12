package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MarkerOptionsCreator implements Parcelable.Creator<MarkerOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public MarkerOptions createFromParcel(Parcel parcel) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position((LatLng) parcel.readParcelable(LatLng.class.getClassLoader()));
        markerOptions.title(parcel.readString());
        markerOptions.snippet(parcel.readString());
        markerOptions.anchor(parcel.readFloat(), parcel.readFloat());
        markerOptions.setInfoWindowOffset(parcel.readInt(), parcel.readInt());
        boolean[] zArr = new boolean[8];
        parcel.readBooleanArray(zArr);
        markerOptions.visible(zArr[0]);
        markerOptions.draggable(zArr[1]);
        markerOptions.setGps(zArr[2]);
        markerOptions.setFlat(zArr[3]);
        markerOptions.autoOverturnInfoWindow(zArr[4]);
        markerOptions.infoWindowEnable(zArr[5]);
        markerOptions.belowMaskLayer(zArr[6]);
        markerOptions.setRotatingMode(zArr[7]);
        markerOptions.a = parcel.readString();
        markerOptions.period(parcel.readInt());
        markerOptions.icons(parcel.readArrayList(BitmapDescriptor.class.getClassLoader()));
        markerOptions.zIndex(parcel.readFloat());
        markerOptions.alpha(parcel.readFloat());
        markerOptions.displayLevel(parcel.readInt());
        markerOptions.rotateAngle(parcel.readFloat());
        BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        if (bitmapDescriptor != null) {
            markerOptions.icon(bitmapDescriptor);
        }
        return markerOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public MarkerOptions[] newArray(int i) {
        return new MarkerOptions[i];
    }
}
