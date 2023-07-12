package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.view.ConfigurationChangedRelativeLayout;
import com.youku.live.dago.widgetlib.ailproom.view.flowview.FlowBean;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public abstract class BaseInputDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    protected int MAX_CHAT_INPUT_LENGTH;
    private View mCommitButton;
    protected Activity mContext;
    protected FrameLayout mCustomPanel;
    private CharSequence mDefaultText;
    protected ConfigurationChangedRelativeLayout mEditContainer;
    protected ImageView mExpressionButton;
    protected List<FlowBean> mExpressionList;
    protected boolean mHasYell;
    private CharSequence mHint;
    protected EditText mInputEditText;
    private OnInputCompleteListener mInputListener;
    protected InputMethodManager mInputMethodManager;
    private CharSequence mLastInput;
    protected boolean mShowYell;
    private TextView mSumTextView;
    protected String mYellIconUrl;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnInputCompleteListener {
        void onInputComplete(CharSequence charSequence);
    }

    public BaseInputDialog(@NonNull Context context) {
        this(context, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getSpaceCount(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-879841528")) {
            return ((Integer) ipChange.ipc$dispatch("-879841528", new Object[]{charSequence})).intValue();
        }
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage() {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "792499313")) {
            ipChange.ipc$dispatch("792499313", new Object[]{this});
        } else if (this.mInputListener == null) {
        } else {
            int spaceCount = getSpaceCount(this.mInputEditText.getText());
            int i = this.MAX_CHAT_INPUT_LENGTH;
            if (spaceCount > i) {
                onOverMaxLength(spaceCount, i);
                return;
            }
            Editable text = this.mInputEditText.getText();
            if ((TextUtils.isEmpty(text) || TextUtils.isEmpty(text.toString().trim())) ? true : true) {
                onEmptyInput();
            } else {
                onInput(text);
            }
        }
    }

    protected TextWatcher createTextWatcher() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-965049861") ? (TextWatcher) ipChange.ipc$dispatch("-965049861", new Object[]{this}) : new TextWatcher() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog.7
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1774084857")) {
                    ipChange2.ipc$dispatch("1774084857", new Object[]{this, editable});
                    return;
                }
                BaseInputDialog baseInputDialog = BaseInputDialog.this;
                baseInputDialog.mLastInput = baseInputDialog.mInputEditText.getText().toString();
                BaseInputDialog baseInputDialog2 = BaseInputDialog.this;
                int spaceCount = baseInputDialog2.MAX_CHAT_INPUT_LENGTH - BaseInputDialog.getSpaceCount(baseInputDialog2.mLastInput);
                BaseInputDialog baseInputDialog3 = BaseInputDialog.this;
                baseInputDialog3.setSumTextView(baseInputDialog3.mSumTextView, spaceCount < 0, Math.abs(spaceCount));
                BaseInputDialog baseInputDialog4 = BaseInputDialog.this;
                baseInputDialog4.setCommitButtonStatus(baseInputDialog4.mCommitButton, BaseInputDialog.getSpaceCount(BaseInputDialog.this.mLastInput) > 0);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1112847126")) {
                    ipChange2.ipc$dispatch("-1112847126", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "197396106")) {
                    ipChange2.ipc$dispatch("197396106", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                }
            }
        };
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-225844506")) {
            ipChange.ipc$dispatch("-225844506", new Object[]{this});
            return;
        }
        InputMethodManager inputMethodManager = this.mInputMethodManager;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.mInputEditText.getWindowToken(), 0);
        }
        super.dismiss();
    }

    protected abstract View getCommitButton();

    protected abstract FrameLayout getCustomPanel();

    protected abstract ConfigurationChangedRelativeLayout getEditContainer();

    protected abstract ImageView getExpressionButton();

    public CharSequence getInput() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-362249484")) {
            return (CharSequence) ipChange.ipc$dispatch("-362249484", new Object[]{this});
        }
        EditText editText = this.mInputEditText;
        if (editText != null) {
            return editText.getText();
        }
        return null;
    }

    protected abstract EditText getInputEditText();

    @LayoutRes
    protected abstract int getLayoutId();

    public OnInputCompleteListener getOnInputCompleteListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1525939884") ? (OnInputCompleteListener) ipChange.ipc$dispatch("-1525939884", new Object[]{this}) : this.mInputListener;
    }

    protected int getSpaceChineseCount(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-862152481")) {
            return ((Integer) ipChange.ipc$dispatch("-862152481", new Object[]{this, charSequence})).intValue();
        }
        Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(charSequence);
        int i = 0;
        while (matcher.find()) {
            for (int i2 = 0; i2 <= matcher.groupCount(); i2++) {
                i++;
            }
        }
        return i;
    }

    protected abstract TextView getSumTextView();

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideExpressionboard() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1023049732")) {
            ipChange.ipc$dispatch("1023049732", new Object[]{this});
        } else if (this.mCustomPanel.getVisibility() != 8) {
            switchExpressionButton(false);
            this.mCustomPanel.setVisibility(8);
        }
    }

    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "441240741")) {
            ipChange.ipc$dispatch("441240741", new Object[]{this});
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2051989643")) {
            ipChange.ipc$dispatch("-2051989643", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(getLayoutId());
        this.mCommitButton = getCommitButton();
        this.mSumTextView = getSumTextView();
        this.mInputEditText = getInputEditText();
        this.mExpressionButton = getExpressionButton();
        this.mEditContainer = getEditContainer();
        this.mCustomPanel = getCustomPanel();
        if (!TextUtils.isEmpty(this.mHint)) {
            this.mInputEditText.setHint(this.mHint);
        }
        TextView textView = this.mSumTextView;
        textView.setText("" + this.MAX_CHAT_INPUT_LENGTH);
        if (!TextUtils.isEmpty(this.mDefaultText)) {
            this.mInputEditText.setText(this.mDefaultText);
            this.mInputEditText.setSelection(this.mDefaultText.length());
            int spaceCount = this.MAX_CHAT_INPUT_LENGTH - getSpaceCount(this.mDefaultText);
            setSumTextView(this.mSumTextView, spaceCount < 0, Math.abs(spaceCount));
            setCommitButtonStatus(this.mCommitButton, getSpaceCount(this.mDefaultText) > 0);
        }
        this.mInputEditText.addTextChangedListener(createTextWatcher());
        if (!TextUtils.isEmpty(this.mLastInput)) {
            this.mInputEditText.setText(this.mLastInput);
        }
        this.mInputEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1289188516")) {
                    return ((Boolean) ipChange2.ipc$dispatch("-1289188516", new Object[]{this, textView2, Integer.valueOf(i), keyEvent})).booleanValue();
                }
                if (i == 6 || i == 4) {
                    BaseInputDialog.this.sendMessage();
                    return true;
                }
                return false;
            }
        });
        this.mInputEditText.setOnTouchListener(new View.OnTouchListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2041311191")) {
                    return ((Boolean) ipChange2.ipc$dispatch("-2041311191", new Object[]{this, view, motionEvent})).booleanValue();
                }
                if (motionEvent.getAction() == 0) {
                    BaseInputDialog.this.hideExpressionboard();
                    BaseInputDialog.this.mInputEditText.requestFocus();
                }
                return false;
            }
        });
        this.mInputEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog.3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-2084654822")) {
                    ipChange2.ipc$dispatch("-2084654822", new Object[]{this, view, Boolean.valueOf(z)});
                } else if (z) {
                    ((ILog) Dsl.getService(ILog.class)).d("baseInputDialog", "Has focus ");
                } else {
                    ((ILog) Dsl.getService(ILog.class)).d("baseInputDialog", "lose focus");
                }
            }
        });
        this.mCommitButton.setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "836934555")) {
                    ipChange2.ipc$dispatch("836934555", new Object[]{this, view});
                } else {
                    BaseInputDialog.this.sendMessage();
                }
            }
        });
        if (this.mHasYell) {
            this.mExpressionButton.setVisibility(0);
        } else {
            this.mExpressionButton.setVisibility(8);
            this.mCustomPanel.setVisibility(8);
        }
        if (this.mShowYell && this.mHasYell) {
            showExpressionboard();
        } else if (openKeyBoardAfterCreate()) {
            this.mCommitButton.postDelayed(new Runnable() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1107889044")) {
                        ipChange2.ipc$dispatch("1107889044", new Object[]{this});
                        return;
                    }
                    EditText editText = BaseInputDialog.this.mInputEditText;
                    if (editText != null) {
                        editText.requestFocus();
                        BaseInputDialog baseInputDialog = BaseInputDialog.this;
                        baseInputDialog.mInputMethodManager.showSoftInput(baseInputDialog.mInputEditText, 0);
                    }
                }
            }, 300L);
        }
        initView();
    }

    protected abstract void onEmptyInput();

    protected abstract void onInput(CharSequence charSequence);

    protected abstract void onOverMaxLength(int i, int i2);

    @Override // android.app.Dialog
    protected void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1082555123")) {
            ipChange.ipc$dispatch("-1082555123", new Object[]{this});
            return;
        }
        super.onStart();
        setWindowAttributes();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1956249979")) {
            ipChange.ipc$dispatch("-1956249979", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onWindowFocusChanged(z);
        if (z) {
            return;
        }
        dismiss();
    }

    protected boolean openKeyBoardAfterCreate() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "65038669")) {
            return ((Boolean) ipChange.ipc$dispatch("65038669", new Object[]{this})).booleanValue();
        }
        return true;
    }

    protected abstract void release();

    protected abstract void setCommitButtonStatus(View view, boolean z);

    public void setDefaultText(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-305956174")) {
            ipChange.ipc$dispatch("-305956174", new Object[]{this, charSequence});
        } else {
            this.mDefaultText = charSequence;
        }
    }

    public void setHintText(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1037031362")) {
            ipChange.ipc$dispatch("-1037031362", new Object[]{this, charSequence});
        } else {
            this.mHint = charSequence;
        }
    }

    public void setMaxInputLength(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1796800927")) {
            ipChange.ipc$dispatch("-1796800927", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.MAX_CHAT_INPUT_LENGTH = i;
        }
    }

    public void setOnInputCompleteListener(OnInputCompleteListener onInputCompleteListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "380861306")) {
            ipChange.ipc$dispatch("380861306", new Object[]{this, onInputCompleteListener});
        } else {
            this.mInputListener = onInputCompleteListener;
        }
    }

    protected abstract void setSumTextView(TextView textView, boolean z, int i);

    protected void setWindowAttributes() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-121130329")) {
            ipChange.ipc$dispatch("-121130329", new Object[]{this});
            return;
        }
        Window window = getWindow();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(this.mContext.getWindowManager().getDefaultDisplay(), displayMetrics);
        window.setLayout(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), getWindow().getAttributes().height);
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        attributes.dimAmount = 0.0f;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showExpressionboard() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1645192447")) {
            ipChange.ipc$dispatch("1645192447", new Object[]{this});
            return;
        }
        InputMethodManager inputMethodManager = this.mInputMethodManager;
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.mInputEditText.getWindowToken(), 0);
        }
        this.mInputEditText.clearFocus();
        this.mCustomPanel.postDelayed(new Runnable() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "911375539")) {
                    ipChange2.ipc$dispatch("911375539", new Object[]{this});
                    return;
                }
                BaseInputDialog.this.switchExpressionButton(true);
                BaseInputDialog.this.mCustomPanel.setVisibility(0);
            }
        }, 300L);
    }

    protected abstract void switchExpressionButton(boolean z);

    public BaseInputDialog(@NonNull Context context, int i) {
        this(context, i, -1, null, null);
    }

    public BaseInputDialog(@NonNull Context context, int i, int i2, CharSequence charSequence, OnInputCompleteListener onInputCompleteListener) {
        this(context, i, i2, charSequence, null, onInputCompleteListener);
    }

    public BaseInputDialog(@NonNull Context context, int i, int i2, CharSequence charSequence, CharSequence charSequence2, OnInputCompleteListener onInputCompleteListener) {
        super(context, i);
        this.MAX_CHAT_INPUT_LENGTH = 60;
        this.mHasYell = false;
        this.mShowYell = false;
        this.mContext = (Activity) context;
        this.mInputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        this.MAX_CHAT_INPUT_LENGTH = i2 <= 0 ? this.MAX_CHAT_INPUT_LENGTH : i2;
        this.mHint = charSequence;
        this.mDefaultText = charSequence2;
        this.mInputListener = onInputCompleteListener;
    }
}
