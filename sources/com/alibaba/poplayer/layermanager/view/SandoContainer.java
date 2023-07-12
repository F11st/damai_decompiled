package com.alibaba.poplayer.layermanager.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.alibaba.poplayer.R$id;
import com.alibaba.poplayer.R$layout;
import tb.dt1;
import tb.fw2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class SandoContainer extends FrameLayout {
    private boolean isBeginPreDrawListener;
    private AugmentedLayer mAugmentedLayer;
    private MirrorLayer mMirrorLayer;
    private PopLayerViewContainer mPopLayerContainer;
    private final ViewTreeObserver.OnPreDrawListener mPreDrawLsn;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.layermanager.view.SandoContainer$a */
    /* loaded from: classes8.dex */
    class ViewTreeObserver$OnPreDrawListenerC3670a implements ViewTreeObserver.OnPreDrawListener {
        ViewTreeObserver$OnPreDrawListenerC3670a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            try {
                SandoContainer.this.mMirrorLayer.updateMirrorViewsIfNeed();
                SandoContainer.this.mAugmentedLayer.updateAugmentedViews();
                if (SandoContainer.this.mMirrorLayer.size() == 0 && SandoContainer.this.mAugmentedLayer.getChildCount() == 0) {
                    SandoContainer.this.stopPreDrawListenerIfNeed();
                    dt1.b("SandoContainer.stop preDraw listener:mirror and track count = 0;", new Object[0]);
                }
            } catch (Throwable unused) {
            }
            return true;
        }
    }

    public SandoContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isBeginPreDrawListener = false;
        this.mPreDrawLsn = new ViewTreeObserver$OnPreDrawListenerC3670a();
        initialize(context);
    }

    private void initialize(Context context) {
        View.inflate(context, R$layout.pop_layer_sando_layer, this);
        MirrorLayer mirrorLayer = (MirrorLayer) findViewById(R$id.mirror);
        this.mMirrorLayer = mirrorLayer;
        mirrorLayer.setSandoContainer(this);
        AugmentedLayer augmentedLayer = (AugmentedLayer) findViewById(R$id.augmented);
        this.mAugmentedLayer = augmentedLayer;
        augmentedLayer.setSandoContainer(this);
    }

    public AugmentedLayer getAugmentedLayer() {
        return this.mAugmentedLayer;
    }

    public MirrorLayer getMirrorLayer() {
        return this.mMirrorLayer;
    }

    PopLayerViewContainer getPopLayerContainer() {
        return this.mPopLayerContainer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPopLayerContainer(PopLayerViewContainer popLayerViewContainer) {
        this.mPopLayerContainer = popLayerViewContainer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreDrawListenerIfNeed() {
        if (this.isBeginPreDrawListener) {
            return;
        }
        this.mPopLayerContainer.showSandoContainer(true);
        ViewTreeObserver viewTreeObserver = fw2.e((Activity) getContext()).getViewTreeObserver();
        viewTreeObserver.removeOnPreDrawListener(this.mPreDrawLsn);
        viewTreeObserver.addOnPreDrawListener(this.mPreDrawLsn);
        dt1.b("SandoContainer.start preDraw listener.", new Object[0]);
        this.isBeginPreDrawListener = true;
    }

    void stopPreDrawListenerIfNeed() {
        if (this.isBeginPreDrawListener) {
            this.mPopLayerContainer.showSandoContainer(false);
            fw2.e((Activity) getContext()).getViewTreeObserver().removeOnPreDrawListener(this.mPreDrawLsn);
            dt1.b("SandoContainer.stop preDraw listener.", new Object[0]);
            this.isBeginPreDrawListener = false;
        }
    }

    public SandoContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isBeginPreDrawListener = false;
        this.mPreDrawLsn = new ViewTreeObserver$OnPreDrawListenerC3670a();
        initialize(context);
    }

    public SandoContainer(Context context) {
        super(context);
        this.isBeginPreDrawListener = false;
        this.mPreDrawLsn = new ViewTreeObserver$OnPreDrawListenerC3670a();
        initialize(context);
    }
}
