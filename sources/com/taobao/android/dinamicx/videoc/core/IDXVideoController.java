package com.taobao.android.dinamicx.videoc.core;

import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IDXVideoController<VideoData, Video> {
    void appendVideo(@NonNull VideoData videodata, @NonNull String str);

    void clearVideos();

    void clearVideos(@NonNull String str);

    void deleteVideo(@NonNull VideoData videodata, @NonNull String str);

    void deleteVideo(@NonNull VideoData videodata, @NonNull String str, boolean z);

    List<Video> getVideos(@NonNull String str);

    void playNextVideo(@NonNull Video video, @NonNull String str);

    Collection<String> scenes();

    void skipToNextVideo(@NonNull Video video, @NonNull String str);
}
