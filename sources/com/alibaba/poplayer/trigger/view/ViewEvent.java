package com.alibaba.poplayer.trigger.view;

import android.view.View;
import com.alibaba.poplayer.trigger.Event;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ViewEvent extends Event {
    private WeakReference<View> hostView;

    public ViewEvent(int i, String str, String str2, String str3, int i2) {
        super(i, str, str2, str3, i2);
    }

    public static ViewEvent createViewEvent(String str, String str2, String str3) {
        ViewEvent viewEvent = new ViewEvent(3, str, str2, str3, 2);
        int indexOf = viewEvent.uri.indexOf(63);
        boolean z = -1 == indexOf;
        String substring = z ? viewEvent.uri : viewEvent.uri.substring(0, indexOf);
        int i = viewEvent.uri.startsWith(d.VIEW_SCHEME) ? 1 : 2;
        boolean z2 = i == viewEvent.source;
        if (!z || !z2) {
            if (z2) {
                substring = viewEvent.uri;
            }
            viewEvent = new ViewEvent(2, substring, viewEvent.param, str3, i);
        }
        viewEvent.originUri = str;
        return viewEvent;
    }

    public WeakReference<View> getHostView() {
        return this.hostView;
    }

    public void setHostView(WeakReference<View> weakReference) {
        this.hostView = weakReference;
    }

    public ViewEvent(int i, String str, String str2, String str3, int i2, WeakReference<View> weakReference) {
        super(i, str, str2, str3, i2);
        this.hostView = weakReference;
    }
}
