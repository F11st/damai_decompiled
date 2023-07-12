package com.taobao.android.dinamicx.videoc.core.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.videoc.core.IDXVideoController;
import com.taobao.android.dinamicx.videoc.core.IDXVideoManager;
import com.taobao.android.dinamicx.videoc.core.IDXVideoNotifier;
import com.taobao.android.dinamicx.videoc.core.listener.IDXVideoContainerListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import tb.ry;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXVideoController<VideoData, Video> implements IDXVideoController<VideoData, Video> {
    @NonNull
    protected final RecyclerView a;
    @NonNull
    protected final IDXVideoManager<VideoData, Video> b;
    @NonNull
    protected final IDXVideoNotifier<Video> c;
    private Handler d;

    public DXVideoController(@NonNull RecyclerView recyclerView, @NonNull IDXVideoManager<VideoData, Video> iDXVideoManager, @NonNull IDXVideoNotifier<Video> iDXVideoNotifier) {
        this(recyclerView, iDXVideoManager, iDXVideoNotifier, false);
    }

    private Handler a() {
        if (this.d == null) {
            this.d = new Handler(Looper.getMainLooper());
        }
        return this.d;
    }

    private Video b(@NonNull Video video, @NonNull String str) {
        Video nextVideo = this.b.nextVideo(str, video);
        if (nextVideo == null) {
            return null;
        }
        while (nextVideo != null && this.c.isVideoPlaying(nextVideo)) {
            Video peekNextVideo = this.b.peekNextVideo(str, nextVideo);
            if (peekNextVideo != null && peekNextVideo == nextVideo) {
                break;
            }
            nextVideo = peekNextVideo;
        }
        return nextVideo;
    }

    private static boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private void d(@NonNull final VideoData videodata, @NonNull final String str) {
        a().post(new Runnable() { // from class: com.taobao.android.dinamicx.videoc.core.impl.DXVideoController.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                DXVideoController.this.appendVideo(videodata, str);
            }
        });
    }

    private void e() {
        a().post(new Runnable() { // from class: com.taobao.android.dinamicx.videoc.core.impl.DXVideoController.1
            @Override // java.lang.Runnable
            public void run() {
                DXVideoController.this.clearVideos();
            }
        });
    }

    private void f(@NonNull final String str) {
        a().post(new Runnable() { // from class: com.taobao.android.dinamicx.videoc.core.impl.DXVideoController.2
            @Override // java.lang.Runnable
            public void run() {
                DXVideoController.this.clearVideos(str);
            }
        });
    }

    private void g(@NonNull final VideoData videodata, @NonNull final String str) {
        a().post(new Runnable() { // from class: com.taobao.android.dinamicx.videoc.core.impl.DXVideoController.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                DXVideoController.this.deleteVideo(videodata, str);
            }
        });
    }

    private void h(@NonNull final Video video, @NonNull final String str) {
        a().post(new Runnable() { // from class: com.taobao.android.dinamicx.videoc.core.impl.DXVideoController.5
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                DXVideoController.this.playNextVideo(video, str);
            }
        });
    }

    private void i(@NonNull final Video video, @NonNull final String str) {
        a().post(new Runnable() { // from class: com.taobao.android.dinamicx.videoc.core.impl.DXVideoController.6
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                DXVideoController.this.skipToNextVideo(video, str);
            }
        });
    }

    private void j(Collection<Video> collection, String str) {
        k(collection, str, true);
    }

    private void k(Collection<Video> collection, String str, boolean z) {
        List<Video> currentVideo;
        if (collection != null) {
            for (Video video : collection) {
                if (this.c.isVideoPlaying(video) && !this.b.containsVideo(str, video)) {
                    this.c.notifyVideoStop(this, video, str);
                }
            }
        }
        if (z && (currentVideo = this.b.currentVideo(str)) != null) {
            Iterator<Video> it = currentVideo.iterator();
            while (it.hasNext()) {
                Video next = it.next();
                this.c.notifyVideoPlay(this, next, str);
                while (this.c.remainingVideoCount() > 0 && (next = this.b.peekNextVideo(str, next)) != null && !this.c.isVideoPlaying(next)) {
                    this.c.notifyVideoPlay(this, next, str);
                }
            }
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoController
    public void appendVideo(@NonNull VideoData videodata, @NonNull String str) {
        try {
            if (!c()) {
                d(videodata, str);
            } else {
                j(this.b.appendVideoData(str, videodata), str);
            }
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoController
    public void clearVideos() {
        try {
            if (!c()) {
                e();
                return;
            }
            for (Map.Entry<String, List<Video>> entry : this.b.clearQueue().entrySet()) {
                for (Video video : entry.getValue()) {
                    this.c.notifyVideoStop(this, video, entry.getKey());
                }
            }
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoController
    public void deleteVideo(@NonNull VideoData videodata, @NonNull String str) {
        deleteVideo(videodata, str, true);
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoController
    public List<Video> getVideos(@NonNull String str) {
        return this.b.getVideos(str);
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoController
    public void playNextVideo(@NonNull Video video, @NonNull String str) {
        try {
            if (!c()) {
                h(video, str);
                return;
            }
            this.c.removePlayingVideo(video);
            if ((this.a instanceof IDXVideoContainerListener) && this.b.lastVideoInQueue(str) == video) {
                ((IDXVideoContainerListener) this.a).onDidFinishPlayingLastItem(this.b.getVideoPositionInContainer(str, video), this.b.isLoop(), new HashMap());
            }
            Video b = b(video, str);
            if (b == null) {
                return;
            }
            this.c.notifyVideoPlay(this, b, str);
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoController
    public Collection<String> scenes() {
        return this.b.scenes();
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoController
    public void skipToNextVideo(@NonNull Video video, @NonNull String str) {
        try {
            if (!c()) {
                i(video, str);
                return;
            }
            this.c.removePlayingVideo(video);
            Video b = b(video, str);
            this.b.skipCurrentVideo(str, video);
            if (b == null || b == video) {
                return;
            }
            this.c.notifyVideoPlay(this, b, str);
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public DXVideoController(@NonNull RecyclerView recyclerView, @NonNull IDXVideoManager<VideoData, Video> iDXVideoManager, @NonNull IDXVideoNotifier<Video> iDXVideoNotifier, boolean z) {
        this.a = recyclerView;
        this.b = iDXVideoManager;
        this.c = iDXVideoNotifier;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoController
    public void deleteVideo(@NonNull VideoData videodata, @NonNull String str, boolean z) {
        try {
            if (!c()) {
                g(videodata, str);
            } else {
                k(this.b.deleteVideoData(str, videodata), str, z);
            }
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoController
    public void clearVideos(@NonNull String str) {
        try {
            if (!c()) {
                f(str);
                return;
            }
            for (Video video : this.b.clearQueue(str)) {
                this.c.notifyVideoStop(this, video, str);
            }
        } catch (Throwable th) {
            ry.b(th);
        }
    }
}
