package io.flutter.embedding.engine.dart;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StringCodec;
import io.flutter.util.SourceLocation;
import io.flutter.util.Trace;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;
import tb.lu2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DartExecutor implements BinaryMessenger {
    private static final String TAG = "DartExecutor";
    @NonNull
    private final AssetManager assetManager;
    @NonNull
    private final BinaryMessenger binaryMessenger;
    @Nullable
    private DartExecutingListener dartExecutingListener;
    @NonNull
    private final DartMessenger dartMessenger;
    @NonNull
    private final FlutterJNI flutterJNI;
    private boolean isApplicationRunning;
    private final BinaryMessenger.BinaryMessageHandler isolateChannelMessageHandler;
    @Nullable
    private String isolateServiceId;
    @Nullable
    private IsolateServiceIdListener isolateServiceIdListener;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class DartCallback {
        public final AssetManager androidAssetManager;
        public final FlutterCallbackInformation callbackHandle;
        public final String pathToBundle;

        public DartCallback(@NonNull AssetManager assetManager, @NonNull String str, @NonNull FlutterCallbackInformation flutterCallbackInformation) {
            this.androidAssetManager = assetManager;
            this.pathToBundle = str;
            this.callbackHandle = flutterCallbackInformation;
        }

        @NonNull
        public String toString() {
            return "DartCallback( bundle path: " + this.pathToBundle + ", library path: " + this.callbackHandle.callbackLibraryPath + ", function: " + this.callbackHandle.callbackName + " )";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface DartExecutingListener {
        void onExecuteDartEntrypoint();
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class DefaultBinaryMessenger implements BinaryMessenger {
        private final DartMessenger messenger;

        @Override // io.flutter.plugin.common.BinaryMessenger
        @UiThread
        public void send(@NonNull String str, @Nullable ByteBuffer byteBuffer) {
            this.messenger.send(str, byteBuffer, null);
        }

        @Override // io.flutter.plugin.common.BinaryMessenger
        @UiThread
        public void setMessageHandler(@NonNull String str, @Nullable BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
            this.messenger.setMessageHandler(str, binaryMessageHandler);
        }

        private DefaultBinaryMessenger(@NonNull DartMessenger dartMessenger) {
            this.messenger = dartMessenger;
        }

        @Override // io.flutter.plugin.common.BinaryMessenger
        @UiThread
        public void send(@NonNull String str, @Nullable ByteBuffer byteBuffer, @Nullable BinaryMessenger.BinaryReply binaryReply) {
            this.messenger.send(str, byteBuffer, binaryReply);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    interface IsolateServiceIdListener {
        void onIsolateServiceIdAvailable(@NonNull String str);
    }

    public DartExecutor(@NonNull FlutterJNI flutterJNI, @NonNull AssetManager assetManager) {
        this.isApplicationRunning = false;
        BinaryMessenger.BinaryMessageHandler binaryMessageHandler = new BinaryMessenger.BinaryMessageHandler() { // from class: io.flutter.embedding.engine.dart.DartExecutor.1
            @Override // io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler
            public void onMessage(ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
                DartExecutor.this.isolateServiceId = StringCodec.INSTANCE.decodeMessage(byteBuffer);
                if (DartExecutor.this.isolateServiceIdListener != null) {
                    DartExecutor.this.isolateServiceIdListener.onIsolateServiceIdAvailable(DartExecutor.this.isolateServiceId);
                }
            }
        };
        this.isolateChannelMessageHandler = binaryMessageHandler;
        this.flutterJNI = flutterJNI;
        this.assetManager = assetManager;
        DartMessenger dartMessenger = new DartMessenger(flutterJNI);
        this.dartMessenger = dartMessenger;
        dartMessenger.setMessageHandler("flutter/isolate", binaryMessageHandler);
        this.binaryMessenger = new DefaultBinaryMessenger(dartMessenger);
        if (flutterJNI.isAttached()) {
            this.isApplicationRunning = true;
        }
    }

    public void executeDartCallback(@NonNull DartCallback dartCallback) {
        if (this.isApplicationRunning) {
            Log.w(TAG, "Attempted to run a DartExecutor that is already running.");
            return;
        }
        Log.v(TAG, "Executing Dart callback: " + dartCallback);
        FlutterJNI flutterJNI = this.flutterJNI;
        String str = dartCallback.pathToBundle;
        FlutterCallbackInformation flutterCallbackInformation = dartCallback.callbackHandle;
        flutterJNI.runBundleAndSnapshotFromLibrary(str, flutterCallbackInformation.callbackName, flutterCallbackInformation.callbackLibraryPath, dartCallback.androidAssetManager);
        this.isApplicationRunning = true;
    }

    public void executeDartEntrypoint(@NonNull DartEntrypoint dartEntrypoint) {
        if (this.isApplicationRunning) {
            Log.w(TAG, "Attempted to run a DartExecutor that is already running.");
            return;
        }
        Trace.beginSection(SourceLocation.clazz(this) + "." + SourceLocation.method());
        StringBuilder sb = new StringBuilder();
        sb.append("Executing Dart entrypoint: ");
        sb.append(dartEntrypoint);
        Log.v(TAG, sb.toString());
        DartExecutingListener dartExecutingListener = this.dartExecutingListener;
        if (dartExecutingListener != null) {
            dartExecutingListener.onExecuteDartEntrypoint();
        }
        this.flutterJNI.runBundleAndSnapshotFromLibrary(dartEntrypoint.pathToBundle, dartEntrypoint.dartEntrypointFunctionName, dartEntrypoint.dartEntrypointLibrary, this.assetManager);
        this.isApplicationRunning = true;
        Trace.endSection();
    }

    @NonNull
    public BinaryMessenger getBinaryMessenger() {
        return this.binaryMessenger;
    }

    @Nullable
    public String getIsolateServiceId() {
        return this.isolateServiceId;
    }

    @UiThread
    public int getPendingChannelResponseCount() {
        return this.dartMessenger.getPendingChannelResponseCount();
    }

    public boolean isExecutingDart() {
        return this.isApplicationRunning;
    }

    public void notifyLowMemoryWarning() {
        if (this.flutterJNI.isAttached()) {
            this.flutterJNI.notifyLowMemoryWarning();
        }
    }

    public void onAttachedToJNI() {
        Log.v(TAG, "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.flutterJNI.setPlatformMessageHandler(this.dartMessenger);
    }

    public void onDetachedFromJNI() {
        Log.v(TAG, "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.flutterJNI.setPlatformMessageHandler(null);
    }

    public void registerDartExecutingListener(@NonNull DartExecutingListener dartExecutingListener) {
        this.dartExecutingListener = dartExecutingListener;
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @UiThread
    @Deprecated
    public void send(@NonNull String str, @Nullable ByteBuffer byteBuffer) {
        this.binaryMessenger.send(str, byteBuffer);
    }

    public void setIsolateServiceIdListener(@Nullable IsolateServiceIdListener isolateServiceIdListener) {
        String str;
        this.isolateServiceIdListener = isolateServiceIdListener;
        if (isolateServiceIdListener == null || (str = this.isolateServiceId) == null) {
            return;
        }
        isolateServiceIdListener.onIsolateServiceIdAvailable(str);
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @UiThread
    @Deprecated
    public void setMessageHandler(@NonNull String str, @Nullable BinaryMessenger.BinaryMessageHandler binaryMessageHandler) {
        this.binaryMessenger.setMessageHandler(str, binaryMessageHandler);
    }

    public void unRegisterDartExecutingListener() {
        this.dartExecutingListener = null;
    }

    @Override // io.flutter.plugin.common.BinaryMessenger
    @UiThread
    @Deprecated
    public void send(@NonNull String str, @Nullable ByteBuffer byteBuffer, @Nullable BinaryMessenger.BinaryReply binaryReply) {
        this.binaryMessenger.send(str, byteBuffer, binaryReply);
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class DartEntrypoint {
        @NonNull
        public final String dartEntrypointFunctionName;
        @Nullable
        public final String dartEntrypointLibrary;
        @NonNull
        public final String pathToBundle;

        public DartEntrypoint(@NonNull String str, @NonNull String str2) {
            this.pathToBundle = str;
            this.dartEntrypointLibrary = null;
            this.dartEntrypointFunctionName = str2;
        }

        @NonNull
        public static DartEntrypoint createDefault() {
            FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
            if (flutterLoader.initialized()) {
                return new DartEntrypoint(flutterLoader.findAppBundlePath(), lu2.MAIN);
            }
            throw new AssertionError("DartEntrypoints can only be created once a FlutterEngine is created.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DartEntrypoint dartEntrypoint = (DartEntrypoint) obj;
            if (this.pathToBundle.equals(dartEntrypoint.pathToBundle)) {
                return this.dartEntrypointFunctionName.equals(dartEntrypoint.dartEntrypointFunctionName);
            }
            return false;
        }

        public int hashCode() {
            return (this.pathToBundle.hashCode() * 31) + this.dartEntrypointFunctionName.hashCode();
        }

        @NonNull
        public String toString() {
            return "DartEntrypoint( bundle path: " + this.pathToBundle + ", function: " + this.dartEntrypointFunctionName + " )";
        }

        public DartEntrypoint(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            this.pathToBundle = str;
            this.dartEntrypointLibrary = str2;
            this.dartEntrypointFunctionName = str3;
        }
    }
}
