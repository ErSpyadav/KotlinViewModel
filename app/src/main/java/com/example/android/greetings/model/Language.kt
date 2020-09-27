

package com.example.android.greetings.model


data class Language(val name: String, val greeting: Greeting) {
  override fun toString() = name
}