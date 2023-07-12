package tb;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.videoc.core.IDXVideoFinder;
import com.taobao.android.dinamicx.videoc.core.IDXVideoManager;
import com.taobao.android.dinamicx.videoc.core.IKeyedQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class p1<VideoData, Video> implements IDXVideoManager<VideoData, Video> {
    private final Map<String, Pair<List<VideoData>, IKeyedQueue<Video>>> a = new HashMap();
    private final IDXVideoFinder<VideoData, Video> b;
    private final Comparator<VideoData> c;
    private final boolean d;
    private final boolean e;

    public p1(IDXVideoFinder<VideoData, Video> iDXVideoFinder, Comparator<VideoData> comparator, boolean z, boolean z2) {
        this.b = iDXVideoFinder;
        this.c = comparator;
        this.d = z;
        this.e = z2;
    }

    private IKeyedQueue<Video> b(@NonNull String str) {
        Pair<List<VideoData>, IKeyedQueue<Video>> pair = this.a.get(str);
        if (pair == null) {
            return null;
        }
        return (IKeyedQueue) pair.second;
    }

    private Video i(Video video, Video video2, IKeyedQueue<Video> iKeyedQueue) {
        if (iKeyedQueue.contains(video)) {
            if (this.e && video2 == null && !iKeyedQueue.isEmpty()) {
                iKeyedQueue.reLoop();
                iKeyedQueue.addCurrent(0);
                return iKeyedQueue.get(0);
            }
            return video2;
        }
        return null;
    }

    protected IKeyedQueue<Video> a(String str, List<VideoData> list, List<VideoData> list2, IKeyedQueue<Video> iKeyedQueue) {
        IKeyedQueue<Video> d = d();
        for (int i = 0; i < list.size(); i++) {
            VideoData videodata = list.get(i);
            List<Video> list3 = null;
            if (iKeyedQueue != null && !list2.isEmpty()) {
                list3 = f(videodata, list2, iKeyedQueue);
            }
            if (list3 == null || list3.isEmpty()) {
                list3 = this.b.findVideos(videodata, str);
            }
            if (list3 != null && !list3.isEmpty()) {
                if (this.d) {
                    Collections.reverse(list3);
                }
                d.push(i, list3);
            }
        }
        return d;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    public Collection<Video> appendVideoData(@NonNull String str, @NonNull VideoData videodata) {
        Pair<List<VideoData>, IKeyedQueue<Video>> pair = this.a.get(str);
        return refreshQueue(str, c(pair != null ? (List) pair.first : new ArrayList<>(), videodata));
    }

    protected abstract List<VideoData> c(List<VideoData> list, VideoData videodata);

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    public Map<String, List<Video>> clearQueue() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Pair<List<VideoData>, IKeyedQueue<Video>>> entry : this.a.entrySet()) {
            hashMap.put(entry.getKey(), ((IKeyedQueue) entry.getValue().second).toList());
        }
        this.a.clear();
        return hashMap;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    public boolean containsVideo(@NonNull String str, @NonNull Video video) {
        IKeyedQueue<Video> b = b(str);
        return b != null && b.indexOf(video) > -1;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    @Nullable
    public List<Video> currentVideo(@NonNull String str) {
        IKeyedQueue<Video> b = b(str);
        if (b == null) {
            return null;
        }
        return b.peek();
    }

    @NonNull
    protected abstract IKeyedQueue<Video> d();

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    public Collection<Video> deleteVideoData(@NonNull String str, @NonNull VideoData videodata) {
        Pair<List<VideoData>, IKeyedQueue<Video>> pair = this.a.get(str);
        return refreshQueue(str, e(pair != null ? (List) pair.first : new ArrayList<>(), videodata));
    }

    protected abstract List<VideoData> e(List<VideoData> list, VideoData videodata);

    protected abstract List<Video> f(@NonNull VideoData videodata, @NonNull List<VideoData> list, @NonNull IKeyedQueue<Video> iKeyedQueue);

    protected abstract int g(@NonNull VideoData videodata);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    public int getVideoPositionInContainer(@NonNull String str, @NonNull Video video) {
        Pair<List<VideoData>, IKeyedQueue<Video>> pair = this.a.get(str);
        if (pair == null) {
            return -1;
        }
        List list = (List) pair.first;
        int intValue = ((IKeyedQueue) pair.second).keyOf(video).intValue();
        if (intValue < 0 || intValue >= list.size()) {
            return -1;
        }
        return g(list.get(intValue));
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    public List<Video> getVideos(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        Pair<List<VideoData>, IKeyedQueue<Video>> pair = this.a.get(str);
        if (pair != null) {
            arrayList.addAll(((IKeyedQueue) pair.second).toList());
        }
        return arrayList;
    }

    protected abstract boolean h(@NonNull List<VideoData> list, @NonNull List<VideoData> list2);

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    public boolean isLoop() {
        return this.e;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    public Video lastVideoInQueue(@NonNull String str) {
        IKeyedQueue<Video> b = b(str);
        if (b == null) {
            return null;
        }
        return b.last();
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    public Video nextVideo(@NonNull String str, @NonNull Video video) {
        IKeyedQueue<Video> b = b(str);
        if (b == null) {
            return null;
        }
        return i(video, b.shift(video), b);
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    public Video peekNextVideo(@NonNull String str, @NonNull Video video) {
        IKeyedQueue<Video> b = b(str);
        if (b == null) {
            return null;
        }
        return i(video, b.addNext(video), b);
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    public Collection<Video> refreshQueue(@NonNull String str, @NonNull List<VideoData> list) {
        Pair<List<VideoData>, IKeyedQueue<Video>> pair = this.a.get(str);
        List<VideoData> arrayList = pair != null ? (List) pair.first : new ArrayList<>();
        IKeyedQueue<Video> iKeyedQueue = pair != null ? (IKeyedQueue) pair.second : null;
        if (list.size() > 1) {
            Collections.sort(list, this.c);
        }
        if (h(arrayList, list)) {
            IKeyedQueue<Video> a = a(str, list, arrayList, iKeyedQueue);
            this.a.put(str, new Pair<>(list, a));
            a.reset();
            if (iKeyedQueue == null) {
                a.addCurrent(0);
                return null;
            }
            List<Video> peek = iKeyedQueue.peek();
            if (peek.isEmpty() && !iKeyedQueue.isEmpty()) {
                a.addCurrent(Math.max(0, a.indexOf(iKeyedQueue.get(iKeyedQueue.size() - 1)) + 1));
                for (Video video : iKeyedQueue.peekShifted()) {
                    a.skip(video);
                }
            }
            for (Video video2 : peek) {
                a.addCurrent(Math.max(0, a.indexOf(video2)));
            }
            if (peek.isEmpty()) {
                a.addCurrent(0);
            }
            return iKeyedQueue.toList();
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    public Collection<String> scenes() {
        return this.b.scenes();
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    public Video skipCurrentVideo(@NonNull String str, @NonNull Video video) {
        IKeyedQueue<Video> b = b(str);
        if (b == null) {
            return null;
        }
        return b.remove((IKeyedQueue<Video>) video);
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoManager
    public List<Video> clearQueue(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        Pair<List<VideoData>, IKeyedQueue<Video>> remove = this.a.remove(str);
        if (remove != null) {
            arrayList.addAll(((IKeyedQueue) remove.second).toList());
        }
        return arrayList;
    }
}
