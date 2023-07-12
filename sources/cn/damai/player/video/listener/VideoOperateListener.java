package cn.damai.player.video.listener;

import androidx.annotation.Nullable;
import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface VideoOperateListener {
    void onMuteClick(@Nullable VideoInfo videoInfo, boolean z);

    void onPlayClick(@Nullable VideoInfo videoInfo);
}
