package exercise3

data class StringTag(val text: String)

infix fun String.tag(value: String): Pair<String, StringTag> = this to StringTag(value)
fun renderTemplate(template: String, data: Map<String, StringTag>): String? {
    return renderTemplate(template, data, StringBuilder(), 0)
}

tailrec fun renderTemplate(template: String, data: Map<String, StringTag>, str: StringBuilder, index: Int): String? {
    if (index == template.length) {
        return str.toString()
    } else {
        if (template[index] == '{') {
            val endIndex = template.indexOf('}', index+1).takeIf { it != -1 } ?: return null
            val tag = template.substring(index + 1, endIndex).trim()
            str.append(data[tag]?.text ?: return null)
            return renderTemplate(template, data, str, endIndex + 1)
        } else {
            str.append(template[index])
            return renderTemplate(template, data, str, index + 1)
        }
    }
}