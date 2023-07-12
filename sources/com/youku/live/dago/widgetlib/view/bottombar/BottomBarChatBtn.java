package com.youku.live.dago.widgetlib.view.bottombar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dago.widgetlib.view.bottombar.BaseBottomBarBtn;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.dsl.usertrack.IUserTracker;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class BottomBarChatBtn extends BaseBottomBarBtn {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "BottomBarChatBtn";
    private static final int WIDTH_DEFAULT = UIUtil.getScreenWidth(AppContextUtils.getApp()) - (((BaseBottomBarBtn.SIZE + BaseBottomBarBtn.MARGIN) * 5) + (BaseBottomBarBtn.PADDING * 2));
    private String mAnchorId;
    private int mLastWidth;
    private String mRoomId;
    private String mScreenId;

    public BottomBarChatBtn(@NonNull Context context, BaseBottomBarBtn.OnBtnClickListener onBtnClickListener) {
        super(context, 0, onBtnClickListener);
        this.mLastWidth = WIDTH_DEFAULT;
        this.mRoomId = "0";
        this.mScreenId = "0";
        this.mAnchorId = "0";
    }

    @Override // com.youku.live.dago.widgetlib.view.bottombar.BaseBottomBarBtn
    public LinearLayout.LayoutParams getBtnLayoutParams() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1577571584") ? (LinearLayout.LayoutParams) ipChange.ipc$dispatch("1577571584", new Object[]{this}) : new LinearLayout.LayoutParams(WIDTH_DEFAULT, -1);
    }

    @Override // com.youku.live.dago.widgetlib.view.bottombar.BaseBottomBarBtn
    public ViewGroup getContentView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-838648772")) {
            return (ViewGroup) ipChange.ipc$dispatch("-838648772", new Object[]{this});
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        textView.setText("聊聊吧~");
        textView.setTextColor(-1);
        textView.setAlpha(0.5f);
        textView.setBackgroundColor(0);
        ImageView imageView = new ImageView(getContext());
        imageView.setImageBitmap(getIcon());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(UIUtil.dip2px(16), UIUtil.dip2px(16));
        layoutParams.leftMargin = BaseBottomBarBtn.PADDING;
        layoutParams.rightMargin = UIUtil.dip2px(4);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView);
        return linearLayout;
    }

    @Override // com.youku.live.dago.widgetlib.view.bottombar.BaseBottomBarBtn
    public Bitmap getIcon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2090210744") ? (Bitmap) ipChange.ipc$dispatch("2090210744", new Object[]{this}) : BitmapFactory.decodeResource(getResources(), R.drawable.dago_pgc_ic_chat_pcel);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-416069683")) {
            ipChange.ipc$dispatch("-416069683", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("spm-name", "board");
            hashMap.put("roomid", this.mRoomId);
            hashMap.put("screenid", this.mScreenId);
            hashMap.put("anchor-id", this.mAnchorId);
            ((IUserTracker) Dsl.getService(IUserTracker.class)).track4Show("a2h0m.room.board.chatbutton", "board_chatbutton", hashMap);
        }
    }

    public void setChatPosition(int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1804388582")) {
            ipChange.ipc$dispatch("1804388582", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d(TAG, "setChatPosition l: " + i);
        if (i + i2 + i3 + i4 == 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
        int i5 = BaseBottomBarBtn.PADDING;
        if (i - i5 > 0) {
            layoutParams.leftMargin = UIUtil.wx2px(i - i5);
            ((ILog) Dsl.getService(ILog.class)).d(TAG, "setChatPosition leftMargin: " + layoutParams.leftMargin);
        }
        if (i3 - i5 > 0) {
            layoutParams.rightMargin = UIUtil.wx2px(i3 - i5);
        }
        if (i2 > 0) {
            layoutParams.topMargin = UIUtil.wx2px(i2);
        }
        if (i4 > 0) {
            layoutParams.bottomMargin = UIUtil.wx2px(i4);
        }
        setLayoutParams(layoutParams);
    }

    public void setChatWidth(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1902062354")) {
            ipChange.ipc$dispatch("-1902062354", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setChatWidth width: " + i);
        int wx2px = UIUtil.wx2px(i);
        ValueAnimator duration = ValueAnimator.ofInt(this.mLastWidth, wx2px).setDuration(100L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.youku.live.dago.widgetlib.view.bottombar.BottomBarChatBtn.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1472477114")) {
                    ipChange2.ipc$dispatch("-1472477114", new Object[]{this, valueAnimator});
                    return;
                }
                BottomBarChatBtn.this.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                BottomBarChatBtn.this.requestLayout();
            }
        });
        duration.start();
        this.mLastWidth = wx2px;
    }

    public void setOpenChat(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "963760958")) {
            ipChange.ipc$dispatch("963760958", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "setOpenChat openChat: " + i);
        if (i == 1 && getVisibility() != 0) {
            setVisibility(0);
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "setOpenChat VISIBLE");
        }
        if (i == 0 && getVisibility() == 0) {
            setVisibility(4);
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "setOpenChat INVISIBLE");
        }
    }

    public void setParams(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1535998143")) {
            ipChange.ipc$dispatch("1535998143", new Object[]{this, str, str2, str3});
            return;
        }
        this.mRoomId = str;
        this.mScreenId = str2;
        this.mAnchorId = str3;
    }
}
