package cn.damai.utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.FloatRange;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.extension.UCCore;
import java.util.HashMap;
import tb.db1;
import tb.in2;
import tb.uh2;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class RGBUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static HandlerC2781a a = new HandlerC2781a();
    private static HashMap<String, Integer> b = new HashMap<>();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.utils.RGBUtil$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final class AnonymousClass1 extends PriorityTask {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ float val$alpha;
        final /* synthetic */ Bitmap val$bitmap;
        final /* synthetic */ OnFetchColorListener val$fetchColorListener;
        final /* synthetic */ String val$flag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Object obj, float f, Bitmap bitmap, String str2, OnFetchColorListener onFetchColorListener) {
            super(str, obj);
            this.val$alpha = f;
            this.val$bitmap = bitmap;
            this.val$flag = str2;
            this.val$fetchColorListener = onFetchColorListener;
        }

        @Override // cn.damai.utils.PriorityTask
        public void doTask() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-300891864")) {
                ipChange.ipc$dispatch("-300891864", new Object[]{this});
                return;
            }
            final int d = RGBUtil.d(this.val$alpha, this.val$bitmap);
            if (!TextUtils.isEmpty(this.val$flag)) {
                RGBUtil.b.put(uh2.c(this.val$flag), Integer.valueOf(d));
            }
            RGBUtil.a.post(new Runnable() { // from class: cn.damai.utils.RGBUtil.1.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-236109478")) {
                        ipChange2.ipc$dispatch("-236109478", new Object[]{this});
                        return;
                    }
                    AnonymousClass1.this.val$fetchColorListener.onFetchColor(d);
                    db1.a("TASK_FETCH_IMAGE_ALL_PIXEL_AVERAGE_COLOR", "fetch color");
                }
            });
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnFetchColorListener {
        void onFetchColor(int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.utils.RGBUtil$a */
    /* loaded from: classes17.dex */
    public static class HandlerC2781a extends Handler {
        public HandlerC2781a() {
            super(Looper.getMainLooper());
        }
    }

    private static int c(@FloatRange(from = 0.0d, to = 1.0d) float f, int i) {
        int intValue;
        int intValue2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "537121930")) {
            return ((Integer) ipChange.ipc$dispatch("537121930", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue();
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
        String str = "49";
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
            intValue = Integer.valueOf("DE", 16).intValue();
            intValue2 = Integer.valueOf("3F", 16).intValue();
            str = "64";
        } else {
            intValue = Integer.valueOf("E6", 16).intValue();
            intValue2 = Integer.valueOf("55", 16).intValue();
        }
        return Color.argb(round, intValue, intValue2, Integer.valueOf(str, 16).intValue());
    }

    @Deprecated
    public static int d(@FloatRange(from = 0.0d, to = 1.0d) float f, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1366228917")) {
            return ((Integer) ipChange.ipc$dispatch("1366228917", new Object[]{Float.valueOf(f), bitmap})).intValue();
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
        return c(f, Color.argb(i5 / i, i2 / i, i3 / i, i4 / i));
    }

    @Deprecated
    public static int e(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-758969779") ? ((Integer) ipChange.ipc$dispatch("-758969779", new Object[]{bitmap})).intValue() : d(1.0f, bitmap);
    }
}
