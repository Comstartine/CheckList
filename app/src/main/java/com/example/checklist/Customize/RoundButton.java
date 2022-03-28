package com.example.checklist.Customize;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.Button;

import com.example.checklist.R;

public class RoundButton extends androidx.appcompat.widget.AppCompatButton{


    /**
     * 颜色值不要设置默认值为-1；
     * TypedArray的getColor方法在颜色设置为白色的时候返回-1
     * why:白色的16进制 #FFFFFF, 不设置不透明度默认FF ,ARGB合起来 #FFFFFFFF,这个不就是整数-1
     */
    private int backgroundNormalColor = -2;  //默认背景颜色
    private int backgroundPressedColor = -2;    //点击背景颜色
    private int backgroundEnableFalseColor = -2; //不是有背景颜色
    private int backgroundStrokeColor = -2;     //边框颜色
    private int backgroundRadius = -1;          //背景半径
    private int backgroundTopLeftRadius = -1;   //左上角半径
    private int backgroundTopRightRadius = -1;  //右上角半径
    private int backgroundBottomLeftRadius = -1;    //左下角半径
    private int backgroundBottomRightRadius = -1;   //右下角半径
    private int backgroundStrokeWidth = -1;         //边框宽带
    private static final int[] STATE_NORMAL = {-android.R.attr.state_pressed, android.R.attr.state_enabled};
    private static final int[] STATE_PRESSED = {android.R.attr.state_pressed};
    private static final int[] STATE_ENABLE_FALSE = {-android.R.attr.state_enabled};


    public RoundButton(Context context) {
        super(context);
    }

    public RoundButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }
    public RoundButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }
    /*
    * 是否设置背景颜色
    * */
    private boolean isNotSetColor() {
        return backgroundNormalColor == -2
                && backgroundPressedColor == -2
                && backgroundEnableFalseColor == -2;
    }

    /*
    * 是否设置边框半径
    * */
    private boolean isNotSetRadius() {
        return backgroundRadius == -1
                && backgroundTopLeftRadius == -1
                && backgroundTopRightRadius == -1
                && backgroundBottomLeftRadius == -1
                && backgroundBottomRightRadius == -1;
    }

    /*
    * 是否单独设置不同方位的半径
    * */
    private boolean isNotSetSeparatelyRadius() {
        return backgroundTopLeftRadius == -1
                && backgroundTopRightRadius == -1
                && backgroundBottomLeftRadius == -1
                && backgroundBottomRightRadius == -1;
    }
    /**
     * 设置四个角的圆角效果
     */
    private void setRadius(GradientDrawable gradientDrawable) {
        if (isNotSetSeparatelyRadius()) return;
        float[] radii = new float[8];
        //top-left
        radii[0] = backgroundTopLeftRadius;
        radii[1] = backgroundTopLeftRadius;
        //top-right
        radii[2] = backgroundTopRightRadius;
        radii[3] = backgroundTopRightRadius;
        //bottom-right
        radii[4] = backgroundBottomLeftRadius;
        radii[5] = backgroundBottomLeftRadius;
        //bottom-left
        radii[6] = backgroundBottomRightRadius;
        radii[7] = backgroundBottomRightRadius;
        gradientDrawable.setCornerRadii(radii);
    }
    /*
    * 初始化按钮
    * */
    private void initView(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.RoundButton, 0, 0);
        try {
            backgroundNormalColor = a.getColor(R.styleable.RoundButton_background_normal_color, -2);
            backgroundPressedColor = a.getColor(R.styleable.RoundButton_background_pressed_color, -2);
            backgroundEnableFalseColor = a.getColor(R.styleable.RoundButton_background_enable_false_color, -2);
            backgroundStrokeColor = a.getColor(R.styleable.RoundButton_background_stroke_color, -2);
            backgroundRadius = a.getLayoutDimension(R.styleable.RoundButton_background_radius, -1);
            backgroundTopLeftRadius = a.getLayoutDimension(R.styleable.RoundButton_background_topLeftRadius, -1);
            backgroundTopRightRadius = a.getLayoutDimension(R.styleable.RoundButton_background_topRightRadius, -1);
            backgroundBottomLeftRadius = a.getLayoutDimension(R.styleable.RoundButton_background_bottomLeftRadius, -1);
            backgroundBottomRightRadius = a.getLayoutDimension(R.styleable.RoundButton_background_bottomRightRadius, -1);
            backgroundStrokeWidth = a.getLayoutDimension(R.styleable.RoundButton_background_stroke_width, -1);
        } finally {
            a.recycle();
        }
        if (isNotSetColor() || isNotSetRadius()) return;
        StateListDrawable stateListDrawable = new StateListDrawable();
        //pressed
        if (backgroundPressedColor != -2) {
            GradientDrawable shapePressed = new GradientDrawable();//对应xml中<shape/>
            shapePressed.setColor(backgroundPressedColor);  //设置点击时的颜色
            if (backgroundRadius != -1) {
                shapePressed.setCornerRadius(backgroundRadius);
            }
            if (backgroundStrokeWidth != -1 && backgroundStrokeColor != -2) {
                shapePressed.setStroke(backgroundStrokeWidth, backgroundStrokeColor);
            }
            setRadius(shapePressed);
            stateListDrawable.addState(STATE_PRESSED, shapePressed);
        }
        //enable_false
        if (backgroundEnableFalseColor != -2) {
            GradientDrawable shapeEnableFalse = new GradientDrawable();
            shapeEnableFalse.setColor(backgroundEnableFalseColor);
            if (backgroundRadius != -1) {
                shapeEnableFalse.setCornerRadius(backgroundRadius);
            }
            if (backgroundStrokeWidth != -1 && backgroundStrokeColor != -2) {
                shapeEnableFalse.setStroke(backgroundStrokeWidth, backgroundStrokeColor);
            }
            setRadius(shapeEnableFalse);
            stateListDrawable.addState(STATE_ENABLE_FALSE, shapeEnableFalse);
        }
        //normal
        if (backgroundNormalColor != -2) {
            GradientDrawable shapeNormal = new GradientDrawable();
            shapeNormal.setColor(backgroundNormalColor);
            if (backgroundRadius != -1) {
                shapeNormal.setCornerRadius(backgroundRadius);
            }
            if (backgroundStrokeWidth != -1 && backgroundStrokeColor != -2) {
                shapeNormal.setStroke(backgroundStrokeWidth, backgroundStrokeColor);
            }
            setRadius(shapeNormal);
            stateListDrawable.addState(STATE_NORMAL, shapeNormal);
        }
        setBackground(stateListDrawable);
    }
} 
