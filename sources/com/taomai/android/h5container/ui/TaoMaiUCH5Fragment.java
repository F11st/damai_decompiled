package com.taomai.android.h5container.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.taobao.windvane.webview.WVUIModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import cn.damai.common.DamaiConstants;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.security.common.track.model.a;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taomai.android.h5container.R$id;
import com.taomai.android.h5container.R$layout;
import com.taomai.android.h5container.R$string;
import com.taomai.android.h5container.api.TMNavigationBarPlugin;
import com.taomai.android.h5container.provider.IH5EventDispatcher;
import com.taomai.android.h5container.provider.IKeyboardHookProvider;
import com.taomai.android.h5container.provider.INavigationBarProvider;
import com.taomai.android.h5container.utils.ActivityStackManager;
import com.taomai.android.h5container.utils.ImageTool;
import com.taomai.android.h5container.webview.TaoMaiUCWebView;
import com.taomai.android.h5container.widget.H5Progress;
import com.taomai.android.h5container.widget.H5ToolBar;
import com.taomai.android.h5container.widget.TitleBar;
import com.tencent.open.SocialConstants;
import com.uc.webview.export.WebResourceError;
import com.uc.webview.export.WebResourceRequest;
import com.uc.webview.export.WebSettings;
import com.uc.webview.export.WebView;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.media.MessageID;
import com.youku.arch.v3.event.Subject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.al2;
import tb.b41;
import tb.bl2;
import tb.cl2;
import tb.eq2;
import tb.fb1;
import tb.jn1;
import tb.kp0;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\t¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u001eH\u0016J\b\u0010#\u001a\u00020\bH\u0016J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\bH\u0016J\u0012\u0010'\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010-\u001a\u00020\b2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J\b\u0010.\u001a\u00020\bH\u0016J\b\u0010/\u001a\u00020\bH\u0016J\u0006\u00100\u001a\u00020\bJ\u0006\u00101\u001a\u00020\bJ\u000e\u00103\u001a\u00020\b2\u0006\u00102\u001a\u00020\u001eJ\b\u00105\u001a\u000204H\u0016J\b\u00107\u001a\u000206H\u0016J$\u0010=\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u0001082\b\u0010:\u001a\u0004\u0018\u00010\u00112\b\u0010<\u001a\u0004\u0018\u00010;J\u001a\u0010>\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u0001082\b\u0010:\u001a\u0004\u0018\u00010\u0011J.\u0010B\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u0001082\u0006\u0010?\u001a\u00020(2\b\u0010@\u001a\u0004\u0018\u00010\u00112\b\u0010A\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010B\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u0001082\b\u0010E\u001a\u0004\u0018\u00010D2\b\u0010G\u001a\u0004\u0018\u00010FH\u0016J\b\u0010H\u001a\u00020\bH\u0016J\b\u0010I\u001a\u00020\bH\u0016J\u000e\u0010K\u001a\u00020\b2\u0006\u0010J\u001a\u00020(J\u0006\u0010L\u001a\u00020\bJ\u0006\u0010M\u001a\u00020\bJ\u0006\u0010N\u001a\u00020\bJ\u000e\u0010O\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u0011J\b\u0010P\u001a\u00020\bH\u0016J\u0010\u0010R\u001a\u00020\b2\u0006\u0010Q\u001a\u00020\u001eH\u0016J\b\u0010S\u001a\u00020\u001eH\u0016J\b\u0010T\u001a\u00020\u001eH\u0016J\u001c\u0010V\u001a\u00020\b2\b\u0010U\u001a\u0004\u0018\u00010\u00112\b\u0010,\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010X\u001a\u00020\b2\b\u0010W\u001a\u0004\u0018\u00010\u00112\b\u0010,\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010Y\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010Z\u001a\u00020\bH\u0016J\b\u0010[\u001a\u00020\bH\u0016J\b\u0010\\\u001a\u00020\bH\u0016J\b\u0010]\u001a\u00020\bH\u0016J\u001a\u0010b\u001a\u00020\b2\b\u0010_\u001a\u0004\u0018\u00010^2\u0006\u0010a\u001a\u00020`H\u0016J\b\u0010c\u001a\u00020\bH\u0016J\b\u0010d\u001a\u00020\bH\u0016J\b\u0010e\u001a\u00020\bH\u0016J\u0012\u0010g\u001a\u00020\b2\b\u0010f\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010i\u001a\u00020\b2\b\u0010h\u001a\u0004\u0018\u00010\u0011H\u0016Ro\u0010m\u001aO\u0012\u0015\u0012\u0013\u0018\u000108¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(9\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(:\u0012\u0015\u0012\u0013\u0018\u00010;¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\b\u0018\u00010j8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rRX\u0010t\u001a8\u0012\u0015\u0012\u0013\u0018\u000108¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(9\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\b\u0018\u00010s8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0085\u0001\u0010{\u001ad\u0012\u0015\u0012\u0013\u0018\u000108¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(9\u0012\u0013\u0012\u00110(¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(?\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(@\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(A\u0012\u0004\u0012\u00020\b\u0018\u00010z8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R*\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R*\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R0\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001a\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001a\u0010\u009b\u0001\u001a\u00030\u009a\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0019\u0010\u009d\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R)\u0010:\u001a\u0004\u0018\u00010\u00118\u0004@\u0004X\u0084\u000e¢\u0006\u0017\n\u0005\b:\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R\u0019\u0010¤\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010\u009e\u0001R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0012\u0010\u009f\u0001R\u0019\u0010¥\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010\u009e\u0001R\u0019\u0010¦\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010\u009e\u0001R\u0019\u0010§\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010\u009e\u0001R\u0019\u0010¨\u0001\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¨\u0001\u0010\u009e\u0001R*\u0010©\u0001\u001a\u00020\u001e2\u0007\u0010\u0090\u0001\u001a\u00020\u001e8\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b©\u0001\u0010\u009e\u0001\u001a\u0006\b©\u0001\u0010ª\u0001¨\u0006\u00ad\u0001"}, d2 = {"Lcom/taomai/android/h5container/ui/TaoMaiUCH5Fragment;", "Landroidx/fragment/app/Fragment;", "Lcom/taomai/android/h5container/provider/IKeyboardHookProvider;", "Lcom/taomai/android/h5container/provider/IH5EventDispatcher;", "Lcom/taomai/android/h5container/provider/INavigationBarProvider;", "Lcom/taomai/android/h5container/utils/ActivityStackManager$IActivityStackBackEvent;", "Landroid/view/View;", "root", "Ltb/wt2;", "initView", "setupWebView", "registerProvider4Bridge", "parseArguments", "showLoading", "hideLoading", "notifyH5BackPressed", "loadInitUrl", "", "title", "setTitleIfNeed", "resetTitleStatus", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED, "", "isVisibleToUser", "setUserVisibleHint", "hidden", "onHiddenChanged", "onResume", MessageID.onPause, "onDestroy", "args", "setArguments", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "pageAppear", "pageDisappear", TMNavigationBarPlugin.ACTION_SHOW_TITLE_BAR, TMNavigationBarPlugin.ACTION_HIDE_TITLE_BAR, "enable", "setEnableProgress", "Ltb/cl2;", "createWebViewClient", "Ltb/bl2;", "createWebViewChromeClient", "Lcom/uc/webview/export/WebView;", "view", "url", "Landroid/graphics/Bitmap;", "favicon", "handleOnPageStarted", "handleOnPageFinished", "errorCode", SocialConstants.PARAM_COMMENT, "failingUrl", "handleOnReceivedError", a.c.d, "Lcom/uc/webview/export/WebResourceRequest;", "webResourceRequest", "Lcom/uc/webview/export/WebResourceError;", "webResourceResponse", "showEmptyOrErrorView", "hideEmptyOrErrorView", "progress", UCCore.EVENT_UPDATE_PROGRESS, "notifyProgressEnd", "showProgressIfEnable", "reload", "loadUrl", com.alipay.sdk.m.x.d.p, "enableHook", "setHookBackKey", "isBackHooked", "onBackPressed", "type", WXBridgeManager.METHOD_FIRE_EVENT, "eventName", "fireGlobalEvent", "setWebTitle", "showWebTitle", "hideWebTitle", "showWebOptionMenu", "hideWebOptionMenu", "Lcom/alibaba/fastjson/JSONObject;", "menu", "Landroid/view/View$OnClickListener;", "listener", "setWebOptionMenu", "showWebTitleBackBtn", "hideWebTitleBackBtn", "enableHookBackBtn", "transparentTitle", TMNavigationBarPlugin.ACTION_SET_TRANSPARENT_TITLE, "jsonData", "onPageBackResult", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "pageLoadStartListener", "Lkotlin/jvm/functions/Function3;", "getPageLoadStartListener", "()Lkotlin/jvm/functions/Function3;", "setPageLoadStartListener", "(Lkotlin/jvm/functions/Function3;)V", "Lkotlin/Function2;", "pageLoadFinishListener", "Lkotlin/jvm/functions/Function2;", "getPageLoadFinishListener", "()Lkotlin/jvm/functions/Function2;", "setPageLoadFinishListener", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function4;", "pageLoadErrorListener", "Lkotlin/jvm/functions/Function4;", "getPageLoadErrorListener", "()Lkotlin/jvm/functions/Function4;", "setPageLoadErrorListener", "(Lkotlin/jvm/functions/Function4;)V", "Lcom/taomai/android/h5container/widget/H5ToolBar;", "toolbar", "Lcom/taomai/android/h5container/widget/H5ToolBar;", "getToolbar", "()Lcom/taomai/android/h5container/widget/H5ToolBar;", "setToolbar", "(Lcom/taomai/android/h5container/widget/H5ToolBar;)V", "Lcom/taomai/android/h5container/widget/TitleBar;", "titleBar", "Lcom/taomai/android/h5container/widget/TitleBar;", "getTitleBar", "()Lcom/taomai/android/h5container/widget/TitleBar;", "setTitleBar", "(Lcom/taomai/android/h5container/widget/TitleBar;)V", "Lcom/taomai/android/h5container/webview/TaoMaiUCWebView;", "<set-?>", "webView", "Lcom/taomai/android/h5container/webview/TaoMaiUCWebView;", "getWebView", "()Lcom/taomai/android/h5container/webview/TaoMaiUCWebView;", "webContainer", "Landroid/view/ViewGroup;", "Lcom/taomai/android/h5container/widget/H5Progress;", "h5ProgressView", "Lcom/taomai/android/h5container/widget/H5Progress;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "refreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "enableProgressBar", "Z", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "hookBackEvent", "needHideTitleBar", "readTitle", "hasSetTitleFromBridge", "hasSetTransparentTitleFromBridge", "isLoadSuccess", "()Z", "<init>", "()V", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public class TaoMaiUCH5Fragment extends Fragment implements IH5EventDispatcher, IKeyboardHookProvider, INavigationBarProvider, ActivityStackManager.IActivityStackBackEvent {
    private H5Progress h5ProgressView;
    private boolean hasSetTitleFromBridge;
    private boolean hasSetTransparentTitleFromBridge;
    private boolean hookBackEvent;
    private boolean isLoadSuccess;
    private boolean needHideTitleBar;
    @Nullable
    private Function4<? super WebView, ? super Integer, ? super String, ? super String, wt2> pageLoadErrorListener;
    @Nullable
    private Function2<? super WebView, ? super String, wt2> pageLoadFinishListener;
    @Nullable
    private Function3<? super WebView, ? super String, ? super Bitmap, wt2> pageLoadStartListener;
    private SwipeRefreshLayout refreshLayout;
    private String title;
    public TitleBar titleBar;
    public H5ToolBar toolbar;
    private eq2 transparentTitleHelper;
    @Nullable
    private String url;
    private ViewGroup webContainer;
    @Nullable
    private TaoMaiUCWebView webView;
    private boolean enableProgressBar = true;
    private boolean readTitle = true;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class a extends bl2 {
        a(Context context) {
            super(context);
        }

        @Override // com.uc.webview.export.WebChromeClient
        public void onProgressChanged(@Nullable WebView webView, int i) {
            super.onProgressChanged(webView, i);
            TaoMaiUCH5Fragment.this.updateProgress(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = TaoMaiUCH5Fragment.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class d implements SwipeRefreshLayout.OnRefreshListener {
        d() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            TaoMaiUCH5Fragment.this.onRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class e implements SwipeRefreshLayout.OnChildScrollUpCallback {
        e() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnChildScrollUpCallback
        public final boolean canChildScrollUp(@NotNull SwipeRefreshLayout swipeRefreshLayout, @Nullable View view) {
            b41.i(swipeRefreshLayout, "swipeRefreshLayout");
            try {
                TaoMaiUCWebView webView = TaoMaiUCH5Fragment.this.getWebView();
                if (webView != null) {
                    return webView.realScrollY() > 0;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class f implements H5Progress.ProgressNotifier {
        f() {
        }

        @Override // com.taomai.android.h5container.widget.H5Progress.ProgressNotifier
        public void onProgressBegin() {
        }

        @Override // com.taomai.android.h5container.widget.H5Progress.ProgressNotifier
        public void onProgressEnd() {
            TaoMaiUCH5Fragment.access$getH5ProgressView$p(TaoMaiUCH5Fragment.this).hideAndResetProgress();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static final class g implements View.OnClickListener {
        final /* synthetic */ JSONObject b;
        final /* synthetic */ View.OnClickListener c;

        g(JSONObject jSONObject, View.OnClickListener onClickListener) {
            this.b = jSONObject;
            this.c = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TaoMaiUCH5Fragment.this.fireEvent("optionMenu", this.b.toJSONString());
            this.c.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TaoMaiUCWebView webView = TaoMaiUCH5Fragment.this.getWebView();
            if (webView != null) {
                webView.reload();
            }
        }
    }

    public static final /* synthetic */ H5Progress access$getH5ProgressView$p(TaoMaiUCH5Fragment taoMaiUCH5Fragment) {
        H5Progress h5Progress = taoMaiUCH5Fragment.h5ProgressView;
        if (h5Progress == null) {
            b41.A("h5ProgressView");
        }
        return h5Progress;
    }

    private final void hideLoading() {
    }

    private final void initView(View view) {
        boolean q;
        View findViewById = view.findViewById(R$id.toolbar);
        b41.h(findViewById, "root.findViewById(R.id.toolbar)");
        H5ToolBar h5ToolBar = (H5ToolBar) findViewById;
        this.toolbar = h5ToolBar;
        if (h5ToolBar == null) {
            b41.A("toolbar");
        }
        View findViewById2 = h5ToolBar.findViewById(R$id.titlebar);
        b41.h(findViewById2, "toolbar.findViewById(R.id.titlebar)");
        TitleBar titleBar = (TitleBar) findViewById2;
        this.titleBar = titleBar;
        if (titleBar == null) {
            b41.A("titleBar");
        }
        titleBar.updateStyle();
        TitleBar titleBar2 = this.titleBar;
        if (titleBar2 == null) {
            b41.A("titleBar");
        }
        titleBar2.setType(2);
        if (this.needHideTitleBar) {
            hideTitleBar();
        }
        TitleBar titleBar3 = this.titleBar;
        if (titleBar3 == null) {
            b41.A("titleBar");
        }
        titleBar3.setLeftButtonText(getString(R$string.h5_ic_arrow_back));
        TitleBar titleBar4 = this.titleBar;
        if (titleBar4 == null) {
            b41.A("titleBar");
        }
        titleBar4.setLeftButtonListener(new c());
        String str = this.title;
        if (str != null) {
            TitleBar titleBar5 = this.titleBar;
            if (titleBar5 == null) {
                b41.A("titleBar");
            }
            titleBar5.setTitle(str);
        }
        View findViewById3 = view.findViewById(R$id.refresh_layout);
        b41.h(findViewById3, "root.findViewById(R.id.refresh_layout)");
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById3;
        this.refreshLayout = swipeRefreshLayout;
        if (swipeRefreshLayout == null) {
            b41.A("refreshLayout");
        }
        swipeRefreshLayout.setColorScheme(17170454);
        SwipeRefreshLayout swipeRefreshLayout2 = this.refreshLayout;
        if (swipeRefreshLayout2 == null) {
            b41.A("refreshLayout");
        }
        Bundle arguments = getArguments();
        q = o.q("YES", arguments != null ? arguments.getString("pullRefresh") : null, true);
        swipeRefreshLayout2.setEnabled(q);
        SwipeRefreshLayout swipeRefreshLayout3 = this.refreshLayout;
        if (swipeRefreshLayout3 == null) {
            b41.A("refreshLayout");
        }
        swipeRefreshLayout3.setOnRefreshListener(new d());
        SwipeRefreshLayout swipeRefreshLayout4 = this.refreshLayout;
        if (swipeRefreshLayout4 == null) {
            b41.A("refreshLayout");
        }
        swipeRefreshLayout4.setOnChildScrollUpCallback(new e());
        this.webView = (TaoMaiUCWebView) view.findViewById(R$id.webview);
        this.webContainer = (ViewGroup) view.findViewById(R$id.web_container);
        View findViewById4 = view.findViewById(R$id.horizontal_progress);
        b41.h(findViewById4, "root.findViewById(R.id.horizontal_progress)");
        H5Progress h5Progress = (H5Progress) findViewById4;
        this.h5ProgressView = h5Progress;
        if (h5Progress == null) {
            b41.A("h5ProgressView");
        }
        h5Progress.setNotifier(new f());
        H5ToolBar h5ToolBar2 = this.toolbar;
        if (h5ToolBar2 == null) {
            b41.A("toolbar");
        }
        TaoMaiUCWebView taoMaiUCWebView = this.webView;
        b41.f(taoMaiUCWebView);
        this.transparentTitleHelper = new eq2(h5ToolBar2, taoMaiUCWebView);
        H5ToolBar h5ToolBar3 = this.toolbar;
        if (h5ToolBar3 == null) {
            b41.A("toolbar");
        }
        h5ToolBar3.setType(2);
    }

    private final void loadInitUrl() {
        TaoMaiUCWebView taoMaiUCWebView;
        String str = this.url;
        if ((str == null || str.length() == 0) || (taoMaiUCWebView = this.webView) == null) {
            return;
        }
        String str2 = this.url;
        b41.f(str2);
        taoMaiUCWebView.loadUrl(str2);
    }

    private final void notifyH5BackPressed() {
        fireEvent("wvBackClickEvent", null);
    }

    private final void parseArguments() {
        String string;
        String string2;
        Bundle arguments = getArguments();
        this.url = arguments != null ? arguments.getString("url") : null;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string = arguments2.getString("title")) == null) {
            Bundle arguments3 = getArguments();
            string = arguments3 != null ? arguments3.getString("defaultTitle") : null;
        }
        this.title = string;
        Bundle arguments4 = getArguments();
        this.needHideTitleBar = b41.d(arguments4 != null ? arguments4.getString(DamaiConstants.KEY_H5_CONTAINER_HIDE_NAVBAR) : null, "1");
        Bundle arguments5 = getArguments();
        if (arguments5 != null && (string2 = arguments5.getString("rt")) != null) {
            this.readTitle = b41.d(string2, "1");
        }
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            boolean z = true;
            if (arguments6.containsKey("showProgress")) {
                Bundle arguments7 = getArguments();
                String string3 = arguments7 != null ? arguments7.getString("showProgress") : null;
                if (string3 == null || string3.length() == 0) {
                    Bundle arguments8 = getArguments();
                    if (arguments8 == null || !arguments8.getBoolean("showProgress")) {
                        z = false;
                    }
                } else {
                    z = b41.d(string3, "true");
                }
                this.enableProgressBar = z;
            }
        }
    }

    private final void registerProvider4Bridge() {
        TaoMaiUCWebView taoMaiUCWebView = this.webView;
        if (taoMaiUCWebView != null) {
            taoMaiUCWebView.addJsObject(Subject.FRAGMENT, this);
        }
        TaoMaiUCWebView taoMaiUCWebView2 = this.webView;
        if (taoMaiUCWebView2 != null) {
            taoMaiUCWebView2.addJsObject("NavigationBarProvider", this);
        }
        TaoMaiUCWebView taoMaiUCWebView3 = this.webView;
        if (taoMaiUCWebView3 != null) {
            taoMaiUCWebView3.addJsObject("KeyboardHookProvider", this);
        }
    }

    private final void resetTitleStatus() {
        this.hasSetTitleFromBridge = false;
        this.hasSetTransparentTitleFromBridge = false;
    }

    private final void setTitleIfNeed(String str) {
        boolean K;
        boolean K2;
        if (this.hasSetTitleFromBridge) {
            return;
        }
        if (this.readTitle && str != null) {
            K = StringsKt__StringsKt.K(str, "http", false, 2, null);
            if (!K) {
                K2 = StringsKt__StringsKt.K(str, "mapi", false, 2, null);
                if (!K2) {
                    TitleBar titleBar = this.titleBar;
                    if (titleBar == null) {
                        b41.A("titleBar");
                    }
                    titleBar.setTitle(str);
                    return;
                }
            }
        }
        TitleBar titleBar2 = this.titleBar;
        if (titleBar2 == null) {
            b41.A("titleBar");
        }
        titleBar2.setTitle("");
    }

    private final void setupWebView() {
        WebSettings settings;
        WVUIModel wvUIModel;
        View errorView;
        TaoMaiUCWebView taoMaiUCWebView = this.webView;
        if (taoMaiUCWebView != null) {
            taoMaiUCWebView.setWebChromeClient(createWebViewChromeClient());
        }
        TaoMaiUCWebView taoMaiUCWebView2 = this.webView;
        if (taoMaiUCWebView2 != null) {
            taoMaiUCWebView2.setWebViewClient(createWebViewClient());
        }
        TaoMaiUCWebView taoMaiUCWebView3 = this.webView;
        if (taoMaiUCWebView3 != null && (wvUIModel = taoMaiUCWebView3.getWvUIModel()) != null && (errorView = wvUIModel.getErrorView()) != null) {
            errorView.setOnClickListener(new h());
        }
        TaoMaiUCWebView taoMaiUCWebView4 = this.webView;
        if (taoMaiUCWebView4 == null || (settings = taoMaiUCWebView4.getSettings()) == null) {
            return;
        }
        settings.setMixedContentMode(0);
    }

    private final void showLoading() {
    }

    @NotNull
    public bl2 createWebViewChromeClient() {
        FragmentActivity requireActivity = requireActivity();
        b41.h(requireActivity, "requireActivity()");
        return new a(requireActivity);
    }

    @NotNull
    public cl2 createWebViewClient() {
        FragmentActivity requireActivity = requireActivity();
        b41.h(requireActivity, "requireActivity()");
        return new b(requireActivity);
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void enableHookBackBtn() {
        setHookBackKey(true);
    }

    @Override // com.taomai.android.h5container.provider.IH5EventDispatcher
    public void fireEvent(@Nullable String str, @Nullable String str2) {
        if (this.webView == null || !kp0.a(this)) {
            return;
        }
        al2.a(this.webView, str, str2);
    }

    @Override // com.taomai.android.h5container.provider.IH5EventDispatcher
    public void fireGlobalEvent(@Nullable String str, @Nullable String str2) {
        al2.b(str, str2);
    }

    @Nullable
    public final Function4<WebView, Integer, String, String, wt2> getPageLoadErrorListener() {
        return this.pageLoadErrorListener;
    }

    @Nullable
    public final Function2<WebView, String, wt2> getPageLoadFinishListener() {
        return this.pageLoadFinishListener;
    }

    @Nullable
    public final Function3<WebView, String, Bitmap, wt2> getPageLoadStartListener() {
        return this.pageLoadStartListener;
    }

    @NotNull
    public final TitleBar getTitleBar() {
        TitleBar titleBar = this.titleBar;
        if (titleBar == null) {
            b41.A("titleBar");
        }
        return titleBar;
    }

    @NotNull
    public final H5ToolBar getToolbar() {
        H5ToolBar h5ToolBar = this.toolbar;
        if (h5ToolBar == null) {
            b41.A("toolbar");
        }
        return h5ToolBar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final TaoMaiUCWebView getWebView() {
        return this.webView;
    }

    public final void handleOnPageFinished(@Nullable WebView webView, @Nullable String str) {
        eq2 eq2Var;
        SwipeRefreshLayout swipeRefreshLayout = this.refreshLayout;
        if (swipeRefreshLayout == null) {
            b41.A("refreshLayout");
        }
        swipeRefreshLayout.setRefreshing(false);
        this.isLoadSuccess = true;
        setTitleIfNeed(webView != null ? webView.getTitle() : null);
        notifyProgressEnd();
        hideLoading();
        hideEmptyOrErrorView();
        if (!this.hasSetTransparentTitleFromBridge && (eq2Var = this.transparentTitleHelper) != null) {
            eq2Var.j(null);
        }
        Function2<? super WebView, ? super String, wt2> function2 = this.pageLoadFinishListener;
        if (function2 != null) {
            function2.invoke(webView, str);
        }
    }

    public final void handleOnPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
        setHookBackKey(false);
        resetTitleStatus();
        showLoading();
        showProgressIfEnable();
        this.isLoadSuccess = false;
        Function3<? super WebView, ? super String, ? super Bitmap, wt2> function3 = this.pageLoadStartListener;
        if (function3 != null) {
            function3.invoke(webView, str, bitmap);
        }
    }

    public void handleOnReceivedError(@Nullable WebView webView, int i, @Nullable String str, @Nullable String str2) {
        fb1.b("TaoMaiH5Container", "H5Page load error: code:" + i + "   description:" + str + "   url:" + str2);
        SwipeRefreshLayout swipeRefreshLayout = this.refreshLayout;
        if (swipeRefreshLayout == null) {
            b41.A("refreshLayout");
        }
        swipeRefreshLayout.setRefreshing(false);
        hideLoading();
        showEmptyOrErrorView();
        TaoMaiUCWebView taoMaiUCWebView = this.webView;
        b41.f(taoMaiUCWebView);
        taoMaiUCWebView.loadUrl("javascript:document.body.innerHTML=\"" + jn1.QUOTE);
        Function4<? super WebView, ? super Integer, ? super String, ? super String, wt2> function4 = this.pageLoadErrorListener;
        if (function4 != null) {
            function4.invoke(webView, Integer.valueOf(i), str, str2);
        }
    }

    public void hideEmptyOrErrorView() {
        WVUIModel wvUIModel;
        TaoMaiUCWebView taoMaiUCWebView = this.webView;
        if (taoMaiUCWebView == null || (wvUIModel = taoMaiUCWebView.getWvUIModel()) == null) {
            return;
        }
        wvUIModel.hideErrorPage();
    }

    public final void hideTitleBar() {
        H5ToolBar h5ToolBar = this.toolbar;
        if (h5ToolBar == null) {
            b41.A("toolbar");
        }
        h5ToolBar.setVisibility(8);
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void hideWebOptionMenu() {
        TitleBar titleBar = this.titleBar;
        if (titleBar == null) {
            b41.A("titleBar");
        }
        View rightButton = titleBar.getRightButton();
        if (rightButton != null) {
            rightButton.setVisibility(8);
        }
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void hideWebTitle() {
        H5ToolBar h5ToolBar = this.toolbar;
        if (h5ToolBar == null) {
            b41.A("toolbar");
        }
        h5ToolBar.setVisibility(8);
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void hideWebTitleBackBtn() {
        TitleBar titleBar = this.titleBar;
        if (titleBar == null) {
            b41.A("titleBar");
        }
        View leftButton = titleBar.getLeftButton();
        b41.h(leftButton, "titleBar.leftButton");
        leftButton.setVisibility(8);
    }

    @Override // com.taomai.android.h5container.provider.IKeyboardHookProvider
    public boolean isBackHooked() {
        return this.hookBackEvent;
    }

    public final boolean isLoadSuccess() {
        return this.isLoadSuccess;
    }

    public final void loadUrl(@NotNull String str) {
        b41.i(str, "url");
        TaoMaiUCWebView taoMaiUCWebView = this.webView;
        if (taoMaiUCWebView != null) {
            taoMaiUCWebView.loadUrl(str);
        }
    }

    public final void notifyProgressEnd() {
        if (this.enableProgressBar) {
            H5Progress h5Progress = this.h5ProgressView;
            if (h5Progress == null) {
                b41.A("h5ProgressView");
            }
            updateProgress(h5Progress.getMax());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        setupWebView();
        registerProvider4Bridge();
        if (getUserVisibleHint()) {
            loadInitUrl();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        TaoMaiUCWebView taoMaiUCWebView = this.webView;
        if (taoMaiUCWebView != null) {
            taoMaiUCWebView.onActivityResult(i, i2, intent);
        }
    }

    public boolean onBackPressed() {
        if (isBackHooked()) {
            notifyH5BackPressed();
            return true;
        }
        TaoMaiUCWebView taoMaiUCWebView = this.webView;
        if (taoMaiUCWebView != null) {
            return taoMaiUCWebView.back();
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        parseArguments();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        b41.i(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(R$layout.fragment_taomai_h5_container_layout, viewGroup, false);
        b41.h(inflate, "view");
        initView(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        TaoMaiUCWebView taoMaiUCWebView = this.webView;
        if (taoMaiUCWebView != null) {
            if (taoMaiUCWebView != null) {
                taoMaiUCWebView.doDestory();
            }
            this.webView = null;
        }
        try {
            super.onDestroy();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            pageDisappear();
        } else {
            pageAppear();
        }
    }

    @Override // com.taomai.android.h5container.utils.ActivityStackManager.IActivityStackBackEvent
    public void onPageBackResult(@Nullable String str) {
        String str2;
        if (str != null) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("data", new org.json.JSONObject(str));
            str2 = jSONObject.toString();
        } else {
            str2 = null;
        }
        TaoMaiUCWebView taoMaiUCWebView = this.webView;
        if (taoMaiUCWebView != null) {
            taoMaiUCWebView.setDataOnActive(str2);
        }
        fireEvent("wvPopToDataEvent", str2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        TaoMaiUCWebView taoMaiUCWebView = this.webView;
        if (taoMaiUCWebView != null) {
            taoMaiUCWebView.onPause();
        }
        super.onPause();
        if (isHidden() || !getUserVisibleHint()) {
            return;
        }
        pageDisappear();
    }

    public void onRefresh() {
        reload();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        TaoMaiUCWebView taoMaiUCWebView = this.webView;
        if (taoMaiUCWebView != null) {
            taoMaiUCWebView.onResume();
        }
        super.onResume();
        if (isHidden() || !getUserVisibleHint()) {
            return;
        }
        pageAppear();
    }

    public void pageAppear() {
    }

    public void pageDisappear() {
    }

    public final void reload() {
        TaoMaiUCWebView taoMaiUCWebView = this.webView;
        if (taoMaiUCWebView != null) {
            taoMaiUCWebView.reload();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(@Nullable Bundle bundle) {
        super.setArguments(bundle);
        parseArguments();
    }

    public final void setEnableProgress(boolean z) {
        this.enableProgressBar = z;
        if (z) {
            H5Progress h5Progress = this.h5ProgressView;
            if (h5Progress == null) {
                b41.A("h5ProgressView");
            }
            h5Progress.showProgress();
            return;
        }
        H5Progress h5Progress2 = this.h5ProgressView;
        if (h5Progress2 == null) {
            b41.A("h5ProgressView");
        }
        h5Progress2.hideProgress();
    }

    @Override // com.taomai.android.h5container.provider.IKeyboardHookProvider
    public void setHookBackKey(boolean z) {
        this.hookBackEvent = z;
    }

    public final void setPageLoadErrorListener(@Nullable Function4<? super WebView, ? super Integer, ? super String, ? super String, wt2> function4) {
        this.pageLoadErrorListener = function4;
    }

    public final void setPageLoadFinishListener(@Nullable Function2<? super WebView, ? super String, wt2> function2) {
        this.pageLoadFinishListener = function2;
    }

    public final void setPageLoadStartListener(@Nullable Function3<? super WebView, ? super String, ? super Bitmap, wt2> function3) {
        this.pageLoadStartListener = function3;
    }

    public final void setTitleBar(@NotNull TitleBar titleBar) {
        b41.i(titleBar, "<set-?>");
        this.titleBar = titleBar;
    }

    public final void setToolbar(@NotNull H5ToolBar h5ToolBar) {
        b41.i(h5ToolBar, "<set-?>");
        this.toolbar = h5ToolBar;
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void setTransparentTitle(@Nullable String str) {
        this.hasSetTransparentTitleFromBridge = true;
        eq2 eq2Var = this.transparentTitleHelper;
        if (eq2Var != null) {
            eq2Var.n(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setUrl(@Nullable String str) {
        this.url = str;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        if (z && isVisible() && !this.isLoadSuccess) {
            loadInitUrl();
        }
        super.setUserVisibleHint(z);
        if (z) {
            pageAppear();
        } else {
            pageDisappear();
        }
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void setWebOptionMenu(@Nullable JSONObject jSONObject, @NotNull View.OnClickListener onClickListener) {
        b41.i(onClickListener, "listener");
        if (jSONObject == null) {
            return;
        }
        String string = jSONObject.getString("title");
        String string2 = jSONObject.getString("color");
        String string3 = jSONObject.getString(RemoteMessageConst.Notification.ICON);
        String string4 = jSONObject.getString("icontype");
        if (string4 == null) {
            string4 = jSONObject.getString("iconType");
        }
        boolean booleanValue = jSONObject.getBooleanValue("reset");
        boolean z = true;
        if (string == null || string.length() == 0) {
            if (string3 == null || string3.length() == 0) {
                if (string4 == null || string4.length() == 0) {
                    return;
                }
            }
        }
        TitleBar titleBar = this.titleBar;
        if (titleBar == null) {
            b41.A("titleBar");
        }
        View findViewById = titleBar.getRightButton().findViewById(R$id.titlebar_image);
        b41.h(findViewById, "titleBar.rightButton.fin…ById(R.id.titlebar_image)");
        ImageView imageView = (ImageView) findViewById;
        if (booleanValue) {
            imageView.setImageBitmap(null);
            TitleBar titleBar2 = this.titleBar;
            if (titleBar2 == null) {
                b41.A("titleBar");
            }
            titleBar2.setRightButtonText("");
            TitleBar titleBar3 = this.titleBar;
            if (titleBar3 == null) {
                b41.A("titleBar");
            }
            titleBar3.setRightButtonListener(null);
            return;
        }
        TitleBar titleBar4 = this.titleBar;
        if (titleBar4 == null) {
            b41.A("titleBar");
        }
        titleBar4.setRightButtonListener(new g(jSONObject, onClickListener));
        if (string3 == null || string3.length() == 0) {
            imageView.setVisibility(8);
        } else {
            TitleBar titleBar5 = this.titleBar;
            if (titleBar5 == null) {
                b41.A("titleBar");
            }
            View rightButton = titleBar5.getRightButton();
            b41.h(rightButton, "titleBar.rightButton");
            rightButton.setVisibility(0);
            imageView.setVisibility(0);
            ImageTool.b(string3, imageView);
        }
        if (string == null || string.length() == 0) {
            if (string4 != null) {
                int hashCode = string4.hashCode();
                if (hashCode != 109400031) {
                    if (hashCode == 1434631203 && string4.equals("settings")) {
                        string = getString(R$string.h5_ic_settings);
                    }
                } else if (string4.equals("share")) {
                    string = getString(R$string.h5_ic_share);
                }
            }
            string = null;
        }
        if (string4 != null && string4.length() != 0) {
            z = false;
        }
        if (z) {
            TitleBar titleBar6 = this.titleBar;
            if (titleBar6 == null) {
                b41.A("titleBar");
            }
            titleBar6.setRightButtonTextSize(16);
        } else {
            TitleBar titleBar7 = this.titleBar;
            if (titleBar7 == null) {
                b41.A("titleBar");
            }
            titleBar7.setRightButtonTextSize(22);
        }
        TitleBar titleBar8 = this.titleBar;
        if (titleBar8 == null) {
            b41.A("titleBar");
        }
        titleBar8.setRightButtonText(string != null ? string : "");
        if (string2 != null) {
            try {
                TitleBar titleBar9 = this.titleBar;
                if (titleBar9 == null) {
                    b41.A("titleBar");
                }
                titleBar9.setRightButtonTextColor(Color.parseColor(string2));
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void setWebTitle(@Nullable String str) {
        this.hasSetTitleFromBridge = true;
        TitleBar titleBar = this.titleBar;
        if (titleBar == null) {
            b41.A("titleBar");
        }
        if (str == null) {
            str = "";
        }
        titleBar.setTitle(str);
    }

    public void showEmptyOrErrorView() {
        WVUIModel wvUIModel;
        TaoMaiUCWebView taoMaiUCWebView = this.webView;
        if (taoMaiUCWebView == null || (wvUIModel = taoMaiUCWebView.getWvUIModel()) == null) {
            return;
        }
        wvUIModel.loadErrorPage();
    }

    public final void showProgressIfEnable() {
        if (this.enableProgressBar) {
            H5Progress h5Progress = this.h5ProgressView;
            if (h5Progress == null) {
                b41.A("h5ProgressView");
            }
            h5Progress.showProgress();
            H5Progress h5Progress2 = this.h5ProgressView;
            if (h5Progress2 == null) {
                b41.A("h5ProgressView");
            }
            h5Progress2.updateProgress(10);
        }
    }

    public final void showTitleBar() {
        H5ToolBar h5ToolBar = this.toolbar;
        if (h5ToolBar == null) {
            b41.A("toolbar");
        }
        h5ToolBar.setVisibility(0);
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void showWebOptionMenu() {
        TitleBar titleBar = this.titleBar;
        if (titleBar == null) {
            b41.A("titleBar");
        }
        View rightButton = titleBar.getRightButton();
        if (rightButton != null) {
            rightButton.setVisibility(0);
        }
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void showWebTitle() {
        H5ToolBar h5ToolBar = this.toolbar;
        if (h5ToolBar == null) {
            b41.A("toolbar");
        }
        h5ToolBar.setVisibility(0);
    }

    @Override // com.taomai.android.h5container.provider.INavigationBarProvider
    public void showWebTitleBackBtn() {
        TitleBar titleBar = this.titleBar;
        if (titleBar == null) {
            b41.A("titleBar");
        }
        View leftButton = titleBar.getLeftButton();
        b41.h(leftButton, "titleBar.leftButton");
        leftButton.setVisibility(0);
    }

    public final void updateProgress(int i) {
        if (this.enableProgressBar) {
            H5Progress h5Progress = this.h5ProgressView;
            if (h5Progress == null) {
                b41.A("h5ProgressView");
            }
            h5Progress.updateProgress(i);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static final class b extends cl2 {
        b(Context context) {
            super(context);
        }

        @Override // tb.cl2, android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public void onPageFinished(@Nullable WebView webView, @Nullable String str) {
            super.onPageFinished(webView, str);
            TaoMaiUCH5Fragment.this.handleOnPageFinished(webView, str);
        }

        @Override // tb.cl2, android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            TaoMaiUCH5Fragment.this.handleOnPageStarted(webView, str, bitmap);
        }

        @Override // android.taobao.windvane.extra.uc.WVUCWebViewClient, com.uc.webview.export.WebViewClient
        public void onReceivedError(@Nullable WebView webView, int i, @Nullable String str, @Nullable String str2) {
            super.onReceivedError(webView, i, str, str2);
            TaoMaiUCH5Fragment.this.handleOnReceivedError(webView, i, str, str2);
        }

        @Override // com.uc.webview.export.WebViewClient
        public void onReceivedError(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest, @Nullable WebResourceError webResourceError) {
            super.onReceivedError(TaoMaiUCH5Fragment.this.getWebView(), webResourceRequest, webResourceError);
            TaoMaiUCH5Fragment.this.handleOnReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    public void handleOnReceivedError(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest, @Nullable WebResourceError webResourceError) {
        boolean F;
        boolean F2;
        Uri url;
        if (b41.d((webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString(), this.url)) {
            String valueOf = String.valueOf(webResourceError != null ? Integer.valueOf(webResourceError.getErrorCode()) : null);
            F = o.F(valueOf, "4", false, 2, null);
            if (!F) {
                F2 = o.F(valueOf, "5", false, 2, null);
                if (!F2) {
                    return;
                }
            }
            SwipeRefreshLayout swipeRefreshLayout = this.refreshLayout;
            if (swipeRefreshLayout == null) {
                b41.A("refreshLayout");
            }
            swipeRefreshLayout.setRefreshing(false);
            hideLoading();
            TaoMaiUCWebView taoMaiUCWebView = this.webView;
            b41.f(taoMaiUCWebView);
            taoMaiUCWebView.loadUrl("javascript:document.body.innerHTML=\"" + jn1.QUOTE);
            showEmptyOrErrorView();
        }
    }
}
