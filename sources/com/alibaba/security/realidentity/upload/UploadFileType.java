package com.alibaba.security.realidentity.upload;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum UploadFileType {
    ARUP(1, "内部arup上传"),
    OSS(2, "外部oss上传");
    
    public String desc;
    public int type;

    UploadFileType(int i, String str) {
        this.type = i;
        this.desc = str;
    }
}
