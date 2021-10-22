package eu.tutorials.tutorialseuandroid

import android.os.Bundle
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import eu.tutorials.tutorialseuandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Todo 3 : create a binding variable and inflate the layout
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    //Todo 5: create a webview variable
    private var webView:WebView? = null
    //Todo 6: create a url String and assign the website url to it
    private val url:String = "https://tutorials.eu"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Todo 4: attach the layout to this activity
        setContentView(binding.root)

        //Todo 7: Reference the webview id from the layout, load the url and set webview client to
       // the android in built client, we also enable javascript for older versions of android
        webView = binding.webview
        webView?.loadUrl(url)
        webView?.webViewClient = WebViewClient()
        webView?.settings?.javaScriptEnabled = true
    }

    /**Todo 9: override onKeyDown to ensure the app doesnt exit if there are previous
     * pages when back button is pressed
    *
    * */

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        //Since the webview is nullable we make sure it has been initialized be using it
        if (webView != null) {
            if (keyCode == KeyEvent.KEYCODE_BACK && webView!!.canGoBack()) {
                webView?.goBack()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }

}