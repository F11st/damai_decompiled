package com.youku.live.dsl.pages;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.DrawableRes;
import com.youku.live.dsl.network.INetCallback;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface ILaifengManagerInterface {
    void clearPrePlay(Activity activity);

    @DrawableRes
    int getDefaultCoverDrawable(boolean z);

    void handleLaifengReoprtParmas(Context context, Map<String, Object> map);

    boolean isLaifeng(Uri uri, Bundle bundle);

    String parseParams(Uri uri, Bundle bundle);

    void registerAll(Application application);

    boolean registerCallback(String str, INetCallback iNetCallback);

    int[][] requestPreloadLayoutIds();

    boolean startPrePlay(Activity activity, ViewGroup viewGroup);
}
