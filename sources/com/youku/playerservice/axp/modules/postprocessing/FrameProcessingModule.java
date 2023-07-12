package com.youku.playerservice.axp.modules.postprocessing;

import android.content.Context;
import android.text.TextUtils;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.item.VodItem;
import com.youku.playerservice.axp.modules.BaseModule;
import com.youku.playerservice.axp.modules.postprocessing.rotation.InteractionDataManager;
import com.youku.playerservice.axp.player.PlayerImpl;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playparams.PlayParams;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FrameProcessingModule extends BaseModule {
    private static final String BY_PASS_MATCH_KEY = "byPassDataMatchCount";
    private static final String BY_PASS_MISS_KEY = "byPassDataMissCount";
    private static HashMap<Integer, String> MISS_MATCH_MAP = new HashMap() { // from class: com.youku.playerservice.axp.modules.postprocessing.FrameProcessingModule.1
        {
            put(1, "EMPTYINFO");
        }
    };
    public static final String TAG = "FrameProcessingModule";
    private String lastDataString;
    private InteractionDataManager mDataManager;

    public FrameProcessingModule(Context context, PlayerImpl playerImpl) {
        super(context, playerImpl);
        this.mDataManager = null;
    }

    private int getChangeCount(PlayParams playParams, String str) {
        String string = playParams.getString(str, "0");
        if (TextUtils.isDigitsOnly(string)) {
            return Integer.parseInt(string);
        }
        return 0;
    }

    private int increaseMatchCount(PlayParams playParams) {
        if (playParams == null) {
            return -1;
        }
        int changeCount = getChangeCount(playParams, BY_PASS_MATCH_KEY) + 1;
        playParams.putString(BY_PASS_MATCH_KEY, String.valueOf(changeCount));
        return changeCount;
    }

    private int increaseMissCount(PlayParams playParams) {
        if (playParams == null) {
            return -1;
        }
        int changeCount = getChangeCount(playParams, BY_PASS_MISS_KEY) + 1;
        playParams.putString(BY_PASS_MISS_KEY, String.valueOf(changeCount));
        return changeCount;
    }

    private void workInGeneralMode(InteractionDataManager interactionDataManager, double d, Map<Integer, String> map) {
        Map<Integer, String> data = interactionDataManager.getData(d);
        if (data != null && data.size() > 0 && map != null) {
            String obj = data.toString();
            if (TextUtils.equals(obj, this.lastDataString)) {
                return;
            }
            this.lastDataString = obj;
            map.putAll(data);
            PlayerImpl playerImpl = this.mPlayer;
            if (playerImpl != null) {
                increaseMatchCount(playerImpl.getPlayParams());
            }
        } else if (map != null) {
            String hashMap = MISS_MATCH_MAP.toString();
            if (TextUtils.equals(hashMap, this.lastDataString)) {
                return;
            }
            this.lastDataString = hashMap;
            map.putAll(MISS_MATCH_MAP);
            PlayerImpl playerImpl2 = this.mPlayer;
            if (playerImpl2 != null) {
                increaseMissCount(playerImpl2.getPlayParams());
            }
        }
    }

    @Override // com.youku.playerservice.axp.modules.BaseModule, com.youku.playerservice.axp.modules.IModule
    public void onQualityChangeFinish(boolean z, Object obj) {
        PlayInfo playInfo = this.mPlayer.getPlayInfo();
        InteractionDataManager interactionDataManager = this.mDataManager;
        if (playInfo.getPlayType() != PlayDefinition.PlayType.VOD || interactionDataManager == null) {
            return;
        }
        interactionDataManager.request(playInfo, ((VodItem) playInfo.getPlayItem()).getBitStream());
    }

    @Override // com.youku.playerservice.axp.modules.BaseModule, com.youku.playerservice.axp.modules.IModule
    public void onRealVideoStart() {
        this.mDataManager = new InteractionDataManager(this.mContext);
        PlayInfo playInfo = this.mPlayer.getPlayInfo();
        if (playInfo.getPlayType() == PlayDefinition.PlayType.VOD) {
            this.mDataManager.request(playInfo, ((VodItem) playInfo.getPlayItem()).getBitStream());
        }
    }

    public void processData(byte[] bArr, Map<Integer, String> map, long j, long j2, long j3, long j4, long j5) {
        InteractionDataManager interactionDataManager = this.mDataManager;
        if (interactionDataManager != null) {
            workInGeneralMode(interactionDataManager, (j * 1.0d) / j2, map);
        }
    }
}
