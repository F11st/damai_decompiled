package com.youku.uplayer;

import android.util.Log;
import com.youku.alixplayer.BaseMediaSource;
import com.youku.alixplayer.IPlaylist;
import com.youku.alixplayer.model.Playlist;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ProxyMediaSource extends BaseMediaSource {
    private static final String TAG = "ProxyMediaSource";
    private String mSourceKey;

    public ProxyMediaSource(Playlist playlist, String str) {
        this.mPlayList = playlist;
        this.mSourceKey = str;
    }

    @Override // com.youku.alixplayer.IMediaSource
    public String getSourceKey() {
        return this.mSourceKey;
    }

    @Override // com.youku.alixplayer.BaseMediaSource, com.youku.alixplayer.IMediaSource
    public void preparePlaylist() {
        IPlaylist iPlaylist = this.mPlayList;
        if (iPlaylist != null) {
            notifyPlaylistPrepared(iPlaylist);
        } else {
            Log.e(TAG, "Playlist is null");
        }
    }
}
