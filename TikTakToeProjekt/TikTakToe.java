package TikTakToeProjekt;







public class TikTakToe { 

    
    public static void main(String[] args) {
        System.out.println("");
        
        TikTakToeAnzeigen();

   

    }

    private static void TikTakToeAnzeigen(){

        String[][] array = {
            {"", "", ""},
            {"", "", ""},
            {"", "", ""}
        };

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("\"" + array[i][j] + "\" ");
            }
            System.out.println();
        }

    }
}
