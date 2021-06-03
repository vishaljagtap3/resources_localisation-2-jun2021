package `in`.bitcode.resourcesdemo

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var btnSetInfo : Button
    lateinit var edtInfo : EditText
    lateinit var txtInfo : TextView

    var strings = ArrayList<String>()

    data class MyData(var str : CharSequence?, var strings: ArrayList<String>)

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSetInfo = findViewById(R.id.btnSetInfo)
        edtInfo = findViewById(R.id.edtInfo)
        txtInfo = findViewById(R.id.txtInfo)

        btnSetInfo.setOnClickListener(
            View.OnClickListener {
                txtInfo.text = edtInfo.text
                strings.add(edtInfo.text.toString())

                for (str in strings) {
                    log(str)
                }
                log("-------------------")
            }
        )

        //get the backed up object
        var data : Any? = lastCustomNonConfigurationInstance
        if(data != null) {
            log("Got the data back...")
            //txtInfo.text = data as CharSequence?
            txtInfo.text = (data as MyData).str
            this.strings = (data as MyData).strings
        }

        /*
        var config : Configuration = resources.configuration
        log("locale: " + config.locale.displayName)
        log("Colormode: ${config.colorMode}")
        log("kb: ${config.keyboard}" )
        log("dpi: ${config.densityDpi}")
        log("${config.mcc} - ${config.mnc} ")
        log( "touch screen: ${config.touchscreen}")
*/

        //resources
        /*var companyName = resources.getString(R.string.companyname)
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
        }*/
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        log("onConfiguarationChanged");
    }


    override fun onRetainCustomNonConfigurationInstance(): Any? {
        log("onRetainCustomNonConfigurationInstance")
        //return txtInfo.text
        return MyData(txtInfo.text, strings)
    }

    private fun log(text : String) {
        Log.e("tag", text)
    }
}