package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.transition.MaterialContainerTransform;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class MaskEvaluator {
    private ShapeAppearanceModel currentShapeAppearanceModel;
    private final Path path = new Path();
    private final Path startPath = new Path();
    private final Path endPath = new Path();
    private final ShapeAppearancePathProvider pathProvider = ShapeAppearancePathProvider.getInstance();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clip(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 23) {
            canvas.clipPath(this.path);
            return;
        }
        canvas.clipPath(this.startPath);
        canvas.clipPath(this.endPath, Region.Op.UNION);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void evaluate(float f, ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, RectF rectF2, RectF rectF3, MaterialContainerTransform.ProgressThresholds progressThresholds) {
        ShapeAppearanceModel lerp = TransitionUtils.lerp(shapeAppearanceModel, shapeAppearanceModel2, rectF, rectF3, progressThresholds.getStart(), progressThresholds.getEnd(), f);
        this.currentShapeAppearanceModel = lerp;
        this.pathProvider.calculatePath(lerp, 1.0f, rectF2, this.startPath);
        this.pathProvider.calculatePath(this.currentShapeAppearanceModel, 1.0f, rectF3, this.endPath);
        if (Build.VERSION.SDK_INT >= 23) {
            this.path.op(this.startPath, this.endPath, Path.Op.UNION);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeAppearanceModel getCurrentShapeAppearanceModel() {
        return this.currentShapeAppearanceModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path getPath() {
        return this.path;
    }
}
