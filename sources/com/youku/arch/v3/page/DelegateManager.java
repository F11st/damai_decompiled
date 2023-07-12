package com.youku.arch.v3.page;

import android.content.Context;
import android.net.Uri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.util.ConfigParser;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/youku/arch/v3/page/DelegateManager;", "", "Lcom/youku/arch/v3/page/DelegateConfigure;", "getDelegateConfigure", "Landroid/net/Uri;", "uri", "", "pageName", "Ljava/lang/String;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "delegateConfigure", "Lcom/youku/arch/v3/page/DelegateConfigure;", "<init>", "(Ljava/lang/String;Landroid/content/Context;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DelegateManager {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context context;
    @Nullable
    private DelegateConfigure delegateConfigure;
    @NotNull
    private final String pageName;

    public DelegateManager(@NotNull String str, @NotNull Context context) {
        b41.i(str, "pageName");
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.pageName = str;
        this.context = context;
    }

    @Nullable
    public final DelegateConfigure getDelegateConfigure() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-375568584")) {
            return (DelegateConfigure) ipChange.ipc$dispatch("-375568584", new Object[]{this});
        }
        if (this.delegateConfigure == null) {
            ConfigParser configParser = new ConfigParser();
            Context context = this.context;
            this.delegateConfigure = (DelegateConfigure) configParser.parse(context, Uri.parse("android.resource://" + ((Object) this.context.getPackageName()) + "/raw/" + this.pageName + "_delegate_config"), DelegateConfigure.class);
        }
        return this.delegateConfigure;
    }

    @Nullable
    public final DelegateConfigure getDelegateConfigure(@Nullable Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1466825775")) {
            return (DelegateConfigure) ipChange.ipc$dispatch("1466825775", new Object[]{this, uri});
        }
        if (this.delegateConfigure == null) {
            this.delegateConfigure = (DelegateConfigure) new ConfigParser().parse(this.context, uri, DelegateConfigure.class);
        }
        return this.delegateConfigure;
    }
}
