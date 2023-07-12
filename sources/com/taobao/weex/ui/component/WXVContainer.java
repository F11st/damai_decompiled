package com.taobao.weex.ui.component;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.taobao.weex.dom.CSSShorthand;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.view.WXImageView;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class WXVContainer<T extends ViewGroup> extends WXComponent<T> {
    private static final String TAG = "WXVContainer";
    private WXVContainer<T>.BoxShadowHost mBoxShadowHost;
    protected ArrayList<WXComponent> mChildren;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class BoxShadowHost extends View {
        public BoxShadowHost(Context context) {
            super(context);
        }
    }

    @Deprecated
    public WXVContainer(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, String str, boolean z, BasicComponentData basicComponentData) {
        this(wXSDKInstance, wXVContainer, z, basicComponentData);
    }

    private void doViewTreeRecycleImageView(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof WXImageView) {
                if (z) {
                    ((WXImageView) childAt).autoReleaseImage();
                } else {
                    ((WXImageView) childAt).autoRecoverImage();
                }
            } else if (childAt instanceof ViewGroup) {
                doViewTreeRecycleImageView((ViewGroup) childAt, z);
            }
        }
    }

    public void addChild(WXComponent wXComponent) {
        addChild(wXComponent, -1);
    }

    public void addSubView(View view, int i) {
        if (view == null || getRealView() == null) {
            return;
        }
        if (i >= getRealView().getChildCount()) {
            i = -1;
        }
        if (i == -1) {
            getRealView().addView(view);
        } else {
            getRealView().addView(view, i);
        }
        WXSDKInstance wXComponent = getInstance();
        if (wXComponent != null) {
            wXComponent.getApmForInstance().o = true;
        }
    }

    public void appendTreeCreateFinish() {
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void applyLayoutAndEvent(WXComponent wXComponent) {
        if (isLazy()) {
            return;
        }
        if (wXComponent == null) {
            wXComponent = this;
        }
        super.applyLayoutAndEvent(wXComponent);
        int childCount = childCount();
        for (int i = 0; i < childCount; i++) {
            getChild(i).applyLayoutAndEvent(((WXVContainer) wXComponent).getChild(i));
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void bindData(WXComponent wXComponent) {
        if (isLazy()) {
            return;
        }
        if (wXComponent == null) {
            wXComponent = this;
        }
        super.bindData(wXComponent);
        int childCount = childCount();
        for (int i = 0; i < childCount; i++) {
            getChild(i).bindData(((WXVContainer) wXComponent).getChild(i));
        }
    }

    public int childCount() {
        ArrayList<WXComponent> arrayList = this.mChildren;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public void createChildViewAt(int i) {
        Pair<WXComponent, Integer> rearrangeIndexAndGetChild = rearrangeIndexAndGetChild(i);
        Object obj = rearrangeIndexAndGetChild.first;
        if (obj != null) {
            WXComponent wXComponent = (WXComponent) obj;
            wXComponent.createView();
            if (wXComponent.isVirtualComponent()) {
                return;
            }
            addSubView(wXComponent.getHostView(), ((Integer) rearrangeIndexAndGetChild.second).intValue());
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void createViewImpl() {
        super.createViewImpl();
        int childCount = childCount();
        for (int i = 0; i < childCount; i++) {
            createChildViewAt(i);
        }
        if (getHostView() != 0) {
            ((ViewGroup) getHostView()).setClipToPadding(false);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        ArrayList<WXComponent> arrayList = this.mChildren;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.mChildren.get(i).destroy();
            }
            this.mChildren.clear();
        }
        super.destroy();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public View detachViewAndClearPreInfo() {
        View detachViewAndClearPreInfo = super.detachViewAndClearPreInfo();
        if (this.mChildren != null) {
            int childCount = childCount();
            for (int i = 0; i < childCount; i++) {
                this.mChildren.get(i).detachViewAndClearPreInfo();
            }
        }
        return detachViewAndClearPreInfo;
    }

    @Nullable
    public View getBoxShadowHost(boolean z) {
        if (z) {
            return this.mBoxShadowHost;
        }
        ViewGroup viewGroup = (ViewGroup) getHostView();
        if (viewGroup == null) {
            return null;
        }
        try {
            if (WXBasicComponentType.DIV.equals(getComponentType())) {
                WXLogUtils.d("BoxShadow", "Draw box-shadow with BoxShadowHost on div: " + toString());
                if (this.mBoxShadowHost == null) {
                    WXVContainer<T>.BoxShadowHost boxShadowHost = new BoxShadowHost(getContext());
                    this.mBoxShadowHost = boxShadowHost;
                    WXViewUtils.setBackGround(boxShadowHost, null, this);
                    viewGroup.addView(this.mBoxShadowHost);
                }
                CSSShorthand padding = getPadding();
                CSSShorthand border = getBorder();
                CSSShorthand.EDGE edge = CSSShorthand.EDGE.LEFT;
                int i = (int) (padding.get(edge) + border.get(edge));
                CSSShorthand.EDGE edge2 = CSSShorthand.EDGE.TOP;
                int i2 = (int) (padding.get(edge2) + border.get(edge2));
                CSSShorthand.EDGE edge3 = CSSShorthand.EDGE.RIGHT;
                int i3 = (int) (padding.get(edge3) + border.get(edge3));
                CSSShorthand.EDGE edge4 = CSSShorthand.EDGE.BOTTOM;
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(viewGroup.getLayoutParams());
                setMarginsSupportRTL(marginLayoutParams, -i, -i2, -i3, -((int) (padding.get(edge4) + border.get(edge4))));
                this.mBoxShadowHost.setLayoutParams(marginLayoutParams);
                viewGroup.removeView(this.mBoxShadowHost);
                viewGroup.addView(this.mBoxShadowHost);
                return this.mBoxShadowHost;
            }
        } catch (Throwable th) {
            WXLogUtils.w("BoxShadow", th);
        }
        return viewGroup;
    }

    public WXComponent getChild(int i) {
        ArrayList<WXComponent> arrayList = this.mChildren;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.mChildren.get(i);
    }

    public int getChildCount() {
        return childCount();
    }

    public ViewGroup.LayoutParams getChildLayoutParams(WXComponent wXComponent, View view, int i, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams == null) {
            return new ViewGroup.LayoutParams(i, i2);
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            setMarginsSupportRTL((ViewGroup.MarginLayoutParams) layoutParams, i3, i5, i4, i6);
            return layoutParams;
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getChildrenLayoutTopOffset() {
        return 0;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public Scrollable getFirstScroller() {
        if (this instanceof Scrollable) {
            return (Scrollable) this;
        }
        for (int i = 0; i < getChildCount(); i++) {
            Scrollable firstScroller = getChild(i).getFirstScroller();
            if (firstScroller != null) {
                return firstScroller;
            }
        }
        return null;
    }

    public void ignoreFocus() {
        ViewGroup viewGroup = (ViewGroup) getHostView();
        if (viewGroup != null) {
            viewGroup.setFocusable(false);
            viewGroup.setFocusableInTouchMode(false);
            viewGroup.clearFocus();
        }
    }

    public final int indexOf(WXComponent wXComponent) {
        return this.mChildren.indexOf(wXComponent);
    }

    public void interceptFocus() {
        ViewGroup viewGroup = (ViewGroup) getHostView();
        if (viewGroup != null) {
            viewGroup.setFocusable(true);
            viewGroup.setFocusableInTouchMode(true);
            viewGroup.setDescendantFocusability(131072);
            viewGroup.requestFocus();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void notifyAppearStateChange(String str, String str2) {
        ArrayList<WXComponent> arrayList;
        super.notifyAppearStateChange(str, str2);
        if (getHostView() == 0 || (arrayList = this.mChildren) == null) {
            return;
        }
        Iterator<WXComponent> it = arrayList.iterator();
        while (it.hasNext()) {
            WXComponent next = it.next();
            if (next.getHostView() != null && next.getHostView().getVisibility() != 0) {
                str = Constants.Event.DISAPPEAR;
            }
            next.notifyAppearStateChange(str, str2);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public boolean onActivityBack() {
        super.onActivityBack();
        int childCount = childCount();
        for (int i = 0; i < childCount; i++) {
            getChild(i).onActivityBack();
        }
        return false;
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityCreate() {
        super.onActivityCreate();
        int childCount = childCount();
        for (int i = 0; i < childCount; i++) {
            getChild(i).onActivityCreate();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityDestroy() {
        super.onActivityDestroy();
        int childCount = childCount();
        for (int i = 0; i < childCount; i++) {
            getChild(i).onActivityDestroy();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityPause() {
        super.onActivityPause();
        int childCount = childCount();
        for (int i = 0; i < childCount; i++) {
            getChild(i).onActivityPause();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        int childCount = childCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChild(i3).onActivityResult(i, i2, intent);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityResume() {
        super.onActivityResume();
        int childCount = childCount();
        for (int i = 0; i < childCount; i++) {
            getChild(i).onActivityResume();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityStart() {
        super.onActivityStart();
        int childCount = childCount();
        for (int i = 0; i < childCount; i++) {
            getChild(i).onActivityStart();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent, com.taobao.weex.IWXActivityStateListener
    public void onActivityStop() {
        super.onActivityStop();
        int childCount = childCount();
        for (int i = 0; i < childCount; i++) {
            getChild(i).onActivityStop();
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        int childCount = childCount();
        for (int i = 0; i < childCount; i++) {
            getChild(i).onCreateOptionsMenu(menu);
        }
        return false;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void onRenderFinish(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            WXComponent child = getChild(i2);
            child.mTraceInfo.b = this.mTraceInfo.b;
            child.onRenderFinish(i);
        }
        super.onRenderFinish(i);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        int childCount = childCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChild(i2).onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Pair<WXComponent, Integer> rearrangeIndexAndGetChild(int i) {
        if (i < 0) {
            i = childCount() - 1;
        }
        if (i < 0) {
            return new Pair<>(null, Integer.valueOf(i));
        }
        return new Pair<>(getChild(i), Integer.valueOf(i));
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View] */
    @JSMethod
    public void recoverImageList(String str) {
        if (getHostView() != 0 && ViewCompat.isAttachedToWindow(getHostView()) && (getHostView() instanceof ViewGroup)) {
            if (WXUtils.getBoolean(str, Boolean.FALSE).booleanValue()) {
                doViewTreeRecycleImageView((ViewGroup) getHostView(), false);
                return;
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                WXComponent child = getChild(i);
                if ((child instanceof WXImage) && (((WXImage) child).getHostView() instanceof WXImageView)) {
                    WXImageView wXImageView = (WXImageView) child.getHostView();
                    if (wXImageView != null && ViewCompat.isAttachedToWindow(wXImageView)) {
                        wXImageView.autoRecoverImage();
                    }
                } else if (child instanceof WXVContainer) {
                    ((WXVContainer) child).recoverImageList(str);
                }
            }
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void recycled() {
        if (this.mChildren != null && !isFixed() && getAttrs().canRecycled()) {
            int size = this.mChildren.size();
            for (int i = 0; i < size; i++) {
                this.mChildren.get(i).recycled();
            }
        }
        super.recycled();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void refreshData(WXComponent wXComponent) {
        if (wXComponent == null) {
            wXComponent = this;
        }
        super.refreshData(wXComponent);
        int childCount = childCount();
        for (int i = 0; i < childCount; i++) {
            getChild(i).refreshData(((WXVContainer) wXComponent).getChild(i));
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View] */
    @JSMethod
    public void releaseImageList(String str) {
        if (getHostView() != 0 && ViewCompat.isAttachedToWindow(getHostView()) && (getHostView() instanceof ViewGroup)) {
            if (WXUtils.getBoolean(str, Boolean.FALSE).booleanValue()) {
                doViewTreeRecycleImageView((ViewGroup) getHostView(), true);
                return;
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                WXComponent child = getChild(i);
                if ((child instanceof WXImage) && (((WXImage) child).getHostView() instanceof WXImageView)) {
                    WXImageView wXImageView = (WXImageView) child.getHostView();
                    if (wXImageView != null && ViewCompat.isAttachedToWindow(wXImageView)) {
                        wXImageView.autoReleaseImage();
                    }
                } else if (child instanceof WXVContainer) {
                    ((WXVContainer) child).releaseImageList(str);
                }
            }
        }
    }

    public void remove(WXComponent wXComponent, boolean z) {
        ArrayList<WXComponent> arrayList;
        if (wXComponent == null || (arrayList = this.mChildren) == null || arrayList.size() == 0) {
            return;
        }
        this.mChildren.remove(wXComponent);
        if (getInstance() != null && getInstance().getRootView() != null && wXComponent.isFixed()) {
            getInstance().removeFixedView(wXComponent.getHostView());
        } else if (getRealView() != null) {
            if (!wXComponent.isVirtualComponent()) {
                ViewParent viewParent = null;
                if ((wXComponent.getParent() instanceof WXScroller) && wXComponent.getHostView() != null) {
                    viewParent = wXComponent.getHostView().getParent();
                }
                if (viewParent != null && (viewParent instanceof ViewGroup)) {
                    ((ViewGroup) viewParent).removeView(wXComponent.getHostView());
                } else {
                    getRealView().removeView(wXComponent.getHostView());
                }
            } else {
                wXComponent.removeVirtualComponent();
            }
        }
        if (z) {
            wXComponent.destroy();
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        WXGesture wXGesture = this.mGesture;
        if (wXGesture != null) {
            if (wXGesture.isRequestDisallowInterceptTouchEvent()) {
                return;
            }
            this.mGesture.setRequestDisallowInterceptTouchEvent(z);
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    @Deprecated
    public WXVContainer(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mChildren = new ArrayList<>();
    }

    public void addChild(WXComponent wXComponent, int i) {
        if (wXComponent == null || i < -1) {
            return;
        }
        wXComponent.mDeepInComponentTree = this.mDeepInComponentTree + 1;
        getInstance().setMaxDomDeep(wXComponent.mDeepInComponentTree);
        if (i >= this.mChildren.size()) {
            i = -1;
        }
        if (i == -1) {
            this.mChildren.add(wXComponent);
        } else {
            this.mChildren.add(i, wXComponent);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public ViewGroup getRealView() {
        return (ViewGroup) super.getRealView();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    @Deprecated
    public ViewGroup getView() {
        return (ViewGroup) getHostView();
    }

    public WXVContainer(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mChildren = new ArrayList<>();
    }
}
