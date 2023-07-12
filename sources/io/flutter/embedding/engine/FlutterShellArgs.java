package io.flutter.embedding.engine;

import android.content.Intent;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FlutterShellArgs {
    public static final String ARG_AX_SERVICE_WHITE_LIST = "--ax-service-white-list";
    public static final String ARG_CACHE_SKSL = "--cache-sksl";
    public static final String ARG_DART_FLAGS = "--dart-flags";
    public static final String ARG_DISABLE_SERVICE_AUTH_CODES = "--disable-service-auth-codes";
    public static final String ARG_DUMP_SHADER_SKP_ON_SHADER_COMPILATION = "--dump-skp-on-shader-compilation";
    public static final String ARG_ENABLE_DART_PROFILING = "--enable-dart-profiling";
    public static final String ARG_ENABLE_SOFTWARE_RENDERING = "--enable-software-rendering";
    public static final String ARG_ENDLESS_TRACE_BUFFER = "--endless-trace-buffer";
    public static final String ARG_KEY_AX_SERVICE_WHITE_LIST = "ax-service-white-list";
    public static final String ARG_KEY_CACHE_SKSL = "cache-sksl";
    public static final String ARG_KEY_DART_FLAGS = "dart-flags";
    public static final String ARG_KEY_DISABLE_SERVICE_AUTH_CODES = "disable-service-auth-codes";
    public static final String ARG_KEY_DUMP_SHADER_SKP_ON_SHADER_COMPILATION = "dump-skp-on-shader-compilation";
    public static final String ARG_KEY_ENABLE_DART_PROFILING = "enable-dart-profiling";
    public static final String ARG_KEY_ENABLE_SOFTWARE_RENDERING = "enable-software-rendering";
    public static final String ARG_KEY_ENDLESS_TRACE_BUFFER = "endless-trace-buffer";
    public static final String ARG_KEY_OBSERVATORY_PORT = "observatory-port";
    public static final String ARG_KEY_PURGE_PERSISTENT_CACHE = "purge-persistent-cache";
    public static final String ARG_KEY_SKIA_DETERMINISTIC_RENDERING = "skia-deterministic-rendering";
    public static final String ARG_KEY_START_PAUSED = "start-paused";
    public static final String ARG_KEY_TRACE_SKIA = "trace-skia";
    public static final String ARG_KEY_TRACE_SKIA_ALLOWLIST = "trace-skia-allowlist";
    public static final String ARG_KEY_TRACE_STARTUP = "trace-startup";
    public static final String ARG_KEY_TRACE_SYSTRACE = "trace-systrace";
    public static final String ARG_KEY_USE_TEST_FONTS = "use-test-fonts";
    public static final String ARG_KEY_VERBOSE_LOGGING = "verbose-logging";
    public static final String ARG_OBSERVATORY_PORT = "--observatory-port=";
    public static final String ARG_PURGE_PERSISTENT_CACHE = "--purge-persistent-cache";
    public static final String ARG_SKIA_DETERMINISTIC_RENDERING = "--skia-deterministic-rendering";
    public static final String ARG_START_PAUSED = "--start-paused";
    public static final String ARG_TRACE_SKIA = "--trace-skia";
    public static final String ARG_TRACE_SKIA_ALLOWLIST = "--trace-skia-allowlist=";
    public static final String ARG_TRACE_STARTUP = "--trace-startup";
    public static final String ARG_TRACE_SYSTRACE = "--trace-systrace";
    public static final String ARG_USE_TEST_FONTS = "--use-test-fonts";
    public static final String ARG_VERBOSE_LOGGING = "--verbose-logging";
    @NonNull
    private Set<String> args;

    public FlutterShellArgs(@NonNull String[] strArr) {
        this.args = new HashSet(Arrays.asList(strArr));
    }

    @NonNull
    public static FlutterShellArgs fromIntent(@NonNull Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (intent.getBooleanExtra(ARG_KEY_TRACE_STARTUP, false)) {
            arrayList.add(ARG_TRACE_STARTUP);
        }
        if (intent.getBooleanExtra(ARG_KEY_START_PAUSED, false)) {
            arrayList.add(ARG_START_PAUSED);
        }
        int intExtra = intent.getIntExtra(ARG_KEY_OBSERVATORY_PORT, 0);
        if (intExtra > 0) {
            arrayList.add(ARG_OBSERVATORY_PORT + Integer.toString(intExtra));
        }
        if (intent.getBooleanExtra(ARG_KEY_DISABLE_SERVICE_AUTH_CODES, false)) {
            arrayList.add(ARG_DISABLE_SERVICE_AUTH_CODES);
        }
        if (intent.getBooleanExtra(ARG_KEY_ENDLESS_TRACE_BUFFER, false)) {
            arrayList.add(ARG_ENDLESS_TRACE_BUFFER);
        }
        if (intent.getBooleanExtra(ARG_KEY_USE_TEST_FONTS, false)) {
            arrayList.add(ARG_USE_TEST_FONTS);
        }
        if (intent.getBooleanExtra(ARG_KEY_ENABLE_DART_PROFILING, false)) {
            arrayList.add(ARG_ENABLE_DART_PROFILING);
        }
        if (intent.getBooleanExtra(ARG_KEY_ENABLE_SOFTWARE_RENDERING, false)) {
            arrayList.add(ARG_ENABLE_SOFTWARE_RENDERING);
        }
        if (intent.getBooleanExtra(ARG_KEY_SKIA_DETERMINISTIC_RENDERING, false)) {
            arrayList.add(ARG_SKIA_DETERMINISTIC_RENDERING);
        }
        if (intent.getBooleanExtra(ARG_KEY_TRACE_SKIA, false)) {
            arrayList.add(ARG_TRACE_SKIA);
        }
        String stringExtra = intent.getStringExtra(ARG_KEY_TRACE_SKIA_ALLOWLIST);
        if (stringExtra != null) {
            arrayList.add(ARG_TRACE_SKIA_ALLOWLIST + stringExtra);
        }
        if (intent.getBooleanExtra(ARG_KEY_TRACE_SYSTRACE, false)) {
            arrayList.add(ARG_TRACE_SYSTRACE);
        }
        if (intent.getBooleanExtra(ARG_KEY_DUMP_SHADER_SKP_ON_SHADER_COMPILATION, false)) {
            arrayList.add(ARG_DUMP_SHADER_SKP_ON_SHADER_COMPILATION);
        }
        if (intent.getBooleanExtra(ARG_KEY_CACHE_SKSL, false)) {
            arrayList.add(ARG_CACHE_SKSL);
        }
        if (intent.getBooleanExtra(ARG_KEY_PURGE_PERSISTENT_CACHE, false)) {
            arrayList.add(ARG_PURGE_PERSISTENT_CACHE);
        }
        if (intent.getBooleanExtra(ARG_KEY_VERBOSE_LOGGING, false)) {
            arrayList.add(ARG_VERBOSE_LOGGING);
        }
        if (intent.hasExtra(ARG_KEY_DART_FLAGS)) {
            arrayList.add("--dart-flags=" + intent.getStringExtra(ARG_KEY_DART_FLAGS));
        }
        if (intent.hasExtra(ARG_KEY_AX_SERVICE_WHITE_LIST)) {
            arrayList.add("--ax-service-white-list=" + intent.getStringExtra(ARG_KEY_AX_SERVICE_WHITE_LIST));
        }
        return new FlutterShellArgs(arrayList);
    }

    public void add(@NonNull String str) {
        this.args.add(str);
    }

    public void remove(@NonNull String str) {
        this.args.remove(str);
    }

    @NonNull
    public String[] toArray() {
        return (String[]) this.args.toArray(new String[this.args.size()]);
    }

    public FlutterShellArgs(@NonNull List<String> list) {
        this.args = new HashSet(list);
    }

    public FlutterShellArgs(@NonNull Set<String> set) {
        this.args = new HashSet(set);
    }
}
