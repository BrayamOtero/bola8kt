//Declarando valores de las respuestas
const val AFFIRMATIVE_ANSWER = "✅"
const val NEGATIVE_ANSWER = "❌"
const val DOUBTFUL_ANSWER = "?"

//uniendo las respuestas con sus valores
val answers = mapOf(
    "Yes" to AFFIRMATIVE_ANSWER,
    "It's true" to AFFIRMATIVE_ANSWER,
    "Totally" to AFFIRMATIVE_ANSWER,
    "Undoubtedly" to AFFIRMATIVE_ANSWER,
    "Ask in an other moment" to DOUBTFUL_ANSWER,
    "I can't say you in this moment" to DOUBTFUL_ANSWER,
    "Maybe yes, or maybe not" to DOUBTFUL_ANSWER,
    "It's not going to happen" to NEGATIVE_ANSWER,
    "Do not count on it" to NEGATIVE_ANSWER,
    "Definitely not" to NEGATIVE_ANSWER,
    "I don't believe it" to NEGATIVE_ANSWER
)


fun main(args: Array<String>) {
    //Declarando el menu principal
    println("Hello, I'm the Kotlin 8 Ball. What do you want to do?\n" +
            "1. Ask a question\n" +
            "2. Check all answers\n" +
            "3. Exit")
    //leyendo la respuesta del usuario

    //funciones a executar segun la respuesta del usuario
    when(readLine()){
        "1"->askQuestion()
        "2"->checkAnswer()
        "3"->exit()
        else->showError()
    }
}

fun askQuestion(){
    println("What do you wish to ask?")
    readLine()
    println("So that was you question.. The answer is: ")
    val answerGenerate = answers.keys.random()
    println(answerGenerate)
}
fun checkAnswer(){
    println("Select a choose")
    println("1. Check all answer.")
    println("2. Check only affirmative answers.")
    println("3. Check only doubtful answers.")
    println("4. Check only negative answers.")

    val enteredChoose = readLine()

    when(enteredChoose) {
        "1" -> showAnswerByType()
        "2" -> showAnswerByType(answerType =  AFFIRMATIVE_ANSWER)
        "3" -> showAnswerByType(answerType = DOUBTFUL_ANSWER)
        "4" -> showAnswerByType(answerType = NEGATIVE_ANSWER)
    else    -> println("Invalidate answer. Good Bye.")
    }
}

fun showAnswerByType(answerType : String = "ALL"){
    val printAnswer : (Map<String, String>) -> Unit = {
        println(it.keys)
    }
    when(answerType){
        "ALL" -> answers.keys.forEach{answer -> println(answer)}
        AFFIRMATIVE_ANSWER -> answers.filterValues { values -> values == AFFIRMATIVE_ANSWER }
            .also { printAnswer(it) }
        NEGATIVE_ANSWER -> answers.filterValues { values -> values == NEGATIVE_ANSWER }
            .also { printAnswer(it) }
        DOUBTFUL_ANSWER -> answers.filterValues { values -> values == DOUBTFUL_ANSWER }
            .also { printAnswer(it) }
    }
}
fun exit(){
    println("Good Bye")
}
fun showError(){
    println("Oops it seems you have chosen an invalidate option.")
}