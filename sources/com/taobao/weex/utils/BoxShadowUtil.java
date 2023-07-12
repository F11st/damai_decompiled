package com.taobao.weex.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.taobao.uikit.feature.features.FeatureFactory;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.common.WXThread;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class BoxShadowUtil {
    private static boolean a = true;
    private static Pattern b;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class BoxShadowOptions {
        private List<IParser> a;
        private int b;
        public float blur;
        public int color;
        public float hShadow;
        public boolean isInset;
        public float[] radii;
        public float spread;
        public PointF topLeft;
        public float vShadow;
        public int viewHeight;
        public int viewWidth;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        public interface IParser {
            void parse(String str);
        }

        public Rect getTargetCanvasRect() {
            return new Rect(0, 0, this.viewWidth + (((int) (this.blur + this.spread + Math.abs(this.hShadow))) * 2), this.viewHeight + (((int) (this.blur + this.spread + Math.abs(this.vShadow))) * 2));
        }

        public BoxShadowOptions scale(float f) {
            if (f <= 0.0f || f > 1.0f) {
                return null;
            }
            BoxShadowOptions boxShadowOptions = new BoxShadowOptions(this.b);
            boxShadowOptions.hShadow = this.hShadow * f;
            boxShadowOptions.vShadow = this.vShadow * f;
            boxShadowOptions.blur = this.blur * f;
            boxShadowOptions.spread = this.spread * f;
            int i = 0;
            while (true) {
                float[] fArr = this.radii;
                if (i >= fArr.length) {
                    break;
                }
                boxShadowOptions.radii[i] = fArr[i] * f;
                i++;
            }
            boxShadowOptions.viewHeight = (int) (this.viewHeight * f);
            boxShadowOptions.viewWidth = (int) (this.viewWidth * f);
            if (this.topLeft != null) {
                PointF pointF = new PointF();
                boxShadowOptions.topLeft = pointF;
                PointF pointF2 = this.topLeft;
                pointF.x = pointF2.x * f;
                pointF.y = pointF2.y * f;
            }
            boxShadowOptions.color = this.color;
            boxShadowOptions.isInset = this.isInset;
            WXLogUtils.d("BoxShadowUtil", "Scaled BoxShadowOptions: [" + f + "] " + boxShadowOptions);
            return boxShadowOptions;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("BoxShadowOptions{");
            stringBuffer.append("h-shadow=");
            stringBuffer.append(this.hShadow);
            stringBuffer.append(", v-shadow=");
            stringBuffer.append(this.vShadow);
            stringBuffer.append(", blur=");
            stringBuffer.append(this.blur);
            stringBuffer.append(", spread=");
            stringBuffer.append(this.spread);
            stringBuffer.append(", corner-radius=");
            stringBuffer.append(jn1.ARRAY_START_STR + this.radii[0] + "," + this.radii[2] + "," + this.radii[4] + "," + this.radii[6] + jn1.ARRAY_END_STR);
            stringBuffer.append(", color=#");
            stringBuffer.append(Integer.toHexString(this.color));
            stringBuffer.append(", inset=");
            stringBuffer.append(this.isInset);
            stringBuffer.append('}');
            return stringBuffer.toString();
        }

        private BoxShadowOptions(int i) {
            this.b = FeatureFactory.PRIORITY_ABOVE_NORMAL;
            this.blur = 0.0f;
            this.spread = 0.0f;
            this.radii = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
            this.color = -16777216;
            this.isInset = false;
            this.viewWidth = 0;
            this.viewHeight = 0;
            this.topLeft = null;
            this.b = i;
            this.a = new ArrayList();
            IParser iParser = new IParser() { // from class: com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.1
                @Override // com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.IParser
                public void parse(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    float floatValue = WXUtils.getFloat(str, Float.valueOf(0.0f)).floatValue();
                    BoxShadowOptions boxShadowOptions = BoxShadowOptions.this;
                    boxShadowOptions.spread = WXViewUtils.getRealSubPxByWidth(floatValue, boxShadowOptions.b);
                    WXLogUtils.w("BoxShadowUtil", "Experimental box-shadow attribute: spread");
                }
            };
            this.a.add(new IParser() { // from class: com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.2
                @Override // com.taobao.weex.utils.BoxShadowUtil.BoxShadowOptions.IParser
                public void parse(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    float floatValue = WXUtils.getFloat(str, Float.valueOf(0.0f)).floatValue();
                    BoxShadowOptions boxShadowOptions = BoxShadowOptions.this;
                    boxShadowOptions.blur = WXViewUtils.getRealSubPxByWidth(floatValue, boxShadowOptions.b);
                }
            });
            this.a.add(iParser);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class InsetShadowDrawable extends Drawable {
        private float a;
        private int b;
        private float[] c;
        private float d;
        private float e;
        private float f;
        private float g;
        private Shader[] h;
        private Path[] i;
        private Paint j;

        private void a() {
            PointF pointF = new PointF(0.0f, 0.0f);
            PointF pointF2 = new PointF(this.d, 0.0f);
            PointF pointF3 = new PointF(pointF2.x, this.e);
            PointF pointF4 = new PointF(pointF.x, pointF3.y);
            PointF pointF5 = new PointF(this.f, this.g);
            PointF pointF6 = new PointF(pointF2.x - this.f, pointF5.y);
            PointF pointF7 = new PointF(pointF6.x, pointF3.y - this.g);
            PointF pointF8 = new PointF(pointF5.x, pointF7.y);
            float f = pointF5.x;
            float f2 = pointF5.y;
            LinearGradient linearGradient = new LinearGradient(f - this.a, f2, f, f2, this.b, 0, Shader.TileMode.CLAMP);
            float f3 = pointF5.x;
            float f4 = pointF5.y;
            LinearGradient linearGradient2 = new LinearGradient(f3, f4 - this.a, f3, f4, this.b, 0, Shader.TileMode.CLAMP);
            float f5 = pointF7.x;
            float f6 = f5 + this.a;
            float f7 = pointF7.y;
            LinearGradient linearGradient3 = new LinearGradient(f6, f7, f5, f7, this.b, 0, Shader.TileMode.CLAMP);
            float f8 = pointF7.x;
            float f9 = pointF7.y;
            LinearGradient linearGradient4 = new LinearGradient(f8, f9 + this.a, f8, f9, this.b, 0, Shader.TileMode.CLAMP);
            Shader[] shaderArr = this.h;
            shaderArr[0] = linearGradient;
            shaderArr[1] = linearGradient2;
            shaderArr[2] = linearGradient3;
            shaderArr[3] = linearGradient4;
            Path path = new Path();
            path.moveTo(pointF.x, pointF.y);
            path.lineTo(pointF5.x, pointF5.y);
            path.lineTo(pointF8.x, pointF8.y);
            path.lineTo(pointF4.x, pointF4.y);
            path.close();
            Path path2 = new Path();
            path2.moveTo(pointF.x, pointF.y);
            path2.lineTo(pointF2.x, pointF2.y);
            path2.lineTo(pointF6.x, pointF6.y);
            path2.lineTo(pointF5.x, pointF5.y);
            path2.close();
            Path path3 = new Path();
            path3.moveTo(pointF2.x, pointF2.y);
            path3.lineTo(pointF3.x, pointF3.y);
            path3.lineTo(pointF7.x, pointF7.y);
            path3.lineTo(pointF6.x, pointF6.y);
            path3.close();
            Path path4 = new Path();
            path4.moveTo(pointF4.x, pointF4.y);
            path4.lineTo(pointF3.x, pointF3.y);
            path4.lineTo(pointF7.x, pointF7.y);
            path4.lineTo(pointF8.x, pointF8.y);
            path4.close();
            Path[] pathArr = this.i;
            pathArr[0] = path;
            pathArr[1] = path2;
            pathArr[2] = path3;
            pathArr[3] = path4;
            Paint paint = new Paint();
            this.j = paint;
            paint.setAntiAlias(true);
            this.j.setStyle(Paint.Style.FILL);
            this.j.setColor(this.b);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect clipBounds = canvas.getClipBounds();
            Path path = new Path();
            path.addRoundRect(new RectF(clipBounds), this.c, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.translate(clipBounds.left, clipBounds.top);
            for (int i = 0; i < 4; i++) {
                Shader shader = this.h[i];
                Path path2 = this.i[i];
                this.j.setShader(shader);
                canvas.drawPath(path2, this.j);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
        }

        private InsetShadowDrawable(int i, int i2, float f, float f2, float f3, float f4, int i3, float[] fArr) {
            this.h = new Shader[4];
            this.i = new Path[4];
            this.a = f3;
            this.b = i3;
            this.d = i + (f * 2.0f);
            this.e = i2 + (2.0f * f2);
            this.f = f + f4;
            this.g = f2 + f4;
            this.c = fArr;
            setBounds(0, 0, i, i2);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class OverflowBitmapDrawable extends BitmapDrawable {
        private int a;
        private int b;
        private float[] c;

        @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            Rect clipBounds = canvas.getClipBounds();
            Rect rect = new Rect(clipBounds);
            rect.inset((-this.a) * 2, (-this.b) * 2);
            try {
                if (WXEnvironment.sApplication.getApplicationInfo().targetSdkVersion > 26) {
                    canvas.clipRect(rect);
                } else {
                    canvas.clipRect(rect, Region.Op.REPLACE);
                }
            } catch (NullPointerException unused) {
                canvas.clipRect(rect);
            }
            Path path = new Path();
            path.addRoundRect(new RectF(clipBounds), this.c, Path.Direction.CCW);
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.translate(clipBounds.left, clipBounds.top);
            super.draw(canvas);
        }

        private OverflowBitmapDrawable(Resources resources, Bitmap bitmap, Point point, Rect rect, float[] fArr) {
            super(resources, bitmap);
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            this.a = xVar;
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            this.b = yVar;
            this.c = fArr;
            setBounds(-xVar, -yVar, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) + this.a, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect) + this.b);
        }
    }

    private static void c(Canvas canvas, BoxShadowOptions boxShadowOptions) {
        float f = boxShadowOptions.spread;
        RectF rectF = new RectF(0.0f, 0.0f, boxShadowOptions.viewWidth + (f * 2.0f), boxShadowOptions.viewHeight + (f * 2.0f));
        PointF pointF = boxShadowOptions.topLeft;
        if (pointF != null) {
            rectF.offset(pointF.x, pointF.y);
        }
        float f2 = boxShadowOptions.blur;
        float f3 = boxShadowOptions.hShadow;
        float f4 = f3 > 0.0f ? (f3 * 2.0f) + f2 : f2;
        float f5 = boxShadowOptions.vShadow;
        if (f5 > 0.0f) {
            f2 += f5 * 2.0f;
        }
        rectF.offset(f4, f2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(boxShadowOptions.color);
        paint.setStyle(Paint.Style.FILL);
        if (boxShadowOptions.blur > 0.0f) {
            paint.setMaskFilter(new BlurMaskFilter(boxShadowOptions.blur, BlurMaskFilter.Blur.NORMAL));
        }
        Path path = new Path();
        float[] fArr = new float[8];
        int i = 0;
        while (true) {
            float[] fArr2 = boxShadowOptions.radii;
            if (i < fArr2.length) {
                if (fArr2[i] == 0.0f) {
                    fArr[i] = 0.0f;
                } else {
                    fArr[i] = fArr2[i] + boxShadowOptions.spread;
                }
                i++;
            } else {
                path.addRoundRect(rectF, fArr, Path.Direction.CCW);
                canvas.drawPath(path, paint);
                return;
            }
        }
    }

    private static BoxShadowOptions d(String str, int i) {
        int i2;
        BoxShadowOptions boxShadowOptions = new BoxShadowOptions(i);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String replaceAll = str.replaceAll("\\s*,\\s+", ",");
        if (replaceAll.contains("inset")) {
            boxShadowOptions.isInset = true;
            replaceAll = replaceAll.replace("inset", "");
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(replaceAll.trim().split("\\s+")));
        String str2 = (String) arrayList.get(arrayList.size() - 1);
        if (!TextUtils.isEmpty(str2) && (str2.startsWith(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) || str2.startsWith("rgb") || WXResourceUtils.isNamedColor(str2))) {
            boxShadowOptions.color = WXResourceUtils.getColor(str2, -16777216);
            arrayList.remove(arrayList.size() - 1);
        }
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (arrayList.size() < 2) {
            return null;
        }
        if (!TextUtils.isEmpty((CharSequence) arrayList.get(0))) {
            boxShadowOptions.hShadow = WXViewUtils.getRealSubPxByWidth(WXUtils.getFloat(((String) arrayList.get(0)).trim(), Float.valueOf(0.0f)).floatValue(), i);
        }
        if (!TextUtils.isEmpty((CharSequence) arrayList.get(1))) {
            boxShadowOptions.vShadow = WXViewUtils.getRealPxByWidth(WXUtils.getFloat(((String) arrayList.get(1)).trim(), Float.valueOf(0.0f)).floatValue(), i);
        }
        for (i2 = 2; i2 < arrayList.size(); i2++) {
            ((BoxShadowOptions.IParser) boxShadowOptions.a.get(i2 - 2)).parse((String) arrayList.get(i2));
        }
        return boxShadowOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(View view, List<BoxShadowOptions> list, float f, float[] fArr) {
        if (view != null && list != null) {
            if (view.getWidth() != 0 && view.getHeight() != 0) {
                if (Build.VERSION.SDK_INT >= 18) {
                    Drawable[] drawableArr = new Drawable[list.size()];
                    for (int i = 0; i < list.size(); i++) {
                        BoxShadowOptions boxShadowOptions = list.get(i);
                        drawableArr[i] = new InsetShadowDrawable(view.getWidth(), view.getHeight(), boxShadowOptions.hShadow, boxShadowOptions.vShadow, boxShadowOptions.blur, boxShadowOptions.spread, boxShadowOptions.color, fArr);
                    }
                    view.getOverlay().add(new LayerDrawable(drawableArr));
                    view.invalidate();
                    return;
                }
                Log.w("BoxShadowUtil", "Call setInsetBoxShadow() requires API level 18 or higher.");
                return;
            }
            WXLogUtils.w("BoxShadowUtil", "Target view is invisible, ignore set shadow.");
            return;
        }
        WXLogUtils.w("BoxShadowUtil", "Illegal arguments");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(View view, List<BoxShadowOptions> list, float f, float[] fArr) {
        int height = view.getHeight();
        int width = view.getWidth();
        view.getLayoutParams();
        if (height != 0 && width != 0) {
            if (Build.VERSION.SDK_INT >= 18) {
                int i = 0;
                int i2 = 0;
                for (BoxShadowOptions boxShadowOptions : list) {
                    boxShadowOptions.viewWidth = width;
                    boxShadowOptions.viewHeight = height;
                    boxShadowOptions.radii = fArr;
                    Rect targetCanvasRect = boxShadowOptions.getTargetCanvasRect();
                    if (i < com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(targetCanvasRect)) {
                        i = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(targetCanvasRect);
                    }
                    if (i2 < com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(targetCanvasRect)) {
                        i2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(targetCanvasRect);
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap((int) (i * f), (int) (i2 * f), Bitmap.Config.ARGB_4444);
                if (Build.VERSION.SDK_INT >= 19) {
                    WXLogUtils.d("BoxShadowUtil", "Allocation memory for box-shadow: " + (createBitmap.getAllocationByteCount() / 1024) + " KB");
                }
                Canvas canvas = new Canvas(createBitmap);
                for (BoxShadowOptions boxShadowOptions2 : list) {
                    Rect targetCanvasRect2 = boxShadowOptions2.getTargetCanvasRect();
                    boxShadowOptions2.topLeft = new PointF((i - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(targetCanvasRect2)) / 2.0f, (i2 - com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(targetCanvasRect2)) / 2.0f);
                    c(canvas, boxShadowOptions2.scale(f));
                }
                OverflowBitmapDrawable overflowBitmapDrawable = new OverflowBitmapDrawable(view.getResources(), createBitmap, new Point((i - width) / 2, (i2 - height) / 2), new Rect(0, 0, width, height), fArr);
                view.getOverlay().add(overflowBitmapDrawable);
                ViewParent parent = view.getParent();
                if (parent != null) {
                    parent.requestLayout();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).invalidate(overflowBitmapDrawable.getBounds());
                        return;
                    }
                    return;
                }
                return;
            }
            Log.w("BoxShadowUtil", "Call setNormalBoxShadow() requires API level 18 or higher.");
            return;
        }
        Log.w("BoxShadowUtil", "Target view is invisible, ignore set shadow.");
    }

    public static boolean isBoxShadowEnabled() {
        return a;
    }

    public static BoxShadowOptions[] parseBoxShadows(String str, int i) {
        int i2;
        if (b == null) {
            b = Pattern.compile("([rR][gG][bB][aA]?)\\((\\d+\\s*),\\s*(\\d+\\s*),\\s*(\\d+\\s*)(?:,\\s*(\\d+(?:\\.\\d+)?))?\\)");
        }
        Matcher matcher = b.matcher(str);
        while (true) {
            if (!matcher.find()) {
                break;
            }
            String group = matcher.group();
            str = str.replace(group, Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + String.format("%8s", Integer.toHexString(WXResourceUtils.getColor(group, -16777216))).replaceAll("\\s", "0"));
        }
        String[] split = str.split(",");
        if (split == null || split.length <= 0) {
            return null;
        }
        BoxShadowOptions[] boxShadowOptionsArr = new BoxShadowOptions[split.length];
        for (i2 = 0; i2 < split.length; i2++) {
            boxShadowOptionsArr[i2] = d(split[i2], i);
        }
        return boxShadowOptionsArr;
    }

    public static void setBoxShadow(final View view, String str, final float[] fArr, int i, final float f) {
        if (!a) {
            WXLogUtils.w("BoxShadowUtil", "box-shadow was disabled by config");
        } else if (view == null) {
            WXLogUtils.w("BoxShadowUtil", "Target view is null!");
        } else if (TextUtils.isEmpty(str) && Build.VERSION.SDK_INT >= 18) {
            view.getOverlay().clear();
            WXLogUtils.d("BoxShadowUtil", "Remove all box-shadow");
        } else {
            BoxShadowOptions[] parseBoxShadows = parseBoxShadows(str, i);
            if (parseBoxShadows != null && parseBoxShadows.length != 0) {
                final ArrayList arrayList = new ArrayList();
                final ArrayList arrayList2 = new ArrayList();
                for (BoxShadowOptions boxShadowOptions : parseBoxShadows) {
                    if (boxShadowOptions != null) {
                        if (boxShadowOptions.isInset) {
                            arrayList2.add(0, boxShadowOptions);
                        } else {
                            arrayList.add(0, boxShadowOptions);
                        }
                    }
                }
                if (fArr != null) {
                    if (fArr.length != 8) {
                        WXLogUtils.w("BoxShadowUtil", "Length of radii must be 8");
                    } else {
                        for (int i2 = 0; i2 < fArr.length; i2++) {
                            fArr[i2] = WXViewUtils.getRealSubPxByWidth(fArr[i2], i);
                        }
                    }
                }
                view.post(WXThread.secure(new Runnable() { // from class: com.taobao.weex.utils.BoxShadowUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Build.VERSION.SDK_INT >= 18) {
                            view.getOverlay().clear();
                            if (arrayList.size() > 0) {
                                BoxShadowUtil.f(view, arrayList, f, fArr);
                            }
                            if (arrayList2.size() > 0) {
                                BoxShadowUtil.e(view, arrayList2, f, fArr);
                            }
                        }
                    }
                }));
                return;
            }
            WXLogUtils.w("BoxShadowUtil", "Failed to parse box-shadow: " + str);
        }
    }

    public static void setBoxShadowEnabled(boolean z) {
        a = z;
        WXLogUtils.w("BoxShadowUtil", "Switch box-shadow status: " + z);
    }
}
