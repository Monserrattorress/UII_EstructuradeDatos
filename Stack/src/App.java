public class App {
    public static void main(String[] args) {
        String texto1 = "Anita lava la tina";
        String texto2 = "Hola";

        System.out.println(texto1 + " -> " + isPalindrome(texto1));
        System.out.println(texto2 + " -> " + isPalindrome(texto2));
    }

    public static boolean isPalindrome(String text) {
        ArrayStack<Character> stack = new ArrayStack<>();

        String clean = text.replaceAll("[^a-zA-Z]", "").toLowerCase();

        for (int i = 0; i < clean.length(); i++) {
            stack.push(clean.charAt(i));
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return clean.equals(reversed.toString());
    }
}
