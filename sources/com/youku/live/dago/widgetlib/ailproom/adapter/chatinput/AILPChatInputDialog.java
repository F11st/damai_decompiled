package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.adapter.YellGridlistAdapter;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.adapter.YellInfoBean;
import com.youku.live.dago.widgetlib.ailproom.manager.BaseInfoBean;
import com.youku.live.dago.widgetlib.ailproom.utils.DensityUtil;
import com.youku.live.dago.widgetlib.ailproom.view.ConfigurationChangedRelativeLayout;
import com.youku.live.dago.widgetlib.ailproom.view.flowview.ViewFlowLayout;
import com.youku.live.dago.widgetlib.util.ToastUtil;
import java.util.List;
import tb.jn1;
import tb.ur1;
import tb.wr1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPChatInputDialog extends BaseInputDialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String YELL_TAG;
    private boolean isRotateDismiss;
    private List<BaseInfoBean> mExpressionList;
    private int mOrientation;
    private boolean mShowGif;
    private String mTopic;
    private TextView mTopicText;
    private RecyclerView mYellGridView;
    private Toast toast;
    private boolean weexCallClose;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnInputCompleteListener extends BaseInputDialog.OnInputCompleteListener {
        void onTopicSend(String str);
    }

    public AILPChatInputDialog(@NonNull Context context, int i, int i2, CharSequence charSequence, CharSequence charSequence2, int i3, boolean z, boolean z2, String str, boolean z3, List<BaseInfoBean> list, BaseInputDialog.OnInputCompleteListener onInputCompleteListener) {
        super(context, i, i2, charSequence, charSequence2, onInputCompleteListener);
        this.YELL_TAG = "yell";
        this.toast = null;
        this.weexCallClose = false;
        this.isRotateDismiss = true;
        this.mShowGif = false;
        this.mOrientation = i3;
        this.mHasYell = z;
        this.mShowYell = z2;
        this.mShowGif = z3;
        this.mYellIconUrl = str;
        this.mExpressionList = list;
    }

    private void addExpressionView(Activity activity, List<BaseInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-939329336")) {
            ipChange.ipc$dispatch("-939329336", new Object[]{this, activity, list});
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int dip2px = DensityUtil.dip2px(activity, 1.0f);
        this.mYellGridView = new RecyclerView(getContext());
        this.mYellGridView.setLayoutManager(new GridLayoutManager(activity, 4));
        this.mYellGridView.setOverScrollMode(2);
        this.mYellGridView.setVerticalScrollBarEnabled(false);
        int i = dip2px * 15;
        int i2 = dip2px * 8;
        this.mYellGridView.setPadding(i, i2, i, i2);
        this.mYellGridView.setLayoutParams(layoutParams);
        this.mCustomPanel.addView(this.mYellGridView);
        this.mYellGridView.setTag("yell");
        YellGridlistAdapter yellGridlistAdapter = new YellGridlistAdapter(getContext(), list, (DensityUtil.getScreenWidth() - (dip2px * 30)) / 4, this.mShowGif);
        this.mYellGridView.setAdapter(yellGridlistAdapter);
        yellGridlistAdapter.setOnItemClickListener(new YellGridlistAdapter.OnYellItemClickListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputDialog.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.adapter.YellGridlistAdapter.OnYellItemClickListener
            public void onItemClick(int i3, BaseInfoBean baseInfoBean) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1236857010")) {
                    ipChange2.ipc$dispatch("-1236857010", new Object[]{this, Integer.valueOf(i3), baseInfoBean});
                } else if (baseInfoBean == null || !(baseInfoBean instanceof YellInfoBean)) {
                } else {
                    AILPChatInputDialog aILPChatInputDialog = AILPChatInputDialog.this;
                    aILPChatInputDialog.onInput(jn1.ARRAY_START_STR + ((YellInfoBean) baseInfoBean).tag + jn1.ARRAY_END_STR);
                }
            }
        });
    }

    private void setExpressionData(List<BaseInfoBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072097904")) {
            ipChange.ipc$dispatch("1072097904", new Object[]{this, list});
        } else if (list == null || list.size() == 0 || list.size() <= 0) {
        } else {
            addExpressionView(this.mContext, list);
        }
    }

    private void showTextToast(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1028760304")) {
            ipChange.ipc$dispatch("-1028760304", new Object[]{this, str});
            return;
        }
        Context context = getContext();
        if (context != null) {
            ToastUtil.toast(context, str);
        }
    }

    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1013053803")) {
            ipChange.ipc$dispatch("1013053803", new Object[]{this});
            return;
        }
        this.weexCallClose = true;
        dismiss();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected View getCommitButton() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "909853190") ? (View) ipChange.ipc$dispatch("909853190", new Object[]{this}) : findViewById(R.id.tv_send);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected FrameLayout getCustomPanel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2070880079") ? (FrameLayout) ipChange.ipc$dispatch("2070880079", new Object[]{this}) : (FrameLayout) findViewById(R.id.custom_panel);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected ConfigurationChangedRelativeLayout getEditContainer() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2074832096") ? (ConfigurationChangedRelativeLayout) ipChange.ipc$dispatch("-2074832096", new Object[]{this}) : (ConfigurationChangedRelativeLayout) findViewById(R.id.group_edit_container);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected ImageView getExpressionButton() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-655770003") ? (ImageView) ipChange.ipc$dispatch("-655770003", new Object[]{this}) : (ImageView) findViewById(R.id.iv_expression);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected EditText getInputEditText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1471250549") ? (EditText) ipChange.ipc$dispatch("-1471250549", new Object[]{this}) : (EditText) findViewById(R.id.et_comment_input);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-417681765")) {
            return ((Integer) ipChange.ipc$dispatch("-417681765", new Object[]{this})).intValue();
        }
        if (this.mOrientation == 2) {
            return R.layout.dago_pgc_ailp_chat_edit_bar_fullscreen;
        }
        return R.layout.dago_pgc_ailp_chat_edit_bar;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected TextView getSumTextView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "593647540") ? (TextView) ipChange.ipc$dispatch("593647540", new Object[]{this}) : (TextView) findViewById(R.id.tv_comment_sum_left);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2053133778")) {
            ipChange.ipc$dispatch("2053133778", new Object[]{this});
            return;
        }
        if (this.mHasYell) {
            setExpressionData(this.mExpressionList);
            this.mEditContainer.setConfigurationListener(new ViewFlowLayout.ConfigurationListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputDialog.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.ailproom.view.flowview.ViewFlowLayout.ConfigurationListener
                public void onConfigurationChanged(Configuration configuration) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1746169064")) {
                        ipChange2.ipc$dispatch("-1746169064", new Object[]{this, configuration});
                    } else if (AILPChatInputDialog.this.isRotateDismiss && AILPChatInputDialog.this.isShowing()) {
                        AILPChatInputDialog.this.close();
                        AILPChatInputDialog.this.release();
                    }
                }
            });
            this.mExpressionButton.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputDialog.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1591939143")) {
                        ipChange2.ipc$dispatch("1591939143", new Object[]{this, view});
                    } else if (AILPChatInputDialog.this.mCustomPanel.getVisibility() == 0) {
                        AILPChatInputDialog.this.hideExpressionboard();
                        AILPChatInputDialog.this.mInputEditText.requestFocus();
                        AILPChatInputDialog aILPChatInputDialog = AILPChatInputDialog.this;
                        aILPChatInputDialog.mInputMethodManager.showSoftInput(aILPChatInputDialog.mInputEditText, 0);
                    } else {
                        AILPChatInputDialog.this.showExpressionboard();
                    }
                }
            });
        }
        if (this.mOrientation == 2) {
            this.mExpressionButton.setVisibility(8);
            if (this.mCustomPanel.getVisibility() != 8) {
                switchExpressionButton(false);
                this.mCustomPanel.setVisibility(8);
            }
        }
        TextView textView = (TextView) findViewById(R.id.chat_topic_text_btn);
        this.mTopicText = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputDialog.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-591737784")) {
                    ipChange2.ipc$dispatch("-591737784", new Object[]{this, view});
                    return;
                }
                BaseInputDialog.OnInputCompleteListener onInputCompleteListener = AILPChatInputDialog.this.getOnInputCompleteListener();
                if (AILPChatInputDialog.this.mTopic == null || onInputCompleteListener == null || !(onInputCompleteListener instanceof OnInputCompleteListener)) {
                    return;
                }
                ((OnInputCompleteListener) onInputCompleteListener).onTopicSend(AILPChatInputDialog.this.mTopic);
            }
        });
        if (!TextUtils.isEmpty(this.mTopic)) {
            this.mTopicText.setVisibility(0);
            this.mTopicText.setText(this.mTopic);
            this.mTopicText.setTag(this.mTopic);
        }
        if (!TextUtils.isEmpty(this.mYellIconUrl)) {
            wr1 s = ur1.o().s(this.mYellIconUrl);
            int i = R.drawable.dago_pgc_chat_expression_default_bg;
            s.H(i).k(i).y(this.mExpressionButton);
        } else if (this.mOrientation == 2) {
            this.mExpressionButton.setImageResource(R.drawable.dago_pgc_yell_landscape_icon);
        } else {
            this.mExpressionButton.setImageResource(R.drawable.dago_pgc_yell_portrait_icon);
        }
    }

    public boolean isWeexCallClose() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-56557480") ? ((Boolean) ipChange.ipc$dispatch("-56557480", new Object[]{this})).booleanValue() : this.weexCallClose;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected void onEmptyInput() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-639352437")) {
            ipChange.ipc$dispatch("-639352437", new Object[]{this});
        } else {
            showTextToast("请输入聊天内容");
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected void onInput(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-738897284")) {
            ipChange.ipc$dispatch("-738897284", new Object[]{this, charSequence});
            return;
        }
        BaseInputDialog.OnInputCompleteListener onInputCompleteListener = getOnInputCompleteListener();
        if (onInputCompleteListener != null) {
            onInputCompleteListener.onInputComplete(charSequence);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected void onOverMaxLength(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "86537100")) {
            ipChange.ipc$dispatch("86537100", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        showTextToast("聊天不能超过" + String.valueOf(i2) + "字");
    }

    public void refreshYellData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1436702734")) {
            ipChange.ipc$dispatch("-1436702734", new Object[]{this});
            return;
        }
        RecyclerView recyclerView = this.mYellGridView;
        if (recyclerView == null || recyclerView.getAdapter() == null) {
            return;
        }
        this.mYellGridView.getAdapter().notifyDataSetChanged();
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected void release() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-815448708")) {
            ipChange.ipc$dispatch("-815448708", new Object[]{this});
            return;
        }
        FrameLayout frameLayout = this.mCustomPanel;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected void setCommitButtonStatus(View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-58178072")) {
            ipChange.ipc$dispatch("-58178072", new Object[]{this, view, Boolean.valueOf(z)});
        } else if (z) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(-1);
            }
            view.setBackground(getContext().getResources().getDrawable(R.drawable.dago_pgc_ailp_chat_fullscreen_btn_background));
        } else {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(-4473925);
            }
            view.setBackground(getContext().getResources().getDrawable(R.drawable.dago_pgc_ailp_chat_edit_small_send_btn_background));
        }
    }

    public void setRotateDismiss(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "331125978")) {
            ipChange.ipc$dispatch("331125978", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isRotateDismiss = z;
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected void setSumTextView(TextView textView, boolean z, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-711329497")) {
            ipChange.ipc$dispatch("-711329497", new Object[]{this, textView, Boolean.valueOf(z), Integer.valueOf(i)});
        } else if (z) {
            textView.setText("-" + i + "");
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
        } else {
            if (this.mOrientation == 2) {
                textView.setTextColor(-1);
            } else {
                textView.setTextColor(-5131855);
            }
            textView.setText(i + "");
        }
    }

    public void setTopic(String str) {
        TextView textView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1099672580")) {
            ipChange.ipc$dispatch("1099672580", new Object[]{this, str});
            return;
        }
        this.mTopic = str;
        if (TextUtils.isEmpty(str) || (textView = this.mTopicText) == null) {
            return;
        }
        textView.setVisibility(0);
        this.mTopicText.setText(this.mTopic);
        this.mTopicText.setTag(this.mTopic);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog
    protected void switchExpressionButton(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1361059243")) {
            ipChange.ipc$dispatch("1361059243", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mExpressionButton.setImageResource(R.drawable.dago_pgc_keyboard_icon);
        } else if (!TextUtils.isEmpty(this.mYellIconUrl)) {
            wr1 s = ur1.o().s(this.mYellIconUrl);
            int i = R.drawable.dago_pgc_chat_expression_default_bg;
            s.H(i).k(i).y(this.mExpressionButton);
        } else if (this.mOrientation == 2) {
            this.mExpressionButton.setImageResource(R.drawable.dago_pgc_yell_landscape_icon);
        } else {
            this.mExpressionButton.setImageResource(R.drawable.dago_pgc_yell_portrait_icon);
        }
    }
}
