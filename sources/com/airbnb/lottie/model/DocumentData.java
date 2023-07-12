package com.airbnb.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes17.dex */
public class DocumentData {
    public final String a;
    public final String b;
    public final float c;
    public final Justification d;
    public final int e;
    public final float f;
    public final float g;
    @ColorInt
    public final int h;
    @ColorInt
    public final int i;
    public final float j;
    public final boolean k;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f, Justification justification, int i, float f2, float f3, @ColorInt int i2, @ColorInt int i3, float f4, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = f;
        this.d = justification;
        this.e = i;
        this.f = f2;
        this.g = f3;
        this.h = i2;
        this.i = i3;
        this.j = f4;
        this.k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c)) * 31) + this.d.ordinal()) * 31) + this.e;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.h;
    }
}
