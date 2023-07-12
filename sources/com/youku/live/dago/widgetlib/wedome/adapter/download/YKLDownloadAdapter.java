package com.youku.live.dago.widgetlib.wedome.adapter.download;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.DownloadListener;
import com.youku.live.dago.widgetlib.interactive.resource.resource.YKLDownloadBean;
import com.youku.live.dago.widgetlib.interactive.resource.resource.YKLDownloadListener;
import com.youku.live.dago.widgetlib.interactive.resource.resource.YKLResourceManager;
import com.youku.live.dago.widgetlib.interactive.resource.resource.YKLResourcesCacheManager;
import com.youku.live.dago.widgetlib.interactive.resource.utils.ResourceOrangeUtils;
import com.youku.live.dago.widgetlib.protocol.YKLDownloadProtocol;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.List;
import tb.jq1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLDownloadAdapter implements YKLDownloadProtocol {
    private static transient /* synthetic */ IpChange $ipChange;
    private String mNameSpace = "youku";

    @Override // com.youku.live.dago.widgetlib.protocol.YKLDownloadProtocol
    public List<YKLDownloadBean> checkResourceList(List<YKLDownloadBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1532642740")) {
            return (List) ipChange.ipc$dispatch("1532642740", new Object[]{this, list});
        }
        if (list != null) {
            ((ILog) Dsl.getService(ILog.class)).i("ykl-download", "download list size = " + list.size());
        }
        return YKLResourcesCacheManager.checkResourceList("youku", list);
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLDownloadProtocol
    public void download(List<YKLDownloadBean> list, final IDownloadCallback iDownloadCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "356133824")) {
            ipChange.ipc$dispatch("356133824", new Object[]{this, list, iDownloadCallback});
        } else if (list == null || list.size() == 0) {
        } else {
            YKLResourceManager.getInstance().reloadResouce(this.mNameSpace, list, new YKLDownloadListener() { // from class: com.youku.live.dago.widgetlib.wedome.adapter.download.YKLDownloadAdapter.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.downloader.request.DownloadListener
                public void onDownloadError(String str, int i, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2011571173")) {
                        ipChange2.ipc$dispatch("-2011571173", new Object[]{this, str, Integer.valueOf(i), str2});
                        return;
                    }
                    IDownloadCallback iDownloadCallback2 = iDownloadCallback;
                    if (iDownloadCallback2 != null) {
                        iDownloadCallback2.onFailure(2001, str, "download error");
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onDownloadFinish(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2054244741")) {
                        ipChange2.ipc$dispatch("-2054244741", new Object[]{this, str, str2});
                        return;
                    }
                    IDownloadCallback iDownloadCallback2 = iDownloadCallback;
                    if (iDownloadCallback2 != null) {
                        iDownloadCallback2.onSuccess(1000, str, "download success");
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onDownloadProgress(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-753255210")) {
                        ipChange2.ipc$dispatch("-753255210", new Object[]{this, Integer.valueOf(i)});
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onDownloadStateChange(String str, boolean z) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "499375483")) {
                        ipChange2.ipc$dispatch("499375483", new Object[]{this, str, Boolean.valueOf(z)});
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onFinish(boolean z) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "662589221")) {
                        ipChange2.ipc$dispatch("662589221", new Object[]{this, Boolean.valueOf(z)});
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onNetworkLimit(int i, jq1 jq1Var, DownloadListener.NetworkLimitCallback networkLimitCallback) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1750797695")) {
                        ipChange2.ipc$dispatch("-1750797695", new Object[]{this, Integer.valueOf(i), jq1Var, networkLimitCallback});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.resource.resource.YKLDownloadListener
                public void onProcessFailure(String str, int i, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "558977116")) {
                        ipChange2.ipc$dispatch("558977116", new Object[]{this, str, Integer.valueOf(i), str2});
                        return;
                    }
                    IDownloadCallback iDownloadCallback2 = iDownloadCallback;
                    if (iDownloadCallback2 != null) {
                        iDownloadCallback2.onFailure(2002, str, "unzip error");
                    }
                }

                @Override // com.youku.live.dago.widgetlib.interactive.resource.resource.YKLDownloadListener
                public void onProcessSuccess(String str, int i, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2144907733")) {
                        ipChange2.ipc$dispatch("2144907733", new Object[]{this, str, Integer.valueOf(i), str2});
                    }
                }
            }, ResourceOrangeUtils.isBatchDownLoadIn4G());
        }
    }

    @Override // com.youku.live.dago.widgetlib.protocol.YKLDownloadProtocol
    public void setNameSpace(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1460165883")) {
            ipChange.ipc$dispatch("-1460165883", new Object[]{this, str});
        } else {
            this.mNameSpace = str;
        }
    }
}
