import java.util.PriorityQueue
class Candidate() : Comparable<Candidate>{
    var surname:String = read("enter surname")
    var initials:String = read("enter initials")
    var dateOfBirth:String = read("enter dateOfBirth")
    var popularityIndex:Int
    var variants = listOf<String>(
        "Поддержан президентом",
        "Поддержан опозиционной партией",
        "оппозиционный кандидат, который снимет свою кандидатуру в пользу кандидата № 1",
        "прочие")

    private fun read(promptString: String):String{
        println(promptString)
        return readLine()?:"error"
    }

    init{

        variants.forEachIndexed {index ,it  -> print("$index - $it \n") }
        print("Выберите индекс популярности")
        var ind :Int = readLine()?.toInt()?:-1

        if(ind > -1 && ind < variants.size){
            popularityIndex = ind
        }else{
            popularityIndex = -1
        }
    }

    override fun compareTo(b: Candidate): Int = when{
        popularityIndex < b.popularityIndex -> -1
        popularityIndex > b.popularityIndex -> 1
        else -> 0
        }


}

class App{
    private var candidatesList = PriorityQueue<Candidate>()


    fun add(){
        candidatesList.add(Candidate())
    }

    fun remove(){
        candidatesList.poll()
    }

    fun printCandidates(){
        var iterator = candidatesList.iterator()
        while(iterator.hasNext()){
            var it = iterator.next()
            print("Фамилия: ${it.surname} \n" +
                    "Инициалы: ${it.initials} \n" +
                    "Дата рождения: ${it.dateOfBirth} \n" +
                    "Индекс популярности ${it.popularityIndex} \n")
        }
    }

}


fun main(){

    var isWorking = true

    var app = App()
    var ways = listOf("1 - add new","2 - print All" , "3 - remove top")

    while(isWorking){
        ways.forEach { print("$it \n") }
        var input = readLine()?.toInt()?:0
        when(input){
            0 -> print("incorect input \n")
            1 -> app.add()
            2 -> app.printCandidates()
            3 -> app.remove()
        }
    }
}