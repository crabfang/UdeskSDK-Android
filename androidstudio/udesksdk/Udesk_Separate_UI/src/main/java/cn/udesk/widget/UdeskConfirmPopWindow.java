package cn.udesk.widget;import android.app.Activity;import android.content.Context;import android.graphics.drawable.ColorDrawable;import android.view.Gravity;import android.view.LayoutInflater;import android.view.View;import android.view.ViewGroup;import android.widget.PopupWindow;import android.widget.TextView;import cn.udesk.R;public class UdeskConfirmPopWindow extends PopupWindow implements View.OnClickListener {    public UdeskConfirmPopWindow(Context context) {        super(context );        setFocusable(true);         setTouchable(true);        setOutsideTouchable(true);         setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));            }        public void show(Activity content,View locationView,String positiveLabel,String negativeLabel,String confirmContent,OnPopConfirmClick onPopMultiMenuClick){        LayoutInflater layoutInflater=LayoutInflater.from(content);        mOnPopConfirmClick = onPopMultiMenuClick;                ViewGroup rootView =(ViewGroup) layoutInflater.inflate(R.layout.udesk_confirm_pop_dialog, null);        ViewGroup popupView = (ViewGroup)rootView.findViewById(R.id.udesk_confirm_pop_panel);                //       TextView gegativeTv= (TextView)popupView.findViewById(R.id.udesk_confirm_pop_negative);       gegativeTv.setText(negativeLabel);       gegativeTv.setOnClickListener(this);              //       TextView potitiveTv= (TextView)popupView.findViewById(R.id.udesk_confirm_pop_positive);       potitiveTv.setText(positiveLabel);       potitiveTv.setOnClickListener(this);       //       ((TextView)popupView.findViewById(R.id.udesk_confirm_pop_content)).setText(confirmContent);        // 把菜单都添加进去        setContentView(rootView);         setWindowLayoutMode(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);          setWidth( ViewGroup.LayoutParams.WRAP_CONTENT);         setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);         //显示出来        showAtLocation(locationView, Gravity.CENTER , 0,0);    }         public void  cancle() {    	     	 dismiss();	}        @Override    public void onClick(View childView) {        if (mOnPopConfirmClick != null) {            int id = childView.getId();            if (id == R.id.udesk_confirm_pop_positive) {                mOnPopConfirmClick.onPositiveClick();            } else if (id == R.id.udesk_confirm_pop_negative) {                mOnPopConfirmClick.onNegativeClick();            }        }        dismiss();    }            private OnPopConfirmClick mOnPopConfirmClick;    public interface OnPopConfirmClick {        public void onPositiveClick( );        public void onNegativeClick( );    }}