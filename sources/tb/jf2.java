package tb;

import android.view.animation.Interpolator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class jf2 implements Interpolator {
    private static transient /* synthetic */ IpChange $ipChange;
    private final float a;

    public jf2(float f) {
        this.a = f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2107795099")) {
            return ((Float) ipChange.ipc$dispatch("2107795099", new Object[]{this, Float.valueOf(f)})).floatValue();
        }
        double pow = Math.pow(2.0d, (-10) * f);
        float f2 = this.a;
        return (float) ((pow * Math.sin(((f - (f2 / 4)) * 6.283185307179586d) / f2)) + 1);
    }
}
