package com.amap.api.services.route;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class Cost {
    private float a;
    private float b;
    private String c;
    private float d;
    private int e;

    public float getDuration() {
        return this.a;
    }

    public float getTollDistance() {
        return this.b;
    }

    public String getTollRoad() {
        return this.c;
    }

    public float getTolls() {
        return this.d;
    }

    public int getTrafficLights() {
        return this.e;
    }

    public void setDuration(float f) {
        this.a = f;
    }

    public void setTollDistance(float f) {
        this.b = f;
    }

    public void setTollRoad(String str) {
        this.c = str;
    }

    public void setTolls(float f) {
        this.d = f;
    }

    public void setTrafficLights(int i) {
        this.e = i;
    }
}
