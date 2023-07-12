package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class TextOptions implements Parcelable {
    public static final TextOptionsCreator CREATOR = new TextOptionsCreator();
    String a;
    private Object object;
    private LatLng position;
    private float rotate;
    private String text;
    private Typeface typeface = Typeface.DEFAULT;
    private int alignX = 4;
    private int alignY = 32;
    private int backgroundColor = -1;
    private int fontColor = -16777216;
    private int fontSize = 20;
    private float zIndex = 0.0f;
    private boolean isVisible = true;

    public TextOptions align(int i, int i2) {
        this.alignX = i;
        this.alignY = i2;
        return this;
    }

    public TextOptions backgroundColor(int i) {
        this.backgroundColor = i;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TextOptions fontColor(int i) {
        this.fontColor = i;
        return this;
    }

    public TextOptions fontSize(int i) {
        this.fontSize = i;
        return this;
    }

    public int getAlignX() {
        return this.alignX;
    }

    public int getAlignY() {
        return this.alignY;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public int getFontColor() {
        return this.fontColor;
    }

    public int getFontSize() {
        return this.fontSize;
    }

    public Object getObject() {
        return this.object;
    }

    public LatLng getPosition() {
        return this.position;
    }

    public float getRotate() {
        return this.rotate;
    }

    public String getText() {
        return this.text;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public TextOptions position(LatLng latLng) {
        this.position = latLng;
        return this;
    }

    public TextOptions rotate(float f) {
        this.rotate = f;
        return this;
    }

    public TextOptions setObject(Object obj) {
        this.object = obj;
        return this;
    }

    public TextOptions text(String str) {
        this.text = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        if (typeface != null) {
            this.typeface = typeface;
        }
        return this;
    }

    public TextOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        Bundle bundle = new Bundle();
        LatLng latLng = this.position;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.position.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeString(this.text);
        parcel.writeInt(this.typeface.getStyle());
        parcel.writeFloat(this.rotate);
        parcel.writeInt(this.alignX);
        parcel.writeInt(this.alignY);
        parcel.writeInt(this.backgroundColor);
        parcel.writeInt(this.fontColor);
        parcel.writeInt(this.fontSize);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        if (this.object instanceof Parcelable) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("obj", (Parcelable) this.object);
            parcel.writeBundle(bundle2);
        }
    }

    public TextOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }
}
