package com.taobao.phenix.cache.memory;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.Map;
import java.util.WeakHashMap;
import tb.ef;
import tb.jn1;
import tb.m12;
import tb.md2;
import tb.tq1;
import tb.xt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StaticCachedImage extends ef {
    private static final Map<Bitmap, Map<StaticCachedImage, Boolean>> l = new WeakHashMap(300);
    final Bitmap i;
    final Rect j;
    private StaticImageRecycleListener k;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface StaticImageRecycleListener {
        void recycle(StaticCachedImage staticCachedImage);
    }

    public StaticCachedImage(Bitmap bitmap, Rect rect, String str, String str2, int i, int i2) {
        super(str, str2, i, i2);
        this.i = bitmap;
        this.j = rect;
        k();
        xt2.a(a.TAG_RECYCLE, "new image=%s", this);
    }

    private void k() {
        Map<Bitmap, Map<StaticCachedImage, Boolean>> map = l;
        synchronized (map) {
            Map<StaticCachedImage, Boolean> map2 = map.get(this.i);
            if (map2 == null) {
                map2 = new WeakHashMap<>(1);
                map.put(this.i, map2);
            }
            map2.put(this, Boolean.TRUE);
        }
    }

    @Override // tb.ef
    public int c() {
        return md2.b(this.i);
    }

    @Override // tb.ef
    protected tq1 d(String str, String str2, int i, int i2, boolean z, Resources resources) {
        if (z) {
            return new m12(resources, this.i, this.j, str, str2, i, i2);
        }
        return new tq1(resources, this.i, this.j, str, str2, i, i2);
    }

    @Override // tb.ef
    protected void f() {
        boolean z;
        StaticImageRecycleListener staticImageRecycleListener;
        Map<Bitmap, Map<StaticCachedImage, Boolean>> map = l;
        synchronized (map) {
            Map<StaticCachedImage, Boolean> map2 = map.get(this.i);
            boolean z2 = true;
            z = false;
            if (map2 != null) {
                map2.remove(this);
                int size = map2.size();
                if (size == 0) {
                    map.remove(this.i);
                    xt2.a(a.TAG_RECYCLE, "bitmap in the image can be recycled now, image=%s", this);
                } else {
                    xt2.i(a.TAG_RECYCLE, "cannot recycled the image(bitmap referenced by %d image still), image=%s", Integer.valueOf(size), this);
                    z2 = false;
                }
                z = z2;
            } else {
                xt2.i(a.TAG_RECYCLE, "cannot recycled the image(bitmap has been recycled ever), image=%s", this);
            }
        }
        if (!z || (staticImageRecycleListener = this.k) == null) {
            return;
        }
        staticImageRecycleListener.recycle(this);
    }

    @Override // tb.ef
    protected void g() {
        xt2.a(a.TAG_RECYCLE, "image change to not recycled, image=%s", this);
        k();
    }

    public StaticCachedImage l(StaticImageRecycleListener staticImageRecycleListener) {
        this.k = staticImageRecycleListener;
        return this;
    }

    @Override // tb.ef
    public String toString() {
        return "StaticCachedImage(" + Integer.toHexString(hashCode()) + ", bmp@" + this.i + ", key@" + b() + jn1.BRACKET_END_STR;
    }
}
