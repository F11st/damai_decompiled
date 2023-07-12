package com.youku.playerservice.axp.utils;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.taobao.application.common.C6673b;
import com.taobao.phenix.request.ImageStatistics;
import com.youku.android.liveservice.bean.Artp;
import com.youku.android.liveservice.bean.Grtn;
import com.youku.android.liveservice.bean.Hls;
import com.youku.android.liveservice.bean.HttpFlv;
import com.youku.android.liveservice.bean.Mcs;
import com.youku.android.liveservice.bean.Rtp;
import com.youku.core.context.YoukuContext;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.vo.LanguageBean;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayerUtil {
    public static boolean has265Failed;

    public static String completionVid(String str) {
        StringBuilder sb;
        String str2;
        if ("".equals(str) || !str.substring(0, 1).equals("X")) {
            return str;
        }
        int length = str.substring(1).getBytes().length % 4;
        if (length == 3) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "=";
        } else if (length != 2) {
            return str;
        } else {
            sb = new StringBuilder();
            sb.append(str);
            str2 = jn1.EQUAL2;
        }
        sb.append(str2);
        return sb.toString();
    }

    public static String getAbilityJson(boolean z) {
        return getAbilityJsonInJsonObject(z).toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00be A[Catch: JSONException -> 0x00e4, TryCatch #0 {JSONException -> 0x00e4, blocks: (B:3:0x000d, B:5:0x0047, B:8:0x005b, B:12:0x0087, B:14:0x0093, B:16:0x00be, B:18:0x00c6, B:28:0x00de, B:21:0x00cf, B:24:0x00d6, B:13:0x008c), top: B:33:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c6 A[Catch: JSONException -> 0x00e4, TryCatch #0 {JSONException -> 0x00e4, blocks: (B:3:0x000d, B:5:0x0047, B:8:0x005b, B:12:0x0087, B:14:0x0093, B:16:0x00be, B:18:0x00c6, B:28:0x00de, B:21:0x00cf, B:24:0x00d6, B:13:0x008c), top: B:33:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject getAbilityJsonInJsonObject(boolean r10) {
        /*
            java.lang.String r0 = "fansPlay"
            java.lang.String r1 = "z_real_config"
            java.lang.String r2 = "1"
            java.lang.String r3 = "0"
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r5 = "hbrPlay"
            com.youku.media.arch.instruments.ConfigFetcher r6 = com.youku.media.arch.instruments.ConfigFetcher.getInstance()     // Catch: org.json.JSONException -> Le4
            java.lang.String r7 = "live_z_real_enable"
            java.lang.String r6 = r6.getConfig(r1, r7, r3)     // Catch: org.json.JSONException -> Le4
            r4.put(r5, r6)     // Catch: org.json.JSONException -> Le4
            java.lang.String r5 = "ahbrPlay"
            r6 = 1
            r4.put(r5, r6)     // Catch: org.json.JSONException -> Le4
            java.lang.String r5 = "abrPlay"
            com.youku.media.arch.instruments.ConfigFetcher r7 = com.youku.media.arch.instruments.ConfigFetcher.getInstance()     // Catch: org.json.JSONException -> Le4
            java.lang.String r8 = "network_retry_config_live"
            java.lang.String r9 = "live_enable_abr"
            java.lang.String r7 = r7.getConfig(r8, r9, r2)     // Catch: org.json.JSONException -> Le4
            r4.put(r5, r7)     // Catch: org.json.JSONException -> Le4
            java.lang.String r5 = "1080p"
            com.youku.media.arch.instruments.ConfigFetcher r7 = com.youku.media.arch.instruments.ConfigFetcher.getInstance()     // Catch: org.json.JSONException -> Le4
            java.lang.String r8 = "youku_player_config"
            java.lang.String r9 = "force_show_4k"
            java.lang.String r7 = r7.getConfig(r8, r9, r3)     // Catch: org.json.JSONException -> Le4
            boolean r7 = r2.equals(r7)     // Catch: org.json.JSONException -> Le4
            if (r7 != 0) goto L59
            com.youku.media.arch.instruments.ConfigFetcher r7 = com.youku.media.arch.instruments.ConfigFetcher.getInstance()     // Catch: org.json.JSONException -> Le4
            java.lang.String r8 = "player_config"
            java.lang.String r9 = "4k_support"
            java.lang.String r7 = r7.getConfig(r8, r9, r3)     // Catch: org.json.JSONException -> Le4
            boolean r7 = r2.equals(r7)     // Catch: org.json.JSONException -> Le4
            if (r7 == 0) goto L5b
        L59:
            java.lang.String r5 = "4k"
        L5b:
            com.youku.media.arch.instruments.ConfigFetcher r7 = com.youku.media.arch.instruments.ConfigFetcher.getInstance()     // Catch: org.json.JSONException -> Le4
            java.lang.String r8 = "max_fps"
            java.lang.String r9 = "50"
            java.lang.String r1 = r7.getConfig(r1, r8, r9)     // Catch: org.json.JSONException -> Le4
            java.lang.String r7 = "decode_resolution_FPS"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> Le4
            r8.<init>()     // Catch: org.json.JSONException -> Le4
            r8.append(r5)     // Catch: org.json.JSONException -> Le4
            java.lang.String r5 = "_"
            r8.append(r5)     // Catch: org.json.JSONException -> Le4
            r8.append(r1)     // Catch: org.json.JSONException -> Le4
            java.lang.String r1 = r8.toString()     // Catch: org.json.JSONException -> Le4
            r4.put(r7, r1)     // Catch: org.json.JSONException -> Le4
            boolean r1 = com.youku.playerservice.axp.utils.PlayerUtil.has265Failed     // Catch: org.json.JSONException -> Le4
            if (r1 != 0) goto L8c
            if (r10 != 0) goto L87
            goto L8c
        L87:
            java.lang.String r10 = getDecode()     // Catch: org.json.JSONException -> Le4
            goto L93
        L8c:
            java.lang.String r10 = "H264"
            java.lang.String r1 = "播放器h265播放报错或者业务层指定不使用h265，则能力改为不支持h265"
            com.youku.playerservice.axp.utils.TLogUtil.playLog(r1)     // Catch: org.json.JSONException -> Le4
        L93:
            java.lang.String r1 = "decode"
            r4.put(r1, r10)     // Catch: org.json.JSONException -> Le4
            java.lang.String r10 = "decodeMode"
            java.lang.String r1 = getDecodeMode()     // Catch: org.json.JSONException -> Le4
            r4.put(r10, r1)     // Catch: org.json.JSONException -> Le4
            com.youku.media.arch.instruments.ConfigFetcher r10 = com.youku.media.arch.instruments.ConfigFetcher.getInstance()     // Catch: org.json.JSONException -> Le4
            java.lang.String r1 = "live_multi_view_config"
            java.lang.String r10 = r10.getConfig(r1, r0, r3)     // Catch: org.json.JSONException -> Le4
            boolean r10 = r3.equals(r10)     // Catch: org.json.JSONException -> Le4
            r10 = r10 ^ r6
            r4.put(r0, r10)     // Catch: org.json.JSONException -> Le4
            r10 = 0
            com.youku.alixplayer.config.FeatureManager r0 = com.youku.alixplayer.config.FeatureManager.getInstance()     // Catch: org.json.JSONException -> Le4
            boolean r0 = r0.hasFreeFlow()     // Catch: org.json.JSONException -> Le4
            if (r0 == 0) goto Lc4
            java.lang.String r10 = "live"
            com.youku.phone.freeflow.YKFreeFlowResult r10 = com.youku.phone.freeflow.YoukuFreeFlowApi.getFreeFlowResult(r10)     // Catch: org.json.JSONException -> Le4
        Lc4:
            if (r10 == 0) goto Ldd
            com.youku.phone.freeflow.model.CarrierType r10 = r10.getCarrierType()     // Catch: org.json.JSONException -> Le4
            com.youku.phone.freeflow.model.CarrierType r0 = com.youku.phone.freeflow.model.CarrierType.MOBILE     // Catch: org.json.JSONException -> Le4
            if (r10 != r0) goto Lcf
            goto Lde
        Lcf:
            com.youku.phone.freeflow.model.CarrierType r0 = com.youku.phone.freeflow.model.CarrierType.UNICOM     // Catch: org.json.JSONException -> Le4
            if (r10 != r0) goto Ld6
            java.lang.String r2 = "2"
            goto Lde
        Ld6:
            com.youku.phone.freeflow.model.CarrierType r0 = com.youku.phone.freeflow.model.CarrierType.TELECOM     // Catch: org.json.JSONException -> Le4
            if (r10 != r0) goto Ldd
            java.lang.String r2 = "3"
            goto Lde
        Ldd:
            r2 = r3
        Lde:
            java.lang.String r10 = "ct_type"
            r4.put(r10, r2)     // Catch: org.json.JSONException -> Le4
            goto Le8
        Le4:
            r10 = move-exception
            r10.printStackTrace()
        Le8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.utils.PlayerUtil.getAbilityJsonInJsonObject(boolean):org.json.JSONObject");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ca A[Catch: JSONException -> 0x00df, TryCatch #0 {JSONException -> 0x00df, blocks: (B:3:0x000d, B:5:0x0047, B:8:0x005b, B:12:0x0087, B:14:0x0093, B:16:0x00b9, B:18:0x00c1, B:28:0x00d9, B:21:0x00ca, B:24:0x00d1, B:13:0x008c), top: B:33:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject getAbilityJsonInJsonObject(boolean r10, android.content.Context r11) {
        /*
            java.lang.String r0 = "fansPlay"
            java.lang.String r1 = "z_real_config"
            java.lang.String r2 = "1"
            java.lang.String r3 = "0"
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r5 = "hbrPlay"
            com.youku.media.arch.instruments.ConfigFetcher r6 = com.youku.media.arch.instruments.ConfigFetcher.getInstance()     // Catch: org.json.JSONException -> Ldf
            java.lang.String r7 = "live_z_real_enable"
            java.lang.String r6 = r6.getConfig(r1, r7, r3)     // Catch: org.json.JSONException -> Ldf
            r4.put(r5, r6)     // Catch: org.json.JSONException -> Ldf
            java.lang.String r5 = "ahbrPlay"
            r6 = 1
            r4.put(r5, r6)     // Catch: org.json.JSONException -> Ldf
            java.lang.String r5 = "abrPlay"
            com.youku.media.arch.instruments.ConfigFetcher r7 = com.youku.media.arch.instruments.ConfigFetcher.getInstance()     // Catch: org.json.JSONException -> Ldf
            java.lang.String r8 = "network_retry_config_live"
            java.lang.String r9 = "live_enable_abr"
            java.lang.String r7 = r7.getConfig(r8, r9, r2)     // Catch: org.json.JSONException -> Ldf
            r4.put(r5, r7)     // Catch: org.json.JSONException -> Ldf
            java.lang.String r5 = "1080p"
            com.youku.media.arch.instruments.ConfigFetcher r7 = com.youku.media.arch.instruments.ConfigFetcher.getInstance()     // Catch: org.json.JSONException -> Ldf
            java.lang.String r8 = "youku_player_config"
            java.lang.String r9 = "force_show_4k"
            java.lang.String r7 = r7.getConfig(r8, r9, r3)     // Catch: org.json.JSONException -> Ldf
            boolean r7 = r2.equals(r7)     // Catch: org.json.JSONException -> Ldf
            if (r7 != 0) goto L59
            com.youku.media.arch.instruments.ConfigFetcher r7 = com.youku.media.arch.instruments.ConfigFetcher.getInstance()     // Catch: org.json.JSONException -> Ldf
            java.lang.String r8 = "player_config"
            java.lang.String r9 = "4k_support"
            java.lang.String r7 = r7.getConfig(r8, r9, r3)     // Catch: org.json.JSONException -> Ldf
            boolean r7 = r2.equals(r7)     // Catch: org.json.JSONException -> Ldf
            if (r7 == 0) goto L5b
        L59:
            java.lang.String r5 = "4k"
        L5b:
            com.youku.media.arch.instruments.ConfigFetcher r7 = com.youku.media.arch.instruments.ConfigFetcher.getInstance()     // Catch: org.json.JSONException -> Ldf
            java.lang.String r8 = "max_fps"
            java.lang.String r9 = "50"
            java.lang.String r1 = r7.getConfig(r1, r8, r9)     // Catch: org.json.JSONException -> Ldf
            java.lang.String r7 = "decode_resolution_FPS"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> Ldf
            r8.<init>()     // Catch: org.json.JSONException -> Ldf
            r8.append(r5)     // Catch: org.json.JSONException -> Ldf
            java.lang.String r5 = "_"
            r8.append(r5)     // Catch: org.json.JSONException -> Ldf
            r8.append(r1)     // Catch: org.json.JSONException -> Ldf
            java.lang.String r1 = r8.toString()     // Catch: org.json.JSONException -> Ldf
            r4.put(r7, r1)     // Catch: org.json.JSONException -> Ldf
            boolean r1 = com.youku.playerservice.axp.utils.PlayerUtil.has265Failed     // Catch: org.json.JSONException -> Ldf
            if (r1 != 0) goto L8c
            if (r10 != 0) goto L87
            goto L8c
        L87:
            java.lang.String r10 = getDecode()     // Catch: org.json.JSONException -> Ldf
            goto L93
        L8c:
            java.lang.String r10 = "H264"
            java.lang.String r1 = "播放器h265播放报错或者业务层指定不使用h265，则能力改为不支持h265"
            com.youku.playerservice.axp.utils.TLogUtil.playLog(r1)     // Catch: org.json.JSONException -> Ldf
        L93:
            java.lang.String r1 = "decode"
            r4.put(r1, r10)     // Catch: org.json.JSONException -> Ldf
            java.lang.String r10 = "decodeMode"
            java.lang.String r1 = getDecodeMode()     // Catch: org.json.JSONException -> Ldf
            r4.put(r10, r1)     // Catch: org.json.JSONException -> Ldf
            com.youku.media.arch.instruments.ConfigFetcher r10 = com.youku.media.arch.instruments.ConfigFetcher.getInstance()     // Catch: org.json.JSONException -> Ldf
            java.lang.String r1 = "live_multi_view_config"
            java.lang.String r10 = r10.getConfig(r1, r0, r3)     // Catch: org.json.JSONException -> Ldf
            boolean r10 = r3.equals(r10)     // Catch: org.json.JSONException -> Ldf
            r10 = r10 ^ r6
            r4.put(r0, r10)     // Catch: org.json.JSONException -> Ldf
            boolean r10 = com.youku.playerservice.axp.utils.Utils.isYoukuOrHuaweiBaipai(r11)     // Catch: org.json.JSONException -> Ldf
            if (r10 == 0) goto Ld8
            java.lang.String r10 = "live"
            com.youku.phone.freeflow.YKFreeFlowResult r10 = com.youku.phone.freeflow.YoukuFreeFlowApi.getFreeFlowResult(r10)     // Catch: org.json.JSONException -> Ldf
            if (r10 == 0) goto Ld8
            com.youku.phone.freeflow.model.CarrierType r10 = r10.getCarrierType()     // Catch: org.json.JSONException -> Ldf
            com.youku.phone.freeflow.model.CarrierType r11 = com.youku.phone.freeflow.model.CarrierType.MOBILE     // Catch: org.json.JSONException -> Ldf
            if (r10 != r11) goto Lca
            goto Ld9
        Lca:
            com.youku.phone.freeflow.model.CarrierType r11 = com.youku.phone.freeflow.model.CarrierType.UNICOM     // Catch: org.json.JSONException -> Ldf
            if (r10 != r11) goto Ld1
            java.lang.String r2 = "2"
            goto Ld9
        Ld1:
            com.youku.phone.freeflow.model.CarrierType r11 = com.youku.phone.freeflow.model.CarrierType.TELECOM     // Catch: org.json.JSONException -> Ldf
            if (r10 != r11) goto Ld8
            java.lang.String r2 = "3"
            goto Ld9
        Ld8:
            r2 = r3
        Ld9:
            java.lang.String r10 = "ct_type"
            r4.put(r10, r2)     // Catch: org.json.JSONException -> Ldf
            goto Le3
        Ldf:
            r10 = move-exception
            r10.printStackTrace()
        Le3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.utils.PlayerUtil.getAbilityJsonInJsonObject(boolean, android.content.Context):org.json.JSONObject");
    }

    public static String getDecode() {
        return ConfigFetcher.getInstance().getConfig("live_player_config", ImageStatistics.KEY_BITMAP_DECODE, "H265");
    }

    public static String getDecodeMode() {
        return ConfigFetcher.getInstance().getConfig("live_player_config", "decode_mode", "HW");
    }

    public static int getDeviceScore() {
        return C6673b.d().getInt("oldDeviceScore", YoukuContext.getApplicationContext().getSharedPreferences("device_score", 0).getInt("device_score", -1));
    }

    public static String getLanguageCodeById(int i) {
        LanguageBean[] languageBeanArr;
        for (LanguageBean languageBean : LanguageBean.ALL_LANGAUGE) {
            if (i == languageBean.id) {
                return languageBean.code;
            }
        }
        return LanguageBean.ALL_LANGAUGE[0].code;
    }

    public static Artp getPlayArtp(Mcs mcs, int i) {
        List<Artp> list = mcs.ms.playInfo.artp;
        if (list != null && list.size() > 0) {
            for (Artp artp : mcs.ms.playInfo.artp) {
                if (artp.idx == i) {
                    return artp;
                }
            }
        }
        return null;
    }

    public static HttpFlv getPlayFlv(Mcs mcs, int i) {
        List<HttpFlv> list = mcs.ms.playInfo.httpFlv;
        if (list != null && list.size() > 0) {
            for (HttpFlv httpFlv : mcs.ms.playInfo.httpFlv) {
                if (httpFlv.idx == i) {
                    return httpFlv;
                }
            }
        }
        return null;
    }

    public static Grtn getPlayGrtn(Mcs mcs, int i) {
        List<Grtn> list = mcs.ms.playInfo.grtn;
        if (list != null && list.size() > 0) {
            for (Grtn grtn : mcs.ms.playInfo.grtn) {
                if (grtn.idx == i) {
                    return grtn;
                }
            }
        }
        return null;
    }

    public static Hls getPlayHls(Mcs mcs, int i) {
        List<Hls> list = mcs.ms.playInfo.hls;
        if (list != null && list.size() > 0) {
            for (Hls hls : mcs.ms.playInfo.hls) {
                if (hls.idx == i) {
                    return hls;
                }
            }
        }
        return null;
    }

    public static Rtp getPlayRtp(Mcs mcs, int i) {
        List<Rtp> list = mcs.ms.playInfo.rtp;
        if (list != null && list.size() > 0) {
            for (Rtp rtp : mcs.ms.playInfo.rtp) {
                if (rtp.idx == i) {
                    return rtp;
                }
            }
        }
        return null;
    }

    public static boolean isFeed(String str) {
        try {
            float parseFloat = Float.parseFloat(str);
            return parseFloat >= 2.0f && parseFloat < 4.0f;
        } catch (Exception unused) {
            TLogUtil.flowLog(null, "playerSource转换Float失败 " + str);
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [boolean, int] */
    public static boolean isShowId(String str) {
        int length = str.length();
        ?? startsWith = str.startsWith("z");
        int i = length - startsWith;
        if (i != 20) {
            return false;
        }
        for (int i2 = startsWith; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'A' || charAt > 'F') && (charAt < 'a' || charAt > 'f'))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSkipHeadAndTail(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("skip_head", true);
    }

    public static boolean isVid(String str) {
        return TextUtils.isEmpty(str) || !isShowId(str);
    }

    public static String urlEncoder(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }
}
