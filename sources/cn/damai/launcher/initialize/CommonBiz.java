package cn.damai.launcher.initialize;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import anetwork.channel.monitor.Monitor;
import anetwork.channel.monitor.speed.NetworkSpeed;
import cn.damai.common.AppConfig;
import cn.damai.common.DamaiConstants;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.app.ShareperfenceConstants;
import cn.damai.common.image.DMImageStrategyConfig;
import cn.damai.common.image.b;
import cn.damai.common.uploader.AusConfigCenter;
import cn.damai.common.user.a;
import cn.damai.common.user.c;
import cn.damai.common.util.CompliantUtUtils;
import cn.damai.commonbusiness.poplayer.DMPopLayer;
import cn.damai.commonbusiness.share.ShareInit;
import cn.damai.h5container.UniH5ContainerSwitcher;
import cn.damai.h5container.WindvaneAgent;
import cn.damai.homepage.R$drawable;
import cn.damai.launcher.LauncherApplication;
import cn.damai.launcher.PrivacyDoubleListDelegate;
import cn.damai.launcher.utils.PictureGaiaxProviderImp;
import cn.damai.launcher.utils.SplashXFlushHelper;
import cn.damai.launcher.utils.WifiInfoUtil;
import cn.damai.login.LoginManager;
import cn.damai.net.NetConstants;
import cn.damai.onearch.token.DMTokenManager;
import cn.damai.push.DaMaiPushAgent;
import cn.damai.security.AliSecurityHelper;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.uikit.image.IImageLoader;
import cn.damai.wantsee.GeoDeBackList;
import cn.damai.wantsee.StartConfig;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.InitResultCallback;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.config.Environment;
import com.ali.user.open.jsbridge.UccJsBridge;
import com.ali.user.open.ucc.UccService;
import com.alibaba.pictures.cornerstone.APPClient;
import com.alibaba.pictures.cornerstone.EnvMode;
import com.alibaba.pictures.cornerstone.IAppBaseInfoProvider;
import com.alibaba.pictures.moimage.IImageUrlFixer;
import com.alibaba.pictures.moimage.IMoImageConfig;
import com.alibaba.pictures.moimage.ImgResExtraInfo;
import com.alibaba.pictures.moimage.ImgResQuality;
import com.alibaba.pictures.piclocation.LocationErrorReporter;
import com.alibaba.pictures.piclocation.listener.GetBlackListInterface;
import com.alibaba.pictures.piclocation.listener.GetLocationInfoInterface;
import com.alibaba.pictures.piclocation.mtop.LocationRequestDelegate;
import com.alibaba.pictures.piclocation.mtop.RegionRequestHandler;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx;
import com.alient.onearch.adapter.ComponentTypeMapper;
import com.alient.onearch.adapter.request.RemoteDataLoader;
import com.alient.onearch.adapter.state.StateViewManager;
import com.alient.oneservice.provider.impl.OneConfig;
import com.alient.oneservice.provider.impl.OneContext;
import com.amap.api.location.AMapLocation;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.Login;
import com.taobao.login4android.constants.LoginEnvType;
import com.taobao.pexode.Pexode;
import com.taobao.tao.image.IImageStrategySupport;
import com.taobao.tao.remotebusiness.login.RemoteLogin;
import com.uc.webview.export.extension.UCCore;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.drm.DrmConfig;
import com.youku.alixplayer.opensdk.ups.request.service.URLConnectionTask;
import com.youku.alixplayer.opensdk.utils.Callable;
import com.youku.android.liveservice.utils.MTopHelper;
import com.youku.arch.v3.data.Repository;
import com.youku.arch.v3.view.config.ComponentConfigManager;
import com.youku.gaiax.GaiaX;
import com.youku.gaiax.IStable;
import com.youku.gaiax.provider.module.proxy.PictureGaiaXProviderProxy;
import com.youku.live.dago.liveplayback.widget.Utils;
import com.youku.media.arch.instruments.utils.RemoteLogger;
import com.youku.middlewareservice.provider.info.DeviceInfoProviderProxy;
import com.youku.usercenter.passport.Domain;
import com.youku.usercenter.passport.PassportConfig;
import com.youku.usercenter.passport.PassportManager;
import com.youku.usercenter.passport.listener.IRefreshTokenListener;
import com.youku.usercenter.passport.mtop.LoginImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.intf.IDeviceInfo;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopSetting;
import mtopsdk.xstate.util.PhoneInfo;
import tb.cb1;
import tb.dw0;
import tb.e80;
import tb.ga1;
import tb.hg2;
import tb.hm;
import tb.hr1;
import tb.ia1;
import tb.ik2;
import tb.k3;
import tb.kk2;
import tb.ko;
import tb.m61;
import tb.mg1;
import tb.mu0;
import tb.my1;
import tb.n11;
import tb.on1;
import tb.rj1;
import tb.t03;
import tb.uh1;
import tb.wu0;
import tb.yl2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class CommonBiz {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ORANGE_CONFIT_IMAGE_PHENIX = "damai_image_android_phenix";
    public static final String TAG = LauncherApplication.class.getSimpleName() + "_xxx";
    private static CommonBiz c;
    public Application a;
    Handler b = new Handler(Looper.getMainLooper()) { // from class: cn.damai.launcher.initialize.CommonBiz.17
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1505184756")) {
                ipChange.ipc$dispatch("1505184756", new Object[]{this, message});
                return;
            }
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                if (AppConfig.v()) {
                    String str = CommonBiz.TAG;
                    cb1.c(str, "set env: " + message.obj);
                }
            } else if (i == 1) {
                CommonBiz.this.d();
            } else if (i == 2) {
                CommonBiz.this.e();
            } else if (i != 3) {
            } else {
                MTopHelper.setMtop(Mtop.instance(NetConstants.YOUKU_MTOP_INSTANCE_ID, CommonBiz.this.a, AppConfig.p()));
                PlayerConfig dynamicProperties = new PlayerConfig().setPlayerViewType(1).setAppKey(AppConfig.c()).setLiveCCode("live01010101damai").setAppVersion(AppConfig.q()).setUserAgent(CommonBiz.getDamaiUserAgent()).setCCode("01010121").setUseHardwareDecode(false).setDynamicProperties(new Callable<String>(this) { // from class: cn.damai.launcher.initialize.CommonBiz.17.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
                        if (r7.equals(com.youku.vpm.constants.TableField.IS_VIP) == false) goto L8;
                     */
                    @Override // com.youku.alixplayer.opensdk.utils.Callable
                    /* renamed from: a */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public java.lang.String call(java.lang.String r7) {
                        /*
                            r6 = this;
                            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.launcher.initialize.CommonBiz.AnonymousClass17.AnonymousClass1.$ipChange
                            java.lang.String r1 = "-498180035"
                            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
                            r3 = 2
                            r4 = 1
                            r5 = 0
                            if (r2 == 0) goto L1a
                            java.lang.Object[] r2 = new java.lang.Object[r3]
                            r2[r5] = r6
                            r2[r4] = r7
                            java.lang.Object r7 = r0.ipc$dispatch(r1, r2)
                            java.lang.String r7 = (java.lang.String) r7
                            return r7
                        L1a:
                            r7.hashCode()
                            r0 = -1
                            int r1 = r7.hashCode()
                            switch(r1) {
                                case -1354757532: goto L46;
                                case -892073626: goto L3b;
                                case 100481683: goto L32;
                                case 2064555103: goto L27;
                                default: goto L25;
                            }
                        L25:
                            r3 = -1
                            goto L50
                        L27:
                            java.lang.String r1 = "isLogin"
                            boolean r7 = r7.equals(r1)
                            if (r7 != 0) goto L30
                            goto L25
                        L30:
                            r3 = 3
                            goto L50
                        L32:
                            java.lang.String r1 = "isVip"
                            boolean r7 = r7.equals(r1)
                            if (r7 != 0) goto L50
                            goto L25
                        L3b:
                            java.lang.String r1 = "stoken"
                            boolean r7 = r7.equals(r1)
                            if (r7 != 0) goto L44
                            goto L25
                        L44:
                            r3 = 1
                            goto L50
                        L46:
                            java.lang.String r1 = "cookie"
                            boolean r7 = r7.equals(r1)
                            if (r7 != 0) goto L4f
                            goto L25
                        L4f:
                            r3 = 0
                        L50:
                            java.lang.String r7 = "false"
                            java.lang.String r0 = ""
                            switch(r3) {
                                case 0: goto L59;
                                case 1: goto L59;
                                case 2: goto L58;
                                case 3: goto L58;
                                default: goto L57;
                            }
                        L57:
                            r7 = 0
                        L58:
                            return r7
                        L59:
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: cn.damai.launcher.initialize.CommonBiz.AnonymousClass17.AnonymousClass1.call(java.lang.String):java.lang.String");
                    }
                });
                dynamicProperties.setDrmConfig(new DrmConfig("DM-Android", ""));
                dynamicProperties.setNetworkTask(new URLConnectionTask());
                Utils.setPlayerConfig(dynamicProperties);
                RemoteLogger.setRemoteAdapter(new RemoteLogger.IRemoteAdapter(this) { // from class: cn.damai.launcher.initialize.CommonBiz.17.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.media.arch.instruments.utils.RemoteLogger.IRemoteAdapter
                    public void log(String str2, String str3) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "248544194")) {
                            ipChange2.ipc$dispatch("248544194", new Object[]{this, str2, str3});
                        } else {
                            kk2.a().d(str2, str3);
                        }
                    }
                });
            }
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[ImgResQuality.values().length];
            c = iArr;
            try {
                iArr[ImgResQuality.Q90.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[ImgResQuality.Q75.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[ImgResQuality.Q60.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[ImgResQuality.Q50.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[ImgResQuality.Q30.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[TrackType.values().length];
            b = iArr2;
            try {
                iArr2[TrackType.page.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[TrackType.click.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                b[TrackType.expose.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                b[TrackType.custom.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                b[TrackType.custom_1999.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                b[TrackType.warning.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr3 = new int[AppConfig.EnvMode.values().length];
            a = iArr3;
            try {
                iArr3[AppConfig.EnvMode.test.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[AppConfig.EnvMode.prepare.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private CommonBiz() {
    }

    private void B(Context context) {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "-552498823")) {
            ipChange.ipc$dispatch("-552498823", new Object[]{this, context});
            return;
        }
        try {
            IUMIDComponent uMIDComp = SecurityGuardManager.getInstance(context).getUMIDComp();
            if (uMIDComp != null) {
                try {
                    if (AppConfig.g() != AppConfig.EnvMode.prepare) {
                        i = AppConfig.g() == AppConfig.EnvMode.test ? 2 : 0;
                    }
                    uMIDComp.initUMID(i, new IUMIDInitListenerEx(this) { // from class: cn.damai.launcher.initialize.CommonBiz.18
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.alibaba.wireless.security.open.umid.IUMIDInitListenerEx
                        public void onUMIDInitFinishedEx(String str, int i2) {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "1261993205")) {
                                ipChange2.ipc$dispatch("1261993205", new Object[]{this, str, Integer.valueOf(i2)});
                            } else if (i2 == 200) {
                                cb1.b(BizTime.SECURITY_GUARD_MANAGER, "token=" + str);
                            } else {
                                cb1.b(BizTime.SECURITY_GUARD_MANAGER, "initUMID error resultCode : " + i2);
                            }
                        }
                    });
                } catch (SecException e) {
                    cb1.c(BizTime.SECURITY_GUARD_MANAGER, "umidComponent.registerInitListener Error: " + e.getErrorCode());
                }
            }
        } catch (SecException e2) {
            cb1.c(BizTime.SECURITY_GUARD_MANAGER, "SecurityGuardManager.getInstance(context) Error: " + e2.getErrorCode());
        }
    }

    private void C() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1961926976")) {
            ipChange.ipc$dispatch("-1961926976", new Object[]{this});
        } else {
            AppConfig.v();
        }
    }

    private void D() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1319322424")) {
            ipChange.ipc$dispatch("1319322424", new Object[]{this});
        } else {
            WindvaneAgent.initWindVane(this.a);
        }
    }

    private void E(Context context) {
        EnvModeEnum envModeEnum;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-867881647")) {
            ipChange.ipc$dispatch("-867881647", new Object[]{this, context});
            return;
        }
        if (AppConfig.g() == AppConfig.EnvMode.test) {
            envModeEnum = EnvModeEnum.TEST;
        } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
            envModeEnum = EnvModeEnum.PREPARE;
        } else {
            envModeEnum = EnvModeEnum.ONLINE;
        }
        MtopSetting.setMtopDomain(NetConstants.YOUKU_MTOP_INSTANCE_ID, "acs.youku.com", "pre-acs.youku.com", "daily-acs.youku.com");
        Mtop.instance(NetConstants.YOUKU_MTOP_INSTANCE_ID, context, "", 0).switchEnvMode(envModeEnum);
    }

    private void F() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1268268663")) {
            ipChange.ipc$dispatch("1268268663", new Object[]{this});
            return;
        }
        EnvModeEnum envModeEnum = EnvModeEnum.ONLINE;
        if (AppConfig.g() == AppConfig.EnvMode.test) {
            envModeEnum = EnvModeEnum.TEST;
            cb1.b(TAG, "EnvModeEnum Init TEST ");
        } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
            envModeEnum = EnvModeEnum.PREPARE;
            cb1.b(TAG, "EnvModeEnum Init PREPARE ");
        } else {
            cb1.b(TAG, "EnvModeEnum Init ONLINE ");
        }
        TBSdkLog.setTLogEnabled(true);
        TBSdkLog.setPrintLog(false);
        TBSdkLog.setLogEnable(TBSdkLog.LogEnable.DebugEnable);
        Message message = new Message();
        message.obj = envModeEnum;
        this.b.sendMessage(message);
        E(this.a);
        if (ProcessUtils.b(this.a)) {
            r(this.a);
        }
    }

    private boolean G() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "810949005")) {
            return ((Boolean) ipChange.ipc$dispatch("810949005", new Object[]{this})).booleanValue();
        }
        try {
            Class.forName("cn.damai.appinfo.PopcornApplication");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void H(final Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1422737905")) {
            ipChange.ipc$dispatch("1422737905", new Object[]{this, context});
            return;
        }
        MtopSetting.setDeviceInfo(new IDeviceInfo(this) { // from class: cn.damai.launcher.initialize.CommonBiz.16
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getAndroidId() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-1455618709") ? (String) ipChange2.ipc$dispatch("-1455618709", new Object[]{this}) : DeviceInfoProviderProxy.getAndroidId();
            }

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getBssId() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-876140546") ? (String) ipChange2.ipc$dispatch("-876140546", new Object[]{this}) : WifiInfoUtil.a(context);
            }

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getDeviceId() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "1596534246") ? (String) ipChange2.ipc$dispatch("1596534246", new Object[]{this}) : DeviceInfoProviderProxy.getImei();
            }

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getImei() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-1951795171") ? (String) ipChange2.ipc$dispatch("-1951795171", new Object[]{this}) : DeviceInfoProviderProxy.getImei();
            }

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getMacAddress() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-1197834502") ? (String) ipChange2.ipc$dispatch("-1197834502", new Object[]{this}) : PhoneInfo.getLocalMacAddress(context);
            }

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getSerialNum() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "348574323") ? (String) ipChange2.ipc$dispatch("348574323", new Object[]{this}) : PhoneInfo.getSerialNum();
            }

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getSsId() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "726003568") ? (String) ipChange2.ipc$dispatch("726003568", new Object[]{this}) : WifiInfoUtil.b(context);
            }

            @Override // mtopsdk.mtop.intf.IDeviceInfo
            public String getSubscriberId() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "1639370104") ? (String) ipChange2.ipc$dispatch("1639370104", new Object[]{this}) : DeviceInfoProviderProxy.getImsi();
            }
        });
        MtopSetting.setAppKeyIndex(Mtop.Id.INNER, 0, 2);
        MtopSetting.setAppKeyIndex(Mtop.Id.OPEN, 0, 2);
        MtopSetting.setAppVersion(Mtop.Id.INNER, AppConfig.q());
        EnvModeEnum envModeEnum = EnvModeEnum.ONLINE;
        if (AppConfig.g() == AppConfig.EnvMode.test) {
            envModeEnum = EnvModeEnum.TEST;
            cb1.b(TAG, "EnvModeEnum Init TEST ");
        } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
            envModeEnum = EnvModeEnum.PREPARE;
            cb1.b(TAG, "EnvModeEnum Init PREPARE ");
        } else {
            cb1.b(TAG, "EnvModeEnum Init ONLINE ");
        }
        Mtop.instance(Mtop.Id.INNER, context, AppConfig.p()).switchEnvMode(envModeEnum);
        Mtop.instance(Mtop.Id.OPEN, context, AppConfig.p()).switchEnvMode(envModeEnum);
    }

    private void I() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1002411403")) {
            ipChange.ipc$dispatch("-1002411403", new Object[]{this});
        } else {
            hr1.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1130245948")) {
            ipChange.ipc$dispatch("-1130245948", new Object[]{this});
        } else if (UccJsBridge.getInstance() == null || ((UccService) AliMemberSDK.getService(UccService.class)) == null) {
        } else {
            UccJsBridge.getInstance().setUccDataProvider();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "297697669")) {
            ipChange.ipc$dispatch("297697669", new Object[]{this});
        } else if (ProcessUtils.b(this.a)) {
            C();
            o();
            v();
            B(this.a);
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1824532667")) {
            ipChange.ipc$dispatch("1824532667", new Object[]{this});
        } else if (ProcessUtils.b(this.a)) {
            D();
            cb1.b("delayInit", "delayInitfor3 initWindVane");
        }
    }

    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-597302444")) {
            ipChange.ipc$dispatch("-597302444", new Object[]{this});
        } else if (ProcessUtils.b(this.a)) {
            Environment environment = Environment.ONLINE;
            if (AppConfig.g() == AppConfig.EnvMode.test) {
                environment = Environment.TEST;
            } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
                environment = Environment.PRE;
            }
            AliMemberSDK.setEnvironment(environment);
            ConfigManager.setAppKeyIndex(0, 2);
            AliMemberSDK.init(this.a, "damai", new InitResultCallback() { // from class: cn.damai.launcher.initialize.CommonBiz.11
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.ali.user.open.core.callback.FailureCallback
                public void onFailure(int i, String str) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1115279410")) {
                        ipChange2.ipc$dispatch("1115279410", new Object[]{this, Integer.valueOf(i), str});
                    } else {
                        cb1.c(CommonBiz.TAG, "havana: AliMemberSDK init failed");
                    }
                }

                @Override // com.ali.user.open.core.callback.InitResultCallback
                public void onSuccess() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2107307234")) {
                        ipChange2.ipc$dispatch("2107307234", new Object[]{this});
                    } else {
                        CommonBiz.this.L();
                    }
                }
            });
            LoginManager.k().z(this.a);
            L();
        }
    }

    public static String getDamaiUserAgent() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1762509088")) {
            return (String) ipChange.ipc$dispatch("1762509088", new Object[0]);
        }
        return "Damai;" + AppConfig.q() + ";Android;" + e80.e() + ";" + e80.b();
    }

    public static CommonBiz getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "565408507")) {
            return (CommonBiz) ipChange.ipc$dispatch("565408507", new Object[0]);
        }
        if (c == null) {
            synchronized (CommonBiz.class) {
                if (c == null) {
                    c = new CommonBiz();
                }
            }
        }
        return c;
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "759699049")) {
            ipChange.ipc$dispatch("759699049", new Object[]{this});
        } else {
            AusConfigCenter.initUploader(this.a);
        }
    }

    private void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1868575346")) {
            ipChange.ipc$dispatch("-1868575346", new Object[]{this});
        } else if (ProcessUtils.b(this.a)) {
            cb1.b("GaiaXSDK", UCCore.LEGACY_EVENT_INIT);
            GaiaX.Companion companion = GaiaX.Companion;
            companion.init(this.a);
            IStable stable = companion.getInstance().stable();
            if (stable != null) {
                stable.launchDB();
                cb1.b("GaiaXSDK", "launchDB");
                String B = z20.B("gaiax_cache_app_version");
                String q = AppConfig.q();
                if (!q.equals(B)) {
                    stable.cleanRemoteTemplates();
                    z20.T("gaiax_cache_app_version", q);
                }
            }
            if (stable != null) {
                stable.launchRemote();
                cb1.b("GaiaXSDK", "launchRemote");
            }
            PictureGaiaXProviderProxy.Companion.initProxyImpl(new PictureGaiaxProviderImp());
        }
    }

    private void o() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1448469448")) {
            ipChange.ipc$dispatch("1448469448", new Object[]{this});
        } else {
            uh1.a();
        }
    }

    private void p() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-857862484")) {
            ipChange.ipc$dispatch("-857862484", new Object[]{this});
            return;
        }
        OneContext.setApplication(this.a);
        OneConfig.setTtid(AppConfig.p());
        OneConfig.setEnvType(AppConfig.g().ordinal());
        OneConfig.appkey = AppConfig.c();
        OneConfig.CHECK_UPDATE_BACKGROUND = false;
        OneConfig.CHECK_UPDATE_SYNC = true;
        Repository.Companion.setRemoteDataLoader(new RemoteDataLoader());
        ComponentTypeMapper.INSTANCE.register(new hm());
        StateViewManager.Companion.getInstance().register(new hg2());
        ComponentConfigManager.Companion.getInstance().setUniversallyComponentConfigPath("android.resource://bricks/raw/universally_component_config");
        DMTokenManager.Companion.a().b(this.a);
    }

    private void q() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "515284884")) {
            ipChange.ipc$dispatch("515284884", new Object[]{this});
        } else if (ProcessUtils.b(this.a) || ProcessUtils.a(this.a)) {
            OrangeConfigCenter.c();
            OrangeConfigCenter.d(this.a);
            on1.c();
            if (ProcessUtils.b(this.a)) {
                OrangeConfigCenter.c().f(DamaiConstants.BLACK_WHITE_VIEW_CONFIG, new OrangeConfigCenter.DMOrangeConfigListener(this) { // from class: cn.damai.launcher.initialize.CommonBiz.8
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.common.OrangeConfigCenter.DMOrangeConfigListener
                    public void onConfigUpdate(String str, boolean z) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "691548590")) {
                            ipChange2.ipc$dispatch("691548590", new Object[]{this, str, Boolean.valueOf(z)});
                            return;
                        }
                        String str2 = CommonBiz.TAG;
                        cb1.c(str2, "orange: 开始初始化");
                        wu0.b();
                        cb1.c(str2, "orange: grayViewOrangeConfig完成");
                    }
                });
                OrangeConfigCenter.c().f("app_startup_config", new OrangeConfigCenter.DMOrangeConfigListener(this) { // from class: cn.damai.launcher.initialize.CommonBiz.9
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.common.OrangeConfigCenter.DMOrangeConfigListener
                    public void onConfigUpdate(String str, boolean z) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-2141838707")) {
                            ipChange2.ipc$dispatch("-2141838707", new Object[]{this, str, Boolean.valueOf(z)});
                            return;
                        }
                        String customConfig = ko.d().getCustomConfig(r2, "");
                        if (TextUtils.isEmpty(customConfig)) {
                            return;
                        }
                        z20.M(customConfig);
                        String str2 = CommonBiz.TAG;
                        cb1.c(str2, "app_startup_config: config= " + customConfig);
                    }
                });
                OrangeConfigCenter.c().f("request_cdn_config", new OrangeConfigCenter.DMOrangeConfigListener(this) { // from class: cn.damai.launcher.initialize.CommonBiz.10
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.common.OrangeConfigCenter.DMOrangeConfigListener
                    public void onConfigUpdate(String str, boolean z) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1029953391")) {
                            ipChange2.ipc$dispatch("-1029953391", new Object[]{this, str, Boolean.valueOf(z)});
                            return;
                        }
                        String str2 = CommonBiz.TAG;
                        cb1.c(str2, "orange: 开始初始化");
                        Map<String, String> allConfig = ko.d().getAllConfig("request_cdn_config");
                        if (allConfig != null) {
                            z20.O(allConfig.get("homepage_request_cdn"));
                            z20.Q(allConfig.get("newhomepage_request_cdn"));
                            z20.N(allConfig.get("drama_channel_request_cdn"));
                            z20.U(allConfig.get("tablive_request_cdn"));
                            z20.P(allConfig.get(ShareperfenceConstants.NEW_CHANNEL_PAGE_CDN_REQUEST));
                        } else {
                            z20.O("0");
                            z20.Q("0");
                            z20.N("0");
                            z20.U("0");
                            z20.P("0");
                        }
                        cb1.c(str2, "orange: grayViewOrangeConfig完成");
                    }
                });
                UniH5ContainerSwitcher.getInstance().registerOrangeConfig();
            }
        }
    }

    private void r(Context context) {
        Domain domain;
        EnvModeEnum envModeEnum;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "115058920")) {
            ipChange.ipc$dispatch("115058920", new Object[]{this, context});
            return;
        }
        if (AppConfig.g() == AppConfig.EnvMode.test) {
            domain = Domain.DOMAIN_TEST;
            envModeEnum = EnvModeEnum.TEST;
        } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
            domain = Domain.DOMAIN_PRE;
            envModeEnum = EnvModeEnum.PREPARE;
        } else {
            domain = Domain.DOMAIN_ONLINE;
            envModeEnum = EnvModeEnum.ONLINE;
        }
        Mtop instance = Mtop.instance(NetConstants.YOUKU_MTOP_INSTANCE_ID, context, "", 0);
        instance.switchEnvMode(envModeEnum);
        RemoteLogin.setLoginImpl(instance, new LoginImpl(context));
        PassportManager.getInstance().init(new PassportConfig.Builder(context).setProductLineInfo(AppConfig.l(), AppConfig.m()).setUseMtop(true).setSessionMtop(instance).setDomain(domain).setRefreshTokenListener(new IRefreshTokenListener(this) { // from class: cn.damai.launcher.initialize.CommonBiz.12
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.usercenter.passport.listener.IRefreshTokenListener
            public void onTokenRefreshed(String str) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-711841137")) {
                    ipChange2.ipc$dispatch("-711841137", new Object[]{this, str});
                }
            }
        }).build());
    }

    private void s() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "160095198")) {
            ipChange.ipc$dispatch("160095198", new Object[]{this});
        } else {
            OrangeConfigCenter.c().f("damai_image_android_phenix", new OrangeConfigCenter.DMOrangeConfigListener(this) { // from class: cn.damai.launcher.initialize.CommonBiz.15
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.OrangeConfigCenter.DMOrangeConfigListener
                public void onConfigUpdate(String str, boolean z) {
                    IpChange ipChange2 = $ipChange;
                    final boolean z2 = true;
                    if (AndroidInstantRuntime.support(ipChange2, "1982979308")) {
                        ipChange2.ipc$dispatch("1982979308", new Object[]{this, str, Boolean.valueOf(z)});
                        return;
                    }
                    z2 = (Pexode.a(com.taobao.pexode.mimetype.a.WEBP) && Pexode.a(com.taobao.pexode.mimetype.a.WEBP_A)) ? false : false;
                    n11.e(mu0.a(), new IImageStrategySupport(this) { // from class: cn.damai.launcher.initialize.CommonBiz.15.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // com.taobao.tao.image.IImageStrategySupport
                        public String getConfigString(String str2, String str3, String str4) {
                            IpChange ipChange3 = $ipChange;
                            return AndroidInstantRuntime.support(ipChange3, "-2087678346") ? (String) ipChange3.ipc$dispatch("-2087678346", new Object[]{this, str2, str3, str4}) : ko.d().getString("damai_image_android_phenix", str3, str4);
                        }

                        @Override // com.taobao.tao.image.IImageStrategySupport
                        public boolean isNetworkSlow() {
                            IpChange ipChange3 = $ipChange;
                            return AndroidInstantRuntime.support(ipChange3, "-1535304780") ? ((Boolean) ipChange3.ipc$dispatch("-1535304780", new Object[]{this})).booleanValue() : Monitor.getNetworkSpeed() == NetworkSpeed.Slow;
                        }

                        @Override // com.taobao.tao.image.IImageStrategySupport
                        public boolean isSupportWebP() {
                            IpChange ipChange3 = $ipChange;
                            return AndroidInstantRuntime.support(ipChange3, "851682200") ? ((Boolean) ipChange3.ipc$dispatch("851682200", new Object[]{this})).booleanValue() : z2;
                        }
                    });
                    n11.c().f();
                }
            });
        }
    }

    private void t() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-806903870")) {
            ipChange.ipc$dispatch("-806903870", new Object[]{this});
        } else if (ProcessUtils.b(this.a)) {
            try {
                new DMPopLayer().setup(this.a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void u() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1472975978")) {
            ipChange.ipc$dispatch("-1472975978", new Object[]{this});
            return;
        }
        String n = AppConfig.n(this.a);
        if (ProcessUtils.b(this.a) || ProcessUtils.a(this.a)) {
            try {
                DaMaiPushAgent.h(this.a);
                h();
                Application application = this.a;
                z(application, application, n);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void v() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122148364")) {
            ipChange.ipc$dispatch("122148364", new Object[]{this});
        } else {
            my1.a(this.a);
        }
    }

    private void x() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2011116030")) {
            ipChange.ipc$dispatch("-2011116030", new Object[]{this});
        } else if (ProcessUtils.b(this.a) || ProcessUtils.a(this.a)) {
            AliSecurityHelper.a();
        }
    }

    private void y() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "63445565")) {
            ipChange.ipc$dispatch("63445565", new Object[]{this});
        } else if (ProcessUtils.b(mu0.a())) {
            cn.damai.solid.a.d().g(mu0.a(), LauncherApplication.sAppCreateTimeMillis);
        }
    }

    private void z(Context context, Application application, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "732384435")) {
            ipChange.ipc$dispatch("732384435", new Object[]{this, context, application, str});
        } else {
            ik2.a(context, application, str);
        }
    }

    public void A() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1422635373")) {
            ipChange.ipc$dispatch("-1422635373", new Object[]{this});
        } else {
            yl2.b(new IImageLoader(this) { // from class: cn.damai.launcher.initialize.CommonBiz.6
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.uikit.image.IImageLoader
                public void load(String str, int i, int i2, int i3, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "886430823")) {
                        ipChange2.ipc$dispatch("886430823", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), iImageSuccListener, iImageFailListener});
                    } else {
                        cn.damai.common.image.a.b().load(str, i, i2, i3, iImageSuccListener, iImageFailListener);
                    }
                }

                @Override // cn.damai.uikit.image.IImageLoader
                public IImageLoader.ImageTicket loadinto(String str, ImageView imageView) {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "-1064802065") ? (IImageLoader.ImageTicket) ipChange2.ipc$dispatch("-1064802065", new Object[]{this, str, imageView}) : cn.damai.common.image.a.b().loadinto(str, imageView);
                }

                @Override // cn.damai.uikit.image.IImageLoader
                public void load(String str, int i, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1113573063")) {
                        ipChange2.ipc$dispatch("1113573063", new Object[]{this, str, Integer.valueOf(i), iImageSuccListener, iImageFailListener});
                    } else {
                        cn.damai.common.image.a.b().load(str, i, iImageSuccListener, iImageFailListener);
                    }
                }

                @Override // cn.damai.uikit.image.IImageLoader
                public IImageLoader.ImageTicket loadinto(String str, ImageView imageView, int i, int i2) {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "-1391060785") ? (IImageLoader.ImageTicket) ipChange2.ipc$dispatch("-1391060785", new Object[]{this, str, imageView, Integer.valueOf(i), Integer.valueOf(i2)}) : cn.damai.common.image.a.b().loadinto(str, imageView, i, i2);
                }

                @Override // cn.damai.uikit.image.IImageLoader
                public IImageLoader.ImageTicket load(String str, int i, int i2, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "-875145951") ? (IImageLoader.ImageTicket) ipChange2.ipc$dispatch("-875145951", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), iImageSuccListener, iImageFailListener}) : cn.damai.common.image.a.b().load(str, i, i2, iImageSuccListener, iImageFailListener);
                }

                @Override // cn.damai.uikit.image.IImageLoader
                public IImageLoader.ImageTicket load(String str, int i, int i2, int i3, int i4, IImageLoader.IImageSuccListener iImageSuccListener, IImageLoader.IImageFailListener iImageFailListener) {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "-192099455") ? (IImageLoader.ImageTicket) ipChange2.ipc$dispatch("-192099455", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), iImageSuccListener, iImageFailListener}) : cn.damai.common.image.a.b().load(str, i, i2, i3, i4, iImageSuccListener, iImageFailListener);
                }
            }, new TrackProxy.ITrack() { // from class: cn.damai.launcher.initialize.CommonBiz.7
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.tetris.core.ut.TrackProxy.ITrack
                public void userTrack(TrackType trackType, View view, String str, String str2, String str3, Map<String, String> map, boolean z) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-2083521267")) {
                        ipChange2.ipc$dispatch("-2083521267", new Object[]{this, trackType, view, str, str2, str3, map, Boolean.valueOf(z)});
                        return;
                    }
                    switch (a.b[trackType.ordinal()]) {
                        case 1:
                            c.e().x(CommonBiz.this.f(str, str2, str3, map, Boolean.valueOf(z)));
                            return;
                        case 2:
                            c.e().x(CommonBiz.this.f(str, str2, str3, map, Boolean.valueOf(z)));
                            return;
                        case 3:
                            c.e().G(view, str3, str2, str, map);
                            return;
                        case 4:
                            c.e().D(str, str2, map.get("arg1"), map.get("arg2"), map, map.get("eventId") != null ? Integer.parseInt(map.get("eventId")) : 0);
                            return;
                        case 5:
                            c.e().A(map, str2, str);
                            return;
                        case 6:
                            try {
                                t03.c(str2, str3, str2, str3, m61.e(map));
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        default:
                            return;
                    }
                }
            });
        }
    }

    public void J() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1674124839")) {
            ipChange.ipc$dispatch("-1674124839", new Object[]{this});
        } else if (AppConfig.v() || G()) {
            Intent intent = new Intent();
            intent.setPackage("cn.damai");
            intent.setAction("popcorn_monitor_app_start");
            this.a.sendBroadcast(intent);
        }
    }

    public void K() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1595512693")) {
            ipChange.ipc$dispatch("1595512693", new Object[]{this});
        } else if (AppConfig.v()) {
            boolean u = z20.u();
            rj1.l0(!u);
            rj1.k0(!u);
        }
    }

    public a.b f(String str, String str2, String str3, Map<String, String> map, Boolean bool) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-345139164") ? (a.b) ipChange.ipc$dispatch("-345139164", new Object[]{this, str, str2, str3, map, bool}) : new a.b().i(str).f(str2).l(str3).g(bool.booleanValue()).j(map);
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-784893608")) {
            ipChange.ipc$dispatch("-784893608", new Object[]{this});
            return;
        }
        ko koVar = ko.INSTANCE;
        koVar.g(this.a, APPClient.DM.getClientName());
        ko.d().h("android_dm_config");
        ko.f().h("dm_local_kv_data");
        koVar.h(new IAppBaseInfoProvider(this) { // from class: cn.damai.launcher.initialize.CommonBiz.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.alibaba.pictures.cornerstone.IAppBaseInfoProvider
            @Nullable
            public String getAppKey() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "153654217") ? (String) ipChange2.ipc$dispatch("153654217", new Object[]{this}) : AppConfig.c();
            }

            @Override // com.alibaba.pictures.cornerstone.IAppBaseInfoProvider
            @Nullable
            public String getChannelId() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-1436702775") ? (String) ipChange2.ipc$dispatch("-1436702775", new Object[]{this}) : "";
            }

            @Override // com.alibaba.pictures.cornerstone.IAppBaseInfoProvider
            @Nullable
            public EnvMode getEnv() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1741980379")) {
                    return (EnvMode) ipChange2.ipc$dispatch("-1741980379", new Object[]{this});
                }
                EnvMode envMode = EnvMode.ONLINE;
                int i = a.a[AppConfig.g().ordinal()];
                if (i != 1) {
                    return i != 2 ? envMode : EnvMode.PREPARE;
                }
                return EnvMode.TEST;
            }

            @Override // com.alibaba.pictures.cornerstone.IAppBaseInfoProvider
            @Nullable
            public String getExtraInfo(@Nullable String str) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1103560287")) {
                    return (String) ipChange2.ipc$dispatch("1103560287", new Object[]{this, str});
                }
                return null;
            }

            @Override // com.alibaba.pictures.cornerstone.IAppBaseInfoProvider
            @Nullable
            public String getTTID() {
                IpChange ipChange2 = $ipChange;
                return AndroidInstantRuntime.support(ipChange2, "-994187706") ? (String) ipChange2.ipc$dispatch("-994187706", new Object[]{this}) : AppConfig.p();
            }
        });
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2137681539")) {
            ipChange.ipc$dispatch("2137681539", new Object[]{this});
        } else if (ProcessUtils.b(this.a)) {
            cn.damai.common.image.a.b().h(this.a);
            mg1 mg1Var = mg1.INSTANCE;
            mg1Var.k(ko.d().isExpected(DamaiConstants.CONFIG_KEY_MOIMAGE_XCDN_SWITCH, "on", false));
            mg1Var.j(ko.d().isExpected(DamaiConstants.CONFIG_KEY_MOIMAGE_DOMAIN_CONVERGE_SWITCH, "on", true));
            mg1Var.h(this.a, new IMoImageConfig(this) { // from class: cn.damai.launcher.initialize.CommonBiz.13
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.alibaba.pictures.moimage.IMoImageConfig
                @Nullable
                public Boolean debugAble() {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "685301908") ? (Boolean) ipChange2.ipc$dispatch("685301908", new Object[]{this}) : Boolean.valueOf(AppConfig.v());
                }

                @Override // com.alibaba.pictures.moimage.IMoImageConfig
                @Nullable
                public Integer defaultDrawable() {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "-1141989748") ? (Integer) ipChange2.ipc$dispatch("-1141989748", new Object[]{this}) : Integer.valueOf(R$drawable.uikit_default_image_bg_gradient);
                }

                @Override // com.alibaba.pictures.moimage.IMoImageConfig
                @Nullable
                public Integer defaultErrorDrawable() {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "452050952") ? (Integer) ipChange2.ipc$dispatch("452050952", new Object[]{this}) : Integer.valueOf(R$drawable.uikit_default_image_bg_gradient);
                }

                @Override // com.alibaba.pictures.moimage.IMoImageConfig
                @Nullable
                public Boolean disableFadeIn() {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "717345560") ? (Boolean) ipChange2.ipc$dispatch("717345560", new Object[]{this}) : Boolean.FALSE;
                }

                @Override // com.alibaba.pictures.moimage.IMoImageConfig
                @Nullable
                public Boolean showImageOff() {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "-470358862") ? (Boolean) ipChange2.ipc$dispatch("-470358862", new Object[]{this}) : Boolean.FALSE;
                }
            });
            mg1Var.i(new IImageUrlFixer(this) { // from class: cn.damai.launcher.initialize.CommonBiz.14
                private static transient /* synthetic */ IpChange $ipChange;

                private String a() {
                    IpChange ipChange2 = $ipChange;
                    return AndroidInstantRuntime.support(ipChange2, "458860122") ? (String) ipChange2.ipc$dispatch("458860122", new Object[]{this}) : "http://gw.alicdn.com/tfscom/";
                }

                @Override // com.alibaba.pictures.moimage.IImageUrlFixer
                @Nullable
                public String addPrefixIfNeeded(@Nullable String str) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2115102776")) {
                        return (String) ipChange2.ipc$dispatch("2115102776", new Object[]{this, str});
                    }
                    if (str == null || str.startsWith("http")) {
                        return str;
                    }
                    return a() + str;
                }

                @Override // com.alibaba.pictures.moimage.IImageUrlFixer
                @Nullable
                public String autoFix(@Nullable String str, int i, int i2, @Nullable ImgResQuality imgResQuality, @Nullable ImgResExtraInfo imgResExtraInfo) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "235328256")) {
                        return (String) ipChange2.ipc$dispatch("235328256", new Object[]{this, str, Integer.valueOf(i), Integer.valueOf(i2), imgResQuality, imgResExtraInfo});
                    }
                    try {
                        String addPrefixIfNeeded = addPrefixIfNeeded(str);
                        DMImageStrategyConfig b = b.b(str, i, i2);
                        if (addPrefixIfNeeded == null || b == null) {
                            return addPrefixIfNeeded;
                        }
                        if (imgResQuality != null) {
                            int i3 = a.c[imgResQuality.ordinal()];
                            if (i3 == 1) {
                                b.j = DMImageStrategyConfig.DMImageQuality.q90;
                            } else if (i3 == 2) {
                                b.j = DMImageStrategyConfig.DMImageQuality.q75;
                            } else if (i3 == 3) {
                                b.j = DMImageStrategyConfig.DMImageQuality.q60;
                            } else if (i3 == 4) {
                                b.j = DMImageStrategyConfig.DMImageQuality.q50;
                            } else if (i3 != 5) {
                                b.j = DMImageStrategyConfig.DMImageQuality.non;
                            } else {
                                b.j = DMImageStrategyConfig.DMImageQuality.q30;
                            }
                        }
                        return b.c(str, b);
                    } catch (Exception unused) {
                        return str;
                    }
                }
            });
            s();
        }
    }

    public void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-908718045")) {
            ipChange.ipc$dispatch("-908718045", new Object[]{this});
            return;
        }
        try {
            ia1 ia1Var = ia1.INSTANCE;
            ia1Var.d(mu0.a(), new LocationRequestDelegate(this) { // from class: cn.damai.launcher.initialize.CommonBiz.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.alibaba.pictures.piclocation.mtop.LocationRequestDelegate
                public void requestRegionData(@NonNull ga1 ga1Var, @NonNull RegionRequestHandler regionRequestHandler) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1641620912")) {
                        ipChange2.ipc$dispatch("-1641620912", new Object[]{this, ga1Var, regionRequestHandler});
                    }
                }
            }, new LocationErrorReporter(this) { // from class: cn.damai.launcher.initialize.CommonBiz.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.alibaba.pictures.piclocation.LocationErrorReporter
                public void reportGpsLocateFailed(int i) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1514525279")) {
                        ipChange2.ipc$dispatch("1514525279", new Object[]{this, Integer.valueOf(i)});
                    } else {
                        SplashXFlushHelper.c(i);
                    }
                }
            });
            ia1Var.h(new GetBlackListInterface(this) { // from class: cn.damai.launcher.initialize.CommonBiz.4
                private static transient /* synthetic */ IpChange $ipChange;

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.alibaba.pictures.piclocation.listener.GetBlackListInterface
                @NonNull
                public List<String> getBlackList() {
                    GeoDeBackList geoDeBackList;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "189071884")) {
                        return (List) ipChange2.ipc$dispatch("189071884", new Object[]{this});
                    }
                    List list = null;
                    try {
                        StartConfig configFromSp = StartConfig.getConfigFromSp();
                        if (configFromSp != null && (geoDeBackList = configFromSp.geoBackList) != null) {
                            List list2 = geoDeBackList.backList;
                            if (list2 != null) {
                                list = list2;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (list == null) {
                        list = new ArrayList();
                    }
                    if (AppConfig.v()) {
                        cb1.c("GeoBackList", "current device model:" + Build.getMODEL());
                        cb1.c("GeoBackList", "orange backList:" + m61.e(list));
                    }
                    return list;
                }
            });
            ia1Var.i(new GetLocationInfoInterface(this) { // from class: cn.damai.launcher.initialize.CommonBiz.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.alibaba.pictures.piclocation.listener.GetLocationInfoInterface
                public void getLocationInfoSuccess(AMapLocation aMapLocation, long j) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-51181877")) {
                        ipChange2.ipc$dispatch("-51181877", new Object[]{this, aMapLocation, Long.valueOf(j)});
                    } else if (aMapLocation == null) {
                    } else {
                        CompliantUtUtils.b(String.valueOf(aMapLocation.getLatitude()), String.valueOf(aMapLocation.getLongitude()));
                    }
                }
            });
            ia1Var.g(300000L);
        } catch (Exception e) {
            cb1.c(TAG, "LocationSDK init failed");
            e.printStackTrace();
        }
    }

    public void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2003114897")) {
            ipChange.ipc$dispatch("2003114897", new Object[]{this});
        } else if (ProcessUtils.b(this.a)) {
            dw0 dw0Var = new dw0();
            LoginEnvType loginEnvType = LoginEnvType.ONLINE;
            if (AppConfig.g() == AppConfig.EnvMode.test) {
                loginEnvType = LoginEnvType.DEV;
            } else if (AppConfig.g() == AppConfig.EnvMode.prepare) {
                loginEnvType = LoginEnvType.PRE;
            }
            String p = AppConfig.p();
            Login.init(this.a, p, "damai_android_" + AppConfig.q(), loginEnvType, dw0Var);
        }
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189204230")) {
            ipChange.ipc$dispatch("-189204230", new Object[]{this});
        } else {
            H(this.a);
        }
    }

    public void w() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1228579598")) {
            ipChange.ipc$dispatch("1228579598", new Object[]{this});
            return;
        }
        Application a2 = mu0.a();
        this.a = a2;
        if (ProcessUtils.b(a2) || ProcessUtils.a(this.a)) {
            F();
            K();
        }
        u();
        q();
        t();
        x();
        k3.b();
        g();
        p();
        k();
        y();
        ShareInit.INSTANCE.b(mu0.a());
        cn.damai.im.a.a();
        PrivacyDoubleListDelegate.INSTANCE.a(this.a);
        this.b.sendEmptyMessageDelayed(1, 2000L);
        this.b.sendEmptyMessageDelayed(2, 3000L);
        this.b.sendEmptyMessageDelayed(3, 0L);
    }
}
