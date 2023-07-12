package com.youku.alixplayer.instances.System;

import android.util.Log;
import com.youku.alixplayer.EventType;
import com.youku.alixplayer.IAlixPlayer;
import com.youku.alixplayer.IMediaSource;
import com.youku.alixplayer.IPeriod;
import com.youku.alixplayer.IPlaylist;
import com.youku.alixplayer.OnStateChangeListener;
import com.youku.alixplayer.instances.System.model.SystemPlayList;
import com.youku.alixplayer.instances.System.playState.APIState;
import com.youku.alixplayer.instances.System.playState.APStateError;
import com.youku.alixplayer.instances.System.playState.APStateIdle;
import com.youku.alixplayer.instances.System.playState.APStateMidAdPaused;
import com.youku.alixplayer.instances.System.playState.APStateMidAdStarted;
import com.youku.alixplayer.instances.System.playState.APStatePostAdCompleted;
import com.youku.alixplayer.instances.System.playState.APStatePostAdPaused;
import com.youku.alixplayer.instances.System.playState.APStatePostAdStarted;
import com.youku.alixplayer.instances.System.playState.APStatePreAdPaused;
import com.youku.alixplayer.instances.System.playState.APStatePreAdStarted;
import com.youku.alixplayer.instances.System.playState.APStatePreVipPaused;
import com.youku.alixplayer.instances.System.playState.APStatePreVipStarted;
import com.youku.alixplayer.instances.System.playState.APStatePrepared;
import com.youku.alixplayer.instances.System.playState.APStatePreparing;
import com.youku.alixplayer.instances.System.playState.APStateReleased;
import com.youku.alixplayer.instances.System.playState.APStateSourceFailed;
import com.youku.alixplayer.instances.System.playState.APStateSourceGeting;
import com.youku.alixplayer.instances.System.playState.APStateSourceReady;
import com.youku.alixplayer.instances.System.playState.APStateStarting;
import com.youku.alixplayer.instances.System.playState.APStateStopped;
import com.youku.alixplayer.instances.System.playState.APStateVideoCompleted;
import com.youku.alixplayer.instances.System.playState.APStateVideoPaused;
import com.youku.alixplayer.instances.System.playState.APStateVideoStarted;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AndroidPlayerStateMachine implements IMediaSource.OnMediaSourceUpdatedListener {
    private static final String TAG = "PlayerStateMachine";
    private AndroidPlayer mAndroidPlayer;
    private SystemPlayerQueue mPlayerQueue;
    private SystemPlayList mPlaylist;
    private OnStateChangeListener mStateChangeListener;
    private APStateIdle mStateIdle = new APStateIdle();
    private APStateSourceGeting mStateSourceGetting = new APStateSourceGeting();
    private APStateSourceReady mStateSourceReady = new APStateSourceReady();
    private APStateSourceFailed mStateSourceFailed = new APStateSourceFailed();
    private APStatePreparing mStatePreparing = new APStatePreparing();
    private APStatePrepared mStatePrepared = new APStatePrepared();
    private APStateStarting mStateStarting = new APStateStarting();
    private APStateVideoStarted mStateVideoStarted = new APStateVideoStarted();
    private APStateVideoPaused mStateVideoPaused = new APStateVideoPaused();
    private APStateVideoCompleted mStateVideoCompleted = new APStateVideoCompleted();
    private APStatePreAdStarted mStatePreAdStarted = new APStatePreAdStarted();
    private APStatePreAdPaused mStatePreAdPaused = new APStatePreAdPaused();
    private APStateMidAdPaused mStateMidAdPaused = new APStateMidAdPaused();
    private APStateMidAdStarted mStateMidAdStarted = new APStateMidAdStarted();
    private APStatePostAdStarted mStatePostAdStarted = new APStatePostAdStarted();
    private APStatePostAdPaused mStatePostAdPaused = new APStatePostAdPaused();
    private APStatePostAdCompleted mStatePostAdCompleted = new APStatePostAdCompleted();
    private APStateStopped mStateStopped = new APStateStopped();
    private APStateReleased mStateReleased = new APStateReleased();
    private APStateError mStateError = new APStateError();
    private APStatePreVipStarted mStatePreVipStarted = new APStatePreVipStarted();
    private APStatePreVipPaused mStatePreVipPaused = new APStatePreVipPaused();
    private APIState mCurrentState = this.mStateIdle;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.youku.alixplayer.instances.System.AndroidPlayerStateMachine$1  reason: invalid class name */
    /* loaded from: classes.dex */
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
        APStateError aPStateError = this.mStateError;
        this.mCurrentState = aPStateError;
        aPStateError.enterAction(state);
    }

    private void handleOnMidAdStart(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] != 15) {
            return;
        }
        this.mCurrentState.outerAction();
        APStateMidAdStarted aPStateMidAdStarted = this.mStateMidAdStarted;
        this.mCurrentState = aPStateMidAdStarted;
        aPStateMidAdStarted.enterAction(state);
    }

    private void handleOnPostAdCompleted(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] != 18) {
            return;
        }
        this.mCurrentState.outerAction();
        APStatePostAdCompleted aPStatePostAdCompleted = this.mStatePostAdCompleted;
        this.mCurrentState = aPStatePostAdCompleted;
        aPStatePostAdCompleted.enterAction(state);
    }

    private void handleOnPostAdStart(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] != 19) {
            return;
        }
        this.mCurrentState.outerAction();
        APStatePostAdStarted aPStatePostAdStarted = this.mStatePostAdStarted;
        this.mCurrentState = aPStatePostAdStarted;
        aPStatePostAdStarted.enterAction(state);
    }

    private void handleOnPreAdStart(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 1 || i == 2 || i == 16) {
            this.mCurrentState.outerAction();
            APStatePreAdStarted aPStatePreAdStarted = this.mStatePreAdStarted;
            this.mCurrentState = aPStatePreAdStarted;
            aPStatePreAdStarted.enterAction(state);
        }
    }

    private void handleOnPrepared(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] != 9) {
            return;
        }
        this.mCurrentState.outerAction();
        APStatePrepared aPStatePrepared = this.mStatePrepared;
        this.mCurrentState = aPStatePrepared;
        aPStatePrepared.enterAction(state);
    }

    private void handleOnSourceFailed(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] != 7) {
            return;
        }
        this.mCurrentState.outerAction();
        APStateSourceFailed aPStateSourceFailed = this.mStateSourceFailed;
        this.mCurrentState = aPStateSourceFailed;
        aPStateSourceFailed.enterAction(state);
    }

    private void handleOnSourceReady(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] != 7) {
            return;
        }
        Log.d(TAG, "handleOnSourceReady");
        this.mCurrentState.outerAction();
        APStateSourceReady aPStateSourceReady = this.mStateSourceReady;
        this.mCurrentState = aPStateSourceReady;
        aPStateSourceReady.enterAction(state);
    }

    private void handleOnVideoCompleted(IAlixPlayer.State state) {
        if (AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()] != 15) {
            return;
        }
        this.mCurrentState.outerAction();
        APStateVideoCompleted aPStateVideoCompleted = this.mStateVideoCompleted;
        this.mCurrentState = aPStateVideoCompleted;
        aPStateVideoCompleted.enterAction(state);
    }

    private void handleOnVideoStart(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 1 || i == 2 || i == 3 || i == 16 || i == 17) {
            this.mCurrentState.outerAction();
            APStateVideoStarted aPStateVideoStarted = this.mStateVideoStarted;
            this.mCurrentState = aPStateVideoStarted;
            aPStateVideoStarted.enterAction(state);
        }
    }

    private void handlePause(IAlixPlayer.State state) {
        APIState aPIState;
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i != 3) {
            switch (i) {
                case 15:
                    this.mCurrentState.outerAction();
                    aPIState = this.mStateVideoPaused;
                    break;
                case 16:
                    this.mCurrentState.outerAction();
                    aPIState = this.mStatePreVipPaused;
                    break;
                case 17:
                    this.mCurrentState.outerAction();
                    aPIState = this.mStateMidAdPaused;
                    break;
                case 18:
                    this.mCurrentState.outerAction();
                    aPIState = this.mStatePostAdPaused;
                    break;
                default:
                    return;
            }
        } else {
            this.mCurrentState.outerAction();
            aPIState = this.mStatePreAdPaused;
        }
        this.mCurrentState = aPIState;
        aPIState.enterAction(state);
    }

    private void handlePreVipStart(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            this.mCurrentState.outerAction();
            APStatePreVipStarted aPStatePreVipStarted = this.mStatePreVipStarted;
            this.mCurrentState = aPStatePreVipStarted;
            aPStatePreVipStarted.enterAction(state);
        }
    }

    private void handlePrepare(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 5 || i == 8) {
            this.mCurrentState.outerAction();
            this.mCurrentState = this.mStatePreparing;
            SystemPlayerQueue systemPlayerQueue = this.mPlayerQueue;
            if (systemPlayerQueue != null && systemPlayerQueue.getActiveItem() != null && !this.mPlayerQueue.getActiveItem().isOnprepared()) {
                this.mCurrentState.enterAction(state);
                return;
            }
            this.mStateChangeListener.onStateChange(IAlixPlayer.State.STATE_SOURCE_READY, IAlixPlayer.State.STATE_PREPARING);
            handleEvent(EventType.ON_PREPARED);
        }
    }

    private void handleRelease(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 4 || i == 7 || i == 20) {
            return;
        }
        this.mCurrentState.outerAction();
        APStateReleased aPStateReleased = this.mStateReleased;
        this.mCurrentState = aPStateReleased;
        aPStateReleased.enterAction(state);
    }

    private void handleSetDataSource(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 4 || i == 5 || i == 6) {
            this.mCurrentState.outerAction();
            APStateSourceGeting aPStateSourceGeting = this.mStateSourceGetting;
            this.mCurrentState = aPStateSourceGeting;
            aPStateSourceGeting.enterAction(state);
        }
    }

    private void handleStart(IAlixPlayer.State state) {
        APIState aPIState;
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i != 2) {
            switch (i) {
                case 10:
                    this.mCurrentState.outerAction();
                    aPIState = this.mStateVideoStarted;
                    break;
                case 11:
                    this.mCurrentState.outerAction();
                    aPIState = this.mStatePreAdStarted;
                    break;
                case 12:
                    this.mCurrentState.outerAction();
                    aPIState = this.mStatePreVipStarted;
                    break;
                case 13:
                    this.mCurrentState.outerAction();
                    aPIState = this.mStateMidAdStarted;
                    break;
                case 14:
                    this.mCurrentState.outerAction();
                    aPIState = this.mStatePostAdStarted;
                    break;
                default:
                    return;
            }
        } else {
            this.mCurrentState.outerAction();
            aPIState = this.mStateStarting;
        }
        this.mCurrentState = aPIState;
        aPIState.enterAction(state);
    }

    private void handleStop(IAlixPlayer.State state) {
        int i = AnonymousClass1.$SwitchMap$com$youku$alixplayer$IAlixPlayer$State[state.ordinal()];
        if (i == 4 || i == 7 || i == 20) {
            return;
        }
        this.mCurrentState.outerAction();
        APStateStopped aPStateStopped = this.mStateStopped;
        this.mCurrentState = aPStateStopped;
        aPStateStopped.enterAction(state);
    }

    public IAlixPlayer.State getCurrentState() {
        return this.mCurrentState.getState();
    }

    public IPlaylist getPlaylist() {
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
        SystemPlayList systemPlayList = (SystemPlayList) iPlaylist;
        this.mPlaylist = systemPlayList;
        this.mStateSourceReady.setPlaylist(systemPlayList);
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
        this.mAndroidPlayer.changePeriod();
    }

    public void setAndroidPlayer(AndroidPlayer androidPlayer) {
        this.mAndroidPlayer = androidPlayer;
        this.mStateSourceReady.setAndroidPlayer(androidPlayer);
        this.mStatePreparing.setAndroidPlayer(androidPlayer);
        this.mStateStarting.setAndroidPlayer(androidPlayer);
        this.mStateVideoStarted.setAndroidPlayer(androidPlayer);
        this.mStatePreVipStarted.setAndroidPlayer(androidPlayer);
        this.mStatePreVipPaused.setAndroidPlayer(androidPlayer);
        this.mStateVideoPaused.setAndroidPlayer(androidPlayer);
        this.mStatePreAdStarted.setAndroidPlayer(androidPlayer);
        this.mStatePreAdPaused.setAndroidPlayer(androidPlayer);
        this.mStateMidAdStarted.setAndroidPlayer(androidPlayer);
        this.mStateMidAdPaused.setAndroidPlayer(androidPlayer);
        this.mStatePostAdStarted.setAndroidPlayer(androidPlayer);
        this.mStatePostAdPaused.setAndroidPlayer(androidPlayer);
        this.mStateReleased.setAndroidPlayer(androidPlayer);
        this.mStateStopped.setAndroidPlayer(androidPlayer);
    }

    public void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.mStateChangeListener = onStateChangeListener;
    }

    public void setPlayerQueue(SystemPlayerQueue systemPlayerQueue) {
        this.mPlayerQueue = systemPlayerQueue;
    }
}
