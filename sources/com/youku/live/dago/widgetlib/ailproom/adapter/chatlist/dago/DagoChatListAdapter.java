package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.DagoCell;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoChatListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    protected static int MAX_CHAT_CACHE_LENGTH = 100;
    protected static int MAX_CHAT_LIST_LENGTH = 100;
    private static final String TAG = "DagoChatListAdapter";
    protected RecyclerView mRecyclerView;
    protected OnCellClickListener onCellClickListener;
    private List<DagoCell> mLiveCommentItem = new ArrayList();
    private List<DagoCell> mCacheList = new ArrayList();
    private List<DagoCell> mNewChatMessage = new ArrayList();
    private int fontSize = 14;
    private String groupName = "";

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ChatItemView chatItemView;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ViewHolder(View view) {
            super(view);
            this.chatItemView = (ChatItemView) view;
        }
    }

    public DagoChatListAdapter(OnCellClickListener onCellClickListener) {
        this.onCellClickListener = onCellClickListener;
    }

    private void notifyRemoveItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1620326826")) {
            ipChange.ipc$dispatch("1620326826", new Object[]{this, Integer.valueOf(i)});
        } else if (isSlideToBottom()) {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "notifyRemoveItem: " + i);
            notifyItemRemoved(i);
        }
    }

    public void addCacheData(boolean z) {
        IpChange ipChange = $ipChange;
        boolean z2 = true;
        if (AndroidInstantRuntime.support(ipChange, "-741349690")) {
            ipChange.ipc$dispatch("-741349690", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        try {
            synchronized (this) {
                if (this.mRecyclerView != null) {
                    if (this.mCacheList.size() == 0) {
                        return;
                    }
                    int size = this.mCacheList.size();
                    for (int i = 0; i < size; i++) {
                        DagoCell dagoCell = this.mCacheList.get(i);
                        if (this.mLiveCommentItem.size() > getMaxChatListLength()) {
                            this.mLiveCommentItem.remove(0);
                        }
                        this.mLiveCommentItem.add(dagoCell);
                    }
                    this.mCacheList.clear();
                    notifyDataSetChanged();
                    if (z) {
                        z2 = false;
                    }
                    scrollToEnd(z2);
                    ((ILog) Dsl.getService(ILog.class)).i(TAG, "addCacheData");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "704234010")) {
            ipChange.ipc$dispatch("704234010", new Object[]{this});
            return;
        }
        synchronized (this) {
            this.mLiveCommentItem.clear();
            notifyDataSetChanged();
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "clearData notifyDataSetChanged");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1597597574")) {
            return ((Integer) ipChange.ipc$dispatch("1597597574", new Object[]{this})).intValue();
        }
        synchronized (this) {
            List<DagoCell> list = this.mLiveCommentItem;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "706197642") ? ((Long) ipChange.ipc$dispatch("706197642", new Object[]{this, Integer.valueOf(i)})).longValue() : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "262876973") ? ((Integer) ipChange.ipc$dispatch("262876973", new Object[]{this, Integer.valueOf(i)})).intValue() : this.mLiveCommentItem.get(i).getCellType();
    }

    protected int getMaxChatListLength() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "388374434") ? ((Integer) ipChange.ipc$dispatch("388374434", new Object[]{this})).intValue() : MAX_CHAT_LIST_LENGTH;
    }

    public int getNewCount() {
        int size;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "235194143")) {
            return ((Integer) ipChange.ipc$dispatch("235194143", new Object[]{this})).intValue();
        }
        if (this.mCacheList != null) {
            try {
                synchronized (this) {
                    ((ILog) Dsl.getService(ILog.class)).i(TAG, "getNewCount: " + this.mCacheList.size());
                    size = this.mCacheList.size();
                }
                return size;
            } catch (Exception unused) {
            }
        }
        return 1;
    }

    public boolean isSlideToBottom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-414662488")) {
            return ((Boolean) ipChange.ipc$dispatch("-414662488", new Object[]{this})).booleanValue();
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return false;
        }
        return !recyclerView.canScrollVertically(1);
    }

    public void notifyAddItem(DagoCell dagoCell) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-967081986")) {
            ipChange.ipc$dispatch("-967081986", new Object[]{this, dagoCell});
            return;
        }
        synchronized (this) {
            this.mNewChatMessage.add(dagoCell);
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "notifyAddItem: " + dagoCell);
        }
    }

    public void notifyUpdateLastItem(DagoCell dagoCell) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1539237306")) {
            ipChange.ipc$dispatch("-1539237306", new Object[]{this, dagoCell});
            return;
        }
        synchronized (this) {
            if (this.mCacheList.size() == 0) {
                if (this.mLiveCommentItem.size() != 0) {
                    int size = this.mLiveCommentItem.size() - 1;
                    this.mLiveCommentItem.set(size, dagoCell);
                    notifyItemChanged(size);
                    ((ILog) Dsl.getService(ILog.class)).i(TAG, "notifyItemChanged" + size);
                }
            } else {
                List<DagoCell> list = this.mCacheList;
                list.set(list.size() - 1, dagoCell);
            }
            scrollToEnd();
        }
    }

    public void notifyUpdateList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-832636119")) {
            ipChange.ipc$dispatch("-832636119", new Object[]{this});
            return;
        }
        synchronized (this) {
            if (isSlideToBottom()) {
                int size = this.mLiveCommentItem.size();
                this.mLiveCommentItem.addAll(this.mNewChatMessage);
                if (this.mLiveCommentItem.size() != 0) {
                    notifyItemRangeInserted(size, this.mLiveCommentItem.size() - size);
                    ((ILog) Dsl.getService(ILog.class)).d(TAG, "notifyUpdateList notifyItemRangeInserted: start= " + size + ", itemCount= " + (this.mLiveCommentItem.size() - size));
                }
                if (this.mLiveCommentItem.size() > MAX_CHAT_CACHE_LENGTH) {
                    int size2 = this.mLiveCommentItem.size() - MAX_CHAT_CACHE_LENGTH;
                    for (int i = 0; i < size2; i++) {
                        this.mLiveCommentItem.remove(0);
                        notifyRemoveItem(0);
                        ((ILog) Dsl.getService(ILog.class)).d(TAG, "notifyUpdateList notifyRemoveItem");
                    }
                }
                scrollToEnd();
            } else if (this.mCacheList.size() < MAX_CHAT_CACHE_LENGTH) {
                this.mCacheList.addAll(this.mNewChatMessage);
            }
            this.mNewChatMessage.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "352568864")) {
            ipChange.ipc$dispatch("352568864", new Object[]{this, recyclerView});
            return;
        }
        super.onAttachedToRecyclerView(recyclerView);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onAttachedToRecyclerView: " + recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1126573085")) {
            ipChange.ipc$dispatch("1126573085", new Object[]{this, recyclerView});
            return;
        }
        super.onDetachedFromRecyclerView(recyclerView);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onDetachedFromRecyclerView: " + recyclerView);
    }

    public void refreshData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-185118004")) {
            ipChange.ipc$dispatch("-185118004", new Object[]{this});
            return;
        }
        try {
            synchronized (this) {
                notifyDataSetChanged();
                scrollToEnd();
                ((ILog) Dsl.getService(ILog.class)).i(TAG, "refreshData");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollToEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-862890082")) {
            ipChange.ipc$dispatch("-862890082", new Object[]{this});
        } else {
            scrollToEnd(true);
        }
    }

    public void setFontSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2097235580")) {
            ipChange.ipc$dispatch("-2097235580", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.fontSize = i;
        }
    }

    public void setLimit(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1727661117")) {
            ipChange.ipc$dispatch("-1727661117", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        synchronized (this) {
            MAX_CHAT_CACHE_LENGTH = i;
            MAX_CHAT_LIST_LENGTH = i;
        }
    }

    public void setOnCellClickListener(OnCellClickListener onCellClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-546259004")) {
            ipChange.ipc$dispatch("-546259004", new Object[]{this, onCellClickListener});
        } else {
            this.onCellClickListener = onCellClickListener;
        }
    }

    public void setTrueLoveGroupName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "52262843")) {
            ipChange.ipc$dispatch("52262843", new Object[]{this, str});
        } else {
            this.groupName = str;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1634393025")) {
            ipChange.ipc$dispatch("-1634393025", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        try {
            synchronized (this) {
                DagoCell dagoCell = this.mLiveCommentItem.get(i);
                if (viewHolder != null && dagoCell != null && !dagoCell.cell.isEmpty()) {
                    viewHolder.chatItemView.setFontSize(this.fontSize);
                    viewHolder.chatItemView.setOnItemViewClick(this.onCellClickListener);
                    viewHolder.chatItemView.drawCell(dagoCell, this.groupName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1179219753") ? (ViewHolder) ipChange.ipc$dispatch("-1179219753", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder(new ChatItemView(viewGroup.getContext()));
    }

    public void scrollToEnd(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-979742986")) {
            ipChange.ipc$dispatch("-979742986", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        try {
            synchronized (this) {
                if (this.mRecyclerView != null) {
                    ((ILog) Dsl.getService(ILog.class)).i(TAG, "scrollToEnd: " + this.mLiveCommentItem.size());
                    if (z) {
                        this.mRecyclerView.smoothScrollToPosition(this.mLiveCommentItem.size());
                    } else {
                        this.mRecyclerView.scrollToPosition(getItemCount() - 1);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
