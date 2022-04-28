package com.automendes.futebolstats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class ClubDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_club_detail)

        val name = intent.getStringExtra(CLUB_NAME)
        val points = intent.getStringExtra(CLUB_POINTS)

        val textViewName = findViewById<TextView>(R.id.textViewClubName)
        val textViewPoints = findViewById<TextView>(R.id.textViewClubPoints)
        val buttonShare = findViewById<Button>(R.id.buttonShare)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)

        textViewName.text = name
        textViewPoints.text = points

        buttonShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                val string = name.plus(" ").plus(points.toString()).plus(" pontos")
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, string)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(sendIntent, "Share to.."))
        }
            checkBox.setOnClickListener {
                if (checkBox.isChecked) {
                    Toast.makeText( this@ClubDetailActivity, "Adicionado aos favoritos", Toast.LENGTH_SHORT).show()
                }
            }

    }

    companion object {
        const val CLUB_NAME = "club_name"
        const val CLUB_POINTS = "club_points"
        const val CLUB_FAV = "club_fav"
    }
}