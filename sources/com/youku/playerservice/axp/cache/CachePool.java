package com.youku.playerservice.axp.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.youku.network.HttpIntent;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.definition.FirstSliceCode;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.SystemUtil;
import com.youku.playerservice.axp.utils.Utils;
import com.youku.service.YoukuService;
import com.youku.service.data.IYoukuDataSource;
import com.youku.usercenter.passport.api.Passport;
import com.youku.vip.info.VipUserService;
import com.youku.vpm.constants.TableField;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CachePool {
    private static volatile CachePool mCachePool;
    private CacheLocalController cacheLocalController;
    private Boolean enableLocalCache;
    private ConcurrentHashMap<String, PlayInfoResponse> mPlayInfoCache = new ConcurrentHashMap<>();
    private long mMaxLiveInfoTime = ApsUtil.getLiveInfoExpiredTime() * 1000;
    private long mMaxUPSInfoTime = ApsUtil.getUpsInfoExpiredTime() * 1000;
    private LruCache<String, IPlayInfoRequest> mPlayInfoRequestCache = new LruCache<>(100);
    private long mMaxUPSInfoTimeByMultiGet = ApsUtil.getUpsInfoByMultiGetExpiredTime() * 1000;

    private CachePool() {
    }

    private String getCookieParam(Context context) {
        if (Utils.isYoukuOrHuaweiBaipai(context)) {
            String str = VipUserService.getInstance().isVip() ? VipUserService.getInstance().isLightVip() ? "2" : "1" : "0";
            String str2 = Passport.isLogin() ? "1" : "0";
            String userId = ((IYoukuDataSource) YoukuService.getService(IYoukuDataSource.class)).getUserId();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("isVip=");
            stringBuffer.append(str);
            stringBuffer.append("&isLogin=");
            stringBuffer.append(str2);
            stringBuffer.append("&userId=");
            stringBuffer.append(userId);
            return stringBuffer.toString();
        }
        return "";
    }

    public static CachePool getInstance() {
        if (mCachePool == null) {
            synchronized (CachePool.class) {
                if (mCachePool == null) {
                    mCachePool = new CachePool();
                }
            }
        }
        return mCachePool;
    }

    private void initLocalCacheController(Context context) {
        if (context == null) {
            return;
        }
        if (this.enableLocalCache == null) {
            this.enableLocalCache = Boolean.valueOf(ApsUtil.enableUpsLocalCache());
        }
        Boolean bool = this.enableLocalCache;
        if ((bool == null || bool.booleanValue()) && this.cacheLocalController == null) {
            synchronized (this) {
                if (this.cacheLocalController == null) {
                    this.cacheLocalController = new CacheLocalController(context);
                }
            }
        }
    }

    private synchronized void removeCachedResponse(String str) {
        ConcurrentHashMap<String, PlayInfoResponse> concurrentHashMap = this.mPlayInfoCache;
        if (concurrentHashMap != null && concurrentHashMap.containsKey("playId")) {
            this.mPlayInfoCache.remove(str);
        }
        CacheLocalController cacheLocalController = this.cacheLocalController;
        if (cacheLocalController != null) {
            cacheLocalController.cleanPlayInfo(str);
        }
    }

    public synchronized boolean checkPlayInfoResponseExist(Context context, PlayDefinition.PlayInfoType playInfoType, String str, String str2) {
        if (ApsUtil.enablePlayInfoResponseCache()) {
            ConcurrentHashMap<String, PlayInfoResponse> concurrentHashMap = this.mPlayInfoCache;
            if (concurrentHashMap == null) {
                this.mPlayInfoCache = new ConcurrentHashMap<>();
                return false;
            }
            PlayInfoResponse playInfoResponse = concurrentHashMap.get(str);
            if (playInfoResponse == null) {
                if (this.enableLocalCache == null) {
                    initCacheContext(context);
                }
                Boolean bool = this.enableLocalCache;
                if (bool != null && bool.booleanValue() && this.cacheLocalController != null) {
                    ArrayMap arrayMap = new ArrayMap();
                    arrayMap.put(HttpIntent.COOKIE, getCookieParam(context));
                    ArrayMap arrayMap2 = new ArrayMap();
                    if (playInfoType != null) {
                        arrayMap2.put("playType", playInfoType.toString());
                    }
                    if (str2 != null) {
                        arrayMap2.put(TableField.PLAYER_SOURCE, str2);
                    }
                    playInfoResponse = this.cacheLocalController.queryPlayInfo(str, arrayMap2, arrayMap);
                }
                if (playInfoResponse == null) {
                    return false;
                }
            }
            if (playInfoResponse.getInfoType() == playInfoType) {
                if (playInfoResponse.getUpsInfo() != null && !TextUtils.isEmpty(playInfoResponse.getUpsInfo().getQGetErrorCode()) && !"0".equals(playInfoResponse.getUpsInfo().getQGetErrorCode())) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis() - playInfoResponse.getTimeOfRequestEnd();
                if (playInfoResponse.getInvalidTime() != 0 && playInfoResponse.getInvalidTime() < currentTimeMillis) {
                    return false;
                }
                if (playInfoResponse.getRequestMode() == PlayInfoResponse.RequestMode.MULTIGET && ApsUtil.getPlayerSourceConfigCanUseMultiGet().contains(str2)) {
                    return true;
                }
                if (playInfoResponse.getRequestMode() == PlayInfoResponse.RequestMode.QGET && ApsUtil.getPlayerSourceConfigCanUseQGet().contains(str2) && !TextUtils.isEmpty(playInfoResponse.getCookieParams()) && getCookieParam(context).equals(playInfoResponse.getCookieParams())) {
                    return true;
                }
                if (playInfoResponse.getRequestMode() == PlayInfoResponse.RequestMode.NORMAL && !TextUtils.isEmpty(playInfoResponse.getCookieParams()) && getCookieParam(context).equals(playInfoResponse.getCookieParams())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public IPlayInfoRequest getPlayInfoRequest(String str) {
        return this.mPlayInfoRequestCache.remove(str);
    }

    public void initCacheContext(Context context) {
        initLocalCacheController(context);
    }

    public synchronized PlayInfoResponse queryPlayInfoResponse(Context context, PlayDefinition.PlayInfoType playInfoType, String str, String str2) {
        return queryPlayInfoResponse(context, playInfoType, str, str2, new ResultCode());
    }

    public synchronized PlayInfoResponse queryPlayInfoResponse(Context context, PlayDefinition.PlayInfoType playInfoType, String str, String str2, @NonNull ResultCode resultCode) {
        if (!ApsUtil.enablePlayInfoResponseCache()) {
            resultCode.code = FirstSliceCode.FS_NULL;
            return null;
        } else if (TextUtils.isEmpty(str)) {
            resultCode.code = "-5";
            return null;
        } else if ("1".equals(SystemUtil.getSystemProperty("debug.ups.get.mock", "0"))) {
            return null;
        } else {
            ConcurrentHashMap<String, PlayInfoResponse> concurrentHashMap = this.mPlayInfoCache;
            if (concurrentHashMap == null) {
                this.mPlayInfoCache = new ConcurrentHashMap<>();
                return null;
            }
            PlayInfoResponse playInfoResponse = concurrentHashMap.get(str);
            if (playInfoResponse == null) {
                if (playInfoType == PlayDefinition.PlayInfoType.UPS) {
                    if (this.enableLocalCache == null) {
                        initCacheContext(context);
                    }
                    Boolean bool = this.enableLocalCache;
                    if (bool != null && bool.booleanValue() && this.cacheLocalController != null) {
                        ArrayMap arrayMap = new ArrayMap();
                        arrayMap.put(HttpIntent.COOKIE, getCookieParam(context));
                        ArrayMap arrayMap2 = new ArrayMap();
                        if (playInfoType != null) {
                            arrayMap2.put("playType", playInfoType.toString());
                        }
                        playInfoResponse = this.cacheLocalController.queryPlayInfo(str, arrayMap2, arrayMap);
                    }
                }
                if (playInfoResponse == null) {
                    resultCode.code = "-1";
                    resultCode.note = "没有缓存数据可以取";
                    return null;
                }
            }
            if (playInfoResponse.getInfoType() == playInfoType) {
                if (playInfoType == PlayDefinition.PlayInfoType.LIVE) {
                    if (ApsUtil.enableAxpLivePlayControlCache()) {
                        long currentTimeMillis = System.currentTimeMillis() - playInfoResponse.getTimeOfRequestEnd();
                        if (playInfoResponse.getInvalidTime() != 0) {
                            if (playInfoResponse.getInvalidTime() < currentTimeMillis) {
                                removeCachedResponse(str);
                                resultCode.code = "-2";
                                return null;
                            }
                            return playInfoResponse;
                        }
                    }
                } else if (playInfoResponse.getUpsInfo() != null && !TextUtils.isEmpty(playInfoResponse.getUpsInfo().getQGetErrorCode()) && !"0".equals(playInfoResponse.getUpsInfo().getQGetErrorCode())) {
                    resultCode.code = playInfoResponse.getUpsInfo().getQGetErrorCode();
                    resultCode.note = playInfoResponse.getUpsInfo().getQGetErrorMsg();
                    return null;
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis() - playInfoResponse.getTimeOfRequestEnd();
                    if (playInfoResponse.getInvalidTime() != 0 && playInfoResponse.getInvalidTime() < currentTimeMillis2) {
                        removeCachedResponse(str);
                        resultCode.code = "-2";
                        return null;
                    } else if (playInfoResponse.getRequestMode() == PlayInfoResponse.RequestMode.MULTIGET && ApsUtil.getPlayerSourceConfigCanUseMultiGet().contains(str2)) {
                        return playInfoResponse;
                    } else {
                        if (playInfoResponse.getRequestMode() == PlayInfoResponse.RequestMode.QGET && ApsUtil.getPlayerSourceConfigCanUseQGet().contains(str2)) {
                            if (!TextUtils.isEmpty(playInfoResponse.getCookieParams()) && getCookieParam(context).equals(playInfoResponse.getCookieParams())) {
                                return playInfoResponse;
                            }
                            removeCachedResponse(str);
                            resultCode.code = FirstSliceCode.FVV;
                            resultCode.note = "ups参数不一致";
                        }
                        if (playInfoResponse.getRequestMode() == PlayInfoResponse.RequestMode.NORMAL) {
                            if (!TextUtils.isEmpty(playInfoResponse.getCookieParams()) && getCookieParam(context).equals(playInfoResponse.getCookieParams())) {
                                return playInfoResponse;
                            }
                            removeCachedResponse(str);
                            resultCode.code = FirstSliceCode.FVV;
                            resultCode.note = "ups参数不一致";
                        }
                    }
                }
            }
            return null;
        }
    }

    public synchronized void removeQGetAndNormalResponses() {
        removeSpecifyTypeCachedResponses(PlayInfoResponse.RequestMode.QGET);
        removeSpecifyTypeCachedResponses(PlayInfoResponse.RequestMode.NORMAL);
    }

    public synchronized void removeSpecifyTypeCachedResponses(PlayInfoResponse.RequestMode requestMode) {
        ConcurrentHashMap<String, PlayInfoResponse> concurrentHashMap = this.mPlayInfoCache;
        if (concurrentHashMap != null) {
            for (String str : concurrentHashMap.keySet()) {
                if (this.mPlayInfoCache.get(str).getRequestMode() == requestMode) {
                    this.mPlayInfoCache.remove(str);
                }
            }
        }
    }

    public synchronized void savePlayInfoResponse(Context context, PlayInfoResponse playInfoResponse) {
        if (ApsUtil.enablePlayInfoResponseCache()) {
            if (playInfoResponse != null && playInfoResponse.getUpsInfo() != null && playInfoResponse.getError() == null) {
                if (this.mPlayInfoCache == null) {
                    this.mPlayInfoCache = new ConcurrentHashMap<>();
                }
                String str = "";
                if (playInfoResponse.getInfoType() == PlayDefinition.PlayInfoType.LIVE) {
                    if (ApsUtil.enableAxpLivePlayControlCache()) {
                        String playId = playInfoResponse.getPlayParams().getPlayIdParams().getPlayId();
                        if (!TextUtils.isEmpty(playId)) {
                            playInfoResponse.setCachePlayID(playId);
                            playInfoResponse.setInvalidTime(this.mMaxLiveInfoTime);
                            this.mPlayInfoCache.put(playId, playInfoResponse);
                        }
                    }
                    return;
                }
                PlayInfoResponse.RequestMode requestMode = playInfoResponse.getRequestMode();
                PlayInfoResponse.RequestMode requestMode2 = PlayInfoResponse.RequestMode.MULTIGET;
                if (requestMode == requestMode2) {
                    str = playInfoResponse.getUpsInfo().getSimpleVideoInfo().getVid();
                } else if (playInfoResponse.getRequestMode() == PlayInfoResponse.RequestMode.QGET) {
                    str = playInfoResponse.getUpsInfo().getCacheKey();
                } else if (playInfoResponse.getRequestMode() == PlayInfoResponse.RequestMode.NORMAL) {
                    str = playInfoResponse.getPlayParams().getPlayIdParams().getPlayId();
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                playInfoResponse.setCachePlayID(str);
                playInfoResponse.setCookieParams(getCookieParam(context));
                if (playInfoResponse.getInfoType() == PlayDefinition.PlayInfoType.UPS) {
                    playInfoResponse.setInvalidTime(playInfoResponse.getRequestMode() == requestMode2 ? this.mMaxUPSInfoTimeByMultiGet : this.mMaxUPSInfoTime);
                }
                this.mPlayInfoCache.put(str, playInfoResponse);
                if (this.enableLocalCache == null) {
                    initCacheContext(context);
                }
                Boolean bool = this.enableLocalCache;
                if (bool != null && bool.booleanValue() && this.cacheLocalController != null) {
                    String str2 = "";
                    if (playInfoResponse.getPlayParams() != null && playInfoResponse.getPlayParams().getPlayIdParams() != null) {
                        str2 = playInfoResponse.getPlayParams().getPlayIdParams().getString(TableField.PLAYER_SOURCE);
                    }
                    ArrayMap arrayMap = new ArrayMap();
                    arrayMap.put(TableField.PLAYER_SOURCE, str2);
                    this.cacheLocalController.savePlayInfoResponse(playInfoResponse, arrayMap, (Map<String, String>) null);
                }
            }
        }
    }

    public synchronized void savePlayInfoResponseList(Context context, List<PlayInfoResponse> list) {
        CacheLocalController cacheLocalController;
        if (ApsUtil.enablePlayInfoResponseCache()) {
            if (list != null && list.size() != 0) {
                for (PlayInfoResponse playInfoResponse : list) {
                    if (playInfoResponse.getInfoType() != PlayDefinition.PlayInfoType.LIVE) {
                        String str = "";
                        PlayInfoResponse.RequestMode requestMode = playInfoResponse.getRequestMode();
                        PlayInfoResponse.RequestMode requestMode2 = PlayInfoResponse.RequestMode.MULTIGET;
                        if (requestMode == requestMode2) {
                            str = playInfoResponse.getUpsInfo().getSimpleVideoInfo().getVid();
                        } else if (playInfoResponse.getRequestMode() == PlayInfoResponse.RequestMode.QGET) {
                            str = playInfoResponse.getUpsInfo().getCacheKey();
                        } else if (playInfoResponse.getRequestMode() == PlayInfoResponse.RequestMode.NORMAL) {
                            str = playInfoResponse.getPlayParams().getPlayIdParams().getPlayId();
                        }
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        playInfoResponse.setCachePlayID(str);
                        if (this.mPlayInfoCache == null) {
                            this.mPlayInfoCache = new ConcurrentHashMap<>();
                        }
                        playInfoResponse.setCookieParams(getCookieParam(context));
                        if (playInfoResponse.getInfoType() == PlayDefinition.PlayInfoType.UPS) {
                            playInfoResponse.setInvalidTime(playInfoResponse.getRequestMode() == requestMode2 ? this.mMaxUPSInfoTimeByMultiGet : this.mMaxUPSInfoTime);
                        }
                        if (this.mPlayInfoCache.containsKey(str)) {
                            PlayInfoResponse playInfoResponse2 = this.mPlayInfoCache.get(str);
                            if (playInfoResponse2.getUpsInfo() != null && !TextUtils.isEmpty(playInfoResponse2.getUpsInfo().getQGetErrorCode()) && !"0".equals(playInfoResponse2.getUpsInfo().getQGetErrorCode()) && playInfoResponse.getUpsInfo() != null && !TextUtils.isEmpty(playInfoResponse.getUpsInfo().getQGetErrorCode()) && !"0".equals(playInfoResponse.getUpsInfo().getQGetErrorCode())) {
                                Logger.e(CacheManager.TAG_MINSET, str + " cache not cover with error code " + playInfoResponse.getUpsInfo().getQGetErrorCode());
                                return;
                            }
                        }
                        this.mPlayInfoCache.put(str, playInfoResponse);
                    }
                }
                if (this.enableLocalCache == null) {
                    initCacheContext(context);
                }
                Boolean bool = this.enableLocalCache;
                if (bool != null && bool.booleanValue() && (cacheLocalController = this.cacheLocalController) != null) {
                    cacheLocalController.savePlayInfoResponse(list, (Map<String, String>) null, (Map<String, String>) null);
                }
            }
        }
    }

    public void setPlayInfoRequest(String str, IPlayInfoRequest iPlayInfoRequest) {
        if (iPlayInfoRequest != null) {
            this.mPlayInfoRequestCache.put(str, iPlayInfoRequest);
        } else {
            this.mPlayInfoRequestCache.remove(str);
        }
    }
}
