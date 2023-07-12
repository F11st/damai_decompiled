package cn.damai.uikit.irecycler.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class LoadMoreView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView loadMoreTip;
    private LoadingView loadMoreView;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public enum Status {
        INIT,
        GONE,
        LOADING,
        ERROR,
        THE_END
    }

    public LoadMoreView(Context context) {
        this(context, null);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1302139940")) {
            ipChange.ipc$dispatch("-1302139940", new Object[]{this});
            return;
        }
        LinearLayout.inflate(getContext(), R$layout.uikit_load_more_view, this);
        this.loadMoreView = (LoadingView) findViewById(R$id.uikit_load_more_loading_icon);
        this.loadMoreTip = (TextView) findViewById(R$id.uikit_load_more_loading_tip);
    }

    public void setLoadMoreTip(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1155322269")) {
            ipChange.ipc$dispatch("1155322269", new Object[]{this, str});
            return;
        }
        TextView textView = this.loadMoreTip;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public void setLoadingIconType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1041982017")) {
            ipChange.ipc$dispatch("-1041982017", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        LoadingView loadingView = this.loadMoreView;
        if (loadingView == null) {
            return;
        }
        loadingView.setLoadingIconType(i);
    }

    public void setStatus(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-725429169")) {
            ipChange.ipc$dispatch("-725429169", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        LoadingView loadingView = this.loadMoreView;
        if (loadingView == null) {
            return;
        }
        loadingView.setVisibility(z ? 8 : 0);
    }

    public LoadMoreView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadMoreView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public void setStatus(Status status, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "998795084")) {
            ipChange.ipc$dispatch("998795084", new Object[]{this, status, str});
            return;
        }
        LoadingView loadingView = this.loadMoreView;
        if (loadingView == null || this.loadMoreTip == null) {
            return;
        }
        if (status == Status.GONE) {
            loadingView.setVisibility(8);
            this.loadMoreTip.setVisibility(8);
        } else if (status == Status.LOADING) {
            loadingView.setVisibility(0);
            this.loadMoreTip.setVisibility(0);
            if (TextUtils.isEmpty(str)) {
                str = "正在寻找你喜欢的";
            }
        } else if (status == Status.THE_END) {
            loadingView.setVisibility(8);
            this.loadMoreTip.setVisibility(0);
            if (TextUtils.isEmpty(str)) {
                str = "只有这么多了，明天再来 ╰(*°▽°*)╯";
            }
        } else if (status == Status.ERROR) {
            loadingView.setVisibility(8);
            this.loadMoreTip.setVisibility(0);
            if (TextUtils.isEmpty(str)) {
                str = "网络开小差了哦";
            }
        } else if (status == Status.INIT) {
            loadingView.setVisibility(8);
            this.loadMoreTip.setVisibility(8);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.loadMoreTip.setText(str);
    }
}
