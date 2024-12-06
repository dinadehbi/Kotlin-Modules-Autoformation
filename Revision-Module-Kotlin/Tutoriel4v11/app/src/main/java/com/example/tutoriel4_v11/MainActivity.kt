fun main() {
    // 1. Instructions conditionnelles
    val age = 18
    val status = if (age >= 18) "Adulte" else "Mineur"
    println(status)

    val grade = 85
    val result = when {
        grade >= 90 -> "Excellent"
        grade >= 75 -> "Bien"
        grade >= 50 -> "Passable"
        else -> "Insuffisant"
    }
    println(result)

    // 2. Nullabilité
    var name: String? = null
    println(name?.length) // Safe-call
    name = "Solicode"
    println(name?.length ?: 0) // Opérateur Elvis

    // 3. Classes et Objets
    // a) Constructeurs
    class Person(val name: String, val age: Int) {
        init {
            println("Création d'une personne : $name, $age ans")
        }

        constructor(name: String) : this(name, 0) {
            println("Création d'une personne avec un âge inconnu.")
        }
    }
    val person1 = Person("Alice", 25)
    val person2 = Person("Bob")

    // b) Propriétés et accesseurs
    class Circle(val radius: Double) {
        val area: Double
            get() = Math.PI * radius * radius
    }
    val circle = Circle(5.0)
    println("Aire du cercle : ${circle.area}")

    // c) Méthodes
    class Calculator {
        fun add(a: Int, b: Int): Int = a + b
        fun subtract(a: Int, b: Int): Int = a - b
    }
    val calculator = Calculator()
    println("Addition : ${calculator.add(5, 3)}")
    println("Soustraction : ${calculator.subtract(5, 3)}")

    // 4. Expressions Lambdas
    val multiply: (Int, Int) -> Int = { a, b -> a * b }
    println(multiply(4, 5))

    val numbers = listOf(1, 2, 3, 4, 5)
    val doubled = numbers.map { it * 2 }
    println(doubled)

    val evenNumbers = numbers.filter { it % 2 == 0 }
    println(evenNumbers)

    // Exercice pratique : Classe Task
    class Task(val id: Int, val title: String, var isCompleted: Boolean = false) {
        fun markAsCompleted() {
            isCompleted = true
        }

        override fun toString(): String {
            return "Task(id=$id, title='$title', isCompleted=$isCompleted)"
        }
    }
    val task = Task(1, "Apprendre Kotlin")
    println(task)
    task.markAsCompleted()
    println(task)
}
