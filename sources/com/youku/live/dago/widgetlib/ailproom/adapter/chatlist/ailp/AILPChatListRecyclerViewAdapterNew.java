package com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.LeadingMarginSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.image.DagoImageLoader;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.adapter.YellInfoBean;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.BaseChatListRecyclerViewAdapter;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.span.ImageBean;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.span.YTImageSpan;
import com.youku.live.dago.widgetlib.ailproom.manager.BaseInfoBean;
import com.youku.live.dago.widgetlib.ailproom.manager.ChatResourceManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;
import tb.jn1;
import tb.ur1;
import tb.wr1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPChatListRecyclerViewAdapterNew extends BaseChatListRecyclerViewAdapter<AILPChatBean, ViewHolder> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static int USER_FLAG_MARGIN = 5;
    private static int USER_FLAG_SIZE = 12;
    private static int USER_NAME_SIZE = 14;
    private static int USER_TEXT_SIZE = 14;
    private Context mContext;
    private Map<String, Object> mShareMap;
    private SpannableStringBuilder shareString;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class ChatListClickSpan extends ClickableSpan {
        private static transient /* synthetic */ IpChange $ipChange;

        ChatListClickSpan() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-247648058")) {
                ipChange.ipc$dispatch("-247648058", new Object[]{this, view});
            } else {
                AILPChatListRecyclerViewAdapterNew.this.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "146205361")) {
                ipChange.ipc$dispatch("146205361", new Object[]{this, textPaint});
                return;
            }
            super.updateDrawState(textPaint);
            textPaint.setColor(Color.parseColor("#53B8FE"));
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class TextRoundSpan implements LeadingMarginSpan.LeadingMarginSpan2 {
        private static transient /* synthetic */ IpChange $ipChange;
        private boolean hasIcon;
        private int lines;
        private int margin;

        TextRoundSpan(int i, int i2, boolean z) {
            this.margin = i;
            this.lines = i2;
            this.hasIcon = z;
        }

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1655851300")) {
                ipChange.ipc$dispatch("1655851300", new Object[]{this, canvas, paint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Boolean.valueOf(z), layout});
            }
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "380791169")) {
                return ((Integer) ipChange.ipc$dispatch("380791169", new Object[]{this, Boolean.valueOf(z)})).intValue();
            }
            if (this.hasIcon) {
                if (z) {
                    return this.margin;
                }
                return 0;
            }
            return this.margin;
        }

        @Override // android.text.style.LeadingMarginSpan.LeadingMarginSpan2
        public int getLeadingMarginLineCount() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-670329668") ? ((Integer) ipChange.ipc$dispatch("-670329668", new Object[]{this})).intValue() : this.lines;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout itemLayout;
        public TextView mUserComment;
        public ImageView mUserIcon;
        public ImageView mUserVipIcon;
        public ImageView mUserYellImage;
        private TextRoundSpan noHeadSpan;
        private TextRoundSpan span;

        public ViewHolder(View view) {
            super(view);
            this.mUserIcon = (ImageView) view.findViewById(R.id.iv_user_icon);
            this.mUserVipIcon = (ImageView) view.findViewById(R.id.iv_user_vip_icon);
            this.mUserYellImage = (ImageView) view.findViewById(R.id.iv_yell_image);
            this.mUserComment = (TextView) view.findViewById(R.id.content_text);
            this.itemLayout = (RelativeLayout) view.findViewById(R.id.ailp_new_chat_item_bg);
        }

        private int dp2px(Context context, int i) {
            return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
        }

        private CharSequence getNoHeadRoundSpan(CharSequence charSequence) {
            if (this.noHeadSpan == null) {
                createSpan();
            }
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(this.noHeadSpan, 0, charSequence.length(), 17);
            return spannableString;
        }

        private CharSequence getTextColorAndSizeSpan(CharSequence charSequence, int i, int i2) {
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i);
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(foregroundColorSpan, 0, charSequence.length(), 17);
            spannableString.setSpan(new AbsoluteSizeSpan(i2, true), 0, charSequence.length(), 17);
            return spannableString;
        }

        private CharSequence getTextRoundSpan(CharSequence charSequence) {
            if (this.span == null) {
                createSpan();
            }
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(this.span, 0, charSequence.length(), 17);
            return spannableString;
        }

        private boolean setFlagSpan(Context context, float f, SpannableStringBuilder spannableStringBuilder, List<ImageBean> list) {
            boolean z = false;
            if (list != null && list.size() != 0) {
                for (ImageBean imageBean : list) {
                    if (imageBean != null && !TextUtils.isEmpty(imageBean.src)) {
                        float f2 = imageBean.width;
                        if (f2 != 0.0f) {
                            float f3 = imageBean.height;
                            if (f3 != 0.0f) {
                                imageBean.setWidth((f2 * f) / f3).setHeight(f).setSrc(imageBean.src).setAlignment(imageBean.alignment);
                                YTImageSpan yTImageSpan = new YTImageSpan(YTImageSpan.getDrawable(Integer.valueOf((int) (imageBean.width + 0.5f + dp2px(context, AILPChatListRecyclerViewAdapterNew.USER_FLAG_MARGIN))), Integer.valueOf((int) (imageBean.height + 0.5f))), imageBean, this.mUserComment);
                                yTImageSpan.into(spannableStringBuilder);
                                yTImageSpan.format(spannableStringBuilder);
                                yTImageSpan.fetch(context);
                                z = true;
                            }
                        }
                    }
                }
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setText(AILPChatBean aILPChatBean, int i) {
            ViewGroup.LayoutParams layoutParams;
            if (aILPChatBean == null) {
                return;
            }
            if (aILPChatBean.getLineNum() != 0) {
                this.mUserComment.setMaxLines(aILPChatBean.getLineNum());
                this.mUserComment.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                this.mUserComment.setMaxLines(Integer.MAX_VALUE);
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Log.d("liulei", "source = " + aILPChatBean.getSource());
            if ("attention".equals(aILPChatBean.getSource())) {
                spannableStringBuilder.append(getTextColorAndSizeSpan("感谢 ", aILPChatBean.getTextColor(), AILPChatListRecyclerViewAdapterNew.USER_TEXT_SIZE));
                spannableStringBuilder.append(getTextColorAndSizeSpan(aILPChatBean.getName(), aILPChatBean.getNameColor(), AILPChatListRecyclerViewAdapterNew.USER_TEXT_SIZE));
                spannableStringBuilder.append(getTextColorAndSizeSpan(" 关注主播，喜欢主播 ", aILPChatBean.getTextColor(), AILPChatListRecyclerViewAdapterNew.USER_TEXT_SIZE));
                spannableStringBuilder.append(getTextColorAndSizeSpan("快去关注", Color.parseColor("#53B8FE"), AILPChatListRecyclerViewAdapterNew.USER_TEXT_SIZE));
                spannableStringBuilder.append(getTextColorAndSizeSpan(" 吧", aILPChatBean.getTextColor(), AILPChatListRecyclerViewAdapterNew.USER_TEXT_SIZE));
                int indexOf = spannableStringBuilder.toString().indexOf(" 快去关注 ");
                this.mUserComment.setTag(3);
                spannableStringBuilder.setSpan(new ChatListClickSpan(), indexOf, indexOf + 6, 33);
                this.mUserComment.setHighlightColor(0);
                this.mUserComment.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                spannableStringBuilder.clear();
                setFlagSpan(this.mUserComment.getContext(), dp2px(this.mUserComment.getContext(), AILPChatListRecyclerViewAdapterNew.USER_FLAG_SIZE), spannableStringBuilder, aILPChatBean.getBn());
                spannableStringBuilder.append(getTextColorAndSizeSpan(aILPChatBean.getName(), aILPChatBean.getNameColor(), AILPChatListRecyclerViewAdapterNew.USER_NAME_SIZE));
                setFlagSpan(this.mUserComment.getContext(), dp2px(this.mUserComment.getContext(), AILPChatListRecyclerViewAdapterNew.USER_FLAG_SIZE), spannableStringBuilder, aILPChatBean.getAn());
                YellInfoBean yellBean = AILPChatListRecyclerViewAdapterNew.this.getYellBean(aILPChatBean.getData());
                if (yellBean != null && !TextUtils.isEmpty(yellBean.url) && !ChatResourceManager.getInstance().isOrangeDowngradeGif()) {
                    spannableStringBuilder.append(AltriaXLaunchTime.SPACE);
                    wr1 s = ur1.o().s(yellBean.url);
                    int i2 = R.C7941drawable.dago_pgc_chat_expression_default_bg;
                    s.H(i2).k(i2).y(this.mUserYellImage);
                    if (yellBean.w != 0 && yellBean.h != 0 && (layoutParams = this.mUserYellImage.getLayoutParams()) != null) {
                        layoutParams.height = dp2px(AILPChatListRecyclerViewAdapterNew.this.mContext, yellBean.h);
                        layoutParams.width = dp2px(AILPChatListRecyclerViewAdapterNew.this.mContext, yellBean.w);
                    }
                    this.mUserYellImage.setVisibility(0);
                } else {
                    this.mUserYellImage.setVisibility(8);
                    if (i == 1) {
                        this.mUserComment.setTag(1);
                        if (!TextUtils.isEmpty(aILPChatBean.getName())) {
                            spannableStringBuilder.append(" ");
                        }
                        if (!TextUtils.isEmpty(aILPChatBean.getConcatUserAndAnchor())) {
                            spannableStringBuilder.append(getTextColorAndSizeSpan(aILPChatBean.getConcatUserAndAnchor(), aILPChatBean.getConcatColor(), AILPChatListRecyclerViewAdapterNew.USER_TEXT_SIZE));
                        }
                        if (!TextUtils.isEmpty(aILPChatBean.getAnchorName())) {
                            spannableStringBuilder.append(" ");
                            spannableStringBuilder.append(getTextColorAndSizeSpan(aILPChatBean.getAnchorName(), aILPChatBean.getAnchorNameColor(), AILPChatListRecyclerViewAdapterNew.USER_TEXT_SIZE));
                        }
                        if (spannableStringBuilder.length() != 0) {
                            spannableStringBuilder.append(" ");
                        }
                        spannableStringBuilder.append(getTextColorAndSizeSpan(aILPChatBean.getData(), aILPChatBean.getTextColor(), AILPChatListRecyclerViewAdapterNew.USER_TEXT_SIZE));
                    } else if (i == 2) {
                        AILPChatListRecyclerViewAdapterNew.this.shareString.setSpan(new ForegroundColorSpan(aILPChatBean.getTextColor()), 0, 12, 33);
                        this.mUserComment.setTag(2);
                        spannableStringBuilder.append((CharSequence) AILPChatListRecyclerViewAdapterNew.this.shareString);
                        this.mUserComment.setOnClickListener(AILPChatListRecyclerViewAdapterNew.this);
                    }
                }
            }
            this.mUserComment.setText(spannableStringBuilder);
            if (TextUtils.isEmpty(aILPChatBean.getFace())) {
                TextView textView = this.mUserComment;
                textView.setText(getNoHeadRoundSpan(textView.getText()));
                return;
            }
            TextView textView2 = this.mUserComment;
            textView2.setText(getTextRoundSpan(textView2.getText()));
        }

        public void createSpan() {
            Resources resources = this.mUserComment.getContext().getResources();
            int i = R.dimen.dago_pgc_chat_list_new_user_pic_size;
            int dimensionPixelOffset = resources.getDimensionPixelOffset(i);
            int dimensionPixelOffset2 = this.mUserComment.getContext().getResources().getDimensionPixelOffset(i);
            int fontSpacing = (int) (dimensionPixelOffset / this.mUserComment.getPaint().getFontSpacing());
            this.span = new TextRoundSpan(dimensionPixelOffset2 + dp2px(this.mUserComment.getContext(), 5), fontSpacing, true);
            this.noHeadSpan = new TextRoundSpan(dp2px(this.mUserComment.getContext(), 5), fontSpacing, false);
        }
    }

    public AILPChatListRecyclerViewAdapterNew(Context context) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("分享了直播，邀好友来围观 立即分享，戳这里   ");
        this.shareString = spannableStringBuilder;
        spannableStringBuilder.setSpan(new ForegroundColorSpan(-8667649), 12, 22, 33);
        this.shareString.setSpan(new ImageSpan(context, R.C7941drawable.dago_pgc_ailp_live_share), 22, 23, 33);
        HashMap hashMap = new HashMap(2);
        this.mShareMap = hashMap;
        hashMap.put("ilpType", "share");
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public YellInfoBean getYellBean(String str) {
        BaseInfoBean yellSource;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1089891024")) {
            return (YellInfoBean) ipChange.ipc$dispatch("-1089891024", new Object[]{this, str});
        }
        if (isHasYellContent(str)) {
            String substring = str.substring(1, str.length() - 1);
            if (TextUtils.isEmpty(substring) || (yellSource = ChatResourceManager.getInstance().getYellSource(substring)) == null || !(yellSource instanceof YellInfoBean)) {
                return null;
            }
            return (YellInfoBean) yellSource;
        }
        return null;
    }

    private boolean isHasYellContent(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-655797586") ? ((Boolean) ipChange.ipc$dispatch("-655797586", new Object[]{this, str})).booleanValue() : !TextUtils.isEmpty(str) && str.startsWith(jn1.ARRAY_START_STR) && str.endsWith(jn1.ARRAY_END_STR);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "264052977") ? ((Integer) ipChange.ipc$dispatch("264052977", new Object[]{this, Integer.valueOf(i)})).intValue() : getLiveCommentItem().get(i).getCellType();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2126235634")) {
            ipChange.ipc$dispatch("-2126235634", new Object[]{this, view});
        } else if (view.getId() != R.id.content_text || view.getTag() == null) {
        } else {
            int intValue = ((Integer) view.getTag()).intValue();
            OnCellClickListener onCellClickListener = this.mCellClickListener;
            if (onCellClickListener != null) {
                if (intValue == 2) {
                    onCellClickListener.onCellClick("onCellClicked", this.mShareMap);
                } else if (intValue == 3) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("source", "attention");
                    this.mCellClickListener.onCellClick("onAttentionClicked", hashMap);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "526731161")) {
            ipChange.ipc$dispatch("526731161", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        AILPChatBean aILPChatBean = getLiveCommentItem().get(i);
        if (viewHolder == null || aILPChatBean == null) {
            return;
        }
        viewHolder.setText(aILPChatBean, getItemViewType(i));
        if (!TextUtils.isEmpty(aILPChatBean.getFace())) {
            DagoImageLoader.getInstance().showCircle(this.mContext, aILPChatBean.getFace(), viewHolder.mUserIcon, R.C7941drawable.dago_pgc_ailp_gift_user_header_2x);
            viewHolder.mUserIcon.setVisibility(0);
        } else {
            viewHolder.mUserIcon.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aILPChatBean.getFaceIcon())) {
            viewHolder.mUserVipIcon.setVisibility(0);
            DagoImageLoader.getInstance().showCircle(this.mContext, aILPChatBean.getFaceIcon(), viewHolder.mUserVipIcon, R.C7941drawable.dago_pgc_ailp_chat_gold_icon);
            return;
        }
        viewHolder.mUserVipIcon.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2129934205") ? (ViewHolder) ipChange.ipc$dispatch("2129934205", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.C7942layout.dago_pgc_ailp_comment_item_new, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(final ViewHolder viewHolder) {
        final AILPChatBean aILPChatBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "994471204")) {
            ipChange.ipc$dispatch("994471204", new Object[]{this, viewHolder});
            return;
        }
        super.onViewAttachedToWindow((AILPChatListRecyclerViewAdapterNew) viewHolder);
        if (viewHolder == null) {
            return;
        }
        int adapterPosition = viewHolder.getAdapterPosition();
        List<AILPChatBean> liveCommentItem = getLiveCommentItem();
        if (liveCommentItem == null || liveCommentItem.size() <= adapterPosition || (aILPChatBean = getLiveCommentItem().get(adapterPosition)) == null) {
            return;
        }
        viewHolder.itemLayout.setTag(Integer.valueOf(adapterPosition));
        if (aILPChatBean.getBorderWidth() != 0) {
            viewHolder.mUserComment.post(new Runnable() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp.AILPChatListRecyclerViewAdapterNew.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1134735989")) {
                        ipChange2.ipc$dispatch("1134735989", new Object[]{this});
                        return;
                    }
                    if (viewHolder.mUserComment.getLineCount() == 1) {
                        Drawable drawable = AILPChatListRecyclerViewAdapterNew.this.mContext.getResources().getDrawable(R.C7941drawable.dago_pgc_chat_item_bg_one_line_border);
                        if (drawable instanceof GradientDrawable) {
                            if (aILPChatBean.getBgColor() != -1) {
                                ((GradientDrawable) drawable).setColor(aILPChatBean.getBgColor());
                            }
                            if (aILPChatBean.getBgAlpha() >= 0) {
                                drawable.setAlpha(aILPChatBean.getBgAlpha());
                            }
                            if (!TextUtils.isEmpty(aILPChatBean.getBorderColor()) && aILPChatBean.getBorderWidth() > 0) {
                                int borderWidth = aILPChatBean.getBorderWidth();
                                GradientDrawable gradientDrawable = (GradientDrawable) drawable;
                                i = borderWidth > 1 ? borderWidth : 2;
                                AILPChatBean aILPChatBean2 = aILPChatBean;
                                gradientDrawable.setStroke(i, aILPChatBean2.getColor("", aILPChatBean2.getBorderColor(), 0));
                            }
                            viewHolder.itemLayout.setBackground(drawable);
                            return;
                        }
                        return;
                    }
                    Drawable drawable2 = AILPChatListRecyclerViewAdapterNew.this.mContext.getResources().getDrawable(R.C7941drawable.dago_pgc_chat_item_bg_more_line_border);
                    if (drawable2 instanceof GradientDrawable) {
                        if (aILPChatBean.getBgColor() != -1) {
                            ((GradientDrawable) drawable2).setColor(aILPChatBean.getBgColor());
                        }
                        if (aILPChatBean.getBgAlpha() >= 0) {
                            drawable2.setAlpha(aILPChatBean.getBgAlpha());
                        }
                        if (!TextUtils.isEmpty(aILPChatBean.getBorderColor()) && aILPChatBean.getBorderWidth() > 0) {
                            int borderWidth2 = aILPChatBean.getBorderWidth();
                            GradientDrawable gradientDrawable2 = (GradientDrawable) drawable2;
                            i = borderWidth2 > 1 ? borderWidth2 : 2;
                            AILPChatBean aILPChatBean3 = aILPChatBean;
                            gradientDrawable2.setStroke(i, aILPChatBean3.getColor("", aILPChatBean3.getBorderColor(), 0));
                        }
                        viewHolder.itemLayout.setBackground(drawable2);
                    }
                }
            });
        } else {
            viewHolder.mUserComment.post(new Runnable() { // from class: com.youku.live.dago.widgetlib.ailproom.adapter.chatlist.ailp.AILPChatListRecyclerViewAdapterNew.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // java.lang.Runnable
                public void run() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "938222484")) {
                        ipChange2.ipc$dispatch("938222484", new Object[]{this});
                    } else if (viewHolder.mUserComment.getLineCount() == 1) {
                        Drawable drawable = AILPChatListRecyclerViewAdapterNew.this.mContext.getResources().getDrawable(R.C7941drawable.dago_pgc_chat_item_bg_one_line);
                        if (drawable instanceof GradientDrawable) {
                            if (aILPChatBean.getBgColor() != -1) {
                                ((GradientDrawable) drawable).setColor(aILPChatBean.getBgColor());
                            }
                            if (aILPChatBean.getBgAlpha() >= 0) {
                                drawable.setAlpha(aILPChatBean.getBgAlpha());
                            }
                            ((GradientDrawable) drawable).setStroke(0, 0);
                            viewHolder.itemLayout.setBackground(drawable);
                        }
                    } else {
                        Drawable drawable2 = AILPChatListRecyclerViewAdapterNew.this.mContext.getResources().getDrawable(R.C7941drawable.dago_pgc_chat_item_bg_more_line);
                        if (drawable2 instanceof GradientDrawable) {
                            if (aILPChatBean.getBgColor() != -1) {
                                ((GradientDrawable) drawable2).setColor(aILPChatBean.getBgColor());
                            }
                            if (aILPChatBean.getBgAlpha() >= 0) {
                                drawable2.setAlpha(aILPChatBean.getBgAlpha());
                            }
                            ((GradientDrawable) drawable2).setStroke(0, 0);
                            viewHolder.itemLayout.setBackground(drawable2);
                        }
                    }
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(ViewHolder viewHolder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "412454082")) {
            ipChange.ipc$dispatch("412454082", new Object[]{this, viewHolder});
        } else {
            super.onViewRecycled((AILPChatListRecyclerViewAdapterNew) viewHolder);
        }
    }
}
