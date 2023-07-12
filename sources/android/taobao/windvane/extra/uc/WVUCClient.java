package android.taobao.windvane.extra.uc;

import android.net.Uri;
import android.taobao.windvane.config.GlobalConfig;
import android.taobao.windvane.config.WVCommonConfig;
import android.taobao.windvane.config.WVCommonConfigData;
import android.taobao.windvane.embed.BaseEmbedView;
import android.taobao.windvane.embed.Empty;
import android.taobao.windvane.embed.WVEVManager;
import android.taobao.windvane.extra.config.WindVaneUrlCacheManager;
import android.taobao.windvane.extra.performance2.UCTracker;
import android.taobao.windvane.extra.performance2.WVWPData;
import android.taobao.windvane.ha.UCHAReporter;
import android.taobao.windvane.monitor.AppMonitorUtil;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.util.FullTraceUtils;
import android.taobao.windvane.util.TaoLog;
import android.taobao.windvane.utils.TimeUtils;
import android.taobao.windvane.webview.IFullTrace;
import android.taobao.windvane.webview.IWVWebView;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.monitor.procedure.IProcedure;
import com.uc.webview.export.WebView;
import com.uc.webview.export.extension.EmbedViewConfig;
import com.uc.webview.export.extension.IEmbedView;
import com.uc.webview.export.extension.IEmbedViewContainer;
import com.uc.webview.export.extension.UCClient;
import java.util.Map;
import org.json.JSONObject;
import tb.aq1;
import tb.jn1;
import tb.wu1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class WVUCClient extends UCClient {
    private static final String TAG = "WVUCClient";
    String tStart;
    IWVWebView webView;

    public WVUCClient() {
        this.webView = null;
        this.tStart = "0";
    }

    @Override // com.uc.webview.export.extension.UCClient
    public String getCachedFilePath(String str) {
        return WindVaneUrlCacheManager.getCacheFilePath(str);
    }

    @Override // com.uc.webview.export.extension.UCClient
    public IEmbedView getEmbedView(EmbedViewConfig embedViewConfig, IEmbedViewContainer iEmbedViewContainer) {
        Map map = embedViewConfig.mObjectParam;
        if (map.containsKey("viewType")) {
            BaseEmbedView createEV = WVEVManager.createEV(map.containsKey("bridgeId") ? (String) map.get("bridgeId") : "", (String) map.get("viewType"), this.webView, embedViewConfig);
            if (createEV == null) {
                TaoLog.e("EmbedView", "failed to create embedView");
            } else {
                iEmbedViewContainer.setOnParamChangedListener(createEV);
                iEmbedViewContainer.setOnStateChangedListener(createEV);
                iEmbedViewContainer.setOnVisibilityChangedListener(createEV);
                return createEV;
            }
        } else {
            TaoLog.e("EmbedView", "viewType should not be lost");
        }
        Empty empty = new Empty();
        empty.init("", DXRecyclerLayout.LOAD_MORE_EMPTY, this.webView, null);
        return empty;
    }

    @Override // com.uc.webview.export.extension.UCClient
    public void onGpuProcessGone(String str) {
        TaoLog.i("sandbox", "onGpuProcessGone");
        if (str.contains("hasWebGl")) {
            Uri parse = Uri.parse(this.webView.getUrl());
            String str2 = parse.getHost() + parse.getPath();
            if (!GlobalConfig.isBackground) {
                TaoLog.e("GPU", "gpu process is killed, url = [" + str2 + "] , upload information!");
                AppMonitorUtil.commitFail(AppMonitorUtil.MONITOR_POINT_GPU_PROCESS_GONE_TYPE, 1, null, str2);
            }
            WVCommonConfigData wVCommonConfigData = WVCommonConfig.commonConfig;
            if (wVCommonConfigData.ucParam.glLostUnreloadList.contains(str2)) {
                TaoLog.e("GPU", "gpu process error, need not reload page, url = [" + str2 + jn1.ARRAY_END_STR);
                return;
            }
            WVCommonConfig.getInstance();
            if (wVCommonConfigData.enableGpuGoneReload) {
                this.webView.refresh();
                TaoLog.e("GPU", "gpu process error, reload page, url = [" + str2 + jn1.ARRAY_END_STR);
            }
        }
    }

    @Override // com.uc.webview.export.extension.UCClient
    public void onWebViewEvent(final WebView webView, int i, Object obj) {
        Integer num;
        String str;
        String str2;
        String str3;
        String str4;
        WVWPData wVWPData;
        if (i == 9) {
            try {
                if (obj instanceof String) {
                    num = Integer.valueOf((String) obj);
                } else {
                    num = (Integer) obj;
                }
                String url = webView.getUrl();
                if (TextUtils.isEmpty(url)) {
                    if (webView instanceof WVUCWebView) {
                        String currentUrl = ((WVUCWebView) webView).getCurrentUrl();
                        if (!TextUtils.isEmpty(currentUrl)) {
                            AppMonitorUtil.commitEmptyPage(currentUrl, "TYPEA_" + num.toString());
                        }
                    }
                } else {
                    AppMonitorUtil.commitEmptyPage(url, "TYPEB_" + num.toString());
                }
            } catch (Throwable unused) {
            }
        } else if (i == 107) {
            TaoLog.i("sandbox", "onRenderProcessReady");
            if ((webView instanceof WVUCWebView) && webView.getUCExtension() != null) {
                webView.getUCExtension().getCoreStatus(1, new ValueCallback<Object>() { // from class: android.taobao.windvane.extra.uc.WVUCClient.1
                    @Override // android.webkit.ValueCallback
                    public void onReceiveValue(Object obj2) {
                        String str5;
                        WVUCWebViewClient wVUCWebViewClient = ((WVUCWebView) webView).webViewClient;
                        if (wVUCWebViewClient == null) {
                            str5 = "unknow";
                        } else {
                            str5 = wVUCWebViewClient.crashCount != 0 ? "Recover_Success" : "R_Success";
                        }
                        if (obj2 instanceof Integer) {
                            int intValue = ((Integer) obj2).intValue();
                            if (WVMonitorService.getWvMonitorInterface() != null) {
                                WVMonitorService.getWvMonitorInterface().commitRenderType(webView.getUrl(), str5, intValue);
                            }
                            TaoLog.i("sandbox", "process mode: " + intValue);
                        }
                    }
                });
            }
        } else if (i == 108) {
            TaoLog.i("sandbox", "WEBVIEW_EVENT_TYPE_DESTORY_NON_ISOLATE_STATIC_WEBVIEW");
            if (webView instanceof WVUCWebView) {
                WVUCWebView.destroyStaticWebViewIfNeeded();
            }
        } else if (i == 109) {
            TaoLog.i("sandbox", "WEBVIEW_EVENT_TYPE_CREATE_ISOLATE_STATIC_WEBVIEW");
            if ((webView instanceof WVUCWebView) && webView.getContext() != null) {
                WVUCWebView.createStaticWebViewIfNeeded(webView.getContext());
            }
        } else if (i != 4) {
            String str5 = "0";
            if (i == 6) {
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    if (map.containsKey("ts")) {
                        str5 = (String) map.get("ts");
                    }
                }
                long parseLong = Long.parseLong(str5);
                try {
                    ((WVUCWebView) webView).wvh5PPManager.recordUCT1(parseLong);
                    ((WVUCWebView) webView).pageTracker.onPageReceivedT1(parseLong);
                } catch (Throwable unused2) {
                }
                TaoLog.i("AIT", "UC_T1: " + parseLong);
            } else {
                str = "";
                if (i == 14) {
                    if (obj instanceof Map) {
                        Map map2 = (Map) obj;
                        String str6 = map2.containsKey("ts") ? (String) map2.get("ts") : "0";
                        if (map2.containsKey("time")) {
                            str5 = (String) map2.get("time");
                            if ((webView instanceof WVUCWebView) && (wVWPData = ((WVUCWebView) webView).wpData) != null) {
                                wVWPData.t2 = str5;
                            }
                        }
                        str = map2.containsKey("url") ? (String) map2.get("url") : "";
                        str4 = str5;
                        str5 = str6;
                    } else {
                        str4 = "0";
                    }
                    long parseLong2 = Long.parseLong(str5);
                    try {
                        if (webView instanceof IFullTrace) {
                            FullTraceUtils.addStage(((IFullTrace) webView).getSpanWrapper(), "UC_T2");
                            FullTraceUtils.addProperty(((IFullTrace) webView).getSpanWrapper(), "UC_T2", str4);
                        }
                        ((WVUCWebView) webView).wvh5PPManager.recordUCT2(parseLong2);
                        if (str4 != null) {
                            UCTracker.commitUCT2(str, (long) Double.parseDouble(str4));
                        }
                        Long valueOf = Long.valueOf(TimeUtils.generateUptimeFromCurrentTime(parseLong2));
                        IProcedure launcherProcedure = wu1.b.getLauncherProcedure();
                        if (launcherProcedure != null && launcherProcedure.isAlive()) {
                            launcherProcedure.stage("H5_UC_T2", valueOf.longValue());
                        } else {
                            TaoLog.v(TAG, "LauncherProcedure is not Alive");
                        }
                        IProcedure currentActivityProcedure = wu1.b.getCurrentActivityProcedure();
                        if (currentActivityProcedure != null && currentActivityProcedure.isAlive()) {
                            currentActivityProcedure.stage("H5_UC_T2", valueOf.longValue());
                        } else {
                            TaoLog.v(TAG, "CurrentActivityProcedure is not Alive");
                        }
                        IProcedure procedure = wu1.b.getProcedure(webView);
                        if (procedure != null && procedure.isAlive()) {
                            procedure.stage("H5_UC_T2", valueOf.longValue());
                        } else {
                            TaoLog.v(TAG, "LauncherProcedure is not Alive");
                        }
                        TaoLog.e(TAG, "H5_UC_T2 time:" + valueOf);
                        aq1.a.getPageGroup(webView).getPageRenderStandard().onPageVisible(TimeUtils.generateUptimeFromCurrentTime(parseLong2));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    TaoLog.i("AIT", "UC_T2: " + str5);
                } else if (i == 20) {
                    if (obj instanceof String) {
                        try {
                            JSONObject jSONObject = new JSONObject(String.valueOf(obj));
                            str2 = jSONObject.optString("url");
                            try {
                                str = jSONObject.optString("linkId");
                            } catch (Throwable unused3) {
                            }
                        } catch (Throwable unused4) {
                            str2 = "";
                        }
                    } else if (obj instanceof Map) {
                        Map map3 = (Map) obj;
                        str2 = map3.containsKey("url") ? (String) map3.get("url") : "";
                        if (map3.containsKey("linkId")) {
                            str = (String) map3.get("linkId");
                        }
                    } else {
                        str3 = "";
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
                            UCHAReporter.getInstance().putLinkIdWithUrl(str3, str);
                        }
                        TaoLog.i("UCHA", "linkId: " + str3 + ", url: " + str);
                    }
                    str3 = str;
                    str = str2;
                    if (!TextUtils.isEmpty(str)) {
                        UCHAReporter.getInstance().putLinkIdWithUrl(str3, str);
                    }
                    TaoLog.i("UCHA", "linkId: " + str3 + ", url: " + str);
                } else if (i == 106) {
                    TaoLog.e("GPU", "page use webgl, url = [" + webView.getUrl() + jn1.ARRAY_END_STR);
                    if (WVMonitorService.getWvMonitorInterface() != null) {
                        WVMonitorService.getWvMonitorInterface().commitUseWebgl(webView.getUrl());
                    }
                }
            }
        } else if (obj instanceof Map) {
            Map map4 = (Map) obj;
            if (map4.containsKey("time")) {
                this.tStart = (String) map4.get("time");
            }
        }
        super.onWebViewEvent(webView, i, obj);
    }

    public WVUCClient(IWVWebView iWVWebView) {
        this.webView = null;
        this.tStart = "0";
        this.webView = iWVWebView;
    }
}
