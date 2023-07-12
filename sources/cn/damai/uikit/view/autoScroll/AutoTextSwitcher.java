package cn.damai.uikit.view.autoScroll;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.th2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AutoTextSwitcher extends TextSwitcher {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int TIME_FLIP = 3000;
    private boolean isAttachedToWindow;
    private List<String> mList;
    private OnNextTextShowListener mListener;
    private int mPos;
    private Runnable mTask;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnNextTextShowListener {
        void onNext(String str);
    }

    public AutoTextSwitcher(Context context) {
        this(context, null);
    }

    static /* synthetic */ int access$108(AutoTextSwitcher autoTextSwitcher) {
        int i = autoTextSwitcher.mPos;
        autoTextSwitcher.mPos = i + 1;
        return i;
    }

    private void callListener(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "321967139")) {
            ipChange.ipc$dispatch("321967139", new Object[]{this, str});
            return;
        }
        OnNextTextShowListener onNextTextShowListener = this.mListener;
        if (onNextTextShowListener != null) {
            onNextTextShowListener.onNext(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeAnimation(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2005922743")) {
            ipChange.ipc$dispatch("-2005922743", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            if (isCanFlipping()) {
                removeCallbacks(this.mTask);
                postDelayed(this.mTask, 3000L);
            }
        } else {
            removeCallbacks(this.mTask);
        }
    }

    private boolean isCanFlipping() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1695603390") ? ((Boolean) ipChange.ipc$dispatch("1695603390", new Object[]{this})).booleanValue() : this.isAttachedToWindow && getVisibility() == 0 && th2.b(this.mList) > 1;
    }

    private boolean isListContentSame(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1818946883")) {
            return ((Boolean) ipChange.ipc$dispatch("-1818946883", new Object[]{this, list})).booleanValue();
        }
        List<String> list2 = this.mList;
        if (list2 == null || list == null || list2.size() <= 0 || this.mList.size() != list.size()) {
            return false;
        }
        for (int i = 0; i < this.mList.size(); i++) {
            if (!TextUtils.equals(this.mList.get(i), list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2059575875")) {
            ipChange.ipc$dispatch("-2059575875", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        changeAnimation(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-182044256")) {
            ipChange.ipc$dispatch("-182044256", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        changeAnimation(false);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1119656563")) {
            ipChange.ipc$dispatch("-1119656563", new Object[]{this, view, Integer.valueOf(i)});
            return;
        }
        super.onVisibilityChanged(view, i);
        changeAnimation(i == 0);
    }

    public void setListener(OnNextTextShowListener onNextTextShowListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2112586226")) {
            ipChange.ipc$dispatch("2112586226", new Object[]{this, onNextTextShowListener});
        } else {
            this.mListener = onNextTextShowListener;
        }
    }

    @Override // android.widget.TextSwitcher
    public void setText(CharSequence charSequence) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1518709324")) {
            ipChange.ipc$dispatch("-1518709324", new Object[]{this, charSequence});
            return;
        }
        callListener(charSequence == null ? null : charSequence.toString());
        super.setText(charSequence);
    }

    public void update(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088492781")) {
            ipChange.ipc$dispatch("-2088492781", new Object[]{this, list});
        } else if (th2.b(list) == 0) {
            this.mList = null;
            this.mPos = 0;
            reset();
        } else if (!isListContentSame(list)) {
            this.mList = list;
            this.mPos = 0;
            int childCount = getChildCount();
            if (childCount > 0) {
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt instanceof TextView) {
                        ((TextView) childAt).setText((CharSequence) null);
                    }
                }
            }
            if (th2.b(list) > 0) {
                this.mPos++;
                setText(list.get(0));
                changeAnimation(true);
            }
        }
    }

    public AutoTextSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isAttachedToWindow = false;
        this.mTask = new Runnable() { // from class: cn.damai.uikit.view.autoScroll.AutoTextSwitcher.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1082391225")) {
                    ipChange.ipc$dispatch("-1082391225", new Object[]{this});
                } else if (th2.b(AutoTextSwitcher.this.mList) > 0) {
                    int size = AutoTextSwitcher.this.mPos % AutoTextSwitcher.this.mList.size();
                    AutoTextSwitcher.access$108(AutoTextSwitcher.this);
                    AutoTextSwitcher autoTextSwitcher = AutoTextSwitcher.this;
                    autoTextSwitcher.setText((CharSequence) autoTextSwitcher.mList.get(size));
                    AutoTextSwitcher.this.changeAnimation(true);
                }
            }
        };
    }
}
