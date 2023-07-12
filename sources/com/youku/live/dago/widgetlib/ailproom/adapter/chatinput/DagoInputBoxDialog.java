package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.taobao.weex.common.Constants;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener;
import com.youku.live.dago.widgetlib.ailpbaselib.util.MyLog;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.ExpressionDict;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.ExpressionManager;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.ExpressionPanel;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.listener.IExpressionSelectListener;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.widget.PagerExpression;
import com.youku.live.dago.widgetlib.util.RomUtil;
import com.youku.live.dago.widgetlib.util.ToastUtil;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.config.IConfig;
import com.youku.live.dsl.config.IConfigImp;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.wkit.component.Constants;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoInputBoxDialog extends Dialog implements DialogInterface.OnKeyListener, TextWatcher, View.OnClickListener, View.OnFocusChangeListener, CompoundButton.OnCheckedChangeListener, TextView.OnEditorActionListener, IDagoInputBox {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "InputBoxDialog";
    private int[] btnBg;
    private boolean isShowEmoji;
    private boolean isShowSwitch;
    private boolean isShowYell;
    private boolean isSwitchActive;
    private CheckBox mBarrageSwitch;
    private View mBottomLayout;
    private View mCancelLayout;
    private Activity mContext;
    private long mCurrentTimeMillis;
    private String mDefaultText;
    private ImageView mExpressionBtn;
    private IExpressionSelectListener mExpressionListener;
    private ExpressionPanel mExpressionPanel;
    private EditText mInputEditText;
    private View mInputLayuot;
    private String mKeyboardType;
    private int mMaxLength;
    private int mOrientation;
    private View mPanelContainer;
    private String mPlaceholder;
    private View mRootLayout;
    private TextView mSendBtn;
    private int mSendTextCode;
    private int mSrceenHeight;
    private int mSrceenWidth;
    private String mSwicthPlaceholder;
    private String mSwitchActivePic;
    private String mSwitchPic;
    private String mTopic;
    private int offset;
    private OnInputBoxListener onInputBoxListener;
    private OnInputDialogShowListener onInputDialogShowListener;
    private boolean weexCallClose;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface OnInputDialogShowListener {
        void dialogShow(boolean z);
    }

    public DagoInputBoxDialog(@NonNull Context context, Map<String, Object> map) {
        super(context, R.C7944style.dago_pgc_InputBoxDialogStyle);
        this.mOrientation = 1;
        this.offset = 0;
        this.mTopic = "";
        this.mMaxLength = 30;
        this.mDefaultText = "";
        this.mSwicthPlaceholder = "";
        this.mSwitchActivePic = "";
        this.mSendTextCode = 1;
        this.isShowEmoji = false;
        this.isShowYell = false;
        this.isShowSwitch = false;
        this.isSwitchActive = false;
        this.mKeyboardType = null;
        this.btnBg = new int[2];
        this.weexCallClose = false;
        this.mCurrentTimeMillis = 0L;
        this.mExpressionListener = new IExpressionSelectListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.DagoInputBoxDialog.6
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.listener.IExpressionSelectListener
            public void onExpressionClick(String str, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1263687385")) {
                    ipChange.ipc$dispatch("1263687385", new Object[]{this, str, Integer.valueOf(i)});
                } else if (str.equals(PagerExpression.BACK)) {
                    Editable editableText = DagoInputBoxDialog.this.mInputEditText.getEditableText();
                    int selectionStart = DagoInputBoxDialog.this.mInputEditText.getSelectionStart();
                    if (selectionStart >= 4) {
                        int i2 = selectionStart - 4;
                        if (ExpressionManager.isExpression(editableText.subSequence(i2, selectionStart))) {
                            DagoInputBoxDialog.this.mInputEditText.getText().delete(i2, selectionStart);
                        } else {
                            DagoInputBoxDialog.this.mInputEditText.getText().delete(selectionStart - 1, selectionStart);
                        }
                    } else if (selectionStart > 0) {
                        DagoInputBoxDialog.this.mInputEditText.getText().delete(selectionStart - 1, selectionStart);
                    }
                    DagoInputBoxDialog.this.mInputEditText.invalidate();
                } else {
                    ImageSpan imageSpan = new ImageSpan(DagoInputBoxDialog.this.getContext(), Bitmap.createScaledBitmap(BitmapFactory.decodeResource(UIUtil.getResources(), i), UIUtil.dip2px(18), UIUtil.dip2px(18), true));
                    SpannableString spannableString = new SpannableString(str);
                    spannableString.setSpan(imageSpan, 0, 4, 33);
                    DagoInputBoxDialog.this.mInputEditText.getText().insert(DagoInputBoxDialog.this.mInputEditText.getSelectionStart(), spannableString);
                }
            }
        };
        initData(context, map);
        this.mSrceenWidth = Math.min(UIUtil.getScreenWidth(getContext()), UIUtil.getFullActivityHeight(getContext()));
        this.mSrceenHeight = Math.max(UIUtil.getScreenWidth(getContext()), UIUtil.getFullActivityHeight(getContext()));
    }

    private void editAfterTextChanged(Editable editable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-365462679")) {
            ipChange.ipc$dispatch("-365462679", new Object[]{this, editable});
        } else if (editable != null && !TextUtils.isEmpty(editable.toString())) {
            this.mSendBtn.setEnabled(true);
            this.mSendBtn.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            this.mSendBtn.setEnabled(false);
            this.mSendBtn.setTextColor(Color.parseColor("#FFFFFF"));
        }
    }

    private void expressionBtnClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-115800604")) {
            ipChange.ipc$dispatch("-115800604", new Object[]{this});
        } else if (getWindow() == null) {
        } else {
            if (isShowExpressionPanel()) {
                hideExpressionPanel();
            } else {
                showExpressionPanel();
            }
        }
    }

    private int getColorString(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-151028282")) {
            return ((Integer) ipChange.ipc$dispatch("-151028282", new Object[]{this, str})).intValue();
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return Color.parseColor(str.replaceAll("^0[x|X]", Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX));
    }

    private void hideExpressionPanel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-369644519")) {
            ipChange.ipc$dispatch("-369644519", new Object[]{this});
            return;
        }
        this.mExpressionBtn.setImageResource(R.C7941drawable.dago_pgc_ic_biaoqing);
        this.mExpressionPanel.setVisibility(4);
    }

    private void hideKeyboardPanel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1837651352")) {
            ipChange.ipc$dispatch("-1837651352", new Object[]{this});
            return;
        }
        try {
            EditText editText = this.mInputEditText;
            if (editText != null) {
                DagoInputBoxUtils.hideKeyboard(editText);
                MyLog.d(TAG, "jiangzInput dismiss dismiss");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void hidePanelContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1933298936")) {
            ipChange.ipc$dispatch("-1933298936", new Object[]{this});
            return;
        }
        MyLog.i(TAG, "hidePanelContainer");
        if (isShowPanelContainer()) {
            this.mPanelContainer.setVisibility(4);
        }
        hideExpressionPanel();
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "244601522")) {
            ipChange.ipc$dispatch("244601522", new Object[]{this});
            return;
        }
        this.mCancelLayout = findViewById(R.id.dago_pgc_cancelView);
        this.mInputLayuot = findViewById(R.id.dago_pgc_editPanel);
        this.mPanelContainer = findViewById(R.id.dago_pgc_panel_container);
        this.mSendBtn = (TextView) findViewById(R.id.dago_pgc_btnSendBox);
        this.mInputEditText = (EditText) findViewById(R.id.dago_pgc_editBox);
        this.mExpressionBtn = (ImageView) findViewById(R.id.dago_pgc_btnChatExpression);
        this.mExpressionPanel = (ExpressionPanel) findViewById(R.id.dago_pgc_expressionPanel);
        CheckBox checkBox = (CheckBox) findViewById(R.id.lf_barrageSwitch);
        this.mBarrageSwitch = checkBox;
        checkBox.setOnCheckedChangeListener(this);
        this.mCancelLayout.setOnClickListener(this);
        this.mInputLayuot.setOnClickListener(this);
        this.mSendBtn.setOnClickListener(this);
        this.mExpressionBtn.setOnClickListener(this);
        this.mInputEditText.setOnClickListener(this);
        this.mInputEditText.setOnFocusChangeListener(this);
        this.mInputEditText.addTextChangedListener(this);
        this.mInputEditText.setOnEditorActionListener(this);
        this.mRootLayout = findViewById(R.id.edit_box_root_layout);
        this.mBottomLayout = findViewById(R.id.edit_box_bottom_layout);
        this.mRootLayout.setOnClickListener(this);
        this.mBottomLayout.setOnClickListener(this);
        setDefaultText(this.mDefaultText);
        setHint(this.mPlaceholder, this.mSwicthPlaceholder);
        setSendBtnText(this.mSendTextCode);
        setEmojiEnable(this.isShowEmoji);
        setEnableBarrage(this.isShowSwitch);
        setBarrageStatus(this.isSwitchActive);
        setBarrageRes(this.mSwitchPic, this.mSwitchActivePic);
        setSendBtnBackground(this.btnBg);
        setKeyboardType(this.mKeyboardType);
    }

    private void inputEditTextClicked() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1590952639")) {
            ipChange.ipc$dispatch("-1590952639", new Object[]{this});
        } else if (isShowPanelContainer()) {
            hidePanelContainer();
        } else {
            showPanelContainer();
        }
    }

    private boolean isExceedLimit(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222730196")) {
            return ((Boolean) ipChange.ipc$dispatch("1222730196", new Object[]{this, str})).booleanValue();
        }
        int i = this.mMaxLength;
        return i != 0 && i - ((int) Math.round(DagoInputBoxUtils.getLengthCH(str))) <= 0;
    }

    private void parseOptions(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "703592105")) {
            ipChange.ipc$dispatch("703592105", new Object[]{this, map});
            return;
        }
        this.mOrientation = AppContextUtils.getApp().getResources().getConfiguration().orientation;
        this.mTopic = DagoInputBoxUtils.getOptionsString(map, "topic");
        this.mMaxLength = DagoInputBoxUtils.getOptionsInt(map, "limit");
        this.mDefaultText = DagoInputBoxUtils.getOptionsString(map, "text");
        this.mPlaceholder = DagoInputBoxUtils.getOptionsString(map, Constants.Name.PLACEHOLDER);
        this.mSwicthPlaceholder = DagoInputBoxUtils.getOptionsString(map, "swicthPlaceholder");
        this.mSwitchPic = DagoInputBoxUtils.getOptionsString(map, "switchPic");
        this.mSwitchActivePic = DagoInputBoxUtils.getOptionsString(map, "switchActivePic");
        this.isShowYell = DagoInputBoxUtils.getOptionsBoolean(map, "showYell");
        this.mSendTextCode = DagoInputBoxUtils.getOptionsInt(map, "UIReturnKey");
        this.isShowEmoji = DagoInputBoxUtils.getOptionsBoolean(map, "emoji");
        this.isShowSwitch = DagoInputBoxUtils.getOptionsBoolean(map, "switch");
        this.isSwitchActive = DagoInputBoxUtils.getOptionsBoolean(map, "switchActive");
        this.mKeyboardType = DagoInputBoxUtils.getOptionsString(map, "keyboardType");
        String str = "#FFFFB700";
        String str2 = "#FFFF8200";
        if (map.get("btnBg") instanceof List) {
            List list = (List) map.get("btnBg");
            int[] iArr = this.btnBg;
            if (list.get(0) != null) {
                str2 = com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + String.valueOf(list.get(0));
            }
            iArr[0] = Color.parseColor(str2);
            int[] iArr2 = this.btnBg;
            if (list.get(1) != null) {
                str = com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + String.valueOf(list.get(1));
            }
            iArr2[1] = Color.parseColor(str);
            return;
        }
        this.btnBg[0] = Color.parseColor("#FFFF8200");
        this.btnBg[1] = Color.parseColor("#FFFFB700");
    }

    private void sendMessage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1048917828")) {
            ipChange.ipc$dispatch("1048917828", new Object[]{this});
        } else if (this.onInputBoxListener != null) {
            String convertStringWithResName = ExpressionDict.getInstance().getConvertStringWithResName(this.mInputEditText.getText().toString());
            if (isExceedLimit(convertStringWithResName)) {
                Context context = getContext();
                ToastUtil.toast(context, "聊天不能超过" + this.mMaxLength + "字");
                return;
            }
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "sendMessage: " + convertStringWithResName);
            this.onInputBoxListener.onSendMessage(convertStringWithResName);
        }
    }

    private void setBgColor(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2089171371")) {
            ipChange.ipc$dispatch("-2089171371", new Object[]{this, str});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "FFFFFFFF";
        }
        View view = this.mInputLayuot;
        if (view != null) {
            view.setBackgroundColor(Color.parseColor(com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + str));
        }
    }

    private void setDialogTheme() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1384207656")) {
            ipChange.ipc$dispatch("1384207656", new Object[]{this});
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Window window = getWindow();
        if (window != null) {
            Display.getMetrics(window.getWindowManager().getDefaultDisplay(), displayMetrics);
            window.setLayout(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), getWindow().getAttributes().height);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            attributes.gravity = 80;
            attributes.dimAmount = 0.0f;
            window.setAttributes(attributes);
            if (this.mOrientation == 1) {
                window.setFlags(2048, 2048);
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.C7944style.dago_pgc_InputDialogAnimations);
        }
    }

    private void setDiffModelPanelHeight() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1036572070")) {
            ipChange.ipc$dispatch("-1036572070", new Object[]{this});
            return;
        }
        String string = ((IConfig) Dsl.getService(IConfig.class)).getString(IConfigImp.NAMESPACE_LOCALCONFIG, "defPanelHeight", "[{\"model\":\"MI 6\",\"height\":256}]");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                if (RomUtil.isMiui() && Build.getMODEL().equals(jSONObject.getString("model")) && this.mOrientation == 1) {
                    DagoInputBoxUtils.saveKeyboardHeight(UIUtil.dip2px(jSONObject.getInt("height")));
                    showKeyboardPanel();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setEmojiEnable(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2096501068")) {
            ipChange.ipc$dispatch("-2096501068", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        ImageView imageView = this.mExpressionBtn;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    private void setEnableBarrage(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1198316328")) {
            ipChange.ipc$dispatch("1198316328", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        CheckBox checkBox = this.mBarrageSwitch;
        if (checkBox != null) {
            if (z) {
                checkBox.setVisibility(0);
            } else {
                checkBox.setVisibility(8);
            }
        }
    }

    private void setKeyboardType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-929645142")) {
            ipChange.ipc$dispatch("-929645142", new Object[]{this, str});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "default";
        }
        if (str.equals("number")) {
            this.mInputEditText.setInputType(2);
        } else {
            this.mInputEditText.setInputType(1);
        }
    }

    private void setRootViewOrientation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1334443808")) {
            ipChange.ipc$dispatch("-1334443808", new Object[]{this});
            return;
        }
        if (this.mOrientation == 1) {
            this.offset = 0;
            this.mCancelLayout.setVisibility(8);
        } else {
            this.mCancelLayout.setVisibility(0);
            int i = this.mSrceenWidth;
            int i2 = (i * 16) / 9;
            if (i2 < i) {
                this.offset = (this.mSrceenHeight - i2) / 2;
            }
        }
        this.mInputLayuot.setPadding(this.offset, UIUtil.dip2px(8), this.offset, UIUtil.dip2px(8));
        ExpressionPanel expressionPanel = this.mExpressionPanel;
        int i3 = this.offset;
        expressionPanel.setPadding(i3, 0, i3, 0);
        MyLog.i(TAG, "setRootViewOrientation offset: " + this.offset);
    }

    private void setSendBtnBackground(int[] iArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1190472501")) {
            ipChange.ipc$dispatch("1190472501", new Object[]{this, iArr});
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(UIUtil.dip2px(24));
        gradientDrawable.setColors(iArr);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910}, gradientDrawable);
        stateListDrawable.addState(new int[]{-16842910}, UIUtil.getResources().getDrawable(R.C7941drawable.dago_pgc_background_chat_none));
        TextView textView = this.mSendBtn;
        if (textView != null) {
            textView.setMaxLines(1);
            this.mSendBtn.setBackground(stateListDrawable);
        }
    }

    private void showExpressionPanel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "252498196")) {
            ipChange.ipc$dispatch("252498196", new Object[]{this});
            return;
        }
        this.mExpressionBtn.setImageResource(R.C7941drawable.dago_pgc_ic_jianpan);
        this.mExpressionPanel.setVisibility(0);
        DagoInputBoxUtils.hideKeyboard(this.mInputEditText);
        UIUtil.postDelayed(new Runnable() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.DagoInputBoxDialog.5
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1846736729")) {
                    ipChange2.ipc$dispatch("-1846736729", new Object[]{this});
                } else {
                    DagoInputBoxDialog.this.updatePanelContainerHeight(DagoInputBoxUtils.HEIGHT_PANEL_EMOJI);
                }
            }
        }, 100L);
    }

    private void showKeyboardPanel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-688401885")) {
            ipChange.ipc$dispatch("-688401885", new Object[]{this});
            return;
        }
        EditText editText = this.mInputEditText;
        if (editText != null) {
            DagoInputBoxUtils.toggleSoftInput(editText);
            updatePanelContainerHeight(DagoInputBoxUtils.getKeyboardHeight());
        }
    }

    private void showPanelContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-666303827")) {
            ipChange.ipc$dispatch("-666303827", new Object[]{this});
            return;
        }
        MyLog.i(TAG, "showPanelContainer");
        if (isShowPanelContainer()) {
            return;
        }
        this.mPanelContainer.setVisibility(0);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1743639743")) {
            ipChange.ipc$dispatch("1743639743", new Object[]{this, editable});
        } else {
            editAfterTextChanged(editable);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1784284900")) {
            ipChange.ipc$dispatch("1784284900", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.IDagoInputBox
    public boolean canClose() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1015202397") ? ((Boolean) ipChange.ipc$dispatch("-1015202397", new Object[]{this})).booleanValue() : System.currentTimeMillis() - this.mCurrentTimeMillis > 500;
    }

    public void clearText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1615371479")) {
            ipChange.ipc$dispatch("-1615371479", new Object[]{this});
            return;
        }
        EditText editText = this.mInputEditText;
        if (editText != null) {
            editText.setText("");
            setHint(this.mPlaceholder, this.mSwicthPlaceholder);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.IDagoInputBox
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922705547")) {
            ipChange.ipc$dispatch("1922705547", new Object[]{this});
            return;
        }
        this.mCurrentTimeMillis = 0L;
        this.weexCallClose = true;
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-647829703")) {
            ipChange.ipc$dispatch("-647829703", new Object[]{this});
            return;
        }
        hideKeyboardPanel();
        super.dismiss();
        OnInputDialogShowListener onInputDialogShowListener = this.onInputDialogShowListener;
        if (onInputDialogShowListener != null) {
            onInputDialogShowListener.dialogShow(false);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.IDagoInputBox
    public CharSequence getInputText() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687986092")) {
            return (CharSequence) ipChange.ipc$dispatch("-1687986092", new Object[]{this});
        }
        EditText editText = this.mInputEditText;
        if (editText != null) {
            return editText.getText();
        }
        return null;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.IDagoInputBox
    public void initData(Context context, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-237979318")) {
            ipChange.ipc$dispatch("-237979318", new Object[]{this, context, map});
            return;
        }
        this.mContext = (Activity) context;
        parseOptions(map);
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.IDagoInputBox
    public boolean isShowExpressionPanel() {
        ExpressionPanel expressionPanel;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "502252386") ? ((Boolean) ipChange.ipc$dispatch("502252386", new Object[]{this})).booleanValue() : isShowPanelContainer() && (expressionPanel = this.mExpressionPanel) != null && expressionPanel.getVisibility() == 0;
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.IDagoInputBox
    public boolean isShowPanelContainer() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1350983897")) {
            return ((Boolean) ipChange.ipc$dispatch("-1350983897", new Object[]{this})).booleanValue();
        }
        View view = this.mPanelContainer;
        return view != null && view.getVisibility() == 0;
    }

    public boolean isWeexCallClose() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1715521400") ? ((Boolean) ipChange.ipc$dispatch("1715521400", new Object[]{this})).booleanValue() : this.weexCallClose;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "434605494")) {
            ipChange.ipc$dispatch("434605494", new Object[]{this, compoundButton, Boolean.valueOf(z)});
            return;
        }
        if (z && isShowPanelContainer() && this.mExpressionPanel != null) {
            hidePanelContainer();
        }
        showKeyboardPanel();
        this.isSwitchActive = true;
        setHint(this.mPlaceholder, this.mSwicthPlaceholder);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-999885800")) {
            ipChange.ipc$dispatch("-999885800", new Object[]{this, view});
        } else if (view == this.mSendBtn) {
            sendMessage();
        } else if (view == this.mExpressionBtn) {
            OnInputBoxListener onInputBoxListener = this.onInputBoxListener;
            if (onInputBoxListener != null) {
                onInputBoxListener.onChangeExpressionPanel(!isShowExpressionPanel());
            }
            expressionBtnClicked();
        } else if (view == this.mInputEditText) {
            inputEditTextClicked();
        } else if (view == this.mCancelLayout) {
            ((ILog) Dsl.getService(ILog.class)).d(TAG, "jiangzInput dismiss mCancelLayout");
            dismiss();
        } else if (view == this.mRootLayout) {
            MyLog.d(TAG, "jiangzInput click mRootLayout");
            dismiss();
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-8930232")) {
            ipChange.ipc$dispatch("-8930232", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R.C7942layout.dago_pgc_view_inputbox);
        initView();
        setDiffModelPanelHeight();
        setRootViewOrientation();
        updatePanelContainerHeight(DagoInputBoxUtils.getKeyboardHeight());
        this.mExpressionPanel.initExpressionView(getContext(), this.mExpressionListener);
        setOnKeyListener(this);
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.DagoInputBoxDialog.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "54260091")) {
                    ipChange2.ipc$dispatch("54260091", new Object[]{this, dialogInterface});
                } else if (DagoInputBoxDialog.this.onInputBoxListener != null) {
                    DagoInputBoxDialog.this.onInputBoxListener.onDismiss();
                }
            }
        });
        this.mCurrentTimeMillis = System.currentTimeMillis();
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1192046884")) {
            return ((Boolean) ipChange.ipc$dispatch("-1192046884", new Object[]{this, textView, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 6 || i == 4) {
            sendMessage();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1278751452")) {
            ipChange.ipc$dispatch("1278751452", new Object[]{this, view, Boolean.valueOf(z)});
        } else if (view == this.mInputEditText && z && isShowExpressionPanel()) {
            this.mExpressionPanel.setVisibility(4);
        }
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "516880032")) {
            return ((Boolean) ipChange.ipc$dispatch("516880032", new Object[]{this, dialogInterface, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            ((ILog) Dsl.getService(ILog.class)).d(TAG, "jiangzInput dismiss KEYCODE_BACK");
            dismiss();
        }
        return false;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1504540320")) {
            ipChange.ipc$dispatch("-1504540320", new Object[]{this});
            return;
        }
        super.onStart();
        setDialogTheme();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-746402428")) {
            ipChange.ipc$dispatch("-746402428", new Object[]{this, charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1840548456")) {
            ipChange.ipc$dispatch("-1840548456", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        super.onWindowFocusChanged(z);
        if (z) {
            return;
        }
        try {
            ((ILog) Dsl.getService(ILog.class)).d(TAG, "jiangzInput dismiss onWindowFocusChanged");
            dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBarrageRes(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1236933579")) {
            ipChange.ipc$dispatch("-1236933579", new Object[]{this, str, str2});
        } else if (str == null || str2 == null) {
        } else {
            final StateListDrawable stateListDrawable = new StateListDrawable();
            DagoImageLoader.getInstance().load(getContext(), str2, new ImageLoadListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.DagoInputBoxDialog.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
                public void onFail() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1346288760")) {
                        ipChange2.ipc$dispatch("1346288760", new Object[]{this});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
                public void onSuccess(BitmapDrawable bitmapDrawable) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1677855174")) {
                        ipChange2.ipc$dispatch("1677855174", new Object[]{this, bitmapDrawable});
                        return;
                    }
                    stateListDrawable.addState(new int[]{16842912}, bitmapDrawable);
                    if (DagoInputBoxDialog.this.mBarrageSwitch != null) {
                        DagoInputBoxDialog.this.mBarrageSwitch.setBackgroundDrawable(stateListDrawable);
                    }
                }
            });
            DagoImageLoader.getInstance().load(getContext(), str, new ImageLoadListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.DagoInputBoxDialog.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
                public void onFail() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1052885753")) {
                        ipChange2.ipc$dispatch("1052885753", new Object[]{this});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailpbaselib.image.ImageLoadListener
                public void onSuccess(BitmapDrawable bitmapDrawable) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-252763931")) {
                        ipChange2.ipc$dispatch("-252763931", new Object[]{this, bitmapDrawable});
                        return;
                    }
                    stateListDrawable.addState(new int[]{-16842912}, bitmapDrawable);
                    if (DagoInputBoxDialog.this.mBarrageSwitch != null) {
                        DagoInputBoxDialog.this.mBarrageSwitch.setBackgroundDrawable(stateListDrawable);
                    }
                }
            });
        }
    }

    public void setBarrageStatus(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "231494589")) {
            ipChange.ipc$dispatch("231494589", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        CheckBox checkBox = this.mBarrageSwitch;
        if (checkBox != null) {
            checkBox.setChecked(z);
        }
    }

    public void setDefaultText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-230731419")) {
            ipChange.ipc$dispatch("-230731419", new Object[]{this, str});
            return;
        }
        EditText editText = this.mInputEditText;
        if (editText != null) {
            editText.setText(str);
        }
    }

    public void setHint(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "485455726")) {
            ipChange.ipc$dispatch("485455726", new Object[]{this, str, str2});
            return;
        }
        EditText editText = this.mInputEditText;
        if (editText != null) {
            if (this.isSwitchActive) {
                str = str2;
            }
            editText.setHint(str);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.IDagoInputBox
    public void setOnInputBoxListener(OnInputBoxListener onInputBoxListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "353168708")) {
            ipChange.ipc$dispatch("353168708", new Object[]{this, onInputBoxListener});
        } else {
            this.onInputBoxListener = onInputBoxListener;
        }
    }

    public void setOnInputDialogShowListener(OnInputDialogShowListener onInputDialogShowListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "16326290")) {
            ipChange.ipc$dispatch("16326290", new Object[]{this, onInputDialogShowListener});
        } else {
            this.onInputDialogShowListener = onInputDialogShowListener;
        }
    }

    public void setSendBtnText(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-643578245")) {
            ipChange.ipc$dispatch("-643578245", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        TextView textView = this.mSendBtn;
        if (textView != null) {
            if (i == 1) {
                textView.setText("发送");
            } else if (i == 2) {
                textView.setText(PurchaseConstants.CONFIRM);
            } else if (i == 3) {
                textView.setText("搜索");
            } else if (i != 4) {
                textView.setText("发送");
            } else {
                textView.setText("完成");
            }
        }
    }

    @Override // android.app.Dialog, com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.IDagoInputBox
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-676938870")) {
            ipChange.ipc$dispatch("-676938870", new Object[]{this});
            return;
        }
        super.show();
        UIUtil.postDelayed(new Runnable() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.DagoInputBoxDialog.4
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1650223224")) {
                    ipChange2.ipc$dispatch("-1650223224", new Object[]{this});
                } else if (DagoInputBoxDialog.this.mInputEditText != null) {
                    DagoInputBoxUtils.toggleSoftInput(DagoInputBoxDialog.this.mInputEditText);
                }
            }
        }, 200L);
        OnInputDialogShowListener onInputDialogShowListener = this.onInputDialogShowListener;
        if (onInputDialogShowListener != null) {
            onInputDialogShowListener.dialogShow(true);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.IDagoInputBox
    public void updatePanelContainerHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1798864905")) {
            ipChange.ipc$dispatch("1798864905", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        View view = this.mPanelContainer;
        if (view == null || i < 200) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams.height != i) {
            layoutParams.height = i;
            this.mPanelContainer.setLayoutParams(layoutParams);
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.IDagoInputBox
    public boolean useBarrage() {
        CheckBox checkBox;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1726990030") ? ((Boolean) ipChange.ipc$dispatch("-1726990030", new Object[]{this})).booleanValue() : this.isShowSwitch && (checkBox = this.mBarrageSwitch) != null && checkBox.isChecked();
    }
}
