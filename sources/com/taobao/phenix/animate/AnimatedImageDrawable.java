package com.taobao.phenix.animate;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.taobao.pexode.animate.AnimatedImage;
import com.taobao.rxm.schedule.SchedulerSupplier;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import tb.f60;
import tb.jn1;
import tb.tq1;
import tb.ur1;
import tb.xt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AnimatedImageDrawable extends tq1 {
    private static final int CHOREOGRAPHER_SUBTRACT_FRAME_DELAY = 10;
    private static final int FRAME_DURATION_MS_FOR_MIN = 100;
    private static final int MIN_FRAME_DURATION_MS = 11;
    private static final int TIMEOUT_FOR_DRAW_MS = 1000;
    private static SchedulerSupplier sOneSchedulerSupplier;
    private int[] mAccruedFrameDurations;
    private boolean mAllowPlaying;
    private AnimatedFramesBuffer mAnimatedFramesBuffer;
    private int mCurrAbsFrameNum;
    private int mCurrRelFrameNum;
    private final int mDurationMs;
    private final int mFrameCount;
    private int[] mFrameDurations;
    private final Handler mHandler;
    private final int mImageHeight;
    private final int mImageWidth;
    private final Runnable mInvalidateTask;
    private boolean mIsPaused;
    private int mLastFrameAbsNum;
    private int mLoopCountAtLastPause;
    private AnimatedLoopListener mLoopListener;
    private int mMaxLoopCount;
    private final Runnable mNextFrameTask;
    private long mNextFrameTaskMs;
    private Bitmap mRenderingBitmap;
    private int mStartFrameMustBeRendered;
    private final Runnable mStartTask;
    private long mStartTimeMs;
    private final Runnable mTimeout4DrawTask;
    private boolean mWaitingForUpdate;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class WeakFrameTask implements Runnable {
        public static final int INVALIDATE_TYPE = 2;
        public static final int NEXT_TYPE = 1;
        public static final int START_TYPE = 0;
        public static final int TIMEOUT_FOR_DRAW_TYPE = 3;
        private WeakReference<AnimatedImageDrawable> drawableRef;
        private int type;

        public WeakFrameTask(AnimatedImageDrawable animatedImageDrawable, int i) {
            this.drawableRef = new WeakReference<>(animatedImageDrawable);
            this.type = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimatedImageDrawable animatedImageDrawable = this.drawableRef.get();
            if (animatedImageDrawable != null) {
                int i = this.type;
                if (i == 0) {
                    animatedImageDrawable.onStart();
                } else if (i == 1) {
                    animatedImageDrawable.onNextFrame();
                } else if (i == 2) {
                    animatedImageDrawable.doInvalidateSelf();
                } else if (i != 3) {
                } else {
                    animatedImageDrawable.onTimeout4Draw();
                }
            }
        }
    }

    public AnimatedImageDrawable(AnimatedImage animatedImage) {
        this(null, null, 0, 0, animatedImage);
    }

    private int accrueAndFixDurations() {
        this.mAccruedFrameDurations = new int[this.mFrameCount];
        int i = 0;
        for (int i2 = 0; i2 < this.mFrameCount; i2++) {
            int[] iArr = this.mFrameDurations;
            if (iArr[i2] < 11) {
                iArr[i2] = 100;
            }
            this.mAccruedFrameDurations[i2] = i;
            i += iArr[i2];
        }
        return i;
    }

    private void computeAndScheduleNextFrame(boolean z, boolean z2) {
        if (this.mDurationMs == 0) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        long j = uptimeMillis - this.mStartTimeMs;
        int i = this.mDurationMs;
        int i2 = (int) (j / i);
        int i3 = (int) (j % i);
        int frameNumWithTimestamp = getFrameNumWithTimestamp(i3);
        boolean z3 = this.mCurrRelFrameNum != frameNumWithTimestamp;
        this.mCurrRelFrameNum = frameNumWithTimestamp;
        int i4 = this.mFrameCount;
        this.mCurrAbsFrameNum = (i2 * i4) + frameNumWithTimestamp;
        if (z) {
            if (z3) {
                xt2.a("AnimatedImage", "%s schedule next frame changed to %d, drawing=%b, now=%d", this, Integer.valueOf(frameNumWithTimestamp), Boolean.valueOf(z2), Long.valueOf(uptimeMillis));
                doInvalidateSelf();
                return;
            }
            int i5 = (frameNumWithTimestamp + 1) % i4;
            long j2 = ((this.mAccruedFrameDurations[frameNumWithTimestamp] + this.mFrameDurations[frameNumWithTimestamp]) - i3) + uptimeMillis + 10;
            long j3 = this.mNextFrameTaskMs;
            if (j3 == -1 || j3 > j2) {
                xt2.a("AnimatedImage", "%s schedule next frame=%d at %d[last:%d], drawing=%b, now=%d", this, Integer.valueOf(i5), Long.valueOf(j2), Long.valueOf(this.mNextFrameTaskMs), Boolean.valueOf(z2), Long.valueOf(uptimeMillis));
                unscheduleSelf(this.mNextFrameTask);
                scheduleSelf(this.mNextFrameTask, j2);
                this.mNextFrameTaskMs = j2;
            }
        }
    }

    private void doEnd() {
        this.mLoopCountAtLastPause = 0;
        this.mAnimatedFramesBuffer.dropCaches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInvalidateSelf() {
        this.mWaitingForUpdate = true;
        this.mHandler.removeCallbacks(this.mTimeout4DrawTask);
        this.mHandler.postDelayed(this.mTimeout4DrawTask, 1000L);
        invalidateSelf();
    }

    private int getFrameNumWithTimestamp(int i) {
        int binarySearch = Arrays.binarySearch(this.mAccruedFrameDurations, i);
        return binarySearch < 0 ? ((-binarySearch) - 1) - 1 : binarySearch;
    }

    private boolean updateRenderingBitmap(int i, int i2) {
        Bitmap cachedBitmapAt = this.mAnimatedFramesBuffer.getCachedBitmapAt(i);
        if (cachedBitmapAt == null) {
            return false;
        }
        Bitmap bitmap = this.mRenderingBitmap;
        if (bitmap != null) {
            this.mAnimatedFramesBuffer.freeBitmap(bitmap);
        }
        this.mRenderingBitmap = cachedBitmapAt;
        int i3 = this.mLastFrameAbsNum;
        if (i2 - i3 > 1) {
            xt2.i("AnimatedImage", "%s dropped %d frames", this, Integer.valueOf((i2 - i3) - 1));
        }
        this.mLastFrameAbsNum = i2;
        return true;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Runnable runnable;
        int i;
        int i2;
        AnimatedLoopListener animatedLoopListener;
        xt2.a("AnimatedImage", "%s start to draw, waiting=%b, playing=%b", this, Boolean.valueOf(this.mWaitingForUpdate), Boolean.valueOf(this.mAllowPlaying));
        this.mHandler.removeCallbacks(this.mTimeout4DrawTask);
        if (this.mWaitingForUpdate && (this.mAllowPlaying || this.mRenderingBitmap == null)) {
            this.mWaitingForUpdate = false;
            try {
                if (this.mStartFrameMustBeRendered >= 0) {
                    this.mStartTimeMs = SystemClock.uptimeMillis() - this.mAccruedFrameDurations[this.mStartFrameMustBeRendered];
                }
                computeAndScheduleNextFrame(false, true);
                int i3 = this.mCurrRelFrameNum;
                int i4 = this.mCurrAbsFrameNum;
                int i5 = this.mLastFrameAbsNum;
                boolean updateRenderingBitmap = updateRenderingBitmap(i3, i4);
                xt2.a("AnimatedImage", "%s drew frame=%d|%d, success=%B", this, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(updateRenderingBitmap));
                if (updateRenderingBitmap) {
                    boolean z = this.mStartFrameMustBeRendered == i3;
                    if (z) {
                        this.mStartFrameMustBeRendered = -1;
                    }
                    int i6 = this.mLoopCountAtLastPause;
                    int i7 = this.mFrameCount;
                    int i8 = ((i4 + 1) / i7) + i6;
                    boolean z2 = i8 != ((i5 + 1) / i7) + i6;
                    if ((((z && i6 == 0 && i4 == 0) || z2) && (animatedLoopListener = this.mLoopListener) != null && !animatedLoopListener.onLoopCompleted(i8, this.mMaxLoopCount)) || (z2 && (i2 = this.mMaxLoopCount) != 0 && i8 >= i2)) {
                        this.mAllowPlaying = false;
                    } else {
                        computeAndScheduleNextFrame(true, true);
                    }
                    if (!this.mAllowPlaying) {
                        doEnd();
                    }
                }
                boolean z3 = this.mAllowPlaying;
                if (z3 || this.mRenderingBitmap == null) {
                    if (updateRenderingBitmap) {
                        runnable = null;
                        i = 1;
                    } else {
                        runnable = this.mInvalidateTask;
                        i = 0;
                    }
                    if (z3) {
                        this.mAnimatedFramesBuffer.startCacheFrom((i3 + i) % this.mFrameCount, runnable);
                    } else {
                        this.mAnimatedFramesBuffer.startCacheFrom((i3 + i) % this.mFrameCount, 1, runnable);
                    }
                }
            } catch (Throwable th) {
                xt2.c("AnimatedImage", "%s frame render error=%s", this, th);
            }
        }
        Bitmap bitmap = this.mRenderingBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, getBounds(), (Paint) null);
        }
    }

    public int getDurationMs() {
        return this.mDurationMs;
    }

    public int getFrameCount() {
        return this.mFrameCount;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mImageHeight;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mImageWidth;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean isPlaying() {
        return this.mAllowPlaying;
    }

    void onNextFrame() {
        this.mNextFrameTaskMs = -1L;
        if (!this.mAllowPlaying || this.mDurationMs == 0 || this.mFrameCount <= 1) {
            return;
        }
        computeAndScheduleNextFrame(true, false);
    }

    void onStart() {
        if (this.mAllowPlaying) {
            if (this.mIsPaused) {
                this.mStartFrameMustBeRendered = this.mCurrRelFrameNum;
            } else {
                this.mCurrRelFrameNum = 0;
                this.mCurrAbsFrameNum = 0;
                this.mStartFrameMustBeRendered = 0;
            }
            doInvalidateSelf();
        }
    }

    void onTimeout4Draw() {
        unscheduleSelf(this.mNextFrameTask);
        this.mNextFrameTaskMs = -1L;
        this.mStartFrameMustBeRendered = 0;
        this.mLastFrameAbsNum = 0;
        this.mRenderingBitmap = null;
        doEnd();
        xt2.a("AnimatedImage", "%s timeout for draw, maybe terminate", this);
    }

    public void pause() {
        pause(true);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        invalidateSelf();
    }

    public void setAnimatedLoopListener(AnimatedLoopListener animatedLoopListener) {
        this.mLoopListener = animatedLoopListener;
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        invalidateSelf();
    }

    public void setMaxLoopCount(int i) {
        this.mMaxLoopCount = i;
    }

    public void start() {
        if (this.mDurationMs == 0 || this.mFrameCount <= 1) {
            return;
        }
        this.mAllowPlaying = true;
        scheduleSelf(this.mStartTask, SystemClock.uptimeMillis());
    }

    public void stop() {
        this.mIsPaused = false;
        this.mAllowPlaying = false;
        doEnd();
    }

    @Override // tb.tq1
    public String toString() {
        return "AnimatedImageDrawable(" + Integer.toHexString(hashCode()) + ", key@" + getMemoryCacheKey() + jn1.BRACKET_END_STR;
    }

    public AnimatedImageDrawable(String str, String str2, int i, int i2, AnimatedImage animatedImage) {
        super(str, str2, i, i2);
        this.mStartTask = new WeakFrameTask(this, 0);
        this.mNextFrameTask = new WeakFrameTask(this, 1);
        this.mInvalidateTask = new WeakFrameTask(this, 2);
        this.mTimeout4DrawTask = new WeakFrameTask(this, 3);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mImageWidth = animatedImage.getWidth();
        this.mImageHeight = animatedImage.getHeight();
        this.mFrameDurations = animatedImage.getFrameDurations();
        this.mMaxLoopCount = animatedImage.getLoopCount();
        this.mFrameCount = animatedImage.getFrameCount();
        this.mStartFrameMustBeRendered = 0;
        this.mLoopCountAtLastPause = 0;
        this.mNextFrameTaskMs = -1L;
        this.mWaitingForUpdate = true;
        this.mAllowPlaying = true;
        this.mDurationMs = accrueAndFixDurations();
        SchedulerSupplier n = ur1.o().n();
        if (n == null) {
            synchronized (AnimatedImageDrawable.class) {
                if (sOneSchedulerSupplier == null) {
                    sOneSchedulerSupplier = new f60(null, 0, 3, 8, 5, 1500, 3, 0, 0);
                }
            }
            n = sOneSchedulerSupplier;
        }
        this.mAnimatedFramesBuffer = new AnimatedFramesBuffer(animatedImage, n.forDecode(), toString());
    }

    public void pause(boolean z) {
        this.mIsPaused = true;
        this.mAllowPlaying = false;
        if (z) {
            this.mAnimatedFramesBuffer.dropCaches();
        }
        this.mLoopCountAtLastPause += (this.mCurrAbsFrameNum + 1) / this.mFrameCount;
    }
}
