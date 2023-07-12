package com.alibaba.poplayerconsole.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.poplayer.trigger.view.C3698c;
import com.alibaba.poplayerconsole.C3705a;
import com.alibaba.poplayerconsole.R$id;
import com.alibaba.poplayerconsole.R$layout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import tb.gw2;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PopLayerToolsView extends ScrollView implements View.OnClickListener, ILogView {
    private boolean mIsTrackMode;
    private C3698c mSelector;
    private Button mTrackBtn;
    private TextView mTrackResult;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayerconsole.view.PopLayerToolsView$b */
    /* loaded from: classes8.dex */
    private class View$OnTouchListenerC3725b implements View.OnTouchListener {
        private View[] a;
        private final Drawable b;

        /* compiled from: Taobao */
        /* renamed from: com.alibaba.poplayerconsole.view.PopLayerToolsView$b$a */
        /* loaded from: classes8.dex */
        class C3726a extends ClickableSpan {
            final /* synthetic */ String a;

            C3726a(String str) {
                this.a = str;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                PopLayerToolsView.this.copyToClipboard(this.a);
                Toast.makeText(PopLayerToolsView.this.getContext().getApplicationContext(), "Copy to clipboard success.", 0).show();
            }
        }

        private View$OnTouchListenerC3725b() {
            this.b = new ColorDrawable(-2013265920);
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        @TargetApi(16)
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int action = motionEvent.getAction();
            int i = 0;
            if (action != 0) {
                if (action == 1 || action == 3) {
                    View[] viewArr = this.a;
                    int length = viewArr.length;
                    while (i < length) {
                        View view2 = viewArr[i];
                        view2.setBackground((Drawable) view2.getTag(R$id.poplayer_console_register_background_tag_id));
                        i++;
                    }
                    this.a = null;
                    return true;
                }
                return true;
            }
            PopLayerToolsView.this.updateButton();
            this.a = PopLayerToolsView.this.mSelector.k(rawX, rawY);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableStringBuilder append = spannableStringBuilder.append((CharSequence) "Find ");
            append.append((CharSequence) ("" + this.a.length)).append((CharSequence) " selector: \n");
            View[] viewArr2 = this.a;
            int length2 = viewArr2.length;
            while (i < length2) {
                View view3 = viewArr2[i];
                view3.setTag(R$id.poplayer_console_register_background_tag_id, view3.getBackground());
                view3.setBackground(this.b);
                String hierarchy = PopLayerToolsView.this.getHierarchy(view3, 3);
                int length3 = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) hierarchy);
                spannableStringBuilder.setSpan(new C3726a(hierarchy), length3, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append((CharSequence) "\n\n");
                i++;
            }
            PopLayerToolsView.this.mTrackResult.setMovementMethod(LinkMovementMethod.getInstance());
            PopLayerToolsView.this.mTrackResult.setText(spannableStringBuilder);
            return true;
        }
    }

    public PopLayerToolsView(Context context) {
        super(context);
        this.mSelector = new C3698c();
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R$layout.console_tools, (ViewGroup) this, true);
        this.mTrackBtn = (Button) findViewById(R$id.track_pick_btn);
        this.mTrackResult = (TextView) findViewById(R$id.track_result);
        this.mTrackBtn.setOnClickListener(this);
        this.mTrackResult.setOnClickListener(this);
        updateButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyToClipboard(String str) {
        ((ClipboardManager) getContext().getApplicationContext().getSystemService("clipboard")).setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getHierarchy(View view, int i) {
        ArrayList<View> arrayList = new ArrayList();
        arrayList.add(view);
        int i2 = 0;
        while (true) {
            if (i > 0 && i2 >= i) {
                break;
            }
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
            arrayList.add(view);
            i2++;
        }
        StringBuilder sb = new StringBuilder();
        for (View view2 : arrayList) {
            sb.insert(0, getViewProps(view2)).insert(0, jn1.G);
        }
        if (sb.length() >= 1) {
            return sb.substring(1, sb.length());
        }
        return sb.toString();
    }

    private String getViewProps(View view) {
        String str;
        if (view == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(view.getClass().getName());
        CharSequence contentDescription = view.getContentDescription();
        if (!TextUtils.isEmpty(contentDescription)) {
            sb.append("[contentDescription=");
            sb.append(contentDescription.toString());
            sb.append(jn1.ARRAY_END_STR);
        }
        Object tag = view.getTag();
        if (tag != null) {
            sb.append("[tag=");
            sb.append(tag.toString());
            sb.append(jn1.ARRAY_END_STR);
        }
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (!TextUtils.isEmpty(text)) {
                sb.append("[text=");
                sb.append(text.toString());
                sb.append(jn1.ARRAY_END_STR);
            }
        }
        int id = view.getId();
        if (-1 != id && id == 0) {
            Resources resources = view.getResources();
            int i = (-16777216) & id;
            if (i == 16777216) {
                str = "android";
            } else if (i != 2130706432) {
                try {
                    str = resources.getResourcePackageName(id);
                } catch (Resources.NotFoundException unused) {
                }
            } else {
                str = "app";
            }
            String resourceTypeName = resources.getResourceTypeName(id);
            String resourceEntryName = resources.getResourceEntryName(id);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(":");
            sb2.append(resourceTypeName);
            sb2.append("/");
            sb2.append(resourceEntryName);
            sb.append("[id=");
            sb.append(sb2.toString());
            sb.append(jn1.ARRAY_END_STR);
            return sb2.toString();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateButton() {
        Button button = this.mTrackBtn;
        StringBuilder sb = new StringBuilder();
        sb.append(this.mIsTrackMode ? "Stop" : "Start");
        sb.append(" Track Mode");
        button.setText(sb.toString());
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public void destoryView() {
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public String getTitle() {
        return "Tools";
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public View getView() {
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R$id.track_pick_btn) {
            try {
                this.mIsTrackMode = !this.mIsTrackMode;
                updateButton();
                Activity activity = (Activity) gw2.a((WeakReference) C3705a.d().get("page").b);
                if (activity == null) {
                    Toast.makeText(getContext().getApplicationContext(), "Current Activity is null", 0).show();
                    return;
                }
                Window window = activity.getWindow();
                int i = R$id.poplayer_console_selector_touch_interceptor_id;
                View findViewById = window.findViewById(i);
                if (findViewById != null) {
                    ((ViewGroup) findViewById.getParent()).removeView(findViewById);
                    return;
                }
                FrameLayout frameLayout = new FrameLayout(activity);
                frameLayout.setBackgroundColor(1157562368);
                frameLayout.setId(i);
                activity.getWindow().addContentView(frameLayout, new ViewGroup.LayoutParams(-1, -1));
                frameLayout.setOnTouchListener(new View$OnTouchListenerC3725b());
            } catch (Exception e) {
                Log.e("PopLayer", "Toggle_view_tracker.error", e);
            }
        }
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public void update(com.alibaba.poplayerconsole.lib.Window window) throws Throwable {
    }
}
