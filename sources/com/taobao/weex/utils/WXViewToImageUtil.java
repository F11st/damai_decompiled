package com.taobao.weex.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.View;
import androidx.annotation.ColorInt;
import com.taobao.weex.WXSDKManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXViewToImageUtil {
    public static int mBackgroundColor;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnImageSavedCallback {
        void onSaveFailed(String str);

        void onSaveSucceed(String str);
    }

    public static void generateImage(final View view, final int i, @ColorInt int i2, final OnImageSavedCallback onImageSavedCallback) {
        mBackgroundColor = i2;
        WXSDKManager.v().I().post(new Thread(new Runnable() { // from class: com.taobao.weex.utils.WXViewToImageUtil.1
            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmapFromImageView = WXViewToImageUtil.getBitmapFromImageView(view, i);
                if (bitmapFromImageView == null) {
                    OnImageSavedCallback onImageSavedCallback2 = onImageSavedCallback;
                    if (onImageSavedCallback2 != null) {
                        onImageSavedCallback2.onSaveFailed("Image is empty");
                        return;
                    }
                    return;
                }
                final String saveBitmapToGallery = WXViewToImageUtil.saveBitmapToGallery(view.getContext(), bitmapFromImageView, onImageSavedCallback);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.taobao.weex.utils.WXViewToImageUtil.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OnImageSavedCallback onImageSavedCallback3 = onImageSavedCallback;
                        if (onImageSavedCallback3 != null) {
                            onImageSavedCallback3.onSaveSucceed(saveBitmapToGallery);
                            view.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(saveBitmapToGallery)));
                        }
                    }
                });
            }
        }));
    }

    public static Bitmap getBitmapFromImageView(View view, int i) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
        view.setDrawingCacheEnabled(true);
        return view.getDrawingCache();
    }

    public static String saveBitmapToGallery(Context context, Bitmap bitmap, OnImageSavedCallback onImageSavedCallback) {
        File file = new File(Environment.getExternalStorageDirectory(), gn1.TYPE_OPEN_URL_WEEX);
        if (!file.exists()) {
            file.mkdir();
        }
        String str = System.currentTimeMillis() + ".jpg";
        File file2 = new File(file, str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            if (onImageSavedCallback != null) {
                onImageSavedCallback.onSaveFailed("Image creation failed due to system reason");
            }
            e.printStackTrace();
        } catch (IOException e2) {
            if (onImageSavedCallback != null) {
                onImageSavedCallback.onSaveFailed("Android IOException");
            }
            e2.printStackTrace();
        }
        try {
            MediaStore.Images.Media.insertImage(context.getContentResolver(), file2.getAbsolutePath(), str, (String) null);
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + file.getAbsolutePath() + "/" + str)));
        return file2.getAbsolutePath();
    }
}
