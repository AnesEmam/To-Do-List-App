public class ToDoListApp {
    
    static class Task {
        private String title;
        private String description;
        private boolean completed;

        public Task(String title, String description) {
            this.title = title;
            this.description = description;
            this.completed = false;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void markCompleted() {
            this.completed = true;
        }
    }

    static class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    static class ToDoList {
        private Node head;

        public ToDoList() {
            this.head = null;
        }

        public void addToDo(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        public void markToDoAsCompleted(String title) {
            Node current = head;
            while (current != null) {
                if (current.task.getTitle().equalsIgnoreCase(title)) {
                    current.task.markCompleted();
                    return;
                }
                current = current.next;
            }
            System.out.println("Task with title \"" + title + "\" not found.");
        }

        public void viewToDoList() {
            Node current = head;
            while (current != null) {
                System.out.println("Title: " + current.task.getTitle());
                System.out.println("Description: " + current.task.getDescription());
                System.out.println("Completed: " + current.task.isCompleted());
                System.out.println();
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        ToDoList myToDoList = new ToDoList();

        myToDoList.addToDo(new Task("Buy groceries", "Milk, Bread, Butter"));
        myToDoList.addToDo(new Task("Study", "Prepare for the math exam"));
        myToDoList.addToDo(new Task("Exercise", "30 minutes of cardio"));
        System.out.println("To-Do List:");
        myToDoList.viewToDoList();
        myToDoList.markToDoAsCompleted("Study");
        System.out.println("To-Do List after marking 'Study' as completed:");
        myToDoList.viewToDoList();
    }
}
