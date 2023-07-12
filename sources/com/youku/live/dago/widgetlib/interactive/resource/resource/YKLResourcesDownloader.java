package com.youku.live.dago.widgetlib.interactive.resource.resource;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.DownloadListener;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.Config;
import com.youku.live.dago.widgetlib.interactive.resource.prefetch.ResourceEntity;
import com.youku.live.dago.widgetlib.interactive.resource.utils.FileUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.jq1;
import tb.l41;
import tb.qc0;
import tb.sc0;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLResourcesDownloader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "YKLResourcesDownloader";
    public ConcurrentHashMap<String, YKLDownloadBean> mDownloadingList = new ConcurrentHashMap<>();

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class YklDownloadListener implements DownloadListener {
        private Map<String, YKLDownloadBean> downloadList;
        private DownloadListener listener;

        public YklDownloadListener(Map<String, YKLDownloadBean> map, DownloadListener downloadListener) {
            this.downloadList = map;
            this.listener = downloadListener;
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadError(String str, int i, String str2) {
            Map<String, YKLDownloadBean> map = this.downloadList;
            if (map != null && map.containsKey(str)) {
                this.downloadList.remove(str);
            }
            DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onDownloadError(str, i, str2);
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadFinish(String str, String str2) {
            Map<String, YKLDownloadBean> map = this.downloadList;
            if (map != null && map.containsKey(str)) {
                this.downloadList.remove(str);
            }
            DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onDownloadFinish(str, str2);
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadProgress(int i) {
            DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onDownloadProgress(i);
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onDownloadStateChange(String str, boolean z) {
            DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onDownloadStateChange(str, z);
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onFinish(boolean z) {
            DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onFinish(z);
            }
        }

        @Override // com.taobao.downloader.request.DownloadListener
        public void onNetworkLimit(int i, jq1 jq1Var, DownloadListener.NetworkLimitCallback networkLimitCallback) {
            DownloadListener downloadListener = this.listener;
            if (downloadListener != null) {
                downloadListener.onNetworkLimit(i, jq1Var, networkLimitCallback);
            }
        }
    }

    private void checkFileExist(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "162748300")) {
            ipChange.ipc$dispatch("162748300", new Object[]{this, str, str2});
            return;
        }
        FileUtils.deleteFolder(getStorePath() + File.separatorChar + str + File.separatorChar + str2);
    }

    private jq1 getParams(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-182232590")) {
            return (jq1) ipChange.ipc$dispatch("-182232590", new Object[]{this, str, Boolean.valueOf(z)});
        }
        jq1 jq1Var = new jq1();
        jq1Var.c = z ? 7 : 1;
        jq1Var.b = 10;
        jq1Var.d = 0;
        jq1Var.f = getStorePath() + File.separatorChar + str;
        jq1Var.l = z ? 5 : 2;
        return jq1Var;
    }

    private String getStorePath() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-181884315") ? (String) ipChange.ipc$dispatch("-181884315", new Object[]{this}) : YKLResourcesCacheManager.getStorePath();
    }

    public void batchDownload(Config config, DownloadListener downloadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-393286581")) {
            ipChange.ipc$dispatch("-393286581", new Object[]{this, config, downloadListener, Boolean.valueOf(z)});
            return;
        }
        Log.d(TAG, "batch_download for " + config.getNamespace());
        String namespace = config.getNamespace();
        qc0 qc0Var = new qc0();
        qc0Var.b = getParams(namespace, z);
        ArrayList arrayList = (ArrayList) ((ArrayList) config.getConfigItems()).clone();
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ResourceEntity.Resource resource = (ResourceEntity.Resource) it.next();
                l41 l41Var = new l41();
                String uri = resource.uri.toString();
                l41Var.a = uri;
                if (!this.mDownloadingList.containsKey(uri)) {
                    String str = resource.key;
                    l41Var.d = str;
                    checkFileExist(namespace, str);
                    YKLDownloadBean yKLDownloadBean = new YKLDownloadBean();
                    String str2 = l41Var.a;
                    yKLDownloadBean.url = str2;
                    this.mDownloadingList.put(str2, yKLDownloadBean);
                    arrayList2.add(l41Var);
                }
            }
            qc0Var.a = arrayList2;
        }
        sc0.c().b(qc0Var, new YklDownloadListener(this.mDownloadingList, downloadListener));
    }

    public void download(String str, String str2, DownloadListener downloadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1975833169")) {
            ipChange.ipc$dispatch("1975833169", new Object[]{this, str, str2, downloadListener, Boolean.valueOf(z)});
            return;
        }
        Log.d(TAG, "download for " + str + ", key:" + str2);
        ResourceEntity.Resource resourceConfig = YKLPrefetchManager.getInstance().getResourceConfig(str, str2);
        if (resourceConfig != null) {
            qc0 qc0Var = new qc0();
            qc0Var.a = new ArrayList();
            l41 l41Var = new l41();
            String uri = resourceConfig.uri.toString();
            l41Var.a = uri;
            if (this.mDownloadingList.containsKey(uri)) {
                return;
            }
            String str3 = resourceConfig.key;
            l41Var.d = str3;
            checkFileExist(str, str3);
            qc0Var.a.add(l41Var);
            YKLDownloadBean yKLDownloadBean = new YKLDownloadBean();
            String str4 = l41Var.a;
            yKLDownloadBean.url = str4;
            this.mDownloadingList.put(str4, yKLDownloadBean);
            qc0Var.b = getParams(str, z);
            sc0.c().b(qc0Var, new YklDownloadListener(this.mDownloadingList, downloadListener));
        }
    }

    public void download(String str, List<YKLDownloadBean> list, final YKLDownloadListener yKLDownloadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "78718673")) {
            ipChange.ipc$dispatch("78718673", new Object[]{this, str, list, yKLDownloadListener, Boolean.valueOf(z)});
            return;
        }
        qc0 qc0Var = new qc0();
        if (list != null) {
            qc0Var.a = new ArrayList();
            for (YKLDownloadBean yKLDownloadBean : list) {
                l41 l41Var = new l41();
                String str2 = yKLDownloadBean.url;
                l41Var.a = str2;
                if (!this.mDownloadingList.containsKey(str2)) {
                    String str3 = yKLDownloadBean.fileName;
                    l41Var.d = str3;
                    checkFileExist(str, str3);
                    qc0Var.a.add(l41Var);
                    this.mDownloadingList.put(l41Var.a, yKLDownloadBean);
                    qc0Var.b = getParams(str, z);
                }
            }
            Log.d("ykl-download", "start download ");
            sc0.c().b(qc0Var, new DownloadListener() { // from class: com.youku.live.dago.widgetlib.interactive.resource.resource.YKLResourcesDownloader.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.taobao.downloader.request.DownloadListener
                public void onDownloadError(String str4, int i, String str5) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "289469266")) {
                        ipChange2.ipc$dispatch("289469266", new Object[]{this, str4, Integer.valueOf(i), str5});
                        return;
                    }
                    ConcurrentHashMap<String, YKLDownloadBean> concurrentHashMap = YKLResourcesDownloader.this.mDownloadingList;
                    if (concurrentHashMap != null && concurrentHashMap.containsKey(str4)) {
                        YKLResourcesDownloader.this.mDownloadingList.remove(str4);
                    }
                    ((ILog) Dsl.getService(ILog.class)).d("ykl-download", "download error, url = " + str4);
                    ((ILog) Dsl.getService(ILog.class)).i("ykl-download", "download error, MSG = " + str5);
                    YKLDownloadListener yKLDownloadListener2 = yKLDownloadListener;
                    if (yKLDownloadListener2 != null) {
                        yKLDownloadListener2.onDownloadError(str4, i, str5);
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onDownloadFinish(String str4, String str5) {
                    String str6;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "246795698")) {
                        ipChange2.ipc$dispatch("246795698", new Object[]{this, str4, str5});
                        return;
                    }
                    YKLDownloadBean yKLDownloadBean2 = null;
                    ConcurrentHashMap<String, YKLDownloadBean> concurrentHashMap = YKLResourcesDownloader.this.mDownloadingList;
                    if (concurrentHashMap != null && concurrentHashMap.containsKey(str4)) {
                        yKLDownloadBean2 = YKLResourcesDownloader.this.mDownloadingList.remove(str4);
                    }
                    if (yKLDownloadBean2 != null) {
                        ((ILog) Dsl.getService(ILog.class)).d("liulei-download", "download finish, url = " + yKLDownloadBean2.url);
                        if (yKLDownloadBean2.isZip) {
                            if (!str5.endsWith(".zip")) {
                                str6 = str5 + ".zip";
                                new File(str5).renameTo(new File(str6));
                            }
                            new YKLAfterDownloadProcessor(str4, yKLDownloadListener).process(yKLDownloadBean2.isZip, str5);
                        } else {
                            String str7 = yKLDownloadBean2.type;
                            if (ResourceConstants.FILE_TYPE_SVGA.equals(str7)) {
                                str6 = str5 + ".svga";
                            } else if ("webp".equals(str7)) {
                                str6 = str5 + ".webp";
                            } else if ("mp4gift".equals(str7)) {
                                str6 = str5 + ".mp4";
                            } else {
                                str6 = str5;
                            }
                            new File(str5).renameTo(new File(str6));
                        }
                        str5 = str6;
                        new YKLAfterDownloadProcessor(str4, yKLDownloadListener).process(yKLDownloadBean2.isZip, str5);
                    }
                    YKLDownloadListener yKLDownloadListener2 = yKLDownloadListener;
                    if (yKLDownloadListener2 != null) {
                        yKLDownloadListener2.onDownloadFinish(str4, str5);
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onDownloadProgress(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2058471103")) {
                        ipChange2.ipc$dispatch("2058471103", new Object[]{this, Integer.valueOf(i)});
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onDownloadStateChange(String str4, boolean z2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-350040270")) {
                        ipChange2.ipc$dispatch("-350040270", new Object[]{this, str4, Boolean.valueOf(z2)});
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onFinish(boolean z2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "693401678")) {
                        ipChange2.ipc$dispatch("693401678", new Object[]{this, Boolean.valueOf(z2)});
                    }
                }

                @Override // com.taobao.downloader.request.DownloadListener
                public void onNetworkLimit(int i, jq1 jq1Var, DownloadListener.NetworkLimitCallback networkLimitCallback) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-943653462")) {
                        ipChange2.ipc$dispatch("-943653462", new Object[]{this, Integer.valueOf(i), jq1Var, networkLimitCallback});
                    }
                }
            });
        }
    }

    public void batchDownload(String str, List<ResourceEntity.Resource> list, DownloadListener downloadListener, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1518297232")) {
            ipChange.ipc$dispatch("1518297232", new Object[]{this, str, list, downloadListener, Boolean.valueOf(z)});
            return;
        }
        Log.d(TAG, "batch_download for list");
        qc0 qc0Var = new qc0();
        qc0Var.b = getParams(str, z);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (ResourceEntity.Resource resource : list) {
                l41 l41Var = new l41();
                String uri = resource.uri.toString();
                l41Var.a = uri;
                if (!this.mDownloadingList.containsKey(uri)) {
                    String str2 = resource.key;
                    l41Var.d = str2;
                    checkFileExist(str, str2);
                    YKLDownloadBean yKLDownloadBean = new YKLDownloadBean();
                    String str3 = l41Var.a;
                    yKLDownloadBean.url = str3;
                    this.mDownloadingList.put(str3, yKLDownloadBean);
                    arrayList.add(l41Var);
                }
            }
            qc0Var.a = arrayList;
        }
        sc0.c().b(qc0Var, new YklDownloadListener(this.mDownloadingList, downloadListener));
    }
}
