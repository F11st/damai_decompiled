package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.AnchorLevelCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.BaseCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.ButtonCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.DagoCell;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.FaceCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.GiftCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.ImageCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.MedalCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.TextCellItem;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.model.UserLevelCellItem;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import de.greenrobot.event.EventBus;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class ChatItemView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "ChatItemView";
    final SpannableStringBuilder mBuilder;
    private DrawCellItemUtils.DeleteTextSpanCallBack mCallBack;
    private TextView mContextTextView;
    private int mFontSize;
    private OnCellClickListener onItemViewClick;

    public ChatItemView(Context context) {
        super(context);
        this.mFontSize = 14;
        this.mBuilder = new SpannableStringBuilder();
        this.mCallBack = new DrawCellItemUtils.DeleteTextSpanCallBack() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.ChatItemView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils.DeleteTextSpanCallBack
            public void removeText(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1482743971")) {
                    ipChange.ipc$dispatch("1482743971", new Object[]{this, str});
                    return;
                }
                try {
                    int lastIndexOf = ChatItemView.this.mContextTextView.getText().toString().lastIndexOf(str);
                    ChatItemView.this.mBuilder.delete(lastIndexOf, str.length() + lastIndexOf);
                    ChatItemView.this.mContextTextView.setText(ChatItemView.this.mBuilder);
                } catch (Exception unused) {
                }
            }
        };
        initView(context);
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1818046528")) {
            ipChange.ipc$dispatch("-1818046528", new Object[]{this, context});
            return;
        }
        setLayoutParams(new AbsListView.LayoutParams(-2, -2));
        TextView textView = new TextView(context);
        this.mContextTextView = textView;
        textView.setIncludeFontPadding(false);
        addView(this.mContextTextView);
    }

    public void drawCell(DagoCell dagoCell, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1225223447")) {
            ipChange.ipc$dispatch("1225223447", new Object[]{this, dagoCell, str});
        } else if (dagoCell != null && !dagoCell.cell.isEmpty()) {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "drawCell: " + dagoCell.cell.size());
            int i = dagoCell.fontSize;
            if (i <= 0) {
                i = 14;
            }
            this.mFontSize = i;
            for (BaseCellItem baseCellItem : dagoCell.cell) {
                if (baseCellItem instanceof TextCellItem) {
                    this.mBuilder.append(DrawCellItemUtils.drawTextCellItem((TextCellItem) baseCellItem, this.onItemViewClick));
                } else if (baseCellItem instanceof ImageCellItem) {
                    this.mBuilder.append(DrawCellItemUtils.drawImageCellItem(this.mContextTextView, (ImageCellItem) baseCellItem, this.onItemViewClick));
                } else if (baseCellItem instanceof FaceCellItem) {
                    this.mBuilder.append(DrawCellItemUtils.drawFaceCellItem((FaceCellItem) baseCellItem));
                } else if (baseCellItem instanceof GiftCellItem) {
                    this.mBuilder.append(DrawCellItemUtils.drawGiftCellItem(this.mContextTextView, (GiftCellItem) baseCellItem));
                } else if (baseCellItem instanceof MedalCellItem) {
                    this.mBuilder.append(DrawCellItemUtils.drawMedalCellItem(this.mContextTextView, (MedalCellItem) baseCellItem, str));
                } else if (baseCellItem instanceof AnchorLevelCellItem) {
                    this.mBuilder.append(DrawCellItemUtils.drawAnchorLevelCellItem((AnchorLevelCellItem) baseCellItem));
                } else if (baseCellItem instanceof UserLevelCellItem) {
                    this.mBuilder.append(DrawCellItemUtils.drawUserLevelCellItem((UserLevelCellItem) baseCellItem));
                } else if (baseCellItem instanceof ButtonCellItem) {
                    this.mBuilder.append(DrawCellItemUtils.drawButtonCellItem((ButtonCellItem) baseCellItem, this.onItemViewClick, this.mCallBack));
                }
            }
            this.mContextTextView.setIncludeFontPadding(false);
            this.mContextTextView.setGravity(16);
            this.mContextTextView.setPadding(0, UIUtil.dip2px(2), 0, UIUtil.dip2px(2));
            this.mContextTextView.setLineSpacing(0.0f, 1.2f);
            this.mContextTextView.setHighlightColor(0);
            this.mContextTextView.setMovementMethod(LinkMovementMethod.getInstance());
            this.mContextTextView.setTextSize(this.mFontSize);
            this.mContextTextView.setText(this.mBuilder);
            this.mBuilder.clear();
            GradientDrawable gradientDrawable = new GradientDrawable();
            if (!TextUtils.isEmpty(dagoCell.bgColor)) {
                gradientDrawable.setColor(Color.parseColor(dagoCell.bgColor));
            }
            if (!TextUtils.isEmpty(dagoCell.bgColor) && !TextUtils.isEmpty(dagoCell.nBgColor) && !"#FFFFFFFF".equals(dagoCell.nBgColor)) {
                gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor(dagoCell.nBgColor), Color.parseColor(dagoCell.bgColor)});
            }
            int i2 = dagoCell.borderWidth;
            if (i2 > 0) {
                gradientDrawable.setStroke(i2, Color.parseColor(dagoCell.borderColor));
            }
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(UIUtil.dip2px(13));
            setBackground(gradientDrawable);
            setPadding(UIUtil.dip2px(9), UIUtil.dip2px(6), UIUtil.dip2px(9), UIUtil.dip2px(6));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1727113106")) {
            ipChange.ipc$dispatch("1727113106", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        if (EventBus.b().g(this)) {
            EventBus.b().p(this);
        }
    }

    public void setFontSize(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1549724200")) {
            ipChange.ipc$dispatch("1549724200", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.mFontSize = i;
        }
    }

    public void setOnItemViewClick(OnCellClickListener onCellClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2034425010")) {
            ipChange.ipc$dispatch("2034425010", new Object[]{this, onCellClickListener});
        } else {
            this.onItemViewClick = onCellClickListener;
        }
    }

    public ChatItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFontSize = 14;
        this.mBuilder = new SpannableStringBuilder();
        this.mCallBack = new DrawCellItemUtils.DeleteTextSpanCallBack() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.ChatItemView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils.DeleteTextSpanCallBack
            public void removeText(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1482743971")) {
                    ipChange.ipc$dispatch("1482743971", new Object[]{this, str});
                    return;
                }
                try {
                    int lastIndexOf = ChatItemView.this.mContextTextView.getText().toString().lastIndexOf(str);
                    ChatItemView.this.mBuilder.delete(lastIndexOf, str.length() + lastIndexOf);
                    ChatItemView.this.mContextTextView.setText(ChatItemView.this.mBuilder);
                } catch (Exception unused) {
                }
            }
        };
        initView(context);
    }

    public ChatItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFontSize = 14;
        this.mBuilder = new SpannableStringBuilder();
        this.mCallBack = new DrawCellItemUtils.DeleteTextSpanCallBack() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.ChatItemView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.dago.DrawCellItemUtils.DeleteTextSpanCallBack
            public void removeText(String str) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1482743971")) {
                    ipChange.ipc$dispatch("1482743971", new Object[]{this, str});
                    return;
                }
                try {
                    int lastIndexOf = ChatItemView.this.mContextTextView.getText().toString().lastIndexOf(str);
                    ChatItemView.this.mBuilder.delete(lastIndexOf, str.length() + lastIndexOf);
                    ChatItemView.this.mContextTextView.setText(ChatItemView.this.mBuilder);
                } catch (Exception unused) {
                }
            }
        };
        initView(context);
        if (EventBus.b().g(this)) {
            return;
        }
        EventBus.b().m(this);
    }
}
