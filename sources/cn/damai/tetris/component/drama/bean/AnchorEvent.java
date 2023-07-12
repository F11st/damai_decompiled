package cn.damai.tetris.component.drama.bean;

import cn.damai.tetris.component.drama.mvp.AnchorFloatingView;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class AnchorEvent {
    public static final int TYPE_SELECT = 51;
    public static final int TYPE_UI_BIND = 52;
    public AnchorFloatingView mFloatingView;
    public AnchorBean select;

    public AnchorEvent(AnchorBean anchorBean) {
        this.select = anchorBean;
    }

    public AnchorEvent(AnchorFloatingView anchorFloatingView) {
        this.mFloatingView = anchorFloatingView;
    }
}
