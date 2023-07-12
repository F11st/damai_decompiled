package tb;

import com.taobao.downloader.adpater.DownloadFactory;
import com.taobao.downloader.download.IDownloader;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ad2 implements DownloadFactory {
    @Override // com.taobao.downloader.adpater.DownloadFactory
    public IDownloader getDownloader(jq1 jq1Var) {
        if (1 == jq1Var.g) {
            return new er();
        }
        return new m50();
    }
}
