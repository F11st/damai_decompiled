package com.taobao.tao.log.upload;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class OSSUploadListener implements FileUploadListener {
    public String contentType;
    public String fileName;
    public String ossEndpoint;
    public String ossObjectKey;

    public OSSUploadListener() {
    }

    public OSSUploadListener(String str, String str2, String str3, String str4) {
        this.fileName = str;
        this.contentType = str2;
        this.ossObjectKey = str3;
        this.ossEndpoint = str4;
    }
}
