package com.taobao.phenix.animate;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.animate.AnimatedDrawableFrameInfo;
import com.taobao.pexode.animate.AnimatedImage;
import com.taobao.rxm.consume.Consumer;
import com.taobao.rxm.schedule.ScheduledAction;
import com.taobao.rxm.schedule.Scheduler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tb.cu1;
import tb.d62;
import tb.n8;
import tb.xt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AnimatedFramesBuffer {
    private static final int MAX_CACHE_SIZE = 5242880;
    private static final int MAX_FREE_SIZE = 2097152;
    private final SparseArray<CachedEntity> mCachedEntities;
    private SparseArray<Runnable> mDecodeFlights;
    private boolean mDecodeRunning;
    private final Scheduler mDecodeScheduler;
    private String mDrawableId;
    private AnimatedFrameCompositor mFrameCompositor;
    private final int mFrameCount;
    private List<Bitmap> mFreeBitmaps;
    private final int mImageHeight;
    private final int mImageWidth;
    private final int mMaxCacheCount;
    private final int mMaxFreeCount;
    private final ScheduledAction mWeakDecodeAction = new WeakDecodeAction(this);
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class CachedEntity {
        private Bitmap bitmap;
        private int references = 0;

        public CachedEntity(Bitmap bitmap) {
            this.bitmap = bitmap;
        }

        static /* synthetic */ int access$008(CachedEntity cachedEntity) {
            int i = cachedEntity.references;
            cachedEntity.references = i + 1;
            return i;
        }

        static /* synthetic */ int access$010(CachedEntity cachedEntity) {
            int i = cachedEntity.references;
            cachedEntity.references = i - 1;
            return i;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class WeakDecodeAction extends ScheduledAction {
        private WeakReference<AnimatedFramesBuffer> frameBufferRef;

        public WeakDecodeAction(AnimatedFramesBuffer animatedFramesBuffer) {
            super(1, null, null, false);
            this.frameBufferRef = new WeakReference<>(animatedFramesBuffer);
        }

        @Override // com.taobao.rxm.schedule.ScheduledAction
        public void run(Consumer consumer, d62 d62Var) {
            AnimatedFramesBuffer animatedFramesBuffer = this.frameBufferRef.get();
            if (animatedFramesBuffer != null) {
                animatedFramesBuffer.onDecodeActionRun();
            }
        }
    }

    public AnimatedFramesBuffer(AnimatedImage animatedImage, Scheduler scheduler, String str) {
        this.mDrawableId = str;
        int width = animatedImage.getWidth();
        this.mImageWidth = width;
        int height = animatedImage.getHeight();
        this.mImageHeight = height;
        this.mFrameCount = animatedImage.getFrameCount();
        int min = Math.min(6, Math.max(1, 5242880 / ((width * height) * 4)));
        this.mMaxCacheCount = min;
        int min2 = Math.min(3, Math.max(1, 2097152 / ((width * height) * 4)));
        this.mMaxFreeCount = min2;
        this.mDecodeScheduler = scheduler;
        this.mCachedEntities = new SparseArray<>(min);
        this.mFreeBitmaps = new ArrayList(min2);
        this.mDecodeFlights = new SparseArray<>(min);
        this.mFrameCompositor = new AnimatedFrameCompositor(animatedImage, this, str);
    }

    private boolean isInRange(int i, int i2, int i3) {
        return (i2 > i && i3 >= i && i3 < i2) || (i2 <= i && (i3 >= i || i3 < i2));
    }

    private CachedEntity newCachedEntityAt(int i) {
        Bitmap remove;
        synchronized (this) {
            remove = this.mFreeBitmaps.size() > 0 ? this.mFreeBitmaps.remove(0) : null;
        }
        if (remove == null && Pexode.j()) {
            remove = n8.a().newBitmapWithPin(this.mImageWidth, this.mImageHeight, Bitmap.Config.ARGB_8888);
        }
        if (remove == null) {
            remove = Bitmap.createBitmap(this.mImageWidth, this.mImageHeight, Bitmap.Config.ARGB_8888);
        }
        this.mFrameCompositor.i(i, remove);
        return new CachedEntity(remove);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDecodeActionRun() {
        int keyAt;
        Runnable valueAt;
        boolean z;
        while (true) {
            synchronized (this) {
                if (this.mDecodeFlights.size() <= 0) {
                    this.mDecodeRunning = false;
                    return;
                }
                keyAt = this.mDecodeFlights.keyAt(0);
                valueAt = this.mDecodeFlights.valueAt(0);
                this.mDecodeFlights.removeAt(0);
            }
            synchronized (this) {
                z = this.mCachedEntities.get(keyAt) == null;
            }
            if (z) {
                CachedEntity newCachedEntityAt = newCachedEntityAt(keyAt);
                synchronized (this) {
                    this.mCachedEntities.put(keyAt, newCachedEntityAt);
                }
            }
            if (valueAt != null) {
                this.mHandler.post(valueAt);
            }
        }
    }

    private void recycleAsFreeBitmap(Bitmap bitmap) {
        if (this.mFreeBitmaps.size() >= this.mMaxFreeCount || bitmap == null || !bitmap.isMutable() || bitmap.getWidth() != this.mImageWidth || bitmap.getHeight() != this.mImageHeight || this.mFreeBitmaps.contains(bitmap)) {
            return;
        }
        this.mFreeBitmaps.add(bitmap);
    }

    public synchronized void dropCaches() {
        this.mFrameCompositor.b();
        this.mDecodeFlights.clear();
        this.mCachedEntities.clear();
        this.mFreeBitmaps.clear();
        xt2.a("AnimatedImage", "%s dropped frame caches", this.mDrawableId);
    }

    public synchronized void freeBitmap(Bitmap bitmap) {
        int size = this.mCachedEntities.size();
        int i = 0;
        while (true) {
            if (i < size) {
                CachedEntity valueAt = this.mCachedEntities.valueAt(i);
                if (valueAt != null && valueAt.bitmap == bitmap) {
                    CachedEntity.access$010(valueAt);
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        if (i == size) {
            recycleAsFreeBitmap(bitmap);
        }
    }

    public synchronized Bitmap getCachedBitmapAt(int i) {
        CachedEntity cachedEntity = this.mCachedEntities.get(i);
        if (cachedEntity == null) {
            return null;
        }
        CachedEntity.access$008(cachedEntity);
        return cachedEntity.bitmap;
    }

    public synchronized void startCacheFrom(int i, int i2, Runnable runnable) {
        cu1.a(i >= 0);
        cu1.a(i2 > 0);
        int i3 = this.mMaxCacheCount;
        if (i2 > i3) {
            i2 = i3;
        }
        int max = this.mFrameCompositor.e(i).e == AnimatedDrawableFrameInfo.DisposalMode.DISPOSE_TO_PREVIOUS ? Math.max(0, i - 1) : i;
        int i4 = max;
        while (true) {
            if (i4 < 0) {
                i4 = -1;
                break;
            } else if (this.mCachedEntities.get(i4) != null) {
                break;
            } else {
                i4--;
            }
        }
        int i5 = (max + i2) % this.mFrameCount;
        int i6 = 0;
        while (i6 < this.mCachedEntities.size()) {
            int keyAt = this.mCachedEntities.keyAt(i6);
            if (keyAt != i4 && !isInRange(max, i5, keyAt)) {
                CachedEntity valueAt = this.mCachedEntities.valueAt(i6);
                this.mCachedEntities.removeAt(i6);
                if (valueAt != null && valueAt.references <= 0) {
                    recycleAsFreeBitmap(valueAt.bitmap);
                }
            }
            i6++;
        }
        int i7 = 0;
        while (i7 < this.mDecodeFlights.size()) {
            if (isInRange(max, i2, this.mDecodeFlights.keyAt(i7))) {
                i7++;
            } else {
                this.mDecodeFlights.removeAt(i7);
            }
        }
        for (int i8 = 0; i8 < i2; i8++) {
            int i9 = (max + i8) % this.mFrameCount;
            if (this.mCachedEntities.get(i9) != null) {
                if (i == i9) {
                    this.mHandler.post(runnable);
                }
            } else if (i == i9) {
                this.mDecodeFlights.put(i9, runnable);
            } else {
                this.mDecodeFlights.put(i9, null);
            }
        }
        if (!this.mDecodeRunning) {
            this.mDecodeRunning = true;
            this.mDecodeScheduler.schedule(this.mWeakDecodeAction);
        }
    }

    public void startCacheFrom(int i, Runnable runnable) {
        startCacheFrom(i, this.mMaxCacheCount, runnable);
    }
}
