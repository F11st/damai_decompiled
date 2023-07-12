package com.ali.user.mobile.utils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.LruCache;
import android.widget.ImageView;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes17.dex */
public class ImageUtil {
    private static LruCache<String, Bitmap> mMemoryCache = new LruCache<>(3);

    private static int calculateInSampleSize(int i, int i2, int i3) {
        double d = i3;
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > Math.min(i / d, i2 / d)) {
                return (int) f;
            }
            f = f2;
        }
    }

    public static Bitmap decodeSampledBitmapFromResource(String str, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        options.inJustDecodeBounds = false;
        options.inSampleSize = calculateInSampleSize(i2, i3, i);
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap getBitmapFromMemoryCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (mMemoryCache == null) {
            mMemoryCache = new LruCache<>(3);
        }
        return mMemoryCache.get(str);
    }

    public static void updateImage(ImageView imageView, String str) {
        updateImage(imageView, str, 640);
    }

    public static void updateImage(ImageView imageView, String str, int i) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        imageView.setVisibility(0);
        Bitmap bitmapFromMemoryCache = getBitmapFromMemoryCache(MD5Util.getMD5(str));
        if (bitmapFromMemoryCache != null) {
            imageView.setImageBitmap(bitmapFromMemoryCache);
        } else {
            new LoadImageTask(DataProviderFactory.getApplicationContext(), imageView, "HeadImages", i).execute(str);
        }
    }
}
