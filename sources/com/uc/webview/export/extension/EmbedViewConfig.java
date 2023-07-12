package com.uc.webview.export.extension;

import com.uc.webview.export.annotations.Interface;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
@Interface
/* loaded from: classes11.dex */
public class EmbedViewConfig {
    public int mEmbedViewID;
    public int mHeight;
    public boolean mIsCurrentPage;
    public Map mObjectParam = new HashMap();
    public String mType;
    public int mWidth;

    public EmbedViewConfig(int i, int i2, int i3, String str, String[] strArr, String[] strArr2, boolean z) {
        this.mType = str;
        this.mHeight = i;
        this.mWidth = i2;
        this.mEmbedViewID = i3;
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (i4 < strArr2.length) {
                this.mObjectParam.put(strArr[i4], strArr2[i4]);
            }
        }
        this.mIsCurrentPage = z;
    }

    public String toString() {
        return "height=" + this.mHeight + ", width=" + this.mWidth + ", id=" + this.mEmbedViewID + ", type = " + this.mType + ", mIsCurrentPage = " + this.mIsCurrentPage;
    }
}
