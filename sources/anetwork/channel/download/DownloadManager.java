package anetwork.channel.download;

import android.os.RemoteException;
import android.text.TextUtils;
import anet.channel.util.ALog;
import anetwork.channel.Header;
import anetwork.channel.aidl.Connection;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.network.util.Constants;
import tb.c22;
import tb.h01;
import tb.zh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DownloadManager {
    public static final int ERROR_DOWNLOAD_CANCELLED = -105;
    public static final int ERROR_EXCEPTION_HAPPEN = -104;
    public static final int ERROR_FILE_FOLDER_INVALID = -101;
    public static final int ERROR_FILE_RENAME_FAILED = -106;
    public static final int ERROR_IO_EXCEPTION = -103;
    public static final int ERROR_REQUEST_FAIL = -102;
    public static final int ERROR_URL_INVALID = -100;
    public static final String TAG = "anet.DownloadManager";

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface DownloadListener {
        void onFail(int i, int i2, String str);

        void onProgress(int i, long j, long j2);

        void onSuccess(int i, String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    class DownloadTask implements Runnable {
        private final String filePath;
        private final CopyOnWriteArrayList<DownloadListener> listenerList;
        final int taskId;
        final /* synthetic */ DownloadManager this$0;
        final URL url;
        private final AtomicBoolean isCancelled = new AtomicBoolean(false);
        private final AtomicBoolean isFinish = new AtomicBoolean(false);
        private volatile Connection conn = null;
        private boolean useExternalCache = true;

        DownloadTask(DownloadManager downloadManager, URL url, String str, String str2, DownloadListener downloadListener) {
            throw null;
        }

        private void notifyFail(int i, String str) {
            if (this.isFinish.compareAndSet(false, true)) {
                Iterator<DownloadListener> it = this.listenerList.iterator();
                while (it.hasNext()) {
                    it.next().onFail(this.taskId, i, str);
                }
            }
        }

        private void notifyProgress(long j, long j2) {
            if (this.isFinish.get()) {
                return;
            }
            Iterator<DownloadListener> it = this.listenerList.iterator();
            while (it.hasNext()) {
                it.next().onProgress(this.taskId, j, j2);
            }
        }

        private void notifySuccess(String str) {
            if (this.isFinish.compareAndSet(false, true)) {
                Iterator<DownloadListener> it = this.listenerList.iterator();
                while (it.hasNext()) {
                    it.next().onSuccess(this.taskId, str);
                }
            }
        }

        private long parseContentLength(int i, Map<String, List<String>> map, long j) {
            int lastIndexOf;
            try {
                if (i == 200) {
                    return Long.parseLong(h01.d(map, Constants.Protocol.CONTENT_LENGTH));
                }
                if (i == 206) {
                    String d = h01.d(map, "Content-Range");
                    long parseLong = (d == null || (lastIndexOf = d.lastIndexOf(47)) == -1) ? 0L : Long.parseLong(d.substring(lastIndexOf + 1));
                    if (parseLong == 0) {
                        try {
                            return Long.parseLong(h01.d(map, Constants.Protocol.CONTENT_LENGTH)) + j;
                        } catch (Exception unused) {
                        }
                    }
                    return parseLong;
                }
                return 0L;
            } catch (Exception unused2) {
                return 0L;
            }
        }

        private String parseFileNameForURL(URL url) {
            String path = url.getPath();
            int lastIndexOf = path.lastIndexOf(47);
            String substring = lastIndexOf != -1 ? path.substring(lastIndexOf + 1, path.length()) : null;
            if (TextUtils.isEmpty(substring)) {
                String h = zh2.h(url.toString());
                return h == null ? url.getFile() : h;
            }
            return substring;
        }

        private void removeRangeHeader(List<Header> list) {
            if (list != null) {
                ListIterator<Header> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if ("Range".equalsIgnoreCase(listIterator.next().getName())) {
                        listIterator.remove();
                        return;
                    }
                }
            }
        }

        public boolean attachListener(DownloadListener downloadListener) {
            if (this.isFinish.get()) {
                return false;
            }
            this.listenerList.add(downloadListener);
            return true;
        }

        public void cancel() {
            this.isCancelled.set(true);
            notifyFail(-105, "download canceled.");
            if (this.conn != null) {
                try {
                    this.conn.cancel();
                } catch (RemoteException unused) {
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.isCancelled.get()) {
                return;
            }
            try {
                File a = DownloadManager.a(this.this$0, this.url.toString(), this.useExternalCache);
                boolean exists = a.exists();
                c22 c22Var = new c22(this.url);
                c22Var.setRetryTime(0);
                c22Var.setFollowRedirects(true);
                if (exists) {
                    c22Var.addHeader("Range", "bytes=" + a.length() + "-");
                }
                throw null;
            } catch (Exception e) {
                ALog.d(DownloadManager.TAG, "file download failed!", null, e, new Object[0]);
                notifyFail(-104, e.toString());
                throw null;
            }
        }
    }

    static /* synthetic */ File a(DownloadManager downloadManager, String str, boolean z) {
        throw null;
    }
}
