package androidx.transition;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class VisibilityPropagation extends TransitionPropagation {
    private static final String PROPNAME_VISIBILITY = "android:visibilityPropagation:visibility";
    private static final String PROPNAME_VIEW_CENTER = "android:visibilityPropagation:center";
    private static final String[] VISIBILITY_PROPAGATION_VALUES = {PROPNAME_VISIBILITY, PROPNAME_VIEW_CENTER};

    private static int getViewCoordinate(TransitionValues transitionValues, int i) {
        int[] iArr;
        if (transitionValues == null || (iArr = (int[]) transitionValues.values.get(PROPNAME_VIEW_CENTER)) == null) {
            return -1;
        }
        return iArr[i];
    }

    @Override // androidx.transition.TransitionPropagation
    public void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        Integer num = (Integer) transitionValues.values.get("android:visibility:visibility");
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        transitionValues.values.put(PROPNAME_VISIBILITY, num);
        view.getLocationOnScreen(r2);
        int[] iArr = {iArr[0] + Math.round(view.getTranslationX())};
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        transitionValues.values.put(PROPNAME_VIEW_CENTER, iArr);
    }

    @Override // androidx.transition.TransitionPropagation
    public String[] getPropagationProperties() {
        return VISIBILITY_PROPAGATION_VALUES;
    }

    public int getViewVisibility(TransitionValues transitionValues) {
        Integer num;
        if (transitionValues == null || (num = (Integer) transitionValues.values.get(PROPNAME_VISIBILITY)) == null) {
            return 8;
        }
        return num.intValue();
    }

    public int getViewX(TransitionValues transitionValues) {
        return getViewCoordinate(transitionValues, 0);
    }

    public int getViewY(TransitionValues transitionValues) {
        return getViewCoordinate(transitionValues, 1);
    }
}
