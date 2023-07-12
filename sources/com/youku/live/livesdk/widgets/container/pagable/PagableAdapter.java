package com.youku.live.livesdk.widgets.container.pagable;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.widgets.container.interfaces.PagableViewProvider;
import com.youku.live.widgets.protocol.IDestroyable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PagableAdapter<DataType, ContentViewType extends View> extends RecyclerView.Adapter<PagableViewHolder<DataType>> implements IDestroyable {
    private static transient /* synthetic */ IpChange $ipChange;
    private LiveViewCacher<ContentViewType> contentViewCacher;
    private List<DataType> mDataList;
    private PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType> mLifecycleListener;
    private PagableViewProvider.PagingContentCreator<ContentViewType> mPagingContentCreator;
    private boolean mOnFirstAppear = true;
    private int mTopSpace = 0;
    private int mBottomSpace = 0;

    public PagableAdapter(List<DataType> list) {
        this.mDataList = list;
    }

    private LiveViewCacher<ContentViewType> getContentViewCache() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "423512842")) {
            return (LiveViewCacher) ipChange.ipc$dispatch("423512842", new Object[]{this});
        }
        if (this.contentViewCacher == null) {
            synchronized (this) {
                if (this.contentViewCacher == null) {
                    this.contentViewCacher = new LiveViewCacher<>();
                }
            }
        }
        return this.contentViewCacher;
    }

    @Override // com.youku.live.widgets.protocol.IDestroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1393417367")) {
            ipChange.ipc$dispatch("1393417367", new Object[]{this});
        } else {
            getContentViewCache().destroy();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-54966074")) {
            return ((Integer) ipChange.ipc$dispatch("-54966074", new Object[]{this})).intValue();
        }
        List<DataType> list = this.mDataList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1285482954") ? ((Long) ipChange.ipc$dispatch("1285482954", new Object[]{this, Integer.valueOf(i)})).longValue() : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void noitfyFirstAppear(DataType datatype, ContentViewType contentviewtype) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741649237")) {
            ipChange.ipc$dispatch("-1741649237", new Object[]{this, datatype, contentviewtype});
        } else if (this.mOnFirstAppear) {
            this.mLifecycleListener.onPageIdleChanged(0, datatype, contentviewtype, true);
            this.mOnFirstAppear = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((PagableViewHolder) ((PagableViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return onFailedToRecycleView((PagableViewHolder) ((PagableViewHolder) viewHolder));
    }

    public boolean onFailedToRecycleView(PagableViewHolder<DataType> pagableViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2140540383")) {
            return ((Boolean) ipChange.ipc$dispatch("2140540383", new Object[]{this, pagableViewHolder})).booleanValue();
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        onViewAttachedToWindow((PagableViewHolder) ((PagableViewHolder) viewHolder));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        onViewDetachedFromWindow((PagableViewHolder) ((PagableViewHolder) viewHolder));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        onViewRecycled((PagableViewHolder) ((PagableViewHolder) viewHolder));
    }

    public void setDataList(List<DataType> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "300349848")) {
            ipChange.ipc$dispatch("300349848", new Object[]{this, list});
        } else {
            this.mDataList = list;
        }
    }

    public void setExtraSpace(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1467925479")) {
            ipChange.ipc$dispatch("-1467925479", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.mTopSpace = i;
        this.mBottomSpace = i2;
    }

    public void setPagingContentCreator(PagableViewProvider.PagingContentCreator<ContentViewType> pagingContentCreator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1009007723")) {
            ipChange.ipc$dispatch("1009007723", new Object[]{this, pagingContentCreator});
        } else {
            this.mPagingContentCreator = pagingContentCreator;
        }
    }

    public void setPagingLifecycleListener(PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType> onPagingLifecycleListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "170136442")) {
            ipChange.ipc$dispatch("170136442", new Object[]{this, onPagingLifecycleListener});
        } else {
            this.mLifecycleListener = onPagingLifecycleListener;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBindViewHolder(PagableViewHolder<DataType> pagableViewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1735727220")) {
            ipChange.ipc$dispatch("-1735727220", new Object[]{this, pagableViewHolder, Integer.valueOf(i)});
            return;
        }
        List<DataType> list = this.mDataList;
        if (list != null) {
            DataType datatype = list.get(i);
            PagableViewProvider.OnPagingLifecycleListener<DataType, ContentViewType> onPagingLifecycleListener = this.mLifecycleListener;
            if (onPagingLifecycleListener != 0) {
                onPagingLifecycleListener.onPageInit(i, datatype, pagableViewHolder.itemView);
            }
            pagableViewHolder.update(datatype);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PagableViewHolder<DataType> onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-390471062") ? (PagableViewHolder) ipChange.ipc$dispatch("-390471062", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new PagableViewHolder<>(this.mPagingContentCreator.createPageItem());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onViewAttachedToWindow(PagableViewHolder<DataType> pagableViewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1934034991")) {
            ipChange.ipc$dispatch("-1934034991", new Object[]{this, pagableViewHolder});
        } else if (this.mDataList == null || this.mLifecycleListener == null) {
        } else {
            View view = pagableViewHolder.itemView;
            int adapterPosition = pagableViewHolder.getAdapterPosition();
            RecyclerView recyclerView = (RecyclerView) view.getParent();
            if (adapterPosition < 0 || adapterPosition >= this.mDataList.size()) {
                adapterPosition = recyclerView.getChildAdapterPosition(view);
            }
            if (pagableViewHolder.getPreviousVisibility() == 0 || view.getTop() == view.getBottom()) {
                return;
            }
            if ((view.getTop() < this.mTopSpace || view.getTop() > recyclerView.getHeight() - this.mBottomSpace) && (view.getBottom() > recyclerView.getHeight() - this.mBottomSpace || view.getBottom() <= this.mTopSpace)) {
                return;
            }
            DataType datatype = this.mDataList.get(adapterPosition);
            if (adapterPosition == 0) {
                Log.d("SlideOp", "from attach");
                this.mLifecycleListener.onPageVisible(adapterPosition, datatype, pagableViewHolder.itemView);
                pagableViewHolder.updateVisibility(0);
                noitfyFirstAppear(datatype, pagableViewHolder.itemView);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onViewDetachedFromWindow(PagableViewHolder<DataType> pagableViewHolder) {
        int adapterPosition;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1308546060")) {
            ipChange.ipc$dispatch("-1308546060", new Object[]{this, pagableViewHolder});
        } else if (this.mDataList == null || this.mLifecycleListener == null || (adapterPosition = pagableViewHolder.getAdapterPosition()) < 0 || adapterPosition >= this.mDataList.size()) {
        } else {
            DataType datatype = this.mDataList.get(adapterPosition);
            Log.d("SlideOp", "from detach");
            if (pagableViewHolder.getPreviousVisibility() != 4) {
                this.mLifecycleListener.onPageInvisible(adapterPosition, datatype, pagableViewHolder.itemView);
                pagableViewHolder.updateVisibility(4);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onViewRecycled(PagableViewHolder<DataType> pagableViewHolder) {
        int adapterPosition;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "25217391")) {
            ipChange.ipc$dispatch("25217391", new Object[]{this, pagableViewHolder});
        } else if (this.mDataList == null || this.mLifecycleListener == null || (adapterPosition = pagableViewHolder.getAdapterPosition()) < 0 || adapterPosition >= this.mDataList.size()) {
        } else {
            DataType datatype = this.mDataList.get(adapterPosition);
            this.mLifecycleListener.onPageIdleChanged(adapterPosition, datatype, pagableViewHolder.itemView, false);
            this.mLifecycleListener.onPageDeinit(adapterPosition, datatype, pagableViewHolder.itemView);
            int mode = LiveViewCacher.getMode();
            if (mode == 1 || mode == 2) {
                this.mPagingContentCreator.releasePageItem(pagableViewHolder.itemView);
            }
            if (LiveViewCacher.getMode() != 2) {
                return;
            }
            getContentViewCache().recyclerView((ContentViewType) pagableViewHolder.itemView);
        }
    }
}
