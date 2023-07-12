package tb;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.videoc.core.IDXVideoController;
import com.taobao.android.dinamicx.videoc.core.IDXVideoNotifier;
import com.taobao.android.dinamicx.videoc.core.listener.IDXVideoListener;
import java.util.HashSet;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class l20 implements IDXVideoNotifier<IDXVideoListener> {
    public static final int DEFAULT_MAX_PLAYING_VIDEO = 1;
    private final int a;
    private final Set<Integer> b = new HashSet();

    public l20(int i) {
        this.a = i;
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoNotifier
    /* renamed from: a */
    public boolean isVideoPlaying(IDXVideoListener iDXVideoListener) {
        return this.b.contains(Integer.valueOf(iDXVideoListener.hashCode()));
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoNotifier
    /* renamed from: b */
    public void notifyVideoPlay(IDXVideoController<?, IDXVideoListener> iDXVideoController, @NonNull IDXVideoListener iDXVideoListener, @NonNull String str) {
        if (this.b.contains(Integer.valueOf(iDXVideoListener.hashCode())) || this.b.size() >= this.a) {
            return;
        }
        this.b.add(Integer.valueOf(iDXVideoListener.hashCode()));
        iDXVideoListener.onCanPlay(iDXVideoController, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoNotifier
    /* renamed from: c */
    public void notifyVideoStop(IDXVideoController<?, IDXVideoListener> iDXVideoController, @NonNull IDXVideoListener iDXVideoListener, @NonNull String str) {
        if (this.b.contains(Integer.valueOf(iDXVideoListener.hashCode()))) {
            removePlayingVideo(iDXVideoListener);
            iDXVideoListener.onShouldStop(iDXVideoController, str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoNotifier
    /* renamed from: d */
    public void removePlayingVideo(@NonNull IDXVideoListener iDXVideoListener) {
        this.b.remove(Integer.valueOf(iDXVideoListener.hashCode()));
    }

    @Override // com.taobao.android.dinamicx.videoc.core.IDXVideoNotifier
    public int remainingVideoCount() {
        return Math.max(0, this.a - this.b.size());
    }
}
