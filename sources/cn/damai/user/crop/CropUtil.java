package cn.damai.user.crop;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import cn.damai.user.crop.MonitoredActivity;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.log.TLogConstant;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import tb.sa1;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class CropUtil {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static class BackgroundJob extends MonitoredActivity.C2684a implements Runnable {
        private static transient /* synthetic */ IpChange $ipChange;
        private final MonitoredActivity activity;
        private final Runnable cleanupRunner = new Runnable() { // from class: cn.damai.user.crop.CropUtil.BackgroundJob.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-586506046")) {
                    ipChange.ipc$dispatch("-586506046", new Object[]{this});
                    return;
                }
                BackgroundJob.this.activity.b(BackgroundJob.this);
                if (BackgroundJob.this.dialog.getWindow() != null) {
                    BackgroundJob.this.dialog.dismiss();
                }
            }
        };
        private final ProgressDialog dialog;
        private final Handler handler;
        private final Runnable job;

        public BackgroundJob(MonitoredActivity monitoredActivity, Runnable runnable, ProgressDialog progressDialog, Handler handler) {
            this.activity = monitoredActivity;
            this.dialog = progressDialog;
            this.job = runnable;
            monitoredActivity.a(this);
            this.handler = handler;
        }

        @Override // cn.damai.user.crop.MonitoredActivity.C2684a, cn.damai.user.crop.MonitoredActivity.LifeCycleListener
        public void onActivityDestroyed(MonitoredActivity monitoredActivity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1337011884")) {
                ipChange.ipc$dispatch("1337011884", new Object[]{this, monitoredActivity});
                return;
            }
            this.cleanupRunner.run();
            this.handler.removeCallbacks(this.cleanupRunner);
        }

        @Override // cn.damai.user.crop.MonitoredActivity.C2684a, cn.damai.user.crop.MonitoredActivity.LifeCycleListener
        public void onActivityStarted(MonitoredActivity monitoredActivity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-221810172")) {
                ipChange.ipc$dispatch("-221810172", new Object[]{this, monitoredActivity});
            } else {
                this.dialog.show();
            }
        }

        @Override // cn.damai.user.crop.MonitoredActivity.C2684a, cn.damai.user.crop.MonitoredActivity.LifeCycleListener
        public void onActivityStopped(MonitoredActivity monitoredActivity) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-698481096")) {
                ipChange.ipc$dispatch("-698481096", new Object[]{this, monitoredActivity});
            } else {
                this.dialog.hide();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1888182511")) {
                ipChange.ipc$dispatch("1888182511", new Object[]{this});
                return;
            }
            try {
                this.job.run();
            } finally {
                this.handler.post(this.cleanupRunner);
            }
        }
    }

    public static void a(@Nullable Closeable closeable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1486676320")) {
            ipChange.ipc$dispatch("-1486676320", new Object[]{closeable});
        } else if (closeable == null) {
        } else {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean b(File file, File file2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374836500")) {
            return ((Boolean) ipChange.ipc$dispatch("374836500", new Object[]{file, file2})).booleanValue();
        }
        if (file != null && file2 != null) {
            try {
                ExifInterface exifInterface = new ExifInterface(file.getAbsolutePath());
                ExifInterface exifInterface2 = new ExifInterface(file2.getAbsolutePath());
                exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION));
                exifInterface2.saveAttributes();
                return true;
            } catch (IOException e) {
                sa1.a("Error copying Exif data", e);
            }
        }
        return false;
    }

    public static int c(File file) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2009184789")) {
            return ((Integer) ipChange.ipc$dispatch("-2009184789", new Object[]{file})).intValue();
        }
        if (file == null) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(file.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    if (attributeInt != 8) {
                        return 0;
                    }
                    return AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
                }
                return 90;
            }
            return 180;
        } catch (IOException e) {
            sa1.a("Error getting Exif data", e);
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x008e, code lost:
        if (r3 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0094, code lost:
        if (r3 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0096, code lost:
        r3.close();
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File d(android.content.Context r9, android.content.ContentResolver r10, android.net.Uri r11) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.user.crop.CropUtil.$ipChange
            java.lang.String r1 = "116361715"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L1d
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r9
            r9 = 1
            r2[r9] = r10
            r9 = 2
            r2[r9] = r11
            java.lang.Object r9 = r0.ipc$dispatch(r1, r2)
            java.io.File r9 = (java.io.File) r9
            return r9
        L1d:
            r0 = 0
            if (r11 != 0) goto L21
            return r0
        L21:
            java.lang.String r1 = r11.getScheme()
            java.lang.String r2 = "file"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L37
            java.io.File r9 = new java.io.File
            java.lang.String r10 = r11.getPath()
            r9.<init>(r10)
            return r9
        L37:
            java.lang.String r1 = r11.getScheme()
            java.lang.String r2 = "content"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto Laa
            java.lang.String r1 = "_data"
            java.lang.String r2 = "_display_name"
            java.lang.String[] r5 = new java.lang.String[]{r1, r2}
            r6 = 0
            r7 = 0
            r8 = 0
            r3 = r10
            r4 = r11
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L91 java.lang.SecurityException -> L93 java.lang.IllegalArgumentException -> L9a
            if (r3 == 0) goto L8e
            boolean r4 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            if (r4 == 0) goto L8e
            java.lang.String r4 = r11.toString()     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            java.lang.String r5 = "content://com.google.android.gallery3d"
            boolean r4 = r4.startsWith(r5)     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            if (r4 == 0) goto L6d
            int r1 = r3.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            goto L71
        L6d:
            int r1 = r3.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
        L71:
            r2 = -1
            if (r1 == r2) goto L8e
            java.lang.String r1 = r3.getString(r1)     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            if (r2 != 0) goto L8e
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L87 java.lang.SecurityException -> L8a java.lang.IllegalArgumentException -> L8c
            r3.close()
            return r2
        L87:
            r9 = move-exception
            r0 = r3
            goto La4
        L8a:
            goto L94
        L8c:
            r0 = r3
            goto L9a
        L8e:
            if (r3 == 0) goto Laa
            goto L96
        L91:
            r9 = move-exception
            goto La4
        L93:
            r3 = r0
        L94:
            if (r3 == 0) goto Laa
        L96:
            r3.close()
            goto Laa
        L9a:
            java.io.File r9 = e(r9, r10, r11)     // Catch: java.lang.Throwable -> L91
            if (r0 == 0) goto La3
            r0.close()
        La3:
            return r9
        La4:
            if (r0 == 0) goto La9
            r0.close()
        La9:
            throw r9
        Laa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.user.crop.CropUtil.d(android.content.Context, android.content.ContentResolver, android.net.Uri):java.io.File");
    }

    @Nullable
    private static File e(Context context, ContentResolver contentResolver, Uri uri) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "681833109")) {
            return (File) ipChange.ipc$dispatch("681833109", new Object[]{context, contentResolver, uri});
        }
        FileInputStream fileInputStream2 = null;
        if (uri == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(contentResolver.openFileDescriptor(uri, UploadQueueMgr.MSGTYPE_REALTIME).getFileDescriptor());
            try {
                String f = f(context);
                fileOutputStream = new FileOutputStream(f);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            File file = new File(f);
                            a(fileInputStream);
                            a(fileOutputStream);
                            return file;
                        }
                    }
                } catch (IOException unused) {
                    a(fileInputStream);
                    a(fileOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    a(fileInputStream2);
                    a(fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    private static String f(Context context) throws IOException {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1087356244") ? (String) ipChange.ipc$dispatch("-1087356244", new Object[]{context}) : File.createTempFile("image", TLogConstant.RUBBISH_DIR, context.getCacheDir()).getAbsolutePath();
    }

    public static void g(MonitoredActivity monitoredActivity, String str, String str2, Runnable runnable, Handler handler) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1325448745")) {
            ipChange.ipc$dispatch("-1325448745", new Object[]{monitoredActivity, str, str2, runnable, handler});
        } else {
            new Thread(new BackgroundJob(monitoredActivity, runnable, ProgressDialog.show(monitoredActivity, str, str2, true, false), handler)).start();
        }
    }
}
