package com.taobao.tao.log.upload;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UploadQueue {
    private String TAG;
    private Map<String, FileUploadListener> fileUploadListenerMap;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class CreateInstance {
        private static UploadQueue instance = new UploadQueue();

        private CreateInstance() {
        }
    }

    public static synchronized UploadQueue getInstance() {
        UploadQueue uploadQueue;
        synchronized (UploadQueue.class) {
            uploadQueue = CreateInstance.instance;
        }
        return uploadQueue;
    }

    public FileUploadListener popListener(String str) {
        FileUploadListener fileUploadListener = this.fileUploadListenerMap.get(str);
        if (fileUploadListener != null) {
            this.fileUploadListenerMap.remove(str);
            return fileUploadListener;
        }
        return null;
    }

    public void pushListener(String str, FileUploadListener fileUploadListener) {
        if (str == null || fileUploadListener == null) {
            return;
        }
        this.fileUploadListenerMap.put(str, fileUploadListener);
    }

    private UploadQueue() {
        this.TAG = "TLOG.UploadQueue";
        this.fileUploadListenerMap = new ConcurrentHashMap();
    }
}
