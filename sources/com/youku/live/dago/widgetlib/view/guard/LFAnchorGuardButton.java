package com.youku.live.dago.widgetlib.view.guard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.uc.webview.export.cyclone.StatAction;
import com.youku.live.animation.SVGAAnimationView;
import com.youku.live.arch.utils.StringUtils;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.module.GuardGodModel;
import com.youku.live.dago.widgetlib.util.AsyncInflaterUtils;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.account.ILogin;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.toast.IToast;
import com.youku.live.dsl.usertrack.IUserTracker;
import com.youku.live.livesdk.wkit.utils.SdkChannel;
import com.youku.live.widgets.protocol.IDestroyable;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LFAnchorGuardButton extends FrameLayout implements IDestroyable, IAppearStateChangedListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "LFAnchorGuardButton";
    private final String ANIM_GUARD;
    private SVGAAnimationView animationView;
    private boolean isFullScreen;
    private Context mContext;
    private IEngineInstance mEngineInstance;
    private GuardClickListener mGuardListener;
    private Handler mHandler;
    private View mInflateRoot;
    private String mRoomActorId;
    private String mRoomDirection;
    private String mRoomId;
    private String mScreenId;
    private int mShouhuAllNum;
    private ImageView mShouhuAvatar;
    private ImageView mShouhuBorder;
    private ImageView mShouhuIcon;
    private ImageView mShouhuNull;
    private int mShouhuNum;
    private FrameLayout mTextShouhu;
    private TextView mTextShouhuNum;
    private HashMap<String, String> params;
    private boolean supportAsyncInflater;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface GuardClickListener {
        void onGuardClicked();
    }

    public LFAnchorGuardButton(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoGuardPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1181469401")) {
            ipChange.ipc$dispatch("-1181469401", new Object[]{this});
            return;
        }
        GuardClickListener guardClickListener = this.mGuardListener;
        if (guardClickListener != null) {
            guardClickListener.onGuardClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGuard() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1696027293")) {
            ipChange.ipc$dispatch("-1696027293", new Object[]{this});
            return;
        }
        UIUtil.setGone(true, this.mShouhuAvatar, this.mTextShouhuNum);
        UIUtil.setGone(false, (View[]) new ImageView[]{this.mShouhuNull, this.mShouhuIcon});
        View view = this.mInflateRoot;
        if (view == null || view.getParent() != null) {
            return;
        }
        addView(this.mInflateRoot);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "751277259")) {
            ipChange.ipc$dispatch("751277259", new Object[]{this, context});
            return;
        }
        this.mContext = context;
        this.supportAsyncInflater = AsyncInflaterUtils.supportAsyncInflater();
        this.params = new HashMap<>();
        if (this.supportAsyncInflater) {
            new AsyncLayoutInflater(getContext()).inflate(R.layout.dago_lf_guard_btn_layout, this, new AsyncLayoutInflater.OnInflateFinishedListener() { // from class: com.youku.live.dago.widgetlib.view.guard.LFAnchorGuardButton.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
                public void onInflateFinished(View view, int i, ViewGroup viewGroup) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1308956481")) {
                        ipChange2.ipc$dispatch("1308956481", new Object[]{this, view, Integer.valueOf(i), viewGroup});
                        return;
                    }
                    viewGroup.addView(view);
                    LFAnchorGuardButton.this.mInflateRoot = view;
                    LFAnchorGuardButton lFAnchorGuardButton = LFAnchorGuardButton.this;
                    lFAnchorGuardButton.mTextShouhu = (FrameLayout) lFAnchorGuardButton.mInflateRoot.findViewById(R.id.guard_btn_layout);
                    LFAnchorGuardButton lFAnchorGuardButton2 = LFAnchorGuardButton.this;
                    lFAnchorGuardButton2.mTextShouhuNum = (TextView) lFAnchorGuardButton2.mInflateRoot.findViewById(R.id.guard_num_text);
                    LFAnchorGuardButton lFAnchorGuardButton3 = LFAnchorGuardButton.this;
                    lFAnchorGuardButton3.mShouhuIcon = (ImageView) lFAnchorGuardButton3.mInflateRoot.findViewById(R.id.guard_icon);
                    LFAnchorGuardButton lFAnchorGuardButton4 = LFAnchorGuardButton.this;
                    lFAnchorGuardButton4.mShouhuBorder = (ImageView) lFAnchorGuardButton4.mInflateRoot.findViewById(R.id.guard_border);
                    LFAnchorGuardButton lFAnchorGuardButton5 = LFAnchorGuardButton.this;
                    lFAnchorGuardButton5.animationView = (SVGAAnimationView) lFAnchorGuardButton5.mInflateRoot.findViewById(R.id.svga_anim_view);
                    LFAnchorGuardButton lFAnchorGuardButton6 = LFAnchorGuardButton.this;
                    lFAnchorGuardButton6.mShouhuNull = (ImageView) lFAnchorGuardButton6.mInflateRoot.findViewById(R.id.guard_bg);
                    LFAnchorGuardButton lFAnchorGuardButton7 = LFAnchorGuardButton.this;
                    lFAnchorGuardButton7.mShouhuAvatar = (ImageView) lFAnchorGuardButton7.mInflateRoot.findViewById(R.id.guard_avatar);
                    LFAnchorGuardButton.this.mTextShouhu.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.view.guard.LFAnchorGuardButton.1.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "-461982819")) {
                                ipChange3.ipc$dispatch("-461982819", new Object[]{this, view2});
                            } else if (LFAnchorGuardButton.this.isFullScreen) {
                                LFAnchorGuardButton.this.showNoClickToast();
                            } else if (((ILogin) Dsl.getService(ILogin.class)).isLogined()) {
                                if (LFAnchorGuardButton.this.params != null) {
                                    LFAnchorGuardButton.this.params.put("direction", LFAnchorGuardButton.this.mRoomDirection);
                                    HashMap hashMap = LFAnchorGuardButton.this.params;
                                    hashMap.put("roomid", LFAnchorGuardButton.this.mRoomId + "");
                                    HashMap hashMap2 = LFAnchorGuardButton.this.params;
                                    hashMap2.put("liveid", LFAnchorGuardButton.this.mRoomId + "");
                                    HashMap hashMap3 = LFAnchorGuardButton.this.params;
                                    hashMap3.put("screenid", LFAnchorGuardButton.this.mScreenId + "");
                                    HashMap hashMap4 = LFAnchorGuardButton.this.params;
                                    hashMap4.put("uid", LFAnchorGuardButton.this.mRoomActorId + "");
                                    LFAnchorGuardButton.this.params.put("scm", "");
                                }
                                String pageName = LFAnchorGuardButton.this.getPageName();
                                ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(pageName, LFAnchorGuardButton.this.getPageName() + "_interaction_guardentry", LFAnchorGuardButton.this.params);
                                LFAnchorGuardButton.this.gotoGuardPage();
                            } else {
                                ((ILogin) Dsl.getService(ILogin.class)).login();
                            }
                        }
                    });
                    LFAnchorGuardButton.this.initGuard();
                }
            });
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.layout.dago_lf_guard_btn_layout, (ViewGroup) this, false);
        this.mInflateRoot = inflate;
        this.mTextShouhu = (FrameLayout) inflate.findViewById(R.id.guard_btn_layout);
        this.mTextShouhuNum = (TextView) this.mInflateRoot.findViewById(R.id.guard_num_text);
        this.mShouhuIcon = (ImageView) this.mInflateRoot.findViewById(R.id.guard_icon);
        this.mShouhuBorder = (ImageView) this.mInflateRoot.findViewById(R.id.guard_border);
        this.animationView = (SVGAAnimationView) this.mInflateRoot.findViewById(R.id.svga_anim_view);
        this.mShouhuNull = (ImageView) this.mInflateRoot.findViewById(R.id.guard_bg);
        this.mShouhuAvatar = (ImageView) this.mInflateRoot.findViewById(R.id.guard_avatar);
        this.mTextShouhu.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.view.guard.LFAnchorGuardButton.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1627274385")) {
                    ipChange2.ipc$dispatch("1627274385", new Object[]{this, view});
                } else if (LFAnchorGuardButton.this.isFullScreen) {
                    LFAnchorGuardButton.this.showNoClickToast();
                } else if (((ILogin) Dsl.getService(ILogin.class)).isLogined()) {
                    if (LFAnchorGuardButton.this.params != null) {
                        LFAnchorGuardButton.this.params.put("direction", LFAnchorGuardButton.this.mRoomDirection);
                        HashMap hashMap = LFAnchorGuardButton.this.params;
                        hashMap.put("roomid", LFAnchorGuardButton.this.mRoomId + "");
                        HashMap hashMap2 = LFAnchorGuardButton.this.params;
                        hashMap2.put("liveid", LFAnchorGuardButton.this.mRoomId + "");
                        HashMap hashMap3 = LFAnchorGuardButton.this.params;
                        hashMap3.put("screenid", LFAnchorGuardButton.this.mScreenId + "");
                        HashMap hashMap4 = LFAnchorGuardButton.this.params;
                        hashMap4.put("uid", LFAnchorGuardButton.this.mRoomActorId + "");
                        LFAnchorGuardButton.this.params.put("scm", "");
                    }
                    String pageName = LFAnchorGuardButton.this.getPageName();
                    ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Click(pageName, LFAnchorGuardButton.this.getPageName() + "_interaction_guardentry", LFAnchorGuardButton.this.params);
                    LFAnchorGuardButton.this.gotoGuardPage();
                } else {
                    ((ILogin) Dsl.getService(ILogin.class)).login();
                }
            }
        });
        initGuard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playAnim(URL url) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-584838452")) {
            ipChange.ipc$dispatch("-584838452", new Object[]{this, url});
            return;
        }
        SVGAAnimationView sVGAAnimationView = this.animationView;
        if (sVGAAnimationView == null || url == null) {
            return;
        }
        if (sVGAAnimationView.isActivated()) {
            this.animationView.stopAnimation(true);
            this.animationView.setVisibility(8);
        }
        this.animationView.setLoops(1);
        new SVGAParser(getContext()).k(url, new SVGAParser.ParseCompletion() { // from class: com.youku.live.dago.widgetlib.view.guard.LFAnchorGuardButton.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(@NonNull SVGAVideoEntity sVGAVideoEntity) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "175400171")) {
                    ipChange2.ipc$dispatch("175400171", new Object[]{this, sVGAVideoEntity});
                    return;
                }
                LFAnchorGuardButton.this.mShouhuBorder.setVisibility(8);
                LFAnchorGuardButton.this.animationView.setVisibility(0);
                LFAnchorGuardButton.this.animationView.setVideoItem(sVGAVideoEntity);
                LFAnchorGuardButton.this.animationView.startAnimation();
            }

            @Override // com.opensource.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "532464991")) {
                    ipChange2.ipc$dispatch("532464991", new Object[]{this});
                } else {
                    LFAnchorGuardButton.this.animationView.setVisibility(8);
                }
            }
        });
        this.animationView.setCallback(new SVGACallback() { // from class: com.youku.live.dago.widgetlib.view.guard.LFAnchorGuardButton.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.opensource.svgaplayer.SVGACallback
            public void onFinished() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2071071342")) {
                    ipChange2.ipc$dispatch("-2071071342", new Object[]{this});
                    return;
                }
                LFAnchorGuardButton.this.animationView.setVisibility(8);
                LFAnchorGuardButton.this.mShouhuBorder.setVisibility(0);
            }

            @Override // com.opensource.svgaplayer.SVGACallback
            public void onPause() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-95515568")) {
                    ipChange2.ipc$dispatch("-95515568", new Object[]{this});
                }
            }

            @Override // com.opensource.svgaplayer.SVGACallback
            public void onRepeat() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-149441655")) {
                    ipChange2.ipc$dispatch("-149441655", new Object[]{this});
                }
            }

            @Override // com.opensource.svgaplayer.SVGACallback
            public void onStep(int i, double d) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1798842387")) {
                    ipChange2.ipc$dispatch("1798842387", new Object[]{this, Integer.valueOf(i), Double.valueOf(d)});
                }
            }
        });
    }

    private void setShouhuStr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1796778293")) {
            ipChange.ipc$dispatch("1796778293", new Object[]{this, str});
        } else if (this.mTextShouhuNum != null) {
            try {
                this.mShouhuNum = StringUtils.parse2Int(str);
                updateState();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoClickToast() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1625254325")) {
            ipChange.ipc$dispatch("1625254325", new Object[]{this});
        } else {
            ((IToast) Dsl.getService(IToast.class)).showCenterToast(this.mContext, "全屏模式下不支持查看");
        }
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-133563522")) {
            ipChange.ipc$dispatch("-133563522", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-580724348")) {
            ipChange.ipc$dispatch("-580724348", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void didDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1703121234")) {
            ipChange.ipc$dispatch("-1703121234", new Object[]{this});
        }
    }

    public String getPageName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1783998104")) {
            return (String) ipChange.ipc$dispatch("1783998104", new Object[]{this});
        }
        if (SdkChannel.isYouku(AppContextUtils.getApp())) {
            return "page_yklaifeng_room";
        }
        if (SdkChannel.isUC(AppContextUtils.getApp())) {
            return "page_uclive_room";
        }
        if (SdkChannel.isXiami(AppContextUtils.getApp())) {
            return "page_xiamilaifeng_room";
        }
        SdkChannel.isLaifeng(AppContextUtils.getApp());
        return "page_laifeng_room";
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "593136807")) {
            ipChange.ipc$dispatch("593136807", new Object[]{this});
        } else {
            super.onDetachedFromWindow();
        }
    }

    public void onPurchaseGuardianUpdate(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-809409726")) {
            ipChange.ipc$dispatch("-809409726", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d(TAG, "守护更新 " + str);
        try {
            JSONObject jSONObject = new JSONObject(str).optJSONArray("args").getJSONObject(0);
            JSONArray optJSONArray = jSONObject.optJSONObject("body").optJSONArray("list");
            int optInt = jSONObject.optJSONObject("body").optInt(StatAction.KEY_TOTAL);
            List parseArray = JSON.parseArray(optJSONArray.toString(), GuardGodModel.class);
            if (parseArray != null && !parseArray.isEmpty()) {
                String str2 = ((GuardGodModel) parseArray.get(0)).f;
                if (!TextUtils.isEmpty(str2)) {
                    DagoImageLoader.getInstance().showCircle(this.mContext, str2, this.mShouhuAvatar);
                    UIUtil.setGone(this.mShouhuNull, true);
                    UIUtil.setGone(this.mShouhuAvatar, false);
                } else {
                    UIUtil.setGone(this.mShouhuAvatar, true);
                    UIUtil.setGone(this.mShouhuNull, false);
                }
                setShouhuStr(StringUtils.valueOf(Integer.valueOf(optInt)));
                return;
            }
            UIUtil.setGone(this.mShouhuAvatar, true);
            UIUtil.setGone(this.mShouhuNull, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onScreenStatInfo(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1962973403")) {
            ipChange.ipc$dispatch("-1962973403", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "<<<<<<<<<ScreenStatInfoEvent--event args = " + i + AltriaXLaunchTime.SPACE + i2);
        this.mShouhuNum = i;
        this.mShouhuAllNum = i2;
        updateState();
    }

    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1184193617")) {
            ipChange.ipc$dispatch("1184193617", new Object[]{this});
            return;
        }
        SVGAAnimationView sVGAAnimationView = this.animationView;
        if (sVGAAnimationView != null) {
            sVGAAnimationView.stopAnimation(true);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ImageView imageView = this.mShouhuAvatar;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        UIUtil.setGone(true, this.mShouhuAvatar, this.mTextShouhuNum);
        UIUtil.setGone(false, (View[]) new ImageView[]{this.mShouhuNull, this.mShouhuIcon});
    }

    public void setEngineInstance(IEngineInstance iEngineInstance) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1306673590")) {
            ipChange.ipc$dispatch("-1306673590", new Object[]{this, iEngineInstance});
        } else {
            this.mEngineInstance = iEngineInstance;
        }
    }

    public void setFullScreen(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1270971975")) {
            ipChange.ipc$dispatch("-1270971975", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        this.isFullScreen = z;
        this.mRoomDirection = z ? "0" : "1";
    }

    public void setGuardListener(GuardClickListener guardClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-801709880")) {
            ipChange.ipc$dispatch("-801709880", new Object[]{this, guardClickListener});
        } else {
            this.mGuardListener = guardClickListener;
        }
    }

    public void setRoomInfo(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "815760331")) {
            ipChange.ipc$dispatch("815760331", new Object[]{this, str, str2, str3});
            return;
        }
        this.mRoomId = str;
        this.mRoomActorId = str2;
        this.mScreenId = str3;
    }

    public void startAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "870713989")) {
            ipChange.ipc$dispatch("870713989", new Object[]{this});
        } else {
            this.mHandler.sendEmptyMessage(1);
        }
    }

    public void startFirstAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1999500077")) {
            ipChange.ipc$dispatch("-1999500077", new Object[]{this});
        } else {
            this.mHandler.sendEmptyMessageDelayed(1, 10000L);
        }
    }

    public void stopAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-3486849")) {
            ipChange.ipc$dispatch("-3486849", new Object[]{this});
            return;
        }
        this.mShouhuBorder.setVisibility(0);
        this.animationView.setVisibility(8);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void updateState() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "716563952")) {
            ipChange.ipc$dispatch("716563952", new Object[]{this});
            return;
        }
        int i = this.mShouhuNum;
        if (i > 0) {
            if (i > 99) {
                this.mTextShouhuNum.setText("99+");
            } else {
                this.mTextShouhuNum.setText(String.valueOf(i));
            }
            this.mShouhuIcon.setVisibility(8);
            this.mTextShouhuNum.setVisibility(0);
            return;
        }
        this.mTextShouhuNum.setVisibility(8);
        this.mShouhuIcon.setVisibility(0);
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willAppear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1166475499")) {
            ipChange.ipc$dispatch("1166475499", new Object[]{this});
            return;
        }
        this.mRoomId = null;
        this.mRoomActorId = null;
        this.mScreenId = null;
        initGuard();
        setFullScreen(false);
    }

    @Override // com.youku.live.widgets.protocol2.lifecycle.IAppearStateChangedListener
    public void willDisappear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1581139481")) {
            ipChange.ipc$dispatch("-1581139481", new Object[]{this});
        }
    }

    public LFAnchorGuardButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LFAnchorGuardButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ANIM_GUARD = "https://files.alicdn.com/tpsservice/c4a257e465d6204c264bb792fbfe3998.zip";
        this.isFullScreen = false;
        this.supportAsyncInflater = false;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.dago.widgetlib.view.guard.LFAnchorGuardButton.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                URL url;
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1325017091")) {
                    ipChange.ipc$dispatch("-1325017091", new Object[]{this, message});
                } else if (message.what == 1) {
                    try {
                        url = new URL("https://files.alicdn.com/tpsservice/c4a257e465d6204c264bb792fbfe3998.zip");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        url = null;
                    }
                    LFAnchorGuardButton.this.playAnim(url);
                    removeCallbacksAndMessages(null);
                    sendEmptyMessageDelayed(1, 20000L);
                }
            }
        };
        initView(context);
    }
}
