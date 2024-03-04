package com.example.match3

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import kotlin.random.Random
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    inner class AnimationSequence(private val imageView: ImageView, private vararg val animations: Animation) : Animation.AnimationListener {
        private var currentAnimationIndex = 0

        init {
            animations.forEach { it.setAnimationListener(this) }
        }

        fun start() {
            imageView.startAnimation(animations[currentAnimationIndex])
        }

        override fun onAnimationStart(animation: Animation?) {
            // Начало анимации
        }

        override fun onAnimationEnd(animation: Animation?) {
            currentAnimationIndex++
            if (currentAnimationIndex < animations.size) {
                // Переходим к следующей анимации
                animations[currentAnimationIndex].setAnimationListener(this)
                imageView.startAnimation(animations[currentAnimationIndex])
            } else {
                // Все анимации завершены
            }
        }

        override fun onAnimationRepeat(animation: Animation?) {
            // Повторение анимации
        }
    }

    val rows = 8
    val columns = 7
    val chipImageMatrix = Array(rows) { Array<ImageView?>(columns) { null } }

    val array = Array(rows) { Array(columns) { Random.nextInt(1, 5) } }

    var currentX = -1
    var currentY = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        chipImageMatrix[0][0] = this.findViewById<ImageView?>(R.id.imageView1_1)
        chipImageMatrix[0][1] = this.findViewById<ImageView?>(R.id.imageView1_2)
        chipImageMatrix[0][2] = this.findViewById<ImageView?>(R.id.imageView1_3)
        chipImageMatrix[0][3] = this.findViewById<ImageView?>(R.id.imageView1_4)
        chipImageMatrix[0][4] = this.findViewById<ImageView?>(R.id.imageView1_5)
        chipImageMatrix[0][5] = this.findViewById<ImageView?>(R.id.imageView1_6)
        chipImageMatrix[0][6] = this.findViewById<ImageView?>(R.id.imageView1_7)

        chipImageMatrix[1][0] = this.findViewById<ImageView?>(R.id.imageView2_1)
        chipImageMatrix[1][1] = this.findViewById<ImageView?>(R.id.imageView2_2)
        chipImageMatrix[1][2] = this.findViewById<ImageView?>(R.id.imageView2_3)
        chipImageMatrix[1][3] = this.findViewById<ImageView?>(R.id.imageView2_4)
        chipImageMatrix[1][4] = this.findViewById<ImageView?>(R.id.imageView2_5)
        chipImageMatrix[1][5] = this.findViewById<ImageView?>(R.id.imageView2_6)
        chipImageMatrix[1][6] = this.findViewById<ImageView?>(R.id.imageView2_7)

        chipImageMatrix[2][0] = this.findViewById<ImageView?>(R.id.imageView3_1)
        chipImageMatrix[2][1] = this.findViewById<ImageView?>(R.id.imageView3_2)
        chipImageMatrix[2][2] = this.findViewById<ImageView?>(R.id.imageView3_3)
        chipImageMatrix[2][3] = this.findViewById<ImageView?>(R.id.imageView3_4)
        chipImageMatrix[2][4] = this.findViewById<ImageView?>(R.id.imageView3_5)
        chipImageMatrix[2][5] = this.findViewById<ImageView?>(R.id.imageView3_6)
        chipImageMatrix[2][6] = this.findViewById<ImageView?>(R.id.imageView3_7)

        chipImageMatrix[3][0] = this.findViewById<ImageView?>(R.id.imageView4_1)
        chipImageMatrix[3][1] = this.findViewById<ImageView?>(R.id.imageView4_2)
        chipImageMatrix[3][2] = this.findViewById<ImageView?>(R.id.imageView4_3)
        chipImageMatrix[3][3] = this.findViewById<ImageView?>(R.id.imageView4_4)
        chipImageMatrix[3][4] = this.findViewById<ImageView?>(R.id.imageView4_5)
        chipImageMatrix[3][5] = this.findViewById<ImageView?>(R.id.imageView4_6)
        chipImageMatrix[3][6] = this.findViewById<ImageView?>(R.id.imageView4_7)

        chipImageMatrix[4][0] = this.findViewById<ImageView?>(R.id.imageView5_1)
        chipImageMatrix[4][1] = this.findViewById<ImageView?>(R.id.imageView5_2)
        chipImageMatrix[4][2] = this.findViewById<ImageView?>(R.id.imageView5_3)
        chipImageMatrix[4][3] = this.findViewById<ImageView?>(R.id.imageView5_4)
        chipImageMatrix[4][4] = this.findViewById<ImageView?>(R.id.imageView5_5)
        chipImageMatrix[4][5] = this.findViewById<ImageView?>(R.id.imageView5_6)
        chipImageMatrix[4][6] = this.findViewById<ImageView?>(R.id.imageView5_7)

        chipImageMatrix[5][0] = this.findViewById<ImageView?>(R.id.imageView6_1)
        chipImageMatrix[5][1] = this.findViewById<ImageView?>(R.id.imageView6_2)
        chipImageMatrix[5][2] = this.findViewById<ImageView?>(R.id.imageView6_3)
        chipImageMatrix[5][3] = this.findViewById<ImageView?>(R.id.imageView6_4)
        chipImageMatrix[5][4] = this.findViewById<ImageView?>(R.id.imageView6_5)
        chipImageMatrix[5][5] = this.findViewById<ImageView?>(R.id.imageView6_6)
        chipImageMatrix[5][6] = this.findViewById<ImageView?>(R.id.imageView6_7)

        chipImageMatrix[6][0] = this.findViewById<ImageView?>(R.id.imageView7_1)
        chipImageMatrix[6][1] = this.findViewById<ImageView?>(R.id.imageView7_2)
        chipImageMatrix[6][2] = this.findViewById<ImageView?>(R.id.imageView7_3)
        chipImageMatrix[6][3] = this.findViewById<ImageView?>(R.id.imageView7_4)
        chipImageMatrix[6][4] = this.findViewById<ImageView?>(R.id.imageView7_5)
        chipImageMatrix[6][5] = this.findViewById<ImageView?>(R.id.imageView7_6)
        chipImageMatrix[6][6] = this.findViewById<ImageView?>(R.id.imageView7_7)

        chipImageMatrix[7][0] = this.findViewById<ImageView?>(R.id.imageView8_1)
        chipImageMatrix[7][1] = this.findViewById<ImageView?>(R.id.imageView8_2)
        chipImageMatrix[7][2] = this.findViewById<ImageView?>(R.id.imageView8_3)
        chipImageMatrix[7][3] = this.findViewById<ImageView?>(R.id.imageView8_4)
        chipImageMatrix[7][4] = this.findViewById<ImageView?>(R.id.imageView8_5)
        chipImageMatrix[7][5] = this.findViewById<ImageView?>(R.id.imageView8_6)
        chipImageMatrix[7][6] = this.findViewById<ImageView?>(R.id.imageView8_7)

        setListeners()
        updateImages()
    }

    fun updateImages() {
        for (y in 0 until rows) {
            for (x in 0 until columns) {
                val imageView = chipImageMatrix[y][x] ?: continue
                when (array[y][x]) {
                    1 -> imageView.setImageResource(R.drawable.chip1)
                    2 -> imageView.setImageResource(R.drawable.chip2)
                    3 -> imageView.setImageResource(R.drawable.chip3)
                    4 -> imageView.setImageResource(R.drawable.chip4)
                    else -> imageView.setImageResource(R.drawable.empty)
                }
            }
        }
    }

    fun swap(x1: Int, y1: Int, x2:Int, y2:Int)
    {
        var c:Int
        c = array[y1][x1]
        array[y1][x1]=array[y2][x2]
        array[y2][x2]=c
    }

    fun solveMatches()
    {
        
    }

    fun startAnimationLeftRight(x1: Int, y1: Int, x2: Int, y2: Int)
    {
        val imageView1 = chipImageMatrix[y1][x1]

        val translateAnimation1 = TranslateAnimation(
            0.0f,
            -150.0f,
            0.0f,
            0.0f
        )
        translateAnimation1.duration = 200

        translateAnimation1.startOffset = 0

        translateAnimation1.repeatCount = 1

        translateAnimation1.interpolator = android.view.animation.LinearInterpolator()

        translateAnimation1.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
            }

            override fun onAnimationRepeat(animation: Animation?) {
                animation?.cancel()
                swap(x1,y1, x2, y2)
                updateImages()
            }
        })

        imageView1?.startAnimation(translateAnimation1)

        val imageView2 = chipImageMatrix[y2][x2]

        val translateAnimation2 = TranslateAnimation(
            0.0f,
            150.0f,
            0.0f,
            0.0f
        )
        translateAnimation2.duration = 200

        translateAnimation2.startOffset = 0

        translateAnimation2.repeatCount = 1

        translateAnimation2.interpolator = android.view.animation.LinearInterpolator()

        translateAnimation2.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {
            }

            override fun onAnimationRepeat(animation: Animation?) {
                animation?.cancel()
            }
        })

        imageView2?.startAnimation(translateAnimation2)

    }


    fun startAnimationLeftRightFail(x1: Int, y1: Int, x2: Int, y2: Int)
    {
        val imageView1 = chipImageMatrix[y1][x1]

        val translateAnimation1 = TranslateAnimation(
            0.0f,
            -150.0f,
            0.0f,
            0.0f
        )
        translateAnimation1.duration = 200

        translateAnimation1.startOffset = 0

        translateAnimation1.repeatCount = 0

        translateAnimation1.interpolator = android.view.animation.LinearInterpolator()

        val translateAnimation1r = TranslateAnimation(
            -150.0f,
            0.0f,
            0.0f,
            0.0f
        )
        translateAnimation1r.duration = 200

        translateAnimation1r.startOffset = 0

        translateAnimation1r.repeatCount = 0

        translateAnimation1r.interpolator = android.view.animation.LinearInterpolator()

        val animationSequence1 = AnimationSequence(imageView1!!, translateAnimation1, translateAnimation1r)

        animationSequence1.start()

        val imageView2 = chipImageMatrix[y2][x2]

        val translateAnimation2 = TranslateAnimation(
            0.0f,
            150.0f,
            0.0f,
            0.0f
        )
        translateAnimation2.duration = 200

        translateAnimation2.startOffset = 0

        translateAnimation2.repeatCount = 0

        translateAnimation2.interpolator = android.view.animation.LinearInterpolator()

        val translateAnimation2r = TranslateAnimation(
            150.0f,
            0.0f,
            0.0f,
            0.0f
        )
        translateAnimation2r.duration = 200

        translateAnimation2r.startOffset = 0

        translateAnimation2r.repeatCount = 0

        translateAnimation2r.interpolator = android.view.animation.LinearInterpolator()

        val animationSequence2 = AnimationSequence(imageView2!!, translateAnimation2, translateAnimation2r)

        animationSequence2.start()

    }


    fun startAnimationTopBottomFail(x1: Int, y1: Int, x2: Int, y2: Int)
    {
        val imageView1 = chipImageMatrix[y1][x1]

        val translateAnimation1 = TranslateAnimation(
            0.0f,
            0.0f,
            0.0f,
            -150.0f
        )
        translateAnimation1.duration = 200

        translateAnimation1.startOffset = 0

        translateAnimation1.repeatCount = 0

        translateAnimation1.interpolator = android.view.animation.LinearInterpolator()

        val translateAnimation1r = TranslateAnimation(
            0.0f,
            0.0f,
            -150.0f,
            0.0f
        )
        translateAnimation1r.duration = 200

        translateAnimation1r.startOffset = 0

        translateAnimation1r.repeatCount = 0

        translateAnimation1r.interpolator = android.view.animation.LinearInterpolator()

        val animationSequence1 = AnimationSequence(imageView1!!, translateAnimation1, translateAnimation1r)

        animationSequence1.start()

        val imageView2 = chipImageMatrix[y2][x2]

        val translateAnimation2 = TranslateAnimation(
            0.0f,
            0.0f,
            0.0f,
            150.0f
        )
        translateAnimation2.duration = 200

        translateAnimation2.startOffset = 0

        translateAnimation2.repeatCount = 0

        translateAnimation2.interpolator = android.view.animation.LinearInterpolator()

        val translateAnimation2r = TranslateAnimation(
            0.0f,
            0.0f,
            150.0f,
            0.0f
        )
        translateAnimation2r.duration = 200

        translateAnimation2r.startOffset = 0

        translateAnimation2r.repeatCount = 0

        translateAnimation2r.interpolator = android.view.animation.LinearInterpolator()

        val animationSequence2 = AnimationSequence(imageView2!!, translateAnimation2, translateAnimation2r)

        animationSequence2.start()

    }

    fun startAnimationTopBottom(x1: Int, y1: Int, x2: Int, y2: Int)
    {
        val imageView1 = chipImageMatrix[y1][x1]

        val translateAnimation1 = TranslateAnimation(
            0.0f,
            0.0f,
            0.0f,
            -150.0f
        )
        translateAnimation1.duration = 200

        translateAnimation1.zAdjustment = Animation.ZORDER_TOP

        translateAnimation1.startOffset = 0

        translateAnimation1.repeatCount = 1

        translateAnimation1.interpolator = android.view.animation.LinearInterpolator()

        translateAnimation1.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {

            }

            override fun onAnimationRepeat(animation: Animation?) {
                animation?.cancel()
                swap(x1,y1, x2, y2)
                updateImages()
            }
        })

        imageView1?.startAnimation(translateAnimation1)

        val imageView2 = chipImageMatrix[y2][x2]

        val translateAnimation2 = TranslateAnimation(
            0.0f,
            0.0f,
            0.0f,
            150.0f
        )
        translateAnimation2.duration = 200

        translateAnimation2.zAdjustment = Animation.ZORDER_TOP

        translateAnimation2.startOffset = 0

        translateAnimation2.repeatCount = 1

        translateAnimation2.interpolator = android.view.animation.LinearInterpolator()

        translateAnimation2.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation?) {

            }

            override fun onAnimationRepeat(animation: Animation?) {
                animation?.cancel()
            }
        })

        imageView2?.startAnimation(translateAnimation2)

    }

    fun setListeners(){
        for (y in 0 until rows) {
            for (x in 0 until columns) {
                val imageView = chipImageMatrix[y][x] ?: continue
                  imageView.setOnClickListener {

                      if(x==currentX+1 && y==currentY)
                      {
                          startAnimationLeftRightFail(x,y, currentX, currentY)
                          currentX = -1
                          currentY = -1
                      }
                      else if(x==currentX-1 && y==currentY)
                      {
                          startAnimationLeftRightFail(currentX, currentY, x, y)
                          currentX = -1
                          currentY = -1
                      }
                      else if(x==currentX && y==currentY+1)
                      {
                          startAnimationTopBottomFail(x, y, currentX, currentY)
                          currentX = -1
                          currentY = -1
                      }
                      else if(x==currentX && y==currentY-1)
                      {
                          startAnimationTopBottomFail(currentX, currentY, x, y)
                          currentX = -1
                          currentY = -1
                      }
                      else
                      {
                            currentX=x
                            currentY=y
                      }
                      updateImages()
                  }
            }
        }
    }
}
