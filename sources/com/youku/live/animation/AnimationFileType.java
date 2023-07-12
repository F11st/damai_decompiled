package com.youku.live.animation;

import com.youku.live.dago.widgetlib.interactive.resource.resource.ResourceConstants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public enum AnimationFileType {
    TYPE_SVGA(0, ResourceConstants.FILE_TYPE_SVGA),
    TYPE_LOTTIE(1, "lottie");
    
    private String fileName;
    private int fileType;

    AnimationFileType(int i, String str) {
        this.fileType = i;
        this.fileName = str;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getFileType() {
        return this.fileType;
    }
}
