package com.taobao.update.apk;

import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MainUpdateData implements Serializable {
    public long applicationId;
    public long batchId;
    public String channelNum;
    public String etag;
    public String httpsUrl;
    public String info;
    public String md5;
    public String packageUrl;
    public long productId;
    public int remindCount;
    public int remindStrategy;
    public long size;
    public String version;

    public String getDownloadUrl() {
        if (!TextUtils.isEmpty(this.httpsUrl)) {
            return this.httpsUrl;
        }
        return this.packageUrl;
    }
}
