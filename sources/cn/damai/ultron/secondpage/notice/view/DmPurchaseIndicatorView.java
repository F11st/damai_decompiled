package cn.damai.ultron.secondpage.notice.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.secondpage.notice.bean.DmNoticeTitleBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DmPurchaseIndicatorView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DmNoticeTitleBean> mAnchorList;
    private Context mContext;
    private OnAnchorItemClickListener mOnAnchorItemClickListener;
    private Paint mPaint;
    private int mSelectedFontColor;
    private int mSelectedFontSize;
    private int mUnSelectedFontColor;
    private int mUnSelectedFontSize;
    private int paddingBottomBig;
    private int paddingBottomSmall;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public interface OnAnchorItemClickListener {
        void onAnchorItemClick(int i, String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ DmNoticeTitleBean a;

        a(DmNoticeTitleBean dmNoticeTitleBean) {
            this.a = dmNoticeTitleBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2031882398")) {
                ipChange.ipc$dispatch("2031882398", new Object[]{this, view});
            } else if (DmPurchaseIndicatorView.this.mOnAnchorItemClickListener != null) {
                OnAnchorItemClickListener onAnchorItemClickListener = DmPurchaseIndicatorView.this.mOnAnchorItemClickListener;
                DmNoticeTitleBean dmNoticeTitleBean = this.a;
                onAnchorItemClickListener.onAnchorItemClick(dmNoticeTitleBean.index, dmNoticeTitleBean.name);
            }
        }
    }

    public DmPurchaseIndicatorView(Context context) {
        super(context);
        this.mSelectedFontSize = 20;
        this.mUnSelectedFontSize = 16;
        this.mPaint = new Paint();
        this.mContext = context;
        initView();
    }

    private void commit() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "708399817")) {
            ipChange.ipc$dispatch("708399817", new Object[]{this});
            return;
        }
        removeAllViews();
        int e = wh2.e(this.mAnchorList);
        for (int i = 0; i < e; i++) {
            DmNoticeTitleBean dmNoticeTitleBean = this.mAnchorList.get(i);
            if (dmNoticeTitleBean != null) {
                View inflate = LayoutInflater.from(this.mContext).inflate(R$layout.dm_purchase_indicator_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R$id.tv_name);
                textView.setText(dmNoticeTitleBean.name);
                textView.setTextColor(this.mUnSelectedFontColor);
                textView.setTextSize(1, this.mUnSelectedFontSize);
                inflate.setOnClickListener(new a(dmNoticeTitleBean));
                addView(inflate);
            }
        }
    }

    private int dip2px(float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1436651998") ? ((Integer) ipChange.ipc$dispatch("-1436651998", new Object[]{this, Float.valueOf(f)})).intValue() : (int) ((f * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1812220757")) {
            ipChange.ipc$dispatch("-1812220757", new Object[]{this});
            return;
        }
        this.paddingBottomBig = t60.a(this.mContext, 3.0f);
        this.paddingBottomSmall = t60.a(this.mContext, 6.0f);
        setWillNotDraw(false);
        setOrientation(0);
        setGravity(80);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPaint.setAntiAlias(true);
    }

    public DmPurchaseIndicatorView setAnchorFonSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1084854601")) {
            return (DmPurchaseIndicatorView) ipChange.ipc$dispatch("1084854601", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mSelectedFontSize = i;
        this.mUnSelectedFontSize = i2;
        return this;
    }

    public DmPurchaseIndicatorView setAnchorFontColor(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1524840265")) {
            return (DmPurchaseIndicatorView) ipChange.ipc$dispatch("-1524840265", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.mSelectedFontColor = i;
        this.mUnSelectedFontColor = i2;
        return this;
    }

    public DmPurchaseIndicatorView setAnchorList(List<DmNoticeTitleBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2030572460")) {
            return (DmPurchaseIndicatorView) ipChange.ipc$dispatch("-2030572460", new Object[]{this, list});
        }
        this.mAnchorList = list;
        commit();
        setPadding(dip2px(9.0f), 0, dip2px(9.0f), 0);
        return this;
    }

    public DmPurchaseIndicatorView setOnAnchorItemClickListener(OnAnchorItemClickListener onAnchorItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "277668506")) {
            return (DmPurchaseIndicatorView) ipChange.ipc$dispatch("277668506", new Object[]{this, onAnchorItemClickListener});
        }
        this.mOnAnchorItemClickListener = onAnchorItemClickListener;
        return this;
    }

    public void setSelectAnchor(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-773226708")) {
            ipChange.ipc$dispatch("-773226708", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        int e = wh2.e(this.mAnchorList);
        if (e == 0) {
            return;
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            LinearLayout linearLayout = (LinearLayout) getChildAt(i2);
            TextView textView = (TextView) linearLayout.findViewById(R$id.tv_name);
            ImageView imageView = (ImageView) linearLayout.findViewById(R$id.iv_line);
            if (i == i2) {
                textView.setTextColor(this.mSelectedFontColor);
                textView.setTextSize(1, this.mSelectedFontSize);
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), this.paddingBottomBig);
                if (e != 1) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(4);
                }
            } else {
                textView.setTextColor(this.mUnSelectedFontColor);
                textView.setTextSize(1, this.mUnSelectedFontSize);
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), this.paddingBottomSmall);
                imageView.setVisibility(4);
            }
        }
    }

    public DmPurchaseIndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSelectedFontSize = 20;
        this.mUnSelectedFontSize = 16;
        this.mPaint = new Paint();
        this.mContext = context;
        initView();
    }
}
