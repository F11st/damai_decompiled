package com.youku.playerservice.axp.modules.postprocessing;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.item.PlayItem;
import com.youku.playerservice.axp.modules.BaseModule;
import com.youku.playerservice.axp.player.PlayerImpl;
import com.youku.playerservice.axp.playinfo.NetUpsInfo;
import com.youku.playerservice.axp.utils.TLogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PostProcessingModule extends BaseModule {
    private static final String ALGORITHM = "algorithm";
    private static final String DEFAULTEXTEND = "defaultextend";
    private static final String EXTEND = "extend";
    private static final String EXTRAS = "extras";
    private static final String SETRECORD = "setRecord";
    public static final String TAG = "PostProcessingModule";
    private Map<String, PostProcessionItem> lastMap;
    private HashSet<String> lastPPFilters;
    private ArrayList<String> processingNamespaces2;

    public PostProcessingModule(Context context, PlayerImpl playerImpl) {
        super(context, playerImpl);
        this.processingNamespaces2 = new ArrayList<>();
        this.lastPPFilters = new HashSet<>();
        this.processingNamespaces2.add("pp_sharp");
        this.processingNamespaces2.add("pp_color_filter");
        this.processingNamespaces2.add("pp_color_space_correct");
        this.processingNamespaces2.add("pp_hdr");
        this.processingNamespaces2.add("pp_audio_enhancement");
        this.processingNamespaces2.add("pp_hdr10");
        this.processingNamespaces2.add("pp_deband");
        this.processingNamespaces2.add("pp_film_style");
        this.processingNamespaces2.add("pp_adaptive_sharp");
        this.processingNamespaces2.add("pp_pixelwork");
    }

    private void closeLastProcess(Map<String, PostProcessionItem> map) {
        Map<String, PostProcessionItem> map2 = this.lastMap;
        if (map2 != null) {
            for (Map.Entry<String, PostProcessionItem> entry : map2.entrySet()) {
                closePostProcess2(Integer.parseInt(entry.getKey()));
            }
            this.lastMap.clear();
        }
        this.lastMap = map;
    }

    private void closePostProcess2(int i) {
        if (i == 0 || this.mPlayer == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", "0");
        int filter = this.mPlayer.setFilter(i, hashMap);
        TLogUtil.loge(TAG, "close2  filter = " + i + "  with params = " + hashMap + " , result = " + filter);
    }

    private void doBatchProcess(Map<String, PostProcessionItem> map, Map<String, String> map2) {
        Map<String, PostProcessionItem> map3;
        if (map != null) {
            Iterator<Map.Entry<String, PostProcessionItem>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, PostProcessionItem> next = it.next();
                String key = next.getKey();
                if (TextUtils.isEmpty(key) || !TextUtils.isDigitsOnly(key) || "0".equals(key)) {
                    TLogUtil.loge(TAG, "不规范的数据: " + next.getValue().toString());
                    it.remove();
                } else if (openNewPostProcess(next.getValue()) && (map3 = this.lastMap) != null) {
                    map3.remove(key);
                }
            }
        }
    }

    private void doPostProcess() {
        if (this.mPlayer.getPlayInfo() != null && this.mPlayer.getPlayInfo().getPlayParams().getPlayType() == PlayDefinition.PlayType.LIVE && this.mPlayer.getPlayInfo().getPlayInfoResponse() != null && this.mPlayer.getPlayInfo().getPlayInfoResponse().getLiveInfo() != null && this.mPlayer.getPlayInfo().getPlayInfoResponse().getLiveInfo().getLivePlayControl() != null && this.mPlayer.getPlayInfo().getPlayInfoResponse().getLiveInfo().getLivePlayControl().playerWidget != null && this.mPlayer.getPlayInfo().getPlayInfoResponse().getLiveInfo().getLivePlayControl().playerWidget.postProcessConfig != null) {
            String streamType = this.mPlayer.getPlayInfo().getPlayItem().getStreamType();
            if (TextUtils.isEmpty(streamType)) {
                return;
            }
            doPostProcessByPlayControl(this.mPlayer.getPlayInfo().getPlayInfoResponse().getLiveInfo().getLivePlayControl().playerWidget.postProcessConfig, streamType);
        } else if (this.mPlayer.getPlayInfo() == null || this.mPlayer.getPlayInfo().getPlayParams().getPlayType() != PlayDefinition.PlayType.VOD || this.mPlayer.getPlayInfo().getPlayInfoResponse() == null || this.mPlayer.getPlayInfo().getPlayInfoResponse().getUpsInfo() == null || this.mPlayer.getPlayInfo().getPlayInfoResponse().getUpsInfo().getVideoInfo() == null || this.mPlayer.getPlayInfo().getPlayInfoResponse().getUpsInfo().getVideoInfo().getController() == null || !this.mPlayer.getPlayInfo().getPlayInfoResponse().getUpsInfo().getVideoInfo().getController().post_process) {
        } else {
            PlayItem playItem = this.mPlayer.getPlayInfo().getPlayItem();
            doPostProcessByUps(this.mPlayer.getPlayInfo().getPlayInfoResponse().getUpsInfo(), playItem, playItem.getStreamType());
        }
    }

    private void doPostProcessByPlayControl(String str, String str2) {
        List<JSONObject> parseArray;
        HashSet hashSet = new HashSet();
        if (str == null) {
            Iterator<String> it = this.lastPPFilters.iterator();
            while (it.hasNext()) {
                closePostProcess2(Integer.parseInt(it.next()));
            }
            this.lastPPFilters.clear();
            this.lastPPFilters.addAll(hashSet);
            return;
        }
        try {
            try {
                JSONObject parseObject = JSON.parseObject(str);
                if (parseObject != null && (parseArray = JSON.parseArray(parseObject.getString(str2), JSONObject.class)) != null && !parseArray.isEmpty()) {
                    for (JSONObject jSONObject : parseArray) {
                        if (TextUtils.equals("1", jSONObject.getString("appPostProcessingMode")) && openPostProcessByPlayControl(jSONObject) == 0) {
                            String string = jSONObject.getString("appPostProcessingType");
                            hashSet.add(string);
                            this.lastPPFilters.remove(string);
                        }
                    }
                }
                Iterator<String> it2 = this.lastPPFilters.iterator();
                while (it2.hasNext()) {
                    closePostProcess2(Integer.parseInt(it2.next()));
                }
            } catch (Exception e) {
                e.printStackTrace();
                Iterator<String> it3 = this.lastPPFilters.iterator();
                while (it3.hasNext()) {
                    closePostProcess2(Integer.parseInt(it3.next()));
                }
            }
            this.lastPPFilters.clear();
            this.lastPPFilters.addAll(hashSet);
        } catch (Throwable th) {
            Iterator<String> it4 = this.lastPPFilters.iterator();
            while (it4.hasNext()) {
                closePostProcess2(Integer.parseInt(it4.next()));
            }
            this.lastPPFilters.clear();
            this.lastPPFilters.addAll(hashSet);
            throw th;
        }
    }

    private void doPostProcessByUps(@NonNull NetUpsInfo netUpsInfo, PlayItem playItem, @Nullable String str) {
        JSONObject ppStreamConfig;
        TLogUtil.loge(TAG, "后处理 UPS方式");
        TLogUtil.loge(TAG, "StreamType=" + playItem.getStreamType() + " sub=" + str);
        if (isHbrAutoStream(playItem.getStreamType()) && TextUtils.isEmpty(str)) {
            TLogUtil.loge(TAG, "帧享智能档以subStreamType为准，return");
            return;
        }
        HashMap hashMap = null;
        try {
            try {
                ppStreamConfig = netUpsInfo.getVideoInfo().getPpStreamConfig();
            } catch (Exception e) {
                e = e;
            }
            if (ppStreamConfig == null) {
                closeLastProcess(null);
                return;
            }
            String langCode = playItem.getLangCode();
            TextUtils.isEmpty(langCode);
            if (!ppStreamConfig.containsKey(langCode)) {
                langCode = "default";
            }
            if (!ppStreamConfig.containsKey(langCode)) {
                TLogUtil.loge(TAG, "no default language data and " + langCode + "data");
                closeLastProcess(null);
                return;
            }
            JSONObject jSONObject = ppStreamConfig.getJSONObject(langCode);
            if (jSONObject != null) {
                if (TextUtils.isEmpty(str)) {
                    str = playItem.getStreamType();
                }
                if (TextUtils.isEmpty(str)) {
                    closeLastProcess(null);
                    return;
                } else if (!jSONObject.containsKey(str)) {
                    TLogUtil.loge(TAG, "no currentStreamType: " + str);
                    closeLastProcess(null);
                    return;
                } else {
                    String string = jSONObject.getString(str);
                    if (TextUtils.isEmpty(string)) {
                        closeLastProcess(null);
                        return;
                    }
                    List<PostProcessionItem> parseArray = JSON.parseArray(string, PostProcessionItem.class);
                    if (parseArray != null) {
                        HashMap hashMap2 = new HashMap();
                        try {
                            StringBuilder sb = new StringBuilder();
                            StringBuilder sb2 = new StringBuilder();
                            for (PostProcessionItem postProcessionItem : parseArray) {
                                if (postProcessionItem != null) {
                                    hashMap2.put(postProcessionItem.type, postProcessionItem);
                                    if (sb.length() > 0) {
                                        sb.append(";");
                                    }
                                    sb.append(postProcessionItem.type);
                                    sb.append("=");
                                    sb.append(postProcessionItem.algorithm);
                                    if (sb2.length() > 0) {
                                        sb2.append(";");
                                    }
                                    StringBuilder sb3 = new StringBuilder();
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append(ALGORITHM);
                                    sb4.append("=");
                                    sb4.append(postProcessionItem.algorithm);
                                    if (!TextUtils.isEmpty(postProcessionItem.extend)) {
                                        sb4.append(";");
                                        sb4.append(EXTEND);
                                        sb4.append("=");
                                        sb4.append(postProcessionItem.extend);
                                    }
                                    if (!TextUtils.isEmpty(postProcessionItem.defaultExtend)) {
                                        sb4.append(";");
                                        sb4.append(DEFAULTEXTEND);
                                        sb4.append("=");
                                        sb4.append(postProcessionItem.defaultExtend);
                                    }
                                    sb3.append(postProcessionItem.type);
                                    sb3.append("=");
                                    sb3.append(jn1.BRACKET_START_STR);
                                    sb3.append((CharSequence) sb4);
                                    sb3.append(jn1.BRACKET_END_STR);
                                    sb2.append((CharSequence) sb3);
                                }
                            }
                            String sb5 = sb.toString();
                            String sb6 = sb2.toString();
                            TLogUtil.loge(TAG, "setRecord : " + sb5 + " extras : " + sb6);
                            doBatchProcess(hashMap2, null);
                            hashMap = hashMap2;
                        } catch (Exception e2) {
                            e = e2;
                            hashMap = hashMap2;
                            TLogUtil.loge(TAG, "后处理解析数据异常 :" + e.getMessage());
                            closeLastProcess(hashMap);
                        } catch (Throwable th) {
                            th = th;
                            hashMap = hashMap2;
                            closeLastProcess(hashMap);
                            throw th;
                        }
                    }
                }
            }
            closeLastProcess(hashMap);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean isHbrAutoStream(String str) {
        try {
            return str.contains("hbr_auto");
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean openNewPostProcess(PostProcessionItem postProcessionItem) {
        TLogUtil.loge(TAG, "openNewPostProcess,filter = " + postProcessionItem.type);
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(postProcessionItem.algorithm)) {
            hashMap.put("type", postProcessionItem.algorithm);
        }
        if (!TextUtils.isEmpty(postProcessionItem.defaultExtend)) {
            hashMap.put(EXTEND, postProcessionItem.defaultExtend);
        }
        if (!TextUtils.isEmpty(postProcessionItem.extend)) {
            hashMap.put("ups_extend", postProcessionItem.extend);
        }
        int parseInt = Integer.parseInt(postProcessionItem.type);
        int filter = parseInt == 18 ? -1 : this.mPlayer.setFilter(parseInt, hashMap);
        TLogUtil.loge(TAG, "openNewPostProcess  filter = " + parseInt + " with params = " + hashMap + " result = " + filter);
        return filter >= 0;
    }

    private int openPostProcessByPlayControl(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(jSONObject.getString("appPostProcessingAlgorithm"))) {
            hashMap.put("type", jSONObject.getString("appPostProcessingAlgorithm"));
        }
        if (!TextUtils.isEmpty(jSONObject.getString("appPostProcessingDefaultExtend"))) {
            hashMap.put(EXTEND, jSONObject.getString("appPostProcessingDefaultExtend"));
        }
        if (!TextUtils.isEmpty(jSONObject.getString("appPostProcessingExtend"))) {
            hashMap.put("ups_extend", jSONObject.getString("appPostProcessingExtend"));
        }
        String string = jSONObject.getString("appPostProcessingType");
        int filter = this.mPlayer.setFilter(Integer.parseInt(string), hashMap);
        TLogUtil.loge(TAG, "openPostProcessByPlayControl  filter = " + string + "  with params = " + hashMap + " , result = " + filter);
        return filter;
    }

    @Override // com.youku.playerservice.axp.modules.BaseModule, com.youku.playerservice.axp.modules.IModule
    public void onQualityChangeFinish(boolean z, Object obj) {
        super.onQualityChangeFinish(z, obj);
        doPostProcess();
    }

    @Override // com.youku.playerservice.axp.modules.BaseModule, com.youku.playerservice.axp.modules.IModule
    public void onRealVideoStart() {
        super.onRealVideoStart();
        doPostProcess();
    }
}
