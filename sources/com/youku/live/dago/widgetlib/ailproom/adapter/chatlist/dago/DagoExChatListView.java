package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.view.NestRecyclerView;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoExChatListView extends FrameLayout implements View.OnClickListener, IDagoChatListView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoExChatListView";
    private DagoExChatListAdapter mAdapter;
    private NestRecyclerView mChatRecyclerView;
    private String mGroupName;
    private TextView mNewMessageTextView;
    private View mNewMessageTips;
    private SmoothScrollLayoutManager mSmoothScrollLayoutManager;
    private Runnable newMessageTipsRunnable;
    private OnCellClickListener onCellClickListener;

    public DagoExChatListView(@NonNull Context context, OnCellClickListener onCellClickListener) {
        super(context);
        this.newMessageTipsRunnable = new Runnable() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DagoExChatListView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1641404431")) {
                    ipChange.ipc$dispatch("-1641404431", new Object[]{this});
                } else {
                    DagoExChatListView.this.updateNewMsgLayoutStatus();
                }
            }
        };
        this.mGroupName = "";
        this.onCellClickListener = onCellClickListener;
        initView(context);
    }

    private void addNewCacheMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-304549540")) {
            ipChange.ipc$dispatch("-304549540", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "addNewCacheMessage");
        DagoExChatListAdapter dagoExChatListAdapter = this.mAdapter;
        if (dagoExChatListAdapter != null) {
            dagoExChatListAdapter.renderMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideNewMsgLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-684402221")) {
            ipChange.ipc$dispatch("-684402221", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "hideNewMsgLayout");
        View view = this.mNewMessageTips;
        if (view != null && view.getVisibility() == 0) {
            this.mNewMessageTips.setVisibility(8);
        }
        DagoExChatListAdapter dagoExChatListAdapter = this.mAdapter;
        if (dagoExChatListAdapter != null) {
            dagoExChatListAdapter.setLockScrllo(false);
        }
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1758381949")) {
            ipChange.ipc$dispatch("1758381949", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R.C7942layout.dago_pgc_ailp_chat_list, this);
        NestRecyclerView nestRecyclerView = (NestRecyclerView) findViewById(R.id.portrait_chat_recyclerview);
        this.mChatRecyclerView = nestRecyclerView;
        nestRecyclerView.setItemAnimator(null);
        this.mNewMessageTextView = (TextView) findViewById(R.id.portrait_newmsg_tip_text);
        View findViewById = findViewById(R.id.portrait_chat_newmsg_tip);
        this.mNewMessageTips = findViewById;
        findViewById.setVisibility(8);
        this.mNewMessageTips.setOnClickListener(this);
        DagoExChatListAdapter dagoExChatListAdapter = new DagoExChatListAdapter(this.onCellClickListener);
        this.mAdapter = dagoExChatListAdapter;
        dagoExChatListAdapter.setTrueLoveGroupName(this.mGroupName);
        this.mChatRecyclerView.setAdapter(this.mAdapter);
        this.mChatRecyclerView.setLayoutManager(getLayoutManager(context));
        this.mChatRecyclerView.addItemDecoration(new SpaceItemDecoration(5));
        this.mChatRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DagoExChatListView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "2136987690")) {
                    ipChange2.ipc$dispatch("2136987690", new Object[]{this, recyclerView, Integer.valueOf(i)});
                    return;
                }
                super.onScrollStateChanged(recyclerView, i);
                if (i == 0) {
                    if (DagoExChatListView.this.mAdapter.isScrollToBottom()) {
                        DagoExChatListView.this.hideNewMsgLayout();
                    }
                } else if (i == 1) {
                    DagoExChatListView.this.mAdapter.setLockScrllo(true);
                }
            }
        });
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(200L);
        defaultItemAnimator.setRemoveDuration(200L);
        this.mChatRecyclerView.setItemAnimator(defaultItemAnimator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNewMsgLayoutStatus() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "505982490")) {
            ipChange.ipc$dispatch("505982490", new Object[]{this});
        } else if (this.mChatRecyclerView.getScrollState() == 0) {
            DagoExChatListAdapter dagoExChatListAdapter = this.mAdapter;
            if (dagoExChatListAdapter != null && dagoExChatListAdapter.isScrollToBottom()) {
                hideNewMsgLayout();
            } else {
                showNewMsgLayout();
            }
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void add(DagoCell dagoCell) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1502140187")) {
            ipChange.ipc$dispatch("1502140187", new Object[]{this, dagoCell});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "add: " + dagoCell);
        DagoExChatListAdapter dagoExChatListAdapter = this.mAdapter;
        if (dagoExChatListAdapter != null) {
            dagoExChatListAdapter.addMessage(dagoCell);
        }
        removeCallbacks(this.newMessageTipsRunnable);
        post(this.newMessageTipsRunnable);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1235969725")) {
            ipChange.ipc$dispatch("1235969725", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, Constants.TAG_CLEAR_STRING);
        DagoExChatListAdapter dagoExChatListAdapter = this.mAdapter;
        if (dagoExChatListAdapter != null) {
            dagoExChatListAdapter.clearMessage();
        }
    }

    protected RecyclerView.LayoutManager getLayoutManager(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1630514499")) {
            return (RecyclerView.LayoutManager) ipChange.ipc$dispatch("-1630514499", new Object[]{this, context});
        }
        SmoothScrollLayoutManager smoothScrollLayoutManager = new SmoothScrollLayoutManager(context);
        this.mSmoothScrollLayoutManager = smoothScrollLayoutManager;
        smoothScrollLayoutManager.setStackFromEnd(true);
        this.mSmoothScrollLayoutManager.setOrientation(1);
        return this.mSmoothScrollLayoutManager;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1725118958")) {
            ipChange.ipc$dispatch("-1725118958", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onAttachedToWindow");
        DagoExChatListAdapter dagoExChatListAdapter = this.mAdapter;
        if (dagoExChatListAdapter != null) {
            dagoExChatListAdapter.onAttachedToWindow();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "54886353")) {
            ipChange.ipc$dispatch("54886353", new Object[]{this, view});
        } else if (view == this.mNewMessageTips) {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "onClick mNewMessageTips");
            addNewCacheMessage();
            hideNewMsgLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-891494219")) {
            ipChange.ipc$dispatch("-891494219", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "onDetachedFromWindow");
        DagoExChatListAdapter dagoExChatListAdapter = this.mAdapter;
        if (dagoExChatListAdapter != null) {
            dagoExChatListAdapter.onDetachedFromWindow();
        }
        if (this.onCellClickListener != null) {
            this.onCellClickListener = null;
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void setFontSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1639642699")) {
            ipChange.ipc$dispatch("1639642699", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setFontSize: " + i);
        DagoExChatListAdapter dagoExChatListAdapter = this.mAdapter;
        if (dagoExChatListAdapter != null) {
            dagoExChatListAdapter.setFontSize(i);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void setGroupName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1280726910")) {
            ipChange.ipc$dispatch("-1280726910", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setGroupName: " + str);
        this.mGroupName = str;
        if (this.mAdapter != null) {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "setGroupName1: " + str);
            this.mAdapter.setTrueLoveGroupName(this.mGroupName);
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setGroupName2: " + str);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void setLimitSize(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-223138032")) {
            ipChange.ipc$dispatch("-223138032", new Object[]{this, str});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setLimitSize: " + str);
        if (this.mAdapter != null) {
            int i = 100;
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            this.mAdapter.setLimit(i);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void setNewMsgTipStyle(String str, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1787211005")) {
            ipChange.ipc$dispatch("-1787211005", new Object[]{this, str, str2, str3, str4, str5});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setNewMsgTipStyle: " + str);
        if (TextUtils.isEmpty(str)) {
            str = "FF000000";
        }
        TextView textView = this.mNewMessageTextView;
        textView.setTextColor(Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) UIUtil.dip2px(20));
        if (TextUtils.isEmpty(str3)) {
            str3 = "FFFFFFFF";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "FFFFFFFF";
        }
        int dip2px = UIUtil.dip2px(2);
        gradientDrawable.setStroke(dip2px, Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str3));
        gradientDrawable.setColor(Color.parseColor(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str2));
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
        if (AndroidInstantRuntime.support(ipChange, "1578099723")) {
            ipChange.ipc$dispatch("1578099723", new Object[]{this, onCellClickListener});
            return;
        }
        DagoExChatListAdapter dagoExChatListAdapter = this.mAdapter;
        if (dagoExChatListAdapter != null) {
            this.onCellClickListener = onCellClickListener;
            dagoExChatListAdapter.setOnCellClickListener(onCellClickListener);
        }
    }

    protected void showNewMsgLayout() {
        int i;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1015238328")) {
            ipChange.ipc$dispatch("1015238328", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "showNewMsgLayout");
        DagoExChatListAdapter dagoExChatListAdapter = this.mAdapter;
        if (dagoExChatListAdapter == null || this.mNewMessageTextView == null) {
            i = 0;
        } else {
            i = dagoExChatListAdapter.getNewMessageCount();
            TextView textView = this.mNewMessageTextView;
            if (i > 99) {
                str = "99+ 条新消息";
            } else {
                str = i + " 条新消息";
            }
            textView.setText(str);
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "setNewMessageText: " + this.mNewMessageTextView.getText().toString());
            this.mAdapter.setLockScrllo(true);
        }
        View view = this.mNewMessageTips;
        if (view == null || i <= 0) {
            return;
        }
        view.setVisibility(0);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView
    public void updateLast(DagoCell dagoCell) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-558758205")) {
            ipChange.ipc$dispatch("-558758205", new Object[]{this, dagoCell});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "updateLast: " + dagoCell);
        DagoExChatListAdapter dagoExChatListAdapter = this.mAdapter;
        if (dagoExChatListAdapter != null) {
            dagoExChatListAdapter.updateLast(dagoCell);
        }
    }
}
