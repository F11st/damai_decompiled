package com.youku.live.dago.widgetlib.protocol;

import com.youku.live.dago.widgetlib.interactive.resource.resource.YKLDownloadBean;
import com.youku.live.dago.widgetlib.wedome.adapter.download.IDownloadCallback;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface YKLDownloadProtocol {
    List<YKLDownloadBean> checkResourceList(List<YKLDownloadBean> list);

    void download(List<YKLDownloadBean> list, IDownloadCallback iDownloadCallback);

    void setNameSpace(String str);
}
