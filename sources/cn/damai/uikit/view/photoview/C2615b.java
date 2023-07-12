package cn.damai.uikit.view.photoview;

import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: cn.damai.uikit.view.photoview.b */
/* loaded from: classes8.dex */
public class C2615b {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.uikit.view.photoview.b$a */
    /* loaded from: classes8.dex */
    static /* synthetic */ class C2616a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(float f, float f2, float f3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1617152401")) {
            ipChange.ipc$dispatch("1617152401", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)});
        } else if (f >= f2) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        } else {
            if (f2 >= f3) {
                throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-646963896") ? ((Integer) ipChange.ipc$dispatch("-646963896", new Object[]{Integer.valueOf(i)})).intValue() : (i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(ImageView imageView) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1442848641") ? ((Boolean) ipChange.ipc$dispatch("-1442848641", new Object[]{imageView})).booleanValue() : imageView.getDrawable() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(ImageView.ScaleType scaleType) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1869310321")) {
            return ((Boolean) ipChange.ipc$dispatch("-1869310321", new Object[]{scaleType})).booleanValue();
        }
        if (scaleType == null) {
            return false;
        }
        if (C2616a.a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
