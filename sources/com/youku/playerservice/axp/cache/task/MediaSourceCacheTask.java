package com.youku.playerservice.axp.cache.task;

import android.content.Context;
import android.text.TextUtils;
import com.youku.alixplayer.misc.Preloader;
import com.youku.playerservice.axp.cache.CacheManager;
import com.youku.playerservice.axp.cache.CachePreloadParams;
import com.youku.playerservice.axp.cache.CachePreloadResult;
import com.youku.playerservice.axp.cache.IInternalCachePreloadCallback;
import com.youku.playerservice.axp.p2p.P2pManager;
import com.youku.playerservice.axp.p2p.PcdnType;
import com.youku.playerservice.axp.playparams.PlayIdParams;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.TLogUtil;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MediaSourceCacheTask extends CacheTask {
    private Context mContext;
    private IInternalCachePreloadCallback mInternalCallback;
    private String mKey;
    private CachePreloadParams mPreloadParams;

    public MediaSourceCacheTask(String str, CachePreloadParams cachePreloadParams, IInternalCachePreloadCallback iInternalCachePreloadCallback) {
        this.mKey = str;
        this.mPreloadParams = cachePreloadParams;
        this.mInternalCallback = iInternalCachePreloadCallback;
    }

    @Override // com.youku.playerservice.axp.cache.task.CacheTask, java.util.concurrent.Callable
    public CachePreloadResult call() {
        Context context;
        CachePreloadParams cachePreloadParams = this.mPreloadParams;
        if (cachePreloadParams == null || cachePreloadParams.getPlayParams() == null || this.mPreloadParams.getPlayParams().getPlayIdParams() == null) {
            IInternalCachePreloadCallback iInternalCachePreloadCallback = this.mInternalCallback;
            if (iInternalCachePreloadCallback != null) {
                iInternalCachePreloadCallback.onResult(this.mKey, this.mPreloadParams, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_MEDIASOURCE, null);
            }
            return null;
        }
        if (this.mPreloadParams.getPlayerConfig() != null && this.mPreloadParams.getPlayerConfig().getContext() != null) {
            this.mContext = this.mPreloadParams.getPlayerConfig().getContext().getApplicationContext();
        }
        PlayIdParams playIdParams = this.mPreloadParams.getPlayParams().getPlayIdParams();
        String playUrl = playIdParams.getPlayUrl();
        if (TextUtils.isEmpty(playUrl)) {
            IInternalCachePreloadCallback iInternalCachePreloadCallback2 = this.mInternalCallback;
            if (iInternalCachePreloadCallback2 != null) {
                iInternalCachePreloadCallback2.onResult(this.mKey, this.mPreloadParams, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_MEDIASOURCE, null);
            }
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String string = !TextUtils.isEmpty(playIdParams.getString(CacheManager.PRIORITY_LEVEL)) ? playIdParams.getString(CacheManager.PRIORITY_LEVEL) : "2";
        sb.append("priority_level=" + string);
        String string2 = playIdParams.getString("biz_type");
        String enableDownloader = !TextUtils.isEmpty(string2) ? ApsUtil.enableDownloader(string2) : "1";
        sb.append("&use_downloader=" + enableDownloader);
        if ("1".equals(enableDownloader) && (context = this.mContext) != null) {
            P2pManager.Result pcdnUrl = P2pManager.getInstance(context).getPcdnUrl(this.mContext, PcdnType.LIVE, playUrl);
            if (!"10000".equals(pcdnUrl.errorCode)) {
                TLogUtil.playLog("p2pCode=" + pcdnUrl.errorCode);
            } else if (!TextUtils.isEmpty(pcdnUrl.finalUrl)) {
                playUrl = pcdnUrl.finalUrl;
            }
        }
        if (!TextUtils.isEmpty(playIdParams.getString(CacheManager.PRELOAD_SIZE))) {
            try {
                int parseInt = Integer.parseInt(playIdParams.getString(CacheManager.PRELOAD_SIZE));
                sb.append("&preload_size=" + parseInt);
            } catch (NumberFormatException unused) {
            }
        }
        if (!TextUtils.isEmpty(playIdParams.getString(CacheManager.SLICE_ID))) {
            try {
                long parseLong = Long.parseLong(playIdParams.getString(CacheManager.SLICE_ID));
                sb.append("&slice_id=" + parseLong);
            } catch (NumberFormatException unused2) {
            }
        }
        TLogUtil.loge(CacheManager.TAG_MEDIASOURCE, "MediaSourceCacheTask preload url:" + playUrl + "-params:" + sb.toString());
        Preloader.preload(playUrl, sb.toString(), new Preloader.PreloadListener() { // from class: com.youku.playerservice.axp.cache.task.MediaSourceCacheTask.1
            @Override // com.youku.alixplayer.misc.Preloader.PreloadListener
            public void onPreloadStatusUpdated(String str, Preloader.PreloadStatus preloadStatus) {
                IInternalCachePreloadCallback iInternalCachePreloadCallback3;
                String str2;
                CachePreloadParams cachePreloadParams2;
                CachePreloadResult.AXPCachePreloadStatus aXPCachePreloadStatus;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("MediaSourceCacheTask onPreloadStatusUpdated url:");
                sb2.append(str);
                Preloader.PreloadStatus preloadStatus2 = Preloader.PreloadStatus.COMPLETED;
                sb2.append(preloadStatus == preloadStatus2 ? "-complete" : "-failed");
                TLogUtil.loge(CacheManager.TAG_MEDIASOURCE, sb2.toString());
                if (preloadStatus == preloadStatus2) {
                    if (MediaSourceCacheTask.this.mInternalCallback == null) {
                        return;
                    }
                    iInternalCachePreloadCallback3 = MediaSourceCacheTask.this.mInternalCallback;
                    str2 = MediaSourceCacheTask.this.mKey;
                    cachePreloadParams2 = MediaSourceCacheTask.this.mPreloadParams;
                    aXPCachePreloadStatus = CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_SUCCESS_MEDIASOURCE;
                } else if (preloadStatus != Preloader.PreloadStatus.FAILED || MediaSourceCacheTask.this.mInternalCallback == null) {
                    return;
                } else {
                    iInternalCachePreloadCallback3 = MediaSourceCacheTask.this.mInternalCallback;
                    str2 = MediaSourceCacheTask.this.mKey;
                    cachePreloadParams2 = MediaSourceCacheTask.this.mPreloadParams;
                    aXPCachePreloadStatus = CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_MEDIASOURCE;
                }
                iInternalCachePreloadCallback3.onResult(str2, cachePreloadParams2, aXPCachePreloadStatus, null);
            }
        });
        return null;
    }
}
