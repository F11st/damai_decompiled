package io.flutter.embedding.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FlutterEngineCache {
    private static FlutterEngineCache instance;
    private final Map<String, FlutterEngine> cachedEngines = new HashMap();

    @VisibleForTesting
    FlutterEngineCache() {
    }

    @NonNull
    public static FlutterEngineCache getInstance() {
        if (instance == null) {
            instance = new FlutterEngineCache();
        }
        return instance;
    }

    public void clear() {
        this.cachedEngines.clear();
    }

    public boolean contains(@NonNull String str) {
        return this.cachedEngines.containsKey(str);
    }

    @Nullable
    public FlutterEngine get(@NonNull String str) {
        return this.cachedEngines.get(str);
    }

    public void put(@NonNull String str, @Nullable FlutterEngine flutterEngine) {
        if (flutterEngine != null) {
            this.cachedEngines.put(str, flutterEngine);
        } else {
            this.cachedEngines.remove(str);
        }
    }

    public void remove(@NonNull String str) {
        put(str, null);
    }
}
