package com.taobao.zcache.network;

import androidx.annotation.NonNull;
import com.taobao.zcache.Error;
import com.taobao.zcache.ZCache;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DownloadTask implements Runnable, Comparable<DownloadTask> {
    private static boolean supportNetworkSDK = true;
    private final DownloadFinishedCallback callback;
    private File fileCache;
    private RandomAccessFile fileCacheAccess;
    private ByteArrayOutputStream memoryCache;
    private final DownloadRequest request;
    private int retryCount = 0;
    private static final PriorityBlockingQueue<DownloadTask> waitingTasks = new PriorityBlockingQueue<>();
    private static final ExecutorService taskQueue = new ThreadPoolExecutor(1, 5, 3, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.taobao.zcache.network.DownloadTask.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ZCache.Download_" + runnable.hashCode());
        }
    }, new RejectedExecutionHandler() { // from class: com.taobao.zcache.network.DownloadTask.2
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            DownloadTask.waitingTasks.put((DownloadTask) runnable);
        }
    });

    DownloadTask(DownloadRequest downloadRequest, DownloadFinishedCallback downloadFinishedCallback) {
        this.request = downloadRequest;
        this.callback = downloadFinishedCallback;
    }

    private void adjustContentRange(String str) {
        if (str == null || !str.startsWith("bytes")) {
            return;
        }
        String[] split = str.split("[ -/]]");
        if (split.length == 4) {
            try {
                this.fileCacheAccess.seek(Long.parseLong(split[1]));
            } catch (IOException unused) {
            }
        }
    }

    private void closeFileCache() {
        RandomAccessFile randomAccessFile = this.fileCacheAccess;
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
            this.fileCacheAccess = null;
        }
    }

    private void copyFile(File file, File file2) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static String getCacheFile(@NonNull String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(ZCache.getContext().getCacheDir().getAbsolutePath());
        String str2 = File.separator;
        sb.append(str2);
        sb.append("ZCache");
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        String md5 = md5(str.getBytes());
        if (md5 == null) {
            md5 = "TEMP_FILE_" + System.currentTimeMillis();
        }
        return file + str2 + md5;
    }

    public static String md5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            byte[] digest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    sb.append(YKUpsConvert.CHAR_ZERO);
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private void prepareFileCache() throws IOException {
        File file = new File(getCacheFile(this.request.url));
        this.fileCache = file;
        if (file.isDirectory()) {
            this.fileCache.delete();
        }
        if (!this.fileCache.exists()) {
            this.fileCache.createNewFile();
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.fileCache, "rwd");
        this.fileCacheAccess = randomAccessFile;
        long length = randomAccessFile.length();
        if (length > 0) {
            this.fileCacheAccess.seek(length);
            DownloadRequest downloadRequest = this.request;
            if (downloadRequest.header == null) {
                downloadRequest.header = new HashMap<>();
            }
            HashMap<String, String> hashMap = this.request.header;
            hashMap.put("Range", "bytes=" + length + "-");
        }
    }

    private void requestFinished(int i, Map<String, String> map, Error error, String str) {
        closeFileCache();
        this.callback.onDownloadFinished(i, map, error, str);
        DownloadTask poll = waitingTasks.poll();
        if (poll != null) {
            poll.run();
        }
    }

    public static void sendRequest(DownloadRequest downloadRequest, DownloadFinishedCallback downloadFinishedCallback) {
        if (downloadFinishedCallback == null) {
            return;
        }
        if (downloadRequest != null && downloadRequest.url != null) {
            taskQueue.execute(new DownloadTask(downloadRequest, downloadFinishedCallback));
        } else {
            downloadFinishedCallback.onDownloadFinished(0, null, new Error(-1, "request \"null\" invalid URL"), null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0133, code lost:
        if (r1 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0140, code lost:
        if (r1 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0142, code lost:
        r1.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x014f  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.zcache.network.DownloadTask.run():void");
    }

    @Override // java.lang.Comparable
    public int compareTo(DownloadTask downloadTask) {
        return (this.request.tempFilePath == null ? 0 : 1) - (downloadTask.request.tempFilePath != null ? 1 : 0);
    }
}
