package com.taobao.android.dinamicx.util;

import android.graphics.Typeface;
import android.os.Looper;
import android.util.LruCache;
import com.taobao.android.dinamicx.DinamicXEngine;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import tb.y00;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class FontUtil {
    private LruCache<String, Typeface> a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class FontRunnable implements Runnable {
        String font;
        int fontStyle;
        CountDownLatch latch;
        Typeface tf;

        public FontRunnable(CountDownLatch countDownLatch, String str, int i) {
            this.latch = countDownLatch;
            this.font = str;
            this.fontStyle = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Typeface createFromAsset = Typeface.createFromAsset(DinamicXEngine.i().getAssets(), this.font);
                FontUtil.this.a.put(this.font, createFromAsset);
                this.tf = Typeface.create(createFromAsset, this.fontStyle);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.util.FontUtil$b */
    /* loaded from: classes12.dex */
    public static class C6405b {
        private static final FontUtil a = new FontUtil();
    }

    public static final FontUtil c() {
        return C6405b.a;
    }

    public Typeface b(String str, int i) throws InterruptedException {
        Typeface typeface = this.a.get(str);
        if (typeface != null) {
            return typeface;
        }
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            Typeface createFromAsset = Typeface.createFromAsset(DinamicXEngine.i().getAssets(), str);
            this.a.put(str, createFromAsset);
            return Typeface.create(createFromAsset, i);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        FontRunnable fontRunnable = new FontRunnable(countDownLatch, str, i);
        y00.o(fontRunnable);
        countDownLatch.await(2L, TimeUnit.SECONDS);
        return fontRunnable.tf;
    }

    private FontUtil() {
        this.a = null;
        this.a = new LruCache<>(5);
    }
}
