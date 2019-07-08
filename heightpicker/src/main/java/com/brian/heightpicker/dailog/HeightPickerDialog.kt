package com.brian.heightpicker.dailog

/**
 *  @author: brian
 *  @date:  2019/7/8
 *  @description:
 */


import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import com.brian.heightpicker.R
import com.brian.heightpicker.view.QNumberPicker

class HeightPickerDialog(context: Context?, themeResId: Int) : Dialog(context, themeResId) {

//    constructor(context: Context?, themeResId: Int) : super(context, themeResId)
//    constructor(context: Context?,themeResId: Int):super(context,themeResId)

    //    constructor(context: Context?,  themeResId: Int, onReturnValueListener: OnReturnValueListener) : super(
//        context,
//        themeResId
//    )
    var value1: Int = 0
    var value2: Int = 0
    var value3: Int = 0

    lateinit var numberPicker1: QNumberPicker
    lateinit var numberPicker2: QNumberPicker
    lateinit var numberPicker3: QNumberPicker

    lateinit var tvCancel: TextView
    lateinit var tvOk: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_height_picker, null)
//        setView(view) //把选择器添加到提示框
        setContentView(view)
        initView(view)
        initData()
        initListener()

        initWindows()

    }

    private fun initWindows() {


        val window = window
        //设置弹出窗口大小
        window!!.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        //设置显示位置
        window.setGravity(Gravity.BOTTOM)
        //
        //        WindowManager.LayoutParams lp = window.getAttributes();
        //        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        //        window.setAttributes(lp);

        setCancelable(true)
        setCanceledOnTouchOutside(true)

    }

    private fun initListener() {
        numberPicker1.setOnValueChangedListener { picker, oldVal, newVal ->
            value1 = newVal
//            Toast.makeText(this.context, "1选择了：" + newVal, Toast.LENGTH_SHORT).show()
        }

        numberPicker2.setOnValueChangedListener { picker, oldVal, newVal ->
            value2 = newVal
//            Toast.makeText(this.context, "2选择了：" + newVal, Toast.LENGTH_SHORT).show()
        }
        numberPicker3.setOnValueChangedListener { picker, oldVal, newVal ->
            value3 = newVal
//            Toast.makeText(this.context, "3选择了：" + newVal, Toast.LENGTH_SHORT).show()
        }

        tvCancel.setOnClickListener {
            this.dismiss()
        }

        tvOk.setOnClickListener {
            var value = value1 * 100 + value2 * 10 + value3
            mOnReturnValueListener!!.onReturnValue(value)
            this.dismiss()
        }
    }


    private fun initData() {
        numberPicker1.minValue = 0
        numberPicker1.maxValue = 2
        //这里设置为不循环显示，默认值为true
//        numberPicker1.setWrapSelectorWheel(true);
        numberPicker1.setNumberPickerDividerColor(numberPicker1, R.color.picker_division)

        numberPicker2.minValue = 0
        numberPicker2.maxValue = 9
        numberPicker2.setNumberPickerDividerColor(numberPicker2, R.color.picker_division)

        numberPicker3.minValue = 0
        numberPicker3.maxValue = 9
        numberPicker3.setNumberPickerDividerColor(numberPicker3, R.color.picker_division)

    }


    private fun initView(view: View) {
        numberPicker1 = view.findViewById(R.id.np_1)
        numberPicker2 = view.findViewById(R.id.np_2)
        numberPicker3 = view.findViewById(R.id.np_3)

        tvCancel = view.findViewById(R.id.tv_cancel)
        tvOk = view.findViewById(R.id.tv_ok)

    }


    lateinit var mOnReturnValueListener: OnReturnValueListener

    fun setOnReturnDateListener(mOnReturnDateListener: OnReturnValueListener) {
        this.mOnReturnValueListener = mOnReturnDateListener
    }

    /**
     * 返回数据的接口
     */
    interface OnReturnValueListener {
        fun onReturnValue(height: Int)
    }
}
