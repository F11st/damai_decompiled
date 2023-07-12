package com.taobao.weex.ui.component.helper;

import android.os.Handler;
import android.os.Looper;
import com.taobao.weex.common.Constants;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXScroller;
import com.taobao.weex.ui.component.list.BasicListComponent;
import com.taobao.weex.ui.component.list.ListComponentView;
import com.taobao.weex.ui.component.list.template.WXRecyclerTemplateList;
import com.taobao.weex.ui.view.refresh.wrapper.BounceRecyclerView;
import com.taobao.weex.utils.WXUtils;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ScrollStartEndHelper implements Runnable {
    private WXComponent component;
    private boolean hasScrollEnd;
    private boolean hasStart;
    private long minInterval;
    private int x;
    private int y;
    private boolean canStart = false;
    private int oldState = 0;
    private Handler handler = new Handler(Looper.getMainLooper());

    public ScrollStartEndHelper(WXComponent wXComponent) {
        this.component = wXComponent;
        this.minInterval = WXUtils.getNumberInt(wXComponent.getAttrs().get("minscrolldelayinterval"), 32);
    }

    private Map<String, Object> getScrollEvent(int i, int i2) {
        ListComponentView listComponentView;
        WXComponent wXComponent = this.component;
        if (wXComponent instanceof BasicListComponent) {
            BasicListComponent basicListComponent = (BasicListComponent) wXComponent;
            if (!(basicListComponent.getHostView() instanceof ListComponentView) || (listComponentView = (ListComponentView) basicListComponent.getHostView()) == null) {
                return null;
            }
            return basicListComponent.getScrollEvent(listComponentView.getInnerView(), i, i2);
        } else if (wXComponent instanceof WXRecyclerTemplateList) {
            WXRecyclerTemplateList wXRecyclerTemplateList = (WXRecyclerTemplateList) wXComponent;
            return wXRecyclerTemplateList.getScrollEvent(((BounceRecyclerView) wXRecyclerTemplateList.getHostView()).getInnerView(), i, i2);
        } else if (wXComponent instanceof WXScroller) {
            return ((WXScroller) wXComponent).getScrollEvent(i, i2);
        } else {
            return null;
        }
    }

    public static boolean isScrollEvent(String str) {
        return "scroll".equals(str) || Constants.Event.SCROLL_START.equals(str) || Constants.Event.SCROLL_END.equals(str);
    }

    public void onScrollStateChanged(int i) {
        if (this.oldState == 0) {
            this.canStart = true;
        }
        if (i == 0) {
            this.hasScrollEnd = true;
            this.handler.removeCallbacks(this);
            this.handler.postDelayed(this, this.minInterval);
        }
        this.oldState = i;
    }

    public void onScrolled(int i, int i2) {
        Map<String, Object> scrollEvent;
        if (this.component.getEvents().contains(Constants.Event.SCROLL_START) || this.component.getEvents().contains(Constants.Event.SCROLL_END)) {
            this.x = i;
            this.y = i2;
            if (!this.hasStart && this.canStart) {
                if (this.component.getEvents().contains(Constants.Event.SCROLL_START) && (scrollEvent = getScrollEvent(i, i2)) != null && !scrollEvent.isEmpty()) {
                    this.component.fireEvent(Constants.Event.SCROLL_START, scrollEvent);
                }
                this.hasStart = true;
                this.canStart = false;
            }
            this.handler.removeCallbacks(this);
            this.handler.postDelayed(this, this.minInterval);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.component.isDestoryed() && this.hasScrollEnd) {
            if (this.canStart) {
                this.component.fireEvent(Constants.Event.SCROLL_START, getScrollEvent(this.x, this.y));
                this.canStart = false;
            }
            if (this.component.getEvents().contains(Constants.Event.SCROLL_END)) {
                this.component.fireEvent(Constants.Event.SCROLL_END, getScrollEvent(this.x, this.y));
            }
            this.hasStart = false;
            this.hasScrollEnd = false;
        }
    }
}
