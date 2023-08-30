import scalafx.application.JFXApp3
import scalafx.Includes._
import scalafx.scene.Scene
import scalafx.application.JFXApp
import scalafx.scene.control._
import scalafx.scene.layout.GridPane
import scalafx.scene.layout.Priority
import scalafx.event.ActionEvent
import scala.util.control.Breaks
object `GUI-Calculator` extends  JFXApp3 {
  override def start(): Unit = {
    stage = new JFXApp3.PrimaryStage{
        title = "Calculadora"
              scene = new Scene(300,300){
        val gridPane = new GridPane
        for(i <-1 to 9){
          val button = new Button(i.toString)
          gridPane.children += button
          GridPane.setColumnIndex(button,(i-1)%3)
          GridPane.setRowIndex(button,(i-1)/3+1)
          GridPane.setHgrow(button,Priority.Always)
          GridPane.setVgrow(button,Priority.Always)
          button.maxWidth = Int.MaxValue
          button.maxHeight = Int.MaxValue
          button.onAction = (event: ActionEvent)=>{
            textField.appendText(s"${i.toString()}")
          }
        }
        val textField = new TextField
        gridPane.children += textField
        GridPane.setConstraints(textField, 0, 0, 4, 1)
        val zeroButton = new Button("0") 
        gridPane.children += zeroButton
        GridPane.setConstraints(zeroButton,0,4,2,1)
        GridPane.setVgrow(zeroButton,Priority.Always)
        zeroButton.maxWidth = Int.MaxValue
        zeroButton.maxHeight = Int.MaxValue
        zeroButton.onAction = (event: ActionEvent) => {
            textField.appendText("0")
        }
        val periodButton = new Button(".")
        gridPane.children += periodButton
        GridPane.setConstraints(periodButton, 2, 4)
        GridPane.setVgrow(periodButton, Priority.Always)
        periodButton.maxWidth = Int.MaxValue
        periodButton.maxHeight = Int.MaxValue
        periodButton.onAction = (event: ActionEvent) => {
            textField.appendText(".")
        }
        val plusButton = new Button("+")
        gridPane.children += plusButton
        GridPane.setConstraints(plusButton, 3, 1)
        GridPane.setHgrow(plusButton, Priority.Always)
        plusButton.maxWidth = Int.MaxValue
        plusButton.maxHeight = Int.MaxValue
        plusButton.onAction = (event: ActionEvent) =>{
            textField.appendText("+")
        }
        val minusButton = new Button("-")
        gridPane.children += minusButton
        GridPane.setConstraints(minusButton, 3, 2)
        minusButton.maxWidth = Int.MaxValue
        minusButton.maxHeight = Int.MaxValue
        minusButton.onAction = (event: ActionEvent)=>{
            textField.appendText("-")
        }
        val multButton = new Button("*")
        gridPane.children += multButton
        GridPane.setConstraints(multButton, 3, 3)
        multButton.maxWidth = Int.MaxValue
        multButton.maxHeight = Int.MaxValue
        multButton.onAction = (event: ActionEvent)=>{
            textField.appendText("*")
        }
        val divButton = new Button("/")
        gridPane.children += divButton
        GridPane.setConstraints(divButton, 3, 4)
        divButton.maxWidth = Int.MaxValue
        divButton.maxHeight = Int.MaxValue
        divButton.onAction = (event: ActionEvent)=>{
            textField.appendText("/")
        }
        val equalButton = new Button("=")
        gridPane.children+=equalButton
        GridPane.setConstraints(equalButton,4,0,2,5)
        equalButton.maxWidth = Int.MaxValue
        equalButton.maxHeight = Int.MaxValue
        
        equalButton.onAction = (event: ActionEvent)=>{
            var operation = textField.getText()
            val operator = List("+","-","*","/")
            println(operator)
            val loop = new Breaks
            var error: Int = -1
            var result_ : Array[String] = Array.empty[String]
            var last_index : Int = 0
            var op: String = ""
            loop.breakable{
                for(i <- operation){
                    if(operator.contains(i.toString())){
                        op = i.toString()
                        result_ = operation.split(i)
                        last_index = result_.length
                        error = 0
                        loop.break()
                    }
                }
            }
            if(error!=0){
                textField.setText("Erro")
            }
            
            val num1 = result_(0).toFloat
            val num2 = result_(1).toFloat
            val result = op match{
                case "+" => num1 + num2
                case "-" => num1 - num2
                case "*" => num1 * num2
                case "/" => num1 / num2
            }
            var format = "%.2f".format(result)
            format = format.replace(",", ".")
            textField.setText(s"$format")
        }
        
        root = gridPane
        
      }


    }
  }
}
 