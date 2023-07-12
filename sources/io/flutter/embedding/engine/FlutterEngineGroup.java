package io.flutter.embedding.engine;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FlutterEngineGroup {
    @VisibleForTesting
    final List<FlutterEngine> activeEngines;

    public FlutterEngineGroup(@NonNull Context context) {
        this(context, null);
    }

    public FlutterEngine createAndRunDefaultEngine(@NonNull Context context) {
        return createAndRunEngine(context, null);
    }

    public FlutterEngine createAndRunEngine(@NonNull Context context, @Nullable DartExecutor.DartEntrypoint dartEntrypoint) {
        final FlutterEngine spawn;
        if (dartEntrypoint == null) {
            dartEntrypoint = DartExecutor.DartEntrypoint.createDefault();
        }
        if (this.activeEngines.size() == 0) {
            spawn = createEngine(context);
            spawn.getDartExecutor().executeDartEntrypoint(dartEntrypoint);
        } else {
            spawn = this.activeEngines.get(0).spawn(context, dartEntrypoint);
        }
        this.activeEngines.add(spawn);
        spawn.addEngineLifecycleListener(new FlutterEngine.EngineLifecycleListener() { // from class: io.flutter.embedding.engine.FlutterEngineGroup.1
            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onEngineWillDestroy() {
                FlutterEngineGroup.this.activeEngines.remove(spawn);
            }

            @Override // io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener
            public void onPreEngineRestart() {
            }
        });
        return spawn;
    }

    @VisibleForTesting
    FlutterEngine createEngine(Context context) {
        return new FlutterEngine(context);
    }

    public FlutterEngineGroup(@NonNull Context context, @Nullable String[] strArr) {
        this.activeEngines = new ArrayList();
        FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
        if (flutterLoader.initialized()) {
            return;
        }
        flutterLoader.startInitialization(context.getApplicationContext());
        flutterLoader.ensureInitializationComplete(context, strArr);
    }
}
