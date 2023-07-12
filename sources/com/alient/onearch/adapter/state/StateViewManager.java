package com.alient.onearch.adapter.state;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.taobao.login4android.constants.LoginConstants;
import com.youku.arch.v3.page.state.IStateView;
import com.youku.arch.v3.page.state.State;
import io.flutter.wpkbridge.WPKFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0004\u000e\u000f\u0010\u0011B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/alient/onearch/adapter/state/StateViewManager;", "", "", "pageName", "Lcom/alient/onearch/adapter/state/StateViewManager$IStateViewDelegate;", "stateViewDelegate", "Ltb/wt2;", "register", "getStateViewDelegate", "", "stateViewDelegates", "Ljava/util/Map;", "<init>", "()V", "Companion", "IStateFeature", "IStateViewDelegate", "IStateViewListener", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class StateViewManager {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String KEY_DEFAULT_STATE_VIEW_CREATOR = "default_state_delegate";
    @NotNull
    private static final Lazy<StateViewManager> instance$delegate;
    @NotNull
    private final Map<String, IStateViewDelegate> stateViewDelegates = new LinkedHashMap();

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0007\u001a\u00020\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/alient/onearch/adapter/state/StateViewManager$Companion;", "", "Lcom/alient/onearch/adapter/state/StateViewManager;", "instance$delegate", "Lkotlin/Lazy;", "getInstance", "()Lcom/alient/onearch/adapter/state/StateViewManager;", "instance", "", "KEY_DEFAULT_STATE_VIEW_CREATOR", "Ljava/lang/String;", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final StateViewManager getInstance() {
            return (StateViewManager) StateViewManager.instance$delegate.getValue();
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J6\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\u000f\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0011"}, d2 = {"Lcom/alient/onearch/adapter/state/StateViewManager$IStateFeature;", "", "Landroid/app/Activity;", "activity", "", "msg", "", "canCancel", "Ltb/wt2;", "showLoadingDialog", "hideLoadingDialog", "code", "Lcom/alient/onearch/adapter/state/StateViewManager$IStateViewListener;", "listener", "showErrorView", "hideErrorView", LoginConstants.SHOW_TOAST, "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public interface IStateFeature {

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
        /* loaded from: classes12.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void showErrorView$default(IStateFeature iStateFeature, Activity activity, String str, String str2, IStateViewListener iStateViewListener, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorView");
                }
                if ((i & 2) != 0) {
                    str = null;
                }
                if ((i & 4) != 0) {
                    str2 = null;
                }
                if ((i & 8) != 0) {
                    iStateViewListener = null;
                }
                iStateFeature.showErrorView(activity, str, str2, iStateViewListener);
            }

            public static /* synthetic */ void showLoadingDialog$default(IStateFeature iStateFeature, Activity activity, String str, boolean z, int i, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadingDialog");
                }
                if ((i & 2) != 0) {
                    str = null;
                }
                if ((i & 4) != 0) {
                    z = true;
                }
                iStateFeature.showLoadingDialog(activity, str, z);
            }
        }

        void hideErrorView(@Nullable Activity activity);

        void hideLoadingDialog(@Nullable Activity activity);

        void showErrorView(@Nullable Activity activity, @Nullable String str, @Nullable String str2, @Nullable IStateViewListener iStateViewListener);

        void showLoadingDialog(@Nullable Activity activity, @Nullable String str, boolean z);

        void showToast(@NotNull String str);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH&¨\u0006\u0011"}, d2 = {"Lcom/alient/onearch/adapter/state/StateViewManager$IStateViewDelegate;", "Lcom/alient/onearch/adapter/state/StateViewManager$IStateFeature;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/view/ViewGroup;", "container", "Lcom/youku/arch/v3/page/state/State;", "state", "Lcom/alient/onearch/adapter/state/StateViewManager$IStateViewListener;", "stateViewListener", "Lcom/youku/arch/v3/page/state/IStateView;", "createStateView", "Landroid/app/Activity;", "activity", "Lcom/scwang/smartrefresh/layout/api/RefreshInternal;", "createLoadingHeaderView", "createLoadingFooterView", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes10.dex */
    public interface IStateViewDelegate extends IStateFeature {
        @Nullable
        RefreshInternal createLoadingFooterView(@Nullable Activity activity);

        @Nullable
        RefreshInternal createLoadingHeaderView(@Nullable Activity activity);

        @Nullable
        IStateView createStateView(@NotNull Context context, @NotNull ViewGroup viewGroup, @NotNull State state, @Nullable IStateViewListener iStateViewListener);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0005"}, d2 = {"Lcom/alient/onearch/adapter/state/StateViewManager$IStateViewListener;", "", "Ltb/wt2;", "onRefreshClick", "onReportClick", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public interface IStateViewListener {
        void onRefreshClick();

        void onReportClick();
    }

    static {
        Lazy<StateViewManager> a;
        a = b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<StateViewManager>() { // from class: com.alient.onearch.adapter.state.StateViewManager$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final StateViewManager invoke() {
                return new StateViewManager();
            }
        });
        instance$delegate = a;
    }

    @Nullable
    public final IStateViewDelegate getStateViewDelegate(@NotNull String str) {
        b41.i(str, "pageName");
        IStateViewDelegate iStateViewDelegate = this.stateViewDelegates.get(str);
        return iStateViewDelegate == null ? this.stateViewDelegates.get(KEY_DEFAULT_STATE_VIEW_CREATOR) : iStateViewDelegate;
    }

    public final void register(@NotNull String str, @NotNull IStateViewDelegate iStateViewDelegate) {
        b41.i(str, "pageName");
        b41.i(iStateViewDelegate, "stateViewDelegate");
        this.stateViewDelegates.put(str, iStateViewDelegate);
    }

    public final void register(@NotNull IStateViewDelegate iStateViewDelegate) {
        b41.i(iStateViewDelegate, "stateViewDelegate");
        this.stateViewDelegates.put(KEY_DEFAULT_STATE_VIEW_CREATOR, iStateViewDelegate);
    }
}
