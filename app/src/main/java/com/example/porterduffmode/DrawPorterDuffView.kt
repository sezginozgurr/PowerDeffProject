package com.example.porterduffmode

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
open class DrawPorterDuffView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val fullRect by lazy { Rect(0, 0, width, height) }
    private val paintDst = Paint()
    private val paintSrc = Paint()
    private var resourceImageSrc = R.drawable.glow
    private var resourceImageDst= R.drawable.elmas

    init {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null)
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it,
                R.styleable.draw_porter_duff_attributes, 0, 0)
            resourceImageSrc = typedArray.getResourceId(
                R.styleable.draw_porter_duff_attributes_draw_porter_duff_image_src, R.drawable.glow)
            resourceImageDst = typedArray.getResourceId(
                R.styleable.draw_porter_duff_attributes_draw_porter_duff_image_dst, R.drawable.elmas)

            typedArray.recycle()
        }
    }

    private val bitmapSource by lazy { BitmapFactory.decodeResource(resources, resourceImageSrc) }
    private val bitmapDestination by lazy { BitmapFactory.decodeResource(resources, resourceImageDst) }

    var mode: PorterDuff.Mode = PorterDuff.Mode.CLEAR
        set(value) {
            field = value
            paintSrc.xfermode = PorterDuffXfermode(mode)
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width == 0 || height == 0) return
        canvas.drawBitmap(bitmapDestination, null, fullRect, paintDst)
        canvas.drawBitmap(bitmapSource, null, fullRect, paintSrc)
    }
}