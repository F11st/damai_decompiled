package com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.listener.IExpressionSelectListener;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.widget.PagerExpressionNormal;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ExpressionPanel extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "ExpressionPanel";
    private ExpressionPageAdapter mExpressionAdapter;
    private LinearLayout mExpressionContainer;
    private ImageView mExpressionIndicatorFirst;
    private ImageView mExpressionIndicatorSecond;
    private ImageView mExpressionIndicatorThird;
    private IExpressionSelectListener mExpressionListener;
    private ViewPager mExpresstionViewpager;

    public ExpressionPanel(@NonNull Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1591482031")) {
            ipChange.ipc$dispatch("1591482031", new Object[]{this, context});
            return;
        }
        View.inflate(getContext(), R.layout.dago_pgc_expression, this);
        this.mExpresstionViewpager = (ViewPager) findViewById(R.id.lf_expresstionViewpager);
        this.mExpressionContainer = (LinearLayout) findViewById(R.id.lf_expressionContainer);
        this.mExpressionIndicatorFirst = (ImageView) findViewById(R.id.expression_page_indicator_first);
        this.mExpressionIndicatorSecond = (ImageView) findViewById(R.id.expression_page_indicator_second);
        this.mExpressionIndicatorThird = (ImageView) findViewById(R.id.expression_page_indicator_third);
        this.mExpressionIndicatorFirst.setBackgroundResource(R.drawable.dago_pgc_indicator_black);
        ImageView imageView = this.mExpressionIndicatorSecond;
        int i = R.drawable.dago_pgc_indicator_write;
        imageView.setBackgroundResource(i);
        this.mExpressionIndicatorThird.setBackgroundResource(i);
        this.mExpressionIndicatorThird.setVisibility(ExpressionDict.isNewExpression() ? 0 : 8);
    }

    public void initExpressionView(Context context, IExpressionSelectListener iExpressionSelectListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "950764101")) {
            ipChange.ipc$dispatch("950764101", new Object[]{this, context, iExpressionSelectListener});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "ExpressionPanel initExpressionView");
        this.mExpressionListener = iExpressionSelectListener;
        this.mExpresstionViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.ExpressionPanel.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1215780262")) {
                    ipChange2.ipc$dispatch("1215780262", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1041819717")) {
                    ipChange2.ipc$dispatch("1041819717", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-401544079")) {
                    ipChange2.ipc$dispatch("-401544079", new Object[]{this, Integer.valueOf(i)});
                } else if (i == 0) {
                    ExpressionPanel.this.mExpressionIndicatorFirst.setBackgroundResource(R.drawable.dago_pgc_indicator_black);
                    ImageView imageView = ExpressionPanel.this.mExpressionIndicatorSecond;
                    int i2 = R.drawable.dago_pgc_indicator_write;
                    imageView.setBackgroundResource(i2);
                    ExpressionPanel.this.mExpressionIndicatorThird.setBackgroundResource(i2);
                } else if (1 == i) {
                    ImageView imageView2 = ExpressionPanel.this.mExpressionIndicatorFirst;
                    int i3 = R.drawable.dago_pgc_indicator_write;
                    imageView2.setBackgroundResource(i3);
                    ExpressionPanel.this.mExpressionIndicatorSecond.setBackgroundResource(R.drawable.dago_pgc_indicator_black);
                    ExpressionPanel.this.mExpressionIndicatorThird.setBackgroundResource(i3);
                } else {
                    ImageView imageView3 = ExpressionPanel.this.mExpressionIndicatorFirst;
                    int i4 = R.drawable.dago_pgc_indicator_write;
                    imageView3.setBackgroundResource(i4);
                    ExpressionPanel.this.mExpressionIndicatorSecond.setBackgroundResource(i4);
                    ExpressionPanel.this.mExpressionIndicatorThird.setBackgroundResource(R.drawable.dago_pgc_indicator_black);
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        int maxIcon = ExpressionDict.getMaxIcon() / 23;
        if (ExpressionDict.getMaxIcon() > maxIcon * 23) {
            maxIcon++;
        }
        for (int i = 0; i < maxIcon; i++) {
            PagerExpressionNormal pagerExpressionNormal = (PagerExpressionNormal) View.inflate(context, R.layout.dago_pgc_pager_expression, null);
            if (i == maxIcon - 1) {
                pagerExpressionNormal.init(((i * 3) * 8) - i, ExpressionDict.getMaxIcon(), this.mExpressionListener);
            } else if (i == 0) {
                pagerExpressionNormal.init(0, (((i + 1) * 3) * 8) - 1, this.mExpressionListener);
            } else {
                pagerExpressionNormal.init(((i * 3) * 8) - 1, (((i + 1) * 3) * 8) - 2, this.mExpressionListener);
            }
            arrayList.add(pagerExpressionNormal);
        }
        ExpressionPageAdapter expressionPageAdapter = new ExpressionPageAdapter(arrayList);
        this.mExpressionAdapter = expressionPageAdapter;
        this.mExpresstionViewpager.setAdapter(expressionPageAdapter);
    }

    public ExpressionPanel(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public ExpressionPanel(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }
}
