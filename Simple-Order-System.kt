import javax.swing.JOptionPane

fun main(args: Array<String>) {
    var isLoggedIn = false
    var username = ""
    val menuItems = mapOf("Coffee" to 2.99, "Tea" to 1.99, "Milk" to 3.49)
    val chartItems = mutableListOf<Pair<String, Double>>()

    while (!isLoggedIn) {
        val input = JOptionPane.showInputDialog("Enter username:") ?: return
        username = input

        val password = JOptionPane.showInputDialog("Enter password:") ?: return

        isLoggedIn = checkCredentials(username, password)
        if (!isLoggedIn) {
            JOptionPane.showMessageDialog(null, "Invalid credentials")
        }
    }

    var isRunning = true

    while (isRunning) {
        val choice = JOptionPane.showInputDialog("What do you want to order?\n1. Coffee (${menuItems["Coffee"]})\n2.Tea (${menuItems["Tea"]})\n3.Milk (${menuItems["Milk"]})\n4. Exit") ?: return

        when (choice) {
            "1" -> {
                chartItems.add(Pair("Coffee", menuItems["Coffee"]!!))
                JOptionPane.showMessageDialog(null, "You ordered Coffee")
            }
            "2" -> {
                chartItems.add(Pair("Tea", menuItems["Tea"]!!))
                JOptionPane.showMessageDialog(null, "You ordered Tea")
            }
            "3" -> {
                chartItems.add(Pair("Milk", menuItems["Milk"]!!))
                JOptionPane.showMessageDialog(null, "You ordered Milk")
            }
            "4" -> {
                isRunning = false
                JOptionPane.showMessageDialog(null, "Logged out")
            }
            else -> JOptionPane.showMessageDialog(null, "Invalid choice")
        }
    }

    if (chartItems.isNotEmpty()) {
        JOptionPane.showMessageDialog(null, "Items in the chart:\n${chartItems.joinToString("\n") { (item, price) -> "$item - $price" }}")
    }

    val totalOrderPrice = chartItems.sumOf { (_, price) -> price }
    JOptionPane.showMessageDialog(null, "Total order price: $totalOrderPrice")
}

fun checkCredentials(username: String, password: String): Boolean {
    return username == "admin" && password == "123"
}
