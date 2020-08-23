package android.werner.mysandbox.models

data class MainListObject(val id: String, val title: String) {
    constructor(id: String): this(id, id)
}