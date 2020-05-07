package cubex.mahesh.sensorex_and8am2020

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sManager:SensorManager =
                getSystemService(Context.SENSOR_SERVICE) as SensorManager
        var s:Sensor = sManager.getDefaultSensor(
                Sensor.TYPE_PROXIMITY)
        var listener = object:SensorEventListener{
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }
            override fun onSensorChanged(event: SensorEvent?) {
                var svalues:FloatArray? = event?.values
                textView.setText("X Value : "+ svalues?.get(0)?.toString())
             //   textView2.setText("Y Value : "+ svalues?.get(1)?.toString())
            }
        }
        sManager.registerListener(listener,s,
                SensorManager.SENSOR_DELAY_FASTEST)
    }
}
