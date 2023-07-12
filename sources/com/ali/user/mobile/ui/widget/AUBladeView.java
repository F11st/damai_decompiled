package com.ali.user.mobile.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.ui.R;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AUBladeView extends View {
    private String[] b;
    private int choose;
    Runnable dismissRunnable;
    private Handler handler;
    private OnItemClickListener mOnItemClickListener;
    private TextView mPopupText;
    private PopupWindow mPopupWindow;
    private Paint paint;
    private boolean showBkg;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnItemClickListener {
        void onItemClick(String str);
    }

    public AUBladeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new String[]{"★", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, UTConstant.Args.UT_SUCCESS_F, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", "V", ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
        this.choose = -1;
        this.paint = new Paint();
        this.showBkg = false;
        this.handler = new Handler();
        this.dismissRunnable = new Runnable() { // from class: com.ali.user.mobile.ui.widget.AUBladeView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AUBladeView.this.mPopupWindow != null) {
                    try {
                        AUBladeView.this.mPopupWindow.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        initPop(context);
    }

    private void dismissPopup() {
        this.handler.postDelayed(this.dismissRunnable, 800L);
    }

    private void initPop(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.aliuser_letter_popupwindow, (ViewGroup) null);
        this.mPopupWindow = new PopupWindow(inflate, -2, -2);
        this.mPopupText = (TextView) inflate.findViewById(R.id.letterText);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.setOutsideTouchable(true);
    }

    private void performItemClicked(int i) {
        OnItemClickListener onItemClickListener = this.mOnItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(this.b[i]);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        int i = this.choose;
        int height = getHeight();
        String[] strArr = this.b;
        int length = (int) ((y / ((height / strArr.length) * strArr.length)) * strArr.length);
        if (length >= 0 && length < strArr.length) {
            this.mPopupWindow.showAtLocation(this, 17, 0, 0);
            this.mPopupText.setText(this.b[length]);
        }
        if (action == 0) {
            this.showBkg = true;
            if (i != length && length >= 0 && length < this.b.length) {
                performItemClicked(length);
                this.choose = length;
                invalidate();
            }
        } else if (action != 1) {
            if (action == 2 && i != length && length >= 0 && length < this.b.length) {
                performItemClicked(length);
                this.choose = length;
                invalidate();
            }
        } else {
            this.showBkg = false;
            this.choose = -1;
            dismissPopup();
            invalidate();
        }
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.showBkg) {
            canvas.drawColor(Color.parseColor("#00000000"));
        }
        int height = getHeight();
        int width = getWidth();
        int length = height / this.b.length;
        for (int i = 0; i < this.b.length; i++) {
            this.paint.setColor(Color.parseColor("#999999"));
            this.paint.setAntiAlias(true);
            if (height < 400) {
                this.paint.setTextSize(getResources().getDimension(R.dimen.aliuser_letters_item_little_fontsize));
            } else {
                this.paint.setTextSize(getResources().getDimension(R.dimen.aliuser_textsize_smallest));
            }
            if (i == this.choose) {
                this.paint.setColor(getResources().getColor(R.color.aliuser_region_chosen_color));
            }
            canvas.drawText(this.b[i], (width / 2) - (this.paint.measureText(this.b[i]) / 2.0f), (length * i) + length, this.paint);
            this.paint.reset();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public AUBladeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new String[]{"★", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, UTConstant.Args.UT_SUCCESS_F, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", "V", ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
        this.choose = -1;
        this.paint = new Paint();
        this.showBkg = false;
        this.handler = new Handler();
        this.dismissRunnable = new Runnable() { // from class: com.ali.user.mobile.ui.widget.AUBladeView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AUBladeView.this.mPopupWindow != null) {
                    try {
                        AUBladeView.this.mPopupWindow.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        initPop(context);
    }

    public AUBladeView(Context context) {
        super(context);
        this.b = new String[]{"★", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, UTConstant.Args.UT_SUCCESS_F, "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", "V", ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
        this.choose = -1;
        this.paint = new Paint();
        this.showBkg = false;
        this.handler = new Handler();
        this.dismissRunnable = new Runnable() { // from class: com.ali.user.mobile.ui.widget.AUBladeView.1
            @Override // java.lang.Runnable
            public void run() {
                if (AUBladeView.this.mPopupWindow != null) {
                    try {
                        AUBladeView.this.mPopupWindow.dismiss();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        initPop(context);
    }
}
