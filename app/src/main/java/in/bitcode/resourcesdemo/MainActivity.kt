package `in`.bitcode.resourcesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //resources
        var companyName = resources.getString(R.string.companyname)
        log(companyName)
        var code = resources.getInteger(R.integer.code)
        log(code.toString())
        var bgColor = resources.getColor(R.color.bgcolor)
        var isPassword = resources.getBoolean(R.bool.ispassword)
        var width = resources.getDimension(R.dimen.width)

        var cityNames = resources.getStringArray(R.array.cities)
        var codes = resources.getIntArray(R.array.citycodes)
        var drawable = resources.getDrawable(R.drawable.ic_launcher_background)

        for(city in cityNames) {
            log(city)
        }
    }

    private fun log(text : String) {
        Log.e("tag", text)
    }
}