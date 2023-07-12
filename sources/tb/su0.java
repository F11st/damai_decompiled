package tb;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class su0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(ImageView imageView, GradientDrawable.Orientation orientation, float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1559969015")) {
            ipChange.ipc$dispatch("1559969015", new Object[]{imageView, orientation, Float.valueOf(f), Integer.valueOf(i)});
        } else {
            c(imageView, orientation, new float[]{f, f, f, f, f, f, f, f}, i);
        }
    }

    public static void b(ImageView imageView, GradientDrawable.Orientation orientation, float f, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1114964890")) {
            ipChange.ipc$dispatch("1114964890", new Object[]{imageView, orientation, Float.valueOf(f), iArr});
        } else {
            d(imageView, orientation, new float[]{f, f, f, f, f, f, f, f}, iArr);
        }
    }

    public static void c(ImageView imageView, GradientDrawable.Orientation orientation, float[] fArr, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1133733220")) {
            ipChange.ipc$dispatch("1133733220", new Object[]{imageView, orientation, fArr, Integer.valueOf(i)});
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i);
        gradientDrawable.setCornerRadii(fArr);
        imageView.setImageDrawable(gradientDrawable);
    }

    public static void d(ImageView imageView, GradientDrawable.Orientation orientation, float[] fArr, int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "786557133")) {
            ipChange.ipc$dispatch("786557133", new Object[]{imageView, orientation, fArr, iArr});
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(orientation, iArr);
        gradientDrawable.setCornerRadii(fArr);
        imageView.setImageDrawable(gradientDrawable);
    }
}
