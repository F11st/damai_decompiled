package tb;

import android.widget.ImageView;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class z52 {
    private float a;
    private float b;
    private float c = 1.0f;
    private float d = 1.0f;
    private float e = 1.0f;
    private boolean f;

    private final void h() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 1.0f;
        this.d = 1.0f;
        this.e = 1.0f;
        this.f = false;
    }

    public final float a() {
        return this.e;
    }

    public final boolean b() {
        return this.f;
    }

    public final float c() {
        return this.c;
    }

    public final float d() {
        return this.d;
    }

    public final float e() {
        return this.a;
    }

    public final float f() {
        return this.b;
    }

    public final void g(float f, float f2, float f3, float f4, @NotNull ImageView.ScaleType scaleType) {
        b41.j(scaleType, "scaleType");
        if (f == 0.0f || f2 == 0.0f || f3 == 0.0f || f4 == 0.0f) {
            return;
        }
        h();
        float f5 = (f - f3) / 2.0f;
        float f6 = (f2 - f4) / 2.0f;
        float f7 = f3 / f4;
        float f8 = f / f2;
        float f9 = f2 / f4;
        float f10 = f / f3;
        switch (y52.$EnumSwitchMapping$0[scaleType.ordinal()]) {
            case 1:
                this.a = f5;
                this.b = f6;
                return;
            case 2:
                if (f7 > f8) {
                    this.e = f9;
                    this.f = false;
                    this.c = f9;
                    this.d = f9;
                    this.a = (f - (f3 * f9)) / 2.0f;
                    return;
                }
                this.e = f10;
                this.f = true;
                this.c = f10;
                this.d = f10;
                this.b = (f2 - (f4 * f10)) / 2.0f;
                return;
            case 3:
                if (f3 < f && f4 < f2) {
                    this.a = f5;
                    this.b = f6;
                    return;
                } else if (f7 > f8) {
                    this.e = f10;
                    this.f = true;
                    this.c = f10;
                    this.d = f10;
                    this.b = (f2 - (f4 * f10)) / 2.0f;
                    return;
                } else {
                    this.e = f9;
                    this.f = false;
                    this.c = f9;
                    this.d = f9;
                    this.a = (f - (f3 * f9)) / 2.0f;
                    return;
                }
            case 4:
                if (f7 > f8) {
                    this.e = f10;
                    this.f = true;
                    this.c = f10;
                    this.d = f10;
                    this.b = (f2 - (f4 * f10)) / 2.0f;
                    return;
                }
                this.e = f9;
                this.f = false;
                this.c = f9;
                this.d = f9;
                this.a = (f - (f3 * f9)) / 2.0f;
                return;
            case 5:
                if (f7 > f8) {
                    this.e = f10;
                    this.f = true;
                    this.c = f10;
                    this.d = f10;
                    return;
                }
                this.e = f9;
                this.f = false;
                this.c = f9;
                this.d = f9;
                return;
            case 6:
                if (f7 > f8) {
                    this.e = f10;
                    this.f = true;
                    this.c = f10;
                    this.d = f10;
                    this.b = f2 - (f4 * f10);
                    return;
                }
                this.e = f9;
                this.f = false;
                this.c = f9;
                this.d = f9;
                this.a = f - (f3 * f9);
                return;
            case 7:
                this.e = Math.max(f10, f9);
                this.f = f10 > f9;
                this.c = f10;
                this.d = f9;
                return;
            default:
                this.e = f10;
                this.f = true;
                this.c = f10;
                this.d = f10;
                return;
        }
    }
}
