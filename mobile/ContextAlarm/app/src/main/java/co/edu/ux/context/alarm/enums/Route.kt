package co.edu.ux.context.alarm.enums

import androidx.annotation.StringRes
import co.edu.ux.context.alarm.R

enum class Route(@StringRes val title : Int) {
    Main(title = R.string.app_name)
    , Create(title = R.string.create_alarm)
}