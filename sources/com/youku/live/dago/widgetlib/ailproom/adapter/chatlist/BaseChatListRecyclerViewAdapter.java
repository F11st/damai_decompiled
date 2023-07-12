package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OrangeConfig;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp.OnCellClickListener;
import com.youku.live.dago.widgetlib.util.OrangeUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class BaseChatListRecyclerViewAdapter<T, H extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<H> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    protected static int MAX_CHAT_CACHE_LENGTH = 100;
    protected static int MAX_CHAT_LIST_LENGTH = 100;
    protected OnCellClickListener mCellClickListener;
    protected RecyclerView mRecyclerView;
    private List<T> mLiveCommentItem = new ArrayList();
    private List<T> mCacheList = new ArrayList();
    private List<T> mChatMessage = new ArrayList();
    private boolean supportLastItemScrollToEnd = false;
    private final String LIVE_DANMAKU_GROUP_NAME = OrangeUtil.LIVE_DANMAKU_GROUP_NAME;
    public final String ENABLED_INT = "1";
    public final String DISABLE_INT = "0";

    private void notifyRemoveItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1994204124")) {
            ipChange.ipc$dispatch("1994204124", new Object[]{this, Integer.valueOf(i)});
        } else if (isSlideToBottom()) {
            notifyItemRemoved(i);
        }
    }

    private boolean supportLastItemScrollToEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "370860752")) {
            return ((Boolean) ipChange.ipc$dispatch("370860752", new Object[]{this})).booleanValue();
        }
        String config = OrangeConfig.getInstance().getConfig(OrangeUtil.LIVE_DANMAKU_GROUP_NAME, "LAST_ITEM_SCROLL_END", "0");
        return config != null && config.compareToIgnoreCase("1") == 0;
    }

    public void addCacheData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1215792220")) {
            ipChange.ipc$dispatch("1215792220", new Object[]{this});
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
                        T t = this.mCacheList.get(i);
                        if (this.mLiveCommentItem.size() > getMaxChatListLength()) {
                            this.mLiveCommentItem.remove(0);
                        }
                        this.mLiveCommentItem.add(t);
                    }
                    this.mCacheList.clear();
                    notifyDataSetChanged();
                    scrollToEnd();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "400621132")) {
            ipChange.ipc$dispatch("400621132", new Object[]{this});
            return;
        }
        synchronized (this) {
            this.mLiveCommentItem.clear();
            notifyDataSetChanged();
        }
    }

    public int getChatMessageSize() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1160157408")) {
            return ((Integer) ipChange.ipc$dispatch("-1160157408", new Object[]{this})).intValue();
        }
        List<T> list = this.mChatMessage;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1867474452")) {
            return ((Integer) ipChange.ipc$dispatch("1867474452", new Object[]{this})).intValue();
        }
        synchronized (this) {
            List<T> list = this.mLiveCommentItem;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<T> getLiveCommentItem() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1118003888") ? (List) ipChange.ipc$dispatch("-1118003888", new Object[]{this}) : this.mLiveCommentItem;
    }

    protected int getMaxChatCacheLength() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1612661132") ? ((Integer) ipChange.ipc$dispatch("-1612661132", new Object[]{this})).intValue() : MAX_CHAT_CACHE_LENGTH;
    }

    protected int getMaxChatListLength() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1716760624") ? ((Integer) ipChange.ipc$dispatch("1716760624", new Object[]{this})).intValue() : MAX_CHAT_LIST_LENGTH;
    }

    public int getNewCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "520994513")) {
            return ((Integer) ipChange.ipc$dispatch("520994513", new Object[]{this})).intValue();
        }
        List<T> list = this.mCacheList;
        if (list != null) {
            return list.size();
        }
        return 1;
    }

    public boolean isSlideToBottom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-691368102")) {
            return ((Boolean) ipChange.ipc$dispatch("-691368102", new Object[]{this})).booleanValue();
        }
        RecyclerView recyclerView = this.mRecyclerView;
        return recyclerView != null && recyclerView.computeVerticalScrollExtent() + this.mRecyclerView.computeVerticalScrollOffset() >= this.mRecyclerView.computeVerticalScrollRange();
    }

    public void notifyAddItem(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1605593996")) {
            ipChange.ipc$dispatch("-1605593996", new Object[]{this, t});
            return;
        }
        synchronized (this) {
            this.mChatMessage.add(t);
        }
    }

    public void notifyUpdateLastItem(T t) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "365921672")) {
            ipChange.ipc$dispatch("365921672", new Object[]{this, t});
            return;
        }
        synchronized (this) {
            if (this.mCacheList.size() == 0) {
                if (this.mLiveCommentItem.size() != 0) {
                    int size = this.mLiveCommentItem.size() - 1;
                    this.mLiveCommentItem.set(size, t);
                    notifyItemChanged(size);
                }
            } else {
                List<T> list = this.mCacheList;
                list.set(list.size() - 1, t);
            }
            if (isSlideToBottom() && this.supportLastItemScrollToEnd) {
                scrollToEnd();
            }
        }
    }

    public void notifyUpdateList() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-820575561")) {
            ipChange.ipc$dispatch("-820575561", new Object[]{this});
            return;
        }
        synchronized (this) {
            if (isSlideToBottom()) {
                int size = this.mLiveCommentItem.size();
                this.mLiveCommentItem.addAll(this.mChatMessage);
                if (this.mLiveCommentItem.size() != 0) {
                    notifyItemRangeInserted(size, this.mLiveCommentItem.size() - size);
                }
                if (this.mLiveCommentItem.size() > MAX_CHAT_CACHE_LENGTH) {
                    int size2 = this.mLiveCommentItem.size() - MAX_CHAT_CACHE_LENGTH;
                    for (int i = 0; i < size2; i++) {
                        this.mLiveCommentItem.remove(0);
                        notifyRemoveItem(0);
                    }
                }
                scrollToEnd();
            } else if (this.mCacheList.size() < MAX_CHAT_CACHE_LENGTH) {
                this.mCacheList.addAll(this.mChatMessage);
            }
            this.mChatMessage.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1672085458")) {
            ipChange.ipc$dispatch("1672085458", new Object[]{this, recyclerView});
            return;
        }
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
        this.supportLastItemScrollToEnd = supportLastItemScrollToEnd();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2128299697")) {
            ipChange.ipc$dispatch("-2128299697", new Object[]{this, recyclerView});
        } else {
            super.onDetachedFromRecyclerView(recyclerView);
        }
    }

    public void refreshData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "100682366")) {
            ipChange.ipc$dispatch("100682366", new Object[]{this});
            return;
        }
        try {
            synchronized (this) {
                notifyDataSetChanged();
                scrollToEnd();
            }
        } catch (Exception unused) {
        }
    }

    public void scrollToEnd() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-577089712")) {
            ipChange.ipc$dispatch("-577089712", new Object[]{this});
            return;
        }
        try {
            synchronized (this) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.smoothScrollToPosition(this.mLiveCommentItem.size());
                }
            }
        } catch (Exception unused) {
        }
    }

    public void setLimit(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2031273995")) {
            ipChange.ipc$dispatch("-2031273995", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        synchronized (this) {
            MAX_CHAT_CACHE_LENGTH = i;
            MAX_CHAT_LIST_LENGTH = i;
        }
    }

    public void setOnCellClickListener(OnCellClickListener onCellClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-458914837")) {
            ipChange.ipc$dispatch("-458914837", new Object[]{this, onCellClickListener});
        } else {
            this.mCellClickListener = onCellClickListener;
        }
    }

    public void scrollToEnd(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-709882445")) {
            ipChange.ipc$dispatch("-709882445", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        try {
            synchronized (this) {
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    if (i == -1) {
                        recyclerView.scrollToPosition(this.mLiveCommentItem.size() - 1);
                    } else {
                        recyclerView.scrollToPosition(i);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
