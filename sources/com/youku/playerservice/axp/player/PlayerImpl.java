package com.youku.playerservice.axp.player;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.ali.user.mobile.login.model.LoginConstant;
import com.alimm.xadsdk.base.model.AdInfo;
import com.alimm.xadsdk.base.model.BidInfo;
import com.taobao.weex.common.Constants;
import com.youku.a.C7792a;
import com.youku.alixplayer.AlixPlayerHolderUnbindListener;
import com.youku.alixplayer.AndroidXPlayer;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.IMediaSource;
import com.youku.alixplayer.OnAdEventListener;
import com.youku.alixplayer.OnCurrentPositionChangeListener;
import com.youku.alixplayer.OnInfoListener;
import com.youku.alixplayer.OnLocalConfigCenterListener;
import com.youku.alixplayer.OnSeekCompleteListener;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.OnVideoSizeChangedListener;
import com.youku.alixplayer.Reporter;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.middleware.DefaultRenderMiddleware;
import com.youku.alixplayer.middleware.IRenderMiddleware;
import com.youku.alixplayer.model.Period;
import com.youku.alixplayer.model.Source;
import com.youku.alixplayer.util.NativeMap;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;
import com.youku.live.dago.widgetlib.wedome.adapter.animation.YKLAnimationViewAdapter;
import com.youku.media.arch.instruments.utils.RemoteLogger;
import com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol;
import com.youku.playerservice.axp.axpinterface.InternalPlayerEventListener;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.axpinterface.PlayerAction;
import com.youku.playerservice.axp.cache.CacheManager;
import com.youku.playerservice.axp.cellular.CellularPlayUtils;
import com.youku.playerservice.axp.drm.ProvisionAuthenticator;
import com.youku.playerservice.axp.item.BitStream;
import com.youku.playerservice.axp.item.PlayItem;
import com.youku.playerservice.axp.item.Quality;
import com.youku.playerservice.axp.item.SliceItem;
import com.youku.playerservice.axp.item.VodItem;
import com.youku.playerservice.axp.mediasource.AxpMediaSource;
import com.youku.playerservice.axp.mediasource.BaseMediaSource;
import com.youku.playerservice.axp.mediasource.LiveMediaSource;
import com.youku.playerservice.axp.mediasource.SystemUrlMediaSource;
import com.youku.playerservice.axp.mediasource.UpsMediaSource;
import com.youku.playerservice.axp.mediasource.UrlMediaSource;
import com.youku.playerservice.axp.modules.ModuleManager;
import com.youku.playerservice.axp.modules.postprocessing.FrameProcessingModule;
import com.youku.playerservice.axp.playinfo.PlayInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.vpm.Callable;
import com.youku.vpm.IPlayer;
import com.youku.vpm.PlayerTrack;
import com.youku.vpm.framework.TableId;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PlayerImpl implements AlixPlayerHolderUnbindListener, IPlayerImplProtocol, Callable, IPlayer {
    public static final int KEY_PARAMETER_SET_REAL_DRMKEY = 551;
    public static final int KEY_PARAMETER_SET_REAL_STARTTIME = 552;
    public static final int KEY_PARAMETER_SET_REAL_URL = 510;
    private static final String TAG = "PlayerImpl";
    private int abrCode;
    private IAlixPlayer mAlixPlayer;
    private Context mContext;
    private FrameProcessingModule mFrameProcessingModule;
    private Handler mHandler;
    private InternalPlayerEventListener mInternalPlayerEventListener;
    private volatile boolean mIsAutoPlay;
    private volatile boolean mIsLoopPlay;
    private volatile boolean mIsMuted;
    private volatile boolean mIsPreload;
    private Map<String, String> mLocalConfigCenter;
    private BaseMediaSource mMediaSource;
    private ModuleManager mModuleManager;
    private boolean mNotStopFlag;
    private OnAdEventListener mOnAdEventListener;
    private OnCurrentPositionChangeListener mOnCurrentPositionChangeListener;
    private OnInfoListener mOnInfoListener;
    private final OnLocalConfigCenterListener mOnLocalConfigCenterListener;
    private BaseMediaSource.OnMediaSourceListener mOnMediaSourceListener;
    private OnSeekCompleteListener mOnSeekCompleteListener;
    private OnStateChangeListener mOnStateChangeListener;
    private OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private OtherFunc mOtherFunc;
    private PlayInfo mPlayInfo;
    private volatile double mPlaySpeed;
    private PlayerTrack mPlayerTrack;
    private IRenderMiddleware mRenderMiddleware;
    private volatile Surface mSurface;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.playerservice.axp.player.PlayerImpl$10  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$vpm$framework$TableId;

        static {
            int[] iArr = new int[TableId.values().length];
            $SwitchMap$com$youku$vpm$framework$TableId = iArr;
            try {
                iArr[TableId.ONEPLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$vpm$framework$TableId[TableId.IMPAIRMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$vpm$framework$TableId[TableId.BEFORE_PLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$vpm$framework$TableId[TableId.PLAYING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$youku$vpm$framework$TableId[TableId.ONECHANGE_SEEK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$youku$vpm$framework$TableId[TableId.ONECHANGE_QUALITY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$youku$vpm$framework$TableId[TableId.PLAYHEARTBEAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$youku$vpm$framework$TableId[TableId.ONEEVENT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$youku$vpm$framework$TableId[TableId.AD_PLAY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$youku$vpm$framework$TableId[TableId.AD_ERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$youku$vpm$framework$TableId[TableId.AD_IMPAIRMENT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$youku$vpm$framework$TableId[TableId.START_LOADING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$youku$vpm$framework$TableId[TableId.PLAY_ABNORMAL_DETAIL.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$youku$vpm$framework$TableId[TableId.PLAY_ABNORMAL_SUMMARY.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class YKRenderMiddleware extends DefaultRenderMiddleware {
        private YKRenderMiddleware() {
        }

        @Override // com.youku.alixplayer.middleware.DefaultRenderMiddleware
        public boolean processData(byte[] bArr, Map<Integer, String> map, long j, long j2, long j3, long j4, long j5) {
            if (PlayerImpl.this.mFrameProcessingModule != null) {
                PlayerImpl.this.mFrameProcessingModule.processData(bArr, map, j, j2, j3, j4, j5);
                return false;
            }
            return false;
        }
    }

    private PlayerImpl(Context context) {
        this(context, null, false);
    }

    private PlayerImpl(Context context, Handler handler) {
        this(context, handler, false);
    }

    private PlayerImpl(Context context, Handler handler, boolean z) {
        this.mPlaySpeed = 1.0d;
        this.mNotStopFlag = false;
        this.mIsAutoPlay = true;
        this.mLocalConfigCenter = new HashMap();
        this.mOtherFunc = new OtherFunc();
        this.mOnLocalConfigCenterListener = new OnLocalConfigCenterListener() { // from class: com.youku.playerservice.axp.player.PlayerImpl.2
            /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00d7  */
            @Override // com.youku.alixplayer.OnLocalConfigCenterListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.lang.String getLocalConfig(java.lang.String r6, java.lang.String r7, java.lang.String r8) {
                /*
                    Method dump skipped, instructions count: 736
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.player.PlayerImpl.AnonymousClass2.getLocalConfig(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
            }
        };
        this.mOnMediaSourceListener = new BaseMediaSource.OnMediaSourceListener() { // from class: com.youku.playerservice.axp.player.PlayerImpl.3
            @Override // com.youku.playerservice.axp.mediasource.BaseMediaSource.OnMediaSourceListener
            public void onPlaylistFailed(int i) {
                if (PlayerImpl.this.mPlayerTrack != null) {
                    PlayerImpl.this.mPlayerTrack.onError(0, i, null);
                }
                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                    PlayerImpl.this.mInternalPlayerEventListener.onError(i);
                }
            }
        };
        this.mOnStateChangeListener = new OnStateChangeListener() { // from class: com.youku.playerservice.axp.player.PlayerImpl.4
            @Override // com.youku.alixplayer.OnStateChangeListener
            public void onStateChange(IAlixPlayer.State state, IAlixPlayer.State state2) {
                if (!ApsUtil.handleStateChangedSyncEnable()) {
                    PlayerImpl.this.handleStateChanged(state, state2);
                    return;
                }
                synchronized (PlayerImpl.this) {
                    PlayerImpl.this.handleStateChanged(state, state2);
                }
            }
        };
        this.mOnVideoSizeChangedListener = new OnVideoSizeChangedListener() { // from class: com.youku.playerservice.axp.player.PlayerImpl.5
            @Override // com.youku.alixplayer.OnVideoSizeChangedListener
            public void onVideoSizeChange(int i, int i2) {
                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                    PlayerImpl.this.mInternalPlayerEventListener.onVideoSizeChanged(i, i2);
                }
            }
        };
        this.mOnAdEventListener = new OnAdEventListener() { // from class: com.youku.playerservice.axp.player.PlayerImpl.6
            @Override // com.youku.alixplayer.OnAdEventListener
            public void onAdCountDown(int i) {
                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                    PlayerImpl.this.mInternalPlayerEventListener.onAdCountDown(i);
                }
            }

            @Override // com.youku.alixplayer.OnAdEventListener
            public void onAdEnd(int i, int i2) {
                InternalPlayerEventListener internalPlayerEventListener;
                InternalPlayerEventListener.ADType aDType;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4 || PlayerImpl.this.mInternalPlayerEventListener == null) {
                                return;
                            }
                            internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                            aDType = InternalPlayerEventListener.ADType.POST_AD;
                        } else if (PlayerImpl.this.mInternalPlayerEventListener == null) {
                            return;
                        } else {
                            internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                            aDType = InternalPlayerEventListener.ADType.MID_AD;
                        }
                    } else if (PlayerImpl.this.mInternalPlayerEventListener == null) {
                        return;
                    } else {
                        internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                        aDType = InternalPlayerEventListener.ADType.PRE_VIPAD;
                    }
                } else if (PlayerImpl.this.mInternalPlayerEventListener == null) {
                    return;
                } else {
                    internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                    aDType = InternalPlayerEventListener.ADType.PRE_AD;
                }
                internalPlayerEventListener.onAdEnd(aDType, i);
            }

            @Override // com.youku.alixplayer.OnAdEventListener
            public void onAdStart(int i, int i2) {
                InternalPlayerEventListener internalPlayerEventListener;
                InternalPlayerEventListener.ADType aDType;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4 || PlayerImpl.this.mInternalPlayerEventListener == null) {
                                return;
                            }
                            internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                            aDType = InternalPlayerEventListener.ADType.POST_AD;
                        } else if (PlayerImpl.this.mInternalPlayerEventListener == null) {
                            return;
                        } else {
                            internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                            aDType = InternalPlayerEventListener.ADType.MID_AD;
                        }
                    } else if (PlayerImpl.this.mInternalPlayerEventListener == null) {
                        return;
                    } else {
                        internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                        aDType = InternalPlayerEventListener.ADType.PRE_VIPAD;
                    }
                } else if (PlayerImpl.this.mInternalPlayerEventListener == null) {
                    return;
                } else {
                    internalPlayerEventListener = PlayerImpl.this.mInternalPlayerEventListener;
                    aDType = InternalPlayerEventListener.ADType.PRE_AD;
                }
                internalPlayerEventListener.onAdStart(aDType, i);
            }
        };
        this.mOnCurrentPositionChangeListener = new OnCurrentPositionChangeListener() { // from class: com.youku.playerservice.axp.player.PlayerImpl.7
            @Override // com.youku.alixplayer.OnCurrentPositionChangeListener
            public void onCurrentPostionChange(int i) {
                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                    PlayerImpl.this.mInternalPlayerEventListener.onPositionChange(i);
                }
            }
        };
        this.mOnSeekCompleteListener = new OnSeekCompleteListener() { // from class: com.youku.playerservice.axp.player.PlayerImpl.8
            @Override // com.youku.alixplayer.OnSeekCompleteListener
            public void onSeekComplete() {
                if (PlayerImpl.this.mInternalPlayerEventListener != null) {
                    PlayerImpl.this.mInternalPlayerEventListener.onSeekFinish(true, new HashMap());
                }
            }
        };
        this.mOnInfoListener = new OnInfoListener() { // from class: com.youku.playerservice.axp.player.PlayerImpl.9
            /* JADX WARN: Code restructure failed: missing block: B:116:0x0296, code lost:
                if (r5.this$0.mInternalPlayerEventListener == null) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:81:0x017c, code lost:
                if (r5.this$0.mInternalPlayerEventListener != null) goto L90;
             */
            @Override // com.youku.alixplayer.OnInfoListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onInfo(int r6, int r7, int r8, java.lang.Object r9) {
                /*
                    Method dump skipped, instructions count: 754
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.player.PlayerImpl.AnonymousClass9.onInfo(int, int, int, java.lang.Object):void");
            }
        };
        ProvisionAuthenticator.checkProvision();
        this.mContext = context;
        this.mIsPreload = z;
        if (!this.mIsPreload) {
            this.mPlayerTrack = new PlayerTrack(context, this);
            this.mModuleManager = new ModuleManager(context, this, handler);
            if (ModuleManager.enable("frame_processing", "0")) {
                FrameProcessingModule frameProcessingModule = new FrameProcessingModule(context, this);
                this.mFrameProcessingModule = frameProcessingModule;
                this.mModuleManager.add(frameProcessingModule);
            }
        }
        this.mHandler = handler;
        if (RemoteLogger.getRemoteAdaptor() == null) {
            RemoteLogger.setRemoteAdapter(RemoteAdapter.getInstance());
        }
    }

    private PlayerImpl(Context context, boolean z) {
        this(context, null, z);
    }

    private void continuePlayRealVideo(VodItem vodItem, SliceItem sliceItem) {
        BitStream bitStream = vodItem.getBitStream();
        String m3u8Url = bitStream.getM3u8Url();
        if (TextUtils.isEmpty(m3u8Url)) {
            InternalPlayerEventListener internalPlayerEventListener = this.mInternalPlayerEventListener;
            if (internalPlayerEventListener != null) {
                internalPlayerEventListener.onError(28001);
                return;
            }
            return;
        }
        long tsDurSeconds = (((int) sliceItem.getTsDurSeconds()) * 1000) + sliceItem.getStartPos();
        String drmKey = bitStream.getDrmKey();
        if (TextUtils.isEmpty(drmKey)) {
            drmKey = "";
        }
        logWithSessionId((((("正片续播： startTime=" + tsDurSeconds) + " streamType=" + bitStream.getStreamType()) + " duration=" + sliceItem.getTotalDuration()) + " drmKey=" + drmKey) + " url=\n" + m3u8Url);
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack != null) {
            playerTrack.putTimestamp("realVideoResultTs", System.currentTimeMillis());
        }
        this.mAlixPlayer.setPlaybackParam(552, tsDurSeconds + "");
        this.mAlixPlayer.setPlaybackParam(551, drmKey);
        this.mAlixPlayer.setPlaybackParam(510, m3u8Url);
    }

    public static IPlayerImplProtocol createPlayer(Context context) {
        return new PlayerImpl(context);
    }

    public static IPlayerImplProtocol createPlayer(Context context, Handler handler) {
        return new PlayerImpl(context, handler);
    }

    public static IPlayerImplProtocol createPlayer(Context context, boolean z) {
        return new PlayerImpl(context, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b5 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getDomain(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "get host for single slice called with:"
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "PlayerImpl"
            com.youku.playerservice.axp.utils.Logger.d(r1, r0)
            java.util.Map r5 = r3.parse(r5)
            com.youku.playerservice.axp.playinfo.PlayInfo r0 = r3.mPlayInfo
            com.youku.playerservice.axp.playinfo.PlayInfoResponse r0 = r0.getPlayInfoResponse()
            if (r0 == 0) goto Lb6
            com.youku.playerservice.axp.playinfo.PlayInfo r0 = r3.mPlayInfo
            com.youku.playerservice.axp.playinfo.PlayInfoResponse r0 = r0.getPlayInfoResponse()
            com.youku.playerservice.axp.axpinterface.PlayDefinition$PlayInfoType r0 = r0.getInfoType()
            com.youku.playerservice.axp.axpinterface.PlayDefinition$PlayInfoType r1 = com.youku.playerservice.axp.axpinterface.PlayDefinition.PlayInfoType.UPS
            if (r0 != r1) goto L69
            com.youku.playerservice.axp.playinfo.PlayInfo r0 = r3.mPlayInfo
            com.youku.playerservice.axp.playinfo.PlayInfoResponse r0 = r0.getPlayInfoResponse()
            com.youku.playerservice.axp.playinfo.NetUpsInfo r0 = r0.getUpsInfo()
            if (r0 == 0) goto L69
            com.youku.playerservice.axp.playinfo.PlayInfo r0 = r3.mPlayInfo
            com.youku.playerservice.axp.playinfo.PlayInfoResponse r0 = r0.getPlayInfoResponse()
            com.youku.playerservice.axp.playinfo.NetUpsInfo r0 = r0.getUpsInfo()
            com.youku.upsplayer.module.VideoInfo r0 = r0.getVideoInfo()
            if (r0 == 0) goto L69
            com.youku.playerservice.axp.playinfo.PlayInfo r0 = r3.mPlayInfo
            com.youku.playerservice.axp.playinfo.PlayInfoResponse r0 = r0.getPlayInfoResponse()
            com.youku.playerservice.axp.playinfo.NetUpsInfo r0 = r0.getUpsInfo()
            com.youku.upsplayer.module.VideoInfo r0 = r0.getVideoInfo()
            java.lang.String r0 = r0.getDomainController()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L69
            java.lang.String r1 = "domainController"
            r5.put(r1, r0)
        L69:
            java.lang.String r0 = r3.getFileFormat(r4)
            java.lang.String r1 = "fileType"
            r5.put(r1, r0)
            com.youku.playerservice.axp.playinfo.PlayInfo r0 = r3.mPlayInfo
            com.youku.playerservice.axp.axpinterface.PlayDefinition$PlayScene r0 = r0.getPlayScene()
            com.youku.playerservice.axp.axpinterface.PlayDefinition$PlayScene r1 = com.youku.playerservice.axp.axpinterface.PlayDefinition.PlayScene.SHORT_VIDEO
            java.lang.String r2 = "playMode"
            if (r0 != r1) goto L84
            java.lang.String r0 = "feed"
        L80:
            r5.put(r2, r0)
            goto Lab
        L84:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto Lab
            android.net.Uri r0 = android.net.Uri.parse(r4)
            java.lang.String r1 = "ykVideoShowType"
            java.lang.String r0 = r0.getQueryParameter(r1)
            java.lang.String r1 = "2"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto La8
            java.lang.String r1 = "3"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto La5
            goto La8
        La5:
            java.lang.String r0 = "video"
            goto L80
        La8:
            java.lang.String r0 = "ad"
            goto L80
        Lab:
            java.lang.String r4 = com.youku.playerservice.axp.cellular.CellularPlayUtils.getHost(r4, r5)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto Lb6
            return r4
        Lb6:
            r4 = 0
            com.youku.alixplayer.config.FeatureManager r5 = com.youku.alixplayer.config.FeatureManager.getInstance()
            boolean r5 = r5.hasFreeFlow()
            if (r5 == 0) goto Lc5
            boolean r4 = com.youku.phone.freeflow.utils.NetworkUtils.isConnectedCellular()
        Lc5:
            if (r4 == 0) goto Ld2
            com.youku.playerservice.axp.playinfo.PlayInfo r4 = r3.mPlayInfo
            com.youku.playerservice.axp.item.PlayItem r4 = r4.getPlayItem()
            java.lang.String r4 = r4.getCellularDomain()
            return r4
        Ld2:
            com.youku.playerservice.axp.playinfo.PlayInfo r4 = r3.mPlayInfo
            com.youku.playerservice.axp.item.PlayItem r4 = r4.getPlayItem()
            java.lang.String r4 = r4.getWifiDomain()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.player.PlayerImpl.getDomain(java.lang.String, java.lang.String):java.lang.String");
    }

    private String getFileFormat(String str) {
        return (TextUtils.isEmpty(str) || !(str.contains(".m3u8") || str.contains(".ts"))) ? YKLAnimationViewAdapter.TYPE_MP4 : LiveManager.StreamConfig.FORMAT_HLS;
    }

    private Reporter.MonitorTableName getTableName(TableId tableId) {
        switch (AnonymousClass10.$SwitchMap$com$youku$vpm$framework$TableId[tableId.ordinal()]) {
            case 1:
                return Reporter.MonitorTableName.ONE_PLAY;
            case 2:
                return Reporter.MonitorTableName.IMPAIRMENT;
            case 3:
                return Reporter.MonitorTableName.BEFORE_PLAY;
            case 4:
                return Reporter.MonitorTableName.PLAYING;
            case 5:
                return Reporter.MonitorTableName.ONE_CHANGE_SEEK;
            case 6:
                return Reporter.MonitorTableName.ONE_CHANGE_QUALITY;
            case 7:
                return Reporter.MonitorTableName.PLAY_HEART_BEAT;
            case 8:
                return Reporter.MonitorTableName.ONE_EVENT;
            case 9:
                return Reporter.MonitorTableName.AD_PLAY;
            case 10:
                return Reporter.MonitorTableName.AD_ERROR;
            case 11:
                return Reporter.MonitorTableName.AD_IMPAIRMENT;
            case 12:
            default:
                return null;
            case 13:
                return Reporter.MonitorTableName.PLAY_ABNORMAL_DETAIL;
            case 14:
                return Reporter.MonitorTableName.PLAY_ABNORMAL_SUMMARY;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStateChanged(IAlixPlayer.State state, IAlixPlayer.State state2) {
        InternalPlayerEventListener internalPlayerEventListener;
        if (this.mAlixPlayer == null) {
            return;
        }
        TLogUtil.loge(CacheManager.TAG_PLAYER, "playerImpl:" + hashCode() + " player:" + this.mAlixPlayer.hashCode() + "-state-" + state2);
        if (state2 == IAlixPlayer.State.STATE_SOURCE_READY) {
            long currentTimeMillis = System.currentTimeMillis();
            Log.d(TAG, "prepare called:" + currentTimeMillis);
            PlayerTrack playerTrack = this.mPlayerTrack;
            if (playerTrack != null) {
                playerTrack.putTimestamp("playlistEndTs", currentTimeMillis);
                this.mPlayerTrack.putTimestamp("playerPrepareTs", currentTimeMillis);
            } else {
                this.mPlayInfo.putString("prePlaylistEndTs", String.valueOf(currentTimeMillis));
                this.mPlayInfo.putString("prePlayerPrepareTs", String.valueOf(currentTimeMillis));
            }
            logWithSessionId("prepare");
            this.mAlixPlayer.prepareAsync();
        } else if (state2 != IAlixPlayer.State.STATE_PREPARED) {
            if (state == IAlixPlayer.State.STATE_VIDEO_PAUSED || state2 != IAlixPlayer.State.STATE_VIDEO_STARTED) {
                if (state2 != IAlixPlayer.State.STATE_VIDEO_COMPLETED || (internalPlayerEventListener = this.mInternalPlayerEventListener) == null) {
                    return;
                }
                internalPlayerEventListener.onComplete();
                return;
            }
            this.mAlixPlayer.setIsLoopPlay(this.mIsLoopPlay);
            InternalPlayerEventListener internalPlayerEventListener2 = this.mInternalPlayerEventListener;
            if (internalPlayerEventListener2 != null) {
                internalPlayerEventListener2.onRealVideoStart();
            }
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.d(TAG, "start called:" + currentTimeMillis2);
            logWithSessionId("内核准备完成，player调用start开始播放");
            PlayerTrack playerTrack2 = this.mPlayerTrack;
            if (playerTrack2 != null) {
                playerTrack2.putTimestamp("playerPreparedTs", currentTimeMillis2);
            } else {
                this.mPlayInfo.putString("prePlayerPreparedTs", String.valueOf(currentTimeMillis2));
            }
            if (this.mIsAutoPlay) {
                logWithSessionId("first start");
                this.mAlixPlayer.start();
            }
            InternalPlayerEventListener internalPlayerEventListener3 = this.mInternalPlayerEventListener;
            if (internalPlayerEventListener3 != null) {
                internalPlayerEventListener3.onPrepared();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDoubleChannelEnable(Map<String, String> map) {
        return CellularPlayUtils.isDoubleChannelEnable(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logWithSessionId(String str) {
        PlayInfo playInfo = this.mPlayInfo;
        logWithSessionId(playInfo != null ? playInfo.getPlayParams().getSessionId() : null, str);
    }

    private void logWithSessionId(String str, String str2) {
        if (this.mIsPreload) {
            str2 = "预播放 " + str2;
        }
        TLogUtil.flowLog(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> parse(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(";")) {
                String[] split = str2.split("=", 2);
                if (split.length == 2) {
                    hashMap.put(split[0], split[1]);
                }
            }
        }
        return hashMap;
    }

    private void setDataSource(PlayInfo playInfo) {
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack != null) {
            playerTrack.putTimestamp("playWithMediaSourceTs", System.currentTimeMillis());
        }
        BaseMediaSource systemUrlMediaSource = PlayerManager.getInstance().useSystemPlayer() ? new SystemUrlMediaSource(this.mContext, playInfo) : playInfo.getPlayType() == PlayDefinition.PlayType.VOD ? new UpsMediaSource(this.mContext, playInfo) : playInfo.getPlayType() == PlayDefinition.PlayType.LIVE ? new LiveMediaSource(this.mContext, playInfo) : new UrlMediaSource(this.mContext, playInfo);
        systemUrlMediaSource.setOnMediaSourceListener(this.mOnMediaSourceListener);
        this.mMediaSource = systemUrlMediaSource;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            PlayerTrack playerTrack2 = this.mPlayerTrack;
            if (playerTrack2 != null) {
                playerTrack2.putTimestamp("playlistStartTs", currentTimeMillis);
            } else {
                playInfo.putString("prePlaylistStartTs", currentTimeMillis + "");
            }
            this.mAlixPlayer.setDataSource(systemUrlMediaSource);
        } catch (Exception unused) {
            PlayerTrack playerTrack3 = this.mPlayerTrack;
            if (playerTrack3 != null) {
                playerTrack3.onError(0, ErrorCode.PLAY_LIST_CONSTRUCT_ERROR, null);
            }
            InternalPlayerEventListener internalPlayerEventListener = this.mInternalPlayerEventListener;
            if (internalPlayerEventListener != null) {
                internalPlayerEventListener.onError(ErrorCode.PLAY_LIST_CONSTRUCT_ERROR);
            }
        }
    }

    @Override // com.youku.vpm.Callable
    public String call(String str) {
        PlayInfo playInfo = this.mPlayInfo;
        if (playInfo == null || playInfo.getPlayerConfig() == null) {
            return null;
        }
        return this.mPlayInfo.getPlayerConfig().getDynamicProperty(str);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void changeVideoSize(int i, int i2) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.changeVideoSize(i, i2);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized Object doAction(PlayerAction playerAction, Map<String, Object> map) {
        IAlixPlayer iAlixPlayer;
        Period period;
        if (playerAction == PlayerAction.GET_PLAYER_HASHCODE) {
            IAlixPlayer iAlixPlayer2 = this.mAlixPlayer;
            if (iAlixPlayer2 != null) {
                return Integer.valueOf(iAlixPlayer2.hashCode());
            }
            return null;
        } else if (playerAction == PlayerAction.SWITCH_PLAYER_MODE) {
            if (this.mAlixPlayer != null) {
                try {
                    this.mAlixPlayer.switchPlayerMode(((Integer) map.get("vrMode")).intValue(), ((Integer) map.get("vrType")).intValue());
                } catch (Exception unused) {
                }
            }
            return null;
        } else if (playerAction == PlayerAction.SET_BINOCULAR_MODE) {
            if (this.mAlixPlayer != null) {
                try {
                    this.mAlixPlayer.setBinocularMode(((Boolean) map.get("sw")).booleanValue());
                } catch (Exception unused2) {
                }
            }
            return null;
        } else if (playerAction == PlayerAction.GET_RENDER_TYPE) {
            IAlixPlayer iAlixPlayer3 = this.mAlixPlayer;
            if (iAlixPlayer3 != null) {
                return Integer.valueOf(iAlixPlayer3.getCurrentRenderType());
            }
            return null;
        } else if (playerAction == PlayerAction.QUERY_SIX_DOF_ANGLE) {
            IAlixPlayer iAlixPlayer4 = this.mAlixPlayer;
            return iAlixPlayer4 != null ? Float.valueOf(iAlixPlayer4.querySixDofAngle()) : Float.valueOf(-1.0f);
        } else if (playerAction == PlayerAction.SCREENSHOT_ONE_FRAME) {
            try {
                IAlixPlayer iAlixPlayer5 = this.mAlixPlayer;
                if (iAlixPlayer5 != null && !isFree(iAlixPlayer5)) {
                    return Integer.valueOf(this.mAlixPlayer.screenShotOneFrame((AssetManager) map.get("assetManager"), (String) map.get("outPath"), ((Integer) map.get("outWidth")).intValue(), ((Integer) map.get("outHeight")).intValue(), ((Integer) map.get("outFmt")).intValue(), (String) map.get("logoPath"), ((Integer) map.get("logoWidth")).intValue(), ((Integer) map.get("logoHeight")).intValue(), ((Integer) map.get("logoLeft")).intValue(), ((Integer) map.get("logoTop")).intValue()));
                }
            } catch (Exception unused3) {
            }
            return -1;
        } else {
            if (playerAction == PlayerAction.SCREENSHOT_MULTI_FRAMES_BEGIN) {
                try {
                    IAlixPlayer iAlixPlayer6 = this.mAlixPlayer;
                    if (iAlixPlayer6 != null && !isFree(iAlixPlayer6)) {
                        String str = (String) map.get("outPath");
                        int intValue = ((Integer) map.get("outWidth")).intValue();
                        int intValue2 = ((Integer) map.get("outHeight")).intValue();
                        int intValue3 = ((Integer) map.get(LoginConstant.START_TIME)).intValue();
                        int intValue4 = ((Integer) map.get("endTime")).intValue();
                        int intValue5 = ((Integer) map.get("mode")).intValue();
                        BitStream bitStream = ((PlayInfoUpsResponse) this.mPlayInfo.getPlayInfoResponse()).getPlayItem(this.mPlayInfo.getPlayParams(), Quality.HD2, (String) null).getBitStream();
                        Period period2 = new Period();
                        period2.setType(0);
                        period2.addSource(new Source(bitStream.getM3u8Url(), bitStream.getDuration()));
                        return Integer.valueOf(this.mAlixPlayer.screenShotMultiFramesBegin(str, intValue, intValue2, period2, intValue3, intValue4, intValue5));
                    }
                } catch (Exception unused4) {
                }
                return -1;
            } else if (playerAction == PlayerAction.SCREENSHOT_MULTI_FRAMES_END) {
                try {
                    IAlixPlayer iAlixPlayer7 = this.mAlixPlayer;
                    if (iAlixPlayer7 != null && !isFree(iAlixPlayer7)) {
                        return Integer.valueOf(this.mAlixPlayer.screenShotMultiFramesEnd(((Integer) map.get("formatType")).intValue(), ((Integer) map.get("endType")).intValue(), ((Integer) map.get(LoginConstant.START_TIME)).intValue(), ((Integer) map.get("endTime")).intValue(), ((Integer) map.get("mode")).intValue(), (Map) map.get("params")));
                    }
                } catch (Exception unused5) {
                }
                return -1;
            } else if (playerAction == PlayerAction.SET_NOTSTOPFLAG) {
                this.mNotStopFlag = true;
                return -1;
            } else {
                if (playerAction == PlayerAction.DO_AD) {
                    try {
                        if (this.mPlayInfo != null && (iAlixPlayer = this.mAlixPlayer) != null && !isFree(iAlixPlayer)) {
                            String str2 = (String) map.get("mode");
                            AdInfo adInfo = (AdInfo) map.get("adInfo");
                            if ("set".equals(str2)) {
                                Period period3 = new Period();
                                period3.setType(3);
                                for (int i = 0; i < adInfo.getBidInfoList().size(); i++) {
                                    BidInfo bidInfo = adInfo.getBidInfoList().get(i);
                                    if (!TextUtils.isEmpty(bidInfo.getCreativeUrl())) {
                                        String trim = bidInfo.getCreativeUrl().trim();
                                        BaseMediaSource baseMediaSource = this.mMediaSource;
                                        if (baseMediaSource instanceof AxpMediaSource) {
                                            trim = ((AxpMediaSource) baseMediaSource).appendUrlParams(trim, "ykVideoShowType=4");
                                        }
                                        period3.addSource(new Source(trim, bidInfo.getDuration()));
                                        period3.setMixedCodec(true);
                                    }
                                }
                                NativeMap nativeMap = new NativeMap();
                                nativeMap.put("enable_auto_start", "0");
                                nativeMap.put("player_source", "1");
                                period3.setHeader(nativeMap);
                                period3.setFeatureFlags(0L);
                                this.mPlayInfo.setTag("midAdPeriod", period3);
                            } else if (Constants.Value.PLAY.equals(str2) && (period = (Period) this.mPlayInfo.getTag("midAdPeriod")) != null) {
                                this.mAlixPlayer.playMidAd(period);
                            }
                        }
                    } catch (Exception unused6) {
                    }
                } else if (playerAction == PlayerAction.RAPHAEL_SET_PARAMS) {
                    try {
                        if (this.mAlixPlayer != null) {
                            HashMap hashMap = new HashMap();
                            for (Map.Entry<String, Object> entry : map.entrySet()) {
                                hashMap.put(entry.getKey(), entry.getValue());
                            }
                            this.mAlixPlayer.setExtraParam(hashMap);
                        }
                    } catch (Exception unused7) {
                    }
                    return -1;
                }
                return null;
            }
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public Object doAction(String str, Map<String, Object> map) {
        if ("continuePlayRealVideo".equals(str)) {
            continuePlayRealVideo((VodItem) map.get("vodItem"), (SliceItem) map.get("sliceItem"));
            return null;
        }
        if ("setVideoRendCutMode".equals(str) && this.mAlixPlayer != null) {
            this.mAlixPlayer.setVideoRendCutMode(((Integer) map.get("mode")).intValue(), ((Float) map.get("xoffset")).floatValue(), ((Float) map.get("yoffset")).floatValue());
        }
        return this.mOtherFunc.doAction(this.mAlixPlayer, str, map);
    }

    @Override // com.youku.vpm.IPlayer
    public synchronized Map<String, String> getAllDims(TableId tableId) {
        try {
            IAlixPlayer iAlixPlayer = this.mAlixPlayer;
            if (iAlixPlayer != null && iAlixPlayer.getReporter() != null) {
                return this.mAlixPlayer.getReporter().getAllDims(getTableName(tableId));
            }
        } finally {
            return null;
        }
        return null;
    }

    @Override // com.youku.vpm.IPlayer
    public synchronized Map<String, String> getAllValues(TableId tableId) {
        try {
            IAlixPlayer iAlixPlayer = this.mAlixPlayer;
            if (iAlixPlayer != null && iAlixPlayer.getReporter() != null) {
                return this.mAlixPlayer.getReporter().getAllValues(getTableName(tableId));
            }
        } finally {
            return null;
        }
        return null;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized long getCurrentPosition() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            return iAlixPlayer.getCurrentPosition(Aliplayer.PositionType.NORMAL);
        }
        return 0L;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized float getCurrentZoomScale() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            return iAlixPlayer.getCurrentZoomScale();
        }
        return 1.0f;
    }

    @Override // com.youku.vpm.IMonitor
    public double getDouble(String str, double d) {
        return 0.0d;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public int getDuration() {
        PlayInfo playInfo = this.mPlayInfo;
        int duration = playInfo != null ? playInfo.getDuration() : 0;
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        return (iAlixPlayer == null || duration > 0) ? duration : (int) iAlixPlayer.getDuration();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol
    public ModuleManager getModuleManager() {
        return this.mModuleManager;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol
    public PlayInfo getPlayInfo() {
        return this.mPlayInfo;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol
    public synchronized PlayInfo getPlayInfoOfReuse(String str) {
        IMediaSource currentMediaSource;
        if (PlayerManager.getInstance().useSystemPlayer()) {
            Logger.d(TAG, "getPlayInfoOfReuse use system player!");
            return null;
        }
        IAlixPlayer c = C7792a.a(this.mContext).c(str);
        if (c == null || isFree(c) || (currentMediaSource = c.getCurrentMediaSource()) == null || !(currentMediaSource instanceof BaseMediaSource)) {
            return null;
        }
        return ((BaseMediaSource) currentMediaSource).getPlayInfo();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol
    public PlayParams getPlayParams() {
        return this.mPlayInfo.getPlayParams();
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public double getPlaySpeed() {
        return this.mPlaySpeed;
    }

    @Override // com.youku.vpm.IPlayer
    public String getPlayerInfoByKey(int i) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer == null || !ApsUtil.enableSameThreadSync()) {
            return null;
        }
        return iAlixPlayer.getPlayerInfoByKey(i);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public PlayerTrack getPlayerTrack() {
        return this.mPlayerTrack;
    }

    @Override // com.youku.vpm.IExt, com.youku.vpm.IMonitor
    public String getString(String str, String str2) {
        return null;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized int getVideoHeight() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            return iAlixPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized int getVideoWidth() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            return iAlixPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized float getVolume() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            return iAlixPlayer.getVolume();
        }
        return 0.0f;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void hideZoomPickWind() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setZoomPickWind(1, 0, 0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public boolean isFree(IAlixPlayer iAlixPlayer) {
        return iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_IDLE || iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_STOPPED || iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_RELEASED || iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_ERROR || iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_SOURCE_FAILED;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized boolean isMuted() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            return iAlixPlayer.isMuted();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
        if (r3.mAlixPlayer.getCurrentState() == com.youku.alixplayer.IAlixPlayer.State.STATE_PRE_VIP_PAUSED) goto L22;
     */
    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isPaused() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.youku.alixplayer.IAlixPlayer r0 = r3.mAlixPlayer     // Catch: java.lang.Throwable -> L3b
            r1 = 0
            if (r0 != 0) goto L8
            monitor-exit(r3)
            return r1
        L8:
            com.youku.alixplayer.IAlixPlayer$State r0 = r0.getCurrentState()     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r2 = com.youku.alixplayer.IAlixPlayer.State.STATE_VIDEO_PAUSED     // Catch: java.lang.Throwable -> L3b
            if (r0 == r2) goto L38
            com.youku.alixplayer.IAlixPlayer r0 = r3.mAlixPlayer     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r0 = r0.getCurrentState()     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r2 = com.youku.alixplayer.IAlixPlayer.State.STATE_MID_AD_PAUSED     // Catch: java.lang.Throwable -> L3b
            if (r0 == r2) goto L38
            com.youku.alixplayer.IAlixPlayer r0 = r3.mAlixPlayer     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r0 = r0.getCurrentState()     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r2 = com.youku.alixplayer.IAlixPlayer.State.STATE_POST_AD_PAUSED     // Catch: java.lang.Throwable -> L3b
            if (r0 == r2) goto L38
            com.youku.alixplayer.IAlixPlayer r0 = r3.mAlixPlayer     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r0 = r0.getCurrentState()     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r2 = com.youku.alixplayer.IAlixPlayer.State.STATE_PRE_AD_PAUSED     // Catch: java.lang.Throwable -> L3b
            if (r0 == r2) goto L38
            com.youku.alixplayer.IAlixPlayer r0 = r3.mAlixPlayer     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r0 = r0.getCurrentState()     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r2 = com.youku.alixplayer.IAlixPlayer.State.STATE_PRE_VIP_PAUSED     // Catch: java.lang.Throwable -> L3b
            if (r0 != r2) goto L39
        L38:
            r1 = 1
        L39:
            monitor-exit(r3)
            return r1
        L3b:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.player.PlayerImpl.isPaused():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
        if (r3.mAlixPlayer.getCurrentState() == com.youku.alixplayer.IAlixPlayer.State.STATE_PRE_VIP_STARTED) goto L22;
     */
    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isStarted() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.youku.alixplayer.IAlixPlayer r0 = r3.mAlixPlayer     // Catch: java.lang.Throwable -> L3b
            r1 = 0
            if (r0 != 0) goto L8
            monitor-exit(r3)
            return r1
        L8:
            com.youku.alixplayer.IAlixPlayer$State r0 = r0.getCurrentState()     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r2 = com.youku.alixplayer.IAlixPlayer.State.STATE_VIDEO_STARTED     // Catch: java.lang.Throwable -> L3b
            if (r0 == r2) goto L38
            com.youku.alixplayer.IAlixPlayer r0 = r3.mAlixPlayer     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r0 = r0.getCurrentState()     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r2 = com.youku.alixplayer.IAlixPlayer.State.STATE_MID_AD_STARTED     // Catch: java.lang.Throwable -> L3b
            if (r0 == r2) goto L38
            com.youku.alixplayer.IAlixPlayer r0 = r3.mAlixPlayer     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r0 = r0.getCurrentState()     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r2 = com.youku.alixplayer.IAlixPlayer.State.STATE_POST_AD_STARTED     // Catch: java.lang.Throwable -> L3b
            if (r0 == r2) goto L38
            com.youku.alixplayer.IAlixPlayer r0 = r3.mAlixPlayer     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r0 = r0.getCurrentState()     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r2 = com.youku.alixplayer.IAlixPlayer.State.STATE_PRE_AD_STARTED     // Catch: java.lang.Throwable -> L3b
            if (r0 == r2) goto L38
            com.youku.alixplayer.IAlixPlayer r0 = r3.mAlixPlayer     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r0 = r0.getCurrentState()     // Catch: java.lang.Throwable -> L3b
            com.youku.alixplayer.IAlixPlayer$State r2 = com.youku.alixplayer.IAlixPlayer.State.STATE_PRE_VIP_STARTED     // Catch: java.lang.Throwable -> L3b
            if (r0 != r2) goto L39
        L38:
            r1 = 1
        L39:
            monitor-exit(r3)
            return r1
        L3b:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.player.PlayerImpl.isStarted():boolean");
    }

    @Override // com.youku.alixplayer.AlixPlayerHolderUnbindListener
    public synchronized void onHolderUnbindNotify() {
        if (this.mAlixPlayer != null) {
            TLogUtil.loge(CacheManager.TAG_PLAYER, "playerimpl:" + hashCode() + " unbind AlixPlayer: " + this.mAlixPlayer.hashCode() + "-state-" + this.mAlixPlayer.getCurrentState());
            this.mAlixPlayer.removeOnPlayerStateListener(this.mOnStateChangeListener);
            this.mAlixPlayer.removeOnVideoSizeChangedListener(this.mOnVideoSizeChangedListener);
            this.mAlixPlayer.removeOnInfoListener(this.mOnInfoListener);
            this.mAlixPlayer.removeOnAdEventListener(this.mOnAdEventListener);
            IRenderMiddleware iRenderMiddleware = this.mRenderMiddleware;
            if (iRenderMiddleware != null) {
                this.mAlixPlayer.removeRenderMiddleware(iRenderMiddleware);
            }
            CacheManager.getInstance().removePoolId(this.mAlixPlayer.getPlayerId());
            if (ApsUtil.setAlixplayerNullEnable()) {
                this.mAlixPlayer = null;
            }
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void pause() {
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack != null) {
            playerTrack.onPause();
        }
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.pause();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(39:2|3|(1:5)|6|(1:8)|9|(1:11)(1:189)|12|(1:14)|15|(1:17)(1:188)|18|(1:20)(1:187)|(3:23|(1:25)|26)|27|(1:29)(24:167|(5:171|(4:178|(1:180)|181|182)|183|(1:185)|186)|31|(2:33|(4:35|(1:39)|40|(20:42|43|(1:45)(2:149|(1:155))|46|47|(1:49)|51|(2:53|(1:55))|56|(18:60|(1:62)|63|(11:68|(1:70)(10:107|(2:109|(1:111)(2:112|(1:114)))(3:115|(1:117)(2:119|(1:121)(1:122))|118)|72|(2:87|(6:93|(1:96)|97|(3:99|(1:101)|102)|103|104))|106|(1:96)|97|(0)|103|104)|71|72|(6:74|76|78|80|87|(8:89|91|93|(0)|97|(0)|103|104))|106|(0)|97|(0)|103|104)|123|(1:125)|126|(1:128)|129|(2:131|(1:133))(2:134|(6:136|(1:138)|139|(1:141)|142|(1:144)))|72|(0)|106|(0)|97|(0)|103|104)|147|71|72|(0)|106|(0)|97|(0)|103|104)(1:(2:162|(1:164))(3:159|160|161)))(1:165))|166|43|(0)(0)|46|47|(0)|51|(0)|56|(18:60|(0)|63|(12:65|68|(0)(0)|71|72|(0)|106|(0)|97|(0)|103|104)|123|(0)|126|(0)|129|(0)(0)|72|(0)|106|(0)|97|(0)|103|104)|147|71|72|(0)|106|(0)|97|(0)|103|104)|30|31|(0)|166|43|(0)(0)|46|47|(0)|51|(0)|56|(0)|147|71|72|(0)|106|(0)|97|(0)|103|104) */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x04cb, code lost:
        com.youku.playerservice.axp.utils.TLogUtil.loge(com.youku.playerservice.axp.cache.CacheManager.TAG_PLAYER, "player:needReplay and stop");
        r11.mAlixPlayer.stop();
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x039b A[Catch: all -> 0x058a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0024, B:8:0x0028, B:9:0x002b, B:11:0x0037, B:13:0x0044, B:15:0x0051, B:16:0x0058, B:18:0x0062, B:20:0x0078, B:26:0x0084, B:28:0x008a, B:29:0x008f, B:30:0x00c4, B:32:0x00cc, B:33:0x00ce, B:54:0x015c, B:56:0x0164, B:58:0x0168, B:60:0x018f, B:62:0x0195, B:63:0x01ab, B:65:0x01b1, B:77:0x0276, B:79:0x02cd, B:87:0x0303, B:89:0x032a, B:90:0x032f, B:92:0x0359, B:94:0x0378, B:95:0x0384, B:99:0x0397, B:101:0x039b, B:102:0x03a4, B:104:0x03aa, B:107:0x03b2, B:109:0x03bc, B:110:0x03d2, B:152:0x04f2, B:154:0x04f6, B:156:0x04fe, B:158:0x0506, B:160:0x0510, B:162:0x0518, B:164:0x0522, B:167:0x0533, B:169:0x0541, B:171:0x054b, B:173:0x0555, B:177:0x056b, B:178:0x0570, B:180:0x0574, B:182:0x0578, B:183:0x0581, B:111:0x03d7, B:113:0x03e1, B:115:0x03e5, B:116:0x0401, B:118:0x0405, B:119:0x040a, B:121:0x0414, B:122:0x041e, B:123:0x0423, B:125:0x042d, B:126:0x0438, B:127:0x0443, B:129:0x0456, B:130:0x0467, B:132:0x0472, B:133:0x0481, B:135:0x048b, B:137:0x048f, B:138:0x0495, B:140:0x049f, B:142:0x04a3, B:143:0x04a8, B:145:0x04b3, B:146:0x04b6, B:148:0x04ba, B:150:0x04cb, B:151:0x04d7, B:80:0x02d8, B:82:0x02de, B:84:0x02e8, B:86:0x02ee, B:67:0x021f, B:69:0x0227, B:72:0x0263, B:74:0x026b, B:75:0x0270, B:34:0x00d3, B:36:0x00db, B:38:0x00e3, B:40:0x00e7, B:42:0x00eb, B:45:0x00f4, B:47:0x0140, B:50:0x0147, B:52:0x014f, B:53:0x0158, B:19:0x0071, B:12:0x003c), top: B:192:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03bc A[Catch: all -> 0x058a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0024, B:8:0x0028, B:9:0x002b, B:11:0x0037, B:13:0x0044, B:15:0x0051, B:16:0x0058, B:18:0x0062, B:20:0x0078, B:26:0x0084, B:28:0x008a, B:29:0x008f, B:30:0x00c4, B:32:0x00cc, B:33:0x00ce, B:54:0x015c, B:56:0x0164, B:58:0x0168, B:60:0x018f, B:62:0x0195, B:63:0x01ab, B:65:0x01b1, B:77:0x0276, B:79:0x02cd, B:87:0x0303, B:89:0x032a, B:90:0x032f, B:92:0x0359, B:94:0x0378, B:95:0x0384, B:99:0x0397, B:101:0x039b, B:102:0x03a4, B:104:0x03aa, B:107:0x03b2, B:109:0x03bc, B:110:0x03d2, B:152:0x04f2, B:154:0x04f6, B:156:0x04fe, B:158:0x0506, B:160:0x0510, B:162:0x0518, B:164:0x0522, B:167:0x0533, B:169:0x0541, B:171:0x054b, B:173:0x0555, B:177:0x056b, B:178:0x0570, B:180:0x0574, B:182:0x0578, B:183:0x0581, B:111:0x03d7, B:113:0x03e1, B:115:0x03e5, B:116:0x0401, B:118:0x0405, B:119:0x040a, B:121:0x0414, B:122:0x041e, B:123:0x0423, B:125:0x042d, B:126:0x0438, B:127:0x0443, B:129:0x0456, B:130:0x0467, B:132:0x0472, B:133:0x0481, B:135:0x048b, B:137:0x048f, B:138:0x0495, B:140:0x049f, B:142:0x04a3, B:143:0x04a8, B:145:0x04b3, B:146:0x04b6, B:148:0x04ba, B:150:0x04cb, B:151:0x04d7, B:80:0x02d8, B:82:0x02de, B:84:0x02e8, B:86:0x02ee, B:67:0x021f, B:69:0x0227, B:72:0x0263, B:74:0x026b, B:75:0x0270, B:34:0x00d3, B:36:0x00db, B:38:0x00e3, B:40:0x00e7, B:42:0x00eb, B:45:0x00f4, B:47:0x0140, B:50:0x0147, B:52:0x014f, B:53:0x0158, B:19:0x0071, B:12:0x003c), top: B:192:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03d7 A[Catch: all -> 0x058a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0024, B:8:0x0028, B:9:0x002b, B:11:0x0037, B:13:0x0044, B:15:0x0051, B:16:0x0058, B:18:0x0062, B:20:0x0078, B:26:0x0084, B:28:0x008a, B:29:0x008f, B:30:0x00c4, B:32:0x00cc, B:33:0x00ce, B:54:0x015c, B:56:0x0164, B:58:0x0168, B:60:0x018f, B:62:0x0195, B:63:0x01ab, B:65:0x01b1, B:77:0x0276, B:79:0x02cd, B:87:0x0303, B:89:0x032a, B:90:0x032f, B:92:0x0359, B:94:0x0378, B:95:0x0384, B:99:0x0397, B:101:0x039b, B:102:0x03a4, B:104:0x03aa, B:107:0x03b2, B:109:0x03bc, B:110:0x03d2, B:152:0x04f2, B:154:0x04f6, B:156:0x04fe, B:158:0x0506, B:160:0x0510, B:162:0x0518, B:164:0x0522, B:167:0x0533, B:169:0x0541, B:171:0x054b, B:173:0x0555, B:177:0x056b, B:178:0x0570, B:180:0x0574, B:182:0x0578, B:183:0x0581, B:111:0x03d7, B:113:0x03e1, B:115:0x03e5, B:116:0x0401, B:118:0x0405, B:119:0x040a, B:121:0x0414, B:122:0x041e, B:123:0x0423, B:125:0x042d, B:126:0x0438, B:127:0x0443, B:129:0x0456, B:130:0x0467, B:132:0x0472, B:133:0x0481, B:135:0x048b, B:137:0x048f, B:138:0x0495, B:140:0x049f, B:142:0x04a3, B:143:0x04a8, B:145:0x04b3, B:146:0x04b6, B:148:0x04ba, B:150:0x04cb, B:151:0x04d7, B:80:0x02d8, B:82:0x02de, B:84:0x02e8, B:86:0x02ee, B:67:0x021f, B:69:0x0227, B:72:0x0263, B:74:0x026b, B:75:0x0270, B:34:0x00d3, B:36:0x00db, B:38:0x00e3, B:40:0x00e7, B:42:0x00eb, B:45:0x00f4, B:47:0x0140, B:50:0x0147, B:52:0x014f, B:53:0x0158, B:19:0x0071, B:12:0x003c), top: B:192:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0456 A[Catch: all -> 0x058a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0024, B:8:0x0028, B:9:0x002b, B:11:0x0037, B:13:0x0044, B:15:0x0051, B:16:0x0058, B:18:0x0062, B:20:0x0078, B:26:0x0084, B:28:0x008a, B:29:0x008f, B:30:0x00c4, B:32:0x00cc, B:33:0x00ce, B:54:0x015c, B:56:0x0164, B:58:0x0168, B:60:0x018f, B:62:0x0195, B:63:0x01ab, B:65:0x01b1, B:77:0x0276, B:79:0x02cd, B:87:0x0303, B:89:0x032a, B:90:0x032f, B:92:0x0359, B:94:0x0378, B:95:0x0384, B:99:0x0397, B:101:0x039b, B:102:0x03a4, B:104:0x03aa, B:107:0x03b2, B:109:0x03bc, B:110:0x03d2, B:152:0x04f2, B:154:0x04f6, B:156:0x04fe, B:158:0x0506, B:160:0x0510, B:162:0x0518, B:164:0x0522, B:167:0x0533, B:169:0x0541, B:171:0x054b, B:173:0x0555, B:177:0x056b, B:178:0x0570, B:180:0x0574, B:182:0x0578, B:183:0x0581, B:111:0x03d7, B:113:0x03e1, B:115:0x03e5, B:116:0x0401, B:118:0x0405, B:119:0x040a, B:121:0x0414, B:122:0x041e, B:123:0x0423, B:125:0x042d, B:126:0x0438, B:127:0x0443, B:129:0x0456, B:130:0x0467, B:132:0x0472, B:133:0x0481, B:135:0x048b, B:137:0x048f, B:138:0x0495, B:140:0x049f, B:142:0x04a3, B:143:0x04a8, B:145:0x04b3, B:146:0x04b6, B:148:0x04ba, B:150:0x04cb, B:151:0x04d7, B:80:0x02d8, B:82:0x02de, B:84:0x02e8, B:86:0x02ee, B:67:0x021f, B:69:0x0227, B:72:0x0263, B:74:0x026b, B:75:0x0270, B:34:0x00d3, B:36:0x00db, B:38:0x00e3, B:40:0x00e7, B:42:0x00eb, B:45:0x00f4, B:47:0x0140, B:50:0x0147, B:52:0x014f, B:53:0x0158, B:19:0x0071, B:12:0x003c), top: B:192:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0472 A[Catch: all -> 0x058a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0024, B:8:0x0028, B:9:0x002b, B:11:0x0037, B:13:0x0044, B:15:0x0051, B:16:0x0058, B:18:0x0062, B:20:0x0078, B:26:0x0084, B:28:0x008a, B:29:0x008f, B:30:0x00c4, B:32:0x00cc, B:33:0x00ce, B:54:0x015c, B:56:0x0164, B:58:0x0168, B:60:0x018f, B:62:0x0195, B:63:0x01ab, B:65:0x01b1, B:77:0x0276, B:79:0x02cd, B:87:0x0303, B:89:0x032a, B:90:0x032f, B:92:0x0359, B:94:0x0378, B:95:0x0384, B:99:0x0397, B:101:0x039b, B:102:0x03a4, B:104:0x03aa, B:107:0x03b2, B:109:0x03bc, B:110:0x03d2, B:152:0x04f2, B:154:0x04f6, B:156:0x04fe, B:158:0x0506, B:160:0x0510, B:162:0x0518, B:164:0x0522, B:167:0x0533, B:169:0x0541, B:171:0x054b, B:173:0x0555, B:177:0x056b, B:178:0x0570, B:180:0x0574, B:182:0x0578, B:183:0x0581, B:111:0x03d7, B:113:0x03e1, B:115:0x03e5, B:116:0x0401, B:118:0x0405, B:119:0x040a, B:121:0x0414, B:122:0x041e, B:123:0x0423, B:125:0x042d, B:126:0x0438, B:127:0x0443, B:129:0x0456, B:130:0x0467, B:132:0x0472, B:133:0x0481, B:135:0x048b, B:137:0x048f, B:138:0x0495, B:140:0x049f, B:142:0x04a3, B:143:0x04a8, B:145:0x04b3, B:146:0x04b6, B:148:0x04ba, B:150:0x04cb, B:151:0x04d7, B:80:0x02d8, B:82:0x02de, B:84:0x02e8, B:86:0x02ee, B:67:0x021f, B:69:0x0227, B:72:0x0263, B:74:0x026b, B:75:0x0270, B:34:0x00d3, B:36:0x00db, B:38:0x00e3, B:40:0x00e7, B:42:0x00eb, B:45:0x00f4, B:47:0x0140, B:50:0x0147, B:52:0x014f, B:53:0x0158, B:19:0x0071, B:12:0x003c), top: B:192:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x048b A[Catch: all -> 0x058a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0024, B:8:0x0028, B:9:0x002b, B:11:0x0037, B:13:0x0044, B:15:0x0051, B:16:0x0058, B:18:0x0062, B:20:0x0078, B:26:0x0084, B:28:0x008a, B:29:0x008f, B:30:0x00c4, B:32:0x00cc, B:33:0x00ce, B:54:0x015c, B:56:0x0164, B:58:0x0168, B:60:0x018f, B:62:0x0195, B:63:0x01ab, B:65:0x01b1, B:77:0x0276, B:79:0x02cd, B:87:0x0303, B:89:0x032a, B:90:0x032f, B:92:0x0359, B:94:0x0378, B:95:0x0384, B:99:0x0397, B:101:0x039b, B:102:0x03a4, B:104:0x03aa, B:107:0x03b2, B:109:0x03bc, B:110:0x03d2, B:152:0x04f2, B:154:0x04f6, B:156:0x04fe, B:158:0x0506, B:160:0x0510, B:162:0x0518, B:164:0x0522, B:167:0x0533, B:169:0x0541, B:171:0x054b, B:173:0x0555, B:177:0x056b, B:178:0x0570, B:180:0x0574, B:182:0x0578, B:183:0x0581, B:111:0x03d7, B:113:0x03e1, B:115:0x03e5, B:116:0x0401, B:118:0x0405, B:119:0x040a, B:121:0x0414, B:122:0x041e, B:123:0x0423, B:125:0x042d, B:126:0x0438, B:127:0x0443, B:129:0x0456, B:130:0x0467, B:132:0x0472, B:133:0x0481, B:135:0x048b, B:137:0x048f, B:138:0x0495, B:140:0x049f, B:142:0x04a3, B:143:0x04a8, B:145:0x04b3, B:146:0x04b6, B:148:0x04ba, B:150:0x04cb, B:151:0x04d7, B:80:0x02d8, B:82:0x02de, B:84:0x02e8, B:86:0x02ee, B:67:0x021f, B:69:0x0227, B:72:0x0263, B:74:0x026b, B:75:0x0270, B:34:0x00d3, B:36:0x00db, B:38:0x00e3, B:40:0x00e7, B:42:0x00eb, B:45:0x00f4, B:47:0x0140, B:50:0x0147, B:52:0x014f, B:53:0x0158, B:19:0x0071, B:12:0x003c), top: B:192:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0495 A[Catch: all -> 0x058a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0024, B:8:0x0028, B:9:0x002b, B:11:0x0037, B:13:0x0044, B:15:0x0051, B:16:0x0058, B:18:0x0062, B:20:0x0078, B:26:0x0084, B:28:0x008a, B:29:0x008f, B:30:0x00c4, B:32:0x00cc, B:33:0x00ce, B:54:0x015c, B:56:0x0164, B:58:0x0168, B:60:0x018f, B:62:0x0195, B:63:0x01ab, B:65:0x01b1, B:77:0x0276, B:79:0x02cd, B:87:0x0303, B:89:0x032a, B:90:0x032f, B:92:0x0359, B:94:0x0378, B:95:0x0384, B:99:0x0397, B:101:0x039b, B:102:0x03a4, B:104:0x03aa, B:107:0x03b2, B:109:0x03bc, B:110:0x03d2, B:152:0x04f2, B:154:0x04f6, B:156:0x04fe, B:158:0x0506, B:160:0x0510, B:162:0x0518, B:164:0x0522, B:167:0x0533, B:169:0x0541, B:171:0x054b, B:173:0x0555, B:177:0x056b, B:178:0x0570, B:180:0x0574, B:182:0x0578, B:183:0x0581, B:111:0x03d7, B:113:0x03e1, B:115:0x03e5, B:116:0x0401, B:118:0x0405, B:119:0x040a, B:121:0x0414, B:122:0x041e, B:123:0x0423, B:125:0x042d, B:126:0x0438, B:127:0x0443, B:129:0x0456, B:130:0x0467, B:132:0x0472, B:133:0x0481, B:135:0x048b, B:137:0x048f, B:138:0x0495, B:140:0x049f, B:142:0x04a3, B:143:0x04a8, B:145:0x04b3, B:146:0x04b6, B:148:0x04ba, B:150:0x04cb, B:151:0x04d7, B:80:0x02d8, B:82:0x02de, B:84:0x02e8, B:86:0x02ee, B:67:0x021f, B:69:0x0227, B:72:0x0263, B:74:0x026b, B:75:0x0270, B:34:0x00d3, B:36:0x00db, B:38:0x00e3, B:40:0x00e7, B:42:0x00eb, B:45:0x00f4, B:47:0x0140, B:50:0x0147, B:52:0x014f, B:53:0x0158, B:19:0x0071, B:12:0x003c), top: B:192:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04f6 A[Catch: all -> 0x058a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0024, B:8:0x0028, B:9:0x002b, B:11:0x0037, B:13:0x0044, B:15:0x0051, B:16:0x0058, B:18:0x0062, B:20:0x0078, B:26:0x0084, B:28:0x008a, B:29:0x008f, B:30:0x00c4, B:32:0x00cc, B:33:0x00ce, B:54:0x015c, B:56:0x0164, B:58:0x0168, B:60:0x018f, B:62:0x0195, B:63:0x01ab, B:65:0x01b1, B:77:0x0276, B:79:0x02cd, B:87:0x0303, B:89:0x032a, B:90:0x032f, B:92:0x0359, B:94:0x0378, B:95:0x0384, B:99:0x0397, B:101:0x039b, B:102:0x03a4, B:104:0x03aa, B:107:0x03b2, B:109:0x03bc, B:110:0x03d2, B:152:0x04f2, B:154:0x04f6, B:156:0x04fe, B:158:0x0506, B:160:0x0510, B:162:0x0518, B:164:0x0522, B:167:0x0533, B:169:0x0541, B:171:0x054b, B:173:0x0555, B:177:0x056b, B:178:0x0570, B:180:0x0574, B:182:0x0578, B:183:0x0581, B:111:0x03d7, B:113:0x03e1, B:115:0x03e5, B:116:0x0401, B:118:0x0405, B:119:0x040a, B:121:0x0414, B:122:0x041e, B:123:0x0423, B:125:0x042d, B:126:0x0438, B:127:0x0443, B:129:0x0456, B:130:0x0467, B:132:0x0472, B:133:0x0481, B:135:0x048b, B:137:0x048f, B:138:0x0495, B:140:0x049f, B:142:0x04a3, B:143:0x04a8, B:145:0x04b3, B:146:0x04b6, B:148:0x04ba, B:150:0x04cb, B:151:0x04d7, B:80:0x02d8, B:82:0x02de, B:84:0x02e8, B:86:0x02ee, B:67:0x021f, B:69:0x0227, B:72:0x0263, B:74:0x026b, B:75:0x0270, B:34:0x00d3, B:36:0x00db, B:38:0x00e3, B:40:0x00e7, B:42:0x00eb, B:45:0x00f4, B:47:0x0140, B:50:0x0147, B:52:0x014f, B:53:0x0158, B:19:0x0071, B:12:0x003c), top: B:192:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0569 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0574 A[Catch: all -> 0x058a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0024, B:8:0x0028, B:9:0x002b, B:11:0x0037, B:13:0x0044, B:15:0x0051, B:16:0x0058, B:18:0x0062, B:20:0x0078, B:26:0x0084, B:28:0x008a, B:29:0x008f, B:30:0x00c4, B:32:0x00cc, B:33:0x00ce, B:54:0x015c, B:56:0x0164, B:58:0x0168, B:60:0x018f, B:62:0x0195, B:63:0x01ab, B:65:0x01b1, B:77:0x0276, B:79:0x02cd, B:87:0x0303, B:89:0x032a, B:90:0x032f, B:92:0x0359, B:94:0x0378, B:95:0x0384, B:99:0x0397, B:101:0x039b, B:102:0x03a4, B:104:0x03aa, B:107:0x03b2, B:109:0x03bc, B:110:0x03d2, B:152:0x04f2, B:154:0x04f6, B:156:0x04fe, B:158:0x0506, B:160:0x0510, B:162:0x0518, B:164:0x0522, B:167:0x0533, B:169:0x0541, B:171:0x054b, B:173:0x0555, B:177:0x056b, B:178:0x0570, B:180:0x0574, B:182:0x0578, B:183:0x0581, B:111:0x03d7, B:113:0x03e1, B:115:0x03e5, B:116:0x0401, B:118:0x0405, B:119:0x040a, B:121:0x0414, B:122:0x041e, B:123:0x0423, B:125:0x042d, B:126:0x0438, B:127:0x0443, B:129:0x0456, B:130:0x0467, B:132:0x0472, B:133:0x0481, B:135:0x048b, B:137:0x048f, B:138:0x0495, B:140:0x049f, B:142:0x04a3, B:143:0x04a8, B:145:0x04b3, B:146:0x04b6, B:148:0x04ba, B:150:0x04cb, B:151:0x04d7, B:80:0x02d8, B:82:0x02de, B:84:0x02e8, B:86:0x02ee, B:67:0x021f, B:69:0x0227, B:72:0x0263, B:74:0x026b, B:75:0x0270, B:34:0x00d3, B:36:0x00db, B:38:0x00e3, B:40:0x00e7, B:42:0x00eb, B:45:0x00f4, B:47:0x0140, B:50:0x0147, B:52:0x014f, B:53:0x0158, B:19:0x0071, B:12:0x003c), top: B:192:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0164 A[Catch: all -> 0x058a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0024, B:8:0x0028, B:9:0x002b, B:11:0x0037, B:13:0x0044, B:15:0x0051, B:16:0x0058, B:18:0x0062, B:20:0x0078, B:26:0x0084, B:28:0x008a, B:29:0x008f, B:30:0x00c4, B:32:0x00cc, B:33:0x00ce, B:54:0x015c, B:56:0x0164, B:58:0x0168, B:60:0x018f, B:62:0x0195, B:63:0x01ab, B:65:0x01b1, B:77:0x0276, B:79:0x02cd, B:87:0x0303, B:89:0x032a, B:90:0x032f, B:92:0x0359, B:94:0x0378, B:95:0x0384, B:99:0x0397, B:101:0x039b, B:102:0x03a4, B:104:0x03aa, B:107:0x03b2, B:109:0x03bc, B:110:0x03d2, B:152:0x04f2, B:154:0x04f6, B:156:0x04fe, B:158:0x0506, B:160:0x0510, B:162:0x0518, B:164:0x0522, B:167:0x0533, B:169:0x0541, B:171:0x054b, B:173:0x0555, B:177:0x056b, B:178:0x0570, B:180:0x0574, B:182:0x0578, B:183:0x0581, B:111:0x03d7, B:113:0x03e1, B:115:0x03e5, B:116:0x0401, B:118:0x0405, B:119:0x040a, B:121:0x0414, B:122:0x041e, B:123:0x0423, B:125:0x042d, B:126:0x0438, B:127:0x0443, B:129:0x0456, B:130:0x0467, B:132:0x0472, B:133:0x0481, B:135:0x048b, B:137:0x048f, B:138:0x0495, B:140:0x049f, B:142:0x04a3, B:143:0x04a8, B:145:0x04b3, B:146:0x04b6, B:148:0x04ba, B:150:0x04cb, B:151:0x04d7, B:80:0x02d8, B:82:0x02de, B:84:0x02e8, B:86:0x02ee, B:67:0x021f, B:69:0x0227, B:72:0x0263, B:74:0x026b, B:75:0x0270, B:34:0x00d3, B:36:0x00db, B:38:0x00e3, B:40:0x00e7, B:42:0x00eb, B:45:0x00f4, B:47:0x0140, B:50:0x0147, B:52:0x014f, B:53:0x0158, B:19:0x0071, B:12:0x003c), top: B:192:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02cd A[Catch: all -> 0x058a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0024, B:8:0x0028, B:9:0x002b, B:11:0x0037, B:13:0x0044, B:15:0x0051, B:16:0x0058, B:18:0x0062, B:20:0x0078, B:26:0x0084, B:28:0x008a, B:29:0x008f, B:30:0x00c4, B:32:0x00cc, B:33:0x00ce, B:54:0x015c, B:56:0x0164, B:58:0x0168, B:60:0x018f, B:62:0x0195, B:63:0x01ab, B:65:0x01b1, B:77:0x0276, B:79:0x02cd, B:87:0x0303, B:89:0x032a, B:90:0x032f, B:92:0x0359, B:94:0x0378, B:95:0x0384, B:99:0x0397, B:101:0x039b, B:102:0x03a4, B:104:0x03aa, B:107:0x03b2, B:109:0x03bc, B:110:0x03d2, B:152:0x04f2, B:154:0x04f6, B:156:0x04fe, B:158:0x0506, B:160:0x0510, B:162:0x0518, B:164:0x0522, B:167:0x0533, B:169:0x0541, B:171:0x054b, B:173:0x0555, B:177:0x056b, B:178:0x0570, B:180:0x0574, B:182:0x0578, B:183:0x0581, B:111:0x03d7, B:113:0x03e1, B:115:0x03e5, B:116:0x0401, B:118:0x0405, B:119:0x040a, B:121:0x0414, B:122:0x041e, B:123:0x0423, B:125:0x042d, B:126:0x0438, B:127:0x0443, B:129:0x0456, B:130:0x0467, B:132:0x0472, B:133:0x0481, B:135:0x048b, B:137:0x048f, B:138:0x0495, B:140:0x049f, B:142:0x04a3, B:143:0x04a8, B:145:0x04b3, B:146:0x04b6, B:148:0x04ba, B:150:0x04cb, B:151:0x04d7, B:80:0x02d8, B:82:0x02de, B:84:0x02e8, B:86:0x02ee, B:67:0x021f, B:69:0x0227, B:72:0x0263, B:74:0x026b, B:75:0x0270, B:34:0x00d3, B:36:0x00db, B:38:0x00e3, B:40:0x00e7, B:42:0x00eb, B:45:0x00f4, B:47:0x0140, B:50:0x0147, B:52:0x014f, B:53:0x0158, B:19:0x0071, B:12:0x003c), top: B:192:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02d8 A[Catch: all -> 0x058a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0024, B:8:0x0028, B:9:0x002b, B:11:0x0037, B:13:0x0044, B:15:0x0051, B:16:0x0058, B:18:0x0062, B:20:0x0078, B:26:0x0084, B:28:0x008a, B:29:0x008f, B:30:0x00c4, B:32:0x00cc, B:33:0x00ce, B:54:0x015c, B:56:0x0164, B:58:0x0168, B:60:0x018f, B:62:0x0195, B:63:0x01ab, B:65:0x01b1, B:77:0x0276, B:79:0x02cd, B:87:0x0303, B:89:0x032a, B:90:0x032f, B:92:0x0359, B:94:0x0378, B:95:0x0384, B:99:0x0397, B:101:0x039b, B:102:0x03a4, B:104:0x03aa, B:107:0x03b2, B:109:0x03bc, B:110:0x03d2, B:152:0x04f2, B:154:0x04f6, B:156:0x04fe, B:158:0x0506, B:160:0x0510, B:162:0x0518, B:164:0x0522, B:167:0x0533, B:169:0x0541, B:171:0x054b, B:173:0x0555, B:177:0x056b, B:178:0x0570, B:180:0x0574, B:182:0x0578, B:183:0x0581, B:111:0x03d7, B:113:0x03e1, B:115:0x03e5, B:116:0x0401, B:118:0x0405, B:119:0x040a, B:121:0x0414, B:122:0x041e, B:123:0x0423, B:125:0x042d, B:126:0x0438, B:127:0x0443, B:129:0x0456, B:130:0x0467, B:132:0x0472, B:133:0x0481, B:135:0x048b, B:137:0x048f, B:138:0x0495, B:140:0x049f, B:142:0x04a3, B:143:0x04a8, B:145:0x04b3, B:146:0x04b6, B:148:0x04ba, B:150:0x04cb, B:151:0x04d7, B:80:0x02d8, B:82:0x02de, B:84:0x02e8, B:86:0x02ee, B:67:0x021f, B:69:0x0227, B:72:0x0263, B:74:0x026b, B:75:0x0270, B:34:0x00d3, B:36:0x00db, B:38:0x00e3, B:40:0x00e7, B:42:0x00eb, B:45:0x00f4, B:47:0x0140, B:50:0x0147, B:52:0x014f, B:53:0x0158, B:19:0x0071, B:12:0x003c), top: B:192:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x032a A[Catch: Exception -> 0x032f, all -> 0x058a, TRY_LEAVE, TryCatch #0 {Exception -> 0x032f, blocks: (B:87:0x0303, B:89:0x032a), top: B:190:0x0303 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0359 A[Catch: all -> 0x058a, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0012, B:6:0x0024, B:8:0x0028, B:9:0x002b, B:11:0x0037, B:13:0x0044, B:15:0x0051, B:16:0x0058, B:18:0x0062, B:20:0x0078, B:26:0x0084, B:28:0x008a, B:29:0x008f, B:30:0x00c4, B:32:0x00cc, B:33:0x00ce, B:54:0x015c, B:56:0x0164, B:58:0x0168, B:60:0x018f, B:62:0x0195, B:63:0x01ab, B:65:0x01b1, B:77:0x0276, B:79:0x02cd, B:87:0x0303, B:89:0x032a, B:90:0x032f, B:92:0x0359, B:94:0x0378, B:95:0x0384, B:99:0x0397, B:101:0x039b, B:102:0x03a4, B:104:0x03aa, B:107:0x03b2, B:109:0x03bc, B:110:0x03d2, B:152:0x04f2, B:154:0x04f6, B:156:0x04fe, B:158:0x0506, B:160:0x0510, B:162:0x0518, B:164:0x0522, B:167:0x0533, B:169:0x0541, B:171:0x054b, B:173:0x0555, B:177:0x056b, B:178:0x0570, B:180:0x0574, B:182:0x0578, B:183:0x0581, B:111:0x03d7, B:113:0x03e1, B:115:0x03e5, B:116:0x0401, B:118:0x0405, B:119:0x040a, B:121:0x0414, B:122:0x041e, B:123:0x0423, B:125:0x042d, B:126:0x0438, B:127:0x0443, B:129:0x0456, B:130:0x0467, B:132:0x0472, B:133:0x0481, B:135:0x048b, B:137:0x048f, B:138:0x0495, B:140:0x049f, B:142:0x04a3, B:143:0x04a8, B:145:0x04b3, B:146:0x04b6, B:148:0x04ba, B:150:0x04cb, B:151:0x04d7, B:80:0x02d8, B:82:0x02de, B:84:0x02e8, B:86:0x02ee, B:67:0x021f, B:69:0x0227, B:72:0x0263, B:74:0x026b, B:75:0x0270, B:34:0x00d3, B:36:0x00db, B:38:0x00e3, B:40:0x00e7, B:42:0x00eb, B:45:0x00f4, B:47:0x0140, B:50:0x0147, B:52:0x014f, B:53:0x0158, B:19:0x0071, B:12:0x003c), top: B:192:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0393 A[ADDED_TO_REGION] */
    @Override // com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void playWithPlayInfo(com.youku.playerservice.axp.playinfo.PlayInfo r12) {
        /*
            Method dump skipped, instructions count: 1421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.player.PlayerImpl.playWithPlayInfo(com.youku.playerservice.axp.playinfo.PlayInfo):void");
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void release() {
        if (this.mPlayerTrack != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("stopFrom", "release");
            this.mPlayerTrack.onStop(hashMap);
        }
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null && !this.mNotStopFlag) {
            if (iAlixPlayer instanceof AndroidXPlayer) {
                iAlixPlayer.release();
            } else if (this.mPlayInfo != null) {
                C7792a.a(this.mContext).a(this.mAlixPlayer);
                TLogUtil.loge(CacheManager.TAG_PLAYER, "player:release");
                TLogUtil.loge(CacheManager.TAG_PLAYER, "returnAlixPlayer: " + this.mAlixPlayer.hashCode() + " id:" + this.mAlixPlayer.getPlayerId() + "|||TotalleftInusePlayer-" + C7792a.a(this.mContext).a());
            }
        }
    }

    public void replayWithRequest(Map<String, String> map) {
        if (this.mInternalPlayerEventListener != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(map);
            this.mInternalPlayerEventListener.onNotify("replayWithRequest", hashMap);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void seekTo(int i, boolean z) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            if (z) {
                iAlixPlayer.seekTo(i, 1);
            } else {
                iAlixPlayer.seekTo(i, 0);
            }
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public void setAutoPlay(boolean z) {
        this.mIsAutoPlay = z;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setDisplay(Surface surface) {
        this.mSurface = surface;
        if (this.mAlixPlayer != null) {
            PlayerTrack playerTrack = this.mPlayerTrack;
            if (playerTrack != null) {
                playerTrack.putTimestamp("setDisplayTs", System.currentTimeMillis());
            }
            this.mAlixPlayer.setDisplay(surface);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public int setFilter(int i, Map<String, String> map) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer == null) {
            return -1;
        }
        return iAlixPlayer.setFilter(i, map);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol
    public void setInternalPlayEventListener(InternalPlayerEventListener internalPlayerEventListener) {
        this.mInternalPlayerEventListener = internalPlayerEventListener;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setLooping(boolean z) {
        this.mIsLoopPlay = z;
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null && iAlixPlayer.getCurrentState() == IAlixPlayer.State.STATE_VIDEO_STARTED) {
            this.mAlixPlayer.setIsLoopPlay(this.mIsLoopPlay);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setMaxZoomScale(float f) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setZoom(4, f, 0.0d, 0.0d);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setMuted(boolean z) {
        this.mIsMuted = z;
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setMute(this.mIsMuted);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setPlaySpeed(double d) {
        this.mPlaySpeed = d;
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setPlaySpeed(this.mPlaySpeed);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setPlaybackParam(int i, String str) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setPlaybackParam(i, str);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setVolume(float f) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setVolume(f);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void setZoom(int i, double d, double d2, double d3) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setZoom(i, d, d2, d3);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void showZoomPickWind(int i, float f, float f2, float f3, float f4) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.setZoomPickWind(0, i, f, f2, f3, f4);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void skipAD(int i) {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.skipAd(i);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void start() {
        PlayerTrack playerTrack = this.mPlayerTrack;
        if (playerTrack != null) {
            playerTrack.onStart();
        }
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null) {
            iAlixPlayer.start();
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerProtocol
    public synchronized void stop() {
        IAlixPlayer iAlixPlayer = this.mAlixPlayer;
        if (iAlixPlayer != null && iAlixPlayer.getCurrentState() != IAlixPlayer.State.STATE_STOPPED && this.mAlixPlayer.getCurrentState() != IAlixPlayer.State.STATE_RELEASED) {
            if (!this.mNotStopFlag) {
                this.mAlixPlayer.stop();
                TLogUtil.loge(CacheManager.TAG_PLAYER, "player:stop");
                this.mAlixPlayer.reset();
            }
            this.mAlixPlayer.setHolder(null);
            this.mAlixPlayer.setDisplay(null);
        }
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayerImplProtocol
    public synchronized void switchPlayItem(PlayItem playItem) {
        if (((UpsMediaSource) this.mMediaSource).switchDataSource((VodItem) playItem, getCurrentPosition() + 10000) != 0) {
            this.mInternalPlayerEventListener.onQualityChangeFinish(false, null);
        }
    }
}
