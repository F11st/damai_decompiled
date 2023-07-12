package com.youku.alixplayer;

import com.youku.alixplayer.IMediaSource;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class BaseMediaSource implements IMediaSourceExt {
    public static final int ERROR_PLAYLIST_NULL = -1;
    public static final int SUCCESS_CODE = 1;
    protected List<IMediaSource.OnMediaSourceUpdatedListener> mOnMediaSourceUpdatedListeners = new CopyOnWriteArrayList();
    protected IPlaylist mPlayList;

    @Override // com.youku.alixplayer.IMediaSource
    public void addMediaSourceUpdatedListener(IMediaSource.OnMediaSourceUpdatedListener onMediaSourceUpdatedListener) {
        this.mOnMediaSourceUpdatedListeners.add(onMediaSourceUpdatedListener);
    }

    protected int addPeriod(IPeriod iPeriod) {
        IPlaylist iPlaylist = this.mPlayList;
        if (iPlaylist == null) {
            return -1;
        }
        iPlaylist.addPeriod(iPeriod);
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int changePeriod(int i, IPeriod iPeriod) {
        if (this.mPlayList == null) {
            return -1;
        }
        notifyPeriodUpdate(i, iPeriod);
        this.mPlayList.replacePeriod(iPeriod, i);
        notifyPlaylistUpdate(this.mPlayList);
        return 1;
    }

    @Override // com.youku.alixplayer.IMediaSource
    public void deinit() {
        IPlaylist iPlaylist = this.mPlayList;
        if (iPlaylist != null) {
            iPlaylist.destruct();
        }
        this.mPlayList = null;
    }

    protected final void notifyPeriodUpdate(int i, IPeriod iPeriod) {
        List<IMediaSource.OnMediaSourceUpdatedListener> list = this.mOnMediaSourceUpdatedListeners;
        if (list != null) {
            for (IMediaSource.OnMediaSourceUpdatedListener onMediaSourceUpdatedListener : list) {
                onMediaSourceUpdatedListener.onPeriodUpdate(i, iPeriod);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyPlaylistFailed() {
        List<IMediaSource.OnMediaSourceUpdatedListener> list = this.mOnMediaSourceUpdatedListeners;
        if (list != null) {
            for (IMediaSource.OnMediaSourceUpdatedListener onMediaSourceUpdatedListener : list) {
                onMediaSourceUpdatedListener.onPlaylistFailed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void notifyPlaylistPrepared(IPlaylist iPlaylist) {
        if (iPlaylist != null && iPlaylist.getPeriodList() != null && iPlaylist.getPeriodList().size() != 0) {
            for (IPeriod iPeriod : iPlaylist.getPeriodList()) {
                Reporter.addPeriodTypeMapping(iPeriod);
            }
        }
        List<IMediaSource.OnMediaSourceUpdatedListener> list = this.mOnMediaSourceUpdatedListeners;
        if (list != null) {
            for (IMediaSource.OnMediaSourceUpdatedListener onMediaSourceUpdatedListener : list) {
                onMediaSourceUpdatedListener.onPlaylistPrepared(this, iPlaylist);
            }
        }
    }

    protected final void notifyPlaylistUpdate(IPlaylist iPlaylist) {
        if (iPlaylist != null && iPlaylist.getPeriodList() != null && iPlaylist.getPeriodList().size() != 0) {
            for (IPeriod iPeriod : iPlaylist.getPeriodList()) {
                Reporter.addPeriodTypeMapping(iPeriod);
            }
        }
        List<IMediaSource.OnMediaSourceUpdatedListener> list = this.mOnMediaSourceUpdatedListeners;
        if (list != null) {
            for (IMediaSource.OnMediaSourceUpdatedListener onMediaSourceUpdatedListener : list) {
                onMediaSourceUpdatedListener.onPlaylistUpdate(iPlaylist);
            }
        }
    }

    @Override // com.youku.alixplayer.IMediaSource
    public abstract void preparePlaylist();

    @Override // com.youku.alixplayer.IMediaSource
    public void removeMediaSourceUpdatedListener(IMediaSource.OnMediaSourceUpdatedListener onMediaSourceUpdatedListener) {
        this.mOnMediaSourceUpdatedListeners.remove(onMediaSourceUpdatedListener);
    }

    protected int removePeriod(int i) {
        return this.mPlayList == null ? -1 : 1;
    }

    @Override // com.youku.alixplayer.IMediaSourceExt
    public boolean useRaphaelPlayer() {
        return false;
    }
}
