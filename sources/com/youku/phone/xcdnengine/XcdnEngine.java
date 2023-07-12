package com.youku.phone.xcdnengine;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import anet.channel.status.NetworkStatusHelper;
import com.taobao.application.common.Apm;
import com.taobao.application.common.b;
import com.taobao.orange.OrangeConfig;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.tencent.open.apireq.BaseResp;
import com.youku.phone.xcdn.api.IXcdnCallback;
import com.youku.phone.xcdnengine.NetworkBroadcastReceiver;
import com.youku.phone.xcdnengine.statistics.DownloadEnd;
import com.youku.phone.xcdnengine.statistics.DownloadStart;
import com.youku.phone.xcdnengine.statistics.Keys;
import com.youku.phone.xcdnengine.utils.KVString;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
@Keep
/* loaded from: classes13.dex */
public class XcdnEngine {
    private static final int CLEAN_TASK_DELAY = 120000;
    private static final String DOWNLOADER_DIR_SUFFIX = "/xcdn/";
    private static final String FEED_DIR = "/xcdn-feed/";
    private static final String LOCAL_DIR = "/xcdn-file/";
    private static final int MAX_STORAGE_SIZE = 200;
    private static final int MAX_STORAGE_SIZE_FEED = 200;
    private static final String TAG = "XcdnEngine";
    private static final String TLOG_PREFIX = "[Xcdn]  ";
    private static Runnable cleanTask;
    private static int limit;
    private static String localDir;
    private static CopyOnWriteArrayList<DownloadItem> mDownloadItems;
    private static volatile boolean mInitialized;
    private static NetworkBroadcastReceiver mNetworkReceiver;
    private static Handler mWorkerHandler;
    private static HandlerThread mWorkerThread;
    private static volatile NetworkBroadcastReceiver.NetType netType;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface Callback extends IXcdnCallback {
        @Override // com.youku.phone.xcdn.api.IXcdnCallback
        void onEvent(long j, int i, int i2, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class DownloadItem {
        String backupPath;
        IXcdnCallback callback;
        DownloadEnd downloadEnd;
        long handle;
        String savePath;
        int useBackup;

        private DownloadItem() {
        }

        public String toString() {
            return "[DownloadItem] handle=" + this.handle + " savePath=" + this.savePath;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes13.dex */
    public static class XcdnHandler extends Handler {
        public XcdnHandler(Looper looper) {
            super(looper);
        }

        private boolean handleFinish(Message message) {
            int i;
            Iterator it = XcdnEngine.mDownloadItems.iterator();
            boolean z = false;
            while (it.hasNext()) {
                DownloadItem downloadItem = (DownloadItem) it.next();
                if (downloadItem.handle == message.arg1) {
                    KVString Parse = new KVString((String) message.obj).Parse(";", ":");
                    String str = "net_type=" + XcdnEngine.netType.ordinal() + ",net_connected=" + NetworkStatusHelper.n() + ",backup=" + downloadItem.useBackup + "," + Parse.getStringValue(Keys.NAME);
                    int i2 = message.arg2;
                    if (i2 == 32) {
                        long longValue = Parse.getLongValue("cost").longValue();
                        if (downloadItem.useBackup != 1 || TextUtils.isEmpty(downloadItem.backupPath) || TextUtils.isEmpty(downloadItem.savePath) || Utils.copFile(downloadItem.backupPath, downloadItem.savePath)) {
                            i = 0;
                        } else {
                            AdapterForTLog.loge(XcdnEngine.TAG, "copy file failed !");
                            Log.e(XcdnEngine.TAG, "copy file failed !");
                            i = -3000;
                            message.arg2 = -3000;
                        }
                        DownloadEnd downloadEnd = downloadItem.downloadEnd;
                        if (downloadEnd != null) {
                            downloadEnd.setError(String.valueOf(i)).setCost(String.valueOf(longValue)).setFile(str, Parse.getStringValue(Keys.FILE_SIZE)).setSpeed(Parse.getStringValue(Keys.AVG_SPEED)).setTraffic(Parse.getStringValue(Keys.T1), Parse.getStringValue(Keys.T2), Parse.getStringValue(Keys.T3), Parse.getStringValue(Keys.T8)).report();
                        }
                    } else {
                        DownloadEnd downloadEnd2 = downloadItem.downloadEnd;
                        if (downloadEnd2 != null) {
                            downloadEnd2.setError(String.valueOf(i2)).setFile(str, "0").setTraffic("0", "0", "0", "0").report();
                        }
                    }
                    IXcdnCallback iXcdnCallback = downloadItem.callback;
                    if (iXcdnCallback != null) {
                        iXcdnCallback.onEvent(message.arg1, message.what, message.arg2, (String) message.obj);
                    }
                    XcdnEngine.mDownloadItems.remove(downloadItem);
                    z = true;
                }
            }
            return z;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IXcdnCallback iXcdnCallback;
            int i = message.what;
            if (i != 7) {
                if (i == 8) {
                    try {
                        if (handleFinish(message)) {
                            return;
                        }
                        Message obtain = Message.obtain(message);
                        obtain.what = 1008;
                        sendMessageDelayed(obtain, 100L);
                        Log.e(XcdnEngine.TAG, "send finish message again:" + message);
                        AdapterForTLog.loge(XcdnEngine.TAG, "send finish message again !!!! " + message.what);
                        return;
                    } catch (Exception e) {
                        AdapterForTLog.loge(XcdnEngine.TAG, "send finish message exception:" + e);
                        return;
                    }
                } else if (i != 9) {
                    if (i != 11) {
                        if (i != 1008) {
                            return;
                        }
                        AdapterForTLog.loge(XcdnEngine.TAG, "process finish_1008 message !!!");
                        handleFinish(message);
                        return;
                    }
                    String str = (String) message.obj;
                    int indexOf = str.indexOf("url:");
                    KVString Parse = new KVString(str.substring(0, indexOf)).Parse(";", ":");
                    String str2 = "net_type=" + XcdnEngine.netType.ordinal() + ",net_connected=" + NetworkStatusHelper.n() + ",backup=1," + Parse.getStringValue(Keys.NAME);
                    DownloadEnd downloadEnd = new DownloadEnd();
                    String substring = str.substring(indexOf + 4);
                    String substring2 = substring.substring(0, substring.length() - 1);
                    downloadEnd.setUrl(substring2).setBizId(Parse.getIntegerValue(Keys.BIZ_ID).intValue()).setVersion(Utils.getVersion(BuildConfig.BUILD_SDK_VERSION)).setDomain(Utils.getDomain(substring2));
                    int i2 = message.arg2;
                    if (i2 == 32) {
                        downloadEnd.setError("0").setCost(String.valueOf(Parse.getLongValue("cost").longValue())).setFile(str2, Parse.getStringValue(Keys.FILE_SIZE)).setSpeed(Parse.getStringValue(Keys.AVG_SPEED)).setTraffic(Parse.getStringValue(Keys.T1), Parse.getStringValue(Keys.T2), Parse.getStringValue(Keys.T3), Parse.getStringValue(Keys.T8)).report();
                        return;
                    } else {
                        downloadEnd.setError(String.valueOf(i2)).setFile(str2, "0").setTraffic("0", "0", "0", "0").report();
                        return;
                    }
                }
            }
            Iterator it = XcdnEngine.mDownloadItems.iterator();
            while (it.hasNext()) {
                DownloadItem downloadItem = (DownloadItem) it.next();
                long j = downloadItem.handle;
                int i3 = message.arg1;
                if (j == i3 && (iXcdnCallback = downloadItem.callback) != null) {
                    iXcdnCallback.onEvent(i3, message.what, message.arg2, (String) message.obj);
                }
            }
        }
    }

    static {
        try {
            System.loadLibrary(TAG);
        } catch (Throwable th) {
            AdapterForTLog.loge(TAG, "load xcdn so failed:" + th);
            Log.e(TAG, "load xcdn so fialed:" + th);
            try {
                System.loadLibrary(TAG);
            } catch (Throwable unused) {
            }
        }
        mInitialized = false;
        netType = NetworkBroadcastReceiver.NetType.NONE;
        mDownloadItems = new CopyOnWriteArrayList<>();
        mWorkerThread = new HandlerThread("Xcdn-Worker");
        cleanTask = new Runnable() { // from class: com.youku.phone.xcdnengine.XcdnEngine.1
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                long currentTimeMillis = System.currentTimeMillis();
                File file = new File(XcdnEngine.localDir);
                String config = OrangeConfig.getInstance().getConfig(XcdnInner.XCDN_APS_NAMESPACE, "enable_clean", "0");
                int parseInt = Integer.parseInt(OrangeConfig.getInstance().getConfig(XcdnInner.XCDN_APS_NAMESPACE, "urgent_count", "200"));
                if (file.listFiles() != null && file.listFiles().length > 0 && "1".equals(config)) {
                    boolean z = file.listFiles().length > parseInt;
                    for (File file2 : file.listFiles()) {
                        if (file2.isFile()) {
                            long length = file2.length();
                            long lastModified = file2.lastModified();
                            int i = (length > 102400L ? 1 : (length == 102400L ? 0 : -1));
                            if (i < 0 && System.currentTimeMillis() - lastModified > 86400000) {
                                file2.delete();
                            } else if (System.currentTimeMillis() - lastModified > 1296000000) {
                                file2.delete();
                            } else if (z && i < 0 && System.currentTimeMillis() - lastModified > 240000 && !file2.getName().endsWith(".tmp")) {
                                file2.delete();
                            }
                        }
                    }
                }
                XcdnEngine.mWorkerHandler.postDelayed(XcdnEngine.cleanTask, 120000L);
                AdapterForTLog.loge(XcdnEngine.TAG, "clean task use time:" + (System.currentTimeMillis() - currentTimeMillis));
                Log.e(XcdnEngine.TAG, "clean task use time:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        };
    }

    public XcdnEngine(Context context) {
        this(context, true);
    }

    private static void checkReportEnd(String str, long j, IXcdnCallback iXcdnCallback, int i, String str2, String str3, int i2) {
        String domain = Utils.getDomain(str);
        DownloadEnd downloadEnd = new DownloadEnd();
        downloadEnd.setBizId(i).setDomain(domain).setUrl(str).setVersion(Utils.getVersion(BuildConfig.BUILD_SDK_VERSION));
        if (j < 1) {
            if (j == -1000) {
                downloadEnd.setFile("name:save_path=" + str2, "0").setTraffic("0", "0", "0", "0");
            }
            downloadEnd.setError(String.valueOf(j)).report();
            return;
        }
        DownloadItem downloadItem = new DownloadItem();
        downloadItem.handle = j;
        downloadItem.callback = iXcdnCallback;
        downloadItem.downloadEnd = downloadEnd;
        downloadItem.backupPath = str3;
        downloadItem.savePath = str2;
        downloadItem.useBackup = i2;
        mDownloadItems.add(downloadItem);
    }

    private static synchronized void init(Context context, boolean z) {
        synchronized (XcdnEngine.class) {
            if (!mInitialized) {
                synchronized (XcdnEngine.class) {
                    if (!mInitialized) {
                        File file = new File(context.getFilesDir().getAbsolutePath() + DOWNLOADER_DIR_SUFFIX);
                        if (!file.exists() && !file.mkdir()) {
                            Log.e(TAG, "mkdir failed:" + file.getAbsolutePath());
                            AdapterForTLog.loge(TAG, "mkdir failed:" + file.getAbsolutePath());
                        } else {
                            localDir = context.getCacheDir().getAbsolutePath() + LOCAL_DIR;
                            File file2 = new File(localDir);
                            if (!file2.exists() && !file2.mkdir()) {
                                Log.e(TAG, "mkdir failed:" + localDir);
                                AdapterForTLog.loge(TAG, "mkdir failed:" + localDir);
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("sdk_version", Utils.getVersion(BuildConfig.BUILD_SDK_VERSION));
                            limit = 200;
                            new StorageManager(localDir, 200).checkSize();
                            if (!z) {
                                hashMap.put("disable_login", "1");
                            }
                            Log.d(TAG, "init xcdn with dir:" + file.getAbsolutePath());
                            AdapterForTLog.loge(TAG, "init xcdn with dir:" + file.getAbsolutePath());
                            hashMap.put("local_cache", localDir);
                            String str = context.getCacheDir().getAbsolutePath() + FEED_DIR;
                            File file3 = new File(str);
                            if (!file3.exists() && !file3.mkdir()) {
                                Log.e(TAG, "mkdir failed:" + str);
                                AdapterForTLog.loge(TAG, "mkdir failed:" + str);
                            }
                            if (file3.exists()) {
                                new StorageManager(str, 200).checkSize();
                                hashMap.put("feed_cache", str);
                            }
                            mWorkerThread.start();
                            XcdnHandler xcdnHandler = new XcdnHandler(mWorkerThread.getLooper());
                            mWorkerHandler = xcdnHandler;
                            xcdnHandler.postDelayed(cleanTask, 120000L);
                            nativeInit(file.getAbsolutePath(), hashMap);
                            registerNetworkReceiver(context.getApplicationContext());
                            registerAPMListener();
                            AdapterForTLog.loge(TAG, "xcdn init end !");
                            mInitialized = true;
                        }
                    }
                }
            }
        }
    }

    private static HashMap<String, String> initXcdnConfig() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("sdk_version", Utils.getVersion(BuildConfig.BUILD_SDK_VERSION));
        Map<String, String> configs = OrangeConfig.getInstance().getConfigs(XcdnInner.XCDN_APS_NAMESPACE);
        if (configs != null && configs.size() > 0) {
            hashMap.putAll(configs);
        }
        return hashMap;
    }

    private native int nativeDownload(String str, String str2, Object obj);

    private static native String nativeGetLocalUrl(String str);

    private static native int nativeInit(String str, Object obj);

    private native int nativeStop(int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeUpdateConfigs(Object obj);

    private static void postFromNative(int i, long j, int i2, String str) {
        if (i == 10) {
            AdapterForTLog.loge(TAG, TLOG_PREFIX + str);
            return;
        }
        Handler handler = mWorkerHandler;
        handler.sendMessage(Message.obtain(handler, i, (int) j, i2, str));
    }

    private static void registerAPMListener() {
        b.a(new Apm.OnApmEventListener() { // from class: com.youku.phone.xcdnengine.XcdnEngine.3
            @Override // com.taobao.application.common.IApmEventListener
            public void onEvent(int i) {
                if (i != 1) {
                    if (i == 2) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(XcdnInner.CONFIG_UPLOAD_ENABLE, "1");
                        XcdnEngine.nativeUpdateConfigs(hashMap);
                        return;
                    } else if (i != 50) {
                        return;
                    }
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put(XcdnInner.CONFIG_UPLOAD_ENABLE, "0");
                XcdnEngine.nativeUpdateConfigs(hashMap2);
            }
        });
    }

    private static void registerNetworkReceiver(Context context) {
        if (mNetworkReceiver == null) {
            NetworkBroadcastReceiver networkBroadcastReceiver = new NetworkBroadcastReceiver();
            mNetworkReceiver = networkBroadcastReceiver;
            networkBroadcastReceiver.addNetWorkCallBack(new NetworkBroadcastReceiver.NetWorkCallBack() { // from class: com.youku.phone.xcdnengine.XcdnEngine.2
                @Override // com.youku.phone.xcdnengine.NetworkBroadcastReceiver.NetWorkCallBack
                public void netWorkChange(NetworkBroadcastReceiver.NetType netType2) {
                    Log.d(XcdnEngine.TAG, "net work change to " + netType2);
                    AdapterForTLog.loge(XcdnEngine.TAG, "[Xcdn]   net work change to " + netType2);
                    NetworkBroadcastReceiver.NetType unused = XcdnEngine.netType = netType2;
                    int i = netType2 == NetworkBroadcastReceiver.NetType.MOBILE ? 0 : 1;
                    HashMap hashMap = new HashMap();
                    hashMap.put(XcdnInner.CONFIG_UPLOAD_ENABLE, i + "");
                    hashMap.put("network_state", String.valueOf(netType2.ordinal()));
                    XcdnEngine.nativeUpdateConfigs(hashMap);
                }
            });
            context.registerReceiver(mNetworkReceiver, new IntentFilter(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION));
        }
    }

    private static void reportStart(String str, int i) {
        DownloadStart downloadStart = new DownloadStart();
        downloadStart.setBizId(i).setUrl(str).setDomain(Utils.getDomain(str)).setVersion(Utils.getVersion(BuildConfig.BUILD_SDK_VERSION)).report();
    }

    private static void updateXcdnConfig() {
        HashMap hashMap = new HashMap();
        Map<String, String> configs = OrangeConfig.getInstance().getConfigs(XcdnInner.XCDN_APS_NAMESPACE);
        if (configs == null || configs.size() <= 0) {
            return;
        }
        hashMap.putAll(configs);
        nativeUpdateConfigs(hashMap);
    }

    public boolean cancelDownload(long j) {
        if (mInitialized) {
            AdapterForTLog.loge(TAG, "cancel download with handle " + j);
            if (j < 1) {
                Log.i(TAG, "cancel download with invaild handle " + j);
                return false;
            }
            Iterator<DownloadItem> it = mDownloadItems.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadItem next = it.next();
                if (next.handle == j) {
                    mDownloadItems.remove(next);
                    break;
                }
            }
            nativeStop((int) j);
            return true;
        }
        return false;
    }

    public String getLocalCachePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        return localDir + Utils.md5(parse.getLastPathSegment());
    }

    public String getLocalUrl(String str) {
        return !mInitialized ? str : nativeGetLocalUrl(str);
    }

    public void setGlobalConfigs(Map<String, String> map) {
        if (mInitialized && map != null && map.size() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(map);
            nativeUpdateConfigs(hashMap);
        }
    }

    public synchronized long startDownload(String str, String str2, HashMap<String, String> hashMap, IXcdnCallback iXcdnCallback) {
        int i;
        if (mInitialized) {
            AdapterForTLog.loge(TAG, "download file " + str);
            int parseInt = (hashMap == null || TextUtils.isEmpty(hashMap.get("biz_id"))) ? 0 : Integer.parseInt(hashMap.get("biz_id"));
            int parseInt2 = (hashMap == null || TextUtils.isEmpty(hashMap.get("use_backup_storage"))) ? 0 : Integer.parseInt(hashMap.get("use_backup_storage"));
            reportStart(str, parseInt);
            String str3 = localDir + parseInt + "/" + Utils.md5(str);
            if (!Utils.isPathValid(str2)) {
                AdapterForTLog.loge(TAG, "download url " + str + " with invalid save path:" + str2);
                i = -1000;
            } else if (parseInt2 == 0) {
                updateXcdnConfig();
                i = nativeDownload(str, str2, hashMap);
                AdapterForTLog.loge(TAG, "start download with handle " + i);
            } else if (Utils.isPathValid(str3)) {
                Log.e(TAG, "download backup file " + new File(str2).getName());
                updateXcdnConfig();
                i = nativeDownload(str, str3, hashMap);
            } else {
                AdapterForTLog.loge(TAG, "download url " + str + " with invalid backup path:" + str3);
                i = BaseResp.CODE_ERROR_PARAMS;
            }
            long j = i;
            checkReportEnd(str, j, iXcdnCallback, parseInt, str2, str3, parseInt2);
            return j;
        }
        return -1L;
    }

    public synchronized long xcdnDownload(String str, String str2, HashMap<String, String> hashMap, Callback callback) {
        return startDownload(str, str2, hashMap, callback);
    }

    public XcdnEngine(Context context, boolean z) {
        init(context, z);
    }
}
