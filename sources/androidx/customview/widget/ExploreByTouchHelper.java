package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.customview.widget.FocusStrategy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.1
        @Override // androidx.customview.widget.FocusStrategy.BoundsAdapter
        public void obtainBounds(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Rect rect) {
            accessibilityNodeInfoCompat.getBoundsInParent(rect);
        }
    };
    private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat>() { // from class: androidx.customview.widget.ExploreByTouchHelper.2
        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat, int i) {
            return sparseArrayCompat.valueAt(i);
        }

        @Override // androidx.customview.widget.FocusStrategy.CollectionAdapter
        public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat) {
            return sparseArrayCompat.size();
        }
    };
    private final View mHost;
    private final AccessibilityManager mManager;
    private MyNodeProvider mNodeProvider;
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final int[] mTempGlobalRect = new int[2];
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private class MyNodeProvider extends AccessibilityNodeProviderCompat {
        MyNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(i));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int i) {
            int i2 = i == 2 ? ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId : ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(i2);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int i, int i2, Bundle bundle) {
            return ExploreByTouchHelper.this.performAction(i, i2, bundle);
        }
    }

    public ExploreByTouchHelper(@NonNull View view) {
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ViewCompat.getImportantForAccessibility(view) == 0) {
                ViewCompat.setImportantForAccessibility(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int i) {
        if (this.mAccessibilityFocusedVirtualViewId == i) {
            this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
            this.mHost.invalidate();
            sendEventForVirtualView(i, 65536);
            return true;
        }
        return false;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int i = this.mKeyboardFocusedVirtualViewId;
        return i != Integer.MIN_VALUE && onPerformActionForVirtualView(i, 16, null);
    }

    private AccessibilityEvent createEvent(int i, int i2) {
        if (i != -1) {
            return createEventForChild(i, i2);
        }
        return createEventForHost(i2);
    }

    private AccessibilityEvent createEventForChild(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
        obtain.getText().add(obtainAccessibilityNodeInfo.getText());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.getContentDescription());
        obtain.setScrollable(obtainAccessibilityNodeInfo.isScrollable());
        obtain.setPassword(obtainAccessibilityNodeInfo.isPassword());
        obtain.setEnabled(obtainAccessibilityNodeInfo.isEnabled());
        obtain.setChecked(obtainAccessibilityNodeInfo.isChecked());
        onPopulateEventForVirtualView(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(obtainAccessibilityNodeInfo.getClassName());
        AccessibilityRecordCompat.setSource(obtain, this.mHost, i);
        obtain.setPackageName(this.mHost.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent createEventForHost(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForChild(int i) {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        obtain.setClassName(DEFAULT_CLASS_NAME);
        Rect rect = INVALID_PARENT_BOUNDS;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        obtain.setParent(this.mHost);
        onPopulateNodeForVirtualView(i, obtain);
        if (obtain.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        obtain.getBoundsInParent(this.mTempParentRect);
        if (!this.mTempParentRect.equals(rect)) {
            int actions = obtain.getActions();
            if ((actions & 64) == 0) {
                if ((actions & 128) == 0) {
                    obtain.setPackageName(this.mHost.getContext().getPackageName());
                    obtain.setSource(this.mHost, i);
                    if (this.mAccessibilityFocusedVirtualViewId == i) {
                        obtain.setAccessibilityFocused(true);
                        obtain.addAction(128);
                    } else {
                        obtain.setAccessibilityFocused(false);
                        obtain.addAction(64);
                    }
                    boolean z = this.mKeyboardFocusedVirtualViewId == i;
                    if (z) {
                        obtain.addAction(2);
                    } else if (obtain.isFocusable()) {
                        obtain.addAction(1);
                    }
                    obtain.setFocused(z);
                    this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                    obtain.getBoundsInScreen(this.mTempScreenRect);
                    if (this.mTempScreenRect.equals(rect)) {
                        obtain.getBoundsInParent(this.mTempScreenRect);
                        if (obtain.mParentVirtualDescendantId != -1) {
                            AccessibilityNodeInfoCompat obtain2 = AccessibilityNodeInfoCompat.obtain();
                            for (int i2 = obtain.mParentVirtualDescendantId; i2 != -1; i2 = obtain2.mParentVirtualDescendantId) {
                                obtain2.setParent(this.mHost, -1);
                                obtain2.setBoundsInParent(INVALID_PARENT_BOUNDS);
                                onPopulateNodeForVirtualView(i2, obtain2);
                                obtain2.getBoundsInParent(this.mTempParentRect);
                                Rect rect2 = this.mTempScreenRect;
                                Rect rect3 = this.mTempParentRect;
                                rect2.offset(rect3.left, rect3.top);
                            }
                            obtain2.recycle();
                        }
                        this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                    }
                    if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                        this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                        if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                            obtain.setBoundsInScreen(this.mTempScreenRect);
                            if (isVisibleToUser(this.mTempScreenRect)) {
                                obtain.setVisibleToUser(true);
                            }
                        }
                    }
                    return obtain;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    @NonNull
    private AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.mHost);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, obtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            obtain.addChild(this.mHost, ((Integer) arrayList.get(i)).intValue());
        }
        return obtain;
    }

    private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat<AccessibilityNodeInfoCompat> sparseArrayCompat = new SparseArrayCompat<>();
        for (int i = 0; i < arrayList.size(); i++) {
            sparseArrayCompat.put(i, createNodeForChild(i));
        }
        return sparseArrayCompat;
    }

    private void getBoundsInParent(int i, Rect rect) {
        obtainAccessibilityNodeInfo(i).getBoundsInParent(rect);
    }

    private static Rect guessPreviouslyFocusedRect(@NonNull View view, int i, @NonNull Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int keyToDirection(int i) {
        if (i != 19) {
            if (i != 21) {
                return i != 22 ? 130 : 66;
            }
            return 17;
        }
        return 33;
    }

    private boolean moveFocus(int i, @Nullable Rect rect) {
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        SparseArrayCompat<AccessibilityNodeInfoCompat> allNodes = getAllNodes();
        int i2 = this.mKeyboardFocusedVirtualViewId;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = i2 == Integer.MIN_VALUE ? null : allNodes.get(i2);
        if (i == 1 || i == 2) {
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInRelativeDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat2, i, ViewCompat.getLayoutDirection(this.mHost) == 1, false);
        } else if (i != 17 && i != 33 && i != 66 && i != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } else {
            Rect rect2 = new Rect();
            int i3 = this.mKeyboardFocusedVirtualViewId;
            if (i3 != Integer.MIN_VALUE) {
                getBoundsInParent(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                guessPreviouslyFocusedRect(this.mHost, i, rect2);
            }
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) FocusStrategy.findNextFocusInAbsoluteDirection(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, accessibilityNodeInfoCompat2, rect2, i);
        }
        return requestKeyboardFocusForVirtualView(accessibilityNodeInfoCompat != null ? allNodes.keyAt(allNodes.indexOfValue(accessibilityNodeInfoCompat)) : Integer.MIN_VALUE);
    }

    private boolean performActionForChild(int i, int i2, Bundle bundle) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 64) {
                    if (i2 != 128) {
                        return onPerformActionForVirtualView(i, i2, bundle);
                    }
                    return clearAccessibilityFocus(i);
                }
                return requestAccessibilityFocus(i);
            }
            return clearKeyboardFocusForVirtualView(i);
        }
        return requestKeyboardFocusForVirtualView(i);
    }

    private boolean performActionForHost(int i, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.mHost, i, bundle);
    }

    private boolean requestAccessibilityFocus(int i) {
        int i2;
        if (this.mManager.isEnabled() && this.mManager.isTouchExplorationEnabled() && (i2 = this.mAccessibilityFocusedVirtualViewId) != i) {
            if (i2 != Integer.MIN_VALUE) {
                clearAccessibilityFocus(i2);
            }
            this.mAccessibilityFocusedVirtualViewId = i;
            this.mHost.invalidate();
            sendEventForVirtualView(i, 32768);
            return true;
        }
        return false;
    }

    private void updateHoveredVirtualView(int i) {
        int i2 = this.mHoveredVirtualViewId;
        if (i2 == i) {
            return;
        }
        this.mHoveredVirtualViewId = i;
        sendEventForVirtualView(i, 128);
        sendEventForVirtualView(i2, 256);
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        if (this.mManager.isEnabled() && this.mManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action != 7 && action != 9) {
                if (action == 10 && this.mHoveredVirtualViewId != Integer.MIN_VALUE) {
                    updateHoveredVirtualView(Integer.MIN_VALUE);
                    return true;
                }
                return false;
            }
            int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            updateHoveredVirtualView(virtualViewAt);
            return virtualViewAt != Integer.MIN_VALUE;
        }
        return false;
    }

    public final boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                int keyToDirection = keyToDirection(keyCode);
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z = false;
                                while (i < repeatCount && moveFocus(keyToDirection, null)) {
                                    i++;
                                    z = true;
                                }
                                return z;
                            }
                            return false;
                        case 23:
                            break;
                        default:
                            return false;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    clickKeyboardFocusedVirtualView();
                    return true;
                }
                return false;
            } else if (keyEvent.hasNoModifiers()) {
                return moveFocus(2, null);
            } else {
                if (keyEvent.hasModifiers(1)) {
                    return moveFocus(1, null);
                }
                return false;
            }
        }
        return false;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    protected abstract int getVirtualViewAt(float f, float f2);

    protected abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i) {
        invalidateVirtualView(i, 0);
    }

    @NonNull
    AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i) {
        if (i == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i);
    }

    public final void onFocusChanged(boolean z, int i, @Nullable Rect rect) {
        int i2 = this.mKeyboardFocusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (z) {
            moveFocus(i, rect);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        onPopulateNodeForHost(accessibilityNodeInfoCompat);
    }

    protected abstract boolean onPerformActionForVirtualView(int i, int i2, @Nullable Bundle bundle);

    protected void onPopulateEventForHost(@NonNull AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateEventForVirtualView(int i, @NonNull AccessibilityEvent accessibilityEvent) {
    }

    protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    protected abstract void onPopulateNodeForVirtualView(int i, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    protected void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    boolean performAction(int i, int i2, Bundle bundle) {
        if (i != -1) {
            return performActionForChild(i, i2, bundle);
        }
        return performActionForHost(i2, bundle);
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        int i2;
        if ((this.mHost.isFocused() || this.mHost.requestFocus()) && (i2 = this.mKeyboardFocusedVirtualViewId) != i) {
            if (i2 != Integer.MIN_VALUE) {
                clearKeyboardFocusForVirtualView(i2);
            }
            this.mKeyboardFocusedVirtualViewId = i;
            onVirtualViewKeyboardFocusChanged(i, true);
            sendEventForVirtualView(i, 8);
            return true;
        }
        return false;
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return ViewParentCompat.requestSendAccessibilityEvent(parent, this.mHost, createEvent(i, i2));
    }

    public final void invalidateVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return;
        }
        AccessibilityEvent createEvent = createEvent(i, 2048);
        AccessibilityEventCompat.setContentChangeTypes(createEvent, i2);
        ViewParentCompat.requestSendAccessibilityEvent(parent, this.mHost, createEvent);
    }
}
