package in.srain.cube.views.ptr;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import tb.rx1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class PtrClassicDefaultHeader extends FrameLayout implements PtrUIHandler {
    private static final String KEY_SharedPreferences = "cube_ptr_classic_last_update";
    private static SimpleDateFormat sDataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private RotateAnimation mFlipAnimation;
    private TextView mLastUpdateTextView;
    private long mLastUpdateTime;
    private String mLastUpdateTimeKey;
    private LastUpdateTimeUpdater mLastUpdateTimeUpdater;
    private View mProgressBar;
    private RotateAnimation mReverseFlipAnimation;
    private int mRotateAniTime;
    private View mRotateView;
    private boolean mShouldShowLastUpdate;
    private TextView mTitleTextView;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private class LastUpdateTimeUpdater implements Runnable {
        private boolean mRunning;

        private LastUpdateTimeUpdater() {
            this.mRunning = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void start() {
            if (TextUtils.isEmpty(PtrClassicDefaultHeader.this.mLastUpdateTimeKey)) {
                return;
            }
            this.mRunning = true;
            run();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop() {
            this.mRunning = false;
            PtrClassicDefaultHeader.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            PtrClassicDefaultHeader.this.tryUpdateLastUpdateTime();
            if (this.mRunning) {
                PtrClassicDefaultHeader.this.postDelayed(this, 1000L);
            }
        }
    }

    public PtrClassicDefaultHeader(Context context) {
        super(context);
        this.mRotateAniTime = 150;
        this.mLastUpdateTime = -1L;
        this.mLastUpdateTimeUpdater = new LastUpdateTimeUpdater();
        initViews(null);
    }

    private void buildAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.mFlipAnimation = rotateAnimation;
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.mFlipAnimation.setDuration(this.mRotateAniTime);
        this.mFlipAnimation.setFillAfter(true);
        RotateAnimation rotateAnimation2 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.mReverseFlipAnimation = rotateAnimation2;
        rotateAnimation2.setInterpolator(new LinearInterpolator());
        this.mReverseFlipAnimation.setDuration(this.mRotateAniTime);
        this.mReverseFlipAnimation.setFillAfter(true);
    }

    private void crossRotateLineFromBottomUnderTouch(PtrFrameLayout ptrFrameLayout) {
        this.mTitleTextView.setVisibility(0);
        if (ptrFrameLayout.isPullToRefresh()) {
            this.mTitleTextView.setText(getResources().getString(R$string.cube_ptr_pull_down_to_refresh));
        } else {
            this.mTitleTextView.setText(getResources().getString(R$string.cube_ptr_pull_down));
        }
    }

    private void crossRotateLineFromTopUnderTouch(PtrFrameLayout ptrFrameLayout) {
        if (ptrFrameLayout.isPullToRefresh()) {
            return;
        }
        this.mTitleTextView.setVisibility(0);
        this.mTitleTextView.setText(R$string.cube_ptr_release_to_refresh);
    }

    private String getLastUpdateTime() {
        if (this.mLastUpdateTime == -1 && !TextUtils.isEmpty(this.mLastUpdateTimeKey)) {
            this.mLastUpdateTime = getContext().getSharedPreferences(KEY_SharedPreferences, 0).getLong(this.mLastUpdateTimeKey, -1L);
        }
        if (this.mLastUpdateTime == -1) {
            return null;
        }
        long time = new Date().getTime() - this.mLastUpdateTime;
        int i = (int) (time / 1000);
        if (time >= 0 && i > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(getContext().getString(R$string.cube_ptr_last_update));
            if (i < 60) {
                sb.append(i + getContext().getString(R$string.cube_ptr_seconds_ago));
            } else {
                int i2 = i / 60;
                if (i2 > 60) {
                    int i3 = i2 / 60;
                    if (i3 > 24) {
                        sb.append(sDataFormat.format(new Date(this.mLastUpdateTime)));
                    } else {
                        sb.append(i3 + getContext().getString(R$string.cube_ptr_hours_ago));
                    }
                } else {
                    sb.append(i2 + getContext().getString(R$string.cube_ptr_minutes_ago));
                }
            }
            return sb.toString();
        }
        return null;
    }

    private void hideRotateView() {
        this.mRotateView.clearAnimation();
        this.mRotateView.setVisibility(4);
    }

    private void resetView() {
        hideRotateView();
        this.mProgressBar.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryUpdateLastUpdateTime() {
        if (!TextUtils.isEmpty(this.mLastUpdateTimeKey) && this.mShouldShowLastUpdate) {
            String lastUpdateTime = getLastUpdateTime();
            if (TextUtils.isEmpty(lastUpdateTime)) {
                this.mLastUpdateTextView.setVisibility(8);
                return;
            }
            this.mLastUpdateTextView.setVisibility(0);
            this.mLastUpdateTextView.setText(lastUpdateTime);
            return;
        }
        this.mLastUpdateTextView.setVisibility(8);
    }

    protected void initViews(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.PtrClassicHeader, 0, 0);
        if (obtainStyledAttributes != null) {
            this.mRotateAniTime = obtainStyledAttributes.getInt(R$styleable.PtrClassicHeader_ptr_rotate_ani_time, this.mRotateAniTime);
        }
        buildAnimation();
        View inflate = LayoutInflater.from(getContext()).inflate(R$layout.cube_ptr_classic_default_header, this);
        this.mRotateView = inflate.findViewById(R$id.ptr_classic_header_rotate_view);
        this.mTitleTextView = (TextView) inflate.findViewById(R$id.ptr_classic_header_rotate_view_header_title);
        this.mLastUpdateTextView = (TextView) inflate.findViewById(R$id.ptr_classic_header_rotate_view_header_last_update);
        this.mProgressBar = inflate.findViewById(R$id.ptr_classic_header_rotate_view_progressbar);
        resetView();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LastUpdateTimeUpdater lastUpdateTimeUpdater = this.mLastUpdateTimeUpdater;
        if (lastUpdateTimeUpdater != null) {
            lastUpdateTimeUpdater.stop();
        }
    }

    public void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, rx1 rx1Var) {
        int offsetToRefresh = ptrFrameLayout.getOffsetToRefresh();
        int d = rx1Var.d();
        int f = rx1Var.f();
        if (d < offsetToRefresh && f >= offsetToRefresh) {
            if (z && b == 2) {
                crossRotateLineFromBottomUnderTouch(ptrFrameLayout);
                View view = this.mRotateView;
                if (view != null) {
                    view.clearAnimation();
                    this.mRotateView.startAnimation(this.mReverseFlipAnimation);
                }
            }
        } else if (d <= offsetToRefresh || f > offsetToRefresh || !z || b != 2) {
        } else {
            crossRotateLineFromTopUnderTouch(ptrFrameLayout);
            View view2 = this.mRotateView;
            if (view2 != null) {
                view2.clearAnimation();
                this.mRotateView.startAnimation(this.mFlipAnimation);
            }
        }
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
        this.mShouldShowLastUpdate = false;
        hideRotateView();
        this.mProgressBar.setVisibility(0);
        this.mTitleTextView.setVisibility(0);
        this.mTitleTextView.setText(R$string.cube_ptr_refreshing);
        tryUpdateLastUpdateTime();
        this.mLastUpdateTimeUpdater.stop();
    }

    public void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
        hideRotateView();
        this.mProgressBar.setVisibility(4);
        this.mTitleTextView.setVisibility(0);
        this.mTitleTextView.setText(getResources().getString(R$string.cube_ptr_refresh_complete));
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(KEY_SharedPreferences, 0);
        if (TextUtils.isEmpty(this.mLastUpdateTimeKey)) {
            return;
        }
        this.mLastUpdateTime = new Date().getTime();
        sharedPreferences.edit().putLong(this.mLastUpdateTimeKey, this.mLastUpdateTime).commit();
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
        this.mShouldShowLastUpdate = true;
        tryUpdateLastUpdateTime();
        this.mLastUpdateTimeUpdater.start();
        this.mProgressBar.setVisibility(4);
        this.mRotateView.setVisibility(0);
        this.mTitleTextView.setVisibility(0);
        if (ptrFrameLayout.isPullToRefresh()) {
            this.mTitleTextView.setText(getResources().getString(R$string.cube_ptr_pull_down_to_refresh));
        } else {
            this.mTitleTextView.setText(getResources().getString(R$string.cube_ptr_pull_down));
        }
    }

    @Override // in.srain.cube.views.ptr.PtrUIHandler
    public void onUIReset(PtrFrameLayout ptrFrameLayout) {
        resetView();
        this.mShouldShowLastUpdate = true;
        tryUpdateLastUpdateTime();
    }

    public void setLastUpdateTimeKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mLastUpdateTimeKey = str;
    }

    public void setLastUpdateTimeRelateObject(Object obj) {
        setLastUpdateTimeKey(obj.getClass().getName());
    }

    public void setRotateAniTime(int i) {
        if (i == this.mRotateAniTime || i == 0) {
            return;
        }
        this.mRotateAniTime = i;
        buildAnimation();
    }

    public PtrClassicDefaultHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRotateAniTime = 150;
        this.mLastUpdateTime = -1L;
        this.mLastUpdateTimeUpdater = new LastUpdateTimeUpdater();
        initViews(attributeSet);
    }

    public PtrClassicDefaultHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRotateAniTime = 150;
        this.mLastUpdateTime = -1L;
        this.mLastUpdateTimeUpdater = new LastUpdateTimeUpdater();
        initViews(attributeSet);
    }
}
