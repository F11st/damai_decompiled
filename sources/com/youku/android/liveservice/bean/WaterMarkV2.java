package com.youku.android.liveservice.bean;

import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class WaterMarkV2 implements Serializable {
    protected float alpha;
    protected int autoScale;
    protected List<displayDTOS> displayDTOS;
    protected int display_mode;
    protected int refCoord;
    protected float refWnd;
    protected float rsType;
    protected String rsUrl;
    protected String text;
    protected String textColor;
    protected float textSize;
    protected float type;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class displayDTOS implements Serializable {
        public float duration;
        public float height;
        public float posX;
        public float posY;
        public float start;
        public float width;

        public String toString() {
            return "displayDTOS{posY=" + this.posY + ", duration=" + this.duration + ", posX=" + this.posX + ", start=" + this.start + ", width=" + this.width + ", height=" + this.height + '}';
        }
    }

    public float getAlpha() {
        return this.alpha;
    }

    public int getAutoScale() {
        return this.autoScale;
    }

    public List<displayDTOS> getDisplayDTOS() {
        return this.displayDTOS;
    }

    public int getDisplay_mode() {
        return this.display_mode;
    }

    public int getRefCoord() {
        return this.refCoord;
    }

    public float getRefWnd() {
        return this.refWnd;
    }

    public float getRsType() {
        return this.rsType;
    }

    public String getRsUrl() {
        return this.rsUrl;
    }

    public String getText() {
        return this.text;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public float getType() {
        return this.type;
    }

    public void setAlpha(float f) {
        this.alpha = f;
    }

    public void setAutoScale(int i) {
        this.autoScale = i;
    }

    public void setDisplayDTOS(List<displayDTOS> list) {
        this.displayDTOS = list;
    }

    public void setDisplay_mode(int i) {
        this.display_mode = i;
    }

    public void setRefCoord(int i) {
        this.refCoord = i;
    }

    public void setRefWnd(float f) {
        this.refWnd = f;
    }

    public void setRsType(float f) {
        this.rsType = f;
    }

    public void setRsUrl(String str) {
        this.rsUrl = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTextColor(String str) {
        this.textColor = str;
    }

    public void setTextSize(float f) {
        this.textSize = f;
    }

    public void setType(float f) {
        this.type = f;
    }

    public String toString() {
        return "WaterMark{display_mode=" + this.display_mode + ", textSize=" + this.textSize + ", refCoord=" + this.refCoord + ", alpha=" + this.alpha + ", displayDTOS=" + this.displayDTOS + ", rsUrl='" + this.rsUrl + "', refWnd=" + this.refWnd + ", text='" + this.text + "', textColor='" + this.textColor + "', autoScale=" + this.autoScale + ", rsType=" + this.rsType + ", type=" + this.type + '}';
    }
}
