package io.flutter.embedding.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import io.flutter.Log;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FlutterFPS {
    private static final int CACL_CIRCLE = 1000;
    public static final String DEBUG_FPS = "debug.uc.fps";
    public static final String DEBUG_FPS_CANVAS = "debug.uc.fps_canvas";
    public static final String DEBUG_FPS_EX = "debug.uc.fpsex";
    public static final String DEBUG_FPS_LOG = "debug.uc.fps_log";
    public static boolean ENABLE = false;
    public static boolean ENABLE_LOG = false;
    private static final String TAG = "FlutterFPS";
    private static String sCommitHash;
    private static String sEngineVersion;
    private static long sFirstFrameCompensation;
    private static Paint sFpsBgPaint;
    private static Paint sFpsTxtPaint;
    private static Paint sFpsWarningTxtPaint;
    private static int sFrames;
    private static long sLastTime;
    private static boolean sOnceDraw;
    private static double sOverallFps;
    private static long sOverallTime;
    private static String sRenderingMode;
    private static int sTotalFrames;

    public static boolean calculate() {
        if (ENABLE) {
            if (sLastTime <= 0) {
                sLastTime = System.currentTimeMillis() - sFirstFrameCompensation;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - sLastTime;
            if (j < 500) {
                sOverallTime += j;
                sFrames++;
                sTotalFrames++;
            }
            sLastTime = currentTimeMillis;
            long j2 = sOverallTime;
            if (j2 > 1000) {
                sOverallFps = (sFrames * 1000.0d) / j2;
                sOverallTime = 0L;
                sFrames = 0;
                if (ENABLE_LOG) {
                    Log.e(TAG, String.format(Locale.US, "%s>%.1f fps", sRenderingMode, Double.valueOf(sOverallFps)));
                }
                return true;
            }
            return true ^ sOnceDraw;
        }
        return false;
    }

    public static void draw(Canvas canvas, View view, boolean z) {
        if (ENABLE) {
            sOnceDraw = true;
            if (sFpsBgPaint == null) {
                Paint paint = new Paint();
                sFpsBgPaint = paint;
                paint.setStyle(Paint.Style.FILL);
                sFpsBgPaint.setColor(-815833249);
                Paint paint2 = new Paint();
                sFpsTxtPaint = paint2;
                paint2.setStyle(Paint.Style.FILL);
                sFpsTxtPaint.setColor(-16711936);
                sFpsTxtPaint.setTextSize(24.0f);
                sFpsTxtPaint.setTextAlign(Paint.Align.RIGHT);
                sFpsTxtPaint.setTypeface(Typeface.create(Typeface.MONOSPACE, 1));
                Paint paint3 = new Paint();
                sFpsWarningTxtPaint = paint3;
                paint3.setStyle(Paint.Style.FILL);
                sFpsWarningTxtPaint.setColor(SupportMenu.CATEGORY_MASK);
                sFpsWarningTxtPaint.setTextSize(24.0f);
                sFpsWarningTxtPaint.setTextAlign(Paint.Align.RIGHT);
            }
            int width = view.getWidth();
            int height = view.getHeight();
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            String format = String.format(Locale.US, "%s>%.1f fps", sRenderingMode, Double.valueOf(sOverallFps));
            int i = width - 2;
            int i2 = (sEngineVersion != null ? 30 : 0) + 30 + (sCommitHash != null ? 30 : 0);
            canvas.save();
            if (z) {
                canvas.translate(scrollX, scrollY);
            } else {
                canvas.translate(scrollX, (scrollY + height) - i2);
            }
            canvas.drawRect(width - 250, 0.0f, width, i2, sFpsBgPaint);
            float f = i;
            canvas.drawText(format, f, 22.0f, sFpsTxtPaint);
            if (sEngineVersion != null) {
                canvas.translate(0.0f, 30.0f);
                canvas.drawText(sEngineVersion, f, 22.0f, sFpsTxtPaint);
            }
            if (sCommitHash != null) {
                canvas.translate(0.0f, 30.0f);
                canvas.drawText(sCommitHash, f, 22.0f, sFpsTxtPaint);
            }
            canvas.restore();
        }
    }

    public static void enableDebugIfNeeded() {
    }

    public static void enableFps(boolean z) {
        ENABLE = z;
        enableDebugIfNeeded();
    }

    public static void fps(Canvas canvas, View view) {
        calculate();
        draw(canvas, view, false);
    }

    public static void resetDrawOnce() {
        sOnceDraw = false;
    }

    public static void setEngineVersion(String str, String str2) {
        sEngineVersion = "Hummer " + str;
        sCommitHash = str2.substring(0, 16);
    }

    public static void setRenderingMode(String str) {
        sRenderingMode = str;
    }
}
