package com.taobao.weex.ui.view.refresh.wrapper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.taobao.weex.ui.component.list.ListComponentView;
import com.taobao.weex.ui.component.list.StickyHeaderHelper;
import com.taobao.weex.ui.component.list.WXCell;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.ui.view.gesture.WXGestureObservable;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter;

/* compiled from: Taobao */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes11.dex */
public class BounceRecyclerView extends BaseBounceView<WXRecyclerView> implements ListComponentView, WXGestureObservable {
    public static final int DEFAULT_COLUMN_COUNT = 1;
    public static final int DEFAULT_COLUMN_GAP = 1;
    private RecyclerViewBaseAdapter adapter;
    private int mColumnCount;
    private float mColumnGap;
    private WXGesture mGesture;
    private int mLayoutType;
    private StickyHeaderHelper mStickyHeaderHelper;

    public BounceRecyclerView(Context context, int i, int i2, float f, int i3) {
        super(context, i3);
        this.adapter = null;
        this.mLayoutType = 1;
        this.mColumnCount = 1;
        this.mColumnGap = 1.0f;
        this.mLayoutType = i;
        this.mColumnCount = i2;
        this.mColumnGap = f;
        init(context);
        this.mStickyHeaderHelper = new StickyHeaderHelper(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        WXGesture wXGesture = this.mGesture;
        return wXGesture != null ? dispatchTouchEvent | wXGesture.onTouch(this, motionEvent) : dispatchTouchEvent;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public WXGesture getGestureListener() {
        return this.mGesture;
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView, com.taobao.weex.ui.component.list.ListComponentView
    public /* bridge */ /* synthetic */ WXRecyclerView getInnerView() {
        return (WXRecyclerView) super.getInnerView();
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public RecyclerViewBaseAdapter getRecyclerViewBaseAdapter() {
        return this.adapter;
    }

    public StickyHeaderHelper getStickyHeaderHelper() {
        return this.mStickyHeaderHelper;
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void notifyStickyRemove(WXCell wXCell) {
        this.mStickyHeaderHelper.notifyStickyRemove(wXCell);
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void notifyStickyShow(WXCell wXCell) {
        this.mStickyHeaderHelper.notifyStickyShow(wXCell);
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public void onLoadmoreComplete() {
        RecyclerViewBaseAdapter recyclerViewBaseAdapter = this.adapter;
        if (recyclerViewBaseAdapter != null) {
            recyclerViewBaseAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public void onRefreshingComplete() {
        RecyclerViewBaseAdapter recyclerViewBaseAdapter = this.adapter;
        if (recyclerViewBaseAdapter != null) {
            recyclerViewBaseAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(@Nullable WXGesture wXGesture) {
        this.mGesture = wXGesture;
        getInnerView().registerGestureListener(wXGesture);
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void setRecyclerViewBaseAdapter(RecyclerViewBaseAdapter recyclerViewBaseAdapter) {
        this.adapter = recyclerViewBaseAdapter;
        if (getInnerView() != null) {
            getInnerView().setAdapter(recyclerViewBaseAdapter);
        }
    }

    @Override // com.taobao.weex.ui.component.list.ListComponentView
    public void updateStickyView(int i) {
        this.mStickyHeaderHelper.updateStickyView(i);
    }

    @Override // com.taobao.weex.ui.view.refresh.wrapper.BaseBounceView
    public WXRecyclerView setInnerView(Context context) {
        WXRecyclerView wXRecyclerView = new WXRecyclerView(context);
        wXRecyclerView.initView(context, this.mLayoutType, this.mColumnCount, this.mColumnGap, getOrientation());
        return wXRecyclerView;
    }

    public BounceRecyclerView(Context context, int i, int i2) {
        this(context, i, 1, 1.0f, i2);
    }
}
