package com.youku.playerservice.axp.playinfo;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alimm.xadsdk.business.common.utils.AdUtils;
import com.alimm.xadsdk.request.builder.BaseAdRequestBuilder;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.taobao.tao.log.TLogConstant;
import com.taobao.weex.annotation.JSMethod;
import com.youku.android.liveservice.bean.BizType;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.Mcs;
import com.youku.android.liveservice.bean.MicPlayInfo;
import com.youku.android.liveservice.bean.Quality;
import com.youku.android.liveservice.bean.Stream;
import com.youku.arch.v3.core.Constants;
import com.youku.d.a;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.item.Codec;
import com.youku.playerservice.axp.item.LiveItem;
import com.youku.playerservice.axp.item.QualityStream;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.PlayerUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.mtop.BaseMtopRequest;
import com.youku.vpm.constants.TableField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import tb.cf0;
import tb.kh1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayInfoLiveResponse extends PlayInfoResponse {
    public static final String IS_RAPHAEL = "isRaphael";
    public static final String IS_SCENE = "isScene";
    private static final String LANGCODE = "default";
    public static final String SCENE_ID = "sceneId";
    public static final String SCREEN_ID = "screenId";
    private Context mContext;
    private Map<String, List<QualityStream>> mQualityList;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class RaphaelMtopRequest extends BaseMtopRequest {
        public RaphaelMtopRequest(String str) {
            this.API_NAME = str;
            this.VERSION = "1.0";
        }

        @Override // com.youku.playerservice.axp.utils.mtop.BaseMtopRequest
        public MtopResponse doMtopRequest(HashMap<String, Object> hashMap) {
            MtopRequest mtopRequest = new MtopRequest();
            mtopRequest.setApiName(this.API_NAME);
            mtopRequest.setVersion(this.VERSION);
            mtopRequest.setNeedEcode(false);
            mtopRequest.setData(BaseMtopRequest.convertMapToDataStr(hashMap));
            return a.a().build(mtopRequest, AppInfoProviderProxy.getTTID()).syncRequest();
        }
    }

    public PlayInfoLiveResponse(Context context, PlayParams playParams) {
        super(playParams);
        this.mContext = context;
    }

    private void constructQualityList(LivePlayControl livePlayControl) {
        this.mQualityList = new LinkedHashMap();
        if (livePlayControl == null) {
            TLogUtil.playLog("livePlayControl为空，无法构建清晰度列表");
        } else if ("live".equals(livePlayControl.streamMode)) {
            ArrayList arrayList = new ArrayList();
            for (Quality quality : livePlayControl.qualities) {
                String str = quality.selectionName;
                int i = quality.quality;
                com.youku.playerservice.axp.item.Quality convert = convert(quality);
                if (convert != com.youku.playerservice.axp.item.Quality.UNKNOWN) {
                    convert.setLiveDescription(str);
                    convert.putString("name", quality.name);
                    convert.putString("selectionName", quality.selectionName);
                    convert.setLiveCode(i);
                    arrayList.add(new QualityStream(convert, "default", quality.bitStream));
                }
            }
            this.mQualityList.put("default", arrayList);
        }
    }

    private com.youku.playerservice.axp.item.Quality convert(Quality quality) {
        return quality.bizSwitch.abr == 1 ? com.youku.playerservice.axp.item.Quality.AUTO : quality.hbr == 1 ? com.youku.playerservice.axp.item.Quality.HD3_HBR : com.youku.playerservice.axp.item.Quality.getQualityByLiveCode(quality.quality);
    }

    private String getEdgeParam(LivePlayControl livePlayControl) {
        List<Stream> list;
        if (livePlayControl == null || (list = livePlayControl.streams) == null || list.size() <= 0) {
            return null;
        }
        for (Stream stream : livePlayControl.streams) {
            if (!TextUtils.isEmpty(stream.edgeParam)) {
                return stream.edgeParam;
            }
        }
        return null;
    }

    private List<LiveItem> getLiveItems(PlayParams playParams, boolean z, LivePlayControl livePlayControl) {
        Codec codec;
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        Quality defaultQuality = livePlayControl.getDefaultQuality();
        Codec codec2 = Codec.H264;
        PlayDefinition.PlayFormat playFormatByProtocol = PlayDefinition.PlayFormat.getPlayFormatByProtocol(defaultQuality.playType);
        int i = defaultQuality.h265;
        boolean z2 = true;
        if (i != 1 && i != 2) {
            z2 = false;
        }
        if (!z2 || TextUtils.isEmpty(defaultQuality.h265PlayUrl)) {
            codec = codec2;
            str = defaultQuality.h264PlayUrl;
            str2 = defaultQuality.h264TSUrl;
        } else {
            str = defaultQuality.h265PlayUrl;
            str2 = defaultQuality.h265TSUrl;
            codec = Codec.H265;
        }
        LiveItem liveItem = new LiveItem(playParams, str);
        liveItem.setLivePlayControl(this.mLiveInfo.getLivePlayControl());
        liveItem.setPlayFormat(playFormatByProtocol);
        liveItem.setQuality(convert(defaultQuality));
        liveItem.setTimeUrl(str2);
        liveItem.setCodec(codec);
        liveItem.setEnablePursue(z);
        liveItem.setStreamType(defaultQuality.bitStream);
        arrayList.add(liveItem);
        return arrayList;
    }

    public static String getVideoType(String str) {
        if ("3".equals(str)) {
            return "来疯";
        }
        if ("4".equals(str)) {
            return "OGC";
        }
        if ("5".equals(str)) {
            return "体育";
        }
        if ("6".equals(str)) {
            return "PGC";
        }
        if ("7".equals(str)) {
            return BaseAdRequestBuilder.LICENSE_CIBN;
        }
        if ("9".equals(str)) {
            return "轮播台";
        }
        return null;
    }

    private boolean useRaphaelPlayer(LivePlayControl livePlayControl) {
        List<Stream> list;
        if (livePlayControl == null || (list = livePlayControl.streams) == null || list.size() <= 0 || 1 != livePlayControl.fansMode) {
            return false;
        }
        String edgeParam = getEdgeParam(livePlayControl);
        for (Stream stream : livePlayControl.streams) {
            if (edgeParam != null && livePlayControl.sceneId.equals(stream.sceneId)) {
                TLogUtil.playLog("PlayInfoLiveResponse edge video, use raphael player:" + stream.edgeParam);
                return true;
            }
        }
        TLogUtil.playLog("PlayInfoLiveResponse edge video, use raphael player false edgeParam ： " + edgeParam);
        return false;
    }

    @Override // com.youku.playerservice.axp.playinfo.PlayInfoResponse
    public List<LiveItem> getPlayItem(PlayParams playParams) {
        List<Stream> list;
        List<LiveItem> list2;
        LivePlayControl livePlayControl;
        Iterator<Stream> it;
        JSONObject parseObject;
        JSONObject jSONObject;
        String str;
        boolean z;
        ArrayList arrayList = new ArrayList();
        LivePlayControl livePlayControl2 = this.mLiveInfo.getLivePlayControl();
        boolean enablePursue = ApsUtil.enablePursue(this.mContext, BizType.getBizTypeByValue(livePlayControl2.bizType));
        if (!"live".equals(livePlayControl2.streamMode)) {
            if ("mic".equals(livePlayControl2.streamMode)) {
                if (TextUtils.isEmpty(livePlayControl2.micMode) || "video".equals(livePlayControl2.micMode) || PushConstants.URI_PACKAGE_NAME.equals(livePlayControl2.micMode)) {
                    if (livePlayControl2.mcu == 1) {
                        return getLiveItems(playParams, enablePursue, livePlayControl2);
                    }
                    String str2 = livePlayControl2.micInfo.po.get(0);
                    ArrayList arrayList2 = new ArrayList();
                    if (livePlayControl2.micInfo.mcs.size() > 0) {
                        for (Mcs mcs : livePlayControl2.micInfo.mcs) {
                            MicPlayInfo micPlayInfo = new MicPlayInfo();
                            micPlayInfo.rtp = PlayerUtil.getPlayRtp(mcs, livePlayControl2.micInfo.dfi);
                            micPlayInfo.flv = PlayerUtil.getPlayFlv(mcs, livePlayControl2.micInfo.dfi);
                            micPlayInfo.artp = PlayerUtil.getPlayArtp(mcs, livePlayControl2.micInfo.dfi);
                            micPlayInfo.grtn = PlayerUtil.getPlayGrtn(mcs, livePlayControl2.micInfo.dfi);
                            arrayList2.add(micPlayInfo);
                        }
                    }
                    for (int i = 0; i < arrayList2.size(); i++) {
                        String str3 = "rtp".equals(str2) ? ((MicPlayInfo) arrayList2.get(i)).rtp.Url : "httpFlv".equals(str2) ? ((MicPlayInfo) arrayList2.get(i)).flv.Url : "artp".equals(str2) ? ((MicPlayInfo) arrayList2.get(i)).artp.Url : "grtn".equals(str2) ? ((MicPlayInfo) arrayList2.get(i)).grtn.Url : "";
                        PlayDefinition.PlayFormat playFormatByProtocol = PlayDefinition.PlayFormat.getPlayFormatByProtocol(str2);
                        LiveItem liveItem = new LiveItem(playParams, str3);
                        liveItem.setLivePlayControl(livePlayControl2);
                        liveItem.setPlayFormat(playFormatByProtocol);
                        liveItem.setCodec(Codec.H264);
                        liveItem.setEnablePursue(enablePursue);
                        arrayList.add(liveItem);
                    }
                    return arrayList;
                }
                return arrayList;
            }
            return arrayList;
        }
        List<LiveItem> liveItems = getLiveItems(playParams, enablePursue, livePlayControl2);
        if (useRaphaelPlayer(livePlayControl2) && (list = livePlayControl2.streams) != null && list.size() > 0) {
            String edgeParam = getEdgeParam(livePlayControl2);
            Iterator<Stream> it2 = livePlayControl2.streams.iterator();
            while (it2.hasNext()) {
                Stream next = it2.next();
                if (TextUtils.isEmpty(livePlayControl2.sceneId) || !livePlayControl2.sceneId.equals(next.sceneId)) {
                    list2 = liveItems;
                    livePlayControl = livePlayControl2;
                    it = it2;
                } else {
                    if (!TextUtils.isEmpty(next.edgeParam)) {
                        edgeParam = next.edgeParam;
                    }
                    JSONObject parseObject2 = JSON.parseObject(edgeParam);
                    String string = parseObject2.getJSONObject("args").getString(Constants.CONFIG);
                    String string2 = parseObject2.getJSONObject("args").getString(TLogConstant.PERSIST_TASK_ID);
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put(TLogConstant.PERSIST_TASK_ID, string2);
                    MtopResponse doMtopRequest = new RaphaelMtopRequest(string).doMtopRequest(hashMap);
                    try {
                        JSONObject parseObject3 = JSON.parseObject(new String(doMtopRequest.getBytedata()));
                        String string3 = parseObject3.getJSONObject("data").getJSONObject("data").getString("ossResultUrl");
                        String string4 = parseObject3.getJSONObject("data").getJSONObject("data").getString(kh1.RESOURCE_STREAM);
                        JSONArray parseArray = JSON.parseArray(string4);
                        String string5 = playParams.getPlayIdParams().getString("targetSceneId");
                        String str4 = livePlayControl2.sceneId;
                        if (TextUtils.isEmpty(string5)) {
                            string5 = str4;
                        }
                        list2 = liveItems;
                        int i2 = 0;
                        while (true) {
                            str = edgeParam;
                            if (i2 >= parseArray.size()) {
                                livePlayControl = livePlayControl2;
                                it = it2;
                                break;
                            }
                            JSONObject jSONObject2 = parseArray.getJSONObject(i2);
                            it = it2;
                            JSONArray jSONArray = parseArray;
                            if ("1".equals(jSONObject2.getString("templateType"))) {
                                JSONArray jSONArray2 = jSONObject2.getJSONArray("locationInfo");
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= jSONArray2.size()) {
                                        livePlayControl = livePlayControl2;
                                        z = false;
                                        break;
                                    }
                                    livePlayControl = livePlayControl2;
                                    JSONArray jSONArray3 = jSONArray2.getJSONObject(i3).getJSONArray("positionNormalized");
                                    float parseFloat = Float.parseFloat(jSONArray3.getString(0));
                                    float parseFloat2 = Float.parseFloat(jSONArray3.getString(1));
                                    if (parseFloat == 0.0f && parseFloat2 == 0.0f && string5.equals(jSONArray2.getJSONObject(i3).getString("sceneId"))) {
                                        parseObject2.put("streamId", (Object) jSONObject2.getString("streamId"));
                                        z = true;
                                        break;
                                    }
                                    i3++;
                                    livePlayControl2 = livePlayControl;
                                }
                                if (z) {
                                    break;
                                }
                            } else {
                                livePlayControl = livePlayControl2;
                            }
                            i2++;
                            edgeParam = str;
                            it2 = it;
                            parseArray = jSONArray;
                            livePlayControl2 = livePlayControl;
                        }
                        String string6 = playParams.getPlayIdParams().getString("raphaelStreamId");
                        if (!TextUtils.isEmpty(string6)) {
                            parseObject2.put("streamId", (Object) string6);
                        }
                        parseObject2.put(IS_RAPHAEL, (Object) playParams.getPlayIdParams().getString(IS_RAPHAEL));
                        parseObject2.put("url", (Object) string3);
                        parseObject2.put("streams", (Object) string4);
                        next.edgeParam = parseObject2.toString();
                        edgeParam = str;
                    } catch (Exception e) {
                        String str5 = (doMtopRequest == null || (parseObject = JSON.parseObject(new String(doMtopRequest.getBytedata()))) == null || !parseObject.containsKey("data") || (jSONObject = parseObject.getJSONObject("data")) == null) ? "unknow" : jSONObject.getString("code") + JSMethod.NOT_SET + jSONObject.getString("msg");
                        PlayInfoError playInfoError = new PlayInfoError();
                        playInfoError.setErrorCode(Math.abs((int) cf0.ERROR_IO_EXCEPTION) + 60000);
                        playInfoError.setErrorMsg(str5);
                        setError(playInfoError);
                        TLogUtil.playLog("raphael video exception:" + e);
                        return null;
                    }
                }
                liveItems = list2;
                it2 = it;
                livePlayControl2 = livePlayControl;
            }
        }
        return liveItems;
    }

    @Override // com.youku.playerservice.axp.playinfo.PlayInfoResponse
    public Map<String, List<QualityStream>> getQualityList(String str) {
        return this.mQualityList;
    }

    @Override // com.youku.playerservice.axp.playinfo.PlayInfoResponse
    public void setLiveInfo(LiveInfo liveInfo) {
        PlayParams playParams;
        String str;
        List<Stream> list;
        super.setLiveInfo(liveInfo);
        LivePlayControl livePlayControl = liveInfo.getLivePlayControl();
        boolean z = livePlayControl != null && livePlayControl.liveStatus == 1 && (list = livePlayControl.streams) != null && list.size() > 1 && livePlayControl.sceneType == 0;
        if (livePlayControl == null || livePlayControl.playLog != 1) {
            playParams = this.mPlayParams;
            str = "true";
        } else {
            playParams = this.mPlayParams;
            str = "false";
        }
        playParams.putString("disablePlayLog", str);
        this.mProperties.put(IS_SCENE, Boolean.valueOf(z));
        this.mProperties.put("showId", this.mPlayParams.getPlayIdParams().getPlayId());
        if (livePlayControl != null) {
            this.mProperties.put("vid", livePlayControl.screenId);
            this.mProperties.put(TableField.VIDEO_TYPE, getVideoType(livePlayControl.bizType));
        }
        if (livePlayControl != null) {
            String str2 = livePlayControl.adJsonStr;
            if (!TextUtils.isEmpty(str2)) {
                this.mAdInfo = AdUtils.parseAd(str2, true, 0, null);
                this.mProperties.put("adJson", str2);
            }
        }
        constructQualityList(livePlayControl);
    }
}
