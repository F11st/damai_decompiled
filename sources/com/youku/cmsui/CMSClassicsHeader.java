package com.youku.cmsui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import com.scwang.smartrefresh.layout.api.OnTwoLevelListener;
import com.youku.resource.widget.YKPageRefreshHeader;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CMSClassicsHeader extends YKPageRefreshHeader {
    protected static final int ROTATE_ANIM_DURATION = 400;
    private AnimationDrawable anim;
    protected Animation mRotateCircleAnim;
    protected Animation mRotateDownAnim;
    protected Animation mRotateUpAnim;

    public CMSClassicsHeader(Context context) {
        super(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.youku.resource.widget.YKPageRefreshHeader
    public void initView() {
        super.initView();
    }

    public CMSClassicsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    @Override // com.youku.resource.widget.YKPageRefreshHeader
    public CMSClassicsHeader finishTwoLevel() {
        super.finishTwoLevel();
        return this;
    }

    @Override // com.youku.resource.widget.YKPageRefreshHeader
    public CMSClassicsHeader setEnablePullToCloseTwoLevel(boolean z) {
        super.setEnablePullToCloseTwoLevel(z);
        return this;
    }

    @Override // com.youku.resource.widget.YKPageRefreshHeader
    public CMSClassicsHeader setEnableTwoLevel(boolean z) {
        super.setEnableTwoLevel(z);
        return this;
    }

    @Override // com.youku.resource.widget.YKPageRefreshHeader
    public CMSClassicsHeader setFloorDuration(int i) {
        super.setFloorDuration(i);
        return this;
    }

    @Override // com.youku.resource.widget.YKPageRefreshHeader
    public CMSClassicsHeader setFloorRage(float f) {
        super.setFloorRage(f);
        return this;
    }

    @Override // com.youku.resource.widget.YKPageRefreshHeader
    public CMSClassicsHeader setOnTwoLevelListener(OnTwoLevelListener onTwoLevelListener) {
        super.setOnTwoLevelListener(onTwoLevelListener);
        return this;
    }

    @Override // com.youku.resource.widget.YKPageRefreshHeader
    public CMSClassicsHeader setRefreshRage(float f) {
        super.setRefreshRage(f);
        return this;
    }
}
