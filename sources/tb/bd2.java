package tb;

import com.taobao.downloader.adpater.FileCacheManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bd2 implements FileCacheManager {
    @Override // com.taobao.downloader.adpater.FileCacheManager
    public String getTmpCache() {
        return ui0.c(um.a, "download-sdk/tmp");
    }
}
