class ConsoleManager {
    public static void printText(String text) {
        for (int index = 0; index < text.length(); index++) {
            if (Character.compare(text.charAt(index), ',')==0 || Character.compare(text.charAt(index), '.')==0) {
                System.out.print(text.charAt(index));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.print(text.charAt(index));
            }
        }
        System.out.println();
    }

    public static void printSpeech(String character, String[] text) {
        System.out.print(character+": ");
        for (int rl = 0; rl < text.length; rl++) {
            for (int index = 0; index < text[rl].length(); index++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.print(text[rl].charAt(index));
            }
            System.out.println();
            for (int i = 0; i<character.length()+2; i++) {
                System.out.print(" ");
            }
            try {
                Thread.sleep(text[rl].length()*50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}