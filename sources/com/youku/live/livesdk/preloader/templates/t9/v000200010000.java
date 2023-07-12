package com.youku.live.livesdk.preloader.templates.t9;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.livesdk.preloader.templates.ITemplate;
import com.youku.live.widgets.model.template.TemplateModel;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class v000200010000 implements ITemplate {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String landscapeLayout = "{\"id\":\"yk_pgc\",\"playType\":\"interact\",\"version\":\"1.5\",\"standardWidth\":750,\"supportLandscape\":true,\"plugins\":[{\"name\":\"DagoChannel\",\"extra\":{}},{\"name\":\"LiveFullInfoV4\",\"extra\":{}},{\"name\":\"YkImChannel\",\"extra\":{}}],\"theme\":{\"main_0\":\"#00B3FA\",\"main_1\":\"#1AA1FF\",\"main_2\":\"#0AE6FF\",\"sub_0\":\"#CCF0FE\",\"border_0\":\"#FFAC00\",\"disable_0\":\"#CCCCCC\",\"sub_1\":\"#FFB800\",\"font_0\":\"#FFFFFF\",\"font_1\":\"#333333\",\"font_2\":\"#666666\",\"font_sub_0\":\"#999999\",\"font_sub_1\":\"#FF9300\",\"font_highlight_0\":\"#00B3FA\",\"font_disable_0\":\"#CCCCCC\"},\"widget\":{\"name\":\"Stack\",\"id\":\"stack\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"children\":[{\"name\":\"PGCBackground\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}},\"extra\":{\"bg\":\"#312C42\"}},\"id\":\"background\"},{\"name\":\"LivePlayback\",\"atts\":{\"portrait\":{\"margin\":{\"t\":160,\"l\":0},\"dimensions\":{\"w\":750,\"h\":422},\"safeArea\":true},\"landscape\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0},\"safeArea\":false},\"extra\":{\"sap\":true,\"playRecord\":true,\"pcdnEnable\":false,\"exitPlayerEnable\":true}},\"id\":\"LivePlayback\"},{\"name\":\"PGCLinkMic\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0},\"visible\":false},\"landscape\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0},\"visible\":true}},\"id\":\"PGCLinkMic\"},{\"name\":\"BackBtn\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"r\":24},\"dimensions\":{\"w\":68,\"h\":68},\"visible\":true,\"safeArea\":true},\"landscape\":{\"margin\":{\"b\":24,\"r\":24},\"dimensions\":{\"w\":68,\"h\":68},\"visible\":false},\"extra\":{\"src\":\"https://gw.alicdn.com/tfs/TB1C6LYBhD1gK0jSZFyXXciOVXa-102-102.png\"}},\"id\":\"back-btn\"},{\"name\":\"LRLiveSlide\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}},\"extra\":{\"leftToRightOnPortrait\":true,\"topToBottomOnPortrait\":false,\"leftToRightOnLandscape\":false,\"topToBottomOnLandscape\":false}},\"id\":\"slide\",\"children\":[{\"name\":\"RoomInfo\",\"atts\":{\"portrait\":{\"margin\":{\"t\":12,\"l\":24},\"dimensions\":{\"w\":702,\"h\":72},\"visible\":true,\"safeArea\":true},\"landscape\":{\"margin\":{\"t\":0,\"l\":0},\"dimensions\":{\"w\":702,\"h\":72},\"visible\":false,\"safeArea\":true},\"extra\":{\"guard\":false}},\"id\":\"room-info\"},{\"name\":\"BottomBar\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"l\":24},\"dimensions\":{\"w\":614,\"h\":68},\"safeArea\":true},\"landscape\":{\"margin\":{\"b\":0,\"l\":0},\"dimensions\":{\"w\":614,\"h\":68},\"visible\":false,\"safeArea\":true}},\"id\":\"bottom-bar\"},{\"name\":\"LiveWeex\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"live-weex\"}]}]}}";
    private static final String portraitLayout = "{\"id\":\"yk_pgc\",\"playType\":\"interact\",\"version\":\"1.5\",\"standardWidth\":750,\"supportLandscape\":false,\"plugins\":[{\"name\":\"DagoChannel\",\"extra\":{}},{\"name\":\"LiveFullInfoV4\",\"extra\":{}},{\"name\":\"YkImChannel\",\"extra\":{}}],\"theme\":{\"main_0\":\"#00B3FA\",\"main_1\":\"#1AA1FF\",\"main_2\":\"#0AE6FF\",\"sub_0\":\"#CCF0FE\",\"border_0\":\"#FFAC00\",\"disable_0\":\"#CCCCCC\",\"sub_1\":\"#FFB800\",\"font_0\":\"#FFFFFF\",\"font_1\":\"#333333\",\"font_2\":\"#666666\",\"font_sub_0\":\"#999999\",\"font_sub_1\":\"#FF9300\",\"font_highlight_0\":\"#00B3FA\",\"font_disable_0\":\"#CCCCCC\"},\"widget\":{\"name\":\"Stack\",\"id\":\"stack\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"children\":[{\"name\":\"PGCBackground\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}},\"extra\":{\"bg\":\"#312C42\"}},\"id\":\"background\"},{\"name\":\"LivePlayback\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}},\"extra\":{\"sap\":true,\"playRecord\":true,\"pcdnEnable\":false,\"pBarBottom\":92,\"pBarLeft\":0,\"pBarWidth\":750,\"pBtnLeft\":24,\"pBtnBottom\":24,\"pBtnWidth\":68,\"pBtnHeight\":68,\"exitPlayerEnable\":true}},\"id\":\"LivePlayback\"},{\"name\":\"PGCLinkMic\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0},\"visible\":false},\"landscape\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0},\"visible\":true}},\"id\":\"PGCLinkMic\"},{\"name\":\"BackBtn\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"r\":24},\"dimensions\":{\"w\":68,\"h\":68},\"visible\":true,\"safeArea\":true},\"landscape\":{\"margin\":{\"b\":24,\"r\":24},\"dimensions\":{\"w\":68,\"h\":68},\"visible\":false},\"extra\":{\"src\":\"https://gw.alicdn.com/tfs/TB1C6LYBhD1gK0jSZFyXXciOVXa-102-102.png\"}},\"id\":\"back-btn\"},{\"name\":\"LRLiveSlide\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}},\"extra\":{\"leftToRightOnPortrait\":true,\"topToBottomOnPortrait\":false,\"leftToRightOnLandscape\":false,\"topToBottomOnLandscape\":false}},\"id\":\"slide\",\"children\":[{\"name\":\"RoomInfo\",\"atts\":{\"portrait\":{\"margin\":{\"t\":12,\"l\":24},\"dimensions\":{\"w\":702,\"h\":72},\"visible\":true,\"safeArea\":true},\"landscape\":{\"margin\":{\"t\":0,\"l\":0},\"dimensions\":{\"w\":702,\"h\":72},\"visible\":false,\"safeArea\":true},\"extra\":{\"guard\":false}},\"id\":\"room-info\"},{\"name\":\"BottomBar\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"l\":24},\"dimensions\":{\"w\":614,\"h\":68},\"safeArea\":true},\"landscape\":{\"margin\":{\"b\":0,\"l\":0},\"dimensions\":{\"w\":614,\"h\":68},\"visible\":false,\"safeArea\":true}},\"id\":\"bottom-bar\"},{\"name\":\"LiveWeex\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"live-weex\"}]}]}}";
    private static v000200010000 sInstance;
    private boolean isInit = false;
    private TemplateModel landscapeModel;
    private TemplateModel portraitModel;

    v000200010000() {
    }

    public static ITemplate getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1559252205")) {
            return (ITemplate) ipChange.ipc$dispatch("1559252205", new Object[0]);
        }
        if (sInstance == null) {
            synchronized (v000200010000.class) {
                if (sInstance == null) {
                    sInstance = new v000200010000();
                }
            }
        }
        return sInstance;
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public String getLandscapeLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "916199300") ? (String) ipChange.ipc$dispatch("916199300", new Object[]{this}) : landscapeLayout;
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public TemplateModel getLandscapeModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2124082109")) {
            return (TemplateModel) ipChange.ipc$dispatch("2124082109", new Object[]{this});
        }
        init();
        return this.landscapeModel;
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public String getPortraitLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2048768252") ? (String) ipChange.ipc$dispatch("2048768252", new Object[]{this}) : portraitLayout;
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public TemplateModel getPortraitModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "672018229")) {
            return (TemplateModel) ipChange.ipc$dispatch("672018229", new Object[]{this});
        }
        init();
        return this.portraitModel;
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2102511109")) {
            ipChange.ipc$dispatch("-2102511109", new Object[]{this});
        } else if (this.isInit) {
        } else {
            synchronized (v000200010000.class) {
                if (!this.isInit) {
                    this.landscapeModel = (TemplateModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(landscapeLayout, TemplateModel.class);
                    this.portraitModel = (TemplateModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(portraitLayout, TemplateModel.class);
                    this.isInit = true;
                }
            }
        }
    }
}
