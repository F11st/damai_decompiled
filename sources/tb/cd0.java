package tb;

import android.view.animation.Interpolator;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class cd0 implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f < 0.25f) {
            return (((float) Math.pow(f - 0.125d, 2.0d)) * (-38.4f)) + 0.6f;
        }
        double d = f;
        if (d < 0.5d || d >= 0.75d) {
            return 0.0f;
        }
        return (((float) Math.pow(d - 0.625d, 2.0d)) * (-19.2f)) + 0.3f;
    }
}
