package cn.damai.commonbusiness.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import cn.damai.common.util.PriorityTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;
import java.util.Objects;
import tb.cb1;
import tb.in2;
import tb.nu1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DMRGBUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static HashMap<String, Integer> b = new HashMap<>();
    private static HandlerC0944a a = new HandlerC0944a();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnFetchColorListener {
        void onFetchColor(int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.util.DMRGBUtil$a */
    /* loaded from: classes.dex */
    public static class HandlerC0944a extends Handler {
        public HandlerC0944a() {
            super(Looper.getMainLooper());
        }
    }

    public static int[] c(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1435906501")) {
            return (int[]) ipChange.ipc$dispatch("-1435906501", new Object[]{Integer.valueOf(i)});
        }
        switch (i) {
            case -16728729:
                return new int[]{-6688769, -5767232, -786514};
            case -12665043:
            case -8753409:
                return new int[]{-413697, -6638337, -6752257};
            case -46478:
                return new int[]{-17482, -29750, -4083969};
            case -31940:
                return new int[]{-68463, -23121, -26123};
            default:
                return new int[]{-413697, -6638337, -6752257};
        }
    }

    private static int d(@FloatRange(from = 0.0d, to = 1.0d) float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1402400342")) {
            return ((Integer) ipChange.ipc$dispatch("1402400342", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue();
        }
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        int round = Math.round(f * 255.0f);
        if (f4 <= 0.35d) {
            return Color.argb(round, Integer.valueOf("53", 16).intValue(), Integer.valueOf("63", 16).intValue(), Integer.valueOf("88", 16).intValue());
        }
        if (f3 <= 0.05d) {
            return Color.argb(round, Integer.valueOf("6E", 16).intValue(), Integer.valueOf("82", 16).intValue(), Integer.valueOf("AB", 16).intValue());
        }
        if (f2 <= 10.0f) {
            return Color.argb(round, Integer.valueOf("E6", 16).intValue(), Integer.valueOf("55", 16).intValue(), Integer.valueOf("49", 16).intValue());
        }
        if (f2 <= 30.0f) {
            return Color.argb(round, Integer.valueOf("E8", 16).intValue(), Integer.valueOf("79", 16).intValue(), Integer.valueOf("34", 16).intValue());
        }
        if (f2 <= 50.0f) {
            return Color.argb(round, Integer.valueOf("EE", 16).intValue(), Integer.valueOf("A4", 16).intValue(), Integer.valueOf("46", 16).intValue());
        }
        if (f2 <= 150.0f) {
            return Color.argb(round, Integer.valueOf("89", 16).intValue(), Integer.valueOf("B9", 16).intValue(), Integer.valueOf("59", 16).intValue());
        }
        if (f2 <= 180.0f) {
            return Color.argb(round, Integer.valueOf("4E", 16).intValue(), Integer.valueOf(UCCore.OPTION_HARDWARE_ACCELERATED, 16).intValue(), Integer.valueOf("98", 16).intValue());
        }
        if (f2 <= 200.0f) {
            return Color.argb(round, Integer.valueOf(in2.PERFORM_CANCEL, 16).intValue(), Integer.valueOf("AA", 16).intValue(), Integer.valueOf("C8", 16).intValue());
        }
        if (f2 <= 230.0f) {
            return Color.argb(round, Integer.valueOf("3F", 16).intValue(), Integer.valueOf("96", 16).intValue(), Integer.valueOf("D8", 16).intValue());
        }
        if (f2 <= 250.0f) {
            return Color.argb(round, Integer.valueOf("71", 16).intValue(), Integer.valueOf("76", 16).intValue(), Integer.valueOf("D4", 16).intValue());
        }
        if (f2 <= 280.0f) {
            return Color.argb(round, Integer.valueOf("96", 16).intValue(), Integer.valueOf("5B", 16).intValue(), Integer.valueOf("BD", 16).intValue());
        }
        if (f2 <= 340.0f) {
            return Color.argb(round, Integer.valueOf("DE", 16).intValue(), Integer.valueOf("3F", 16).intValue(), Integer.valueOf("64", 16).intValue());
        }
        return Color.argb(round, Integer.valueOf("E6", 16).intValue(), Integer.valueOf("55", 16).intValue(), Integer.valueOf("49", 16).intValue());
    }

    @Deprecated
    public static int e(@FloatRange(from = 0.0d, to = 1.0d) float f, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-905677439")) {
            return ((Integer) ipChange.ipc$dispatch("-905677439", new Object[]{Float.valueOf(f), bitmap})).intValue();
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            i2 += Color.red(iArr[i6]);
            i3 += Color.green(iArr[i6]);
            i4 += Color.blue(iArr[i6]);
            i5 += Color.alpha(iArr[i6]);
        }
        return d(f, Color.argb(i5 / i, i2 / i, i3 / i, i4 / i));
    }

    @Deprecated
    public static int f(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1107405569") ? ((Integer) ipChange.ipc$dispatch("1107405569", new Object[]{bitmap})).intValue() : e(1.0f, bitmap);
    }

    public static void g(@FloatRange(from = 0.0d, to = 1.0d) final float f, final Bitmap bitmap, @NonNull final String str, final OnFetchColorListener onFetchColorListener) {
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "392808011")) {
            ipChange.ipc$dispatch("392808011", new Object[]{Float.valueOf(f), bitmap, str, onFetchColorListener});
            return;
        }
        Objects.requireNonNull(bitmap, "DMRGBUtil >>>> bitmap is null");
        Objects.requireNonNull(onFetchColorListener, "DMRGBUtil >>>> OnFetchColorListener is null");
        if (!TextUtils.isEmpty(str) && (num = b.get(wh2.f(str))) != null && num.intValue() != 0) {
            onFetchColorListener.onFetchColor(num.intValue());
            cb1.b("TASK_FETCH_IMAGE_ALL_PIXEL_AVERAGE_COLOR", "cache color");
            return;
        }
        nu1.a(new PriorityTask("TASK_FETCH_IMAGE_ALL_PIXEL_AVERAGE_COLOR", null) { // from class: cn.damai.commonbusiness.util.DMRGBUtil.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.util.PriorityTask
            public void doTask() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "564386548")) {
                    ipChange2.ipc$dispatch("564386548", new Object[]{this});
                    return;
                }
                final int e = DMRGBUtil.e(f, bitmap);
                if (!TextUtils.isEmpty(str)) {
                    DMRGBUtil.b.put(wh2.f(str), Integer.valueOf(e));
                }
                DMRGBUtil.a.post(new Runnable() { // from class: cn.damai.commonbusiness.util.DMRGBUtil.1.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "1038728718")) {
                            ipChange3.ipc$dispatch("1038728718", new Object[]{this});
                            return;
                        }
                        onFetchColorListener.onFetchColor(e);
                        cb1.b("TASK_FETCH_IMAGE_ALL_PIXEL_AVERAGE_COLOR", "fetch color");
                    }
                });
            }
        });
    }

    public static void h(Bitmap bitmap, @NonNull String str, OnFetchColorListener onFetchColorListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-879304501")) {
            ipChange.ipc$dispatch("-879304501", new Object[]{bitmap, str, onFetchColorListener});
        } else {
            g(1.0f, bitmap, str, onFetchColorListener);
        }
    }

    public static int i(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-497855589")) {
            return ((Integer) ipChange.ipc$dispatch("-497855589", new Object[]{Integer.valueOf(i)})).intValue();
        }
        switch (i) {
            case -12609832:
            case -12539192:
                return -12665043;
            case -11621224:
            case -7751591:
                return -16728729;
            case -2211996:
            case -1682103:
                return -46478;
            case -1541836:
            case -1137594:
                return -31940;
            default:
                return -8753409;
        }
    }
}
