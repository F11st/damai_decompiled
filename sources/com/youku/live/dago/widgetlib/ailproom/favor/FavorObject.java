package com.youku.live.dago.widgetlib.ailproom.favor;

import android.graphics.drawable.Drawable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class FavorObject {
    private static transient /* synthetic */ IpChange $ipChange;
    private float alpha;
    private Drawable drawable;
    private float scaleX;
    private float scaleY;
    private float x;
    private float y;

    public float getAlpha() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2031062550") ? ((Float) ipChange.ipc$dispatch("-2031062550", new Object[]{this})).floatValue() : this.alpha;
    }

    public Drawable getDrawable() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-934386010") ? (Drawable) ipChange.ipc$dispatch("-934386010", new Object[]{this}) : this.drawable;
    }

    public float getScaleX() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "178722836") ? ((Float) ipChange.ipc$dispatch("178722836", new Object[]{this})).floatValue() : this.scaleX;
    }

    public float getScaleY() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "178752627") ? ((Float) ipChange.ipc$dispatch("178752627", new Object[]{this})).floatValue() : this.scaleY;
    }

    public float getX() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1422745104") ? ((Float) ipChange.ipc$dispatch("1422745104", new Object[]{this})).floatValue() : this.x;
    }

    public float getY() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1422774895") ? ((Float) ipChange.ipc$dispatch("1422774895", new Object[]{this})).floatValue() : this.y;
    }

    public void setAlpha(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1284377222")) {
            ipChange.ipc$dispatch("-1284377222", new Object[]{this, Float.valueOf(f)});
        } else {
            this.alpha = f;
        }
    }

    public void setDrawable(Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1043706580")) {
            ipChange.ipc$dispatch("-1043706580", new Object[]{this, drawable});
        } else {
            this.drawable = drawable;
        }
    }

    public void setScaleX(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2019598888")) {
            ipChange.ipc$dispatch("2019598888", new Object[]{this, Float.valueOf(f)});
        } else {
            this.scaleX = f;
        }
    }

    public void setScaleY(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2020522409")) {
            ipChange.ipc$dispatch("2020522409", new Object[]{this, Float.valueOf(f)});
        } else {
            this.scaleY = f;
        }
    }

    public void setX(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "594339860")) {
            ipChange.ipc$dispatch("594339860", new Object[]{this, Float.valueOf(f)});
        } else {
            this.x = f;
        }
    }

    public void setY(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "595263381")) {
            ipChange.ipc$dispatch("595263381", new Object[]{this, Float.valueOf(f)});
        } else {
            this.y = f;
        }
    }
}
