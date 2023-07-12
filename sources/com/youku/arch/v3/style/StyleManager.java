package com.youku.arch.v3.style;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.uc.webview.export.media.MessageID;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0004H\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/youku/arch/v3/style/StyleManager;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/youku/arch/v3/style/Style;", "style", "Ltb/wt2;", "updateStyle", "onCreate", "onResume", MessageID.onPause, "onDestroy", "Lcom/youku/arch/v3/style/IScene;", "scene", "registerScene", "unregisterScene", "Landroidx/lifecycle/LifecycleOwner;", "host", "Landroidx/lifecycle/LifecycleOwner;", "", "scenes", "Ljava/util/List;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StyleManager implements LifecycleObserver {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private Context context;
    @NotNull
    private LifecycleOwner host;
    @NotNull
    private final List<IScene> scenes;

    public StyleManager(@NotNull LifecycleOwner lifecycleOwner) {
        b41.i(lifecycleOwner, "host");
        this.host = lifecycleOwner;
        this.scenes = new ArrayList();
        this.host.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        Context activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "988205921")) {
            ipChange.ipc$dispatch("988205921", new Object[]{this});
        } else if (this.context == null) {
            LifecycleOwner lifecycleOwner = this.host;
            Context context = null;
            if (lifecycleOwner instanceof Activity) {
                if (lifecycleOwner instanceof Activity) {
                    activity = (Activity) lifecycleOwner;
                    context = activity;
                }
                this.context = context;
            }
            if (lifecycleOwner instanceof Fragment) {
                Fragment fragment = lifecycleOwner instanceof Fragment ? (Fragment) lifecycleOwner : null;
                if (fragment != null) {
                    activity = fragment.getActivity();
                    context = activity;
                }
            }
            this.context = context;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "661799891")) {
            ipChange.ipc$dispatch("661799891", new Object[]{this});
            return;
        }
        List<IScene> list = this.scenes;
        if (!((list == null || list.isEmpty()) ? true : true)) {
            for (IScene iScene : this.scenes) {
                iScene.unbindStyle();
            }
            this.scenes.clear();
        }
        this.host.getLifecycle().removeObserver(this);
        if (this.context != null) {
            this.context = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009119831")) {
            ipChange.ipc$dispatch("1009119831", new Object[]{this});
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1429237104")) {
            ipChange.ipc$dispatch("-1429237104", new Object[]{this});
        }
    }

    public final void registerScene(@NotNull IScene iScene) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072055718")) {
            ipChange.ipc$dispatch("1072055718", new Object[]{this, iScene});
            return;
        }
        b41.i(iScene, "scene");
        this.scenes.add(iScene);
    }

    public final void unregisterScene(@NotNull IScene iScene) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-238023681")) {
            ipChange.ipc$dispatch("-238023681", new Object[]{this, iScene});
            return;
        }
        b41.i(iScene, "scene");
        this.scenes.remove(iScene);
    }

    public final void updateStyle(@Nullable Style style) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1976731829")) {
            ipChange.ipc$dispatch("1976731829", new Object[]{this, style});
            return;
        }
        for (IScene iScene : this.scenes) {
            iScene.bindStyle(style);
        }
    }
}
