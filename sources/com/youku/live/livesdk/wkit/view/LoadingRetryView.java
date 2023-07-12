package com.youku.live.livesdk.wkit.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.R;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class LoadingRetryView extends RelativeLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int MSG_SET_BACKGROUND_VISIBLE = 257;
    private static final int MSG_SET_BACK_BUTTON_VISIBLE = 258;
    private static final int MSG_SET_LOADING = 259;
    private static final int MSG_SET_RETRY = 260;
    private View mBackButton;
    private View.OnClickListener mBackListener;
    private View mBackground;
    private Handler mHandler;
    private boolean mHasBeenInited;
    private PortraitLoading mPortraitLoading;
    private Button mRetryButton;
    private View mRetryLayout;
    private View.OnClickListener mRetryListener;
    private boolean mViewInflated;
    private Queue<Message> msgQueue;

    public LoadingRetryView(Context context) {
        super(context);
        this.mHasBeenInited = false;
        this.mViewInflated = false;
        this.msgQueue = new ConcurrentLinkedQueue();
        this.mHandler = new Handler() { // from class: com.youku.live.livesdk.wkit.view.LoadingRetryView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-772002344")) {
                    ipChange.ipc$dispatch("-772002344", new Object[]{this, message});
                    return;
                }
                switch (message.what) {
                    case 257:
                        if (message.arg1 == 1) {
                            LoadingRetryView.this.setBackgroundVisibleInternal(true);
                            return;
                        } else {
                            LoadingRetryView.this.setBackgroundVisibleInternal(false);
                            return;
                        }
                    case 258:
                        if (message.arg1 == 1) {
                            LoadingRetryView.this.setBackButtonVisibleInternal(true);
                            return;
                        } else {
                            LoadingRetryView.this.setBackButtonVisibleInternal(false);
                            return;
                        }
                    case 259:
                        if (message.arg1 == 1) {
                            LoadingRetryView.this.setLoadingInternal(true);
                            return;
                        } else {
                            LoadingRetryView.this.setLoadingInternal(false);
                            return;
                        }
                    case 260:
                        if (message.arg1 == 1) {
                            LoadingRetryView.this.setRetryInternal(true);
                            return;
                        } else {
                            LoadingRetryView.this.setRetryInternal(false);
                            return;
                        }
                    default:
                        return;
                }
            }
        };
        initWithContext(context);
    }

    private void initWithContext(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "706740463")) {
            ipChange.ipc$dispatch("706740463", new Object[]{this, context});
        } else if (this.mHasBeenInited) {
        } else {
            this.mHasBeenInited = true;
            new AsyncLayoutInflater(context).inflate(R.C7960layout.dago_container_retry_loading_layout, this, new AsyncLayoutInflater.OnInflateFinishedListener() { // from class: com.youku.live.livesdk.wkit.view.LoadingRetryView.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
                public void onInflateFinished(View view, int i, ViewGroup viewGroup) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "2090885883")) {
                        ipChange2.ipc$dispatch("2090885883", new Object[]{this, view, Integer.valueOf(i), viewGroup});
                        return;
                    }
                    viewGroup.addView(view);
                    LoadingRetryView.this.mBackground = view.findViewById(R.id.dago_container_loading_root);
                    LoadingRetryView loadingRetryView = LoadingRetryView.this;
                    int i2 = R.id.dago_container_loading;
                    loadingRetryView.mPortraitLoading = (PortraitLoading) view.findViewById(i2);
                    LoadingRetryView.this.mRetryLayout = view.findViewById(R.id.dago_container_retry_layout);
                    LoadingRetryView.this.mBackButton = view.findViewById(R.id.dago_container_back);
                    LoadingRetryView.this.mRetryButton = (Button) view.findViewById(R.id.dago_container_fail_retry_btn);
                    LoadingRetryView.this.mPortraitLoading = (PortraitLoading) view.findViewById(i2);
                    if (LoadingRetryView.this.mRetryButton != null) {
                        LoadingRetryView.this.mRetryButton.setOnClickListener(LoadingRetryView.this.mRetryListener);
                    }
                    if (LoadingRetryView.this.mBackButton != null) {
                        LoadingRetryView.this.mBackButton.setOnClickListener(LoadingRetryView.this.mBackListener);
                    }
                    if (LoadingRetryView.this.mRetryLayout != null) {
                        LoadingRetryView.this.mRetryLayout.setOnClickListener(LoadingRetryView.this.mRetryListener);
                    }
                    LoadingRetryView.this.mViewInflated = true;
                    if (LoadingRetryView.this.msgQueue != null) {
                        while (!LoadingRetryView.this.msgQueue.isEmpty()) {
                            Message message = (Message) LoadingRetryView.this.msgQueue.poll();
                            if (message != null) {
                                LoadingRetryView.this.mHandler.sendMessage(message);
                            }
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackButtonVisibleInternal(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-554867952")) {
            ipChange.ipc$dispatch("-554867952", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = this.mBackButton;
        if (view != null) {
            view.setVisibility(z ? 0 : 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBackgroundVisibleInternal(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "8797883")) {
            ipChange.ipc$dispatch("8797883", new Object[]{this, Boolean.valueOf(z)});
            return;
        }
        View view = this.mBackground;
        if (view != null) {
            if (z) {
                view.setBackgroundResource(R.C7959drawable.dago_container_live_room_bg_online_class);
            } else {
                view.setBackground(new ColorDrawable(0));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingInternal(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1011410515")) {
            ipChange.ipc$dispatch("1011410515", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            this.mPortraitLoading.setVisibility(0);
            this.mPortraitLoading.startAnimation(true);
        } else {
            this.mPortraitLoading.setVisibility(4);
            this.mPortraitLoading.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRetryInternal(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1299929215")) {
            ipChange.ipc$dispatch("1299929215", new Object[]{this, Boolean.valueOf(z)});
        } else if (z) {
            View view = this.mRetryLayout;
            if (view != null) {
                view.setVisibility(0);
            }
            stopLoading();
        } else {
            View view2 = this.mRetryLayout;
            if (view2 != null) {
                view2.setVisibility(4);
            }
        }
    }

    public void hideRetry() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1486428180")) {
            ipChange.ipc$dispatch("-1486428180", new Object[]{this});
        } else if (this.mViewInflated) {
            setRetryInternal(false);
        } else {
            Message message = new Message();
            message.what = 260;
            message.arg1 = 0;
            this.msgQueue.add(message);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "756869421")) {
            ipChange.ipc$dispatch("756869421", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        if (this.mViewInflated) {
            setLoadingInternal(false);
        }
        this.msgQueue.clear();
    }

    public void setBackButtonVisible(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2047599283")) {
            ipChange.ipc$dispatch("2047599283", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mViewInflated) {
            setBackgroundVisibleInternal(z);
        } else {
            Message message = new Message();
            message.what = 258;
            message.arg1 = z ? 1 : 0;
            this.msgQueue.add(message);
        }
    }

    public void setBackListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1648910588")) {
            ipChange.ipc$dispatch("-1648910588", new Object[]{this, onClickListener});
        } else {
            this.mBackListener = onClickListener;
        }
    }

    public void setBackgroundVisible(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1661245790")) {
            ipChange.ipc$dispatch("1661245790", new Object[]{this, Boolean.valueOf(z)});
        } else if (this.mViewInflated) {
            setBackgroundVisibleInternal(z);
        } else {
            Message message = new Message();
            message.what = 257;
            message.arg1 = z ? 1 : 0;
            this.msgQueue.add(message);
        }
    }

    public void setRetryButtonListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "774456685")) {
            ipChange.ipc$dispatch("774456685", new Object[]{this, onClickListener});
        } else {
            this.mRetryListener = onClickListener;
        }
    }

    public void setRetryListener(View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1267075035")) {
            ipChange.ipc$dispatch("1267075035", new Object[]{this, onClickListener});
        } else {
            this.mRetryListener = onClickListener;
        }
    }

    public void showRetry() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1394342567")) {
            ipChange.ipc$dispatch("1394342567", new Object[]{this});
        } else if (this.mViewInflated) {
            setRetryInternal(true);
        } else {
            Message message = new Message();
            message.what = 260;
            message.arg1 = 1;
            this.msgQueue.add(message);
        }
    }

    public void startLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629074142")) {
            ipChange.ipc$dispatch("629074142", new Object[]{this});
        } else if (this.mViewInflated) {
            setLoadingInternal(true);
        } else {
            Message message = new Message();
            message.what = 259;
            message.arg1 = 1;
            this.msgQueue.add(message);
        }
    }

    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2000281560")) {
            ipChange.ipc$dispatch("2000281560", new Object[]{this});
        } else if (this.mViewInflated) {
            setLoadingInternal(false);
        } else {
            Message message = new Message();
            message.what = 259;
            message.arg1 = 0;
            this.msgQueue.add(message);
        }
    }

    public LoadingRetryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHasBeenInited = false;
        this.mViewInflated = false;
        this.msgQueue = new ConcurrentLinkedQueue();
        this.mHandler = new Handler() { // from class: com.youku.live.livesdk.wkit.view.LoadingRetryView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-772002344")) {
                    ipChange.ipc$dispatch("-772002344", new Object[]{this, message});
                    return;
                }
                switch (message.what) {
                    case 257:
                        if (message.arg1 == 1) {
                            LoadingRetryView.this.setBackgroundVisibleInternal(true);
                            return;
                        } else {
                            LoadingRetryView.this.setBackgroundVisibleInternal(false);
                            return;
                        }
                    case 258:
                        if (message.arg1 == 1) {
                            LoadingRetryView.this.setBackButtonVisibleInternal(true);
                            return;
                        } else {
                            LoadingRetryView.this.setBackButtonVisibleInternal(false);
                            return;
                        }
                    case 259:
                        if (message.arg1 == 1) {
                            LoadingRetryView.this.setLoadingInternal(true);
                            return;
                        } else {
                            LoadingRetryView.this.setLoadingInternal(false);
                            return;
                        }
                    case 260:
                        if (message.arg1 == 1) {
                            LoadingRetryView.this.setRetryInternal(true);
                            return;
                        } else {
                            LoadingRetryView.this.setRetryInternal(false);
                            return;
                        }
                    default:
                        return;
                }
            }
        };
        initWithContext(context);
    }

    public LoadingRetryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHasBeenInited = false;
        this.mViewInflated = false;
        this.msgQueue = new ConcurrentLinkedQueue();
        this.mHandler = new Handler() { // from class: com.youku.live.livesdk.wkit.view.LoadingRetryView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-772002344")) {
                    ipChange.ipc$dispatch("-772002344", new Object[]{this, message});
                    return;
                }
                switch (message.what) {
                    case 257:
                        if (message.arg1 == 1) {
                            LoadingRetryView.this.setBackgroundVisibleInternal(true);
                            return;
                        } else {
                            LoadingRetryView.this.setBackgroundVisibleInternal(false);
                            return;
                        }
                    case 258:
                        if (message.arg1 == 1) {
                            LoadingRetryView.this.setBackButtonVisibleInternal(true);
                            return;
                        } else {
                            LoadingRetryView.this.setBackButtonVisibleInternal(false);
                            return;
                        }
                    case 259:
                        if (message.arg1 == 1) {
                            LoadingRetryView.this.setLoadingInternal(true);
                            return;
                        } else {
                            LoadingRetryView.this.setLoadingInternal(false);
                            return;
                        }
                    case 260:
                        if (message.arg1 == 1) {
                            LoadingRetryView.this.setRetryInternal(true);
                            return;
                        } else {
                            LoadingRetryView.this.setRetryInternal(false);
                            return;
                        }
                    default:
                        return;
                }
            }
        };
        initWithContext(context);
    }
}
