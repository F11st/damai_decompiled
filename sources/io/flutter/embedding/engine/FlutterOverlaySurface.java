package io.flutter.embedding.engine;

import android.view.Surface;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
@Keep
/* loaded from: classes3.dex */
public class FlutterOverlaySurface {
    private final int id;
    @NonNull
    private final Surface surface;

    public FlutterOverlaySurface(int i, @NonNull Surface surface) {
        this.id = i;
        this.surface = surface;
    }

    public int getId() {
        return this.id;
    }

    public Surface getSurface() {
        return this.surface;
    }
}
