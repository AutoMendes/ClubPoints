package com.automendes.futebolstats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

class ClubDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_club_detail)

        val name = intent.getStringExtra(CLUB_NAME)
        val points = intent.getStringExtra(CLUB_POINTS)

        val textViewName = findViewById<TextView>(R.id.textViewClubName)
        val textViewPoints = findViewById<TextView>(R.id.textViewClubPoints)
        val buttonShare = findViewById<Button>(R.id.buttonShare)

        textViewName.text = name
        textViewPoints.text = points

        buttonShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, CLUB_NAME)
                putExtra(Intent.EXTRA_TITLE, CLUB_POINTS)
                type = "text/plain"
            }
            startActivity(Intent.createChooser(sendIntent, "Share to.."))
        }
    }

    companion object {
        const val CLUB_NAME = "club_name"
        const val CLUB_POINTS = "club_points"
    }
}