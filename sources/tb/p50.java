package tb;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureZone;
import com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class p50<ExposeKey, ExposeData> implements IExposureZoneRunner<ExposeKey, ExposeData> {
    private final Set<IExposureZone<ExposeKey, ExposeData>> a = new HashSet();

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void clear() {
        this.a.clear();
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public IExposureZone<ExposeKey, ExposeData> findZoneBySceneName(@NonNull String str) {
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a) {
            if (iExposureZone.key().equals(str)) {
                return iExposureZone;
            }
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public List<IExposureZone<ExposeKey, ExposeData>> findZonesBySceneName(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a) {
            if (iExposureZone.key().equals(str)) {
                arrayList.add(iExposureZone);
            }
        }
        return arrayList;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void registerExposureZone(@NonNull IExposureZone<ExposeKey, ExposeData> iExposureZone) {
        this.a.add(iExposureZone);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void runZone() {
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a) {
            runZone(iExposureZone);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void stopZone() {
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a) {
            stopZone(iExposureZone);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void unregisterExposureZone(@NonNull IExposureZone<ExposeKey, ExposeData> iExposureZone) {
        stopZone(iExposureZone);
        this.a.remove(iExposureZone);
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public Collection<IExposureZone<ExposeKey, ExposeData>> zones() {
        return this.a;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public <ZoneType extends IExposureZone<ExposeKey, ExposeData>> ZoneType findZoneBySceneName(@NonNull Class<ZoneType> cls, @NonNull String str) {
        Iterator<IExposureZone<ExposeKey, ExposeData>> it = this.a.iterator();
        while (it.hasNext()) {
            ZoneType zonetype = (ZoneType) it.next();
            if (zonetype.key().equals(str) && cls.isInstance(zonetype)) {
                return zonetype;
            }
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void runZone(@NonNull IExposureZone<ExposeKey, ExposeData> iExposureZone) {
        iExposureZone.attach();
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void stopZone(@NonNull IExposureZone<ExposeKey, ExposeData> iExposureZone) {
        iExposureZone.detach();
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void runZone(@NonNull String str) {
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a) {
            if (iExposureZone.key().equals(str)) {
                iExposureZone.attach();
            }
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public void stopZone(@NonNull String str) {
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a) {
            stopZone(iExposureZone);
        }
    }

    @Override // com.taobao.android.dinamicx.videoc.expose.core.IExposureZoneRunner
    public <ZoneType extends IExposureZone<ExposeKey, ExposeData>> List<ZoneType> findZonesBySceneName(@NonNull Class<ZoneType> cls, @NonNull String str) {
        ArrayList arrayList = new ArrayList();
        for (IExposureZone<ExposeKey, ExposeData> iExposureZone : this.a) {
            if (iExposureZone.key().equals(str) && cls.isInstance(iExposureZone)) {
                arrayList.add(iExposureZone);
            }
        }
        return arrayList;
    }
}
