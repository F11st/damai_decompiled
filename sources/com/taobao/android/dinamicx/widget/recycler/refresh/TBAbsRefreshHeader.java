package com.taobao.android.dinamicx.widget.recycler.refresh;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.widget.recycler.refresh.TBSwipeRefreshLayout;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class TBAbsRefreshHeader extends RelativeLayout {
    protected TBSwipeRefreshLayout.OnPullRefreshListener mPullRefreshListener;
    protected RefreshState mState;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum RefreshHeaderStyle {
        NORMAL,
        DARK
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum RefreshState {
        NONE,
        PULL_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING,
        PREPARE_TO_SECOND_FLOOR,
        SECOND_FLOOR_START,
        SECOND_FLOOR_END;

        @Override // java.lang.Enum
        public String toString() {
            switch (C6518a.a[ordinal()]) {
                case 1:
                    return "NONE";
                case 2:
                    return "PULL_TO_REFRESH";
                case 3:
                    return "RELEASE_TO_REFRESH";
                case 4:
                    return "REFRESHING";
                case 5:
                    return "PREPARE_TO_SECOND_FLOOR";
                case 6:
                    return "SECOND_FLOOR_START";
                case 7:
                    return "SECOND_FLOOR_END";
                default:
                    return "";
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.refresh.TBAbsRefreshHeader$a */
    /* loaded from: classes12.dex */
    static /* synthetic */ class C6518a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            try {
                iArr[RefreshState.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RefreshState.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RefreshState.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RefreshState.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RefreshState.PREPARE_TO_SECOND_FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RefreshState.SECOND_FLOOR_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RefreshState.SECOND_FLOOR_END.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public TBAbsRefreshHeader(Context context) {
        super(context);
        this.mState = RefreshState.NONE;
    }

    public abstract void changeToState(RefreshState refreshState);

    public RefreshState getCurrentState() {
        return this.mState;
    }

    public abstract View getRefreshView();

    public abstract View getSecondFloorView();

    public abstract void setProgress(float f);

    public void setPullRefreshListener(TBSwipeRefreshLayout.OnPullRefreshListener onPullRefreshListener) {
        this.mPullRefreshListener = onPullRefreshListener;
    }

    public abstract void setRefreshAnimation(String[] strArr, @Nullable String str);

    public abstract void setRefreshTipColor(@ColorInt int i);

    public abstract void setRefreshTips(String[] strArr);

    public abstract void setSecondFloorView(View view);

    public void switchStyle(RefreshHeaderStyle refreshHeaderStyle) {
    }
}
