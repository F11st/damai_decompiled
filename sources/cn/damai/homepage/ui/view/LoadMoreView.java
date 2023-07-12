package cn.damai.homepage.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.irecycler.widget.LoadingView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class LoadMoreView extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView mLoadMoreTip;
    private LoadingView mLoadMoreView;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public enum LoadMoreStatus {
        LOADING,
        END,
        NETWORK_EXCEPTION
    }

    public LoadMoreView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "207027219")) {
            ipChange.ipc$dispatch("207027219", new Object[]{this, context});
            return;
        }
        LayoutInflater.from(context).inflate(R$layout.homepage_load_more_view, this);
        this.mLoadMoreTip = (TextView) findViewById(R$id.load_more_tip);
        this.mLoadMoreView = (LoadingView) findViewById(R$id.loadingView);
    }

    public void setLoadMoreText(LoadMoreStatus loadMoreStatus, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1061182247")) {
            ipChange.ipc$dispatch("-1061182247", new Object[]{this, loadMoreStatus, str});
            return;
        }
        LoadingView loadingView = this.mLoadMoreView;
        if (loadingView != null) {
            if (loadMoreStatus == LoadMoreStatus.END) {
                loadingView.setVisibility(8);
                if (TextUtils.isEmpty(str)) {
                    str = "只有这么多了，明天再来 ╰(*°▽°*)╯";
                }
            } else if (loadMoreStatus == LoadMoreStatus.LOADING) {
                loadingView.setVisibility(0);
                if (TextUtils.isEmpty(str)) {
                    str = "正在寻找你喜欢的";
                }
            } else if (loadMoreStatus == LoadMoreStatus.NETWORK_EXCEPTION) {
                loadingView.setVisibility(8);
                str = "网络开小差了哦";
            }
            TextView textView = this.mLoadMoreTip;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public LoadMoreView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public LoadMoreView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
