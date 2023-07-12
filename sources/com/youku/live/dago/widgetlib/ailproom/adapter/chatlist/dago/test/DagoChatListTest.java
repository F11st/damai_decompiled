package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.test;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.alibaba.fastjson.JSON;
import com.alibaba.gaiax.GXTemplateEngine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.IDagoChatListView;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.DagoCell;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoChatListTest implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DagoChatListTest";
    private static final boolean isDebug = false;
    private static boolean isRunning;
    private static int mCount;
    private Button mClearBtn;
    private IDagoChatListView mDagoChatListView;
    private ViewGroup mRootView;
    private Button mSendMsgBtn;
    private Button mSendMsgThreadBtn;
    private LinearLayout mTestPanel;
    private Runnable runnable = new Runnable() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.test.DagoChatListTest.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1274090557")) {
                ipChange.ipc$dispatch("-1274090557", new Object[]{this});
                return;
            }
            while (DagoChatListTest.isRunning) {
                try {
                    DagoChatListTest.this.sendMessage();
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    private Thread thread;

    public DagoChatListTest(ViewGroup viewGroup, IDagoChatListView iDagoChatListView) {
    }

    private void clear() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1406770094")) {
            ipChange.ipc$dispatch("1406770094", new Object[]{this});
            return;
        }
        this.mDagoChatListView.clear();
        mCount = 0;
    }

    private String getText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1424751752")) {
            return (String) ipChange.ipc$dispatch("1424751752", new Object[]{this});
        }
        int i = mCount;
        mCount = i + 1;
        String valueOf = String.valueOf(i);
        String[] strArr = {getText4(valueOf), getText5(valueOf)};
        return "{\"cell\":" + strArr[(int) (2 * Math.random())] + ",\"bgColor\":26000000,\"borderColor\":26000000,\"borderWidth\":0}";
    }

    private static String getText1(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1148194325")) {
            return (String) ipChange.ipc$dispatch("1148194325", new Object[]{str});
        }
        return "[{\"cache\":false,\"h\":42,\"src\":\"https://gw.alicdn.com/tfs/TB1oTTrFXT7gK0jSZFpXXaTkpXa-108-42.png\",\"type\":\"image\",\"w\":108},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"bold\":true,\"clickData\":\"{\\\"userId\\\":362218495}\",\"color\":\"FFD9D9D9\",\"emoji\":false,\"text\":\"魔方Online\",\"type\":\"text\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"bold\":true,\"color\":\"FFFFFFFF\",\"emoji\":true,\"text\":\"我是一条[酷]文案\",\"type\":\"text\"},{\"color\":\"FF999900\",\"emoji\":false,\"text\":\"count: " + str + "\",\"type\":\"text\"}" + jn1.ARRAY_END_STR;
    }

    private static String getText2(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "225510742")) {
            return (String) ipChange.ipc$dispatch("225510742", new Object[]{str});
        }
        return "[{\"level\":20,\"type\":\"lfUserLevel\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"id\":\"483\",\"type\":\"medal\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"bold\":true,\"clickData\":\"{\\\"userId\\\":1558848224}\",\"color\":\"FFFFB700\",\"emoji\":false,\"text\":\"奋斗的饼干\",\"type\":\"text\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"bold\":true,\"color\":\"FFFFF6DE\",\"emoji\":false,\"text\":\"赠送了\",\"type\":\"text\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"bold\":true,\"color\":\"FFFFB700\",\"emoji\":false,\"text\":\"星星\",\"type\":\"text\"},{\"color\":\"FF999900\",\"emoji\":false,\"text\":\"count: " + str + "\",\"type\":\"text\"}" + jn1.ARRAY_END_STR;
    }

    private static String getText3(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-697172841")) {
            return (String) ipChange.ipc$dispatch("-697172841", new Object[]{str});
        }
        return "[{\"level\":18,\"type\":\"lfUserLevel\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"id\":\"486\",\"type\":\"medal\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"bold\":true,\"clickData\":\"{\\\"userId\\\":1835368892}\",\"color\":\"FFFFB700\",\"emoji\":false,\"text\":\"蟲蟲蜀黍\",\"type\":\"text\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"bold\":true,\"color\":\"FFFFF6DE\",\"emoji\":false,\"text\":\"赠送了\",\"type\":\"text\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"bold\":true,\"color\":\"FFFFB700\",\"emoji\":false,\"text\":\"10个幸运花束\",\"type\":\"text\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"id\":923,\"type\":\"gift\"},{\"color\":\"FF999900\",\"emoji\":false,\"text\":\"count: " + str + "\",\"type\":\"text\"}" + jn1.ARRAY_END_STR;
    }

    private static String getText4(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1619856424") ? (String) ipChange.ipc$dispatch("-1619856424", new Object[]{str}) : "[{\"src\":\"https://r1.ykimg.com/051000005C93873A8B9429D3550F0112\",\"type\":\"face\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"cache\":false,\"h\":42,\"src\":\"https://gw.alicdn.com/tfs/TB19IdxGHH1gK0jSZFwXXc7aXXa-102-42.png\",\"type\":\"image\",\"w\":108},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"bold\":true,\"clickData\":\"{\\\"userId\\\":839169623}\",\"color\":\"FFD9D9D9\",\"emoji\":false,\"text\":\"mofinds\",\"type\":\"text\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"bold\":true,\"color\":\"FFFFF6DE\",\"emoji\":false,\"text\":\"路路路路转粉了\",\"type\":\"text\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"bg\":[\"FFFF8200\",\"FFFFB700\"],\"clickData\":\"{\\\"action\\\":\\\"clickFollowBtn\\\"}\",\"color\":\"FFFFFFFF\",\"hiddenAfterClick\":true,\"text\":\"我也关注\",\"type\":\"button\"}{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},]";
    }

    private static String getText5(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1752427289") ? (String) ipChange.ipc$dispatch("1752427289", new Object[]{str}) : "[{\"src\":\"https://r1.ykimg.com/051000005C93873A8B9429D3550F0112\",\"type\":\"face\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"cache\":false,\"h\":42,\"src\":\"https://gw.alicdn.com/tfs/TB19IdxGHH1gK0jSZFwXXc7aXXa-102-42.png\",\"type\":\"image\",\"w\":108},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"bold\":true,\"clickData\":\"{\\\"userId\\\":839169623}\",\"color\":\"FFD9D9D9\",\"emoji\":false,\"text\":\"mofinds\",\"type\":\"text\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"bold\":true,\"color\":\"FFFFF6DE\",\"emoji\":false,\"text\":\"路路路路路路转粉了了了\",\"type\":\"text\"},{\"color\":\"FFFFFFFF\",\"emoji\":false,\"text\":\" \",\"type\":\"text\"},{\"bg\":[\"FFFF8200\",\"FFFFB700\"],\"clickData\":\"{\\\"action\\\":\\\"clickFollowBtn\\\"}\",\"color\":\"FFFFFFFF\",\"hiddenAfterClick\":true,\"text\":\"我也关注\",\"type\":\"button\"}]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-102314788")) {
            ipChange.ipc$dispatch("-102314788", new Object[]{this});
        } else {
            this.mDagoChatListView.add(new DagoCell(JSON.parseObject(getText())));
        }
    }

    private void startSendMessageThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-328576216")) {
            ipChange.ipc$dispatch("-328576216", new Object[]{this});
            return;
        }
        if (this.thread == null) {
            this.thread = new Thread(this.runnable);
        }
        this.thread.start();
        isRunning = true;
        this.mSendMsgThreadBtn.setText("STOP");
    }

    private void stopSendMessageThread() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-843504300")) {
            ipChange.ipc$dispatch("-843504300", new Object[]{this});
            return;
        }
        isRunning = false;
        if (this.thread != null) {
            this.thread = null;
        }
        this.mSendMsgThreadBtn.setText(GXTemplateEngine.b.STATE_START);
    }

    public void addTestView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "143646595")) {
            ipChange.ipc$dispatch("143646595", new Object[]{this});
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1885045888")) {
            ipChange.ipc$dispatch("-1885045888", new Object[]{this, view});
        } else if (this.mSendMsgBtn == view) {
            sendMessage();
        } else if (this.mSendMsgThreadBtn == view) {
            if (isRunning) {
                stopSendMessageThread();
            } else {
                startSendMessageThread();
            }
        } else if (this.mClearBtn == view) {
            clear();
        }
    }

    public void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1739962828")) {
            ipChange.ipc$dispatch("-1739962828", new Object[]{this});
        }
    }

    public void removeTestView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "919340980")) {
            ipChange.ipc$dispatch("919340980", new Object[]{this});
        }
    }
}
