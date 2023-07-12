package com.taobao.phenix.animate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.taobao.pexode.animate.AnimatedDrawableFrameInfo;
import com.taobao.pexode.animate.AnimatedImage;
import com.taobao.pexode.animate.AnimatedImageFrame;
import com.taobao.phenix.bitmap.C6849b;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AnimatedFrameCompositor {
    private final AnimatedImage a;
    private final int b;
    private final int c;
    private final AnimatedFramesBuffer d;
    private final Paint e;
    private final AnimatedDrawableFrameInfo[] f;
    private Bitmap g;
    private String h;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface Callback {
        Bitmap getCachedBitmap(int i);

        void onIntermediateResult(int i, Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum CompositedFrameRenderingType {
        REQUIRED,
        NOT_REQUIRED,
        SKIP,
        ABORT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.phenix.animate.AnimatedFrameCompositor$a */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class C6847a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CompositedFrameRenderingType.values().length];
            a = iArr;
            try {
                iArr[CompositedFrameRenderingType.REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CompositedFrameRenderingType.NOT_REQUIRED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CompositedFrameRenderingType.ABORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CompositedFrameRenderingType.SKIP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public AnimatedFrameCompositor(AnimatedImage animatedImage, AnimatedFramesBuffer animatedFramesBuffer, String str) {
        this.a = animatedImage;
        this.h = str;
        this.b = animatedImage.getWidth();
        this.c = animatedImage.getHeight();
        this.d = animatedFramesBuffer;
        Paint paint = new Paint();
        this.e = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.f = new AnimatedDrawableFrameInfo[animatedImage.getFrameCount()];
        for (int i = 0; i < this.a.getFrameCount(); i++) {
            AnimatedImageFrame frame = this.a.getFrame(i);
            try {
                this.f[i] = frame.getFrameInfo();
                frame.dispose();
            } catch (Throwable th) {
                frame.dispose();
                throw th;
            }
        }
    }

    private void a(Canvas canvas, AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        int i = animatedDrawableFrameInfo.a;
        int i2 = animatedDrawableFrameInfo.b;
        canvas.drawRect(i, i2, i + animatedDrawableFrameInfo.c, i2 + animatedDrawableFrameInfo.d, this.e);
    }

    private void c() {
        Bitmap bitmap = this.g;
        if (bitmap == null) {
            this.g = C6849b.a().get(this.b, this.c, Bitmap.Config.ARGB_8888);
        } else {
            bitmap.eraseColor(0);
        }
    }

    private CompositedFrameRenderingType d(int i) {
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo = this.f[i];
        AnimatedDrawableFrameInfo.DisposalMode disposalMode = animatedDrawableFrameInfo.e;
        if (disposalMode == AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_DO_NOT) {
            return CompositedFrameRenderingType.REQUIRED;
        }
        if (disposalMode == AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_BACKGROUND) {
            if (f(animatedDrawableFrameInfo)) {
                return CompositedFrameRenderingType.NOT_REQUIRED;
            }
            return CompositedFrameRenderingType.REQUIRED;
        } else if (disposalMode == AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_PREVIOUS) {
            return CompositedFrameRenderingType.SKIP;
        } else {
            return CompositedFrameRenderingType.ABORT;
        }
    }

    private boolean f(AnimatedDrawableFrameInfo animatedDrawableFrameInfo) {
        return animatedDrawableFrameInfo.a == 0 && animatedDrawableFrameInfo.b == 0 && animatedDrawableFrameInfo.c == this.b && animatedDrawableFrameInfo.d == this.c;
    }

    private boolean g(int i) {
        if (i == 0) {
            return true;
        }
        AnimatedDrawableFrameInfo[] animatedDrawableFrameInfoArr = this.f;
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo = animatedDrawableFrameInfoArr[i];
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo2 = animatedDrawableFrameInfoArr[i - 1];
        if (animatedDrawableFrameInfo.f == AnimatedDrawableFrameInfo.BlendMode.NO_BLEND && f(animatedDrawableFrameInfo)) {
            return true;
        }
        return animatedDrawableFrameInfo2.e == AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_BACKGROUND && f(animatedDrawableFrameInfo2);
    }

    private int h(int i, Canvas canvas) {
        while (i >= 0) {
            int i2 = C6847a.a[d(i).ordinal()];
            if (i2 == 1) {
                AnimatedDrawableFrameInfo animatedDrawableFrameInfo = this.f[i];
                Bitmap cachedBitmapAt = this.d.getCachedBitmapAt(i);
                if (cachedBitmapAt != null) {
                    canvas.drawBitmap(cachedBitmapAt, 0.0f, 0.0f, (Paint) null);
                    this.d.freeBitmap(cachedBitmapAt);
                    if (animatedDrawableFrameInfo.e == AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_BACKGROUND) {
                        a(canvas, animatedDrawableFrameInfo);
                    }
                    return i + 1;
                } else if (g(i)) {
                    return i;
                }
            } else if (i2 == 2) {
                return i + 1;
            } else {
                if (i2 == 3) {
                    return i;
                }
            }
            i--;
        }
        return 0;
    }

    private void j(int i, Canvas canvas) {
        AnimatedImageFrame frame = this.a.getFrame(i);
        try {
            synchronized (this) {
                c();
                frame.renderFrame(frame.getWidth(), frame.getHeight(), this.g);
                canvas.save();
                canvas.translate(frame.getXOffset(), frame.getYOffset());
                canvas.drawBitmap(this.g, 0.0f, 0.0f, (Paint) null);
                canvas.restore();
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public synchronized void b() {
        this.g = null;
    }

    public AnimatedDrawableFrameInfo e(int i) {
        return this.f[i];
    }

    public void i(int i, Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        for (int h = g(i) ? i : h(i - 1, canvas); h < i; h++) {
            AnimatedDrawableFrameInfo animatedDrawableFrameInfo = this.f[h];
            AnimatedDrawableFrameInfo.DisposalMode disposalMode = animatedDrawableFrameInfo.e;
            if (disposalMode != AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_PREVIOUS) {
                if (animatedDrawableFrameInfo.f == AnimatedDrawableFrameInfo.BlendMode.NO_BLEND) {
                    a(canvas, animatedDrawableFrameInfo);
                }
                j(h, canvas);
                if (disposalMode == AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_BACKGROUND) {
                    a(canvas, animatedDrawableFrameInfo);
                }
            }
        }
        AnimatedDrawableFrameInfo animatedDrawableFrameInfo2 = this.f[i];
        if (animatedDrawableFrameInfo2.f == AnimatedDrawableFrameInfo.BlendMode.NO_BLEND) {
            a(canvas, animatedDrawableFrameInfo2);
        }
        j(i, canvas);
    }
}
