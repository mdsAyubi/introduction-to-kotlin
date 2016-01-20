package swing.demo

import kool.swing.*
import java.awt.Dimension
import javax.swing.*

val greeting = "Hello,\n\nEnter some text here!"

fun main(args : Array<String>) {
    JFrame("Demo") {
        size = Dimension(400, 400)

        val text = JTextArea(greeting)
        center = text

        south = JPanel {
            west = JButton("Clear") {
                text.text = ""
            }

            east = JButton("Restore") {
                text.text = greeting
            }
        }
    }.show()
}