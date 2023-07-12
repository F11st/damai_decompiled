package com.youku.live.livesdk.widgets.container.pagable;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.widgets.helper.ConfigHelper;
import java.util.LinkedList;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LiveViewCacher<ContentViewType extends View> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int MODE_DEFAULT = 0;
    public static final int MODE_DISABLE_RECYCLER_CACHE = 1;
    public static final int MODE_ENABLE_LIVE_ROOM_CACHE = 2;
    private LinkedList<ContentViewType> contentViewCacher;

    private LinkedList<ContentViewType> getContentViewCacher() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2121440459")) {
            return (LinkedList) ipChange.ipc$dispatch("2121440459", new Object[]{this});
        }
        if (this.contentViewCacher == null) {
            synchronized (this) {
                if (this.contentViewCacher == null) {
                    this.contentViewCacher = new LinkedList<>();
                }
            }
        }
        return this.contentViewCacher;
    }

    public static int getMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-81241783") ? ((Integer) ipChange.ipc$dispatch("-81241783", new Object[0])).intValue() : ConfigHelper.getInteger("live_platform_issues", "disableRecyclerCache", 1);
    }

    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-884964395")) {
            ipChange.ipc$dispatch("-884964395", new Object[]{this});
        } else {
            getContentViewCacher().clear();
        }
    }

    public ContentViewType getCacheView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1665481044")) {
            return (ContentViewType) ipChange.ipc$dispatch("-1665481044", new Object[]{this});
        }
        try {
            return getContentViewCacher().pollFirst();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void recyclerView(ContentViewType contentviewtype) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "119466075")) {
            ipChange.ipc$dispatch("119466075", new Object[]{this, contentviewtype});
        } else if (contentviewtype == null) {
        } else {
            getContentViewCacher().push(contentviewtype);
        }
    }
}
