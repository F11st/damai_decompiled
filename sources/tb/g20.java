package tb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.videoc.DXVideoControlConfig;
import com.taobao.android.dinamicx.videoc.IDXVideoControlCenter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class g20 implements IDXVideoControlCenter {
    private IDXVideoControlCenter a;
    private DXVideoControlConfig<by2> b;

    public g20(@NonNull DXVideoControlConfig<by2> dXVideoControlConfig) {
        this.b = dXVideoControlConfig;
    }

    public void a() {
        if (this.a != null) {
            return;
        }
        DXVideoControlConfig<by2> dXVideoControlConfig = this.b;
        if (dXVideoControlConfig == null) {
            dXVideoControlConfig = DXVideoControlConfig.j();
        }
        this.a = new f20(dXVideoControlConfig);
    }

    public boolean b() {
        return this.a != null && wt.C0();
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void clearVideoQueue(@NonNull RecyclerView recyclerView) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.clearVideoQueue(recyclerView);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void destroy() {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.destroy();
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void makeVideoControl(@NonNull RecyclerView recyclerView) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.makeVideoControl(recyclerView);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void start(@NonNull RecyclerView recyclerView) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.start(recyclerView);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void startAtOnce(@NonNull RecyclerView recyclerView, @Nullable String str) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.startAtOnce(recyclerView, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stop(@NonNull RecyclerView recyclerView) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.stop(recyclerView);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stopAtOnce(@NonNull RecyclerView recyclerView) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.stopAtOnce(recyclerView);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void triggerPlayControl(@NonNull RecyclerView recyclerView) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.triggerPlayControl(recyclerView);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public int triggerPlayControlAtOnce(@NonNull RecyclerView recyclerView, @NonNull String str) {
        if (this.a == null || !wt.C0()) {
            return -1;
        }
        return this.a.triggerPlayControlAtOnce(recyclerView, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void clearVideoQueue(@NonNull RecyclerView recyclerView, @Nullable String str) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.clearVideoQueue(recyclerView, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void makeVideoControl(@NonNull RecyclerView recyclerView, @NonNull DXVideoControlConfig<by2> dXVideoControlConfig) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.makeVideoControl(recyclerView, dXVideoControlConfig);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void start(@NonNull RecyclerView recyclerView, @Nullable String str) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.start(recyclerView, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void startAtOnce(@NonNull RecyclerView recyclerView) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.startAtOnce(recyclerView);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stop(@NonNull RecyclerView recyclerView, @Nullable String str) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.stop(recyclerView, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stopAtOnce(@NonNull RecyclerView recyclerView, @Nullable String str) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.stopAtOnce(recyclerView, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void triggerPlayControl(@NonNull RecyclerView recyclerView, @Nullable String str) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.triggerPlayControl(recyclerView, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void makeVideoControl(@NonNull RecyclerView recyclerView, @NonNull DXVideoControlConfig<by2> dXVideoControlConfig, @NonNull String str) {
        if (this.a == null || !wt.C0()) {
            return;
        }
        this.a.makeVideoControl(recyclerView, dXVideoControlConfig, str);
    }
}
