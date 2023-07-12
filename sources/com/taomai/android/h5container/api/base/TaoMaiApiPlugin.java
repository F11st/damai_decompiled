package com.taomai.android.h5container.api.base;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.webview.IWVWebView;
import androidx.fragment.app.Fragment;
import com.youku.arch.v3.event.Subject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001f\u0010\u000b\u001a\u0004\u0018\u00010\u00068F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/taomai/android/h5container/api/base/TaoMaiApiPlugin;", "Landroid/taobao/windvane/jsbridge/WVApiPlugin;", "", "name", "", "getProvider", "Landroidx/fragment/app/Fragment;", "fragment$delegate", "Lkotlin/Lazy;", "getFragment", "()Landroidx/fragment/app/Fragment;", Subject.FRAGMENT, "<init>", "()V", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public abstract class TaoMaiApiPlugin extends WVApiPlugin {
    @Nullable
    private final Lazy fragment$delegate;

    public TaoMaiApiPlugin() {
        Lazy b;
        b = b.b(new Function0<Fragment>() { // from class: com.taomai.android.h5container.api.base.TaoMaiApiPlugin$fragment$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Fragment invoke() {
                IWVWebView iWVWebView;
                iWVWebView = ((WVApiPlugin) TaoMaiApiPlugin.this).mWebView;
                Object jsObject = iWVWebView.getJsObject(Subject.FRAGMENT);
                if (!(jsObject instanceof Fragment)) {
                    jsObject = null;
                }
                return (Fragment) jsObject;
            }
        });
        this.fragment$delegate = b;
    }

    @Nullable
    public final Fragment getFragment() {
        return (Fragment) this.fragment$delegate.getValue();
    }

    @Nullable
    public final Object getProvider(@NotNull String str) {
        b41.i(str, "name");
        return this.mWebView.getJsObject(str);
    }
}
