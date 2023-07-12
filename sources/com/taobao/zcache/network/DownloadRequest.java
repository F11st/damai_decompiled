package com.taobao.zcache.network;

import androidx.annotation.Keep;
import java.util.HashMap;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class DownloadRequest {
    public String url = null;
    public int timeout = 0;
    public String tempFilePath = null;
    public HashMap<String, String> header = null;
    public String traceId = null;
    public boolean fetchResponseHeader = false;
}
