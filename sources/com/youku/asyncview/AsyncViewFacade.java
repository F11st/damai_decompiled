package com.youku.asyncview;

import android.app.Activity;
import android.content.Context;
import com.youku.asyncview.core.AsyncViewManager;
import com.youku.asyncview.utils.AssertUtil;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class AsyncViewFacade implements Serializable {
    public static IAsyncViewManager createAsyncViewManager(Context context) {
        AssertUtil.throwIf(context == null);
        return new AsyncViewManager(context);
    }

    public static Activity getActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ViewContext) {
            Context currentContext = ((ViewContext) context).getCurrentContext();
            if (currentContext instanceof Activity) {
                return (Activity) currentContext;
            }
            return null;
        }
        return null;
    }
}
