package com.taobao.android.dinamicx.videoc.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDXVideoManager<VideoData, Video> {
    Collection<Video> appendVideoData(@NonNull String str, @NonNull VideoData videodata);

    List<Video> clearQueue(@NonNull String str);

    Map<String, List<Video>> clearQueue();

    boolean containsVideo(@NonNull String str, @NonNull Video video);

    @Nullable
    List<Video> currentVideo(@NonNull String str);

    Collection<Video> deleteVideoData(@NonNull String str, @NonNull VideoData videodata);

    int getVideoPositionInContainer(@NonNull String str, @NonNull Video video);

    List<Video> getVideos(@NonNull String str);

    boolean isLoop();

    Video lastVideoInQueue(@NonNull String str);

    Video nextVideo(@NonNull String str, @NonNull Video video);

    Video peekNextVideo(@NonNull String str, @NonNull Video video);

    Collection<Video> refreshQueue(@NonNull String str, @NonNull List<VideoData> list);

    Collection<String> scenes();

    Video skipCurrentVideo(@NonNull String str, @NonNull Video video);
}
