package com.youku.resource.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;
import com.youku.resource.R;
import com.youku.resource.widget.PlayerGuideTipsView;
import com.youku.resource.widget.PlayerHorizontalGuideTipsView;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TipsPopWindowUtil {
    public static final int POP_LOCATION_CENTER_BOTTOM = 3;
    public static final int POP_LOCATION_CENTER_TOP = 6;
    public static final int POP_LOCATION_LEFT = 7;
    public static final int POP_LOCATION_LEFT_BOTTOM = 4;
    public static final int POP_LOCATION_LEFT_TOP = 5;
    public static final int POP_LOCATION_RIGHT = 8;
    public static final int POP_LOCATION_RIGHT_BOTTOM = 1;
    public static final int POP_LOCATION_RIGHT_TOP = 2;
    private Context mContext;
    private PlayerGuideTipsView mGuideTipsView;
    private ViewGroup mHolderView;
    private PlayerHorizontalGuideTipsView mHorizontalGuideTipsView;
    private int mLocation;
    private PopupWindow mTrianglePopView;

    public TipsPopWindowUtil(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissWithTryCatch() {
        try {
            this.mTrianglePopView.dismiss();
        } catch (IllegalArgumentException | Exception unused) {
        } catch (Throwable th) {
            this.mTrianglePopView = null;
            throw th;
        }
        this.mTrianglePopView = null;
    }

    private int getMeasuredHeight(View view) {
        view.measure(0, 0);
        return view.getMeasuredHeight();
    }

    private int getMeasuredWidth(View view) {
        view.measure(0, 0);
        return view.getMeasuredWidth();
    }

    private void initPopView() {
        this.mHolderView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.resource_yk_window_pop_tips, (ViewGroup) null);
        this.mTrianglePopView = new PopupWindow((View) this.mHolderView, -2, -2, false);
        this.mGuideTipsView = (PlayerGuideTipsView) this.mHolderView.findViewById(R.id.v_guide_tips);
        this.mHorizontalGuideTipsView = (PlayerHorizontalGuideTipsView) this.mHolderView.findViewById(R.id.v_horizontal_guide_tips);
        this.mTrianglePopView.setOutsideTouchable(true);
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(-1);
        colorDrawable.setAlpha(0);
        this.mTrianglePopView.setBackgroundDrawable(colorDrawable);
    }

    public static TipsPopWindowUtil show(View view, int i, String str, int i2, int i3) {
        TipsPopWindowUtil tipsPopWindowUtil = new TipsPopWindowUtil(view.getContext());
        tipsPopWindowUtil.showPopView(view, i, str, i2, i3);
        return tipsPopWindowUtil;
    }

    public void hidePopView() {
        PopupWindow popupWindow = this.mTrianglePopView;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mHolderView.getContext(), R.anim.yk_amin_guide_tips_alpha_hide);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.youku.resource.widget.TipsPopWindowUtil.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TipsPopWindowUtil.this.dismissWithTryCatch();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.mHolderView.startAnimation(loadAnimation);
    }

    public void setOnClickDismiss() {
        ViewGroup viewGroup = this.mHolderView;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.youku.resource.widget.TipsPopWindowUtil.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TipsPopWindowUtil.this.hidePopView();
                }
            });
        }
    }

    public void showPopView(View view, int i, String str) {
        showPopView(view, i, str, 0, 0, 0, 0);
    }

    public void showPopView(View view, int i, String str, int i2, int i3) {
        showPopView(view, i, str, i2, i3, 0, 0);
    }

    public static TipsPopWindowUtil show(View view, int i, String str) {
        TipsPopWindowUtil tipsPopWindowUtil = new TipsPopWindowUtil(view.getContext());
        tipsPopWindowUtil.showPopView(view, i, str, 0, 0);
        return tipsPopWindowUtil;
    }

    public void showPopView(View view, int i, String str, int i2, int i3, int i4, int i5) {
        if (this.mTrianglePopView == null) {
            initPopView();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.mLocation = i;
        switch (i) {
            case 1:
                this.mHorizontalGuideTipsView.setVisibility(8);
                this.mGuideTipsView.setVisibility(4);
                this.mGuideTipsView.setTipsType(PlayerGuideTipsView.GuideTipsType.BOTTOM_RIGHT);
                this.mGuideTipsView.setTipsText(str);
                if (i2 == 0) {
                    i2 = (iArr[0] + (view.getMeasuredWidth() / 2)) - this.mGuideTipsView.getBottomTriangleHorizon2Edge();
                }
                if (i3 == 0) {
                    i3 = (iArr[1] + view.getHeight()) - this.mGuideTipsView.getTriangleTopEdge();
                }
                this.mGuideTipsView.show();
                this.mTrianglePopView.showAtLocation(view, 51, i2 + i4, i3 + i5);
                break;
            case 2:
                this.mHorizontalGuideTipsView.setVisibility(8);
                this.mGuideTipsView.setVisibility(4);
                this.mGuideTipsView.setTipsType(PlayerGuideTipsView.GuideTipsType.TOP_RIGHT);
                this.mGuideTipsView.setTipsText(str);
                if (i2 == 0) {
                    i2 = (iArr[0] + (view.getMeasuredWidth() / 2)) - this.mGuideTipsView.getTopTriangleHorizontal2Edge();
                }
                if (i3 == 0) {
                    i3 = (iArr[1] - getMeasuredHeight(this.mGuideTipsView)) + this.mGuideTipsView.getTriangleBottomEdge();
                }
                this.mTrianglePopView.showAtLocation(view, 51, i2 + i4, i3 + i5);
                this.mGuideTipsView.show();
                break;
            case 3:
                this.mHorizontalGuideTipsView.setVisibility(8);
                this.mGuideTipsView.setVisibility(4);
                this.mGuideTipsView.setTipsType(PlayerGuideTipsView.GuideTipsType.BOTTOM_CENTER);
                this.mGuideTipsView.setTipsText(str);
                if (i2 == 0) {
                    i2 = (iArr[0] + (view.getMeasuredWidth() / 2)) - (getMeasuredWidth(this.mGuideTipsView) / 2);
                }
                if (i3 == 0) {
                    i3 = (iArr[1] + view.getHeight()) - this.mGuideTipsView.getTriangleTopEdge();
                }
                this.mGuideTipsView.show();
                this.mTrianglePopView.showAtLocation(view, 51, i2 + i4, i3 + i5);
                break;
            case 4:
                this.mHorizontalGuideTipsView.setVisibility(8);
                this.mGuideTipsView.setVisibility(4);
                this.mGuideTipsView.setTipsType(PlayerGuideTipsView.GuideTipsType.BOTTOM_LEFT);
                this.mGuideTipsView.setTipsText(str);
                if (i2 == 0) {
                    i2 = ((iArr[0] + (view.getMeasuredWidth() / 2)) + this.mGuideTipsView.getBottomTriangleHorizon2Edge()) - getMeasuredWidth(this.mGuideTipsView);
                }
                if (i3 == 0) {
                    i3 = (iArr[1] + view.getMeasuredHeight()) - this.mGuideTipsView.getTriangleTopEdge();
                }
                this.mGuideTipsView.show();
                this.mTrianglePopView.showAtLocation(view, 51, i2 + i4, i3 + i5);
                break;
            case 5:
                this.mHorizontalGuideTipsView.setVisibility(8);
                this.mGuideTipsView.setVisibility(4);
                this.mGuideTipsView.setTipsType(PlayerGuideTipsView.GuideTipsType.TOP_LEFT);
                this.mGuideTipsView.setTipsText(str);
                if (i2 == 0) {
                    i2 = ((iArr[0] + (view.getMeasuredWidth() / 2)) + this.mGuideTipsView.getTopTriangleHorizontal2Edge()) - getMeasuredWidth(this.mGuideTipsView);
                }
                if (i3 == 0) {
                    i3 = (iArr[1] - getMeasuredHeight(this.mGuideTipsView)) + this.mGuideTipsView.getTriangleBottomEdge();
                }
                this.mGuideTipsView.show();
                this.mTrianglePopView.showAtLocation(view, 51, i2 + i4, i3 + i5);
                break;
            case 6:
                this.mHorizontalGuideTipsView.setVisibility(8);
                this.mGuideTipsView.setVisibility(4);
                this.mGuideTipsView.setTipsType(PlayerGuideTipsView.GuideTipsType.TOP_CENTER);
                this.mGuideTipsView.setTipsText(str);
                if (i2 == 0) {
                    i2 = (iArr[0] + (view.getMeasuredWidth() / 2)) - (getMeasuredWidth(this.mGuideTipsView) / 2);
                }
                if (i3 == 0) {
                    i3 = (iArr[1] - getMeasuredHeight(this.mGuideTipsView)) + this.mGuideTipsView.getTriangleBottomEdge();
                }
                this.mGuideTipsView.show();
                this.mTrianglePopView.showAtLocation(view, 51, i2 + i4, i3 + i5);
                break;
            case 7:
                this.mHorizontalGuideTipsView.setVisibility(4);
                this.mGuideTipsView.setVisibility(8);
                this.mHorizontalGuideTipsView.setTipsType(PlayerHorizontalGuideTipsView.HorizontalGuideTipsType.LEFT);
                this.mHorizontalGuideTipsView.setTipsText(str);
                if (i2 == 0) {
                    i2 = iArr[0] - getMeasuredWidth(this.mHorizontalGuideTipsView);
                }
                if (i3 == 0) {
                    i3 = (iArr[1] + (view.getHeight() / 2)) - (getMeasuredHeight(this.mHorizontalGuideTipsView) / 2);
                }
                this.mHorizontalGuideTipsView.show();
                this.mTrianglePopView.showAtLocation(view, 51, i2 + i4, i3 + i5);
                break;
            case 8:
                this.mHorizontalGuideTipsView.setVisibility(4);
                this.mGuideTipsView.setVisibility(8);
                this.mHorizontalGuideTipsView.setTipsType(PlayerHorizontalGuideTipsView.HorizontalGuideTipsType.RIGHT);
                this.mHorizontalGuideTipsView.setTipsText(str);
                if (i2 == 0) {
                    i2 = iArr[0] + view.getMeasuredWidth();
                }
                if (i3 == 0) {
                    i3 = (iArr[1] + (view.getHeight() / 2)) - (getMeasuredHeight(this.mHorizontalGuideTipsView) / 2);
                }
                this.mHorizontalGuideTipsView.show();
                this.mTrianglePopView.showAtLocation(view, 51, i2 + i4, i3 + i5);
                break;
        }
        setOnClickDismiss();
    }
}
