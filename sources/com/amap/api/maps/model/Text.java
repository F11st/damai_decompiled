package com.amap.api.maps.model;

import android.graphics.Typeface;
import com.autonavi.amap.mapcore.interfaces.IText;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class Text {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;
    private IText textDelegate;

    public Text(IText iText) {
        this.textDelegate = iText;
    }

    public void destroy() {
        try {
            IText iText = this.textDelegate;
            if (iText != null) {
                iText.destroy(true);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof Text) {
                return this.textDelegate.equalsRemote(((Text) obj).textDelegate);
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public int getAlignX() {
        try {
            return this.textDelegate.getAlignX();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getAlignY() {
        try {
            return this.textDelegate.getAlignY();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getBackgroundColor() {
        try {
            return this.textDelegate.getBackgroundColor();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getFontColor() {
        try {
            return this.textDelegate.getFontColor();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getFontSize() {
        try {
            return this.textDelegate.getFontSize();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public String getId() {
        try {
            return this.textDelegate.getId();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Object getObject() {
        return this.textDelegate.getObject();
    }

    public LatLng getPosition() {
        try {
            return this.textDelegate.getPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getRotate() {
        return this.textDelegate.getRotateAngle();
    }

    public String getText() {
        try {
            return this.textDelegate.getText();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public Typeface getTypeface() {
        try {
            return this.textDelegate.getTypeface();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getZIndex() {
        return this.textDelegate.getZIndex();
    }

    public int hashCode() {
        return this.textDelegate.hashCodeRemote();
    }

    public boolean isVisible() {
        try {
            return this.textDelegate.isVisible();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            this.textDelegate.remove();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAlign(int i, int i2) {
        try {
            this.textDelegate.setAlign(i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setBackgroundColor(int i) {
        try {
            this.textDelegate.setBackgroundColor(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setFontColor(int i) {
        try {
            this.textDelegate.setFontColor(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setFontSize(int i) {
        try {
            this.textDelegate.setFontSize(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setObject(Object obj) {
        this.textDelegate.setObject(obj);
    }

    public void setPosition(LatLng latLng) {
        try {
            this.textDelegate.setPosition(latLng);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setRotate(float f) {
        try {
            this.textDelegate.setRotateAngle(f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setText(String str) {
        try {
            this.textDelegate.setText(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTypeface(Typeface typeface) {
        try {
            this.textDelegate.setTypeface(typeface);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            this.textDelegate.setVisible(z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f) {
        this.textDelegate.setZIndex(f);
    }
}
