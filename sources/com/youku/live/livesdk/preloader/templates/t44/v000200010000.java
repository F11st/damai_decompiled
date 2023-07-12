package com.youku.live.livesdk.preloader.templates.t44;

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
    private static final String landscapeLayout = "{\"id\":\"laifeng_audio_room\",\"playType\":\"interact\",\"version\":\"1.2\",\"standardWidth\":750,\"plugins\":[{\"name\":\"DagoChannel\",\"extra\":{}},{\"name\":\"LaifengRoomInfo\",\"extra\":{}},{\"name\":\"LiveFullInfoV4\",\"extra\":{}},{\"name\":\"LaifengAudioCtrl\",\"extra\":{}}],\"theme\":{\"main_0\":\"#FFAC00\",\"main_1\":\"#FF8200\",\"main_2\":\"#FFB700\",\"sub_0\":\"#FFF6DE\",\"border_0\":\"#FFAC00\",\"disable_0\":\"#CCCCCC\",\"sub_1\":\"#FFB800\",\"font_0\":\"#FFFFFF\",\"font_1\":\"#333333\",\"font_2\":\"#666666\",\"font_sub_0\":\"#999999\",\"font_sub_1\":\"#FF9300\",\"font_highlight_0\":\"#FFAC00\",\"font_disable_0\":\"#CCCCCC\"},\"widget\":{\"name\":\"Stack\",\"id\":\"stack\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"children\":[{\"name\":\"AudioBackground\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"background\"},{\"name\":\"BackBtn\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"r\":24},\"dimensions\":{\"w\":68,\"h\":68},\"visible\":true,\"safeArea\":true},\"extra\":{\"src\":\"https://gw.alicdn.com/tfs/TB1C6LYBhD1gK0jSZFyXXciOVXa-102-102.png\"}},\"id\":\"back-btn\"},{\"name\":\"RoomInfo\",\"atts\":{\"portrait\":{\"margin\":{\"t\":12,\"l\":24},\"dimensions\":{\"w\":702,\"h\":72},\"visible\":true,\"safeArea\":true},\"extra\":{\"guard\":true}},\"id\":\"room-info\"},{\"name\":\"BottomBar\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"l\":24},\"dimensions\":{\"w\":614,\"h\":68},\"safeArea\":true}},\"id\":\"bottom-bar\"},{\"name\":\"LiveWeex\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"live-weex\"}]}}";
    private static final String portraitLayout = "{\"id\":\"laifeng_audio_room\",\"playType\":\"interact\",\"version\":\"1.2\",\"standardWidth\":750,\"plugins\":[{\"name\":\"DagoChannel\",\"extra\":{}},{\"name\":\"LaifengRoomInfo\",\"extra\":{}},{\"name\":\"LiveFullInfoV4\",\"extra\":{}},{\"name\":\"LaifengAudioCtrl\",\"extra\":{}}],\"theme\":{\"main_0\":\"#FFAC00\",\"main_1\":\"#FF8200\",\"main_2\":\"#FFB700\",\"sub_0\":\"#FFF6DE\",\"border_0\":\"#FFAC00\",\"disable_0\":\"#CCCCCC\",\"sub_1\":\"#FFB800\",\"font_0\":\"#FFFFFF\",\"font_1\":\"#333333\",\"font_2\":\"#666666\",\"font_sub_0\":\"#999999\",\"font_sub_1\":\"#FF9300\",\"font_highlight_0\":\"#FFAC00\",\"font_disable_0\":\"#CCCCCC\"},\"widget\":{\"name\":\"Stack\",\"id\":\"stack\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"children\":[{\"name\":\"AudioBackground\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"background\"},{\"name\":\"BackBtn\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"r\":24},\"dimensions\":{\"w\":68,\"h\":68},\"visible\":true,\"safeArea\":true},\"extra\":{\"src\":\"https://gw.alicdn.com/tfs/TB1C6LYBhD1gK0jSZFyXXciOVXa-102-102.png\"}},\"id\":\"back-btn\"},{\"name\":\"RoomInfo\",\"atts\":{\"portrait\":{\"margin\":{\"t\":12,\"l\":24},\"dimensions\":{\"w\":702,\"h\":72},\"visible\":true,\"safeArea\":true},\"extra\":{\"guard\":true}},\"id\":\"room-info\"},{\"name\":\"BottomBar\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"l\":24},\"dimensions\":{\"w\":614,\"h\":68},\"safeArea\":true}},\"id\":\"bottom-bar\"},{\"name\":\"LiveWeex\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"live-weex\"}]}}";
    private static v000200010000 sInstance;
    private boolean isInit = false;
    private TemplateModel landscapeModel;
    private TemplateModel portraitModel;

    v000200010000() {
    }

    public static ITemplate getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1811028522")) {
            return (ITemplate) ipChange.ipc$dispatch("-1811028522", new Object[0]);
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
        return AndroidInstantRuntime.support(ipChange, "-741276165") ? (String) ipChange.ipc$dispatch("-741276165", new Object[]{this}) : "{\"id\":\"laifeng_audio_room\",\"playType\":\"interact\",\"version\":\"1.2\",\"standardWidth\":750,\"plugins\":[{\"name\":\"DagoChannel\",\"extra\":{}},{\"name\":\"LaifengRoomInfo\",\"extra\":{}},{\"name\":\"LiveFullInfoV4\",\"extra\":{}},{\"name\":\"LaifengAudioCtrl\",\"extra\":{}}],\"theme\":{\"main_0\":\"#FFAC00\",\"main_1\":\"#FF8200\",\"main_2\":\"#FFB700\",\"sub_0\":\"#FFF6DE\",\"border_0\":\"#FFAC00\",\"disable_0\":\"#CCCCCC\",\"sub_1\":\"#FFB800\",\"font_0\":\"#FFFFFF\",\"font_1\":\"#333333\",\"font_2\":\"#666666\",\"font_sub_0\":\"#999999\",\"font_sub_1\":\"#FF9300\",\"font_highlight_0\":\"#FFAC00\",\"font_disable_0\":\"#CCCCCC\"},\"widget\":{\"name\":\"Stack\",\"id\":\"stack\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"children\":[{\"name\":\"AudioBackground\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"background\"},{\"name\":\"BackBtn\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"r\":24},\"dimensions\":{\"w\":68,\"h\":68},\"visible\":true,\"safeArea\":true},\"extra\":{\"src\":\"https://gw.alicdn.com/tfs/TB1C6LYBhD1gK0jSZFyXXciOVXa-102-102.png\"}},\"id\":\"back-btn\"},{\"name\":\"RoomInfo\",\"atts\":{\"portrait\":{\"margin\":{\"t\":12,\"l\":24},\"dimensions\":{\"w\":702,\"h\":72},\"visible\":true,\"safeArea\":true},\"extra\":{\"guard\":true}},\"id\":\"room-info\"},{\"name\":\"BottomBar\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"l\":24},\"dimensions\":{\"w\":614,\"h\":68},\"safeArea\":true}},\"id\":\"bottom-bar\"},{\"name\":\"LiveWeex\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"live-weex\"}]}}";
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public TemplateModel getLandscapeModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "534084724")) {
            return (TemplateModel) ipChange.ipc$dispatch("534084724", new Object[]{this});
        }
        init();
        return this.landscapeModel;
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public String getPortraitLayout() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1441111973") ? (String) ipChange.ipc$dispatch("1441111973", new Object[]{this}) : "{\"id\":\"laifeng_audio_room\",\"playType\":\"interact\",\"version\":\"1.2\",\"standardWidth\":750,\"plugins\":[{\"name\":\"DagoChannel\",\"extra\":{}},{\"name\":\"LaifengRoomInfo\",\"extra\":{}},{\"name\":\"LiveFullInfoV4\",\"extra\":{}},{\"name\":\"LaifengAudioCtrl\",\"extra\":{}}],\"theme\":{\"main_0\":\"#FFAC00\",\"main_1\":\"#FF8200\",\"main_2\":\"#FFB700\",\"sub_0\":\"#FFF6DE\",\"border_0\":\"#FFAC00\",\"disable_0\":\"#CCCCCC\",\"sub_1\":\"#FFB800\",\"font_0\":\"#FFFFFF\",\"font_1\":\"#333333\",\"font_2\":\"#666666\",\"font_sub_0\":\"#999999\",\"font_sub_1\":\"#FF9300\",\"font_highlight_0\":\"#FFAC00\",\"font_disable_0\":\"#CCCCCC\"},\"widget\":{\"name\":\"Stack\",\"id\":\"stack\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"children\":[{\"name\":\"AudioBackground\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"background\"},{\"name\":\"BackBtn\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"r\":24},\"dimensions\":{\"w\":68,\"h\":68},\"visible\":true,\"safeArea\":true},\"extra\":{\"src\":\"https://gw.alicdn.com/tfs/TB1C6LYBhD1gK0jSZFyXXciOVXa-102-102.png\"}},\"id\":\"back-btn\"},{\"name\":\"RoomInfo\",\"atts\":{\"portrait\":{\"margin\":{\"t\":12,\"l\":24},\"dimensions\":{\"w\":702,\"h\":72},\"visible\":true,\"safeArea\":true},\"extra\":{\"guard\":true}},\"id\":\"room-info\"},{\"name\":\"BottomBar\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"l\":24},\"dimensions\":{\"w\":614,\"h\":68},\"safeArea\":true}},\"id\":\"bottom-bar\"},{\"name\":\"LiveWeex\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"live-weex\"}]}}";
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public TemplateModel getPortraitModel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-210556002")) {
            return (TemplateModel) ipChange.ipc$dispatch("-210556002", new Object[]{this});
        }
        init();
        return this.portraitModel;
    }

    @Override // com.youku.live.livesdk.preloader.templates.ITemplate
    public void init() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1297416604")) {
            ipChange.ipc$dispatch("-1297416604", new Object[]{this});
        } else if (this.isInit) {
        } else {
            synchronized (v000200010000.class) {
                if (!this.isInit) {
                    this.landscapeModel = (TemplateModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize("{\"id\":\"laifeng_audio_room\",\"playType\":\"interact\",\"version\":\"1.2\",\"standardWidth\":750,\"plugins\":[{\"name\":\"DagoChannel\",\"extra\":{}},{\"name\":\"LaifengRoomInfo\",\"extra\":{}},{\"name\":\"LiveFullInfoV4\",\"extra\":{}},{\"name\":\"LaifengAudioCtrl\",\"extra\":{}}],\"theme\":{\"main_0\":\"#FFAC00\",\"main_1\":\"#FF8200\",\"main_2\":\"#FFB700\",\"sub_0\":\"#FFF6DE\",\"border_0\":\"#FFAC00\",\"disable_0\":\"#CCCCCC\",\"sub_1\":\"#FFB800\",\"font_0\":\"#FFFFFF\",\"font_1\":\"#333333\",\"font_2\":\"#666666\",\"font_sub_0\":\"#999999\",\"font_sub_1\":\"#FF9300\",\"font_highlight_0\":\"#FFAC00\",\"font_disable_0\":\"#CCCCCC\"},\"widget\":{\"name\":\"Stack\",\"id\":\"stack\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"children\":[{\"name\":\"AudioBackground\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"background\"},{\"name\":\"BackBtn\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"r\":24},\"dimensions\":{\"w\":68,\"h\":68},\"visible\":true,\"safeArea\":true},\"extra\":{\"src\":\"https://gw.alicdn.com/tfs/TB1C6LYBhD1gK0jSZFyXXciOVXa-102-102.png\"}},\"id\":\"back-btn\"},{\"name\":\"RoomInfo\",\"atts\":{\"portrait\":{\"margin\":{\"t\":12,\"l\":24},\"dimensions\":{\"w\":702,\"h\":72},\"visible\":true,\"safeArea\":true},\"extra\":{\"guard\":true}},\"id\":\"room-info\"},{\"name\":\"BottomBar\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"l\":24},\"dimensions\":{\"w\":614,\"h\":68},\"safeArea\":true}},\"id\":\"bottom-bar\"},{\"name\":\"LiveWeex\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"live-weex\"}]}}", TemplateModel.class);
                    this.portraitModel = (TemplateModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize("{\"id\":\"laifeng_audio_room\",\"playType\":\"interact\",\"version\":\"1.2\",\"standardWidth\":750,\"plugins\":[{\"name\":\"DagoChannel\",\"extra\":{}},{\"name\":\"LaifengRoomInfo\",\"extra\":{}},{\"name\":\"LiveFullInfoV4\",\"extra\":{}},{\"name\":\"LaifengAudioCtrl\",\"extra\":{}}],\"theme\":{\"main_0\":\"#FFAC00\",\"main_1\":\"#FF8200\",\"main_2\":\"#FFB700\",\"sub_0\":\"#FFF6DE\",\"border_0\":\"#FFAC00\",\"disable_0\":\"#CCCCCC\",\"sub_1\":\"#FFB800\",\"font_0\":\"#FFFFFF\",\"font_1\":\"#333333\",\"font_2\":\"#666666\",\"font_sub_0\":\"#999999\",\"font_sub_1\":\"#FF9300\",\"font_highlight_0\":\"#FFAC00\",\"font_disable_0\":\"#CCCCCC\"},\"widget\":{\"name\":\"Stack\",\"id\":\"stack\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"children\":[{\"name\":\"AudioBackground\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"background\"},{\"name\":\"BackBtn\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"r\":24},\"dimensions\":{\"w\":68,\"h\":68},\"visible\":true,\"safeArea\":true},\"extra\":{\"src\":\"https://gw.alicdn.com/tfs/TB1C6LYBhD1gK0jSZFyXXciOVXa-102-102.png\"}},\"id\":\"back-btn\"},{\"name\":\"RoomInfo\",\"atts\":{\"portrait\":{\"margin\":{\"t\":12,\"l\":24},\"dimensions\":{\"w\":702,\"h\":72},\"visible\":true,\"safeArea\":true},\"extra\":{\"guard\":true}},\"id\":\"room-info\"},{\"name\":\"BottomBar\",\"atts\":{\"portrait\":{\"margin\":{\"b\":24,\"l\":24},\"dimensions\":{\"w\":614,\"h\":68},\"safeArea\":true}},\"id\":\"bottom-bar\"},{\"name\":\"LiveWeex\",\"atts\":{\"portrait\":{\"margin\":{\"t\":0,\"l\":0,\"b\":0,\"r\":0}}},\"id\":\"live-weex\"}]}}", TemplateModel.class);
                    this.isInit = true;
                }
            }
        }
    }
}
