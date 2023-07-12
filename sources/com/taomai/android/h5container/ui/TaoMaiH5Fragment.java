package com.taomai.android.h5container.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.webview.WVUIModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import cn.damai.common.DamaiConstants;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.x.C4345d;
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
import com.taomai.android.h5container.webview.TaoMaiWebChromeClient;
import com.taomai.android.h5container.webview.TaoMaiWebClient;
import com.taomai.android.h5container.webview.TaoMaiWebView;
import com.taomai.android.h5container.widget.H5Progress;
import com.taomai.android.h5container.widget.H5ToolBar;
import com.taomai.android.h5container.widget.TitleBar;
import com.tencent.open.SocialConstants;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.media.MessageID;
import com.youku.arch.v3.event.Subject;
import kotlin.C8177b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.text.C8604o;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.al2;
import tb.b41;
import tb.fb1;
import tb.jn1;
import tb.kp0;
import tb.mo2;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\t¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010!\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0015H\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0015H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\b\u0010'\u001a\u00020\u0006H\u0016J\b\u0010(\u001a\u00020\u0006H\u0016J\u0012\u0010*\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u00100\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\b\u00101\u001a\u00020\u0006H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\u001a\u00103\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u00104\u001a\u00020\u0006H\u0016J\u0010\u00105\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u0015H\u0016J\u0006\u00106\u001a\u00020\u0006J\u0006\u00107\u001a\u00020\u0006J\u000e\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0015J\u000e\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u001fJ\b\u0010<\u001a\u00020\u0006H\u0016J\u000e\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020+J\u0006\u0010?\u001a\u00020\u0006J\u0006\u0010@\u001a\u00020\u0006J\u0006\u0010A\u001a\u00020\u0006J\u000e\u0010C\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u000fJ\b\u0010D\u001a\u00020\u0006H\u0016J\u0010\u0010F\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u0015H\u0016J\b\u0010G\u001a\u00020\u0015H\u0016J\b\u0010H\u001a\u00020\u0015H\u0016J\u001c\u0010J\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010\u000f2\b\u0010/\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010L\u001a\u00020\u00062\b\u0010K\u001a\u0004\u0018\u00010\u000f2\b\u0010/\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010M\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010N\u001a\u00020\u0006H\u0016J\b\u0010O\u001a\u00020\u0006H\u0016J\b\u0010P\u001a\u00020\u0006H\u0016J\b\u0010Q\u001a\u00020\u0006H\u0016J\u001a\u0010V\u001a\u00020\u00062\b\u0010S\u001a\u0004\u0018\u00010R2\u0006\u0010U\u001a\u00020TH\u0016J\b\u0010W\u001a\u00020\u0006H\u0016J\b\u0010X\u001a\u00020\u0006H\u0016J\b\u0010Y\u001a\u00020\u0006H\u0016J\u0012\u0010[\u001a\u00020\u00062\b\u0010Z\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010]\u001a\u00020\u00062\b\u0010\\\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010a\u001a\u00020\u00062\b\u0010^\u001a\u0004\u0018\u00010\u001f2\b\u0010`\u001a\u0004\u0018\u00010_H\u0016J\u000e\u0010c\u001a\u00020\u00062\u0006\u0010b\u001a\u00020\u0015Ro\u0010j\u001aO\u0012\u0015\u0012\u0013\u0018\u00010e¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(^\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(B\u0012\u0015\u0012\u0013\u0018\u00010h¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(i\u0012\u0004\u0012\u00020\u0006\u0018\u00010d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oRX\u0010q\u001a8\u0012\u0015\u0012\u0013\u0018\u00010e¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(^\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u0006\u0018\u00010p8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0085\u0001\u0010{\u001ad\u0012\u0015\u0012\u0013\u0018\u00010e¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(^\u0012\u0013\u0012\u00110+¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(x\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(y\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\bf\u0012\b\bg\u0012\u0004\b\b(z\u0012\u0004\u0012\u00020\u0006\u0018\u00010w8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R*\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R*\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R0\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001a\u0010\u0098\u0001\u001a\u00030\u0097\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001a\u0010\u009b\u0001\u001a\u00030\u009a\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0019\u0010\u009d\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0019\u0010B\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bB\u0010\u009f\u0001R\u0019\u0010 \u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010\u009e\u0001R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0010\u0010\u009f\u0001R\u0019\u0010¡\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¡\u0001\u0010\u009e\u0001R\u0019\u0010¢\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010\u009e\u0001R\u0019\u0010£\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010\u009e\u0001R\u0019\u0010¤\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¤\u0001\u0010\u009e\u0001R\u001b\u0010¥\u0001\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¥\u0001\u0010\u0096\u0001R*\u0010¦\u0001\u001a\u00020\u00152\u0007\u0010\u0090\u0001\u001a\u00020\u00158\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b¦\u0001\u0010\u009e\u0001\u001a\u0006\b¦\u0001\u0010§\u0001R#\u0010\u00ad\u0001\u001a\u00030¨\u00018B@\u0002X\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b©\u0001\u0010ª\u0001\u001a\u0006\b«\u0001\u0010¬\u0001R,\u0010¯\u0001\u001a\u0005\u0018\u00010®\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001R*\u0010¸\u0001\u001a\u0013\u0012\f\u0012\n\u0012\u0005\u0012\u00030·\u00010¶\u0001\u0018\u00010µ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u001b\u0010º\u0001\u001a\u0004\u0018\u00010_8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u001b\u0010¼\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u001b\u0010¾\u0001\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001¨\u0006Â\u0001"}, d2 = {"Lcom/taomai/android/h5container/ui/TaoMaiH5Fragment;", "Landroidx/fragment/app/Fragment;", "Lcom/taomai/android/h5container/provider/IKeyboardHookProvider;", "Lcom/taomai/android/h5container/provider/IH5EventDispatcher;", "Lcom/taomai/android/h5container/provider/INavigationBarProvider;", "Lcom/taomai/android/h5container/utils/ActivityStackManager$IActivityStackBackEvent;", "Ltb/wt2;", "registerProvider4Bridge", "parseArguments", "showEmptyOrErrorView", "hideEmptyOrErrorView", "showLoading", "hideLoading", "notifyH5BackPressed", "loadInitUrl", "", "title", "setTitleIfNeed", "resetTitleStatus", "Landroid/app/Activity;", "activity", "", "fullscreen", "setCustomFullscreen", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED, "isVisibleToUser", "setUserVisibleHint", "hidden", "onHiddenChanged", "onResume", MessageID.onPause, "onDestroy", "args", "setArguments", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "pageAppear", "pageDisappear", "createView", "handleOnActivityCreated", "handleUserVisibleHint", TMNavigationBarPlugin.ACTION_SHOW_TITLE_BAR, TMNavigationBarPlugin.ACTION_HIDE_TITLE_BAR, "enable", "setEnableProgress", "root", "initView", "setupWebView", "progress", UCCore.EVENT_UPDATE_PROGRESS, "notifyProgressEnd", "showProgressIfEnable", "reload", "url", "loadUrl", C4345d.p, "enableHook", "setHookBackKey", "isBackHooked", "onBackPressed", "type", WXBridgeManager.METHOD_FIRE_EVENT, "eventName", "fireGlobalEvent", "setWebTitle", "showWebTitle", "hideWebTitle", "showWebOptionMenu", "hideWebOptionMenu", "Lcom/alibaba/fastjson/JSONObject;", "menu", "Landroid/view/View$OnClickListener;", "listener", "setWebOptionMenu", "showWebTitleBackBtn", "hideWebTitleBackBtn", "enableHookBackBtn", "transparentTitle", TMNavigationBarPlugin.ACTION_SET_TRANSPARENT_TITLE, "jsonData", "onPageBackResult", "view", "Landroid/webkit/WebChromeClient$CustomViewCallback;", WXBridgeManager.METHOD_CALLBACK, "showCustomView", "fromSystem", "hideCustomView", "Lkotlin/Function3;", "Landroid/webkit/WebView;", "Lkotlin/ParameterName;", "name", "Landroid/graphics/Bitmap;", "favicon", "pageLoadStartListener", "Lkotlin/jvm/functions/Function3;", "getPageLoadStartListener", "()Lkotlin/jvm/functions/Function3;", "setPageLoadStartListener", "(Lkotlin/jvm/functions/Function3;)V", "Lkotlin/Function2;", "pageLoadFinishListener", "Lkotlin/jvm/functions/Function2;", "getPageLoadFinishListener", "()Lkotlin/jvm/functions/Function2;", "setPageLoadFinishListener", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function4;", "errorCode", SocialConstants.PARAM_COMMENT, "failingUrl", "pageLoadErrorListener", "Lkotlin/jvm/functions/Function4;", "getPageLoadErrorListener", "()Lkotlin/jvm/functions/Function4;", "setPageLoadErrorListener", "(Lkotlin/jvm/functions/Function4;)V", "Lcom/taomai/android/h5container/widget/H5ToolBar;", "toolbar", "Lcom/taomai/android/h5container/widget/H5ToolBar;", "getToolbar", "()Lcom/taomai/android/h5container/widget/H5ToolBar;", "setToolbar", "(Lcom/taomai/android/h5container/widget/H5ToolBar;)V", "Lcom/taomai/android/h5container/widget/TitleBar;", "titleBar", "Lcom/taomai/android/h5container/widget/TitleBar;", "getTitleBar", "()Lcom/taomai/android/h5container/widget/TitleBar;", "setTitleBar", "(Lcom/taomai/android/h5container/widget/TitleBar;)V", "Lcom/taomai/android/h5container/webview/TaoMaiWebView;", "<set-?>", "webView", "Lcom/taomai/android/h5container/webview/TaoMaiWebView;", "getWebView", "()Lcom/taomai/android/h5container/webview/TaoMaiWebView;", "webContainer", "Landroid/view/ViewGroup;", "Lcom/taomai/android/h5container/widget/H5Progress;", "h5ProgressView", "Lcom/taomai/android/h5container/widget/H5Progress;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "refreshLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "enableProgressBar", "Z", "Ljava/lang/String;", "hookBackEvent", "needHideTitleBar", "readTitle", "hasSetTitleFromBridge", "hasSetTransparentTitleFromBridge", "videoPlayerContainer", "isLoadSuccess", "()Z", "Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "getHandler", "()Landroid/os/Handler;", "handler", "Landroid/view/ViewParent;", "scrollableViewParent", "Landroid/view/ViewParent;", "getScrollableViewParent", "()Landroid/view/ViewParent;", "setScrollableViewParent", "(Landroid/view/ViewParent;)V", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "filePathCallback", "Landroid/webkit/ValueCallback;", "mCallBack", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "originalVisibility", "Ljava/lang/Integer;", "mCustomView", "Landroid/view/View;", "<init>", "()V", "h5container_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes11.dex */
public class TaoMaiH5Fragment extends Fragment implements IH5EventDispatcher, IKeyboardHookProvider, INavigationBarProvider, ActivityStackManager.IActivityStackBackEvent {
    private ValueCallback<Uri[]> filePathCallback;
    private H5Progress h5ProgressView;
    private final Lazy handler$delegate;
    private boolean hasSetTitleFromBridge;
    private boolean hasSetTransparentTitleFromBridge;
    private boolean hookBackEvent;
    private boolean isLoadSuccess;
    private WebChromeClient.CustomViewCallback mCallBack;
    private View mCustomView;
    private boolean needHideTitleBar;
    private Integer originalVisibility;
    @Nullable
    private Function4<? super WebView, ? super Integer, ? super String, ? super String, wt2> pageLoadErrorListener;
    @Nullable
    private Function2<? super WebView, ? super String, wt2> pageLoadFinishListener;
    @Nullable
    private Function3<? super WebView, ? super String, ? super Bitmap, wt2> pageLoadStartListener;
    private SwipeRefreshLayout refreshLayout;
    @Nullable
    private ViewParent scrollableViewParent;
    private String title;
    public TitleBar titleBar;
    public H5ToolBar toolbar;
    private mo2 transparentTitleHelper;
    private String url;
    private ViewGroup videoPlayerContainer;
    private ViewGroup webContainer;
    @Nullable
    private TaoMaiWebView webView;
    private boolean enableProgressBar = true;
    private boolean readTitle = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.ui.TaoMaiH5Fragment$a */
    /* loaded from: classes11.dex */
    public static final class View$OnClickListenerC7005a implements View.OnClickListener {
        View$OnClickListenerC7005a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            FragmentActivity activity = TaoMaiH5Fragment.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.ui.TaoMaiH5Fragment$b */
    /* loaded from: classes11.dex */
    public static final class C7006b implements SwipeRefreshLayout.OnRefreshListener {
        C7006b() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            TaoMaiH5Fragment.this.onRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.ui.TaoMaiH5Fragment$c */
    /* loaded from: classes11.dex */
    public static final class C7007c implements SwipeRefreshLayout.OnChildScrollUpCallback {
        C7007c() {
        }

        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnChildScrollUpCallback
        public final boolean canChildScrollUp(@NotNull SwipeRefreshLayout swipeRefreshLayout, @Nullable View view) {
            b41.i(swipeRefreshLayout, "swipeRefreshLayout");
            try {
                if (TaoMaiH5Fragment.this.getWebView() != null) {
                    TaoMaiWebView webView = TaoMaiH5Fragment.this.getWebView();
                    b41.f(webView);
                    return webView.getScrollY() > 0;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.ui.TaoMaiH5Fragment$d */
    /* loaded from: classes11.dex */
    public static final class C7008d implements H5Progress.ProgressNotifier {
        C7008d() {
        }

        @Override // com.taomai.android.h5container.widget.H5Progress.ProgressNotifier
        public void onProgressBegin() {
        }

        @Override // com.taomai.android.h5container.widget.H5Progress.ProgressNotifier
        public void onProgressEnd() {
            TaoMaiH5Fragment.access$getH5ProgressView$p(TaoMaiH5Fragment.this).hideAndResetProgress();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.ui.TaoMaiH5Fragment$e */
    /* loaded from: classes11.dex */
    static final class View$OnClickListenerC7009e implements View.OnClickListener {
        final /* synthetic */ JSONObject b;
        final /* synthetic */ View.OnClickListener c;

        View$OnClickListenerC7009e(JSONObject jSONObject, View.OnClickListener onClickListener) {
            this.b = jSONObject;
            this.c = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TaoMaiH5Fragment.this.fireEvent("optionMenu", this.b.toJSONString());
            this.c.onClick(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taomai.android.h5container.ui.TaoMaiH5Fragment$f */
    /* loaded from: classes11.dex */
    public static final class View$OnClickListenerC7010f implements View.OnClickListener {
        View$OnClickListenerC7010f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TaoMaiWebView webView = TaoMaiH5Fragment.this.getWebView();
            if (webView != null) {
                webView.reload();
            }
        }
    }

    public TaoMaiH5Fragment() {
        Lazy b;
        b = C8177b.b(new Function0<Handler>() { // from class: com.taomai.android.h5container.ui.TaoMaiH5Fragment$handler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.handler$delegate = b;
    }

    public static final /* synthetic */ H5Progress access$getH5ProgressView$p(TaoMaiH5Fragment taoMaiH5Fragment) {
        H5Progress h5Progress = taoMaiH5Fragment.h5ProgressView;
        if (h5Progress == null) {
            b41.A("h5ProgressView");
        }
        return h5Progress;
    }

    public static final /* synthetic */ SwipeRefreshLayout access$getRefreshLayout$p(TaoMaiH5Fragment taoMaiH5Fragment) {
        SwipeRefreshLayout swipeRefreshLayout = taoMaiH5Fragment.refreshLayout;
        if (swipeRefreshLayout == null) {
            b41.A("refreshLayout");
        }
        return swipeRefreshLayout;
    }

    private final Handler getHandler() {
        return (Handler) this.handler$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideEmptyOrErrorView() {
        WVUIModel wvUIModel;
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView == null || (wvUIModel = taoMaiWebView.getWvUIModel()) == null) {
            return;
        }
        wvUIModel.hideErrorPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoading() {
    }

    private final void loadInitUrl() {
        TaoMaiWebView taoMaiWebView;
        String str = this.url;
        if ((str == null || str.length() == 0) || (taoMaiWebView = this.webView) == null) {
            return;
        }
        String str2 = this.url;
        b41.f(str2);
        taoMaiWebView.loadUrl(str2);
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
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.addJsObject(Subject.FRAGMENT, this);
        }
        TaoMaiWebView taoMaiWebView2 = this.webView;
        if (taoMaiWebView2 != null) {
            taoMaiWebView2.addJsObject("NavigationBarProvider", this);
        }
        TaoMaiWebView taoMaiWebView3 = this.webView;
        if (taoMaiWebView3 != null) {
            taoMaiWebView3.addJsObject("KeyboardHookProvider", this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetTitleStatus() {
        this.hasSetTitleFromBridge = false;
        this.hasSetTransparentTitleFromBridge = false;
    }

    private final void setCustomFullscreen(Activity activity, boolean z) {
        if (activity == null || activity.getWindow() == null) {
            return;
        }
        Window window = activity.getWindow();
        b41.h(window, "activity.window");
        View decorView = window.getDecorView();
        b41.h(decorView, "activity.window.decorView");
        if (z) {
            decorView.setSystemUiVisibility(5894);
            return;
        }
        Integer num = this.originalVisibility;
        decorView.setSystemUiVisibility(num != null ? num.intValue() : 1280);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTitleIfNeed(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEmptyOrErrorView() {
        WVUIModel wvUIModel;
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView == null || (wvUIModel = taoMaiWebView.getWvUIModel()) == null) {
            return;
        }
        wvUIModel.loadErrorPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoading() {
    }

    @NotNull
    public View createView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        b41.i(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R$layout.fragment_taomai_h5_container_sys_layout, viewGroup, false);
        b41.h(inflate, "view");
        initView(inflate);
        return inflate;
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

    @Nullable
    public final ViewParent getScrollableViewParent() {
        return this.scrollableViewParent;
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

    @Nullable
    public final TaoMaiWebView getWebView() {
        return this.webView;
    }

    public void handleOnActivityCreated() {
        Bundle arguments = getArguments();
        this.url = arguments != null ? arguments.getString("url") : null;
        setupWebView();
        registerProvider4Bridge();
        if (getUserVisibleHint()) {
            loadInitUrl();
        }
    }

    public void handleUserVisibleHint(boolean z) {
        if (z && isVisible() && !this.isLoadSuccess) {
            loadInitUrl();
        }
        if (z) {
            pageAppear();
        } else {
            pageDisappear();
        }
    }

    public final void hideCustomView(boolean z) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            b41.h(activity, "activity ?: return");
            if (!z) {
                try {
                    WebChromeClient.CustomViewCallback customViewCallback = this.mCallBack;
                    if (customViewCallback != null) {
                        customViewCallback.onCustomViewHidden();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            Window window = activity.getWindow();
            b41.h(window, "activity.window");
            View decorView = window.getDecorView();
            if (!(decorView instanceof FrameLayout)) {
                decorView = null;
            }
            FrameLayout frameLayout = (FrameLayout) decorView;
            if (frameLayout != null) {
                frameLayout.removeView(this.videoPlayerContainer);
            }
            ViewGroup viewGroup = this.videoPlayerContainer;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            this.videoPlayerContainer = null;
            this.mCustomView = null;
            this.mCallBack = null;
            setCustomFullscreen(activity, false);
            activity.setRequestedOrientation(1);
        }
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

    public final void initView(@NotNull View view) {
        boolean q;
        b41.i(view, "root");
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
        titleBar4.setLeftButtonListener(new View$OnClickListenerC7005a());
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
        q = C8604o.q("YES", arguments != null ? arguments.getString("pullRefresh") : null, true);
        swipeRefreshLayout2.setEnabled(q);
        SwipeRefreshLayout swipeRefreshLayout3 = this.refreshLayout;
        if (swipeRefreshLayout3 == null) {
            b41.A("refreshLayout");
        }
        swipeRefreshLayout3.setOnRefreshListener(new C7006b());
        SwipeRefreshLayout swipeRefreshLayout4 = this.refreshLayout;
        if (swipeRefreshLayout4 == null) {
            b41.A("refreshLayout");
        }
        swipeRefreshLayout4.setOnChildScrollUpCallback(new C7007c());
        this.webView = (TaoMaiWebView) view.findViewById(R$id.webview);
        this.webContainer = (ViewGroup) view.findViewById(R$id.web_container);
        View findViewById4 = view.findViewById(R$id.horizontal_progress);
        b41.h(findViewById4, "root.findViewById(R.id.horizontal_progress)");
        H5Progress h5Progress = (H5Progress) findViewById4;
        this.h5ProgressView = h5Progress;
        if (h5Progress == null) {
            b41.A("h5ProgressView");
        }
        h5Progress.setNotifier(new C7008d());
        H5ToolBar h5ToolBar2 = this.toolbar;
        if (h5ToolBar2 == null) {
            b41.A("toolbar");
        }
        TaoMaiWebView taoMaiWebView = this.webView;
        b41.f(taoMaiWebView);
        this.transparentTitleHelper = new mo2(h5ToolBar2, taoMaiWebView);
        H5ToolBar h5ToolBar3 = this.toolbar;
        if (h5ToolBar3 == null) {
            b41.A("toolbar");
        }
        h5ToolBar3.setType(2);
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
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.loadUrl(str);
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
        handleOnActivityCreated();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
        r8 = kotlin.collections.ArraysKt___ArraysKt.s(r9);
     */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onActivityResult(int r7, int r8, @org.jetbrains.annotations.Nullable android.content.Intent r9) {
        /*
            r6 = this;
            super.onActivityResult(r7, r8, r9)
            com.taomai.android.h5container.webview.TaoMaiWebView r0 = r6.webView
            if (r0 == 0) goto La
            r0.onActivityResult(r7, r8, r9)
        La:
            r0 = 15
            if (r7 != r0) goto L6c
            r7 = -1
            r0 = 0
            r1 = 0
            if (r8 != r7) goto L4b
            if (r9 == 0) goto L4b
            java.lang.String r7 = r9.getDataString()
            android.content.ClipData r8 = r9.getClipData()
            if (r8 == 0) goto L3e
            int r9 = r8.getItemCount()
            android.net.Uri[] r9 = new android.net.Uri[r9]
            int r2 = r8.getItemCount()
            r3 = 0
        L2a:
            if (r3 >= r2) goto L3f
            android.content.ClipData$Item r4 = r8.getItemAt(r3)
            java.lang.String r5 = "item"
            tb.b41.h(r4, r5)
            android.net.Uri r4 = r4.getUri()
            r9[r3] = r4
            int r3 = r3 + 1
            goto L2a
        L3e:
            r9 = r1
        L3f:
            if (r7 == 0) goto L4c
            r8 = 1
            android.net.Uri[] r9 = new android.net.Uri[r8]
            android.net.Uri r7 = android.net.Uri.parse(r7)
            r9[r0] = r7
            goto L4c
        L4b:
            r9 = r1
        L4c:
            android.webkit.ValueCallback<android.net.Uri[]> r7 = r6.filePathCallback
            if (r7 == 0) goto L6a
            if (r9 == 0) goto L66
            java.util.List r8 = kotlin.collections.C8202e.s(r9)
            if (r8 == 0) goto L66
            android.net.Uri[] r9 = new android.net.Uri[r0]
            java.lang.Object[] r8 = r8.toArray(r9)
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.Array<T>"
            java.util.Objects.requireNonNull(r8, r9)
            android.net.Uri[] r8 = (android.net.Uri[]) r8
            goto L67
        L66:
            r8 = r1
        L67:
            r7.onReceiveValue(r8)
        L6a:
            r6.filePathCallback = r1
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taomai.android.h5container.ui.TaoMaiH5Fragment.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // com.taomai.android.h5container.provider.IKeyboardHookProvider
    public boolean onBackPressed() {
        ViewGroup viewGroup = this.videoPlayerContainer;
        if (viewGroup != null) {
            b41.f(viewGroup);
            if (viewGroup.getChildCount() > 0) {
                hideCustomView(false);
            }
        }
        if (isBackHooked()) {
            notifyH5BackPressed();
            return true;
        }
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            return taoMaiWebView.back();
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
        return createView(layoutInflater, viewGroup);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.doDestory();
        }
        this.webView = null;
        try {
            super.onDestroy();
        } catch (Exception e) {
            e.printStackTrace();
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
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.setDataOnActive(str2);
        }
        fireEvent("wvPopToDataEvent", str2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.onPause();
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
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.onResume();
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
        TaoMaiWebView taoMaiWebView = this.webView;
        if (taoMaiWebView != null) {
            taoMaiWebView.reload();
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

    public final void setScrollableViewParent(@Nullable ViewParent viewParent) {
        this.scrollableViewParent = viewParent;
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
        mo2 mo2Var = this.transparentTitleHelper;
        if (mo2Var != null) {
            mo2Var.n(str);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        handleUserVisibleHint(z);
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
        titleBar4.setRightButtonListener(new View$OnClickListenerC7009e(jSONObject, onClickListener));
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

    public void setupWebView() {
        TaoMaiWebView taoMaiWebView;
        WebSettings settings;
        WVUIModel wvUIModel;
        View errorView;
        TaoMaiWebView taoMaiWebView2 = this.webView;
        if (taoMaiWebView2 != null) {
            taoMaiWebView2.setScrollableViewParent(this.scrollableViewParent);
        }
        TaoMaiWebView taoMaiWebView3 = this.webView;
        if (taoMaiWebView3 != null) {
            final FragmentActivity requireActivity = requireActivity();
            taoMaiWebView3.setWebChromeClient(new TaoMaiWebChromeClient(requireActivity) { // from class: com.taomai.android.h5container.ui.TaoMaiH5Fragment$setupWebView$1
                @Override // android.webkit.WebChromeClient
                public void onHideCustomView() {
                    super.onHideCustomView();
                    fb1.a("Kian", "onHideCustomView");
                    TaoMaiH5Fragment.this.hideCustomView(true);
                }

                @Override // android.taobao.windvane.webview.WVWebChromeClient, android.webkit.WebChromeClient
                public void onProgressChanged(@Nullable WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    TaoMaiH5Fragment.this.updateProgress(i);
                }

                @Override // android.webkit.WebChromeClient
                public void onShowCustomView(@Nullable View view, int i, @Nullable WebChromeClient.CustomViewCallback customViewCallback) {
                    super.onShowCustomView(view, i, customViewCallback);
                }

                @Override // com.taomai.android.h5container.webview.TaoMaiWebChromeClient, android.webkit.WebChromeClient
                public boolean onShowFileChooser(@Nullable WebView webView, @Nullable ValueCallback<Uri[]> valueCallback, @Nullable WebChromeClient.FileChooserParams fileChooserParams) {
                    TaoMaiH5Fragment.this.filePathCallback = valueCallback;
                    return handleOnShowFileChooser(webView, valueCallback, fileChooserParams);
                }

                @Override // android.webkit.WebChromeClient
                public void onShowCustomView(@Nullable View view, @Nullable WebChromeClient.CustomViewCallback customViewCallback) {
                    super.onShowCustomView(view, customViewCallback);
                    TaoMaiH5Fragment.this.showCustomView(view, customViewCallback);
                }
            });
        }
        TaoMaiWebView taoMaiWebView4 = this.webView;
        if (taoMaiWebView4 != null) {
            final FragmentActivity requireActivity2 = requireActivity();
            taoMaiWebView4.setWebViewClient(new TaoMaiWebClient(requireActivity2) { // from class: com.taomai.android.h5container.ui.TaoMaiH5Fragment$setupWebView$2
                /* JADX WARN: Code restructure failed: missing block: B:8:0x0038, code lost:
                    r0 = r3.this$0.transparentTitleHelper;
                 */
                @Override // android.taobao.windvane.webview.WVWebViewClient, android.webkit.WebViewClient
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onPageFinished(@org.jetbrains.annotations.Nullable android.webkit.WebView r4, @org.jetbrains.annotations.Nullable java.lang.String r5) {
                    /*
                        r3 = this;
                        super.onPageFinished(r4, r5)
                        com.taomai.android.h5container.ui.TaoMaiH5Fragment r0 = com.taomai.android.h5container.ui.TaoMaiH5Fragment.this
                        androidx.swiperefreshlayout.widget.SwipeRefreshLayout r0 = com.taomai.android.h5container.ui.TaoMaiH5Fragment.access$getRefreshLayout$p(r0)
                        r1 = 0
                        r0.setRefreshing(r1)
                        com.taomai.android.h5container.ui.TaoMaiH5Fragment r0 = com.taomai.android.h5container.ui.TaoMaiH5Fragment.this
                        r1 = 1
                        com.taomai.android.h5container.ui.TaoMaiH5Fragment.access$setLoadSuccess$p(r0, r1)
                        com.taomai.android.h5container.ui.TaoMaiH5Fragment r0 = com.taomai.android.h5container.ui.TaoMaiH5Fragment.this
                        r1 = 0
                        if (r4 == 0) goto L1d
                        java.lang.String r2 = r4.getTitle()
                        goto L1e
                    L1d:
                        r2 = r1
                    L1e:
                        com.taomai.android.h5container.ui.TaoMaiH5Fragment.access$setTitleIfNeed(r0, r2)
                        com.taomai.android.h5container.ui.TaoMaiH5Fragment r0 = com.taomai.android.h5container.ui.TaoMaiH5Fragment.this
                        r0.notifyProgressEnd()
                        com.taomai.android.h5container.ui.TaoMaiH5Fragment r0 = com.taomai.android.h5container.ui.TaoMaiH5Fragment.this
                        com.taomai.android.h5container.ui.TaoMaiH5Fragment.access$hideLoading(r0)
                        com.taomai.android.h5container.ui.TaoMaiH5Fragment r0 = com.taomai.android.h5container.ui.TaoMaiH5Fragment.this
                        com.taomai.android.h5container.ui.TaoMaiH5Fragment.access$hideEmptyOrErrorView(r0)
                        com.taomai.android.h5container.ui.TaoMaiH5Fragment r0 = com.taomai.android.h5container.ui.TaoMaiH5Fragment.this
                        boolean r0 = com.taomai.android.h5container.ui.TaoMaiH5Fragment.access$getHasSetTransparentTitleFromBridge$p(r0)
                        if (r0 != 0) goto L43
                        com.taomai.android.h5container.ui.TaoMaiH5Fragment r0 = com.taomai.android.h5container.ui.TaoMaiH5Fragment.this
                        tb.mo2 r0 = com.taomai.android.h5container.ui.TaoMaiH5Fragment.access$getTransparentTitleHelper$p(r0)
                        if (r0 == 0) goto L43
                        r0.j(r1)
                    L43:
                        com.taomai.android.h5container.ui.TaoMaiH5Fragment r0 = com.taomai.android.h5container.ui.TaoMaiH5Fragment.this
                        kotlin.jvm.functions.Function2 r0 = r0.getPageLoadFinishListener()
                        if (r0 == 0) goto L51
                        java.lang.Object r4 = r0.invoke(r4, r5)
                        tb.wt2 r4 = (tb.wt2) r4
                    L51:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.taomai.android.h5container.ui.TaoMaiH5Fragment$setupWebView$2.onPageFinished(android.webkit.WebView, java.lang.String):void");
                }

                @Override // android.taobao.windvane.webview.WVWebViewClient, android.webkit.WebViewClient
                public void onPageStarted(@Nullable WebView webView, @Nullable String str, @Nullable Bitmap bitmap) {
                    super.onPageStarted(webView, str, bitmap);
                    TaoMaiH5Fragment.this.setHookBackKey(false);
                    TaoMaiH5Fragment.this.resetTitleStatus();
                    TaoMaiH5Fragment.this.showLoading();
                    TaoMaiH5Fragment.this.showProgressIfEnable();
                    TaoMaiH5Fragment.this.isLoadSuccess = false;
                    Function3<WebView, String, Bitmap, wt2> pageLoadStartListener = TaoMaiH5Fragment.this.getPageLoadStartListener();
                    if (pageLoadStartListener != null) {
                        pageLoadStartListener.invoke(webView, str, bitmap);
                    }
                }

                @Override // android.taobao.windvane.webview.WVWebViewClient, android.webkit.WebViewClient
                public void onReceivedError(@Nullable WebView webView, int i, @Nullable String str, @Nullable String str2) {
                    super.onReceivedError(webView, i, str, str2);
                    fb1.b("TaoMaiH5Container", "H5Page load error: code:" + i + "   description:" + str + "   url:" + str2);
                    TaoMaiH5Fragment.access$getRefreshLayout$p(TaoMaiH5Fragment.this).setRefreshing(false);
                    TaoMaiH5Fragment.this.hideLoading();
                    TaoMaiH5Fragment.this.showEmptyOrErrorView();
                    TaoMaiWebView webView2 = TaoMaiH5Fragment.this.getWebView();
                    b41.f(webView2);
                    webView2.loadUrl("javascript:document.body.innerHTML=\"" + jn1.QUOTE);
                    Function4<WebView, Integer, String, String, wt2> pageLoadErrorListener = TaoMaiH5Fragment.this.getPageLoadErrorListener();
                    if (pageLoadErrorListener != null) {
                        pageLoadErrorListener.invoke(webView, Integer.valueOf(i), str, str2);
                    }
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedHttpError(@Nullable WebView webView, @Nullable WebResourceRequest webResourceRequest, @Nullable WebResourceResponse webResourceResponse) {
                    String str;
                    boolean F;
                    boolean F2;
                    Uri url;
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                    String uri = (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString();
                    str = TaoMaiH5Fragment.this.url;
                    if (b41.d(uri, str)) {
                        String valueOf = String.valueOf(webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null);
                        F = C8604o.F(valueOf, "4", false, 2, null);
                        if (!F) {
                            F2 = C8604o.F(valueOf, "5", false, 2, null);
                            if (!F2) {
                                return;
                            }
                        }
                        TaoMaiH5Fragment.access$getRefreshLayout$p(TaoMaiH5Fragment.this).setRefreshing(false);
                        TaoMaiH5Fragment.this.hideLoading();
                        TaoMaiWebView webView2 = TaoMaiH5Fragment.this.getWebView();
                        b41.f(webView2);
                        webView2.loadUrl("javascript:document.body.innerHTML=\"" + jn1.QUOTE);
                        TaoMaiH5Fragment.this.showEmptyOrErrorView();
                    }
                }
            });
        }
        TaoMaiWebView taoMaiWebView5 = this.webView;
        if (taoMaiWebView5 != null && (wvUIModel = taoMaiWebView5.getWvUIModel()) != null && (errorView = wvUIModel.getErrorView()) != null) {
            errorView.setOnClickListener(new View$OnClickListenerC7010f());
        }
        if (Build.VERSION.SDK_INT <= 21 || (taoMaiWebView = this.webView) == null || (settings = taoMaiWebView.getSettings()) == null) {
            return;
        }
        settings.setMixedContentMode(0);
    }

    public void showCustomView(@Nullable View view, @Nullable WebChromeClient.CustomViewCallback customViewCallback) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            b41.h(activity, "activity ?: return");
            try {
                this.mCallBack = customViewCallback;
                if (this.mCustomView != null) {
                    if (customViewCallback != null) {
                        customViewCallback.onCustomViewHidden();
                        return;
                    }
                    return;
                }
                this.mCustomView = view;
                FrameLayout frameLayout = new FrameLayout(activity);
                this.videoPlayerContainer = frameLayout;
                frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
                Window window = activity.getWindow();
                b41.h(window, "activity.window");
                View decorView = window.getDecorView();
                if (!(decorView instanceof FrameLayout)) {
                    decorView = null;
                }
                FrameLayout frameLayout2 = (FrameLayout) decorView;
                if (frameLayout2 != null) {
                    frameLayout2.addView(this.videoPlayerContainer, new FrameLayout.LayoutParams(-1, -1));
                }
                this.originalVisibility = frameLayout2 != null ? Integer.valueOf(frameLayout2.getSystemUiVisibility()) : null;
                if (view != null) {
                    view.setKeepScreenOn(true);
                }
                setCustomFullscreen(activity, true);
                activity.setRequestedOrientation(6);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
}
