package com.alibaba.gaiax.template.animation;

import android.animation.Animator;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/gaiax/template/animation/GXIPropAnimation;", "Lcom/alibaba/gaiax/template/animation/GXIAnimation;", "Landroid/view/View;", "targetView", "Landroid/animation/Animator;", "createAnimator", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public interface GXIPropAnimation extends GXIAnimation {
    @NotNull
    Animator createAnimator(@NotNull View view);
}
