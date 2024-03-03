package com.example.match3

import android.os.Bundle
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

    val chipImageMatrix = Array(8) { Array<ImageView?>(7) { null } }


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
    }

    fun setListeners(){
        val rows = 8
        val columns = 7
        val array = Array(rows) { Array(columns) { Random.nextInt(1, 5) } }
        val x = 0
        val y = 0
        for (x in 0 until 8) {
            for (y in 0 until 7) {
                val imageView = chipImageMatrix[x][y] ?: continue
                when (array[x][y]) {
                    1 -> imageView.setImageResource(R.drawable.chip1)
                    2 -> imageView.setImageResource(R.drawable.chip2)
                    3 -> imageView.setImageResource(R.drawable.chip3)
                    4 -> imageView.setImageResource(R.drawable.chip4)
                    else -> imageView.setImageResource(R.drawable.ic_launcher_background)
                }

                imageView.setOnClickListener {
                    if(x==currentX+1 && y==currentY)
                    {
                        var c:Int
                        c = array[x][y]
                        array[x][y]=array[currentX][currentY]
                        array[currentX][currentY]=c

                        val imageView = chipImageMatrix[x][y]
                        when (array[x][y]) {
                            1 -> imageView?.setImageResource(R.drawable.chip1)
                            2 -> imageView?.setImageResource(R.drawable.chip2)
                            3 -> imageView?.setImageResource(R.drawable.chip3)
                            4 -> imageView?.setImageResource(R.drawable.chip4)
                            else -> imageView?.setImageResource(R.drawable.ic_launcher_background)
                        }
                        val imageView1 = chipImageMatrix[currentX][currentY]
                        when (array[currentX][currentY]) {
                            1 -> imageView1?.setImageResource(R.drawable.chip1)
                            2 -> imageView1?.setImageResource(R.drawable.chip2)
                            3 -> imageView1?.setImageResource(R.drawable.chip3)
                            4 -> imageView1?.setImageResource(R.drawable.chip4)
                            else -> imageView?.setImageResource(R.drawable.ic_launcher_background)
                        }


                    }
                    else{
                        currentX=x
                        currentY=y
                    }
                    currentX = x
                    currentY = y
                    Toast.makeText(
                        this@MainActivity,
                        "Нажали на ImageView, $x, $y",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
    var currentX = 0
    var currentY = 0
}
