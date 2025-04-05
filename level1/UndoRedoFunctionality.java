class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
    }
}

class TextEditor {
    private TextState head;      
    private TextState tail;      
    private TextState current;   
    private int size = 0;
    private final int LIMIT = 10;

    public void addState(String newText) {
        TextState newState = new TextState(newText);

        if (current != tail && current != null) {
            current.next = null;
            tail = current;
        }

        if (tail != null) {
            tail.next = newState;
            newState.prev = tail;
        } else {
            head = newState;
        }

        tail = newState;
        current = newState;
        size++;

        // Remove oldest state if limit exceeded
        if (size > LIMIT) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("New state added.");
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo available.");
        }
    }
	
	public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: \"" + current.content + "\"");
        } else {
            System.out.println("Editor is empty.");
        }
    }

    public void displayAllStates() {
        System.out.println("\nAll States in History:");
        TextState temp = head;
        while (temp != null) {
            if (temp == current) {
                System.out.println("-> (Current) \"" + temp.content + "\"");
            } else {
                System.out.println("   \"" + temp.content + "\"");
            }
            temp = temp.next;
        }
    }
}

public class UndoRedoFunctionality {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState(); 

        editor.undo();
        editor.displayCurrentState(); 
        editor.undo();
        editor.displayCurrentState(); 

        editor.redo();
        editor.displayCurrentState(); 

        editor.addState("Hello Again");
        editor.displayCurrentState(); 
        
        editor.displayAllStates(); 
    }
}
