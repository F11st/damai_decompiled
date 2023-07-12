package com.youku.playerservice.axp.cache;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.cache.local.SimpleLocalDataStorage;
import com.youku.playerservice.axp.cache.local.db.entity.VideoUpsInfoEntity;
import com.youku.playerservice.axp.playinfo.NetUpsInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoLiveResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.upsplayer.ParseResult;
import com.youku.upsplayer.module.SimpleVideoInfo;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.vpm.constants.TableField;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class CacheLocalController {
    private static final int STORE_DATA_FROM_LIVE = 1;
    private static final int STORE_DATA_FROM_MAIN_INFO = 4;
    private static final int STORE_DATA_FROM_QINFO = 3;
    private static final int STORE_DATA_FROM_SIMPLE = 2;

    public CacheLocalController(Context context) {
        if (context != null) {
            while (!(context instanceof Application)) {
                try {
                    context = context.getApplicationContext();
                } catch (Exception unused) {
                    return;
                }
            }
            SimpleLocalDataStorage.initInstance(context);
            SimpleLocalDataStorage.getInstance().getVideoUpsInfoDao().deleteExpiredCache(System.currentTimeMillis());
        }
    }

    private VideoUpsInfoEntity constructEntity(PlayInfoResponse playInfoResponse, Map<String, String> map, Map<String, String> map2) {
        String str;
        if (playInfoResponse == null || TextUtils.isEmpty(playInfoResponse.getCachePlayID())) {
            return null;
        }
        String string = (playInfoResponse.getPlayParams() == null || playInfoResponse.getPlayParams().getPlayIdParams() == null) ? "" : playInfoResponse.getPlayParams().getPlayIdParams().getString(TableField.PLAYER_SOURCE);
        if (TextUtils.isEmpty(string) && map != null) {
            string = map.get(TableField.PLAYER_SOURCE);
        }
        String str2 = map != null ? map.get("requestMode") : null;
        if (str2 == null && playInfoResponse.getRequestMode() != null) {
            str2 = playInfoResponse.getRequestMode().toString();
        }
        String str3 = map != null ? map.get("playType") : null;
        if (str3 == null && playInfoResponse.getInfoType() != null) {
            str3 = playInfoResponse.getInfoType().toString();
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        String obj = map2 != null ? map2.toString() : playInfoResponse.getCookieParams();
        JSONObject constructLocalExtraInfo = playInfoResponse.constructLocalExtraInfo();
        if (constructLocalExtraInfo == null) {
            constructLocalExtraInfo = new JSONObject();
        }
        int i = 0;
        if (playInfoResponse.getLiveInfo() != null && playInfoResponse.getLiveInfo().getLivePlayControl() != null) {
            String str4 = playInfoResponse.getLiveInfo().getLivePlayControl().rawData;
            constructLocalExtraInfo.put("upsCacheForm", (Object) 1);
            str = str4;
            i = 1;
        } else if (playInfoResponse.getUpsInfo() == null) {
            str = null;
        } else if (!TextUtils.isEmpty(playInfoResponse.getUpsInfo().getQGetErrorCode())) {
            return null;
        } else {
            if (playInfoResponse.getUpsInfo().getSimpleVideoInfo() != null) {
                String rawData = playInfoResponse.getUpsInfo().getSimpleVideoInfo().getRawData();
                constructLocalExtraInfo.put("upsCacheForm", (Object) 2);
                str = rawData;
                i = 2;
            } else {
                String raw = playInfoResponse.getUpsInfo().getRaw();
                if (str2 == null || !str2.equals(PlayInfoResponse.RequestMode.NORMAL)) {
                    constructLocalExtraInfo.put("upsCacheForm", (Object) 3);
                    str = raw;
                    i = 3;
                } else {
                    constructLocalExtraInfo.put("upsCacheForm", (Object) 4);
                    str = raw;
                    i = 4;
                }
            }
        }
        if (ApsUtil.enableUpsLocalCache(i) && ApsUtil.enableUpsLocalCache(i, string)) {
            VideoUpsInfoEntity videoUpsInfoEntity = new VideoUpsInfoEntity(playInfoResponse.getCachePlayID(), str3, str2);
            videoUpsInfoEntity.setRawData(str);
            videoUpsInfoEntity.setExpiredTime(Long.valueOf(playInfoResponse.getTimeOfRequestEnd() + playInfoResponse.getInvalidTime()));
            videoUpsInfoEntity.setExtraParams(obj);
            videoUpsInfoEntity.setExtraData(constructLocalExtraInfo.toJSONString());
            return videoUpsInfoEntity;
        }
        return null;
    }

    private PlayInfoResponse constructResponse(VideoUpsInfoEntity videoUpsInfoEntity) {
        JSONObject parseObject;
        if (videoUpsInfoEntity == null || (parseObject = JSON.parseObject(videoUpsInfoEntity.getExtraData())) == null) {
            return null;
        }
        int intValue = parseObject.getIntValue("upsCacheForm");
        if (intValue == 1) {
            PlayInfoLiveResponse playInfoLiveResponse = new PlayInfoLiveResponse(null, null);
            playInfoLiveResponse.setRequestMode(PlayInfoResponse.RequestMode.NORMAL);
            playInfoLiveResponse.setInfoType(PlayDefinition.PlayInfoType.LIVE);
            return playInfoLiveResponse;
        }
        if (intValue == 2) {
            SimpleVideoInfo simpleVideoInfo = (SimpleVideoInfo) JSON.parseObject(videoUpsInfoEntity.getRawData(), SimpleVideoInfo.class);
            if (simpleVideoInfo != null) {
                PlayInfoUpsResponse playInfoUpsResponse = new PlayInfoUpsResponse(null, null);
                NetUpsInfo netUpsInfo = new NetUpsInfo(simpleVideoInfo);
                simpleVideoInfo.setRawData(videoUpsInfoEntity.getRawData());
                playInfoUpsResponse.setUpsInfo(netUpsInfo);
                if (videoUpsInfoEntity.getExtraData() != null) {
                    playInfoUpsResponse.updateLocalExtraInfo(JSON.parseObject(videoUpsInfoEntity.getExtraData()));
                }
                playInfoUpsResponse.setRequestMode(PlayInfoResponse.RequestMode.MULTIGET);
                playInfoUpsResponse.setInfoType(PlayDefinition.PlayInfoType.UPS);
                return playInfoUpsResponse;
            }
        } else if (intValue == 3) {
            PlayInfoUpsResponse playInfoUpsResponse2 = new PlayInfoUpsResponse(null, null);
            PlayInfoResponse.RequestMode requestMode = PlayInfoResponse.RequestMode.QGET;
            playInfoUpsResponse2.setRequestMode(requestMode);
            VideoInfo parseJson1 = ParseResult.parseJson1(videoUpsInfoEntity.getRawData());
            if (parseJson1 != null) {
                NetUpsInfo netUpsInfo2 = new NetUpsInfo(parseJson1);
                netUpsInfo2.setRaw(videoUpsInfoEntity.getRawData());
                playInfoUpsResponse2.setUpsInfo(netUpsInfo2);
                if (videoUpsInfoEntity.getExtraData() != null) {
                    playInfoUpsResponse2.updateLocalExtraInfo(JSON.parseObject(videoUpsInfoEntity.getExtraData()));
                }
                if (playInfoUpsResponse2.getRequestMode() == null) {
                    playInfoUpsResponse2.setRequestMode(requestMode);
                }
                playInfoUpsResponse2.setInfoType(PlayDefinition.PlayInfoType.UPS);
            }
            return playInfoUpsResponse2;
        } else if (intValue == 4) {
            PlayInfoUpsResponse playInfoUpsResponse3 = new PlayInfoUpsResponse(null, null);
            playInfoUpsResponse3.setRequestMode(PlayInfoResponse.RequestMode.NORMAL);
            VideoInfo parseJson12 = ParseResult.parseJson1(videoUpsInfoEntity.getRawData());
            if (parseJson12 != null) {
                NetUpsInfo netUpsInfo3 = new NetUpsInfo(parseJson12);
                netUpsInfo3.setRaw(videoUpsInfoEntity.getRawData());
                playInfoUpsResponse3.setUpsInfo(netUpsInfo3);
                if (videoUpsInfoEntity.getExtraData() != null) {
                    playInfoUpsResponse3.updateLocalExtraInfo(JSON.parseObject(videoUpsInfoEntity.getExtraData()));
                }
                if (playInfoUpsResponse3.getRequestMode() == null) {
                    playInfoUpsResponse3.setRequestMode(PlayInfoResponse.RequestMode.QGET);
                }
                playInfoUpsResponse3.setInfoType(PlayDefinition.PlayInfoType.UPS);
            }
            return playInfoUpsResponse3;
        }
        return null;
    }

    private VideoUpsInfoEntity getPlayInfoInner(String str, Map<String, String> map, Map<String, String> map2) {
        String str2 = map != null ? map.get("requestMode") : null;
        String str3 = map != null ? map.get("playType") : null;
        try {
            List<VideoUpsInfoEntity> upsCacheData = SimpleLocalDataStorage.getInstance().getVideoUpsInfoDao().getUpsCacheData(str, System.currentTimeMillis());
            if (upsCacheData != null && upsCacheData.size() != 0) {
                VideoUpsInfoEntity videoUpsInfoEntity = upsCacheData.get(0);
                if (map2 != null) {
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(value) && (videoUpsInfoEntity.getExtraData() == null || !videoUpsInfoEntity.getExtraData().contains(value))) {
                            return null;
                        }
                    }
                }
                if (str2 == null || str2.equals(videoUpsInfoEntity.getRequestMode())) {
                    if (str3 != null) {
                        if (!str3.equals(videoUpsInfoEntity.getPlayType())) {
                            return null;
                        }
                    }
                    return videoUpsInfoEntity;
                }
                return null;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void cleanPlayInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            SimpleLocalDataStorage.getInstance().getVideoUpsInfoDao().deleteCache(str);
        } catch (Exception unused) {
        }
    }

    public boolean isExistPlayInfo(String str, Map<String, String> map, Map<String, String> map2) {
        return (TextUtils.isEmpty(str) || getPlayInfoInner(str, map, map2) == null) ? false : true;
    }

    public PlayInfoResponse queryPlayInfo(String str, Map<String, String> map, Map<String, String> map2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            VideoUpsInfoEntity playInfoInner = getPlayInfoInner(str, map, map2);
            if (playInfoInner == null) {
                return null;
            }
            PlayInfoResponse constructResponse = constructResponse(playInfoInner);
            if (Logger.DEBUG && constructResponse != null) {
                Log.e(SimpleLocalDataStorage.TAG, "Get cache for " + str + " content: " + playInfoInner.toString());
            }
            return constructResponse;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0096, code lost:
        if (r10 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a0, code lost:
        if (r10.equals(r3.getPlayType()) != false) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<com.youku.playerservice.axp.playinfo.PlayInfoResponse> queryPlayInfo(java.util.List<java.lang.String> r9, java.util.Map<java.lang.String, java.lang.String> r10, java.util.Map<java.lang.String, java.lang.String> r11) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto Lb0
            int r1 = r9.size()
            if (r1 != 0) goto Lb
            goto Lb0
        Lb:
            if (r10 == 0) goto L16
            java.lang.String r1 = "requestMode"
            java.lang.Object r1 = r10.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            goto L17
        L16:
            r1 = r0
        L17:
            if (r10 == 0) goto L22
            java.lang.String r2 = "playType"
            java.lang.Object r10 = r10.get(r2)
            java.lang.String r10 = (java.lang.String) r10
            goto L23
        L22:
            r10 = r0
        L23:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.youku.playerservice.axp.cache.local.SimpleLocalDataStorage r3 = com.youku.playerservice.axp.cache.local.SimpleLocalDataStorage.getInstance()     // Catch: java.lang.Exception -> Lb0
            com.youku.playerservice.axp.cache.local.db.dao.VideoStoreDao r3 = r3.getVideoUpsInfoDao()     // Catch: java.lang.Exception -> Lb0
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> Lb0
            java.util.List r9 = r3.getUpsCacheData(r9, r4)     // Catch: java.lang.Exception -> Lb0
            if (r9 == 0) goto Lb0
            int r3 = r9.size()     // Catch: java.lang.Exception -> Lb0
            if (r3 != 0) goto L41
            goto Lb0
        L41:
            java.util.Iterator r9 = r9.iterator()     // Catch: java.lang.Exception -> Lb0
        L45:
            boolean r3 = r9.hasNext()     // Catch: java.lang.Exception -> Lb0
            if (r3 == 0) goto Laf
            java.lang.Object r3 = r9.next()     // Catch: java.lang.Exception -> Lb0
            com.youku.playerservice.axp.cache.local.db.entity.VideoUpsInfoEntity r3 = (com.youku.playerservice.axp.cache.local.db.entity.VideoUpsInfoEntity) r3     // Catch: java.lang.Exception -> Lb0
            r4 = 1
            if (r11 == 0) goto L85
            java.util.Set r5 = r11.entrySet()     // Catch: java.lang.Exception -> Lb0
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> Lb0
        L5c:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Exception -> Lb0
            if (r6 == 0) goto L85
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Exception -> Lb0
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6     // Catch: java.lang.Exception -> Lb0
            java.lang.Object r6 = r6.getValue()     // Catch: java.lang.Exception -> Lb0
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> Lb0
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> Lb0
            if (r7 != 0) goto L5c
            java.lang.String r7 = r3.getExtraData()     // Catch: java.lang.Exception -> Lb0
            if (r7 == 0) goto L84
            java.lang.String r7 = r3.getExtraData()     // Catch: java.lang.Exception -> Lb0
            boolean r6 = r7.contains(r6)     // Catch: java.lang.Exception -> Lb0
            if (r6 != 0) goto L5c
        L84:
            r4 = 0
        L85:
            if (r4 == 0) goto L94
            if (r1 == 0) goto L94
            java.lang.String r5 = r3.getRequestMode()     // Catch: java.lang.Exception -> Lb0
            boolean r5 = r1.equals(r5)     // Catch: java.lang.Exception -> Lb0
            if (r5 != 0) goto L94
            goto L45
        L94:
            if (r4 == 0) goto La3
            if (r10 == 0) goto La3
            java.lang.String r5 = r3.getPlayType()     // Catch: java.lang.Exception -> Lb0
            boolean r5 = r10.equals(r5)     // Catch: java.lang.Exception -> Lb0
            if (r5 != 0) goto La3
            goto L45
        La3:
            if (r4 == 0) goto L45
            com.youku.playerservice.axp.playinfo.PlayInfoResponse r3 = r8.constructResponse(r3)     // Catch: java.lang.Exception -> Lb0
            if (r3 == 0) goto L45
            r2.add(r3)     // Catch: java.lang.Exception -> Lb0
            goto L45
        Laf:
            return r2
        Lb0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.cache.CacheLocalController.queryPlayInfo(java.util.List, java.util.Map, java.util.Map):java.util.List");
    }

    public boolean savePlayInfoResponse(PlayInfoResponse playInfoResponse, Map<String, String> map, Map<String, String> map2) {
        if (playInfoResponse != null && !TextUtils.isEmpty(playInfoResponse.getCachePlayID())) {
            try {
                VideoUpsInfoEntity constructEntity = constructEntity(playInfoResponse, map, map2);
                if (constructEntity == null) {
                    return false;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(constructEntity);
                SimpleLocalDataStorage.getInstance().getVideoUpsInfoDao().insertUpsCacheData(arrayList);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public boolean savePlayInfoResponse(List<PlayInfoResponse> list, Map<String, String> map, Map<String, String> map2) {
        if (list != null && list.size() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (PlayInfoResponse playInfoResponse : list) {
                    VideoUpsInfoEntity constructEntity = constructEntity(playInfoResponse, map, map2);
                    if (constructEntity != null) {
                        if (Logger.DEBUG) {
                            Log.e(SimpleLocalDataStorage.TAG, "" + constructEntity.toString());
                        }
                        arrayList.add(constructEntity);
                    }
                }
                SimpleLocalDataStorage.getInstance().getVideoUpsInfoDao().insertUpsCacheData(arrayList);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
