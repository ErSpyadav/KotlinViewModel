
package com.example.android.greetings.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.example.android.greetings.R
import com.example.android.greetings.model.GreetingStore
import com.example.android.greetings.model.Language


class GreetingsViewModel(application: Application) : AndroidViewModel(application) {
  var greetingCount = 0
    private set

  var showFormal = true
    private set

  var language = GreetingStore.defaultLanguage
    private set

  val languages: List<Language> by lazy {
    GreetingStore.languages
  }

  fun updateGreeting(language: Language, callback: () -> Unit) {
    this.language = language
    greetingCount++
    callback()
  }

  fun updateShowFormal(showFormal: Boolean) {
    this.showFormal = showFormal
  }

  fun greeting() = if (showFormal) language.greeting.formal else language.greeting.informal

  fun countText(): String {
    return getApplication<Application>().resources.getQuantityString(R.plurals.greetings, greetingCount, greetingCount)
  }
}