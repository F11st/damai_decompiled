package com.youku.playerservice.axp.mediasource;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.util.NativeMap;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.Stream;
import com.youku.arch.solid.SolidServer;
import com.youku.arch.solid.Status;
import com.youku.arch.solid.lifecycle.SolidRequest;
import com.youku.player.init.PlayerSuperSolutionMananger;
import com.youku.playerservice.axp.item.LiveItem;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.p2p.P2pManager;
import com.youku.playerservice.axp.p2p.PcdnType;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.SystemUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import tb.d01;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class LiveMediaSource extends AxpMediaSource {
    private static final String TAG = "LiveMediaSource";

    public LiveMediaSource(Context context, PlayInfo playInfo) {
        super(context, playInfo);
    }

    private String constructSixdofJsonParam(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bizName", (Object) "6dof");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("confPath", (Object) str);
        jSONObject2.put("max6DofAngle", (Object) Integer.valueOf(i));
        jSONObject.put("args", (Object) jSONObject2);
        Logger.d(TAG, "sixdof json is " + jSONObject.toString());
        return jSONObject.toString();
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "1.0.0";
        }
    }

    private boolean isRaphaelReady() {
        return true;
    }

    private void setSuperResolutionParamsForHeader(NativeMap nativeMap, boolean z) {
        String str;
        if (Utils.isYoukuOrHuaweiBaipai(this.mContext) && ApsUtil.enableSuperResolution() && z) {
            String str2 = (supportSRDeivce(this.mContext) && supportSuperResolutionCurrentQuality() && superResolutionFilesIsExists()) ? "1" : "-1";
            String str3 = "";
            if (str2.equals("1")) {
                String path = this.mContext.getFilesDir().getPath();
                str3 = path + "/solid-" + getVersionName(this.mContext);
                str = path + "/YKSRConfig/YKSRFiles";
            } else {
                str = "";
            }
            nativeMap.put("cvfilter_run_mode", str2);
            nativeMap.put("cvfilter_so_path", str3);
            nativeMap.put("cvfilter_config_path", str);
        }
    }

    public static boolean supportSRDeivce(Context context) {
        String cpuName = Utils.getCpuName(context);
        String hiAiVersion = SystemUtil.getHiAiVersion();
        return (cpuName.equals("kirin9000") || cpuName.equals("kirin9000E") || cpuName.equals("kirin990") || cpuName.equals("kirin990E")) ? hiAiVersion.compareTo("100.320.010.045") >= 0 : cpuName.equals("kirin980") && hiAiVersion.compareTo("100.210.010.010") >= 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0202  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.youku.alixplayer.model.Period buildPlaylistByLiveInfo() {
        /*
            Method dump skipped, instructions count: 539
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.mediasource.LiveMediaSource.buildPlaylistByLiveInfo():com.youku.alixplayer.model.Period");
    }

    @Override // com.youku.playerservice.axp.mediasource.AxpMediaSource, com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public String getSourceKey() {
        PlayInfo playInfo = this.mPlayInfo;
        return playInfo != null ? playInfo.getPlayId() : "";
    }

    @Override // com.youku.playerservice.axp.mediasource.AxpMediaSource, com.youku.playerservice.axp.mediasource.BaseMediaSource, com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
        LivePlayControl livePlayControl;
        List<Stream> list;
        String str;
        super.preparePlaylist();
        Period buildPlaylistByAdInfo = buildPlaylistByAdInfo();
        if (buildPlaylistByAdInfo != null) {
            this.mPlayList.addPeriod(buildPlaylistByAdInfo);
        }
        Period buildPlaylistByLiveInfo = buildPlaylistByLiveInfo();
        if (buildPlaylistByLiveInfo == null) {
            notifyPlaylistFailed();
            return;
        }
        if (useRaphaelPlayer() && this.mPlayInfo.getPlayInfoResponse() != null && this.mPlayInfo.getPlayInfoResponse().getLiveInfo() != null && (livePlayControl = this.mPlayInfo.getPlayInfoResponse().getLiveInfo().getLivePlayControl()) != null && (list = livePlayControl.streams) != null && list.size() > 0) {
            for (Stream stream : livePlayControl.streams) {
                if (livePlayControl.sceneId.equals(stream.sceneId)) {
                    ArrayList<d01.a> b = d01.b("s-ybd.youku.com", false);
                    d01.a aVar = null;
                    if (b != null && b.size() > 0) {
                        aVar = b.get(0);
                        Logger.d(TAG, "origin ip is " + aVar.b() + " port is " + aVar.c());
                    }
                    Logger.d(TAG, "origin is " + b);
                    buildPlaylistByLiveInfo.addHeader("rh_server_ip", aVar != null ? aVar.b() : "");
                    buildPlaylistByLiveInfo.addHeader("rh_udp_port", aVar != null ? aVar.c() + "" : "1940");
                    if (stream.sixDofInfo != null && stream.sixDofInfo.sixDof == 1) {
                        TLogUtil.playLog("6dof video, set raphael player header.");
                        str = constructSixdofJsonParam(stream.sixDofInfo.confUrl, stream.sixDofInfo.maxAngle);
                    } else if (!TextUtils.isEmpty(stream.edgeParam)) {
                        TLogUtil.playLog("edge video, set raphael player header.");
                        str = stream.edgeParam;
                    }
                    buildPlaylistByLiveInfo.addHeader("edge_param", str);
                }
            }
        }
        this.mPlayList.addPeriod(buildPlaylistByLiveInfo);
        String sessionId = this.mPlayInfo.getPlayParams().getSessionId();
        TLogUtil.flowLog(sessionId, "设置live地址");
        printPlaylist(sessionId, this.mPlayList);
        notifyPlaylistPrepared(this.mPlayList);
    }

    public String[] replaceMasterP2P(String str) {
        String[] strArr = {null, str};
        try {
            String[] split = str.split("[\r\n]+");
            if (split != null && split.length > 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (String str2 : split) {
                    if (str2.contains("#EXT-X-STREAM-INF")) {
                        arrayList.add(str2);
                    } else if (str2.contains("http://") || str2.contains("https://")) {
                        arrayList2.add(str2);
                    }
                }
                if (arrayList2.isEmpty()) {
                    strArr[0] = "null";
                    return strArr;
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    P2pManager.Result pcdnUrl = P2pManager.getInstance(this.mContext.getApplicationContext()).getPcdnUrl(this.mContext, PcdnType.LIVE, (String) it.next());
                    if (!"10000".equals(pcdnUrl.errorCode)) {
                        strArr[0] = pcdnUrl.errorCode;
                        return strArr;
                    }
                    arrayList3.add(pcdnUrl.finalUrl);
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("#EXTM3U\n");
                for (int i = 0; i < arrayList.size(); i++) {
                    stringBuffer.append((String) arrayList.get(i));
                    stringBuffer.append(StringUtils.LF);
                    stringBuffer.append((String) arrayList3.get(i));
                    stringBuffer.append(StringUtils.LF);
                }
                stringBuffer.append("#EXT-X-ENDLIST\n");
                strArr[0] = "10000";
                strArr[1] = stringBuffer.toString();
            }
            return strArr;
        } catch (Exception e) {
            e.printStackTrace();
            return strArr;
        }
    }

    boolean superResolutionConfigFilesIsExists() {
        PlayerSuperSolutionMananger.getInstance();
        return PlayerSuperSolutionMananger.isSRConfigFilesReady();
    }

    boolean superResolutionFilesIsExists() {
        return superResolutionConfigFilesIsExists() && superResolutionSOFilesIsExists();
    }

    boolean superResolutionSOFilesIsExists() {
        try {
            SolidRequest solidRequest = new SolidRequest();
            solidRequest.name = "SuperResolution";
            return SolidServer.checkSoGroupStatus(solidRequest) == Status.DOWNLOADED;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean supportSuperResolutionCurrentQuality() {
        Quality quality = ((LiveItem) this.mPlayInfo.getPlayItem()).getQuality();
        return quality == Quality.HD || quality == Quality.SD || quality == Quality.HD3GP;
    }

    @Override // com.youku.playerservice.axp.mediasource.AxpMediaSource, com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSourceExt
    public boolean useRaphaelPlayer() {
        LivePlayControl livePlayControl;
        List<Stream> list;
        String str;
        if (this.mPlayInfo.getPlayInfoResponse() == null || this.mPlayInfo.getPlayInfoResponse().getLiveInfo() == null || (livePlayControl = this.mPlayInfo.getPlayInfoResponse().getLiveInfo().getLivePlayControl()) == null || (list = livePlayControl.streams) == null || list.size() <= 0) {
            return false;
        }
        for (Stream stream : livePlayControl.streams) {
            if (livePlayControl.sceneId.equals(stream.sceneId)) {
                if (stream.sixDofInfo != null && stream.sixDofInfo.sixDof == 1 && isRaphaelReady()) {
                    str = "6dof video, use raphael player.";
                } else if (!TextUtils.isEmpty(stream.edgeParam) && livePlayControl.fansMode == 1 && isRaphaelReady()) {
                    str = "edge video, use raphael player:" + stream.edgeParam;
                }
                TLogUtil.playLog(str);
                return true;
            }
        }
        return false;
    }
}
