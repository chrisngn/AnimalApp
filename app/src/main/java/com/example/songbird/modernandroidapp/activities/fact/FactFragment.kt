package com.example.songbird.modernandroidapp.activities.fact

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.songbird.modernandroidapp.R
import com.example.songbird.modernandroidapp.models.CatFact
import com.example.songbird.modernandroidapp.models.CatFactResponse
import com.example.songbird.modernandroidapp.restservices.CatClient
import kotlinx.android.synthetic.main.fragment_fact.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class FactFragment : Fragment() {

    companion object {
        private const val MIN = 0
        @JvmStatic
        fun newInstance() = FactFragment()
    }

    private var facts: List<CatFact> = mutableListOf<CatFact>()
    private var position: Int = MIN

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        loadFacts()
    }

    private fun loadFacts() {
        CatClient.instance().getFacts().enqueue(object : Callback<CatFactResponse> {
            override fun onResponse(call: Call<CatFactResponse>, response: Response<CatFactResponse>) {
                if (response.isSuccessful) {
                    response.body()?.facts?.apply {
                        facts = this
                    }
                    updateTextView(facts[position].text)
                    println("CatFact: 🦄: " + facts.size)
                }
            }

            override fun onFailure(call: Call<CatFactResponse>, t: Throwable) {
                println("CatFact: 🦄: " + t.message)
            }

        })
    }

    private fun updateTextView(fact: String) {
        textView.text = fact
    }

    private fun setupUI() {
        prevButton.setOnClickListener {
            if (position == MIN) {
                position = facts.size
            }
            position--
            updateTextView(facts[position].text)
        }
        nextButton.setOnClickListener {
            if (position == facts.size - 1) {
                position = MIN - 1
            }
            position++
            updateTextView(facts[position].text)
        }
        randomButton.setOnClickListener {
            if (facts.size > 1) {
                var randomIndex = position
                while (randomIndex == position) {
                    randomIndex = getRandomNumber()
                }
                position = randomIndex
                updateTextView(facts[position].text)
            }
        }
    }

    private fun getRandomNumber(): Int {
        val rand = Random()
        return rand.nextInt(facts.size)
    }

}
