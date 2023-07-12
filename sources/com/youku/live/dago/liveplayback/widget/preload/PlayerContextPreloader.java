package com.youku.live.dago.liveplayback.widget.preload;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.live.livesdk.LiveRoomConstants;
import com.youku.live.livesdk.util.DebugHelp;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public enum PlayerContextPreloader {
    INSTANCE;
    
    private Map<String, PlayerContextContainer> mPlayerContextContainers = new HashMap(2);

    PlayerContextPreloader() {
    }

    public void clear(Activity activity) {
        if (activity != null && this.mPlayerContextContainers.size() > 0) {
            for (Map.Entry<String, PlayerContextContainer> entry : this.mPlayerContextContainers.entrySet()) {
                if (entry.getValue() != null && entry.getValue() != null) {
                    PlayerContextContainer value = entry.getValue();
                    if (value.getPlayerContext().getActivity() == activity) {
                        value.releasePlayer();
                        value.clear(activity.getApplicationContext());
                        this.mPlayerContextContainers.remove(entry.getKey());
                    }
                }
            }
        }
    }

    @Nullable
    public PlayerContextContainer getPlayerContext(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        PlayerContextContainer remove = this.mPlayerContextContainers.remove(str);
        if (remove != null && remove.getPlayerContext() != null) {
            remove.clear(remove.getPlayerContext().getActivity().getApplication());
        }
        return remove;
    }

    @Nullable
    public PlayerContextContainer preloadPlayerContext(@NonNull Activity activity) {
        IPlayerContainer findPreloadPlayer;
        Intent intent = activity.getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(Utils.DATA_COME_IN_PLAYCONTROLLER_UNIQUEKEY);
            if (TextUtils.isEmpty(stringExtra) || (findPreloadPlayer = PlayerPreloader.getInstance().findPreloadPlayer(stringExtra)) == null || findPreloadPlayer.getPlayVideoInfo() == null || findPreloadPlayer.getPlayVideoInfo().getFastData() == null) {
                return null;
            }
            try {
                long longExtra = intent.getLongExtra(LiveRoomConstants.DATA_COME_IN_ROOM_START_TIME, System.currentTimeMillis());
                if (findPreloadPlayer.getPlayerTrack() != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("key", "clickTs");
                    bundle.putLong("time", longExtra);
                    findPreloadPlayer.getPlayerTrack().onAction("putTimestamp", bundle);
                }
            } catch (Exception e) {
                if (DebugHelp.isDebugBuild()) {
                    e.printStackTrace();
                }
            }
            PlayerContextContainer playerContextContainer = new PlayerContextContainer(activity, findPreloadPlayer);
            this.mPlayerContextContainers.put(stringExtra, playerContextContainer);
            return playerContextContainer;
        }
        return null;
    }

    public boolean startPrePlay(Activity activity, ViewGroup viewGroup) {
        PlayerContextContainer preloadPlayerContext = preloadPlayerContext(activity);
        if (preloadPlayerContext != null && preloadPlayerContext.isNeedPreAttached()) {
            FrameLayout frameLayout = new FrameLayout(activity);
            viewGroup.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.addView(preloadPlayerContext.getPlayerView(), new FrameLayout.LayoutParams(-1, -1));
            frameLayout.setVisibility(0);
            frameLayout.setAlpha(0.0f);
        }
        return preloadPlayerContext != null;
    }
}
