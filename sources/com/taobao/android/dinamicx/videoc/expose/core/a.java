package com.taobao.android.dinamicx.videoc.expose.core;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureZone;
import com.taobao.android.dinamicx.videoc.expose.core.listener.ExposureLifecycle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import tb.p50;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class a<ExposeKey, ExposeData> implements IExposureEngine<ExposeKey, ExposeData> {
    protected final IExposureZoneRunner<ExposeKey, ExposeData> a;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.videoc.expose.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static abstract class AbstractC0292a<ExposeKey, ExposeData, CacheDataType> {
        private final IExposureZone.Builder<ExposeKey, ExposeData> a;
        private final List<Pair<IExposure<ExposeKey, ExposeData>, String>> b = new ArrayList();
        private final IExposureCenter<ExposeKey, ExposeData, CacheDataType> c;
        private IExposureZoneRunner<ExposeKey, ExposeData> d;

        public AbstractC0292a(@NonNull IExposureZone.Builder<ExposeKey, ExposeData> builder, @Nullable IExposureCenter<ExposeKey, ExposeData, CacheDataType> iExposureCenter) {
            this.a = builder;
            this.c = iExposureCenter;
        }

        @NonNull
        public IExposureEngine<ExposeKey, ExposeData> a() {
            IExposureZone<ExposeKey, ExposeData> build;
            if (this.d == null) {
                this.d = new p50();
            }
            for (Pair<IExposure<ExposeKey, ExposeData>, String> pair : this.b) {
                Object obj = pair.second;
                if (obj != null) {
                    build = this.a.build((IExposure) pair.first, (String) obj);
                } else {
                    build = this.a.build((IExposure) pair.first);
                }
                this.d.registerExposureZone(build);
            }
            IExposureZoneRunner<ExposeKey, ExposeData> iExposureZoneRunner = this.d;
            if (iExposureZoneRunner == null) {
                iExposureZoneRunner = new p50<>();
            }
            return b(iExposureZoneRunner, this.d.zones());
        }

        @NonNull
        protected abstract IExposureEngine<ExposeKey, ExposeData> b(@NonNull IExposureZoneRunner<ExposeKey, ExposeData> iExposureZoneRunner, @NonNull Collection<IExposureZone<ExposeKey, ExposeData>> collection);

        public AbstractC0292a<ExposeKey, ExposeData, CacheDataType> c(@NonNull IExposure<ExposeKey, ExposeData> iExposure, @Nullable String str) {
            this.b.add(new Pair<>(iExposure, str));
            return this;
        }

        public AbstractC0292a<ExposeKey, ExposeData, CacheDataType> d(@NonNull ExposureLifecycle<ExposeKey, ExposeData> exposureLifecycle, long j, @Nullable String str) {
            IExposureCenter<ExposeKey, ExposeData, CacheDataType> iExposureCenter = this.c;
            return iExposureCenter != null ? c(iExposureCenter.buildExposure(exposureLifecycle, j), str) : this;
        }
    }

    public a(IExposureZoneRunner<ExposeKey, ExposeData> iExposureZoneRunner) {
        this.a = iExposureZoneRunner;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void clear() {
        this.a.clear();
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void clearCache() {
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a.zones()) {
            iExposureZone.exposure().clearCache();
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void exposeCache() {
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a.zones()) {
            iExposureZone.exposure().exposeCache();
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public IExposureZone<ExposeKey, ExposeData> findZoneBySceneName(@NonNull String str) {
        return this.a.findZoneBySceneName(str);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public List<IExposureZone<ExposeKey, ExposeData>> findZonesBySceneName(@NonNull String str) {
        return this.a.findZonesBySceneName(str);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void registerExposureZone(@NonNull IExposureZone<ExposeKey, ExposeData> iExposureZone) {
        this.a.registerExposureZone(iExposureZone);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void runZone() {
        this.a.runZone();
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void stop(@Nullable String str) {
        if (str == null) {
            stopZone();
        } else {
            stopZone(str);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void stopZone() {
        this.a.stopZone();
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void triggerExpose() {
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a.zones()) {
            iExposureZone.exposure().triggerExpose(iExposureZone.key());
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void triggerExposeAtOnce() {
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a.zones()) {
            iExposureZone.exposure().triggerExposeAtOnce(iExposureZone.key());
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void unregisterExposureZone(@NonNull IExposureZone<ExposeKey, ExposeData> iExposureZone) {
        this.a.unregisterExposureZone(iExposureZone);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public Collection<IExposureZone<ExposeKey, ExposeData>> zones() {
        return this.a.zones();
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public <ZoneType extends IExposureZone<ExposeKey, ExposeData>> ZoneType findZoneBySceneName(@NonNull Class<ZoneType> cls, @NonNull String str) {
        return (ZoneType) this.a.findZoneBySceneName(cls, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public <ZoneType extends IExposureZone<ExposeKey, ExposeData>> List<ZoneType> findZonesBySceneName(@NonNull Class<ZoneType> cls, @NonNull String str) {
        return this.a.findZonesBySceneName(cls, str);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void runZone(@NonNull IExposureZone<ExposeKey, ExposeData> iExposureZone) {
        this.a.runZone(iExposureZone);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void stopZone(@NonNull IExposureZone<ExposeKey, ExposeData> iExposureZone) {
        this.a.stopZone(iExposureZone);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void clearCache(@NonNull String str) {
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a.findZonesBySceneName(str)) {
            iExposureZone.exposure().clearCache();
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void exposeCache(@NonNull String str) {
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a.findZonesBySceneName(str)) {
            iExposureZone.exposure().exposeCache();
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void runZone(@NonNull String str) {
        this.a.runZone(str);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void stopZone(@NonNull String str) {
        this.a.stopZone(str);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void triggerExpose(@NonNull String str) {
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a.findZonesBySceneName(str)) {
            iExposureZone.exposure().triggerExpose(iExposureZone.key());
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureEngine
    public void triggerExposeAtOnce(@NonNull String str) {
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a.findZonesBySceneName(str)) {
            iExposureZone.exposure().triggerExposeAtOnce(iExposureZone.key());
        }
    }
}
