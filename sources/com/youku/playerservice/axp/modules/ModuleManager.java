package com.youku.playerservice.axp.modules;

import android.content.Context;
import android.os.Handler;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.playerservice.axp.modules.history.PlayerHistoryModule;
import com.youku.playerservice.axp.modules.postprocessing.PostProcessingModule;
import com.youku.playerservice.axp.player.PlayerImpl;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.Utils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ModuleManager {
    private List<IModule> mModules = new ArrayList();

    public ModuleManager(Context context, PlayerImpl playerImpl, Handler handler) {
        if (Utils.isYoukuOrHuaweiBaipai(context)) {
            this.mModules.add(new PlayerHistoryModule(context, playerImpl, handler));
            this.mModules.add(new PlayRetryModule(context, playerImpl));
        }
        this.mModules.add(new PostProcessingModule(context, playerImpl));
    }

    public static boolean enable(String str, String str2) {
        return "1".equals(ConfigFetcher.getInstance().getConfig("player_module_manager", str, str2));
    }

    public void add(IModule iModule) {
        this.mModules.add(iModule);
    }

    public void onDataReady(PlayInfo playInfo) {
        for (IModule iModule : this.mModules) {
            iModule.onDataReady(playInfo);
        }
    }

    public boolean onError(int i, int i2, Object obj) {
        for (IModule iModule : this.mModules) {
            if (iModule.onError(i, i2, obj)) {
                return true;
            }
        }
        return false;
    }

    public void onPause() {
        for (IModule iModule : this.mModules) {
            iModule.onPause();
        }
    }

    public void onPlay(PlayParams playParams) {
        for (IModule iModule : this.mModules) {
            iModule.onPlay(playParams);
        }
    }

    public void onQualityChangeFinish(boolean z, Object obj) {
        for (IModule iModule : this.mModules) {
            iModule.onQualityChangeFinish(z, obj);
        }
    }

    public void onRealVideoStart() {
        for (IModule iModule : this.mModules) {
            iModule.onRealVideoStart();
        }
    }

    public void onSeekTo(int i) {
        for (IModule iModule : this.mModules) {
            iModule.onSeekTo(i);
        }
    }

    public void onStart() {
        for (IModule iModule : this.mModules) {
            iModule.onStart();
        }
    }

    public void onStop() {
        for (IModule iModule : this.mModules) {
            iModule.onStop();
        }
    }
}
