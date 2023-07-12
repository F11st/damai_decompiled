package com.youku.live.dago.module;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.dago.liveplayback.widget.AlixLivePlayback;
import com.youku.live.dago.liveplayback.widget.Constants;
import com.youku.live.dago.model.PlayerInteract;
import com.youku.live.dago.utils.UnitUtil;
import com.youku.live.dago.view.dagocustomelement.PopImageLayout;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListBean;
import com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListView;
import com.youku.live.dago.widgetlib.view.anchor.DagoAnchorInfoView;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.image.IImageLoaderFactory;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface;
import com.youku.live.livesdk.wkit.widget.LiveWeexWidget;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IWidget;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoPlayerInteract extends WXModule implements View.OnClickListener, Destroyable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ELEMENT_ANCHOR_INFO = "anchorInfo";
    public static final String ELEMENT_CUSTOM_IMAGE = "customImage";
    public static final String ELEMENT_DANMAKU = "danmaku";
    public static final String ELEMENT_IMAGE = "image";
    public static final String ELEMENT_POP_IMAGE = "popImage";
    public static final String ELEMENT_TEXT = "text";
    public static final String ELEMENT_USER_LIST = "userList";
    public static final String MODULE_NAME = "dago-live-player-interact";
    public static final int UNIT_ANCHOR_INFO_HEIGHT = 36;
    public static final int UNIT_ANCHOR_INFO_NO_ATT_WIDTH = 112;
    public static final int UNIT_ANCHOR_INFO_WIDTH = 147;
    public static final int UNIT_IMAGE_BUTTON_HEIGHT = 32;
    public static final int UNIT_IMAGE_BUTTON_WIDTH = 32;
    public static final int UNIT_TEXT_BUTTON_HEIGHT = 28;
    public JSCallback mControllerResultCallback;
    private Map<String, Map<String, View>> mInjectedViews;
    private IDagoLivePlaybackInjectorInterface mInjector;

    private void createAllElements(Context context, IDagoLivePlaybackInjectorInterface iDagoLivePlaybackInjectorInterface, PlayerInteract.AddController addController, DagoPlayerInteract dagoPlayerInteract) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-7951670")) {
            ipChange.ipc$dispatch("-7951670", new Object[]{this, context, iDagoLivePlaybackInjectorInterface, addController, dagoPlayerInteract});
        } else if (addController == null) {
        } else {
            List<Map<String, Object>> createElementsByType = createElementsByType(context, Constants.AREA_HLT, false, addController.HLT, this);
            List<Map<String, Object>> createElementsByType2 = createElementsByType(context, Constants.AREA_HRT, false, addController.HRT, this);
            List<Map<String, Object>> createElementsByType3 = createElementsByType(context, Constants.AREA_HMT, false, addController.HMT, this);
            List<Map<String, Object>> createElementsByType4 = createElementsByType(context, Constants.AREA_HMB, false, addController.HMB, this);
            List<Map<String, Object>> createElementsByType5 = createElementsByType(context, Constants.AREA_HRB, false, addController.HRB, this);
            List<Map<String, Object>> createElementsByType6 = createElementsByType(context, Constants.AREA_HLB, false, addController.HLB, this);
            List<Map<String, Object>> createElementsByType7 = createElementsByType(context, Constants.AREA_VRS, true, addController.VRS, this);
            List<Map<String, Object>> createElementsByType8 = createElementsByType(context, Constants.AREA_VRB, true, addController.VRB, this);
            List<Map<String, Object>> createElementsByType9 = createElementsByType(context, Constants.AREA_VRT, true, addController.VRT, this);
            List<Map<String, Object>> createElementsByType10 = createElementsByType(context, "HRRT", true, addController.HRRT, this);
            List<Map<String, Object>> createElementsByType11 = createElementsByType(context, "VRRT", true, addController.VRRT, this);
            ArrayList arrayList = new ArrayList();
            if (createElementsByType != null && createElementsByType.size() > 0) {
                arrayList.addAll(createElementsByType);
            }
            if (createElementsByType2 != null && createElementsByType2.size() > 0) {
                arrayList.addAll(createElementsByType2);
            }
            if (createElementsByType3 != null && createElementsByType3.size() > 0) {
                arrayList.addAll(createElementsByType3);
            }
            if (createElementsByType5 != null && createElementsByType5.size() > 0) {
                arrayList.addAll(createElementsByType5);
            }
            if (createElementsByType7 != null && createElementsByType7.size() > 0) {
                arrayList.addAll(createElementsByType7);
            }
            if (createElementsByType8 != null && createElementsByType8.size() > 0) {
                arrayList.addAll(createElementsByType8);
            }
            if (createElementsByType9 != null && createElementsByType9.size() > 0) {
                arrayList.addAll(createElementsByType9);
            }
            if (createElementsByType6 != null && createElementsByType6.size() > 0) {
                arrayList.addAll(createElementsByType6);
            }
            if (createElementsByType10 != null && createElementsByType10.size() > 0) {
                arrayList.addAll(createElementsByType10);
            }
            if (createElementsByType4 != null && createElementsByType4.size() > 0) {
                arrayList.addAll(createElementsByType4);
            }
            if (createElementsByType11 != null && createElementsByType11.size() > 0) {
                arrayList.addAll(createElementsByType11);
            }
            if (iDagoLivePlaybackInjectorInterface == null || arrayList.size() <= 0) {
                return;
            }
            iDagoLivePlaybackInjectorInterface.injectorPlayerAction("insertView2ControlPlugin", arrayList);
        }
    }

    private int createElementsByType(Context context, IDagoLivePlaybackInjectorInterface iDagoLivePlaybackInjectorInterface, String str, boolean z, int i, List<PlayerInteract.Controller> list, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1871657987")) {
            return ((Integer) ipChange.ipc$dispatch("-1871657987", new Object[]{this, context, iDagoLivePlaybackInjectorInterface, str, Boolean.valueOf(z), Integer.valueOf(i), list, onClickListener})).intValue();
        }
        if (list == null) {
            return i;
        }
        Map<String, Map<String, View>> injectedViewsMap = getInjectedViewsMap();
        Map<String, View> map = injectedViewsMap.containsKey(str) ? injectedViewsMap.get(str) : null;
        if (map == null) {
            map = new HashMap<>();
            injectedViewsMap.put(str, map);
        }
        HashMap hashMap = new HashMap();
        for (PlayerInteract.Controller controller : list) {
            if (map.containsKey(controller.key)) {
                hashMap.put(controller.key, map.remove(controller.key));
            }
        }
        for (Map.Entry<String, View> entry : map.entrySet()) {
            entry.getValue().setVisibility(8);
        }
        injectedViewsMap.put(str, hashMap);
        for (PlayerInteract.Controller controller2 : list) {
            controller2.onPortrait = z;
            controller2.area = str;
            View createElementByType = createElementByType(context, controller2.type, controller2, onClickListener);
            setInjectedViews(str, controller2.key, createElementByType);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("key", controller2.key);
            hashMap2.put("view", createElementByType);
            hashMap2.put(Constants.ACTION_PARAMS_LAYOUTPARAMS, controller2.layoutParams);
            hashMap2.put("p", Integer.valueOf(i));
            hashMap2.put(Constants.ACTION_PARAMS_AREA, str);
            hashMap2.put("s", Boolean.valueOf(z));
            iDagoLivePlaybackInjectorInterface.injectorPlayerAction("insertView2ControlPlugin", hashMap2);
            i++;
        }
        return i;
    }

    private View getInjectedViews(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2061184497")) {
            return (View) ipChange.ipc$dispatch("-2061184497", new Object[]{this, str, str2});
        }
        if (str == null || str2 == null) {
            return null;
        }
        Map<String, Map<String, View>> injectedViewsMap = getInjectedViewsMap();
        Map<String, View> map = injectedViewsMap.containsKey(str) ? injectedViewsMap.get(str) : null;
        if (map == null) {
            map = new HashMap<>();
            injectedViewsMap.put(str, map);
        }
        if (map.containsKey(str2)) {
            return map.get(str2);
        }
        return null;
    }

    private Map<String, Map<String, View>> getInjectedViewsMap() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1246946134")) {
            return (Map) ipChange.ipc$dispatch("-1246946134", new Object[]{this});
        }
        if (this.mInjectedViews == null) {
            synchronized (this) {
                if (this.mInjectedViews == null) {
                    this.mInjectedViews = new HashMap();
                }
            }
        }
        return this.mInjectedViews;
    }

    private IDagoLivePlaybackInjectorInterface getInjector() {
        List<IWidget> findWidgetsByName;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2140257599")) {
            return (IDagoLivePlaybackInjectorInterface) ipChange.ipc$dispatch("2140257599", new Object[]{this});
        }
        IDagoLivePlaybackInjectorInterface iDagoLivePlaybackInjectorInterface = this.mInjector;
        if (iDagoLivePlaybackInjectorInterface != null) {
            return iDagoLivePlaybackInjectorInterface;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            IWidget findWidgetById = widgetEngineInstance.findWidgetById(AlixLivePlayback.WIDGET_NAME);
            r0 = findWidgetById instanceof IDagoLivePlaybackInjectorInterface ? (IDagoLivePlaybackInjectorInterface) findWidgetById : null;
            if (r0 == null && (findWidgetsByName = widgetEngineInstance.findWidgetsByName(AlixLivePlayback.WIDGET_NAME)) != null) {
                Iterator<IWidget> it = findWidgetsByName.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    IWidget next = it.next();
                    if (next instanceof IDagoLivePlaybackInjectorInterface) {
                        r0 = (IDagoLivePlaybackInjectorInterface) next;
                        break;
                    }
                }
            }
        }
        this.mInjector = r0;
        return r0;
    }

    public static void refreshElementByModel(View view, String str, PlayerInteract.Controller controller) {
        int dp2px;
        int dp2px2;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "722584917")) {
            ipChange.ipc$dispatch("722584917", new Object[]{view, str, controller});
        } else if (view == null || controller == null) {
        } else {
            PlayerInteract.Content content = controller.current;
            if (content != null && content != null) {
                if (content.isHide) {
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                }
            }
            if (str != null) {
                if (ELEMENT_CUSTOM_IMAGE.equals(str)) {
                    PlayerInteract.Content content2 = controller.current;
                    if (view instanceof ImageView) {
                        ImageView imageView = (ImageView) view;
                        if (content2 == null || content2.data == null) {
                            return;
                        }
                        ((IImageLoaderFactory) Dsl.getService(IImageLoaderFactory.class)).createInstance().loadUrl(content2.data).into(imageView);
                    }
                } else if (ELEMENT_POP_IMAGE.equals(str)) {
                    PlayerInteract.Content content3 = controller.current;
                    if (view instanceof PopImageLayout) {
                        PopImageLayout popImageLayout = (PopImageLayout) view;
                        if (content3 != null) {
                            popImageLayout.setData(content3.data, content3.num);
                        }
                    }
                } else if ("image".equals(str)) {
                    PlayerInteract.Content content4 = controller.current;
                    if (view instanceof ImageView) {
                        ImageView imageView2 = (ImageView) view;
                        imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        if (content4 == null || content4.data == null) {
                            return;
                        }
                        ((IImageLoaderFactory) Dsl.getService(IImageLoaderFactory.class)).createInstance().loadUrl(content4.data).into(imageView2);
                    }
                } else if ("text".equals(str)) {
                    PlayerInteract.Content content5 = controller.current;
                    if (view instanceof TextView) {
                        TextView textView = (TextView) view;
                        textView.setBackgroundColor(-1);
                        if (content5 == null || (str2 = content5.data) == null) {
                            return;
                        }
                        textView.setText(str2);
                        textView.setGravity(17);
                        textView.setTextSize(2, 14.0f);
                        textView.setTextColor(content5.textColorInt);
                    }
                } else if (ELEMENT_DANMAKU.equals(str)) {
                } else {
                    if (ELEMENT_ANCHOR_INFO.equals(str)) {
                        PlayerInteract.Content content6 = controller.current;
                        ((ILog) Dsl.getService(ILog.class)).i("liulei-anchor", "refresh ELEMENT_ANCHOR_INFO");
                        if (view instanceof DagoAnchorInfoView) {
                            DagoAnchorInfoView dagoAnchorInfoView = (DagoAnchorInfoView) view;
                            if (content6 != null) {
                                if (dagoAnchorInfoView.getLayoutParams() != null) {
                                    if (dagoAnchorInfoView.getContext() != null) {
                                        if (!content6.showFollowBtn) {
                                            dp2px2 = UnitUtil.dp2px(dagoAnchorInfoView.getContext(), 112);
                                        } else {
                                            dp2px2 = UnitUtil.dp2px(dagoAnchorInfoView.getContext(), UNIT_ANCHOR_INFO_WIDTH);
                                        }
                                        int i = (int) (dp2px2 + 0.5f);
                                        ((ILog) Dsl.getService(ILog.class)).i("liulei-anchor", "refresh 1111   " + i);
                                        dagoAnchorInfoView.getLayoutParams().width = i;
                                        ViewGroup.LayoutParams layoutParams = controller.layoutParams;
                                        if (layoutParams != null) {
                                            layoutParams.width = i;
                                        }
                                        dagoAnchorInfoView.requestLayout();
                                    }
                                } else if (dagoAnchorInfoView.getContext() != null) {
                                    if (!content6.showFollowBtn) {
                                        dp2px = UnitUtil.dp2px(dagoAnchorInfoView.getContext(), 112);
                                    } else {
                                        dp2px = UnitUtil.dp2px(dagoAnchorInfoView.getContext(), UNIT_ANCHOR_INFO_WIDTH);
                                    }
                                    int i2 = (int) (dp2px + 0.5f);
                                    ((ILog) Dsl.getService(ILog.class)).i("liulei-anchor", "refresh 2222 = " + i2);
                                    ViewGroup.LayoutParams layoutParams2 = controller.layoutParams;
                                    if (layoutParams2 != null) {
                                        layoutParams2.width = i2;
                                    }
                                    dagoAnchorInfoView.setLayoutParams(new LinearLayout.LayoutParams(i2, (int) (UnitUtil.dp2px(dagoAnchorInfoView.getContext(), 36) + 0.5f)));
                                }
                                List<String> list = content6.btnBg;
                                if (list != null && list.size() > 0) {
                                    String str3 = content6.btnBg.get(1);
                                    if ("FFFF8200".equalsIgnoreCase(content6.btnBg.get(0)) && "FFFFB700".equalsIgnoreCase(str3)) {
                                        dagoAnchorInfoView.setBizType(3);
                                    } else {
                                        dagoAnchorInfoView.setBizType(6);
                                    }
                                } else {
                                    dagoAnchorInfoView.setBizType(6);
                                }
                                dagoAnchorInfoView.setAttentionVisibility(content6.showFollowBtn, false);
                                dagoAnchorInfoView.updateAnchorAttentionState(content6.anchorIsFollow);
                                dagoAnchorInfoView.updateAnchorAvatar(content6.anchorAvatar);
                                dagoAnchorInfoView.updateAnchorDesc(content6.anchorFansCount);
                                dagoAnchorInfoView.updateAnchorName(content6.anchorName);
                                dagoAnchorInfoView.setSubtitleIcon(content6.iconUrl);
                            }
                        }
                    } else if (ELEMENT_USER_LIST.equals(str)) {
                        PlayerInteract.Content content7 = controller.current;
                        if (view instanceof UserListView) {
                            UserListView userListView = (UserListView) view;
                            if (content7 != null) {
                                String str4 = content7.size;
                                if (str4 != null) {
                                    userListView.setMode(str4);
                                }
                                List list2 = content7.updateUserList;
                                if (list2 != null) {
                                    userListView.bubbleUserList(list2);
                                }
                                Integer num = content7.updateUserCount;
                                if (num != null) {
                                    userListView.setUserCount(num.intValue());
                                }
                                String str5 = content7.liveId;
                                if (str5 != null) {
                                    userListView.reqUserList(str5);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean setInjectedViews(String str, String str2, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-550803939")) {
            return ((Boolean) ipChange.ipc$dispatch("-550803939", new Object[]{this, str, str2, view})).booleanValue();
        }
        if (str == null || str2 == null || view == null) {
            return false;
        }
        Map<String, Map<String, View>> injectedViewsMap = getInjectedViewsMap();
        Map<String, View> map = injectedViewsMap.containsKey(str) ? injectedViewsMap.get(str) : null;
        if (map == null) {
            map = new HashMap<>();
            injectedViewsMap.put(str, map);
        }
        map.put(str2, view);
        return true;
    }

    @JSMethod
    public void addController(String str, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-289387022")) {
            ipChange.ipc$dispatch("-289387022", new Object[]{this, str, jSCallback});
            return;
        }
        try {
            addController((PlayerInteract.AddController) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(str, PlayerInteract.AddController.class), jSCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @JSMethod
    public void addSeiEvent(final JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "450520035")) {
            ipChange.ipc$dispatch("450520035", new Object[]{this, jSCallback});
            return;
        }
        IDagoLivePlaybackInjectorInterface injector = getInjector();
        if (injector != null) {
            injector.injectorSetSeiEventListener(new IDagoLivePlaybackInjectorInterface.IResultListener() { // from class: com.youku.live.dago.module.DagoPlayerInteract.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface.IResultListener
                public void onResult(Map<String, Object> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1869975378")) {
                        ipChange2.ipc$dispatch("1869975378", new Object[]{this, map});
                    } else {
                        jSCallback.invokeAndKeepAlive(map.get("sei"));
                    }
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r0v19, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r0v27, types: [android.widget.RelativeLayout, com.youku.live.dago.view.dagocustomelement.PopImageLayout] */
    /* JADX WARN: Type inference failed for: r0v36, types: [android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.widget.RelativeLayout, com.youku.live.dago.widgetlib.view.anchor.DagoAnchorInfoView] */
    public View createElementByType(Context context, String str, PlayerInteract.Controller controller, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033240196")) {
            return (View) ipChange.ipc$dispatch("-1033240196", new Object[]{this, context, str, controller, onClickListener});
        }
        UserListView userListView = null;
        userListView = null;
        userListView = null;
        userListView = null;
        if (controller != null) {
            controller.preprocess();
        }
        if (str != null && controller != null) {
            if (ELEMENT_CUSTOM_IMAGE.equals(str)) {
                controller.layoutParams = new LinearLayout.LayoutParams((int) (UnitUtil.dp2px(context, controller.current.width) + 0.5f), (int) (UnitUtil.dp2px(context, controller.current.height) + 0.5f));
                ?? imageView = new ImageView(context);
                imageView.setTag(R.id.dago_interact_controller, controller);
                imageView.setOnClickListener(onClickListener);
                userListView = imageView;
            } else {
                if (ELEMENT_POP_IMAGE.equals(str)) {
                    int i = controller.current.width;
                    if (i <= 0) {
                        i = 32;
                    }
                    int dp2px = (int) (UnitUtil.dp2px(context, i) + 0.5f);
                    int i2 = controller.current.height;
                    controller.layoutParams = new LinearLayout.LayoutParams(dp2px, (int) (UnitUtil.dp2px(context, i2 > 0 ? i2 : 32) + 0.5f));
                    ?? popImageLayout = new PopImageLayout(context);
                    popImageLayout.setTag(R.id.dago_interact_controller, controller);
                    popImageLayout.setOnClickListener(onClickListener);
                    userListView = popImageLayout;
                } else if ("image".equals(str)) {
                    controller.layoutParams = new LinearLayout.LayoutParams((int) (UnitUtil.dp2px(context, 32) + 0.5f), (int) (UnitUtil.dp2px(context, 32) + 0.5f));
                    ?? imageView2 = new ImageView(context);
                    imageView2.setTag(R.id.dago_interact_controller, controller);
                    imageView2.setOnClickListener(onClickListener);
                    userListView = imageView2;
                } else if ("text".equals(str)) {
                    controller.layoutParams = new LinearLayout.LayoutParams(-2, (int) (UnitUtil.dp2px(context, 28) + 0.5f));
                    ?? textView = new TextView(context);
                    textView.setTag(R.id.dago_interact_controller, controller);
                    textView.setOnClickListener(onClickListener);
                    userListView = textView;
                } else if (ELEMENT_DANMAKU.equals(str)) {
                    controller.layoutParams = new LinearLayout.LayoutParams(4, 4);
                } else if (ELEMENT_ANCHOR_INFO.equals(str)) {
                    ((ILog) Dsl.getService(ILog.class)).i("liulei-anchor", "ctreate ELEMENT_ANCHOR_INFO");
                    final ?? dagoAnchorInfoView = new DagoAnchorInfoView(context);
                    dagoAnchorInfoView.setTag(R.id.dago_interact_controller, controller);
                    controller.layoutParams = new LinearLayout.LayoutParams((int) (UnitUtil.dp2px(context, UNIT_ANCHOR_INFO_WIDTH) + 0.5f), (int) (UnitUtil.dp2px(context, 36) + 0.5f));
                    PlayerInteract.Ret ret = new PlayerInteract.Ret();
                    controller.onClick = ret;
                    ret.action = controller.current.onAction.clickAnchorInfo;
                    ret.key = controller.key;
                    ret.state = controller.state;
                    PlayerInteract.Ret ret2 = new PlayerInteract.Controller(controller).onClick;
                    ret2.action = controller.current.onAction.clickFollowBtn;
                    ret2.key = controller.key;
                    ret2.state = controller.state;
                    dagoAnchorInfoView.setAnchorCallback(new DagoAnchorInfoView.AnchorCallback() { // from class: com.youku.live.dago.module.DagoPlayerInteract.3
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.youku.live.dago.widgetlib.view.anchor.DagoAnchorInfoView.AnchorCallback
                        public void onAttentionClick() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-1767921657")) {
                                ipChange2.ipc$dispatch("-1767921657", new Object[]{this});
                                return;
                            }
                            DagoAnchorInfoView dagoAnchorInfoView2 = dagoAnchorInfoView;
                            if (dagoAnchorInfoView2 != null) {
                                Object tag = dagoAnchorInfoView2.getTag(R.id.dago_interact_controller);
                                if (tag instanceof PlayerInteract.Controller) {
                                    PlayerInteract.Controller controller2 = (PlayerInteract.Controller) tag;
                                    PlayerInteract.Ret ret3 = new PlayerInteract.Ret();
                                    ret3.action = controller2.current.onAction.clickFollowBtn;
                                    ret3.key = controller2.key;
                                    ret3.state = controller2.state;
                                    DagoPlayerInteract.this.onClick(ret3, null);
                                }
                            }
                        }

                        @Override // com.youku.live.dago.widgetlib.view.anchor.DagoAnchorInfoView.AnchorCallback
                        public void onAvatarClick() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "1810373386")) {
                                ipChange2.ipc$dispatch("1810373386", new Object[]{this});
                                return;
                            }
                            DagoAnchorInfoView dagoAnchorInfoView2 = dagoAnchorInfoView;
                            if (dagoAnchorInfoView2 != null) {
                                Object tag = dagoAnchorInfoView2.getTag(R.id.dago_interact_controller);
                                if (tag instanceof PlayerInteract.Controller) {
                                    PlayerInteract.Controller controller2 = (PlayerInteract.Controller) tag;
                                    PlayerInteract.Ret ret3 = new PlayerInteract.Ret();
                                    ret3.action = controller2.current.onAction.clickAnchorInfo;
                                    ret3.key = controller2.key;
                                    ret3.state = controller2.state;
                                    DagoPlayerInteract.this.onClick(ret3, null);
                                }
                            }
                        }
                    });
                    userListView = dagoAnchorInfoView;
                } else if (ELEMENT_USER_LIST.equals(str)) {
                    final UserListView userListView2 = new UserListView(context);
                    userListView2.setTag(R.id.dago_interact_controller, controller);
                    controller.layoutParams = new LinearLayout.LayoutParams(0, (int) (UnitUtil.dp2px(context, 36) + 0.5f), 1.0f);
                    userListView2.setOnItemClickListener(new UserListView.IClickCallback() { // from class: com.youku.live.dago.module.DagoPlayerInteract.4
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.youku.live.dago.widgetlib.ailproom.adapter.userlist.UserListView.IClickCallback
                        public void onItemClick(UserListBean userListBean) {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-332142382")) {
                                ipChange2.ipc$dispatch("-332142382", new Object[]{this, userListBean});
                            } else if (userListBean != null && !TextUtils.isEmpty(userListBean.u)) {
                                UserListView userListView3 = userListView2;
                                if (userListView3 != null) {
                                    Object tag = userListView3.getTag(R.id.dago_interact_controller);
                                    if (tag instanceof PlayerInteract.Controller) {
                                        PlayerInteract.Controller controller2 = (PlayerInteract.Controller) tag;
                                        PlayerInteract.Ret ret3 = new PlayerInteract.Ret();
                                        ret3.key = controller2.key;
                                        ret3.state = controller2.state;
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("userId", userListBean.u);
                                        DagoPlayerInteract.this.onClick(ret3, hashMap);
                                    }
                                }
                            } else {
                                UserListView userListView4 = userListView2;
                                if (userListView4 != null) {
                                    Object tag2 = userListView4.getTag(R.id.dago_interact_controller);
                                    if (tag2 instanceof PlayerInteract.Controller) {
                                        PlayerInteract.Controller controller3 = (PlayerInteract.Controller) tag2;
                                        PlayerInteract.Ret ret4 = new PlayerInteract.Ret();
                                        ret4.key = controller3.key;
                                        ret4.state = controller3.state;
                                        DagoPlayerInteract.this.onClick(ret4, null);
                                    }
                                }
                            }
                        }
                    });
                    userListView = userListView2;
                } else {
                    controller.layoutParams = new LinearLayout.LayoutParams(4, 4);
                }
            }
            if (userListView != null) {
                refreshElementByModel(userListView, str, controller);
            }
        }
        if (userListView == null) {
            View view = new View(context);
            view.setOnClickListener(onClickListener);
            view.setBackgroundColor(-16711936);
            view.setTag(R.id.dago_interact_controller, controller);
            return view;
        }
        return userListView;
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1026305295")) {
            ipChange.ipc$dispatch("1026305295", new Object[]{this});
        } else {
            this.mControllerResultCallback = null;
        }
    }

    @JSMethod
    public void goBackToMultiScreenSelect() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-888775118")) {
            ipChange.ipc$dispatch("-888775118", new Object[]{this});
            return;
        }
        IDagoLivePlaybackInjectorInterface injector = getInjector();
        if (injector != null) {
            injector.injectorPlayerAction(Constants.WEEX.ACTION.Multi_GO_BACK, (Map<String, Object>) null);
        }
    }

    @JSMethod
    public void initModule() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1761325563")) {
            ipChange.ipc$dispatch("-1761325563", new Object[]{this});
            return;
        }
        IDagoLivePlaybackInjectorInterface injector = getInjector();
        if (injector != null) {
            IDagoLivePlaybackInjectorInterface.IResultListener iResultListener = new IDagoLivePlaybackInjectorInterface.IResultListener() { // from class: com.youku.live.dago.module.DagoPlayerInteract.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dsl.widgets.IDagoLivePlaybackInjectorInterface.IResultListener
                public void onResult(Map<String, Object> map) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1858659251")) {
                        ipChange2.ipc$dispatch("1858659251", new Object[]{this, map});
                        return;
                    }
                    WXSDKInstance wXSDKInstance = DagoPlayerInteract.this.mWXSDKInstance;
                    if (wXSDKInstance == null || map == null || !map.containsKey("key")) {
                        return;
                    }
                    wXSDKInstance.fireGlobalEventCallback((String) map.get("key"), map);
                }
            };
            HashMap hashMap = new HashMap(1);
            hashMap.put("value", iResultListener);
            injector.injectorPlayerAction(LiveWeexWidget.GLOBAL_EVENT, hashMap);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1435207954")) {
            ipChange.ipc$dispatch("1435207954", new Object[]{this, view});
            return;
        }
        JSCallback jSCallback = this.mControllerResultCallback;
        if (view == null || jSCallback == null) {
            return;
        }
        Object tag = view.getTag(R.id.dago_interact_controller);
        if (tag instanceof PlayerInteract.Controller) {
            onClick((PlayerInteract.Controller) tag);
        }
    }

    @JSMethod
    public void play() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1506437011")) {
            ipChange.ipc$dispatch("-1506437011", new Object[]{this});
            return;
        }
        IDagoLivePlaybackInjectorInterface injector = getInjector();
        if (injector != null) {
            injector.injectorPlayerAction(Constants.Value.PLAY, (Map<String, Object>) null);
        }
    }

    @JSMethod
    public void rePower() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692414839")) {
            ipChange.ipc$dispatch("1692414839", new Object[]{this});
            return;
        }
        IDagoLivePlaybackInjectorInterface injector = getInjector();
        if (injector != null) {
            injector.injectorPlayerAction("rePower", (Map<String, Object>) null);
        }
    }

    @JSMethod
    public void setAHDRState(boolean z, JSCallback jSCallback, JSCallback jSCallback2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "903980941")) {
            ipChange.ipc$dispatch("903980941", new Object[]{this, Boolean.valueOf(z), jSCallback, jSCallback2});
            return;
        }
        IDagoLivePlaybackInjectorInterface injector = getInjector();
        if (injector != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("open", Boolean.valueOf(z));
            injector.injectorPlayerAction("setAHDRState", hashMap);
            jSCallback.invokeAndKeepAlive(null);
        }
    }

    @JSMethod
    @Deprecated
    public void setControllerStyle(JSONObject jSONObject, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-647924698")) {
            ipChange.ipc$dispatch("-647924698", new Object[]{this, jSONObject, jSCallback});
        }
    }

    @JSMethod
    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1397768415")) {
            ipChange.ipc$dispatch("1397768415", new Object[]{this});
            return;
        }
        IDagoLivePlaybackInjectorInterface injector = getInjector();
        if (injector != null) {
            injector.injectorPlayerAction("stop", (Map<String, Object>) null);
        }
    }

    @JSMethod
    public void switchListMultiScreenWithSceneId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-881528067")) {
            ipChange.ipc$dispatch("-881528067", new Object[]{this, str});
            return;
        }
        IDagoLivePlaybackInjectorInterface injector = getInjector();
        if (injector != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("sceneId", str);
            injector.injectorPlayerAction("switchListMultiScreenWithSceneId", hashMap);
        }
    }

    @JSMethod
    public void updateControllerContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1517495775")) {
            ipChange.ipc$dispatch("1517495775", new Object[]{this, str});
            return;
        }
        try {
            updateControllerContent((PlayerInteract.UpdateControllerContent) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(str, PlayerInteract.UpdateControllerContent.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @JSMethod
    public void updateControllerState(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-522031353")) {
            ipChange.ipc$dispatch("-522031353", new Object[]{this, str});
            return;
        }
        try {
            updateControllerState((PlayerInteract.UpdateControllerContent) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize(str, PlayerInteract.UpdateControllerContent.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @JSMethod
    public void updateDanmuState(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1243033482")) {
            ipChange.ipc$dispatch("1243033482", new Object[]{this, str});
        }
    }

    private void updateControllerContent(PlayerInteract.UpdateControllerContent updateControllerContent) {
        List<PlayerInteract.State> list;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-775231428")) {
            ipChange.ipc$dispatch("-775231428", new Object[]{this, updateControllerContent});
            return;
        }
        View injectedViews = getInjectedViews(updateControllerContent.tag, updateControllerContent.key);
        if (injectedViews != null) {
            Object tag = injectedViews.getTag(R.id.dago_interact_controller);
            if (tag instanceof PlayerInteract.Controller) {
                PlayerInteract.Controller controller = (PlayerInteract.Controller) tag;
                if (controller.state == null || updateControllerContent.state == null || (list = updateControllerContent.states) == null) {
                    return;
                }
                PlayerInteract.State state = null;
                Iterator<PlayerInteract.State> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PlayerInteract.State next = it.next();
                    if (next != null && (str = next.state) != null && str.equals(updateControllerContent.state)) {
                        state = next;
                        break;
                    }
                }
                if (state != null) {
                    controller.mapstates.put(updateControllerContent.state, state.content);
                    if (controller.state.equals(updateControllerContent.state)) {
                        controller.current = state.content;
                        refreshElementByModel(injectedViews, controller.type, controller);
                    }
                }
            }
        }
    }

    private void updateControllerState(PlayerInteract.UpdateControllerContent updateControllerContent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1218724196")) {
            ipChange.ipc$dispatch("1218724196", new Object[]{this, updateControllerContent});
            return;
        }
        View injectedViews = getInjectedViews(updateControllerContent.tag, updateControllerContent.key);
        if (injectedViews != null) {
            Object tag = injectedViews.getTag(R.id.dago_interact_controller);
            if (tag instanceof PlayerInteract.Controller) {
                PlayerInteract.Controller controller = (PlayerInteract.Controller) tag;
                String str = updateControllerContent.state;
                controller.state = str;
                controller.current = controller.mapstates.get(str);
                refreshElementByModel(injectedViews, controller.type, controller);
            }
        }
    }

    @JSMethod
    public void addController(PlayerInteract.AddController addController, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-681539938")) {
            ipChange.ipc$dispatch("-681539938", new Object[]{this, addController, jSCallback});
            return;
        }
        IDagoLivePlaybackInjectorInterface injector = getInjector();
        this.mControllerResultCallback = jSCallback;
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        Context context = wXSDKInstance != null ? wXSDKInstance.getContext() : null;
        if (injector == null || context == null) {
            return;
        }
        if (addController != null) {
            createAllElements(context, injector, addController, this);
        }
        View view = new View(context);
        view.setBackgroundColor(1711341567);
        injector.injectorInsertView2DanmuPlugin(view, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void onClick(PlayerInteract.Controller controller) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "327180217")) {
            ipChange.ipc$dispatch("327180217", new Object[]{this, controller});
        } else if (this.mControllerResultCallback == null || controller == null) {
        } else {
            PlayerInteract.Ret ret = controller.onClick;
            ret.state = controller.state;
            onClick(ret, controller.onClickParams);
        }
    }

    public void onClick(PlayerInteract.Ret ret, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "344636203")) {
            ipChange.ipc$dispatch("344636203", new Object[]{this, ret, map});
            return;
        }
        JSCallback jSCallback = this.mControllerResultCallback;
        if (jSCallback != null) {
            HashMap hashMap = new HashMap();
            if (ret != null) {
                hashMap.put("key", ret.key);
                hashMap.put("action", ret.action);
                hashMap.put("state", ret.state);
            }
            if (map != null) {
                hashMap.putAll(map);
            }
            jSCallback.invokeAndKeepAlive(hashMap);
        }
    }

    private int createElementsByType(Context context, IDagoLivePlaybackInjectorInterface iDagoLivePlaybackInjectorInterface, String str, boolean z, List<PlayerInteract.Controller> list, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "2078762678")) {
            return ((Integer) ipChange.ipc$dispatch("2078762678", new Object[]{this, context, iDagoLivePlaybackInjectorInterface, str, Boolean.valueOf(z), list, onClickListener})).intValue();
        }
        if (list == null) {
            return 0;
        }
        Map<String, Map<String, View>> injectedViewsMap = getInjectedViewsMap();
        Map<String, View> map = injectedViewsMap.containsKey(str) ? injectedViewsMap.get(str) : null;
        if (map == null) {
            map = new HashMap<>();
            injectedViewsMap.put(str, map);
        }
        HashMap hashMap = new HashMap();
        for (PlayerInteract.Controller controller : list) {
            if (map.containsKey(controller.key)) {
                hashMap.put(controller.key, map.remove(controller.key));
            }
        }
        for (Map.Entry<String, View> entry : map.entrySet()) {
            entry.getValue().setVisibility(8);
        }
        injectedViewsMap.put(str, hashMap);
        ArrayList arrayList = new ArrayList();
        for (PlayerInteract.Controller controller2 : list) {
            controller2.onPortrait = z;
            controller2.area = str;
            View createElementByType = createElementByType(context, controller2.type, controller2, onClickListener);
            setInjectedViews(str, controller2.key, createElementByType);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("key", controller2.key);
            hashMap2.put("view", createElementByType);
            hashMap2.put(com.youku.live.dago.liveplayback.widget.Constants.ACTION_PARAMS_LAYOUTPARAMS, controller2.layoutParams);
            hashMap2.put("p", Integer.valueOf(i));
            hashMap2.put(com.youku.live.dago.liveplayback.widget.Constants.ACTION_PARAMS_AREA, str);
            hashMap2.put("s", Boolean.valueOf(z));
            arrayList.add(hashMap2);
            i++;
        }
        if (iDagoLivePlaybackInjectorInterface != null) {
            iDagoLivePlaybackInjectorInterface.injectorPlayerAction("insertView2ControlPlugin", arrayList);
        }
        return i;
    }

    private List<Map<String, Object>> createElementsByType(Context context, String str, boolean z, List<PlayerInteract.Controller> list, View.OnClickListener onClickListener) {
        PlayerInteract.State state;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1857621154")) {
            return (List) ipChange.ipc$dispatch("-1857621154", new Object[]{this, context, str, Boolean.valueOf(z), list, onClickListener});
        }
        if (list == null) {
            return null;
        }
        Map<String, Map<String, View>> injectedViewsMap = getInjectedViewsMap();
        Map<String, View> map = injectedViewsMap.containsKey(str) ? injectedViewsMap.get(str) : null;
        if (map == null) {
            map = new HashMap<>();
            injectedViewsMap.put(str, map);
        }
        HashMap hashMap = new HashMap();
        for (PlayerInteract.Controller controller : list) {
            if (map.containsKey(controller.key)) {
                hashMap.put(controller.key, map.remove(controller.key));
            }
        }
        for (Map.Entry<String, View> entry : map.entrySet()) {
            entry.getValue().setVisibility(8);
        }
        injectedViewsMap.put(str, hashMap);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (PlayerInteract.Controller controller2 : list) {
            controller2.onPortrait = z;
            controller2.area = str;
            View createElementByType = createElementByType(context, controller2.type, controller2, onClickListener);
            setInjectedViews(str, controller2.key, createElementByType);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("key", controller2.key);
            hashMap2.put("view", createElementByType);
            hashMap2.put(com.youku.live.dago.liveplayback.widget.Constants.ACTION_PARAMS_LAYOUTPARAMS, controller2.layoutParams);
            int i2 = i + 1;
            hashMap2.put("p", Integer.valueOf(i));
            hashMap2.put(com.youku.live.dago.liveplayback.widget.Constants.ACTION_PARAMS_AREA, str);
            hashMap2.put("s", Boolean.valueOf(z));
            List<PlayerInteract.State> list2 = controller2.states;
            if (list2 != null && list2.size() > 0 && (state = controller2.states.get(0)) != null && state.content != null) {
                hashMap2.put("tip", controller2.states.get(0).content.tipText);
            }
            arrayList.add(hashMap2);
            i = i2;
        }
        return arrayList;
    }
}
