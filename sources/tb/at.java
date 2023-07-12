package tb;

import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class at {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-40367738")) {
            ipChange.ipc$dispatch("-40367738", new Object[]{view});
        } else if (view == null) {
        } else {
            Paint paint = new Paint(5);
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            view.setLayerType(2, paint);
        }
    }
}
