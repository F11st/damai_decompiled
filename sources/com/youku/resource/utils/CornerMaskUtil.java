package com.youku.resource.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import com.youku.resource.R;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class CornerMaskUtil {
    private static int dp1;
    private static int dp16;
    private static int dp20;
    private static int dp4;
    private static int dp9;
    private static int dpRad;
    private static GradientDrawable gd = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{0, 0});
    private static boolean isInited = false;
    private static float[] loc;
    private static Paint mRTPaint;

    public static void drawCornerMask(Context context, Canvas canvas, int i, String str, int i2, int i3, int i4) {
        if (!isInited) {
            dp1 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_1);
            dpRad = DimenUtils.getDimensionPixelSize(context, R.dimen.radius_secondary_medium);
            dp4 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_4);
            dp9 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_9);
            dp16 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_16);
            dp20 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_20);
            gd.setShape(0);
            GradientDrawable gradientDrawable = gd;
            int i5 = dpRad;
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, i5, i5, 0.0f, 0.0f, i5, i5});
            isInited = true;
        }
        canvas.drawBitmap(makeTopRightBitmap(str, i2, i3, i4), (i - loc[2]) - (dp1 * 2), 0.0f, getRTPaint());
    }

    private static Paint getRTPaint() {
        if (mRTPaint == null) {
            Paint paint = new Paint();
            mRTPaint = paint;
            paint.setAntiAlias(true);
            mRTPaint.setColor(-1);
            mRTPaint.setTextSize(dp9);
            mRTPaint.setFakeBoldText(false);
        }
        return mRTPaint;
    }

    private static Bitmap makeTopRightBitmap(String str, int i, int i2, int i3) {
        float[] updateTopRight = updateTopRight(str);
        loc = updateTopRight;
        int i4 = dp1;
        int i5 = ((int) updateTopRight[2]) + (i4 << 1);
        int i6 = dp16 - i4;
        Bitmap createBitmap = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int[] iArr = {0, 0};
        iArr[0] = i;
        iArr[1] = i2;
        gd.setColors(iArr);
        gd.setBounds(0, 0, i5, i6);
        gd.draw(canvas);
        Paint rTPaint = getRTPaint();
        rTPaint.setColor(i3);
        float[] fArr = loc;
        canvas.drawText(str, fArr[0], fArr[1], rTPaint);
        return createBitmap;
    }

    private static float[] updateTopRight(String str) {
        float f;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Paint rTPaint = getRTPaint();
        float[] fArr = {0.0f, 0.0f, rTPaint.measureText(str)};
        float f2 = fArr[2];
        int i = dp20;
        int i2 = dp4;
        if (f2 < i - i2) {
            f = i - fArr[2];
            fArr[2] = i;
        } else {
            f = i2;
            fArr[2] = fArr[2] + f;
        }
        Paint.FontMetrics fontMetrics = rTPaint.getFontMetrics();
        int i3 = dp1;
        fArr[0] = i3 + (f / 2.0f);
        fArr[1] = (((dp16 - fontMetrics.bottom) - fontMetrics.top) / 2.0f) - i3;
        return fArr;
    }

    public static void drawCornerMask(Context context, Canvas canvas, int i, String str, int i2) {
        if (!isInited) {
            dp1 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_1);
            dpRad = DimenUtils.getDimensionPixelSize(context, R.dimen.radius_secondary_medium);
            dp4 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_4);
            dp9 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_9);
            dp16 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_16);
            dp20 = DimenUtils.getDimensionPixelSize(context, R.dimen.resource_size_20);
            gd.setShape(0);
            GradientDrawable gradientDrawable = gd;
            int i3 = dpRad;
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, i3, i3, 0.0f, 0.0f, i3, i3});
            isInited = true;
        }
        canvas.drawBitmap(makeTopRightBitmap(str, Utils.getStartColor(context, i2), Utils.getEndColor(context, i2), i2 == 3 ? Color.parseColor("#FF4E2D03") : -1), (i - loc[2]) - (dp1 * 2), 0.0f, getRTPaint());
    }
}
