package cn.damai.uikit.banner.transformer;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class TabletTransformer extends ABaseTransformer {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final Matrix a = new Matrix();
    private static final Camera b = new Camera();
    private static final float[] c = new float[2];

    protected static final float g(float f, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-165742307")) {
            return ((Float) ipChange.ipc$dispatch("-165742307", new Object[]{Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})).floatValue();
        }
        Matrix matrix = a;
        matrix.reset();
        Camera camera = b;
        camera.save();
        camera.rotateY(Math.abs(f));
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate((-i) * 0.5f, (-i2) * 0.5f);
        float f2 = i;
        float f3 = i2;
        matrix.postTranslate(f2 * 0.5f, 0.5f * f3);
        float[] fArr = c;
        fArr[0] = f2;
        fArr[1] = f3;
        matrix.mapPoints(fArr);
        return (f2 - fArr[0]) * (f > 0.0f ? 1.0f : -1.0f);
    }

    @Override // cn.damai.uikit.banner.transformer.ABaseTransformer
    protected void f(View view, float f) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2064115380")) {
            ipChange.ipc$dispatch("-2064115380", new Object[]{this, view, Float.valueOf(f)});
            return;
        }
        float abs = (f < 0.0f ? 30.0f : -30.0f) * Math.abs(f);
        view.setTranslationX(g(abs, view.getWidth(), view.getHeight()));
        view.setPivotX(view.getWidth() * 0.5f);
        view.setPivotY(0.0f);
        view.setRotationY(abs);
    }
}
