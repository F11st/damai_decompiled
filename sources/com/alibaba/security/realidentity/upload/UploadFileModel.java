package com.alibaba.security.realidentity.upload;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class UploadFileModel implements Serializable {
    private String mDestDir;
    private String mFileType;
    private byte[] mLocalFileDatas;
    private String mLocalFilePath;
    private String mRemoteFileName;

    public String getDestDir() {
        return this.mDestDir;
    }

    public String getFileType() {
        return this.mFileType;
    }

    public String getLocalFilePath() {
        return this.mLocalFilePath;
    }

    public String getRemoteFileName() {
        return this.mRemoteFileName;
    }

    public void setDestDir(String str) {
        this.mDestDir = str;
    }

    public void setFileType(String str) {
        this.mFileType = str;
    }

    public void setLocalFilePath(String str) {
        this.mLocalFilePath = str;
    }

    public void setRemoteFileName(String str) {
        this.mRemoteFileName = str;
    }
}
