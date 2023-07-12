package com.youku.live.livesdk.widgets.container.pagable;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider;
import com.youku.live.livesdk.widgets.container.pagable.PagableConfigure;
import com.youku.live.livesdk.widgets.helper.Accessor;
import com.youku.live.livesdk.widgets.helper.Caller;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PagableRecyclerViewProvider<DataType, ContentViewType extends View> implements PagableViewProvider<DataType, ContentViewType> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int DEFAULT_ITEM_EXTRA_SPACE = 30;
    private PagableAdapter<DataType, ContentViewType> mAdapter;
    private int mBottomExtraSpace;
    private PreloadableContentView mContentLayout;
    private List<DataType> mItemList;
    private PagableViewProvider.OnItemInfoListener mOnItemInfoListener;
    private DefaultOnPagingLifecycleListener<DataType, ContentViewType> mOnPagingLifecycleListener = new DefaultOnPagingLifecycleListener<>();
    private RestrictedRecyclerView mRecyclerView;
    private PagerSnapHelper mRestrictedPagerSnapHelper;
    private int mTopExtraSpace;

    /* compiled from: Taobao */
    /* renamed from: com.youku.live.livesdk.widgets.container.pagable.PagableRecyclerViewProvider$2  reason: invalid class name */
    /* loaded from: classes12.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$live$livesdk$widgets$container$pagable$PagableConfigure$PreloadMode;

        static {
            int[] iArr = new int[PagableConfigure.PreloadMode.values().length];
            $SwitchMap$com$youku$live$livesdk$widgets$container$pagable$PagableConfigure$PreloadMode = iArr;
            try {
                iArr[PagableConfigure.PreloadMode.TOP_BOTTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$live$livesdk$widgets$container$pagable$PagableConfigure$PreloadMode[PagableConfigure.PreloadMode.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$live$livesdk$widgets$container$pagable$PagableConfigure$PreloadMode[PagableConfigure.PreloadMode.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public PagableRecyclerViewProvider(Context context, PagableConfigure.PreloadMode preloadMode) {
        this.mTopExtraSpace = 30;
        this.mBottomExtraSpace = 30;
        this.mContentLayout = new PreloadableContentView(context);
        RestrictedRecyclerView restrictedRecyclerView = new RestrictedRecyclerView(context);
        this.mRecyclerView = restrictedRecyclerView;
        restrictedRecyclerView.setItemAnimator(null);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setItemViewCacheSize(0);
        int mode = LiveViewCacher.getMode();
        if (mode != 1 && mode != 2) {
            this.mRecyclerView.getRecycledViewPool().setMaxRecycledViews(0, 1);
        } else {
            this.mRecyclerView.getRecycledViewPool().setMaxRecycledViews(0, 0);
        }
        this.mAdapter = new PagableAdapter<>(null);
        int i = AnonymousClass2.$SwitchMap$com$youku$live$livesdk$widgets$container$pagable$PagableConfigure$PreloadMode[preloadMode.ordinal()];
        if (i == 2) {
            this.mTopExtraSpace = 0;
            this.mBottomExtraSpace = 30;
            this.mContentLayout.setExtraSpace(0, 30);
            this.mContentLayout.addView(this.mRecyclerView, new FrameLayout.LayoutParams(-1, -1, 48));
        } else if (i != 3) {
            this.mTopExtraSpace = 30;
            this.mBottomExtraSpace = 30;
            this.mContentLayout.setExtraSpace(30, 30);
            this.mContentLayout.addView(this.mRecyclerView, new FrameLayout.LayoutParams(-1, -1, 17));
        } else {
            this.mTopExtraSpace = 0;
            this.mBottomExtraSpace = 0;
            this.mContentLayout.setExtraSpace(0, 0);
            this.mContentLayout.addView(this.mRecyclerView, new FrameLayout.LayoutParams(-1, -1, 17));
        }
        this.mRecyclerView.setPadding(0, this.mTopExtraSpace, 0, this.mBottomExtraSpace);
        this.mAdapter.setExtraSpace(this.mTopExtraSpace, this.mBottomExtraSpace);
        this.mAdapter.setPagingLifecycleListener(this.mOnPagingLifecycleListener);
        this.mAdapter.setHasStableIds(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
        linearLayoutManager.setItemPrefetchEnabled(false);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setAdapter(this.mAdapter);
        RestrictedPagerSnapHelper restrictedPagerSnapHelper = new RestrictedPagerSnapHelper();
        this.mRestrictedPagerSnapHelper = restrictedPagerSnapHelper;
        restrictedPagerSnapHelper.attachToRecyclerView(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.youku.live.livesdk.widgets.container.pagable.PagableRecyclerViewProvider.1
            private static transient /* synthetic */ IpChange $ipChange;
            private List<PagableViewHolder<DataType>> mCacheInvisibleHolders = new ArrayList();
            private List<PagableViewHolder<DataType>> mCacheVisibleHolders = new ArrayList();

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-631801657")) {
                    ipChange.ipc$dispatch("-631801657", new Object[]{this, recyclerView, Integer.valueOf(i2)});
                    return;
                }
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 != 0 || PagableRecyclerViewProvider.this.mOnPagingLifecycleListener == null) {
                    return;
                }
                View findChildViewUnder = recyclerView.findChildViewUnder(recyclerView.getWidth() / 2, recyclerView.getHeight() / 2);
                for (int i3 = 0; i3 < recyclerView.getChildCount(); i3++) {
                    View childAt = recyclerView.getChildAt(i3);
                    int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                    if (childAdapterPosition >= 0 && childAdapterPosition < PagableRecyclerViewProvider.this.mItemList.size()) {
                        PagableRecyclerViewProvider.this.mOnPagingLifecycleListener.onPageIdleChanged(childAdapterPosition, PagableRecyclerViewProvider.this.mItemList.get(childAdapterPosition), childAt, childAt == findChildViewUnder);
                        PagableRecyclerViewProvider.this.mRecyclerView.stopScroll();
                    }
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1271673720")) {
                    ipChange.ipc$dispatch("1271673720", new Object[]{this, recyclerView, Integer.valueOf(i2), Integer.valueOf(i3)});
                    return;
                }
                super.onScrolled(recyclerView, i2, i3);
                int childCount = recyclerView.getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = recyclerView.getChildAt(i4);
                    RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
                    if (childViewHolder instanceof PagableViewHolder) {
                        PagableViewHolder<DataType> pagableViewHolder = (PagableViewHolder) childViewHolder;
                        int previousVisibility = pagableViewHolder.getPreviousVisibility();
                        int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                        if (childAdapterPosition >= 0 && childAdapterPosition < PagableRecyclerViewProvider.this.mItemList.size()) {
                            if (childAt.getTop() != childAt.getBottom() && ((childAt.getBottom() <= PagableRecyclerViewProvider.this.mTopExtraSpace || childAt.getTop() >= recyclerView.getHeight() - PagableRecyclerViewProvider.this.mBottomExtraSpace) && previousVisibility != 4)) {
                                this.mCacheInvisibleHolders.add(pagableViewHolder);
                            }
                            if (childAt.getTop() != childAt.getBottom() && childAt.getBottom() > PagableRecyclerViewProvider.this.mTopExtraSpace && childAt.getTop() < recyclerView.getHeight() - PagableRecyclerViewProvider.this.mBottomExtraSpace && previousVisibility != 0) {
                                this.mCacheVisibleHolders.add(pagableViewHolder);
                            }
                        }
                    }
                }
                if (this.mCacheInvisibleHolders.size() > 0) {
                    for (PagableViewHolder<DataType> pagableViewHolder2 : this.mCacheInvisibleHolders) {
                        View view = pagableViewHolder2.itemView;
                        int childAdapterPosition2 = recyclerView.getChildAdapterPosition(view);
                        PagableRecyclerViewProvider.this.mOnPagingLifecycleListener.onPageInvisible(childAdapterPosition2, PagableRecyclerViewProvider.this.mItemList.get(childAdapterPosition2), view);
                        pagableViewHolder2.updateVisibility(4);
                    }
                    this.mCacheInvisibleHolders.clear();
                }
                if (this.mCacheVisibleHolders.size() > 0) {
                    for (PagableViewHolder<DataType> pagableViewHolder3 : this.mCacheVisibleHolders) {
                        View view2 = pagableViewHolder3.itemView;
                        int childAdapterPosition3 = recyclerView.getChildAdapterPosition(view2);
                        Object obj = PagableRecyclerViewProvider.this.mItemList.get(childAdapterPosition3);
                        PagableRecyclerViewProvider.this.mOnPagingLifecycleListener.onPageVisible(childAdapterPosition3, obj, view2);
                        pagableViewHolder3.updateVisibility(0);
                        if (childAdapterPosition3 == 0) {
                            PagableRecyclerViewProvider.this.mAdapter.noitfyFirstAppear(obj, view2);
                        }
                    }
                    this.mCacheVisibleHolders.clear();
                }
            }
        });
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void addOnPagingLifecycleListener(PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType> onPagingLifecycleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1863330600")) {
            ipChange.ipc$dispatch("-1863330600", new Object[]{this, onPagingLifecycleListener});
        } else {
            this.mOnPagingLifecycleListener.addInnerListener(onPagingLifecycleListener);
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public <Params, RetValue> RetValue callActiveView(Caller<ContentViewType, Params, RetValue> caller, Params params, RetValue retvalue) {
        View findChildViewUnder;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-935874029") ? (RetValue) ipChange.ipc$dispatch("-935874029", new Object[]{this, caller, params, retvalue}) : (caller == 0 || (findChildViewUnder = this.mRecyclerView.findChildViewUnder((float) (this.mRecyclerView.getWidth() / 2), (float) (this.mRecyclerView.getHeight() / 2))) == null) ? retvalue : caller.onCall(findChildViewUnder, params);
    }

    public void enableScrolling(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-788997447")) {
            ipChange.ipc$dispatch("-788997447", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mRecyclerView.enableScrolling(z);
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public View getContentView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-564072969") ? (View) ipChange.ipc$dispatch("-564072969", new Object[]{this}) : this.mContentLayout;
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void notifyActiveView(Accessor<ContentViewType> accessor) {
        View findChildViewUnder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-159808512")) {
            ipChange.ipc$dispatch("-159808512", new Object[]{this, accessor});
        } else if (accessor == 0 || (findChildViewUnder = this.mRecyclerView.findChildViewUnder(this.mRecyclerView.getWidth() / 2, this.mRecyclerView.getHeight() / 2)) == null) {
        } else {
            accessor.onAccess(findChildViewUnder);
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void notifyAllViews(Accessor<ContentViewType> accessor) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2141709826")) {
            ipChange.ipc$dispatch("-2141709826", new Object[]{this, accessor});
        } else if (accessor != 0) {
            for (int i = 0; i < this.mRecyclerView.getChildCount(); i++) {
                View childAt = this.mRecyclerView.getChildAt(i);
                if (childAt != null) {
                    accessor.onAccess(childAt);
                }
            }
        }
    }

    public void notifyDataSetUpdated() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-124590831")) {
            ipChange.ipc$dispatch("-124590831", new Object[]{this});
        } else {
            this.mAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void setDataList(List<DataType> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-848613068")) {
            ipChange.ipc$dispatch("-848613068", new Object[]{this, list});
            return;
        }
        this.mItemList = list;
        this.mAdapter.setDataList(list);
        updateDataList();
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void setLimit(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1822962236")) {
            ipChange.ipc$dispatch("-1822962236", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public void setOnItemInfoListener(PagableViewProvider.OnItemInfoListener onItemInfoListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1465869539")) {
            ipChange.ipc$dispatch("-1465869539", new Object[]{this, onItemInfoListener});
        } else {
            this.mOnItemInfoListener = onItemInfoListener;
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void setPagingContentCreator(PagableViewProvider.PagingContentCreator<ContentViewType> pagingContentCreator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1611331321")) {
            ipChange.ipc$dispatch("-1611331321", new Object[]{this, pagingContentCreator});
            return;
        }
        this.mOnPagingLifecycleListener.setPagingContentCreator(pagingContentCreator);
        this.mAdapter.setPagingContentCreator(pagingContentCreator);
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    @Deprecated
    public void setRoomSwitch(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "791723896")) {
            ipChange.ipc$dispatch("791723896", new Object[]{this, Boolean.valueOf(z)});
        } else {
            enableScrolling(z);
        }
    }

    @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider
    public void updateDataList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-901948788")) {
            ipChange.ipc$dispatch("-901948788", new Object[]{this});
        } else {
            notifyDataSetUpdated();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class DefaultOnPagingLifecycleListener<DataType, ContentViewType> implements PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType>, PagableViewProvider.PagingContentCreator<ContentViewType> {
        private List<PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType>> mInnerListeners = new ArrayList();
        private PagableViewProvider.PagingContentCreator<ContentViewType> mPagingContentCreator;
        private WeakReference<PagableRecyclerViewProvider> outer;

        public DefaultOnPagingLifecycleListener(PagableRecyclerViewProvider pagableRecyclerViewProvider) {
            this.outer = new WeakReference<>(pagableRecyclerViewProvider);
        }

        private void invoke(Accessor<PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType>> accessor) {
            if (accessor != null) {
                for (PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType> onPagingLifecycleListener : this.mInnerListeners) {
                    accessor.onAccess(onPagingLifecycleListener);
                }
            }
        }

        public void addInnerListener(PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType> onPagingLifecycleListener) {
            if (onPagingLifecycleListener != null) {
                this.mInnerListeners.add(onPagingLifecycleListener);
            }
        }

        @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.PagingContentCreator
        public ContentViewType createPageItem() {
            return this.mPagingContentCreator.createPageItem();
        }

        @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
        public void onPageDeinit(final int i, final DataType datatype, final ContentViewType contentviewtype) {
            invoke(new Accessor<PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType>>() { // from class: com.youku.live.livesdk.widgets.container.pagable.PagableRecyclerViewProvider.DefaultOnPagingLifecycleListener.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public /* bridge */ /* synthetic */ void onAccess(Object obj) {
                    onAccess((PagableViewProvider.OnPagingLifecycleListener) ((PagableViewProvider.OnPagingLifecycleListener) obj));
                }

                public void onAccess(PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType> onPagingLifecycleListener) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "555177258")) {
                        ipChange.ipc$dispatch("555177258", new Object[]{this, onPagingLifecycleListener});
                    } else {
                        onPagingLifecycleListener.onPageDeinit(i, datatype, contentviewtype);
                    }
                }
            });
            this.mPagingContentCreator = null;
        }

        @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
        public void onPageIdleChanged(final int i, final DataType datatype, final ContentViewType contentviewtype, final boolean z) {
            invoke(new Accessor<PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType>>() { // from class: com.youku.live.livesdk.widgets.container.pagable.PagableRecyclerViewProvider.DefaultOnPagingLifecycleListener.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public /* bridge */ /* synthetic */ void onAccess(Object obj) {
                    onAccess((PagableViewProvider.OnPagingLifecycleListener) ((PagableViewProvider.OnPagingLifecycleListener) obj));
                }

                public void onAccess(PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType> onPagingLifecycleListener) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-1446709012")) {
                        ipChange.ipc$dispatch("-1446709012", new Object[]{this, onPagingLifecycleListener});
                    } else {
                        onPagingLifecycleListener.onPageIdleChanged(i, datatype, contentviewtype, z);
                    }
                }
            });
        }

        @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
        public void onPageInit(final int i, final DataType datatype, final ContentViewType contentviewtype) {
            invoke(new Accessor<PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType>>() { // from class: com.youku.live.livesdk.widgets.container.pagable.PagableRecyclerViewProvider.DefaultOnPagingLifecycleListener.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public /* bridge */ /* synthetic */ void onAccess(Object obj) {
                    onAccess((PagableViewProvider.OnPagingLifecycleListener) ((PagableViewProvider.OnPagingLifecycleListener) obj));
                }

                public void onAccess(PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType> onPagingLifecycleListener) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "846372014")) {
                        ipChange.ipc$dispatch("846372014", new Object[]{this, onPagingLifecycleListener});
                    } else {
                        onPagingLifecycleListener.onPageInit(i, datatype, contentviewtype);
                    }
                }
            });
        }

        @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
        public void onPageInvisible(final int i, final DataType datatype, final ContentViewType contentviewtype) {
            invoke(new Accessor<PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType>>() { // from class: com.youku.live.livesdk.widgets.container.pagable.PagableRecyclerViewProvider.DefaultOnPagingLifecycleListener.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public /* bridge */ /* synthetic */ void onAccess(Object obj) {
                    onAccess((PagableViewProvider.OnPagingLifecycleListener) ((PagableViewProvider.OnPagingLifecycleListener) obj));
                }

                public void onAccess(PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType> onPagingLifecycleListener) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1701717771")) {
                        ipChange.ipc$dispatch("1701717771", new Object[]{this, onPagingLifecycleListener});
                    } else {
                        onPagingLifecycleListener.onPageInvisible(i, datatype, contentviewtype);
                    }
                }
            });
        }

        @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.OnPagingLifecycleListener
        public void onPageVisible(final int i, final DataType datatype, final ContentViewType contentviewtype) {
            invoke(new Accessor<PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType>>() { // from class: com.youku.live.livesdk.widgets.container.pagable.PagableRecyclerViewProvider.DefaultOnPagingLifecycleListener.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.livesdk.widgets.helper.Accessor
                public /* bridge */ /* synthetic */ void onAccess(Object obj) {
                    onAccess((PagableViewProvider.OnPagingLifecycleListener) ((PagableViewProvider.OnPagingLifecycleListener) obj));
                }

                public void onAccess(PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType> onPagingLifecycleListener) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-300168499")) {
                        ipChange.ipc$dispatch("-300168499", new Object[]{this, onPagingLifecycleListener});
                    } else {
                        onPagingLifecycleListener.onPageVisible(i, datatype, contentviewtype);
                    }
                }
            });
        }

        @Override // com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider.PagingContentCreator
        public void releasePageItem(ContentViewType contentviewtype) {
            this.mPagingContentCreator.releasePageItem(contentviewtype);
        }

        public void setPagingContentCreator(PagableViewProvider.PagingContentCreator<ContentViewType> pagingContentCreator) {
            this.mPagingContentCreator = pagingContentCreator;
        }

        public DefaultOnPagingLifecycleListener() {
        }
    }
}
