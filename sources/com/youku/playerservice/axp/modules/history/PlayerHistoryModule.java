package com.youku.playerservice.axp.modules.history;

import android.content.Context;
import android.os.Handler;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.weex.common.Constants;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.item.PlayItem;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.item.VodItem;
import com.youku.playerservice.axp.modules.BaseModule;
import com.youku.playerservice.axp.player.PlayerImpl;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playhistory.PlayHistory;
import com.youku.playhistory.data.Source;
import com.youku.playhistory.data.UploadHistoryInfo;
import com.youku.playhistory.strategy.upload.constants.UploadChanceConstants;
import com.youku.service.YoukuService;
import com.youku.service.data.IYoukuDataSource;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.vo.LanguageBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayerHistoryModule extends BaseModule {
    public static final String BOOL_READ_PLAY_HISTORY = "read_player_history";
    public static final String BOOL_WRITE_PLAY_HISTORY = "write_player_history";
    private static final int HEARTBEAT_INTERVAL = 60000;
    public static final String INT_SHOW_STAGE = "show_stage";
    public static final String INT_SHOW_VIDEO_TYPE = "video_type";
    public static final String JSONOBJECT_HISTORY_EXTRAS = "history_extras";
    public static final String PLAYER_HISTORY_REFERENCE_SID = "player_history_reference_sid";
    public static final String STRING_SHOW_CATEGORY = "show_category";
    public static final String STRING_SHOW_IMAGE = "show_image";
    public static final String STRING_SHOW_KIND = "show_kind";
    public static final String STRING_SHOW_NAME = "show_name";
    public static final String STRING_SHOW_V_IMAGE = "show_v_image";
    private static final String TAG = "PlayerHistoryModule";
    private Handler mHandlder;
    private PlayParams mPlayParams;
    private final Runnable mUpdateHistoryRunnable;
    private boolean mWritePlayerHistory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.playerservice.axp.modules.history.PlayerHistoryModule$4  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$playerservice$axp$item$Quality;

        static {
            int[] iArr = new int[Quality.values().length];
            $SwitchMap$com$youku$playerservice$axp$item$Quality = iArr;
            try {
                iArr[Quality.HD3GP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$playerservice$axp$item$Quality[Quality.SD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$playerservice$axp$item$Quality[Quality.HD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$playerservice$axp$item$Quality[Quality.HD2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$youku$playerservice$axp$item$Quality[Quality.HD3.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$youku$playerservice$axp$item$Quality[Quality.DOLBY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$youku$playerservice$axp$item$Quality[Quality.SOUND.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private class LogType {
        public static final int PLAYING = 1;
        public static final int START = 0;
        public static final int STOP = 2;

        private LogType() {
        }
    }

    public PlayerHistoryModule(Context context, PlayerImpl playerImpl, Handler handler) {
        super(context, playerImpl);
        this.mUpdateHistoryRunnable = new Runnable() { // from class: com.youku.playerservice.axp.modules.history.PlayerHistoryModule.1
            @Override // java.lang.Runnable
            public void run() {
                PlayerHistoryModule.this.addPlayHistory(1, "heart_beat");
                if (PlayerHistoryModule.this.mHandlder == null) {
                    return;
                }
                if (AppInfoProviderProxy.isDebuggable()) {
                    Logger.d(PlayerHistoryModule.TAG, "updateHistory after 1 min!");
                }
                PlayerHistoryModule.this.mHandlder.postDelayed(this, DateUtils.MILLIS_PER_MINUTE);
            }
        };
        this.mHandlder = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPlayHistory(int i, int i2, @UploadChanceConstants.UploadChanceType String str) {
        VideoInfo videoInfo;
        if ("true".equals(this.mPlayParams.getString("disablePlayLog"))) {
            this.mHandlder.removeCallbacks(this.mUpdateHistoryRunnable);
            return;
        }
        PlayInfo playInfo = getPlayInfo();
        if (playInfo == null) {
            return;
        }
        int realPosition = playInfo.getRealPosition(false, i < 0 ? playInfo.getProgress() : i);
        PlayParams playParams = playInfo.getPlayParams();
        PlayItem playItem = playInfo.getPlayItem();
        PlayInfoResponse playInfoResponse = playInfo.getPlayInfoResponse();
        if (playInfoResponse == null) {
            return;
        }
        UploadHistoryInfo uploadHistoryInfo = new UploadHistoryInfo();
        uploadHistoryInfo.videoId = playInfo.getPlayId();
        uploadHistoryInfo.showId = playInfoResponse.getProperties("showId", (String) null);
        uploadHistoryInfo.title = playInfoResponse.getProperties("title", (String) null);
        uploadHistoryInfo.folderPlace = playInfoResponse.getProperties("showVideoSeq", 0);
        uploadHistoryInfo.ytid = ((IYoukuDataSource) YoukuService.getService(IYoukuDataSource.class)).getYtid();
        uploadHistoryInfo.duration = playInfo.getDuration() / 1000;
        uploadHistoryInfo.autoPlay = Integer.parseInt(playParams.getString(Constants.Name.AUTO_PLAY, "0"));
        uploadHistoryInfo.logType = i2;
        uploadHistoryInfo.point = realPosition / 1000;
        uploadHistoryInfo.chanceType = str;
        if (playInfoResponse.getUpsInfo() != null && (videoInfo = playInfoResponse.getUpsInfo().getVideoInfo()) != null && videoInfo.getUser() != null) {
            try {
                HashMap hashMap = new HashMap();
                Collection collection = videoInfo.getUser().idens;
                Collection collection2 = videoInfo.getUser().tags;
                if (collection == null) {
                    collection = new ArrayList();
                }
                hashMap.put("idens", collection);
                if (collection2 == null) {
                    collection2 = new ArrayList();
                }
                hashMap.put(IRequestConst.TAGS, collection2);
                uploadHistoryInfo.extMsg = new JSONObject(hashMap);
            } catch (Exception unused) {
            }
        }
        Object tag = playParams.getTag(JSONOBJECT_HISTORY_EXTRAS);
        if (tag instanceof JSONObject) {
            uploadHistoryInfo.extras = (JSONObject) tag;
        }
        if (playParams.getPlayType() == PlayDefinition.PlayType.VOD) {
            uploadHistoryInfo.tp = (int) playParams.getDouble(INT_SHOW_VIDEO_TYPE, 0.0d);
            uploadHistoryInfo.category = playParams.getString(STRING_SHOW_CATEGORY);
            uploadHistoryInfo.showKind = playParams.getString(STRING_SHOW_KIND);
            uploadHistoryInfo.showName = playParams.getString(STRING_SHOW_NAME);
            uploadHistoryInfo.showImg = playParams.getString(STRING_SHOW_IMAGE);
            uploadHistoryInfo.showVImg = playParams.getString(STRING_SHOW_V_IMAGE);
            uploadHistoryInfo.stage = (int) playParams.getDouble(INT_SHOW_STAGE, 0.0d);
            uploadHistoryInfo.lang = getLanguageIdByCode(playInfo.getPlayItem().getLangCode());
            uploadHistoryInfo.hd = getHistoryQuality(playParams.getPlayIdParams().getRequestQuality());
            uploadHistoryInfo.source = Source.DEFAULT_VIDEO;
            VodItem vodItem = (VodItem) playInfo.getPlayItem();
            if (playInfoResponse.getUpsInfo() != null && playInfoResponse.getUpsInfo().getVideoInfo() != null) {
                VideoInfo videoInfo2 = playInfoResponse.getUpsInfo().getVideoInfo();
                if (videoInfo2 == null || videoInfo2.getShow() == null) {
                    uploadHistoryInfo.videoType = "正片";
                } else {
                    uploadHistoryInfo.videoType = videoInfo2.getShow().show_videotype;
                    uploadHistoryInfo.tp = videoInfo2.getShow().video_type;
                    uploadHistoryInfo.category = videoInfo2.getShow().showcategory;
                    String[] strArr = videoInfo2.getShow().showkind;
                    StringBuilder sb = new StringBuilder();
                    if (strArr != null && strArr.length > 0) {
                        for (String str2 : strArr) {
                            sb.append(str2);
                            sb.append(",");
                        }
                        String sb2 = sb.toString();
                        uploadHistoryInfo.showKind = sb2.substring(0, sb2.length() - 1);
                    }
                    uploadHistoryInfo.needPay = videoInfo2.getShow().video_pay == 1;
                    uploadHistoryInfo.stage = videoInfo2.getShow().stage;
                    uploadHistoryInfo.showName = videoInfo2.getShow().title;
                    uploadHistoryInfo.showImg = videoInfo2.getShow().show_thumburl;
                    uploadHistoryInfo.showVImg = videoInfo2.getShow().show_vthumburl;
                }
                uploadHistoryInfo.lang = getLanguageIdByCode(playInfo.getPlayItem().getLangCode());
                uploadHistoryInfo.hd = getHistoryQuality(playItem.getQuality());
            }
            if (vodItem.isCache()) {
                uploadHistoryInfo.tp = 1;
                uploadHistoryInfo.videoType = "正片";
            }
        } else if (playParams.getPlayType() == PlayDefinition.PlayType.LIVE) {
            uploadHistoryInfo.source = Source.LIVE_VIDEO;
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            Logger.d(TAG, "addPlayHistory title=" + uploadHistoryInfo.title + " vid=" + uploadHistoryInfo.videoId + " langCode=" + getLanguageCodeById(uploadHistoryInfo.lang) + " point=" + realPosition + " logType=" + i2 + " chanceType=" + str);
        }
        PlayHistory.addPlayHistory(this.mContext, "1", uploadHistoryInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPlayHistory(int i, @UploadChanceConstants.UploadChanceType String str) {
        addPlayHistory(-1, i, str);
    }

    private int getHistoryQuality(Quality quality) {
        switch (AnonymousClass4.$SwitchMap$com$youku$playerservice$axp$item$Quality[quality.ordinal()]) {
            case 1:
                return 4;
            case 2:
            default:
                return 0;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 5;
            case 7:
                return 6;
        }
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

    public static int getLanguageIdByCode(String str) {
        LanguageBean[] languageBeanArr;
        for (LanguageBean languageBean : LanguageBean.ALL_LANGAUGE) {
            if (languageBean.code.equals(str)) {
                return languageBean.id;
            }
        }
        return LanguageBean.ALL_LANGAUGE[0].id;
    }

    @Override // com.youku.playerservice.axp.modules.BaseModule, com.youku.playerservice.axp.modules.IModule
    public void onPlay(PlayParams playParams) {
        this.mPlayParams = playParams;
        this.mWritePlayerHistory = "1".equals(playParams.getString("isWriteHistory"));
    }

    @Override // com.youku.playerservice.axp.modules.BaseModule, com.youku.playerservice.axp.modules.IModule
    public void onRealVideoStart() {
        Handler handler;
        if (!this.mWritePlayerHistory || (handler = this.mHandlder) == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.youku.playerservice.axp.modules.history.PlayerHistoryModule.2
            @Override // java.lang.Runnable
            public void run() {
                if (((BaseModule) PlayerHistoryModule.this).mPlayer.getPlayInfo() != null) {
                    PlayerHistoryModule.this.addPlayHistory(0, "start");
                }
                PlayerHistoryModule.this.mHandlder.removeCallbacks(PlayerHistoryModule.this.mUpdateHistoryRunnable);
                PlayerHistoryModule.this.mHandlder.postDelayed(PlayerHistoryModule.this.mUpdateHistoryRunnable, DateUtils.MILLIS_PER_MINUTE);
            }
        });
    }

    @Override // com.youku.playerservice.axp.modules.BaseModule, com.youku.playerservice.axp.modules.IModule
    public void onSeekTo(final int i) {
        if (!this.mWritePlayerHistory || this.mHandlder == null) {
            return;
        }
        if (AppInfoProviderProxy.isDebuggable()) {
            Logger.d(TAG, "onSeekComplete addPlayerHistory");
        }
        this.mHandlder.post(new Runnable() { // from class: com.youku.playerservice.axp.modules.history.PlayerHistoryModule.3
            @Override // java.lang.Runnable
            public void run() {
                PlayerHistoryModule.this.addPlayHistory(i, 1, "seek");
            }
        });
    }

    @Override // com.youku.playerservice.axp.modules.BaseModule, com.youku.playerservice.axp.modules.IModule
    public void onStop() {
        if (!this.mWritePlayerHistory || this.mHandlder == null || this.mPlayer.getPlayInfo() == null) {
            return;
        }
        addPlayHistory(2, "end");
        this.mHandlder.removeCallbacks(this.mUpdateHistoryRunnable);
    }
}
