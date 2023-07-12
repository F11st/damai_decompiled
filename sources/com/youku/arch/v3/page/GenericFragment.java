package com.youku.arch.v3.page;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.sdk.m.x.d;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.uc.webview.export.media.MessageID;
import com.youku.arch.v3.IContainer;
import com.youku.arch.v3.adapter.ContentAdapter;
import com.youku.arch.v3.core.ActivityValue;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.PageContext;
import com.youku.arch.v3.event.FragmentEventPoster;
import com.youku.arch.v3.event.RefreshEvent;
import com.youku.arch.v3.io.Callback;
import com.youku.arch.v3.io.IResponse;
import com.youku.arch.v3.loader.LoadingViewManager;
import com.youku.arch.v3.loader.PageLoader;
import com.youku.arch.v3.loader.PagingLoader;
import com.youku.arch.v3.loader.RefreshLayoutManger;
import com.youku.arch.v3.page.DelegateConfigure;
import com.youku.arch.v3.page.state.PageStateManager;
import com.youku.arch.v3.page.state.State;
import com.youku.arch.v3.page.state.StateSuccessView;
import com.youku.arch.v3.style.Style;
import com.youku.arch.v3.style.StyleManager;
import com.youku.arch.v3.util.ArchMontior;
import com.youku.arch.v3.util.ArchMontiorManager;
import com.youku.arch.v3.util.LogUtil;
import com.youku.kubus.Event;
import com.youku.kubus.EventBus;
import com.youku.kubus.Subscribe;
import io.flutter.wpkbridge.WPKFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.a;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\t¢\u0006\u0006\bã\u0001\u0010ä\u0001J\u001e\u0010\t\u001a\u00020\b2\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0006\u0018\u00010\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\f\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\nH\u0014J\u0012\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0001H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0018\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J&\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010\u001e\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020!2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010%\u001a\u00020\bH\u0016J\b\u0010&\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020\bH\u0016J\b\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\bH\u0016J\b\u0010+\u001a\u00020\bH\u0016J\"\u00100\u001a\u00020\b2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u0010\u00102\u001a\u00020\b2\u0006\u00101\u001a\u00020\u000eH\u0016J\u0012\u00103\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u00106\u001a\u00020\b2\u0006\u00105\u001a\u000204H\u0016J\u0010\u00108\u001a\u00020\b2\u0006\u00107\u001a\u000204H\u0016J\u0010\u0010;\u001a\u00020\b2\u0006\u0010:\u001a\u000209H\u0016J\u0010\u0010=\u001a\u00020\b2\u0006\u0010<\u001a\u000204H\u0016J\u0010\u0010?\u001a\u00020\b2\u0006\u0010>\u001a\u000204H\u0016J-\u0010E\u001a\u00020\b2\u0006\u0010,\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020A0@2\u0006\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bE\u0010FJ\"\u0010K\u001a\u0004\u0018\u00010J2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020\nH\u0016J\"\u0010M\u001a\u0004\u0018\u00010L2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020\nH\u0016J\b\u0010N\u001a\u00020\bH\u0016J\u0010\u0010Q\u001a\u00020\b2\u0006\u0010P\u001a\u00020OH\u0016J\b\u0010R\u001a\u00020\bH\u0016J\u001c\u0010V\u001a\u00020\b2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020T0SH\u0016J\b\u0010W\u001a\u00020\bH\u0016J\b\u0010X\u001a\u00020\bH$J\b\u0010Y\u001a\u00020\bH\u0014J\u0016\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\\2\u0006\u0010[\u001a\u00020ZH$J\b\u0010_\u001a\u00020\bH\u0014J\u0012\u0010_\u001a\u00020\b2\b\u0010`\u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010c\u001a\u00020\b2\b\u0010b\u001a\u0004\u0018\u00010aH\u0014J\b\u0010d\u001a\u00020\bH&J\n\u0010e\u001a\u0004\u0018\u00010AH\u0016J\u0010\u0010g\u001a\u00020\b2\u0006\u0010f\u001a\u000204H\u0016J\u000e\u0010i\u001a\u00020\b2\u0006\u0010h\u001a\u000204J\u0014\u0010k\u001a\u0004\u0018\u00010!2\b\u0010j\u001a\u0004\u0018\u00010\u001fH\u0014J\u0014\u0010m\u001a\u0004\u0018\u00010!2\b\u0010l\u001a\u0004\u0018\u00010!H\u0014J\u0006\u0010n\u001a\u00020\bJ\u0006\u0010p\u001a\u00020oJ\u0016\u0010r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0006\u0018\u00010qH\u0016J\u001e\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00060q2\b\u0010s\u001a\u0004\u0018\u00010AH\u0016J,\u0010u\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0006\u0018\u00010q2\u0014\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0006\u0018\u00010qH\u0016J\u0010\u0010x\u001a\u00020\b2\u0006\u0010w\u001a\u00020vH\u0017J\u0010\u0010y\u001a\u00020\b2\u0006\u0010w\u001a\u00020vH\u0017J\u0010\u0010{\u001a\u00020\b2\u0006\u0010z\u001a\u000204H\u0016J\b\u0010}\u001a\u00020|H\u0016J\b\u0010~\u001a\u00020|H\u0016J\u000f\u0010\u0080\u0001\u001a\u00020\b2\u0006\u0010\u007f\u001a\u00020\nJ\u0013\u0010\u0083\u0001\u001a\u00020\b2\n\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u0001R/\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020]0\\8\u0016@\u0016X\u0096.¢\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R)\u0010\u008b\u0001\u001a\u00030\u008a\u00018\u0016@\u0016X\u0096.¢\u0006\u0017\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0005\bp\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R'\u0010[\u001a\u00020Z8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b[\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R,\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0095\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R5\u0010\u0007\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u0006\u0018\u00010q8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b\u0007\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R,\u0010¢\u0001\u001a\u0005\u0018\u00010¡\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¢\u0001\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R*\u0010©\u0001\u001a\u00030¨\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001\"\u0006\b\u00ad\u0001\u0010®\u0001R)\u0010b\u001a\u0004\u0018\u00010a8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bb\u0010¯\u0001\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R,\u0010µ\u0001\u001a\u0005\u0018\u00010´\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bµ\u0001\u0010¶\u0001\u001a\u0006\b·\u0001\u0010¸\u0001\"\u0006\b¹\u0001\u0010º\u0001R,\u0010¼\u0001\u001a\u0005\u0018\u00010»\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¼\u0001\u0010½\u0001\u001a\u0006\b¾\u0001\u0010¿\u0001\"\u0006\bÀ\u0001\u0010Á\u0001R2\u0010Ã\u0001\u001a\u0002042\u0007\u0010Â\u0001\u001a\u0002048\u0006@DX\u0086\u000e¢\u0006\u0018\n\u0006\bÃ\u0001\u0010Ä\u0001\u001a\u0006\bÃ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R/\u0010h\u001a\u0002042\u0007\u0010Â\u0001\u001a\u0002048\u0006@DX\u0086\u000e¢\u0006\u0016\n\u0005\bh\u0010Ä\u0001\u001a\u0005\bh\u0010Å\u0001\"\u0006\bÈ\u0001\u0010Ç\u0001R.\u0010É\u0001\u001a\u0004\u0018\u00010!2\t\u0010Â\u0001\u001a\u0004\u0018\u00010!8\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001R+\u0010Í\u0001\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÍ\u0001\u0010Ê\u0001\u001a\u0006\bÎ\u0001\u0010Ì\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R+\u0010Ñ\u0001\u001a\u0004\u0018\u00010O8\u0014@\u0014X\u0094\u000e¢\u0006\u0018\n\u0006\bÑ\u0001\u0010Ò\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\"\u0006\bÕ\u0001\u0010Ö\u0001R,\u0010Ø\u0001\u001a\u0005\u0018\u00010×\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bØ\u0001\u0010Ù\u0001\u001a\u0006\bÚ\u0001\u0010Û\u0001\"\u0006\bÜ\u0001\u0010Ý\u0001R\u0019\u0010à\u0001\u001a\u00020A8$@$X¤\u0004¢\u0006\b\u001a\u0006\bÞ\u0001\u0010ß\u0001R\u001b\u0010â\u0001\u001a\u0004\u0018\u00010A8$@$X¤\u0004¢\u0006\b\u001a\u0006\bá\u0001\u0010ß\u0001¨\u0006å\u0001"}, d2 = {"Lcom/youku/arch/v3/page/GenericFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/youku/arch/v3/io/Callback;", "Lcom/youku/arch/v3/page/IStatics;", "Ljava/io/Serializable;", "", "Lcom/youku/arch/v3/page/IDelegate;", "delegateList", "Ltb/wt2;", "unRegisterDelegates", "", "getLayoutResId", "getRecyclerViewResId", "getRefreshLayoutResId", "Landroid/os/Bundle;", "args", "setArguments", "childFragment", "onAttachFragment", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "onAttach", "savedInstanceState", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED, "onCreate", "Landroid/view/LayoutInflater;", "onGetLayoutInflater", "Landroid/util/AttributeSet;", TemplateDom.KEY_ATTRS, "onInflate", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onStart", "onResume", MessageID.onPause, MessageID.onStop, "onDestroyView", "onDestroy", "onDetach", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "outState", "onSaveInstanceState", "onViewStateRestored", "", "isInMultiWindowMode", "onMultiWindowModeChanged", "isInPictureInPictureMode", "onPictureInPictureModeChanged", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "hidden", "onHiddenChanged", "isVisibleToUser", "setUserVisibleHint", "", "", "permissions", "", WXModule.GRANT_RESULTS, "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "transit", "enter", "nextAnim", "Landroid/view/animation/Animation;", "onCreateAnimation", "Landroid/animation/Animator;", "onCreateAnimator", "onLowMemory", "Lcom/youku/arch/v3/io/IResponse;", "response", "onResponse", "updatePvStatics", "", "", com.youku.arch.v3.core.Constants.CONFIG, "load", "doRequest", "initConfigManager", "initPageLoader", "Lcom/youku/arch/v3/core/PageContext;", com.youku.arch.v3.data.Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/IContainer;", "Lcom/youku/arch/v3/core/ModelValue;", "initPageContainer", "initPageStateManager", "successView", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "refreshLayout", "initLoadingViewManager", "initRecycleViewSettings", "getDelegatePathPrefix", "isVisible", "onFragmentVisibleChange", "isSelected", "setPageSelected", "viewGroup", "getPreContentView", "contentView", "onContentViewInflated", "autoRefresh", "Lcom/youku/arch/v3/loader/PagingLoader;", "getPageLoader", "", "getDelegates", "pathPrefix", "initDelegates", "wrapperDelegates", "Lcom/youku/kubus/Event;", "event", "onLoadMore", d.p, DXRecyclerLayout.LOAD_MORE_NO_DATA_STRING, "setNoMore", "", "getLoadingFootHeight", "getNoMoreFootHeight", "color", "setFragmentBackGroundColor", "Landroid/graphics/drawable/Drawable;", "drawable", "setFragmentBackGroundDrawable", "pageContainer", "Lcom/youku/arch/v3/IContainer;", "getPageContainer", "()Lcom/youku/arch/v3/IContainer;", "setPageContainer", "(Lcom/youku/arch/v3/IContainer;)V", "Lcom/youku/arch/v3/loader/PageLoader;", "pageLoader", "Lcom/youku/arch/v3/loader/PageLoader;", "()Lcom/youku/arch/v3/loader/PageLoader;", "setPageLoader", "(Lcom/youku/arch/v3/loader/PageLoader;)V", "Lcom/youku/arch/v3/core/PageContext;", "getPageContext", "()Lcom/youku/arch/v3/core/PageContext;", "setPageContext", "(Lcom/youku/arch/v3/core/PageContext;)V", "Lcom/youku/arch/v3/core/IContext;", "attachBaseContext", "Lcom/youku/arch/v3/core/IContext;", "getAttachBaseContext", "()Lcom/youku/arch/v3/core/IContext;", "setAttachBaseContext", "(Lcom/youku/arch/v3/core/IContext;)V", "Ljava/util/List;", "getDelegateList", "()Ljava/util/List;", "setDelegateList", "(Ljava/util/List;)V", "Lcom/youku/arch/v3/page/FragmentInterceptor;", "fragmentInterceptor", "Lcom/youku/arch/v3/page/FragmentInterceptor;", "getFragmentInterceptor", "()Lcom/youku/arch/v3/page/FragmentInterceptor;", "setFragmentInterceptor", "(Lcom/youku/arch/v3/page/FragmentInterceptor;)V", "Lcom/youku/arch/v3/page/state/PageStateManager;", "pageStateManager", "Lcom/youku/arch/v3/page/state/PageStateManager;", "getPageStateManager", "()Lcom/youku/arch/v3/page/state/PageStateManager;", "setPageStateManager", "(Lcom/youku/arch/v3/page/state/PageStateManager;)V", "Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "getRefreshLayout", "()Lcom/scwang/smartrefresh/layout/api/RefreshLayout;", "setRefreshLayout", "(Lcom/scwang/smartrefresh/layout/api/RefreshLayout;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/youku/arch/v3/page/RecycleViewSettings;", "recycleViewSettings", "Lcom/youku/arch/v3/page/RecycleViewSettings;", "getRecycleViewSettings", "()Lcom/youku/arch/v3/page/RecycleViewSettings;", "setRecycleViewSettings", "(Lcom/youku/arch/v3/page/RecycleViewSettings;)V", "<set-?>", "isFragmentVisible", "Z", "()Z", "setFragmentVisible", "(Z)V", "setSelected", "rootView", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "realView", "getRealView", "setRealView", "(Landroid/view/View;)V", "initResponse", "Lcom/youku/arch/v3/io/IResponse;", "getInitResponse", "()Lcom/youku/arch/v3/io/IResponse;", "setInitResponse", "(Lcom/youku/arch/v3/io/IResponse;)V", "Lcom/youku/arch/v3/page/GenericFragmentPreloadDelegate;", "fragmentPreloadDelegate", "Lcom/youku/arch/v3/page/GenericFragmentPreloadDelegate;", "getFragmentPreloadDelegate", "()Lcom/youku/arch/v3/page/GenericFragmentPreloadDelegate;", "setFragmentPreloadDelegate", "(Lcom/youku/arch/v3/page/GenericFragmentPreloadDelegate;)V", "getConfigPath", "()Ljava/lang/String;", "configPath", "getPageName", "pageName", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class GenericFragment extends Fragment implements Callback, IStatics, Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private IContext attachBaseContext;
    @Nullable
    private List<IDelegate<GenericFragment>> delegateList;
    @Nullable
    private FragmentInterceptor fragmentInterceptor;
    @Nullable
    private GenericFragmentPreloadDelegate fragmentPreloadDelegate;
    @Nullable
    private IResponse initResponse;
    private boolean isFragmentVisible;
    private boolean isSelected;
    public IContainer<ModelValue> pageContainer;
    @NotNull
    private PageContext pageContext;
    public PageLoader pageLoader;
    public PageStateManager pageStateManager;
    @Nullable
    private View realView;
    @Nullable
    private RecycleViewSettings recycleViewSettings;
    @Nullable
    private RecyclerView recyclerView;
    @Nullable
    private RefreshLayout refreshLayout;
    @Nullable
    private View rootView;

    public GenericFragment() {
        PageContext pageContext = new PageContext();
        this.pageContext = pageContext;
        EventBus eventBus = pageContext.getEventBus();
        if (eventBus == null) {
            return;
        }
        setFragmentInterceptor(new FragmentEventPoster(eventBus));
    }

    private final void unRegisterDelegates(List<? extends IDelegate<GenericFragment>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1417905056")) {
            ipChange.ipc$dispatch("-1417905056", new Object[]{this, list});
        } else if (list == null) {
        } else {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                IDelegate iDelegate = (IDelegate) it.next();
                EventBus eventBus = getPageContext().getEventBus();
                if (eventBus != null) {
                    eventBus.unregister(iDelegate);
                }
            }
        }
    }

    public final void autoRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1355013227")) {
            ipChange.ipc$dispatch("-1355013227", new Object[]{this});
            return;
        }
        RefreshLayout refreshLayout = this.refreshLayout;
        if (refreshLayout == null) {
            return;
        }
        refreshLayout.autoRefresh();
    }

    public void doRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1592687043")) {
            ipChange.ipc$dispatch("-1592687043", new Object[]{this});
            return;
        }
        LogUtil.d("OneArch.GenericFragment", "doRequest");
        IResponse initResponse = getInitResponse();
        IResponse iResponse = null;
        if (!(initResponse != null)) {
            initResponse = null;
        }
        if (initResponse != null) {
            getPageLoader().handleLoadSuccess(initResponse, 1);
            setInitResponse(null);
            iResponse = initResponse;
        }
        if (iResponse == null) {
            getPageLoader().refreshLoad();
            setNoMore(false);
        }
    }

    @Nullable
    public final IContext getAttachBaseContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "411882862") ? (IContext) ipChange.ipc$dispatch("411882862", new Object[]{this}) : this.attachBaseContext;
    }

    @NotNull
    protected abstract String getConfigPath();

    @Nullable
    public final List<IDelegate<GenericFragment>> getDelegateList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "43179743") ? (List) ipChange.ipc$dispatch("43179743", new Object[]{this}) : this.delegateList;
    }

    @Nullable
    public String getDelegatePathPrefix() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1946931185")) {
            return (String) ipChange.ipc$dispatch("1946931185", new Object[]{this});
        }
        return null;
    }

    @Nullable
    public List<IDelegate<GenericFragment>> getDelegates() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-673970474")) {
            return (List) ipChange.ipc$dispatch("-673970474", new Object[]{this});
        }
        return null;
    }

    @Nullable
    public final FragmentInterceptor getFragmentInterceptor() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1515955769") ? (FragmentInterceptor) ipChange.ipc$dispatch("1515955769", new Object[]{this}) : this.fragmentInterceptor;
    }

    @Nullable
    public final GenericFragmentPreloadDelegate getFragmentPreloadDelegate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1722977880") ? (GenericFragmentPreloadDelegate) ipChange.ipc$dispatch("1722977880", new Object[]{this}) : this.fragmentPreloadDelegate;
    }

    @Nullable
    protected IResponse getInitResponse() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1654232989") ? (IResponse) ipChange.ipc$dispatch("1654232989", new Object[]{this}) : this.initResponse;
    }

    protected int getLayoutResId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "209636513")) {
            return ((Integer) ipChange.ipc$dispatch("209636513", new Object[]{this})).intValue();
        }
        return -1;
    }

    public float getLoadingFootHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1220385698")) {
            return ((Float) ipChange.ipc$dispatch("-1220385698", new Object[]{this})).floatValue();
        }
        return 53.0f;
    }

    public float getNoMoreFootHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1167251856")) {
            return ((Float) ipChange.ipc$dispatch("1167251856", new Object[]{this})).floatValue();
        }
        return 63.0f;
    }

    @NotNull
    public IContainer<ModelValue> getPageContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923453747")) {
            return (IContainer) ipChange.ipc$dispatch("923453747", new Object[]{this});
        }
        IContainer<ModelValue> iContainer = this.pageContainer;
        if (iContainer != null) {
            return iContainer;
        }
        b41.A("pageContainer");
        return null;
    }

    @NotNull
    public final PageContext getPageContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "869757257") ? (PageContext) ipChange.ipc$dispatch("869757257", new Object[]{this}) : this.pageContext;
    }

    @NotNull
    public PageLoader getPageLoader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1396861897")) {
            return (PageLoader) ipChange.ipc$dispatch("1396861897", new Object[]{this});
        }
        PageLoader pageLoader = this.pageLoader;
        if (pageLoader != null) {
            return pageLoader;
        }
        b41.A("pageLoader");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public abstract String getPageName();

    @NotNull
    public final PageStateManager getPageStateManager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-216883723")) {
            return (PageStateManager) ipChange.ipc$dispatch("-216883723", new Object[]{this});
        }
        PageStateManager pageStateManager = this.pageStateManager;
        if (pageStateManager != null) {
            return pageStateManager;
        }
        b41.A("pageStateManager");
        return null;
    }

    @Nullable
    protected View getPreContentView(@Nullable ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1315348399")) {
            return (View) ipChange.ipc$dispatch("-1315348399", new Object[]{this, viewGroup});
        }
        return null;
    }

    @Nullable
    public final View getRealView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "134189578") ? (View) ipChange.ipc$dispatch("134189578", new Object[]{this}) : this.realView;
    }

    @Nullable
    public final RecycleViewSettings getRecycleViewSettings() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1070845831") ? (RecycleViewSettings) ipChange.ipc$dispatch("-1070845831", new Object[]{this}) : this.recycleViewSettings;
    }

    @Nullable
    public final RecyclerView getRecyclerView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-697484178") ? (RecyclerView) ipChange.ipc$dispatch("-697484178", new Object[]{this}) : this.recyclerView;
    }

    protected int getRecyclerViewResId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1256437893")) {
            return ((Integer) ipChange.ipc$dispatch("-1256437893", new Object[]{this})).intValue();
        }
        return -1;
    }

    @Nullable
    public final RefreshLayout getRefreshLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2003193231") ? (RefreshLayout) ipChange.ipc$dispatch("-2003193231", new Object[]{this}) : this.refreshLayout;
    }

    protected int getRefreshLayoutResId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251012040")) {
            return ((Integer) ipChange.ipc$dispatch("1251012040", new Object[]{this})).intValue();
        }
        return -1;
    }

    @Nullable
    public final View getRootView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1587323066") ? (View) ipChange.ipc$dispatch("-1587323066", new Object[]{this}) : this.rootView;
    }

    protected abstract void initConfigManager();

    @NotNull
    public List<IDelegate<GenericFragment>> initDelegates(@Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-245098886")) {
            return (List) ipChange.ipc$dispatch("-245098886", new Object[]{this, str});
        }
        List<IDelegate<GenericFragment>> delegates = getDelegates();
        if (delegates == null || delegates.isEmpty()) {
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (z) {
                return new ArrayList();
            }
            Context requireContext = requireContext();
            b41.h(requireContext, "requireContext()");
            DelegateConfigure delegateConfigure = new DelegateManager(str, requireContext).getDelegateConfigure();
            if (delegateConfigure != null) {
                ArrayList arrayList = new ArrayList();
                for (DelegateConfigure.DelegatesBean delegatesBean : delegateConfigure.getDelegates()) {
                    if (delegatesBean.isEnable()) {
                        Object f = a.j(delegatesBean.getClassX()).b().f();
                        IDelegate iDelegate = f instanceof IDelegate ? (IDelegate) f : null;
                        if (iDelegate != null) {
                            arrayList.add(iDelegate);
                        }
                    }
                }
                return arrayList;
            }
            return new ArrayList();
        }
        return delegates;
    }

    protected void initLoadingViewManager(@Nullable RefreshLayout refreshLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1901165054")) {
            ipChange.ipc$dispatch("-1901165054", new Object[]{this, refreshLayout});
            return;
        }
        LoadingViewManager loadingViewManager = getPageContainer().getPageLoader().getLoadingViewManager();
        if (refreshLayout != null) {
            refreshLayout.setOnMultiPurposeListener(getFragmentInterceptor());
            RefreshLayoutManger refreshLayoutManger = new RefreshLayoutManger();
            refreshLayoutManger.setRefreshLayout(refreshLayout);
            loadingViewManager.addLoadingStateListener(refreshLayoutManger);
        }
        loadingViewManager.addLoadingStateListener(getPageStateManager());
    }

    @NotNull
    protected abstract IContainer<ModelValue> initPageContainer(@NotNull PageContext pageContext);

    protected void initPageLoader() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1027980343")) {
            ipChange.ipc$dispatch("1027980343", new Object[]{this});
            return;
        }
        setPageLoader(new PageLoader(getPageContainer()));
        getPageLoader().setCallback(this);
        getPageContainer().setPageLoader(getPageLoader());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initPageStateManager() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-274038258")) {
            ipChange.ipc$dispatch("-274038258", new Object[]{this});
        } else {
            setPageStateManager(new PageStateManager(getContext()));
        }
    }

    public abstract void initRecycleViewSettings();

    public final boolean isFragmentVisible() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-949632051") ? ((Boolean) ipChange.ipc$dispatch("-949632051", new Object[]{this})).booleanValue() : this.isFragmentVisible;
    }

    public final boolean isSelected() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "287371304") ? ((Boolean) ipChange.ipc$dispatch("287371304", new Object[]{this})).booleanValue() : this.isSelected;
    }

    public void load(@NotNull Map<String, ? extends Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "785216674")) {
            ipChange.ipc$dispatch("785216674", new Object[]{this, map});
            return;
        }
        b41.i(map, com.youku.arch.v3.core.Constants.CONFIG);
        getPageContainer().getPageLoader().load(map);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1262648429")) {
            ipChange.ipc$dispatch("1262648429", new Object[]{this, bundle});
            return;
        }
        super.onActivityCreated(bundle);
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1759059941")) {
            ipChange.ipc$dispatch("-1759059941", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Object obj;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-976443965")) {
            ipChange.ipc$dispatch("-976443965", new Object[]{this, context});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        super.onAttach(context);
        Bundle arguments = getArguments();
        if (arguments != null && (obj = arguments.get(com.youku.arch.v3.data.Constants.ACTIVITY_CONTEXT)) != null) {
            getPageContext().attachBaseContext((IContext) obj);
        }
        EventBus eventBus = this.pageContext.getEventBus();
        if (eventBus != null && !eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onFragmentAttach(context);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(@NotNull Fragment fragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "157967917")) {
            ipChange.ipc$dispatch("157967917", new Object[]{this, fragment});
            return;
        }
        b41.i(fragment, "childFragment");
        super.onAttachFragment(fragment);
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onAttachFragment(fragment);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1153903932")) {
            ipChange.ipc$dispatch("-1153903932", new Object[]{this, configuration});
            return;
        }
        b41.i(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onConfigurationChanged(configuration);
    }

    @Nullable
    protected View onContentViewInflated(@Nullable View view) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1040206161") ? (View) ipChange.ipc$dispatch("-1040206161", new Object[]{this, view}) : view;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r5) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.page.GenericFragment.onCreate(android.os.Bundle):void");
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1018832892")) {
            return (Animation) ipChange.ipc$dispatch("1018832892", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        }
        Animation onCreateAnimation = super.onCreateAnimation(i, z, i2);
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor != null) {
            fragmentInterceptor.onCreateAnimation(i, z, i2);
        }
        return onCreateAnimation;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public Animator onCreateAnimator(int i, boolean z, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1493526440")) {
            return (Animator) ipChange.ipc$dispatch("1493526440", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)});
        }
        Animator onCreateAnimator = super.onCreateAnimator(i, z, i2);
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor != null) {
            fragmentInterceptor.onCreateAnimation(i, z, i2);
        }
        return onCreateAnimator;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-122218178")) {
            return (View) ipChange.ipc$dispatch("-122218178", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        b41.i(layoutInflater, "inflater");
        ViewGroup contentView = getPageStateManager().isStateViewEnable() ? getPageStateManager().getContentView() : null;
        if (this.realView == null) {
            ViewGroup viewGroup2 = getPageStateManager().isStateViewEnable() ? contentView : viewGroup;
            View preContentView = getPreContentView(viewGroup2);
            this.realView = preContentView;
            if (preContentView == null) {
                this.realView = layoutInflater.inflate(getLayoutResId(), viewGroup2, false);
            }
        }
        View view = this.realView;
        if (view != null) {
            if (getRefreshLayoutResId() > 0) {
                setRefreshLayout((RefreshLayout) view.findViewById(getRefreshLayoutResId()));
                RefreshLayout refreshLayout = getRefreshLayout();
                if (refreshLayout != null) {
                    refreshLayout.setEnableRefresh(false);
                }
                RefreshLayout refreshLayout2 = getRefreshLayout();
                if (refreshLayout2 != null) {
                    refreshLayout2.setEnableLoadMore(true);
                }
            }
            if (getRecyclerViewResId() > 0) {
                setRecyclerView((RecyclerView) view.findViewById(getRecyclerViewResId()));
            }
        }
        initLoadingViewManager(this.refreshLayout);
        initPageStateManager(onContentViewInflated(this.realView));
        List<IDelegate<GenericFragment>> initDelegates = initDelegates(getDelegatePathPrefix());
        this.delegateList = initDelegates;
        wrapperDelegates(initDelegates);
        List<IDelegate<GenericFragment>> list = this.delegateList;
        if (list != null) {
            for (IDelegate<GenericFragment> iDelegate : list) {
                iDelegate.setDelegatedContainer(this);
            }
        }
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor != null) {
            fragmentInterceptor.onCreateView(layoutInflater, viewGroup, bundle);
        }
        return getPageStateManager().isStateViewEnable() ? contentView : this.realView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1247820474")) {
            ipChange.ipc$dispatch("-1247820474", new Object[]{this});
            return;
        }
        super.onDestroy();
        String pageName = getPageName();
        if (pageName != null) {
            ArchMontiorManager.Companion companion = ArchMontiorManager.Companion;
            ArchMontior archMontior = companion.get(pageName);
            if (archMontior != null) {
                archMontior.uploadComponentsMonitor();
            }
            companion.release(pageName);
        }
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor != null) {
            fragmentInterceptor.onFragmentDestroy();
        }
        this.isFragmentVisible = false;
        this.rootView = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1716612127")) {
            ipChange.ipc$dispatch("-1716612127", new Object[]{this});
            return;
        }
        super.onDestroyView();
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor != null) {
            fragmentInterceptor.onDestroyView();
        }
        this.isFragmentVisible = false;
        this.rootView = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "427705751")) {
            ipChange.ipc$dispatch("427705751", new Object[]{this});
            return;
        }
        super.onDetach();
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor != null) {
            fragmentInterceptor.onFragmentDetach();
        }
        EventBus eventBus = this.pageContext.getEventBus();
        if (eventBus != null) {
            eventBus.removeAllStickyEvents();
        }
        EventBus eventBus2 = this.pageContext.getEventBus();
        if (eventBus2 != null) {
            eventBus2.unregister(this);
        }
        unRegisterDelegates(this.delegateList);
        this.pageContext.release();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onFragmentVisibleChange(boolean r5) {
        /*
            r4 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.v3.page.GenericFragment.$ipChange
            java.lang.String r1 = "-1741458458"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            if (r2 == 0) goto L1b
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            r3 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r2[r3] = r5
            r0.ipc$dispatch(r1, r2)
            return
        L1b:
            com.youku.arch.v3.core.PageContext r0 = r4.pageContext     // Catch: java.lang.Throwable -> L2a
            android.os.Bundle r0 = r0.getBundle()     // Catch: java.lang.Throwable -> L2a
            if (r0 != 0) goto L24
            goto L31
        L24:
            java.lang.String r1 = "key_fragment_visible_state"
            r0.putBoolean(r1, r5)     // Catch: java.lang.Throwable -> L2a
            goto L31
        L2a:
            r0 = move-exception
            boolean r1 = com.youku.middlewareservice.provider.info.AppInfoProviderProxy.isDebuggable()
            if (r1 != 0) goto L37
        L31:
            if (r5 == 0) goto L36
            r4.updatePvStatics()
        L36:
            return
        L37:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.v3.page.GenericFragment.onFragmentVisibleChange(boolean):void");
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1819525327")) {
            return (LayoutInflater) ipChange.ipc$dispatch("-1819525327", new Object[]{this, bundle});
        }
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater(bundle);
        b41.h(onGetLayoutInflater, "super.onGetLayoutInflater(savedInstanceState)");
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor != null) {
            fragmentInterceptor.onGetLayoutInflater(bundle);
        }
        return onGetLayoutInflater;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1279005758")) {
            ipChange.ipc$dispatch("1279005758", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        boolean z2 = !z;
        this.isFragmentVisible = z2;
        onFragmentVisibleChange(z2);
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onHiddenChanged(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(@NotNull Context context, @NotNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1766386069")) {
            ipChange.ipc$dispatch("1766386069", new Object[]{this, context, attributeSet, bundle});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(attributeSet, TemplateDom.KEY_ATTRS);
        super.onInflate(context, attributeSet, bundle);
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onInflate(context, attributeSet, bundle);
    }

    @Subscribe(eventType = {RefreshEvent.ON_LOAD_MORE})
    public void onLoadMore(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "246412741")) {
            ipChange.ipc$dispatch("246412741", new Object[]{this, event});
            return;
        }
        b41.i(event, "event");
        if (getPageContainer().hasNext()) {
            getPageContainer().loadMore();
            return;
        }
        Object obj = event.data;
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        Object obj2 = hashMap == null ? null : hashMap.get("refreshLayout");
        RefreshLayout refreshLayout = obj2 instanceof RefreshLayout ? (RefreshLayout) obj2 : null;
        if (refreshLayout == null) {
            return;
        }
        refreshLayout.finishLoadMoreWithNoMoreData();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1491262251")) {
            ipChange.ipc$dispatch("1491262251", new Object[]{this});
            return;
        }
        super.onLowMemory();
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onLowMemory();
    }

    @Override // androidx.fragment.app.Fragment
    public void onMultiWindowModeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-615039662")) {
            ipChange.ipc$dispatch("-615039662", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onMultiWindowModeChanged(z);
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onMultiWindowModeChanged(z);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1835322230")) {
            ipChange.ipc$dispatch("-1835322230", new Object[]{this});
            return;
        }
        super.onPause();
        if (this.isSelected && this.isFragmentVisible) {
            setUserVisibleHint(false);
        }
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onFragmentPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPictureInPictureModeChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-76050518")) {
            ipChange.ipc$dispatch("-76050518", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onPictureInPictureModeChanged(z);
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onPictureInPictureModeChanged(z);
    }

    @Subscribe(eventType = {RefreshEvent.ON_REFRESH})
    public void onRefresh(@NotNull Event event) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "262104015")) {
            ipChange.ipc$dispatch("262104015", new Object[]{this, event});
            return;
        }
        b41.i(event, "event");
        getPageContainer().reload();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-309911070")) {
            ipChange.ipc$dispatch("-309911070", new Object[]{this, Integer.valueOf(i), strArr, iArr});
            return;
        }
        b41.i(strArr, "permissions");
        b41.i(iArr, WXModule.GRANT_RESULTS);
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // com.youku.arch.v3.io.Callback
    public void onResponse(@NotNull IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1975010710")) {
            ipChange.ipc$dispatch("-1975010710", new Object[]{this, iResponse});
            return;
        }
        b41.i(iResponse, "response");
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onApiResponse(iResponse);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "587372221")) {
            ipChange.ipc$dispatch("587372221", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.isSelected && !this.isFragmentVisible) {
            setUserVisibleHint(true);
        }
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onFragmentResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1775035309")) {
            ipChange.ipc$dispatch("-1775035309", new Object[]{this, bundle});
            return;
        }
        b41.i(bundle, "outState");
        super.onSaveInstanceState(bundle);
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1792217442")) {
            ipChange.ipc$dispatch("-1792217442", new Object[]{this});
            return;
        }
        super.onStart();
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onFragmentStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "647719944")) {
            ipChange.ipc$dispatch("647719944", new Object[]{this});
            return;
        }
        super.onStop();
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onFragmentStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        ContentAdapter adapter;
        Style style;
        StyleManager styleManager;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1940639647")) {
            ipChange.ipc$dispatch("1940639647", new Object[]{this, view, bundle});
            return;
        }
        b41.i(view, "view");
        this.rootView = view;
        super.onViewCreated(view, bundle);
        if (this.recycleViewSettings == null) {
            this.recycleViewSettings = new RecycleViewSettings(getActivity());
            initRecycleViewSettings();
        }
        RecycleViewSettings recycleViewSettings = this.recycleViewSettings;
        if (recycleViewSettings != null && (adapter = recycleViewSettings.getAdapter()) != null) {
            ActivityValue activityValue = getPageContext().getActivityValue();
            if (activityValue != null && (style = activityValue.getStyle()) != null && (styleManager = getPageContext().getStyleManager()) != null) {
                styleManager.updateStyle(style);
            }
            getPageContainer().setContentAdapter(adapter);
            getPageContainer().updateContentAdapter();
        }
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onViewCreated(view, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1175579190")) {
            ipChange.ipc$dispatch("1175579190", new Object[]{this, bundle});
            return;
        }
        super.onViewStateRestored(bundle);
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onViewStateRestored(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1251964129")) {
            ipChange.ipc$dispatch("-1251964129", new Object[]{this, bundle});
            return;
        }
        super.setArguments(bundle);
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.setArguments(bundle);
    }

    public final void setAttachBaseContext(@Nullable IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "419419302")) {
            ipChange.ipc$dispatch("419419302", new Object[]{this, iContext});
        } else {
            this.attachBaseContext = iContext;
        }
    }

    public final void setDelegateList(@Nullable List<IDelegate<GenericFragment>> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "134235341")) {
            ipChange.ipc$dispatch("134235341", new Object[]{this, list});
        } else {
            this.delegateList = list;
        }
    }

    public final void setFragmentBackGroundColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2072138243")) {
            ipChange.ipc$dispatch("-2072138243", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View view = this.realView;
        if (view == null) {
            return;
        }
        view.setBackgroundColor(i);
    }

    public final void setFragmentBackGroundDrawable(@Nullable Drawable drawable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "524477095")) {
            ipChange.ipc$dispatch("524477095", new Object[]{this, drawable});
            return;
        }
        View view = this.realView;
        if (view == null) {
            return;
        }
        view.setBackground(drawable);
    }

    public final void setFragmentInterceptor(@Nullable FragmentInterceptor fragmentInterceptor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "593936451")) {
            ipChange.ipc$dispatch("593936451", new Object[]{this, fragmentInterceptor});
        } else {
            this.fragmentInterceptor = fragmentInterceptor;
        }
    }

    public final void setFragmentPreloadDelegate(@Nullable GenericFragmentPreloadDelegate genericFragmentPreloadDelegate) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-869880838")) {
            ipChange.ipc$dispatch("-869880838", new Object[]{this, genericFragmentPreloadDelegate});
        } else {
            this.fragmentPreloadDelegate = genericFragmentPreloadDelegate;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setFragmentVisible(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913606923")) {
            ipChange.ipc$dispatch("1913606923", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isFragmentVisible = z;
        }
    }

    protected void setInitResponse(@Nullable IResponse iResponse) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "850372847")) {
            ipChange.ipc$dispatch("850372847", new Object[]{this, iResponse});
        } else {
            this.initResponse = iResponse;
        }
    }

    public void setNoMore(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1402885525")) {
            ipChange.ipc$dispatch("-1402885525", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        RefreshLayout refreshLayout = this.refreshLayout;
        if (refreshLayout == null) {
            return;
        }
        if (z) {
            refreshLayout.finishLoadMoreWithNoMoreData();
        } else {
            refreshLayout.setEnableLoadMore(true);
        }
        refreshLayout.setEnableAutoLoadMore(!z);
        if (z) {
            refreshLayout.setFooterHeight(getNoMoreFootHeight());
        } else {
            refreshLayout.setFooterHeight(getLoadingFootHeight());
        }
        refreshLayout.setNoMoreData(z);
    }

    public void setPageContainer(@NotNull IContainer<ModelValue> iContainer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1257683869")) {
            ipChange.ipc$dispatch("-1257683869", new Object[]{this, iContainer});
            return;
        }
        b41.i(iContainer, "<set-?>");
        this.pageContainer = iContainer;
    }

    public final void setPageContext(@NotNull PageContext pageContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1119558627")) {
            ipChange.ipc$dispatch("-1119558627", new Object[]{this, pageContext});
            return;
        }
        b41.i(pageContext, "<set-?>");
        this.pageContext = pageContext;
    }

    public void setPageLoader(@NotNull PageLoader pageLoader) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "365336243")) {
            ipChange.ipc$dispatch("365336243", new Object[]{this, pageLoader});
            return;
        }
        b41.i(pageLoader, "<set-?>");
        this.pageLoader = pageLoader;
    }

    public final void setPageSelected(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1503536511")) {
            ipChange.ipc$dispatch("1503536511", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isSelected = z;
        if (z) {
            setUserVisibleHint(true);
        }
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.onPageSelected(z);
    }

    public final void setPageStateManager(@NotNull PageStateManager pageStateManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1320227089")) {
            ipChange.ipc$dispatch("1320227089", new Object[]{this, pageStateManager});
            return;
        }
        b41.i(pageStateManager, "<set-?>");
        this.pageStateManager = pageStateManager;
    }

    public final void setRealView(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1618593814")) {
            ipChange.ipc$dispatch("1618593814", new Object[]{this, view});
        } else {
            this.realView = view;
        }
    }

    public final void setRecycleViewSettings(@Nullable RecycleViewSettings recycleViewSettings) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-853229321")) {
            ipChange.ipc$dispatch("-853229321", new Object[]{this, recycleViewSettings});
        } else {
            this.recycleViewSettings = recycleViewSettings;
        }
    }

    public final void setRecyclerView(@Nullable RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1260504804")) {
            ipChange.ipc$dispatch("-1260504804", new Object[]{this, recyclerView});
        } else {
            this.recyclerView = recyclerView;
        }
    }

    public final void setRefreshLayout(@Nullable RefreshLayout refreshLayout) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1654236763")) {
            ipChange.ipc$dispatch("1654236763", new Object[]{this, refreshLayout});
        } else {
            this.refreshLayout = refreshLayout;
        }
    }

    protected final void setSelected(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1504552880")) {
            ipChange.ipc$dispatch("-1504552880", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isSelected = z;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-829482409")) {
            ipChange.ipc$dispatch("-829482409", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.setUserVisibleHint(z);
        if (isAdded() && this.isFragmentVisible != z) {
            this.isFragmentVisible = z;
            onFragmentVisibleChange(z);
        }
        FragmentInterceptor fragmentInterceptor = this.fragmentInterceptor;
        if (fragmentInterceptor == null) {
            return;
        }
        fragmentInterceptor.setUserVisibleHint(z);
    }

    public void updatePvStatics() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-942774421")) {
            ipChange.ipc$dispatch("-942774421", new Object[]{this});
        }
    }

    @Nullable
    public List<IDelegate<GenericFragment>> wrapperDelegates(@Nullable List<IDelegate<GenericFragment>> list) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "878255208") ? (List) ipChange.ipc$dispatch("878255208", new Object[]{this, list}) : list;
    }

    @NotNull
    /* renamed from: getPageLoader  reason: collision with other method in class */
    public final PagingLoader m1253getPageLoader() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1959912404") ? (PagingLoader) ipChange.ipc$dispatch("-1959912404", new Object[]{this}) : getPageContainer().getPageLoader();
    }

    public void initPageStateManager(@Nullable View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-812994556")) {
            ipChange.ipc$dispatch("-812994556", new Object[]{this, view});
            return;
        }
        PageStateManager pageStateManager = getPageStateManager();
        pageStateManager.setOnConfigStateViewListener(new GenericFragment$initPageStateManager$1$1(this));
        pageStateManager.setStateProperty(State.SUCCESS, new StateSuccessView(view));
    }
}
