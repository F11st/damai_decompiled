package com.youku.live.dsl.pages;

import android.content.Context;
import android.view.View;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IYoukuLiveFactoryInterface {
    <T extends View & IYoukuLiveInterface> T createYoukuLiveView(Context context, LiveFullInfoData liveFullInfoData);
}
