package io.github.latticetower

import android.app.Activity
import android.os.Bundle

class MainActivity extends Activity with TypedFindView {

  override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)
    findView(TR.textview).setText(R.string.hello_world)
  }

}
