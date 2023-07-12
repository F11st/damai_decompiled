package com.alibaba.aliweex.utils;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.reflect.Array;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class BlurTool {
    private static ExecutorService a = Executors.newCachedThreadPool(new a());

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnBlurCompleteListener {
        void onBlurComplete(@NonNull Bitmap bitmap);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    static class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "wx_blur_thread");
        }
    }

    public static void b(@NonNull final Bitmap bitmap, final int i, @Nullable final OnBlurCompleteListener onBlurCompleteListener) {
        a.execute(new Runnable() { // from class: com.alibaba.aliweex.utils.BlurTool.2
            @Override // java.lang.Runnable
            public void run() {
                if (OnBlurCompleteListener.this != null) {
                    try {
                        final Bitmap c = BlurTool.c(bitmap, i);
                        BlurTool.e(new Runnable() { // from class: com.alibaba.aliweex.utils.BlurTool.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                OnBlurCompleteListener.this.onBlurComplete(c);
                            }
                        });
                    } catch (Exception unused) {
                        BlurTool.e(new Runnable() { // from class: com.alibaba.aliweex.utils.BlurTool.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                OnBlurCompleteListener.this.onBlurComplete(bitmap);
                            }
                        });
                        WXLogUtils.e("blur failed,return original image.");
                    }
                }
            }
        });
    }

    @NonNull
    public static Bitmap c(@NonNull Bitmap bitmap, int i) {
        double d;
        double d2;
        Bitmap bitmap2;
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        int min = Math.min(10, Math.max(0, i));
        if (min == 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > 0 && height > 0) {
            double d3 = d(min);
            int i2 = 3;
            double d4 = width;
            double d5 = height;
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (d3 * d4), (int) (d3 * d5), true);
            int i3 = 0;
            int i4 = min;
            while (true) {
                Bitmap bitmap3 = createScaledBitmap;
                long j = currentTimeMillis;
                if (i3 >= i2) {
                    WXLogUtils.d("BlurTool", "elapsed time on blurring image(radius:" + i4 + ",sampling: " + d3 + "): " + (System.currentTimeMillis() - j) + "ms");
                    break;
                } else if (i4 == 0) {
                    return bitmap;
                } else {
                    try {
                        double d6 = d(i4);
                        if (d6 != d3) {
                            try {
                                bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) (d6 * d4), (int) (d6 * d5), true);
                                z = false;
                                d2 = d6;
                                d = d4;
                            } catch (Exception e) {
                                e = e;
                                createScaledBitmap = bitmap3;
                                d3 = d6;
                                d = d4;
                            }
                        } else {
                            d = d4;
                            d2 = d3;
                            bitmap2 = bitmap3;
                            z = false;
                        }
                        try {
                            Bitmap f = f(bitmap2, i4, z);
                            WXLogUtils.d("BlurTool", "elapsed time on blurring image(radius:" + i4 + ",sampling: " + d2 + "): " + (System.currentTimeMillis() - j) + "ms");
                            return f;
                        } catch (Exception e2) {
                            e = e2;
                            createScaledBitmap = bitmap2;
                            d3 = d2;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        d = d4;
                        createScaledBitmap = bitmap3;
                    }
                }
                WXLogUtils.e("BlurTool", "thrown exception when blurred image(times = " + i3 + ")," + e.getMessage());
                i4 = Math.max(0, i4 + (-1));
                i3++;
                currentTimeMillis = j;
                d4 = d;
                i2 = 3;
            }
        }
        return bitmap;
    }

    private static double d(int i) {
        if (i <= 3) {
            return 0.5d;
        }
        return i <= 8 ? 0.25d : 0.125d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(@NonNull Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public static Bitmap f(Bitmap bitmap, int i, boolean z) {
        int[] iArr;
        int i2 = i;
        Bitmap copy = z ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        if (i2 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2 + 1;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[i3];
        int[] iArr6 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr7 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr7[i10] = i10 / i8;
        }
        int[][] iArr8 = (int[][]) Array.newInstance(int.class, i6, 3);
        int i11 = i2 + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            Bitmap bitmap2 = copy;
            int i15 = height;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = -i2;
            int i25 = 0;
            while (i24 <= i2) {
                int i26 = i5;
                int[] iArr9 = iArr6;
                int i27 = iArr2[i13 + Math.min(i4, Math.max(i24, 0))];
                int[] iArr10 = iArr8[i24 + i2];
                iArr10[0] = (i27 & 16711680) >> 16;
                iArr10[1] = (i27 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i27 & 255;
                int abs = i11 - Math.abs(i24);
                i25 += iArr10[0] * abs;
                i16 += iArr10[1] * abs;
                i17 += iArr10[2] * abs;
                if (i24 > 0) {
                    i21 += iArr10[0];
                    i22 += iArr10[1];
                    i23 += iArr10[2];
                } else {
                    i18 += iArr10[0];
                    i19 += iArr10[1];
                    i20 += iArr10[2];
                }
                i24++;
                i5 = i26;
                iArr6 = iArr9;
            }
            int i28 = i5;
            int[] iArr11 = iArr6;
            int i29 = i2;
            int i30 = i25;
            int i31 = 0;
            while (i31 < width) {
                iArr3[i13] = iArr7[i30];
                iArr4[i13] = iArr7[i16];
                iArr5[i13] = iArr7[i17];
                int i32 = i30 - i18;
                int i33 = i16 - i19;
                int i34 = i17 - i20;
                int[] iArr12 = iArr8[((i29 - i2) + i6) % i6];
                int i35 = i18 - iArr12[0];
                int i36 = i19 - iArr12[1];
                int i37 = i20 - iArr12[2];
                if (i12 == 0) {
                    iArr = iArr7;
                    iArr11[i31] = Math.min(i31 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i38 = iArr2[i14 + iArr11[i31]];
                iArr12[0] = (i38 & 16711680) >> 16;
                iArr12[1] = (i38 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr12[2] = i38 & 255;
                int i39 = i21 + iArr12[0];
                int i40 = i22 + iArr12[1];
                int i41 = i23 + iArr12[2];
                i30 = i32 + i39;
                i16 = i33 + i40;
                i17 = i34 + i41;
                i29 = (i29 + 1) % i6;
                int[] iArr13 = iArr8[i29 % i6];
                i18 = i35 + iArr13[0];
                i19 = i36 + iArr13[1];
                i20 = i37 + iArr13[2];
                i21 = i39 - iArr13[0];
                i22 = i40 - iArr13[1];
                i23 = i41 - iArr13[2];
                i13++;
                i31++;
                iArr7 = iArr;
            }
            i14 += width;
            i12++;
            copy = bitmap2;
            height = i15;
            i5 = i28;
            iArr6 = iArr11;
        }
        Bitmap bitmap3 = copy;
        int i42 = i5;
        int[] iArr14 = iArr6;
        int i43 = height;
        int[] iArr15 = iArr7;
        int i44 = 0;
        while (i44 < width) {
            int i45 = -i2;
            int i46 = i6;
            int[] iArr16 = iArr2;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = i45;
            int i55 = i45 * width;
            int i56 = 0;
            int i57 = 0;
            while (i54 <= i2) {
                int i58 = width;
                int max = Math.max(0, i55) + i44;
                int[] iArr17 = iArr8[i54 + i2];
                iArr17[0] = iArr3[max];
                iArr17[1] = iArr4[max];
                iArr17[2] = iArr5[max];
                int abs2 = i11 - Math.abs(i54);
                i56 += iArr3[max] * abs2;
                i57 += iArr4[max] * abs2;
                i47 += iArr5[max] * abs2;
                if (i54 > 0) {
                    i51 += iArr17[0];
                    i52 += iArr17[1];
                    i53 += iArr17[2];
                } else {
                    i48 += iArr17[0];
                    i49 += iArr17[1];
                    i50 += iArr17[2];
                }
                int i59 = i42;
                if (i54 < i59) {
                    i55 += i58;
                }
                i54++;
                i42 = i59;
                width = i58;
            }
            int i60 = width;
            int i61 = i42;
            int i62 = i2;
            int i63 = i44;
            int i64 = i57;
            int i65 = i43;
            int i66 = i56;
            int i67 = 0;
            while (i67 < i65) {
                iArr16[i63] = (iArr16[i63] & (-16777216)) | (iArr15[i66] << 16) | (iArr15[i64] << 8) | iArr15[i47];
                int i68 = i66 - i48;
                int i69 = i64 - i49;
                int i70 = i47 - i50;
                int[] iArr18 = iArr8[((i62 - i2) + i46) % i46];
                int i71 = i48 - iArr18[0];
                int i72 = i49 - iArr18[1];
                int i73 = i50 - iArr18[2];
                if (i44 == 0) {
                    iArr14[i67] = Math.min(i67 + i11, i61) * i60;
                }
                int i74 = iArr14[i67] + i44;
                iArr18[0] = iArr3[i74];
                iArr18[1] = iArr4[i74];
                iArr18[2] = iArr5[i74];
                int i75 = i51 + iArr18[0];
                int i76 = i52 + iArr18[1];
                int i77 = i53 + iArr18[2];
                i66 = i68 + i75;
                i64 = i69 + i76;
                i47 = i70 + i77;
                i62 = (i62 + 1) % i46;
                int[] iArr19 = iArr8[i62];
                i48 = i71 + iArr19[0];
                i49 = i72 + iArr19[1];
                i50 = i73 + iArr19[2];
                i51 = i75 - iArr19[0];
                i52 = i76 - iArr19[1];
                i53 = i77 - iArr19[2];
                i63 += i60;
                i67++;
                i2 = i;
            }
            i44++;
            i2 = i;
            i42 = i61;
            i43 = i65;
            i6 = i46;
            iArr2 = iArr16;
            width = i60;
        }
        int i78 = width;
        bitmap3.setPixels(iArr2, 0, i78, 0, 0, i78, i43);
        return bitmap3;
    }
}
