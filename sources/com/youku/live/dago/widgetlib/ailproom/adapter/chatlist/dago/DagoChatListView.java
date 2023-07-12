package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.DagoCell;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoChatListView extends FrameLayout implements View.OnClickListener, IDagoChatListView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    protected static final int CHAT_LAST_MSG_UPDATE = 6;
    protected static final int CHAT_MSG = 1;
    protected static final int CHAT_MSG_NOTIFY = 3;
    protected static final int CHAT_MSG_UPDATE = 5;
    private static final String TAG = "DagoChatListView";
    private DagoChatListAdapter mAdapter;
    private RecyclerView mChatRecyclerView;
    private int mCurrentOrientation;
    private Handler mHandler;
    private int mLastOrientation;
    private TextView mNewMessageTextView;
    private View mNewMessageTips;
    private Runnable newMessageTipsRunnable;
    private OnCellClickListener onCellClickListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class OnScrollListener extends RecyclerView.OnScrollListener {
        int nNewState;

        private OnScrollListener() {
            this.nNewState = -2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            this.nNewState = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
            if (DagoChatListView.this.mAdapter == null || !DagoChatListView.this.mAdapter.isSlideToBottom()) {
                return;
            }
            DagoChatListView.this.hideNewMsgLayout();
            DagoChatListView.this.addCacheData(false);
        }
    }

    public DagoChatListView(@NonNull Context context, OnCellClickListener onCellClickListener) {
        super(context);
        this.mLastOrientation = 1;
        this.mCurrentOrientation = 1;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DagoChatListView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-302900956")) {
                    ipChange.ipc$dispatch("-302900956", new Object[]{this, message});
                    return;
                }
                DagoCell dagoCell = (DagoCell) message.obj;
                int i = message.what;
                if (i == 1) {
                    ((ILog) Dsl.getService(ILog.class)).v(DagoChatListView.TAG, "handleMessage CHAT_MSG");
                    DagoChatListView.this.updateChatData(dagoCell);
                } else if (i == 3) {
                    ((ILog) Dsl.getService(ILog.class)).v(DagoChatListView.TAG, "handleMessage CHAT_UPDATE");
                    DagoChatListView.this.mAdapter.notifyUpdateList();
                    DagoChatListView.this.mHandler.removeCallbacks(DagoChatListView.this.newMessageTipsRunnable);
                    DagoChatListView.this.mHandler.postDelayed(DagoChatListView.this.newMessageTipsRunnable, 0L);
                } else if (i == 5) {
                    ((ILog) Dsl.getService(ILog.class)).v(DagoChatListView.TAG, "handleMessage CHAT_MSG_UPDATE");
                    DagoChatListView.this.updateLast(dagoCell);
                } else if (i != 6) {
                } else {
                    ((ILog) Dsl.getService(ILog.class)).v(DagoChatListView.TAG, "handleMessage CHAT_LAST_MSG_UPDATE");
                    DagoChatListView.this.mAdapter.notifyUpdateLastItem(dagoCell);
                }
            }
        };
        this.newMessageTipsRunnable = new Runnable() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DagoChatListView.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "359795234")) {
                    ipChange.ipc$dispatch("359795234", new Object[]{this});
                } else if (DagoChatListView.this.mAdapter == null) {
                } else {
                    if (DagoChatListView.this.mAdapter.isSlideToBottom() || DagoChatListView.this.mAdapter.getNewCount() == 0) {
                        DagoChatListView.this.hideNewMsgLayout();
                    } else {
                        DagoChatListView.this.showNewMsgLayout();
                    }
                }
            }
        };
        this.onCellClickListener = onCellClickListener;
        initView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addCacheData(final boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1322688466")) {
            ipChange.ipc$dispatch("1322688466", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "addCacheData");
        RecyclerView recyclerView = this.mChatRecyclerView;
        if (recyclerView != null) {
            recyclerView.post(new Runnable() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DagoChatListView.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "556308739")) {
                        ipChange2.ipc$dispatch("556308739", new Object[]{this});
                    } else if (DagoChatListView.this.mAdapter != null) {
                        DagoChatListView.this.mAdapter.addCacheData(z);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNewMsgLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "291140608")) {
            ipChange.ipc$dispatch("291140608", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "hideNewMsgLayout");
        View view = this.mNewMessageTips;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.mNewMessageTips.setVisibility(8);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1828007152")) {
            ipChange.ipc$dispatch("1828007152", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R.C7942layout.dago_pgc_ailp_chat_list, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.portrait_chat_recyclerview);
        this.mChatRecyclerView = recyclerView;
        recyclerView.setItemAnimator(null);
        this.mNewMessageTips = findViewById(R.id.portrait_chat_newmsg_tip);
        this.mNewMessageTextView = (TextView) findViewById(R.id.portrait_newmsg_tip_text);
        this.mNewMessageTips.setOnClickListener(this);
        DagoChatListAdapter dagoChatListAdapter = new DagoChatListAdapter(this.onCellClickListener);
        this.mAdapter = dagoChatListAdapter;
        this.mChatRecyclerView.setAdapter(dagoChatListAdapter);
        this.mChatRecyclerView.setLayoutManager(getLayoutManager(context));
        this.mChatRecyclerView.addItemDecoration(new SpaceItemDecoration(5));
        this.mChatRecyclerView.addOnScrollListener(new OnScrollListener());
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(200L);
        defaultItemAnimator.setRemoveDuration(200L);
        this.mChatRecyclerView.setItemAnimator(defaultItemAnimator);
        hideNewMsgLayout();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void add(DagoCell dagoCell) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-997815992")) {
            ipChange.ipc$dispatch("-997815992", new Object[]{this, dagoCell});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "add: " + dagoCell);
        if (dagoCell == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = dagoCell;
        this.mHandler.sendMessageAtTime(obtainMessage, uptimeMillis);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-664770896")) {
            ipChange.ipc$dispatch("-664770896", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, Constants.TAG_CLEAR_STRING);
        DagoChatListAdapter dagoChatListAdapter = this.mAdapter;
        if (dagoChatListAdapter != null) {
            dagoChatListAdapter.clearData();
        }
    }

    protected RecyclerView.LayoutManager getLayoutManager(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-363749328")) {
            return (RecyclerView.LayoutManager) ipChange.ipc$dispatch("-363749328", new Object[]{this, context});
        }
        SmoothScrollLayoutManager smoothScrollLayoutManager = new SmoothScrollLayoutManager(context);
        smoothScrollLayoutManager.setStackFromEnd(true);
        smoothScrollLayoutManager.setOrientation(1);
        return smoothScrollLayoutManager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1390806462")) {
            ipChange.ipc$dispatch("1390806462", new Object[]{this, view});
        } else if (view == this.mNewMessageTips) {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "mNewMessageTips onClick");
            addCacheData(true);
            hideNewMsgLayout();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1650937184")) {
            ipChange.ipc$dispatch("-1650937184", new Object[]{this, configuration});
            return;
        }
        super.onConfigurationChanged(configuration);
        int i = this.mCurrentOrientation;
        this.mLastOrientation = i;
        int i2 = configuration.orientation;
        this.mCurrentOrientation = i2;
        if (i2 == 1 && i == 2 && this.mAdapter != null) {
            postDelayed(new Runnable() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DagoChatListView.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "752822244")) {
                        ipChange2.ipc$dispatch("752822244", new Object[]{this});
                    } else {
                        DagoChatListView.this.mAdapter.scrollToEnd();
                    }
                }
            }, 200L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-417358750")) {
            ipChange.ipc$dispatch("-417358750", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void setFontSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2030653704")) {
            ipChange.ipc$dispatch("-2030653704", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        DagoChatListAdapter dagoChatListAdapter = this.mAdapter;
        if (dagoChatListAdapter != null) {
            dagoChatListAdapter.setFontSize(i);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void setGroupName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1836355601")) {
            ipChange.ipc$dispatch("-1836355601", new Object[]{this, str});
            return;
        }
        DagoChatListAdapter dagoChatListAdapter = this.mAdapter;
        if (dagoChatListAdapter != null) {
            dagoChatListAdapter.setTrueLoveGroupName(str);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void setLimitSize(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-778766723")) {
            ipChange.ipc$dispatch("-778766723", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setLimitSize: " + str);
        try {
            this.mAdapter.setLimit(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    protected void setNewMessageText(TextView textView, int i) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1630573114")) {
            ipChange.ipc$dispatch("-1630573114", new Object[]{this, textView, Integer.valueOf(i)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setNewMessageText: " + i);
        if (textView != null) {
            if (i > 99) {
                str = "99+ 条新消息";
            } else {
                str = i + " 条新消息";
            }
            textView.setText(str);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void setNewMsgTipStyle(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-533025610")) {
            ipChange.ipc$dispatch("-533025610", new Object[]{this, str, str2, str3, str4, str5});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "newMsgTipTextColor: " + str);
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "newMsgTipBgColor: " + str2);
        if (!TextUtils.isEmpty(str)) {
            TextView textView = this.mNewMessageTextView;
            textView.setTextColor(Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str));
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(UIUtil.dip2px(20));
        if (!TextUtils.isEmpty(str3)) {
            int dip2px = UIUtil.dip2px(2);
            gradientDrawable.setStroke(dip2px, Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str3));
        }
        if (!TextUtils.isEmpty(str2)) {
            gradientDrawable.setColor(Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str2));
        } else {
            gradientDrawable.setColor(-1);
        }
        findViewById(R.id.tips_root).setBackground(gradientDrawable);
        ImageView imageView = (ImageView) findViewById(R.id.tip_arrow_icon);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        imageView.setColorFilter(Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str));
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void setOnCellClickListener(OnCellClickListener onCellClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1273684168")) {
            ipChange.ipc$dispatch("-1273684168", new Object[]{this, onCellClickListener});
            return;
        }
        DagoChatListAdapter dagoChatListAdapter = this.mAdapter;
        if (dagoChatListAdapter != null) {
            dagoChatListAdapter.setOnCellClickListener(this.onCellClickListener);
        }
    }

    protected void showNewMsgLayout() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1990781157")) {
            ipChange.ipc$dispatch("1990781157", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "showNewMsgLayout");
        DagoChatListAdapter dagoChatListAdapter = this.mAdapter;
        if (dagoChatListAdapter == null || this.mNewMessageTextView == null) {
            i = 0;
        } else {
            i = dagoChatListAdapter.getNewCount();
            setNewMessageText(this.mNewMessageTextView, i);
        }
        View view = this.mNewMessageTips;
        if (view == null || view.getVisibility() != 8 || i <= 0 || this.mChatRecyclerView.getScrollState() != 0) {
            return;
        }
        this.mNewMessageTips.setVisibility(0);
    }

    protected void updateChatData(DagoCell dagoCell) {
        DagoChatListAdapter dagoChatListAdapter;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1470363646")) {
            ipChange.ipc$dispatch("-1470363646", new Object[]{this, dagoCell});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "updateChatData cell: " + dagoCell);
        if (dagoCell == null || (dagoChatListAdapter = this.mAdapter) == null) {
            return;
        }
        dagoChatListAdapter.notifyAddItem(dagoCell);
        if (this.mCurrentOrientation == 2) {
            this.mAdapter.refreshData();
        }
        this.mHandler.sendEmptyMessageAtTime(3, SystemClock.uptimeMillis());
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void updateLast(DagoCell dagoCell) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1625094134")) {
            ipChange.ipc$dispatch("1625094134", new Object[]{this, dagoCell});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "updateLast: " + dagoCell);
        if (dagoCell == null || this.mAdapter == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 6;
        obtainMessage.obj = dagoCell;
        this.mHandler.sendMessageAtTime(obtainMessage, uptimeMillis);
    }
}
