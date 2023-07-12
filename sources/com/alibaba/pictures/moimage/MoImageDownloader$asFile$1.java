package com.alibaba.pictures.moimage;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.File;
import kotlin.Metadata;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/wt2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class MoImageDownloader$asFile$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ DownloadImgListener $downloadImgListener;
    final /* synthetic */ MoImageDownloader this$0;

    MoImageDownloader$asFile$1(MoImageDownloader moImageDownloader, DownloadImgListener downloadImgListener) {
        this.this$0 = moImageDownloader;
        this.$downloadImgListener = downloadImgListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        File h;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1933930082")) {
            ipChange.ipc$dispatch("1933930082", new Object[]{this});
            return;
        }
        try {
            MoImageDownloader moImageDownloader = this.this$0;
            h = moImageDownloader.h(moImageDownloader.a);
            if (h != null && h.exists()) {
                DownloadImgListener downloadImgListener = this.$downloadImgListener;
                if (downloadImgListener != null) {
                    downloadImgListener.onDownloaded(this.this$0.a, h);
                }
            }
            DownloadImgListener downloadImgListener2 = this.$downloadImgListener;
            if (downloadImgListener2 != null) {
                MoImageLoadException moImageLoadException = new MoImageLoadException("file==null");
                downloadImgListener2.onFail(moImageLoadException, "fullUrl=" + this.this$0.a);
            }
        } catch (Exception e) {
            DownloadImgListener downloadImgListener3 = this.$downloadImgListener;
            if (downloadImgListener3 != null) {
                MoImageLoadException moImageLoadException2 = new MoImageLoadException(e);
                downloadImgListener3.onFail(moImageLoadException2, "fullUrl=" + this.this$0.a);
            }
        }
    }
}
