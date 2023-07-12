package com.ut.mini.anti_cheat;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.alibaba.analytics.utils.Logger;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class ScreenshotDetector {
    private static final long TIME_MAX = 30;
    private long changeTimestamp = 0;
    private ContentObserver contentObserver;
    private ScreenshotListener listener;
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class FileData {
        private final long date;
        private final String path;

        public FileData(String str, long j) {
            this.path = str;
            this.date = j;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface ScreenshotListener {
        void onScreenCaptured(String str);

        void onScreenCapturedWithDeniedPermission();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScreenshotDetector(Context context) {
        this.mContext = context;
        try {
            this.contentObserver = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.ut.mini.anti_cheat.ScreenshotDetector.1
                @Override // android.database.ContentObserver
                public boolean deliverSelfNotifications() {
                    return super.deliverSelfNotifications();
                }

                @Override // android.database.ContentObserver
                public void onChange(boolean z) {
                    super.onChange(z);
                }

                @Override // android.database.ContentObserver
                public void onChange(boolean z, Uri uri) {
                    Logger.d();
                    super.onChange(z, uri);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ScreenshotDetector.this.changeTimestamp > 1000) {
                        ScreenshotDetector screenshotDetector = ScreenshotDetector.this;
                        FileData filePathFromContentResolver = screenshotDetector.getFilePathFromContentResolver(screenshotDetector.mContext, uri);
                        if (ScreenshotDetector.this.isValidScreenshot(filePathFromContentResolver)) {
                            ScreenshotDetector.this.onScreenCaptured(filePathFromContentResolver.path);
                        }
                        ScreenshotDetector.this.changeTimestamp = currentTimeMillis;
                    }
                }
            };
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FileData getFilePathFromContentResolver(Context context, Uri uri) {
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_display_name", "_data", "date_added"}, null, null, "date_added DESC");
            if (query == null || !query.moveToFirst()) {
                return null;
            }
            String string = query.getString(query.getColumnIndex("_data"));
            long j = query.getLong(query.getColumnIndex("date_added"));
            query.close();
            return new FileData(string, j);
        } catch (Throwable th) {
            Logger.f("", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidScreenshot(FileData fileData) {
        if (fileData == null || TextUtils.isEmpty(fileData.path)) {
            return false;
        }
        Logger.f("", "data.path", fileData.path);
        if (fileData.path.toLowerCase().contains("screenshots")) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Logger.f("", "localtime", Long.valueOf(currentTimeMillis), "data.date", Long.valueOf(fileData.date));
        return Math.abs(currentTimeMillis - fileData.date) < TIME_MAX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onScreenCaptured(String str) {
        Logger.d();
        ScreenshotListener screenshotListener = this.listener;
        if (screenshotListener != null) {
            screenshotListener.onScreenCaptured(str);
        }
    }

    public void start(ScreenshotListener screenshotListener) {
        this.listener = screenshotListener;
        try {
            this.mContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.contentObserver);
        } catch (Throwable unused) {
        }
    }

    public void stop() {
        try {
            this.mContext.getContentResolver().unregisterContentObserver(this.contentObserver);
        } catch (Throwable unused) {
        }
    }
}
