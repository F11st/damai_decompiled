package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class CircleOptions extends BaseOptions implements Parcelable {
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
    String a;
    private LatLng point = null;
    private double radius = 0.0d;
    private float strokeWidth = 10.0f;
    private int strokeColor = -16777216;
    private int fillColor = 0;
    private float zIndex = 0.0f;
    private boolean isVisible = true;
    private final String type = "CircleOptions";
    private boolean isCenterUpdated = false;
    private boolean isRadiusUpdated = false;
    private boolean isHoleOptionsUpdated = false;
    private int dottedLineType = -1;
    private boolean isUsePolylineStroke = false;
    private List<BaseHoleOptions> holeOptions = new ArrayList();

    public CircleOptions addHoles(BaseHoleOptions... baseHoleOptionsArr) {
        if (baseHoleOptionsArr != null) {
            try {
                this.holeOptions.addAll(Arrays.asList(baseHoleOptionsArr));
                this.isHoleOptionsUpdated = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }

    public CircleOptions center(LatLng latLng) {
        this.point = latLng;
        this.isCenterUpdated = true;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int i) {
        this.fillColor = i;
        return this;
    }

    public LatLng getCenter() {
        return this.point;
    }

    public int getFillColor() {
        return this.fillColor;
    }

    public List<BaseHoleOptions> getHoleOptions() {
        return this.holeOptions;
    }

    public double getRadius() {
        return this.radius;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeDottedLineType() {
        return this.dottedLineType;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isUsePolylineStroke() {
        return this.isUsePolylineStroke;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public CircleOptions radius(double d) {
        this.radius = d;
        this.isRadiusUpdated = true;
        return this;
    }

    public CircleOptions setStrokeDottedLineType(int i) {
        this.dottedLineType = i;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.strokeWidth = f;
        return this;
    }

    public CircleOptions usePolylineStroke(boolean z) {
        this.isUsePolylineStroke = z;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.point.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.a);
        parcel.writeList(this.holeOptions);
        parcel.writeInt(this.dottedLineType);
        parcel.writeByte(this.isUsePolylineStroke ? (byte) 1 : (byte) 0);
    }

    public CircleOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }

    public CircleOptions addHoles(Iterable<BaseHoleOptions> iterable) {
        if (iterable != null) {
            try {
                for (BaseHoleOptions baseHoleOptions : iterable) {
                    this.holeOptions.add(baseHoleOptions);
                }
                this.isHoleOptionsUpdated = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return this;
    }
}
