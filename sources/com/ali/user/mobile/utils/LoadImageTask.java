package com.ali.user.mobile.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ListView;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoadImageTask extends AsyncTask<String, Void, Bitmap> {
    private boolean forceRefreshCache;
    private Context mContext;
    private String mImageUrl;
    private ImageView mImageView;
    private int mLimitSize;
    private ListView mListView;
    private String mTargetDir;

    public LoadImageTask(Context context, ImageView imageView, String str, int i) {
        this.mLimitSize = 160;
        this.forceRefreshCache = false;
        this.mContext = context;
        this.mImageView = imageView;
        this.mTargetDir = str;
        this.mLimitSize = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f A[Catch: IOException -> 0x00a3, TRY_ENTER, TryCatch #10 {IOException -> 0x00a3, blocks: (B:35:0x006f, B:37:0x0074, B:44:0x0089, B:56:0x009f, B:60:0x00a7, B:68:0x00be, B:38:0x0077, B:40:0x007d, B:62:0x00ac, B:64:0x00b2), top: B:90:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a7 A[Catch: IOException -> 0x00a3, TRY_LEAVE, TryCatch #10 {IOException -> 0x00a3, blocks: (B:35:0x006f, B:37:0x0074, B:44:0x0089, B:56:0x009f, B:60:0x00a7, B:68:0x00be, B:38:0x0077, B:40:0x007d, B:62:0x00ac, B:64:0x00b2), top: B:90:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ac A[Catch: all -> 0x00ba, TRY_ENTER, TryCatch #10 {IOException -> 0x00a3, blocks: (B:35:0x006f, B:37:0x0074, B:44:0x0089, B:56:0x009f, B:60:0x00a7, B:68:0x00be, B:38:0x0077, B:40:0x007d, B:62:0x00ac, B:64:0x00b2), top: B:90:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d1 A[Catch: IOException -> 0x00cd, TRY_LEAVE, TryCatch #9 {IOException -> 0x00cd, blocks: (B:74:0x00c9, B:78:0x00d1, B:86:0x00e8, B:80:0x00d6, B:82:0x00dc), top: B:102:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d6 A[Catch: all -> 0x00e4, TRY_ENTER, TryCatch #9 {IOException -> 0x00cd, blocks: (B:74:0x00c9, B:78:0x00d1, B:86:0x00e8, B:80:0x00d6, B:82:0x00dc), top: B:102:0x00c9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void downloadImage(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.mobile.utils.LoadImageTask.downloadImage(java.lang.String):void");
    }

    private String getImagePath(String str) {
        String str2 = this.mContext.getCacheDir().getPath() + "/" + this.mTargetDir + "/";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2 + MD5Util.getMD5(str);
    }

    private Bitmap loadImage(String str) {
        Bitmap decodeSampledBitmapFromResource;
        File file = new File(getImagePath(str));
        if (!file.exists() || this.forceRefreshCache) {
            downloadImage(str);
        }
        if (str == null || (decodeSampledBitmapFromResource = ImageUtil.decodeSampledBitmapFromResource(file.getAbsolutePath(), this.mLimitSize)) == null) {
            return null;
        }
        return decodeSampledBitmapFromResource;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Bitmap doInBackground(String... strArr) {
        String str = strArr[0];
        this.mImageUrl = str;
        return loadImage(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ImageView imageView;
        if (bitmap != null) {
            ImageView imageView2 = this.mImageView;
            if (imageView2 != null) {
                imageView2.setImageBitmap(bitmap);
            }
            ListView listView = this.mListView;
            if (listView == null || (imageView = (ImageView) listView.findViewWithTag(this.mImageUrl)) == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
        }
    }

    public LoadImageTask(Context context, ListView listView, String str, int i, boolean z) {
        this.mLimitSize = 160;
        this.forceRefreshCache = false;
        this.mContext = context;
        this.mListView = listView;
        this.mTargetDir = str;
        this.mLimitSize = i;
        this.forceRefreshCache = z;
    }
}
