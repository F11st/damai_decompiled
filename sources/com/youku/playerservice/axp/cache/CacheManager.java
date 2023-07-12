package com.youku.playerservice.axp.cache;

import android.content.Context;
import android.text.TextUtils;
import com.youku.a.C7792a;
import com.youku.alixplayer.misc.Preloader;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.cache.CachePreloadParams;
import com.youku.playerservice.axp.cache.CachePreloadResult;
import com.youku.playerservice.axp.cache.task.MediaSourceCacheTask;
import com.youku.playerservice.axp.cache.task.MinsetTask;
import com.youku.playerservice.axp.cache.task.MultiGetUpsTask;
import com.youku.playerservice.axp.cache.task.MultiMediaSourceCacheTask;
import com.youku.playerservice.axp.cache.task.PlayInfoMultiCacheTask;
import com.youku.playerservice.axp.cache.task.PlayInfoNormalCacheTask;
import com.youku.playerservice.axp.cache.task.PlayerCacheTask;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.TLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class CacheManager implements IInternalCachePreloadCallback {
    public static final String BIZ_TYPE = "biz_type";
    public static final String BIZ_TYPE_FEED = "feed";
    public static final String BIZ_TYPE_LIVE = "live";
    public static final String BIZ_TYPE_VOD = "vod";
    public static final String PRELOAD_SIZE = "preload_size";
    public static final String PRIORITY_LEVEL = "priority_level";
    public static final String SLICE_ID = "slice_id";
    public static final String TAG_MEDIASOURCE = "CacheManager-MediaSource";
    public static final String TAG_MINSET = "CacheManager-Minset";
    public static final String TAG_MULTIGET = "CacheManager-MultiGet";
    public static final String TAG_PLAYER = "CacheManager-Player";
    private static volatile CacheManager mAXPCacheManager;
    private ExecutorService mExecutorService = Executors.newCachedThreadPool();
    private ConcurrentHashMap<String, Future> mTasks = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, CacheRecorder> mCacheRecorders = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, ICachePreloadCallback> mCallbacks = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Map<String, Map<String, String>>> mVidRecorder = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, List<String>> mUrlRecorder = new ConcurrentHashMap<>();

    private CacheManager() {
        Logger.setDebugMode(true);
    }

    private void addPoolId(String str, String str2) {
        CacheRecorder cacheRecorder;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mCacheRecorders.containsKey(str)) {
            cacheRecorder = this.mCacheRecorders.get(str);
        } else {
            cacheRecorder = new CacheRecorder();
            this.mCacheRecorders.put(str, cacheRecorder);
        }
        cacheRecorder.addPoolId(str2);
    }

    private void addTaskKey(String str, String str2) {
        CacheRecorder cacheRecorder;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mCacheRecorders.containsKey(str)) {
            cacheRecorder = this.mCacheRecorders.get(str);
        } else {
            cacheRecorder = new CacheRecorder();
            this.mCacheRecorders.put(str, cacheRecorder);
        }
        cacheRecorder.addTaskKey(str2);
    }

    private void cancelPreloadTask(String str) {
        TLogUtil.loge(TAG_MEDIASOURCE, "cancelPreloadTask url:" + str);
        Preloader.cancelPreload(str);
    }

    private void cancelTaskByGroupid(String str) {
        CacheRecorder cacheRecorder = this.mCacheRecorders.get(str);
        if (cacheRecorder != null) {
            List<String> taskKeyList = cacheRecorder.getTaskKeyList();
            synchronized (taskKeyList) {
                if (taskKeyList.size() > 0) {
                    for (String str2 : taskKeyList) {
                        Future future = this.mTasks.get(str2);
                        if (future != null) {
                            future.cancel(true);
                            this.mTasks.remove(str2);
                        }
                    }
                    taskKeyList.clear();
                }
            }
        }
    }

    public static CacheManager getInstance() {
        if (mAXPCacheManager == null) {
            synchronized (CacheManager.class) {
                if (mAXPCacheManager == null) {
                    mAXPCacheManager = new CacheManager();
                }
            }
        }
        return mAXPCacheManager;
    }

    private void recyclePlayersByGroupid(Context context, String str) {
        CacheRecorder cacheRecorder = this.mCacheRecorders.get(str);
        if (cacheRecorder != null) {
            List<String> poolIdList = cacheRecorder.getPoolIdList();
            synchronized (poolIdList) {
                if (poolIdList.size() > 0) {
                    for (String str2 : poolIdList) {
                        C7792a.a(context).b(str2);
                        TLogUtil.loge(TAG_PLAYER, "recyclePlayersByGroupid: recyclePlayer-" + str2);
                    }
                    poolIdList.clear();
                }
            }
        }
    }

    private void removeTaskKey(String str) {
        for (CacheRecorder cacheRecorder : this.mCacheRecorders.values()) {
            cacheRecorder.removeTaskKey(str);
        }
    }

    public void cancelUrlMediaSourceWithKey(String str) {
        TLogUtil.loge(TAG_MEDIASOURCE, "cancelUrlMediaSourceWithKey key:" + str);
        Future future = this.mTasks.get(str);
        if (future != null) {
            future.cancel(true);
            this.mTasks.remove(str);
        }
        List<String> list = this.mUrlRecorder.get(str);
        if (list == null || list.size() <= 0) {
            return;
        }
        for (String str2 : list) {
            cancelPreloadTask(str2);
        }
        this.mUrlRecorder.remove(str);
    }

    public void cancelVidMediaSourceWithKey(String str) {
        TLogUtil.loge(TAG_MEDIASOURCE, "cancelVidMediaSourceWithKey key:" + str);
        Future future = this.mTasks.get(str);
        if (future != null) {
            future.cancel(true);
            this.mTasks.remove(str);
        }
        synchronized (this) {
            if (this.mVidRecorder.get(str) != null) {
                for (Map<String, String> map : this.mVidRecorder.get(str).values()) {
                    if (map != null) {
                        for (String str2 : map.keySet()) {
                            cancelPreloadTask(str2);
                        }
                    }
                }
            }
        }
    }

    public void clearCallbackWithKey(String str) {
        ConcurrentHashMap<String, ICachePreloadCallback> concurrentHashMap = this.mCallbacks;
        if (concurrentHashMap != null && concurrentHashMap.containsKey(str)) {
            this.mCallbacks.remove(str);
        }
        synchronized (this) {
            this.mVidRecorder.remove(str);
        }
    }

    public void clearPreloadWithGroupid(Context context, String str) {
        TLogUtil.loge(TAG_PLAYER, "clearPreloadWithGroupid：" + str);
        if (TextUtils.isEmpty(str) || !this.mCacheRecorders.containsKey(str)) {
            return;
        }
        cancelTaskByGroupid(str);
        recyclePlayersByGroupid(context, str);
        this.mCacheRecorders.remove(str);
        for (CacheRecorder cacheRecorder : this.mCacheRecorders.values()) {
            if (cacheRecorder != null && cacheRecorder.getPoolIdList().size() > 0) {
                TLogUtil.loge(TAG_PLAYER, "recyclePlayersByGroupid: leftPlayer-" + cacheRecorder.getPoolIdList().toString());
            }
        }
    }

    public void clearPreloadWithKey(String str) {
        TLogUtil.loge(TAG_PLAYER, "clearPreloadWithKey：" + str);
        Future future = this.mTasks.get(str);
        if (future != null) {
            future.cancel(true);
            this.mTasks.remove(str);
        }
    }

    public String getPreloadKey() {
        String valueOf = String.valueOf(System.currentTimeMillis());
        return !this.mTasks.containsKey(valueOf) ? valueOf : String.valueOf(System.currentTimeMillis());
    }

    public boolean isExistsPreloadWithKey(String str) {
        return this.mTasks.get(str) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b5, code lost:
        if (android.text.TextUtils.isEmpty(r10.getPlayerId()) == false) goto L23;
     */
    @Override // com.youku.playerservice.axp.cache.IInternalCachePreloadCallback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResult(java.lang.String r7, com.youku.playerservice.axp.cache.CachePreloadParams r8, com.youku.playerservice.axp.cache.CachePreloadResult.AXPCachePreloadStatus r9, com.youku.playerservice.axp.cache.CachePreloadResult r10) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.cache.CacheManager.onResult(java.lang.String, com.youku.playerservice.axp.cache.CachePreloadParams, com.youku.playerservice.axp.cache.CachePreloadResult$AXPCachePreloadStatus, com.youku.playerservice.axp.cache.CachePreloadResult):void");
    }

    public void preloadMediaSourceWithUrls(String str, Context context, List<String> list, Map<String, String> map, ICachePreloadCallback iCachePreloadCallback) {
        if (TextUtils.isEmpty(str) || context == null) {
            TLogUtil.loge(TAG_MEDIASOURCE, "preloadMediaSourceWithUrls params error");
            if (iCachePreloadCallback != null) {
                iCachePreloadCallback.onResult(null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PARAMS, null);
            }
        } else if (list == null || list.size() == 0 || list.size() > 10) {
            TLogUtil.loge(TAG_MEDIASOURCE, "preloadMediaSourceWithUrls urls error");
            if (iCachePreloadCallback != null) {
                iCachePreloadCallback.onResult(null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PARAMS, null);
            }
        } else if (isExistsPreloadWithKey(str)) {
            TLogUtil.loge(TAG_MEDIASOURCE, "preloadMediaSourceWithUrls：key is exist");
            if (iCachePreloadCallback != null) {
                iCachePreloadCallback.onResult(null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_EXISTS_TASK, null);
            }
        } else {
            if (iCachePreloadCallback != null) {
                this.mCallbacks.put(str, iCachePreloadCallback);
            }
            this.mTasks.put(str, this.mExecutorService.submit(new MultiMediaSourceCacheTask(str, context, null, list, map, this)));
            this.mUrlRecorder.put(str, list);
        }
    }

    public void preloadMediaSourceWithVids(String str, Context context, List<String> list, Map<String, String> map, ICachePreloadCallback iCachePreloadCallback) {
        if (TextUtils.isEmpty(str) || context == null) {
            TLogUtil.loge(TAG_MEDIASOURCE, "preloadMediaSourceWithVids params error");
            if (iCachePreloadCallback != null) {
                iCachePreloadCallback.onResult(null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PARAMS, null);
            }
        } else if (list == null || list.size() == 0 || list.size() > 10) {
            TLogUtil.loge(TAG_MEDIASOURCE, "preloadMediaSourceWithVids vids error");
            if (iCachePreloadCallback != null) {
                iCachePreloadCallback.onResult(null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PARAMS, null);
            }
        } else if (isExistsPreloadWithKey(str)) {
            TLogUtil.loge(TAG_MEDIASOURCE, "preloadMediaSourceWithVids：key is exist");
            if (iCachePreloadCallback != null) {
                iCachePreloadCallback.onResult(null, CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_EXISTS_TASK, null);
            }
        } else {
            if (iCachePreloadCallback != null) {
                this.mCallbacks.put(str, iCachePreloadCallback);
            }
            this.mTasks.put(str, this.mExecutorService.submit(new MultiMediaSourceCacheTask(str, context, list, null, map, this)));
        }
    }

    public void preloadMinset(Context context, List<MinsetPreloadInfo> list, Map<String, String> map) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.mExecutorService.submit(new MinsetTask(context, list, map));
    }

    public void preloadMultiget(Context context, List<String> list, Map<String, String> map, IMultiGetUpsCallback iMultiGetUpsCallback) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.mExecutorService.submit(new MultiGetUpsTask(context, list, map, iMultiGetUpsCallback));
    }

    public void preloadWithKey(String str, CachePreloadParams cachePreloadParams, ICachePreloadCallback iCachePreloadCallback) {
        ICachePreloadCallback iCachePreloadCallback2;
        CachePreloadResult.AXPCachePreloadStatus aXPCachePreloadStatus;
        String playUrl;
        if (iCachePreloadCallback != null) {
            this.mCallbacks.put(str, iCachePreloadCallback);
        }
        Callable callable = null;
        if (!TextUtils.isEmpty(str) || this.mCallbacks.get(str) == null) {
            if (!TextUtils.isEmpty(cachePreloadParams.getGroupId()) || this.mCallbacks.get(str) == null) {
                if (cachePreloadParams.getPlayParams() != null) {
                    String str2 = "";
                    if (cachePreloadParams.getPlayParams().getPlayIdParams() != null) {
                        str2 = cachePreloadParams.getPlayParams().getPlayIdParams().getPlayId();
                        playUrl = "";
                    } else {
                        playUrl = cachePreloadParams.getPlayParams().getPlayUrlParams() != null ? cachePreloadParams.getPlayParams().getPlayUrlParams().getPlayUrl() : "";
                    }
                    TLogUtil.loge(TAG_PLAYER, "preloadWithKey--playid:" + str2 + "--playUrl:" + playUrl + "--groupid:" + cachePreloadParams.getGroupId());
                }
                if (isExistsPreloadWithKey(str)) {
                    TLogUtil.loge(TAG_PLAYER, "preloadWithKey：key is exist");
                    if (this.mCallbacks.get(str) != null) {
                        iCachePreloadCallback2 = this.mCallbacks.get(str);
                        aXPCachePreloadStatus = CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_EXISTS_TASK;
                        iCachePreloadCallback2.onResult(cachePreloadParams, aXPCachePreloadStatus, null);
                    }
                }
                if (cachePreloadParams.getPlayParams() != null) {
                    cachePreloadParams.getPlayParams().putString("prePlayTs", String.valueOf(System.currentTimeMillis()));
                }
                CachePreloadParams.AXPCacheAction cacheAction = cachePreloadParams.getCacheAction();
                if (cacheAction == CachePreloadParams.AXPCacheAction.AXPCACHEACTION_PLAYINFO_NORMAL) {
                    callable = new PlayInfoNormalCacheTask(str, cachePreloadParams, this);
                } else if (cacheAction == CachePreloadParams.AXPCacheAction.AXPCACHEACTION_PLAYINFO_MULTI) {
                    callable = new PlayInfoMultiCacheTask(str, cachePreloadParams, this);
                } else if (cacheAction == CachePreloadParams.AXPCacheAction.AXPCACHEACTION_MEDIASOURCE) {
                    if (cachePreloadParams.getPlayParams() != null && cachePreloadParams.getPlayParams().getPlayType() == PlayDefinition.PlayType.LIVE && this.mCallbacks.get(str) != null) {
                        iCachePreloadCallback2 = this.mCallbacks.get(str);
                        aXPCachePreloadStatus = CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_MEDIASOURCE;
                        iCachePreloadCallback2.onResult(cachePreloadParams, aXPCachePreloadStatus, null);
                    }
                    callable = new MediaSourceCacheTask(str, cachePreloadParams, this);
                } else if (cacheAction == CachePreloadParams.AXPCacheAction.AXPCACHEACTION_PLAYER) {
                    callable = new PlayerCacheTask(str, cachePreloadParams, this);
                }
                if (callable != null) {
                    this.mTasks.put(str, this.mExecutorService.submit(callable));
                    if (cacheAction == CachePreloadParams.AXPCacheAction.AXPCACHEACTION_PLAYER) {
                        addTaskKey(cachePreloadParams.getGroupId(), str);
                        return;
                    } else if (cacheAction != CachePreloadParams.AXPCacheAction.AXPCACHEACTION_MEDIASOURCE || cachePreloadParams.getPlayParams() == null || cachePreloadParams.getPlayParams().getPlayIdParams() == null) {
                        return;
                    } else {
                        String playUrl2 = cachePreloadParams.getPlayParams().getPlayIdParams().getPlayUrl();
                        if (TextUtils.isEmpty(playUrl2)) {
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(playUrl2);
                        this.mUrlRecorder.put(str, arrayList);
                        return;
                    }
                }
                return;
            }
            TLogUtil.loge(TAG_PLAYER, "preloadWithKey：groupid is null");
        }
        iCachePreloadCallback2 = this.mCallbacks.get(str);
        aXPCachePreloadStatus = CachePreloadResult.AXPCachePreloadStatus.AXPCACHEPRELOADSTATUS_FAIL_PARAMS;
        iCachePreloadCallback2.onResult(cachePreloadParams, aXPCachePreloadStatus, null);
    }

    public int queryPreloadMediaSourceResultWithUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            Preloader.PreloadStatus checkPreloadStatus = Preloader.checkPreloadStatus(str);
            if (checkPreloadStatus == Preloader.PreloadStatus.COMPLETED) {
                return 0;
            }
            if (checkPreloadStatus == Preloader.PreloadStatus.FAILED) {
                return 1;
            }
            if (checkPreloadStatus != Preloader.PreloadStatus.IDLE && checkPreloadStatus == Preloader.PreloadStatus.STARTED) {
                return 3;
            }
        }
        return 2;
    }

    public Preloader.PreloadStatus queryPreloadMediaSourceResultWithVid(String str, String str2) {
        TLogUtil.loge(TAG_MEDIASOURCE, "queryPreloadMediaSourceResultWithVid key:" + str + " vid:" + str2);
        Map<String, Map<String, String>> map = this.mVidRecorder.get(str);
        Preloader.PreloadStatus preloadStatus = null;
        if (map != null && map.containsKey(str2)) {
            Iterator<String> it = map.get(str2).keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Preloader.PreloadStatus checkPreloadStatus = Preloader.checkPreloadStatus(next);
                TLogUtil.loge(TAG_MEDIASOURCE, "queryPreloadMediaSourceResultWithVid url:" + next);
                Preloader.PreloadStatus preloadStatus2 = Preloader.PreloadStatus.COMPLETED;
                if (checkPreloadStatus != preloadStatus2) {
                    Preloader.PreloadStatus preloadStatus3 = Preloader.PreloadStatus.FAILED;
                    if (checkPreloadStatus == preloadStatus3) {
                        preloadStatus = preloadStatus3;
                        break;
                    }
                    Preloader.PreloadStatus preloadStatus4 = Preloader.PreloadStatus.IDLE;
                    if (checkPreloadStatus != preloadStatus4) {
                        preloadStatus2 = Preloader.PreloadStatus.STARTED;
                        if (checkPreloadStatus == preloadStatus2) {
                            preloadStatus = preloadStatus2;
                        }
                    } else if (preloadStatus == preloadStatus2) {
                        preloadStatus = Preloader.PreloadStatus.STARTED;
                    } else if (preloadStatus == null || preloadStatus == preloadStatus4) {
                        preloadStatus = preloadStatus4;
                    }
                } else if (preloadStatus == Preloader.PreloadStatus.IDLE) {
                    preloadStatus = Preloader.PreloadStatus.STARTED;
                } else {
                    if (preloadStatus != null && preloadStatus != preloadStatus2) {
                    }
                    preloadStatus = preloadStatus2;
                }
            }
        }
        TLogUtil.loge(TAG_MEDIASOURCE, "queryPreloadMediaSourceResultWithVid checkStatus:" + preloadStatus);
        return preloadStatus;
    }

    public void removePoolId(String str) {
        for (CacheRecorder cacheRecorder : this.mCacheRecorders.values()) {
            cacheRecorder.removePoolId(str);
        }
    }
}
