package com.youku.live.livesdk.widgets.container.pager;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.sdk.m.e0.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.arch.utils.MapUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.OptConfigUtils;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.dsl.network.IRequestCallback;
import com.youku.live.dsl.network.IRequestFactory;
import com.youku.live.dsl.network.IResponse;
import com.youku.live.dsl.pages.IDagoLivePlaybackManangerInterface;
import com.youku.live.dsl.thread.ILiveThreadFactory;
import com.youku.live.livesdk.config.YKLiveConfig;
import com.youku.live.livesdk.constants.SDKConstants;
import com.youku.live.livesdk.model.mtop.LiveFullInfoV4;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.LiveBundleLayout;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.TemplateDTO;
import com.youku.live.livesdk.model.mtop.data.livefullinfo.ThemeDTO;
import com.youku.live.livesdk.monitor.page.LivePageTaskHolder;
import com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider;
import com.youku.live.livesdk.widgets.container.pagable.LiveContentView;
import com.youku.live.livesdk.widgets.container.pager.model.LiveQuickPlayModel;
import com.youku.live.livesdk.widgets.container.pager.model.SwitchItemModel;
import com.youku.live.livesdk.widgets.container.pager.model.SwitchListDataModel;
import com.youku.live.livesdk.widgets.container.pager.model.SwitchListModel;
import com.youku.live.livesdk.widgets.helper.Accessor;
import com.youku.live.livesdk.widgets.helper.ConfigHelper;
import com.youku.live.livesdk.widgets.helper.MtopDataHelper;
import com.youku.live.widgets.model.template.TemplateModel;
import com.youku.live.widgets.monitor.IPerfMonitor;
import com.youku.live.widgets.monitor.PerfMonitorImp;
import com.youku.live.widgets.protocol.IDestroyable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PagableDataProvider implements PagableViewProvider.OnPagingLifecycleListener<SwitchItemModel, LiveContentView>, IDestroyable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String API = "mtop.youku.yklive.rec.room.switch.list";
    private static final String LANDSCAPE_TYPE = "landScape";
    private static final String PORTRAIT_TYPE = "vertical";
    public static final String VER = "2.0";
    private static boolean useNetClient = true;
    private String actorBizType;
    private List<String> latRoomIdsList;
    private boolean layoutIsLaifeng;
    private boolean layoutLandscape;
    private String layoutSource;
    private LiveFullInfoData liveFullInfoData;
    private JSONObject liveFullInfoJson;
    private List<SwitchItemModel> mItems;
    private IPerfMonitor mPagePerfMonitor;
    private PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider;
    private String roomId;
    private String sdkVersion;
    private boolean supportPagerSlide;
    private String switchListJson;
    private String taskId;
    private TemplateModel templateModel;
    private String tplTag;
    private Runnable requestListByTimerRunnable = new Runnable() { // from class: com.youku.live.livesdk.widgets.container.pager.PagableDataProvider.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "518311292")) {
                ipChange.ipc$dispatch("518311292", new Object[]{this});
                return;
            }
            Log.d("PagableDataProvider", "requestList.Timer::pageVisited(" + PagableDataProvider.this.pageVisited + "),pageTotalOffset(" + PagableDataProvider.this.pageTotalOffset + jn1.BRACKET_END_STR);
            PagableDataProvider pagableDataProvider = PagableDataProvider.this;
            pagableDataProvider.requestList(pagableDataProvider.pageVisited);
            PagableDataProvider.this.requestListByTimer();
        }
    };
    private final int timerForRequestListInterval = a.a;
    private volatile int pageSelected = 0;
    private volatile int pageVisited = 0;
    private volatile int pageTotalOffset = 0;
    private volatile int pageTotal = 0;
    private final int pageLimit = 20;
    private volatile String lastRoomIds = "";
    private volatile boolean supportRoomSwitch = true;
    private volatile boolean isListRequesting = false;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private long mTimestampForOnCreateBegin = System.currentTimeMillis();

    public PagableDataProvider() {
        getPagePerfMonitor().perfBegin(this.mTimestampForOnCreateBegin);
    }

    private boolean abtestOpenLayoutPreParse() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "321684675") ? ((Boolean) ipChange.ipc$dispatch("321684675", new Object[]{this})).booleanValue() : OptConfigUtils.isOpenOpt() && OptConfigUtils.getConfig("openLayoutPreParse", true);
    }

    private boolean abtestTrimNavigatorUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1552332717") ? ((Boolean) ipChange.ipc$dispatch("1552332717", new Object[]{this})).booleanValue() : OptConfigUtils.getConfig("fixRequestFullInfo", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void computeLastRoomIds(int i, SwitchItemModel switchItemModel) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "344832314")) {
            ipChange.ipc$dispatch("344832314", new Object[]{this, Integer.valueOf(i), switchItemModel});
            return;
        }
        String str = this.roomId;
        if (str == null || !str.equals(switchItemModel.roomId)) {
            getLastRoomIdsList().add(switchItemModel.roomId);
            int size = getLastRoomIdsList().size();
            if (size < i) {
                i = size;
            } else {
                i2 = size - i;
            }
            this.lastRoomIds = JSON.toJSONString(getLastRoomIdsList(i2, i + i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeTask(Runnable runnable, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1658578946")) {
            ipChange.ipc$dispatch("1658578946", new Object[]{this, runnable, str});
            return;
        }
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.pagableViewProvider;
        if (pagableViewProvider != null && pagableViewProvider.getContentView() != null && (this.pagableViewProvider.getContentView().getContext() instanceof Activity)) {
            LivePageTaskHolder.getInstance().addPageNormalTask((Activity) this.pagableViewProvider.getContentView().getContext(), true, runnable, str);
        } else {
            runnable.run();
        }
    }

    private String getCkeyInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1656932628")) {
            return (String) ipChange.ipc$dispatch("-1656932628", new Object[]{this});
        }
        String str = null;
        try {
            str = ((IDagoLivePlaybackManangerInterface) Dsl.getService(IDagoLivePlaybackManangerInterface.class)).getCkeyInfoForRoomSwitchList(getContext(), null);
        } catch (Throwable unused) {
        }
        return str == null ? "" : str;
    }

    private Context getContext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-642101419")) {
            return (Context) ipChange.ipc$dispatch("-642101419", new Object[]{this});
        }
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.pagableViewProvider;
        if (pagableViewProvider == null || pagableViewProvider.getContentView() == null) {
            return null;
        }
        return this.pagableViewProvider.getContentView().getContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SwitchItemModel> getItems() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-972424357")) {
            return (List) ipChange.ipc$dispatch("-972424357", new Object[]{this});
        }
        if (this.mItems == null) {
            synchronized (this) {
                if (this.mItems == null) {
                    this.mItems = new CopyOnWriteArrayList();
                }
            }
        }
        return this.mItems;
    }

    private List<String> getLastRoomIdsList() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "21899968") ? (List) ipChange.ipc$dispatch("21899968", new Object[]{this}) : getLastRoomIdsList(-1, -1);
    }

    private IPerfMonitor getPagePerfMonitor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-378482257")) {
            return (IPerfMonitor) ipChange.ipc$dispatch("-378482257", new Object[]{this});
        }
        if (this.mPagePerfMonitor == null) {
            synchronized (this) {
                if (this.mPagePerfMonitor == null) {
                    this.mPagePerfMonitor = PerfMonitorImp.createInstance("PagableDataProvider", this);
                }
            }
        }
        return this.mPagePerfMonitor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postRunnable(Runnable runnable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-29260233")) {
            ipChange.ipc$dispatch("-29260233", new Object[]{this, runnable});
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postSwitchList(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "558427086")) {
            ipChange.ipc$dispatch("558427086", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.switchListJson = str;
            PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.pagableViewProvider;
            if (pagableViewProvider != null) {
                pagableViewProvider.notifyActiveView(new Accessor<LiveContentView>() { // from class: com.youku.live.livesdk.widgets.container.pager.PagableDataProvider.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.livesdk.widgets.helper.Accessor
                    public void onAccess(LiveContentView liveContentView) {
                        JSONObject jSONObject;
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1098871141")) {
                            ipChange2.ipc$dispatch("-1098871141", new Object[]{this, liveContentView});
                            return;
                        }
                        try {
                            JSONObject parseObject = JSON.parseObject(PagableDataProvider.this.switchListJson);
                            if (parseObject != null && parseObject.containsKey("data") && (jSONObject = parseObject.getJSONObject("data")) != null) {
                                liveContentView.getInstance().asyncPutData(PagableDataProvider.API, jSONObject.toJSONString());
                            }
                            PagableDataProvider.this.switchListJson = null;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    }

    private void releaseHandler() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "872608467")) {
            ipChange.ipc$dispatch("872608467", new Object[]{this});
            return;
        }
        Handler handler = this.mHandler;
        this.mHandler = null;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public PagableDataProvider attach(PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1080559459")) {
            return (PagableDataProvider) ipChange.ipc$dispatch("1080559459", new Object[]{this, pagableViewProvider});
        }
        this.pagableViewProvider = pagableViewProvider;
        pagableViewProvider.addOnPagingLifecycleListener(this);
        pagableViewProvider.setDataList(getItems());
        return this;
    }

    public PagableDataProvider clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "754686333")) {
            return (PagableDataProvider) ipChange.ipc$dispatch("754686333", new Object[]{this});
        }
        getItems().clear();
        return this;
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1453538522")) {
            ipChange.ipc$dispatch("1453538522", new Object[]{this});
        } else {
            releaseHandler();
        }
    }

    public PagableDataProvider dettach() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-480752875")) {
            return (PagableDataProvider) ipChange.ipc$dispatch("-480752875", new Object[]{this});
        }
        this.pagableViewProvider = null;
        return this;
    }

    public PagableDataProvider fetch() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-578667478")) {
            return (PagableDataProvider) ipChange.ipc$dispatch("-578667478", new Object[]{this});
        }
        if (this.sdkVersion == null) {
            this.sdkVersion = SDKConstants.SDK_VERSION_NUMBER;
        }
        requestFullInfo();
        requestListByTimer();
        return this;
    }

    public PagableDataProvider notifyChanges() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1531751510")) {
            return (PagableDataProvider) ipChange.ipc$dispatch("-1531751510", new Object[]{this});
        }
        PagableViewProvider<SwitchItemModel, LiveContentView> pagableViewProvider = this.pagableViewProvider;
        if (pagableViewProvider != null) {
            pagableViewProvider.updateDataList();
        }
        return this;
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
    public void onPageDeinit(int i, SwitchItemModel switchItemModel, LiveContentView liveContentView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "643561699")) {
            ipChange.ipc$dispatch("643561699", new Object[]{this, Integer.valueOf(i), switchItemModel, liveContentView});
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
    public void onPageInit(int i, SwitchItemModel switchItemModel, LiveContentView liveContentView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "660176290")) {
            ipChange.ipc$dispatch("660176290", new Object[]{this, Integer.valueOf(i), switchItemModel, liveContentView});
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
    public void onPageInvisible(int i, SwitchItemModel switchItemModel, LiveContentView liveContentView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1580693573")) {
            ipChange.ipc$dispatch("1580693573", new Object[]{this, Integer.valueOf(i), switchItemModel, liveContentView});
        }
    }

    public void requestFullInfo() {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "580376840")) {
            ipChange.ipc$dispatch("580376840", new Object[]{this});
            return;
        }
        LiveFullInfoData liveFullInfoData = this.liveFullInfoData;
        if (liveFullInfoData != null) {
            SwitchItemModel switchItemModel = new SwitchItemModel();
            Boolean bool = liveFullInfoData.template.landScape;
            if (abtestOpenLayoutPreParse()) {
                TemplateDTO templateDTO = liveFullInfoData.template;
                switchItemModel._layoutModel = templateDTO.layoutModel;
                switchItemModel._layout = templateDTO.layoutSource;
            } else {
                switchItemModel._layout = new String(Base64.decode(liveFullInfoData.template.layout, 0));
                switchItemModel._layoutModel = (TemplateModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(switchItemModel._layout, TemplateModel.class);
            }
            for (LiveBundleLayout liveBundleLayout : liveFullInfoData.template.layoutList) {
                if ("landScape".equals(liveBundleLayout.type)) {
                    if (abtestOpenLayoutPreParse()) {
                        switchItemModel._layoutLandscape = liveBundleLayout.layoutSource;
                    } else {
                        try {
                            switchItemModel._layoutLandscape = new String(Base64.decode(liveBundleLayout.layout, 0));
                        } catch (Throwable unused) {
                        }
                    }
                } else if ("vertical".equals(liveBundleLayout.type)) {
                    if (abtestOpenLayoutPreParse()) {
                        switchItemModel._layoutPortrait = liveBundleLayout.layoutSource;
                    } else {
                        switchItemModel._layoutPortrait = new String(Base64.decode(liveBundleLayout.layout, 0));
                    }
                }
            }
            this.pageTotal = 1;
            switchItemModel._landscape = bool != null ? bool.booleanValue() : false;
            switchItemModel._static = liveFullInfoData.template.staticJsBundle;
            switchItemModel._fullInfoData = liveFullInfoData;
            switchItemModel._fullInfoJson = this.liveFullInfoJson;
            switchItemModel._isLaifeng = liveFullInfoData.bizType.intValue() == 3;
            Integer num = liveFullInfoData.bizType;
            switchItemModel._biztype = num != null ? num.intValue() : 0;
            switchItemModel.roomId = this.roomId;
            LiveQuickPlayModel liveQuickPlayModel = new LiveQuickPlayModel();
            switchItemModel.liveQuickPlay = liveQuickPlayModel;
            liveQuickPlayModel.theme = liveFullInfoData.theme;
            liveQuickPlayModel.template = liveFullInfoData.template;
            Integer num2 = liveFullInfoData.bizType;
            liveQuickPlayModel.bizType = num2 != null ? num2.intValue() : 0;
            ThemeDTO themeDTO = switchItemModel.liveQuickPlay.theme;
            if (themeDTO != null) {
                String str3 = themeDTO.play916ImgUrl;
                switchItemModel._cover = str3;
                if (TextUtils.isEmpty(str3)) {
                    switchItemModel._cover = switchItemModel.liveQuickPlay.theme.play11ImgUrl;
                }
                if (TextUtils.isEmpty(switchItemModel._cover)) {
                    switchItemModel._cover = switchItemModel.liveQuickPlay.theme.play169ImgUrl;
                }
            }
            computeLastRoomIds(20, switchItemModel);
            getItems().add(switchItemModel);
            this.pagableViewProvider.updateDataList();
            Log.d("PagableDataProvider", "requestList.LiveFullInfo::pageVisited(" + this.pageVisited + "),pageTotalOffset(" + this.pageTotalOffset + jn1.BRACKET_END_STR);
            requestList();
        } else if (!TextUtils.isEmpty(this.layoutSource)) {
            SwitchItemModel switchItemModel2 = new SwitchItemModel();
            switchItemModel2._layout = this.layoutSource;
            if (abtestOpenLayoutPreParse()) {
                switchItemModel2._layoutModel = this.templateModel;
            } else {
                switchItemModel2._layoutModel = (TemplateModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(this.layoutSource, TemplateModel.class);
            }
            boolean z = this.layoutIsLaifeng;
            switchItemModel2._isLaifeng = z;
            switchItemModel2._biztype = z ? 3 : 0;
            switchItemModel2._taskId = this.taskId;
            switchItemModel2.roomId = this.roomId;
            this.pageTotal = 1;
            computeLastRoomIds(20, switchItemModel2);
            getItems().add(switchItemModel2);
            this.pagableViewProvider.updateDataList();
            Log.d("PagableDataProvider", "requestList.LiveFullInfo::pageVisited(" + this.pageVisited + "),pageTotalOffset(" + this.pageTotalOffset + jn1.BRACKET_END_STR);
            requestList();
        } else {
            final String str4 = this.roomId;
            Map<String, String> build = MapUtils.build(MapUtils.build(MapUtils.build(MapUtils.build(new HashMap(), "liveId", str4), "sdkVersion", this.sdkVersion), "app", "Android"), "ckeyInfo", getCkeyInfo());
            if (!TextUtils.isEmpty(this.tplTag)) {
                MapUtils.build(build, "tplTag", this.tplTag);
            }
            IRequestFactory iRequestFactory = (IRequestFactory) Dsl.getService(IRequestFactory.class);
            if (abtestTrimNavigatorUrl()) {
                str = "mtop.youku.live.com.livefullinfo";
                str2 = "4.0";
            } else {
                str = API;
                str2 = "2.0";
            }
            iRequestFactory.createRequestWithMtop(str, str2, build, false, false).async(new IRequestCallback() { // from class: com.youku.live.livesdk.widgets.container.pager.PagableDataProvider.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.IRequestCallback
                public void onCallback(IResponse iResponse) {
                    IpChange ipChange2 = $ipChange;
                    boolean z2 = true;
                    if (AndroidInstantRuntime.support(ipChange2, "487618952")) {
                        ipChange2.ipc$dispatch("487618952", new Object[]{this, iResponse});
                        return;
                    }
                    if (PagableDataProvider.this.mPagePerfMonitor != null) {
                        IPerfMonitor iPerfMonitor = PagableDataProvider.this.mPagePerfMonitor;
                        iPerfMonitor.point("LiveFullInfoCost", Thread.currentThread().getName() + "::PagableDataProvider requestFullInfo:" + PagableDataProvider.this + ",mLiveId：" + str4 + ", 2 after reqLiveFullInfo4.0");
                    }
                    Log.d("PagableDataProvider", "onSuccess:; Name:" + Thread.currentThread().getName() + "; GroupName:" + Thread.currentThread().getThreadGroup().getName() + "; Pid:" + Thread.currentThread().getId());
                    try {
                        String str5 = new String(iResponse.getSource());
                        PagableDataProvider.this.postSwitchList(str5);
                        LiveFullInfoData liveFullInfoData2 = (LiveFullInfoData) MtopDataHelper.getDataDataWithModel(str5, LiveFullInfoV4.class);
                        JSONObject dataDataWithJson = MtopDataHelper.getDataDataWithJson(str5, LiveFullInfoV4.class);
                        if (PagableDataProvider.this.mPagePerfMonitor != null) {
                            IPerfMonitor iPerfMonitor2 = PagableDataProvider.this.mPagePerfMonitor;
                            iPerfMonitor2.point("LiveFullInfoCost", Thread.currentThread().getName() + "::PagableDataProvider requestFullInfo parse:" + PagableDataProvider.this + ",mLiveId：" + str4 + ", 3 after reqLiveFullInfo4.0");
                        }
                        final SwitchItemModel switchItemModel3 = new SwitchItemModel();
                        Boolean bool2 = liveFullInfoData2.template.landScape;
                        Integer num3 = liveFullInfoData2.bizType;
                        if (num3 == null || num3.intValue() != 3) {
                            z2 = false;
                        }
                        switchItemModel3._isLaifeng = z2;
                        Integer num4 = liveFullInfoData2.bizType;
                        switchItemModel3._biztype = num4 != null ? num4.intValue() : 0;
                        TemplateDTO templateDTO2 = liveFullInfoData2.template;
                        switchItemModel3._layout = templateDTO2.layoutSource;
                        switchItemModel3._layoutModel = templateDTO2.layoutModel;
                        switchItemModel3._landscape = bool2 != null ? bool2.booleanValue() : false;
                        switchItemModel3._static = liveFullInfoData2.template.staticJsBundle;
                        switchItemModel3._fullInfoData = liveFullInfoData2;
                        switchItemModel3._fullInfoJson = dataDataWithJson;
                        switchItemModel3.roomId = str4;
                        LiveQuickPlayModel liveQuickPlayModel2 = new LiveQuickPlayModel();
                        switchItemModel3.liveQuickPlay = liveQuickPlayModel2;
                        liveQuickPlayModel2.theme = liveFullInfoData2.theme;
                        liveQuickPlayModel2.template = liveFullInfoData2.template;
                        Integer num5 = liveFullInfoData2.bizType;
                        liveQuickPlayModel2.bizType = num5 != null ? num5.intValue() : 0;
                        ThemeDTO themeDTO2 = switchItemModel3.liveQuickPlay.theme;
                        if (themeDTO2 != null) {
                            String str6 = themeDTO2.play916ImgUrl;
                            switchItemModel3._cover = str6;
                            if (TextUtils.isEmpty(str6)) {
                                switchItemModel3._cover = switchItemModel3.liveQuickPlay.theme.play11ImgUrl;
                            }
                            if (TextUtils.isEmpty(switchItemModel3._cover)) {
                                switchItemModel3._cover = switchItemModel3.liveQuickPlay.theme.play169ImgUrl;
                            }
                        }
                        PagableDataProvider.this.computeLastRoomIds(20, switchItemModel3);
                        PagableDataProvider.this.postRunnable(new Runnable() { // from class: com.youku.live.livesdk.widgets.container.pager.PagableDataProvider.3.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "1780377805")) {
                                    ipChange3.ipc$dispatch("1780377805", new Object[]{this});
                                    return;
                                }
                                PagableDataProvider.this.pageTotal = 1;
                                PagableDataProvider.this.getItems().add(switchItemModel3);
                                PagableDataProvider.this.pagableViewProvider.updateDataList();
                                Log.d("PagableDataProvider", "requestList.LiveFullInfo::pageVisited(" + PagableDataProvider.this.pageVisited + "),pageTotalOffset(" + PagableDataProvider.this.pageTotalOffset + jn1.BRACKET_END_STR + " pageTotal：" + PagableDataProvider.this.pageTotal);
                                PagableDataProvider.this.requestList();
                            }
                        });
                        if (PagableDataProvider.this.mPagePerfMonitor != null) {
                            IPerfMonitor iPerfMonitor3 = PagableDataProvider.this.mPagePerfMonitor;
                            iPerfMonitor3.point("LiveFullInfoCost", Thread.currentThread().getName() + "::PagableDataProvider requestFullInfo parse:" + PagableDataProvider.this + ",mLiveId：" + str4 + ", 4 after reqLiveFullInfo4.0");
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, new IRequestCallback() { // from class: com.youku.live.livesdk.widgets.container.pager.PagableDataProvider.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.network.IRequestCallback
                public void onCallback(IResponse iResponse) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1181011657")) {
                        ipChange2.ipc$dispatch("1181011657", new Object[]{this, iResponse});
                        return;
                    }
                    if (PagableDataProvider.this.mPagePerfMonitor != null) {
                        IPerfMonitor iPerfMonitor = PagableDataProvider.this.mPagePerfMonitor;
                        iPerfMonitor.point("LiveFullInfoCost", Thread.currentThread().getName() + "::PagableDataProvider requestFullInfo:" + PagableDataProvider.this + ",mLiveId：" + str4 + ", 2 after reqLiveFullInfo4.0");
                    }
                    Log.d("PagableDataProvider", "onSuccess:; Name:" + Thread.currentThread().getName() + "; GroupName:" + Thread.currentThread().getThreadGroup().getName() + "; Pid:" + Thread.currentThread().getId());
                }
            });
        }
    }

    public void requestList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201490087")) {
            ipChange.ipc$dispatch("1201490087", new Object[]{this});
            return;
        }
        Log.d("PagableDataProvider", "requestList:; supportPagerSlide:" + this.supportPagerSlide);
        if (this.supportPagerSlide) {
            requestList(this.pageTotalOffset);
        }
    }

    public void requestListAsync(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "523455036")) {
            ipChange.ipc$dispatch("523455036", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        Log.d("PagableDataProvider", "requestList:; isListRequesting:" + this.isListRequesting + ";supportRoomSwitch" + this.supportRoomSwitch, new Throwable());
        if (this.isListRequesting || !this.supportRoomSwitch) {
            return;
        }
        Log.d("PagableDataProvider", "requestList:; pageTotalOffset:" + i + ";");
        this.isListRequesting = true;
        HashMap hashMap = new HashMap(16);
        hashMap.put("roomId", this.roomId);
        hashMap.put("app", "Android");
        hashMap.put("sdkVersion", YKLiveConfig.getSdkVersion());
        hashMap.put("ccode", YKLiveConfig.getCcode());
        hashMap.put("lastRoomIds", this.lastRoomIds);
        hashMap.put("offset", "" + i);
        hashMap.put("limit", "20");
        hashMap.put("ckeyInfo", getCkeyInfo());
        if (!TextUtils.isEmpty(this.actorBizType)) {
            hashMap.put("nodeKey", this.actorBizType);
        }
        ((IRequestFactory) Dsl.getService(IRequestFactory.class)).createRequestWithMtop(API, "2.0", hashMap, false, false).async(new IRequestCallback() { // from class: com.youku.live.livesdk.widgets.container.pager.PagableDataProvider.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dsl.network.IRequestCallback
            public void onCallback(IResponse iResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1727170229")) {
                    ipChange2.ipc$dispatch("-1727170229", new Object[]{this, iResponse});
                    return;
                }
                try {
                    String source = iResponse.getSource();
                    PagableDataProvider.this.postSwitchList(source);
                    final SwitchListDataModel switchListDataModel = (SwitchListDataModel) ((SwitchListModel) JSON.parseObject(source, SwitchListModel.class)).data;
                    if (switchListDataModel != null) {
                        LinkedList linkedList = new LinkedList();
                        List<SwitchItemModel> list = switchListDataModel.itemList;
                        if (list != null) {
                            for (SwitchItemModel switchItemModel : list) {
                                try {
                                    TemplateDTO templateDTO = switchItemModel.liveQuickPlay.template;
                                    Boolean bool = templateDTO.landScape;
                                    switchItemModel._layout = templateDTO.layoutSource;
                                    switchItemModel._layoutModel = templateDTO.layoutModel;
                                    switchItemModel._landscape = bool != null ? bool.booleanValue() : false;
                                    LiveQuickPlayModel liveQuickPlayModel = switchItemModel.liveQuickPlay;
                                    switchItemModel._static = liveQuickPlayModel.template.staticJsBundle;
                                    long j = liveQuickPlayModel.bizType;
                                    switchItemModel._isLaifeng = j == 3;
                                    switchItemModel._biztype = (int) j;
                                    ThemeDTO themeDTO = liveQuickPlayModel.theme;
                                    if (themeDTO != null) {
                                        String str = themeDTO.play916ImgUrl;
                                        switchItemModel._cover = str;
                                        if (TextUtils.isEmpty(str)) {
                                            switchItemModel._cover = switchItemModel.liveQuickPlay.theme.play11ImgUrl;
                                        }
                                        if (TextUtils.isEmpty(switchItemModel._cover)) {
                                            switchItemModel._cover = switchItemModel.liveQuickPlay.theme.play169ImgUrl;
                                        }
                                    }
                                    linkedList.add(switchItemModel);
                                } catch (Throwable unused) {
                                }
                            }
                            PagableDataProvider.this.computeLastRoomIds(20, linkedList);
                        }
                        switchListDataModel.itemList = linkedList;
                        PagableDataProvider.this.supportRoomSwitch = switchListDataModel.roomSwitch;
                        PagableDataProvider.this.pageTotalOffset = switchListDataModel.offset;
                        Log.d("PagableDataProvider", "onSuccess:; pageTotalOffset:" + PagableDataProvider.this.pageTotalOffset + "; offset:" + switchListDataModel.offset + ";");
                        PagableDataProvider.this.executeTask(new Runnable() { // from class: com.youku.live.livesdk.widgets.container.pager.PagableDataProvider.6.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                List<SwitchItemModel> list2;
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "-2127341334")) {
                                    ipChange3.ipc$dispatch("-2127341334", new Object[]{this});
                                    return;
                                }
                                PagableDataProvider.this.pagableViewProvider.setLimit(40, 20);
                                SwitchListDataModel switchListDataModel2 = switchListDataModel;
                                if (switchListDataModel2 != null && (list2 = switchListDataModel2.itemList) != null && list2.size() > 0 && !"1".equals(switchListDataModel.changeStatus)) {
                                    PagableDataProvider.this.pageTotal += switchListDataModel.itemList.size();
                                    Log.d("PagableDataProvider", "onSuccess:; pageTotalOffset:" + PagableDataProvider.this.pageTotalOffset + "; offset:" + switchListDataModel.offset + "; pageTotal:" + PagableDataProvider.this.pageTotal);
                                    PagableDataProvider.this.pagableViewProvider.setRoomSwitch(true);
                                    PagableDataProvider.this.getItems().addAll(switchListDataModel.itemList);
                                }
                                PagableDataProvider.this.pagableViewProvider.updateDataList();
                            }
                        }, "updateDataList_1");
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }, new IRequestCallback() { // from class: com.youku.live.livesdk.widgets.container.pager.PagableDataProvider.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dsl.network.IRequestCallback
            public void onCallback(IResponse iResponse) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1033777524")) {
                    ipChange2.ipc$dispatch("-1033777524", new Object[]{this, iResponse});
                } else {
                    PagableDataProvider.this.isListRequesting = false;
                }
            }
        });
    }

    public void requestListByTimer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1032719925")) {
            ipChange.ipc$dispatch("1032719925", new Object[]{this});
        } else {
            postRunnable(this.requestListByTimerRunnable, 300000L);
        }
    }

    public PagableDataProvider setActorBizType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-163061408")) {
            return (PagableDataProvider) ipChange.ipc$dispatch("-163061408", new Object[]{this, str});
        }
        Log.d("fornia", "laifeng nodekey 设置" + str);
        this.actorBizType = str;
        return this;
    }

    public PagableDataProvider setFirstRoomLayoutSource(String str, String str2, TemplateModel templateModel, boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "989751310")) {
            return (PagableDataProvider) ipChange.ipc$dispatch("989751310", new Object[]{this, str, str2, templateModel, Boolean.valueOf(z), Boolean.valueOf(z2)});
        }
        if (ConfigHelper.getBoolean("live_platform_bugfix_rollback", "issue29192322_preload_task", true)) {
            this.taskId = str;
        }
        this.layoutSource = str2;
        this.templateModel = templateModel;
        this.layoutLandscape = z;
        this.layoutIsLaifeng = z2;
        return this;
    }

    public PagableDataProvider setFullInfoData(LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1695280331")) {
            return (PagableDataProvider) ipChange.ipc$dispatch("-1695280331", new Object[]{this, liveFullInfoData});
        }
        this.liveFullInfoData = liveFullInfoData;
        return this;
    }

    public PagableDataProvider setFullInfoJson(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138630239")) {
            return (PagableDataProvider) ipChange.ipc$dispatch("-2138630239", new Object[]{this, jSONObject});
        }
        this.liveFullInfoJson = jSONObject;
        return this;
    }

    public PagableDataProvider setRoomId(String str, LiveFullInfoData liveFullInfoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1023128400")) {
            return (PagableDataProvider) ipChange.ipc$dispatch("-1023128400", new Object[]{this, str, liveFullInfoData});
        }
        this.roomId = str;
        this.liveFullInfoData = liveFullInfoData;
        return this;
    }

    public PagableDataProvider setSdkVersion(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1799759834")) {
            return (PagableDataProvider) ipChange.ipc$dispatch("-1799759834", new Object[]{this, str});
        }
        this.sdkVersion = str;
        return this;
    }

    public PagableDataProvider setTpltag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "974721682")) {
            return (PagableDataProvider) ipChange.ipc$dispatch("974721682", new Object[]{this, str});
        }
        this.tplTag = str;
        return this;
    }

    public PagableDataProvider supportPagerSlide(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2071237689")) {
            return (PagableDataProvider) ipChange.ipc$dispatch("-2071237689", new Object[]{this, Boolean.valueOf(z)});
        }
        this.supportPagerSlide = z;
        return this;
    }

    private List<String> getLastRoomIdsList(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1555219488")) {
            return (List) ipChange.ipc$dispatch("1555219488", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (this.latRoomIdsList == null) {
            synchronized (this) {
                if (this.latRoomIdsList == null) {
                    this.latRoomIdsList = new CopyOnWriteArrayList();
                }
            }
        }
        if (i >= 0 && i2 >= 0) {
            this.latRoomIdsList = this.latRoomIdsList.subList(i, i2);
        }
        return this.latRoomIdsList;
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
    public void onPageIdleChanged(int i, SwitchItemModel switchItemModel, LiveContentView liveContentView, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2097379780")) {
            ipChange.ipc$dispatch("-2097379780", new Object[]{this, Integer.valueOf(i), switchItemModel, liveContentView, Boolean.valueOf(z)});
        } else if (z) {
            Log.d("PagableDataProvider", "requestList.onPageIdleChanged::pageSelected(" + this.pageSelected + jn1.BRACKET_END_STR);
            this.pageSelected = i;
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
    public void onPageVisible(int i, SwitchItemModel switchItemModel, LiveContentView liveContentView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1443974582")) {
            ipChange.ipc$dispatch("-1443974582", new Object[]{this, Integer.valueOf(i), switchItemModel, liveContentView});
            return;
        }
        if (this.pageVisited < i) {
            this.pageVisited = i;
        }
        Log.d("PagableDataProvider", "requestList.onPageVisible::position(" + i + "),pageTotalOffset(" + this.pageTotalOffset + jn1.BRACKET_END_STR + " pageTotal：" + this.pageTotal);
        if (this.pageTotal > 1 && this.pageVisited > this.pageTotal - 10) {
            Log.d("PagableDataProvider", "requestList.onPageVisible::pageVisited(" + this.pageVisited + "),pageTotalOffset(" + this.pageTotalOffset + "),pageTotal(" + this.pageTotal + "),");
            requestList();
        }
        postSwitchList(this.switchListJson);
    }

    private void postRunnable(Runnable runnable, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-907036819")) {
            ipChange.ipc$dispatch("-907036819", new Object[]{this, runnable, Long.valueOf(j)});
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(runnable, j);
        }
    }

    public PagableDataProvider setRoomId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1300981182")) {
            return (PagableDataProvider) ipChange.ipc$dispatch("1300981182", new Object[]{this, str});
        }
        this.roomId = str;
        return this;
    }

    public void requestList(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1408483524")) {
            ipChange.ipc$dispatch("-1408483524", new Object[]{this, Integer.valueOf(i)});
        } else {
            executeTask(new Runnable() { // from class: com.youku.live.livesdk.widgets.container.pager.PagableDataProvider.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-267742728")) {
                        ipChange2.ipc$dispatch("-267742728", new Object[]{this});
                    } else {
                        ((ILiveThreadFactory) Dsl.getService(ILiveThreadFactory.class)).excute(new Runnable() { // from class: com.youku.live.livesdk.widgets.container.pager.PagableDataProvider.5.1
                            private static transient /* synthetic */ IpChange $ipChange;

                            @Override // java.lang.Runnable
                            public void run() {
                                IpChange ipChange3 = $ipChange;
                                if (AndroidInstantRuntime.support(ipChange3, "2038543243")) {
                                    ipChange3.ipc$dispatch("2038543243", new Object[]{this});
                                    return;
                                }
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                PagableDataProvider.this.requestListAsync(i);
                            }
                        });
                    }
                }
            }, "request_list_1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void computeLastRoomIds(int i, List<SwitchItemModel> list) {
        IpChange ipChange = $ipChange;
        int i2 = 0;
        if (AndroidInstantRuntime.support(ipChange, "1884244462")) {
            ipChange.ipc$dispatch("1884244462", new Object[]{this, Integer.valueOf(i), list});
            return;
        }
        if (this.latRoomIdsList == null) {
            this.latRoomIdsList = new LinkedList();
        }
        for (SwitchItemModel switchItemModel : list) {
            String str = this.roomId;
            if (str != null && !str.equals(switchItemModel.roomId)) {
                this.latRoomIdsList.add(switchItemModel.roomId);
            }
        }
        int size = this.latRoomIdsList.size();
        if (size < i) {
            i = size;
        } else {
            i2 = size - i;
        }
        List<String> subList = this.latRoomIdsList.subList(i2, i + i2);
        this.latRoomIdsList = subList;
        this.lastRoomIds = JSON.toJSONString(subList);
    }
}
