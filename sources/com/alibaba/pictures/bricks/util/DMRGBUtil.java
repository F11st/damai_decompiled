package com.alibaba.pictures.bricks.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.extension.UCCore;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Objects;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.in2;
import tb.pu1;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class DMRGBUtil {
    private static transient /* synthetic */ IpChange $ipChange;
    private static HashMap<String, Integer> b = new HashMap<>();
    private static HandlerC3548a a = new HandlerC3548a();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnFetchColorListener {
        void onFetchColor(int i);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.util.DMRGBUtil$a */
    /* loaded from: classes7.dex */
    public static class HandlerC3548a extends Handler {
        public HandlerC3548a() {
            super(Looper.getMainLooper());
        }
    }

    public static String c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1574582791")) {
            return (String) ipChange.ipc$dispatch("1574582791", new Object[]{str});
        }
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException unused) {
        }
        byte[] digest = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            if (Integer.toHexString(digest[i] & 255).length() == 1) {
                stringBuffer.append("0");
                stringBuffer.append(Integer.toHexString(digest[i] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(digest[i] & 255));
            }
        }
        return stringBuffer.toString();
    }

    private static int d(@FloatRange(from = 0.0d, to = 1.0d) float f, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1980302929")) {
            return ((Integer) ipChange.ipc$dispatch("1980302929", new Object[]{Float.valueOf(f), Integer.valueOf(i)})).intValue();
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
        if (AndroidInstantRuntime.support(ipChange, "683478140")) {
            return ((Integer) ipChange.ipc$dispatch("683478140", new Object[]{Float.valueOf(f), bitmap})).intValue();
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

    public static void f(@FloatRange(from = 0.0d, to = 1.0d) final float f, final Bitmap bitmap, @NonNull final String str, final OnFetchColorListener onFetchColorListener) {
        Integer num;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "813489963")) {
            ipChange.ipc$dispatch("813489963", new Object[]{Float.valueOf(f), bitmap, str, onFetchColorListener});
            return;
        }
        Objects.requireNonNull(bitmap, "DMRGBUtil >>>> bitmap is null");
        Objects.requireNonNull(onFetchColorListener, "DMRGBUtil >>>> OnFetchColorListener is null");
        if (!TextUtils.isEmpty(str) && (num = b.get(c(str))) != null && num.intValue() != 0) {
            onFetchColorListener.onFetchColor(num.intValue());
            Log.d("TASK_FETCH_IMAGE_ALL_PIXEL_AVERAGE_COLOR", "cache color");
            return;
        }
        pu1.a(new PriorityTask("TASK_FETCH_IMAGE_ALL_PIXEL_AVERAGE_COLOR", null) { // from class: com.alibaba.pictures.bricks.util.DMRGBUtil.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.alibaba.pictures.bricks.util.PriorityTask
            public void doTask() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1142289135")) {
                    ipChange2.ipc$dispatch("1142289135", new Object[]{this});
                    return;
                }
                final int e = DMRGBUtil.e(f, bitmap);
                if (!TextUtils.isEmpty(str)) {
                    DMRGBUtil.b.put(DMRGBUtil.c(str), Integer.valueOf(e));
                }
                DMRGBUtil.a.post(new Runnable() { // from class: com.alibaba.pictures.bricks.util.DMRGBUtil.1.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange3 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange3, "-1020839245")) {
                            ipChange3.ipc$dispatch("-1020839245", new Object[]{this});
                            return;
                        }
                        onFetchColorListener.onFetchColor(e);
                        Log.d("TASK_FETCH_IMAGE_ALL_PIXEL_AVERAGE_COLOR", "fetch color");
                    }
                });
            }
        });
    }

    public static void g(Bitmap bitmap, @NonNull String str, OnFetchColorListener onFetchColorListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1251926335")) {
            ipChange.ipc$dispatch("-1251926335", new Object[]{bitmap, str, onFetchColorListener});
        } else {
            f(1.0f, bitmap, str, onFetchColorListener);
        }
    }
}
