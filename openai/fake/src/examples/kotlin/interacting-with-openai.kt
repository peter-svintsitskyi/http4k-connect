import org.http4k.connect.openai.Content
import org.http4k.connect.openai.Http
import org.http4k.connect.openai.ModelName.Companion.GPT3_5
import org.http4k.connect.openai.OpenAI
import org.http4k.connect.openai.OpenAIToken
import org.http4k.connect.openai.Role.Companion.User
import org.http4k.connect.openai.action.Message
import org.http4k.connect.openai.chatCompletion

fun main() {
    val openAiToken = OpenAIToken.of(System.getenv("OPEN_AI_TOKEN"))

    // create a client
    val openai = OpenAI.Http(openAiToken)

    // get a chat completion
    println(
        openai.chatCompletion(
            GPT3_5,
            listOf(
                Message(User, Content.of("Explain pythagoras's theorem to a 5 year old child")),
            ),
            1000
        )
    )
}
