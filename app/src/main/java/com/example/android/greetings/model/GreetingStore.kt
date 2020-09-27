
package com.example.android.greetings.model

import org.json.JSONObject


object GreetingStore {

  private const val languageData = "{\"languages\":[{\"name\": \"Arabic\", \"greeting\": {\"formal\": \"Asalaam alaikum\", \"informal\": \"Ahlan\"}},{\"name\": \"Chinese\", \"greeting\": {\"formal\": \"Nǐn hǎo\", \"informal\": \"Nǐ hǎo\"}},{\"name\": \"English\", \"greeting\": {\"formal\": \"Hello\", \"informal\": \"Hi\"}},{\"name\": \"French\", \"greeting\": {\"formal\": \"Bonjour\", \"informal\": \"Salut\"}},{\"name\": \"German\", \"greeting\": {\"formal\": \"Guten Tag\", \"informal\": \"Hallo\"}},{\"name\": \"Italian\", \"greeting\": {\"formal\": \"Salve\", \"informal\": \"Ciao\"}},{\"name\": \"Japanese\", \"greeting\": {\"formal\": \"Konnichiwa\", \"informal\": \"Yā, _Yō\"}},{\"name\": \"Korean\", \"greeting\": {\"formal\": \"Anyoung haseyo\", \"informal\": \"Anyoung\"}},{\"name\": \"Portuguese\", \"greeting\": {\"formal\": \"Olá\", \"informal\": \"Oi\"}},{\"name\": \"Russian\", \"greeting\": {\"formal\": \"Zdravstvuyte\", \"informal\": \"Privet\"}},{\"name\": \"Spanish\", \"greeting\": {\"formal\": \"Hola\", \"informal\": \"¿Qué tal?\"}}]}"

  val languages: List<Language> by lazy {
    val languages = mutableListOf<Language>()
    val languageArray = JSONObject(languageData).getJSONArray("languages")

    for (i in 0 until languageArray.length()) {
      val languageObject = languageArray[i] as JSONObject
      val greetingObject = languageObject.get("greeting") as JSONObject
      val language = Language(languageObject.getString("name"),
          Greeting(greetingObject.getString("formal"), greetingObject.getString("informal")))
      languages.add(language)
    }

    languages
  }

  val defaultLanguage = Language("English", Greeting("Hello", "Hi"))
}