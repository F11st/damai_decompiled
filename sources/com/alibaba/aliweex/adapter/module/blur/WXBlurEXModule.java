package com.alibaba.aliweex.adapter.module.blur;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LongSparseArray;
import com.taobao.android.task.Coordinator;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXResourceUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import tb.jn1;
import tb.rz2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXBlurEXModule extends WXSDKEngine.DestroyableModule {
    public static final String BLUR_MODULE_NAME = "blurEx";
    private static final String DATA = "data";
    private static final String DEFAULT_OVERLAY_COLOR = "0x00FFFFFF";
    private static final int DEFAULT_SIZE = 16;
    private static final String RESULT = "result";
    private static final String RESULT_FAILED = "failure";
    private static final String RESULT_SUCCESS = "success";
    static final String TAG = "WXBlurEXModule";
    @Nullable
    private FixedLongSparseArray<WeakReference<Bitmap>> mBitmapHolders = null;
    private AtomicLong mIdGenerator = new AtomicLong(1);
    @Nullable
    private Handler mUIHandler = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    static class FixedLongSparseArray<E> extends LongSparseArray<E> {
        private final int mFixedSize;

        FixedLongSparseArray(int i) {
            super(i);
            this.mFixedSize = i;
        }

        private void trimToSizeIfNeeded() {
            int size = size();
            int i = size - this.mFixedSize;
            if (i <= 0) {
                return;
            }
            long[] jArr = new long[i];
            int i2 = 0;
            for (int i3 = 0; i3 < size && i2 < i; i3++) {
                jArr[i2] = keyAt(i3);
                i2++;
            }
            for (int i4 = 0; i4 < i; i4++) {
                remove(jArr[i4]);
            }
        }

        @Override // androidx.collection.LongSparseArray
        public void append(long j, E e) {
            super.append(j, e);
            trimToSizeIfNeeded();
        }

        @Override // androidx.collection.LongSparseArray
        public void put(long j, E e) {
            super.put(j, e);
            trimToSizeIfNeeded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireCallbackEvent(@NonNull String str, long j, @Nullable JSCallback jSCallback) {
        if (jSCallback == null) {
            return;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("result", str);
        if (j != -1) {
            hashMap.put("data", Long.valueOf(j));
        }
        jSCallback.invoke(hashMap);
    }

    @JSMethod
    public void applyBlur(@Nullable String str, long j, @Nullable JSCallback jSCallback) {
        if (str != null && !"".equals(str.trim()) && this.mWXSDKInstance != null) {
            FixedLongSparseArray<WeakReference<Bitmap>> fixedLongSparseArray = this.mBitmapHolders;
            if (fixedLongSparseArray == null) {
                WXLogUtils.e(TAG, "bitmapHolders not initialized");
                fireCallbackEvent("failure", -1L, jSCallback);
                return;
            }
            WeakReference<Bitmap> weakReference = fixedLongSparseArray.get(j);
            if (weakReference != null && weakReference.get() != null) {
                Bitmap bitmap = weakReference.get();
                View b = rz2.b(this.mWXSDKInstance.getInstanceId(), str);
                if (b == null) {
                    WXLogUtils.e(TAG, "view not found");
                    fireCallbackEvent("failure", -1L, jSCallback);
                    return;
                } else if (!(b instanceof ImageView)) {
                    WXLogUtils.e(TAG, "target is not an imageView");
                    fireCallbackEvent("failure", -1L, jSCallback);
                    return;
                } else {
                    try {
                        ((ImageView) b).setImageBitmap(bitmap);
                        this.mBitmapHolders.remove(j);
                        fireCallbackEvent("success", -1L, jSCallback);
                        return;
                    } catch (Exception e) {
                        WXLogUtils.e(TAG, e.getMessage());
                        this.mBitmapHolders.remove(j);
                        fireCallbackEvent("failure", -1L, jSCallback);
                        return;
                    }
                }
            }
            WXLogUtils.e(TAG, "bitmap not found.[id:" + j + jn1.ARRAY_END_STR);
            fireCallbackEvent("failure", -1L, jSCallback);
            return;
        }
        WXLogUtils.e(TAG, "illegal argument. [sourceRef:" + str + jn1.ARRAY_END_STR);
    }

    @JSMethod
    public void createBlur(@Nullable String str, int i, @Nullable JSCallback jSCallback) {
        createBlurWithOverlay(str, i, DEFAULT_OVERLAY_COLOR, jSCallback);
    }

    @JSMethod
    public void createBlurWithOverlay(@Nullable String str, final int i, @Nullable String str2, @Nullable final JSCallback jSCallback) {
        if (str != null && !"".equals(str.trim()) && i >= 0 && jSCallback != null && this.mWXSDKInstance != null) {
            if (str2 != null && !"".equals(str2.trim())) {
                final int color = WXResourceUtils.getColor(str2, 0);
                final View b = rz2.b(this.mWXSDKInstance.getInstanceId(), str);
                if (b == null) {
                    WXLogUtils.e(TAG, "view not found");
                    fireCallbackEvent("failure", -1L, jSCallback);
                    return;
                }
                final b b2 = b.b(new a(true));
                Coordinator.postTask(new Coordinator.TaggedRunnable(TAG) { // from class: com.alibaba.aliweex.adapter.module.blur.WXBlurEXModule.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            final Bitmap c = b2.c(b, color, i);
                            if (WXBlurEXModule.this.mUIHandler != null) {
                                WXBlurEXModule.this.mUIHandler.post(new Runnable() { // from class: com.alibaba.aliweex.adapter.module.blur.WXBlurEXModule.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (c != null) {
                                            if (WXBlurEXModule.this.mBitmapHolders == null) {
                                                WXBlurEXModule.this.mBitmapHolders = new FixedLongSparseArray(16);
                                            }
                                            long andIncrement = WXBlurEXModule.this.mIdGenerator.getAndIncrement();
                                            WXBlurEXModule.this.mBitmapHolders.put(andIncrement, new WeakReference(c));
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            WXBlurEXModule.this.fireCallbackEvent("success", andIncrement, jSCallback);
                                            return;
                                        }
                                        WXLogUtils.e(WXBlurEXModule.TAG, "blur failed");
                                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                        WXBlurEXModule.this.fireCallbackEvent("failure", -1L, jSCallback);
                                    }
                                });
                            }
                        } catch (Exception unused) {
                        }
                    }
                });
                return;
            }
            WXLogUtils.e(TAG, "illegal argument. [overlayColor:" + str2 + jn1.ARRAY_END_STR);
            return;
        }
        WXLogUtils.e(TAG, "illegal argument. [sourceRef:" + str + ",radius:" + i + ",callback:" + jSCallback + jn1.ARRAY_END_STR);
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        FixedLongSparseArray<WeakReference<Bitmap>> fixedLongSparseArray = this.mBitmapHolders;
        if (fixedLongSparseArray != null) {
            fixedLongSparseArray.clear();
        }
        this.mBitmapHolders = null;
        Handler handler = this.mUIHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mUIHandler = null;
    }
}
