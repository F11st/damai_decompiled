package com.youku.live.dago.liveplayback.widget.preload;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.opensdk.AlixPlayerContainer;
import com.youku.alixplayer.opensdk.FileFormat;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.PlayType;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.fast.FastData;
import com.youku.alixplayer.opensdk.statistics.PlayerTrack;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.android.liveservice.utils.FastJsonTools;
import com.youku.live.dago.liveplayback.ConfigUtils;
import com.youku.live.dago.liveplayback.widget.BusinessTrack;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.dago.liveplayback.widget.plugins.player.PlaylistBuilder;
import com.youku.live.dsl.config.OptConfigUtils;
import com.youku.live.dsl.log.PerfLogUtils;
import com.youku.live.livesdk.util.LivePerfUtils;
import com.youku.live.livesdk.widgets.container.pager.model.AppKeyPlayInfoModel;
import com.youku.live.livesdk.widgets.container.pager.model.NewPlayInfoModel;
import com.youku.live.livesdk.wkit.utils.SdkChannel;
import com.youku.vpm.constants.TableField;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PlayerPreloader implements IPlayerPreloader {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "FASTPLAY";
    private static PlayerPreloader sInstance;
    private Context mApplicationContext;
    private IPlayerContainer mRecycledPlayer;
    private Map<String, IPlayerContainer> mPlayerContaners = new HashMap();
    private Map<String, Boolean> mUseFastPlays = new HashMap();

    private PlayerPreloader() {
        Utils.initRemoteLogger();
    }

    public static PlayerPreloader getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "458242577")) {
            return (PlayerPreloader) ipChange.ipc$dispatch("458242577", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (PlayerPreloader.class) {
                if (sInstance == null) {
                    sInstance = new PlayerPreloader();
                }
            }
        }
        return sInstance;
    }

    private boolean isPrePlayPlayer(@NonNull IPlayerContainer iPlayerContainer) {
        PlayerConfig playerConfig;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-242278591")) {
            return ((Boolean) ipChange.ipc$dispatch("-242278591", new Object[]{this, iPlayerContainer})).booleanValue();
        }
        if (!(iPlayerContainer instanceof AlixPlayerContainer) || (playerConfig = ((AlixPlayerContainer) iPlayerContainer).getPlayerConfig()) == null) {
            return false;
        }
        return "1".equals(playerConfig.getExtras().getString("for_pre_play"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public IPlayerContainer findPreloadPlayer(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "972319184") ? (IPlayerContainer) ipChange.ipc$dispatch("972319184", new Object[]{this, str}) : this.mPlayerContaners.get(str);
    }

    @Override // com.youku.live.dago.liveplayback.widget.preload.IPlayerPreloader
    public int getForceFreshTime(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1469526789")) {
            return ((Integer) ipChange.ipc$dispatch("1469526789", new Object[]{this, context})).intValue();
        }
        if (SdkChannel.isLaifeng(context)) {
            return 1000;
        }
        if (SdkChannel.isUC(context)) {
            return 2000;
        }
        SdkChannel.isYouku(context);
        return 2000;
    }

    @Override // com.youku.live.dago.liveplayback.widget.preload.IPlayerPreloader
    public IPlayerContainer getPlayerContainer(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "42311263")) {
            return (IPlayerContainer) ipChange.ipc$dispatch("42311263", new Object[]{this, context});
        }
        if (context == null) {
            return null;
        }
        if (this.mApplicationContext == null) {
            this.mApplicationContext = context.getApplicationContext();
        }
        PlayerConfig defaultPlayerConfig = Utils.getDefaultPlayerConfig(this.mApplicationContext);
        IPlayerContainer create = AlixPlayerContainer.create(this.mApplicationContext, defaultPlayerConfig);
        create.setPlaylistBuilder(new PlaylistBuilder(this.mApplicationContext, defaultPlayerConfig));
        return create;
    }

    @Override // com.youku.live.dago.liveplayback.widget.preload.IPlayerPreloader
    public String getUniqKey(IPlayerContainer iPlayerContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "715576027")) {
            return (String) ipChange.ipc$dispatch("715576027", new Object[]{this, iPlayerContainer});
        }
        Set<String> keySet = this.mPlayerContaners.keySet();
        if (keySet == null || keySet.size() <= 0) {
            return "";
        }
        for (String str : keySet) {
            if (iPlayerContainer != null && this.mPlayerContaners.get(str) == iPlayerContainer) {
                return str;
            }
        }
        return "";
    }

    @Override // com.youku.live.dago.liveplayback.widget.preload.IPlayerPreloader
    public String initPlayContainer(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-185609193")) {
            return (String) ipChange.ipc$dispatch("-185609193", new Object[]{this, context});
        }
        PerfLogUtils.log("PlayerPreloader.initPlayContainer ... ");
        if (this.mApplicationContext == null && context != null) {
            this.mApplicationContext = context.getApplicationContext();
        }
        IPlayerContainer iPlayerContainer = this.mRecycledPlayer;
        String str = null;
        if (iPlayerContainer != null) {
            this.mRecycledPlayer = null;
        } else {
            PlayerConfig defaultPlayerConfig = Utils.getDefaultPlayerConfig(this.mApplicationContext);
            defaultPlayerConfig.getExtras().putString("for_pre_play", "1");
            IPlayerContainer create = AlixPlayerContainer.create(this.mApplicationContext, defaultPlayerConfig);
            create.setVideoRequestFactory(new FactoryWithPreloader());
            create.setPlaylistBuilder(new PlaylistBuilder(this.mApplicationContext, defaultPlayerConfig));
            iPlayerContainer = create;
        }
        try {
            str = UUID.randomUUID().toString();
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(str)) {
            str = iPlayerContainer.hashCode() + "";
        }
        this.mPlayerContaners.put(str, iPlayerContainer);
        return str;
    }

    @Override // com.youku.live.dago.liveplayback.widget.preload.IPlayerPreloader
    public boolean isUseFastPlay(IPlayerContainer iPlayerContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-872801440")) {
            return ((Boolean) ipChange.ipc$dispatch("-872801440", new Object[]{this, iPlayerContainer})).booleanValue();
        }
        if (iPlayerContainer == null) {
            return false;
        }
        String uniqKey = getUniqKey(iPlayerContainer);
        if (TextUtils.isEmpty(uniqKey) || !this.mUseFastPlays.containsKey(uniqKey)) {
            return false;
        }
        return this.mUseFastPlays.get(uniqKey).booleanValue();
    }

    public boolean play(String str, int i, int i2, boolean z) {
        IPlayerContainer iPlayerContainer;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-206015628")) {
            return ((Boolean) ipChange.ipc$dispatch("-206015628", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        }
        if (ConfigUtils.enablePlayByLiveidOnwall(String.valueOf(i2))) {
            if (OptConfigUtils.isOpenOpt() && OptConfigUtils.getConfig("preplayWithRoomId", true)) {
                PerfLogUtils.log("PlayerPreloader.play ... ");
                Log.d(TAG, "start play");
                if (TextUtils.isEmpty(str) || !this.mPlayerContaners.containsKey(str) || (iPlayerContainer = this.mPlayerContaners.get(str)) == null) {
                    return false;
                }
                PlayVideoInfo playVideoInfo = new PlayVideoInfo(String.valueOf(i2));
                playVideoInfo.setPlayType(PlayType.LIVE);
                playVideoInfo.putString(TableField.PLAY_FROM, "preloaderById");
                long currentTimeMillis = System.currentTimeMillis();
                Log.d(TAG, "fast play: " + currentTimeMillis);
                iPlayerContainer.play(playVideoInfo);
                BusinessTrack.mVVTrigger = true;
                this.mUseFastPlays.put(str, new Boolean(true));
                return true;
            }
            Map<String, IPlayerContainer> map = this.mPlayerContaners;
            if (map != null && str != null) {
                map.remove(str);
            }
            return false;
        }
        return false;
    }

    public boolean recyclePlayer(IPlayerContainer iPlayerContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1217016359")) {
            return ((Boolean) ipChange.ipc$dispatch("1217016359", new Object[]{this, iPlayerContainer})).booleanValue();
        }
        if (this.mApplicationContext == null || !OptConfigUtils.getConfig("openRecyclePlayerContainer", false) || !LivePerfUtils.enableRecyclePlayerContainer() || this.mRecycledPlayer != null || iPlayerContainer == null || iPlayerContainer.getPlayer() == null || !isPrePlayPlayer(iPlayerContainer) || iPlayerContainer.getPlayer().getCurrentState() == IAlixPlayer.State.STATE_RELEASED || iPlayerContainer.getPlayer().getCurrentState() == IAlixPlayer.State.STATE_ERROR) {
            return false;
        }
        if (iPlayerContainer.getPlayerTrack() instanceof PlayerTrack) {
            ((PlayerTrack) iPlayerContainer.getPlayerTrack()).onPlayerDestroy();
        }
        iPlayerContainer.recyclePlayer();
        iPlayerContainer.getPlayer().setResizer(null);
        this.mRecycledPlayer = iPlayerContainer;
        return true;
    }

    @Override // com.youku.live.dago.liveplayback.widget.preload.IPlayerPreloader
    public void release(IPlayerContainer iPlayerContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1477101866")) {
            ipChange.ipc$dispatch("-1477101866", new Object[]{this, iPlayerContainer});
            return;
        }
        String uniqKey = getUniqKey(iPlayerContainer);
        if (TextUtils.isEmpty(uniqKey)) {
            return;
        }
        if (this.mPlayerContaners.containsKey(uniqKey)) {
            this.mPlayerContaners.remove(uniqKey);
        }
        if (this.mUseFastPlays.containsKey(uniqKey)) {
            this.mUseFastPlays.remove(uniqKey);
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.preload.IPlayerPreloader
    public void setUseFastPlay(IPlayerContainer iPlayerContainer, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-550376510")) {
            ipChange.ipc$dispatch("-550376510", new Object[]{this, iPlayerContainer, Boolean.valueOf(z)});
        } else if (iPlayerContainer == null) {
        } else {
            String uniqKey = getUniqKey(iPlayerContainer);
            if (TextUtils.isEmpty(uniqKey) || !this.mUseFastPlays.containsKey(uniqKey)) {
                return;
            }
            this.mUseFastPlays.put(uniqKey, new Boolean(z));
        }
    }

    @Override // com.youku.live.dago.liveplayback.widget.preload.IPlayerPreloader
    public IPlayerContainer getPlayerContainer(String str, Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "658359893")) {
            return (IPlayerContainer) ipChange.ipc$dispatch("658359893", new Object[]{this, str, context});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        IPlayerContainer iPlayerContainer = this.mPlayerContaners.get(str);
        this.mPlayerContaners.remove(str);
        return iPlayerContainer;
    }

    public String initPlayContainer(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1892161587")) {
            return (String) ipChange.ipc$dispatch("-1892161587", new Object[]{this, context, str});
        }
        if (this.mApplicationContext == null && context != null) {
            this.mApplicationContext = context.getApplicationContext();
        }
        IPlayerContainer iPlayerContainer = this.mRecycledPlayer;
        if (iPlayerContainer != null) {
            this.mRecycledPlayer = null;
        } else {
            PlayerConfig defaultPlayerConfig = Utils.getDefaultPlayerConfig(this.mApplicationContext);
            defaultPlayerConfig.getExtras().putString("for_pre_play", "1");
            IPlayerContainer create = AlixPlayerContainer.create(this.mApplicationContext, defaultPlayerConfig);
            create.setVideoRequestFactory(new FactoryWithPreloader());
            create.setPlaylistBuilder(new PlaylistBuilder(this.mApplicationContext, defaultPlayerConfig));
            iPlayerContainer = create;
        }
        if (TextUtils.isEmpty(str)) {
            str = iPlayerContainer.hashCode() + "";
        }
        this.mPlayerContaners.put(str, iPlayerContainer);
        return str;
    }

    @Override // com.youku.live.dago.liveplayback.widget.preload.IPlayerPreloader
    public void play(String str, String str2, int i, int i2, boolean z) {
        IPlayerContainer iPlayerContainer;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-894585242")) {
            ipChange.ipc$dispatch("-894585242", new Object[]{this, str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
            return;
        }
        PerfLogUtils.log("PlayerPreloader.play ... ");
        Log.d(TAG, "start play");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            play(str, i, i2, z);
        } else if (this.mPlayerContaners.containsKey(str) && (iPlayerContainer = this.mPlayerContaners.get(str)) != null) {
            PlayVideoInfo playVideoInfo = new PlayVideoInfo(String.valueOf(i2));
            playVideoInfo.setPlayType(PlayType.LIVE);
            playVideoInfo.putString(TableField.PLAY_FROM, "preloader");
            NewPlayInfoModel newPlayInfoModel = (NewPlayInfoModel) FastJsonTools.deserialize(str2, NewPlayInfoModel.class);
            if (newPlayInfoModel != null && newPlayInfoModel.playInfo != null) {
                if (!TextUtils.isEmpty(newPlayInfoModel.templateId) && "13".equals(newPlayInfoModel.templateId)) {
                    TLogUtil.playLog("old liveroom, skip playerpreload");
                    return;
                }
                AppKeyPlayInfoModel appKeyPlayInfoModel = newPlayInfoModel.playInfo;
                FileFormat fileFormatByProtocol = FileFormat.getFileFormatByProtocol(appKeyPlayInfoModel.format);
                if (fileFormatByProtocol != FileFormat.UNKNOWN && !TextUtils.isEmpty(appKeyPlayInfoModel.url)) {
                    playVideoInfo.setFastData(new FastData(fileFormatByProtocol, appKeyPlayInfoModel.url, false));
                    playVideoInfo.putString("uniqueKey", str);
                    if (newPlayInfoModel.seiDecode == 1) {
                        playVideoInfo.putMonitor("seidecode", "1");
                    } else {
                        playVideoInfo.putMonitor("seidecode", "0");
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    Log.d(TAG, "fast play: " + currentTimeMillis);
                    iPlayerContainer.play(playVideoInfo);
                    BusinessTrack.mVVTrigger = true;
                    this.mUseFastPlays.put(str, new Boolean(true));
                    NewPlayInfoCache.getInstance().put(str, newPlayInfoModel);
                    return;
                } else if (play(str, i, i2, z)) {
                    return;
                } else {
                    this.mPlayerContaners.remove(str);
                    return;
                }
            }
            play(str, i, i2, z);
        }
    }
}
