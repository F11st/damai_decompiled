package com.youku.uplayer;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class AudioSplit {
    AliMediaPlayer aliMediaPlayer = new AliMediaPlayer();

    public void end() {
        this.aliMediaPlayer.mediaSplitEnd();
    }

    public void mediaTranslateBegin(int i, String str, String str2, int i2, int i3, long j, long j2, OnMediaEditorProgressListener onMediaEditorProgressListener) {
        this.aliMediaPlayer.setMediaEditorProgressListener(onMediaEditorProgressListener);
        this.aliMediaPlayer.mediaTranslateBegin(i, str, str2, i2, i3, j, j2);
    }

    public void release() {
        this.aliMediaPlayer.release();
    }

    public void start(String str, String str2, int i, OnAudioSplitProgressListener onAudioSplitProgressListener) {
        this.aliMediaPlayer.setmOnAudioSplitProgressListener(onAudioSplitProgressListener);
        this.aliMediaPlayer.mediaSplitBegin(str, str2, i);
    }
}
