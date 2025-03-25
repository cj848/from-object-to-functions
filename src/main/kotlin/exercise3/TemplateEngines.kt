package exercise3

data class StringTag(val text: String)

infix fun String.tag(value: String): Pair<String, StringTag> = this to StringTag(value)
fun renderTemplate(template: String, data: Map<String, StringTag>): String {

    return data.entries.fold(template) { temp, (key, tag) ->
        temp.replace("{$key}", tag.text)
    }
}

