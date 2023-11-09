package com.example.jokeesingleservingapp.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.jokeesingleservingapp.AppApplication
import com.example.jokeesingleservingapp.R
import com.example.jokeesingleservingapp.adapter.JokesAdapter
import com.example.jokeesingleservingapp.model.DataJokes


/**
 * ================================================
 * Created by HOQUANGTUNG on 2023
 * ================================================
 */
class MainActivity : ComponentActivity() {
    private lateinit var jokesAdapter: JokesAdapter
    private var lnButtonLike: LinearLayout? = null
    private var lnButtonDisLike: LinearLayout? = null
    private var lvContent: ListView? = null
    private var tvNotify: TextView? = null
    private var lnButton: LinearLayout? = null
    private val listJokes = ArrayList<DataJokes>()
    private var positionLike = 0
    private var positionDisLike = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
        mapping()
        jokesList()
        //onClickButtonLike
        lnButtonLike!!.setOnClickListener {
            buttonLike()
        }
        //onClickButtonDisLike
        lnButtonDisLike!!.setOnClickListener {
            buttonDisLike()
        }
    }

    private fun mapping() {
        lnButtonLike = findViewById(R.id.lnButtonLike)
        lnButtonDisLike = findViewById(R.id.lnButtonDisLike)
        lvContent = findViewById(R.id.lvNoiDung)
        tvNotify = findViewById(R.id.tvNotify)
        lnButton = findViewById(R.id.lnButton)
    }

    //Gan data
    private fun jokesList() {
        listJokes.add(
            DataJokes(
                "A child asked his father, \"How were people born?\" So his father said, \"Adam and Eve made babies, then their babies became adults and made babies, and so on.\"\n" + "\n" + "The child then went to his mother, asked her the same question and she told him, \"We were monkeys then we evolved to become like we are now.\"\n" + "\n" + "The child ran back to his father and said, \"You lied to me!\" His father replied, \"No, your mom was talking about her side of the family.\"\n" + "\n"
            )
        )
        listJokes.add(
            DataJokes(
                "Teacher: \"Kids,what does the chicken give you?\" Student: \"Meat!\" Teacher: \"Very good! Now what does the pig give you?\" Student: \"Bacon!\" Teacher: \"Great! And what does the fat cow give you?\" Student: \"Homework!\"\n" + "\n"
            )
        )
        listJokes.add(
            DataJokes(
                "The teacher asked Jimmy, \"Why is your cat at school today Jimmy?\" Jimmy replied crying, \"Because I heard my daddy tell my mommy, 'I am going to eat that pussy once Jimmy leaves for school today!'\""
            )
        )
        listJokes.add(
            DataJokes(
                "A housewife, an accountant and a lawyer were asked \"How much is 2+2?\" The housewife replies: \"Four!\". The accountant says: \"I think it's either 3 or 4. Let me run those figures through my spreadsheet one more time.\" The lawyer pulls the drapes, dims the lights and asks in a hushed voice, \"How much do you want it to be?\""
            )
        )
        jokesAdapter = JokesAdapter(this, listJokes)
        lvContent!!.adapter = jokesAdapter
    }

    //xu ly nut like
    private fun buttonLike() {
        if (listJokes.size > 1) {
            listJokes.removeAt(positionLike)
            jokesAdapter.notifyDataSetChanged()
            val dataJokes = DataJokes()
            dataJokes.jokesId = 1
            AppApplication.mDb?.jokesDao()?.insertJokes(dataJokes)
            // val item = AppApplication.mDb?.jokesDao()?.getAllTasks()
            Toast.makeText(this, getString(R.string.like), Toast.LENGTH_SHORT).show()
        } else {
            tvNotify!!.visibility = View.VISIBLE
            lnButton!!.visibility = View.GONE
            lvContent!!.visibility = View.GONE
            Toast.makeText(this, getString(R.string.no_content), Toast.LENGTH_SHORT).show()
        }

    }

    //xu ly nut dislike
    private fun buttonDisLike() {
        if (listJokes.size > 1) {
            listJokes.removeAt(positionDisLike)
            jokesAdapter.notifyDataSetChanged()
            val dataJokes = DataJokes()
            dataJokes.jokesId = 2
            AppApplication.mDb?.jokesDao()?.insertJokes(dataJokes)
            Toast.makeText(this, getString(R.string.dis_like), Toast.LENGTH_SHORT).show()
        } else {
            tvNotify!!.visibility = View.VISIBLE
            lnButton!!.visibility = View.GONE
            lvContent!!.visibility = View.GONE
            Toast.makeText(this, getString(R.string.no_content), Toast.LENGTH_SHORT).show()
        }
    }
}

