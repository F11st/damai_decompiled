package cn.damai.baseview.pull.lib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class LoadingLayout extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    static final int DEFAULT_ROTATION_ANIMATION_DURATION = 150;
    private static final SimpleDateFormat sdfProjectState = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Date currentData;
    private final ImageView headerImage;
    private final ProgressBar headerProgress;
    private final TextView headerText;
    private String pullLabel;
    private final TextView pull_to_refresh_time;
    private String refreshingLabel;
    private String releaseLabel;
    private final Animation resetRotateAnimation;
    private final Animation rotateAnimation;

    public LoadingLayout(Context context, int i, String str, String str2, String str3) {
        super(context);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R$layout.pull_to_refresh_header, this);
        this.headerText = (TextView) viewGroup.findViewById(R$id.pull_to_refresh_text);
        TextView textView = (TextView) viewGroup.findViewById(R$id.pull_to_refresh_time);
        this.pull_to_refresh_time = textView;
        this.headerImage = (ImageView) viewGroup.findViewById(R$id.pull_to_refresh_image);
        this.headerProgress = (ProgressBar) viewGroup.findViewById(R$id.pull_to_refresh_progress);
        this.currentData = new Date();
        textView.setText("更新于:" + sdfProjectState.format(this.currentData));
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.rotateAnimation = rotateAnimation;
        rotateAnimation.setInterpolator(linearInterpolator);
        rotateAnimation.setDuration(150L);
        rotateAnimation.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.resetRotateAnimation = rotateAnimation2;
        rotateAnimation2.setInterpolator(linearInterpolator);
        rotateAnimation2.setDuration(150L);
        rotateAnimation2.setFillAfter(true);
        this.releaseLabel = str;
        this.pullLabel = str2;
        this.refreshingLabel = str3;
    }

    public void pullToRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374761354")) {
            ipChange.ipc$dispatch("374761354", new Object[]{this});
            return;
        }
        this.headerText.setText(this.pullLabel);
        this.headerImage.clearAnimation();
    }

    public void refreshing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1705130974")) {
            ipChange.ipc$dispatch("1705130974", new Object[]{this});
            return;
        }
        this.headerText.setText(this.refreshingLabel);
        this.headerImage.clearAnimation();
        this.headerImage.setVisibility(4);
        this.headerProgress.setVisibility(0);
    }

    public void releaseToRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-899943892")) {
            ipChange.ipc$dispatch("-899943892", new Object[]{this});
            return;
        }
        this.headerText.setText(this.releaseLabel);
        this.headerImage.clearAnimation();
    }

    public void reset() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1489459414")) {
            ipChange.ipc$dispatch("1489459414", new Object[]{this});
            return;
        }
        this.headerText.setText(this.pullLabel);
        this.pull_to_refresh_time.setVisibility(0);
        this.currentData = new Date();
        TextView textView = this.pull_to_refresh_time;
        textView.setText("更新于:" + sdfProjectState.format(this.currentData));
        this.headerImage.setVisibility(0);
        this.headerProgress.setVisibility(8);
    }

    public void setPullLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1479758754")) {
            ipChange.ipc$dispatch("1479758754", new Object[]{this, str});
        } else {
            this.pullLabel = str;
        }
    }

    public void setRefreshingLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1894316924")) {
            ipChange.ipc$dispatch("-1894316924", new Object[]{this, str});
        } else {
            this.refreshingLabel = str;
        }
    }

    public void setReleaseLabel(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1794981312")) {
            ipChange.ipc$dispatch("1794981312", new Object[]{this, str});
        } else {
            this.releaseLabel = str;
        }
    }

    public void setTextColor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-907637454")) {
            ipChange.ipc$dispatch("-907637454", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.headerText.setTextColor(i);
        }
    }
}
