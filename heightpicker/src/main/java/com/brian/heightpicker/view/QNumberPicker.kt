package com.brian.heightpicker.view

import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.view.View
import android.widget.EditText
import android.widget.NumberPicker
import android.graphics.drawable.ColorDrawable
import com.brian.heightpicker.R


/**
 *  @author: brian
 *  @date:  2019/7/8
 *  @description:
 */

class QNumberPicker : NumberPicker {

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun addView(child: View) {
        super.addView(child)
        updateView(child)
    }

    override fun addView(
        child: View, index: Int,
        params: android.view.ViewGroup.LayoutParams
    ) {
        super.addView(child, index, params)
        updateView(child)
    }

    override fun addView(child: View, params: android.view.ViewGroup.LayoutParams) {
        super.addView(child, params)
        updateView(child)
    }

    fun updateView(view: View) {
        if (view is EditText) {
            //这里修改字体的属性
            (view as EditText).setTextColor(getResources().getColor(R.color.picker_text))
            //            ((EditText) view).setTextSize();
        }

    }

    public fun setNumberPickerDividerColor(numberPicker: NumberPicker, color :Int) {
        val pickerFields = NumberPicker::class.java.declaredFields
        for (pf in pickerFields) {
            if (pf.name.equals("mSelectionDivider")) {
                pf.isAccessible = true
                try {
                    //设置分割线的颜色值
                    pf.set(numberPicker, ColorDrawable(this.resources.getColor(color)))
//                    pf.set(numberPicker, ColorDrawable(color))
                } catch (e: IllegalArgumentException) {
                    e.printStackTrace()
                } catch (e: Resources.NotFoundException) {
                    e.printStackTrace()
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                }

                break
            }
        }
    }


}