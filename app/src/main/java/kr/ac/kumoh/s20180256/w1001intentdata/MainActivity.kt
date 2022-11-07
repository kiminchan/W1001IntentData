package kr.ac.kumoh.s20180256.w1001intentdata

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import kr.ac.kumoh.s20180256.w1001intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    View.OnClickListener{
        companion object {
            const val keyName = "image"
        }
        private lateinit var binding : ActivityMainBinding
        private lateinit var launcher: ActivityResultLauncher<Intent>

        override fun onClick(v: View?){
            val intent = Intent(this, ImageActivity::class.java)
            val value = when (v?.id){
                binding.btnGundam.id -> "gundam"
                binding.btnZaku.id -> "zaku"
                else -> return
            }
            intent.putExtra(keyName, value)
            launcher.launch(intent)
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGundam.setOnClickListener(this)
        binding.btnZaku.setOnClickListener(this)

        launcher = registerForActivityResult(
            ActvityResultContracts.Start
        )
    }
}