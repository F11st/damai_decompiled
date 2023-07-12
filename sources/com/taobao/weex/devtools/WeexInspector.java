package com.taobao.weex.devtools;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.devtools.adapter.JsLogAdapter;
import com.taobao.weex.devtools.adapter.WXTracingAdapter;
import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.debug.IWebSocketClient;
import com.taobao.weex.devtools.inspector.console.RuntimeReplFactory;
import com.taobao.weex.devtools.inspector.elements.Document;
import com.taobao.weex.devtools.inspector.elements.DocumentProviderFactory;
import com.taobao.weex.devtools.inspector.elements.android.ActivityTracker;
import com.taobao.weex.devtools.inspector.elements.android.AndroidDocumentProviderFactory;
import com.taobao.weex.devtools.inspector.protocol.ChromeDevtoolsDomain;
import com.taobao.weex.devtools.inspector.protocol.module.CSS;
import com.taobao.weex.devtools.inspector.protocol.module.Console;
import com.taobao.weex.devtools.inspector.protocol.module.DOM;
import com.taobao.weex.devtools.inspector.protocol.module.Debugger;
import com.taobao.weex.devtools.inspector.protocol.module.Input;
import com.taobao.weex.devtools.inspector.protocol.module.Inspector;
import com.taobao.weex.devtools.inspector.protocol.module.Network;
import com.taobao.weex.devtools.inspector.protocol.module.Page;
import com.taobao.weex.devtools.inspector.protocol.module.Runtime;
import com.taobao.weex.devtools.inspector.protocol.module.Worker;
import com.taobao.weex.devtools.inspector.protocol.module.WxDebug;
import com.taobao.weex.devtools.inspector.runtime.RhinoDetectingRuntimeReplFactory;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WeexInspector {
    private static IWebSocketClient customerWSClient;
    private static volatile AtomicBoolean sInited = new AtomicBoolean(false);

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class BuilderBasedInitializer extends Initializer {
        @Nullable
        private final InspectorModulesProvider mInspectorModules;

        @Override // com.taobao.weex.devtools.WeexInspector.Initializer
        @Nullable
        protected Iterable<ChromeDevtoolsDomain> getInspectorModules() {
            InspectorModulesProvider inspectorModulesProvider = this.mInspectorModules;
            if (inspectorModulesProvider != null) {
                return inspectorModulesProvider.get();
            }
            return null;
        }

        private BuilderBasedInitializer(InitializerBuilder initializerBuilder) {
            super(initializerBuilder.mContext);
            this.mInspectorModules = initializerBuilder.mInspectorModules;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class DefaultInspectorModulesBuilder {
        private final Application mContext;
        private final PluginBuilder<ChromeDevtoolsDomain> mDelegate = new PluginBuilder<>();
        @Nullable
        private DocumentProviderFactory mDocumentProvider;
        @Nullable
        private RuntimeReplFactory mRuntimeRepl;

        public DefaultInspectorModulesBuilder(Context context) {
            this.mContext = (Application) context.getApplicationContext();
        }

        private DefaultInspectorModulesBuilder provideIfDesired(ChromeDevtoolsDomain chromeDevtoolsDomain) {
            this.mDelegate.provideIfDesired(chromeDevtoolsDomain.getClass().getName(), chromeDevtoolsDomain);
            return this;
        }

        @Nullable
        private DocumentProviderFactory resolveDocumentProvider() {
            DocumentProviderFactory documentProviderFactory = this.mDocumentProvider;
            if (documentProviderFactory != null) {
                return documentProviderFactory;
            }
            if (Build.VERSION.SDK_INT >= 14) {
                return new AndroidDocumentProviderFactory(this.mContext);
            }
            return null;
        }

        public DefaultInspectorModulesBuilder documentProvider(DocumentProviderFactory documentProviderFactory) {
            this.mDocumentProvider = documentProviderFactory;
            return this;
        }

        public Iterable<ChromeDevtoolsDomain> finish() {
            provideIfDesired(new Console());
            provideIfDesired(new Debugger());
            provideIfDesired(new WxDebug());
            DocumentProviderFactory resolveDocumentProvider = resolveDocumentProvider();
            if (resolveDocumentProvider != null) {
                Document document = new Document(resolveDocumentProvider);
                provideIfDesired(new DOM(document));
                provideIfDesired(new CSS(document));
            }
            provideIfDesired(new Input());
            provideIfDesired(new Inspector());
            provideIfDesired(new Network(this.mContext));
            provideIfDesired(new Page(this.mContext));
            RuntimeReplFactory runtimeReplFactory = this.mRuntimeRepl;
            if (runtimeReplFactory == null) {
                runtimeReplFactory = new RhinoDetectingRuntimeReplFactory(this.mContext);
            }
            provideIfDesired(new Runtime(runtimeReplFactory));
            provideIfDesired(new Worker());
            return this.mDelegate.finish();
        }

        @Deprecated
        public DefaultInspectorModulesBuilder provide(ChromeDevtoolsDomain chromeDevtoolsDomain) {
            this.mDelegate.provide(chromeDevtoolsDomain.getClass().getName(), chromeDevtoolsDomain);
            return this;
        }

        @Deprecated
        public DefaultInspectorModulesBuilder remove(String str) {
            this.mDelegate.remove(str);
            return this;
        }

        public DefaultInspectorModulesBuilder runtimeRepl(RuntimeReplFactory runtimeReplFactory) {
            this.mRuntimeRepl = runtimeReplFactory;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static abstract class Initializer {
        private final Context mContext;

        protected Initializer(Context context) {
            this.mContext = context.getApplicationContext();
        }

        @Nullable
        protected abstract Iterable<ChromeDevtoolsDomain> getInspectorModules();
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class InitializerBuilder {
        protected final Context mContext;
        @Nullable
        InspectorModulesProvider mInspectorModules;

        public Initializer build() {
            return new BuilderBasedInitializer(this);
        }

        public InitializerBuilder enableWebKitInspector(InspectorModulesProvider inspectorModulesProvider) {
            this.mInspectorModules = inspectorModulesProvider;
            return this;
        }

        private InitializerBuilder(Context context) {
            this.mContext = context.getApplicationContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class PluginBuilder<T> {
        private boolean mFinished;
        private final ArrayList<T> mPlugins;
        private final Set<String> mProvidedNames;
        private final Set<String> mRemovedNames;

        private PluginBuilder() {
            this.mProvidedNames = new HashSet();
            this.mRemovedNames = new HashSet();
            this.mPlugins = new ArrayList<>();
        }

        private void throwIfFinished() {
            if (this.mFinished) {
                throw new IllegalStateException("Must not continue to build after finish()");
            }
        }

        public Iterable<T> finish() {
            this.mFinished = true;
            return this.mPlugins;
        }

        public void provide(String str, T t) {
            throwIfFinished();
            this.mPlugins.add(t);
            this.mProvidedNames.add(str);
        }

        public void provideIfDesired(String str, T t) {
            throwIfFinished();
            if (this.mRemovedNames.contains(str) || !this.mProvidedNames.add(str)) {
                return;
            }
            this.mPlugins.add(t);
        }

        public void remove(String str) {
            throwIfFinished();
            this.mRemovedNames.remove(str);
        }
    }

    private WeexInspector() {
    }

    public static InspectorModulesProvider defaultInspectorModulesProvider(final Context context) {
        return new InspectorModulesProvider() { // from class: com.taobao.weex.devtools.WeexInspector.2
            @Override // com.taobao.weex.devtools.InspectorModulesProvider
            public Iterable<ChromeDevtoolsDomain> get() {
                return new DefaultInspectorModulesBuilder(context).finish();
            }
        };
    }

    public static IWebSocketClient getCustomerWSClient() {
        return customerWSClient;
    }

    public static void initToolbox() {
        try {
            WXSDKManager.v().Z(new WXTracingAdapter());
            WXLogUtils.setJsLogWatcher(JsLogAdapter.getInstance());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void initialize(Initializer initializer) {
        if (sInited.get()) {
            LogUtil.w("WeexInspector initialized");
            return;
        }
        boolean beginTrackingIfPossible = ActivityTracker.get().beginTrackingIfPossible((Application) initializer.mContext.getApplicationContext());
        sInited.set(beginTrackingIfPossible);
        if (beginTrackingIfPossible) {
            return;
        }
        LogUtil.w("Automatic activity tracking not available on this API level, caller must invoke ActivityTracker methods manually!");
    }

    public static void initializeWithDefaults(final Context context) {
        initialize(new Initializer(context) { // from class: com.taobao.weex.devtools.WeexInspector.1
            @Override // com.taobao.weex.devtools.WeexInspector.Initializer
            protected Iterable<ChromeDevtoolsDomain> getInspectorModules() {
                return new DefaultInspectorModulesBuilder(context).finish();
            }
        });
    }

    public static InitializerBuilder newInitializerBuilder(Context context) {
        return new InitializerBuilder(context);
    }

    public static void overrideWebSocketClient(IWebSocketClient iWebSocketClient) {
        customerWSClient = iWebSocketClient;
    }
}
