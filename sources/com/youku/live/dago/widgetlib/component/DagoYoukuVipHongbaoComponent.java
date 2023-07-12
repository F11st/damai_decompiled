package com.youku.live.dago.widgetlib.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.phenix.request.ImageStatistics;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXVContainer;
import com.youku.live.dago.model.data.LiveInfoGetAnchorInfoDataModel;
import com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoHelper;
import com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoView;
import com.youku.live.dago.widgetlib.view.hongbao.HongbaoUTUtils;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.account.ILogin;
import com.youku.live.dsl.json.IDeserialize;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol.IProps;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoYoukuVipHongbaoComponent extends ProxyWXComponent<View> implements IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoYoukuVipHongbaoComponent";
    private String mAnchorId;
    private LiveInfoGetAnchorInfoDataModel mAnchorInfo;
    private String mAnchorName;
    private String mAnchorUrl;
    private DagoVipHongbaoView mDagoHongbaoView;
    private DagoVipHongbaoHelper mHongbaoHelper;
    private boolean mIsInitialized;
    private String mRedPacketId;
    private String mRoomId;
    private String mScreenId;
    private String mSmoothTime;
    private String mTimeLeft;
    private String mTotalTime;

    public DagoYoukuVipHongbaoComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, str, z, basicComponentData);
        this.mIsInitialized = false;
    }

    private void initAttrs(final Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-830976154")) {
            ipChange.ipc$dispatch("-830976154", new Object[]{this, context});
        } else if (getBasicComponentData() == null || getBasicComponentData().getAttrs() == null) {
        } else {
            this.mTotalTime = (String) getBasicComponentData().getAttrs().get(ImageStatistics.KEY_TOTAL_TIME);
            this.mTimeLeft = (String) getBasicComponentData().getAttrs().get("timeleft");
            this.mAnchorName = (String) getBasicComponentData().getAttrs().get("anchorName");
            this.mAnchorId = (String) getBasicComponentData().getAttrs().get("anchorId");
            this.mAnchorUrl = (String) getBasicComponentData().getAttrs().get("anchorUrl");
            this.mRedPacketId = (String) getBasicComponentData().getAttrs().get("redPacketId");
            this.mSmoothTime = (String) getBasicComponentData().getAttrs().get("smoothTime");
            DagoVipHongbaoHelper dagoVipHongbaoHelper = new DagoVipHongbaoHelper(context, this.mRedPacketId, this.mTotalTime, this.mTimeLeft, this.mAnchorId, this.mAnchorName, this.mAnchorUrl);
            this.mHongbaoHelper = dagoVipHongbaoHelper;
            dagoVipHongbaoHelper.setSmoothTime(this.mSmoothTime);
            this.mDagoHongbaoView.setIListener(new DagoVipHongbaoView.IListener() { // from class: com.youku.live.dago.widgetlib.component.DagoYoukuVipHongbaoComponent.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoView.IListener
                public void onClick() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-245952162")) {
                        ipChange2.ipc$dispatch("-245952162", new Object[]{this});
                        return;
                    }
                    HongbaoUTUtils.smallHongbaoClick(DagoYoukuVipHongbaoComponent.this.mAnchorId, DagoYoukuVipHongbaoComponent.this.mRoomId, DagoYoukuVipHongbaoComponent.this.mScreenId);
                    if (((ILogin) Dsl.getService(ILogin.class)).isLogined()) {
                        DagoYoukuVipHongbaoComponent.this.showHongbaoView();
                    } else {
                        ((ILogin) Dsl.getService(ILogin.class)).login(context);
                    }
                }
            });
            this.mHongbaoHelper.setCallback(new DagoVipHongbaoHelper.ICallback() { // from class: com.youku.live.dago.widgetlib.component.DagoYoukuVipHongbaoComponent.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoHelper.ICallback
                public void onAttentionChange(boolean z) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-137448099")) {
                        ipChange2.ipc$dispatch("-137448099", new Object[]{this, Boolean.valueOf(z)});
                    } else if (DagoYoukuVipHongbaoComponent.this.mAnchorInfo != null) {
                        DagoYoukuVipHongbaoComponent.this.mAnchorInfo.followed = z;
                        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(DagoYoukuVipHongbaoComponent.this);
                        if (widgetEngineInstance != null) {
                            HashMap hashMap = new HashMap(1);
                            hashMap.put("followed", Boolean.TRUE);
                            widgetEngineInstance.asyncPutData("mtop.youku.live.widget.liveInfo.getInfo", JSON.toJSONString(hashMap));
                        }
                    }
                }

                @Override // com.youku.live.dago.widgetlib.view.hongbao.DagoVipHongbaoHelper.ICallback
                public void onHongbaoFinish() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1067339490")) {
                        ipChange2.ipc$dispatch("1067339490", new Object[]{this});
                    } else {
                        DagoYoukuVipHongbaoComponent.this.fireEvent("close");
                    }
                }
            });
            this.mHongbaoHelper.addCountDownView(this.mDagoHongbaoView);
            this.mHongbaoHelper.startCountDown();
            ((ILog) Dsl.getService(ILog.class)).i(TAG, " data attr" + this.mAnchorId + "\n " + this.mAnchorName + "\n " + this.mAnchorUrl + "\n " + this.mTotalTime + "\n " + this.mTimeLeft);
        }
    }

    private void initWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1688847805")) {
            ipChange.ipc$dispatch("1688847805", new Object[]{this});
        } else if (this.mIsInitialized) {
        } else {
            this.mIsInitialized = true;
            IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
            if (widgetEngineInstance != null) {
                IProps options = widgetEngineInstance.getOptions();
                if (options != null) {
                    String string = options.getString("pagename", "");
                    String string2 = options.getString("spm-cnt", "");
                    ((ILog) Dsl.getService(ILog.class)).i("liulei-UT", "page name = " + string);
                    if (!TextUtils.isEmpty(string)) {
                        HongbaoUTUtils.PAGENAME = string;
                    }
                    if (TextUtils.isEmpty(string2)) {
                        return;
                    }
                    HongbaoUTUtils.SPM_AB = string2;
                    return;
                }
                ((ILog) Dsl.getService(ILog.class)).i("liulei-UT", "OPTION is null ");
            }
        }
    }

    private void releaseView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "22893256")) {
            ipChange.ipc$dispatch("22893256", new Object[]{this});
            return;
        }
        DagoVipHongbaoView dagoVipHongbaoView = this.mDagoHongbaoView;
        if (dagoVipHongbaoView != null) {
            dagoVipHongbaoView.destroy();
            this.mDagoHongbaoView = null;
        }
    }

    private void releaseWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1092638422")) {
            ipChange.ipc$dispatch("1092638422", new Object[]{this});
        } else {
            WeexHelper.getWidgetEngineInstance(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHongbaoView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1465174140")) {
            ipChange.ipc$dispatch("1465174140", new Object[]{this});
        } else if (getRealView() == null || getRealView().getParent() == null || !(getRealView().getParent() instanceof View)) {
        } else {
            this.mHongbaoHelper.showHongbaoWindow((View) getRealView().getParent());
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "307015386")) {
            ipChange.ipc$dispatch("307015386", new Object[]{this});
            return;
        }
        super.destroy();
        ((ILog) Dsl.getService(ILog.class)).i(TAG, Constants.Event.SLOT_LIFECYCLE.DESTORY);
        releaseView();
        DagoVipHongbaoHelper dagoVipHongbaoHelper = this.mHongbaoHelper;
        if (dagoVipHongbaoHelper != null) {
            dagoVipHongbaoHelper.release();
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.removeDataHandler("mtop.youku.live.widget.liveInfo.getInfo", this);
            widgetEngineInstance.removeDataHandler("mtop.youku.live.com.livefullinfo", this);
        }
        releaseWithNothing();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected View initComponentHostView(@NonNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-79293808")) {
            return (View) ipChange.ipc$dispatch("-79293808", new Object[]{this, context});
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "initComponentHostView");
        releaseView();
        this.mDagoHongbaoView = new DagoVipHongbaoView(context);
        initAttrs(context);
        initWithNothing();
        return this.mDagoHongbaoView;
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        DagoVipHongbaoHelper dagoVipHongbaoHelper;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1267851883")) {
            ipChange.ipc$dispatch("1267851883", new Object[]{this, str, obj, obj2});
        } else if ("mtop.youku.live.com.livefullinfo".equals(str)) {
            if (obj instanceof LiveFullInfoData) {
                LiveFullInfoData liveFullInfoData = (LiveFullInfoData) obj;
                if (liveFullInfoData.template != null) {
                    ((ILog) Dsl.getService(ILog.class)).i("hongbaoUT", "roomInfo.template = " + liveFullInfoData.template.landScape);
                    z = liveFullInfoData.template.landScape.booleanValue();
                }
                this.mRoomId = liveFullInfoData.liveId + "";
                this.mScreenId = liveFullInfoData.screenId + "";
                this.mHongbaoHelper.setRoomInfo(liveFullInfoData.liveId, liveFullInfoData.screenId, z);
            }
        } else if ("mtop.youku.live.widget.liveInfo.getInfo".equals(str)) {
            this.mAnchorInfo = null;
            if (obj instanceof LiveInfoGetAnchorInfoDataModel) {
                this.mAnchorInfo = (LiveInfoGetAnchorInfoDataModel) obj;
            } else if (obj instanceof String) {
                this.mAnchorInfo = (LiveInfoGetAnchorInfoDataModel) ((IDeserialize) Dsl.getService(IDeserialize.class)).deserialize((String) obj, LiveInfoGetAnchorInfoDataModel.class);
            }
            LiveInfoGetAnchorInfoDataModel liveInfoGetAnchorInfoDataModel = this.mAnchorInfo;
            if (liveInfoGetAnchorInfoDataModel == null || (dagoVipHongbaoHelper = this.mHongbaoHelper) == null) {
                return;
            }
            dagoVipHongbaoHelper.updateAttention(liveInfoGetAnchorInfoDataModel.followed);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-371707066")) {
            ipChange.ipc$dispatch("-371707066", new Object[]{this, view});
            return;
        }
        super.onHostViewInitialized(view);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onHostViewInitialized");
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.addDataHandler("mtop.youku.live.widget.liveInfo.getInfo", this);
            widgetEngineInstance.addDataHandler("mtop.youku.live.com.livefullinfo", this);
        }
    }

    public DagoYoukuVipHongbaoComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        this.mIsInitialized = false;
    }

    public DagoYoukuVipHongbaoComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mIsInitialized = false;
    }

    public DagoYoukuVipHongbaoComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, int i, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, i, basicComponentData);
        this.mIsInitialized = false;
    }
}
