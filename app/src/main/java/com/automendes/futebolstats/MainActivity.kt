package com.automendes.futebolstats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var clubs : List<Club> = arrayListOf(
        Club("FC Porto", 82),
        Club("Sporting Clube de Portugal", 76),
        Club("SL Benfica", 68),
        Club("SC Braga", 59),
        Club("Gil Vicente", 48),
        Club("Vitoria SC", 43),
        Club("Marítimo", 37),
        Club("Paços de Ferreira", 37),
        Club("Santa Clara", 36),
        Club("Estoril", 36),
        Club("Portimonense", 35),
        Club("Boavista", 33),
        Club("Vizela", 32),
        Club("Famalicão", 30),
        Club("Arouca", 27),
        Club("Moreirense", 26),
        Club("Tondela", 26),
        Club("B SAD", 25)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewClubs = findViewById<ListView>(R.id.listViewClubs)
        val clubsAdapter = ClubsAdapter()
        listViewClubs.adapter = clubsAdapter
    }

    inner class ClubsAdapter: BaseAdapter() {
        override fun getCount(): Int {
            return clubs.size
        }

        override fun getItem(position: Int): Any {
            return clubs[position]
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            val rootView = layoutInflater.inflate(R.layout.row_content, viewGroup, false)
            val textViewClubName = rootView.findViewById<TextView>(R.id.textViewClubName)
            val textViewClubPoints = rootView.findViewById<TextView>(R.id.textViewClubPoints)

            // preencher views
            textViewClubName.text = clubs[position].name
            textViewClubPoints.text = clubs[position].points.toString()


            rootView.setOnClickListener {
                val intent = Intent(this@MainActivity, ClubDetailActivity:: class.java)
                intent.putExtra(ClubDetailActivity.CLUB_NAME, clubs[position].name)
                intent.putExtra(ClubDetailActivity.CLUB_POINTS, clubs[position].points.toString())
                startActivity(intent)
            }


            return rootView
        }

    }
}