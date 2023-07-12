package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DagoChatListAdapter;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.DagoCell;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoExChatListAdapter extends RecyclerView.Adapter<DagoChatListAdapter.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange = null;
    protected static final int CHAT_MSG_AUTO = 17;
    protected static final int CHAT_MSG_CLEAR = 19;
    protected static final int CHAT_MSG_LAST_UPDATE = 18;
    protected static final int CHAT_MSG_NOTIFY = 16;
    protected static int MAX_CHAT_CACHE_LENGTH = 100;
    protected static int MAX_CHAT_LIST_LENGTH = 100;
    private static final int RENDER_DURATION = 500;
    private static final String TAG = "DagoExChatListAdapter";
    private static boolean isRunning = false;
    private static int mDuratuon = 500;
    protected RecyclerView mRecyclerView;
    protected OnCellClickListener onCellClickListener;
    private Thread thread;
    private List<DagoCell> mNewMessageList = Collections.synchronizedList(new ArrayList());
    private List<DagoCell> mDisplayMessageList = Collections.synchronizedList(new ArrayList());
    private int fontSize = 14;
    private String mGroupName = "";
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DagoExChatListAdapter.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "134932139")) {
                ipChange.ipc$dispatch("134932139", new Object[]{this, message});
                return;
            }
            switch (message.what) {
                case 16:
                    DagoExChatListAdapter.this.updateNotifyDataSetChanged();
                    return;
                case 17:
                    DagoExChatListAdapter.this.updateMsgAuto();
                    return;
                case 18:
                    DagoExChatListAdapter.this.updateMsgLast((DagoCell) message.obj);
                    return;
                case 19:
                    DagoExChatListAdapter.this.updateClearData();
                    return;
                default:
                    return;
            }
        }
    };
    private boolean isLockScrllo = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class RenderRunnable implements Runnable {
        private WeakReference<DagoExChatListAdapter> mAdapterRef;

        RenderRunnable(DagoExChatListAdapter dagoExChatListAdapter) {
            this.mAdapterRef = new WeakReference<>(dagoExChatListAdapter);
        }

        @Override // java.lang.Runnable
        public void run() {
            DagoExChatListAdapter dagoExChatListAdapter;
            while (DagoExChatListAdapter.isRunning) {
                try {
                    dagoExChatListAdapter = this.mAdapterRef.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (dagoExChatListAdapter == null) {
                    return;
                }
                dagoExChatListAdapter.renderMessage();
                Thread.sleep(DagoExChatListAdapter.mDuratuon);
            }
        }
    }

    public DagoExChatListAdapter(OnCellClickListener onCellClickListener) {
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "DagoExChatListAdapter init " + onCellClickListener);
        this.onCellClickListener = onCellClickListener;
    }

    private void scrollToEnd(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-457022781")) {
            ipChange.ipc$dispatch("-457022781", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        try {
            if (this.mRecyclerView != null) {
                int itemCount = getItemCount() - 1;
                if (z) {
                    this.mRecyclerView.smoothScrollToPosition(itemCount);
                } else {
                    this.mRecyclerView.scrollToPosition(itemCount);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateClearData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "735576470")) {
            ipChange.ipc$dispatch("735576470", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "clearMessage");
        this.mNewMessageList.clear();
        this.mDisplayMessageList.clear();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMsgAuto() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "277679037")) {
            ipChange.ipc$dispatch("277679037", new Object[]{this});
            return;
        }
        synchronized (this) {
            if (this.isLockScrllo) {
                return;
            }
            if (this.mNewMessageList.isEmpty()) {
                mDuratuon = 500;
                return;
            }
            mDuratuon = (Math.min(this.mNewMessageList.size(), 10) * 150) + 500;
            if (this.mNewMessageList.size() >= 3) {
                z = false;
            }
            ((ILog) Dsl.getService(ILog.class)).d(TAG, "notifyUpdateList: duratuon: " + mDuratuon + ", isQuick: " + z);
            int size = this.mDisplayMessageList.size();
            this.mDisplayMessageList.addAll(this.mNewMessageList);
            if (this.mDisplayMessageList.size() > 0) {
                notifyItemRangeInserted(size, this.mDisplayMessageList.size() - size);
                if (this.mDisplayMessageList.size() > MAX_CHAT_LIST_LENGTH) {
                    int size2 = this.mDisplayMessageList.size() - MAX_CHAT_LIST_LENGTH;
                    for (int i = 0; i < size2; i++) {
                        this.mDisplayMessageList.remove(0);
                        if (isScrollToBottom()) {
                            notifyItemRemoved(0);
                        }
                    }
                }
            } else {
                notifyDataSetChanged();
            }
            if (z) {
                scrollToEndQuick();
            } else {
                scrollToEndSmooth();
            }
            this.mNewMessageList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMsgLast(DagoCell dagoCell) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2103461870")) {
            ipChange.ipc$dispatch("2103461870", new Object[]{this, dagoCell});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "updateMsgLast");
        synchronized (this) {
            if (this.mNewMessageList.size() == 0) {
                if (this.mDisplayMessageList.size() != 0) {
                    int size = this.mDisplayMessageList.size() - 1;
                    this.mDisplayMessageList.set(size, dagoCell);
                    notifyItemChanged(size);
                    ((ILog) Dsl.getService(ILog.class)).i(TAG, "updateLast" + size);
                }
            } else {
                List<DagoCell> list = this.mNewMessageList;
                list.set(list.size() - 1, dagoCell);
            }
            scrollToEndQuick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNotifyDataSetChanged() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1782911400")) {
            ipChange.ipc$dispatch("-1782911400", new Object[]{this});
            return;
        }
        notifyDataSetChanged();
        scrollToEndQuick();
    }

    public void addMessage(DagoCell dagoCell) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1179033380")) {
            ipChange.ipc$dispatch("1179033380", new Object[]{this, dagoCell});
            return;
        }
        if (this.mNewMessageList.size() >= MAX_CHAT_CACHE_LENGTH) {
            this.mNewMessageList.remove(0);
        }
        this.mNewMessageList.add(dagoCell);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "addMessage: " + this.mNewMessageList.size());
    }

    public void clearMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2071326956")) {
            ipChange.ipc$dispatch("2071326956", new Object[]{this});
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 19;
        this.mHandler.sendMessageAtTime(obtainMessage, uptimeMillis);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2120317779") ? ((Integer) ipChange.ipc$dispatch("2120317779", new Object[]{this})).intValue() : this.mDisplayMessageList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1478730857") ? ((Long) ipChange.ipc$dispatch("-1478730857", new Object[]{this, Integer.valueOf(i)})).longValue() : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1910150266") ? ((Integer) ipChange.ipc$dispatch("1910150266", new Object[]{this, Integer.valueOf(i)})).intValue() : this.mDisplayMessageList.get(i).getCellType();
    }

    public int getNewMessageCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "813837639") ? ((Integer) ipChange.ipc$dispatch("813837639", new Object[]{this})).intValue() : this.mNewMessageList.size();
    }

    public boolean isScrollToBottom() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1082563507")) {
            return ((Boolean) ipChange.ipc$dispatch("-1082563507", new Object[]{this})).booleanValue();
        }
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return false;
        }
        return !recyclerView.canScrollVertically(1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "159559603")) {
            ipChange.ipc$dispatch("159559603", new Object[]{this, recyclerView});
            return;
        }
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "914407576")) {
            ipChange.ipc$dispatch("914407576", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onAttachedToWindow");
        startRenderMessageThread();
    }

    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1662800315")) {
            ipChange.ipc$dispatch("1662800315", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onDetachedFromWindow");
        stopRenderMessageThread();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        if (this.onCellClickListener != null) {
            this.onCellClickListener = null;
        }
    }

    public void renderMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1052518835")) {
            ipChange.ipc$dispatch("1052518835", new Object[]{this});
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 17;
        this.mHandler.sendMessageAtTime(obtainMessage, uptimeMillis);
    }

    public void scrollToEndQuick() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-923512500")) {
            ipChange.ipc$dispatch("-923512500", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "scrollToEndQuick");
        scrollToEnd(false);
    }

    public void scrollToEndSmooth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1852785501")) {
            ipChange.ipc$dispatch("-1852785501", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "scrollToEndSmooth");
        scrollToEnd(true);
    }

    public void setFontSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1574515375")) {
            ipChange.ipc$dispatch("-1574515375", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.fontSize = i;
        }
    }

    public void setLimit(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1942635286")) {
            ipChange.ipc$dispatch("1942635286", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        MAX_CHAT_CACHE_LENGTH = i;
        MAX_CHAT_LIST_LENGTH = i;
    }

    public void setLockScrllo(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1644734454")) {
            ipChange.ipc$dispatch("-1644734454", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d(TAG, "setLockScrllo: " + z);
        synchronized (this) {
            this.isLockScrllo = z;
        }
    }

    public void setOnCellClickListener(OnCellClickListener onCellClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1800444399")) {
            ipChange.ipc$dispatch("-1800444399", new Object[]{this, onCellClickListener});
        } else {
            this.onCellClickListener = onCellClickListener;
        }
    }

    public void setTrueLoveGroupName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-361876152")) {
            ipChange.ipc$dispatch("-361876152", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setTrueLoveGroupName: " + str);
        this.mGroupName = str;
    }

    public void startRenderMessageThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "95163597")) {
            ipChange.ipc$dispatch("95163597", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).v(TAG, "startRenderMessageThread");
        if (this.thread == null) {
            this.thread = new Thread(new RenderRunnable(this));
        }
        this.thread.start();
        isRunning = true;
    }

    public void stopRenderMessageThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1239816171")) {
            ipChange.ipc$dispatch("1239816171", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).v(TAG, "stopRenderMessageThread");
        isRunning = false;
        if (this.thread != null) {
            this.thread = null;
        }
    }

    public void updateLast(DagoCell dagoCell) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1727209475")) {
            ipChange.ipc$dispatch("-1727209475", new Object[]{this, dagoCell});
        } else if (dagoCell == null) {
        } else {
            long uptimeMillis = SystemClock.uptimeMillis();
            Message obtainMessage = this.mHandler.obtainMessage();
            obtainMessage.what = 18;
            obtainMessage.obj = dagoCell;
            this.mHandler.sendMessageAtTime(obtainMessage, uptimeMillis);
            setLockScrllo(true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DagoChatListAdapter.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "553589964")) {
            ipChange.ipc$dispatch("553589964", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        try {
            DagoCell dagoCell = this.mDisplayMessageList.get(i);
            if (viewHolder != null && dagoCell != null && !dagoCell.cell.isEmpty()) {
                viewHolder.chatItemView.setFontSize(this.fontSize);
                viewHolder.chatItemView.setOnItemViewClick(this.onCellClickListener);
                viewHolder.chatItemView.drawCell(dagoCell, this.mGroupName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DagoChatListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "480663786") ? (DagoChatListAdapter.ViewHolder) ipChange.ipc$dispatch("480663786", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new DagoChatListAdapter.ViewHolder(new ChatItemView(viewGroup.getContext()));
    }
}
