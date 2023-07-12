package com.alient.onearch.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.responsive.page.IResponsivePage;
import com.alibaba.pictures.ut.DogCat;
import com.alibaba.pictures.ut.IUTPageOperation;
import com.alibaba.pictures.ut.MovieShowUTHelper;
import com.alient.gaiax.container.component.GaiaxComponentCreator;
import com.alient.gaiax.container.config.GaiaxViewTypeConfigCreator;
import com.alient.onearch.adapter.component.footer.ComponentFooterDelegateManager;
import com.alient.onearch.adapter.delegate.OneArchAlarmDelegate;
import com.alient.onearch.adapter.event.IEventFeature;
import com.alient.onearch.adapter.loader.v2.GenericPagerLoader;
import com.alient.onearch.adapter.monitor.CMSRenderMonitorPoint;
import com.alient.onearch.adapter.monitor.MonitorConstant;
import com.alient.onearch.adapter.parser.component.BasicComponentParser;
import com.alient.onearch.adapter.parser.item.BasicItemParser;
import com.alient.onearch.adapter.parser.model.BasicModelParser;
import com.alient.onearch.adapter.parser.module.BasicModuleParser;
import com.alient.onearch.adapter.responsive.util.ResponsiveLayoutDataUtil;
import com.alient.onearch.adapter.state.StateViewManager;
import com.alient.onearch.adapter.util.RecyclerViewUtil;
import com.alient.oneservice.ut.TrackInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.taobao.login4android.constants.LoginConstants;
import com.taobao.weex.bridge.WXBridgeManager;
import com.uc.webview.export.media.MessageID;
import com.ut.mini.UTAnalytics;
import com.youku.arch.v3.IComponent;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.IModule;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.adapter.VBaseAdapter;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.adapter.ViewTypeSupport;
import com.youku.arch.v3.core.ComponentValue;
import com.youku.arch.v3.core.ConfigManager;
import com.youku.arch.v3.core.EventDispatcher;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.core.ModuleValue;
import com.youku.arch.v3.core.Node;
import com.youku.arch.v3.core.PageContext;
import com.youku.arch.v3.core.TypeRange;
import com.youku.arch.v3.creator.ComponentCreatorManager;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.data.Repository;
import com.youku.arch.v3.event.FragmentEvent;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IRequest;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.io.RequestBuilder;
import com.youku.arch.v3.page.GenericFragment;
import com.youku.arch.v3.page.IDelegate;
import com.youku.arch.v3.page.RecycleViewSettings;
import com.youku.arch.v3.page.state.IStateView;
import com.youku.arch.v3.page.state.OnCreateStateViewListener;
import com.youku.arch.v3.page.state.State;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import com.youku.kubus.Event;
import com.youku.kubus.Subscribe;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.e32;
import tb.k50;
import tb.ss2;
import tb.u22;
import tb.wt2;
import tb.ys2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 Ç\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004Ç\u0001È\u0001B\t¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J \u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\u0012\u0010\u001e\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\"\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\fH\u0016J\u0010\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020\fH\u0016J\u0010\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u001cH\u0016J\u0012\u0010*\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010-\u001a\u00020\f2\u0006\u0010,\u001a\u00020+H\u0016J\"\u00100\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020+H\u0016J*\u00108\u001a\u00020\f2\f\u00103\u001a\b\u0012\u0004\u0012\u000202012\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060504H\u0014J*\u0010:\u001a\u00020\f2\f\u00109\u001a\b\u0012\u0004\u0012\u000206052\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060504H\u0014J\u000e\u0010;\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010<\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010>\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010=\u001a\u00020\nH\u0016J\b\u0010?\u001a\u00020+H\u0016J\u0010\u0010C\u001a\u00020B2\u0006\u0010A\u001a\u00020@H\u0014J\"\u0010H\u001a\u0004\u0018\u00010G2\u0016\b\u0002\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020E\u0018\u00010DH$J\b\u0010I\u001a\u00020\fH\u0014J\b\u0010J\u001a\u00020\fH\u0014J\u0010\u0010M\u001a\u00020L2\u0006\u0010K\u001a\u00020BH\u0016J\b\u0010N\u001a\u00020\fH\u0014J&\u0010P\u001a\u00020\f2\u0006\u0010O\u001a\u00020\n2\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020E\u0018\u00010DH\u0016J&\u0010Q\u001a\u00020\f2\u0006\u0010O\u001a\u00020\n2\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020E\u0018\u00010DH\u0016J&\u0010R\u001a\u00020\f2\u0006\u0010O\u001a\u00020\n2\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020E\u0018\u00010DH\u0016J,\u0010U\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010S\u0018\u0001042\u0014\u0010T\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010S\u0018\u000104H\u0016J\b\u0010V\u001a\u0004\u0018\u00010\nJ\b\u0010W\u001a\u0004\u0018\u00010\nJ/\u0010[\u001a\u00020\f2\b\u0010X\u001a\u0004\u0018\u00010\n2\u0016\u0010Z\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0Y\"\u0004\u0018\u00010\n¢\u0006\u0004\b[\u0010\\J\u0012\u0010^\u001a\u0004\u0018\u00010\n2\b\u0010]\u001a\u0004\u0018\u00010\nJ\u000e\u0010`\u001a\u00020\f2\u0006\u0010_\u001a\u00020+J\u0010\u0010b\u001a\u00020\f2\b\u0010a\u001a\u0004\u0018\u00010\nJ\u0010\u0010e\u001a\u00020\f2\b\u0010d\u001a\u0004\u0018\u00010cJ\u0010\u0010g\u001a\u00020\f2\b\u0010f\u001a\u0004\u0018\u00010\nJ\u0010\u0010j\u001a\u00020\f2\b\u0010i\u001a\u0004\u0018\u00010hJ\b\u0010k\u001a\u00020+H\u0016J\n\u0010l\u001a\u0004\u0018\u00010hH\u0016J\u0016\u0010n\u001a\u00020\f2\u0006\u0010]\u001a\u00020\n2\u0006\u0010m\u001a\u00020\nJ\u0018\u0010r\u001a\u00020\f2\u0006\u0010o\u001a\u00020\u00182\b\b\u0002\u0010q\u001a\u00020pJ\u001c\u0010w\u001a\u00020\u00182\u0006\u0010t\u001a\u00020s2\n\u0010v\u001a\u0006\u0012\u0002\b\u00030uH\u0016J\b\u0010x\u001a\u00020\fH\u0016J\u0012\u0010|\u001a\u0004\u0018\u00010{2\u0006\u0010z\u001a\u00020yH\u0016J\u0012\u0010\u007f\u001a\u00020\f2\b\u0010~\u001a\u0004\u0018\u00010}H\u0014J\t\u0010\u0080\u0001\u001a\u00020\fH\u0016J\u0013\u0010\u0083\u0001\u001a\u00020\f2\b\u0010\u0082\u0001\u001a\u00030\u0081\u0001H\u0007J\u0011\u0010\u0086\u0001\u001a\u00020\f2\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001J\t\u0010\u0087\u0001\u001a\u00020\fH\u0016J\u0016\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0088\u00012\b\u0010d\u001a\u0004\u0018\u00010cH\u0016J\u0016\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0088\u00012\b\u0010d\u001a\u0004\u0018\u00010cH\u0016J'\u0010\u008d\u0001\u001a\u00020\f2\b\u0010d\u001a\u0004\u0018\u00010c2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\n2\u0007\u0010\u008c\u0001\u001a\u00020+H\u0016J\u0013\u0010\u008e\u0001\u001a\u00020\f2\b\u0010d\u001a\u0004\u0018\u00010cH\u0016J5\u0010\u0092\u0001\u001a\u00020\f2\b\u0010d\u001a\u0004\u0018\u00010c2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\n2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010\n2\n\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0090\u0001H\u0016J\u0013\u0010\u0093\u0001\u001a\u00020\f2\b\u0010d\u001a\u0004\u0018\u00010cH\u0016J\u0012\u0010\u0094\u0001\u001a\u00020\f2\u0007\u0010\u008b\u0001\u001a\u00020\nH\u0016J\u0013\u0010\u0095\u0001\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001e\u0010\u0095\u0001\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u001cH\u0016J\u001c\u0010\u0098\u0001\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0007\u0010\u0097\u0001\u001a\u00020\u0018H\u0016J'\u0010\u0098\u0001\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0007\u0010\u0097\u0001\u001a\u00020\u00182\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u001cH\u0016R\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0019\u0010\u009c\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001c\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R+\u0010¡\u0001\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0096\u000e¢\u0006\u0018\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R\u001f\u0010¨\u0001\u001a\u00030§\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b¨\u0001\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001R+\u0010¬\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¬\u0001\u0010\u00ad\u0001\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R+\u0010²\u0001\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b²\u0001\u0010\u00ad\u0001\u001a\u0006\b³\u0001\u0010¯\u0001\"\u0006\b´\u0001\u0010±\u0001R,\u0010µ\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R,\u0010»\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b»\u0001\u0010¶\u0001\u001a\u0006\b¼\u0001\u0010¸\u0001\"\u0006\b½\u0001\u0010º\u0001R*\u0010¿\u0001\u001a\u00030¾\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b¿\u0001\u0010À\u0001\u001a\u0006\bÁ\u0001\u0010Â\u0001\"\u0006\bÃ\u0001\u0010Ä\u0001¨\u0006É\u0001"}, d2 = {"Lcom/alient/onearch/adapter/BaseFragment;", "Lcom/youku/arch/v3/page/GenericFragment;", "Lcom/alient/onearch/adapter/event/IEventFeature;", "Lcom/alibaba/pictures/responsive/page/IResponsivePage;", "Lcom/alibaba/pictures/ut/IUTPageOperation;", "Lcom/alient/onearch/adapter/state/StateViewManager$IStateFeature;", "Lcom/alient/onearch/adapter/PageInfoBean;", "pageInfo", "Lcom/alient/onearch/adapter/PageRefreshCallBack;", "callBack", "", "pageSection", "Ltb/wt2;", "refreshBasePageInfo", "pageName", "Landroid/view/ViewGroup;", "parent", "Lcom/youku/arch/v3/page/state/State;", "state", "Lcom/youku/arch/v3/page/state/IStateView;", "createStateView", "Landroid/content/Intent;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "beforeStartActivity", "", "getLayoutResId", "getRecyclerViewResId", "getRefreshLayoutResId", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroid/view/View;", "view", "onViewCreated", "onResume", MessageID.onPause, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onDestroy", "outState", "onSaveInstanceState", "onViewStateRestored", "", "isVisible", "onFragmentVisibleChange", "responsiveLayoutState", "responsiveLayoutStateChanged", "onResponsiveLayout", "Lcom/youku/arch/v3/IModule;", "Lcom/youku/arch/v3/core/ModuleValue;", "module", "", "Lcom/youku/arch/v3/IComponent;", "Lcom/youku/arch/v3/core/ComponentValue;", "updatedComponents", "traverseModule", "component", "traversComponent", "refreshTopBasePageInfo", "refreshBottomBasePageInfo", "spmB", "updateUTPageNameFromRemote", "isUpdatePageNameFromRemote", "Lcom/youku/arch/v3/core/PageContext;", Constants.PAGE_CONTEXT, "Lcom/alient/onearch/adapter/GenericPageContainer;", "initPageContainer", "", "", "params", "Lcom/youku/arch/v3/io/RequestBuilder;", "createRequestBuilder", "initConfigManager", "initPageLoader", "container", "Lcom/alient/onearch/adapter/loader/v2/GenericPagerLoader;", "createPageLoader", "initPageStateManager", "type", "fireComponentEvent", "firePageEvent", "fireGlobalEvent", "Lcom/youku/arch/v3/page/IDelegate;", "delegateList", "wrapperDelegates", "getPageSPM", "getUTPageName", "controlName", "", "kvs", "onUTButtonClick", "(Ljava/lang/String;[Ljava/lang/String;)V", "key", "querySavedPageProperty", "enable", "setUTPageEnable", "spmPageName", "setUTPageName", "Landroid/app/Activity;", "activity", "startExpoTrack", "spm", "updateSPM", "Ljava/util/Properties;", "properties", "updateUTPageProperties", "enableUTReport", "getUTPageData", "value", "addUTPageParams", OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, "", "millisecondsPerInch", "scrollToComponent", "Lcom/alibaba/android/vlayout/DelegateAdapter;", "delegateAdapter", "Lcom/alibaba/android/vlayout/DelegateAdapter$Adapter;", "innerAdapter", "getRealPositionForAdapter", "initRecycleViewSettings", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Lcom/alibaba/android/vlayout/VirtualLayoutManager;", "createLayoutManager", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "addRecyclerViewFeature", "initComponentFooterDelegate", "Lcom/youku/kubus/Event;", "event", "onFragmentLifecycle", "Lcom/youku/arch/v3/core/Node;", "pageNode", "updateABBucket", "updatePvStatics", "Lcom/scwang/smartrefresh/layout/api/RefreshInternal;", "createLoadingHeaderView", "createLoadingFooterView", "msg", "canCancel", "showLoadingDialog", "hideLoadingDialog", "code", "Lcom/alient/onearch/adapter/state/StateViewManager$IStateViewListener;", "listener", "showErrorView", "hideErrorView", LoginConstants.SHOW_TOAST, "startActivity", WXBridgeManager.OPTIONS, "requestCode", "startActivityForResult", "Landroid/os/Handler;", "responsiveHandler", "Landroid/os/Handler;", "isDisplayed", "Z", "Lcom/alibaba/pictures/ut/MovieShowUTHelper;", "utHelper", "Lcom/alibaba/pictures/ut/MovieShowUTHelper;", "utPageName", "Ljava/lang/String;", "getUtPageName", "()Ljava/lang/String;", "setUtPageName", "(Ljava/lang/String;)V", "Lcom/alient/oneservice/ut/TrackInfo;", "trackInfo", "Lcom/alient/oneservice/ut/TrackInfo;", "getTrackInfo", "()Lcom/alient/oneservice/ut/TrackInfo;", "topBasePageInfo", "Lcom/alient/onearch/adapter/PageInfoBean;", "getTopBasePageInfo", "()Lcom/alient/onearch/adapter/PageInfoBean;", "setTopBasePageInfo", "(Lcom/alient/onearch/adapter/PageInfoBean;)V", "bottomBasePageInfo", "getBottomBasePageInfo", "setBottomBasePageInfo", "refreshHeader", "Lcom/scwang/smartrefresh/layout/api/RefreshInternal;", "getRefreshHeader", "()Lcom/scwang/smartrefresh/layout/api/RefreshInternal;", "setRefreshHeader", "(Lcom/scwang/smartrefresh/layout/api/RefreshInternal;)V", "refreshFooter", "getRefreshFooter", "setRefreshFooter", "Ltb/u22;", "responsiveFragmentStateManager", "Ltb/u22;", "getResponsiveFragmentStateManager", "()Ltb/u22;", "setResponsiveFragmentStateManager", "(Ltb/u22;)V", "<init>", "()V", "Companion", "ResponsiveHandler", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public abstract class BaseFragment extends GenericFragment implements IResponsivePage, IUTPageOperation, IEventFeature, StateViewManager.IStateFeature {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int RECOVER_ITEM_ANIMATOR_MSG = 1024;
    @Nullable
    private PageInfoBean bottomBasePageInfo;
    private boolean isDisplayed;
    @Nullable
    private RefreshInternal refreshFooter;
    @Nullable
    private RefreshInternal refreshHeader;
    public u22 responsiveFragmentStateManager;
    @Nullable
    private Handler responsiveHandler;
    @Nullable
    private PageInfoBean topBasePageInfo;
    @NotNull
    private final TrackInfo trackInfo;
    @Nullable
    private MovieShowUTHelper utHelper;
    @Nullable
    private String utPageName;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/alient/onearch/adapter/BaseFragment$Companion;", "", "", "RECOVER_ITEM_ANIMATOR_MSG", "I", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R(\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/alient/onearch/adapter/BaseFragment$ResponsiveHandler;", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "Ltb/wt2;", "handleMessage", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewRef", "Ljava/lang/ref/WeakReference;", "getRecyclerViewRef", "()Ljava/lang/ref/WeakReference;", "setRecyclerViewRef", "(Ljava/lang/ref/WeakReference;)V", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "itemAnimatorRef", "getItemAnimatorRef", "setItemAnimatorRef", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    private static final class ResponsiveHandler extends Handler {
        @NotNull
        private WeakReference<RecyclerView.ItemAnimator> itemAnimatorRef;
        @NotNull
        private WeakReference<RecyclerView> recyclerViewRef;

        public ResponsiveHandler(@NotNull RecyclerView recyclerView) {
            b41.i(recyclerView, "recyclerView");
            this.recyclerViewRef = new WeakReference<>(recyclerView);
            this.itemAnimatorRef = new WeakReference<>(recyclerView.getItemAnimator());
        }

        @NotNull
        public final WeakReference<RecyclerView.ItemAnimator> getItemAnimatorRef() {
            return this.itemAnimatorRef;
        }

        @NotNull
        public final WeakReference<RecyclerView> getRecyclerViewRef() {
            return this.recyclerViewRef;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message message) {
            b41.i(message, "msg");
            RecyclerView recyclerView = this.recyclerViewRef.get();
            if (recyclerView == null) {
                return;
            }
            recyclerView.setItemAnimator(this.itemAnimatorRef.get());
        }

        public final void setItemAnimatorRef(@NotNull WeakReference<RecyclerView.ItemAnimator> weakReference) {
            b41.i(weakReference, "<set-?>");
            this.itemAnimatorRef = weakReference;
        }

        public final void setRecyclerViewRef(@NotNull WeakReference<RecyclerView> weakReference) {
            b41.i(weakReference, "<set-?>");
            this.recyclerViewRef = weakReference;
        }
    }

    public BaseFragment() {
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.setArgs(new HashMap<>());
        wt2 wt2Var = wt2.INSTANCE;
        this.trackInfo = trackInfo;
        initComponentFooterDelegate();
    }

    private final void beforeStartActivity(Intent intent) {
        FragmentActivity activity;
        if (intent == null || intent.hasExtra(ss2.UT_CONST_SQM) || (activity = getActivity()) == null || !activity.getIntent().hasExtra(ss2.UT_CONST_SQM)) {
            return;
        }
        intent.putExtra(ss2.UT_CONST_SQM, activity.getIntent().getStringExtra(ss2.UT_CONST_SQM));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RequestBuilder createRequestBuilder$default(BaseFragment baseFragment, Map map, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                map = null;
            }
            return baseFragment.createRequestBuilder(map);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createRequestBuilder");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IStateView createStateView(String str, ViewGroup viewGroup, State state) {
        StateViewManager.IStateViewDelegate stateViewDelegate = StateViewManager.Companion.getInstance().getStateViewDelegate(str);
        if (getContext() == null || stateViewDelegate == null) {
            return null;
        }
        Context requireContext = requireContext();
        b41.h(requireContext, "requireContext()");
        return stateViewDelegate.createStateView(requireContext, viewGroup, state, new StateViewManager.IStateViewListener() { // from class: com.alient.onearch.adapter.BaseFragment$createStateView$1
            @Override // com.alient.onearch.adapter.state.StateViewManager.IStateViewListener
            public void onRefreshClick() {
                BaseFragment.this.getPageContainer().reload();
            }

            @Override // com.alient.onearch.adapter.state.StateViewManager.IStateViewListener
            public void onReportClick() {
            }
        });
    }

    private final void refreshBasePageInfo(PageInfoBean pageInfoBean, final PageRefreshCallBack pageRefreshCallBack, final String str) {
        final IRequest build;
        String str2 = pageInfoBean.layerId;
        boolean z = false;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        String str3 = pageInfoBean.sectionId;
        if ((str3 == null || str3.length() == 0) ? true : true) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str4 = pageInfoBean.layerId;
        b41.h(str4, "pageInfo.layerId");
        linkedHashMap.put("layerId", str4);
        String str5 = pageInfoBean.sectionId;
        b41.h(str5, "pageInfo.sectionId");
        linkedHashMap.put("sectionId", str5);
        linkedHashMap.put("strategy", 2L);
        RequestBuilder createRequestBuilder$default = createRequestBuilder$default(this, null, 1, null);
        if (createRequestBuilder$default == null || (build = createRequestBuilder$default.build(linkedHashMap)) == null) {
            return;
        }
        getPageContext().runOnLoaderThread(new Function0<wt2>() { // from class: com.alient.onearch.adapter.BaseFragment$refreshBasePageInfo$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Repository companion = Repository.Companion.getInstance();
                IRequest iRequest = IRequest.this;
                final String str6 = str;
                final PageRefreshCallBack pageRefreshCallBack2 = pageRefreshCallBack;
                companion.request(iRequest, new Callback() { // from class: com.alient.onearch.adapter.BaseFragment$refreshBasePageInfo$1$1.1
                    @Override // com.youku.arch.v3.io.Callback
                    public void onResponse(@NotNull IResponse iResponse) {
                        JSONObject jSONObject;
                        JSONObject jSONObject2;
                        JSONObject jSONObject3;
                        b41.i(iResponse, "response");
                        JSONObject jsonObject = iResponse.getJsonObject();
                        if (jsonObject == null || (jSONObject = jsonObject.getJSONObject("data")) == null || (jSONObject2 = jSONObject.getJSONObject("data")) == null || (jSONObject3 = jSONObject2.getJSONObject(str6)) == null) {
                            return;
                        }
                        pageRefreshCallBack2.onCallBack(jSONObject3);
                    }
                });
            }
        });
    }

    public static /* synthetic */ void scrollToComponent$default(BaseFragment baseFragment, int i, float f, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToComponent");
        }
        if ((i2 & 2) != 0) {
            f = 50.0f;
        }
        baseFragment.scrollToComponent(i, f);
    }

    protected void addRecyclerViewFeature(@Nullable RecyclerView recyclerView) {
    }

    public final void addUTPageParams(@NotNull String str, @NotNull String str2) {
        b41.i(str, "key");
        b41.i(str2, "value");
        HashMap<String, String> args = this.trackInfo.getArgs();
        b41.h(args, "trackInfo.args");
        args.put(str, str2);
    }

    @Nullable
    public VirtualLayoutManager createLayoutManager(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        GenericVirtualLayoutManager genericVirtualLayoutManager = new GenericVirtualLayoutManager(context);
        genericVirtualLayoutManager.setItemPrefetchEnabled(true);
        genericVirtualLayoutManager.setInitialPrefetchItemCount(5);
        return genericVirtualLayoutManager;
    }

    @Nullable
    public RefreshInternal createLoadingFooterView(@Nullable Activity activity) {
        StateViewManager.IStateViewDelegate stateViewDelegate;
        String pageName = getPageName();
        if (pageName == null || (stateViewDelegate = StateViewManager.Companion.getInstance().getStateViewDelegate(pageName)) == null) {
            return null;
        }
        return stateViewDelegate.createLoadingFooterView(activity);
    }

    @Nullable
    public RefreshInternal createLoadingHeaderView(@Nullable Activity activity) {
        StateViewManager.IStateViewDelegate stateViewDelegate;
        String pageName = getPageName();
        if (pageName == null || (stateViewDelegate = StateViewManager.Companion.getInstance().getStateViewDelegate(pageName)) == null) {
            return null;
        }
        return stateViewDelegate.createLoadingHeaderView(activity);
    }

    @NotNull
    public GenericPagerLoader createPageLoader(@NotNull GenericPageContainer genericPageContainer) {
        b41.i(genericPageContainer, "container");
        return new GenericPagerLoader(genericPageContainer);
    }

    @Nullable
    protected abstract RequestBuilder createRequestBuilder(@Nullable Map<String, ? extends Object> map);

    public boolean enableUTReport() {
        return false;
    }

    @Override // com.alient.onearch.adapter.event.IEventFeature
    public void fireComponentEvent(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        RecyclerView.Adapter adapter;
        b41.i(str, "type");
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null || (adapter = recyclerView.getAdapter()) == null) {
            return;
        }
        int i = 0;
        int itemCount = adapter.getItemCount();
        if (itemCount <= 0) {
            return;
        }
        while (true) {
            int i2 = i + 1;
            try {
                RecyclerView recyclerView2 = getRecyclerView();
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView2 == null ? null : recyclerView2.findViewHolderForAdapterPosition(i);
                VBaseHolder vBaseHolder = findViewHolderForAdapterPosition instanceof VBaseHolder ? (VBaseHolder) findViewHolderForAdapterPosition : null;
                if (vBaseHolder != null) {
                    vBaseHolder.onMessage(str, map);
                }
            } catch (Exception e) {
                if (AppInfoProviderProxy.isDebuggable()) {
                    throw e;
                }
            }
            if (i2 >= itemCount) {
                return;
            }
            i = i2;
        }
    }

    @Override // com.alient.onearch.adapter.event.IEventFeature
    public void fireGlobalEvent(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        b41.i(str, "type");
    }

    @Override // com.alient.onearch.adapter.event.IEventFeature
    public void firePageEvent(@NotNull String str, @Nullable Map<String, ? extends Object> map) {
        b41.i(str, "type");
        EventDispatcher eventDispatcher = getPageContext().getEventDispatcher();
        if (eventDispatcher == null) {
            return;
        }
        eventDispatcher.dispatchEvent(str, map);
    }

    @Nullable
    public final PageInfoBean getBottomBasePageInfo() {
        return this.bottomBasePageInfo;
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    protected int getLayoutResId() {
        return R.C4043layout.one_arch_fragment_layout;
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public final String getPageSPM() {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper == null) {
            return null;
        }
        return movieShowUTHelper.getPageSPM();
    }

    public int getRealPositionForAdapter(@NotNull DelegateAdapter delegateAdapter, @NotNull DelegateAdapter.Adapter<?> adapter) {
        b41.i(delegateAdapter, "delegateAdapter");
        b41.i(adapter, "innerAdapter");
        int itemCount = delegateAdapter.getItemCount();
        if (itemCount > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                Pair<DelegateAdapter.AdapterDataObserver, DelegateAdapter.Adapter> findAdapterByPosition = delegateAdapter.findAdapterByPosition(i);
                if (findAdapterByPosition != null && findAdapterByPosition.second == adapter) {
                    return i;
                }
                if (i2 >= itemCount) {
                    break;
                }
                i = i2;
            }
        }
        return -1;
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    protected int getRecyclerViewResId() {
        return R.id.one_arch_recyclerView;
    }

    @Nullable
    public final RefreshInternal getRefreshFooter() {
        return this.refreshFooter;
    }

    @Nullable
    public final RefreshInternal getRefreshHeader() {
        return this.refreshHeader;
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    protected int getRefreshLayoutResId() {
        return R.id.one_arch_refresh_layout;
    }

    @NotNull
    public final u22 getResponsiveFragmentStateManager() {
        u22 u22Var = this.responsiveFragmentStateManager;
        if (u22Var != null) {
            return u22Var;
        }
        b41.A("responsiveFragmentStateManager");
        return null;
    }

    @Nullable
    public final PageInfoBean getTopBasePageInfo() {
        return this.topBasePageInfo;
    }

    @NotNull
    public final TrackInfo getTrackInfo() {
        return this.trackInfo;
    }

    @Nullable
    public Properties getUTPageData() {
        return null;
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public final String getUTPageName() {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper == null) {
            return null;
        }
        return movieShowUTHelper.getUTPageName();
    }

    @Nullable
    public String getUtPageName() {
        return this.utPageName;
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void hideErrorView(@Nullable Activity activity) {
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void hideLoadingDialog(@Nullable Activity activity) {
        StateViewManager.IStateViewDelegate stateViewDelegate;
        String pageName = getPageName();
        if (pageName == null || (stateViewDelegate = StateViewManager.Companion.getInstance().getStateViewDelegate(pageName)) == null) {
            return;
        }
        stateViewDelegate.hideLoadingDialog(activity);
    }

    public void initComponentFooterDelegate() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    public void initConfigManager() {
        ConfigManager configManager = new ConfigManager();
        configManager.getParserConfig(0).addParser(0, new BasicModelParser());
        configManager.getParserConfig(1).addParser(0, new BasicModuleParser());
        configManager.getParserConfig(2).addParser(0, new BasicComponentParser());
        configManager.getParserConfig(3).addParser(0, new BasicItemParser());
        getPageContext().setConfigManager(configManager);
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    protected void initPageLoader() {
        setPageLoader(createPageLoader((GenericPageContainer) getPageContainer()));
        getPageLoader().setCallback(this);
        getPageContainer().setPageLoader(getPageLoader());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    public void initPageStateManager() {
        super.initPageStateManager();
        final String pageName = getPageName();
        if (pageName == null) {
            return;
        }
        getPageStateManager().setStateProperty(State.LOADING, new OnCreateStateViewListener() { // from class: com.alient.onearch.adapter.BaseFragment$initPageStateManager$1$1
            @Override // com.youku.arch.v3.page.state.OnCreateStateViewListener
            @Nullable
            public IStateView onCreateStateView(@NotNull ViewGroup viewGroup, @NotNull State state) {
                IStateView createStateView;
                b41.i(viewGroup, "parent");
                b41.i(state, "state");
                createStateView = BaseFragment.this.createStateView(pageName, viewGroup, state);
                return createStateView;
            }
        });
        getPageStateManager().setStateProperty(State.FAILED, new OnCreateStateViewListener() { // from class: com.alient.onearch.adapter.BaseFragment$initPageStateManager$1$2
            @Override // com.youku.arch.v3.page.state.OnCreateStateViewListener
            @Nullable
            public IStateView onCreateStateView(@NotNull ViewGroup viewGroup, @NotNull State state) {
                IStateView createStateView;
                b41.i(viewGroup, "parent");
                b41.i(state, "state");
                createStateView = BaseFragment.this.createStateView(pageName, viewGroup, state);
                return createStateView;
            }
        });
        getPageStateManager().setStateProperty(State.NO_NETWORK, new OnCreateStateViewListener() { // from class: com.alient.onearch.adapter.BaseFragment$initPageStateManager$1$3
            @Override // com.youku.arch.v3.page.state.OnCreateStateViewListener
            @Nullable
            public IStateView onCreateStateView(@NotNull ViewGroup viewGroup, @NotNull State state) {
                IStateView createStateView;
                b41.i(viewGroup, "parent");
                b41.i(state, "state");
                createStateView = BaseFragment.this.createStateView(pageName, viewGroup, state);
                return createStateView;
            }
        });
        getPageStateManager().setStateProperty(State.NO_DATA, new OnCreateStateViewListener() { // from class: com.alient.onearch.adapter.BaseFragment$initPageStateManager$1$4
            @Override // com.youku.arch.v3.page.state.OnCreateStateViewListener
            @Nullable
            public IStateView onCreateStateView(@NotNull ViewGroup viewGroup, @NotNull State state) {
                IStateView createStateView;
                b41.i(viewGroup, "parent");
                b41.i(state, "state");
                createStateView = BaseFragment.this.createStateView(pageName, viewGroup, state);
                return createStateView;
            }
        });
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    public void initRecycleViewSettings() {
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null) {
            return;
        }
        RecycleViewSettings recycleViewSettings = getRecycleViewSettings();
        if (recycleViewSettings != null) {
            Context requireContext = requireContext();
            b41.h(requireContext, "requireContext()");
            recycleViewSettings.setLayoutManager(createLayoutManager(requireContext));
            recycleViewSettings.setAdapter(new ContentAdapter(recycleViewSettings.getLayoutManager(), true));
            recycleViewSettings.config(recyclerView);
        }
        recyclerView.setItemAnimator(null);
        addRecyclerViewFeature(recyclerView);
    }

    public boolean isUpdatePageNameFromRemote() {
        return true;
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        b41.i(configuration, "newConfig");
        getResponsiveFragmentStateManager().b(configuration);
        super.onConfigurationChanged(configuration);
        getResponsiveFragmentStateManager().c(configuration);
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (getPageContext().getComponentCreatorManager() != null) {
            ComponentCreatorManager componentCreatorManager = getPageContext().getComponentCreatorManager();
            b41.f(componentCreatorManager);
            componentCreatorManager.register(new TypeRange(9000, 9800), new GaiaxComponentCreator());
        }
        if (getPageContext().getViewTypeSupport() != null) {
            ViewTypeSupport viewTypeSupport = getPageContext().getViewTypeSupport();
            b41.f(viewTypeSupport);
            viewTypeSupport.registerViewTypeConfigCreator(new TypeRange(9000, 9800), new GaiaxViewTypeConfigCreator());
        }
        FragmentActivity requireActivity = requireActivity();
        b41.h(requireActivity, "requireActivity()");
        setResponsiveFragmentStateManager(new u22(requireActivity, this));
        if (enableUTReport()) {
            String utPageName = getUtPageName();
            if (utPageName == null || utPageName.length() == 0) {
                return;
            }
            MovieShowUTHelper movieShowUTHelper = new MovieShowUTHelper(this);
            movieShowUTHelper.setUTPageName(getUtPageName());
            movieShowUTHelper.setUTPageEnable(true);
            wt2 wt2Var = wt2.INSTANCE;
            this.utHelper = movieShowUTHelper;
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        ComponentFooterDelegateManager.Companion.getInstance().unregister(getPageContext().toString());
        Handler handler = this.responsiveHandler;
        if (handler != null) {
            handler.removeMessages(1024);
        }
        super.onDestroy();
    }

    @Subscribe(eventType = {FragmentEvent.ON_FRAGMENT_RESUME, FragmentEvent.ON_FRAGMENT_PAUSE, FragmentEvent.ON_FRAGMENT_START, FragmentEvent.ON_FRAGMENT_STOP, FragmentEvent.ON_FRAGMENT_CONFIGURATION_CHANGED, FragmentEvent.ON_FRAGMENT_DESTROY, FragmentEvent.ON_FRAGMENT_HIDDEN_CHANGED, FragmentEvent.ON_FRAGMENT_USER_VISIBLE_HINT})
    public final void onFragmentLifecycle(@NotNull Event event) {
        Map<String, ? extends Object> hashMap;
        b41.i(event, "event");
        Object obj = event.data;
        if (obj instanceof Map) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
            hashMap = (Map) obj;
        } else {
            hashMap = new HashMap<>();
        }
        String str = event.type;
        b41.h(str, "event.type");
        fireComponentEvent(str, hashMap);
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    public void onFragmentVisibleChange(boolean z) {
        super.onFragmentVisibleChange(z);
        if (enableUTReport()) {
            if (z) {
                this.isDisplayed = true;
                MovieShowUTHelper movieShowUTHelper = this.utHelper;
                if (movieShowUTHelper != null) {
                    movieShowUTHelper.setUTPageName(getUtPageName());
                }
                MovieShowUTHelper movieShowUTHelper2 = this.utHelper;
                if (movieShowUTHelper2 != null) {
                    movieShowUTHelper2.h();
                }
                updateUTPageProperties(getUTPageData());
                return;
            }
            MovieShowUTHelper movieShowUTHelper3 = this.utHelper;
            if (movieShowUTHelper3 == null) {
                return;
            }
            movieShowUTHelper3.i();
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isDisplayed = false;
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper == null) {
            return;
        }
        movieShowUTHelper.i();
    }

    @Override // com.alibaba.pictures.responsive.page.IResponsivePage
    public void onResponsiveLayout(@Nullable Configuration configuration, int i, boolean z) {
        e32.INSTANCE.b(getRecyclerView());
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        getPageContext().runOnLoaderThread(new Function0<wt2>() { // from class: com.alient.onearch.adapter.BaseFragment$onResponsiveLayout$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ wt2 invoke() {
                invoke2();
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ArrayList arrayList = new ArrayList();
                try {
                    List<IModule<ModuleValue>> modules = BaseFragment.this.getPageContainer().getModules();
                    BaseFragment baseFragment = BaseFragment.this;
                    for (IModule<ModuleValue> iModule : modules) {
                        baseFragment.traverseModule(iModule, arrayList);
                    }
                } catch (Exception e) {
                    if (AppInfoProviderProxy.isDebuggable()) {
                        throw e;
                    }
                }
                ResponsiveLayoutDataUtil.INSTANCE.notifyResponsiveLayoutAdapterChanged(BaseFragment.this.getPageContext(), arrayList);
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(2000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
            if (this.responsiveHandler == null) {
                this.responsiveHandler = new ResponsiveHandler(recyclerView);
            }
        }
        Handler handler = this.responsiveHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.responsiveHandler;
        if (handler2 == null) {
            return;
        }
        handler2.sendEmptyMessageDelayed(1024, 2000L);
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setFragmentVisible(getUserVisibleHint() && !isHidden());
        if (enableUTReport() && isFragmentVisible() && !this.isDisplayed) {
            this.isDisplayed = true;
            MovieShowUTHelper movieShowUTHelper = this.utHelper;
            if (movieShowUTHelper != null) {
                movieShowUTHelper.i();
            }
            MovieShowUTHelper movieShowUTHelper2 = this.utHelper;
            if (movieShowUTHelper2 != null) {
                movieShowUTHelper2.setUTPageName(getUtPageName());
            }
            MovieShowUTHelper movieShowUTHelper3 = this.utHelper;
            if (movieShowUTHelper3 != null) {
                movieShowUTHelper3.h();
            }
            updateUTPageProperties(getUTPageData());
        }
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        b41.i(bundle, "outState");
        try {
            if (getClass().getClassLoader() != null) {
                bundle.setClassLoader(getClass().getClassLoader());
            }
            super.onSaveInstanceState(bundle);
        } catch (Exception e) {
            CMSRenderMonitorPoint.Companion.commitCMSRenderMonitorFail(MonitorConstant.INSTANCE.getSAVE_STATE_DATA_ERROR(), "\"ErrorMsg:\" + e.message + \"---SuperInfo:\" + javaClass.superclass.name + \"---\" + \"Method: onSaveInstanceState\"", new LinkedHashMap());
            DogCat.INSTANCE.d().k("SaveStateError").p("ErrorMsg", e.getMessage(), "SuperInfo", getClass().getSuperclass().getName(), "Method", "onSaveInstanceState").j();
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void onUTButtonClick(@Nullable String str, @NotNull String... strArr) {
        b41.i(strArr, "kvs");
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper == null) {
            return;
        }
        movieShowUTHelper.onUTButtonClick(str, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        b41.i(view, "view");
        super.onViewCreated(view, bundle);
        RefreshInternal createLoadingHeaderView = createLoadingHeaderView(getActivity());
        RefreshInternal refreshInternal = null;
        if (createLoadingHeaderView == null) {
            createLoadingHeaderView = null;
        } else {
            View view2 = createLoadingHeaderView instanceof View ? (View) createLoadingHeaderView : null;
            if (view2 != null) {
                view2.setId(R.id.one_arch_header);
            }
            RefreshLayout refreshLayout = getRefreshLayout();
            if (refreshLayout != null) {
                refreshLayout.setRefreshHeader((RefreshHeader) createLoadingHeaderView);
            }
            wt2 wt2Var = wt2.INSTANCE;
        }
        this.refreshHeader = createLoadingHeaderView;
        RefreshInternal createLoadingFooterView = createLoadingFooterView(getActivity());
        if (createLoadingFooterView != null) {
            View view3 = createLoadingFooterView instanceof View ? (View) createLoadingFooterView : null;
            if (view3 != null) {
                view3.setId(R.id.one_arch_footer);
            }
            RefreshLayout refreshLayout2 = getRefreshLayout();
            if (refreshLayout2 != null) {
                refreshLayout2.setRefreshFooter((RefreshFooter) createLoadingFooterView);
            }
            RefreshLayout refreshLayout3 = getRefreshLayout();
            if (refreshLayout3 != null) {
                refreshLayout3.setEnableLoadMore(false);
            }
            wt2 wt2Var2 = wt2.INSTANCE;
            refreshInternal = createLoadingFooterView;
        }
        this.refreshFooter = refreshInternal;
    }

    @Override // com.youku.arch.v3.page.GenericFragment, androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        if (bundle != null) {
            try {
                if (getClass().getClassLoader() != null) {
                    bundle.setClassLoader(getClass().getClassLoader());
                }
            } catch (Exception e) {
                CMSRenderMonitorPoint.Companion.commitCMSRenderMonitorFail(MonitorConstant.INSTANCE.getSAVE_STATE_DATA_ERROR(), "\"ErrorMsg:\" + e.message + \"---SuperInfo:\" + javaClass.superclass.name + \"---\" + \"Method: onViewStateRestored\"\n", new LinkedHashMap());
                DogCat.INSTANCE.d().k("SaveStateError").p("ErrorMsg", e.getMessage(), "SuperInfo", getClass().getSuperclass().getName(), "Method", "onViewStateRestored").j();
                return;
            }
        }
        super.onViewStateRestored(bundle);
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    @Nullable
    public final String querySavedPageProperty(@Nullable String str) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper == null) {
            return null;
        }
        return movieShowUTHelper.querySavedPageProperty(str);
    }

    public final void refreshBottomBasePageInfo(@NotNull PageRefreshCallBack pageRefreshCallBack) {
        b41.i(pageRefreshCallBack, "callBack");
        PageInfoBean pageInfoBean = this.bottomBasePageInfo;
        if (pageInfoBean == null) {
            return;
        }
        refreshBasePageInfo(pageInfoBean, pageRefreshCallBack, "bottom");
    }

    public final void refreshTopBasePageInfo(@NotNull PageRefreshCallBack pageRefreshCallBack) {
        b41.i(pageRefreshCallBack, "callBack");
        PageInfoBean pageInfoBean = this.topBasePageInfo;
        if (pageInfoBean == null) {
            return;
        }
        refreshBasePageInfo(pageInfoBean, pageRefreshCallBack, "top");
    }

    public final void scrollToComponent(int i, float f) {
        int realPositionForAdapter;
        if (getActivity() == null || getRecyclerView() == null) {
            return;
        }
        Iterator<T> it = getPageContainer().getCurrentModules().iterator();
        while (it.hasNext()) {
            Iterator<T> it2 = ((IModule) it.next()).getComponents().iterator();
            while (true) {
                if (it2.hasNext()) {
                    IComponent iComponent = (IComponent) it2.next();
                    if (iComponent.getType() == i) {
                        VBaseAdapter<IItem<ItemValue>, VBaseHolder<IItem<ItemValue>, GenericRenderConfig>> adapter = iComponent.getAdapter();
                        if (adapter != null && (realPositionForAdapter = getRealPositionForAdapter(getPageContainer().getContentAdapter(), adapter)) > 0) {
                            RecyclerViewUtil recyclerViewUtil = RecyclerViewUtil.INSTANCE;
                            FragmentActivity activity = getActivity();
                            RecyclerView recyclerView = getRecyclerView();
                            b41.f(recyclerView);
                            recyclerViewUtil.smoothScrollToPositionSpeed(activity, recyclerView, realPositionForAdapter, f);
                        }
                    }
                }
            }
        }
    }

    public final void setBottomBasePageInfo(@Nullable PageInfoBean pageInfoBean) {
        this.bottomBasePageInfo = pageInfoBean;
    }

    public final void setRefreshFooter(@Nullable RefreshInternal refreshInternal) {
        this.refreshFooter = refreshInternal;
    }

    public final void setRefreshHeader(@Nullable RefreshInternal refreshInternal) {
        this.refreshHeader = refreshInternal;
    }

    public final void setResponsiveFragmentStateManager(@NotNull u22 u22Var) {
        b41.i(u22Var, "<set-?>");
        this.responsiveFragmentStateManager = u22Var;
    }

    public final void setTopBasePageInfo(@Nullable PageInfoBean pageInfoBean) {
        this.topBasePageInfo = pageInfoBean;
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void setUTPageEnable(boolean z) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper == null) {
            return;
        }
        movieShowUTHelper.setUTPageEnable(z);
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void setUTPageName(@Nullable String str) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper == null) {
            return;
        }
        movieShowUTHelper.setUTPageName(str);
    }

    public void setUtPageName(@Nullable String str) {
        this.utPageName = str;
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void showErrorView(@Nullable Activity activity, @Nullable String str, @Nullable String str2, @Nullable StateViewManager.IStateViewListener iStateViewListener) {
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void showLoadingDialog(@Nullable Activity activity, @Nullable String str, boolean z) {
        StateViewManager.IStateViewDelegate stateViewDelegate;
        String pageName = getPageName();
        if (pageName == null || (stateViewDelegate = StateViewManager.Companion.getInstance().getStateViewDelegate(pageName)) == null) {
            return;
        }
        stateViewDelegate.showLoadingDialog(activity, str, z);
    }

    @Override // com.alient.onearch.adapter.state.StateViewManager.IStateFeature
    public void showToast(@NotNull String str) {
        StateViewManager.IStateViewDelegate stateViewDelegate;
        b41.i(str, "msg");
        String pageName = getPageName();
        if (pageName == null || (stateViewDelegate = StateViewManager.Companion.getInstance().getStateViewDelegate(pageName)) == null) {
            return;
        }
        stateViewDelegate.showToast(str);
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivity(@Nullable Intent intent) {
        beforeStartActivity(intent);
        super.startActivity(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(@Nullable Intent intent, int i) {
        beforeStartActivity(intent);
        super.startActivityForResult(intent, i);
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void startExpoTrack(@Nullable Activity activity) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper == null) {
            return;
        }
        movieShowUTHelper.startExpoTrack(activity);
    }

    protected void traversComponent(@NotNull IComponent<ComponentValue> iComponent, @NotNull List<IComponent<ComponentValue>> list) {
        b41.i(iComponent, "component");
        b41.i(list, "updatedComponents");
        if (list.contains(iComponent)) {
            return;
        }
        list.add(iComponent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void traverseModule(@NotNull IModule<ModuleValue> iModule, @NotNull List<IComponent<ComponentValue>> list) {
        b41.i(iModule, "module");
        b41.i(list, "updatedComponents");
        for (IComponent<ComponentValue> iComponent : iModule.getComponents()) {
            traversComponent(iComponent, list);
        }
    }

    public final void updateABBucket(@NotNull Node node) {
        JSONObject data;
        String string;
        MovieShowUTHelper movieShowUTHelper;
        b41.i(node, "pageNode");
        if (!getUserVisibleHint() || (data = node.getData()) == null || (string = data.getString("pabBucket")) == null) {
            return;
        }
        if (!(string.length() > 0) || (movieShowUTHelper = this.utHelper) == null) {
            return;
        }
        Properties properties = new Properties();
        properties.put("ABTrackInfo", string);
        wt2 wt2Var = wt2.INSTANCE;
        movieShowUTHelper.updateUTPageProperties(properties);
    }

    @Override // com.youku.arch.v3.page.GenericFragment, com.youku.arch.v3.page.IStatics
    public void updatePvStatics() {
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void updateSPM(@Nullable String str) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper == null) {
            return;
        }
        movieShowUTHelper.updateSPM(str);
    }

    public void updateUTPageNameFromRemote(@NotNull String str, @NotNull String str2) {
        String r;
        b41.i(str, "pageName");
        b41.i(str2, "spmB");
        if (enableUTReport() && isUpdatePageNameFromRemote()) {
            ys2 ys2Var = ys2.INSTANCE;
            String e = ys2Var.e();
            if (e == null || e.length() == 0) {
                r = b41.r("Page_", str);
            } else {
                r = b41.r(ys2Var.e(), str);
            }
            UTAnalytics.getInstance().getDefaultTracker().updatePageName(getActivity(), r);
        }
    }

    @Override // com.alibaba.pictures.ut.IUTPageOperation
    public final void updateUTPageProperties(@Nullable Properties properties) {
        MovieShowUTHelper movieShowUTHelper = this.utHelper;
        if (movieShowUTHelper == null) {
            return;
        }
        movieShowUTHelper.updateUTPageProperties(properties);
    }

    @Override // com.youku.arch.v3.page.GenericFragment
    @Nullable
    public List<IDelegate<GenericFragment>> wrapperDelegates(@Nullable List<IDelegate<GenericFragment>> list) {
        List<IDelegate<GenericFragment>> wrapperDelegates = super.wrapperDelegates(list);
        if (wrapperDelegates == null) {
            wrapperDelegates = new ArrayList<>();
        }
        wrapperDelegates.add(new OneArchAlarmDelegate());
        return wrapperDelegates;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.arch.v3.page.GenericFragment
    @NotNull
    public GenericPageContainer initPageContainer(@NotNull PageContext pageContext) {
        b41.i(pageContext, Constants.PAGE_CONTEXT);
        GenericPageContainer genericPageContainer = new GenericPageContainer(pageContext);
        genericPageContainer.setRefreshThreshold(4);
        genericPageContainer.setRequestBuilder(createRequestBuilder(new HashMap()));
        return genericPageContainer;
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivity(@Nullable Intent intent, @Nullable Bundle bundle) {
        beforeStartActivity(intent);
        super.startActivity(intent, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(@Nullable Intent intent, int i, @Nullable Bundle bundle) {
        beforeStartActivity(intent);
        super.startActivityForResult(intent, i, bundle);
    }
}
