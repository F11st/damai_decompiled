package com.taobao.weex.ui.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.SecExceptionCode;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.dom.CSSConstants;
import com.taobao.weex.dom.WXEvent;
import com.taobao.weex.dom.WXStyle;
import com.taobao.weex.layout.ContentBoxMeasurement;
import com.taobao.weex.layout.MeasureMode;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.helper.SoftKeyboardDetector;
import com.taobao.weex.ui.component.helper.WXTimeInputHelper;
import com.taobao.weex.ui.component.list.template.TemplateDom;
import com.taobao.weex.ui.view.WXEditText;
import com.taobao.weex.utils.TypefaceUtil;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXResourceUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.commons.lang3.CharUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class AbstractEditComponent extends WXComponent<WXEditText> {
    private static final int MAX_TEXT_FORMAT_REPEAT = 3;
    private boolean mAutoFocus;
    private String mBeforeText;
    private int mEditorAction;
    private List<TextView.OnEditorActionListener> mEditorActionListeners;
    private int mFormatRepeatCount;
    private TextFormatter mFormatter;
    private boolean mIgnoreNextOnInputEvent;
    private final InputMethodManager mInputMethodManager;
    private boolean mKeepSelectionIndex;
    private String mLastValue;
    private int mLineHeight;
    private boolean mListeningKeyboard;
    private String mMax;
    private String mMin;
    private WXComponent.OnClickListener mOnClickListener;
    private TextPaint mPaint;
    private String mReturnKeyType;
    private TextWatcher mTextChangedEventDispatcher;
    private List<TextWatcher> mTextChangedListeners;
    private String mType;
    private SoftKeyboardDetector.Unregister mUnregister;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class PatternWrapper {
        private boolean global;
        private Pattern matcher;
        private String replace;

        private PatternWrapper() {
            this.global = false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private interface ReturnTypes {
        public static final String DEFAULT = "default";
        public static final String DONE = "done";
        public static final String GO = "go";
        public static final String NEXT = "next";
        public static final String SEARCH = "search";
        public static final String SEND = "send";
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class TextFormatter {
        private PatternWrapper format;
        private PatternWrapper recover;

        /* JADX INFO: Access modifiers changed from: private */
        public String format(String str) {
            try {
                PatternWrapper patternWrapper = this.format;
                if (patternWrapper != null) {
                    return patternWrapper.global ? this.format.matcher.matcher(str).replaceAll(this.format.replace) : this.format.matcher.matcher(str).replaceFirst(this.format.replace);
                }
            } catch (Throwable th) {
                WXLogUtils.w("WXInput", "[format] " + th.getMessage());
            }
            return str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String recover(String str) {
            try {
                PatternWrapper patternWrapper = this.recover;
                if (patternWrapper != null) {
                    return patternWrapper.global ? this.recover.matcher.matcher(str).replaceAll(this.recover.replace) : this.recover.matcher.matcher(str).replaceFirst(this.recover.replace);
                }
            } catch (Throwable th) {
                WXLogUtils.w("WXInput", "[formatted] " + th.getMessage());
            }
            return str;
        }

        private TextFormatter(PatternWrapper patternWrapper, PatternWrapper patternWrapper2) {
            this.format = patternWrapper;
            this.recover = patternWrapper2;
        }
    }

    public AbstractEditComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, boolean z, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, z, basicComponentData);
        this.mBeforeText = "";
        this.mType = "text";
        this.mMax = null;
        this.mMin = null;
        this.mLastValue = "";
        this.mEditorAction = 6;
        this.mReturnKeyType = null;
        this.mListeningKeyboard = false;
        this.mIgnoreNextOnInputEvent = false;
        this.mKeepSelectionIndex = false;
        this.mFormatter = null;
        this.mFormatRepeatCount = 0;
        this.mPaint = new TextPaint();
        this.mLineHeight = -1;
        this.mOnClickListener = new WXComponent.OnClickListener() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.3
            @Override // com.taobao.weex.ui.component.WXComponent.OnClickListener
            public void onHostViewClick() {
                String str = AbstractEditComponent.this.mType;
                str.hashCode();
                if (str.equals("date")) {
                    AbstractEditComponent.this.hideSoftKeyboard();
                    if (AbstractEditComponent.this.getParent() != null) {
                        AbstractEditComponent.this.getParent().interceptFocus();
                    }
                    WXTimeInputHelper.pickDate(AbstractEditComponent.this.mMax, AbstractEditComponent.this.mMin, AbstractEditComponent.this);
                } else if (str.equals("time")) {
                    AbstractEditComponent.this.hideSoftKeyboard();
                    if (AbstractEditComponent.this.getParent() != null) {
                        AbstractEditComponent.this.getParent().interceptFocus();
                    }
                    WXTimeInputHelper.pickTime(AbstractEditComponent.this);
                }
            }
        };
        this.mInputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        setContentBoxMeasurement(new ContentBoxMeasurement() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.1
            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutAfter(float f, float f2) {
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void layoutBefore() {
                AbstractEditComponent.this.updateStyleAndAttrs();
            }

            @Override // com.taobao.weex.layout.ContentBoxMeasurement
            public void measureInternal(float f, float f2, int i, int i2) {
                this.mMeasureWidth = (CSSConstants.isUndefined(f) || i == MeasureMode.UNSPECIFIED) ? 0.0f : 0.0f;
                this.mMeasureHeight = AbstractEditComponent.this.getMeasureHeight();
            }
        });
    }

    private void addKeyboardListener(WXEditText wXEditText) {
        final Context context;
        if (wXEditText == null || (context = wXEditText.getContext()) == null || !(context instanceof Activity)) {
            return;
        }
        SoftKeyboardDetector.registerKeyboardEventListener((Activity) context, new SoftKeyboardDetector.OnKeyboardEventListener() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.13
            @Override // com.taobao.weex.ui.component.helper.SoftKeyboardDetector.OnKeyboardEventListener
            public void onKeyboardEvent(boolean z) {
                if (AbstractEditComponent.this.mListeningKeyboard) {
                    HashMap hashMap = new HashMap(1);
                    hashMap.put("isShow", Boolean.valueOf(z));
                    if (z) {
                        Rect rect = new Rect();
                        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                        hashMap.put("keyboardSize", Float.valueOf(WXViewUtils.getWebPxByWidth(WXViewUtils.getScreenHeight(context) - (rect.bottom - rect.top), AbstractEditComponent.this.getInstance().getInstanceViewPortWidth())));
                    }
                    AbstractEditComponent.this.fireEvent(Constants.Event.KEYBOARD, hashMap);
                }
                if (z) {
                    return;
                }
                AbstractEditComponent.this.blur();
            }
        });
    }

    private void applyOnClickListener() {
        addClickListener(this.mOnClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void decideSoftKeyboard() {
        final Context context;
        WXEditText hostView = getHostView();
        if (hostView == null || (context = getContext()) == null || !(context instanceof Activity)) {
            return;
        }
        hostView.postDelayed(WXThread.secure(new Runnable() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.11
            @Override // java.lang.Runnable
            public void run() {
                if (((Activity) context).getCurrentFocus() instanceof EditText) {
                    return;
                }
                AbstractEditComponent.this.mInputMethodManager.hideSoftInputFromWindow(AbstractEditComponent.this.getHostView().getWindowToken(), 0);
            }
        }), 16L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireEvent(String str, String str2) {
        if (str != null) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("value", str2);
            hashMap.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            hashMap3.put("value", str2);
            hashMap2.put(TemplateDom.KEY_ATTRS, hashMap3);
            WXSDKManager.v().e(getInstanceId(), getRef(), str, hashMap, hashMap2);
        }
    }

    private int getInputType(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1034364087:
                if (str.equals("number")) {
                    c = 0;
                    break;
                }
                break;
            case 114715:
                if (str.equals("tel")) {
                    c = 1;
                    break;
                }
                break;
            case 116079:
                if (str.equals("url")) {
                    c = 2;
                    break;
                }
                break;
            case 3076014:
                if (str.equals("date")) {
                    c = 3;
                    break;
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    c = 4;
                    break;
                }
                break;
            case 3560141:
                if (str.equals("time")) {
                    c = 5;
                    break;
                }
                break;
            case 96619420:
                if (str.equals("email")) {
                    c = 6;
                    break;
                }
                break;
            case 1216985755:
                if (str.equals(Constants.Value.PASSWORD)) {
                    c = 7;
                    break;
                }
                break;
            case 1793702779:
                if (str.equals(Constants.Value.DATETIME)) {
                    c = '\b';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 8194;
            case 1:
                return 3;
            case 2:
                return 17;
            case 3:
                getHostView().setFocusable(false);
                break;
            case 4:
            default:
                return 1;
            case 5:
                if (getHostView() != null) {
                    getHostView().setFocusable(false);
                    break;
                }
                break;
            case 6:
                return 33;
            case 7:
                if (getHostView() != null) {
                    getHostView().setTransformationMethod(PasswordTransformationMethod.getInstance());
                    return SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR;
                }
                return SecExceptionCode.SEC_ERROR_INIT_INDEX_ERROR;
            case '\b':
                return 4;
        }
        return 0;
    }

    private int getTextAlign(String str) {
        int i = isLayoutRTL() ? GravityCompat.END : GravityCompat.START;
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        if (str.equals("left")) {
            return GravityCompat.START;
        }
        if (str.equals("center")) {
            return 17;
        }
        return str.equals("right") ? GravityCompat.END : i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideSoftKeyboard() {
        if (getHostView() != null) {
            getHostView().postDelayed(WXThread.secure(new Runnable() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.10
                @Override // java.lang.Runnable
                public void run() {
                    AbstractEditComponent.this.mInputMethodManager.hideSoftInputFromWindow(AbstractEditComponent.this.getHostView().getWindowToken(), 0);
                }
            }), 16L);
        }
    }

    private PatternWrapper parseToPattern(String str, String str2) {
        Pattern pattern;
        if (str == null || str2 == null) {
            return null;
        }
        if (!Pattern.compile("/[\\S]+/[i]?[m]?[g]?").matcher(str).matches()) {
            WXLogUtils.w("WXInput", "Illegal js pattern syntax: " + str);
            return null;
        }
        String substring = str.substring(str.lastIndexOf("/") + 1);
        String substring2 = str.substring(str.indexOf("/") + 1, str.lastIndexOf("/"));
        int i = substring.contains("i") ? 2 : 0;
        if (substring.contains(WXComponent.PROP_FS_MATCH_PARENT)) {
            i |= 32;
        }
        boolean contains = substring.contains("g");
        try {
            pattern = Pattern.compile(substring2, i);
        } catch (PatternSyntaxException unused) {
            WXLogUtils.w("WXInput", "Pattern syntax error: " + substring2);
            pattern = null;
        }
        if (pattern == null) {
            return null;
        }
        PatternWrapper patternWrapper = new PatternWrapper();
        patternWrapper.global = contains;
        patternWrapper.matcher = pattern;
        patternWrapper.replace = str2;
        return patternWrapper;
    }

    private boolean showSoftKeyboard() {
        if (getHostView() == null) {
            return false;
        }
        getHostView().postDelayed(WXThread.secure(new Runnable() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.9
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractEditComponent.this.getInstance() != null && AbstractEditComponent.this.getInstance().getApmForInstance() != null) {
                    AbstractEditComponent.this.getInstance().getApmForInstance().k = true;
                }
                AbstractEditComponent.this.mInputMethodManager.showSoftInput(AbstractEditComponent.this.getHostView(), 1);
            }
        }), 100L);
        return true;
    }

    protected final void addEditorActionListener(TextView.OnEditorActionListener onEditorActionListener) {
        WXEditText hostView;
        if (onEditorActionListener == null || (hostView = getHostView()) == null) {
            return;
        }
        if (this.mEditorActionListeners == null) {
            this.mEditorActionListeners = new ArrayList();
            hostView.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.12
                private boolean handled = true;

                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    for (TextView.OnEditorActionListener onEditorActionListener2 : AbstractEditComponent.this.mEditorActionListeners) {
                        if (onEditorActionListener2 != null) {
                            this.handled = onEditorActionListener2.onEditorAction(textView, i, keyEvent) & this.handled;
                        }
                    }
                    return this.handled;
                }
            });
        }
        this.mEditorActionListeners.add(onEditorActionListener);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(String str) {
        super.addEvent(str);
        if (getHostView() == null || TextUtils.isEmpty(str)) {
            return;
        }
        final WXEditText hostView = getHostView();
        if (str.equals(Constants.Event.CHANGE)) {
            addFocusChangeListener(new WXComponent.OnFocusChangeListener() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.5
                @Override // com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener
                public void onFocusChange(boolean z) {
                    if (z) {
                        AbstractEditComponent.this.mLastValue = hostView.getText().toString();
                        return;
                    }
                    CharSequence text = hostView.getText();
                    if (text == null) {
                        text = "";
                    }
                    if (text.toString().equals(AbstractEditComponent.this.mLastValue)) {
                        return;
                    }
                    AbstractEditComponent.this.fireEvent(Constants.Event.CHANGE, text.toString());
                    AbstractEditComponent.this.mLastValue = hostView.getText().toString();
                }
            });
            addEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.6
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i == AbstractEditComponent.this.mEditorAction) {
                        CharSequence text = hostView.getText();
                        if (text == null) {
                            text = "";
                        }
                        if (!text.toString().equals(AbstractEditComponent.this.mLastValue)) {
                            AbstractEditComponent.this.fireEvent(Constants.Event.CHANGE, text.toString());
                            AbstractEditComponent.this.mLastValue = hostView.getText().toString();
                        }
                        if (AbstractEditComponent.this.getParent() != null) {
                            AbstractEditComponent.this.getParent().interceptFocus();
                        }
                        AbstractEditComponent.this.hideSoftKeyboard();
                        return true;
                    }
                    return false;
                }
            });
        } else if (str.equals("input")) {
            addTextChangedListener(new TextWatcher() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.7
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (AbstractEditComponent.this.mIgnoreNextOnInputEvent) {
                        AbstractEditComponent.this.mIgnoreNextOnInputEvent = false;
                        AbstractEditComponent.this.mBeforeText = charSequence.toString();
                    } else if (AbstractEditComponent.this.mBeforeText.equals(charSequence.toString())) {
                    } else {
                        AbstractEditComponent.this.mBeforeText = charSequence.toString();
                        AbstractEditComponent.this.fireEvent("input", charSequence.toString());
                    }
                }
            });
        }
        if (Constants.Event.RETURN.equals(str)) {
            addEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.8
                @Override // android.widget.TextView.OnEditorActionListener
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                    if (i == AbstractEditComponent.this.mEditorAction) {
                        HashMap hashMap = new HashMap(2);
                        hashMap.put(Constants.Name.RETURN_KEY_TYPE, AbstractEditComponent.this.mReturnKeyType);
                        hashMap.put("value", textView.getText().toString());
                        AbstractEditComponent.this.fireEvent(Constants.Event.RETURN, hashMap);
                        return true;
                    }
                    return false;
                }
            });
        }
        if (Constants.Event.KEYBOARD.equals(str)) {
            this.mListeningKeyboard = true;
        }
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        if (this.mTextChangedListeners == null) {
            this.mTextChangedListeners = new ArrayList();
        }
        this.mTextChangedListeners.add(textWatcher);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void appleStyleAfterCreated(final WXEditText wXEditText) {
        int textAlign = getTextAlign((String) getStyles().get(Constants.Name.TEXT_ALIGN));
        if (textAlign <= 0) {
            textAlign = GravityCompat.START;
        }
        wXEditText.setGravity(textAlign | getVerticalGravity());
        int color = WXResourceUtils.getColor("#999999");
        if (color != Integer.MIN_VALUE) {
            wXEditText.setHintTextColor(color);
        }
        TextWatcher textWatcher = new TextWatcher() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (AbstractEditComponent.this.mTextChangedListeners != null) {
                    for (TextWatcher textWatcher2 : AbstractEditComponent.this.mTextChangedListeners) {
                        textWatcher2.afterTextChanged(editable);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AbstractEditComponent.this.mTextChangedListeners != null) {
                    for (TextWatcher textWatcher2 : AbstractEditComponent.this.mTextChangedListeners) {
                        textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (AbstractEditComponent.this.mFormatter != null) {
                    String format = AbstractEditComponent.this.mFormatter.format(AbstractEditComponent.this.mFormatter.recover(charSequence.toString()));
                    if (format.equals(charSequence.toString()) || AbstractEditComponent.this.mFormatRepeatCount >= 3) {
                        AbstractEditComponent.this.mFormatRepeatCount = 0;
                    } else {
                        AbstractEditComponent.this.mFormatRepeatCount++;
                        int length = AbstractEditComponent.this.mFormatter.format(AbstractEditComponent.this.mFormatter.recover(charSequence.subSequence(0, wXEditText.getSelectionStart()).toString())).length();
                        wXEditText.setText(format);
                        wXEditText.setSelection(length);
                        return;
                    }
                }
                if (AbstractEditComponent.this.mTextChangedListeners != null) {
                    for (TextWatcher textWatcher2 : AbstractEditComponent.this.mTextChangedListeners) {
                        textWatcher2.onTextChanged(charSequence, i, i2, i3);
                    }
                }
            }
        };
        this.mTextChangedEventDispatcher = textWatcher;
        wXEditText.addTextChangedListener(textWatcher);
        wXEditText.setTextSize(0, WXStyle.getFontSize(getStyles(), getInstance().getInstanceViewPortWidth()));
    }

    @JSMethod
    public void blur() {
        WXEditText hostView = getHostView();
        if (hostView == null || !hostView.hasFocus()) {
            return;
        }
        if (getParent() != null) {
            getParent().interceptFocus();
        }
        hostView.clearFocus();
        hideSoftKeyboard();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public Object convertEmptyProperty(String str, Object obj) {
        str.hashCode();
        if (str.equals("color")) {
            return "black";
        }
        if (!str.equals("fontSize")) {
            return super.convertEmptyProperty(str, obj);
        }
        return 32;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        super.destroy();
        SoftKeyboardDetector.Unregister unregister = this.mUnregister;
        if (unregister != null) {
            try {
                unregister.execute();
                this.mUnregister = null;
            } catch (Throwable th) {
                WXLogUtils.w("Unregister throw ", th);
            }
        }
    }

    @JSMethod
    public void focus() {
        WXEditText hostView = getHostView();
        if (hostView == null || hostView.hasFocus()) {
            return;
        }
        if (getParent() != null) {
            getParent().ignoreFocus();
        }
        hostView.requestFocus();
        hostView.setFocusable(true);
        hostView.setFocusableInTouchMode(true);
        showSoftKeyboard();
    }

    protected float getMeasureHeight() {
        return getMeasuredLineHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float getMeasuredLineHeight() {
        int i = this.mLineHeight;
        return (i == -1 || i <= 0) ? this.mPaint.getFontMetrics(null) : i;
    }

    @JSMethod
    public void getSelectionRange(String str) {
        HashMap hashMap = new HashMap(2);
        WXEditText hostView = getHostView();
        if (hostView != null) {
            int selectionStart = hostView.getSelectionStart();
            int selectionEnd = hostView.getSelectionEnd();
            if (!hostView.hasFocus()) {
                selectionStart = 0;
                selectionEnd = 0;
            }
            hashMap.put(Constants.Name.SELECTION_START, Integer.valueOf(selectionStart));
            hashMap.put(Constants.Name.SELECTION_END, Integer.valueOf(selectionEnd));
        }
        WXBridgeManager.getInstance().callback(getInstanceId(), str, hashMap, false);
    }

    protected int getVerticalGravity() {
        return 16;
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected boolean isConsumeTouch() {
        return !isDisabled();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected void layoutDirectionDidChanged(boolean z) {
        int textAlign = getTextAlign((String) getStyles().get(Constants.Name.TEXT_ALIGN));
        if (textAlign <= 0) {
            textAlign = GravityCompat.START;
        }
        if (getHostView() instanceof WXEditText) {
            getHostView().setGravity(textAlign | getVerticalGravity());
        }
    }

    public void performOnChange(String str) {
        if (getEvents() != null) {
            WXEvent events = getEvents();
            String str2 = Constants.Event.CHANGE;
            if (!events.contains(Constants.Event.CHANGE)) {
                str2 = null;
            }
            fireEvent(str2, str);
        }
    }

    @WXComponentProp(name = Constants.Name.AUTOFOCUS)
    public void setAutofocus(boolean z) {
        if (getHostView() == null) {
            return;
        }
        this.mAutoFocus = z;
        WXEditText hostView = getHostView();
        if (this.mAutoFocus) {
            hostView.setFocusable(true);
            hostView.requestFocus();
            hostView.setFocusableInTouchMode(true);
            showSoftKeyboard();
            return;
        }
        hideSoftKeyboard();
    }

    @WXComponentProp(name = "color")
    public void setColor(String str) {
        int color;
        if (getHostView() == null || TextUtils.isEmpty(str) || (color = WXResourceUtils.getColor(str)) == Integer.MIN_VALUE) {
            return;
        }
        getHostView().setTextColor(color);
    }

    @WXComponentProp(name = "fontSize")
    public void setFontSize(String str) {
        if (getHostView() == null || str == null) {
            return;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("fontSize", str);
        getHostView().setTextSize(0, WXStyle.getFontSize(hashMap, getInstance().getInstanceViewPortWidth()));
    }

    @WXComponentProp(name = Constants.Name.LINES)
    public void setLines(int i) {
        if (getHostView() == null) {
            return;
        }
        getHostView().setLines(i);
    }

    @WXComponentProp(name = "max")
    public void setMax(String str) {
        this.mMax = str;
    }

    @WXComponentProp(name = Constants.Name.MAX_LENGTH)
    public void setMaxLength(int i) {
        if (getHostView() == null) {
            return;
        }
        getHostView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
    }

    @WXComponentProp(name = Constants.Name.MAXLENGTH)
    @Deprecated
    public void setMaxlength(int i) {
        setMaxLength(i);
    }

    @WXComponentProp(name = "min")
    public void setMin(String str) {
        this.mMin = str;
    }

    @WXComponentProp(name = Constants.Name.PLACEHOLDER)
    public void setPlaceholder(String str) {
        if (str == null || getHostView() == null) {
            return;
        }
        getHostView().setHint(str);
    }

    @WXComponentProp(name = Constants.Name.PLACEHOLDER_COLOR)
    public void setPlaceholderColor(String str) {
        int color;
        if (getHostView() == null || TextUtils.isEmpty(str) || (color = WXResourceUtils.getColor(str)) == Integer.MIN_VALUE) {
            return;
        }
        getHostView().setHintTextColor(color);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1898657397:
                if (str.equals(Constants.Name.KEEP_SELECTION_INDEX)) {
                    c = 0;
                    break;
                }
                break;
            case -1576785488:
                if (str.equals(Constants.Name.PLACEHOLDER_COLOR)) {
                    c = 1;
                    break;
                }
                break;
            case -1065511464:
                if (str.equals(Constants.Name.TEXT_ALIGN)) {
                    c = 2;
                    break;
                }
                break;
            case -791400086:
                if (str.equals(Constants.Name.MAX_LENGTH)) {
                    c = 3;
                    break;
                }
                break;
            case 107876:
                if (str.equals("max")) {
                    c = 4;
                    break;
                }
                break;
            case 108114:
                if (str.equals("min")) {
                    c = 5;
                    break;
                }
                break;
            case 3575610:
                if (str.equals("type")) {
                    c = 6;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c = 7;
                    break;
                }
                break;
            case 102977279:
                if (str.equals(Constants.Name.LINES)) {
                    c = '\b';
                    break;
                }
                break;
            case 124732746:
                if (str.equals(Constants.Name.MAXLENGTH)) {
                    c = '\t';
                    break;
                }
                break;
            case 270940796:
                if (str.equals("disabled")) {
                    c = '\n';
                    break;
                }
                break;
            case 365601008:
                if (str.equals("fontSize")) {
                    c = 11;
                    break;
                }
                break;
            case 598246771:
                if (str.equals(Constants.Name.PLACEHOLDER)) {
                    c = '\f';
                    break;
                }
                break;
            case 914346044:
                if (str.equals(Constants.Name.SINGLELINE)) {
                    c = CharUtils.CR;
                    break;
                }
                break;
            case 947486441:
                if (str.equals(Constants.Name.RETURN_KEY_TYPE)) {
                    c = 14;
                    break;
                }
                break;
            case 1625554645:
                if (str.equals(Constants.Name.ALLOW_COPY_PASTE)) {
                    c = 15;
                    break;
                }
                break;
            case 1667607689:
                if (str.equals(Constants.Name.AUTOFOCUS)) {
                    c = 16;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.mKeepSelectionIndex = WXUtils.getBoolean(obj, Boolean.FALSE).booleanValue();
                return true;
            case 1:
                String string = WXUtils.getString(obj, null);
                if (string != null) {
                    setPlaceholderColor(string);
                }
                return true;
            case 2:
                String string2 = WXUtils.getString(obj, null);
                if (string2 != null) {
                    setTextAlign(string2);
                }
                return true;
            case 3:
                Integer integer = WXUtils.getInteger(obj, null);
                if (integer != null) {
                    setMaxLength(integer.intValue());
                }
                return true;
            case 4:
                setMax(String.valueOf(obj));
                return true;
            case 5:
                setMin(String.valueOf(obj));
                return true;
            case 6:
                String string3 = WXUtils.getString(obj, null);
                if (string3 != null) {
                    setType(string3);
                }
                return true;
            case 7:
                String string4 = WXUtils.getString(obj, null);
                if (string4 != null) {
                    setColor(string4);
                }
                return true;
            case '\b':
                Integer integer2 = WXUtils.getInteger(obj, null);
                if (integer2 != null) {
                    setLines(integer2.intValue());
                }
                return true;
            case '\t':
                Integer integer3 = WXUtils.getInteger(obj, null);
                if (integer3 != null) {
                    setMaxLength(integer3.intValue());
                }
                return true;
            case '\n':
                Boolean bool = WXUtils.getBoolean(obj, null);
                if (bool != null && this.mHost != 0) {
                    if (bool.booleanValue()) {
                        ((WXEditText) this.mHost).setFocusable(false);
                        ((WXEditText) this.mHost).setFocusableInTouchMode(false);
                    } else {
                        ((WXEditText) this.mHost).setFocusableInTouchMode(true);
                        ((WXEditText) this.mHost).setFocusable(true);
                    }
                }
                return true;
            case 11:
                String string5 = WXUtils.getString(obj, null);
                if (string5 != null) {
                    setFontSize(string5);
                }
                return true;
            case '\f':
                String string6 = WXUtils.getString(obj, null);
                if (string6 != null) {
                    setPlaceholder(string6);
                }
                return true;
            case '\r':
                Boolean bool2 = WXUtils.getBoolean(obj, null);
                if (bool2 != null) {
                    setSingleLine(bool2.booleanValue());
                }
                return true;
            case 14:
                setReturnKeyType(String.valueOf(obj));
                return true;
            case 15:
                boolean booleanValue = WXUtils.getBoolean(obj, Boolean.TRUE).booleanValue();
                if (getHostView() != null) {
                    getHostView().setAllowCopyPaste(booleanValue);
                }
                return true;
            case 16:
                Boolean bool3 = WXUtils.getBoolean(obj, null);
                if (bool3 != null) {
                    setAutofocus(bool3.booleanValue());
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    @WXComponentProp(name = Constants.Name.RETURN_KEY_TYPE)
    public void setReturnKeyType(String str) {
        if (getHostView() == null) {
            return;
        }
        this.mReturnKeyType = str;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -906336856:
                if (str.equals("search")) {
                    c = 0;
                    break;
                }
                break;
            case 3304:
                if (str.equals(ReturnTypes.GO)) {
                    c = 1;
                    break;
                }
                break;
            case 3089282:
                if (str.equals(ReturnTypes.DONE)) {
                    c = 2;
                    break;
                }
                break;
            case 3377907:
                if (str.equals(ReturnTypes.NEXT)) {
                    c = 3;
                    break;
                }
                break;
            case 3526536:
                if (str.equals("send")) {
                    c = 4;
                    break;
                }
                break;
            case 1544803905:
                if (str.equals("default")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.mEditorAction = 3;
                break;
            case 1:
                this.mEditorAction = 2;
                break;
            case 2:
                this.mEditorAction = 6;
                break;
            case 3:
                this.mEditorAction = 5;
                break;
            case 4:
                this.mEditorAction = 4;
                break;
            case 5:
                this.mEditorAction = 0;
                break;
        }
        blur();
        getHostView().setImeOptions(this.mEditorAction);
    }

    @JSMethod
    public void setSelectionRange(int i, int i2) {
        int length;
        WXEditText hostView = getHostView();
        if (hostView == null || i > (length = getHostView().length()) || i2 > length) {
            return;
        }
        focus();
        hostView.setSelection(i, i2);
    }

    @WXComponentProp(name = Constants.Name.SINGLELINE)
    public void setSingleLine(boolean z) {
        if (getHostView() == null) {
            return;
        }
        getHostView().setSingleLine(z);
    }

    @WXComponentProp(name = Constants.Name.TEXT_ALIGN)
    public void setTextAlign(String str) {
        int textAlign = getTextAlign(str);
        if (textAlign > 0) {
            getHostView().setGravity(textAlign | getVerticalGravity());
        }
    }

    @JSMethod
    public void setTextFormatter(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("formatRule");
            String string2 = jSONObject.getString("formatReplace");
            String string3 = jSONObject.getString("recoverRule");
            String string4 = jSONObject.getString("recoverReplace");
            PatternWrapper parseToPattern = parseToPattern(string, string2);
            PatternWrapper parseToPattern2 = parseToPattern(string3, string4);
            if (parseToPattern == null || parseToPattern2 == null) {
                return;
            }
            this.mFormatter = new TextFormatter(parseToPattern, parseToPattern2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @WXComponentProp(name = "type")
    public void setType(String str) {
        Log.e("weex", "setType=" + str);
        if (str == null || getHostView() == null) {
            return;
        }
        this.mType = str;
        getHostView().setInputType(getInputType(this.mType));
        String str2 = this.mType;
        str2.hashCode();
        if (str2.equals("date") || str2.equals("time")) {
            applyOnClickListener();
        }
    }

    @WXComponentProp(name = "value")
    public void setValue(String str) {
        WXEditText hostView = getHostView();
        if (hostView == null || TextUtils.equals(hostView.getText(), str)) {
            return;
        }
        this.mIgnoreNextOnInputEvent = true;
        int selectionStart = hostView.getSelectionStart();
        hostView.setText(str);
        if (!this.mKeepSelectionIndex) {
            selectionStart = str.length();
        }
        if (str == null) {
            selectionStart = 0;
        }
        hostView.setSelection(selectionStart);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateStyleAndAttrs() {
        if (getStyles().size() > 0) {
            int fontSize = getStyles().containsKey("fontSize") ? WXStyle.getFontSize(getStyles(), getViewPortWidth()) : -1;
            String fontFamily = getStyles().containsKey(Constants.Name.FONT_FAMILY) ? WXStyle.getFontFamily(getStyles()) : null;
            int fontStyle = getStyles().containsKey(Constants.Name.FONT_STYLE) ? WXStyle.getFontStyle(getStyles()) : -1;
            int fontWeight = getStyles().containsKey(Constants.Name.FONT_WEIGHT) ? WXStyle.getFontWeight(getStyles()) : -1;
            int lineHeight = WXStyle.getLineHeight(getStyles(), getViewPortWidth());
            if (lineHeight != -1) {
                this.mLineHeight = lineHeight;
            }
            if (fontSize != -1) {
                this.mPaint.setTextSize(fontSize);
            }
            if (fontFamily != null) {
                TypefaceUtil.applyFontStyle(this.mPaint, fontStyle, fontWeight, fontFamily);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public WXEditText initComponentHostView(@NonNull Context context) {
        WXEditText wXEditText = new WXEditText(context);
        appleStyleAfterCreated(wXEditText);
        return wXEditText;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public void onHostViewInitialized(WXEditText wXEditText) {
        super.onHostViewInitialized((AbstractEditComponent) wXEditText);
        addFocusChangeListener(new WXComponent.OnFocusChangeListener() { // from class: com.taobao.weex.ui.component.AbstractEditComponent.2
            @Override // com.taobao.weex.ui.component.WXComponent.OnFocusChangeListener
            public void onFocusChange(boolean z) {
                if (!z) {
                    AbstractEditComponent.this.decideSoftKeyboard();
                }
                AbstractEditComponent.this.setPseudoClassStatus(Constants.PSEUDO.FOCUS, z);
            }
        });
        addKeyboardListener(wXEditText);
    }
}
