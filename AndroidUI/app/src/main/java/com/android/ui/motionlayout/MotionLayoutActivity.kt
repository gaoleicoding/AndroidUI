package com.android.ui.motionlayout

import android.animation.ObjectAnimator
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.view.View
import android.view.Window.FEATURE_NO_TITLE
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.java.mylibrary.ChatTransActivity
import com.java.mylibrary.CustomPopWindow
import com.java.mylibrary.FloatWindow
import com.java.mylibrary.InfoDialog
import kotlinx.android.synthetic.main.activity_part.*


class MotionLayoutActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(com.android.ui.R.layout.activity_part)
        val animator = ObjectAnimator.ofFloat(bt_right, "rotation", 0f, 3600f)
        animator.duration = 50000
        animator.start()
    }


    fun showUp(view: View) {
        Toast.makeText(this, "上", Toast.LENGTH_SHORT).show()
    }

    fun showDown(view: View) {
        Toast.makeText(this, "下", Toast.LENGTH_SHORT).show()
    }

    fun showLeft(view: View) {
        Toast.makeText(this, "左", Toast.LENGTH_SHORT).show()
    }

    fun showRight(view: View) {
        Toast.makeText(this, "右", Toast.LENGTH_SHORT).show()
    }

    fun openChat(view: View) {

//        showWindow()
//        showCustomPopup()
        showChatTransActivity()
    }
    fun showChatTransActivity() {
        startActivity(Intent(this, ChatTransActivity::class.java))
    }

    fun showCustomPopup() {
        val list = arrayOf("国家", "联盟", "其它")
        val mBottomSelectorPopDialog =
            CustomPopWindow(this, list, object : View.OnClickListener {
                override fun onClick(v: View?) {
                    when (v!!.getId()) {
                        com.android.ui.R.id.tv_one ->
                            Toast.makeText(this@MotionLayoutActivity, "国家", Toast.LENGTH_SHORT).show()
                        com.android.ui.R.id.tv_two ->
                            Toast.makeText(this@MotionLayoutActivity, "联盟", Toast.LENGTH_SHORT).show()
                        com.android.ui.R.id.tv_three ->
                            Toast.makeText(this@MotionLayoutActivity, "其它", Toast.LENGTH_SHORT).show()

                    }
                }

            })
        mBottomSelectorPopDialog.showAtLocation(
            findViewById(com.android.ui.R.id.container),
            Gravity.LEFT,
            0,
            0
        )
    }

    fun showCustomDialog() {
        val infoDialog: InfoDialog = InfoDialog.Builder(this).create()
        infoDialog.show()
    }

    fun showWindow() {

        if (Build.VERSION.SDK_INT >= 23) { // Android6.0及以后需要动态申请权限
            if (!Settings.canDrawOverlays(this)) {
                //启动Activity让用户授权
                val intent = Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName())
                )
                startActivityForResult(intent, 1010);
            } else {
                // 弹出悬浮窗
                FloatWindow.getInstance().showWindow(this);
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1010) {
            if (Build.VERSION.SDK_INT >= 23) { // Android6.0及以后需要动态申请权限
                if (Settings.canDrawOverlays(this)) {
                    // 弹出悬浮窗
                    FloatWindow.getInstance().showWindow(this);
                } else {
                    Toast.makeText(this, "not granted permission!", Toast.LENGTH_SHORT);
                }
            }
        }

    }
}
