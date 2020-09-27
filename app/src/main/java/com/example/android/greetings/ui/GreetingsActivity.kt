package com.example.android.greetings.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.RadioButton
import com.example.android.greetings.R
import com.example.android.greetings.model.GreetingStore
import com.example.android.greetings.model.Language
import kotlinx.android.synthetic.main.activity_greetings.*


class GreetingsActivity : AppCompatActivity() {

  private lateinit var viewModel: GreetingsViewModel

//  private var greetingCount = 0
//  private var showFormal = true

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_greetings)

    viewModel = ViewModelProviders.of(this).get(GreetingsViewModel::class.java)

    configureSpinner()
    configureRadioGroup()

    showButton.setOnClickListener {
      viewModel.updateGreeting(languageSpinner.selectedItem as Language) {
        configureGreeting()
      }
      //greetingCount++
      configureGreeting()
    }

    configureGreeting()
  }

  private fun configureSpinner() {
    languageSpinner.adapter = ArrayAdapter<Language>(this, android.R.layout.simple_spinner_dropdown_item, viewModel.languages)
    //languageSpinner.adapter = ArrayAdapter<Language>(this, android.R.layout.simple_spinner_dropdown_item, GreetingStore.languages)
    languageSpinner.setSelection(2)
  }

  private fun configureRadioGroup() {
    radioGroup.setOnCheckedChangeListener { group, checkedId ->
      val checkedRadioButton = group.findViewById(checkedId) as RadioButton
      //showFormal = checkedRadioButton.text == getString(R.string.formal)
      viewModel.updateShowFormal(checkedRadioButton.text == getString(R.string.formal))
    }
  }
  
  private fun configureGreeting() {
    greeting.text = viewModel.greeting()
    count.text = viewModel.countText()
//    var language = languageSpinner.selectedItem as Language
//    greeting.text = if(showFormal) language.greeting.formal else language.greeting.informal
//    count.text = resources.getQuantityString(R.plurals.greetings,greetingCount,greetingCount)
  }
}
