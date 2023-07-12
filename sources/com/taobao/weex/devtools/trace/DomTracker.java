package com.taobao.weex.devtools.trace;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.devtools.trace.HealthReport;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXEmbed;
import com.taobao.weex.ui.component.WXScroller;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.component.list.WXCell;
import com.taobao.weex.ui.component.list.WXListComponent;
import com.taobao.weex.ui.view.WXFrameLayout;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DomTracker {
    private static final int START_LAYER_OF_REAL_DOM = 2;
    private static final int START_LAYER_OF_VDOM = 2;
    private static final String TAG = "VDomTracker";
    private OnTrackNodeListener mOnTrackNodeListener;
    private WXSDKInstance mWxInstance;
    private Deque<LayeredNode<WXComponent>> mLayeredQueue = new ArrayDeque();
    private ObjectPool<LayeredNode<WXComponent>> mVDomObjectPool = new ObjectPool<LayeredNode<WXComponent>>(10) { // from class: com.taobao.weex.devtools.trace.DomTracker.1
        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.taobao.weex.devtools.trace.DomTracker.ObjectPool
        public LayeredNode<WXComponent> newObject() {
            return new LayeredNode<>();
        }
    };
    private ObjectPool<LayeredNode<View>> mRealDomObjectPool = new ObjectPool<LayeredNode<View>>(15) { // from class: com.taobao.weex.devtools.trace.DomTracker.2
        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.taobao.weex.devtools.trace.DomTracker.ObjectPool
        public LayeredNode<View> newObject() {
            return new LayeredNode<>();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class LayeredNode<T> {
        T component;
        int layer;
        String simpleName;
        String tint;

        private LayeredNode() {
        }

        void clear() {
            this.component = null;
            this.layer = -1;
            this.simpleName = null;
        }

        void set(T t, String str, int i) {
            this.component = t;
            this.layer = i;
            this.simpleName = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static abstract class ObjectPool<T> {
        private final Deque<T> mPool;

        ObjectPool(int i) {
            int max = Math.max(0, i);
            this.mPool = new ArrayDeque(max);
            for (int i2 = 0; i2 < max; i2++) {
                this.mPool.add(newObject());
            }
        }

        abstract T newObject();

        T obtain() {
            return this.mPool.isEmpty() ? newObject() : this.mPool.removeLast();
        }

        void recycle(@NonNull T t) {
            this.mPool.addLast(t);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    interface OnTrackNodeListener {
        void onTrackNode(@NonNull WXComponent wXComponent, int i);
    }

    public DomTracker(@NonNull WXSDKInstance wXSDKInstance) {
        this.mWxInstance = wXSDKInstance;
    }

    private int getComponentNumOfNode(@NonNull WXComponent wXComponent) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(wXComponent);
        int i = 0;
        while (!arrayDeque.isEmpty()) {
            WXComponent wXComponent2 = (WXComponent) arrayDeque.removeFirst();
            i++;
            if (wXComponent2 instanceof WXVContainer) {
                WXVContainer wXVContainer = (WXVContainer) wXComponent2;
                int childCount = wXVContainer.childCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    arrayDeque.add(wXVContainer.getChild(i2));
                }
            }
        }
        return i;
    }

    private int getRealDomMaxLayer(@NonNull View view) {
        ArrayDeque arrayDeque = new ArrayDeque();
        LayeredNode<View> obtain = this.mRealDomObjectPool.obtain();
        obtain.set(view, null, 2);
        arrayDeque.add(obtain);
        int i = 0;
        while (!arrayDeque.isEmpty()) {
            LayeredNode<View> layeredNode = (LayeredNode) arrayDeque.removeFirst();
            i = Math.max(i, layeredNode.layer);
            View view2 = layeredNode.component;
            int i2 = layeredNode.layer;
            layeredNode.clear();
            this.mRealDomObjectPool.recycle(layeredNode);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                if (viewGroup.getChildCount() > 0) {
                    int childCount = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt = viewGroup.getChildAt(i3);
                        LayeredNode<View> obtain2 = this.mRealDomObjectPool.obtain();
                        obtain2.set(childAt, null, i2 + 1);
                        arrayDeque.add(obtain2);
                    }
                }
            }
        }
        return i;
    }

    private boolean isBigCell(float f) {
        return f > 0.0f && ((double) f) > ((double) (WXViewUtils.getScreenHeight() * 2)) / 3.0d;
    }

    void setOnTrackNodeListener(OnTrackNodeListener onTrackNodeListener) {
        this.mOnTrackNodeListener = onTrackNodeListener;
    }

    @Nullable
    public HealthReport traverse() {
        int i;
        WXCell wXCell;
        Map<String, HealthReport.ListDesc> map;
        HealthReport.ListDesc listDesc;
        long currentTimeMillis = System.currentTimeMillis();
        if (Looper.getMainLooper() == Looper.myLooper()) {
            WXLogUtils.e(TAG, "illegal thread...");
            return null;
        }
        WXComponent rootComponent = this.mWxInstance.getRootComponent();
        if (rootComponent == null) {
            WXLogUtils.e(TAG, "god component not found");
            return null;
        }
        HealthReport healthReport = new HealthReport(this.mWxInstance.getBundleUrl());
        View hostView = rootComponent.getHostView();
        if (hostView != null) {
            healthReport.maxLayerOfRealDom = getRealDomMaxLayer(hostView);
            i = hostView.getMeasuredHeight();
        } else {
            i = 0;
        }
        LayeredNode<WXComponent> obtain = this.mVDomObjectPool.obtain();
        obtain.set(rootComponent, ViewUtils.getComponentName(rootComponent), 2);
        this.mLayeredQueue.add(obtain);
        while (!this.mLayeredQueue.isEmpty()) {
            LayeredNode<WXComponent> removeFirst = this.mLayeredQueue.removeFirst();
            WXComponent wXComponent = removeFirst.component;
            healthReport.componentCount++;
            int i2 = removeFirst.layer;
            healthReport.maxLayer = Math.max(healthReport.maxLayer, i2);
            healthReport.estimateContentHeight = Math.max(healthReport.estimateContentHeight, ComponentHeightComputer.computeComponentContentHeight(wXComponent));
            if (!TextUtils.isEmpty(removeFirst.tint)) {
                for (HealthReport.EmbedDesc embedDesc : healthReport.embedDescList) {
                    String str = embedDesc.src;
                    if (str != null && str.equals(removeFirst.tint)) {
                        embedDesc.actualMaxLayer = Math.max(embedDesc.actualMaxLayer, i2 - embedDesc.beginLayer);
                    }
                }
            }
            OnTrackNodeListener onTrackNodeListener = this.mOnTrackNodeListener;
            if (onTrackNodeListener != null) {
                onTrackNodeListener.onTrackNode(wXComponent, i2);
            }
            if (wXComponent instanceof WXListComponent) {
                healthReport.hasList = true;
                if (healthReport.listDescMap == null) {
                    healthReport.listDescMap = new LinkedHashMap();
                }
                HealthReport.ListDesc listDesc2 = healthReport.listDescMap.get(wXComponent.getRef());
                if (listDesc2 == null) {
                    listDesc2 = new HealthReport.ListDesc();
                }
                listDesc2.ref = wXComponent.getRef();
                listDesc2.totalHeight = ComponentHeightComputer.computeComponentContentHeight(wXComponent);
                healthReport.listDescMap.put(listDesc2.ref, listDesc2);
            } else if (wXComponent instanceof WXScroller) {
                if (ViewUtils.isVerticalScroller((WXScroller) wXComponent)) {
                    healthReport.hasScroller = true;
                }
            } else if (wXComponent instanceof WXCell) {
                WXVContainer parent = wXComponent.getParent();
                if (parent != null && (parent instanceof WXListComponent) && (map = healthReport.listDescMap) != null && (listDesc = map.get(parent.getRef())) != null) {
                    listDesc.cellNum++;
                }
                int componentNumOfNode = getComponentNumOfNode(wXComponent);
                healthReport.maxCellViewNum = Math.max(healthReport.maxCellViewNum, componentNumOfNode);
                if (((WXCell) wXComponent).getHostView() != 0) {
                    healthReport.hasBigCell = isBigCell(((WXFrameLayout) wXCell.getHostView()).getMeasuredHeight()) | healthReport.hasBigCell;
                    healthReport.componentNumOfBigCell = componentNumOfNode;
                }
            } else if (wXComponent instanceof WXEmbed) {
                healthReport.hasEmbed = true;
            }
            removeFirst.clear();
            this.mVDomObjectPool.recycle(removeFirst);
            if (wXComponent instanceof WXEmbed) {
                if (healthReport.embedDescList == null) {
                    healthReport.embedDescList = new ArrayList();
                }
                HealthReport.EmbedDesc embedDesc2 = new HealthReport.EmbedDesc();
                WXEmbed wXEmbed = (WXEmbed) wXComponent;
                embedDesc2.src = wXEmbed.getSrc();
                embedDesc2.beginLayer = i2;
                healthReport.embedDescList.add(embedDesc2);
                WXComponent nestedRootComponent = ViewUtils.getNestedRootComponent(wXEmbed);
                if (nestedRootComponent != null) {
                    LayeredNode<WXComponent> obtain2 = this.mVDomObjectPool.obtain();
                    obtain2.set(nestedRootComponent, ViewUtils.getComponentName(nestedRootComponent), i2 + 1);
                    this.mLayeredQueue.add(obtain2);
                    obtain2.tint = embedDesc2.src;
                }
            } else if (wXComponent instanceof WXVContainer) {
                WXVContainer wXVContainer = (WXVContainer) wXComponent;
                int childCount = wXVContainer.childCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    WXComponent child = wXVContainer.getChild(i3);
                    LayeredNode<WXComponent> obtain3 = this.mVDomObjectPool.obtain();
                    obtain3.set(child, ViewUtils.getComponentName(child), i2 + 1);
                    if (!TextUtils.isEmpty(removeFirst.tint)) {
                        obtain3.tint = removeFirst.tint;
                    }
                    this.mLayeredQueue.add(obtain3);
                }
            }
        }
        Context context = this.mWxInstance.getContext();
        if (context != null && i == 0) {
            i = ViewUtils.getScreenHeight(context);
        }
        if (i != 0) {
            healthReport.estimatePages = String.format(Locale.CHINA, "%.2f", Double.valueOf(healthReport.estimateContentHeight / i));
        } else {
            healthReport.estimatePages = "0";
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        WXLogUtils.d(TAG, "[traverse] elapse time :" + (currentTimeMillis2 - currentTimeMillis) + "ms");
        return healthReport;
    }
}
