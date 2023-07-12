package tb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.bindingx.core.BindingXCore;
import com.alibaba.android.bindingx.core.IEventHandler;
import com.alibaba.android.bindingx.core.PlatformManager;
import com.alibaba.android.bindingx.plugin.android.INativeViewUpdater;
import com.alibaba.android.bindingx.plugin.android.NativeCallback;
import com.alibaba.android.bindingx.plugin.android.NativeViewFinder;
import com.alibaba.android.bindingx.plugin.android.NativeViewUpdateService;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ui1 {
    private BindingXCore a;

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class a implements NativeViewFinder {
        a(ui1 ui1Var) {
        }

        @Override // com.alibaba.android.bindingx.plugin.android.NativeViewFinder
        public View findViewBy(View view, String str) {
            int identifier;
            if (view == null || TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                identifier = Integer.parseInt(str);
            } catch (Throwable unused) {
                Context context = view.getContext();
                identifier = context.getResources().getIdentifier(str, "id", context.getPackageName());
            }
            if (identifier > 0) {
                return view.findViewById(identifier);
            }
            return null;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class b implements PlatformManager.IDeviceResolutionTranslator {
        b(ui1 ui1Var) {
        }

        @Override // com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator
        public double nativeToWeb(double d, Object... objArr) {
            return d;
        }

        @Override // com.alibaba.android.bindingx.core.PlatformManager.IDeviceResolutionTranslator
        public double webToNative(double d, Object... objArr) {
            return d;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class c implements PlatformManager.IViewUpdater {
        c(ui1 ui1Var) {
        }

        @Override // com.alibaba.android.bindingx.core.PlatformManager.IViewUpdater
        public void synchronouslyUpdateViewOnUIThread(@NonNull View view, @NonNull String str, @NonNull Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map, Object... objArr) {
            NativeViewUpdateService.e(str).update(view, str, obj, iDeviceResolutionTranslator, map);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    class d implements BindingXCore.ObjectCreator<IEventHandler, Context, PlatformManager> {
        d(ui1 ui1Var) {
        }

        @Override // com.alibaba.android.bindingx.core.BindingXCore.ObjectCreator
        /* renamed from: a */
        public IEventHandler createWith(@NonNull Context context, @NonNull PlatformManager platformManager, Object... objArr) {
            return new ic(context, platformManager, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class e implements BindingXCore.JavaScriptCallback {
        final /* synthetic */ NativeCallback a;

        e(ui1 ui1Var, NativeCallback nativeCallback) {
            this.a = nativeCallback;
        }

        @Override // com.alibaba.android.bindingx.core.BindingXCore.JavaScriptCallback
        public void callback(Object obj) {
            NativeCallback nativeCallback = this.a;
            if (nativeCallback == null || !(obj instanceof Map)) {
                return;
            }
            nativeCallback.callback((Map) obj);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class f implements PlatformManager.IViewFinder {
        private NativeViewFinder a;

        f(@NonNull NativeViewFinder nativeViewFinder) {
            this.a = nativeViewFinder;
        }

        @Override // com.alibaba.android.bindingx.core.PlatformManager.IViewFinder
        @Nullable
        public View findViewBy(String str, Object... objArr) {
            if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof View)) {
                return null;
            }
            return this.a.findViewBy((View) objArr[0], str);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class g implements PlatformManager.IViewUpdater {
        private INativeViewUpdater a;

        g(@NonNull INativeViewUpdater iNativeViewUpdater) {
            this.a = iNativeViewUpdater;
        }

        @Override // com.alibaba.android.bindingx.core.PlatformManager.IViewUpdater
        public void synchronouslyUpdateViewOnUIThread(@NonNull View view, @NonNull String str, @NonNull Object obj, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull Map<String, Object> map, Object... objArr) {
            INativeViewUpdater iNativeViewUpdater = this.a;
            if (iNativeViewUpdater != null) {
                iNativeViewUpdater.update(view, str, obj, iDeviceResolutionTranslator, map);
            }
        }
    }

    private ui1(@Nullable NativeViewFinder nativeViewFinder, @Nullable PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @Nullable INativeViewUpdater iNativeViewUpdater, @Nullable PlatformManager.IScrollFactory iScrollFactory) {
        PlatformManager.IViewUpdater gVar;
        nativeViewFinder = nativeViewFinder == null ? new a(this) : nativeViewFinder;
        iDeviceResolutionTranslator = iDeviceResolutionTranslator == null ? new b(this) : iDeviceResolutionTranslator;
        if (iNativeViewUpdater == null) {
            gVar = new c(this);
        } else {
            gVar = new g(iNativeViewUpdater);
        }
        BindingXCore bindingXCore = new BindingXCore(c(new f(nativeViewFinder), iDeviceResolutionTranslator, gVar, iScrollFactory));
        this.a = bindingXCore;
        bindingXCore.i("scroll", new d(this));
    }

    public static ui1 b(@Nullable NativeViewFinder nativeViewFinder, @Nullable PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @Nullable INativeViewUpdater iNativeViewUpdater, @Nullable PlatformManager.IScrollFactory iScrollFactory) {
        return new ui1(nativeViewFinder, iDeviceResolutionTranslator, iNativeViewUpdater, iScrollFactory);
    }

    private PlatformManager c(@NonNull PlatformManager.IViewFinder iViewFinder, @NonNull PlatformManager.IDeviceResolutionTranslator iDeviceResolutionTranslator, @NonNull PlatformManager.IViewUpdater iViewUpdater, @Nullable PlatformManager.IScrollFactory iScrollFactory) {
        return new PlatformManager.b().d(iViewFinder).b(iDeviceResolutionTranslator).e(iViewUpdater).c(iScrollFactory).a();
    }

    public Map<String, Object> a(View view, Map<String, Object> map, NativeCallback nativeCallback) {
        if (view == null) {
            bb1.b("params invalid. view is null");
            return Collections.emptyMap();
        }
        if (map == null) {
            map = Collections.emptyMap();
        }
        String b2 = this.a.b(view.getContext(), null, map, new e(this, nativeCallback), view);
        HashMap hashMap = new HashMap(2);
        hashMap.put("token", b2);
        hashMap.put("eventType", com.alibaba.android.bindingx.core.internal.o.h(map, "eventType"));
        return hashMap;
    }

    public void d() {
        BindingXCore bindingXCore = this.a;
        if (bindingXCore != null) {
            bindingXCore.e();
            this.a = null;
            NativeViewUpdateService.d();
        }
    }

    public void e(Map<String, Object> map) {
        BindingXCore bindingXCore = this.a;
        if (bindingXCore != null) {
            bindingXCore.g(map);
        }
    }
}
