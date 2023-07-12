package com.youku.playerservice.axp.modules;

import android.content.Context;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.playerservice.axp.modules.tlog.TLogUploader;
import com.youku.playerservice.axp.player.PlayerImpl;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.TLogUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayRetryModule extends BaseModule {
    private TLogUploader mTLogUploader;

    public PlayRetryModule(Context context, PlayerImpl playerImpl) {
        super(context, playerImpl);
        this.mTLogUploader = new TLogUploader(context);
    }

    private boolean contains(int i, String str) {
        return contains(i, "play_retry", str, null);
    }

    public static boolean contains(int i, String str, String str2, String str3) {
        List<String> asList;
        String config = ConfigFetcher.getInstance().getConfig(str, str2, str3);
        if (config != null && (asList = Arrays.asList(config.split(","))) != null && asList.size() > 0) {
            for (String str4 : asList) {
                if (str4.contains("-")) {
                    String[] split = str4.split("-");
                    if (split.length == 2) {
                        try {
                            int parseInt = Integer.parseInt(split[0]);
                            int parseInt2 = Integer.parseInt(split[1]);
                            if (i > parseInt && i < parseInt2) {
                                return true;
                            }
                        } catch (Exception unused) {
                        }
                    } else {
                        continue;
                    }
                } else if (i == Integer.parseInt(str4)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdPlayError(int i) {
        return i == 2005 || i == 2205 || i == 2206 || i == 2200;
    }

    private boolean isDumpError(int i) {
        return contains(i, "player_strategy", "video_dump_code", "11010-11019,11304-11307,11310-11419,13000");
    }

    private boolean isRemoveDrmRetry(int i) {
        return contains(i, "is_remove_drm_retry");
    }

    private boolean isRetryWithRequest(int i) {
        return contains(i, "is_request_retry");
    }

    private boolean isSoftDecodeRetry(int i) {
        return contains(i, "is_soft_decode_retry");
    }

    private boolean isSuperResolutionRetry(int i) {
        return false;
    }

    private boolean isSurfaceRetry(int i) {
        return contains(i, "is_surface_retry");
    }

    private void vpmRetry(String str) {
        PlayInfo playInfo = this.mPlayer.getPlayInfo();
        if (playInfo != null) {
            playInfo.getPlayParams().putString("playRetry", str);
        }
    }

    @Override // com.youku.playerservice.axp.modules.BaseModule, com.youku.playerservice.axp.modules.IModule
    public boolean onError(int i, int i2, Object obj) {
        PlayInfo playInfo = getPlayInfo();
        if (playInfo == null) {
            return false;
        }
        PlayParams playParams = playInfo.getPlayParams();
        String sessionId = playParams.getSessionId();
        if (isAdPlayError(i)) {
            TLogUtil.flowLog(sessionId, "广告异常，进行重试，播放正片 what=" + i);
            vpmRetry("1");
            playInfo.setAdInfo(null);
            this.mPlayer.playWithPlayInfo(playInfo);
            return true;
        } else if (isSuperResolutionRetry(i2)) {
            playParams.putString("superResolution", "-1");
            this.mPlayer.playWithPlayInfo(playInfo);
            return true;
        } else {
            if (isDumpError(i2)) {
                playInfo.getPlayParams().putString("dumpVideo", "1");
                this.mTLogUploader.cleanOldData(playInfo.getPlayId());
            }
            isSoftDecodeRetry(i2);
            if (isRetryWithRequest(i2)) {
                HashMap hashMap = new HashMap();
                if (isRemoveDrmRetry(i2)) {
                    hashMap.put("disableDrm", "1");
                }
                this.mPlayer.replayWithRequest(hashMap);
                return true;
            }
            return super.onError(i, i2, obj);
        }
    }
}
