package com.alibaba.pictures.bricks.util.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.RSRuntimeException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import com.alibaba.pictures.bricks.util.PriorityTask;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.Array;
import tb.oc;
import tb.pe1;
import tb.pu1;
import tb.y11;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ImageBlurHelper {
    private static transient /* synthetic */ IpChange $ipChange;
    private static pe1<String, Bitmap> b = new pe1<>(new oc(), KeyTransformer.IDENTITY);
    private static HandlerC3551a a = new HandlerC3551a();

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface BlurImageCallback {
        void onBlurResult(String str, Bitmap bitmap);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.util.blur.ImageBlurHelper$a */
    /* loaded from: classes7.dex */
    private static class HandlerC3551a extends Handler {
        public HandlerC3551a() {
            super(Looper.getMainLooper());
        }
    }

    @Deprecated
    public static Bitmap d(@Nullable Context context, Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1312808156") ? (Bitmap) ipChange.ipc$dispatch("1312808156", new Object[]{context, bitmap, Integer.valueOf(i), Integer.valueOf(i2)}) : e(context, null, bitmap, i, i2);
    }

    public static Bitmap e(@Nullable Context context, String str, Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "497911506")) {
            return (Bitmap) ipChange.ipc$dispatch("497911506", new Object[]{context, str, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (TextUtils.isEmpty(str) || (bitmap2 = b.get(str)) == null || bitmap2.isRecycled()) {
            Bitmap k = k(context, bitmap, i, i2);
            if (!TextUtils.isEmpty(str) && k != null && !k.isRecycled()) {
                b.save(str, k);
            }
            return k;
        }
        return bitmap2;
    }

    public static void f(final Context context, final String str, final Bitmap bitmap, final int i, final int i2, final BlurImageCallback blurImageCallback) {
        Bitmap bitmap2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "907259337")) {
            ipChange.ipc$dispatch("907259337", new Object[]{context, str, bitmap, Integer.valueOf(i), Integer.valueOf(i2), blurImageCallback});
        } else if (blurImageCallback == null) {
        } else {
            if (!TextUtils.isEmpty(str) && (bitmap2 = b.get(str)) != null && !bitmap2.isRecycled()) {
                blurImageCallback.onBlurResult(str, bitmap2);
            } else {
                pu1.a(new PriorityTask("TASK_BLUR_BITMAP", null) { // from class: com.alibaba.pictures.bricks.util.blur.ImageBlurHelper.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.alibaba.pictures.bricks.util.PriorityTask
                    public void doTask() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1226999691")) {
                            ipChange2.ipc$dispatch("1226999691", new Object[]{this});
                            return;
                        }
                        final Bitmap k = ImageBlurHelper.k(context, bitmap, i, i2);
                        if (!TextUtils.isEmpty(str) && k != null && !k.isRecycled()) {
                            ImageBlurHelper.b.save(str, k);
                        }
                        ImageBlurHelper.a.post(new Runnable() { // from class: com.alibaba.pictures.bricks.util.blur.ImageBlurHelper.1.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "505914007")) {
                                    ipChange3.ipc$dispatch("505914007", new Object[]{this});
                                    return;
                                }
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                blurImageCallback.onBlurResult(str, k);
                            }
                        });
                    }
                });
            }
        }
    }

    public static void g(Context context, String str, Bitmap bitmap, BlurImageCallback blurImageCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-893176407")) {
            ipChange.ipc$dispatch("-893176407", new Object[]{context, str, bitmap, blurImageCallback});
        } else {
            f(context, str, bitmap, j(bitmap), 20, blurImageCallback);
        }
    }

    private static Bitmap h(Bitmap bitmap, int i, boolean z) {
        int[] iArr;
        Bitmap bitmap2 = bitmap;
        int i2 = i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "954094238")) {
            return (Bitmap) ipChange.ipc$dispatch("954094238", new Object[]{bitmap2, Integer.valueOf(i), Boolean.valueOf(z)});
        }
        if (!z) {
            bitmap2 = bitmap2.copy(bitmap.getConfig(), true);
        }
        if (i2 < 1) {
            return null;
        }
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
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
            int i15 = -i2;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i15 <= i2) {
                Bitmap bitmap3 = bitmap2;
                int i25 = height;
                int i26 = iArr2[i13 + Math.min(i4, Math.max(i15, 0))];
                int[] iArr9 = iArr8[i15 + i2];
                iArr9[0] = (i26 & 16711680) >> 16;
                iArr9[1] = (i26 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i26 & 255;
                int abs = i11 - Math.abs(i15);
                i16 += iArr9[0] * abs;
                i17 += iArr9[1] * abs;
                i18 += iArr9[2] * abs;
                if (i15 > 0) {
                    i22 += iArr9[0];
                    i23 += iArr9[1];
                    i24 += iArr9[2];
                } else {
                    i19 += iArr9[0];
                    i20 += iArr9[1];
                    i21 += iArr9[2];
                }
                i15++;
                bitmap2 = bitmap3;
                height = i25;
            }
            Bitmap bitmap4 = bitmap2;
            int i27 = height;
            int i28 = i2;
            int i29 = 0;
            while (i29 < width) {
                iArr3[i13] = iArr7[i16];
                iArr4[i13] = iArr7[i17];
                iArr5[i13] = iArr7[i18];
                int i30 = i16 - i19;
                int i31 = i17 - i20;
                int i32 = i18 - i21;
                int[] iArr10 = iArr8[((i28 - i2) + i6) % i6];
                int i33 = i19 - iArr10[0];
                int i34 = i20 - iArr10[1];
                int i35 = i21 - iArr10[2];
                if (i12 == 0) {
                    iArr = iArr7;
                    iArr6[i29] = Math.min(i29 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i36 = iArr2[i14 + iArr6[i29]];
                iArr10[0] = (i36 & 16711680) >> 16;
                iArr10[1] = (i36 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i36 & 255;
                int i37 = i22 + iArr10[0];
                int i38 = i23 + iArr10[1];
                int i39 = i24 + iArr10[2];
                i16 = i30 + i37;
                i17 = i31 + i38;
                i18 = i32 + i39;
                i28 = (i28 + 1) % i6;
                int[] iArr11 = iArr8[i28 % i6];
                i19 = i33 + iArr11[0];
                i20 = i34 + iArr11[1];
                i21 = i35 + iArr11[2];
                i22 = i37 - iArr11[0];
                i23 = i38 - iArr11[1];
                i24 = i39 - iArr11[2];
                i13++;
                i29++;
                iArr7 = iArr;
            }
            i14 += width;
            i12++;
            bitmap2 = bitmap4;
            height = i27;
        }
        Bitmap bitmap5 = bitmap2;
        int i40 = height;
        int[] iArr12 = iArr7;
        int i41 = 0;
        while (i41 < width) {
            int i42 = -i2;
            int i43 = i42 * width;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            while (i42 <= i2) {
                int[] iArr13 = iArr6;
                int max = Math.max(0, i43) + i41;
                int[] iArr14 = iArr8[i42 + i2];
                iArr14[0] = iArr3[max];
                iArr14[1] = iArr4[max];
                iArr14[2] = iArr5[max];
                int abs2 = i11 - Math.abs(i42);
                i44 += iArr3[max] * abs2;
                i45 += iArr4[max] * abs2;
                i46 += iArr5[max] * abs2;
                if (i42 > 0) {
                    i50 += iArr14[0];
                    i51 += iArr14[1];
                    i52 += iArr14[2];
                } else {
                    i47 += iArr14[0];
                    i48 += iArr14[1];
                    i49 += iArr14[2];
                }
                if (i42 < i5) {
                    i43 += width;
                }
                i42++;
                iArr6 = iArr13;
            }
            int[] iArr15 = iArr6;
            int i53 = i40;
            int i54 = i41;
            int i55 = i2;
            int i56 = 0;
            while (i56 < i53) {
                iArr2[i54] = (iArr2[i54] & (-16777216)) | (iArr12[i44] << 16) | (iArr12[i45] << 8) | iArr12[i46];
                int i57 = i44 - i47;
                int i58 = i45 - i48;
                int i59 = i46 - i49;
                int[] iArr16 = iArr8[((i55 - i2) + i6) % i6];
                int i60 = i47 - iArr16[0];
                int i61 = i48 - iArr16[1];
                int i62 = i49 - iArr16[2];
                if (i41 == 0) {
                    iArr15[i56] = Math.min(i56 + i11, i5) * width;
                }
                int i63 = iArr15[i56] + i41;
                iArr16[0] = iArr3[i63];
                iArr16[1] = iArr4[i63];
                iArr16[2] = iArr5[i63];
                int i64 = i50 + iArr16[0];
                int i65 = i51 + iArr16[1];
                int i66 = i52 + iArr16[2];
                i44 = i57 + i64;
                i45 = i58 + i65;
                i46 = i59 + i66;
                i55 = (i55 + 1) % i6;
                int[] iArr17 = iArr8[i55];
                i47 = i60 + iArr17[0];
                i48 = i61 + iArr17[1];
                i49 = i62 + iArr17[2];
                i50 = i64 - iArr17[0];
                i51 = i65 - iArr17[1];
                i52 = i66 - iArr17[2];
                i54 += width;
                i56++;
                i2 = i;
            }
            i41++;
            i2 = i;
            i40 = i53;
            iArr6 = iArr15;
        }
        bitmap5.setPixels(iArr2, 0, width, 0, 0, width, i40);
        return bitmap5;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
    @android.annotation.TargetApi(18)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap i(android.content.Context r6, android.graphics.Bitmap r7, int r8) throws android.renderscript.RSRuntimeException {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.alibaba.pictures.bricks.util.blur.ImageBlurHelper.$ipChange
            java.lang.String r1 = "-1423536965"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            if (r2 == 0) goto L21
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r4 = 0
            r2[r4] = r6
            r2[r3] = r7
            r6 = 2
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r2[r6] = r7
            java.lang.Object r6 = r0.ipc$dispatch(r1, r2)
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            return r6
        L21:
            r0 = 0
            android.renderscript.RenderScript r6 = android.renderscript.RenderScript.create(r6)     // Catch: java.lang.Throwable -> L6c
            android.renderscript.RenderScript$RSMessageHandler r1 = new android.renderscript.RenderScript$RSMessageHandler     // Catch: java.lang.Throwable -> L66
            r1.<init>()     // Catch: java.lang.Throwable -> L66
            r6.setMessageHandler(r1)     // Catch: java.lang.Throwable -> L66
            android.renderscript.Allocation$MipmapControl r1 = android.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch: java.lang.Throwable -> L66
            android.renderscript.Allocation r1 = android.renderscript.Allocation.createFromBitmap(r6, r7, r1, r3)     // Catch: java.lang.Throwable -> L66
            android.renderscript.Type r2 = r1.getType()     // Catch: java.lang.Throwable -> L63
            android.renderscript.Allocation r2 = android.renderscript.Allocation.createTyped(r6, r2)     // Catch: java.lang.Throwable -> L63
            android.renderscript.Element r3 = android.renderscript.Element.U8_4(r6)     // Catch: java.lang.Throwable -> L5e
            android.renderscript.ScriptIntrinsicBlur r0 = android.renderscript.ScriptIntrinsicBlur.create(r6, r3)     // Catch: java.lang.Throwable -> L5e
            r0.setInput(r1)     // Catch: java.lang.Throwable -> L5e
            float r8 = (float) r8     // Catch: java.lang.Throwable -> L5e
            r0.setRadius(r8)     // Catch: java.lang.Throwable -> L5e
            r0.forEach(r2)     // Catch: java.lang.Throwable -> L5e
            r2.copyTo(r7)     // Catch: java.lang.Throwable -> L5e
            r6.destroy()
            r1.destroy()
            r2.destroy()
            r0.destroy()
            return r7
        L5e:
            r7 = move-exception
            r5 = r0
            r0 = r6
            r6 = r5
            goto L70
        L63:
            r7 = move-exception
            r2 = r0
            goto L69
        L66:
            r7 = move-exception
            r1 = r0
            r2 = r1
        L69:
            r0 = r6
            r6 = r2
            goto L70
        L6c:
            r7 = move-exception
            r6 = r0
            r1 = r6
            r2 = r1
        L70:
            if (r0 == 0) goto L75
            r0.destroy()
        L75:
            if (r1 == 0) goto L7a
            r1.destroy()
        L7a:
            if (r2 == 0) goto L7f
            r2.destroy()
        L7f:
            if (r6 == 0) goto L84
            r6.destroy()
        L84:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.util.blur.ImageBlurHelper.i(android.content.Context, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    private static int j(Bitmap bitmap) {
        int byteCount;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "443446308")) {
            return ((Integer) ipChange.ipc$dispatch("443446308", new Object[]{bitmap})).intValue();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            byteCount = bitmap.getAllocationByteCount();
        } else {
            byteCount = bitmap.getByteCount();
        }
        float f = byteCount;
        if (f < 3774873.5f) {
            return 2;
        }
        return f < 8703181.0f ? 4 : 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap k(@Nullable Context context, Bitmap bitmap, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1004795584")) {
            return (Bitmap) ipChange.ipc$dispatch("1004795584", new Object[]{context, bitmap, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        Bitmap c = y11.c(bitmap, i);
        if (c == null || c.isRecycled()) {
            return null;
        }
        Bitmap b2 = LibBlur.a().b(c, i2);
        if (b2 == null && context != null && Build.VERSION.SDK_INT >= 18 && i2 <= 25) {
            try {
                b2 = i(context, c, i2);
            } catch (RSRuntimeException e) {
                Log.i("TASK_BLUR_BITMAP", "render script blur error=%s :" + e);
            }
        }
        if (b2 == null) {
            try {
                return h(bitmap, i2, true);
            } catch (Exception e2) {
                e2.printStackTrace();
                return b2;
            }
        }
        return b2;
    }
}
