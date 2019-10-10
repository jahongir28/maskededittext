package kg.stark.maskededittext

import android.util.Log


/**Created by Jahongir on 9/18/2019.*/

private object MaskHelper {
    fun setText(text: CharSequence?, mask: String?, pattern: String?): CharSequence? {
        val maskHolder = mask?.let { it } ?: return text
        val textHolder = text?.let { it } ?: return text
        val patternHolder = pattern?.let { it } ?: return text
        try {
            val phoneReg = Regex(patternHolder)
            if (textHolder.matches(phoneReg)) {
                val maskFixed = maskHolder.replace("[^0-9]".toRegex(), "")
                return textHolder.replace("^((\\+)|(0))".toRegex(), "")
                    .replace(maskFixed, "")
            }
        } catch (ex: Exception) {
            Log.e("MaskHelper", "setText Exception:", ex)
        }
        return text
    }
}