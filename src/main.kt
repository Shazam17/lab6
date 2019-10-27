
class Candidate{
    var surname:String = readLine()?:"error"
    var initials:String = readLine()?:"error"
    var dateOfBirth:String = readLine()?:"error"
    var popularityIndex:String

    init{
        var variants = listOf<String>(
            "Поддержан президентом",
            "Поддержан опозиционной партией",
            "оппозиционный кандидат, который снимет свою кандидатуру в пользу кандидата № 1",
            "прочие")
        variants.forEach { print(it) }
        print("Выберите индекс популярности")
        var ind :String = readLine()?:"no"

        if(variants.indexOf(ind) != -1){
            popularityIndex = ind
        }else{
            popularityIndex = "no"
        }

    }
}

class App{
    private var candidatesList = ArrayList<Candidate>()


    fun add(canditate:Candidate){
        candidatesList.add(canditate)
    }

    fun remove(index:Int){
        candidatesList.removeAt(index)
    }

    fun printList(){
        candidatesList.forEach { print("Фамилия: ${it.surname} \n" +
                "Инициалы: ${it.initials} \n" +
                "Дата рождения: ${it.dateOfBirth} \n" +
                "Индекс популярности ${it.popularityIndex}") }
    }

}


fun main(){

}