package com.youku.alixplayer.state;

import android.text.TextUtils;
import android.util.Log;
import com.youku.alixplayer.EventType;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.IMediaSource;
import com.youku.alixplayer.IPeriod;
import com.youku.alixplayer.IPlaylist;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.instances.Aliplayer;
import com.youku.alixplayer.instances.PlayerQueue;
import com.youku.alixplayer.model.Playlist;
import com.youku.media.arch.instruments.ConfigFetcher;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class PlayerStateMachine implements IMediaSource.OnMediaSourceUpdatedListener {
    private static final String TAG = "PlayerStateMachine";
    private Aliplayer mAliplayer;
    private PlayerQueue mPlayerQueue;
    private Playlist mPlaylist;
    private OnStateChangeListener mStateChangeListener;
    private StateIdle mStateIdle = new StateIdle();
    private StateSourceGeting mStateSourceGetting = new StateSourceGeting();
    private StateSourceReady mStateSourceReady = new StateSourceReady();
    private StateSourceFailed mStateSourceFailed = new StateSourceFailed();
    private StatePreparing mStatePreparing = new StatePreparing();
    private StatePrepared mStatePrepared = new StatePrepared();
    private StateStarting mStateStarting = new StateStarting();
    private StateVideoStarted mStateVideoStarted = new StateVideoStarted();
    private StateVideoPaused mStateVideoPaused = new StateVideoPaused();
    private StateVideoCompleted mStateVideoCompleted = new StateVideoCompleted();
    private StatePreAdStarted mStatePreAdStarted = new StatePreAdStarted();
    private StatePreAdPaused mStatePreAdPaused = new StatePreAdPaused();
    private StateMidAdPaused mStateMidAdPaused = new StateMidAdPaused();
    private StateMidAdStarted mStateMidAdStarted = new StateMidAdStarted();
    private StatePostAdStarted mStatePostAdStarted = new StatePostAdStarted();
    private StatePostAdPaused mStatePostAdPaused = new StatePostAdPaused();
    private StatePostAdCompleted mStatePostAdCompleted = new StatePostAdCompleted();
    private StateStopped mStateStopped = new StateStopped();
    private StateReleased mStateReleased = new StateReleased();
    private StateError mStateError = new StateError();
    private StatePreVipStarted mStatePreVipStarted = new StatePreVipStarted();
    private StatePreVipPaused mStatePreVipPaused = new StatePreVipPaused();
    private IState mCurrentState = this.mStateIdle;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.alixplayer.state.PlayerStateMachine$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$EventType;
        static final /* synthetic */ int[] $SwitchMap$com$youku$alixplayer$IAlixPlayer$State;

        static {
            int[] iArr = new int[IAlixPlayer.State.values().length];
            $SwitchMap$com$youku$alixplayer$IAlixPlayer$State = iArr;
            try {
                iArr[IAlixPlayer.State.STATE_STARTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PREPARED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PRE_AD_STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_IDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_STOPPED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_RELEASED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_SOURCE_GETTING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_SOURCE_READY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PREPARING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_VIDEO_PAUSED.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PRE_AD_PAUSED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PRE_VIP_PAUSED.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_MID_AD_PAUSED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_POST_AD_PAUSED.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_VIDEO_STARTED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_PRE_VIP_STARTED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_MID_AD_STARTED.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_POST_AD_STARTED.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_VIDEO_COMPLETED.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$IAlixPlayer$State[IAlixPlayer.State.STATE_SOURCE_FAILED.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            int[] iArr2 = new int[EventType.values().length];
            $SwitchMap$com$youku$alixplayer$EventType = iArr2;
            try {
                iArr2[EventType.SET_DATASOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_INFO_READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_INFO_FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.PREPARE.ordinal()] = 4;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.START.ordinal()] = 5;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_VIDEO_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_PRE_AD_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_PRE_VIP_START.ordinal()] = 8;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_MID_AD_START.ordinal()] = 9;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_POST_AD_START.ordinal()] = 10;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_VIDEO_COMPLETION.ordinal()] = 11;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_POST_AD_COMPLETION.ordinal()] = 12;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_ERROR.ordinal()] = 13;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.PAUSE.ordinal()] = 14;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.RELEASE.ordinal()] = 15;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.ON_PREPARED.ordinal()] = 16;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$youku$alixplayer$EventType[EventType.STOP.ordinal()] = 17;
            } catch (NoSuchFieldError unused37) {
            }
        }
    }

    private void handleOnError(IAlixPlayer.State state) {
        this.mCurrentState.outerAction();
        StateError stateError = this.mStateError;
        this.mCurrentState = stateError;
        stateError.enterAction(state);
    }

    private void handleOnMidAdStart(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] != 15) {
            return;
        }
        this.mCurrentState.outerAction();
        StateMidAdStarted stateMidAdStarted = this.mStateMidAdStarted;
        this.mCurrentState = stateMidAdStarted;
        stateMidAdStarted.enterAction(state);
    }

    private void handleOnPostAdCompleted(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] != 18) {
            return;
        }
        this.mCurrentState.outerAction();
        StatePostAdCompleted statePostAdCompleted = this.mStatePostAdCompleted;
        this.mCurrentState = statePostAdCompleted;
        statePostAdCompleted.enterAction(state);
    }

    private void handleOnPostAdStart(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] != 19) {
            return;
        }
        this.mCurrentState.outerAction();
        StatePostAdStarted statePostAdStarted = this.mStatePostAdStarted;
        this.mCurrentState = statePostAdStarted;
        statePostAdStarted.enterAction(state);
    }

    private void handleOnPreAdStart(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 1 || i == 2 || i == 16) {
            this.mCurrentState.outerAction();
            StatePreAdStarted statePreAdStarted = this.mStatePreAdStarted;
            this.mCurrentState = statePreAdStarted;
            statePreAdStarted.enterAction(state);
        }
    }

    private void handleOnPrepared(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] != 9) {
            return;
        }
        this.mCurrentState.outerAction();
        StatePrepared statePrepared = this.mStatePrepared;
        this.mCurrentState = statePrepared;
        statePrepared.enterAction(state);
    }

    private void handleOnSourceFailed(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] != 7) {
            return;
        }
        this.mCurrentState.outerAction();
        StateSourceFailed stateSourceFailed = this.mStateSourceFailed;
        this.mCurrentState = stateSourceFailed;
        stateSourceFailed.enterAction(state);
    }

    private void handleOnSourceReady(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] != 7) {
            return;
        }
        Log.d(TAG, "handleOnSourceReady");
        this.mCurrentState.outerAction();
        StateSourceReady stateSourceReady = this.mStateSourceReady;
        this.mCurrentState = stateSourceReady;
        stateSourceReady.enterAction(state);
    }

    private void handleOnVideoCompleted(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] != 15) {
            return;
        }
        this.mCurrentState.outerAction();
        StateVideoCompleted stateVideoCompleted = this.mStateVideoCompleted;
        this.mCurrentState = stateVideoCompleted;
        stateVideoCompleted.enterAction(state);
    }

    private void handleOnVideoStart(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 16 || i == 17) {
            this.mCurrentState.outerAction();
            StateVideoStarted stateVideoStarted = this.mStateVideoStarted;
            this.mCurrentState = stateVideoStarted;
            stateVideoStarted.enterAction(state);
        }
    }

    private void handlePause(IAlixPlayer.State state) {
        IState iState;
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i != 3) {
            switch (i) {
                case 15:
                    this.mCurrentState.outerAction();
                    iState = this.mStateVideoPaused;
                    break;
                case 16:
                    this.mCurrentState.outerAction();
                    iState = this.mStatePreVipPaused;
                    break;
                case 17:
                    this.mCurrentState.outerAction();
                    iState = this.mStateMidAdPaused;
                    break;
                case 18:
                    this.mCurrentState.outerAction();
                    iState = this.mStatePostAdPaused;
                    break;
                default:
                    return;
            }
        } else {
            this.mCurrentState.outerAction();
            iState = this.mStatePreAdPaused;
        }
        this.mCurrentState = iState;
        iState.enterAction(state);
    }

    private void handlePreVipStart(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            this.mCurrentState.outerAction();
            StatePreVipStarted statePreVipStarted = this.mStatePreVipStarted;
            this.mCurrentState = statePreVipStarted;
            statePreVipStarted.enterAction(state);
        }
    }

    private void handlePrepare(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 5 || i == 8) {
            this.mCurrentState.outerAction();
            this.mCurrentState = this.mStatePreparing;
            PlayerQueue playerQueue = this.mPlayerQueue;
            if (playerQueue != null && playerQueue.getActiveItem() != null && !this.mPlayerQueue.getActiveItem().isOnprepared()) {
                this.mCurrentState.enterAction(state);
                return;
            }
            this.mStateChangeListener.onStateChange(IAlixPlayer.State.STATE_SOURCE_READY, IAlixPlayer.State.STATE_PREPARING);
            handleEvent(EventType.ON_PREPARED);
        }
    }

    private void handleRelease(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i != 4 && i != 7 && i != 20) {
            this.mCurrentState.outerAction();
            StateReleased stateReleased = this.mStateReleased;
            this.mCurrentState = stateReleased;
            stateReleased.enterAction(state);
            return;
        }
        String config = ConfigFetcher.getInstance().getConfig("player_axp_config", "enable_sourcegetting_handle_stop", "1");
        if (TextUtils.isEmpty(config) || !"1".equals(config)) {
            return;
        }
        this.mCurrentState = this.mStateReleased;
    }

    private void handleSetDataSource(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 4 || i == 5 || i == 6) {
            this.mCurrentState.outerAction();
            StateSourceGeting stateSourceGeting = this.mStateSourceGetting;
            this.mCurrentState = stateSourceGeting;
            stateSourceGeting.enterAction(state);
        }
    }

    private void handleStart(IAlixPlayer.State state) {
        IState iState;
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i != 2) {
            switch (i) {
                case 10:
                    this.mCurrentState.outerAction();
                    iState = this.mStateVideoStarted;
                    break;
                case 11:
                    this.mCurrentState.outerAction();
                    iState = this.mStatePreAdStarted;
                    break;
                case 12:
                    this.mCurrentState.outerAction();
                    iState = this.mStatePreVipStarted;
                    break;
                case 13:
                    this.mCurrentState.outerAction();
                    iState = this.mStateMidAdStarted;
                    break;
                case 14:
                    this.mCurrentState.outerAction();
                    iState = this.mStatePostAdStarted;
                    break;
                default:
                    return;
            }
        } else {
            this.mCurrentState.outerAction();
            iState = this.mStateStarting;
        }
        this.mCurrentState = iState;
        iState.enterAction(state);
    }

    private void handleStop(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i != 4 && i != 7 && i != 20) {
            this.mCurrentState.outerAction();
            StateStopped stateStopped = this.mStateStopped;
            this.mCurrentState = stateStopped;
            stateStopped.enterAction(state);
            return;
        }
        String config = ConfigFetcher.getInstance().getConfig("player_axp_config", "enable_sourcegetting_handle_stop", "1");
        if (TextUtils.isEmpty(config) || !"1".equals(config)) {
            return;
        }
        this.mCurrentState = this.mStateStopped;
    }

    public IAlixPlayer.State getCurrentState() {
        return this.mCurrentState.getState();
    }

    public Playlist getPlaylist() {
        return this.mPlaylist;
    }

    public void handleEvent(EventType eventType) {
        IAlixPlayer.State state = this.mCurrentState.getState();
        switch (AnonymousClass1.$SwitchMap$com$youku$alixplayer$EventType[eventType.ordinal()]) {
            case 1:
                handleSetDataSource(state);
                break;
            case 2:
                handleOnSourceReady(state);
                break;
            case 3:
                handleOnSourceFailed(state);
                break;
            case 4:
                handlePrepare(state);
                break;
            case 5:
                handleStart(state);
                break;
            case 6:
                handleOnVideoStart(state);
                break;
            case 7:
                handleOnPreAdStart(state);
                break;
            case 8:
                handlePreVipStart(state);
                break;
            case 9:
                handleOnMidAdStart(state);
                break;
            case 10:
                handleOnPostAdStart(state);
                break;
            case 11:
                handleOnVideoCompleted(state);
                break;
            case 12:
                handleOnPostAdCompleted(state);
                break;
            case 13:
                handleOnError(state);
                break;
            case 14:
                handlePause(state);
                break;
            case 15:
                handleRelease(state);
                break;
            case 16:
                handleOnPrepared(state);
                break;
            case 17:
                handleStop(state);
                break;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("handleEvent: event=");
        sb.append(eventType);
        sb.append(",AliPlayer:");
        Aliplayer aliplayer = this.mAliplayer;
        sb.append(aliplayer != null ? aliplayer.toString() : "null");
        sb.append(" SourceState=");
        sb.append(state);
        sb.append(", DestState=");
        sb.append(this.mCurrentState.getState());
        Log.d(TAG, sb.toString());
        if (this.mStateChangeListener == null || this.mCurrentState.getState() == state) {
            return;
        }
        this.mStateChangeListener.onStateChange(state, this.mCurrentState.getState());
    }

    @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
    public void onPeriodUpdate(int i, IPeriod iPeriod) {
    }

    @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
    public void onPlaylistFailed() {
        handleEvent(EventType.ON_INFO_FAILED);
    }

    @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
    public void onPlaylistPrepared(IMediaSource iMediaSource, IPlaylist iPlaylist) {
        Log.d(TAG, "onPlaylistPrepared");
        Playlist playlist = (Playlist) iPlaylist;
        this.mPlaylist = playlist;
        this.mStateSourceReady.setPlaylist(playlist);
        if (this.mPlayerQueue.get(iMediaSource.getSourceKey()) == null || !this.mPlayerQueue.get(iMediaSource.getSourceKey()).isOnprepared()) {
            handleEvent(EventType.ON_INFO_READY);
            return;
        }
        iMediaSource.deinit();
        Log.d(TAG, "onPlaylistPrepared: hit preload-aliplayer send source ready");
        this.mCurrentState = this.mStateSourceReady;
        this.mStateChangeListener.onStateChange(IAlixPlayer.State.STATE_SOURCE_GETTING, IAlixPlayer.State.STATE_SOURCE_READY);
    }

    @Override // com.youku.alixplayer.IMediaSource.OnMediaSourceUpdatedListener
    public void onPlaylistUpdate(IPlaylist iPlaylist) {
    }

    public void setAliplayer(Aliplayer aliplayer) {
        this.mAliplayer = aliplayer;
        this.mStateSourceReady.setAliplayer(aliplayer);
        this.mStatePreparing.setAliplayer(aliplayer);
        this.mStateStarting.setAliplayer(aliplayer);
        this.mStateVideoStarted.setAliplayer(aliplayer);
        this.mStatePreVipStarted.setAliplayer(aliplayer);
        this.mStatePreVipPaused.setAliplayer(aliplayer);
        this.mStateVideoPaused.setAliplayer(aliplayer);
        this.mStatePreAdStarted.setAliplayer(aliplayer);
        this.mStatePreAdPaused.setAliplayer(aliplayer);
        this.mStateMidAdStarted.setAliplayer(aliplayer);
        this.mStateMidAdPaused.setAliplayer(aliplayer);
        this.mStatePostAdStarted.setAliplayer(aliplayer);
        this.mStatePostAdPaused.setAliplayer(aliplayer);
        this.mStateReleased.setAliplayer(aliplayer);
        this.mStateStopped.setAliplayer(aliplayer);
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mStateChangeListener = onStateChangeListener;
    }

    public void setPlayerQueue(PlayerQueue playerQueue) {
        this.mPlayerQueue = playerQueue;
    }
}
