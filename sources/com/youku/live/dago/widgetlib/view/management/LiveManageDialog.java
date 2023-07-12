package com.youku.live.dago.widgetlib.view.management;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dago.widgetlib.view.management.LiveUserInfoData;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.ArrayList;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class LiveManageDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "LiveManageDialog";
    private LiveManageAdapter mAdapter;
    private ListView mListView;
    protected LiveManageController mLiveManageController;
    private LiveUserInfoData.InfoData mLiveUserInfoData;
    private String mRoomId;
    private String mTargetUserId;
    private TextView mTextViewCancel;
    private TextView mTextViewTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class DialogItemEntry {
        public String itemName;
        public View.OnClickListener listener;
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class LiveManageAdapter extends BaseAdapter {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context mContext;
        private List<DialogItemEntry> mListItems;

        public LiveManageAdapter(Context context, List<DialogItemEntry> list) {
            this.mContext = context;
            this.mListItems = list;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-724480275") ? ((Integer) ipChange.ipc$dispatch("-724480275", new Object[]{this})).intValue() : this.mListItems.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "18900253") ? ipChange.ipc$dispatch("18900253", new Object[]{this, Integer.valueOf(i)}) : this.mListItems.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1950629724") ? ((Long) ipChange.ipc$dispatch("-1950629724", new Object[]{this, Integer.valueOf(i)})).longValue() : i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1095630548")) {
                return (View) ipChange.ipc$dispatch("-1095630548", new Object[]{this, Integer.valueOf(i), view, viewGroup});
            }
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            TextView textView = new TextView(this.mContext);
            textView.setTextColor(-16745729);
            textView.setTextSize(20.0f);
            textView.setGravity(17);
            textView.setText(this.mListItems.get(i).itemName);
            frameLayout.addView(textView, new FrameLayout.LayoutParams(-1, UIUtil.dip2px(58)));
            frameLayout.setOnClickListener(this.mListItems.get(i).listener);
            return frameLayout;
        }
    }

    public LiveManageDialog(Context context, LiveManageController liveManageController) {
        super(context, R.C7944style.dago_pgc_live_manage_dialog);
        this.mLiveManageController = liveManageController;
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "996742564")) {
            ipChange.ipc$dispatch("996742564", new Object[]{this});
            return;
        }
        this.mTextViewTitle = (TextView) findViewById(R.id.tv_title);
        this.mListView = (ListView) findViewById(R.id.lf_user_card_listView_id);
        TextView textView = (TextView) findViewById(R.id.btn_cancel);
        this.mTextViewCancel = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageDialog.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1046966042")) {
                    ipChange2.ipc$dispatch("1046966042", new Object[]{this, view});
                } else {
                    LiveManageDialog.this.dismiss();
                }
            }
        });
        this.mTextViewTitle.setText(getDialogTitle());
        LiveManageAdapter liveManageAdapter = new LiveManageAdapter(getContext(), getDialogItems());
        this.mAdapter = liveManageAdapter;
        this.mListView.setAdapter((ListAdapter) liveManageAdapter);
    }

    private void setDialogWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1129215415")) {
            ipChange.ipc$dispatch("1129215415", new Object[]{this});
            return;
        }
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.C7944style.dago_pgc_user_card_bottom_anim);
        }
    }

    public List<DialogItemEntry> getDialogItems() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2045840336")) {
            return (List) ipChange.ipc$dispatch("-2045840336", new Object[]{this});
        }
        ArrayList arrayList = new ArrayList();
        if (LiveManageController.isHasRightManager(this.mLiveUserInfoData.operateUserRights)) {
            arrayList.add(new DialogItemEntry() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageDialog.1
                {
                    this.itemName = LiveManageController.isManager(LiveManageDialog.this.mLiveUserInfoData.targetUserRoles) ? "取消管理员" : "设置为管理员";
                    this.listener = new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageDialog.1.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "1051453540")) {
                                ipChange2.ipc$dispatch("1051453540", new Object[]{this, view});
                                return;
                            }
                            LiveManageDialog.this.dismiss();
                            LiveManageDialog liveManageDialog = LiveManageDialog.this;
                            if (liveManageDialog.mLiveManageController != null) {
                                if (LiveManageController.isManager(liveManageDialog.mLiveUserInfoData.targetUserRoles)) {
                                    LiveManageDialog.this.mLiveManageController.requestManagerCancel();
                                } else {
                                    LiveManageDialog.this.mLiveManageController.requestManagerSet();
                                }
                            }
                        }
                    };
                }
            });
        }
        if (LiveManageController.isHasRightBanSpeak(this.mLiveUserInfoData.operateUserRights)) {
            arrayList.add(new DialogItemEntry() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageDialog.2
                {
                    this.itemName = LiveManageDialog.this.mLiveUserInfoData.targetUserIsBanSpeak == 1 ? "取消禁言" : "禁言";
                    this.listener = new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageDialog.2.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "-1518032859")) {
                                ipChange2.ipc$dispatch("-1518032859", new Object[]{this, view});
                                return;
                            }
                            LiveManageDialog.this.dismiss();
                            if (LiveManageDialog.this.mLiveUserInfoData.targetUserIsBanSpeak == 1) {
                                LiveManageController liveManageController = LiveManageDialog.this.mLiveManageController;
                                if (liveManageController != null) {
                                    liveManageController.requestUserUnBanSpeak();
                                    return;
                                }
                                return;
                            }
                            BanSpeakDialog banSpeakDialog = new BanSpeakDialog(LiveManageDialog.this.getContext(), LiveManageDialog.this.mLiveManageController);
                            banSpeakDialog.setUserInfo(LiveManageDialog.this.mRoomId, LiveManageDialog.this.mTargetUserId);
                            banSpeakDialog.setLiveUserInfoData(LiveManageDialog.this.mLiveUserInfoData);
                            banSpeakDialog.show();
                        }
                    };
                }
            });
        }
        if (LiveManageController.isHasRightKickout(this.mLiveUserInfoData.operateUserRights)) {
            arrayList.add(new DialogItemEntry() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageDialog.3
                {
                    this.itemName = LiveManageDialog.this.mLiveUserInfoData.targetUserIsKickOut == 1 ? "取消踢出" : "踢出";
                    this.listener = new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageDialog.3.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "207448038")) {
                                ipChange2.ipc$dispatch("207448038", new Object[]{this, view});
                                return;
                            }
                            LiveManageDialog.this.dismiss();
                            if (LiveManageDialog.this.mLiveUserInfoData.targetUserIsKickOut == 1) {
                                LiveManageController liveManageController = LiveManageDialog.this.mLiveManageController;
                                if (liveManageController != null) {
                                    liveManageController.requestUserUnKickout();
                                    return;
                                }
                                return;
                            }
                            KickoutDialog kickoutDialog = new KickoutDialog(LiveManageDialog.this.getContext(), LiveManageDialog.this.mLiveManageController);
                            kickoutDialog.setUserInfo(LiveManageDialog.this.mRoomId, LiveManageDialog.this.mTargetUserId);
                            kickoutDialog.setLiveUserInfoData(LiveManageDialog.this.mLiveUserInfoData);
                            kickoutDialog.show();
                        }
                    };
                }
            });
        }
        return arrayList;
    }

    public String getDialogTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1292451553") ? (String) ipChange.ipc$dispatch("1292451553", new Object[]{this}) : "管理";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1972658198")) {
            ipChange.ipc$dispatch("1972658198", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        setContentView(R.C7942layout.dago_pgc_dialog_live_manage_layout);
        setDialogWindow();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setListViewHeight(final int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1163075138")) {
            ipChange.ipc$dispatch("-1163075138", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mListView.post(new Runnable() { // from class: com.youku.live.dago.widgetlib.view.management.LiveManageDialog.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1567521525")) {
                        ipChange2.ipc$dispatch("1567521525", new Object[]{this});
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) LiveManageDialog.this.mListView.getLayoutParams();
                    layoutParams.height = i;
                    LiveManageDialog.this.mListView.setLayoutParams(layoutParams);
                }
            });
        }
    }

    public void setLiveUserInfoData(LiveUserInfoData.InfoData infoData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "267857439")) {
            ipChange.ipc$dispatch("267857439", new Object[]{this, infoData});
        } else {
            this.mLiveUserInfoData = infoData;
        }
    }

    public void setUserInfo(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1783413098")) {
            ipChange.ipc$dispatch("1783413098", new Object[]{this, str, str2});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setUserInfo [roomId: " + str + ", targetUid: " + str2 + jn1.ARRAY_END_STR);
        this.mRoomId = str;
        this.mTargetUserId = str2;
    }
}
