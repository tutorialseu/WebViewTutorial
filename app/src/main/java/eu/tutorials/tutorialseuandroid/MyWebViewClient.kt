package eu.tutorials.tutorialseuandroid

import android.net.Uri
import android.webkit.WebView
import android.webkit.WebViewClient

val url:String = "https://tutorials.eu"

class MyWebViewClient: WebViewClient() {


     override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
         view?.loadUrl(url!!)
         if (Uri.parse(url).host == url) {
             // This is my web site, so do not override; let my WebView load the page
             return false
         }
         return true
     }

}