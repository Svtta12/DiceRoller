package science.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        }
        // Делаем бросок при запуске приложения
        rollDice()
    }
    /**
     * Бросьте кости и обновите экран с результатом.
     */
    private fun rollDice() {
        // Создаем новый объект Dice с 6 гранями и бросаем его
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //Обновите экран с помощью броска костей
        //val resultTextView: TextView = findViewById(R.id.textView)
        //resultTextView.text = diceRoll.toString()

        // Находим ImageView в макете
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Определяем, какой ID доступного для рисования ресурса использовать на основе броска кубиков
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Обновляем ImageView с правильным идентификатором ресурса для рисования
        diceImage.setImageResource(drawableResource)

        // Обновить описание содержимого
        diceImage.contentDescription = diceRoll.toString()
        }
    }

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}