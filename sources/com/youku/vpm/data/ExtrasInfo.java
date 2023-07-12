package com.youku.vpm.data;

import android.text.TextUtils;
import com.alimm.xadsdk.base.expose.MonitorType;
import com.youku.vpm.IPlayer;
import com.youku.vpm.IVpmFullInfo;
import com.youku.vpm.IVpmInfo;
import com.youku.vpm.framework.TableId;
import com.youku.vpm.param.CustomParams;
import com.youku.vpm.track.Track;
import com.youku.vpm.utils.TrackUtil;
import java.util.Map;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ExtrasInfo extends ExtraMap {
    public static final String AROUSE_REFER = "arouseRefer";
    public static final String AROUSE_TRACE_ID = "arouseTraceId";
    public static final String EXTRAS = "extras";
    public static final String IS_AROUSE = "isArouse";
    public static final String PLAY_FIRST = "playFirst";

    public ExtrasInfo(Track track, String str) {
        super(str);
        Map<String, String> allDims;
        IVpmInfo vpmInfo = track.getVpmInfo();
        IVpmFullInfo vpmFullInfo = track.getVpmFullInfo();
        IPlayer player = track.getPlayer();
        put("hasMaster", vpmInfo.getString("hasMaster", null));
        put("useMaster", vpmInfo.getString("useMaster", null));
        put("requestQuality", vpmInfo.getString("requestQuality", null));
        put("playQuality", vpmFullInfo != null ? vpmFullInfo.getString("playQuality", null) : null);
        put("bitStreamChange", vpmInfo.getString("bitStreamChange", null));
        put("findStreamError", vpmInfo.getString("findStreamError", null));
        put("langChange", vpmInfo.getString("langChange", null));
        put("playRetry", vpmInfo.getString("playRetry", null));
        put("playRetryError", vpmInfo.getString("playRetryError", null));
        put("errorCode", track.getString("errorCode"));
        put("replay", vpmInfo.getString("replay", null));
        put("spm-url", vpmInfo.getString("spm-url", null));
        put("scm", vpmInfo.getString("scm", null));
        put("pv-spm-pre", vpmInfo.getString("pv-spm-pre", null));
        put("feedVpm", vpmInfo.getString("feedVpm", null));
        put("ntkInterfere", vpmInfo.getString("ntkInterfere", null));
        put("ntkInterfereEnable", vpmInfo.getString("ntkInterfereEnable", null));
        put("catonTip", vpmInfo.getString("catonTip", null));
        put("wifiInfo", vpmInfo.getString("wifiInfo", null));
        put("pcdnVersion", track.getPlayer().getString("pcdnVersion", null));
        put("smartTileError", vpmInfo.getString("smartTileError", null));
        put("useSmartTile", vpmInfo.getString("useSmartTile", "0"));
        if (vpmFullInfo != null) {
            put("hasSmartTile", vpmFullInfo.getString("hasSmartTile", null));
            put("upsClientNetIP", vpmFullInfo.getString("ups_client_netip", null));
            put("extras-ismcu", vpmFullInfo.getString("isMcu", null));
            put("extras-ispk", vpmFullInfo.getString("isPK", null));
        }
        put("tinywindowNumOfEnter", vpmInfo.getString("tinywindowNumOfEnter", null));
        put("tinywindowTimeOfPlay", vpmInfo.getString("tinywindowTimeOfPlay", null));
        put("tinywindowNumOfKeep", vpmInfo.getString("tinywindowNumOfKeep", null));
        put("tinyWindowType", vpmInfo.getString("tinyWindowType", null));
        put("tinywindowRefusePermission", vpmInfo.getString("tinywindowRefusePermission", null));
        if (contains("onePlay", MonitorType.PLAYING, "beforePlay")) {
            if (contains(MonitorType.PLAYING, "beforePlay")) {
                String paramsFromCore = track.getParamsFromCore("368", null);
                if (!TextUtils.isEmpty(paramsFromCore)) {
                    putAll(new CustomParams(paramsFromCore).getData());
                }
            }
            String paramsFromCore2 = track.getParamsFromCore("365", null);
            if (!TextUtils.isEmpty(paramsFromCore2)) {
                putAll(new CustomParams(paramsFromCore2).getData());
            }
            if (vpmFullInfo != null) {
                put("dofDegradeMode", vpmFullInfo.getString("dofDegradeMode", null));
            }
            put("fvvUpsMsgCode", vpmInfo.getString("fvvUpsMsgCode", null));
            put("fvvDownloadStatus", vpmInfo.getString("fvvDownloadStatus", null));
            put("fvvpreload", vpmInfo.getString("fvvpreload", null));
            put("startPointHistory", vpmInfo.getString("startPointHistory", null));
            put(v.TAK_ABILITY_SHOW_POP_BACKGROUND_MODE, vpmInfo.getString(v.TAK_ABILITY_SHOW_POP_BACKGROUND_MODE, null));
        }
        put(IS_AROUSE, vpmInfo.getString(IS_AROUSE, null));
        put(PLAY_FIRST, vpmInfo.getString(PLAY_FIRST, null));
        put(AROUSE_TRACE_ID, vpmInfo.getString(AROUSE_TRACE_ID, null));
        put(AROUSE_REFER, TrackUtil.encode(vpmInfo.getString(AROUSE_REFER, null)));
        if (!contains("onePlay", MonitorType.PLAYING, "beforePlay") || player == null || (allDims = player.getAllDims(TableId.ONEPLAY)) == null) {
            return;
        }
        String str2 = allDims.get("ntkLastReports");
        put("ntkLastReports", str2 == null ? "" : str2);
        String str3 = allDims.get("dlreportfirstts");
        put("dlreportfirstts", str3 == null ? "" : str3);
    }
}
