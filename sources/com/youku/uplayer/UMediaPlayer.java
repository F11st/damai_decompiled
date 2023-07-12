package com.youku.uplayer;

import android.view.SurfaceHolder;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes3.dex */
public class UMediaPlayer extends OriginalMediaPlayer {
    private static final String TAG = "UMediaPlayer";

    /* compiled from: Taobao */
    @Deprecated
    /* loaded from: classes3.dex */
    public static class MsgID {
        public static final int ERROR_NETWORK_CHECK_10 = 503;
        public static final int MEDIA_BUFFERING_UPDATE = 3;
        public static final int MEDIA_ERROR = 100;
        public static final int MEDIA_INFO_AD_CONNECT_DELAY = 1098;
        public static final int MEDIA_INFO_AD_COUNT_DOWN = 1040;
        public static final int MEDIA_INFO_AD_HTTP_ERROR_4XX = 1110;
        public static final int MEDIA_INFO_BUFFERING_UPDATE = 1031;
        public static final int MEDIA_INFO_BUFFER_PERCENT = 2301;
        public static final int MEDIA_INFO_COMPLETED = 1001;
        public static final int MEDIA_INFO_CPU_USAGE = 2302;
        public static final int MEDIA_INFO_CURRENT_INDEX = 2400;
        public static final int MEDIA_INFO_CURRENT_POSITION_UPDATE = 2000;
        public static final int MEDIA_INFO_DATA_SOURCE_ERROR = 1006;
        public static final int MEDIA_INFO_DROP_VIDEO_FRAMES = 1050;
        public static final int MEDIA_INFO_END_LOADING = 1004;
        public static final int MEDIA_INFO_FRAMERATE_AUDIO = 901;
        public static final int MEDIA_INFO_FRAMERATE_VIDEO = 900;
        public static final int MEDIA_INFO_HTTP_AD_302_DELAY = 1100;
        public static final int MEDIA_INFO_HTTP_REDIRECT_TYPE = 2110;
        public static final int MEDIA_INFO_HTTP_VIDEO_302_DELAY = 1101;
        public static final int MEDIA_INFO_HW_DECODE_ERROR = 30000;
        public static final int MEDIA_INFO_HW_PLAYER_ERROR = 30001;
        public static final int MEDIA_INFO_INDEX_AND_CDN_IP = 2008;
        public static final int MEDIA_INFO_INDEX_AND_REAL_IP = 2009;
        public static final int MEDIA_INFO_MIDAD_DATA_SOURCE_ERROR = 2201;
        public static final int MEDIA_INFO_MID_AD_END = 1014;
        public static final int MEDIA_INFO_MID_AD_LOADING_START = 1020;
        public static final int MEDIA_INFO_MID_AD_START = 1013;
        public static final int MEDIA_INFO_NETWORK_CHECK = 2004;
        public static final int MEDIA_INFO_NETWORK_DISSCONNECTED = 1005;
        public static final int MEDIA_INFO_NETWORK_ERROR = 1008;
        public static final int MEDIA_INFO_NETWORK_LOW = 1043;
        public static final int MEDIA_INFO_NETWORK_SPEED = 2300;
        public static final int MEDIA_INFO_NETWORK_SPEED_UPDATE = 2006;
        public static final int MEDIA_INFO_PLAYERROR = 1002;
        public static final int MEDIA_INFO_PREAD_PREPARE_ERROR = 2205;
        public static final int MEDIA_INFO_PREPARED = 1000;
        public static final int MEDIA_INFO_PREPARED_AD_CHECK = 2005;
        public static final int MEDIA_INFO_PREPARED_MID_AD_CHECK = 2200;
        public static final int MEDIA_INFO_PREPARE_ERROR = 1007;
        public static final int MEDIA_INFO_PREPARE_TIMEOUT_ERROR = 1010;
        public static final int MEDIA_INFO_PRE_AD_END = 1012;
        public static final int MEDIA_INFO_PRE_AD_START = 1011;
        public static final int MEDIA_INFO_REAL_CONNECT_TO_FIRST_FRAME_DELAY = 1103;
        public static final int MEDIA_INFO_RENDER_FIRST_FRAME_DELAY = 1102;
        public static final int MEDIA_INFO_SEEK_ERROR = 1009;
        public static final int MEDIA_INFO_SET_VIDEO_SIZE = 1030;
        public static final int MEDIA_INFO_START_LOADING = 1003;
        public static final int MEDIA_INFO_SWITCH_FAILED = 1022;
        public static final int MEDIA_INFO_SWITCH_FINISH = 1021;
        public static final int MEDIA_INFO_VIDEO_CONNECT_DELAY = 1099;
        public static final int MEDIA_INFO_VIDEO_END = 1018;
        public static final int MEDIA_INFO_VIDEO_HTTP_ERROR_4XX = 1111;
        public static final int MEDIA_INFO_VIDEO_START = 1017;
        public static final int MEDIA_NOP = 0;
        public static final int MEDIA_PLAYBACK_COMPLETE = 2;
        public static final int MEDIA_PREPARED = 1;
        public static final int MEDIA_PREPARE_PRE_AD_START = 8001;
        public static final int MEDIA_PREPARE_REAL_VIDEO_START = 8002;
        public static final int MEDIA_SEEK_COMPLETE = 4;
        public static final int MEDIA_SET_VIDEO_SIZE = 5;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public int getCurrentPosition() {
        return 0;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public int getDuration() {
        return 0;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public int getVideoHeight() {
        return 0;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public int getVideoWidth() {
        return 0;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public boolean isLooping() {
        return false;
    }

    @Override // com.youku.uplayer.Mediaplayer
    public boolean isPlaying() {
        return false;
    }

    @Override // com.youku.uplayer.OriginalMediaPlayer
    public void onSeekStart() {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void pause() {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void prepare() {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void prepareAsync() {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void release() {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void reset() {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void seekTo(int i) {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void setAudioStreamType(int i) {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void setDataSource(String str) {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void setScreenOnWhilePlaying(boolean z) {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void start() {
    }

    @Override // com.youku.uplayer.Mediaplayer
    public void stop() {
    }
}
