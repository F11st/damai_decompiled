package cn.damai.player.video.listener;

import cn.damai.commonbusiness.imagebrowse.bean.VideoInfo;
import cn.damai.player.video.view.ApiPlayer;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public interface VideoEventListener {
    void onVideoEnd(ApiPlayer apiPlayer, VideoInfo videoInfo, int i);

    void onVideoPlay(ApiPlayer apiPlayer, VideoInfo videoInfo, int i);
}
