package tb;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.videoc.DXVideoControlConfig;
import com.taobao.android.dinamicx.videoc.IDXVideoControlCenter;
import com.taobao.android.dinamicx.videoc.core.IDXVideoController;
import com.taobao.android.dinamicx.videoc.core.impl.DXVideoController;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine;
import java.util.Comparator;
import java.util.Map;
import java.util.WeakHashMap;
import tb.pz1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class f20 implements IDXVideoControlCenter {
    private final DXVideoControlConfig<by2> a;
    private final Map<RecyclerView, Pair<IExposureEngine<?, ?>, IDXVideoController<?, ?>>> b = new WeakHashMap();

    public f20(@NonNull DXVideoControlConfig<by2> dXVideoControlConfig) {
        this.a = dXVideoControlConfig;
    }

    private IExposureEngine<?, ?> a(@NonNull RecyclerView recyclerView) {
        Pair<IExposureEngine<?, ?>, IDXVideoController<?, ?>> pair = this.b.get(recyclerView);
        if (pair == null) {
            return null;
        }
        return (IExposureEngine) pair.first;
    }

    private IDXVideoController<?, ?> b(@NonNull RecyclerView recyclerView) {
        Pair<IExposureEngine<?, ?>, IDXVideoController<?, ?>> pair = this.b.get(recyclerView);
        if (pair == null) {
            return null;
        }
        return (IDXVideoController) pair.second;
    }

    private void c(RecyclerView recyclerView, DXVideoControlConfig<by2> dXVideoControlConfig) {
        i20 i20Var = new i20(dXVideoControlConfig.o());
        Comparator<by2> p = dXVideoControlConfig.p();
        if (p == null) {
            p = new j20();
        }
        DXVideoController dXVideoController = new DXVideoController(recyclerView, new m20(i20Var, p, dXVideoControlConfig.n() == 1, dXVideoControlConfig.t()), new l20(dXVideoControlConfig.l()));
        pz1.C9584b c9584b = new pz1.C9584b(recyclerView, new r00(dXVideoController, dXVideoControlConfig.s(), dXVideoControlConfig.r(), dXVideoControlConfig.u()));
        for (String str : dXVideoController.scenes()) {
            c9584b.d(new h20(dXVideoController, dXVideoControlConfig.q(), dXVideoControlConfig.u()), dXVideoControlConfig.m(), str);
        }
        this.b.put(recyclerView, new Pair<>(c9584b.a(), dXVideoController));
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void clearVideoQueue(@NonNull RecyclerView recyclerView) {
        clearVideoQueue(recyclerView, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void destroy() {
        for (Pair<IExposureEngine<?, ?>, IDXVideoController<?, ?>> pair : this.b.values()) {
            ((IExposureEngine) pair.first).stop();
        }
        this.b.clear();
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void makeVideoControl(@NonNull RecyclerView recyclerView) {
        makeVideoControl(recyclerView, this.a);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void start(@NonNull RecyclerView recyclerView) {
        start(recyclerView, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void startAtOnce(@NonNull RecyclerView recyclerView) {
        startAtOnce(recyclerView, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stop(@NonNull RecyclerView recyclerView) {
        stop(recyclerView, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stopAtOnce(@NonNull RecyclerView recyclerView) {
        stop(recyclerView, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void triggerPlayControl(@NonNull RecyclerView recyclerView) {
        triggerPlayControl(recyclerView, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public int triggerPlayControlAtOnce(@NonNull RecyclerView recyclerView, @NonNull String str) {
        IExposureEngine<?, ?> a = a(recyclerView);
        IDXVideoController<?, ?> b = b(recyclerView);
        if (a == null || b == null) {
            return -1;
        }
        a.triggerExposeAtOnce(str);
        return b.getVideos(str).size();
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void clearVideoQueue(@NonNull RecyclerView recyclerView, @Nullable String str) {
        IDXVideoController<?, ?> b = b(recyclerView);
        if (b == null) {
            return;
        }
        if (str == null) {
            b.clearVideos();
        } else {
            b.clearVideos(str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void makeVideoControl(@NonNull RecyclerView recyclerView, @NonNull DXVideoControlConfig<by2> dXVideoControlConfig) {
        makeVideoControl(recyclerView, dXVideoControlConfig, null);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void start(@NonNull RecyclerView recyclerView, @Nullable String str) {
        IExposureEngine<?, ?> a = a(recyclerView);
        if (a == null) {
            return;
        }
        a.start(str);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void startAtOnce(@NonNull RecyclerView recyclerView, @Nullable String str) {
        IExposureEngine<?, ?> a = a(recyclerView);
        if (a == null) {
            return;
        }
        if (str == null) {
            a.runZone();
        } else {
            a.runZone(str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stop(@NonNull RecyclerView recyclerView, @Nullable String str) {
        IExposureEngine<?, ?> a = a(recyclerView);
        if (a == null) {
            return;
        }
        a.stop(str);
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void stopAtOnce(@NonNull RecyclerView recyclerView, @Nullable String str) {
        IExposureEngine<?, ?> a = a(recyclerView);
        if (a == null) {
            return;
        }
        if (str == null) {
            a.stopZone();
        } else {
            a.stopZone(str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void triggerPlayControl(@NonNull RecyclerView recyclerView, @Nullable String str) {
        IExposureEngine<?, ?> a = a(recyclerView);
        if (a == null) {
            return;
        }
        if (str == null) {
            a.triggerExpose();
        } else {
            a.triggerExpose(str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.IDXVideoControlCenter
    public void makeVideoControl(@NonNull RecyclerView recyclerView, @NonNull DXVideoControlConfig<by2> dXVideoControlConfig, @Nullable String str) {
        if (this.b.containsKey(recyclerView)) {
            return;
        }
        if (str != null) {
            if (dXVideoControlConfig == this.a) {
                dXVideoControlConfig = DXVideoControlConfig.j();
            }
            dXVideoControlConfig.v(str);
        }
        c(recyclerView, dXVideoControlConfig);
    }
}
