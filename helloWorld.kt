import javax.swing.JOptionPane

fun main(args: Array<String>) {
    var isLoggedIn = false
    var username = ""

    while (!isLoggedIn) {
        val input = JOptionPane.showInputDialog("Enter username:")
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Exiting")
            return
        }
        username = input

        val password = JOptionPane.showInputDialog("Enter password:")
        if (password == null) {
            JOptionPane.showMessageDialog(null, "Exiting")
            return
        }

        if (checkCredentials(username, password)) {
            isLoggedIn = true
            JOptionPane.showMessageDialog(null, "Logged in as $username")
        } else {
            JOptionPane.showMessageDialog(null, "Invalid credentials")
        }
    }

    val menuItems = listOf("Coffee" to 2.99, "Tea" to 1.99, "Milk" to 3.49)
    val chartItems = mutableListOf<String>()

    var isRunning = true

    while (isRunning) {
        val choice = JOptionPane.showInputDialog("What do you want to order?\n1. Coffee (${menuItems[0].second})\n2.Tea (${menuItems[1].second})\n3.Milk (${menuItems[2].second})\n4. Exit")
        if (choice == null) {
            JOptionPane.showMessageDialog(null, "Exiting")
            return
        }

        when (choice) {
            "1" -> {
                chartItems.add("Coffee")
                JOptionPane.showMessageDialog(null, "You ordered Coffee")
            }
            "2" -> {
                chartItems.add("Tea")
                JOptionPane.showMessageDialog(null, "You ordered Tea")
            }
            "3" -> {
                chartItems.add("Milk")
                JOptionPane.showMessageDialog(null, "You ordered Milk")
            }
            "4" -> {
                JOptionPane.showMessageDialog(null, "Logged out")
                isRunning = false
            }
            else -> JOptionPane.showMessageDialog(null, "Invalid choice")
        }
    }

    if (chartItems.isNotEmpty()) {
        JOptionPane.showMessageDialog(null, "Items in the chart:\n${chartItems.joinToString("\n")}")
    }
}

fun checkCredentials(username: String, password: String): Boolean {
    return username == "admin" && password == "123"
}



