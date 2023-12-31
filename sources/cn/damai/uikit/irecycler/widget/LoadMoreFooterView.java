package cn.damai.uikit.irecycler.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class LoadMoreFooterView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private View mErrorView;
    private View mLoadingView;
    private OnRetryListener mOnRetryListener;
    private Status mStatus;
    private View mTheEndView;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnRetryListener {
        void onRetry(LoadMoreFooterView loadMoreFooterView);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum Status {
        GONE,
        LOADING,
        ERROR,
        THE_END
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "419091594")) {
                ipChange.ipc$dispatch("419091594", new Object[]{this, view});
            } else if (LoadMoreFooterView.this.mOnRetryListener != null) {
                LoadMoreFooterView.this.mOnRetryListener.onRetry(LoadMoreFooterView.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Status.values().length];
            a = iArr;
            try {
                iArr[Status.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Status.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Status.THE_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public LoadMoreFooterView(Context context) {
        this(context, null);
    }

    private void change() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-649943396")) {
            ipChange.ipc$dispatch("-649943396", new Object[]{this});
            return;
        }
        int i = b.a[this.mStatus.ordinal()];
        if (i == 1) {
            this.mLoadingView.setVisibility(8);
            this.mErrorView.setVisibility(8);
            this.mTheEndView.setVisibility(8);
        } else if (i == 2) {
            this.mLoadingView.setVisibility(0);
            this.mErrorView.setVisibility(8);
            this.mTheEndView.setVisibility(8);
        } else if (i == 3) {
            this.mLoadingView.setVisibility(8);
            this.mErrorView.setVisibility(0);
            this.mTheEndView.setVisibility(8);
        } else if (i != 4) {
        } else {
            this.mLoadingView.setVisibility(8);
            this.mErrorView.setVisibility(8);
            this.mTheEndView.setVisibility(0);
        }
    }

    public boolean canLoadMore() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1379426263")) {
            return ((Boolean) ipChange.ipc$dispatch("1379426263", new Object[]{this})).booleanValue();
        }
        Status status = this.mStatus;
        return status == Status.GONE || status == Status.ERROR;
    }

    public Status getStatus() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1711160520") ? (Status) ipChange.ipc$dispatch("1711160520", new Object[]{this}) : this.mStatus;
    }

    public void setOnRetryListener(OnRetryListener onRetryListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1301279056")) {
            ipChange.ipc$dispatch("-1301279056", new Object[]{this, onRetryListener});
        } else {
            this.mOnRetryListener = onRetryListener;
        }
    }

    public void setStatus(Status status) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "115655800")) {
            ipChange.ipc$dispatch("115655800", new Object[]{this, status});
            return;
        }
        this.mStatus = status;
        change();
    }

    public LoadMoreFooterView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadMoreFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R$layout.layout_irecyclerview_load_more_footer_view, (ViewGroup) this, true);
        this.mLoadingView = findViewById(R$id.loadingView);
        this.mErrorView = findViewById(R$id.errorView);
        this.mTheEndView = findViewById(R$id.theEndView);
        this.mErrorView.setOnClickListener(new a());
        setStatus(Status.GONE);
    }
}
